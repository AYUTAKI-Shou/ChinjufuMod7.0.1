package com.ayutaki.chinjufumod.particle;

import net.minecraft.client.particle.IAnimatedSprite;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.IParticleRenderType;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.SpriteTexturedParticle;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Particle_Ammo extends SpriteTexturedParticle {
	
	private Particle_Ammo(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, 
			double xSpeed, double ySpeed, double zSpeed) {
		super(worldIn, xCoordIn, yCoordIn, zCoordIn, 0.0D, 0.0D, 0.0D);
		this.motionX *= (double)0.1F;
		this.motionY *= (double)0.1F;
		this.motionZ *= (double)0.1F;
		this.motionX += xSpeed * 0.4D;
		this.motionY += ySpeed * 0.4D;
		this.motionZ += zSpeed * 0.4D;
		float f = (float)(Math.random() * (double)0.3F + (double)0.6F);
		this.particleRed = f;
		this.particleGreen = f;
		this.particleBlue = f;
		this.particleScale *= 0.75F;
		this.maxAge = Math.max((int)(6.0D / (Math.random() * 0.8D + 0.6D)), 1);
		this.canCollide = false;
		this.tick();
	}

	public void tick() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		if (this.age++ >= this.maxAge) {
			this.setExpired();
		}

		else {
			this.move(this.motionX, this.motionY, this.motionZ);
			this.particleGreen = (float)((double)this.particleGreen * 0.96D);
			this.particleBlue = (float)((double)this.particleBlue * 0.9D);
			this.motionX *= (double)0.7F;
			this.motionY *= (double)0.7F;
			this.motionZ *= (double)0.7F;
			this.motionY -= (double)0.02F;
			if (this.onGround) {
				this.motionX *= (double)0.7F;
				this.motionZ *= (double)0.7F;
			}
		}
	}

	public IParticleRenderType getRenderType() {
		return IParticleRenderType.PARTICLE_SHEET_OPAQUE;
	}

	@OnlyIn(Dist.CLIENT)
	public static class Factory implements IParticleFactory<BasicParticleType> {
		private final IAnimatedSprite spriteSet;

		public Factory(IAnimatedSprite Isprite) {
			this.spriteSet = Isprite;
		}

		public Particle makeParticle(BasicParticleType typeIn, World worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			Particle_Ammo critparticle = new Particle_Ammo(worldIn, x, y, z, xSpeed, ySpeed, zSpeed);
			critparticle.selectSpriteRandomly(this.spriteSet);
			return critparticle;
		}
	}
}
