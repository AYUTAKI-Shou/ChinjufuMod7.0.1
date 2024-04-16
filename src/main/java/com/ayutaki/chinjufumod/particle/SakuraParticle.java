package com.ayutaki.chinjufumod.particle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SakuraParticle extends Particle {

	private final Vec3d target;
	private float rot;

	public SakuraParticle(World world, double x, double y, double z, double spX, double spY, double spZ) {
		this(world, x, y, z, spX, spY, spZ, 1.0F);
	}

	public SakuraParticle(World world, double x, double y, double z, double spX, double spY, double spZ, float scale) {
		super(world, x, y, z, 0.0D, 0.0D, 0.0D);
		target = new Vec3d(x, y, z);
		this.motionX *= (double)0.1F;
		this.motionY *= (double)0.1F;
		this.motionZ *= (double)0.1F;
		this.motionX += spX * 0.4D;
		this.motionY += spY * 0.4D;
		this.motionZ += spZ * 0.4D;
		this.particleRed = this.particleGreen = this.particleBlue = 0.75F;
		this.particleAlpha = 0.95F;

		this.particleScale *= 0.5F;
		int i = (int)(32.0D / (Math.random() * 0.8D + 0.2D));
		this.particleMaxAge = (int)Math.max((float)i * 1.8F, 2.0F);

		this.canCollide = true;

		this.setParticleTexture(Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite("chinjufumod:particles/fallsakura"));

		this.onUpdate();
	}

	@Override
	public void onUpdate() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;

		if (this.particleAge++ >= this.particleMaxAge) {
			this.setExpired();
		}

		this.move(this.motionX, this.motionY, this.motionZ);

		this.motionY *= 0.699999988079071D;
		this.motionY -= 0.019999999552965164D;

		if (this.onGround) {
			this.motionX *= 0.699999988079071D;
			this.motionZ *= 0.699999988079071D;
		} else {
			rot += 5F;
			if (motionX == 0)
				motionX += (rand.nextBoolean() ? 1 : -1) * 0.001F;
			if (motionZ == 0)
				motionZ += (rand.nextBoolean() ? 1 : -1) * 0.001F;
			if (rand.nextInt(5) == 0)
				motionX += Math.signum(target.x - posX) * rand.nextFloat() * 0.005F;
			if (rand.nextInt(5) == 0)
				motionZ += Math.signum(target.z - posZ) * rand.nextFloat() * 0.005F;
		}
	}

	@Override
	public void renderParticle(BufferBuilder buffer, Entity entityIn, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ) {
		particleAlpha = 0.95F;
		super.renderParticle(buffer, entityIn, partialTicks, rotationX, rotationZ + MathHelper.cos((float) Math.toRadians((rot + partialTicks) % 360F)), rotationYZ, rotationXY, rotationXZ);
	}

	@Override
	public int getBrightnessForRender(float partialTicks) {
		return 240 | 240 << 16;
	}

	@Override
	public int getFXLayer() {
		return 1;
	}
}
