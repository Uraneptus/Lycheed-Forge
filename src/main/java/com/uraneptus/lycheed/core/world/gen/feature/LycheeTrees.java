package com.uraneptus.lycheed.core.world.gen.feature;

import com.mojang.serialization.Codec;
import com.teamabnormals.blueprint.core.util.TreeUtil;
import com.uraneptus.lycheed.core.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *This is not very nice Tree code but it works!*/
public class LycheeTrees extends Feature<NoneFeatureConfiguration> {
    private static final BlockState LOG = ModBlocks.LYCHEE_LOG.get().defaultBlockState();
    private static final WeightedStateProvider LEAVES_STATE_PROVIDER =  new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(ModBlocks.LYCHEE_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 3), 5).add(ModBlocks.FRUITFUL_LYCHEE_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 3), 3));


    public LycheeTrees(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos pos = context.origin();
        Random random = context.random();
        BlockPos blockPos = pos;
        int trunkHeight = 0;

        List<BlockPos> logs = new ArrayList<>();
        List<BlockPos> leaves = new ArrayList<>();

        if (!TreeUtil.isValidGround(level, pos.below(), (SaplingBlock) ModBlocks.LYCHEE_SAPLING.get())) {
            return false;
        }
        
        int variants = random.nextInt(3);
        
        if (variants == 0) {
            trunkHeight = 3;

            for (int i = 0; i < trunkHeight; i++) {
                logs.add(blockPos);
                blockPos = blockPos.above();
            }

            int i = 0;

            for (BlockPos log : logs) {
                if (i >= trunkHeight - 1) {
                    for (Direction direction : Direction.values()) {
                        if (direction.getAxis().isHorizontal()) {
                            if (i == trunkHeight - 1) {

                                leaves.add(log.offset(0, 3, 0));

                                leaves.add(log.offset(0, 2, 0));
                                leaves.add(log.offset(1, 2, 0));
                                leaves.add(log.offset(0, 2, 1));
                                leaves.add(log.offset(0, 2, -1));

                                leaves.add(log.relative(direction).above());
                                leaves.add(log.offset(0, 1, 0));
                                leaves.add(log.offset(-1, 1, 1));
                                leaves.add(log.offset(-1, 1, -1));
                                leaves.add(log.offset(1, 1, 1));


                                leaves.add(log.offset(-1, 0, 1));
                                leaves.add(log.offset(1, 0, 1));
                                leaves.add(log.offset(0, 0, 1));
                                leaves.add(log.offset(-1, 0, 0));
                                leaves.add(log.offset(1, 0, -1));
                                leaves.add(log.offset(0, 0, -1));

                                leaves.add(log.offset(0, -1, 1));
                                leaves.add(log.offset(0, -1, -1));
                            }
                        }
                    }
                }

                i += 1;
            }
        }
        if (variants == 1) {
            trunkHeight = 4;

            for (int i = 0; i < trunkHeight; i++) {
                logs.add(pos.offset(-1, 4, 0));

                logs.add(blockPos);
                blockPos = blockPos.above();
            }

            int i = 0;

            for (BlockPos log : logs) {
                if (i >= trunkHeight - 1) {
                    for (Direction direction : Direction.values()) {
                        if (direction.getAxis().isHorizontal()) {
                            if (i == trunkHeight - 1) {

                                leaves.add(log.offset(0, 5,0));

                                leaves.add(log.offset(0, 4,0));
                                leaves.add(log.offset(0, 4,1));
                                leaves.add(log.offset(-1, 4,0));
                                leaves.add(log.offset(-1, 4,1));

                                leaves.add(log.offset(0, 3,0));
                                leaves.add(log.offset(0, 3,-1));
                                leaves.add(log.offset(0, 3,1));
                                leaves.add(log.offset(0, 3,2));
                                leaves.add(log.offset(1, 3,0));
                                leaves.add(log.offset(-2, 3,0));
                                leaves.add(log.offset(-1, 3,1));
                                leaves.add(log.offset(-1, 3,-1));
                                leaves.add(log.offset(1, 3,1));

                                leaves.add(log.offset(0, 2,-1));
                                leaves.add(log.offset(0, 2,1));
                                leaves.add(log.offset(0, 2,2));
                                leaves.add(log.offset(-1, 2,0));
                                leaves.add(log.offset(-2, 2,0));
                                leaves.add(log.offset(1, 2,0));
                                leaves.add(log.offset(1, 2,1));
                                leaves.add(log.offset(1, 2,2));
                                leaves.add(log.offset(-1, 2,1));
                                leaves.add(log.offset(-1, 2,-1));
                                leaves.add(log.offset(1, 2,-1));

                                leaves.add(log.offset(0, 1,-1));
                                leaves.add(log.offset(1, 1,0));
                                leaves.add(log.offset(-2, 1,0));
                                leaves.add(log.offset(1, 1,2));
                            }
                        }
                    }
                }

                i += 1;
            }
        }
        if (variants == 2) {
            trunkHeight = 5;

            for (int i = 0; i < trunkHeight; i++) {
                logs.add(pos.offset(1, 5, 0));
                logs.add(pos.offset(-1, 5, -1));
                logs.add(pos.offset(-1, 6, -1));

                logs.add(blockPos);
                blockPos = blockPos.above();
            }

            int i = 0;

            for (BlockPos log : logs) {
                if (i >= trunkHeight - 1) {
                    for (Direction direction : Direction.values()) {
                        if (direction.getAxis().isHorizontal()) {
                            if (i == trunkHeight - 1) {

                                leaves.add(log.offset(-1, 3,0));

                                leaves.add(log.offset(0, 2,0));
                                leaves.add(log.offset(-1, 2,0));
                                leaves.add(log.offset(-2, 2,0));

                                leaves.add(log.offset(-1, 2,1));
                                leaves.add(log.offset(-1, 2,2));
                                leaves.add(log.offset(-1, 2,-1));
                                leaves.add(log.offset(-1, 2,-2));
                                leaves.add(log.offset(-2, 2,1));
                                leaves.add(log.offset(-2, 2,-1));

                                leaves.add(log.offset(0, 1,0));
                                leaves.add(log.offset(1, 1,0));
                                leaves.add(log.offset(-1, 1,0));
                                leaves.add(log.offset(-2, 1,0));
                                leaves.add(log.offset(0, 1,1));
                                leaves.add(log.offset(0, 1,-1));
                                leaves.add(log.offset(-1, 1,-1));
                                leaves.add(log.offset(-1, 1,-2));
                                leaves.add(log.offset(-1, 1,1));
                                leaves.add(log.offset(-1, 1,2));
                                leaves.add(log.offset(-2, 1,1));
                                leaves.add(log.offset(-2, 1,-2));
                                leaves.add(log.offset(-3, 1,-1));

                                leaves.add(log.offset(1, 0,0));
                                leaves.add(log.offset(1, 0,1));
                                leaves.add(log.offset(0, 0,1));
                                leaves.add(log.offset(0, 0,-1));
                                leaves.add(log.offset(-1, 0,0));
                                leaves.add(log.offset(-1, 0,1));
                                leaves.add(log.offset(-1, 0,-1));
                                leaves.add(log.offset(-1, 0,-2));
                                leaves.add(log.offset(-2, 0,0));
                                leaves.add(log.offset(-2, 0,1));
                                leaves.add(log.offset(-2, 0,1));
                                leaves.add(log.offset(-2, 0,-2));
                                leaves.add(log.offset(-3, 0,-1));

                                leaves.add(log.offset(0, -1,0));
                                leaves.add(log.offset(0, -1,1));
                                leaves.add(log.offset(0, -1,-1));
                                leaves.add(log.offset(-2, -1,-2));
                                leaves.add(log.offset(-2, -1,1));
                                leaves.add(log.offset(-3, -1,-1));

                                leaves.add(log.offset(0, -2,1));
                                leaves.add(log.offset(0, -2,-1));

                            }
                        }
                    }
                }

                i += 1;
            }
        }
        
        if (pos.getY() >= 1 && pos.getY() < level.getMaxBuildHeight() - trunkHeight) {
            for (BlockPos blockPos1 : logs) {
                TreeUtil.setForcedState(level, blockPos1, LOG);
            }
            for (BlockPos blockPos1 : leaves) {
                TreeUtil.setForcedState(level, blockPos1, LEAVES_STATE_PROVIDER.getState(random, blockPos1));
            }

            TreeUtil.setDirtAt(level, pos.below());
            return true;
        }

        return false;
    }
}
