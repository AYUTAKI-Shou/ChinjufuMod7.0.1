package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class IkkousenInner extends BaseArmor {

	private ModelRenderer MAEKAKE;

	private ModelRenderer RIGHT_HAKAMA;
	private ModelRenderer LEFT_HAKAMA;
	
	public IkkousenInner(float scale) {
		super(scale);

		MAEKAKE = new ModelRenderer(this, 0, 32);
		MAEKAKE.addBox(-4.5F, 9.5F, -2.25F, 9, 5, 5, 0.5F);
		MAEKAKE.setRotationPoint(0F, 0F, 0F);
		
		RIGHT_HAKAMA = new ModelRenderer(this, 0, 42);
		RIGHT_HAKAMA.addBox(-2.5F, -1.0F, -2.25F, 5, 5, 5, 0.24F);
		RIGHT_HAKAMA.setRotationPoint(0F, 0F, 0F);
		LEFT_HAKAMA = new ModelRenderer(this, 0, 42);
		LEFT_HAKAMA.mirror = true;
		LEFT_HAKAMA.addBox(-2.5F, -1.0F, -2.25F, 5, 5, 5, 0.24F);
		LEFT_HAKAMA.setRotationPoint(0F, 0F, 0F);

		
		bipedBody.addChild(MAEKAKE);
		bipedRightLeg.addChild(RIGHT_HAKAMA);
		bipedLeftLeg.addChild(LEFT_HAKAMA);
	}
}
