package com.uraneptus.lycheed.core.data;

import com.uraneptus.lycheed.LycheedMod;
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
        generatedItem(ModItems.LYCHEE.get());
        generatedItem(ModItems.DRIED_LYCHEE.get());
        generatedItem(ModItems.LYCHEE_CAKE_SLICE.get());
        generatedItem(ModItems.LYCHEE_BOAT.get());

        System.out.println("ITEM GENERATION COMPLETE");
    }

    private String name(Block block) {
        return block.getRegistryName().getPath();
    }

    private String name(Item item) {
        return item.getRegistryName().getPath();
    }

    public ResourceLocation blockLocation(String path) {
        return new ResourceLocation(LycheedMod.MOD_ID, ModelProvider.BLOCK_FOLDER + "/" + path);
    }

    public ResourceLocation itemLocation(String path) {
        return new ResourceLocation(LycheedMod.MOD_ID, ModelProvider.ITEM_FOLDER + "/" + path);
    }

    private void basicBlockItem(Block blockForItem) {
        withExistingParent(name(blockForItem), blockLocation(name(blockForItem)));
    }

    private void basicItem(Item item, String type) {
        withExistingParent(name(item), type).texture("layer0", itemLocation(name(item)));
    }

    private void generatedItem(Item item) {
        basicItem(item, "item/generated");
    }

    private void handheldItem(Item item) {
        basicItem(item, "item/handheld");
    }
}
