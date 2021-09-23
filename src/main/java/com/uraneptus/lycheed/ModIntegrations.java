package com.uraneptus.lycheed;

import com.minecraftabnormals.abnormals_core.core.util.item.filling.TargetedItemGroupFiller;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.NonNullList;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.blocks.PantryBlock;
import vectorwing.farmersdelight.registry.ModItems;

public class ModIntegrations {

    public static Block getPantryBlock(AbstractBlock.Properties properties) {
        return new PantryBlock(properties);
    }

    public static ItemGroup getFdItemGroup() {
        return FarmersDelight.ITEM_GROUP;
    }
}
