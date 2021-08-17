package com.uraneptus.lycheed.common.blocks;

import com.uraneptus.lycheed.core.registry.ModItems;
import net.minecraft.block.*;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.Tags;

import java.util.Random;
import java.util.function.Predicate;

public class ModBranchBlock extends Block implements IGrowable {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_5;

    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(10.0D, 16.0D, 10.0D, 6.0D, 13.0D, 6.0D), //Age 0
            Block.box(10.0D, 16.0D, 10.0D, 6.0D, 11.0D, 6.0D), //Age 1
            Block.box(11.0D, 16.0D, 11.0D, 4.0D, 9.5D, 4.0D),  //Age 2
            Block.box(12.0D, 16.0D, 12.0D, 4.0D, 6.0D, 4.0D),  //Age 3
            Block.box(12.0D, 16.0D, 12.0D, 4.0D, 4.0D, 4.0D),  //Age 4
            Block.box(12.0D, 16.0D, 12.0D, 4.0D, 3.0D, 4.0D),  //Age 5
    };

    public ModBranchBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(this.getAgeProperty(), Integer.valueOf(0)));
    }

    @Override
    public void neighborChanged(BlockState state, World world, BlockPos blockPos, Block block, BlockPos fromBlockPos, boolean isMoving) {
        BlockState stateUp = world.getBlockState(blockPos.above());
        if(!stateUp.is(BlockTags.LEAVES)) {
            world.destroyBlock(blockPos, true);
        }
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
        return true;
    }

    @Override
    public VoxelShape getOcclusionShape(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return SHAPE_BY_AGE[state.getValue(this.getAgeProperty())];
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
        return SHAPE_BY_AGE[state.getValue(this.getAgeProperty())];
    }

    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    public int getMaxAge() {
        return 5;
    }

    protected int getAge(BlockState state) {
        return state.getValue(this.getAgeProperty());
    }

    public BlockState getStateForAge(int age) {
        return this.defaultBlockState().setValue(this.getAgeProperty(), Integer.valueOf(age));
    }

    public boolean isMaxAge(BlockState state) {
        return state.getValue(this.getAgeProperty()) >= this.getMaxAge();
    }

    public boolean isRandomlyTicking(BlockState state) {
        return !this.isMaxAge(state);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!world.isAreaLoaded(pos, 1)) return;
        if (world.getRawBrightness(pos, 0) >= 9) {
            int i = this.getAge(state);
            if (i < this.getMaxAge()) {
                float f = getGrowthSpeed(this, world, pos);
                if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(world, pos, state, random.nextInt((int)(25.0F / f) + 1) == 0)) {
                    world.setBlock(pos, this.getStateForAge(i + 1), 2);
                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(world, pos, state);
                }
            }
        }

    }

    public void growCrops(World world, BlockPos pos, BlockState state) {
        int i = this.getAge(state) + this.getBonemealAgeIncrease(world);
        int j = this.getMaxAge();
        if (i > j) {
            i = j;
        }

        world.setBlock(pos, this.getStateForAge(i), 2);
    }

    protected int getBonemealAgeIncrease(World world) {
        return MathHelper.nextInt(world.random, 0, 3);
    }

    protected static float getGrowthSpeed(Block blockIn, IBlockReader worldIn, BlockPos pos) {
        float f = 2.0F;
        BlockPos blockpos = pos;
        BlockState air = Blocks.AIR.defaultBlockState();
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                float f1 = 0.0F;
                BlockState iblockstate = worldIn.getBlockState(blockpos.offset(i, 0, j));
                if (iblockstate.getBlock().defaultBlockState() == air) f1 = 2.0F;
                if (i != 0 || j != 0) f1 /= 2.0F;
                f += f1;
            }
        }

        BlockPos blockposN = pos.north();
        BlockPos blockposS = pos.south();
        BlockPos blockposW = pos.west();
        BlockPos blockposE = pos.east();
        boolean flag = !isLeavesOrAir(worldIn, blockposN) || !isLeavesOrAir(worldIn, blockposS);
        boolean flag1 = !isLeavesOrAir(worldIn, blockposE) || !isLeavesOrAir(worldIn, blockposW);

        if (flag && flag1) {
            f /= 2.0F;
        } else {
            boolean flag2 = !isLeavesOrAir(worldIn, blockposW.north()) || !isLeavesOrAir(worldIn, blockposE.north()) || !isLeavesOrAir(worldIn, blockposN.south()) || !isLeavesOrAir(worldIn, blockposW.south());
            if (flag2) {
                f /= 2.0F;
            }
        }
        return f;
    }

    @SuppressWarnings("deprecation")
    private static boolean isLeavesOrAir(IBlockReader worldIn, BlockPos pos) {
        return worldIn.getBlockState(pos).isAir(worldIn, pos) || worldIn.getBlockState(pos).is(BlockTags.LEAVES);
    }

    @Override
    public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
        if (worldIn.getBlockState(pos.above()).getBlock().is(BlockTags.LEAVES))
            return true;
        return false;
    }

    protected IItemProvider getBaseSeedId() {
        return ModItems.LYCHEE.get();
    }

    @Override
    public ItemStack getCloneItemStack(IBlockReader p_185473_1_, BlockPos p_185473_2_, BlockState p_185473_3_) {
        return new ItemStack(this.getBaseSeedId());
    }

    @Override
    public boolean isValidBonemealTarget(IBlockReader iBlockReader, BlockPos blockPos, BlockState blockState, boolean b) {
        return !this.isMaxAge(blockState);
    }

    @Override
    public boolean isBonemealSuccess(World world, Random random, BlockPos blockPos, BlockState blockState) {
        return true;
    }

    @Override
    public void performBonemeal(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        this.growCrops(worldIn, pos, state);
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

}
