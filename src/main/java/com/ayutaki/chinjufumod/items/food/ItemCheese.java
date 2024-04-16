package com.ayutaki.chinjufumod.items.food;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ItemCheese extends ItemFood {

	public ItemCheese(String name, int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		setUnlocalizedName(name);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));

		setCreativeTab(ChinjufuModTabs.TEATIME);

		setAlwaysEdible();
	}

	/* 食べ終わった時の処理 */
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer playerIn) {

		/** ポーションエフェクト の追加 **/
		if (!worldIn.isRemote) {
			/* 1秒＝20 */
			playerIn.addPotionEffect(new PotionEffect(MobEffects.HASTE, 600, 0));
		}
	}

}
