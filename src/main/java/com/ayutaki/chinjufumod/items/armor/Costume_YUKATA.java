package com.ayutaki.chinjufumod.items.armor;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.items.armor.model.YUKATA_Inner;
import com.ayutaki.chinjufumod.items.armor.model.YUKATA_Outer;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Costume_YUKATA extends Base_WearItem {

	public Costume_YUKATA(IArmorMaterial material, EquipmentSlotType slot, Properties properties) {
		super(material, slot, properties);
	}

	@SuppressWarnings("unchecked")
	@OnlyIn(Dist.CLIENT)
	@Override
	public <Armor extends BipedModel<?>> Armor getArmorModel(LivingEntity entityLiving, ItemStack stack, EquipmentSlotType slotType, Armor defModel) {
		return (Armor) (slotType == EquipmentSlotType.LEGS ? new YUKATA_Inner(-0.1F) : new YUKATA_Outer(0.55F));
	}

	/* Items needed for repair. */
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack material) {
		if (this == Items_Seasonal.YKTD_GETA) { return material.getItem() == Items.DARK_OAK_SLAB; }

		if (this == Items_Seasonal.YKTO_GETA) { return material.getItem() == Items.OAK_SLAB; }

		if (this == Items_Seasonal.IKADUCHIYKT_HELMET || this == Items_Seasonal.INADUMAYKT_HELMET) {
			return material.getItem() == Items_Seasonal.KAEDE_slabhalf; }

		if (this == Items_Seasonal.KAWAKAZEYKT_HELMET || this == Items_Seasonal.URAKAZEYKT_HELMET) {
			return material.getItem() == Items.BIRCH_SLAB; }

		if (this == Items_Seasonal.OBOROYKT_HELMET) { return material.getItem() == Items.DANDELION; }

		if (this == Items_Seasonal.HAMAKAZEYKT_HELMET) { return material.getItem() == Items.POPPY; }

		else { return material.getItem() == Items_Seasonal.TANMONO; }
	}

	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {

		if (this != Items_Seasonal.YKTD_GETA && this != Items_Seasonal.YKTO_GETA &&
			this != Items_Seasonal.IKADUCHIYKT_HELMET && this != Items_Seasonal.INADUMAYKT_HELMET &&
			this != Items_Seasonal.KAWAKAZEYKT_HELMET && this != Items_Seasonal.URAKAZEYKT_HELMET &&
			this != Items_Seasonal.OBOROYKT_HELMET && this != Items_Seasonal.HAMAKAZEYKT_HELMET) {

			tooltip.add(new TranslationTextComponent("tips.item_ykt").applyTextStyle(TextFormatting.GRAY)); }
	}
}
