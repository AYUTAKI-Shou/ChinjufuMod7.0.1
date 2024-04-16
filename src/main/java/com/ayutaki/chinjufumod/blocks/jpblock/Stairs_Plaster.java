package com.ayutaki.chinjufumod.blocks.jpblock;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.registry.JP_Blocks;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class Stairs_Plaster extends Base_Stairs_JP {

	public Stairs_Plaster(BlockState state, BlockBehaviour.Properties properties) {
		super(state, properties);
	}

	/* ToolTip */
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		if (this != JP_Blocks.DIRTWALL_stairs.get()) {
			tooltip.add(Component.translatable("tips.block_plaster").withStyle(ChatFormatting.GRAY)); }
	}
}
