package com.uraneptus.lycheed.common.blocks;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import java.util.function.Supplier;

public class ModWoodPostBlock extends Block implements IWaterLoggable {
    private static final VoxelShape SHAPE_X = Block.box(0F, 6F, 6F, 16F, 10F, 10F);
    private static final VoxelShape SHAPE_Y = Block.box(6F, 0F, 6F, 10F, 16F, 10F);
    private static final VoxelShape SHAPE_Z = Block.box(6F, 6F, 0F, 10F, 10F, 16F);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;
    private final Supplier<Block> block;

    public static final BooleanProperty[] CHAINED = new BooleanProperty[] {
            BooleanProperty.create("chain_down"),
            BooleanProperty.create("chain_up"),
            BooleanProperty.create("chain_north"),
            BooleanProperty.create("chain_south"),
            BooleanProperty.create("chain_west"),
            BooleanProperty.create("chain_east")
    };


    public ModWoodPostBlock(Properties properties) {
        this((Supplier) null, properties);
    }

    public ModWoodPostBlock(Supplier<Block> stripped, Properties properties) {
        super(properties);
        this.block = stripped;
        BlockState state = stateDefinition.any().setValue(WATERLOGGED, false).setValue(AXIS, Direction.Axis.Y);
        for(BooleanProperty prop : CHAINED)
            state = state.setValue(prop, false);
        registerDefaultState(state);
    }


    public BlockState getToolModifiedState(BlockState state, World world, BlockPos pos, PlayerEntity player, ItemStack stack, ToolType toolType) {
        if (toolType == ToolType.AXE) {
            return this.block != null ? block.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS)) : null;
        } else {
            return super.getToolModifiedState(state, world, pos, player, stack, toolType);
        }
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch(state.getValue(AXIS)) {
            case X: return SHAPE_X;
            case Y: return SHAPE_Y;
            default: return SHAPE_Z;
        }
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
        return !state.getValue(WATERLOGGED);
    }

    @Override
    @SuppressWarnings("deprecation")
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return getState(context.getLevel(), context.getClickedPos(), context.getClickedFace().getAxis());
    }

    @Override
    @SuppressWarnings("deprecation")
    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        super.neighborChanged(state, worldIn, pos, blockIn, fromPos, isMoving);

        BlockState newState = getState(worldIn, pos, state.getValue(AXIS));
        if(!newState.equals(state))
            worldIn.setBlockAndUpdate(pos, newState);
    }

    private BlockState getState(World world, BlockPos pos, Direction.Axis axis) {
        BlockState state = defaultBlockState().setValue(WATERLOGGED, world.getFluidState(pos).getType() == Fluids.WATER).setValue(AXIS, axis);

        for(Direction d : Direction.values()) {
            if(d.getAxis() == axis)
                continue;

            BlockState sideState = world.getBlockState(pos.relative(d));
            if((sideState.getBlock() instanceof ChainBlock && sideState.getValue(BlockStateProperties.AXIS) == d.getAxis())
                    || (d == Direction.DOWN && sideState.getBlock() instanceof LanternBlock && sideState.getValue(LanternBlock.HANGING))) {
                BooleanProperty prop = CHAINED[d.ordinal()];
                state = state.setValue(prop, true);
            }
        }

        return state;
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, AXIS);
        for(BooleanProperty prop : CHAINED)
            builder.add(prop);
    }


}
