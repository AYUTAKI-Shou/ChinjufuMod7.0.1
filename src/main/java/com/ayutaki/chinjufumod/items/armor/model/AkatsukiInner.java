package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class AkatsukiInner extends BaseArmor {
	//Sox 0.15F, Shirt 0.3F, Skirt 0.4F, Outer 0.55F
	
	private ModelRenderer RIGHT_SKIRT;
	private ModelRenderer LEFT_SKIRT;

	public AkatsukiInner(float scale) {
		super(scale);

		RIGHT_SKIRT = new ModelRenderer(this, 0, 32);
		RIGHT_SKIRT.addBox(-2.09F, -1.0F, -2.0F, 4, 12, 4, scale);
		RIGHT_SKIRT.setPos(0F, 0F, 0F);
		LEFT_SKIRT = new ModelRenderer(this, 16, 32);
		LEFT_SKIRT.addBox(-1.91F, -1.0F, -1.99F, 4, 12, 4, scale);
		LEFT_SKIRT.setPos(0F, 0F, 0F);

		rightLeg.addChild(RIGHT_SKIRT);
		leftLeg.addChild(LEFT_SKIRT);
	}
}
