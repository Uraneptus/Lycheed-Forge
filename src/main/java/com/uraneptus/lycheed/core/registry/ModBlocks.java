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
import com.uraneptus.lycheed.core.ModWoodTypes;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import vectorwing.farmersdelight.blocks.PantryBlock;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, LycheedMod.MOD_ID);
    public static final BlockSubRegistryHelper HELPER = LycheedMod.REGISTRY_HELPER.getBlockSubHelper();


    public static final AbstractBlock.Properties CHINENSIS_PLANKS_PROPERTIES = AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).harvestTool(ToolType.AXE).strength(2.0F, 3.0F).sound(SoundType.WOOD);
    public static final AbstractBlock.Properties CHINENSIS_LOG_PROPERTIES = AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).strength(2.0F).sound(SoundType.WOOD);
    public static final AbstractBlock.Properties CHINENSIS_DOOR_PROPERTIES = AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).strength(3.0F).sound(SoundType.WOOD).noOcclusion();
    public static final AbstractBlock.Properties CHINENSIS_BUTTON_PROPERTIES = AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).strength(0.5F).sound(SoundType.WOOD).noCollission();
    public static final AbstractBlock.Properties CHINENSIS_PRESSURE_PLATE_PROPERTIES = AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).strength(0.5F).sound(SoundType.WOOD).noCollission();
    public static final AbstractBlock.Properties CHINENSIS_SIGN_PROPERTIES = AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).strength(2.0F).sound(SoundType.WOOD).noCollission().noOcclusion();
    public static final AbstractBlock.Properties CHINENSIS_LEAVES_PROPERTIES = AbstractBlock.Properties.of(Material.LEAVES, MaterialColor.COLOR_GREEN).harvestTool(ToolType.HOE).noOcclusion().strength(0.2F).randomTicks().sound(SoundType.GRASS).isValidSpawn(ModBlocks::allowsSpawnOnLeaves).isSuffocating(ModBlocks::isntSolid).isViewBlocking(ModBlocks::isntSolid);
    public static final AbstractBlock.Properties CHINENSIS_BRANCH_PROPERTIES = AbstractBlock.Properties.of(Material.PLANT, MaterialColor.COLOR_GREEN).noCollission().noOcclusion().randomTicks().instabreak().sound(SoundType.CROP);
    public static final AbstractBlock.Properties LYCHEE_BASKET_PROPERTIES = AbstractBlock.Properties.of(Material.WOOL, MaterialColor.COLOR_RED);
    public static final AbstractBlock.Properties LYCHEE_CAKE_PROPERTIES = AbstractBlock.Properties.of(Material.CAKE).strength(0.5F).sound(SoundType.WOOL);
    public static final AbstractBlock.Properties CHINENSIS_BEEHIVE_PROPERTIES = AbstractBlock.Properties.copy(Blocks.BEEHIVE);
    public static final AbstractBlock.Properties CHINENSIS_PANTRY_PROPERTIES = AbstractBlock.Properties.copy(Blocks.BARREL);
    public static final AbstractBlock.Properties CHINENSIS_LADDER_PROPERTIES = AbstractBlock.Properties.of(Material.DECORATION).noOcclusion().harvestTool(ToolType.AXE).strength(0.4F).sound(SoundType.LADDER);
    public static final AbstractBlock.Properties CHINENSIS_BOOKSHELF_PROPERTIES = AbstractBlock.Properties.copy(Blocks.BOOKSHELF);
    public static final AbstractBlock.Properties CHINENSIS_LEAVES_CARPET_PROPERTIES = AbstractBlock.Properties.of(Material.CLOTH_DECORATION, MaterialColor.COLOR_GREEN).instabreak().sound(SoundType.GRASS).harvestTool(ToolType.HOE).noOcclusion();


    public static final RegistryObject<Block> CHINENSIS_PLANKS = HELPER.createBlock("chinensis_planks",
        () -> new PlanksBlock(CHINENSIS_PLANKS_PROPERTIES), ItemGroup.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> STRIPPED_CHINENSIS_LOG = HELPER.createBlock("stripped_chinensis_log",
            () -> new StrippedLogBlock(CHINENSIS_LOG_PROPERTIES), ItemGroup.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> STRIPPED_CHINENSIS_WOOD = HELPER.createBlock("stripped_chinensis_wood",
            () -> new StrippedWoodBlock(CHINENSIS_LOG_PROPERTIES), ItemGroup.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> CHINENSIS_LOG = HELPER.createBlock("chinensis_log",
            () -> new AbnormalsLogBlock(STRIPPED_CHINENSIS_LOG, CHINENSIS_LOG_PROPERTIES), ItemGroup.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> CHINENSIS_WOOD = HELPER.createBlock("chinensis_wood",
            () -> new WoodBlock(STRIPPED_CHINENSIS_WOOD, CHINENSIS_LOG_PROPERTIES), ItemGroup.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> CHINENSIS_SLAB = HELPER.createBlock("chinensis_slab",
            () -> new WoodSlabBlock(CHINENSIS_PLANKS_PROPERTIES), ItemGroup.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> CHINENSIS_STAIRS = HELPER.createBlock("chinensis_stairs",
            () -> new WoodStairsBlock(CHINENSIS_PLANKS.get().defaultBlockState(), CHINENSIS_PLANKS_PROPERTIES), ItemGroup.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> CHINENSIS_DOOR = HELPER.createBlock("chinensis_door",
            () -> new WoodDoorBlock(CHINENSIS_DOOR_PROPERTIES), ItemGroup.TAB_REDSTONE);

    public static final RegistryObject<Block> CHINENSIS_TRAPDOOR = HELPER.createBlock("chinensis_trapdoor",
            () -> new WoodTrapDoorBlock(CHINENSIS_DOOR_PROPERTIES), ItemGroup.TAB_REDSTONE);

    public static final RegistryObject<Block> CHINENSIS_FENCE = HELPER.createFuelBlock("chinensis_fence", //Needs to be in Minecraft tags to work
            () -> new WoodFenceBlock(CHINENSIS_PLANKS_PROPERTIES), 300, ItemGroup.TAB_DECORATIONS);

    public static final RegistryObject<Block> CHINENSIS_FENCE_GATE = HELPER.createFuelBlock("chinensis_fence_gate",
            () -> new WoodFenceGateBlock(CHINENSIS_PLANKS_PROPERTIES), 300, ItemGroup.TAB_DECORATIONS);

    public static final RegistryObject<Block> CHINENSIS_PRESSURE_PLATE = HELPER.createBlock("chinensis_pressure_plate",
            () -> new WoodPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, CHINENSIS_PRESSURE_PLATE_PROPERTIES), ItemGroup.TAB_REDSTONE);

    public static final RegistryObject<Block> CHINENSIS_BUTTON = HELPER.createBlock("chinensis_button",
            () -> new AbnormalsWoodButtonBlock(CHINENSIS_BUTTON_PROPERTIES), ItemGroup.TAB_REDSTONE);

    public static final Pair<RegistryObject<AbnormalsStandingSignBlock>, RegistryObject<AbnormalsWallSignBlock>>
            CHINENSIS_SIGN = HELPER.createSignBlock("chinensis", MaterialColor.COLOR_RED);

    public static final RegistryObject<Block> CHINENSIS_LEAVES = HELPER.createBlock("chinensis_leaves",
            () -> new ModLeavesBlock(CHINENSIS_LEAVES_PROPERTIES), ItemGroup.TAB_DECORATIONS);

    public static final RegistryObject<Block> FRUITFUL_CHINENSIS_LEAVES = HELPER.createBlock("fruitful_chinensis_leaves",
            () -> new ModLeavesBlock(CHINENSIS_LEAVES_PROPERTIES), ItemGroup.TAB_DECORATIONS);

    public static final RegistryObject<Block> CHINENSIS_BRANCH = BLOCKS.register("chinensis_branch",
            () -> new ModBranchBlock(CHINENSIS_BRANCH_PROPERTIES));

    public static final RegistryObject<Block> LYCHEE_BASKET = HELPER.createBlock("lychee_basket",
            () -> new Block(LYCHEE_BASKET_PROPERTIES), ItemGroup.TAB_DECORATIONS);

    public static final RegistryObject<Block> LYCHEE_CAKE = BLOCKS.register("lychee_cake",
            () -> new ModCakeBlock(LYCHEE_CAKE_PROPERTIES));

    public static final RegistryObject<Block> CHINENSIS_BEEHIVE = HELPER.createCompatBlock("buzzier_bees", "chinensis_beehive",
            () -> new AbnormalsBeehiveBlock(CHINENSIS_BEEHIVE_PROPERTIES), ItemGroup.TAB_DECORATIONS);

    public static final RegistryObject<Block> CHINENSIS_PANTRY = BLOCKS.register("chinensis_pantry",
            () -> !ModList.get().isLoaded("farmersdelight") ? new Block(CHINENSIS_PANTRY_PROPERTIES) : ModIntegrations.getPantryBlock(CHINENSIS_PANTRY_PROPERTIES));

    public static final RegistryObject<Block> CHINENSIS_LADDER = HELPER.createCompatFuelBlock("quark", "chinensis_ladder",
            () -> new AbnormalsLadderBlock(CHINENSIS_LADDER_PROPERTIES), 300, ItemGroup.TAB_DECORATIONS);

    public static final RegistryObject<Block> CHINENSIS_BOOKSHELF = HELPER.createCompatFuelBlock("quark", "chinensis_bookshelf",
            () -> new BookshelfBlock(CHINENSIS_BOOKSHELF_PROPERTIES), 300, ItemGroup.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> VERTICAL_CHINENSIS_PLANKS = HELPER.createCompatBlock("quark", "vertical_chinensis_planks",
            () -> new Block(CHINENSIS_PLANKS_PROPERTIES), ItemGroup.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> CHINENSIS_LEAVES_CARPET = HELPER.createCompatBlock("quark", "chinensis_leaf_carpet",
            () -> new LeafCarpetBlock(CHINENSIS_LEAVES_CARPET_PROPERTIES), ItemGroup.TAB_DECORATIONS);

    public static final RegistryObject<Block> FRUITFUL_CHINENSIS_LEAVES_CARPET = HELPER.createCompatBlock("quark", "fruitful_chinensis_leaf_carpet",
            () -> new LeafCarpetBlock(CHINENSIS_LEAVES_CARPET_PROPERTIES), ItemGroup.TAB_DECORATIONS);

    public static final RegistryObject<Block> STRIPPED_CHINENSIS_POST = HELPER.createCompatFuelBlock("quark", "stripped_chinensis_post",
            () -> new WoodPostBlock(CHINENSIS_PLANKS_PROPERTIES), 300, ItemGroup.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> CHINENSIS_POST = HELPER.createCompatFuelBlock("quark", "chinensis_post",
            () -> new WoodPostBlock(STRIPPED_CHINENSIS_POST, CHINENSIS_PLANKS_PROPERTIES), 300, ItemGroup.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> CHINENSIS_HEDGE = HELPER.createCompatFuelBlock("quark", "chinensis_hedge",
            () -> new HedgeBlock(CHINENSIS_PLANKS_PROPERTIES), 300, ItemGroup.TAB_DECORATIONS);

    public static final RegistryObject<Block> CHINENSIS_VERTICAL_SLAB = HELPER.createCompatFuelBlock("quark", "chinensis_vertical_slab",
            () -> new VerticalSlabBlock(CHINENSIS_PLANKS_PROPERTIES), 150, ItemGroup.TAB_BUILDING_BLOCKS);

    public static final Pair<RegistryObject<AbnormalsChestBlock>,
            RegistryObject<AbnormalsTrappedChestBlock>> CHINENSIS_CHESTS = HELPER.createCompatChestBlocks("quark", "chinensis", MaterialColor.COLOR_RED);






    public static boolean allowsSpawnOnLeaves(BlockState state, IBlockReader access, BlockPos pos, EntityType<?> entity) {
        return entity == EntityType.OCELOT || entity == EntityType.PARROT;
    }
    public static boolean isntSolid(BlockState state, IBlockReader reader, BlockPos pos) {
        return false;
    }




}
