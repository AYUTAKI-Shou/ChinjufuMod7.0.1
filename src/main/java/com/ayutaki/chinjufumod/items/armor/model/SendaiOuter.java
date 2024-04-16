package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SendaiOuter extends BaseArmor {

	private ModelRenderer SCARF;
	private ModelRenderer SCARF_RIGHT;
	private ModelRenderer SCARF_LEFT;

	private ModelRenderer GYORAI;
	private ModelRenderer OBI;
	private ModelRenderer OBI2;
	private ModelRenderer KOSHIHIMO_1;
	private ModelRenderer KOSHIHIMO_2;
	private ModelRenderer KOSHIHIMO_3;
	
	private ModelRenderer RIGHT_SODE;
	private ModelRenderer LEFT_SODE;
	private ModelRenderer RIGHT_KOTE;
	private ModelRenderer LEFT_KOTE;
	
	private ModelRenderer RIGHT_SOX;
	private ModelRenderer LEFT_SOX;
	
	public SendaiOuter(float scale) {
		super(scale);
		float hi = -1.75F;
		float ag = (float)Math.PI / 180;
		
		SCARF = new ModelRenderer(this, 32, 80);
		SCARF.addBox(-4.0F, hi, -4.0F, 8, 8, 8, 0.75F);
		SCARF.setPos(0F, 0F, 0F);
		SCARF_RIGHT = new ModelRenderer(this, 48, 100);
		SCARF_RIGHT.addBox(-3.8F, hi + 2.5F, 0.0F, 2, 12, 6, 0.75F);
		SCARF_RIGHT.setPos(0F, 0F, 0F);
		SCARF_RIGHT.yRot = -25 * ag;
		SCARF_LEFT = new ModelRenderer(this, 48, 100);
		SCARF_LEFT.addBox(1.8F, hi + 2.5F, 0.0F, 2, 12, 6, 0.75F);
		SCARF_LEFT.setPos(0F, 0F, 0F);
		SCARF_LEFT.yRot = 25 * ag;

		GYORAI = new ModelRenderer(this, 0, 72);
		GYORAI.addBox(-16.25F, 7.25F, 3.7F, 25, 6, 1, 0.0F);
		GYORAI.setPos(0F, 0F, 0F);
		GYORAI.zRot = -20 * ag;
		OBI = new ModelRenderer(this, 0, 32);
		OBI.addBox(-5.25F, -0.45F, -2.45F, 10, 14, 6, 0.0F);
		OBI.setPos(0F, 0F, 0F);
		OBI2 = new ModelRenderer(this, 0, 50);
		OBI2.addBox(-5.25F, -2.2F, 1.55F, 10, 14, 1, 0.0F);
		OBI2.setPos(0F, 0F, 0F);
		OBI2.xRot = 6 * ag;
		
		KOSHIHIMO_1 = new ModelRenderer(this, 0, 96);
		KOSHIHIMO_1.addBox(-4.5F, 8.675F, -2.5F, 9, 1, 5, 0.0F);
		KOSHIHIMO_1.setPos(0F, 0F, 0F);
		KOSHIHIMO_2 = new ModelRenderer(this, 0, 96);
		KOSHIHIMO_2.addBox(-5.9F, 8.75F, -2.5F, 9, 1, 5, 0.075F);
		KOSHIHIMO_2.setPos(0F, 0F, 0F);
		KOSHIHIMO_2.zRot = -8 * ag;
		KOSHIHIMO_3 = new ModelRenderer(this, 0, 104);
		KOSHIHIMO_3.addBox(-9.0F, 10.0F, -2.4F, 10, 1, 6, 0.075F);
		KOSHIHIMO_3.setPos(0F, 0F, 0F);
		KOSHIHIMO_3.zRot = -20 * ag;
		
		RIGHT_SODE = new ModelRenderer(this, 32, 32);
		RIGHT_SODE.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.15F);
		RIGHT_SODE.setPos(0F, 0F, 0F);
		LEFT_SODE = new ModelRenderer(this, 32, 32);
		LEFT_SODE.mirror = true;
		LEFT_SODE.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.15F);
		LEFT_SODE.setPos(0F, 0F, 0F);
		RIGHT_KOTE = new ModelRenderer(this, 48, 32);
		RIGHT_KOTE.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.26F);
		RIGHT_KOTE.setPos(0F, 0F, 0F);
		LEFT_KOTE = new ModelRenderer(this, 48, 32);
		LEFT_KOTE.mirror = true;
		LEFT_KOTE.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.26F);
		LEFT_KOTE.setPos(0F, 0F, 0F);

		RIGHT_SOX = new ModelRenderer(this, 0, 80);
		RIGHT_SOX.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.15F);
		RIGHT_SOX.setPos(0F, 0F, 0F);
		LEFT_SOX = new ModelRenderer(this, 16, 80);
		LEFT_SOX.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.15F);
		LEFT_SOX.setPos(0F, 0F, 0F);


		head.addChild(SCARF);
		head.addChild(SCARF_RIGHT);
		head.addChild(SCARF_LEFT);
		body.addChild(GYORAI);
		body.addChild(OBI);
		body.addChild(OBI2);
		
		body.addChild(KOSHIHIMO_1);
		body.addChild(KOSHIHIMO_2);
		body.addChild(KOSHIHIMO_3);
		
		rightArm.addChild(RIGHT_SODE);
		leftArm.addChild(LEFT_SODE);
		rightArm.addChild(RIGHT_KOTE);
		leftArm.addChild(LEFT_KOTE);
		
		rightLeg.addChild(RIGHT_SOX);
		leftLeg.addChild(LEFT_SOX);
	}
}
