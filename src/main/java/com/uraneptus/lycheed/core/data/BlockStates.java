package com.uraneptus.lycheed.core.data;

import com.uraneptus.lycheed.LycheedMod;
import com.uraneptus.lycheed.core.registry.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockStates extends BlockStateProvider {

    public BlockStates(DataGenerator gen, ExistingFileHelper fileHelper) {
        super(gen, LycheedMod.MOD_ID, fileHelper);
    }

    private String name(Block block) {
        return block.getRegistryName().getPath();
    }

    public ResourceLocation location(String path) {
        return new ResourceLocation(LycheedMod.MOD_ID, "block/" + path);
    }

    @Override
    protected void registerStatesAndModels() {
        basicBlock(ModBlocks.LYCHEE_PLANKS.get());
        modLogBlock(ModBlocks.LYCHEE_LOG.get());
        modLogBlock(ModBlocks.STRIPPED_LYCHEE_LOG.get());
        modWoodBlock(ModBlocks.LYCHEE_WOOD.get(), "lychee_log");
        modWoodBlock(ModBlocks.STRIPPED_LYCHEE_WOOD.get(), "stripped_lychee_log");

        System.out.println("GENERATION ENDED");
    }


    public void basicBlock(Block block) {
        simpleBlock(block);
    }

    public void modLogBlock(Block block) {
        logBlock((RotatedPillarBlock) block);
    }

    public void modAxisBlock(RotatedPillarBlock block, ResourceLocation side, ResourceLocation end) {
        axisBlock(block, models().cubeColumn(name(block), side, end), models().cubeColumn(name(block), side, end));
    }

    public void modWoodBlock(Block block, String texture) {
        modAxisBlock((RotatedPillarBlock) block, location(texture), location(texture));
    }
}
