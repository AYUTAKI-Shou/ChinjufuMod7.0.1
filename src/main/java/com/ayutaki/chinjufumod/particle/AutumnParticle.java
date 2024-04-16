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

/* net.minecraft.client.particle.FallingDustParticle */
@OnlyIn(Dist.CLIENT)
public class AutumnParticle extends SpriteTexturedParticle {

	private final float rotSpeed;

	private AutumnParticle(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn,
			double xSpeed, double ySpeed, double zSpeed) {
		super(worldIn, xCoordIn, yCoordIn, zCoordIn);

		this.particleScale *= 0.75F;
		int i = (int)(32.0D / (Math.random() * 0.8D + 0.2D));
		this.maxAge = (int)Math.max((float)i * 1.8F, 2.0F);
		this.rotSpeed = ((float)Math.random() - 0.5F) * 0.1F;
		this.particleAngle = (float)Math.random() * ((float)Math.PI * 2.0F);
	}

	public IParticleRenderType getRenderType() {
		return IParticleRenderType.PARTICLE_SHEET_OPAQUE;
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
			this.motionY -= (double)0.002F;
			this.motionY = Math.max(this.motionY, (double)-0.1F);

			this.prevParticleAngle = this.particleAngle;
			if (!this.onGround) {
				this.particleAngle += (float)Math.PI * this.rotSpeed * 1.6F;
			}
			else {
				this.motionY = 0.0D;
			}
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class Factory implements IParticleFactory<BasicParticleType> {

		private final IAnimatedSprite spriteSet;

		public Factory(IAnimatedSprite Isprite) {
			this.spriteSet = Isprite;
		}

		/** BubbleColumnUpParticle **/
		public Particle makeParticle(BasicParticleType typeIn, World worldIn, double x, double y, double z,
				double xSpeed, double ySpeed, double zSpeed) {

			AutumnParticle particle = new AutumnParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed);
			//particle.setColor((float)xSpeed, (float)ySpeed, (float)zSpeed);
			particle.selectSpriteRandomly(this.spriteSet);
			return particle;
		}
	}
}
