package com.ayutaki.chinjufumod.items.weapon;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class AdmiralStamp extends BlockNamedItem {

	public AdmiralStamp(Block blockIn, Item.Properties properties) {
		super(blockIn, properties);
	}

	@Override
	public boolean hasContainerItem() {
		return true;
	}

	@Override
	@Nullable
	public ItemStack getContainerItem(ItemStack stack) {

		ItemStack copy = stack.copy();
		if (copy.attemptDamageItem(1, random, null)) {
			copy.shrink(1);
			copy.setDamage(0);
		}
	 return copy;
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack material) {
		return false;
	}
	
	/* ToolTip*/
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.item_admiral_stamp").applyTextStyle(TextFormatting.GRAY));
	}
}
