package com.uraneptus.lycheed.core.world.gen.feature;

import com.minecraftabnormals.abnormals_core.core.util.TreeUtil;
import com.mojang.serialization.Codec;
import com.uraneptus.lycheed.core.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldWriter;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.common.IPlantable;

import java.util.*;

public class LycheeTreeFeature extends Feature<BaseTreeFeatureConfig> {

    private static final Direction[] DIRECTION = new Direction[] { Direction.WEST }; //TODO make generation work for all directions

    private static final BlockState LOG = ModBlocks.LYCHEE_LOG.get().defaultBlockState();
    private static final BlockState LEAVES = ModBlocks.LYCHEE_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 2);

    public LycheeTreeFeature(Codec<BaseTreeFeatureConfig> config) {
        super(config);
    }

    @Override
    public boolean place(ISeedReader world, ChunkGenerator generator, Random random, BlockPos pos, BaseTreeFeatureConfig config) {
        while (pos.getY() > 1 && TreeUtil.isAirOrLeaves(world, pos)) {
            pos = pos.below();
        }
        // Trunks
        int trunkHeight = 7;
        if (pos.getY() >= 1 && pos.getY() + 7 + 1 < world.getHeight()) {
            for (int i = pos.getY() + 1; i < pos.getY() + trunkHeight + 1; i++) {
                world.setBlock(new BlockPos(pos.getX(), i, pos.getZ()), LOG, 3);
            }
        } else {
            return false;
        }

        // Leaves
        //for (int i = 3; i < 8; i++) {
        BlockPos main3 = new BlockPos(pos.getX(), pos.getY() + 3, pos.getZ()).relative(DIRECTION[random.nextInt(DIRECTION.length)]);
        for (int x = -1; x < 0; x++) {
            for (int z = -1; z < 0; z++) {
                world.setBlock(main3, LEAVES, 2);
                world.setBlock(new BlockPos(main3.getX(), main3.getY(), main3.getZ() - z), LEAVES, 2);
                world.setBlock(new BlockPos(main3.getX() - x, main3.getY(), main3.getZ() - z), LEAVES, 2);
            }
        }

        BlockPos main4 = new BlockPos(pos.getX(), pos.getY() + 4, pos.getZ()).relative(DIRECTION[random.nextInt(DIRECTION.length)]);
        for (int x = 2; x > 0; x--) {
            for (int z = -1; z < 0; z++) {
                world.setBlock(main4, LEAVES, 2);
                //world.setBlock(new BlockPos(main4.getX(), main4.getY(), main4.getZ() - 1), LEAVES, 2);
                world.setBlock(new BlockPos(main4.getX() + 2, main4.getY(), main4.getZ() - 1), LEAVES, 2);
                world.setBlock(new BlockPos(main4.getX() + 1, main4.getY(), main4.getZ() + 1), LEAVES, 2);
                world.setBlock(new BlockPos(main4.getX() + 2, main4.getY(), main4.getZ()), LEAVES, 2);

            }
        }
        //world.setBlock(new BlockPos(pos.getX(), pos.getY() + 3, pos.getZ()).relative(DIRECTION[random.nextInt(DIRECTION.length)]), LEAVES, 2);

        //}

        TreeUtil.setDirtAt(world, pos.below());

        return true;
        /*int i = random.nextInt(2) + 6;

        boolean flag = true;
        if (pos.getY() >= 1 && pos.getY() + i + 1 <= world.getMaxBuildHeight()) {
            for (int j = pos.getY(); j <= pos.getY() + 1 + i; ++j) {
                int k = 1;
                if (j == pos.getY()) {
                    k = 0;
                }

                if (j >= pos.getY() + 1 + i - 2) {
                    k = 2;
                }

                BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();

                for (int l = pos.getX() - k; l <= pos.getX() + k && flag; ++l) {
                    for (int i1 = pos.getZ() - k; i1 <= pos.getZ() + k && flag; ++i1) {
                        if (j >= 0 && j < world.getMaxBuildHeight()) {
                            if (!isAirOrLeaves(world, blockpos$mutableblockpos.set(l, j, i1))) {
                                flag = false;
                            }
                        } else {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag) {
                return false;
            } else if (isValidGround(world, pos.below()) && pos.getY() < world.getMaxBuildHeight() - i - 1) {
                setDirtAt(world, pos.below());

                for (int i2 = 0; i2 < 2; ++i2) {
                    BlockPos blockpos = pos.above(i - 1 - i2);

                    for (BlockPos blockpos1 : BlockPos.betweenClosed(blockpos.offset(-2, -1, -2), blockpos.offset(2, 3, 2))) {
                        double d0 = blockpos1.distSqr(blockpos.getX(), blockpos.getY(), blockpos.getZ(), false);
                        if (d0 <= (double) (2.35F * 2.35F) || (d0 <= (double) (2.5F * 2.5F) && random.nextInt(2) > 0)) {
                            if (isAirOrLeaves(world, blockpos1)) {
                                this.placeLeafAt(world, blockpos1, random, config);
                            }
                        }
                    }
                }

                for (int i2 = 0; i2 < i; ++i2) {
                    if (isAirOrLeaves(world, pos.above(i2))) {
                        this.placeLogAt(world, pos.above(i2), random, config);
                    }
                }

                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private void placeLogAt(IWorldWriter worldIn, BlockPos pos, Random rand, BaseTreeFeatureConfig config) {
        BlockState logState = config.trunkProvider.getState(rand, pos);
        TreeUtil.setForcedState(worldIn, pos, logState);
    }

    private void placeLeafAt(IWorldGenerationReader world, BlockPos pos, Random rand, BaseTreeFeatureConfig config) {
        if (isAirOrLeaves(world, pos)) {
            if (TreeUtil.isAirOrLeaves(world, pos)) {
                if (config.leavesProvider.getState(rand, pos).hasProperty(LeavesBlock.DISTANCE)) {
                    TreeUtil.setForcedState(world, pos, config.leavesProvider.getState(rand, pos).setValue(LeavesBlock.DISTANCE, 1));
                } else {
                    TreeUtil.setForcedState(world, pos, config.leavesProvider.getState(rand, pos));
                }
            }
        }
    }

    public static boolean isAirOrLeaves(IWorldGenerationBaseReader worldIn, BlockPos pos) {
        if (worldIn instanceof net.minecraft.world.IWorldReader) {
            return worldIn.isStateAtPosition(pos, state -> state.canBeReplacedByLeaves((net.minecraft.world.IWorldReader) worldIn, pos));
        }
        return worldIn.isStateAtPosition(pos, (state) -> {
            return state.isAir() || state.is(BlockTags.LEAVES);
        });
    }

    public static void setDirtAt(IWorld worldIn, BlockPos pos) {
        Block block = worldIn.getBlockState(pos).getBlock();
        if (block == Blocks.GRASS_BLOCK || block == Blocks.FARMLAND) {
            worldIn.setBlock(pos, Blocks.DIRT.defaultBlockState(), 18);
        }
    }

    public static boolean isValidGround(IWorld world, BlockPos pos) {
        return world.getBlockState(pos).canSustainPlant(world, pos, Direction.UP, (IPlantable) ModBlocks.LYCHEE_SAPLING.get());
    }*/

    }
}
