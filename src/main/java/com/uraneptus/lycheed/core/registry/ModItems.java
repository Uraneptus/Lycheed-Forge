package com.uraneptus.lycheed.core.registry;

import com.uraneptus.lycheed.LycheedMod;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LycheedMod.MOD_ID);

    public static final Item.Properties BUILDING_BLOCKS = new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS);
    public static final Item.Properties DECORATION_BLOCKS = new Item.Properties().tab(ItemGroup.TAB_DECORATIONS);
    public static final Item.Properties FOOD = new Item.Properties().tab(ItemGroup.TAB_FOOD);
    public static final Item.Properties REDSTONE = new Item.Properties().tab(ItemGroup.TAB_REDSTONE);
    public static final Item.Properties TRANSPORTATION = new Item.Properties().tab(ItemGroup.TAB_TRANSPORTATION);

    //FOOD
    public static final RegistryObject<Item> LYCHEE = ITEMS.register("lychee",
            () -> new Item(FOOD.food(new Food.Builder().nutrition(5).saturationMod(0.9F).build())));

    public static final RegistryObject<Item> ROTTEN_LYCHEE = ITEMS.register("rotten_lychee",
            () -> new Item(FOOD.food(new Food.Builder().nutrition(2).saturationMod(0.4F)
                            .effect(() -> new EffectInstance(Effects.CONFUSION, 100, 1), 1.0F).build())));


    //BLOCK ITEMS
    public static final RegistryObject<BlockItem> LYCHEE_PLANKS = ITEMS.register("lychee_planks",
            ()-> new BlockItem(ModBlocks.LYCHEE_PLANKS.get(), BUILDING_BLOCKS));

    public static final RegistryObject<BlockItem> LYCHEE_LOG = ITEMS.register("lychee_log",
            ()-> new BlockItem(ModBlocks.LYCHEE_LOG.get(), BUILDING_BLOCKS));

    public static final RegistryObject<BlockItem> LYCHEE_WOOD = ITEMS.register("lychee_wood",
            ()-> new BlockItem(ModBlocks.LYCHEE_WOOD.get(), BUILDING_BLOCKS));

    public static final RegistryObject<BlockItem> STRIPPED_LYCHEE_LOG = ITEMS.register("stripped_lychee_log",
            ()-> new BlockItem(ModBlocks.STRIPPED_LYCHEE_LOG.get(), BUILDING_BLOCKS));

    public static final RegistryObject<BlockItem> STRIPPED_LYCHEE_WOOD = ITEMS.register("stripped_lychee_wood",
            ()-> new BlockItem(ModBlocks.STRIPPED_LYCHEE_WOOD.get(), BUILDING_BLOCKS));

    public static final RegistryObject<BlockItem> LYCHEE_SLAB = ITEMS.register("lychee_slab",
            ()-> new BlockItem(ModBlocks.LYCHEE_SLAB.get(), BUILDING_BLOCKS));

    public static final RegistryObject<BlockItem> LYCHEE_STAIRS = ITEMS.register("lychee_stairs",
            ()-> new BlockItem(ModBlocks.LYCHEE_STAIRS.get(), BUILDING_BLOCKS));

    public static final RegistryObject<BlockItem> LYCHEE_DOOR = ITEMS.register("lychee_door",
            ()-> new BlockItem(ModBlocks.LYCHEE_DOOR.get(), REDSTONE));

    public static final RegistryObject<BlockItem> LYCHEE_TRAPDOOR = ITEMS.register("lychee_trapdoor",
            ()-> new BlockItem(ModBlocks.LYCHEE_TRAPDOOR.get(), REDSTONE));

    public static final RegistryObject<BlockItem> LYCHEE_FENCE = ITEMS.register("lychee_fence",
            ()-> new BlockItem(ModBlocks.LYCHEE_FENCE.get(), DECORATION_BLOCKS));

    public static final RegistryObject<BlockItem> LYCHEE_FENCE_GATE = ITEMS.register("lychee_fence_gate",
            ()-> new BlockItem(ModBlocks.LYCHEE_FENCE_GATE.get(), REDSTONE));

    public static final RegistryObject<BlockItem> LYCHEE_PRESSURE_PLATE = ITEMS.register("lychee_pressure_plate",
            ()-> new BlockItem(ModBlocks.LYCHEE_PRESSURE_PLATE.get(), REDSTONE));

    public static final RegistryObject<BlockItem> LYCHEE_BUTTON = ITEMS.register("lychee_button",
            ()-> new BlockItem(ModBlocks.LYCHEE_BUTTON.get(), REDSTONE));





}
