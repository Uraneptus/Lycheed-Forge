package com.uraneptus.lycheed.client.entities;

import com.uraneptus.lycheed.LycheedMod;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.util.ResourceLocation;

public class ModBoatRenderer extends BoatRenderer {

    private final ResourceLocation boatTexture;

    public ModBoatRenderer(EntityRendererManager rendererManager) {
        super(rendererManager);
        boatTexture = new ResourceLocation(LycheedMod.MOD_ID, "textures/entity/boat/lychee.png");
    }

    @Override
    public ResourceLocation getTextureLocation(BoatEntity entity) {
        return boatTexture;
    }
}
