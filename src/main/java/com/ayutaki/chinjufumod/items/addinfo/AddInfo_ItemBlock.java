package com.ayutaki.chinjufumod.items.addinfo;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.registry.Items_Seasonal;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class AddInfo_ItemBlock extends ItemNameBlockItem {

	public AddInfo_ItemBlock(Block block, Item.Properties properties) {
		super(block, properties);
	}

	/* ToolTip */
	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag tipFlag) {

		if (this == Items_Seasonal.SNOWCORE.get()) {
			tooltip.add(Component.translatable("tips.block_snowcore").withStyle(ChatFormatting.GRAY)); }
		if (this == Items_Seasonal.SNOWMAN.get()) {
			tooltip.add(Component.translatable("tips.block_snowman").withStyle(ChatFormatting.GRAY)); }
	}
}
