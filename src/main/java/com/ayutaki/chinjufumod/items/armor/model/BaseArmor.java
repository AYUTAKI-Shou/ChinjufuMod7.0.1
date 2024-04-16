package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ArmorStandEntity;

public class BaseArmor extends BipedModel<LivingEntity> {

	public BaseArmor(float scale) {
		super(scale, 0.0F, 64, 120);
		textureWidth = 64;
		textureHeight = 120;
	}

	protected void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	/* アーマースタンドでの向き不一致を防止 */
	public void setRotationAngles(LivingEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

		if (entityIn instanceof ArmorStandEntity) {
			ArmorStandEntity armorstand = (ArmorStandEntity) entityIn;
			this.bipedHead.rotateAngleX = ((float)Math.PI / 180F) * armorstand.getHeadRotation().getX();
			this.bipedHead.rotateAngleY = ((float)Math.PI / 180F) * armorstand.getHeadRotation().getY();
			this.bipedHead.rotateAngleZ = ((float)Math.PI / 180F) * armorstand.getHeadRotation().getZ();
			this.bipedHead.setRotationPoint(0.0F, 1.0F, 0.0F);
			this.bipedBody.rotateAngleX = ((float)Math.PI / 180F) * armorstand.getBodyRotation().getX();
			this.bipedBody.rotateAngleY = ((float)Math.PI / 180F) * armorstand.getBodyRotation().getY();
			this.bipedBody.rotateAngleZ = ((float)Math.PI / 180F) * armorstand.getBodyRotation().getZ();
			this.bipedLeftArm.rotateAngleX = ((float)Math.PI / 180F) * armorstand.getLeftArmRotation().getX();
			this.bipedLeftArm.rotateAngleY = ((float)Math.PI / 180F) * armorstand.getLeftArmRotation().getY();
			this.bipedLeftArm.rotateAngleZ = ((float)Math.PI / 180F) * armorstand.getLeftArmRotation().getZ();
			this.bipedRightArm.rotateAngleX = ((float)Math.PI / 180F) * armorstand.getRightArmRotation().getX();
			this.bipedRightArm.rotateAngleY = ((float)Math.PI / 180F) * armorstand.getRightArmRotation().getY();
			this.bipedRightArm.rotateAngleZ = ((float)Math.PI / 180F) * armorstand.getRightArmRotation().getZ();
			this.bipedLeftLeg.rotateAngleX = ((float)Math.PI / 180F) * armorstand.getLeftLegRotation().getX();
			this.bipedLeftLeg.rotateAngleY = ((float)Math.PI / 180F) * armorstand.getLeftLegRotation().getY();
			this.bipedLeftLeg.rotateAngleZ = ((float)Math.PI / 180F) * armorstand.getLeftLegRotation().getZ();
			this.bipedLeftLeg.setRotationPoint(1.9F, 11.0F, 0.0F);
			this.bipedRightLeg.rotateAngleX = ((float)Math.PI / 180F) * armorstand.getRightLegRotation().getX();
			this.bipedRightLeg.rotateAngleY = ((float)Math.PI / 180F) * armorstand.getRightLegRotation().getY();
			this.bipedRightLeg.rotateAngleZ = ((float)Math.PI / 180F) * armorstand.getRightLegRotation().getZ();
			this.bipedRightLeg.setRotationPoint(-1.9F, 11.0F, 0.0F);
			this.bipedHeadwear.copyModelAngles(this.bipedHead);
		}

		else super.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
	}
}
