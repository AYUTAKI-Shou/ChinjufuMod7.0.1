package com.ayutaki.chinjufumod.entity.render;

import com.ayutaki.chinjufumod.entity.SitableEntity;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SitableRenderer extends EntityRenderer<SitableEntity> {
	
	public SitableRenderer(EntityRendererProvider.Context context) {
		super(context);
	}

	@Override
	public ResourceLocation getTextureLocation(SitableEntity seatEntity) {
		return null;
	}

	@Override
	protected void renderNameTag(SitableEntity entity, Component component, PoseStack stack, MultiBufferSource source, int light) {}
}
