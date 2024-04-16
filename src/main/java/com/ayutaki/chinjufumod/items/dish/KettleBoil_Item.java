package com.ayutaki.chinjufumod.items.dish;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.item.ItemStack;

public class KettleBoil_Item extends ItemBlockBace {

	public KettleBoil_Item(String name) {
		super(name, Dish_Blocks.KETTLE_full);
		setUnlocalizedName(name);
		setCreativeTab(ChinjufuModTabs.TEATIME);

		/*クラフトで使うと, 空のやかんが返ってくる*/
		setMaxStackSize(1);
		setContainerItem(Items_Teatime.Item_YAKAN_kara);
	}

	/* 素材として使った時に特定のアイテムを返す */
	@Override
	public boolean hasContainerItem(ItemStack stack) {
		return true;
	}

	@Override
	public ItemStack getContainerItem(ItemStack stack) {
		return new ItemStack(Items_Teatime.Item_YAKAN_kara);
	}

}
