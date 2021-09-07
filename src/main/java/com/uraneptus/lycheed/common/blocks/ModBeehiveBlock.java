package com.uraneptus.lycheed.common.blocks;

import com.uraneptus.lycheed.LycheedMod;
import com.uraneptus.lycheed.common.entities.tile.ModBeehiveTileEntity;
import com.uraneptus.lycheed.common.entities.tile.ModSignTileEntity;
import com.uraneptus.lycheed.core.registry.ModBlocks;
import net.minecraft.block.BeehiveBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.village.PointOfInterestType;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.HashSet;

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

    @SubscribeEvent
    public static void registerPOI(RegistryEvent.Register<PointOfInterestType> event) {
        ResourceLocation beePOILocation = new ResourceLocation("minecraft:bee_nest");
        PointOfInterestType beePOI = ForgeRegistries.POI_TYPES.getValue(beePOILocation);
        HashSet<BlockState> newSet = new HashSet<>(beePOI.getBlockStates());
        newSet.add(ModBlocks.CHINENSIS_BEEHIVE.get().defaultBlockState());
        PointOfInterestType newBeePOIToRegister = new PointOfInterestType("bee_nest", newSet, beePOI.getValidRange(), beePOI.getMaxTickets());
        event.getRegistry().register(newBeePOIToRegister);
    }

}
