package com.uraneptus.lycheed.core.registry;

import com.uraneptus.lycheed.LycheedMod;
import com.uraneptus.lycheed.common.entities.ModBoatEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE = DeferredRegister.create(ForgeRegistries.ENTITIES, LycheedMod.MOD_ID);

    public static final RegistryObject<EntityType<ModBoatEntity>> LYCHEE_BOAT = ENTITY_TYPE.register("lychee_boat",
            () -> EntityType.Builder.<ModBoatEntity>of((entityType, world) -> new ModBoatEntity(entityType, world, ModItems.LYCHEE_BOAT, ModBlocks.LYCHEE_PLANKS), EntityClassification.MISC)
                    .sized(1.375F, 0.5625F).clientTrackingRange(10)
                    .build(new ResourceLocation("lychee").toString()));
}
