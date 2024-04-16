package com.ayutaki.chinjufumod;

import com.ayutaki.chinjufumod.registry.Items_Armor;
import com.ayutaki.chinjufumod.registry.Items_Chinjufu;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Items_Wablock;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.WallPane_Blocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ChinjufuModTabs {

	/*KONGOU*/
	public static final CreativeTabs CHINJUFU = new CreativeTabs("tab_chinjufumod") {
		@Override
		public ItemStack getTabIconItem() { return new ItemStack(Items_Chinjufu.EMBLEM_C);
		}
	};

	/*KONGOU*/
	public static final CreativeTabs TEATIME = new CreativeTabs("tab_teatime") {
		@Override
		public ItemStack getTabIconItem() { return new ItemStack(Items_Teatime.TEACUP);
		}
	};

	/*KONGOU*/
	public static final CreativeTabs SEASONAL = new CreativeTabs("tab_seasonal") {
		@Override
		public ItemStack getTabIconItem() { return new ItemStack(Items_Seasonal.HAMAKAZEYKT_CHESTPLATE); }
	};

	/*KONGOU*/
	public static final CreativeTabs CMARMOR = new CreativeTabs("tab_cmarmor") {
		@Override
		public ItemStack getTabIconItem() { return new ItemStack(Items_Armor.FUBUKI_CHESTPLATE); }
	};

	/*FUSOU*/
	public static final CreativeTabs WADECO = new CreativeTabs("tab_cmodwadeco") {
		@Override
		public ItemStack getTabIconItem() { return new ItemStack(Items_Wadeco.FUSUMAB_item, 1, 9); }
	};

	/*FUSOU*/
	public static final CreativeTabs WABLOCK = new CreativeTabs("tab_cmodwablock") {
		@Override
		public ItemStack getTabIconItem() { return new ItemStack(Items_Wablock.KAWARA, 1, 7); }
	};

	/*FUSOU*/
	public static final CreativeTabs WALLPANEL = new CreativeTabs("tab_wallpanel") {
		@Override
		public ItemStack getTabIconItem() { return new ItemStack(Item.getItemFromBlock(WallPane_Blocks.WP_STONE_graB)); }
	};
}
