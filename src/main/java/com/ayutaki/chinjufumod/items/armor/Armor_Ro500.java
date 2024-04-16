package com.ayutaki.chinjufumod.items.armor;

import java.util.function.Consumer;

import com.ayutaki.chinjufumod.ConfigClient_CM;
import com.ayutaki.chinjufumod.handler.ArmorLayer_CM;
import com.ayutaki.chinjufumod.items.armor.model.BaseArmor;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class Armor_Ro500 extends Base_Submarine {

	public Armor_Ro500(ArmorMaterial material, ArmorItem.Type slot, Item.Properties properties) {
		super(material, slot, properties);
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void initializeClient(Consumer<net.minecraftforge.client.extensions.common.IClientItemExtensions> consumer) {
		consumer.accept(new IClientItemExtensions() {
			@Override
			public HumanoidModel<?> getHumanoidArmorModel(LivingEntity entityIn, ItemStack stack, EquipmentSlot slot, HumanoidModel<?> defModel) {
				EntityModelSet entityModel = Minecraft.getInstance().getEntityModels();
				int CHEST = ConfigClient_CM.INSTANCE.chestplateTexture.get();
				int LEG = ConfigClient_CM.INSTANCE.leggingsTexture.get();
				ModelPart part = entityModel.bakeLayer(slot == EquipmentSlot.LEGS ? ((LEG == 1)? ArmorLayer_CM.UKIWA_INNER : ArmorLayer_CM.SUBMARINE_INNER) : ((CHEST == 2)? ArmorLayer_CM.RO500_OUTER_C : ArmorLayer_CM.RO500_OUTER));
				return new BaseArmor(part); }
		});
	}
}
