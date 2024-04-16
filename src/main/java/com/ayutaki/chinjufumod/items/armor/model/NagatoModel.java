package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class NagatoModel {
	
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
		bipedBody.addOrReplaceChild("koshi_nagato", CubeListBuilder.create()
				.texOffs(32, 32)
				.addBox(-4.5F, 7.75F, -2.25F, 9, 5, 5, new CubeDeformation(0.52F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //KOSHI_NAGATO
		bipedBody.addOrReplaceChild("entotsu_nagato", CubeListBuilder.create()
				.texOffs(0, 70)
				.addBox(-11.0F, -6.5F, 3.51F, 22, 24, 2, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //ENTOTSU_NAGATO
		bipedBody.addOrReplaceChild("joint_nagato", CubeListBuilder.create()
				.texOffs(32, 102)
				.addBox(-2.0F, 8.25F, 2.5F, 4, 2, 3, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //JOINT_NAGATO
		
		bipedRightLeg.addOrReplaceChild("right_skirt", CubeListBuilder.create()
				.texOffs(0, 32)
				.addBox(-2.09F, -1.0F, -2.0F, 4, 12, 4, new CubeDeformation(scale)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //RIGHT_SKIRT
		bipedLeftLeg.addOrReplaceChild("left_skirt", CubeListBuilder.create()
				.texOffs(16, 32)
				.addBox(-1.91F, -1.0F, -1.99F, 4, 12, 4, new CubeDeformation(scale)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //LEFT_SKIRT
	
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
		root.addOrReplaceChild("body", CubeListBuilder.create()
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
		
		bipedRightArm.addOrReplaceChild("right_sode", CubeListBuilder.create()
				.texOffs(0, 68)
				.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, new CubeDeformation(0.3F)), 
				PartPose.offset(0.0F, 0.0F, 0.0F)); //RIGHT_SODE
		bipedLeftArm.addOrReplaceChild("left_sode", CubeListBuilder.create()
				.texOffs(0, 68)
				.mirror(true)
				.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, new CubeDeformation(0.3F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //LEFT_SODE
		
		bipedRightArm.addOrReplaceChild("right_sode_in", CubeListBuilder.create()
				.texOffs(16, 68)
				.addBox(-3.0F, -2.25F, -2.0F, 4, 12, 4, new CubeDeformation(0.26F)), 
				PartPose.offset(0.0F, 0.0F, 0.0F)); //RIGHT_SODEIN
		bipedLeftArm.addOrReplaceChild("left_sode_in", CubeListBuilder.create()
				.texOffs(16, 68)
				.mirror(true)
				.addBox(-1.0F, -2.25F, -2.0F, 4, 12, 4, new CubeDeformation(0.26F)), 
				PartPose.offset(0.0F, 0.0F, 0.0F)); //LEFT_SODEIN

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
