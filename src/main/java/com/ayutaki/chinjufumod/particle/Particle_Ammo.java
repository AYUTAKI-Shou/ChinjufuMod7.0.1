package com.ayutaki.chinjufumod.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/* net.minecraft.client.particle.CritParticle */
@OnlyIn(Dist.CLIENT)
public class Particle_Ammo extends TextureSheetParticle {
	
	Particle_Ammo(ClientLevel worldIn, double xIn, double yIn, double zIn, double xSpeed, double ySpeed, double zSpeed) {
		super(worldIn, xIn, yIn, zIn, 0.0D, 0.0D, 0.0D);
		this.friction = 0.7F;
		this.gravity = 0.0F;
		this.xd *= (double)0.1F;
		this.yd *= (double)0.1F;
		this.zd *= (double)0.1F;
		this.xd += xSpeed * 0.4D;
		this.yd += ySpeed * 0.4D;
		this.zd += zSpeed * 0.4D;
		float f = (float)(Math.random() * (double)0.3F + (double)0.6F);
		this.rCol = f;
		this.gCol = f;
		this.bCol = f;
		this.quadSize *= 0.75F;
		this.lifetime = Math.max((int)(6.0D / (Math.random() * 0.8D + 0.6D)), 1);
		this.hasPhysics = false;
		this.tick();
	}

	public float getQuadSize(float f) {
		return this.quadSize * Mth.clamp(((float)this.age + f) / (float)this.lifetime * 32.0F, 0.0F, 1.0F);
	}

	public void tick() {
		super.tick();
		this.gCol *= 0.96F;
		this.bCol *= 0.9F;
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
			Particle_Ammo critparticle = new Particle_Ammo(worldIn, xIn, yIn, zIn, xSpeed, ySpeed, zSpeed);
			critparticle.pickSprite(this.sprite);
			return critparticle;
		}
	}
}
