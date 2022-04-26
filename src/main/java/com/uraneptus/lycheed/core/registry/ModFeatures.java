package com.uraneptus.lycheed.core.registry;


import com.teamabnormals.blueprint.core.util.DataUtil;
import com.uraneptus.lycheed.LycheedMod;
import com.uraneptus.lycheed.core.world.gen.feature.LycheeTrees;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, LycheedMod.MOD_ID);

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> LYCHEE_TREES = FEATURES.register("lychee_trees", () -> new LycheeTrees(NoneFeatureConfiguration.CODEC));

    public static final class Config {
        public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>>LYCHEE_TREES_CONFIG = FeatureUtils.register("lychee_trees", ModFeatures.LYCHEE_TREES.get(), FeatureConfiguration.NONE);

    }

   public static final class Placement {
        public static final Holder<PlacedFeature> LYCHEE_TREES_PLACEMENT = PlacementUtils.register("lychee_trees_placement", Config.LYCHEE_TREES_CONFIG, PlacementUtils.countExtra(0, 0.1F, 1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(ModBlocks.LYCHEE_SAPLING.get().defaultBlockState(), BlockPos.ZERO)));

        public static void onBiomeLoad(BiomeLoadingEvent event) {
            BiomeGenerationSettings.Builder generation = event.getGeneration();
            ResourceLocation biome = event.getName();

            if (DataUtil.matchesKeys(biome, Biomes.FOREST)) {
                generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LYCHEE_TREES_PLACEMENT);

            }
        }
   }


}
