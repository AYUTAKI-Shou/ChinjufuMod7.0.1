package com.ayutaki.chinjufumod.items.weapon;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.entity.AbstractAmmo_Kijyuu;
import com.ayutaki.chinjufumod.entity.AmmoEntity_Kijyuu;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class Ammo_Kijyuu extends Item {

	public Ammo_Kijyuu(Item.Properties properties) {
		super(properties);
	}
	
	public AbstractAmmo_Kijyuu createAmmo(Level worldIn, ItemStack stack, LivingEntity shooter) {
		return new AmmoEntity_Kijyuu(worldIn, shooter);
	}

	@SuppressWarnings("deprecation")
	public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.world.entity.player.Player playerIn) {
		int enchant = net.minecraft.world.item.enchantment.EnchantmentHelper.getItemEnchantmentLevel(net.minecraft.world.item.enchantment.Enchantments.INFINITY_ARROWS, bow);
		return enchant <= 0 ? false : this.getClass() == Ammo_Kijyuu.class;
	}
	
	/* ToolTip */
	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.item_ammunition_kijyuu").withStyle(ChatFormatting.GOLD));
	}
}
