package com.ayutaki.chinjufumod.items.addinfo;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Iga_Item extends Item {

	public Iga_Item(Properties properties) {
		super(properties);
	}
 
	/* Used in Furnace. */
	@Override
	public int getBurnTime(ItemStack stack) {
		return 50;
	}
	
	/* ToolTip*/
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.item_rotten_food").applyTextStyle(TextFormatting.GRAY));
	}
}
