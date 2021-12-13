package com.uraneptus.lycheed.core.world.gen;

import com.uraneptus.lycheed.core.registry.ModFeatures;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

import javax.annotation.Nullable;
import java.util.Random;

public class LycheeTree extends AbstractTreeGrower {

    @Nullable
    @Override
    protected ConfiguredFeature<TreeConfiguration, ?> getConfiguredFeature(Random pRandom, boolean pLargeHive) {
        return ModFeatures.LYCHEE_TREE_FEATURE;
    }

    /*@Nullable
    @Override
    protected ConfiguredFeature<TreeConfiguration, ?> getConfiguredFeature(Random random, boolean beehive) {
        if (!beehive) {
            return ModFeatures.LYCHEE_TREE.get().configured(ModFeatures.Configs.LYCHEE_TREE_CONFIG);
        } else {
            return null;
        }
    }*/
}
