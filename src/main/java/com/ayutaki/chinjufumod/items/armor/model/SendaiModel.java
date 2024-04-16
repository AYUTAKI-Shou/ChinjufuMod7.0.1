package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class SendaiModel {
	
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
		float ag = (float)Math.PI / 180;

		bipedBody.addOrReplaceChild("eri", CubeListBuilder.create()
				.texOffs(32, 32)
				.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, new CubeDeformation(scale + 0.2F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //ERI
		bipedBody.addOrReplaceChild("tie", CubeListBuilder.create()
				.texOffs(32, 48)
				.addBox(-4.0F, 0.1F, -1.885F, 8, 12, 4, new CubeDeformation(scale + 0.15F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1 * ag, 0.0F, 0.0F)); //TIE
		bipedBody.addOrReplaceChild("ribon", CubeListBuilder.create()
				.texOffs(32, 64)
				.addBox(-4.0F, 0.1F, -2.35F, 8, 12, 4, new CubeDeformation(scale + 0.1F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 3 * ag, 0.0F, 0.0F)); //RIBON
		bipedBody.addOrReplaceChild("skirt", CubeListBuilder.create()
				.texOffs(32, 80)
				.addBox(-4.0F, 10.0F, -2.0F, 8, 12, 4, new CubeDeformation(scale + 0.15F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //SKIRT

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
		bipedRightLeg.addOrReplaceChild("tanshou", CubeListBuilder.create()
				.texOffs(0, 64)
				.addBox(-4.15F, 2.75F, -2.0F, 2, 2, 4, new CubeDeformation(-0.2F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //TANSHOU
	
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
		float hi = -1.75F;
		float ag = (float)Math.PI / 180;

		bipedHead.addOrReplaceChild("scarf", CubeListBuilder.create()
				.texOffs(32, 80)
				.addBox(-4.0F, hi, -4.0F, 8, 8, 8, new CubeDeformation(0.75F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //SCARF
		bipedHead.addOrReplaceChild("scarf_right", CubeListBuilder.create()
				.texOffs(48, 100)
				.addBox(-3.8F, hi + 2.5F, 0.0F, 2, 12, 6, new CubeDeformation(0.75F)), 
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -25 * ag, 0.0F)); //SCARF_RIGHT
		bipedHead.addOrReplaceChild("scarf_left", CubeListBuilder.create()
				.texOffs(48, 100)
				.addBox(1.8F, hi + 2.5F, 0.0F, 2, 12, 6, new CubeDeformation(0.75F)), 
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 25 * ag, 0.0F)); //SCARF_LEFT

		bipedBody.addOrReplaceChild("gyorai", CubeListBuilder.create()
				.texOffs(0, 72)
				.addBox(-16.25F, 7.25F, 3.7F, 25, 6, 1, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -20 * ag)); //GYORAI
		bipedBody.addOrReplaceChild("obi", CubeListBuilder.create()
				.texOffs(0, 32)
				.addBox(-5.25F, -0.45F, -2.45F, 10, 14, 6, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //OBI
		bipedBody.addOrReplaceChild("obi2", CubeListBuilder.create()
				.texOffs(0, 50)
				.addBox(-5.25F, -2.2F, 1.55F, 10, 14, 1, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 6 * ag, 0.0F, 0.0F)); //OBI2
		
		bipedBody.addOrReplaceChild("koshihimo_1", CubeListBuilder.create()
				.texOffs(0, 96)
				.addBox(-4.5F, 8.675F, -2.5F, 9, 1, 5, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //KOSHIHIMO_1
		bipedBody.addOrReplaceChild("koshihimo_2", CubeListBuilder.create()
				.texOffs(0, 96)
				.addBox(-5.9F, 8.75F, -2.5F, 9, 1, 5, new CubeDeformation(0.075F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -8 * ag)); //KOSHIHIMO_2
		bipedBody.addOrReplaceChild("koshihimo_3", CubeListBuilder.create()
				.texOffs(0, 104)
				.addBox(-9.0F, 10.0F, -2.4F, 10, 1, 6, new CubeDeformation(0.075F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -20 * ag)); //KOSHIHIMO_3
		
		bipedRightArm.addOrReplaceChild("right_sode", CubeListBuilder.create()
				.texOffs(32, 32)
				.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, new CubeDeformation(0.15F)), 
				PartPose.offset(0.0F, 0.0F, 0.0F)); //RIGHT_SODE
		bipedLeftArm.addOrReplaceChild("left_sode", CubeListBuilder.create()
				.texOffs(32, 32)
				.mirror(true)
				.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, new CubeDeformation(0.15F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //LEFT_SODE
		bipedRightArm.addOrReplaceChild("right_kote", CubeListBuilder.create()
				.texOffs(48, 32)
				.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, new CubeDeformation(0.26F)), 
				PartPose.offset(0.0F, 0.0F, 0.0F)); //RIGHT_KOTE
		bipedLeftArm.addOrReplaceChild("left_kote", CubeListBuilder.create()
				.texOffs(48, 32)
				.mirror(true)
				.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, new CubeDeformation(0.26F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //LEFT_KOTE
		
		bipedRightLeg.addOrReplaceChild("right_sox", CubeListBuilder.create()
				.texOffs(0, 80)
				.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, new CubeDeformation(0.15F)), 
				PartPose.offset(0.0F, 0.0F, 0.0F)); //RIGHT_SOX
		bipedLeftLeg.addOrReplaceChild("left_sox", CubeListBuilder.create()
				.texOffs(16, 80)
				.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, new CubeDeformation(0.15F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //LEFT_SOX

		return meshD;
	}
}
