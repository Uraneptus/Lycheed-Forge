package com.uraneptus.lycheed.client;

import com.uraneptus.lycheed.LycheedMod;
import com.uraneptus.lycheed.core.registry.ModTileEntityTypes;
import net.minecraft.client.renderer.tileentity.SignTileEntityRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = LycheedMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BindRenderers {

    @SubscribeEvent
    public static void bindTERenderers(FMLClientSetupEvent event) {
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.MOD_SIGN.get(), SignTileEntityRenderer::new);
    }
}
