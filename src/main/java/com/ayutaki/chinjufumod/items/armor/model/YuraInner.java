package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class YuraInner extends BaseArmor {

	private ModelRenderer ERI;
	private ModelRenderer RIBON;
	
	private ModelRenderer RIGHT_SKIRT;
	private ModelRenderer LEFT_SKIRT;

	private ModelRenderer RIGHT_GYORAI;
	private ModelRenderer LEFT_GYORAI;

	
	public YuraInner(float scale) {
		super(scale);

		ERI = new ModelRenderer(this, 32, 32);
		ERI.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, scale + 0.2F);
		ERI.setPos(0F, 0F, 0F);
		RIBON = new ModelRenderer(this, 32, 48);
		RIBON.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, scale + 0.1F);
		RIBON.setPos(0F, 0F, 0F);
		
		RIGHT_SKIRT = new ModelRenderer(this, 0, 32);
		RIGHT_SKIRT.addBox(-2.09F, -1.0F, -2.0F, 4, 12, 4, scale);
		RIGHT_SKIRT.setPos(0F, 0F, 0F);
		LEFT_SKIRT = new ModelRenderer(this, 16, 32);
		LEFT_SKIRT.addBox(-1.91F, -1.0F, -1.99F, 4, 12, 4, scale);
		LEFT_SKIRT.setPos(0F, 0F, 0F);
		
		RIGHT_GYORAI = new ModelRenderer(this, 0, 48);
		RIGHT_GYORAI.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.5F);
		RIGHT_GYORAI.setPos(0F, 0F, 0F);
		LEFT_GYORAI = new ModelRenderer(this, 0, 48);
		LEFT_GYORAI.mirror = true;
		LEFT_GYORAI.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.5F);
		LEFT_GYORAI.setPos(0F, 0F, 0F);

	
		body.addChild(ERI);
		body.addChild(RIBON);
		
		rightLeg.addChild(RIGHT_SKIRT);
		leftLeg.addChild(LEFT_SKIRT);
		rightLeg.addChild(RIGHT_GYORAI);
		leftLeg.addChild(LEFT_GYORAI);
	}
}