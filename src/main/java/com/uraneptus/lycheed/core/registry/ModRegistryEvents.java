package com.uraneptus.lycheed.core.registry;

import com.uraneptus.lycheed.LycheedMod;
import net.minecraft.block.BlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashSet;

@Mod.EventBusSubscriber(modid = LycheedMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModRegistryEvents {

    @SubscribeEvent
    public static void registerPOI(RegistryEvent.Register<PointOfInterestType> event) {
        ResourceLocation beePOILocation = new ResourceLocation("minecraft:bee_nest");
        PointOfInterestType beePOI = ForgeRegistries.POI_TYPES.getValue(beePOILocation);
        HashSet<BlockState> newSet = new HashSet<>();
        newSet.add(ModBlocks.CHINENSIS_BEEHIVE.get().defaultBlockState());
        //PointOfInterestType newBeePOIToRegister = new PointOfInterestType("mod_beehive", newSet, beePOI.getValidRange(), beePOI.getMaxTickets());
        event.getRegistry().register(new PointOfInterestType("bee_nest", newSet, beePOI.getValidRange(), beePOI.getMaxTickets()));
    }
}
