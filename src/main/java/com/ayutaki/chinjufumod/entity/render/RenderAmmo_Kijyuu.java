package com.ayutaki.chinjufumod.entity.render;

import com.ayutaki.chinjufumod.entity.AbstractAmmo_Kijyuu;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderAmmo_Kijyuu<T extends AbstractAmmo_Kijyuu> extends EntityRenderer<T> {

	public RenderAmmo_Kijyuu(EntityRendererManager renderManager) {
		super(renderManager);
	}

	@Override
	public ResourceLocation getEntityTexture(AbstractAmmo_Kijyuu entity) {
		return null;
	}

	public void render(T entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) { }

}
