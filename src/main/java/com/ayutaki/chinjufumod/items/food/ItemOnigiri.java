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

public class ItemOnigiri extends ItemFood {

	public ItemOnigiri(String name, int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));

		setCreativeTab(ChinjufuModTabs.TEATIME);
		/** Have sub items. **/
		setHasSubtypes(true);
	}

	/* Sub item meta and name. */
	public String getUnlocalizedName(ItemStack stack) {

		switch (stack.getMetadata()) {
		case 0:
		default:
			return "item." + "item_food_onigiri";
		case 1:
			return "item." + "item_food_onigirishake";
		case 2:
			return "item." + "item_food_futomaki";
		case 3:
			return "item." + "item_food_onigiritakenoko";
		case 4:
			return "item." + "item_food_onigirikuri";
		}
	}

	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			items.add(new ItemStack(this, 1, 0));
			items.add(new ItemStack(this, 1, 1));
			items.add(new ItemStack(this, 1, 3));
			items.add(new ItemStack(this, 1, 4));
			items.add(new ItemStack(this, 1, 2));
		}
	}

	/* 食べ終わった時の処理 */
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		int i;
		i = stack.getMetadata();

		/** ポーションエフェクト の追加 **/
		/* 1秒＝20 */
		if (i == 1) { playerIn.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 60, 0)); }
		if (i == 2) { playerIn.addPotionEffect(new PotionEffect(MobEffects.HASTE, 1200, 0)); }
		if (i == 3 || i == 4) { playerIn.addPotionEffect(new PotionEffect(MobEffects.HASTE, 200, 0)); }
		else { }
	}
}
