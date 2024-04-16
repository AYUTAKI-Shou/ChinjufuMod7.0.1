package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
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
		BOUSHI_F.setPos(0F, 0F, 0F);
		BOUSHI_F.yRot = 45 * ag;
		BOUSHI_B = new ModelRenderer(this, 0, 100);
		BOUSHI_B.addBox(-2.0F, -10.5F, -2.0F, 4, 3, 6, 0.0F);
		BOUSHI_B.setPos(0F, 0F, 0F);
		BOUSHI_W = new ModelRenderer(this, 32, 100);
		BOUSHI_W.addBox(-4.0F, hi, -9.0F, 8, 1, 8, 0.75F);
		BOUSHI_W.setPos(0F, 0F, 0F);
		BOUSHI_W.xRot = -30 * ag;
		BOUSHI_W2 = new ModelRenderer(this, 32, 110);
		BOUSHI_W2.addBox(-4.0F, hi - 2.48F, -9.0F, 8, 1, 8, 0.75F);
		BOUSHI_W2.setPos(0F, 0F, 0F);
		BOUSHI_W2.xRot = -30 * ag;
	
		RANSEL = new ModelRenderer(this, 0, 32);
		RANSEL.addBox(-4.0F, 0.1F, -1.9F, 8, 12, 4, 1.0F);
		RANSEL.setPos(0F, 0F, 0F);
		ERI = new ModelRenderer(this, 32, 32);
		ERI.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, scale + 0.2F);
		ERI.setPos(0F, 0F, 0F);
		TIE = new ModelRenderer(this, 32, 48);
		TIE.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, scale + 0.1F);
		TIE.setPos(0F, 0F, 0F);

		RIGHT_SODE = new ModelRenderer(this, 32, 80);
		RIGHT_SODE.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, scale - 0.2F); 
		RIGHT_SODE.setPos(0F, 0F, 0F);
		LEFT_SODE = new ModelRenderer(this, 48, 80);
		LEFT_SODE.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, scale - 0.2F);
		LEFT_SODE.setPos(0F, 0F, 0F);
		
		RIGHT_SOX = new ModelRenderer(this, 0, 80);
		RIGHT_SOX.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.3F);
		RIGHT_SOX.setPos(0F, 0F, 0F);
		LEFT_SOX = new ModelRenderer(this, 0, 80);
		LEFT_SOX.mirror = true;
		LEFT_SOX.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.3F);
		LEFT_SOX.setPos(0F, 0F, 0F);
	
		
		head.addChild(BOUSHI_F);
		head.addChild(BOUSHI_B);
		head.addChild(BOUSHI_W);
		head.addChild(BOUSHI_W2);
		
		body.addChild(RANSEL);
		body.addChild(ERI);
		body.addChild(TIE);
		
		rightArm.addChild(RIGHT_SODE);
		leftArm.addChild(LEFT_SODE);
		
		rightLeg.addChild(RIGHT_SOX);
		leftLeg.addChild(LEFT_SOX);
	}
}
