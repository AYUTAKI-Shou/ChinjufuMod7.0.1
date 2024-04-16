package com.ayutaki.chinjufumod.items.armor;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ConfigClient_CM;
import com.ayutaki.chinjufumod.items.armor.model.Ro500_Outer;
import com.ayutaki.chinjufumod.items.armor.model.Ro500_OuterC;
import com.ayutaki.chinjufumod.items.armor.model.SubmarineInner;
import com.ayutaki.chinjufumod.items.armor.model.UKIWA_Inner;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Armor_Ro500 extends Base_Submarine {

	public Armor_Ro500(IArmorMaterial material, EquipmentSlotType slot, Properties properties) {
		super(material, slot, properties);
	}
	
	@SuppressWarnings("unchecked")
	@Nullable
	@Override
	@OnlyIn(Dist.CLIENT)
	public <Armor extends BipedModel<?>> Armor getArmorModel(LivingEntity entityLiving, ItemStack stack, EquipmentSlotType slot, Armor defModel) {
		int CHEST = ConfigClient_CM.getInstance().chestplateTexture();
		int LEG = ConfigClient_CM.getInstance().leggingsTexture();
		return (Armor) (slot == EquipmentSlotType.LEGS ? ((LEG == 1)? new UKIWA_Inner(0.15F) : new SubmarineInner(0.15F)) : ((CHEST == 2)? new Ro500_OuterC(0.55F) : new Ro500_Outer(0.55F)));
	}
}
