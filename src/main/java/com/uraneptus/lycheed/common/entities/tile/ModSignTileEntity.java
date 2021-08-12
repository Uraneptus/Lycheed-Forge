package com.uraneptus.lycheed.common.entities.tile;

import com.uraneptus.lycheed.core.registry.ModTileEntityTypes;
import net.minecraft.tileentity.SignTileEntity;
import net.minecraft.tileentity.TileEntityType;

public class ModSignTileEntity extends SignTileEntity {

    @Override
    public TileEntityType<?> getType() {
        return ModTileEntityTypes.MOD_SIGN.get();
    }
}
