package com.ayutaki.chinjufumod.items.teatime;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RamenNama_Item extends Item {

	public RamenNama_Item(String name) {
		super();
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
			return "item." + "item_food_ramen_n";
		case 1:
			return "item." + "item_food_tare_shouyu";
		case 2:
			return "item." + "item_food_tare_miso";
		case 3:
			return "item." + "item_food_tare_shio";
		case 4:
			return "item." + "item_food_rsoup_shouyu";
		case 5:
			return "item." + "item_food_rsoup_miso";
		case 6:
			return "item." + "item_food_rsoup_shio";
		case 7:
			return "item." + "item_food_sobaplate";
		}
	}

	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			items.add(new ItemStack(this, 1, 0));
			items.add(new ItemStack(this, 1, 1));
			items.add(new ItemStack(this, 1, 2));
			items.add(new ItemStack(this, 1, 3));
			items.add(new ItemStack(this, 1, 4));
			items.add(new ItemStack(this, 1, 5));
			items.add(new ItemStack(this, 1, 6));
			items.add(new ItemStack(this, 1, 7));
		}
	}

	/* ToolTip*/
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		if (meta == 1 || meta == 2 || meta == 3) { tooltip.add(I18n.format("tips.item_food_tare.name", meta)); }
		if (meta == 4 || meta == 5 || meta == 6) { tooltip.add(I18n.format("tips.item_food_rsoup.name", meta)); }
		if (meta == 7) { tooltip.add(I18n.format("tips.item_food_sobaplate.name", meta)); }
	}
}
