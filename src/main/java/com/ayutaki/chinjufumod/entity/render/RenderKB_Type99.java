package com.ayutaki.chinjufumod.entity.render;

import com.ayutaki.chinjufumod.entity.KB_Type99Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderKB_Type99 extends EntityRenderer<KB_Type99Entity> {

	private final ItemRenderer itemRenderer;
	
	public RenderKB_Type99(EntityRendererProvider.Context renderManager, ItemRenderer itemRenderer) {
		super(renderManager);
		this.itemRenderer = itemRenderer;
		this.shadowRadius = 0.3F; //EntityRenderer
		this.shadowStrength = 1.0F;
	}

	public void render(KB_Type99Entity entity, float entityYaw, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int packedLight) {
		ItemStack stack = entity.getItem();
		BakedModel bakedmodel = this.itemRenderer.getModel(stack, entity.level(), (LivingEntity)null, entity.getId());
		
		matrixStack.pushPose();
		matrixStack.scale(1.0F, 1.0F, 1.0F);
		matrixStack.mulPose(this.entityRenderDispatcher.cameraOrientation());

		if (entity.isReturning() != true) { matrixStack.mulPose(Axis.YP.rotationDegrees(180.0F)); }
		if (entity.isReturning() == true) { matrixStack.mulPose(Axis.YP.rotationDegrees(0.0F)); }
		
		this.itemRenderer.render(stack, ItemDisplayContext.GROUND, false, matrixStack, buffer, packedLight, OverlayTexture.NO_OVERLAY, bakedmodel);
		matrixStack.popPose();
		super.render(entity, entityYaw, partialTicks, matrixStack, buffer, packedLight);
	}

	@Override
	public ResourceLocation getTextureLocation(KB_Type99Entity entity) {
		return null;
	}
}
