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

    public static Item.Properties buildingBlocks() {
        return new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS);
    }

    //FOOD
    public static final RegistryObject<Item> LYCHEE = ITEMS.register("lychee",
            () -> new Item(new Item.Properties().tab(ItemGroup.TAB_FOOD)
                    .food(new Food.Builder().nutrition(5).saturationMod(0.9F).build())));

    public static final RegistryObject<Item> ROTTEN_LYCHEE = ITEMS.register("rotten_lychee",
            () -> new Item(new Item.Properties().tab(ItemGroup.TAB_FOOD)
                    .food(new Food.Builder().nutrition(2).saturationMod(0.4F)
                            .effect(() -> new EffectInstance(Effects.CONFUSION, 100, 1), 1.0F).build())));


    //BLOCK ITEMS
    public static final RegistryObject<BlockItem> LYCHEE_PLANKS = ITEMS.register("lychee_planks",
            ()-> new BlockItem(ModBlocks.LYCHEE_PLANKS.get(), buildingBlocks()));

    public static final RegistryObject<BlockItem> LYCHEE_LOG = ITEMS.register("lychee_log",
            ()-> new BlockItem(ModBlocks.LYCHEE_LOG.get(), buildingBlocks()));

    public static final RegistryObject<BlockItem> LYCHEE_WOOD = ITEMS.register("lychee_wood",
            ()-> new BlockItem(ModBlocks.LYCHEE_WOOD.get(), buildingBlocks()));

    public static final RegistryObject<BlockItem> STRIPPED_LYCHEE_LOG = ITEMS.register("stripped_lychee_log",
            ()-> new BlockItem(ModBlocks.STRIPPED_LYCHEE_LOG.get(), buildingBlocks()));

    public static final RegistryObject<BlockItem> STRIPPED_LYCHEE_WOOD = ITEMS.register("stripped_lychee_wood",
            ()-> new BlockItem(ModBlocks.STRIPPED_LYCHEE_WOOD.get(), buildingBlocks()));



}
