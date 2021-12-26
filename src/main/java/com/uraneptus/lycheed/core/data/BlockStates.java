package com.uraneptus.lycheed.core.data;

import com.uraneptus.lycheed.LycheedMod;
import com.uraneptus.lycheed.common.blocks.ModBranchBlock;
import com.uraneptus.lycheed.core.registry.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockStates extends BlockStateProvider {

    public BlockStates(DataGenerator gen, ExistingFileHelper fileHelper) {
        super(gen, LycheedMod.MOD_ID, fileHelper);
    }

    private String name(Block block) {
        return block.getRegistryName().getPath();
    }

    public ResourceLocation location(String path) {
        return new ResourceLocation(LycheedMod.MOD_ID, ModelProvider.BLOCK_FOLDER + "/" + path);
    }

    @Override
    protected void registerStatesAndModels() {
        basicBlock(ModBlocks.LYCHEE_PLANKS.get());
        modLogBlock(ModBlocks.LYCHEE_LOG.get());
        modLogBlock(ModBlocks.STRIPPED_LYCHEE_LOG.get());
        modWoodBlock(ModBlocks.LYCHEE_WOOD.get(), name(ModBlocks.LYCHEE_LOG.get()));
        modWoodBlock(ModBlocks.STRIPPED_LYCHEE_WOOD.get(), name(ModBlocks.STRIPPED_LYCHEE_LOG.get()));
        modLeavesBlock(ModBlocks.LYCHEE_LEAVES.get());
        modLeavesBlock(ModBlocks.FRUITFUL_LYCHEE_LEAVES.get());
        modCrossBlock(ModBlocks.LYCHEE_SAPLING.get());
        modSlabBlock(ModBlocks.LYCHEE_SLAB.get(), name(ModBlocks.LYCHEE_PLANKS.get()));
        modStairsBlock(ModBlocks.LYCHEE_STAIRS.get(), name(ModBlocks.LYCHEE_PLANKS.get()));
        modDoorBlock(ModBlocks.LYCHEE_DOOR.get());
        modTrapdoorBlock(ModBlocks.LYCHEE_TRAPDOOR.get());

        System.out.println("BLOCK GENERATION COMPLETE");
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

    public void modLeavesBlock(Block block) {
        simpleBlock(block, models().withExistingParent(name(block), new ResourceLocation("block/leaves")).texture("all", location(name(block))));
    }

    public void modCrossBlock(Block block) {
        getVariantBuilder(block).forAllStates(blockState -> ConfiguredModel.builder().modelFile(models().withExistingParent(name(block),
                new ResourceLocation("block/cross")).texture("cross", location(name(block)))).build());
    }

    public void modSlabBlock(Block block, String texture) {
        slabBlock((SlabBlock) block, location(texture), location(texture));
    }

    public void modStairsBlock(Block block, String texture) {
        stairsBlock((StairBlock) block, location(texture));
    }

    public void modDoorBlock(Block block) {
        doorBlock((DoorBlock) block, location(name(block) + "_bottom"), location(name(block) + "_top"));
    }

    public void modTrapdoorBlock(Block block) {
        trapdoorBlock((TrapDoorBlock) block, location(name(block)), true);
    }

    public void modFenceBlock(Block block) {
        fenceBlock((FenceBlock) block, location(name(block)));
    }
}
