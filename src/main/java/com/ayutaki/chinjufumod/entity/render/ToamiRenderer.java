package com.ayutaki.chinjufumod.entity.render;

import com.ayutaki.chinjufumod.entity.ToamiEntity;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.util.ResourceLocation;

public class ToamiRenderer extends EntityRenderer<ToamiEntity> {

	private final net.minecraft.client.renderer.ItemRenderer itemRenderer;

	public ToamiRenderer(EntityRendererManager renderManager, net.minecraft.client.renderer.ItemRenderer itemRenderer) {
		super(renderManager);
		this.itemRenderer = itemRenderer;
		this.shadowSize = 1.0F;
		this.shadowOpaque = 1.0F;
	}

	public void render(ToamiEntity entity, float entityYaw, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffer, int packedLight) {
		float time = entity.ticksExisted / 10.0F;
		
		matrixStack.push();
		matrixStack.scale(time, time, time);
		matrixStack.rotate(this.renderManager.getCameraOrientation());
		matrixStack.rotate(Vector3f.XN.rotationDegrees(0.0F));

		this.itemRenderer.renderItem(((IRendersAsItem)entity).getItem(), ItemCameraTransforms.TransformType.GROUND, packedLight, OverlayTexture.NO_OVERLAY, matrixStack, buffer);
		matrixStack.pop();
		super.render(entity, entityYaw, partialTicks, matrixStack, buffer, packedLight);
	}

	@Override
	public ResourceLocation getEntityTexture(ToamiEntity entity) {
		return null;
	}

}
