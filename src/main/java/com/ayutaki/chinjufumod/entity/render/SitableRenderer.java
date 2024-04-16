package com.ayutaki.chinjufumod.entity.render;

import com.ayutaki.chinjufumod.entity.SitableEntity;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class SitableRenderer extends EntityRenderer<SitableEntity> {

	public SitableRenderer(EntityRendererManager manager) {
		super(manager);
	}

	@Override
	public ResourceLocation getEntityTexture(SitableEntity seatEntity) {
		return null;
	}

	@Override
	protected void renderName(SitableEntity entity, String displayNameIn, MatrixStack matrixStack, IRenderTypeBuffer buffer, int packedLight) { }

}
