package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class UKIWA_Inner extends BaseArmor {

	private ModelRenderer UKIWA_F;
	private ModelRenderer UKIWA_B;
	private ModelRenderer UKIWA_R;
	private ModelRenderer UKIWA_L;
	
	private ModelRenderer UKIWA_1;
	private ModelRenderer UKIWA_2;
	private ModelRenderer UKIWA_3;
	private ModelRenderer UKIWA_4;

	
	public UKIWA_Inner(float scale) {
		super(scale);
		float ag = (float)Math.PI / 180;
		float hi = 9.5F;

		UKIWA_F = new ModelRenderer(this, 0, 32);
		UKIWA_F.addBox(-3.0F, hi, -6.56F, 6, 2, 2, 0.0F);
		UKIWA_F.setRotationPoint(0F, 0F, 0F);
		UKIWA_B = new ModelRenderer(this, 0, 32);
		UKIWA_B.addBox(-3.0F, hi, 4.56F, 6, 2, 2, 0.0F);
		UKIWA_B.setRotationPoint(0F, 0F, 0F);
		UKIWA_R = new ModelRenderer(this, 0, 32);
		UKIWA_R.addBox(-3.0F, hi, -6.56F, 6, 2, 2, 0.0F);
		UKIWA_R.setRotationPoint(0F, 0F, 0F);
		UKIWA_R.rotateAngleY = 90 * ag;
		UKIWA_L = new ModelRenderer(this, 0, 32);
		UKIWA_L.addBox(-3.0F, hi, 4.56F, 6, 2, 2, 0.0F);
		UKIWA_L.setRotationPoint(0F, 0F, 0F);
		UKIWA_L.rotateAngleY = 90 * ag;

		UKIWA_1 = new ModelRenderer(this, 16, 32);
		UKIWA_1.addBox(-2.5F, hi, -6.75F, 5, 2, 2, 0.01F);
		UKIWA_1.setRotationPoint(0F, 0F, 0F);
		UKIWA_1.rotateAngleY = 45 * ag;
		UKIWA_2 = new ModelRenderer(this, 16, 36);
		UKIWA_2.addBox(-2.5F, hi, 4.75F, 5, 2, 2, 0.01F);
		UKIWA_2.setRotationPoint(0F, 0F, 0F);
		UKIWA_2.rotateAngleY = 45 * ag;
		UKIWA_3 = new ModelRenderer(this, 16, 32);
		UKIWA_3.addBox(-2.5F, hi, -6.75F, 5, 2, 2, 0.01F);
		UKIWA_3.setRotationPoint(0F, 0F, 0F);
		UKIWA_3.rotateAngleY = -45 * ag;
		UKIWA_4 = new ModelRenderer(this, 16, 36);
		UKIWA_4.addBox(-2.5F, hi, 4.75F, 5, 2, 2, 0.01F);
		UKIWA_4.setRotationPoint(0F, 0F, 0F);
		UKIWA_4.rotateAngleY = -45 * ag;


		bipedBody.addChild(UKIWA_F);
		bipedBody.addChild(UKIWA_B);
		bipedBody.addChild(UKIWA_R);
		bipedBody.addChild(UKIWA_L);
		
		bipedBody.addChild(UKIWA_1);
		bipedBody.addChild(UKIWA_2);
		bipedBody.addChild(UKIWA_3);
		bipedBody.addChild(UKIWA_4);
	}
}
