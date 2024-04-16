package com.ayutaki.chinjufumod.items.hakkou;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.registry.Items_NoTab;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class HakkouItem_Tips extends ItemNameBlockItem {

	public HakkouItem_Tips(Block block, Item.Properties properties) {
		super(block, properties);
	}
	
	/* ToolTip */
	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		if (this == Items_Teatime.SHOUYU_bot_1.get() || this == Items_Teatime.DASHI_bot_1.get() ||
				this == Items_Teatime.MAYO_bot_1.get() || this == Items_Teatime.OSAUCE_bot_1.get()) {
			tooltip.add(Component.translatable("tips.block_bot").withStyle(ChatFormatting.GRAY)); }

		if (this == Items_NoTab.SHOUYU_bot_2.get() || this == Items_NoTab.DASHI_bot_2.get() ||
				this == Items_NoTab.MAYO_bot_2.get() || this == Items_NoTab.OSAUCE_bot_2.get()) {
			tooltip.add(Component.translatable("tips.block_bot_2").withStyle(ChatFormatting.GRAY)); }

		if (this == Items_NoTab.SHOUYU_bot_3.get() || this == Items_NoTab.DASHI_bot_3.get() || this == Items_Teatime.KOMEZU_bot_1.get() ||
				this == Items_NoTab.MAYO_bot_3.get() || this == Items_NoTab.OSAUCE_bot_3.get()) {
			tooltip.add(Component.translatable("tips.block_bot_3").withStyle(ChatFormatting.GRAY)); }

		if (this == Items_NoTab.SHOUYU_bot_4.get() || this == Items_NoTab.DASHI_bot_4.get() || this == Items_NoTab.KOMEZU_bot_2.get() ||
				this == Items_NoTab.MAYO_bot_4.get() || this == Items_NoTab.OSAUCE_bot_4.get()) {
			tooltip.add(Component.translatable("tips.block_bot_4").withStyle(ChatFormatting.GRAY)); }
		
		if (this == Items_Teatime.OSAUCE_bot_1.get() || this == Items_NoTab.OSAUCE_bot_2.get() || 
				this == Items_NoTab.OSAUCE_bot_3.get() || this == Items_NoTab.OSAUCE_bot_4.get()) {
			tooltip.add(Component.translatable("tips.block_osauce_bot").withStyle(ChatFormatting.GRAY)); }
	}
}
