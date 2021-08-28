package com.uraneptus.lycheed.common.blocks;

import com.uraneptus.lycheed.common.entities.tile.ModBeehiveTileEntity;
import com.uraneptus.lycheed.common.entities.tile.ModSignTileEntity;
import net.minecraft.block.BeehiveBlock;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class ModBeehiveBlock extends BeehiveBlock {

    public ModBeehiveBlock(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader blockReader) {
        return new ModBeehiveTileEntity();
    }
}
