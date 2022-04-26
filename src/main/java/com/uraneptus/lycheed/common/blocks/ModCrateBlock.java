package com.uraneptus.lycheed.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;

public class ModCrateBlock extends Block {

    public ModCrateBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, net.minecraftforge.common.IPlantable plantable) {
        return plantable.getPlant(world, pos).is(BlockTags.FLOWERS);
    }

}
