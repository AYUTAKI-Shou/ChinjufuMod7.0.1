package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class IkkousenOuter extends BaseArmor {

	private ModelRenderer KAMIDOME;
	private ModelRenderer SCARF;
	private ModelRenderer SCARF_RIGHT;
	private ModelRenderer SCARF_LEFT;
	private ModelRenderer SCARF2_RIGHT;
	private ModelRenderer SCARF2_LEFT;
	
	private ModelRenderer SUSO;
	private ModelRenderer DOUGI;
	private ModelRenderer YADUTU;
	private ModelRenderer YA;
	private ModelRenderer ANTENA;
	private ModelRenderer TOME;
	
	private ModelRenderer RIGHT_SODE;
	private ModelRenderer RIGHT_KANPAN;
	private ModelRenderer LEFT_SODE;
	private ModelRenderer LEFT_KANPAN;

	private ModelRenderer RIGHT_SOX;
	private ModelRenderer LEFT_SOX;

	public IkkousenOuter(float scale) {
		super(scale);
		float ag = (float)Math.PI / 180;
		float hi = -1.75F;
		
		KAMIDOME = new ModelRenderer(this, 0, 108);
		KAMIDOME.addBox(-4.0F, -8.0F, -4.0F, 8, 4, 8, 0.3F);
		KAMIDOME.setPos(0F, 0F, 0F);
		SCARF = new ModelRenderer(this, 32, 84);
		SCARF.addBox(-4.0F, hi, -4.0F, 8, 8, 8, 0.75F);
		SCARF.setPos(0F, 0F, 0F);
		SCARF_RIGHT = new ModelRenderer(this, 32, 100);
		SCARF_RIGHT.addBox(0.0F, hi + 2.0F, -3.0F, 6, 12, 2, 0.75F);
		SCARF_RIGHT.setPos(0F, 0F, 0F);
		SCARF_RIGHT.yRot = -45 * ag;
		SCARF_LEFT = new ModelRenderer(this, 32, 100);
		SCARF_LEFT.addBox(-1.0F, hi + 3.5F, 1.0F, 6, 12, 2, 0.75F);
		SCARF_LEFT.setPos(0F, 0F, 0F);
		SCARF_LEFT.yRot = 80 * ag;
		
		SCARF2_RIGHT = new ModelRenderer(this, 48, 100);
		SCARF2_RIGHT.addBox(0.0F, hi + 2.0F, -3.0F, 6, 12, 2, 0.75F);
		SCARF2_RIGHT.setPos(0F, 0F, 0F);
		SCARF2_RIGHT.yRot = -45 * ag;
		SCARF2_LEFT = new ModelRenderer(this, 48, 100);
		SCARF2_LEFT.addBox(-1.25F, hi + 3.5F, -3.0F, 6, 12, 2, 0.75F);
		SCARF2_LEFT.setPos(0F, 0F, 0F);
		SCARF2_LEFT.yRot = -80 * ag;
	
		SUSO = new ModelRenderer(this, 0, 48);
		SUSO.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.25F);
		SUSO.setPos(0F, 0F, 0F);
		DOUGI = new ModelRenderer(this, 0, 32);
		DOUGI.addBox(-4.0F, 0.0F, -2.0F, 8, 8, 4, scale);
		DOUGI.setPos(0F, 0F, 0F);
		
		YADUTU = new ModelRenderer(this, 28, 56);
		YADUTU.addBox(-3.3F, 6.3F, 3.0F, 14, 2, 2, -0.1F);
		YADUTU.setPos(0F, 0F, 0F);
		YADUTU.zRot = 0.40F;
		YA = new ModelRenderer(this, 28, 60);
		YA.addBox(-7.3F, 6.3F, 3.0F, 16, 2, 2, -0.4F);
		YA.setPos(0F, 0F, 0F);
		YA.zRot = 0.40F;
		ANTENA = new ModelRenderer(this, 0, 64);
		ANTENA.addBox(-11.25F, -0.85F, -0.5F, 16, 16, 2, 0.75F);
		ANTENA.setPos(0F, 0F, 0F);
		ANTENA.xRot = 0.20F;
		TOME = new ModelRenderer(this, 48, 80);
		TOME.addBox(0.5F, 0.5F, 1.4F, 1, 1, 1, 0.15F);
		TOME.setPos(0F, 0F, 0F);
		TOME.zRot = 45 * ag;
		
		RIGHT_SODE = new ModelRenderer(this, 32, 32);
		RIGHT_SODE.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, scale - 0.1F); 
		RIGHT_SODE.setPos(0F, 0F, 0F);
		RIGHT_KANPAN = new ModelRenderer(this, 0, 84);
		RIGHT_KANPAN.addBox(-3.0F, -3.0F, -2.0F, 4, 20, 4, scale);
		RIGHT_KANPAN.setPos(0F, 0F, 0F);
		LEFT_SODE = new ModelRenderer(this, 48, 32);
		LEFT_SODE.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, scale - 0.1F);
		LEFT_SODE.setPos(0F, 0F, 0F);
		LEFT_KANPAN = new ModelRenderer(this, 16, 84);
		LEFT_KANPAN.addBox(-1.0F, -3.0F, -2.0F, 4, 20, 4, scale);
		LEFT_KANPAN.setPos(0F, 0F, 0F);

		RIGHT_SOX = new ModelRenderer(this, 48, 64);
		RIGHT_SOX.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.15F); 
		RIGHT_SOX.setPos(0F, 0F, 0F);
		LEFT_SOX = new ModelRenderer(this, 48, 64);
		LEFT_SOX.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.15F);
		LEFT_SOX.setPos(0F, 0F, 0F);
		
		
		head.addChild(KAMIDOME);
		head.addChild(SCARF);
		head.addChild(SCARF_RIGHT);
		head.addChild(SCARF_LEFT);
		head.addChild(SCARF2_RIGHT);
		head.addChild(SCARF2_LEFT);
		
		body.addChild(SUSO);
		body.addChild(DOUGI);
		body.addChild(YADUTU);
		body.addChild(YA);
		body.addChild(ANTENA);
		body.addChild(TOME);

		rightArm.addChild(RIGHT_SODE);
		rightArm.addChild(RIGHT_KANPAN);
		leftArm.addChild(LEFT_SODE);
		leftArm.addChild(LEFT_KANPAN);
		
		rightLeg.addChild(RIGHT_SOX);
		leftLeg.addChild(LEFT_SOX);
	}
}
