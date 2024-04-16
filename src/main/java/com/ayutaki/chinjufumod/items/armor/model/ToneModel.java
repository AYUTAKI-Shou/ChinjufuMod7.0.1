package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class ToneModel {

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
		root.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.ZERO);
		PartDefinition bipedLeftLeg = root.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.ZERO);
		
		
		/** Add **/
		float ag = (float)Math.PI / 180;

		bipedBody.addOrReplaceChild("eri", CubeListBuilder.create()
				.texOffs(0, 76)
				.addBox(-4.5F, 0.0F, -2.3F, 9, 12, 5, new CubeDeformation(0.45F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //ERI

		bipedBody.addOrReplaceChild("koshi_f", CubeListBuilder.create()
				.texOffs(32, 32)
				.addBox(-4.0F, 10.75F, -1.875F, 8, 12, 4, new CubeDeformation(0.55F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1 * ag, 0.0F, 0.0F)); //KOSHI_F
		bipedBody.addOrReplaceChild("koshi_b", CubeListBuilder.create()
				.texOffs(32, 48)
				.addBox(-4.0F, 10.75F, -2.125F, 8, 12, 4, new CubeDeformation(0.55F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1 * ag, 0.0F, 0.0F)); //KOSHI_B
		
		bipedLeftLeg.addOrReplaceChild("left_wa", CubeListBuilder.create()
				.texOffs(16, 32)
				.addBox(-2.0F, -1.0F, -2.0F, 4, 12, 4, new CubeDeformation(0.35F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //LEFT_WA
		bipedLeftLeg.addOrReplaceChild("left_gyorai", CubeListBuilder.create()
				.texOffs(16, 48)
				.addBox(-1.65F, -1.0F, -2.0F, 4, 12, 4, new CubeDeformation(0.4F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //LEFT_GYORAI
		
		return meshD;
	}

	public static MeshDefinition createOuter() {
		MeshDefinition meshD = new MeshDefinition();
		PartDefinition root = meshD.getRoot();
		float scale = 0.55F;
		
		/** Base **/
		PartDefinition bipedHead = root.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
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
		bipedHead.addOrReplaceChild("ribon", CubeListBuilder.create()
				.texOffs(32, 108)
				.addBox(-4.0F, -8.75F, -3.5F, 8, 8, 8, new CubeDeformation(0.3F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //RIBON
		
		bipedBody.addOrReplaceChild("uwagi", CubeListBuilder.create()
				.texOffs(0, 76)
				.addBox(-4.5F, 0.0F, -2.3F, 9, 12, 5, new CubeDeformation(0.4F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //UWAGI
		bipedBody.addOrReplaceChild("lr_guard", CubeListBuilder.create()
				.texOffs(0, 48)
				.addBox(-11.0F, -7.75F, -0.5F, 22, 20, 8, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //LR_GUARD
		bipedBody.addOrReplaceChild("entotsu", CubeListBuilder.create()
				.texOffs(0, 32)
				.addBox(-11.0F, -3.25F, 4.51F, 22, 14, 2, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //ENTOTSU
		bipedBody.addOrReplaceChild("joint", CubeListBuilder.create()
				.texOffs(48, 32)
				.addBox(-2.0F, 7.75F, 2.5F, 4, 2, 2, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //JOINT
		
		bipedRightArm.addOrReplaceChild("right_sode", CubeListBuilder.create()
				.texOffs(0, 94)
				.addBox(-3.5F, -2.25F, -2.25F, 5, 6, 5, new CubeDeformation(0.3F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //RIGHT_SODE
		bipedLeftArm.addOrReplaceChild("left_sode", CubeListBuilder.create()
				.texOffs(0, 94)
				.mirror(true)
				.addBox(-1.5F, -2.25F, -2.25F, 5, 6, 5, new CubeDeformation(0.3F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //LEFT_SODE
		bipedRightArm.addOrReplaceChild("right_sode2", CubeListBuilder.create()
				.texOffs(0, 108)
				.addBox(-3.5F, -2.25F, -2.25F, 5, 6, 5, new CubeDeformation(0.4F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //RIGHT_SODE2
		bipedLeftArm.addOrReplaceChild("left_sode2", CubeListBuilder.create()
				.texOffs(0, 108)
				.mirror(true)
				.addBox(-1.5F, -2.25F, -2.25F, 5, 6, 5, new CubeDeformation(0.4F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //LEFT_SODE2
		bipedLeftArm.addOrReplaceChild("left_tights", CubeListBuilder.create()
				.texOffs(48, 76)
				.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, new CubeDeformation(0.15F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //LEFT_TIGHTS
		
		bipedRightLeg.addOrReplaceChild("right_sox", CubeListBuilder.create()
				.texOffs(32, 92)
				.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, new CubeDeformation(0.15F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //RIGHT_SOX
		bipedLeftLeg.addOrReplaceChild("left_sox", CubeListBuilder.create()
				.texOffs(48, 92)
				.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, new CubeDeformation(0.15F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //LEFT_SOX

		return meshD;
	}
}
