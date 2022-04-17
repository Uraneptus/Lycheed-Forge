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
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class ModBranchBlock extends Block implements BonemealableBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;

    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Shapes.box(0.25, 0.5, 0.25, 0.75, 1.0625, 0.75), //Age 0
            Shapes.box(0.1875, 0.25, 0.1875, 0.8125, 1.0625, 0.8125), //Age 1
            Shapes.box(0.125, 0, 0.125, 0.875, 1.0625, 0.875),  //Age 2
            Shapes.box(0.125, 0, 0.125, 0.875, 1.0625, 0.875),  //Age 3
    };

    public ModBranchBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, Integer.valueOf(0)));
    }

    protected ItemLike getBaseSeedId() {
        return ModItems.LYCHEE.get();
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
        return true;
    }

    @NotNull
    @Override
    public VoxelShape getOcclusionShape(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return SHAPE_BY_AGE[state.getValue(AGE)];
    }

    @NotNull
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter p_220053_2_, BlockPos p_220053_3_, CollisionContext p_220053_4_) {
        return SHAPE_BY_AGE[state.getValue(AGE)];
    }

    public int getMaxAge() {
        return 3;
    }

    protected int getAge(BlockState state) {
        return state.getValue(AGE);
    }

    public BlockState getStateForAge(int age) {
        return this.defaultBlockState().setValue(AGE, Integer.valueOf(age));
    }

    public boolean isMaxAge(BlockState state) {
        return state.getValue(AGE) >= this.getMaxAge();
    }

    public boolean isRandomlyTicking(BlockState state) {
        return !this.isMaxAge(state);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
        if (!world.isAreaLoaded(pos, 1)) return;
        int i = this.getAge(state);
        if (i < this.getMaxAge() && world.getRawBrightness(pos, 0) >= 9) {
            //float f = getGrowthSpeed(this, world, pos);
            if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(world, pos, state, random.nextInt(5) == 0)) {
                world.setBlock(pos, this.getStateForAge(i + 1), 2);
                net.minecraftforge.common.ForgeHooks.onCropsGrowPost(world, pos, state);
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

    @Override
    public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
        if (worldIn.getBlockState(pos.above()).is(ModTags.BlockTags.CAN_PLACE_LYCHEE))
            return true;
        return false;
    }

    @Override
    @NotNull
    public ItemStack getCloneItemStack(BlockGetter p_185473_1_, BlockPos p_185473_2_, BlockState p_185473_3_) {
        return new ItemStack(getBaseSeedId());
    }

    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        int i = state.getValue(AGE);
        boolean flag = i == 3;
        if (!flag && player.getItemInHand(hand).is(Items.BONE_MEAL)) {
            return InteractionResult.PASS;
        } else if (i > 1) {
            int j = 1 + world.random.nextInt(2);
            popResource(world, pos, new ItemStack(getBaseSeedId(), j + (flag ? 1 : 0)));
            world.playSound((Player)null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() * 0.4F);
            world.setBlock(pos, state.setValue(AGE, 1), 2);
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
