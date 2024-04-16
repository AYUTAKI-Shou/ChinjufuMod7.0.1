package com.ayutaki.chinjufumod.entity.render;

import com.ayutaki.chinjufumod.entity.ToamiEntity;
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
public class ToamiRenderer extends EntityRenderer<ToamiEntity> {

	private final ItemRenderer itemRenderer;
	
	public ToamiRenderer(EntityRendererProvider.Context renderManager, ItemRenderer itemRenderer) {
		super(renderManager);
		this.itemRenderer = itemRenderer;
		this.shadowRadius = 1.0F;
		this.shadowStrength = 1.0F;
	}

	@Override
	public void render(ToamiEntity entity, float entityYaw, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int packedLight) {
		float time = entity.tickCount / 10.0F;
		ItemStack stack = entity.getItem();
		BakedModel bakedmodel = this.itemRenderer.getModel(stack, entity.level(), (LivingEntity)null, entity.getId());
		
		matrixStack.pushPose();
		matrixStack.scale(time, time, time);
		matrixStack.mulPose(this.entityRenderDispatcher.cameraOrientation());
		matrixStack.mulPose(Axis.XN.rotationDegrees(0.0F)); //1.18->1.20

		this.itemRenderer.render(stack, ItemDisplayContext.GROUND, false, matrixStack, buffer, packedLight, OverlayTexture.NO_OVERLAY, bakedmodel);
		matrixStack.popPose();
		super.render(entity, entityYaw, partialTicks, matrixStack, buffer, packedLight);
	}

	@Override
	public ResourceLocation getTextureLocation(ToamiEntity entity) {
		return null;
	}
}
