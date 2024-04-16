package com.ayutaki.chinjufumod.items.armor;

import com.ayutaki.chinjufumod.Config_CM;
import com.ayutaki.chinjufumod.items.armor.model.SubmarineInner;
import com.ayutaki.chinjufumod.items.armor.model.SubmarineOuter;
import com.ayutaki.chinjufumod.items.armor.model.UKIWA_Inner;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Armor_i168 extends Base_Submarine {

	public Armor_i168(String name, ArmorMaterial a_material, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(name, a_material, renderIndexIn, equipmentSlotIn);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public net.minecraft.client.model.ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack stack, EntityEquipmentSlot slotType, ModelBiped _default) {
		int LEG = Config_CM.leggingsTexture;
		return (slotType == EntityEquipmentSlot.LEGS)? ((LEG == 1)? new UKIWA_Inner(0.15F) : new SubmarineInner(0.15F)) : new SubmarineOuter(0.55F);
	}
}
