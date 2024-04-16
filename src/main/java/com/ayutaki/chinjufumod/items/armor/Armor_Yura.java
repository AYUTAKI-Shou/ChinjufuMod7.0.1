package com.ayutaki.chinjufumod.items.armor;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.items.armor.model.YuraInner;
import com.ayutaki.chinjufumod.items.armor.model.YuraOuter;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Armor_Yura extends Base_CruiserItem {

	public Armor_Yura(IArmorMaterial material, EquipmentSlotType slot, Properties properties) {
		super(material, slot, properties);
	}

	@SuppressWarnings("unchecked")
	@Nullable
	@Override
	@OnlyIn(Dist.CLIENT)
	public <Armor extends BipedModel<?>> Armor getArmorModel(LivingEntity entityLiving, ItemStack stack, EquipmentSlotType slot, Armor defModel) {
		return (Armor) (slot == EquipmentSlotType.LEGS ? new YuraInner(0.4F) : new YuraOuter(0.55F));
	}
}
