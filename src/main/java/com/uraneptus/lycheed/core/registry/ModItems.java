package com.uraneptus.lycheed.core.registry;

import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import com.uraneptus.lycheed.LycheedMod;
import com.uraneptus.lycheed.ModIntegrations;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import static com.uraneptus.lycheed.core.registry.ModItems.FoodsProperties.*;

@Mod.EventBusSubscriber(modid = LycheedMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {
    public static final ItemSubRegistryHelper HELPER = LycheedMod.REGISTRY_HELPER.getItemSubHelper();

    public static final RegistryObject<Item> LYCHEE = HELPER.createItem("lychee", () -> new BlockItem(ModBlocks.LYCHEE_BRANCH.get(), new Item.Properties().food(LYCHEE_FOOD).tab(CreativeModeTab.TAB_FOOD)));
    public static final RegistryObject<Item> DRIED_LYCHEE = HELPER.createItem("dried_lychee", () -> new Item(new Item.Properties().food(DRIED_LYCHEE_FOOD).tab(CreativeModeTab.TAB_FOOD)));

    public static final RegistryObject<Item> LYCHEE_CAKE_SLICE = HELPER.createItem("lychee_cake_slice", () -> new Item(new Item.Properties().food(LYCHEE_CAKE_SLICE_FOOD).tab(!ModList.get().isLoaded("farmersdelight") ? null : ModIntegrations.getFdItemGroup())));

    public static final RegistryObject<Item> LYCHEE_BOAT = HELPER.createBoatItem("lychee", ModBlocks.LYCHEE_PLANKS);


    static class FoodsProperties {
        public static final FoodProperties LYCHEE_FOOD = new FoodProperties.Builder().nutrition(3).saturationMod(0.9F).fast().build();
        public static final FoodProperties LYCHEE_CAKE_SLICE_FOOD = new FoodProperties.Builder().nutrition(2).saturationMod(0.3F).fast().effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 0), 1.0F).build();
        public static final FoodProperties DRIED_LYCHEE_FOOD = new FoodProperties.Builder().nutrition(4).saturationMod(0.2F).fast().build();

    }
}
