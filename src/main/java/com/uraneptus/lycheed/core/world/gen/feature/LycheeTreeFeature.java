package com.uraneptus.lycheed.core.world.gen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

public class LycheeTreeFeature extends Feature<TreeConfiguration> {

    /*private static final Direction[] DIRECTION = new Direction[] { Direction.WEST }; //TODO make generation work for all directions

    private static final BlockState LOG = ModBlocks.LYCHEE_LOG.get().defaultBlockState();
    private static final BlockState LEAVES = ModBlocks.LYCHEE_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 2);*/

    public LycheeTreeFeature(Codec<TreeConfiguration> config) {
        super(config);
    }

    @Override
    public boolean place(FeaturePlaceContext<TreeConfiguration> pContext) {
        return false;
    }

    /*@Override
    public boolean place(WorldGenLevel world, ChunkGenerator generator, Random random, BlockPos pos, TreeConfiguration config) {
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

    }*/
}
