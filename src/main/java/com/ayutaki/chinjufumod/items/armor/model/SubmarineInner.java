package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SubmarineInner extends BaseArmor {

	private ModelRenderer ERI;
	private ModelRenderer UWAGI;
	private ModelRenderer TIE;
	
	private ModelRenderer RIGHT_WA;
	private ModelRenderer LEFT_WA;
	
	public SubmarineInner(float scale) {
		super(scale);
		
		ERI = new ModelRenderer(this, 32, 32);
		ERI.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, scale + 0.3F);
		ERI.setPos(0F, 0F, 0F);
		UWAGI = new ModelRenderer(this, 32, 48);
		UWAGI.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, scale + 0.2F);
		UWAGI.setPos(0F, 0F, 0F);
		TIE = new ModelRenderer(this, 32, 64);
		TIE.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, scale + 0.1F);
		TIE.setPos(0F, 0F, 0F);
	
		RIGHT_WA = new ModelRenderer(this, 0, 48);
		RIGHT_WA.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, scale + 0.1F);
		RIGHT_WA.setPos(0F, 0F, 0F);
		LEFT_WA = new ModelRenderer(this, 0, 48);
		LEFT_WA.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, scale + 0.1F);
		LEFT_WA.setPos(0F, 0F, 0F);

		
		body.addChild(ERI);
		body.addChild(UWAGI);
		body.addChild(TIE);
		
		rightLeg.addChild(RIGHT_WA);
		leftLeg.addChild(LEFT_WA);
	}
}
