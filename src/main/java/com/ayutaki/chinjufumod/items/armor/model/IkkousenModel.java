package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class IkkousenModel {
	
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
		
		bipedRightLeg.addOrReplaceChild("right_hakama", CubeListBuilder.create()
				.texOffs(0, 42)
				.addBox(-2.5F, -1.0F, -2.25F, 5, 5, 5, new CubeDeformation(0.24F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //RIGHT_HAKAMA
		bipedLeftLeg.addOrReplaceChild("left_hakama", CubeListBuilder.create()
				.texOffs(0, 42)
				.mirror(true)
				.addBox(-2.5F, -1.0F, -2.25F, 5, 5, 5, new CubeDeformation(0.24F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //LEFT_HAKAMA
	
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
		float ag = (float)Math.PI / 180;
		float hi = -1.75F;
		
		bipedHead.addOrReplaceChild("kamidome", CubeListBuilder.create()
				.texOffs(0, 108)
				.addBox(-4.0F, -8.0F, -4.0F, 8, 4, 8, new CubeDeformation(0.3F)), 
				PartPose.offset(0.0F, 0.0F, 0.0F)); //KAMIDOME
		bipedHead.addOrReplaceChild("scarf", CubeListBuilder.create()
				.texOffs(32, 84)
				.addBox(-4.0F, hi, -4.0F, 8, 8, 8, new CubeDeformation(0.75F)), 
				PartPose.offset(0.0F, 0.0F, 0.0F)); //SCARF
		bipedHead.addOrReplaceChild("scarf_right", CubeListBuilder.create()
				.texOffs(32, 100)
				.addBox(0.0F, hi + 2.0F, -3.0F, 6, 12, 2, new CubeDeformation(0.75F)), 
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -45 * ag, 0.0F)); //SCARF_RIGHT
		bipedHead.addOrReplaceChild("scarf_left", CubeListBuilder.create()
				.texOffs(32, 100)
				.addBox(-1.0F, hi + 3.5F, 1.0F, 6, 12, 2, new CubeDeformation(0.75F)), 
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 80 * ag, 0.0F)); //SCARF_LEFT
		
		bipedHead.addOrReplaceChild("scarf2_right", CubeListBuilder.create()
				.texOffs(48, 100)
				.addBox(0.0F, hi + 2.0F, -3.0F, 6, 12, 2, new CubeDeformation(0.75F)), 
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -45 * ag, 0.0F)); //SCARF2_RIGHT
		bipedHead.addOrReplaceChild("scarf2_left", CubeListBuilder.create()
				.texOffs(48, 100)
				.addBox(-1.25F, hi + 3.5F, -3.0F, 6, 12, 2, new CubeDeformation(0.75F)), 
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -80 * ag, 0.0F)); //SCARF2_LEFT
		

		bipedBody.addOrReplaceChild("suso", CubeListBuilder.create()
				.texOffs(0, 48)
				.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, new CubeDeformation(0.25F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //SUSO
		bipedBody.addOrReplaceChild("dougi", CubeListBuilder.create()
				.texOffs(0, 32)
				.addBox(-4.0F, 0.0F, -2.0F, 8, 8, 4, new CubeDeformation(scale)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //DOUGI
		
		bipedBody.addOrReplaceChild("yadutsu", CubeListBuilder.create()
				.texOffs(28, 56)
				.addBox(-3.3F, 6.3F, 3.0F, 14, 2, 2, new CubeDeformation(-0.1F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.40F)); //YADUTU
		bipedBody.addOrReplaceChild("ya", CubeListBuilder.create()
				.texOffs(28, 60)
				.addBox(-7.3F, 6.3F, 3.0F, 16, 2, 2, new CubeDeformation(-0.4F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.40F)); //YA
		bipedBody.addOrReplaceChild("antena", CubeListBuilder.create()
				.texOffs(0, 64)
				.addBox(-11.25F, -0.85F, -0.5F, 16, 16, 2, new CubeDeformation(0.75F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.20F, 0.0F, 0.0F)); //ANTENA
		bipedBody.addOrReplaceChild("tome", CubeListBuilder.create()
				.texOffs(48, 80)
				.addBox(0.5F, 0.5F, 1.4F, 1, 1, 1, new CubeDeformation(0.15F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.20F, 0.0F, 45 * ag)); //TOME
		

		bipedRightArm.addOrReplaceChild("right_sode", CubeListBuilder.create()
				.texOffs(32, 32)
				.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, new CubeDeformation(scale - 0.1F)), 
				PartPose.offset(0.0F, 0.0F, 0.0F)); //RIGHT_SODE
		bipedRightArm.addOrReplaceChild("right_kanpan", CubeListBuilder.create()
				.texOffs(0, 84)
				.addBox(-3.0F, -3.0F, -2.0F, 4, 20, 4, new CubeDeformation(scale)), 
				PartPose.offset(0.0F, 0.0F, 0.0F)); //RIGHT_KANPAN
		bipedLeftArm.addOrReplaceChild("left_sode", CubeListBuilder.create()
				.texOffs(48, 32)
				.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, new CubeDeformation(scale - 0.1F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //LEFT_SODE
		bipedLeftArm.addOrReplaceChild("left_kanpan", CubeListBuilder.create()
				.texOffs(16, 84)
				.addBox(-1.0F, -3.0F, -2.0F, 4, 20, 4, new CubeDeformation(scale)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //LEFT_KANPAN


		bipedRightLeg.addOrReplaceChild("right_sox", CubeListBuilder.create()
				.texOffs(48, 64)
				.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, new CubeDeformation(0.15F)), 
				PartPose.offset(0.0F, 0.0F, 0.0F)); //RIGHT_SOX
		bipedLeftLeg.addOrReplaceChild("left_sox", CubeListBuilder.create()
				.texOffs(48, 64)
				.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, new CubeDeformation(0.15F)),
				PartPose.offset(0.0F, 0.0F, 0.0F)); //LEFT_SOX
		
		return meshD;
	}
}
