package com.ayutaki.chinjufumod.items.armor;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.ShipTypes_CM;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class Base_Submarine extends Base_ArmorItem {

	static int localCount =20;
	
	public Base_Submarine(ArmorMaterial material, ArmorItem.Type slot, Item.Properties properties) {
		super(material, slot, properties);
	}
	
	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean flag) {
		
		if (entity != null && entity instanceof Player) {
			Player playerIn = (Player)entity;
			
			if (ShipTypes_CM.typeSubmarine(playerIn) && !playerIn.getAbilities().instabuild) {
				if (playerIn.isUnderWater()) {
					if (localCount > 0) {
						if (!(playerIn.hasEffect(MobEffects.WATER_BREATHING))) {
							--localCount;
							playerIn.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 500, 0));
							
							if (localCount > 5) { 
								playerIn.displayClientMessage(Component.translatable("count.amount." + localCount).withStyle(ChatFormatting.AQUA), true); }
							if (localCount >= 2 && localCount <= 5) { 
								playerIn.displayClientMessage(Component.translatable("count.amount." + localCount).withStyle(ChatFormatting.YELLOW), true); }
							if (localCount < 2) { 
								playerIn.displayClientMessage(Component.translatable("count.amount." + localCount).withStyle(ChatFormatting.RED), true); }
						}
						
						else { } }
					
					else { } }
				
				if (!playerIn.isUnderWater() && localCount != 20) {
					localCount = 20;
					playerIn.displayClientMessage(Component.translatable("count.amount." + localCount), true); }
			} //typeSubmarine
			else { }
		}
		else { }
	}
	
	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.item_sabumarine").withStyle(ChatFormatting.GRAY));
		tooltip.add(Component.translatable("tips.item_sabumarine2").withStyle(ChatFormatting.GRAY));
	}
}
