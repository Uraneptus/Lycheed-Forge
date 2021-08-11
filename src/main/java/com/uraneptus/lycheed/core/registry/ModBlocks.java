package com.uraneptus.lycheed.core.registry;

import com.uraneptus.lycheed.LycheedMod;
import com.uraneptus.lycheed.common.blocks.ModLogBlock;
import com.uraneptus.lycheed.common.blocks.ModWoodBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, LycheedMod.MOD_ID);

    public static final AbstractBlock.Properties LYCHEE_PLANKS_PROPERTIES = AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).harvestTool(ToolType.AXE).strength(2.0F, 3.0F).sound(SoundType.WOOD);
    public static final AbstractBlock.Properties LYCHEE_LOG_PROPERTIES = AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).strength(2.0F).sound(SoundType.WOOD);
    public static final AbstractBlock.Properties LYCHEE_DOOR_PROPERTIES = AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).strength(3.0F).sound(SoundType.WOOD);
    public static final AbstractBlock.Properties LYCHEE_BUTTON_PROPERTIES = AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).strength(0.5F).sound(SoundType.WOOD);
    public static final AbstractBlock.Properties LYCHEE_PRESSURE_PLATE_PROPERTIES = AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).strength(0.5F).sound(SoundType.WOOD);





    public static final RegistryObject<Block> LYCHEE_PLANKS = BLOCKS.register("lychee_planks",
        () -> new Block(LYCHEE_PLANKS_PROPERTIES));

    public static final RegistryObject<Block> STRIPPED_LYCHEE_LOG = BLOCKS.register("stripped_lychee_log",
            () -> new RotatedPillarBlock(LYCHEE_LOG_PROPERTIES));

    public static final RegistryObject<Block> STRIPPED_LYCHEE_WOOD = BLOCKS.register("stripped_lychee_wood",
            () -> new RotatedPillarBlock(LYCHEE_LOG_PROPERTIES));

    public static final RegistryObject<Block> LYCHEE_LOG = BLOCKS.register("lychee_log",
            () -> new ModLogBlock(STRIPPED_LYCHEE_LOG, LYCHEE_LOG_PROPERTIES));

    public static final RegistryObject<Block> LYCHEE_WOOD = BLOCKS.register("lychee_wood",
            () -> new ModWoodBlock(STRIPPED_LYCHEE_WOOD, LYCHEE_LOG_PROPERTIES));

    public static final RegistryObject<Block> LYCHEE_SLAB = BLOCKS.register("lychee_slab",
            () -> new SlabBlock(LYCHEE_PLANKS_PROPERTIES));

    public static final RegistryObject<Block> LYCHEE_STAIRS = BLOCKS.register("lychee_stairs",
            () -> new StairsBlock(LYCHEE_PLANKS.get().defaultBlockState(), LYCHEE_PLANKS_PROPERTIES));

    public static final RegistryObject<Block> LYCHEE_DOOR = BLOCKS.register("lychee_door", ///
            () -> new DoorBlock(LYCHEE_DOOR_PROPERTIES));

    public static final RegistryObject<Block> LYCHEE_TRAPDOOR = BLOCKS.register("lychee_trapdoor",
            () -> new TrapDoorBlock(LYCHEE_DOOR_PROPERTIES));

    public static final RegistryObject<Block> LYCHEE_FENCE = BLOCKS.register("lychee_fence",
            () -> new FenceBlock(LYCHEE_PLANKS_PROPERTIES));

    public static final RegistryObject<Block> LYCHEE_FENCE_GATE = BLOCKS.register("lychee_fence_gate",
            () -> new FenceGateBlock(LYCHEE_PLANKS_PROPERTIES));

    public static final RegistryObject<Block> LYCHEE_PRESSURE_PLATE = BLOCKS.register("lychee_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, LYCHEE_PRESSURE_PLATE_PROPERTIES));

    public static final RegistryObject<Block> LYCHEE_BUTTON = BLOCKS.register("lychee_button",
            () -> new WoodButtonBlock(LYCHEE_BUTTON_PROPERTIES));



}
