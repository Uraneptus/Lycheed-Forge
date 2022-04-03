package com.uraneptus.lycheed.core.registry;


import com.uraneptus.lycheed.LycheedMod;
import com.uraneptus.lycheed.core.world.gen.feature.LycheeTreeSmall;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, LycheedMod.MOD_ID);


    public static final RegistryObject<Feature<NoneFeatureConfiguration>> LYCHEE_TREE_SMALL = FEATURES.register("lychee_tree_small", () -> new LycheeTreeSmall(NoneFeatureConfiguration.CODEC));

    public static final class Config {
        public static final Holder<ConfiguredFeature<?, ?>> LYCHEE_TREE_SMALL_CONFIG = register("lychee_tree_small", ModFeatures.LYCHEE_TREE_SMALL.get(), FeatureConfiguration.NONE);

        /**
         * Modified version of the .register() method in {@link FeatureUtils}
         */
        public static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<?, ?>> register(String name, F feature, FC featureConfig) {
            return BuiltinRegistries.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(LycheedMod.MOD_ID, name), new ConfiguredFeature<>(feature, featureConfig));
        }
    }


   public static final class Placement {
        public static final Holder<PlacedFeature> LYCHEE_TREE_SMALL_PLACEMENT = register("lychee_tree_small_placement", Config.LYCHEE_TREE_SMALL_CONFIG, VegetationPlacements.treePlacement(PlacementUtils.countExtra(50, 0.1F, 1)));

        public static void onBiomeLoad(BiomeLoadingEvent event) {
            BiomeGenerationSettings.Builder generation = event.getGeneration();

            if (event.getCategory() == Biome.BiomeCategory.PLAINS) {
                generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LYCHEE_TREE_SMALL_PLACEMENT);
            }
        }


       /**
        * Modified version of the .register() method in {@link PlacementUtils}
        */

       public static Holder<PlacedFeature> register(String name, Holder<? extends ConfiguredFeature<?, ?>> configuredFeature, List<PlacementModifier> placementModifiers) {
           return BuiltinRegistries.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(LycheedMod.MOD_ID, name), new PlacedFeature(Holder.hackyErase(configuredFeature), List.copyOf(placementModifiers)));
       }
   }


}
