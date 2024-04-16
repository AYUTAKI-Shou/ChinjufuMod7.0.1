package com.ayutaki.chinjufumod.items.armor;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.handler.ShipTypes_CM;

import net.minecraft.block.material.Material;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Base_Submarine extends Base_ArmorItem {

	static int localCount = 20;
	
	public Base_Submarine(String name, ArmorMaterial a_material, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(a_material, renderIndexIn, equipmentSlotIn);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);
	}

	@Override
	public void onArmorTick(World worldIn, EntityPlayer playerIn, ItemStack armor) {

		if (ShipTypes_CM.typeSubmarine(playerIn) && !playerIn.capabilities.isCreativeMode) {
			
			if (playerIn.isInsideOfMaterial(Material.WATER)) {
				if (localCount > 0) {
					if (!(playerIn.isPotionActive(MobEffects.WATER_BREATHING))) {
						--localCount;
						playerIn.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 500, 0)); 
						
						if (localCount > 5) { 
							playerIn.sendStatusMessage(new TextComponentTranslation("count.amount." + localCount).setStyle(new Style().setColor(TextFormatting.AQUA)), true); }
						if (localCount >= 2 && localCount <= 5) { 
							playerIn.sendStatusMessage(new TextComponentTranslation("count.amount." + localCount).setStyle(new Style().setColor(TextFormatting.YELLOW)), true); }
						if (localCount < 2) { 
							playerIn.sendStatusMessage(new TextComponentTranslation("count.amount." + localCount).setStyle(new Style().setColor(TextFormatting.RED)), true); }
					}
				
					else { }
				}
				
				else { } }
			
			if (!playerIn.isInsideOfMaterial(Material.WATER) && localCount != 20) {
				localCount = 20; 
				playerIn.sendStatusMessage(new TextComponentTranslation("count.amount." + localCount), true); }
		} //typeSubmarine
		
		else { }
	}

	/* Items needed for repair. */
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return (repair.getItem() == Items.IRON_INGOT);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		tooltip.add(I18n.format("tips.item_sabumarine.name"));
		tooltip.add(I18n.format("tips.item_sabumarine2.name"));
	}
}
