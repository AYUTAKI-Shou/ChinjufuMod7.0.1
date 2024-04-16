package com.ayutaki.chinjufumod.items.armor;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.items.armor.model.YUKATA_Inner;
import com.ayutaki.chinjufumod.items.armor.model.YUKATA_Outer;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Costume_YUKATA extends Base_WearItem {

	public Costume_YUKATA(String name, ArmorMaterial a_material, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(a_material, renderIndexIn, equipmentSlotIn);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public net.minecraft.client.model.ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack stack, 
			EntityEquipmentSlot slotType, ModelBiped _default) {
		return (slotType == EntityEquipmentSlot.LEGS)? new YUKATA_Inner(-0.1F) : new YUKATA_Outer(0.55F);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();

		if (this != Items_Seasonal.YKTD_GETA && this != Items_Seasonal.YKTO_GETA &&
				this != Items_Seasonal.IKADUCHIYKT_HELMET && this != Items_Seasonal.INADUMAYKT_HELMET &&
				this != Items_Seasonal.KAWAKAZEYKT_HELMET && this != Items_Seasonal.URAKAZEYKT_HELMET &&
				this != Items_Seasonal.OBOROYKT_HELMET && this != Items_Seasonal.HAMAKAZEYKT_HELMET) {
			
			tooltip.add(I18n.format("tips.item_ykt.name", meta));
		}
	}

	/* Items needed for repair. */
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		if (this == Items_Seasonal.YKTO_GETA) {
			int k;
			k = repair.getMetadata();
			if (k == 0) { return repair.getItem() == Item.getItemFromBlock(Blocks.WOODEN_SLAB); }
			if (k != 0) { return false; } }
		
		if (this == Items_Seasonal.YKTD_GETA) {
			int k;
			k = repair.getMetadata();
			if (k == 5) { return repair.getItem() == Item.getItemFromBlock(Blocks.WOODEN_SLAB); }
			if (k != 5) { return false; } }
		
		if (this == Items_Seasonal.IKADUCHIYKT_HELMET || this == Items_Seasonal.INADUMAYKT_HELMET) {
			return repair.getItem() == Items_Seasonal.KAEDE_slabhalf; }
		
		if (this == Items_Seasonal.KAWAKAZEYKT_HELMET || this == Items_Seasonal.URAKAZEYKT_HELMET) {
			int k;
			k = repair.getMetadata();
			if (k == 2) { return repair.getItem() == Item.getItemFromBlock(Blocks.WOODEN_SLAB); }
			if (k != 2) { return false; } }
		
		if (this == Items_Seasonal.OBOROYKT_HELMET) {
			return repair.getItem() == Item.getItemFromBlock(Blocks.YELLOW_FLOWER); }
		
		if (this == Items_Seasonal.HAMAKAZEYKT_HELMET) {
			int k;
			k = repair.getMetadata();
			if (k == 0) { return (repair.getItem() == Item.getItemFromBlock(Blocks.RED_FLOWER)); }
			if (k != 0) { return false; } }
		
		return (repair.getItem() == Items_Seasonal.TANMONO);
	}
}
