package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class YUKATA_Inner extends BaseArmor {

	private ModelRenderer RIGHT_SUSO;
	private ModelRenderer LEFT_SUSO;

	public YUKATA_Inner(float scale) {
		super(scale);

		RIGHT_SUSO= new ModelRenderer(this, 0, 74);
		RIGHT_SUSO.addBox(-2.9F, -0.75F, -2.89F, 6, 14, 6, scale);
		RIGHT_SUSO.setRotationPoint(0F, 0F, 0F);
		LEFT_SUSO= new ModelRenderer(this, 24, 74);
		LEFT_SUSO.addBox(-7.1F, -0.75F, -2.9F, 10, 14, 6, scale);
		LEFT_SUSO.setRotationPoint(0F, 0F, 0F);


		bipedRightLeg.addChild(RIGHT_SUSO);
		bipedLeftLeg.addChild(LEFT_SUSO);
	}
}
