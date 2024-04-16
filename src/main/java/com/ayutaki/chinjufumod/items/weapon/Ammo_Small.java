package com.ayutaki.chinjufumod.items.weapon;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.entity.AmmoEntity_Small;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class Ammo_Small extends Item {

	public Ammo_Small(String name) {
		super();
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);
		setCreativeTab(ChinjufuModTabs.CMARMOR);
	}

	public AmmoEntity_Small createAmmo(World worldIn, ItemStack stack, EntityLivingBase shooter) {
		AmmoEntity_Small entitytippedarrow = new AmmoEntity_Small(worldIn, shooter);
		return entitytippedarrow;
	}

	public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.EntityPlayer playerIn) {
		int enchant = net.minecraft.enchantment.EnchantmentHelper.getEnchantmentLevel(net.minecraft.init.Enchantments.INFINITY, bow);
		return enchant <= 0 ? false : this.getClass() == Ammo_Small.class;
	}
}
/*
ItemArrow から, Entityの呼び出し
Enityは, EntityArrrowを書き換えたBaseを拡張
連装砲で, ItemとEntityを呼び出し
 */