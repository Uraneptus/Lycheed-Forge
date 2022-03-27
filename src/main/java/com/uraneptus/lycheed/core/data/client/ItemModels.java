package com.uraneptus.lycheed.core.data.client;

import com.uraneptus.lycheed.LycheedMod;
import com.uraneptus.lycheed.core.data.DatagenUtil;
import com.uraneptus.lycheed.core.registry.ModBlocks;
import com.uraneptus.lycheed.core.registry.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModels extends ItemModelProvider {
    public ItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, LycheedMod.MOD_ID, existingFileHelper);
    }


    @Override
    protected void registerModels() {
        basicBlockItem(ModBlocks.LYCHEE_PLANKS.get());
        basicBlockItem(ModBlocks.STRIPPED_LYCHEE_LOG.get());
        basicBlockItem(ModBlocks.STRIPPED_LYCHEE_WOOD.get());
        basicBlockItem(ModBlocks.LYCHEE_LOG.get());
        basicBlockItem(ModBlocks.LYCHEE_WOOD.get());
        basicBlockItem(ModBlocks.LYCHEE_LEAVES.get());
        basicBlockItem(ModBlocks.FRUITFUL_LYCHEE_LEAVES.get());
        basicBlockItem(ModBlocks.LYCHEE_SLAB.get());
        basicBlockItem(ModBlocks.LYCHEE_STAIRS.get());
        basicBlockItem(ModBlocks.LYCHEE_FENCE_GATE.get());
        basicBlockItem(ModBlocks.LYCHEE_PRESSURE_PLATE.get());
        basicBlockItem(ModBlocks.LYCHEE_BASKET.get());
        basicBlockItem(ModBlocks.LYCHEE_BOOKSHELF.get());
        basicBlockItem(ModBlocks.LYCHEE_LEAVES_CARPET.get());
        basicBlockItem(ModBlocks.FRUITFUL_LYCHEE_LEAVES_CARPET.get());
        basicBlockItem(ModBlocks.STRIPPED_LYCHEE_POST.get());
        basicBlockItem(ModBlocks.LYCHEE_POST.get());
        basicBlockItem(ModBlocks.LYCHEE_HEDGE.get(), "_post");
        basicBlockItem(ModBlocks.LYCHEE_VERTICAL_SLAB.get());
        basicBlockItem(ModBlocks.LYCHEE_BEEHIVE.get());
        basicBlockItem(ModBlocks.LYCHEE_CABINET.get());
        basicBlockItem(ModBlocks.LYCHEE_TRAPDOOR.get(), "_bottom");
        fenceBlockItem(ModBlocks.LYCHEE_FENCE.get(), DatagenUtil.LYCHEE_PLANKS);
        buttonBlockItem(ModBlocks.LYCHEE_BUTTON.get(), DatagenUtil.LYCHEE_PLANKS);
        generatedItem(ModItems.LYCHEE.get());
        generatedItem(ModItems.DRIED_LYCHEE.get());
        generatedItem(ModItems.LYCHEE_CAKE_SLICE.get());
        generatedItem(ModItems.LYCHEE_BOAT.get());
        generatedBlockItemWithBlock(ModBlocks.LYCHEE_SAPLING.get());
        generatedBlockItemWithBlock(ModBlocks.LYCHEE_LADDER.get());
        generatedBlockItemWithItem(ModBlocks.LYCHEE_DOOR.get());
        generatedBlockItemWithItem(ModBlocks.LYCHEE_CAKE.get());

        System.out.println("ITEM GENERATION COMPLETE");
    }

    private void basicBlockItem(Block blockForItem) {
        withExistingParent(DatagenUtil.name(blockForItem), DatagenUtil.modBlockLocation(DatagenUtil.name(blockForItem)));
    }

    private void basicBlockItem(Block blockForItem, String sufix) {
        withExistingParent(DatagenUtil.name(blockForItem), DatagenUtil.modBlockLocation(DatagenUtil.name(blockForItem) + sufix));
    }

    private void generatedBlockItemWithItem(Block blockForItem) {
        withExistingParent(DatagenUtil.name(blockForItem), DatagenUtil.GENERATED).texture("layer0", DatagenUtil.modItemLocation(DatagenUtil.name(blockForItem)));
    }

    private void generatedBlockItemWithBlock(Block blockForItem) {
        withExistingParent(DatagenUtil.name(blockForItem), DatagenUtil.GENERATED).texture("layer0", DatagenUtil.modBlockLocation(DatagenUtil.name(blockForItem)));
    }

    private void basicItem(Item item, String type) {
        withExistingParent(DatagenUtil.name(item), type).texture("layer0", DatagenUtil.modItemLocation(DatagenUtil.name(item)));
    }

    private void generatedItem(Item item) {
        basicItem(item, DatagenUtil.GENERATED);
    }

    private void handheldItem(Item item) {
        basicItem(item, DatagenUtil.HANDHELD);
    }

    private void fenceBlockItem(Block blockForItem, String texture) {
        fenceInventory(DatagenUtil.name(blockForItem), DatagenUtil.modBlockLocation(texture));
    }

    private void buttonBlockItem(Block blockForItem, String texture) {
        buttonInventory(DatagenUtil.name(blockForItem), DatagenUtil.modBlockLocation(texture));
    }
}
