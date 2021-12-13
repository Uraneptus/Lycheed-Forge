package com.uraneptus.lycheed.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ModCakeBlock extends Block {//TODO: Rewrite this
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

    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_BITE[(Integer)state.getValue(BITES)];
    }

    public InteractionResult use(BlockState state, Level world, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult result) {
        if (world.isClientSide) {
            ItemStack lvt_7_1_ = player.getItemInHand(hand);
            if (this.eat(world, blockPos, state, player).consumesAction()) {
                return InteractionResult.SUCCESS;
            }

            if (lvt_7_1_.isEmpty()) {
                return InteractionResult.CONSUME;
            }
        }

        return this.eat(world, blockPos, state, player);
    }

    public InteractionResult eat(LevelAccessor world, BlockPos pos, BlockState state, Player player) {
        if (!player.canEat(false)) {
            return InteractionResult.PASS;
        } else {
            player.awardStat(Stats.EAT_CAKE_SLICE);
            player.getFoodData().eat(2, 0.1F);
            int lvt_5_1_ = (Integer)state.getValue(BITES);
            if (lvt_5_1_ < 4) {
                world.setBlock(pos, (BlockState)state.setValue(BITES, lvt_5_1_ + 1), 3);
            } else {
                world.removeBlock(pos, false);
            }

            return InteractionResult.SUCCESS;
        }
    }

    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
        return facing == Direction.DOWN && !state.canSurvive(world, currentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, facing, facingState, world, currentPos, facingPos);
    }

    public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
        return worldIn.getBlockState(pos.below()).getMaterial().isSolid();
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{BITES});
    }

    public int getAnalogOutputSignal(BlockState blockState, Level worldIn, BlockPos pos) {
        return (5 - (Integer)blockState.getValue(BITES)) * 2;
    }

    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    public boolean isPathfindable(BlockState state, BlockGetter worldIn, BlockPos pos, PathComputationType type) {
        return false;
    }
}
