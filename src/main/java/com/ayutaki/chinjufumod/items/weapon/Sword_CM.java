package com.ayutaki.chinjufumod.items.weapon;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Weapon;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class Sword_CM extends SwordItem {

	public Sword_CM(Tier tier, int attackDamageIn, float attackSpeedIn, Item.Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}
	
	/* BurnTime in a Furnace */
	public int getBurnTime(ItemStack stack, @Nullable RecipeType<?> recipeType) {
		return 200;
	}
	
	@Override
	public void onCraftedBy(ItemStack stack, Level worldIn, Player playerIn) {
		if (this == Items_Weapon.SWORD_sakura.get()) { stack.enchant(Enchantments.FIRE_ASPECT, 2); }
		if (this == Items_Weapon.SWORD_kaede.get()) { stack.enchant(Enchantments.SHARPNESS, 2); }
		if (this == Items_Weapon.SWORD_ichoh.get()) { stack.enchant(Enchantments.BANE_OF_ARTHROPODS, 3); }
		else { }
		super.onCraftedBy(stack, worldIn, playerIn);
	}
	
	@Override
	public boolean isValidRepairItem(ItemStack toRepair, ItemStack material) {
		if (this == Items_Weapon.SWORD_kaede.get()) { return material.getItem() == Items_Seasonal.KAEDE_planks.get(); }
		if (this == Items_Weapon.SWORD_ichoh.get()) { return material.getItem() == Items_Seasonal.ICHOH_planks.get(); }
		return material.getItem() == Items_Seasonal.SAKURA_planks.get();
	}
}
