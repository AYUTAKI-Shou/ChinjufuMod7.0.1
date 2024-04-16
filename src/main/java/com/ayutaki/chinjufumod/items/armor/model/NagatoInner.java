package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class NagatoInner extends BaseArmor {

	private ModelRenderer KOSHI_NAGATO;
	private ModelRenderer ENTOTSU_NAGATO;
	private ModelRenderer JOINT_NAGATO;
	
	private ModelRenderer RIGHT_SKIRT;
	private ModelRenderer LEFT_SKIRT;

	
	public NagatoInner(float scale) {
		super(scale);

		KOSHI_NAGATO = new ModelRenderer(this, 32, 32);
		KOSHI_NAGATO.addBox(-4.5F, 7.75F, -2.25F, 9, 5, 5, 0.52F);
		KOSHI_NAGATO.setPos(0F, 0F, 0F);
		ENTOTSU_NAGATO = new ModelRenderer(this, 0, 70);
		ENTOTSU_NAGATO.addBox(-11.0F, -6.5F, 3.51F, 22, 24, 2, 0.0F);
		ENTOTSU_NAGATO.setPos(0F, 0F, 0F);
		JOINT_NAGATO = new ModelRenderer(this, 32, 102);
		JOINT_NAGATO.addBox(-2.0F, 8.25F, 2.5F, 4, 2, 3, 0.0F);
		JOINT_NAGATO.setPos(0F, 0F, 0F);

		RIGHT_SKIRT = new ModelRenderer(this, 0, 32);
		RIGHT_SKIRT.addBox(-2.09F, -1.0F, -2.0F, 4, 12, 4, scale);
		RIGHT_SKIRT.setPos(0F, 0F, 0F);
		LEFT_SKIRT = new ModelRenderer(this, 16, 32);
		LEFT_SKIRT.addBox(-1.91F, -1.0F, -1.99F, 4, 12, 4, scale);
		LEFT_SKIRT.setPos(0F, 0F, 0F);


		body.addChild(KOSHI_NAGATO);
		body.addChild(ENTOTSU_NAGATO);
		body.addChild(JOINT_NAGATO);

		rightLeg.addChild(RIGHT_SKIRT);
		leftLeg.addChild(LEFT_SKIRT);
	}
}