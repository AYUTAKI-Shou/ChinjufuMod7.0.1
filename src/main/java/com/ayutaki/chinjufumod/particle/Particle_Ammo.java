package com.ayutaki.chinjufumod.particle;

import net.minecraft.client.particle.ParticleCrit;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class Particle_Ammo extends ParticleCrit {
	
	float oSize;
	
	public Particle_Ammo(World worldIn, double xIn, double yIn, double zIn, double spX, double spY, double spZ) {
		this(worldIn, xIn, yIn, zIn, spX, spY, spZ, 1.0F);
	}

	protected Particle_Ammo(World worldIn, double xIn, double yIn, double zIn, double spX, double spY, double spZ, float scaleIn) {
		super(worldIn, xIn, yIn, zIn, 0.0D, 0.0D, 0.0D);
		this.motionX *= (double)0.1F;
		this.motionY *= (double)0.1F;
		this.motionZ *= (double)0.1F;
		this.motionX += spX * 0.4D;
		this.motionY += spY * 0.4D;
		this.motionZ += spZ * 0.4D;
		float f = (float)(Math.random() * (double)0.3F + (double)0.6F);
		this.particleRed = f;
		this.particleGreen = f;
		this.particleBlue = f;
		this.particleScale *= 0.75F;
		this.particleScale *= scaleIn;
		this.oSize = this.particleScale;
		this.particleMaxAge = (int)(6.0D / (Math.random() * 0.8D + 0.6D));
		this.particleMaxAge = (int)((float)this.particleMaxAge * scaleIn);
		this.setParticleTextureIndex(146);
		
		this.canCollide = false;
		this.onUpdate();
	}

	@Override
	public void renderParticle(BufferBuilder buffer, Entity entityIn, float partialTicks, float rotX, float rotZ, float rotYZ, float rotXY, float rotXZ) {
		this.canCollide = false;
		super.renderParticle(buffer, entityIn, partialTicks, rotX, rotZ, rotYZ, rotXY, rotXZ);
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
	}
}
