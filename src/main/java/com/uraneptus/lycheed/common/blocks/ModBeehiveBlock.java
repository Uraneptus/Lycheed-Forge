package com.uraneptus.lycheed.common.blocks;

import com.uraneptus.lycheed.LycheedMod;
import com.uraneptus.lycheed.common.entities.tile.ModBeehiveTileEntity;
import net.minecraft.block.BeehiveBlock;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber(modid = LycheedMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
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
