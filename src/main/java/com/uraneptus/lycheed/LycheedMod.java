package com.uraneptus.lycheed;

import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import com.uraneptus.lycheed.core.data.BlockStates;
import com.uraneptus.lycheed.core.data.ItemModels;
import com.uraneptus.lycheed.core.data.LangGenerator;
import com.uraneptus.lycheed.core.registry.ModFeatures;
import com.uraneptus.lycheed.core.registry.ModParticleType;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(LycheedMod.MOD_ID)
@Mod.EventBusSubscriber(modid = LycheedMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LycheedMod {
    public static final String MOD_ID = "lycheed";
    public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MOD_ID);

    public LycheedMod() {
        IEventBus event_bus = FMLJavaModLoadingContext.get().getModEventBus();
        event_bus.addListener(this::setup);

        REGISTRY_HELPER.register(event_bus);
        ModParticleType.PARTICLES.register(event_bus);
        //ModFeatures.FEATURES.register(event_bus);
        event_bus.addListener(this::gatherData);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        //event.enqueueWork(ModFeatures::regFeatures);
    }

    @SubscribeEvent
    public void gatherData(GatherDataEvent event) {
        event.getGenerator().addProvider(new BlockStates(event.getGenerator(), event.getExistingFileHelper()));
        event.getGenerator().addProvider(new ItemModels(event.getGenerator(), event.getExistingFileHelper()));
        event.getGenerator().addProvider(new LangGenerator(event.getGenerator()));
    }
}