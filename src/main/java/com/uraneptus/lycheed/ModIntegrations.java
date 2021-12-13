package com.uraneptus.lycheed;

/*import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.CreativeModeTab;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.blocks.PantryBlock;*/

import com.uraneptus.lycheed.common.blocks.ModFakePantryBlock;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ModIntegrations { //Waiting for farmer's Delight to update
    public static Block getPantryBlock(BlockBehaviour.Properties properties) {
        return new ModFakePantryBlock(properties);
    }

    public static CreativeModeTab getFdItemGroup() {
        return CreativeModeTab.TAB_MISC;
    }
}