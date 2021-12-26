package com.uraneptus.lycheed.core.data;

import com.uraneptus.lycheed.LycheedMod;
import com.uraneptus.lycheed.core.registry.ModBlocks;
import com.uraneptus.lycheed.core.registry.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class LangGenerator extends LanguageProvider {
    public LangGenerator(DataGenerator gen) {
        super(gen, LycheedMod.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(ModItems.LYCHEE.get(), "Lychee");
        add(ModItems.DRIED_LYCHEE.get(), "Dried Lychee");
        add(ModItems.LYCHEE_CAKE_SLICE.get(), "Lychee Cake Slice");
        add(ModItems.LYCHEE_BOAT.get(), "Lychee Boat");


        System.out.println("LANGUAGE GENERATION COMPLETE");
    }
}
