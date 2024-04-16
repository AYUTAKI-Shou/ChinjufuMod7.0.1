package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class NagatoOuter extends BaseArmor {

	private ModelRenderer ANTENA;

	private ModelRenderer RIGHT_SODE;
	private ModelRenderer LEFT_SODE;
	private ModelRenderer RIGHT_SODEIN;
	private ModelRenderer LEFT_SODEIN;
	
	private ModelRenderer RIGHT_SOX;
	private ModelRenderer LEFT_SOX;
	private ModelRenderer RIGHT_BOOT;
	private ModelRenderer LEFT_BOOT;

	public NagatoOuter(float scale) {
		super(scale);

		ANTENA = new ModelRenderer(this, 0, 100);
		ANTENA.addBox(-8.0F, -12.5F, 0.5F, 16, 8, 8, 0.5F);
		ANTENA.setPos(0F, 0F, 0F);

		RIGHT_SODE = new ModelRenderer(this, 0, 68);
		RIGHT_SODE.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.3F); 
		RIGHT_SODE.setPos(0F, 0F, 0F);
		LEFT_SODE = new ModelRenderer(this, 0, 68);
		LEFT_SODE.mirror = true;
		LEFT_SODE.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.3F);
		LEFT_SODE.setPos(0F, 0F, 0F);
		RIGHT_SODEIN = new ModelRenderer(this, 16, 68);
		RIGHT_SODEIN.addBox(-3.0F, -2.25F, -2.0F, 4, 12, 4, 0.26F); 
		RIGHT_SODEIN.setPos(0F, 0F, 0F);
		LEFT_SODEIN = new ModelRenderer(this, 16, 68);
		LEFT_SODEIN.mirror = true;
		LEFT_SODEIN.addBox(-1.0F, -2.25F, -2.0F, 4, 12, 4, 0.26F);
		LEFT_SODEIN.setPos(0F, 0F, 0F);

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

		rightArm.addChild(RIGHT_SODE);
		leftArm.addChild(LEFT_SODE);
		rightArm.addChild(RIGHT_SODEIN);
		leftArm.addChild(LEFT_SODEIN);
		
		rightLeg.addChild(RIGHT_SOX);
		leftLeg.addChild(LEFT_SOX);
		rightLeg.addChild(RIGHT_BOOT);
		leftLeg.addChild(LEFT_BOOT);
	}
}
