package com.uraneptus.lycheed.core;

import com.uraneptus.lycheed.LycheedMod;
import net.minecraft.block.WoodType;
import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import static net.minecraft.client.renderer.Atlases.SIGN_MATERIALS;
import static net.minecraft.client.renderer.Atlases.SIGN_SHEET;

@Mod.EventBusSubscriber(modid = LycheedMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModWoodTypes {

    public static final WoodType LYCHEE = new ModWoodType("lychee");

    @SubscribeEvent
    public static void setRenderLayer(FMLClientSetupEvent event) {
        event.enqueueWork(() -> addWoodType(LYCHEE));
    }

    public static void addWoodType(WoodType woodType) {
        SIGN_MATERIALS.put(woodType, new RenderMaterial(SIGN_SHEET, new ResourceLocation(LycheedMod.MOD_ID, "entity/signs/" + woodType.name())));
    }


    static class ModWoodType extends WoodType {
        protected ModWoodType(String nameIn) {
            super(nameIn);
        }
    }
}
