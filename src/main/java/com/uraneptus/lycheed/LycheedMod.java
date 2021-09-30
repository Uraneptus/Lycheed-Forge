package com.uraneptus.lycheed;

import com.minecraftabnormals.abnormals_core.core.util.registry.RegistryHelper;
import com.uraneptus.lycheed.core.registry.*;
import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(LycheedMod.MOD_ID)
@Mod.EventBusSubscriber(modid = LycheedMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LycheedMod {
    public static final String MOD_ID = "lycheed";
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, LycheedMod.MOD_ID);
    public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MOD_ID);

    public LycheedMod() {
        IEventBus event_bus = FMLJavaModLoadingContext.get().getModEventBus();
        event_bus.addListener(this::setup);

        REGISTRY_HELPER.register(event_bus);
        BLOCKS.register(event_bus);
        ModTileEntityTypes.TILE_ENTITIES.register(event_bus);
        ModEntities.ENTITY_TYPE.register(event_bus);
        ModParticleType.PARTICLES.register(event_bus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }
}