package com.ayutaki.chinjufumod.entity.render;

import com.ayutaki.chinjufumod.entity.SitableEntity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class SitableRenderer extends EntityRenderer<SitableEntity> {

	public SitableRenderer(EntityRendererManager manager) {
		super(manager);
	}

	@Override
	public ResourceLocation getTextureLocation(SitableEntity entity) {
		return null;
	}

}
