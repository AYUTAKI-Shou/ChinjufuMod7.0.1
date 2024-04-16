package com.ayutaki.chinjufumod.entity.render;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.entity.AbstractAmmo_Entity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Matrix3f;
import net.minecraft.client.renderer.Matrix4f;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class RenderAmmo_Large<T extends AbstractAmmo_Entity> extends EntityRenderer<T> {

	public RenderAmmo_Large(EntityRendererManager renderManager) {
		super(renderManager);
	}

	@Override
	public ResourceLocation getEntityTexture(AbstractAmmo_Entity entity) {
		return new ResourceLocation(ChinjufuMod.MOD_ID, "textures/entity/projectiles/ammo_large.png");
	}

	public void render(T entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		matrixStackIn.push();
		matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90.0F));
		matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
		float f9 = (float)entityIn.arrowShake - partialTicks;

		if (f9 > 0.0F) {
			float f10 = -MathHelper.sin(f9 * 3.0F) * f9;
			matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(f10));
		}

		matrixStackIn.rotate(Vector3f.XP.rotationDegrees(45.0F));
		matrixStackIn.scale(0.05625F, 0.05625F, 0.05625F);
		matrixStackIn.translate(-4.0D, 0.0D, 0.0D);
		IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
		MatrixStack.Entry matrixstack$entry = matrixStackIn.getLast();
		Matrix4f matrix4f = matrixstack$entry.getMatrix();
		Matrix3f matrix3f = matrixstack$entry.getNormal();
		this.drawVertex(matrix4f, matrix3f, ivertexbuilder, -7, -2, -2, 0.0F, 0.15625F, -1, 0, 0, packedLightIn);
		this.drawVertex(matrix4f, matrix3f, ivertexbuilder, -7, -2, 2, 0.15625F, 0.15625F, -1, 0, 0, packedLightIn);
		this.drawVertex(matrix4f, matrix3f, ivertexbuilder, -7, 2, 2, 0.15625F, 0.3125F, -1, 0, 0, packedLightIn);
		this.drawVertex(matrix4f, matrix3f, ivertexbuilder, -7, 2, -2, 0.0F, 0.3125F, -1, 0, 0, packedLightIn);
		this.drawVertex(matrix4f, matrix3f, ivertexbuilder, -7, 2, -2, 0.0F, 0.15625F, 1, 0, 0, packedLightIn);
		this.drawVertex(matrix4f, matrix3f, ivertexbuilder, -7, 2, 2, 0.15625F, 0.15625F, 1, 0, 0, packedLightIn);
		this.drawVertex(matrix4f, matrix3f, ivertexbuilder, -7, -2, 2, 0.15625F, 0.3125F, 1, 0, 0, packedLightIn);
		this.drawVertex(matrix4f, matrix3f, ivertexbuilder, -7, -2, -2, 0.0F, 0.3125F, 1, 0, 0, packedLightIn);

		for(int j = 0; j < 4; ++j) {
			matrixStackIn.rotate(Vector3f.XP.rotationDegrees(90.0F));
			this.drawVertex(matrix4f, matrix3f, ivertexbuilder, -8, -2, 0, 0.0F, 0.0F, 0, 1, 0, packedLightIn);
			this.drawVertex(matrix4f, matrix3f, ivertexbuilder, 8, -2, 0, 0.5F, 0.0F, 0, 1, 0, packedLightIn);
			this.drawVertex(matrix4f, matrix3f, ivertexbuilder, 8, 2, 0, 0.5F, 0.15625F, 0, 1, 0, packedLightIn);
			this.drawVertex(matrix4f, matrix3f, ivertexbuilder, -8, 2, 0, 0.0F, 0.15625F, 0, 1, 0, packedLightIn);
		}

		matrixStackIn.pop();
			super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
		}

	public void drawVertex(Matrix4f matrix, Matrix3f normals, IVertexBuilder vertexBuilder, int offsetX, int offsetY, int offsetZ, float textureX, float textureY, int p_229039_9_, int p_229039_10_, int p_229039_11_, int packedLightIn) {
		vertexBuilder.pos(matrix, (float)offsetX, (float)offsetY, (float)offsetZ).color(255, 255, 255, 255).tex(textureX, textureY).overlay(OverlayTexture.NO_OVERLAY).lightmap(packedLightIn).normal(normals, (float)p_229039_9_, (float)p_229039_11_, (float)p_229039_10_).endVertex();
	}

}
