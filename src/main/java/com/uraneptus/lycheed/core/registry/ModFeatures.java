package com.uraneptus.lycheed.core.registry;

import com.uraneptus.lycheed.LycheedMod;
import com.uraneptus.lycheed.core.world.gen.feature.LycheeTreeFeature;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.Features;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.BendingTrunkPlacer;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, LycheedMod.MOD_ID);

    /*public static final RegistryObject<Feature<TreeConfiguration>> LYCHEE_TREE = FEATURES.register("lychee_tree",
            () -> new LycheeTreeFeature(TreeConfiguration.CODEC));*/

    public static final class BlockStates {
        public static final BlockState LYCHEE_LOG = ModBlocks.LYCHEE_LOG.get().defaultBlockState();
        public static final BlockState LYCHEE_LEAVES = ModBlocks.LYCHEE_LEAVES.get().defaultBlockState();
        public static final BlockState FRUITFUL_LYCHEE_LEAVES = ModBlocks.FRUITFUL_LYCHEE_LEAVES.get().defaultBlockState();
        public static final BlockState LYCHEE_SPALING = ModBlocks.LYCHEE_SAPLING.get().defaultBlockState();
    }

    /*public static final class Configs {
        public static final TreeConfiguration LYCHEE_TREE_CONFIG = (new TreeConfiguration.TreeConfigurationBuilder(new SimpleStateProvider(BlockStates.LYCHEE_LOG),
                new WeightedStateProvider().add(BlockStates.LYCHEE_LEAVES, 3).add(BlockStates.FRUITFUL_LYCHEE_LEAVES, 1),
                new BlobFoliagePlacer(UniformInt.fixed(0), UniformInt.fixed(0), 0), new StraightTrunkPlacer(0, 0, 0),
                new TwoLayersFeatureSize(0, 0, 0))).ignoreVines().build();
    }*/

    public static final ConfiguredFeature<TreeConfiguration, ?> LYCHEE_TREE_FEATURE = Feature.TREE.configured((new TreeConfiguration.TreeConfigurationBuilder(
            new SimpleStateProvider(BlockStates.LYCHEE_LOG), new BendingTrunkPlacer(3, 2, 0, 3, UniformInt.of(1, 1)),
            new WeightedStateProvider(weightedBlockStateBuilder().add(BlockStates.LYCHEE_LEAVES, 3).add(BlockStates.FRUITFUL_LYCHEE_LEAVES, 1)),
            new SimpleStateProvider(BlockStates.LYCHEE_SPALING), new RandomSpreadFoliagePlacer(ConstantInt.of(3), ConstantInt.of(1), ConstantInt.of(2), 50),
            new TwoLayersFeatureSize(1, 0, 1))).build());

    public static void regFeatures() {
        register("lychee_tree", LYCHEE_TREE_FEATURE);
    }

    private static <FC extends FeatureConfiguration> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> pConfiguredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(LycheedMod.MOD_ID,  name), pConfiguredFeature);
    }

    static SimpleWeightedRandomList.Builder<BlockState> weightedBlockStateBuilder() {
        return SimpleWeightedRandomList.builder();
    }
}
