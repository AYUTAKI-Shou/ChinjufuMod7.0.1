package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ArmorStand;

public class BaseArmor extends HumanoidModel<LivingEntity> {

	public BaseArmor(ModelPart part) {
		super(part);
	}
	
	/* Fixed the display when wearing this on the ArmorStand. from ArmorStandArmorModel.class */
	public void setupAnim(LivingEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if (entityIn instanceof ArmorStand) {
			ArmorStand armorstand = (ArmorStand) entityIn;
			this.head.xRot = ((float)Math.PI / 180F) * armorstand.getHeadPose().getX();
			this.head.yRot = ((float)Math.PI / 180F) * armorstand.getHeadPose().getY();
			this.head.zRot = ((float)Math.PI / 180F) * armorstand.getHeadPose().getZ();
			this.head.setPos(0.0F, 1.0F, 0.0F);
			this.body.xRot = ((float)Math.PI / 180F) * armorstand.getBodyPose().getX();
			this.body.yRot = ((float)Math.PI / 180F) * armorstand.getBodyPose().getY();
			this.body.zRot = ((float)Math.PI / 180F) * armorstand.getBodyPose().getZ();
			this.leftArm.xRot = ((float)Math.PI / 180F) * armorstand.getLeftArmPose().getX();
			this.leftArm.yRot = ((float)Math.PI / 180F) * armorstand.getLeftArmPose().getY();
			this.leftArm.zRot = ((float)Math.PI / 180F) * armorstand.getLeftArmPose().getZ();
			this.rightArm.xRot = ((float)Math.PI / 180F) * armorstand.getRightArmPose().getX();
			this.rightArm.yRot = ((float)Math.PI / 180F) * armorstand.getRightArmPose().getY();
			this.rightArm.zRot = ((float)Math.PI / 180F) * armorstand.getRightArmPose().getZ();
			this.leftLeg.xRot = ((float)Math.PI / 180F) * armorstand.getLeftLegPose().getX();
			this.leftLeg.yRot = ((float)Math.PI / 180F) * armorstand.getLeftLegPose().getY();
			this.leftLeg.zRot = ((float)Math.PI / 180F) * armorstand.getLeftLegPose().getZ();
			this.leftLeg.setPos(1.9F, 11.0F, 0.0F);
			this.rightLeg.xRot = ((float)Math.PI / 180F) * armorstand.getRightLegPose().getX();
			this.rightLeg.yRot = ((float)Math.PI / 180F) * armorstand.getRightLegPose().getY();
			this.rightLeg.zRot = ((float)Math.PI / 180F) * armorstand.getRightLegPose().getZ();
			this.rightLeg.setPos(-1.9F, 11.0F, 0.0F);
			this.hat.copyFrom(this.head);
		}
		else super.setupAnim(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
	}
}
