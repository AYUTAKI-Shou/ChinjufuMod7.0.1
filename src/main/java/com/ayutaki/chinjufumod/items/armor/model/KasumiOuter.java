package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class KasumiOuter extends BaseArmor {

	private ModelRenderer RIBON;

	private ModelRenderer ENTOTSU;
	private ModelRenderer KOSHI_R;
	private ModelRenderer KOSHI_L;
	private ModelRenderer ERI;
	private ModelRenderer SHIRT;
	
	private ModelRenderer RIGHT_SODE;
	private ModelRenderer LEFT_SODE;
	private ModelRenderer RIGHT_SOX;
	private ModelRenderer LEFT_SOX;

	public KasumiOuter(float scale) {
		super(scale);

		RIBON = new ModelRenderer(this, 0, 96);
		RIBON.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.3F);
		RIBON.setPos(0F, 0F, 0F);
		
		ENTOTSU = new ModelRenderer(this, 0, 50);
		ENTOTSU.addBox(-11.0F, -10.0F, 4.01F, 22, 28, 1, 0.0F);
		ENTOTSU.setPos(0F, 0F, 0F);
		KOSHI_R = new ModelRenderer(this, 0, 32);
		KOSHI_R.addBox(-4.25F, -0.25F, -2.5F, 5, 12, 6, 0.5F);
		KOSHI_R.setPos(0F, 0F, 0F);
		KOSHI_L = new ModelRenderer(this, 0, 32);
		KOSHI_L.mirror = true;
		KOSHI_L.addBox(-0.75F, -0.25F, -2.5F, 5, 12, 6, 0.5F);
		KOSHI_L.setPos(0F, 0F, 0F);

		ERI = new ModelRenderer(this, 32, 32);
		ERI.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, scale + 0.1F);
		ERI.setPos(0F, 0F, 0F);
		SHIRT = new ModelRenderer(this, 32, 96);
		SHIRT.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, scale - 0.06F);
		SHIRT.setPos(0F, 0F, 0F);
		
		RIGHT_SODE = new ModelRenderer(this, 32, 80);
		RIGHT_SODE.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.3F);
		RIGHT_SODE.setPos(0F, 0F, 0F);
		LEFT_SODE = new ModelRenderer(this, 32, 80);
		LEFT_SODE.mirror = true;
		LEFT_SODE.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.3F);
		LEFT_SODE.setPos(0F, 0F, 0F);
		
		RIGHT_SOX = new ModelRenderer(this, 0, 80);
		RIGHT_SOX.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.15F); 
		RIGHT_SOX.setPos(0F, 0F, 0F);
		LEFT_SOX = new ModelRenderer(this, 0, 80);
		LEFT_SOX.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.15F);
		LEFT_SOX.setPos(0F, 0F, 0F);
	
		head.addChild(RIBON);
		
		body.addChild(ENTOTSU);
		body.addChild(KOSHI_R);
		body.addChild(KOSHI_L);
		body.addChild(ERI);
		body.addChild(SHIRT);
		
		rightArm.addChild(RIGHT_SODE);
		leftArm.addChild(LEFT_SODE);
		rightLeg.addChild(RIGHT_SOX);
		leftLeg.addChild(LEFT_SOX);
	}
}
