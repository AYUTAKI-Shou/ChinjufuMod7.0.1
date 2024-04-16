package com.ayutaki.chinjufumod.entity.render;

import com.ayutaki.chinjufumod.entity.KB_TypeZeroEntity;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderKB_TypeZero extends EntityRenderer<KB_TypeZeroEntity> {

	private final net.minecraft.client.renderer.ItemRenderer itemRenderer;

	public RenderKB_TypeZero(EntityRendererManager renderManager, net.minecraft.client.renderer.ItemRenderer itemRenderer) {
		super(renderManager);
		this.itemRenderer = itemRenderer;
		this.shadowRadius = 0.3F; //EntityRenderer
		this.shadowStrength = 1.0F;
	}

	public void render(KB_TypeZeroEntity entity, float entityYaw, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffer, int packedLight) {
		matrixStack.pushPose();
		matrixStack.scale(1.0F, 1.0F, 1.0F);
		matrixStack.mulPose(this.entityRenderDispatcher.cameraOrientation());

		if (entity.isReturning() != true) { matrixStack.mulPose(Vector3f.YP.rotationDegrees(180.0F)); }
		if (entity.isReturning() == true) { matrixStack.mulPose(Vector3f.YP.rotationDegrees(0.0F)); }

		this.itemRenderer.renderStatic(((IRendersAsItem)entity).getItem(), ItemCameraTransforms.TransformType.GROUND, packedLight, OverlayTexture.NO_OVERLAY, matrixStack, buffer);
		matrixStack.popPose();
		super.render(entity, entityYaw, partialTicks, matrixStack, buffer, packedLight);
	}

	@Override
	public ResourceLocation getTextureLocation(KB_TypeZeroEntity entity) {
		return null;
	}

}
