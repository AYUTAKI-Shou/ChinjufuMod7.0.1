package com.ayutaki.chinjufumod.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Particle_Mark extends TextureSheetParticle {
	
	Particle_Mark(ClientLevel worldIn, double xIn, double yIn, double zIn, double xSpeed, double ySpeed, double zSpeed) {
		super(worldIn, xIn, yIn, zIn, 0.0D, 0.0D, 0.0D);
		this.friction = 0.7F;
		this.gravity = 0.0F;
		this.xd *= (double)0.1F;
		this.yd *= (double)0.0F;
		this.zd *= (double)0.1F;
		this.xd += xSpeed * 0.1D;
		this.yd += ySpeed * 0.1D;
		this.zd += zSpeed * 0.1D;
		this.rCol = (float) 200 / 255.0F;
		this.gCol = (float) 160 / 255.0F;
		this.bCol = (float) 60 / 255.0F;
		this.quadSize *= 0.75F;
		this.lifetime = 2;
		this.hasPhysics = false;
		
		this.gravity = 0.0F;
		this.tick();
	}

	public void tick() {
		if (this.age++ >= this.lifetime) {
			this.remove(); }

		else { }
	}

	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
	}

	@OnlyIn(Dist.CLIENT)
	public static class Provider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet sprite;

		public Provider(SpriteSet iSprite) {
			this.sprite = iSprite;
		}

		public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double xIn, double yIn, double zIn, double xSpeed, double ySpeed, double zSpeed) {
			Particle_Mark critparticle = new Particle_Mark(worldIn, xIn, yIn, zIn, xSpeed, ySpeed, zSpeed);
			critparticle.pickSprite(this.sprite);
			return critparticle;
		}
	}
}
