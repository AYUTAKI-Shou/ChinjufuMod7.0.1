package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class ZuihouModel {
	
	public static MeshDefinition createInner() {
		MeshDefinition meshD = new MeshDefinition();
		PartDefinition root = meshD.getRoot();
		float scale = 0.3F;
		
		/** Base **/
		root.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
		PartDefinition bipedBody = root.addOrReplaceChild("body", CubeListBuilder.create()
				.texOffs(16, 16)
				.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, new CubeDeformation(scale)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		root.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.ZERO);
		PartDefinition bipedRightLeg = root.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.ZERO);
		PartDefinition bipedLeftLeg = root.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.ZERO);


		/** Add **/
		bipedBody.addOrReplaceChild("maekake", CubeListBuilder.create()
				.texOffs(0, 32)
				.addBox(-4.5F, 9.5F, -2.25F, 9, 5, 5, new CubeDeformation(0.5F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //MAEKAKE
		
		bipedBody.addOrReplaceChild("tome", CubeListBuilder.create()
				.texOffs(0, 64)
				.addBox(2.35F, 8.75F, 2.75F, 1, 1, 2, new CubeDeformation(-0.1F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.30F)); //TOME
		bipedBody.addOrReplaceChild("yadutsu", CubeListBuilder.create()
				.texOffs(0, 52)
				.addBox(-2.5F, 8.0F, 4.0F, 12, 2, 2, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.30F)); //YADUTU
		bipedBody.addOrReplaceChild("yadutsu_top", CubeListBuilder.create()
				.texOffs(0, 56)
				.addBox(-6.5F, 8.0F, 4.0F, 16, 2, 2, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.30F)); //YADUTU_TOP
		bipedBody.addOrReplaceChild("ya", CubeListBuilder.create()
				.texOffs(0, 60)
				.addBox(-7.0F, 8.0F, 4.0F, 16, 2, 2, new CubeDeformation(-0.4F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.30F)); //YA

		bipedRightLeg.addOrReplaceChild("right_hakama", CubeListBuilder.create()
				.texOffs(0, 42)
				.addBox(-2.5F, -1.0F, -2.25F, 5, 5, 5, new CubeDeformation(0.24F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //RIGHT_HAKAMA
		bipedLeftLeg.addOrReplaceChild("left_hakama", CubeListBuilder.create()
				.texOffs(0, 42)
				.mirror(true)
				.addBox(-2.5F, -1.0F, -2.25F, 5, 5, 5, new CubeDeformation(0.24F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //LEFT_HAKAMA
		bipedRightLeg.addOrReplaceChild("right_wa", CubeListBuilder.create()
				.texOffs(32, 32)
				.addBox(-2.0F, 4.0F, -2.0F, 4, 1, 4, new CubeDeformation(0.2F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //RIGHT_WA
		bipedLeftLeg.addOrReplaceChild("left_wa", CubeListBuilder.create()
				.texOffs(32, 32)
				.addBox(-2.0F, 4.0F, -2.0F, 4, 1, 4, new CubeDeformation(0.2F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //LEFT_WA
		
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
		root.addOrReplaceChild("hat", CubeListBuilder.create()
				.texOffs(32, 0)
				.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, new CubeDeformation(scale + 0.5F)), 
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition bipedBody = root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
		PartDefinition bipedRightArm = root.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.ZERO);
		PartDefinition bipedLeftArm = root.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.ZERO);
		PartDefinition bipedRightLeg = root.addOrReplaceChild("right_leg", CubeListBuilder.create()
				.texOffs(0, 16)
				.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, new CubeDeformation(scale)), 
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition bipedLeftLeg = root.addOrReplaceChild("left_leg", CubeListBuilder.create()
				.texOffs(0, 16)
				.mirror(true)
				.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, new CubeDeformation(scale)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		
		
		/** Add **/
		bipedBody.addOrReplaceChild("suso", CubeListBuilder.create()
				.texOffs(0, 48)
				.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, new CubeDeformation(0.25F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //SUSO
		bipedBody.addOrReplaceChild("dougi", CubeListBuilder.create()
				.texOffs(0, 32)
				.addBox(-4.0F, 0.0F, -2.0F, 8, 8, 4, new CubeDeformation(scale)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //DOUGI
		
		bipedRightArm.addOrReplaceChild("right_sode", CubeListBuilder.create()
				.texOffs(32, 32)
				.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, new CubeDeformation(scale - 0.1F)), 
				PartPose.offset(0.0F, 0.0F, 0.0F)); //RIGHT_SODE
		bipedLeftArm.addOrReplaceChild("left_sode", CubeListBuilder.create()
				.texOffs(32, 32).mirror(true)
				.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, new CubeDeformation(scale - 0.1F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //LEFT_SODE

		bipedRightLeg.addOrReplaceChild("right_sox", CubeListBuilder.create()
				.texOffs(48, 64)
				.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, new CubeDeformation(0.2F)), 
				PartPose.offset(0.0F, 0.0F, 0.0F)); //RIGHT_SOX
		bipedLeftLeg.addOrReplaceChild("left_sox", CubeListBuilder.create()
				.texOffs(48, 64).mirror(true)
				.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, new CubeDeformation(0.2F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //LEFT_SOX

		return meshD;
	}
}
