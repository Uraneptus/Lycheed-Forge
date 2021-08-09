package com.uraneptus.lycheed.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import java.util.function.Supplier;

public class ModLogBlock extends RotatedPillarBlock {
    private final Supplier<Block> block;

    public ModLogBlock(Supplier<Block> stripped, Properties properties) {
        super(properties);
        this.block = stripped;
    }

    @Override
    public BlockState getToolModifiedState(BlockState state, World world, BlockPos pos, PlayerEntity player, ItemStack stack, ToolType toolType)
    {
        return block.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
    }
}
