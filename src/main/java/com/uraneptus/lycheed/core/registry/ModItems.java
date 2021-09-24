package com.uraneptus.lycheed.core.registry;

import com.uraneptus.lycheed.LycheedMod;
import com.uraneptus.lycheed.ModIntegrations;
import com.uraneptus.lycheed.common.items.ModBoatItem;
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

    public static final RegistryObject<Item> LYCHEE = ITEMS.register("lychee",
            () -> new BlockItem(ModBlocks.LYCHEE_BRANCH.get(), new Item.Properties().tab(ItemGroup.TAB_FOOD)
                    .food(new Food.Builder().nutrition(5).saturationMod(0.9F).build())));

    public static final RegistryObject<Item> ROTTEN_LYCHEE = ITEMS.register("rotten_lychee",
            () -> new Item(new Item.Properties().tab(ItemGroup.TAB_FOOD).food(new Food.Builder().nutrition(2).saturationMod(0.4F)
                            .effect(() -> new EffectInstance(Effects.CONFUSION, 100, 1), 1.0F).build())));

    public static final RegistryObject<Item> LYCHEE_BOAT = ITEMS.register("lychee_boat",
            () -> new ModBoatItem((TRANSPORTATION.stacksTo(1)), ModEntities.LYCHEE_BOAT));

    public static final RegistryObject<Item> LYCHEE_CAKE_SLICE = ITEMS.register("lychee_cake_slice",
            () -> new Item(new Item.Properties()
                    .food(new Food.Builder().nutrition(2).saturationMod(0.1F).fast().effect(
                            () -> new EffectInstance(Effects.MOVEMENT_SPEED, 1200, 0), 1.0F).build())
                        .tab(!ModList.get().isLoaded("farmersdelight") ? null : ModIntegrations.getFdItemGroup())));

    //Other Block Items
    public static final RegistryObject<BlockItem> LYCHEE_CAKE = ITEMS.register("lychee_cake",
            () -> new BlockNamedItem(ModBlocks.LYCHEE_CAKE.get(), FOOD));

    public static final RegistryObject<BlockItem> LYCHEE_PANTRY = ITEMS.register("lychee_pantry",
            () -> new BlockItem(ModBlocks.LYCHEE_PANTRY.get(), new Item.Properties().tab(!ModList.get().isLoaded("farmersdelight") ? null : ModIntegrations.getFdItemGroup())));





}
