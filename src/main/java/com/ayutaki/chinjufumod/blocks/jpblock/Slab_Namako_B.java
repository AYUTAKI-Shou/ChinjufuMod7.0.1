package com.ayutaki.chinjufumod.blocks.jpblock;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.AbstractBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Slab_Namako_B extends Base_Slab_JP {

	public Slab_Namako_B(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_namako").withStyle(TextFormatting.GRAY));
	}
}
