package com.uraneptus.lycheed.core.registry;

import com.uraneptus.lycheed.LycheedMod;
import com.uraneptus.lycheed.common.blocks.ModLogBlock;
import com.uraneptus.lycheed.common.blocks.ModWoodBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, LycheedMod.MOD_ID);

    public static AbstractBlock.Properties LYCHEE_WOOD_PROPERTIES() {
        return AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).harvestTool(ToolType.AXE).strength(2.0F, 3.0F).sound(SoundType.WOOD);
    }


    public static final RegistryObject<Block> LYCHEE_PLANKS = BLOCKS.register("lychee_planks",
        () -> new Block(LYCHEE_WOOD_PROPERTIES()));

    public static final RegistryObject<Block> STRIPPED_LYCHEE_LOG = BLOCKS.register("stripped_lychee_log",
            () -> new RotatedPillarBlock(LYCHEE_WOOD_PROPERTIES()));

    public static final RegistryObject<Block> STRIPPED_LYCHEE_WOOD = BLOCKS.register("stripped_lychee_wood",
            () -> new RotatedPillarBlock(LYCHEE_WOOD_PROPERTIES()));

    public static final RegistryObject<Block> LYCHEE_LOG = BLOCKS.register("lychee_log",
            () -> new ModLogBlock(STRIPPED_LYCHEE_LOG, LYCHEE_WOOD_PROPERTIES()));

    public static final RegistryObject<Block> LYCHEE_WOOD = BLOCKS.register("lychee_wood",
            () -> new ModWoodBlock(STRIPPED_LYCHEE_WOOD, LYCHEE_WOOD_PROPERTIES()));



}
