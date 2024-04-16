package com.ayutaki.chinjufumod.handler;

import java.util.function.Supplier;

import com.ayutaki.chinjufumod.ChinjufuMod;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ParticleTypes_CM {

	public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, ChinjufuMod.MOD_ID);

	public static final RegistryObject<ParticleType<SimpleParticleType>> FALLSAKURA = register("fallsakura", ()-> new SimpleParticleType(false));
	public static final RegistryObject<ParticleType<SimpleParticleType>> FALLKAEDE = register("fallkaede", ()-> new SimpleParticleType(false));
	public static final RegistryObject<ParticleType<SimpleParticleType>> FALLICHOH = register("fallichoh", ()-> new SimpleParticleType(false));
	public static final RegistryObject<ParticleType<SimpleParticleType>> FALLKARE = register("fallkare", ()-> new SimpleParticleType(false));
	
	public static final RegistryObject<ParticleType<SimpleParticleType>> AMMO_PT = register("ammo_pt", ()-> new SimpleParticleType(false));
	public static final RegistryObject<ParticleType<SimpleParticleType>> SHOOT_PT = register("shoot_pt", ()-> new SimpleParticleType(false));
	public static final RegistryObject<ParticleType<SimpleParticleType>> SHOOTL_PT = register("shoot_pt_l", ()-> new SimpleParticleType(false));
	public static final RegistryObject<ParticleType<SimpleParticleType>> SHOOTM_PT = register("shoot_pt_m", ()-> new SimpleParticleType(false));
	public static final RegistryObject<ParticleType<SimpleParticleType>> MARK_PT = register("mark_pt", ()-> new SimpleParticleType(false));
	
	///* Register *///
	public static <T extends ParticleOptions> RegistryObject<ParticleType<T>> register(String name, Supplier<ParticleType<T>> type) {
		return PARTICLE_TYPES.register(name, type);
	}
}
