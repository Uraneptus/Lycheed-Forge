package com.uraneptus.lycheed.core.world.gen.feature;

import com.minecraftabnormals.abnormals_core.core.util.TreeUtil;
import com.mojang.serialization.Codec;
import com.uraneptus.lycheed.core.registry.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorldWriter;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LycheeTree extends Feature<BaseTreeFeatureConfig> {

    private static final Direction[] directions = new Direction[] { Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST };

    private static final BlockState LOG = ModBlocks.LYCHEE_LOG.get().defaultBlockState();
    private static final BlockState LEAVES = ModBlocks.LYCHEE_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 2);

    public LycheeTree(Codec<BaseTreeFeatureConfig> config) {
        super(config);
    }

    @Override
    public boolean place(ISeedReader world, ChunkGenerator generator, Random random, BlockPos pos, BaseTreeFeatureConfig config) {
        int trunkHeight = random.nextInt(3) + 4;
        if (pos.getY() <= 0 || pos.getY() + trunkHeight > world.getHeight() - 2) {
            return false;
        }
        if (!TreeUtil.isValidGround(world, pos.below(), (SaplingBlock) ModBlocks.LYCHEE_SAPLING.get())) {
            return false;
        }

        List<BlockPos> logs = new ArrayList<>();
        List<BlockPos> leaves = new ArrayList<>();

        if  (pos.getY() >= 1 && pos.getY() + trunkHeight <= world.getMaxBuildHeight()) {
            TreeUtil.setDirtAt(world, pos.below());
            int logX = pos.getX();
            int logZ = pos.getZ();
            int logY = pos.getY() + trunkHeight;
            BlockPos blockpos = new BlockPos(logX, logY, logZ);
            if (TreeUtil.isAirOrLeaves(world, blockpos)) {
                this.placeLogAt(world, blockpos, Direction.UP, random, config);
            }
        }

        /*for (int i = 0; i <= trunkHeight; i++) {
            logs.add(pos.above(i));
        }*/


        return true;
    }
    private void placeLogAt(IWorldWriter worldIn, BlockPos pos, Direction direction, Random random, BaseTreeFeatureConfig config) {
        BlockState logState = config.trunkProvider.getState(random, pos).setValue(RotatedPillarBlock.AXIS, direction.getAxis());
        TreeUtil.setForcedState(worldIn, pos, logState);
    }

}
