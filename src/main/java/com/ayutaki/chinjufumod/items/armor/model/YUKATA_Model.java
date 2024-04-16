package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class YUKATA_Model {
	
	public static MeshDefinition createInner() {
		MeshDefinition meshD = new MeshDefinition();
		PartDefinition root = meshD.getRoot();
		float scale = -0.1F;
		
		/** Base **/
		root.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.ZERO);
		PartDefinition bipedRightLeg = root.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.ZERO);
		PartDefinition bipedLeftLeg = root.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.ZERO);

		
		/** Add **/
		bipedRightLeg.addOrReplaceChild("right_suso", CubeListBuilder.create()
				.texOffs(0, 74)
				.addBox(-2.9F, -0.75F, -2.89F, 6, 14, 6, new CubeDeformation(scale)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //RIGHT_SUSO
		bipedLeftLeg.addOrReplaceChild("left_suso", CubeListBuilder.create()
				.texOffs(24, 74)
				.addBox(-7.1F, -0.75F, -2.9F, 10, 14, 6, new CubeDeformation(scale)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //LEFT_SUSO
	
		return meshD;
	}

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
		PartDefinition bipedRightArm = root.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.ZERO);
		PartDefinition bipedLeftArm = root.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.ZERO);
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
		bipedBody.addOrReplaceChild("musubi", CubeListBuilder.create()
				.texOffs(32, 32)
				.addBox(-4.0F, 4.875F, 2.66F, 8, 5, 1, new CubeDeformation(-0.15F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //MUSUBI
		bipedBody.addOrReplaceChild("musubi_t", CubeListBuilder.create()
				.texOffs(32, 40)
				.addBox(-4.125F, 7.05F, 2.38F, 8, 3, 1, new CubeDeformation(-0.425F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //MUSUBI_T
		bipedBody.addOrReplaceChild("musubi_t2", CubeListBuilder.create()
				.texOffs(32, 45)
				.addBox(-4.125F, 7.4F, 2.725F, 8, 4, 1, new CubeDeformation(-0.18F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //MUSUBI_T2
		bipedBody.addOrReplaceChild("obi", CubeListBuilder.create()
				.texOffs(0, 100)
				.addBox(-5.0F, 4.0F, -3.0F, 10, 7, 6, new CubeDeformation(-0.18F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //OBI
		
		bipedBody.addOrReplaceChild("ykt_body", CubeListBuilder.create()
				.texOffs(0, 32)
				.addBox(-5.0F, -0.5F, -3.0F, 10, 16, 6, new CubeDeformation(-0.2F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //YKT_BODY
		
		bipedRightArm.addOrReplaceChild("right_sode", CubeListBuilder.create()
				.texOffs(0, 54)
				.addBox(-3.5F, -2.5F, -2.5F, 5, 12, 5, new CubeDeformation(0.0F)), 
				PartPose.offset(0.0F, 0.0F, 0.0F)); //RIGHT_SODE
		bipedLeftArm.addOrReplaceChild("left_sode", CubeListBuilder.create()
				.texOffs(24, 54)
				.addBox(-1.5F, -2.5F, -2.5F, 5, 12, 5, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //LEFT_SODE

		return meshD;
	}
}
