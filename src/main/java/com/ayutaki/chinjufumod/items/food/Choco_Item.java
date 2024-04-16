package com.ayutaki.chinjufumod.items.food;

import com.ayutaki.chinjufumod.ChinjufuMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class Choco_Item extends ItemFood {

	public Choco_Item(String name, int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		/** Have sub items. **/
		setHasSubtypes(true);
		setAlwaysEdible();
	}

	/* Sub item meta and name. */
	public String getUnlocalizedName(ItemStack stack) {

		switch (stack.getMetadata()) {
		case 1:
		default:
			return "item." + "item_food_choco";
		case 2:
			return "item." + "item_food_choco_apple";
		case 3:
			return "item." + "item_food_choco_cherry";
		case 4:
			return "item." + "item_food_choco_grape";
		case 5:
			return "item." + "item_food_choco_greentea";
		case 6:
			return "item." + "item_food_choco_heart";
		}
	}

	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			items.add(new ItemStack(this, 1, 1));
			items.add(new ItemStack(this, 1, 2));
			items.add(new ItemStack(this, 1, 3));
			items.add(new ItemStack(this, 1, 4));
			items.add(new ItemStack(this, 1, 5));
			items.add(new ItemStack(this, 1, 6));
		}
	}

	/* 食べ終わった時の処理 */
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		int i;
		i = stack.getMetadata();

		/** ポーションエフェクト の追加 **/
		/* 1秒＝20 綿菓子は ×50=1000 素材分マイナス */
		if (i == 1) { playerIn.addPotionEffect(new PotionEffect(MobEffects.SPEED, 600, 0)); }

		if (i == 2) { playerIn.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 1000, 0)); }

		if (i == 3) { playerIn.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 1000, 0)); }

		if (i == 4) { playerIn.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 1000, 0)); }

		if (i == 5) { playerIn.addPotionEffect(new PotionEffect(MobEffects.HASTE, 1000, 0)); }

		/* 生成を1個にするため, 効果時間を３倍 */
		if (i == 6) { playerIn.addPotionEffect(new PotionEffect(MobEffects.LUCK, 3000, 0)); }

	}

}
