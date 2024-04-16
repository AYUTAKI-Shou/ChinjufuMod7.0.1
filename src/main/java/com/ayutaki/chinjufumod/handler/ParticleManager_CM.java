package com.ayutaki.chinjufumod.handler;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.particle.AutumnParticle;
import com.ayutaki.chinjufumod.particle.IchohParticle;
import com.ayutaki.chinjufumod.particle.KaedeParticle;
import com.ayutaki.chinjufumod.particle.Particle_Ammo;
import com.ayutaki.chinjufumod.particle.Particle_Mark;
import com.ayutaki.chinjufumod.particle.Particle_ShootK;
import com.ayutaki.chinjufumod.particle.Particle_ShootL;
import com.ayutaki.chinjufumod.particle.Particle_ShootM;
import com.ayutaki.chinjufumod.particle.SakuraParticle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ParticleManager_CM {

	@SuppressWarnings("resource")
	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public static void registerFactories(ParticleFactoryRegisterEvent event) {
		ParticleManager particleManager = Minecraft.getInstance().particles;
		particleManager.registerFactory(ParticleTypes_CM.FALLSAKURA, SakuraParticle.Factory::new);
		particleManager.registerFactory(ParticleTypes_CM.FALLKAEDE, KaedeParticle.Factory::new);
		particleManager.registerFactory(ParticleTypes_CM.FALLICHOH, IchohParticle.Factory::new);
		particleManager.registerFactory(ParticleTypes_CM.FALLKARE, AutumnParticle.Factory::new);
		
		particleManager.registerFactory(ParticleTypes_CM.AMMO_PT, Particle_Ammo.Factory::new);
		particleManager.registerFactory(ParticleTypes_CM.SHOOT_PT, Particle_ShootK.Factory::new);
		particleManager.registerFactory(ParticleTypes_CM.SHOOTL_PT, Particle_ShootL.Factory::new);
		particleManager.registerFactory(ParticleTypes_CM.SHOOTM_PT, Particle_ShootM.Factory::new);
		particleManager.registerFactory(ParticleTypes_CM.MARK_PT, Particle_Mark.Factory::new);
	}
}
