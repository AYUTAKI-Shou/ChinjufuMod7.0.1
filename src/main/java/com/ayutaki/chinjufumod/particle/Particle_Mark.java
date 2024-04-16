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
public class Particle_Mark extends SpriteTexturedParticle {

	private Particle_Mark(ClientWorld worldIn, double xCoordIn, double yCoordIn, double zCoordIn,
			double xSpeed, double ySpeed, double zSpeed) {
			super(worldIn, xCoordIn, yCoordIn, zCoordIn, 0.0D, 0.0D, 0.0D);
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
			Particle_Mark AmmoParticle = new Particle_Mark(worldIn, x, y, z, xSpeed, ySpeed, zSpeed);
			AmmoParticle.pickSprite(this.sprite);
			return AmmoParticle;
		}
	}
}
