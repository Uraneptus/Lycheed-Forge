package com.uraneptus.lycheed.core.data.client;

import com.uraneptus.lycheed.LycheedMod;
import com.uraneptus.lycheed.core.registry.ModBlocks;
import com.uraneptus.lycheed.core.registry.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class LangGenerator extends LanguageProvider {
    public LangGenerator(DataGenerator gen) {
        super(gen, LycheedMod.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(ModItems.LYCHEE.get(), "Lychee");
        add(ModItems.DRIED_LYCHEE.get(), "Dried Lychee");
        add(ModItems.LYCHEE_CAKE_SLICE.get(), "Lychee Cake Slice");
        add(ModItems.LYCHEE_BOAT.get(), "Lychee Boat");
        add(ModBlocks.LYCHEE_PLANKS.get(), "Lychee Planks");
        add(ModBlocks.STRIPPED_LYCHEE_LOG.get(), "Stripped Lychee Log");
        add(ModBlocks.STRIPPED_LYCHEE_WOOD.get(), "Stripped Lychee Wood");
        add(ModBlocks.LYCHEE_LOG.get(), "Lychee Log");
        add(ModBlocks.LYCHEE_WOOD.get(), "Lychee Wood");
        add(ModBlocks.LYCHEE_LEAVES.get(), "Lychee Leaves");
        add(ModBlocks.FRUITFUL_LYCHEE_LEAVES.get(), "Fruitful Lychee Leaves");
        add(ModBlocks.LYCHEE_SAPLING.get(), "Lychee Sapling");
        add(ModBlocks.LYCHEE_SLAB.get(), "Lychee Slab");
        add(ModBlocks.LYCHEE_STAIRS.get(), "Lychee Stairs");
        add(ModBlocks.LYCHEE_DOOR.get(), "Lychee Door");
        add(ModBlocks.LYCHEE_TRAPDOOR.get(), "Lychee Trapdoor");
        add(ModBlocks.LYCHEE_FENCE.get(), "Lychee Fence");
        add(ModBlocks.LYCHEE_FENCE_GATE.get(), "Lychee Fence Gate");
        add(ModBlocks.LYCHEE_PRESSURE_PLATE.get(), "Lychee Pressure Plate");
        add(ModBlocks.LYCHEE_SIGN.getFirst().get(), "Lychee Sign");
        add(ModBlocks.LYCHEE_BUTTON.get(), "Lychee Button");
        add(ModBlocks.LYCHEE_BASKET.get(), "Lychee Basket");
        add(ModBlocks.LYCHEE_CAKE.get(), "Lychee Cake");
        add(ModBlocks.LYCHEE_LADDER.get(), "Lychee Ladder");
        add(ModBlocks.LYCHEE_BOOKSHELF.get(), "Lychee Bookshelf");
        add(ModBlocks.LYCHEE_LEAVES_CARPET.get(), "Lychee Leaves Carpet");
        add(ModBlocks.FRUITFUL_LYCHEE_LEAVES_CARPET.get(), "Fruitful Lychee Leaves Carpet");
        add(ModBlocks.STRIPPED_LYCHEE_POST.get(), "Stripped Lychee Post");
        add(ModBlocks.LYCHEE_VERTICAL_SLAB.get(), "Vertical Lychee Slab");
        add(ModBlocks.LYCHEE_BEEHIVE.get(), "Lychee Beehive");
        add(ModBlocks.LYCHEE_CABINET.get(), "Lychee Cabinet");
        add(ModBlocks.LYCHEE_CHESTS.getFirst().get(), "Lychee Chest");
        add(ModBlocks.LYCHEE_CHESTS.getSecond().get(), "Lychee Trapped Chest");

        System.out.println("LANGUAGE GENERATION COMPLETE");
    }
}
