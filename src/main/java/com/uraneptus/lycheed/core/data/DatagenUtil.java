package com.uraneptus.lycheed.core.data;

import com.uraneptus.lycheed.LycheedMod;
import com.uraneptus.lycheed.core.data.client.BlockStates;
import com.uraneptus.lycheed.core.registry.ModBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelProvider;

public class DatagenUtil {
    public static final String GENERATED = "item/generated";
    public static final String HANDHELD = "item/handheld";

    public static String name(Block block) {
        return block.getRegistryName().getPath();
    }

    public static String name(Item item) {
        return item.getRegistryName().getPath();
    }

    public static ResourceLocation modBlockLocation(String path) {
        return new ResourceLocation(LycheedMod.MOD_ID, ModelProvider.BLOCK_FOLDER + "/" + path);
    }

    public static ResourceLocation modItemLocation(String path) {
        return new ResourceLocation(LycheedMod.MOD_ID, ModelProvider.ITEM_FOLDER + "/" + path);
    }

    public static ResourceLocation vanillaBlockLocation(String path) {
        return new ResourceLocation("minecraft", ModelProvider.BLOCK_FOLDER + "/" + path);
    }

    public static ResourceLocation vanillaItemLocation(String path) {
        return new ResourceLocation("minecraft", ModelProvider.ITEM_FOLDER + "/" + path);
    }

    //Textures
    public static final String LYCHEE_PLANKS = name(ModBlocks.LYCHEE_PLANKS.get());
    public static final String LYCHEE_LOG = name(ModBlocks.LYCHEE_LOG.get());
    public static final String STRIPPED_LYCHEE_LOG = name(ModBlocks.STRIPPED_LYCHEE_LOG.get());

}
