package com.ayutaki.chinjufumod.particle;

import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class Particle_Mark extends Particle {
	
	float oSize;
	
	public Particle_Mark(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, 
			double xSpeed, double ySpeed, double zSpeed) {
		this(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeed, ySpeed, zSpeed, 1.0F);
	}

	protected Particle_Mark(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, 
			double xSpeed, double ySpeed, double zSpeed, float scale) {
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
		this.oSize = this.particleScale;
		this.particleMaxAge = 2;
		this.setParticleTextureIndex(144); //from minecraft.textures.particle.particles.png
		this.onUpdate();
	}

	public void renderParticle(BufferBuilder buffer, Entity entityIn, float partialTicks, float rotationX, float rotationZ, 
			float rotationYZ, float rotationXY, float rotationXZ) {
		float f = ((float)this.particleAge + partialTicks) / (float)this.particleMaxAge * 32.0F;
		f = MathHelper.clamp(f, 0.0F, 1.0F);
		this.particleScale = this.oSize * f;
		super.renderParticle(buffer, entityIn, partialTicks, rotationX, rotationZ, rotationYZ, rotationXY, rotationXZ);
	}

	public void onUpdate() {
		if (this.particleAge++ >= this.particleMaxAge) {
			this.setExpired(); }

		else { }
	}
}
