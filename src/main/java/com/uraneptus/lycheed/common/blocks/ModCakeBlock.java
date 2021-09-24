package com.uraneptus.lycheed.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.Property;
import net.minecraft.state.StateContainer;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class ModCakeBlock extends Block {
    public static final IntegerProperty BITES = IntegerProperty.create("lychee_cake_bites", 0, 4);
    protected static final VoxelShape[] SHAPE_BY_BITE = new VoxelShape[]{
            Block.box(3.0D, 0.0D, 3.0D, 13.0D, 5.0D, 13.0D),
            Block.box(5.0D, 0.0D, 3.0D, 13.0D, 5.0D, 13.0D),
            Block.box(7.0D, 0.0D, 3.0D, 13.0D, 5.0D, 13.0D),
            Block.box(9.0D, 0.0D, 3.0D, 13.0D, 5.0D, 13.0D),
            Block.box(11.0D, 0.0D, 3.0D, 13.0D, 5.0D, 13.0D)};

    public ModCakeBlock(Properties properties) {
        super(properties);
        this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(BITES, 0));
    }

    public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context) {
        return SHAPE_BY_BITE[(Integer)state.getValue(BITES)];
    }

    public ActionResultType use(BlockState state, World world, BlockPos blockPos, PlayerEntity player, Hand hand, BlockRayTraceResult result) {
        if (world.isClientSide) {
            ItemStack lvt_7_1_ = player.getItemInHand(hand);
            if (this.eat(world, blockPos, state, player).consumesAction()) {
                return ActionResultType.SUCCESS;
            }

            if (lvt_7_1_.isEmpty()) {
                return ActionResultType.CONSUME;
            }
        }

        return this.eat(world, blockPos, state, player);
    }

    public ActionResultType eat(IWorld world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!player.canEat(false)) {
            return ActionResultType.PASS;
        } else {
            player.awardStat(Stats.EAT_CAKE_SLICE);
            player.getFoodData().eat(2, 0.1F);
            int lvt_5_1_ = (Integer)state.getValue(BITES);
            if (lvt_5_1_ < 4) {
                world.setBlock(pos, (BlockState)state.setValue(BITES, lvt_5_1_ + 1), 3);
            } else {
                world.removeBlock(pos, false);
            }

            return ActionResultType.SUCCESS;
        }
    }

    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld world, BlockPos currentPos, BlockPos facingPos) {
        return facing == Direction.DOWN && !state.canSurvive(world, currentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, facing, facingState, world, currentPos, facingPos);
    }

    public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
        return worldIn.getBlockState(pos.below()).getMaterial().isSolid();
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{BITES});
    }

    public int getAnalogOutputSignal(BlockState blockState, World worldIn, BlockPos pos) {
        return (5 - (Integer)blockState.getValue(BITES)) * 2;
    }

    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    public boolean isPathfindable(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        return false;
    }
}
