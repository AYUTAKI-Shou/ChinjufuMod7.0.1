package com.ayutaki.chinjufumod.items.armor;

import com.ayutaki.chinjufumod.ConfigClient_CM;
import com.ayutaki.chinjufumod.items.armor.model.SubmarineInner;
import com.ayutaki.chinjufumod.items.armor.model.SubmarineOuter;
import com.ayutaki.chinjufumod.items.armor.model.UKIWA_Inner;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Armor_i168 extends Base_Submarine {

	public Armor_i168(IArmorMaterial material, EquipmentSlotType slot, Properties properties) {
		super(material, slot, properties);
	}

	@SuppressWarnings("unchecked")
	@OnlyIn(Dist.CLIENT)
	@Override
	public <Armor extends BipedModel<?>> Armor getArmorModel(LivingEntity entityLiving, ItemStack stack, EquipmentSlotType slotType, Armor defModel) {
		int LEG = ConfigClient_CM.getInstance().leggingsTexture();
		return (Armor) (slotType == EquipmentSlotType.LEGS ? ((LEG == 1)? new UKIWA_Inner(0.15F) : new SubmarineInner(0.15F)) : new SubmarineOuter(0.55F));
	}
}
