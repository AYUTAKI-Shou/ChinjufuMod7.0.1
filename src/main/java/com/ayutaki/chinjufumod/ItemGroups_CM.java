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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemGroups_CM {

	public static final ItemGroup CHINJUFU = new ItemGroup(ItemGroup.TABS.length, "chinjufumod.tab_chinjufumod") {
		@OnlyIn(Dist.CLIENT)
		public ItemStack makeIcon() { return new ItemStack(Items_NoTab.EMBLEM_C); }
	};

	public static final ItemGroup TEATIME = new ItemGroup(ItemGroup.TABS.length, "chinjufumod.tab_teatime") {
		@OnlyIn(Dist.CLIENT)
		public ItemStack makeIcon() { return new ItemStack(Items_Teatime.TEACUP); }
	};

	public static final ItemGroup SEASONAL = new ItemGroup(ItemGroup.TABS.length, "chinjufumod.tab_seasonal") {
		@OnlyIn(Dist.CLIENT)
		public ItemStack makeIcon() { return new ItemStack(Items_Seasonal.HAMAKAZEYKT_CHESTPLATE); }
	};

	public static final ItemGroup CMARMOR = new ItemGroup(ItemGroup.TABS.length, "chinjufumod.tab_cmarmor") {
		@OnlyIn(Dist.CLIENT)
		public ItemStack makeIcon() { return new ItemStack(Items_Armor.FUBUKI_CHESTPLATE); }
	};

	public static final ItemGroup WADECO = new ItemGroup(ItemGroup.TABS.length, "chinjufumod.tab_cmodwadeco") {
		@OnlyIn(Dist.CLIENT)
		public ItemStack makeIcon() { return new ItemStack(Items_Wadeco.FUSUMAB_cyan); }
	};

	public static final ItemGroup WABLOCK = new ItemGroup(ItemGroup.TABS.length, "chinjufumod.tab_cmodwablock") {
		@OnlyIn(Dist.CLIENT)
		public ItemStack makeIcon() { return new ItemStack(Items_Wablock.KAWARA_gray); }
	};

	public static final ItemGroup WALLPANEL = new ItemGroup(ItemGroup.TABS.length, "chinjufumod.tab_wallpanel") {
		@OnlyIn(Dist.CLIENT)
		public ItemStack makeIcon() { return new ItemStack(Items_WallPanel.WP_STONE_graB); }
	};
}
