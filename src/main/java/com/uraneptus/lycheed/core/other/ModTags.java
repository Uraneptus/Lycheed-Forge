package com.uraneptus.lycheed.core.other;

import com.teamabnormals.blueprint.core.other.tags.BlueprintBlockTags;
import com.teamabnormals.blueprint.core.other.tags.BlueprintItemTags;
import com.teamabnormals.blueprint.core.util.TagUtil;
import com.uraneptus.lycheed.LycheedMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

public class ModTags {

    public static class BlockTags {
        public static final TagKey<Block> CAN_PLACE_LYCHEE = TagUtil.blockTag(LycheedMod.MOD_ID, "can_place_lychee");
    }
}
