package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RJ_Outer extends BaseArmor {

	private ModelRenderer WA;
	private ModelRenderer VISOR;

	private ModelRenderer UWAGI;
	private ModelRenderer KOSHI;
	
	private ModelRenderer RIGHT_SOX;
	private ModelRenderer LEFT_SOX;

	public RJ_Outer(float scale) {
		super(scale);
		
		WA = new ModelRenderer(this, 0, 48);
		WA.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.51F);
		WA.setRotationPoint(0F, 0F, 0F);
		VISOR = new ModelRenderer(this, 32, 48);
		VISOR.addBox(-5.0F, -10.0F, -7.55F, 10, 5, 3, 0.0F);
		VISOR.setRotationPoint(0F, 0F, 0F);
	
		UWAGI = new ModelRenderer(this, 0, 32);
		UWAGI.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, scale + 0.1F);
		UWAGI.setRotationPoint(0F, 0F, 0F);
		KOSHI = new ModelRenderer(this, 0, 71);
		KOSHI.addBox(-11.0F, -10.0F, 3.26F, 22, 28, 1, 0.0F);
		KOSHI.setRotationPoint(0F, 0F, 0F);
		
		RIGHT_SOX = new ModelRenderer(this, 48, 64);
		RIGHT_SOX.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.15F);
		RIGHT_SOX.setRotationPoint(0F, 0F, 0F);
		LEFT_SOX = new ModelRenderer(this, 48, 64);
		LEFT_SOX.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.15F);
		LEFT_SOX.setRotationPoint(0F, 0F, 0F);

		
		bipedHead.addChild(VISOR);
		bipedHead.addChild(WA);
		
		bipedBody.addChild(UWAGI);
		bipedBody.addChild(KOSHI);

		bipedRightLeg.addChild(RIGHT_SOX);
		bipedLeftLeg.addChild(LEFT_SOX);
	}
}
