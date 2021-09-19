package com.uraneptus.lycheed;

import com.google.common.collect.Sets;
import com.uraneptus.lycheed.common.blocks.ModBeehiveBlock;
import com.uraneptus.lycheed.core.registry.*;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Stream;

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
        ModParticleType.PARTICLES.register(event_bus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(this::createNewBeehivePOI);
    }

    private void createNewBeehivePOI() {
        PointOfInterestType.BEEHIVE.matchingStates = Sets.newHashSet(PointOfInterestType.BEEHIVE.matchingStates);
        Map<BlockState, PointOfInterestType> blockStatePOIMap = ObfuscationReflectionHelper.getPrivateValue(PointOfInterestType.class, null, "field_221073_u");
        if (blockStatePOIMap != null) {
            Arrays.stream(ModHelper.getModBlocks(ModBlocks.CHINENSIS_BEEHIVE.get().getClass())).forEach(block -> {
                block.getStateDefinition().getPossibleStates().forEach(state -> {
                    blockStatePOIMap.put(state, PointOfInterestType.BEEHIVE);
                    PointOfInterestType.BEEHIVE.matchingStates.add(state);
                });
            });
        }
    }

    public static class ModHelper {
        public static Block[] getModBlocks(Class<?>... blockClasses)
        {
            Collection<RegistryObject<Block>> blocks = ModBlocks.BLOCKS.getEntries();
            ArrayList<Block> matchingBlocks = new ArrayList<>();
            for (RegistryObject<Block> registryObject : blocks)
            {
                if (Arrays.stream(blockClasses).anyMatch(b -> b.isInstance(registryObject.get())))
                {
                    matchingBlocks.add(registryObject.get());
                }
            }
            return matchingBlocks.toArray(new Block[0]);
        }
    }

}
