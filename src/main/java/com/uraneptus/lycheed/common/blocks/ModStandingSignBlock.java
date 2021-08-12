package com.uraneptus.lycheed.common.blocks;

import com.uraneptus.lycheed.common.entities.tile.ModSignTileEntity;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.StandingSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class ModStandingSignBlock extends StandingSignBlock {

    public ModStandingSignBlock(AbstractBlock.Properties properties, WoodType type) {
        super(properties, type);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader blockReader) {
        return new ModSignTileEntity();
    }
}
