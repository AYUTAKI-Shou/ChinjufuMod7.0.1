package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GisouInner extends BaseArmor {

	private ModelRenderer RIGHT_SKIRT;
	private ModelRenderer LEFT_SKIRT;

	private ModelRenderer RIGHT_WA;
	private ModelRenderer LEFT_WA;
	private ModelRenderer RIGHT_GYORAI;
	private ModelRenderer LEFT_GYORAI;

	public GisouInner(float scale) {
		super(scale);
		
		RIGHT_SKIRT = new ModelRenderer(this, 0, 32);
		RIGHT_SKIRT.addBox(-2.09F, -1.0F, -2.0F, 4, 12, 4, scale);
		RIGHT_SKIRT.setPos(0F, 0F, 0F);
		LEFT_SKIRT = new ModelRenderer(this, 16, 32);
		LEFT_SKIRT.addBox(-1.91F, -1.0F, -1.99F, 4, 12, 4, scale);
		LEFT_SKIRT.setPos(0F, 0F, 0F);
		
		RIGHT_WA = new ModelRenderer(this, 0, 48);
		RIGHT_WA.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, scale);
		RIGHT_WA.setPos(0F, 0F, 0F);
		LEFT_WA = new ModelRenderer(this, 0, 48);
		LEFT_WA.mirror = true;
		LEFT_WA.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, scale);
		LEFT_WA.setPos(0F, 0F, 0F);
		
		RIGHT_GYORAI = new ModelRenderer(this, 0, 64);
		RIGHT_GYORAI.addBox(-2.3F, 0.0F, -2.0F, 4, 12, 4, scale);
		RIGHT_GYORAI.setPos(0F, 0F, 0F);
		LEFT_GYORAI = new ModelRenderer(this, 0, 64);
		LEFT_GYORAI.mirror = true;
		LEFT_GYORAI.addBox(-1.7F, 0.0F, -2.0F, 4, 12, 4, scale);
		LEFT_GYORAI.setPos(0F, 0F, 0F);
		

		rightLeg.addChild(RIGHT_SKIRT);
		leftLeg.addChild(LEFT_SKIRT);
		
		rightLeg.addChild(RIGHT_WA);
		leftLeg.addChild(LEFT_WA);
		rightLeg.addChild(RIGHT_GYORAI);
		leftLeg.addChild(LEFT_GYORAI);
	}
}