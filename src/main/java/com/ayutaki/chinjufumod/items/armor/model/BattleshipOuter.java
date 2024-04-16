package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BattleshipOuter extends BaseArmor {

	private ModelRenderer ANTENA;
	
	private ModelRenderer ENTOTSU;
	private ModelRenderer JOINT_KONGOU;
	private ModelRenderer JOINT_FUSOU;
	private ModelRenderer SUSO;
	
	private ModelRenderer RIGHT_SODE;
	private ModelRenderer LEFT_SODE;
	private ModelRenderer RIGHT_SODEIN;
	private ModelRenderer LEFT_SODEIN;
	private ModelRenderer RIGHT_WA;
	private ModelRenderer LEFT_WA;
	private ModelRenderer RIGHT_FSODE;
	private ModelRenderer LEFT_FSODE;
	
	private ModelRenderer RIGHT_SOX;
	private ModelRenderer LEFT_SOX;
	private ModelRenderer RIGHT_BOOT;
	private ModelRenderer LEFT_BOOT;

	public BattleshipOuter(float scale) {
		super(scale);

		ANTENA = new ModelRenderer(this, 0, 100);
		ANTENA.addBox(-8.0F, -12.5F, 0.5F, 16, 8, 8, 0.5F);
		ANTENA.setPos(0F, 0F, 0F);
				
		ENTOTSU = new ModelRenderer(this, 0, 32);
		ENTOTSU.addBox(-11.0F, -9.0F, 3.51F, 22, 26, 2, 0.0F);
		ENTOTSU.setPos(0F, 0F, 0F);
		JOINT_KONGOU = new ModelRenderer(this, 0, 60);
		JOINT_KONGOU.addBox(-2.0F, 8.0F, 2.5F, 4, 2, 3, 0.0F);
		JOINT_KONGOU.setPos(0F, 0F, 0F);
		JOINT_FUSOU = new ModelRenderer(this, 16, 60);
		JOINT_FUSOU.addBox(-1.5F, 6.0F, 2.5F, 3, 2, 3, 0.0F);
		JOINT_FUSOU.setPos(0F, 0F, 0F);

		SUSO = new ModelRenderer(this, 40, 60);
		SUSO.addBox(-4.0F, 13.0F, -2.0F, 8, 6, 4, scale);
		SUSO.setPos(0F, 0F, 0F);
		
		RIGHT_SODE = new ModelRenderer(this, 0, 84);
		RIGHT_SODE.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, scale - 0.1F); 
		RIGHT_SODE.setPos(0F, 0F, 0F);
		LEFT_SODE = new ModelRenderer(this, 0, 84);
		LEFT_SODE.mirror = true;
		LEFT_SODE.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, scale - 0.1F);
		LEFT_SODE.setPos(0F, 0F, 0F);
		RIGHT_SODEIN = new ModelRenderer(this, 16, 84);
		RIGHT_SODEIN.addBox(-3.0F, -2.125F, -2.0F, 4, 12, 4, scale - 0.15F); 
		RIGHT_SODEIN.setPos(0F, 0F, 0F);
		LEFT_SODEIN = new ModelRenderer(this, 16, 84);
		LEFT_SODEIN.mirror = true;
		LEFT_SODEIN.addBox(-1.0F, -2.125F, -2.0F, 4, 12, 4, scale - 0.15F);
		LEFT_SODEIN.setPos(0F, 0F, 0F);
		
		RIGHT_WA = new ModelRenderer(this, 0, 68);
		RIGHT_WA.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.26F); 
		RIGHT_WA.setPos(0F, 0F, 0F);
		LEFT_WA = new ModelRenderer(this, 0, 68);
		LEFT_WA.mirror = true;
		LEFT_WA.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.26F);
		LEFT_WA.setPos(0F, 0F, 0F);
		RIGHT_FSODE = new ModelRenderer(this, 16, 68);
		RIGHT_FSODE.addBox(-3.0F, 2.36F, -2.0F, 4, 12, 4, scale - 0.1F); 
		RIGHT_FSODE.setPos(0F, 0F, 0F);
		LEFT_FSODE = new ModelRenderer(this, 16, 68);
		LEFT_FSODE.mirror = true;
		LEFT_FSODE.addBox(-1.0F, 2.36F, -2.0F, 4, 12, 4, scale - 0.1F);
		LEFT_FSODE.setPos(0F, 0F, 0F);

		RIGHT_SOX = new ModelRenderer(this,48, 84);
		RIGHT_SOX.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.15F);
		RIGHT_SOX.setPos(0F, 0F, 0F);
		LEFT_SOX = new ModelRenderer(this, 48, 84);
		LEFT_SOX.mirror = true;
		LEFT_SOX.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.15F);
		LEFT_SOX.setPos(0F, 0F, 0F);
		RIGHT_BOOT = new ModelRenderer(this, 48, 100);
		RIGHT_BOOT.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.3F);
		RIGHT_BOOT.setPos(0F, 0F, 0F);
		LEFT_BOOT = new ModelRenderer(this, 48, 100);
		LEFT_BOOT.mirror = true;
		LEFT_BOOT.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.3F);
		LEFT_BOOT.setPos(0F, 0F, 0F);

		
		head.addChild(ANTENA);
		body.addChild(ENTOTSU);
		body.addChild(JOINT_KONGOU);
		body.addChild(JOINT_FUSOU);
		body.addChild(SUSO);
		
		rightArm.addChild(RIGHT_SODE);
		leftArm.addChild(LEFT_SODE);
		rightArm.addChild(RIGHT_SODEIN);
		leftArm.addChild(LEFT_SODEIN);
		
		rightArm.addChild(RIGHT_WA);
		leftArm.addChild(LEFT_WA);
		rightArm.addChild(RIGHT_FSODE);
		leftArm.addChild(LEFT_FSODE);
		
		rightLeg.addChild(RIGHT_SOX);
		leftLeg.addChild(LEFT_SOX);
		rightLeg.addChild(RIGHT_BOOT);
		leftLeg.addChild(LEFT_BOOT);
	}
}
