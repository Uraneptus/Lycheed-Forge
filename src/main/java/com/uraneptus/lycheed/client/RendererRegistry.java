package com.uraneptus.lycheed.client;

import com.uraneptus.lycheed.LycheedMod;
import com.uraneptus.lycheed.client.entities.ModBoatRenderer;
import com.uraneptus.lycheed.core.registry.ModBlocks;
import com.uraneptus.lycheed.core.registry.ModEntities;
import com.uraneptus.lycheed.core.registry.ModTileEntityTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.tileentity.SignTileEntityRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = LycheedMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RendererRegistry {

    @SubscribeEvent
    public static void bindTERenderers(FMLClientSetupEvent event) {
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.MOD_SIGN.get(), SignTileEntityRenderer::new);
    }

    @SubscribeEvent
    public static void registerEntityRenderer(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.CHINENSIS_BOAT.get(), ModBoatRenderer::new);
    }

    @SubscribeEvent
    public static void setBlockRenderTypes(FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(ModBlocks.CHINENSIS_BRANCH.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.CHINENSIS_LADDER.get(), RenderType.cutout());
    }
}
