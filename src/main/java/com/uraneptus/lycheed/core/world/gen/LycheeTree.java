package com.uraneptus.lycheed.core.world.gen;

import com.uraneptus.lycheed.core.registry.ModFeatures;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import javax.annotation.Nullable;
import java.util.Random;

public class LycheeTree extends Tree {

    @Nullable
    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getConfiguredFeature(Random random, boolean beehive) {
        if (!beehive) {
            return ModFeatures.LYCHEE_TREE.get().configured(ModFeatures.Configs.LYCHEE_TREE_CONFIG);
        } else {
            return null;
        }
    }
}
