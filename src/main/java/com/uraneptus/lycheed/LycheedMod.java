package com.uraneptus.lycheed;

import com.uraneptus.lycheed.common.blocks.ModBeehiveBlock;
import com.uraneptus.lycheed.core.registry.ModBlocks;
import com.uraneptus.lycheed.core.registry.ModEntities;
import com.uraneptus.lycheed.core.registry.ModItems;
import com.uraneptus.lycheed.core.registry.ModTileEntityTypes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(LycheedMod.MOD_ID)
@Mod.EventBusSubscriber(modid = LycheedMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LycheedMod
{
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "lycheed";

    public LycheedMod() {
        IEventBus event_bus = FMLJavaModLoadingContext.get().getModEventBus();
        event_bus.addListener(this::setup);

        ModItems.ITEMS.register(event_bus);
        ModBlocks.BLOCKS.register(event_bus);
        ModTileEntityTypes.TILE_ENTITIES.register(event_bus);
        ModEntities.ENTITY_TYPE.register(event_bus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

}
