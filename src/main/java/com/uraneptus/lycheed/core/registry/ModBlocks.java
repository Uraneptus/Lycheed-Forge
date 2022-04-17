package com.uraneptus.lycheed.core.registry;

import com.mojang.datafixers.util.Pair;
import com.teamabnormals.blueprint.common.block.*;
import com.teamabnormals.blueprint.common.block.chest.BlueprintChestBlock;
import com.teamabnormals.blueprint.common.block.chest.BlueprintTrappedChestBlock;
import com.teamabnormals.blueprint.common.block.sign.BlueprintStandingSignBlock;
import com.teamabnormals.blueprint.common.block.sign.BlueprintWallSignBlock;
import com.teamabnormals.blueprint.common.block.wood.*;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import com.uraneptus.lycheed.LycheedMod;
import com.uraneptus.lycheed.common.blocks.*;
import com.uraneptus.lycheed.core.world.gen.LycheeTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import static com.uraneptus.lycheed.core.registry.ModBlocks.Properties.*;

@Mod.EventBusSubscriber(modid = LycheedMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBlocks {
    public static final BlockSubRegistryHelper HELPER = LycheedMod.REGISTRY_HELPER.getBlockSubHelper();

    public static final RegistryObject<Block> LYCHEE_PLANKS = HELPER.createBlock("lychee_planks", () -> new PlanksBlock(LYCHEE_PLANKS_PROPERTIES), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_LYCHEE_LOG = HELPER.createBlock("stripped_lychee_log", () -> new StrippedLogBlock(LYCHEE_LOG_PROPERTIES), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_LYCHEE_WOOD = HELPER.createBlock("stripped_lychee_wood", () -> new StrippedWoodBlock(LYCHEE_LOG_PROPERTIES), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> LYCHEE_LOG = HELPER.createBlock("lychee_log", () -> new LogBlock(STRIPPED_LYCHEE_LOG, LYCHEE_LOG_PROPERTIES), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> LYCHEE_WOOD = HELPER.createBlock("lychee_wood", () -> new WoodBlock(STRIPPED_LYCHEE_WOOD, LYCHEE_LOG_PROPERTIES), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> LYCHEE_LEAVES = HELPER.createBlock("lychee_leaves", () -> new ModLeavesBlock(LYCHEE_LEAVES_PROPERTIES), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> FRUITFUL_LYCHEE_LEAVES = HELPER.createBlock("fruitful_lychee_leaves", () -> new ModLeavesBlock(LYCHEE_LEAVES_PROPERTIES), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> LYCHEE_SAPLING = HELPER.createBlock("lychee_sapling", () -> new BlueprintSaplingBlock(new LycheeTreeGrower(), LYCHEE_SAPLING_PROPERTIES), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> LYCHEE_BRANCH = HELPER.createBlockNoItem("lychee_branch", () -> new ModBranchBlock(LYCHEE_BRANCH_PROPERTIES));

    public static final RegistryObject<Block> LYCHEE_SLAB = HELPER.createBlock("lychee_slab", () -> new WoodSlabBlock(LYCHEE_PLANKS_PROPERTIES), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> LYCHEE_STAIRS = HELPER.createBlock("lychee_stairs", () -> new WoodStairBlock(LYCHEE_PLANKS.get().defaultBlockState(), LYCHEE_PLANKS_PROPERTIES), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> LYCHEE_DOOR = HELPER.createBlock("lychee_door", () -> new WoodDoorBlock(LYCHEE_DOOR_PROPERTIES), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> LYCHEE_TRAPDOOR = HELPER.createBlock("lychee_trapdoor", () -> new WoodTrapDoorBlock(LYCHEE_DOOR_PROPERTIES), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> LYCHEE_FENCE = HELPER.createFuelBlock("lychee_fence", () -> new WoodFenceBlock(LYCHEE_PLANKS_PROPERTIES), 300, CreativeModeTab.TAB_DECORATIONS);//Needs to be in Minecraft tags to work
    public static final RegistryObject<Block> LYCHEE_FENCE_GATE = HELPER.createFuelBlock("lychee_fence_gate", () -> new WoodFenceGateBlock(LYCHEE_PLANKS_PROPERTIES), 300, CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> LYCHEE_PRESSURE_PLATE = HELPER.createBlock("lychee_pressure_plate", () -> new WoodPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, LYCHEE_PRESSURE_PLATE_PROPERTIES), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> LYCHEE_BUTTON = HELPER.createBlock("lychee_button", () -> new BlueprintWoodButtonBlock(LYCHEE_BUTTON_PROPERTIES), CreativeModeTab.TAB_REDSTONE);
    public static final Pair<RegistryObject<BlueprintStandingSignBlock>, RegistryObject<BlueprintWallSignBlock>> LYCHEE_SIGN = HELPER.createSignBlock("lychee", MaterialColor.COLOR_RED);

    public static final RegistryObject<Block> LYCHEE_CRATE = HELPER.createBlock("lychee_crate", () -> new ModCrateBlock(LYCHEE_CRATE_PROPERTIES), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> LYCHEE_CAKE = HELPER.createBlock("lychee_cake", () -> new ModCakeBlock(LYCHEE_CAKE_PROPERTIES), CreativeModeTab.TAB_FOOD);

    public static final RegistryObject<Block> LYCHEE_LADDER = HELPER.createCompatFuelBlock("quark", "lychee_ladder", () -> new BlueprintLadderBlock(LYCHEE_LADDER_PROPERTIES), 300, CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> LYCHEE_BOOKSHELF = HELPER.createCompatFuelBlock("quark", "lychee_bookshelf", () -> new BookshelfBlock(LYCHEE_BOOKSHELF_PROPERTIES), 300, CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> LYCHEE_LEAVES_CARPET = HELPER.createCompatBlock("quark", "lychee_leaf_carpet", () -> new LeafCarpetBlock(LYCHEE_LEAVES_CARPET_PROPERTIES), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> FRUITFUL_LYCHEE_LEAVES_CARPET = HELPER.createCompatBlock("quark", "fruitful_lychee_leaf_carpet", () -> new LeafCarpetBlock(LYCHEE_LEAVES_CARPET_PROPERTIES), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> STRIPPED_LYCHEE_POST = HELPER.createCompatFuelBlock("quark", "stripped_lychee_post", () -> new WoodPostBlock(LYCHEE_PLANKS_PROPERTIES), 300, CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> LYCHEE_POST = HELPER.createCompatFuelBlock("quark", "lychee_post", () -> new WoodPostBlock(STRIPPED_LYCHEE_POST, LYCHEE_PLANKS_PROPERTIES), 300, CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> LYCHEE_HEDGE = HELPER.createCompatFuelBlock("quark", "lychee_hedge", () -> new HedgeBlock(LYCHEE_PLANKS_PROPERTIES), 300, CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> LYCHEE_VERTICAL_SLAB = HELPER.createCompatFuelBlock("quark", "lychee_vertical_slab", () -> new VerticalSlabBlock(LYCHEE_PLANKS_PROPERTIES), 150, CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final Pair<RegistryObject<BlueprintChestBlock>, RegistryObject<BlueprintTrappedChestBlock>> LYCHEE_CHESTS = HELPER.createCompatChestBlocks("quark", "lychee", MaterialColor.COLOR_RED);

    public static final RegistryObject<Block> LYCHEE_BEEHIVE = HELPER.createCompatBlock("buzzier_bees", "lychee_beehive", () -> new BlueprintBeehiveBlock(LYCHEE_BEEHIVE_PROPERTIES), CreativeModeTab.TAB_DECORATIONS);

    public static final RegistryObject<Block> LYCHEE_CABINET = HELPER.createBlock("lychee_cabinet", () -> !ModList.get().isLoaded("farmersdelight") ? new ModFakeCabinetBlock(LYCHEE_PANTRY_PROPERTIES) : new ModFakeCabinetBlock(LYCHEE_PANTRY_PROPERTIES) /*ModIntegrations.getCabinetBlock(LYCHEE_PANTRY_PROPERTIES)*/, !ModList.get().isLoaded("farmersdelight") ? null : CreativeModeTab.TAB_BUILDING_BLOCKS /*ModIntegrations.getFdItemGroup()*/);


    static class Properties {
        public static final BlockBehaviour.Properties LYCHEE_PLANKS_PROPERTIES = BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).requiresCorrectToolForDrops().strength(2.0F, 3.0F).sound(SoundType.WOOD);//TOOL: AXE
        public static final BlockBehaviour.Properties LYCHEE_LOG_PROPERTIES = BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).strength(2.0F).sound(SoundType.WOOD);
        public static final BlockBehaviour.Properties LYCHEE_DOOR_PROPERTIES = BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).strength(3.0F).sound(SoundType.WOOD).noOcclusion();
        public static final BlockBehaviour.Properties LYCHEE_BUTTON_PROPERTIES = BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).strength(0.5F).sound(SoundType.WOOD).noCollission();
        public static final BlockBehaviour.Properties LYCHEE_PRESSURE_PLATE_PROPERTIES = BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).strength(0.5F).sound(SoundType.WOOD).noCollission();
        public static final BlockBehaviour.Properties LYCHEE_LEAVES_PROPERTIES = BlockBehaviour.Properties.of(Material.LEAVES, MaterialColor.COLOR_GREEN).requiresCorrectToolForDrops().noOcclusion().strength(0.2F).randomTicks().sound(SoundType.GRASS).isValidSpawn(ModBlocks::allowsSpawnOnLeaves).isSuffocating(ModBlocks::isntSolid).isViewBlocking(ModBlocks::isntSolid);//TOOL: HOE
        public static final BlockBehaviour.Properties LYCHEE_BRANCH_PROPERTIES = BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_GREEN).noCollission().noOcclusion().randomTicks().instabreak().sound(SoundType.CROP);
        public static final BlockBehaviour.Properties LYCHEE_CRATE_PROPERTIES = BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).sound(SoundType.WOOD);
        public static final BlockBehaviour.Properties LYCHEE_CAKE_PROPERTIES = BlockBehaviour.Properties.of(Material.CAKE).strength(0.5F).sound(SoundType.WOOL);
        public static final BlockBehaviour.Properties LYCHEE_BEEHIVE_PROPERTIES = BlockBehaviour.Properties.copy(Blocks.BEEHIVE);
        public static final BlockBehaviour.Properties LYCHEE_PANTRY_PROPERTIES = BlockBehaviour.Properties.copy(Blocks.BARREL);
        public static final BlockBehaviour.Properties LYCHEE_LADDER_PROPERTIES = BlockBehaviour.Properties.of(Material.DECORATION).noOcclusion().requiresCorrectToolForDrops().strength(0.4F).sound(SoundType.LADDER);//TOOL: AXE
        public static final BlockBehaviour.Properties LYCHEE_BOOKSHELF_PROPERTIES = BlockBehaviour.Properties.copy(Blocks.BOOKSHELF);
        public static final BlockBehaviour.Properties LYCHEE_LEAVES_CARPET_PROPERTIES = BlockBehaviour.Properties.of(Material.CLOTH_DECORATION, MaterialColor.COLOR_GREEN).instabreak().sound(SoundType.GRASS).requiresCorrectToolForDrops().noOcclusion();//TOOL: HOE
        public static final BlockBehaviour.Properties LYCHEE_SAPLING_PROPERTIES = BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0.0F).sound(SoundType.GRASS);
    }


    public static boolean allowsSpawnOnLeaves(BlockState state, BlockGetter access, BlockPos pos, EntityType<?> entity) {
        return entity == EntityType.OCELOT || entity == EntityType.PARROT;
    }
    public static boolean isntSolid(BlockState state, BlockGetter reader, BlockPos pos) {
        return false;
    }
}