package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ToneOuter extends BaseArmor {
	
	private ModelRenderer RIBON;
	private ModelRenderer UWAGI;
	private ModelRenderer LR_GUARD;
	private ModelRenderer ENTOTSU;
	private ModelRenderer JOINT;

	private ModelRenderer RIGHT_SODE;
	private ModelRenderer LEFT_SODE;
	private ModelRenderer RIGHT_SODE2;
	private ModelRenderer LEFT_SODE2;
	private ModelRenderer LEFT_TIGHTS;
	private ModelRenderer RIGHT_SOX;
	private ModelRenderer LEFT_SOX;
	
	public ToneOuter(float scale) {
		super(scale);

		RIBON = new ModelRenderer(this, 32, 108);
		RIBON.addBox(-4.0F, -8.75F, -3.5F, 8, 8, 8, 0.3F);
		RIBON.setPos(0F, 0F, 0F);
		
		UWAGI = new ModelRenderer(this, 0, 76);
		UWAGI.addBox(-4.5F, 0.0F, -2.3F, 9, 12, 5, 0.4F);
		UWAGI.setPos(0F, 0F, 0F);
		LR_GUARD = new ModelRenderer(this, 0, 48);
		LR_GUARD.addBox(-11.0F, -7.75F, -0.5F, 22, 20, 8, 0.0F);
		LR_GUARD.setPos(0F, 0F, 0F);
		ENTOTSU = new ModelRenderer(this, 0, 32);
		ENTOTSU.addBox(-11.0F, -3.25F, 4.51F, 22, 14, 2, 0.0F);
		ENTOTSU.setPos(0F, 0F, 0F);
		JOINT = new ModelRenderer(this, 48, 32);
		JOINT.addBox(-2.0F, 7.75F, 2.5F, 4, 2, 2, 0.0F);
		JOINT.setPos(0F, 0F, 0F);
		
		RIGHT_SODE = new ModelRenderer(this, 0, 94);
		RIGHT_SODE.addBox(-3.5F, -2.25F, -2.25F, 5, 6, 5, 0.3F);
		RIGHT_SODE.setPos(0F, 0F, 0F);
		LEFT_SODE = new ModelRenderer(this, 0, 94);
		LEFT_SODE.mirror = true;
		LEFT_SODE.addBox(-1.5F, -2.25F, -2.25F, 5, 6, 5, 0.3F);
		LEFT_SODE.setPos(0F, 0F, 0F);
		RIGHT_SODE2 = new ModelRenderer(this, 0, 108);
		RIGHT_SODE2.addBox(-3.5F, -2.25F, -2.25F, 5, 6, 5, 0.4F);
		RIGHT_SODE2.setPos(0F, 0F, 0F);
		LEFT_SODE2 = new ModelRenderer(this, 0, 108);
		LEFT_SODE2.mirror = true;
		LEFT_SODE2.addBox(-1.5F, -2.25F, -2.25F, 5, 6, 5, 0.4F);
		LEFT_SODE2.setPos(0F, 0F, 0F);
		LEFT_TIGHTS = new ModelRenderer(this, 48, 76);
		LEFT_TIGHTS.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.15F);
		LEFT_TIGHTS.setPos(0F, 0F, 0F);
		
		RIGHT_SOX = new ModelRenderer(this, 32, 92);
		RIGHT_SOX.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.15F);
		RIGHT_SOX.setPos(0F, 0F, 0F);
		LEFT_SOX = new ModelRenderer(this, 48, 92);
		LEFT_SOX.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.15F);
		LEFT_SOX.setPos(0F, 0F, 0F);

	
		head.addChild(RIBON);
		body.addChild(UWAGI);
		body.addChild(LR_GUARD);
		body.addChild(ENTOTSU);
		body.addChild(JOINT);
		
		rightArm.addChild(RIGHT_SODE);
		leftArm.addChild(LEFT_SODE);
		rightArm.addChild(RIGHT_SODE2);
		leftArm.addChild(LEFT_SODE2);
		leftArm.addChild(LEFT_TIGHTS);
		
		rightLeg.addChild(RIGHT_SOX);
		leftLeg.addChild(LEFT_SOX);
	}
}
