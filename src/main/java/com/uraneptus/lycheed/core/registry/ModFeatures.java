package com.uraneptus.lycheed.core.registry;


import com.uraneptus.lycheed.LycheedMod;
import com.uraneptus.lycheed.core.world.gen.feature.LycheeTreeSmall;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, LycheedMod.MOD_ID);


    public static final RegistryObject<Feature<NoneFeatureConfiguration>> LYCHEE_TREE_SMALL = FEATURES.register("lychee_tree_small_0", () -> new LycheeTreeSmall(NoneFeatureConfiguration.CODEC));

    public static final class LycheedFeatureConfigs {
        public static final ConfiguredFeature<?, ?> LYCHEE_TREE_SMALL_CONFIG = register("lychee_tree_small_0", ModFeatures.LYCHEE_TREE_SMALL.get().configured(FeatureConfiguration.NONE));

        /**
         * Modified version of the .register() method in {@link FeatureUtils}
         */
        public static <FC extends FeatureConfiguration> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
            return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(LycheedMod.MOD_ID, name), configuredFeature);
        }
    }


    public static void registerFeatures() {
        //FeatureUtils.register("lychee_tree_small", LYCHEE_TREE_SMALL);
    }


}
