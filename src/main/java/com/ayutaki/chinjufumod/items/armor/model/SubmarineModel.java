package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class SubmarineModel {
	
	public static MeshDefinition createInner() {
		MeshDefinition meshD = new MeshDefinition();
		PartDefinition root = meshD.getRoot();
		float scale = 0.15F;
		
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
		bipedBody.addOrReplaceChild("eri", CubeListBuilder.create()
				.texOffs(32, 32)
				.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, new CubeDeformation(scale + 0.3F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //ERI
		bipedBody.addOrReplaceChild("uwagi", CubeListBuilder.create()
				.texOffs(32, 48)
				.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, new CubeDeformation(scale + 0.2F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //UWAGI
		bipedBody.addOrReplaceChild("tie", CubeListBuilder.create()
				.texOffs(32, 64)
				.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, new CubeDeformation(scale + 0.1F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //TIE
		
		bipedRightLeg.addOrReplaceChild("right_wa", CubeListBuilder.create()
				.texOffs(0, 48)
				.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, new CubeDeformation(scale + 0.1F)), 
				PartPose.offset(0.0F, 0.0F, 0.0F)); //RIGHT_WA
		bipedLeftLeg.addOrReplaceChild("left_wa", CubeListBuilder.create()
				.texOffs(0, 48)
				.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, new CubeDeformation(scale + 0.1F)),
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
		PartDefinition bipedRightArm = root.addOrReplaceChild("right_arm", CubeListBuilder.create()
				.texOffs(40, 16)
				.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, new CubeDeformation(scale)), 
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition bipedLeftArm = root.addOrReplaceChild("left_arm", CubeListBuilder.create()
				.texOffs(40, 16)
				.mirror(true)
				.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, new CubeDeformation(scale)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
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
		float ag = (float)Math.PI / 180;
		float hi = -7.55F;
		
		bipedHead.addOrReplaceChild("boushi_f", CubeListBuilder.create()
				.texOffs(20, 100)
				.addBox(-0.09F, -10.58F, -2.91F, 3, 3, 3, new CubeDeformation(-0.09F)), 
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 45 * ag, 0.0F)); //BOUSHI_F
		bipedHead.addOrReplaceChild("boushi_b", CubeListBuilder.create()
				.texOffs(0, 100)
				.addBox(-2.0F, -10.5F, -2.0F, 4, 3, 6, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //BOUSHI_B
		bipedHead.addOrReplaceChild("boushi_w", CubeListBuilder.create()
				.texOffs(32, 100)
				.addBox(-4.0F, hi, -9.0F, 8, 1, 8, new CubeDeformation(0.75F)), 
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -30 * ag, 0.0F, 0.0F)); //BOUSHI_W
		bipedHead.addOrReplaceChild("boushi_w2", CubeListBuilder.create()
				.texOffs(32, 110)
				.addBox(-4.0F, hi - 2.48F, -9.0F, 8, 1, 8, new CubeDeformation(0.75F)), 
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -30 * ag, 0.0F, 0.0F)); //BOUSHI_W2
		
		bipedBody.addOrReplaceChild("ransel", CubeListBuilder.create()
				.texOffs(0, 32)
				.addBox(-4.0F, 0.1F, -1.9F, 8, 12, 4, new CubeDeformation(1.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //RANSEL
		
		bipedBody.addOrReplaceChild("eri", CubeListBuilder.create()
				.texOffs(32, 32)
				.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, new CubeDeformation(scale + 0.2F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //ERI
		bipedBody.addOrReplaceChild("tie", CubeListBuilder.create()
				.texOffs(32, 48)
				.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, new CubeDeformation(scale + 0.1F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //TIE
		
		bipedRightArm.addOrReplaceChild("right_sode", CubeListBuilder.create()
				.texOffs(32, 80)
				.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, new CubeDeformation(scale - 0.2F)), 
				PartPose.offset(0.0F, 0.0F, 0.0F)); //RIGHT_SODE
		bipedLeftArm.addOrReplaceChild("left_sode", CubeListBuilder.create()
				.texOffs(48, 80)
				.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, new CubeDeformation(scale - 0.2F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //LEFT_SODE
		
		bipedRightLeg.addOrReplaceChild("right_sox", CubeListBuilder.create()
				.texOffs(0, 80)
				.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, new CubeDeformation(0.3F)), 
				PartPose.offset(0.0F, 0.0F, 0.0F)); //RIGHT_SOX
		bipedLeftLeg.addOrReplaceChild("left_sox", CubeListBuilder.create()
				.texOffs(0, 80)
				.mirror(true)
				.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, new CubeDeformation(0.3F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //LEFT_SOX

		return meshD;
	}
}
