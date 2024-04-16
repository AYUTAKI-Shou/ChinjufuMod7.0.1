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
import net.minecraft.client.particle.ParticleEngine;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD) //must
public class ParticleManager_CM {

	@SuppressWarnings("resource")
	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public static void registerFactories(ParticleFactoryRegisterEvent event) {
		ParticleEngine manager = Minecraft.getInstance().particleEngine;
		manager.register(ParticleTypes_CM.FALLSAKURA.get(), SakuraParticle.Provider::new);
		manager.register(ParticleTypes_CM.FALLKAEDE.get(), KaedeParticle.Provider::new);
		manager.register(ParticleTypes_CM.FALLICHOH.get(), IchohParticle.Provider::new);
		manager.register(ParticleTypes_CM.FALLKARE.get(), AutumnParticle.Provider::new);
		
		manager.register(ParticleTypes_CM.AMMO_PT.get(), Particle_Ammo.Provider::new);
		manager.register(ParticleTypes_CM.SHOOT_PT.get(), Particle_ShootK.Provider::new);
		manager.register(ParticleTypes_CM.SHOOTL_PT.get(), Particle_ShootL.Provider::new);
		manager.register(ParticleTypes_CM.SHOOTM_PT.get(), Particle_ShootM.Provider::new);
		manager.register(ParticleTypes_CM.MARK_PT.get(), Particle_Mark.Provider::new);
	}
}
