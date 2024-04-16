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

/* net.minecraft.client.particle.FallingDustParticle */
@OnlyIn(Dist.CLIENT)
public class IchohParticle extends TextureSheetParticle {

	private final float rotSpeed;
	@SuppressWarnings("unused")
	private final SpriteSet sprites;
	
	public IchohParticle(ClientLevel worldIn, double xIn, double yIn, double zIn, double xSpeed, double ySpeed, double zSpeed, SpriteSet iSprite) {
		super(worldIn, xIn, yIn, zIn);

		this.quadSize *= 0.75F;
		int i = (int)(32.0D / (Math.random() * 0.8D + 0.2D));
		this.lifetime = (int)Math.max((float)i * 1.8F, 2.0F);
		this.rotSpeed = ((float)Math.random() - 0.5F) * 0.1F;
		this.roll = (float)Math.random() * ((float)Math.PI * 2.0F);
		
		this.sprites = iSprite;
	}

	@Override
	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
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
			this.yd -= (double)0.002F;
			this.yd = Math.max(this.yd, (double)-0.1F);

			this.oRoll = this.roll;
			if (!this.onGround) {
				this.roll += (float)Math.PI * this.rotSpeed * 1.6F;
			}
			else {
				this.yd = 0.0D;
			}
		}
	}
	
	@OnlyIn(Dist.CLIENT)
	public static class Provider implements ParticleProvider<SimpleParticleType> {

		private final SpriteSet sprite;

		public Provider(SpriteSet iSprite) {
			this.sprite = iSprite;
		}
		
		@Override
		public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double xIn, double yIn, double zIn,
				double xSpeed, double ySpeed, double zSpeed) {
			IchohParticle particle = new IchohParticle(worldIn, xIn, yIn, zIn, xSpeed, ySpeed, zSpeed, this.sprite);
			particle.pickSprite(this.sprite);
			return particle;
		}
	}
}
