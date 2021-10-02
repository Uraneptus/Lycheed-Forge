package com.uraneptus.lycheed.core.registry;

import com.minecraftabnormals.abnormals_core.common.blocks.*;
import com.minecraftabnormals.abnormals_core.common.blocks.chest.AbnormalsChestBlock;
import com.minecraftabnormals.abnormals_core.common.blocks.chest.AbnormalsTrappedChestBlock;
import com.minecraftabnormals.abnormals_core.common.blocks.sign.AbnormalsStandingSignBlock;
import com.minecraftabnormals.abnormals_core.common.blocks.sign.AbnormalsWallSignBlock;
import com.minecraftabnormals.abnormals_core.common.blocks.wood.*;
import com.minecraftabnormals.abnormals_core.core.util.registry.BlockSubRegistryHelper;
import com.mojang.datafixers.util.Pair;
import com.uraneptus.lycheed.LycheedMod;
import com.uraneptus.lycheed.ModIntegrations;
import com.uraneptus.lycheed.common.blocks.*;
import com.uraneptus.lycheed.core.world.gen.feature.LycheeTree;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import vectorwing.farmersdelight.FarmersDelight;

@Mod.EventBusSubscriber(modid = LycheedMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBlocks {
    public static final BlockSubRegistryHelper HELPER = LycheedMod.REGISTRY_HELPER.getBlockSubHelper();


    public static final AbstractBlock.Properties LYCHEE_PLANKS_PROPERTIES = AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).harvestTool(ToolType.AXE).strength(2.0F, 3.0F).sound(SoundType.WOOD);
    public static final AbstractBlock.Properties LYCHEE_LOG_PROPERTIES = AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).strength(2.0F).sound(SoundType.WOOD);
    public static final AbstractBlock.Properties LYCHEE_DOOR_PROPERTIES = AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).strength(3.0F).sound(SoundType.WOOD).noOcclusion();
    public static final AbstractBlock.Properties LYCHEE_BUTTON_PROPERTIES = AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).strength(0.5F).sound(SoundType.WOOD).noCollission();
    public static final AbstractBlock.Properties LYCHEE_PRESSURE_PLATE_PROPERTIES = AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).strength(0.5F).sound(SoundType.WOOD).noCollission();
    public static final AbstractBlock.Properties LYCHEE_LEAVES_PROPERTIES = AbstractBlock.Properties.of(Material.LEAVES, MaterialColor.COLOR_GREEN).harvestTool(ToolType.HOE).noOcclusion().strength(0.2F).randomTicks().sound(SoundType.GRASS).isValidSpawn(ModBlocks::allowsSpawnOnLeaves).isSuffocating(ModBlocks::isntSolid).isViewBlocking(ModBlocks::isntSolid);
    public static final AbstractBlock.Properties LYCHEE_BRANCH_PROPERTIES = AbstractBlock.Properties.of(Material.PLANT, MaterialColor.COLOR_GREEN).noCollission().noOcclusion().randomTicks().instabreak().sound(SoundType.CROP);
    public static final AbstractBlock.Properties LYCHEE_BASKET_PROPERTIES = AbstractBlock.Properties.of(Material.WOOL, MaterialColor.COLOR_RED);
    public static final AbstractBlock.Properties LYCHEE_CAKE_PROPERTIES = AbstractBlock.Properties.of(Material.CAKE).strength(0.5F).sound(SoundType.WOOL);
    public static final AbstractBlock.Properties LYCHEE_BEEHIVE_PROPERTIES = AbstractBlock.Properties.copy(Blocks.BEEHIVE);
    public static final AbstractBlock.Properties LYCHEE_PANTRY_PROPERTIES = AbstractBlock.Properties.copy(Blocks.BARREL);
    public static final AbstractBlock.Properties LYCHEE_LADDER_PROPERTIES = AbstractBlock.Properties.of(Material.DECORATION).noOcclusion().harvestTool(ToolType.AXE).strength(0.4F).sound(SoundType.LADDER);
    public static final AbstractBlock.Properties LYCHEE_BOOKSHELF_PROPERTIES = AbstractBlock.Properties.copy(Blocks.BOOKSHELF);
    public static final AbstractBlock.Properties LYCHEE_LEAVES_CARPET_PROPERTIES = AbstractBlock.Properties.of(Material.CLOTH_DECORATION, MaterialColor.COLOR_GREEN).instabreak().sound(SoundType.GRASS).harvestTool(ToolType.HOE).noOcclusion();
    public static final AbstractBlock.Properties LYCHEE_SAPLING_PROPERTIES = AbstractBlock.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0.0F).sound(SoundType.GRASS);


    public static final RegistryObject<Block> LYCHEE_PLANKS = HELPER.createBlock("lychee_planks",
            () -> new PlanksBlock(LYCHEE_PLANKS_PROPERTIES), ItemGroup.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> STRIPPED_LYCHEE_LOG = HELPER.createBlock("stripped_lychee_log",
            () -> new StrippedLogBlock(LYCHEE_LOG_PROPERTIES), ItemGroup.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> STRIPPED_LYCHEE_WOOD = HELPER.createBlock("stripped_lychee_wood",
            () -> new StrippedWoodBlock(LYCHEE_LOG_PROPERTIES), ItemGroup.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> LYCHEE_LOG = HELPER.createBlock("lychee_log",
            () -> new AbnormalsLogBlock(STRIPPED_LYCHEE_LOG, LYCHEE_LOG_PROPERTIES), ItemGroup.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> LYCHEE_WOOD = HELPER.createBlock("lychee_wood",
            () -> new WoodBlock(STRIPPED_LYCHEE_WOOD, LYCHEE_LOG_PROPERTIES), ItemGroup.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> LYCHEE_SLAB = HELPER.createBlock("lychee_slab",
            () -> new WoodSlabBlock(LYCHEE_PLANKS_PROPERTIES), ItemGroup.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> LYCHEE_STAIRS = HELPER.createBlock("lychee_stairs",
            () -> new WoodStairsBlock(LYCHEE_PLANKS.get().defaultBlockState(), LYCHEE_PLANKS_PROPERTIES), ItemGroup.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> LYCHEE_DOOR = HELPER.createBlock("lychee_door",
            () -> new WoodDoorBlock(LYCHEE_DOOR_PROPERTIES), ItemGroup.TAB_REDSTONE);

    public static final RegistryObject<Block> LYCHEE_TRAPDOOR = HELPER.createBlock("lychee_trapdoor",
            () -> new WoodTrapDoorBlock(LYCHEE_DOOR_PROPERTIES), ItemGroup.TAB_REDSTONE);

    public static final RegistryObject<Block> LYCHEE_FENCE = HELPER.createFuelBlock("lychee_fence", //Needs to be in Minecraft tags to work
            () -> new WoodFenceBlock(LYCHEE_PLANKS_PROPERTIES), 300, ItemGroup.TAB_DECORATIONS);

    public static final RegistryObject<Block> LYCHEE_FENCE_GATE = HELPER.createFuelBlock("lychee_fence_gate",
            () -> new WoodFenceGateBlock(LYCHEE_PLANKS_PROPERTIES), 300, ItemGroup.TAB_REDSTONE);

    public static final RegistryObject<Block> LYCHEE_PRESSURE_PLATE = HELPER.createBlock("lychee_pressure_plate",
            () -> new WoodPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, LYCHEE_PRESSURE_PLATE_PROPERTIES), ItemGroup.TAB_REDSTONE);

    public static final RegistryObject<Block> LYCHEE_BUTTON = HELPER.createBlock("lychee_button",
            () -> new AbnormalsWoodButtonBlock(LYCHEE_BUTTON_PROPERTIES), ItemGroup.TAB_REDSTONE);

    public static final Pair<RegistryObject<AbnormalsStandingSignBlock>, RegistryObject<AbnormalsWallSignBlock>>
            LYCHEE_SIGN = HELPER.createSignBlock("lychee", MaterialColor.COLOR_RED);

    public static final RegistryObject<Block> LYCHEE_LEAVES = HELPER.createBlock("lychee_leaves",
            () -> new ModLeavesBlock(LYCHEE_LEAVES_PROPERTIES), ItemGroup.TAB_DECORATIONS);

    public static final RegistryObject<Block> FRUITFUL_LYCHEE_LEAVES = HELPER.createBlock("fruitful_lychee_leaves",
            () -> new ModLeavesBlock(LYCHEE_LEAVES_PROPERTIES), ItemGroup.TAB_DECORATIONS);

    public static final RegistryObject<Block> LYCHEE_BRANCH = HELPER.createBlockNoItem("lychee_branch",
            () -> new ModBranchBlock(LYCHEE_BRANCH_PROPERTIES));

    public static final RegistryObject<Block> LYCHEE_BASKET = HELPER.createBlock("lychee_basket",
            () -> new Block(LYCHEE_BASKET_PROPERTIES), ItemGroup.TAB_DECORATIONS);

    public static final RegistryObject<Block> LYCHEE_CAKE = HELPER.createBlock("lychee_cake",
            () -> new ModCakeBlock(LYCHEE_CAKE_PROPERTIES), ItemGroup.TAB_FOOD);

    public static final RegistryObject<Block> LYCHEE_BEEHIVE = HELPER.createCompatBlock("buzzier_bees", "lychee_beehive",
            () -> new AbnormalsBeehiveBlock(LYCHEE_BEEHIVE_PROPERTIES), ItemGroup.TAB_DECORATIONS);

    public static final RegistryObject<Block> LYCHEE_PANTRY = HELPER.createBlock("lychee_pantry",
            () -> !ModList.get().isLoaded("farmersdelight") ? new ModFakePantryBlock(LYCHEE_PANTRY_PROPERTIES) : ModIntegrations.getPantryBlock(LYCHEE_PANTRY_PROPERTIES), !ModList.get().isLoaded("farmersdelight") ? null : ModIntegrations.getFdItemGroup());

    public static final RegistryObject<Block> LYCHEE_LADDER = HELPER.createCompatFuelBlock("quark", "lychee_ladder",
            () -> new AbnormalsLadderBlock(LYCHEE_LADDER_PROPERTIES), 300, ItemGroup.TAB_DECORATIONS);

    public static final RegistryObject<Block> LYCHEE_BOOKSHELF = HELPER.createCompatFuelBlock("quark", "lychee_bookshelf",
            () -> new BookshelfBlock(LYCHEE_BOOKSHELF_PROPERTIES), 300, ItemGroup.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> VERTICAL_LYCHEE_PLANKS = HELPER.createCompatBlock("quark", "vertical_lychee_planks",
            () -> new Block(LYCHEE_PLANKS_PROPERTIES), ItemGroup.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> LYCHEE_LEAVES_CARPET = HELPER.createCompatBlock("quark", "lychee_leaf_carpet",
            () -> new LeafCarpetBlock(LYCHEE_LEAVES_CARPET_PROPERTIES), ItemGroup.TAB_DECORATIONS);

    public static final RegistryObject<Block> FRUITFUL_LYCHEE_LEAVES_CARPET = HELPER.createCompatBlock("quark", "fruitful_lychee_leaf_carpet",
            () -> new LeafCarpetBlock(LYCHEE_LEAVES_CARPET_PROPERTIES), ItemGroup.TAB_DECORATIONS);

    public static final RegistryObject<Block> STRIPPED_LYCHEE_POST = HELPER.createCompatFuelBlock("quark", "stripped_lychee_post",
            () -> new WoodPostBlock(LYCHEE_PLANKS_PROPERTIES), 300, ItemGroup.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> LYCHEE_POST = HELPER.createCompatFuelBlock("quark", "lychee_post",
            () -> new WoodPostBlock(STRIPPED_LYCHEE_POST, LYCHEE_PLANKS_PROPERTIES), 300, ItemGroup.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> LYCHEE_HEDGE = HELPER.createCompatFuelBlock("quark", "lychee_hedge",
            () -> new HedgeBlock(LYCHEE_PLANKS_PROPERTIES), 300, ItemGroup.TAB_DECORATIONS);

    public static final RegistryObject<Block> LYCHEE_VERTICAL_SLAB = HELPER.createCompatFuelBlock("quark", "lychee_vertical_slab",
            () -> new VerticalSlabBlock(LYCHEE_PLANKS_PROPERTIES), 150, ItemGroup.TAB_BUILDING_BLOCKS);

    public static final Pair<RegistryObject<AbnormalsChestBlock>,
            RegistryObject<AbnormalsTrappedChestBlock>> LYCHEE_CHESTS = HELPER.createCompatChestBlocks("quark", "lychee", MaterialColor.COLOR_RED);

    public static boolean allowsSpawnOnLeaves(BlockState state, IBlockReader access, BlockPos pos, EntityType<?> entity) {
        return entity == EntityType.OCELOT || entity == EntityType.PARROT;
    }
    public static boolean isntSolid(BlockState state, IBlockReader reader, BlockPos pos) {
        return false;
    }
}