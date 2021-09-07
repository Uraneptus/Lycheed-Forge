package com.uraneptus.lycheed.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class ModBookshelfBlock extends Block {

    public ModBookshelfBlock(Properties properties) {
        super(properties);
    }

    public float  getEnchantPowerBonus(BlockState state, IWorldReader world, BlockPos pos) {
        return 1.0F;
    }
}
