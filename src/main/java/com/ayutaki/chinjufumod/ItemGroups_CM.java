package com.ayutaki.chinjufumod;

import com.ayutaki.chinjufumod.registry.Items_Armor;
import com.ayutaki.chinjufumod.registry.Items_NoTab;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Items_Wablock;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.Items_WallPanel;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ItemGroups_CM {

	public static final ItemGroup CHINJUFU = new ItemGroup(ItemGroup.GROUPS.length, "chinjufumod.tab_chinjufumod") {
		@Override
		public ItemStack createIcon() { return new ItemStack(Items_NoTab.EMBLEM_C); }
	};

	public static final ItemGroup TEATIME = new ItemGroup(ItemGroup.GROUPS.length, "chinjufumod.tab_teatime") {
		@Override
		public ItemStack createIcon() { return new ItemStack(Items_Teatime.TEACUP); }
	};

	public static final ItemGroup SEASONAL = new ItemGroup(ItemGroup.GROUPS.length, "chinjufumod.tab_seasonal") {
		@Override
		public ItemStack createIcon() { return new ItemStack(Items_Seasonal.HAMAKAZEYKT_CHESTPLATE); }
	};

	public static final ItemGroup CMARMOR = new ItemGroup(ItemGroup.GROUPS.length, "chinjufumod.tab_cmarmor") {
		@Override
		public ItemStack createIcon() { return new ItemStack(Items_Armor.FUBUKI_CHESTPLATE); }
	};

	public static final ItemGroup WADECO = new ItemGroup(ItemGroup.GROUPS.length, "chinjufumod.tab_cmodwadeco") {
		@Override
		public ItemStack createIcon() { return new ItemStack(Items_Wadeco.FUSUMAB_cyan); }
	};

	public static final ItemGroup WABLOCK = new ItemGroup(ItemGroup.GROUPS.length, "chinjufumod.tab_cmodwablock") {
		@Override
		public ItemStack createIcon() { return new ItemStack(Items_Wablock.KAWARA_gray); }
	};

	public static final ItemGroup WALLPANEL = new ItemGroup(ItemGroup.GROUPS.length, "chinjufumod.tab_wallpanel") {
		@Override
		public ItemStack createIcon() { return new ItemStack(Items_WallPanel.WP_STONE_graB); }
	};
}
