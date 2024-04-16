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
public class Particle_ShootK extends SpriteTexturedParticle {
	
	private Particle_ShootK(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, 
			double xSpeed, double ySpeed, double zSpeed) {
		super(worldIn, xCoordIn, yCoordIn, zCoordIn, 0.0D, 0.0D, 0.0D);
		this.motionX *= (double)0.1F;
		this.motionY *= (double)0.1F;
		this.motionZ *= (double)0.1F;
		this.motionX += xSpeed * 0.4D;
		this.motionY += ySpeed * 0.1D;
		this.motionZ += zSpeed * 0.4D;
		float f = (float)(Math.random() * (double)0.3F + (double)0.6F);
		this.particleRed = f;
		this.particleGreen = f;
		this.particleBlue = f;
		this.particleScale *= 0.75F;
		this.maxAge = 3;
		this.canCollide = false;
		
		this.multipleParticleScaleBy(3.0F);
		this.particleAngle = (float)Math.random() * ((float)Math.PI * 2.0F);
		this.particleGravity = -0.025F;
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
			this.motionX *= (double)0.7F;
			this.motionY -= (double)this.particleGravity;
			this.motionZ *= (double)0.7F;
			this.prevParticleAngle = this.particleAngle;
			this.particleAlpha -= 0.3F;
		}
	}

	public IParticleRenderType getRenderType() {
		return IParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
	}

	@OnlyIn(Dist.CLIENT)
	public static class Factory implements IParticleFactory<BasicParticleType> {
		private final IAnimatedSprite spriteSet;

		public Factory(IAnimatedSprite Isprite) {
			this.spriteSet = Isprite;
		}

		public Particle makeParticle(BasicParticleType typeIn, World worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			Particle_ShootK AmmoParticle = new Particle_ShootK(worldIn, x, y, z, xSpeed, ySpeed, zSpeed);
			AmmoParticle.selectSpriteRandomly(this.spriteSet);
			AmmoParticle.setAlphaF(0.9F);
			return AmmoParticle;
		}
	}
}
