package com.uraneptus.lycheed.core.world.gen.feature;

import com.mojang.serialization.Codec;
import com.teamabnormals.blueprint.core.util.TreeUtil;
import com.uraneptus.lycheed.core.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.*;

public class LycheeTreeSmall extends Feature<NoneFeatureConfiguration> {
    private static final BlockState LOG = ModBlocks.LYCHEE_LOG.get().defaultBlockState();
    private static final BlockState LEAVES = ModBlocks.LYCHEE_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 2);
    private static final BlockState FRUIT_LEAVES = ModBlocks.FRUITFUL_LYCHEE_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 2);

    public LycheeTreeSmall(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos pos = context.origin();
        Random random = context.random();
        BlockPos blockPos = pos;
        List<BlockPos> logs = new ArrayList<>();
        Map<BlockPos, Direction> leaves = new HashMap<>();
        Map<BlockPos, Direction> fruitLeaves = new HashMap<>();
        int trunkHeight = 3;

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
                            leaves.put(log.offset(0, 3, 0), direction);

                            if (random.nextInt(8) != 0) {
                                leaves.put(log.offset(0, 2, 0), direction);
                                leaves.put(log.offset(1, 2, 0), direction);
                                leaves.put(log.offset(0, 2, 1), direction);
                                leaves.put(log.offset(0, 2, -1), direction);
                            } else {
                                fruitLeaves.put(log.offset(0, 2, 0), direction);
                                fruitLeaves.put(log.offset(1, 2, 0), direction);
                                fruitLeaves.put(log.offset(0, 2, 1), direction);
                                fruitLeaves.put(log.offset(0, 2, -1), direction);
                            }
                            if (random.nextInt(7) != 0) {
                                leaves.put(log.relative(direction).above(), direction);
                                leaves.put(log.offset(0, 1, 0), direction);
                                leaves.put(log.offset(-1, 1, 1), direction);
                                leaves.put(log.offset(-1, 1, -1), direction);
                                leaves.put(log.offset(1, 1, 1), direction);
                            } else {
                                fruitLeaves.put(log.relative(direction).above(), direction);
                                fruitLeaves.put(log.offset(0, 1, 0), direction);
                                fruitLeaves.put(log.offset(-1, 1, 1), direction);
                                fruitLeaves.put(log.offset(-1, 1, -1), direction);
                                fruitLeaves.put(log.offset(1, 1, 1), direction);
                            }
                            if (random.nextInt(6) != 0) {
                                leaves.put(log.offset(-1, 0, 1), direction);
                                leaves.put(log.offset(1, 0, 1), direction);
                                leaves.put(log.offset(0, 0, 1), direction);
                                leaves.put(log.offset(-1, 0, 0), direction);
                                leaves.put(log.offset(1, 0, -1), direction);
                                leaves.put(log.offset(0, 0, -1), direction);
                            } else {
                                fruitLeaves.put(log.offset(-1, 0, 1), direction);
                                fruitLeaves.put(log.offset(1, 0, 1), direction);
                                fruitLeaves.put(log.offset(0, 0, 1), direction);
                                fruitLeaves.put(log.offset(-1, 0, 0), direction);
                                fruitLeaves.put(log.offset(1, 0, -1), direction);
                                fruitLeaves.put(log.offset(0, 0, -1), direction);
                            }
                            if (random.nextInt(8) != 0) {
                                leaves.put(log.offset(0, -1, 1), direction);
                                leaves.put(log.offset(0, -1, -1), direction);
                            } else {
                                fruitLeaves.put(log.offset(0, -1, 1), direction);
                                fruitLeaves.put(log.offset(0, -1, -1), direction);
                            }
                        }
                    }
                }
            }

            i += 1;
        }


        if (pos.getY() >= 1 && pos.getY() < level.getMaxBuildHeight() - trunkHeight) {
            for (BlockPos blockPos1 : logs) {
                TreeUtil.setForcedState(level, blockPos1, LOG);
            }
            for (BlockPos blockPos1 : leaves.keySet()) {
                TreeUtil.setForcedState(level, blockPos1, LEAVES);
            }
            for (BlockPos blockPos1 : fruitLeaves.keySet()) {
                TreeUtil.setForcedState(level, blockPos1, FRUIT_LEAVES);
            }

            TreeUtil.setDirtAt(level, pos.below());
            return true;
        }

        return false;
    }
}
