package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SubmarineOuter extends BaseArmor {

	private ModelRenderer BOUSHI_F;
	private ModelRenderer BOUSHI_B;
	private ModelRenderer BOUSHI_W;
	private ModelRenderer BOUSHI_W2;
	
	private ModelRenderer RANSEL;
	private ModelRenderer ERI;
	private ModelRenderer TIE;
	
	private ModelRenderer RIGHT_SODE;
	private ModelRenderer LEFT_SODE;

	private ModelRenderer RIGHT_SOX;
	private ModelRenderer LEFT_SOX;
	
	public SubmarineOuter(float scale) {
		super(scale);
		float ag = (float)Math.PI / 180;
		float hi = -7.55F;
		
		BOUSHI_F = new ModelRenderer(this, 20, 100);
		BOUSHI_F.addBox(-0.09F, -10.58F, -2.91F, 3, 3, 3, -0.09F);
		BOUSHI_F.setRotationPoint(0F, 0F, 0F);
		BOUSHI_F.rotateAngleY = 45 * ag;
		BOUSHI_B = new ModelRenderer(this, 0, 100);
		BOUSHI_B.addBox(-2.0F, -10.5F, -2.0F, 4, 3, 6, 0.0F);
		BOUSHI_B.setRotationPoint(0F, 0F, 0F);
		BOUSHI_W = new ModelRenderer(this, 32, 100);
		BOUSHI_W.addBox(-4.0F, hi, -9.0F, 8, 1, 8, 0.75F);
		BOUSHI_W.setRotationPoint(0F, 0F, 0F);
		BOUSHI_W.rotateAngleX = -30 * ag;
		BOUSHI_W2 = new ModelRenderer(this, 32, 110);
		BOUSHI_W2.addBox(-4.0F, hi - 2.48F, -9.0F, 8, 1, 8, 0.75F);
		BOUSHI_W2.setRotationPoint(0F, 0F, 0F);
		BOUSHI_W2.rotateAngleX = -30 * ag;
	
		RANSEL = new ModelRenderer(this, 0, 32);
		RANSEL.addBox(-4.0F, 0.1F, -1.9F, 8, 12, 4, 1.0F);
		RANSEL.setRotationPoint(0F, 0F, 0F);
		ERI = new ModelRenderer(this, 32, 32);
		ERI.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, scale + 0.2F);
		ERI.setRotationPoint(0F, 0F, 0F);
		TIE = new ModelRenderer(this, 32, 48);
		TIE.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, scale + 0.1F);
		TIE.setRotationPoint(0F, 0F, 0F);

		RIGHT_SODE = new ModelRenderer(this, 32, 80);
		RIGHT_SODE.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, scale - 0.2F); 
		RIGHT_SODE.setRotationPoint(0F, 0F, 0F);
		LEFT_SODE = new ModelRenderer(this, 48, 80);
		LEFT_SODE.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, scale - 0.2F);
		LEFT_SODE.setRotationPoint(0F, 0F, 0F);
		
		RIGHT_SOX = new ModelRenderer(this, 0, 80);
		RIGHT_SOX.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.3F);
		RIGHT_SOX.setRotationPoint(0F, 0F, 0F);
		LEFT_SOX = new ModelRenderer(this, 0, 80);
		LEFT_SOX.mirror = true;
		LEFT_SOX.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.3F);
		LEFT_SOX.setRotationPoint(0F, 0F, 0F);
	
		
		bipedHead.addChild(BOUSHI_F);
		bipedHead.addChild(BOUSHI_B);
		bipedHead.addChild(BOUSHI_W);
		bipedHead.addChild(BOUSHI_W2);
		
		bipedBody.addChild(RANSEL);
		bipedBody.addChild(ERI);
		bipedBody.addChild(TIE);
		
		bipedRightArm.addChild(RIGHT_SODE);
		bipedLeftArm.addChild(LEFT_SODE);
		
		bipedRightLeg.addChild(RIGHT_SOX);
		bipedLeftLeg.addChild(LEFT_SOX);
	}
}
