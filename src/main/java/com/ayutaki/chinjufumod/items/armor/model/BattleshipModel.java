package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class BattleshipModel {
	
	public static MeshDefinition createInner() {
		MeshDefinition meshD = new MeshDefinition();
		PartDefinition root = meshD.getRoot();
		float scale = 0.4F;
		
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
		bipedBody.addOrReplaceChild("koshi_kongou", CubeListBuilder.create()
				.texOffs(32, 42)
				.addBox(-4.5F, 7.0F, -2.25F, 9, 5, 5, new CubeDeformation(0.4F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //KOSHI_KONGOU
		
		bipedRightLeg.addOrReplaceChild("right_skirt", CubeListBuilder.create()
				.texOffs(0, 32)
				.addBox(-2.09F, -1.0F, -2.0F, 4, 12, 4, new CubeDeformation(scale)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //RIGHT_SKIRT
		bipedLeftLeg.addOrReplaceChild("left_skirt", CubeListBuilder.create()
				.texOffs(16, 32)
				.addBox(-1.91F, -1.0F, -1.99F, 4, 12, 4, new CubeDeformation(scale)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //LEFT_SKIRT
		
		bipedRightLeg.addOrReplaceChild("right_wa", CubeListBuilder.create()
				.texOffs(0, 48)
				.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, new CubeDeformation(0.3F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //RIGHT_WA
		bipedLeftLeg.addOrReplaceChild("left_wa", CubeListBuilder.create()
				.texOffs(16, 48)
				.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, new CubeDeformation(0.3F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //LEFT_WA
	
		return meshD;
	}

	public static MeshDefinition createOuter() {
		MeshDefinition meshD = new MeshDefinition();
		PartDefinition root = meshD.getRoot();
		float scale = 0.55F;
		
		/** Base **/
		PartDefinition bipedHead = root.addOrReplaceChild("head", CubeListBuilder.create()
				.texOffs(0, 0)
				.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, new CubeDeformation(scale)), 
				PartPose.offset(0.0F, 0.0F, 0.0F));
		root.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
		PartDefinition bipedBody = root.addOrReplaceChild("body", CubeListBuilder.create()
				.texOffs(16, 16)
				.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, new CubeDeformation(scale)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
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
		bipedHead.addOrReplaceChild("antena", CubeListBuilder.create()
				.texOffs(0, 100)
				.addBox(-8.0F, -12.5F, 0.5F, 16, 8, 8, new CubeDeformation(0.5F)), 
				PartPose.offset(0.0F, 0.0F, 0.0F)); //ANTENA

		bipedBody.addOrReplaceChild("entotsu", CubeListBuilder.create()
				.texOffs(0, 32)
				.addBox(-11.0F, -9.0F, 3.51F, 22, 26, 2, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //ENTOTSU
		bipedBody.addOrReplaceChild("joint_kongou", CubeListBuilder.create()
				.texOffs(0, 60)
				.addBox(-2.0F, 8.0F, 2.5F, 4, 2, 3, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //JOINT_KONGOU
		bipedBody.addOrReplaceChild("joint_fusou", CubeListBuilder.create()
				.texOffs(16, 60)
				.addBox(-1.5F, 6.0F, 2.5F, 3, 2, 3, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //JOINT_FUSOU

		bipedBody.addOrReplaceChild("suso", CubeListBuilder.create()
				.texOffs(40, 60)
				.addBox(-4.0F, 13.0F, -2.0F, 8, 6, 4, new CubeDeformation(scale)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //SUSO
		
		bipedRightArm.addOrReplaceChild("right_sode", CubeListBuilder.create()
				.texOffs( 0, 84)
				.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, new CubeDeformation(scale - 0.1F)), 
				PartPose.offset(0.0F, 0.0F, 0.0F)); //RIGHT_SODE
		bipedLeftArm.addOrReplaceChild("left_sode", CubeListBuilder.create()
				.texOffs(0, 84)
				.mirror(true)
				.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, new CubeDeformation(scale - 0.1F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //LEFT_SODE
		bipedRightArm.addOrReplaceChild("right_sode_in", CubeListBuilder.create()
				.texOffs(16, 84)
				.addBox(-3.0F, -2.125F, -2.0F, 4, 12, 4, new CubeDeformation(scale - 0.15F)), 
				PartPose.offset(0.0F, 0.0F, 0.0F)); //RIGHT_SODEIN
		bipedLeftArm.addOrReplaceChild("left_sode_in", CubeListBuilder.create()
				.texOffs(16, 84)
				.mirror(true)
				.addBox(-1.0F, -2.125F, -2.0F, 4, 12, 4, new CubeDeformation(scale - 0.15F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //LEFT_SODEIN
		
		bipedRightArm.addOrReplaceChild("right_wa", CubeListBuilder.create()
				.texOffs(0, 68)
				.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, new CubeDeformation(0.26F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //RIGHT_WA
		bipedLeftArm.addOrReplaceChild("left_wa", CubeListBuilder.create()
				.texOffs(0, 68).mirror(true)
				.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, new CubeDeformation(0.26F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //LEFT_WA
		bipedRightArm.addOrReplaceChild("right_fsode", CubeListBuilder.create()
				.texOffs(16, 68)
				.addBox(-3.0F, 2.36F, -2.0F, 4, 12, 4, new CubeDeformation(scale - 0.1F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //RIGHT_FSODE
		bipedLeftArm.addOrReplaceChild("left_fsode", CubeListBuilder.create()
				.texOffs(16, 68).mirror(true)
				.addBox(-1.0F, 2.36F, -2.0F, 4, 12, 4, new CubeDeformation(scale - 0.1F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //LEFT_FSODE
		
		bipedRightLeg.addOrReplaceChild("right_sox", CubeListBuilder.create()
				.texOffs(48, 84)
				.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, new CubeDeformation(0.15F)), 
				PartPose.offset(0.0F, 0.0F, 0.0F)); //RIGHT_SOX
		bipedLeftLeg.addOrReplaceChild("left_sox", CubeListBuilder.create()
				.texOffs(48, 84)
				.mirror(true)
				.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, new CubeDeformation(0.15F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //LEFT_SOX
		bipedRightLeg.addOrReplaceChild("right_boot", CubeListBuilder.create()
				.texOffs(48, 100)
				.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, new CubeDeformation(0.3F)), 
				PartPose.offset(0.0F, 0.0F, 0.0F)); //RIGHT_BOOT
		bipedLeftLeg.addOrReplaceChild("left_boot", CubeListBuilder.create()
				.texOffs(48, 100)
				.mirror(true)
				.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, new CubeDeformation(0.3F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //LEFT_BOOT

		return meshD;
	}
}
