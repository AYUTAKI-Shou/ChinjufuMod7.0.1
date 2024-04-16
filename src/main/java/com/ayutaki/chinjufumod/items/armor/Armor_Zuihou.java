package com.ayutaki.chinjufumod.items.armor;

import java.util.function.Consumer;

import com.ayutaki.chinjufumod.handler.ArmorLayer_CM;
import com.ayutaki.chinjufumod.items.armor.model.BaseArmor;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.IItemRenderProperties;

public class Armor_Zuihou extends Base_CarrierItem {

	public Armor_Zuihou(ArmorMaterial material, EquipmentSlot slot, Item.Properties properties) {
		super(material, slot, properties);
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void initializeClient(Consumer<net.minecraftforge.client.IItemRenderProperties> consumer) {
		consumer.accept(new IItemRenderProperties() {
			@Override
			public HumanoidModel<?> getArmorModel(LivingEntity entityIn, ItemStack stack, EquipmentSlot slot, HumanoidModel<?> defModel) {
				EntityModelSet entityModel = Minecraft.getInstance().getEntityModels();
				ModelPart part = entityModel.bakeLayer(slot == EquipmentSlot.LEGS ? ArmorLayer_CM.ZUIHOU_INNER : ArmorLayer_CM.ZUIHOU_OUTER);
				return new BaseArmor(part); }
		});
	}
}