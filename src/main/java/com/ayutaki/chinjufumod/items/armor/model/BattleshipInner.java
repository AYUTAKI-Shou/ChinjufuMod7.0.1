package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BattleshipInner extends BaseArmor {

	private ModelRenderer KOSHI_KONGOU;

	private ModelRenderer RIGHT_SKIRT;
	private ModelRenderer LEFT_SKIRT;
	private ModelRenderer RIGHT_WA;
	private ModelRenderer LEFT_WA;
	
	public BattleshipInner(float scale) {
		super(scale);
		
		KOSHI_KONGOU = new ModelRenderer(this, 32, 42);
		KOSHI_KONGOU.addBox(-4.5F, 7.0F, -2.25F, 9, 5, 5, 0.4F);
		KOSHI_KONGOU.setRotationPoint(0F, 0F, 0F);

		RIGHT_SKIRT = new ModelRenderer(this, 0, 32);
		RIGHT_SKIRT.addBox(-2.09F, -1.0F, -2.0F, 4, 12, 4, scale);
		RIGHT_SKIRT.setRotationPoint(0F, 0F, 0F);
		LEFT_SKIRT = new ModelRenderer(this, 16, 32);
		LEFT_SKIRT.addBox(-1.91F, -1.0F, -1.99F, 4, 12, 4, scale);
		LEFT_SKIRT.setRotationPoint(0F, 0F, 0F);
		
		RIGHT_WA = new ModelRenderer(this, 0, 48);
		RIGHT_WA.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.3F);
		RIGHT_WA.setRotationPoint(0F, 0F, 0F);
		LEFT_WA = new ModelRenderer(this, 16, 48);
		LEFT_WA.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.3F);
		LEFT_WA.setRotationPoint(0F, 0F, 0F);


		bipedBody.addChild(KOSHI_KONGOU);
		
		bipedRightLeg.addChild(RIGHT_SKIRT);
		bipedLeftLeg.addChild(LEFT_SKIRT);
		bipedRightLeg.addChild(RIGHT_WA);
		bipedLeftLeg.addChild(LEFT_WA);
	}
}
