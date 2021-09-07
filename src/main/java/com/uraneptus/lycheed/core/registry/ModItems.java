package com.uraneptus.lycheed.core.registry;

import com.uraneptus.lycheed.LycheedMod;
import com.uraneptus.lycheed.ModIntegrations;
import com.uraneptus.lycheed.common.entities.ModBoatEntity;
import com.uraneptus.lycheed.common.items.ModBoatItem;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.ModList;
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
            () -> new BlockNamedItem(ModBlocks.CHINENSIS_BRANCH.get(), new Item.Properties().tab(ItemGroup.TAB_FOOD)
                    .food(new Food.Builder().nutrition(5).saturationMod(0.9F).build())));

    public static final RegistryObject<Item> ROTTEN_LYCHEE = ITEMS.register("rotten_lychee",
            () -> new Item(new Item.Properties().tab(ItemGroup.TAB_FOOD).food(new Food.Builder().nutrition(2).saturationMod(0.4F)
                            .effect(() -> new EffectInstance(Effects.CONFUSION, 100, 1), 1.0F).build())));

    public static final RegistryObject<Item> CHINENSIS_BOAT = ITEMS.register("chinensis_boat",
            () -> new ModBoatItem((TRANSPORTATION.stacksTo(1)), ModEntities.CHINENSIS_BOAT));

    public static final RegistryObject<Item> LYCHEE_CAKE_SLICE = ITEMS.register("lychee_cake_slice",
            () -> new Item(new Item.Properties()
                    .food(new Food.Builder().nutrition(2).saturationMod(0.1F).fast().effect(
                            () -> new EffectInstance(Effects.MOVEMENT_SPEED, 1200, 0), 1.0F).build())
                        .tab(!ModList.get().isLoaded("farmersdelight") ? null : ModIntegrations.getFdItemGroup())));

    //BLOCK ITEMS
    public static final RegistryObject<Item> CHINENSIS_PLANKS = ITEMS.register("chinensis_planks",
            ()-> new BlockItem(ModBlocks.CHINENSIS_PLANKS.get(), BUILDING_BLOCKS));

    public static final RegistryObject<BlockItem> CHINENSIS_LOG = ITEMS.register("chinensis_log",
            ()-> new BlockItem(ModBlocks.CHINENSIS_LOG.get(), BUILDING_BLOCKS));

    public static final RegistryObject<BlockItem> CHINENSIS_WOOD = ITEMS.register("chinensis_wood",
            ()-> new BlockItem(ModBlocks.CHINENSIS_WOOD.get(), BUILDING_BLOCKS));

    public static final RegistryObject<BlockItem> STRIPPED_CHINENSIS_LOG = ITEMS.register("stripped_chinensis_log",
            ()-> new BlockItem(ModBlocks.STRIPPED_CHINENSIS_LOG.get(), BUILDING_BLOCKS));

    public static final RegistryObject<BlockItem> STRIPPED_CHINENSIS_WOOD = ITEMS.register("stripped_chinensis_wood",
            ()-> new BlockItem(ModBlocks.STRIPPED_CHINENSIS_WOOD.get(), BUILDING_BLOCKS));

    public static final RegistryObject<BlockItem> CHINENSIS_SLAB = ITEMS.register("chinensis_slab",
            ()-> new BlockItem(ModBlocks.CHINENSIS_SLAB.get(), BUILDING_BLOCKS));

    public static final RegistryObject<BlockItem> CHINENSIS_STAIRS = ITEMS.register("chinensis_stairs",
            ()-> new BlockItem(ModBlocks.CHINENSIS_STAIRS.get(), BUILDING_BLOCKS));

    public static final RegistryObject<BlockItem> CHINENSIS_DOOR = ITEMS.register("chinensis_door",
            ()-> new BlockItem(ModBlocks.CHINENSIS_DOOR.get(), REDSTONE));

    public static final RegistryObject<BlockItem> CHINENSIS_TRAPDOOR = ITEMS.register("chinensis_trapdoor",
            ()-> new BlockItem(ModBlocks.CHINENSIS_TRAPDOOR.get(), REDSTONE));

    public static final RegistryObject<BlockItem> CHINENSIS_FENCE = ITEMS.register("chinensis_fence",
            ()-> new BlockItem(ModBlocks.CHINENSIS_FENCE.get(), DECORATION_BLOCKS));

    public static final RegistryObject<BlockItem> CHINENSIS_FENCE_GATE = ITEMS.register("chinensis_fence_gate",
            ()-> new BlockItem(ModBlocks.CHINENSIS_FENCE_GATE.get(), REDSTONE));

    public static final RegistryObject<BlockItem> CHINENSIS_PRESSURE_PLATE = ITEMS.register("chinensis_pressure_plate",
            ()-> new BlockItem(ModBlocks.CHINENSIS_PRESSURE_PLATE.get(), REDSTONE));

    public static final RegistryObject<BlockItem> CHINENSIS_BUTTON = ITEMS.register("chinensis_button",
            ()-> new BlockItem(ModBlocks.CHINENSIS_BUTTON.get(), REDSTONE));

    public static final RegistryObject<BlockItem> CHINENSIS_SIGN = ITEMS.register("chinensis_sign",
            () -> new SignItem(DECORATION_BLOCKS.stacksTo(16), ModBlocks.CHINENSIS_SIGN.get(), ModBlocks.CHINENSIS_WALL_SIGN.get()));

    public static final RegistryObject<BlockItem> CHINENSIS_LEAVES = ITEMS.register("chinensis_leaves",
            () -> new BlockItem(ModBlocks.CHINENSIS_LEAVES.get(), DECORATION_BLOCKS));

    public static final RegistryObject<BlockItem> FRUITFUL_CHINENSIS_LEAVES = ITEMS.register("fruitful_chinensis_leaves",
            () -> new BlockItem(ModBlocks.FRUITFUL_CHINENSIS_LEAVES.get(), DECORATION_BLOCKS));

    public static final RegistryObject<BlockItem> LYCHEE_BASKET = ITEMS.register("lychee_basket",
            () -> new BlockItem(ModBlocks.LYCHEE_BASKET.get(), DECORATION_BLOCKS));

    public static final RegistryObject<BlockItem> LYCHEE_CAKE = ITEMS.register("lychee_cake",
            () -> new BlockNamedItem(ModBlocks.LYCHEE_CAKE.get(), FOOD));

    public static final RegistryObject<BlockItem> CHINENSIS_BEEHIVE = ITEMS.register("chinensis_beehive",
            () -> new BlockItem(ModBlocks.CHINENSIS_BEEHIVE.get(), new Item.Properties().tab(!ModList.get().isLoaded("buzzier_bees") ? null : ItemGroup.TAB_DECORATIONS)));

    public static final RegistryObject<BlockItem> CHINENSIS_PANTRY = ITEMS.register("chinensis_pantry",
            () -> new BlockItem(ModBlocks.CHINENSIS_PANTRY.get(), new Item.Properties().tab(!ModList.get().isLoaded("farmersdelight") ? null : ModIntegrations.getFdItemGroup())));

    public static final RegistryObject<BlockItem> CHINENSIS_LADDER = ITEMS.register("chinensis_ladder",
            () -> new BlockItem(ModBlocks.CHINENSIS_LADDER.get(), new Item.Properties().tab(!ModList.get().isLoaded("quark") ? null : ItemGroup.TAB_DECORATIONS)));

    public static final RegistryObject<BlockItem> CHINENSIS_BOOKSHELF = ITEMS.register("chinensis_bookshelf",
            () -> new BlockItem(ModBlocks.CHINENSIS_BOOKSHELF.get(), new Item.Properties().tab(!ModList.get().isLoaded("quark") ? null : ItemGroup.TAB_DECORATIONS)));

    public static final RegistryObject<BlockItem> VERTICAL_CHINENSIS_PLANKS = ITEMS.register("vertical_chinensis_planks",
            () -> new BlockItem(ModBlocks.VERTICAL_CHINENSIS_PLANKS.get(), new Item.Properties().tab(!ModList.get().isLoaded("quark") ? null : ItemGroup.TAB_BUILDING_BLOCKS)));






}
