package com.ayutaki.chinjufumod.items.food;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ItemPizza extends ItemFood {

	public ItemPizza(String name, int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		setUnlocalizedName(name);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));

		setCreativeTab(ChinjufuModTabs.TEATIME);

		setAlwaysEdible();
		/** Have sub items. **/
		setHasSubtypes(true);
	}

	/* Sub item meta and name. */
	public String getUnlocalizedName(ItemStack stack) {
		switch (stack.getMetadata()) {
		case 0:
		default:
			return "item." + "item_food_pizza";
		case 1:
			return "item." + "item_food_pizzac";
		case 2:
			return "item." + "item_food_pizzat";
		case 3:
			return "item." + "item_food_pizzas";
		}
	}

	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			items.add(new ItemStack(this, 1, 0));
			items.add(new ItemStack(this, 1, 1));
			items.add(new ItemStack(this, 1, 2));
			items.add(new ItemStack(this, 1, 3));
		}
	}
	
	/* 食べ終わった時の処理 */
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		int k;
		k = stack.getMetadata();
		
		/** ポーションエフェクト の追加 **/
		if (!worldIn.isRemote) {
			if (k == 1 || k == 2) {
				/* 1秒＝20 */
				playerIn.addPotionEffect(new PotionEffect(MobEffects.HASTE, 1200, 0));
				playerIn.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 60, 1)); }
			
			if (k != 1 && k != 2) {
				playerIn.addPotionEffect(new PotionEffect(MobEffects.HASTE, 1400, 0));
				playerIn.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 70, 1)); }
		}
	}
}
