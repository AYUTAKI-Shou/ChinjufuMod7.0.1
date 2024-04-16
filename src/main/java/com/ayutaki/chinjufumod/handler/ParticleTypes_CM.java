package com.ayutaki.chinjufumod.handler;

import com.ayutaki.chinjufumod.ChinjufuMod;

import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ParticleTypes_CM {

	@SuppressWarnings("deprecation")
	public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = new DeferredRegister<>(ForgeRegistries.PARTICLE_TYPES, ChinjufuMod.MOD_ID);

	public static BasicParticleType FALLSAKURA = register("fallsakura", new BasicParticleType(false));
	public static BasicParticleType FALLKAEDE = register("fallkaede", new BasicParticleType(false));
	public static BasicParticleType FALLICHOH = register("fallichoh", new BasicParticleType(false));
	public static BasicParticleType FALLKARE = register("fallkare", new BasicParticleType(false));
	
	public static BasicParticleType AMMO_PT = register("ammo_pt", new BasicParticleType(false));
	public static BasicParticleType SHOOT_PT = register("shoot_pt", new BasicParticleType(false));
	public static BasicParticleType SHOOTL_PT = register("shoot_pt_l", new BasicParticleType(false));
	public static BasicParticleType SHOOTM_PT = register("shoot_pt_m", new BasicParticleType(false));
	public static BasicParticleType MARK_PT = register("mark_pt", new BasicParticleType(false));
	
	private static BasicParticleType register(String name, BasicParticleType type) {
		PARTICLE_TYPES.register(name, () -> type);
		return type;
	}
}
