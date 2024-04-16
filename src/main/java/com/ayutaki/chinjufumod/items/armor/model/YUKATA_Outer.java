package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class YUKATA_Outer extends BaseArmor {

	private ModelRenderer MUSUBI;
	private ModelRenderer MUSUBI_T;
	private ModelRenderer MUSUBI_T2;
	private ModelRenderer OBI;

	private ModelRenderer YKT_BODY;
	
	private ModelRenderer RIGHT_SODE;
	private ModelRenderer LEFT_SODE;

	public YUKATA_Outer(float scale) {
		super(scale);

		MUSUBI = new ModelRenderer(this, 32, 32);
		MUSUBI.addBox(-4.0F, 4.875F, 2.66F, 8, 5, 1, -0.15F);
		MUSUBI.setRotationPoint(0F, 0F, 0F);
		MUSUBI_T = new ModelRenderer(this, 32, 40);
		MUSUBI_T.addBox(-4.125F, 7.05F, 2.38F, 8, 3, 1, -0.425F);
		MUSUBI_T.setRotationPoint(0F, 0F, 0F);
		MUSUBI_T2 = new ModelRenderer(this, 32, 45);
		MUSUBI_T2.addBox(-4.125F, 7.4F, 2.725F, 8, 4, 1, -0.18F);
		MUSUBI_T2.setRotationPoint(0F, 0F, 0F);
		OBI = new ModelRenderer(this, 0, 100);
		OBI.addBox(-5.0F, 4.0F, -3.0F, 10, 7, 6, -0.18F);
		OBI.setRotationPoint(0F, 0F, 0F);
		
		YKT_BODY = new ModelRenderer(this, 0, 32);
		YKT_BODY.addBox(-5.0F, -0.5F, -3.0F, 10, 16, 6, -0.2F);
		YKT_BODY.setRotationPoint(0F, 0F, 0F);
		
		RIGHT_SODE= new ModelRenderer(this, 0, 54);
		RIGHT_SODE.addBox(-3.5F, -2.5F, -2.5F, 5, 12, 5, 0.0F);
		RIGHT_SODE.setRotationPoint(0F, 0F, 0F);
		LEFT_SODE= new ModelRenderer(this, 24, 54);
		LEFT_SODE.addBox(-1.5F, -2.5F, -2.5F, 5, 12, 5, 0.0F);
		LEFT_SODE.setRotationPoint(0F, 0F, 0F);

		bipedBody.addChild(MUSUBI);
		bipedBody.addChild(MUSUBI_T);
		bipedBody.addChild(MUSUBI_T2);
		bipedBody.addChild(OBI);
		
		bipedBody.addChild(YKT_BODY);
		
		bipedRightArm.addChild(RIGHT_SODE);
		bipedLeftArm.addChild(LEFT_SODE);
	}
}
