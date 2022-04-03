package com.uraneptus.lycheed.core.registry;

import com.uraneptus.lycheed.LycheedMod;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = LycheedMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModParticleType {
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, LycheedMod.MOD_ID);
    
    public static final RegistryObject<SimpleParticleType> LYCHEE_LEAVES_PARTICLE = PARTICLES.register("lychee_leaves_particle", () -> new SimpleParticleType(false));




}
