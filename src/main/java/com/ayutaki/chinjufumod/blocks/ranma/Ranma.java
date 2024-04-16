package com.ayutaki.chinjufumod.blocks.ranma;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class Ranma extends BaseRanma {

	public Ranma(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* ToolTip */
	@Override
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.block_ranma").withStyle(ChatFormatting.GRAY));
		tooltip.add(Component.translatable("tips.wp_stage2").withStyle(ChatFormatting.GRAY));
	}
}
