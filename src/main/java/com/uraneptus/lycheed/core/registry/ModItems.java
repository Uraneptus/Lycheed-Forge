package com.uraneptus.lycheed.core.registry;

import com.minecraftabnormals.abnormals_core.core.util.registry.ItemSubRegistryHelper;
import com.uraneptus.lycheed.LycheedMod;
import com.uraneptus.lycheed.ModIntegrations;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = LycheedMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {
    public static final ItemSubRegistryHelper HELPER = LycheedMod.REGISTRY_HELPER.getItemSubHelper();

    public static final RegistryObject<Item> LYCHEE = HELPER.createItem("lychee",
            () -> new BlockItem(ModBlocks.LYCHEE_BRANCH.get(), new Item.Properties().tab(ItemGroup.TAB_FOOD)
                    .food(new Food.Builder().nutrition(5).saturationMod(0.9F).build())));

    public static final RegistryObject<Item> ROTTEN_LYCHEE = HELPER.createItem("rotten_lychee",
            () -> new Item(new Item.Properties().tab(ItemGroup.TAB_FOOD).food(new Food.Builder().nutrition(2).saturationMod(0.4F)
                    .effect(() -> new EffectInstance(Effects.CONFUSION, 100, 1), 1.0F).build())));

    public static final RegistryObject<Item> LYCHEE_BOAT = HELPER.createBoatItem("lychee",
            ModBlocks.LYCHEE_PLANKS);

    public static final RegistryObject<Item> LYCHEE_CAKE_SLICE = HELPER.createItem("lychee_cake_slice",
            () -> new Item(new Item.Properties()
                    .food(new Food.Builder().nutrition(2).saturationMod(0.1F).fast().effect(
                            () -> new EffectInstance(Effects.MOVEMENT_SPEED, 1200, 0), 1.0F).build())
                    .tab(!ModList.get().isLoaded("farmersdelight") ? null : ModIntegrations.getFdItemGroup())));
}
