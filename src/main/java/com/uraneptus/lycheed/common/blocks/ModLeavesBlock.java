package com.uraneptus.lycheed.common.blocks;

import com.teamabnormals.blueprint.common.block.wood.BlueprintLeavesBlock;
import com.uraneptus.lycheed.core.registry.ModParticleType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class ModLeavesBlock extends BlueprintLeavesBlock {

    public ModLeavesBlock(Properties properties) {
        super(properties);
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState state, Level world, BlockPos pos, Random rand) {
        super.animateTick(state, world, pos, rand);

        if (rand.nextInt(50) == 0) {
            BlockPos blockpos = pos.below();
            if (world.isEmptyBlock(blockpos)) {
                double d3 = (double) ((float) pos.getX() + rand.nextFloat());
                double d4 = (double) pos.getY() - 0.05D;
                double d6 = (double) ((float) pos.getZ() + rand.nextFloat());
                world.addParticle(ModParticleType.LYCHEE_LEAVES_PARTICLE.get(), d3, d4, d6, 0.0D, 0.0D, 0.0D);
            }
        }
    }
}
