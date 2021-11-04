package com.uraneptus.lycheed.core.registry;

import com.uraneptus.lycheed.LycheedMod;
import com.uraneptus.lycheed.core.world.gen.feature.LycheeTreeFeature;
import net.minecraft.block.BlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class ModFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, LycheedMod.MOD_ID);

    public static final RegistryObject<Feature<BaseTreeFeatureConfig>> LYCHEE_TREE = FEATURES.register("lychee_tree",
            () -> new LycheeTreeFeature(BaseTreeFeatureConfig.CODEC));

    public static final class BlockStates {
        public static final BlockState LYCHEE_LOG = ModBlocks.LYCHEE_LOG.get().defaultBlockState();
        public static final BlockState LYCHEE_LEAVES = ModBlocks.LYCHEE_LEAVES.get().defaultBlockState();
        public static final BlockState FRUITFUL_LYCHEE_LEAVES = ModBlocks.FRUITFUL_LYCHEE_LEAVES.get().defaultBlockState();
    }

    public static final class Configs {
        public static final BaseTreeFeatureConfig LYCHEE_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BlockStates.LYCHEE_LOG),
                new WeightedBlockStateProvider().add(BlockStates.LYCHEE_LEAVES, 3).add(BlockStates.FRUITFUL_LYCHEE_LEAVES, 1),
                new BlobFoliagePlacer(FeatureSpread.fixed(0), FeatureSpread.fixed(0), 0), new StraightTrunkPlacer(0, 0, 0),
                new TwoLayerFeature(0, 0, 0))).ignoreVines().build();
    }

    public static final class Configured {
        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> LYCHEE = ModFeatures.LYCHEE_TREE.get().configured(Configs.LYCHEE_TREE_CONFIG);

        public static final ConfiguredFeature<?, ?> LYCHEE_CONFIGURED = LYCHEE.decorated(Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.CHANCE.configured(new ChanceConfig(256)));


        public static void regFeatures() {
            Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(LycheedMod.MOD_ID, "lychee"), Configured.LYCHEE_CONFIGURED);
        }

    }
}
