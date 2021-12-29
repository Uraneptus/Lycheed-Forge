package com.uraneptus.lycheed.common.blocks;

import com.uraneptus.lycheed.core.other.ModTags;
import com.uraneptus.lycheed.core.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

//TODO: Since I changed the stages, here are probably some wrong values
//TODO: Rewrite this
public class ModBranchBlock extends Block implements BonemealableBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;

    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(6.0D, 13.0D, 6.0D, 10.0D, 16.0D, 10.0D), //Age 0
            Block.box(6.0D, 11.0D, 6.0D, 10.0D, 16.0D, 10.0D), //Age 1
            Block.box(4.0D, 9.5D, 4.0D, 11.0D, 16.0D, 11.0D),  //Age 2
            Block.box(4.0D, 6.0D, 4.0D, 12.0D, 16.0D, 12.0D),  //Age 3
    };

    public ModBranchBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(this.getAgeProperty(), Integer.valueOf(0)));
    }

    @Override
    public void neighborChanged(BlockState state, Level world, BlockPos blockPos, Block block, BlockPos fromBlockPos, boolean isMoving) {
        BlockState stateUp = world.getBlockState(blockPos.above());
        if(!stateUp.is(BlockTags.LEAVES)) {
            world.destroyBlock(blockPos, true);
        }
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
        return true;
    }

    @Override
    public VoxelShape getOcclusionShape(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return SHAPE_BY_AGE[state.getValue(this.getAgeProperty())];
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter p_220053_2_, BlockPos p_220053_3_, CollisionContext p_220053_4_) {
        return SHAPE_BY_AGE[state.getValue(this.getAgeProperty())];
    }

    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    public int getMaxAge() {
        return 3;
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
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
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

    public void growCrops(Level world, BlockPos pos, BlockState state) {
        int i = this.getAge(state) + this.getBonemealAgeIncrease(world);
        int j = this.getMaxAge();
        if (i > j) {
            i = j;
        }

        world.setBlock(pos, this.getStateForAge(i), 2);
    }

    protected int getBonemealAgeIncrease(Level world) {
        return Mth.nextInt(world.random, 0, 2);
    }

    protected static float getGrowthSpeed(Block blockIn, BlockGetter worldIn, BlockPos pos) {
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
    private static boolean isLeavesOrAir(BlockGetter worldIn, BlockPos pos) { //TODO: This makes two lychees placed next to each other break under a non leaves block
        return worldIn.getBlockState(pos).isAir() || worldIn.getBlockState(pos).is(BlockTags.LEAVES);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
        if (worldIn.getBlockState(pos.above()).is(ModTags.BlockTags.CAN_PLACE_LYCHEE))
            return true;
        return false;
    }

    protected ItemLike getBaseSeedId() {
        return ModItems.LYCHEE.get();
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter p_185473_1_, BlockPos p_185473_2_, BlockState p_185473_3_) {
        return new ItemStack(this.getBaseSeedId());
    }

    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        int i = state.getValue(AGE);
        boolean flag = i == 3;
        if (!flag && player.getItemInHand(hand).getItem() == Items.BONE_MEAL) {
            return InteractionResult.PASS;
        } else if (i == 3) {
            int j = 1 + world.random.nextInt(2);
            popResource(world, pos, new ItemStack(ModItems.LYCHEE.get(), j + (flag ? 1 : 0)));
            world.playSound((Player)null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() * 0.4F);
            world.setBlock(pos, state.setValue(AGE, Integer.valueOf(2)), 3);
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else {
            return super.use(state, world, pos, player, hand, result);
        }
    }

    @Override
    public boolean isValidBonemealTarget(BlockGetter iBlockReader, BlockPos blockPos, BlockState blockState, boolean b) {
        return !this.isMaxAge(blockState);
    }

    @Override
    public boolean isBonemealSuccess(Level world, Random random, BlockPos blockPos, BlockState blockState) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel worldIn, Random rand, BlockPos pos, BlockState state) {
        this.growCrops(worldIn, pos, state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

}
