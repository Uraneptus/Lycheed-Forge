package com.uraneptus.lycheed.core.data.client;

import com.uraneptus.lycheed.LycheedMod;
import com.uraneptus.lycheed.common.blocks.ModFakeCabinetBlock;
import com.uraneptus.lycheed.core.data.DatagenUtil;
import com.uraneptus.lycheed.core.registry.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockStates extends BlockStateProvider {

    public BlockStates(DataGenerator gen, ExistingFileHelper fileHelper) {
        super(gen, LycheedMod.MOD_ID, fileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        basicBlock(ModBlocks.LYCHEE_PLANKS.get());
        modLogBlock(ModBlocks.LYCHEE_LOG.get());
        modLogBlock(ModBlocks.STRIPPED_LYCHEE_LOG.get());
        modWoodBlock(ModBlocks.LYCHEE_WOOD.get(), DatagenUtil.LYCHEE_LOG);
        modWoodBlock(ModBlocks.STRIPPED_LYCHEE_WOOD.get(), DatagenUtil.STRIPPED_LYCHEE_LOG);
        modLeavesBlock(ModBlocks.LYCHEE_LEAVES.get());
        modLeavesBlock(ModBlocks.FRUITFUL_LYCHEE_LEAVES.get());
        modCrossBlock(ModBlocks.LYCHEE_SAPLING.get());
        modSlabBlock(ModBlocks.LYCHEE_SLAB.get(), DatagenUtil.LYCHEE_PLANKS);
        modStairsBlock(ModBlocks.LYCHEE_STAIRS.get(), DatagenUtil.LYCHEE_PLANKS);
        modDoorBlock(ModBlocks.LYCHEE_DOOR.get());
        modTrapdoorBlock(ModBlocks.LYCHEE_TRAPDOOR.get());
        modFenceBlock(ModBlocks.LYCHEE_FENCE.get(), DatagenUtil.LYCHEE_PLANKS);
        modFenceGateBlock(ModBlocks.LYCHEE_FENCE_GATE.get(), DatagenUtil.LYCHEE_PLANKS);
        modPressurePlateBlock(ModBlocks.LYCHEE_PRESSURE_PLATE.get(), DatagenUtil.LYCHEE_PLANKS);
        modButtonBlock(ModBlocks.LYCHEE_BUTTON.get(), DatagenUtil.LYCHEE_PLANKS);
        basketBlock(ModBlocks.LYCHEE_CRATE.get());
        beehiveBlock(ModBlocks.LYCHEE_BEEHIVE.get());
        cabinetBlock(ModBlocks.LYCHEE_CABINET.get());
        //leaf_carpet(ModBlocks.FRUITFUL_LYCHEE_LEAVES_CARPET.get(), DatagenUtil.FRUITFUL_LYCHEE_LEAVES);

        System.out.println("BLOCK GENERATION COMPLETE");
    }


    public void basicBlock(Block block) {
        simpleBlock(block);
    }

    public void modLogBlock(Block block) {
        logBlock((RotatedPillarBlock) block);
    }

    public void modAxisBlock(RotatedPillarBlock block, ResourceLocation side, ResourceLocation end) {
        axisBlock(block, models().cubeColumn(DatagenUtil.name(block), side, end), models().cubeColumn(DatagenUtil.name(block), side, end));
    }

    public void modWoodBlock(Block block, String texture) {
        modAxisBlock((RotatedPillarBlock) block, DatagenUtil.modBlockLocation(texture), DatagenUtil.modBlockLocation(texture));
    }

    public void modLeavesBlock(Block block) {
        simpleBlock(block, models().withExistingParent(DatagenUtil.name(block), new ResourceLocation("block/leaves")).texture("all", DatagenUtil.modBlockLocation(DatagenUtil.name(block))));
    }

    public void modCrossBlock(Block block) {
        getVariantBuilder(block).forAllStates(blockState -> ConfiguredModel.builder().modelFile(models().withExistingParent(DatagenUtil.name(block),
                new ResourceLocation("block/cross")).texture("cross", DatagenUtil.modBlockLocation(DatagenUtil.name(block)))).build());
    }

    public void modSlabBlock(Block block, String texture) {
        slabBlock((SlabBlock) block, DatagenUtil.modBlockLocation(texture), DatagenUtil.modBlockLocation(texture));
    }

    public void modStairsBlock(Block block, String texture) {
        stairsBlock((StairBlock) block, DatagenUtil.modBlockLocation(texture));
    }

    public void modDoorBlock(Block block) {
        doorBlock((DoorBlock) block, DatagenUtil.modBlockLocation(DatagenUtil.name(block) + "_bottom"), DatagenUtil.modBlockLocation(DatagenUtil.name(block) + "_top"));
    }

    public void modTrapdoorBlock(Block block) {
        trapdoorBlock((TrapDoorBlock) block, DatagenUtil.modBlockLocation(DatagenUtil.name(block)), true);
    }

    public void modFenceBlock(Block block, String texture) {
        fenceBlock((FenceBlock) block, DatagenUtil.modBlockLocation(texture));
    }

    public void modFenceGateBlock(Block block, String texture) {
        fenceGateBlock((FenceGateBlock) block, DatagenUtil.modBlockLocation(texture));
    }

    private void modPressurePlateBlock(Block block, String texture) {
        pressurePlateBlock((PressurePlateBlock) block, DatagenUtil.modBlockLocation(texture));
    }

    private void modButtonBlock(Block block, String texture) {
        buttonBlock((ButtonBlock) block, DatagenUtil.modBlockLocation(texture));
    }

    private void basketBlock(Block block) {
        ModelFile basketModel = models().cubeBottomTop(DatagenUtil.name(block),
                DatagenUtil.modBlockLocation(DatagenUtil.name(block) + "_side"),
                DatagenUtil.modBlockLocation(DatagenUtil.name(block) + "_bottom"),
                DatagenUtil.modBlockLocation(DatagenUtil.name(block) + "_top"));

        getVariantBuilder(block).forAllStates(blockState -> ConfiguredModel.builder().modelFile(basketModel).build());
    }

    private void beehiveBlock(Block block) {
        this.horizontalBlock(block, blockState -> {
            int honeyLevel = blockState.getValue(BlockStateProperties.LEVEL_HONEY);
            String suffix = honeyLevel == 5 ? "_honey" : "";
            return models().orientable(DatagenUtil.name(block) + suffix,
                    DatagenUtil.modBlockLocation(DatagenUtil.name(block) + "_side"),
                    DatagenUtil.modBlockLocation(DatagenUtil.name(block) + "_front" + suffix),
                    DatagenUtil.modBlockLocation(DatagenUtil.name(block) + "_end"));

        });
    }

    private void cabinetBlock(Block block) {
        this.horizontalBlock(block, blockState -> {
            String suffix = blockState.getValue(ModFakeCabinetBlock.OPEN) ? "_open" : "";
            return models().orientable(DatagenUtil.name(block) + suffix,
                    DatagenUtil.modBlockLocation(DatagenUtil.name(block) + "_side"),
                    DatagenUtil.modBlockLocation(DatagenUtil.name(block) + "_front" + suffix),
                    DatagenUtil.modBlockLocation(DatagenUtil.name(block) + "_end"));
        });
    }

    /*private void leaf_carpet(Block block, String texture) {
        //this.cubeAllBP(DatagenUtil.name(block), "leaf_carpet", DatagenUtil.modBlockLocation(DatagenUtil.name(block)));
        this.simpleBlock(block, models().withExistingParent(DatagenUtil.name(block), "blueprint:block/leaf_carpet").texture("all", DatagenUtil.modBlockLocation(texture)));
    }

    public void cubeAllBP(String name, String path, ResourceLocation texture) {
        models().singleTexture(name, DatagenUtil.blueprintBlockLocation(path), "all", texture);
    }*/
}
