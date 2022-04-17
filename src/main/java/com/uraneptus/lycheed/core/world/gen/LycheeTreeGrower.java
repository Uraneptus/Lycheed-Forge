package com.uraneptus.lycheed.core.world.gen;

import com.uraneptus.lycheed.core.registry.ModFeatures;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class LycheeTreeGrower extends AbstractTreeGrower {

    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random pRandom, boolean pLargeHive) {
        int treeRandom = pRandom.nextInt(3);
        if (treeRandom == 1) {
            return ModFeatures.Config.LYCHEE_TREE_SMALL_CONFIG;
        } else {
            return ModFeatures.Config.LYCHEE_TREE_MEDIUM_CONFIG;
        }
    }
}
