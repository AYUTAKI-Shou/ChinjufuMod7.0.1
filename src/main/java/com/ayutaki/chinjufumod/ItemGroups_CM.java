package com.ayutaki.chinjufumod;

import com.ayutaki.chinjufumod.registry.Items_Armor;
import com.ayutaki.chinjufumod.registry.Items_NoTab;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Items_Wablock;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.Items_WallPanel;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ItemGroups_CM {

	public static final CreativeModeTab CHINJUFU = new CreativeModeTab(CreativeModeTab.TABS.length, "chinjufumod.tab_chinjufumod") {
		public ItemStack makeIcon() { return new ItemStack(Items_NoTab.EMBLEM_C.get()); }
	};
	
	public static final CreativeModeTab TEATIME = new CreativeModeTab(CreativeModeTab.TABS.length, "chinjufumod.tab_teatime") {
		public ItemStack makeIcon() { return new ItemStack(Items_Teatime.TEACUP.get()); }
	};

	public static final CreativeModeTab SEASONAL = new CreativeModeTab(CreativeModeTab.TABS.length, "chinjufumod.tab_seasonal") {
		public ItemStack makeIcon() { return new ItemStack(Items_Seasonal.HAMAKAZEYKT_CHESTPLATE.get()); }
	};

	public static final CreativeModeTab CMARMOR = new CreativeModeTab(CreativeModeTab.TABS.length, "chinjufumod.tab_cmarmor") {
		public ItemStack makeIcon() { return new ItemStack(Items_Armor.FUBUKI_CHESTPLATE.get()); }
	};

	public static final CreativeModeTab WADECO = new CreativeModeTab(CreativeModeTab.TABS.length, "chinjufumod.tab_cmodwadeco") {
		public ItemStack makeIcon() { return new ItemStack(Items_Wadeco.FUSUMAB_cyan.get()); }
	};

	public static final CreativeModeTab WABLOCK = new CreativeModeTab(CreativeModeTab.TABS.length, "chinjufumod.tab_cmodwablock") {
		public ItemStack makeIcon() { return new ItemStack(Items_Wablock.KAWARA_gray.get()); }
	};

	public static final CreativeModeTab WALLPANEL = new CreativeModeTab(CreativeModeTab.TABS.length, "chinjufumod.tab_wallpanel") {
		public ItemStack makeIcon() { return new ItemStack(Items_WallPanel.WP_STONE_graB.get()); }
	};
}
