package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ZuihouInner extends BaseArmor {

	private ModelRenderer MAEKAKE;
	private ModelRenderer TOME;
	private ModelRenderer YADUTU;
	private ModelRenderer YADUTU_TOP;
	private ModelRenderer YA;

	private ModelRenderer RIGHT_HAKAMA;
	private ModelRenderer LEFT_HAKAMA;
	private ModelRenderer RIGHT_WA;
	private ModelRenderer LEFT_WA;
	
	public ZuihouInner(float scale) {
		super(scale);

		MAEKAKE = new ModelRenderer(this, 0, 32);
		MAEKAKE.addBox(-4.5F, 9.5F, -2.25F, 9, 5, 5, 0.5F);
		MAEKAKE.setPos(0F, 0F, 0F);
		
		TOME = new ModelRenderer(this, 0, 64);
		TOME.addBox(2.35F, 8.75F, 2.75F, 1, 1, 2, -0.1F);
		TOME.setPos(0F, 0F, 0F);
		TOME.zRot = 0.3F;
		YADUTU = new ModelRenderer(this, 0, 52);
		YADUTU.addBox(-2.5F, 8.0F, 4.0F, 12, 2, 2, 0.0F);
		YADUTU.setPos(0F, 0F, 0F);
		YADUTU.zRot = 0.3F;
		YADUTU_TOP = new ModelRenderer(this, 0, 56);
		YADUTU_TOP.addBox(-6.5F, 8.0F, 4.0F, 16, 2, 2, 0.0F);
		YADUTU_TOP.setPos(0F, 0F, 0F);
		YADUTU_TOP.zRot = 0.3F;
		YA = new ModelRenderer(this, 0, 60);
		YA.addBox(-7.0F, 8.0F, 4.0F, 16, 2, 2, -0.4F);
		YA.setPos(0F, 0F, 0F);
		YA.zRot = 0.3F;

		RIGHT_HAKAMA = new ModelRenderer(this, 0, 42);
		RIGHT_HAKAMA.addBox(-2.5F, -1.0F, -2.25F, 5, 5, 5, 0.24F);
		RIGHT_HAKAMA.setPos(0F, 0F, 0F);
		LEFT_HAKAMA = new ModelRenderer(this, 0, 42);
		LEFT_HAKAMA.mirror = true;
		LEFT_HAKAMA.addBox(-2.5F, -1.0F, -2.25F, 5, 5, 5, 0.24F);
		LEFT_HAKAMA.setPos(0F, 0F, 0F);
		RIGHT_WA = new ModelRenderer(this, 32, 32);
		RIGHT_WA.addBox(-2.0F, 4.0F, -2.0F, 4, 1, 4, 0.2F);
		RIGHT_WA.setPos(0F, 0F, 0F);
		LEFT_WA = new ModelRenderer(this, 32, 32);
		LEFT_WA.addBox(-2.0F, 4.0F, -2.0F, 4, 1, 4, 0.2F);
		LEFT_WA.setPos(0F, 0F, 0F);

		
		body.addChild(MAEKAKE);
		body.addChild(TOME);
		body.addChild(YADUTU);
		body.addChild(YADUTU_TOP);
		body.addChild(YA);
		
		rightLeg.addChild(RIGHT_HAKAMA);
		leftLeg.addChild(LEFT_HAKAMA);
		rightLeg.addChild(RIGHT_WA);
		leftLeg.addChild(LEFT_WA);
	}
}
