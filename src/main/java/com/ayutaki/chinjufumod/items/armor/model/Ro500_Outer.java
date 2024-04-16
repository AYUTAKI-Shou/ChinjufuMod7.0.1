package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class Ro500_Outer extends BaseArmor {

	private ModelRenderer GYORAI;
	private ModelRenderer GYORAI2;
	private ModelRenderer GYORAI3;
	private ModelRenderer GYORAI4;
	private ModelRenderer HANE1;
	private ModelRenderer HANE2;
	
	private ModelRenderer RANSEL;
	private ModelRenderer BAND_G;
	private ModelRenderer BAND_L;
	
	public Ro500_Outer(float scale) {
		super(scale);
		float ag = (float)Math.PI / 180;
		
		float ew = -7.5F;
		float sn = 2.35F + 5.75F;
		float hi = 7.0F - 3.75F;
		
		GYORAI = new ModelRenderer(this, 0, 50);
		GYORAI.addBox(ew, hi, sn, 18, 2, 2, -0.15F);
		GYORAI.setRotationPoint(0F, 0F, 0F);
		GYORAI.rotateAngleX = -45 * ag;
		GYORAI2 = new ModelRenderer(this, 0, 54);
		GYORAI2.addBox(ew - 1.5F, hi, sn, 3, 2, 2, -0.35F);
		GYORAI2.setRotationPoint(0F, 0F, 0F);
		GYORAI2.rotateAngleX = -45 * ag;
		GYORAI3 = new ModelRenderer(this, 0, 54);
		GYORAI3.addBox(ew - 3.0F, hi, sn, 3, 2, 2, -0.55F);
		GYORAI3.setRotationPoint(0F, 0F, 0F);
		GYORAI3.rotateAngleX = -45 * ag;
		GYORAI4 = new ModelRenderer(this, 0, 54);
		GYORAI4.addBox(ew - 4.5F, hi, sn, 3, 2, 2, -0.75F);
		GYORAI4.setRotationPoint(0F, 0F, 0F);
		GYORAI4.rotateAngleX = -45 * ag;
		
		HANE1 = new ModelRenderer(this, 12, 54);
		HANE1.addBox(ew - 3.9F, hi, sn + 0.875F, 3, 2, 2, -0.15F);
		HANE1.setRotationPoint(0F, 0F, 0F);
		HANE1.rotateAngleX = -45 * ag;
		HANE2 = new ModelRenderer(this, 24, 54);
		HANE2.addBox(ew - 3.9F, hi + 0.875F, sn, 3, 2, 2, -0.15F);
		HANE2.setRotationPoint(0F, 0F, 0F);
		HANE2.rotateAngleX = -45 * ag;
		
		BAND_G = new ModelRenderer(this, 0, 58);
		BAND_G.addBox(-6.9F, hi, sn, 18, 2, 2, -0.1F);
		BAND_G.setRotationPoint(0F, 0F, 0F);
		BAND_G.rotateAngleX = -45 * ag;
		BAND_L = new ModelRenderer(this, 0, 62);
		BAND_L.addBox(2.6F, -0.23F, 2.875F, 2, 9, 2, 0.2F);
		BAND_L.setRotationPoint(0F, 0F, 0F);
		BAND_L.rotateAngleX = 5 * ag;
		
		RANSEL = new ModelRenderer(this, 0, 32);
		RANSEL.addBox(-3.675F, 0.1F, -1.8F, 8, 12, 5, 0.75F);
		RANSEL.setRotationPoint(0F, 0F, 0F);

		
		bipedBody.addChild(GYORAI);
		bipedBody.addChild(GYORAI2);
		bipedBody.addChild(GYORAI3);
		bipedBody.addChild(GYORAI4);
		bipedBody.addChild(HANE1);
		bipedBody.addChild(HANE2);
		
		bipedBody.addChild(BAND_G);
		bipedBody.addChild(BAND_L);
		bipedBody.addChild(RANSEL);
	}
}
