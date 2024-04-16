package com.ayutaki.chinjufumod.items.weapon;

import com.ayutaki.chinjufumod.ItemGroups_CM;
import com.ayutaki.chinjufumod.entity.AbstractAmmo_Entity;
import com.ayutaki.chinjufumod.entity.AmmoEntity_Large;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Ammo_Large extends Item {

	public Ammo_Large(Item.Properties properties) {
		super(properties.tab(ItemGroups_CM.CMARMOR));
	}
	
	public AbstractAmmo_Entity createAmmo(Level worldIn, ItemStack stack, LivingEntity shooter) {
		return new AmmoEntity_Large(worldIn, shooter);
	}

	public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.world.entity.player.Player playerIn) {
		int enchant = net.minecraft.world.item.enchantment.EnchantmentHelper.getItemEnchantmentLevel(net.minecraft.world.item.enchantment.Enchantments.INFINITY_ARROWS, bow);
		return enchant <= 0 ? false : this.getClass() == Ammo_Large.class;
	}
}
