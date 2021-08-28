package com.uraneptus.lycheed.core.registry;

import com.uraneptus.lycheed.LycheedMod;
import com.uraneptus.lycheed.common.blocks.ModBeehiveBlock;
import com.uraneptus.lycheed.common.blocks.ModStandingSignBlock;
import com.uraneptus.lycheed.common.blocks.ModWallSignBlock;
import com.uraneptus.lycheed.common.entities.tile.ModBeehiveTileEntity;
import com.uraneptus.lycheed.common.entities.tile.ModSignTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.tileentity.SignTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class ModTileEntityTypes {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, LycheedMod.MOD_ID);


    public static final RegistryObject<TileEntityType<ModSignTileEntity>> MOD_SIGN = TILE_ENTITIES.register("mod_sign",
            () -> TileEntityType.Builder.of(ModSignTileEntity::new, getModBlocks(ModWallSignBlock.class, ModStandingSignBlock.class)).build(null));

    public static final RegistryObject<TileEntityType<ModBeehiveTileEntity>> MOD_BEEHIVE = TILE_ENTITIES.register("mod_beehive",
            () -> TileEntityType.Builder.of(ModBeehiveTileEntity::new, getModBlocks(ModBeehiveBlock.class)).build(null));



    public static Block[] getModBlocks(Class<?>... blockClasses)
    {
        Collection<RegistryObject<Block>> blocks = ModBlocks.BLOCKS.getEntries();
        ArrayList<Block> matchingBlocks = new ArrayList<>();
        for (RegistryObject<Block> registryObject : blocks)
        {
            if (Arrays.stream(blockClasses).anyMatch(b -> b.isInstance(registryObject.get())))
            {
                matchingBlocks.add(registryObject.get());
            }
        }
        return matchingBlocks.toArray(new Block[0]);
    }


}
