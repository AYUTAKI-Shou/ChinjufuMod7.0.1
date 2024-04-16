package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class AkatsukiOuter extends BaseArmor {

	private ModelRenderer BOUSHI;
	private ModelRenderer BOUSHI2;

	private ModelRenderer ENTOTSU;
	private ModelRenderer JOINT;
	private ModelRenderer RENSOUHOU;
	private ModelRenderer GYORAI;

	private ModelRenderer ERI;
	private ModelRenderer RIBON;
	
	private ModelRenderer RIGHT_SODE;
	private ModelRenderer LEFT_SODE;
	
	private ModelRenderer RIGHT_SOX;
	private ModelRenderer LEFT_SOX;

	public AkatsukiOuter(float scale) {
		super(scale);

		BOUSHI = new ModelRenderer(this, 0, 100);
		BOUSHI.addBox(-3.0F, -10.1F, -3.0F, 6, 2, 6, 0.0F);
		BOUSHI.setRotationPoint(0F, 0F, 0F);
		BOUSHI.rotateAngleY = 0.3F;
		BOUSHI2 = new ModelRenderer(this, 0, 108);
		BOUSHI2.addBox(-3.0F, -10.1F, -5.0F, 6, 2, 8, 0.0F);
		BOUSHI2.setRotationPoint(0F, 0F, 0F);
		BOUSHI2.rotateAngleY = 0.3F;
		
		ENTOTSU = new ModelRenderer(this, 0, 50);
		ENTOTSU.addBox(-11.0F, -10.25F, 4.01F, 22, 28, 1, 0.0F);
		ENTOTSU.setRotationPoint(0F, 0F, 0F);
		JOINT = new ModelRenderer(this, 0, 40);
		JOINT.addBox(-2.0F, 1.0F, 2.0F, 4, 2, 3, 0.0F);
		JOINT.setRotationPoint(0F, 0F, 0F);
		RENSOUHOU = new ModelRenderer(this, 0, 32);
		RENSOUHOU.addBox(-8.0F, -0.75F, 3.0F, 8, 4, 4, 0.0F);
		RENSOUHOU.setRotationPoint(0F, 0F, 0F);
		GYORAI = new ModelRenderer(this, 28, 100);
		GYORAI.addBox(-4.0F, 5.25F, -2.0F, 8, 5, 10, 0.75F);
		GYORAI.setRotationPoint(0F, 0F, 0F);
		
		ERI = new ModelRenderer(this, 32, 32);
		ERI.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, scale + 0.1F);
		ERI.setRotationPoint(0F, 0F, 0F);
		RIBON = new ModelRenderer(this, 46, 50);
		RIBON.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 1, scale + 0.05F);
		RIBON.setRotationPoint(0F, 0F, 0F);
		
		RIGHT_SODE = new ModelRenderer(this, 32, 80);
		RIGHT_SODE.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, scale - 0.2F);
		RIGHT_SODE.setRotationPoint(0F, 0F, 0F);
		LEFT_SODE = new ModelRenderer(this, 32, 80);
		LEFT_SODE.mirror = true;
		LEFT_SODE.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, scale - 0.2F);
		LEFT_SODE.setRotationPoint(0F, 0F, 0F);

		RIGHT_SOX = new ModelRenderer(this, 0, 80);
		RIGHT_SOX.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.15F);
		RIGHT_SOX.setRotationPoint(0F, 0F, 0F);
		LEFT_SOX = new ModelRenderer(this, 0, 80);
		LEFT_SOX.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.15F);
		LEFT_SOX.setRotationPoint(0F, 0F, 0F);

		bipedHead.addChild(BOUSHI);
		bipedHead.addChild(BOUSHI2);

		bipedBody.addChild(ENTOTSU);
		bipedBody.addChild(JOINT);
		bipedBody.addChild(RENSOUHOU);
		bipedBody.addChild(GYORAI);
		
		bipedBody.addChild(ERI);
		bipedBody.addChild(RIBON);
		
		bipedRightArm.addChild(RIGHT_SODE);
		bipedLeftArm.addChild(LEFT_SODE);
		
		bipedRightLeg.addChild(RIGHT_SOX);
		bipedLeftLeg.addChild(LEFT_SOX);
	}
}
