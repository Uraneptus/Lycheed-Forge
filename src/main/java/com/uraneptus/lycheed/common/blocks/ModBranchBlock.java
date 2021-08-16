package com.uraneptus.lycheed.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class ModBranchBlock extends Block implements IGrowable{
    public static final IntegerProperty AGE = BlockStateProperties.AGE_5;

    private static final VoxelShape[] AGE_SHAPE = new VoxelShape[]{
            Block.box(16, 16, 16, 16, 16, 16), //Age 0
            Block.box(16, 16, 16, 16, 16, 16), //Age 1
            Block.box(16, 16, 16, 16, 16, 16), //Age 2
            Block.box(16, 16, 16, 16, 16, 16), //Age 3
            Block.box(16, 16, 16, 16, 16, 16), //Age 4
            Block.box(16, 16, 16, 16, 16, 16)  //Age 5
    };

    public ModBranchBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isValidBonemealTarget(IBlockReader iBlockReader, BlockPos blockPos, BlockState blockState, boolean b) {
        return false;
    }

    @Override
    public boolean isBonemealSuccess(World world, Random random, BlockPos blockPos, BlockState blockState) {
        return false;
    }

    @Override
    public void performBonemeal(ServerWorld serverWorld, Random random, BlockPos blockPos, BlockState blockState) {

    }
}
