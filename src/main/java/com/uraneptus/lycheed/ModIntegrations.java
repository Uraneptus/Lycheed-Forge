package com.uraneptus.lycheed;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.blocks.PantryBlock;

public class ModIntegrations {

        public static Block getPantryBlock(AbstractBlock.Properties properties) {
            return new PantryBlock(properties);
        }

    public static ItemGroup getFdItemGroup() {
        return FarmersDelight.ITEM_GROUP;
    }
}
