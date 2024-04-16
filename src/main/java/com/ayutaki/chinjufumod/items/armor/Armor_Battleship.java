package com.ayutaki.chinjufumod.items.armor;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.items.armor.model.BattleshipInner;
import com.ayutaki.chinjufumod.items.armor.model.BattleshipOuter;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Armor_Battleship extends Base_BattleshipItem {

	public Armor_Battleship(IArmorMaterial material, EquipmentSlotType slot, Properties properties) {
		super(material, slot, properties);
	}
	
	@SuppressWarnings("unchecked")
	@Nullable
	@Override
	@OnlyIn(Dist.CLIENT)
	public <Armor extends BipedModel<?>> Armor getArmorModel(LivingEntity entityLiving, ItemStack stack, EquipmentSlotType slot, Armor defModel) {
		return (Armor) (slot == EquipmentSlotType.LEGS ? new BattleshipInner(0.4F) : new BattleshipOuter(0.55F));
	}
}
