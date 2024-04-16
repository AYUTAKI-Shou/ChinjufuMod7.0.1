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
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Base_Submarine extends Base_ArmorItem {

	static int localCount =20;
	
	public Base_Submarine(IArmorMaterial material, EquipmentSlotType slot, Properties properties) {
		super(material, slot, properties);
	}

	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entity, int slot, boolean selected) {

		if (entity instanceof PlayerEntity) {
			PlayerEntity playerIn = (PlayerEntity)entity;

			if (ShipTypes_CM.typeSubmarine(playerIn) && !playerIn.abilities.instabuild) {
				
				if (playerIn.isUnderWater()) {
					if (localCount > 0) {
						if (!(playerIn.hasEffect(Effects.WATER_BREATHING))) {
							--localCount;
							playerIn.addEffect(new EffectInstance(Effects.WATER_BREATHING, 500, 0)); 
							
							if (localCount > 5) { 
								playerIn.displayClientMessage(new TranslationTextComponent("count.amount." + localCount).withStyle(TextFormatting.AQUA), true); }
							if (localCount >= 2 && localCount <= 5) { 
								playerIn.displayClientMessage(new TranslationTextComponent("count.amount." + localCount).withStyle(TextFormatting.YELLOW), true); }
							if (localCount < 2) { 
								playerIn.displayClientMessage(new TranslationTextComponent("count.amount." + localCount).withStyle(TextFormatting.RED), true); }
						}
					
						else { } }

					else { } }
				
				if (!playerIn.isUnderWater() && localCount != 20) {
					localCount = 20; 
					playerIn.displayClientMessage(new TranslationTextComponent("count.amount." + localCount), true); }
			} //typeSubmarine

			else { }
		}
		else { }
	}

	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.item_sabumarine").withStyle(TextFormatting.GRAY));
		tooltip.add(new TranslationTextComponent("tips.item_sabumarine2").withStyle(TextFormatting.GRAY));
	}
}
