package com.ayutaki.chinjufumod.particle;

import net.minecraft.client.particle.IAnimatedSprite;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.IParticleRenderType;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.SpriteTexturedParticle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.BasicParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Particle_Ammo extends SpriteTexturedParticle {

	private Particle_Ammo(ClientWorld worldIn, double xCoordIn, double yCoordIn, double zCoordIn,
			double xSpeed, double ySpeed, double zSpeed) {
			super(worldIn, xCoordIn, yCoordIn, zCoordIn, 0.0D, 0.0D, 0.0D);
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

	public void tick() {
		this.xo = this.x;
		this.yo = this.y;
		this.zo = this.z;
		if (this.age++ >= this.lifetime) {
			this.remove();
		} 
		else {
			this.move(this.xd, this.yd, this.zd);
			this.gCol = (float)((double)this.gCol * 0.96D);
			this.bCol = (float)((double)this.bCol * 0.9D);
			this.xd *= (double)0.7F;
			this.yd *= (double)0.7F;
			this.zd *= (double)0.7F;
			this.yd -= (double)0.02F;
			if (this.onGround) {
				this.xd *= (double)0.7F;
				this.zd *= (double)0.7F;
			}
		}
	}

	public IParticleRenderType getRenderType() {
		return IParticleRenderType.PARTICLE_SHEET_OPAQUE;
	}

	@OnlyIn(Dist.CLIENT)
	public static class Factory implements IParticleFactory<BasicParticleType> {
		private final IAnimatedSprite sprite;

		public Factory(IAnimatedSprite Isprite) {
			this.sprite = Isprite;
		}

		public Particle createParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			Particle_Ammo AmmoParticle = new Particle_Ammo(worldIn, x, y, z, xSpeed, ySpeed, zSpeed);
			AmmoParticle.pickSprite(this.sprite);
			return AmmoParticle;
		}
	}
}
