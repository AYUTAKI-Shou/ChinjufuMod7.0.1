package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class YuraOuter extends BaseArmor {

	// private ModelRenderer PONY;
	private ModelRenderer KAMIDOME;
	private ModelRenderer ENTOTSU;
	private ModelRenderer KOSHI_R;
	private ModelRenderer KOSHI_L;
	
	private ModelRenderer RIGHT_SODE;
	private ModelRenderer LEFT_SODE;
	private ModelRenderer RIGHT_KUTSU;
	private ModelRenderer LEFT_KUTSU;
	
	public YuraOuter(float scale) {
		super(scale);

		// PONY = new ModelRenderer(this, 32, 80);
		// PONY.addBox(-4.0F, 2.2F, -4.0F, 8, 16, 8, 1.1F);
		// PONY.setRotationPoint(0F, 0F, 0F);
		KAMIDOME = new ModelRenderer(this, 0, 108);
		KAMIDOME.addBox(-4.0F, -8.0F, -4.0F, 8, 4, 8, 0.3F);
		KAMIDOME.setRotationPoint(0F, 0F, 0F);
		ENTOTSU = new ModelRenderer(this, 0, 50);
		ENTOTSU.addBox(-11.0F, -10.0F, 4.01F, 22, 28, 1, 0.0F);
		ENTOTSU.setRotationPoint(0F, 0F, 0F);
		KOSHI_R = new ModelRenderer(this, 0, 32);
		KOSHI_R.addBox(-4.25F, -0.25F, -2.5F, 5, 12, 6, 0.5F);
		KOSHI_R.setRotationPoint(0F, 0F, 0F);
		KOSHI_L = new ModelRenderer(this, 0, 32);
		KOSHI_L.mirror = true;
		KOSHI_L.addBox(-0.75F, -0.25F, -2.5F, 5, 12, 6, 0.5F);
		KOSHI_L.setRotationPoint(0F, 0F, 0F);		

		RIGHT_SODE = new ModelRenderer(this, 32, 32);
		RIGHT_SODE.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, scale - 0.2F);
		RIGHT_SODE.setRotationPoint(0F, 0F, 0F);
		LEFT_SODE = new ModelRenderer(this, 32, 32);
		LEFT_SODE.mirror = true;
		LEFT_SODE.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, scale - 0.2F);
		LEFT_SODE.setRotationPoint(0F, 0F, 0F);
		
		RIGHT_KUTSU = new ModelRenderer(this, 0, 80);
		RIGHT_KUTSU.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.4F);
		RIGHT_KUTSU.setRotationPoint(0F, 0F, 0F);
		LEFT_KUTSU = new ModelRenderer(this, 0, 80);
		LEFT_KUTSU.mirror = true;
		LEFT_KUTSU.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.4F);
		LEFT_KUTSU.setRotationPoint(0F, 0F, 0F);


		// bipedHead.addChild(PONY);
		bipedHead.addChild(KAMIDOME);
		bipedBody.addChild(ENTOTSU);
		bipedBody.addChild(KOSHI_R);
		bipedBody.addChild(KOSHI_L);
		
		bipedRightArm.addChild(RIGHT_SODE);
		bipedLeftArm.addChild(LEFT_SODE);

		bipedRightLeg.addChild(RIGHT_KUTSU);
		bipedLeftLeg.addChild(LEFT_KUTSU);
	}
}
