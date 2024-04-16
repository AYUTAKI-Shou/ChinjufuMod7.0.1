package com.ayutaki.chinjufumod.entity.render;

import com.ayutaki.chinjufumod.entity.AbstractAmmo_Kijyuu;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderAmmo_Kijyuu<T extends AbstractAmmo_Kijyuu> extends EntityRenderer<T> {

	public RenderAmmo_Kijyuu(EntityRendererManager manager) {
		super(manager);
	}

	@Override
	public ResourceLocation getTextureLocation(T entityIn) {
		return null;
	}
}
