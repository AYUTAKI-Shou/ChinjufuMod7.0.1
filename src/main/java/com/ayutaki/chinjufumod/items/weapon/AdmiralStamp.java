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
	public boolean hasContainerItem(ItemStack stack) {
		return true;
	}

	@Override
	@Nullable
	public ItemStack getContainerItem(ItemStack stack) {

		ItemStack copy = stack.copy();
		if (stack.isDamageableItem()) {
			copy.setDamageValue(copy.getDamageValue() + 1);
			int damage = copy.getMaxDamage() - copy.getDamageValue();
			if(damage <= 0) { return ItemStack.EMPTY; }
		}
		return copy;
	}

	@Override
	public boolean isRepairable(ItemStack stack) {
		return false;
	}
		
	/* ToolTip ...Item.class 222(1.16.5) */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.item_admiral_stamp").withStyle(TextFormatting.GRAY));
	}

}
/*
決裁印はチェストからの回収とする
・ボーナスチェストは進捗判定にしない Bアイテム
・海図チェストは確定で 1個
・宝チェストは 0-1個(1は回収した印を保管して沈んだ船)
・前哨基地および森の洋館は 0-2個(印を使っている集団と使っていない集団が混在)

工廠指示書はゾンビからのドロップとする
村の鍛冶屋で 0-3枚(1-3枚は取引があった鍛冶屋)
*/