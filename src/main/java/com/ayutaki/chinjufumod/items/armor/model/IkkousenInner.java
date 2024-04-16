package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class IkkousenInner extends BaseArmor {

	private ModelRenderer MAEKAKE;

	private ModelRenderer RIGHT_HAKAMA;
	private ModelRenderer LEFT_HAKAMA;
	
	public IkkousenInner(float scale) {
		super(scale);

		MAEKAKE = new ModelRenderer(this, 0, 32);
		MAEKAKE.addBox(-4.5F, 9.5F, -2.25F, 9, 5, 5, 0.5F);
		MAEKAKE.setPos(0F, 0F, 0F);
		
		RIGHT_HAKAMA = new ModelRenderer(this, 0, 42);
		RIGHT_HAKAMA.addBox(-2.5F, -1.0F, -2.25F, 5, 5, 5, 0.24F);
		RIGHT_HAKAMA.setPos(0F, 0F, 0F);
		LEFT_HAKAMA = new ModelRenderer(this, 0, 42);
		LEFT_HAKAMA.mirror = true;
		LEFT_HAKAMA.addBox(-2.5F, -1.0F, -2.25F, 5, 5, 5, 0.24F);
		LEFT_HAKAMA.setPos(0F, 0F, 0F);

		
		body.addChild(MAEKAKE);
		rightLeg.addChild(RIGHT_HAKAMA);
		leftLeg.addChild(LEFT_HAKAMA);
	}
}