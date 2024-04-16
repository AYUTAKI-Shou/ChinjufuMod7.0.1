package com.ayutaki.chinjufumod.entity.render;

import org.joml.Matrix3f;
import org.joml.Matrix4f;

import com.ayutaki.chinjufumod.entity.AbstractAmmo_Kijyuu;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderAmmo_Kijyuu<T extends AbstractAmmo_Kijyuu> extends EntityRenderer<T> {

	public RenderAmmo_Kijyuu(EntityRendererProvider.Context renderManager) {
		super(renderManager);
	}

	@Override
	public ResourceLocation getTextureLocation(T entityIn) {
		return null;
	}
	
	public void render(T entityIn, float entityYaw, float partialTicks, PoseStack stackIn, MultiBufferSource bufferIn, int packedLightIn) { }

	public void vertex(Matrix4f matrix, Matrix3f normals, VertexConsumer builder, int offsetX, int offsetY, int offsetZ, 
			float textureX, float textureY, int p_113834_, int p_113835_, int p_113836_, int p_113837_) { }
}
