package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SendaiInner extends BaseArmor {

	private ModelRenderer ERI;
	private ModelRenderer TIE;
	private ModelRenderer RIBON;
	private ModelRenderer SKIRT;
	
	private ModelRenderer RIGHT_SKIRT;
	private ModelRenderer LEFT_SKIRT;
	
	private ModelRenderer RIGHT_WA;
	private ModelRenderer TANSHOU;
	
	public SendaiInner(float scale) {
		super(scale);
		float ag = (float)Math.PI / 180;
		
		ERI = new ModelRenderer(this, 32, 32);
		ERI.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, scale + 0.2F);
		ERI.setRotationPoint(0F, 0F, 0F);
		TIE = new ModelRenderer(this, 32, 48);
		TIE.addBox(-4.0F, 0.1F, -1.885F, 8, 12, 4, scale + 0.15F);
		TIE.setRotationPoint(0F, 0F, 0F);
		TIE.rotateAngleX = -1 * ag;
		RIBON = new ModelRenderer(this, 32, 64);
		RIBON.addBox(-4.0F, 0.1F, -2.35F, 8, 12, 4, scale + 0.1F);
		RIBON.setRotationPoint(0F, 0F, 0F);
		RIBON.rotateAngleX = 3 * ag;
		SKIRT = new ModelRenderer(this, 32, 80);
		SKIRT.addBox(-4.0F, 10.0F, -2.0F, 8, 12, 4, scale + 0.15F);
		SKIRT.setRotationPoint(0F, 0F, 0F);
		
		RIGHT_SKIRT = new ModelRenderer(this, 0, 32);
		RIGHT_SKIRT.addBox(-2.09F, -1.0F, -2.0F, 4, 12, 4, scale);
		RIGHT_SKIRT.setRotationPoint(0F, 0F, 0F);
		LEFT_SKIRT = new ModelRenderer(this, 16, 32);
		LEFT_SKIRT.addBox(-1.91F, -1.0F, -1.99F, 4, 12, 4, scale);
		LEFT_SKIRT.setRotationPoint(0F, 0F, 0F);
		
		RIGHT_WA = new ModelRenderer(this, 0, 48);
		RIGHT_WA.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.3F);
		RIGHT_WA.setRotationPoint(0F, 0F, 0F);
		TANSHOU = new ModelRenderer(this, 0, 64);
		TANSHOU.addBox(-4.15F, 2.75F, -2.0F, 2, 2, 4, -0.2F);
		TANSHOU.setRotationPoint(0F, 0F, 0F);

		
		bipedBody.addChild(ERI);
		bipedBody.addChild(TIE);
		bipedBody.addChild(RIBON);
		bipedBody.addChild(SKIRT);
	
		bipedRightLeg.addChild(RIGHT_SKIRT);
		bipedLeftLeg.addChild(LEFT_SKIRT);
		
		bipedRightLeg.addChild(RIGHT_WA);
		bipedRightLeg.addChild(TANSHOU);
	}
}
