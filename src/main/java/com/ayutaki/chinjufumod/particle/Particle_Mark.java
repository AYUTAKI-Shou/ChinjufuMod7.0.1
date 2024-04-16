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
public class Particle_Mark extends SpriteTexturedParticle {
	
	private Particle_Mark(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, 
			double xSpeed, double ySpeed, double zSpeed) {
		super(worldIn, xCoordIn, yCoordIn, zCoordIn, 0.0D, 0.0D, 0.0D);
		this.motionX *= (double)0.1F;
		this.motionY *= (double)0.0F;
		this.motionZ *= (double)0.1F;
		this.motionX += xSpeed * 0.1D;
		this.motionY += ySpeed * 0.1D;
		this.motionZ += zSpeed * 0.1D;
		this.particleRed = (float) 200 / 255.0F;
		this.particleGreen = (float) 160 / 255.0F;
		this.particleBlue = (float) 60 / 255.0F;
		this.particleScale *= 0.75F;
		this.maxAge = 2;
		this.canCollide = false;
		
		this.particleGravity = 0.0F;
		this.tick();
	}

	public void tick() {
		if (this.age++ >= this.maxAge) {
			this.setExpired(); }
		
		else { }
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
			Particle_Mark critparticle = new Particle_Mark(worldIn, x, y, z, xSpeed, ySpeed, zSpeed);
			critparticle.selectSpriteRandomly(this.spriteSet);
			return critparticle;
		}
	}
}
