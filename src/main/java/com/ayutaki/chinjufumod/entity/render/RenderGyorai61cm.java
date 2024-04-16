package com.ayutaki.chinjufumod.entity.render;

import com.ayutaki.chinjufumod.entity.Gyorai61cmEntity;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.util.ResourceLocation;

public class RenderGyorai61cm extends EntityRenderer<Gyorai61cmEntity> {

	private final net.minecraft.client.renderer.ItemRenderer itemRenderer;

	public RenderGyorai61cm(EntityRendererManager renderManager, net.minecraft.client.renderer.ItemRenderer itemRenderer) {
		super(renderManager);
		this.itemRenderer = itemRenderer;
		this.shadowSize = 0.25F;
		this.shadowOpaque = 1.0F;
	}

	public void render(Gyorai61cmEntity entity, float entityYaw, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffer, int packedLight) {
		matrixStack.push();
		matrixStack.scale(1.0F, 1.0F, 1.0F);
		matrixStack.rotate(this.renderManager.getCameraOrientation());
		matrixStack.rotate(Vector3f.YP.rotationDegrees(180.0F));

		this.itemRenderer.renderItem(((IRendersAsItem)entity).getItem(), ItemCameraTransforms.TransformType.GROUND, packedLight, OverlayTexture.NO_OVERLAY, matrixStack, buffer);
		matrixStack.pop();
		super.render(entity, entityYaw, partialTicks, matrixStack, buffer, packedLight);
	}

	@Override
	public ResourceLocation getEntityTexture(Gyorai61cmEntity entity) {
		return null;
	}

}
