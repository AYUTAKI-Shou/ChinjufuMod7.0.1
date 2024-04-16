package com.ayutaki.chinjufumod.items.armor;

import com.ayutaki.chinjufumod.Config_CM;
import com.ayutaki.chinjufumod.items.armor.model.Ro500_Outer;
import com.ayutaki.chinjufumod.items.armor.model.Ro500_OuterC;
import com.ayutaki.chinjufumod.items.armor.model.SubmarineInner;
import com.ayutaki.chinjufumod.items.armor.model.UKIWA_Inner;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Armor_Ro500 extends Base_Submarine {

	public Armor_Ro500(String name, ArmorMaterial a_material, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(name, a_material, renderIndexIn, equipmentSlotIn);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public net.minecraft.client.model.ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack stack, EntityEquipmentSlot slotType, ModelBiped _default) {
		int CHEST = Config_CM.chestplateTexture;
		int LEG = Config_CM.leggingsTexture;
		return (slotType == EntityEquipmentSlot.LEGS)? ((LEG == 1)? new UKIWA_Inner(0.15F) : new SubmarineInner(0.15F)) : ((CHEST == 2)? new Ro500_OuterC(0.55F) : new Ro500_Outer(0.55F));
	}
}
