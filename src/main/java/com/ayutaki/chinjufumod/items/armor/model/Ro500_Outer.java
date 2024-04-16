package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class Ro500_Outer {

	public static MeshDefinition createOuter() {
		MeshDefinition meshD = new MeshDefinition();
		PartDefinition root = meshD.getRoot();
		float scale = 0.55F;
		
		/** Base **/
		root.addOrReplaceChild("head", CubeListBuilder.create()
				.texOffs(0, 0)
				.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, new CubeDeformation(scale)), 
				PartPose.offset(0.0F, 0.0F, 0.0F));
		root.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
		PartDefinition bipedBody = root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("right_leg", CubeListBuilder.create()
				.texOffs(0, 16)
				.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, new CubeDeformation(scale)), 
				PartPose.offset(0.0F, 0.0F, 0.0F));
		root.addOrReplaceChild("left_leg", CubeListBuilder.create()
				.texOffs(0, 16)
				.mirror(true)
				.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, new CubeDeformation(scale)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		
		
		/** Add **/
		float ag = (float)Math.PI / 180;
		
		float ew = -7.5F;
		float sn = 2.35F + 5.75F;
		float hi = 7.0F - 3.75F;
		
		bipedBody.addOrReplaceChild("gyorai", CubeListBuilder.create()
				.texOffs(0, 50)
				.addBox(ew, hi, sn, 18, 2, 2, new CubeDeformation(-0.15F)), 
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -45 * ag, 0.0F, 0.0F)); //GYORAI
		bipedBody.addOrReplaceChild("gyorai2", CubeListBuilder.create()
				.texOffs(0, 54)
				.addBox(ew - 1.5F, hi, sn, 3, 2, 2, new CubeDeformation(-0.35F)), 
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -45 * ag, 0.0F, 0.0F)); //GYORAI2
		bipedBody.addOrReplaceChild("gyorai3", CubeListBuilder.create()
				.texOffs(0, 54)
				.addBox(ew - 3.0F, hi, sn, 3, 2, 2, new CubeDeformation(-0.55F)), 
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -45 * ag, 0.0F, 0.0F)); //GYORAI3
		bipedBody.addOrReplaceChild("gyorai4", CubeListBuilder.create()
				.texOffs(0, 54)
				.addBox(ew - 4.5F, hi, sn, 3, 2, 2, new CubeDeformation(-0.75F)), 
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -45 * ag, 0.0F, 0.0F)); //GYORAI4
		
		bipedBody.addOrReplaceChild("hane1", CubeListBuilder.create()
				.texOffs(12, 54)
				.addBox(ew - 3.9F, hi, sn + 0.875F, 3, 2, 2, new CubeDeformation(-0.15F)), 
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -45 * ag, 0.0F, 0.0F)); //HANE1
		bipedBody.addOrReplaceChild("hane2", CubeListBuilder.create()
				.texOffs(24, 54)
				.addBox(ew - 3.9F, hi + 0.875F, sn, 3, 2, 2, new CubeDeformation(-0.15F)), 
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -45 * ag, 0.0F, 0.0F)); //HANE2
		
		bipedBody.addOrReplaceChild("band_g", CubeListBuilder.create()
				.texOffs(0, 58)
				.addBox(-6.9F, hi, sn, 18, 2, 2, new CubeDeformation(-0.1F)), 
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -45 * ag, 0.0F, 0.0F)); //BAND_G
		bipedBody.addOrReplaceChild("band_l", CubeListBuilder.create()
				.texOffs(0, 62)
				.addBox(2.6F, -0.23F, 2.875F, 2, 9, 2, new CubeDeformation(0.2F)), 
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 5 * ag, 0.0F, 0.0F)); //BAND_L
		
		bipedBody.addOrReplaceChild("ransel", CubeListBuilder.create()
				.texOffs(0, 32)
				.addBox(-3.675F, 0.1F, -1.8F, 8, 12, 5, new CubeDeformation(0.75F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //RANSEL

		return meshD;
	}
}
