package com.uraneptus.lycheed.client;

import com.uraneptus.lycheed.LycheedMod;
import com.uraneptus.lycheed.client.particles.LycheeLeavesParticle;
import com.uraneptus.lycheed.core.registry.ModBlocks;
import com.uraneptus.lycheed.core.registry.ModParticleType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = LycheedMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RendererRegistry {

    @SubscribeEvent
    public static void registerParticleFactory(ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particleEngine.register(ModParticleType.LYCHEE_LEAVES_PARTICLE.get(), LycheeLeavesParticle.Factory::new);
    }

    @SubscribeEvent
    public static void setBlockRenderTypes(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.LYCHEE_BRANCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.LYCHEE_LADDER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.LYCHEE_LEAVES_CARPET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.FRUITFUL_LYCHEE_LEAVES_CARPET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.LYCHEE_HEDGE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.LYCHEE_SAPLING.get(), RenderType.cutout());
    }

    @SubscribeEvent
    public static void bindTERenderers(EntityRenderersEvent.RegisterRenderers event) {

    }

    @SubscribeEvent
    public static void registerEntityRenderer(FMLClientSetupEvent event) {

    }
}
