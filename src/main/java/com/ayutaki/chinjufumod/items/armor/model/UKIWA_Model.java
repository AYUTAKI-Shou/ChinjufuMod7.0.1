package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class UKIWA_Model {

	public static MeshDefinition createInner() {
		MeshDefinition meshD = new MeshDefinition();
		PartDefinition root = meshD.getRoot();
		//float scale = 0.15F;
		
		/** Base **/
		root.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
		PartDefinition bipedBody = root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.ZERO);
		
		
		/** Add **/
		float ag = (float)Math.PI / 180;
		float hi = 9.5F;
		
		bipedBody.addOrReplaceChild("ukiwa_f", CubeListBuilder.create()
				.texOffs(0, 32)
				.addBox(-3.0F, hi, -6.56F, 6, 2, 2, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //UKIWA_F
		bipedBody.addOrReplaceChild("ukiwa_b", CubeListBuilder.create()
				.texOffs(0, 32)
				.addBox(-3.0F, hi, 4.56F, 6, 2, 2, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //UKIWA_B
		bipedBody.addOrReplaceChild("ukiwa_r", CubeListBuilder.create()
				.texOffs(0, 32)
				.addBox(-3.0F, hi, -6.56F, 6, 2, 2, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 90 * ag, 0.0F)); //UKIWA_R
		bipedBody.addOrReplaceChild("ukiwa_l", CubeListBuilder.create()
				.texOffs(0, 32)
				.addBox(-3.0F, hi, 4.56F, 6, 2, 2, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 90 * ag, 0.0F)); //UKIWA_L
		
		bipedBody.addOrReplaceChild("ukiwa_1", CubeListBuilder.create()
				.texOffs(16, 32)
				.addBox(-2.5F, hi, -6.75F, 5, 2, 2, new CubeDeformation(0.01F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 45 * ag, 0.0F)); //UKIWA_1
		bipedBody.addOrReplaceChild("ukiwa_2", CubeListBuilder.create()
				.texOffs(16, 36)
				.addBox(-2.5F, hi, 4.75F, 5, 2, 2, new CubeDeformation(0.01F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 45 * ag, 0.0F)); //UKIWA_2
		bipedBody.addOrReplaceChild("ukiwa_3", CubeListBuilder.create()
				.texOffs(16, 32)
				.addBox(-2.5F, hi, -6.75F, 5, 2, 2, new CubeDeformation(0.01F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -45 * ag, 0.0F)); //UKIWA_3
		bipedBody.addOrReplaceChild("ukiwa_4", CubeListBuilder.create()
				.texOffs(16, 36)
				.addBox(-2.5F, hi, 4.75F, 5, 2, 2, new CubeDeformation(0.01F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -45 * ag, 0.0F)); //UKIWA_4
		
		return meshD;
	}
	
	public static MeshDefinition ro500_OuterC() {
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
		float hi = 9.5F;
		
		bipedBody.addOrReplaceChild("ukiwa_f", CubeListBuilder.create()
				.texOffs(0, 32)
				.addBox(-3.0F, hi, -6.56F, 6, 2, 2, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //UKIWA_F
		bipedBody.addOrReplaceChild("ukiwa_b", CubeListBuilder.create()
				.texOffs(0, 32)
				.addBox(-3.0F, hi, 4.56F, 6, 2, 2, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //UKIWA_B
		bipedBody.addOrReplaceChild("ukiwa_r", CubeListBuilder.create()
				.texOffs(0, 32)
				.addBox(-3.0F, hi, -6.56F, 6, 2, 2, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 90 * ag, 0.0F)); //UKIWA_R
		bipedBody.addOrReplaceChild("ukiwa_l", CubeListBuilder.create()
				.texOffs(0, 32)
				.addBox(-3.0F, hi, 4.56F, 6, 2, 2, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 90 * ag, 0.0F)); //UKIWA_L
		
		bipedBody.addOrReplaceChild("ukiwa_1", CubeListBuilder.create()
				.texOffs(16, 32)
				.addBox(-2.5F, hi, -6.75F, 5, 2, 2, new CubeDeformation(0.01F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 45 * ag, 0.0F)); //UKIWA_1
		bipedBody.addOrReplaceChild("ukiwa_2", CubeListBuilder.create()
				.texOffs(16, 36)
				.addBox(-2.5F, hi, 4.75F, 5, 2, 2, new CubeDeformation(0.01F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 45 * ag, 0.0F)); //UKIWA_2
		bipedBody.addOrReplaceChild("ukiwa_3", CubeListBuilder.create()
				.texOffs(16, 32)
				.addBox(-2.5F, hi, -6.75F, 5, 2, 2, new CubeDeformation(0.01F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -45 * ag, 0.0F)); //UKIWA_3
		bipedBody.addOrReplaceChild("ukiwa_4", CubeListBuilder.create()
				.texOffs(16, 36)
				.addBox(-2.5F, hi, 4.75F, 5, 2, 2, new CubeDeformation(0.01F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -45 * ag, 0.0F)); //UKIWA_4

		return meshD;
	}
}
