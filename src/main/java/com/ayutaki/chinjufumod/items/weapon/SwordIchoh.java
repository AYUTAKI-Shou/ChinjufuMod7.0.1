package com.ayutaki.chinjufumod.items.weapon;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Weapon;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class SwordIchoh extends ItemSword {

	@SuppressWarnings("unused")
	private final float attackDamage;
	@SuppressWarnings("unused")
	private final Item.ToolMaterial material;

	public SwordIchoh(String name, ToolMaterial material) {
		super(material);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);
		setCreativeTab(ChinjufuModTabs.CMARMOR);
		
		/** WOOD(0, 59, 2.0F, 0.0F, 15), **/
		this.material = material;
		this.maxStackSize = 1;
		setMaxDamage(59);
		this.attackDamage = 3.0F + 0.0F;
	}

	/* レシピから作った際, ブーツにエンチャント付与するパターン
	 * 1.11以降はNBTTagCompoundが不要か？ */
	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer entity) {
		super.onCreated(stack, worldIn, entity);

		if (this == Items_Weapon.SWORD_ichoh) {
			stack.addEnchantment(Enchantments.BANE_OF_ARTHROPODS, 3);
		}

		else { }
	}

	/* Items needed for repair. */
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return (repair.getItem() == Items_Seasonal.PLANKS_ichoh);
	}
}
