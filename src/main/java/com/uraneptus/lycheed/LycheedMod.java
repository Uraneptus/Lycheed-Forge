package com.uraneptus.lycheed;

import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import com.uraneptus.lycheed.core.data.client.BlockStates;
import com.uraneptus.lycheed.core.data.client.ItemModels;
import com.uraneptus.lycheed.core.data.client.LangGenerator;
import com.uraneptus.lycheed.core.registry.ModFeatures;
import com.uraneptus.lycheed.core.registry.ModParticleType;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import org.slf4j.Logger;

@Mod(LycheedMod.MOD_ID)
@Mod.EventBusSubscriber(modid = LycheedMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LycheedMod {
    public static final String MOD_ID = "lycheed";
    public static final String BLUEPRINT_MOD_ID = "blueprint";
    public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MOD_ID);

    public LycheedMod() {
        IEventBus event_bus = FMLJavaModLoadingContext.get().getModEventBus();
        event_bus.addListener(this::setup);

        REGISTRY_HELPER.register(event_bus);
        ModFeatures.FEATURES.register(event_bus);
        ModParticleType.PARTICLES.register(event_bus);

        event_bus.addListener(this::gatherData);
        MinecraftForge.EVENT_BUS.addListener(ModFeatures.Placement::onBiomeLoad);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    @SubscribeEvent
    public void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        if (event.includeClient()) {
            generator.addProvider(new BlockStates(generator, fileHelper));
            generator.addProvider(new ItemModels(generator, fileHelper));
            generator.addProvider(new LangGenerator(generator));
        }
        if (event.includeServer()) {

        }
    }
}