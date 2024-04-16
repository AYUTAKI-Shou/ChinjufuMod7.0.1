package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ZuihouOuter extends BaseArmor {

	private ModelRenderer SUSO;
	private ModelRenderer DOUGI;
	private ModelRenderer RIGHT_SODE;
	private ModelRenderer LEFT_SODE;

	private ModelRenderer RIGHT_SOX;
	private ModelRenderer LEFT_SOX;
	
	public ZuihouOuter(float scale) {
		super(scale);

		SUSO = new ModelRenderer(this, 0, 48);
		SUSO.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.25F);
		SUSO.setPos(0F, 0F, 0F);
		DOUGI = new ModelRenderer(this, 0, 32);
		DOUGI.addBox(-4.0F, 0.0F, -2.0F, 8, 8, 4, scale);
		DOUGI.setPos(0F, 0F, 0F);
		
		RIGHT_SODE = new ModelRenderer(this, 32, 32);
		RIGHT_SODE.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, scale - 0.1F);
		RIGHT_SODE.setPos(0F, 0F, 0F);
		LEFT_SODE = new ModelRenderer(this, 32, 32);
		LEFT_SODE.mirror = true;
		LEFT_SODE.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, scale - 0.1F);
		LEFT_SODE.setPos(0F, 0F, 0F);


		RIGHT_SOX = new ModelRenderer(this, 48, 64);
		RIGHT_SOX.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.2F);
		RIGHT_SOX.setPos(0F, 0F, 0F);
		LEFT_SOX = new ModelRenderer(this, 48, 64);
		LEFT_SOX.mirror = true;
		LEFT_SOX.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.2F);
		LEFT_SOX.setPos(0F, 0F, 0F);
		
		body.addChild(SUSO);
		body.addChild(DOUGI);
		rightArm.addChild(RIGHT_SODE);
		leftArm.addChild(LEFT_SODE);

		rightLeg.addChild(RIGHT_SOX);
		leftLeg.addChild(LEFT_SOX);
	}
}