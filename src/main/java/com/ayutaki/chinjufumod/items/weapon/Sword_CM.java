package com.ayutaki.chinjufumod.items.weapon;

import com.ayutaki.chinjufumod.ItemGroups_CM;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Weapon;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.world.World;

public class Sword_CM extends SwordItem {

	public Sword_CM(IItemTier tier, int attackDamageIn, float attackSpeedIn, Item.Properties properties) {
		super(tier, attackDamageIn, attackSpeedIn, properties.tab(ItemGroups_CM.CMARMOR));
	}

	/* BurnTime in a Furnace */
	@Override
	public int getBurnTime(ItemStack stack) {
		return 200;
	}

	/* クラフト時にエンチャント付与 */
	@Override
	public void onCraftedBy(ItemStack stack, World worldIn, PlayerEntity playerIn) {
		super.onCraftedBy(stack, worldIn, playerIn);

		if (this == Items_Weapon.SWORD_sakura) { stack.enchant(Enchantments.FIRE_ASPECT, 2); }
		if (this == Items_Weapon.SWORD_kaede) { stack.enchant(Enchantments.SHARPNESS, 2); }
		if (this == Items_Weapon.SWORD_ichoh) { stack.enchant(Enchantments.BANE_OF_ARTHROPODS, 3); }
		else { }
	}

	/* Items needed for repair. */
	@Override
	public boolean isValidRepairItem(ItemStack toRepair, ItemStack material) {

		if (this == Items_Weapon.SWORD_kaede) { return material.getItem() == Items_Seasonal.KAEDE_planks; }
		if (this == Items_Weapon.SWORD_ichoh) { return material.getItem() == Items_Seasonal.ICHOH_planks; }
		return material.getItem() == Items_Seasonal.SAKURA_planks;
	}
}
