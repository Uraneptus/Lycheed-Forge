package com.uraneptus.lycheed.core.registry;


import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BushFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

public class ModFeatures {

    public static final ConfiguredFeature<?, ?> LYCHEE_TREE_SMALL = Feature.TREE.configured(
                    new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.LYCHEE_LOG.get()),
                    new StraightTrunkPlacer(3, 1, 0),
                    new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(ModBlocks.LYCHEE_LEAVES.get().defaultBlockState(), 3).add(ModBlocks.FRUITFUL_LYCHEE_LEAVES.get().defaultBlockState(), 1)),
                    new BushFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), 2),
                    new TwoLayersFeatureSize(0, 0 , 0)).build());


    public static void registerFeatures() {
        FeatureUtils.register("lychee_tree_small", LYCHEE_TREE_SMALL);
    }


}
