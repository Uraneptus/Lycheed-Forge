package com.uraneptus.lycheed.core.registry;

import com.uraneptus.lycheed.LycheedMod;
import com.uraneptus.lycheed.common.blocks.*;
import com.uraneptus.lycheed.core.ModWoodTypes;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, LycheedMod.MOD_ID);

    public static final AbstractBlock.Properties CHINENSIS_PLANKS_PROPERTIES = AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).harvestTool(ToolType.AXE).strength(2.0F, 3.0F).sound(SoundType.WOOD);
    public static final AbstractBlock.Properties CHINENSIS_LOG_PROPERTIES = AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).strength(2.0F).sound(SoundType.WOOD);
    public static final AbstractBlock.Properties CHINENSIS_DOOR_PROPERTIES = AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).strength(3.0F).sound(SoundType.WOOD).noOcclusion();
    public static final AbstractBlock.Properties CHINENSIS_BUTTON_PROPERTIES = AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).strength(0.5F).sound(SoundType.WOOD).noCollission();
    public static final AbstractBlock.Properties CHINENSIS_PRESSURE_PLATE_PROPERTIES = AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).strength(0.5F).sound(SoundType.WOOD).noCollission();
    public static final AbstractBlock.Properties CHINENSIS_SIGN_PROPERTIES = AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).strength(2.0F).sound(SoundType.WOOD).noCollission().noOcclusion();
    public static final AbstractBlock.Properties CHINENSIS_LEAVES_PROPERTIES = AbstractBlock.Properties.of(Material.LEAVES, MaterialColor.COLOR_GREEN).harvestTool(ToolType.HOE).noOcclusion().strength(0.2F).randomTicks().sound(SoundType.GRASS).isValidSpawn(ModBlocks::allowsSpawnOnLeaves).isSuffocating(ModBlocks::isntSolid).isViewBlocking(ModBlocks::isntSolid);




    public static final RegistryObject<Block> CHINENSIS_PLANKS = BLOCKS.register("chinensis_planks",
        () -> new Block(CHINENSIS_PLANKS_PROPERTIES));

    public static final RegistryObject<Block> STRIPPED_CHINENSIS_LOG = BLOCKS.register("stripped_chinensis_log",
            () -> new RotatedPillarBlock(CHINENSIS_LOG_PROPERTIES));

    public static final RegistryObject<Block> STRIPPED_CHINENSIS_WOOD = BLOCKS.register("stripped_chinensis_wood",
            () -> new RotatedPillarBlock(CHINENSIS_LOG_PROPERTIES));

    public static final RegistryObject<Block> CHINENSIS_LOG = BLOCKS.register("chinensis_log",
            () -> new ModLogBlock(STRIPPED_CHINENSIS_LOG, CHINENSIS_LOG_PROPERTIES));

    public static final RegistryObject<Block> CHINENSIS_WOOD = BLOCKS.register("chinensis_wood",
            () -> new ModWoodBlock(STRIPPED_CHINENSIS_WOOD, CHINENSIS_LOG_PROPERTIES));

    public static final RegistryObject<Block> CHINENSIS_SLAB = BLOCKS.register("chinensis_slab",
            () -> new SlabBlock(CHINENSIS_PLANKS_PROPERTIES));

    public static final RegistryObject<Block> CHINENSIS_STAIRS = BLOCKS.register("chinensis_stairs",
            () -> new StairsBlock(CHINENSIS_PLANKS.get().defaultBlockState(), CHINENSIS_PLANKS_PROPERTIES));

    public static final RegistryObject<Block> CHINENSIS_DOOR = BLOCKS.register("chinensis_door",
            () -> new DoorBlock(CHINENSIS_DOOR_PROPERTIES));

    public static final RegistryObject<Block> CHINENSIS_TRAPDOOR = BLOCKS.register("chinensis_trapdoor",
            () -> new TrapDoorBlock(CHINENSIS_DOOR_PROPERTIES));

    public static final RegistryObject<Block> CHINENSIS_FENCE = BLOCKS.register("chinensis_fence", //Needs to be in Minecraft tags to work
            () -> new FenceBlock(CHINENSIS_PLANKS_PROPERTIES));

    public static final RegistryObject<Block> CHINENSIS_FENCE_GATE = BLOCKS.register("chinensis_fence_gate",
            () -> new FenceGateBlock(CHINENSIS_PLANKS_PROPERTIES));

    public static final RegistryObject<Block> CHINENSIS_PRESSURE_PLATE = BLOCKS.register("chinensis_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, CHINENSIS_PRESSURE_PLATE_PROPERTIES));

    public static final RegistryObject<Block> CHINENSIS_BUTTON = BLOCKS.register("chinensis_button",
            () -> new WoodButtonBlock(CHINENSIS_BUTTON_PROPERTIES));

    public static final RegistryObject<Block> CHINENSIS_SIGN = BLOCKS.register("chinensis_sign",
            () -> new ModStandingSignBlock(CHINENSIS_SIGN_PROPERTIES, ModWoodTypes.CHINENSIS));

    public static final RegistryObject<Block> CHINENSIS_WALL_SIGN = BLOCKS.register("chinensis_wall_sign",
            () -> new ModWallSignBlock(CHINENSIS_SIGN_PROPERTIES, ModWoodTypes.CHINENSIS));

    public static final RegistryObject<Block> CHINENSIS_LEAVES = BLOCKS.register("chinensis_leaves",
            () -> new ModLeavesBlock(CHINENSIS_LEAVES_PROPERTIES));

    public static final RegistryObject<Block> FRUITFUL_CHINENSIS_LEAVES = BLOCKS.register("fruitful_chinensis_leaves",
            () -> new ModLeavesBlock(CHINENSIS_LEAVES_PROPERTIES));





    public static boolean allowsSpawnOnLeaves(BlockState state, IBlockReader access, BlockPos pos, EntityType<?> entity) {
        return entity == EntityType.OCELOT || entity == EntityType.PARROT;
    }
    public static boolean isntSolid(BlockState state, IBlockReader reader, BlockPos pos) {
        return false;
    }


}
