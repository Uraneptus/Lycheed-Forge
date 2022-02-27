package com.uraneptus.lycheed.core.world.gen;

import com.uraneptus.lycheed.core.registry.ModFeatures;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class LycheeTreeGrowerSmall extends AbstractTreeGrower {

    @Nullable
    @Override
    protected ConfiguredFeature<?, ?> getConfiguredFeature(Random pRandom, boolean pLargeHive) {
        return ModFeatures.LycheedFeatureConfigs.LYCHEE_TREE_SMALL_CONFIG;
    }
}
