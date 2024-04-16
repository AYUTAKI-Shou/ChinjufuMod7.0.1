package com.ayutaki.chinjufumod.items.armor;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.ShipTypes_CM;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Base_Submarine extends Base_ArmorItem {

	/* 65/3kt=21 max8kt 6, 60/3kt=20 max5.5kt, 64/4kt=16 max7.7kt -> 20h 1h=1000tick Cut performance in half. */
	static int localCount =20;
	
	public Base_Submarine(IArmorMaterial material, EquipmentSlotType slot, Properties properties) {
		super(material, slot, properties);
	}

	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entity, int slot, boolean selected) {

		if (entity instanceof PlayerEntity) {
			PlayerEntity playerIn = (PlayerEntity)entity;

			if (ShipTypes_CM.typeSubmarine(playerIn) && !playerIn.abilities.isCreativeMode) {

				if (playerIn.areEyesInFluid(FluidTags.WATER, true)) {
					if (localCount > 0) {
						if (!(playerIn.isPotionActive(Effects.WATER_BREATHING))) {
							--localCount;
							playerIn.addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, 500, 0)); 
							
							if (localCount > 5) { 
								playerIn.sendStatusMessage(new TranslationTextComponent("count.amount." + localCount).applyTextStyle(TextFormatting.AQUA), true); }
							if (localCount >= 2 && localCount <= 5) { 
								playerIn.sendStatusMessage(new TranslationTextComponent("count.amount." + localCount).applyTextStyle(TextFormatting.YELLOW), true); }
							if (localCount < 2) { 
								playerIn.sendStatusMessage(new TranslationTextComponent("count.amount." + localCount).applyTextStyle(TextFormatting.RED), true); }
						}
					
						else { } }

					else { } }
				
				if (!playerIn.areEyesInFluid(FluidTags.WATER, true) && localCount != 20) {
					localCount = 20; 
					playerIn.sendStatusMessage(new TranslationTextComponent("count.amount." + localCount), true); }
			} //typeSubmarine

			else { }
		}
		else { }
	}
	
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.item_sabumarine").applyTextStyle(TextFormatting.GRAY));
		tooltip.add(new TranslationTextComponent("tips.item_sabumarine2").applyTextStyle(TextFormatting.GRAY));
	}
}
