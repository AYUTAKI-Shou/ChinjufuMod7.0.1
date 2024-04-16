package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
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
		MAEKAKE.setRotationPoint(0F, 0F, 0F);
		
		TOME = new ModelRenderer(this, 0, 64);
		TOME.addBox(2.35F, 8.75F, 2.75F, 1, 1, 2, -0.1F);
		TOME.setRotationPoint(0F, 0F, 0F);
		TOME.rotateAngleZ = 0.3F;
		YADUTU = new ModelRenderer(this, 0, 52);
		YADUTU.addBox(-2.5F, 8.0F, 4.0F, 12, 2, 2, 0.0F);
		YADUTU.setRotationPoint(0F, 0F, 0F);
		YADUTU.rotateAngleZ = 0.3F;
		YADUTU_TOP = new ModelRenderer(this, 0, 56);
		YADUTU_TOP.addBox(-6.5F, 8.0F, 4.0F, 16, 2, 2, 0.0F);
		YADUTU_TOP.setRotationPoint(0F, 0F, 0F);
		YADUTU_TOP.rotateAngleZ = 0.3F;
		YA = new ModelRenderer(this, 0, 60);
		YA.addBox(-7.0F, 8.0F, 4.0F, 16, 2, 2, -0.4F);
		YA.setRotationPoint(0F, 0F, 0F);
		YA.rotateAngleZ = 0.3F;

		RIGHT_HAKAMA = new ModelRenderer(this, 0, 42);
		RIGHT_HAKAMA.addBox(-2.5F, -1.0F, -2.25F, 5, 5, 5, 0.24F);
		RIGHT_HAKAMA.setRotationPoint(0F, 0F, 0F);
		LEFT_HAKAMA = new ModelRenderer(this, 0, 42);
		LEFT_HAKAMA.mirror = true;
		LEFT_HAKAMA.addBox(-2.5F, -1.0F, -2.25F, 5, 5, 5, 0.24F);
		LEFT_HAKAMA.setRotationPoint(0F, 0F, 0F);
		RIGHT_WA = new ModelRenderer(this, 32, 32);
		RIGHT_WA.addBox(-2.0F, 4.0F, -2.0F, 4, 1, 4, 0.2F);
		RIGHT_WA.setRotationPoint(0F, 0F, 0F);
		LEFT_WA = new ModelRenderer(this, 32, 32);
		LEFT_WA.addBox(-2.0F, 4.0F, -2.0F, 4, 1, 4, 0.2F);
		LEFT_WA.setRotationPoint(0F, 0F, 0F);

		
		bipedBody.addChild(MAEKAKE);
		bipedBody.addChild(TOME);
		bipedBody.addChild(YADUTU);
		bipedBody.addChild(YADUTU_TOP);
		bipedBody.addChild(YA);
		
		bipedRightLeg.addChild(RIGHT_HAKAMA);
		bipedLeftLeg.addChild(LEFT_HAKAMA);
		bipedRightLeg.addChild(RIGHT_WA);
		bipedLeftLeg.addChild(LEFT_WA);
	}
}
