package com.uraneptus.lycheed.common.entities.tile;

import com.uraneptus.lycheed.core.registry.ModTileEntityTypes;
import net.minecraft.tileentity.BeehiveTileEntity;
import net.minecraft.tileentity.TileEntityType;

public class ModBeehiveTileEntity extends BeehiveTileEntity {

    @Override
    public TileEntityType<?> getType() {
        return ModTileEntityTypes.MOD_BEEHIVE.get();
    }
}
