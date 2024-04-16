package com.ayutaki.chinjufumod.entity.render;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.entity.AbstractAmmo_Entity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Matrix3f;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderAmmo_Small<T extends AbstractAmmo_Entity> extends EntityRenderer<T> {

	public RenderAmmo_Small(EntityRendererManager manager) {
		super(manager);
	}

	@Override
	public ResourceLocation getTextureLocation(T entityIn) {
		return new ResourceLocation(ChinjufuMod.MOD_ID, "textures/entity/projectiles/ammo_large.png");
	}

	public void render(T entityIn, float entityYaw, float partialTicks, MatrixStack stackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		stackIn.pushPose();
		stackIn.mulPose(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.yRotO, entityIn.yRot) - 90.0F));
		stackIn.mulPose(Vector3f.ZP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.xRotO, entityIn.xRot)));
		/* int i = 0;
		float f = 0.0F;
		float f1 = 0.5F;
		float f2 = 0.0F;
		float f3 = 0.15625F;
		float f4 = 0.0F;
		float f5 = 0.15625F;
		float f6 = 0.15625F;
		float f7 = 0.3125F;
		float f8 = 0.05625F; */
		float f9 = (float)entityIn.shakeTime - partialTicks;
		if (f9 > 0.0F) {
			float f10 = -MathHelper.sin(f9 * 3.0F) * f9;
			stackIn.mulPose(Vector3f.ZP.rotationDegrees(f10));
		}

		stackIn.mulPose(Vector3f.XP.rotationDegrees(45.0F));
		stackIn.scale(0.05625F, 0.05625F, 0.05625F);
		stackIn.translate(-4.0D, 0.0D, 0.0D);
		IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		MatrixStack.Entry matrixstack$entry = stackIn.last();
		Matrix4f matrix4f = matrixstack$entry.pose();
		Matrix3f matrix3f = matrixstack$entry.normal();
		this.vertex(matrix4f, matrix3f, ivertexbuilder, -7, -2, -2, 0.0F, 0.15625F, -1, 0, 0, packedLightIn);
		this.vertex(matrix4f, matrix3f, ivertexbuilder, -7, -2, 2, 0.15625F, 0.15625F, -1, 0, 0, packedLightIn);
		this.vertex(matrix4f, matrix3f, ivertexbuilder, -7, 2, 2, 0.15625F, 0.3125F, -1, 0, 0, packedLightIn);
		this.vertex(matrix4f, matrix3f, ivertexbuilder, -7, 2, -2, 0.0F, 0.3125F, -1, 0, 0, packedLightIn);
		this.vertex(matrix4f, matrix3f, ivertexbuilder, -7, 2, -2, 0.0F, 0.15625F, 1, 0, 0, packedLightIn);
		this.vertex(matrix4f, matrix3f, ivertexbuilder, -7, 2, 2, 0.15625F, 0.15625F, 1, 0, 0, packedLightIn);
		this.vertex(matrix4f, matrix3f, ivertexbuilder, -7, -2, 2, 0.15625F, 0.3125F, 1, 0, 0, packedLightIn);
		this.vertex(matrix4f, matrix3f, ivertexbuilder, -7, -2, -2, 0.0F, 0.3125F, 1, 0, 0, packedLightIn);

		for(int j = 0; j < 4; ++j) {
			stackIn.mulPose(Vector3f.XP.rotationDegrees(90.0F));
			this.vertex(matrix4f, matrix3f, ivertexbuilder, -8, -2, 0, 0.0F, 0.0F, 0, 1, 0, packedLightIn);
			this.vertex(matrix4f, matrix3f, ivertexbuilder, 8, -2, 0, 0.5F, 0.0F, 0, 1, 0, packedLightIn);
			this.vertex(matrix4f, matrix3f, ivertexbuilder, 8, 2, 0, 0.5F, 0.15625F, 0, 1, 0, packedLightIn);
			this.vertex(matrix4f, matrix3f, ivertexbuilder, -8, 2, 0, 0.0F, 0.15625F, 0, 1, 0, packedLightIn);
		}

		stackIn.popPose();
		super.render(entityIn, entityYaw, partialTicks, stackIn, bufferIn, packedLightIn);
	}

	public void vertex(Matrix4f matrix, Matrix3f normals, IVertexBuilder builder, int offsetX, int offsetY, int offsetZ, float textureX, float textureY, int p_229039_9_, int p_229039_10_, int p_229039_11_, int p_229039_12_) {
		builder.vertex(matrix, (float)offsetX, (float)offsetY, (float)offsetZ).color(255, 255, 255, 255).uv(textureX, textureY).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(p_229039_12_).normal(normals, (float)p_229039_9_, (float)p_229039_11_, (float)p_229039_10_).endVertex();
	}

}
