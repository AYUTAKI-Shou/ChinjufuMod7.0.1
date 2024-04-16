package com.ayutaki.chinjufumod.entity.render;

import com.ayutaki.chinjufumod.entity.ToamiEntity;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;

public class ToamiRenderer extends EntityRenderer<ToamiEntity> {

	private final net.minecraft.client.renderer.ItemRenderer itemRenderer;
	
	public ToamiRenderer(EntityRendererManager renderManager, net.minecraft.client.renderer.ItemRenderer itemRenderer) {
		super(renderManager);
		this.itemRenderer = itemRenderer;
		this.shadowRadius = 1.0F;
		this.shadowStrength = 1.0F;
	}

	public void render(ToamiEntity entity, float entityYaw, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffer, int packedLight) {
		float time = entity.tickCount / 10.0F;
		
		matrixStack.pushPose();
		matrixStack.scale(time, time, time);
		matrixStack.mulPose(this.entityRenderDispatcher.cameraOrientation());
		matrixStack.mulPose(Vector3f.XN.rotationDegrees(0.0F));

		this.itemRenderer.renderStatic(((IRendersAsItem)entity).getItem(), ItemCameraTransforms.TransformType.GROUND, packedLight, OverlayTexture.NO_OVERLAY, matrixStack, buffer);
		matrixStack.popPose();
		super.render(entity, entityYaw, partialTicks, matrixStack, buffer, packedLight);
	}

	@Override
	public ResourceLocation getTextureLocation(ToamiEntity entity) {
		return null;
	}

}
