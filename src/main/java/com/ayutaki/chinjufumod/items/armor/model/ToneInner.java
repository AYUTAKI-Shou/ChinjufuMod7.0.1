package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ToneInner extends BaseArmor {

	private ModelRenderer ERI;
	private ModelRenderer KOSHI_F;
	private ModelRenderer KOSHI_B;
	
	private ModelRenderer LEFT_WA;
	private ModelRenderer LEFT_GYORAI;
	

	public ToneInner(float scale) {
		super(scale);
		float ag = (float)Math.PI / 180;
		
		ERI = new ModelRenderer(this, 0, 76);
		ERI.addBox(-4.5F, 0.0F, -2.3F, 9, 12, 5, 0.45F);
		ERI.setPos(0F, 0F, 0F);
				
		KOSHI_F = new ModelRenderer(this, 32, 32);
		KOSHI_F.addBox(-4.0F, 10.75F, -1.875F, 8, 12, 4, 0.55F);
		KOSHI_F.setPos(0F, 0F, 0F); 
		KOSHI_F.xRot = -1 * ag;
		KOSHI_B = new ModelRenderer(this, 32, 48);
		KOSHI_B.addBox(-4.0F, 10.75F, -2.125F, 8, 12, 4, 0.55F);
		KOSHI_B.setPos(0F, 0F, 0F);
		KOSHI_B.xRot = 1 * ag;
		
		LEFT_WA = new ModelRenderer(this, 16, 32);
		LEFT_WA.addBox(-2.0F, -1.0F, -2.0F, 4, 12, 4, 0.35F);
		LEFT_WA.setPos(0F, 0F, 0F);
		LEFT_GYORAI = new ModelRenderer(this, 16, 48);
		LEFT_GYORAI.addBox(-1.65F, -1.0F, -2.0F, 4, 12, 4, 0.4F);
		LEFT_GYORAI.setPos(0F, 0F, 0F);

		
		body.addChild(ERI);
		body.addChild(KOSHI_F);
		body.addChild(KOSHI_B);
		
		leftLeg.addChild(LEFT_WA);
		leftLeg.addChild(LEFT_GYORAI);
	}
}