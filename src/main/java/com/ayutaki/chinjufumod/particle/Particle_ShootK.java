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
public class Particle_ShootK extends TextureSheetParticle {
	
	Particle_ShootK(ClientLevel worldIn, double xIn, double yIn, double zIn, double xSpeed, double ySpeed, double zSpeed) {
		super(worldIn, xIn, yIn, zIn, 0.0D, 0.0D, 0.0D);
		this.xd *= (double)0.1F;
		this.yd *= (double)0.1F;
		this.zd *= (double)0.1F;
		this.xd += xSpeed * 0.4D;
		this.yd += ySpeed * 0.1D;
		this.zd += zSpeed * 0.4D;
		float f = (float)(Math.random() * (double)0.3F + (double)0.6F);
		this.rCol = f;
		this.gCol = f;
		this.bCol = f;
		this.quadSize *= 0.75F;
		this.lifetime = 3;
		this.hasPhysics = false;
		
		this.scale(3.0F);
		this.roll = (float)Math.random() * ((float)Math.PI * 2.0F);
		this.gravity = -0.025F;
		this.tick();
	}

	public void tick() {
		this.xo = this.x;
		this.yo = this.y;
		this.zo = this.z;
		if (this.age++ >= this.lifetime) {
			this.remove();
		}
		else {
			this.move(this.xd, this.yd, this.zd);
			this.xd *= (double)0.7F;
			this.yd -= (double)this.gravity;
			this.zd *= (double)0.7F;
			this.oRoll = this.roll;
			this.alpha -= 0.3F;
		}
	}

	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
	}

	@OnlyIn(Dist.CLIENT)
	public static class Provider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet sprite;

		public Provider(SpriteSet iSprite) {
			this.sprite = iSprite;
		}

		public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double xIn, double yIn, double zIn, double xSpeed, double ySpeed, double zSpeed) {
			Particle_ShootK AmmoParticle = new Particle_ShootK(worldIn, xIn, yIn, zIn, xSpeed, ySpeed, zSpeed);
			AmmoParticle.pickSprite(this.sprite);
			AmmoParticle.setAlpha(0.9F);
			return AmmoParticle;
		}
	}
}
