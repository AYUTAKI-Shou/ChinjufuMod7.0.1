package com.ayutaki.chinjufumod.items.teatime;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuModTabs;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DishesClay_Item extends Item {

	public DishesClay_Item() {
		super();
		setCreativeTab(ChinjufuModTabs.TEATIME);
		/** Have sub items. **/
		setHasSubtypes(true);
	}

	/* Sub item meta and name. */
	public String getUnlocalizedName(ItemStack stack) {

		switch (stack.getMetadata()) {
		case 1:
		default:
			return "item." + "item_clay_sara";
		case 2:
			return "item." + "item_clay_yunomi";
		case 3:
			return "item." + "item_clay_kyusu";
		case 4:
			return "item." + "item_clay_teacup";
		case 5:
			return "item." + "item_clay_teapot";
		case 6:
			return "item." + "item_clay_chawan";
		case 7:
			return "item." + "item_clay_nabe";
		case 8:
			return "item." + "item_clay_tonsui";
		case 9:
			return "item." + "item_clay_donburi";
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
			items.add(new ItemStack(this, 1, 7));
			items.add(new ItemStack(this, 1, 8));
			items.add(new ItemStack(this, 1, 9));
		}
	}

	/* ToolTip*/
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		if (stack.getMetadata() == 1) { tooltip.add(I18n.format("tips.item_clay_sara.name")); }
		if (stack.getMetadata() == 2) { tooltip.add(I18n.format("tips.item_clay_yunomi.name")); }
		if (stack.getMetadata() == 3) { tooltip.add(I18n.format("tips.item_clay_kyusu.name")); }
		if (stack.getMetadata() == 4) { tooltip.add(I18n.format("tips.item_clay_teacup.name")); }
		if (stack.getMetadata() == 5) { tooltip.add(I18n.format("tips.item_clay_teapot.name")); }
		if (stack.getMetadata() == 6) { tooltip.add(I18n.format("tips.item_clay_chawan.name")); }
		if (stack.getMetadata() == 7) { tooltip.add(I18n.format("tips.item_clay_nabe.name")); }
		if (stack.getMetadata() == 8) { tooltip.add(I18n.format("tips.item_clay_tonsui.name")); }
		if (stack.getMetadata() == 9) { tooltip.add(I18n.format("tips.item_clay_donburi.name")); }
	}
}
