package com.ayutaki.chinjufumod.items.weapon;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class AdmiralStamp extends ItemNameBlockItem {

	public AdmiralStamp(Block blockIn, Item.Properties properties) {
		super(blockIn, properties);
	}
	
	/* from IForgeItem */
	@Override
	public boolean hasCraftingRemainingItem(ItemStack stack) {
		return true;
	}
	
	@Override
	@Nullable
	public ItemStack getCraftingRemainingItem(ItemStack itemStack) {

		ItemStack copy = itemStack.copy();
		if (itemStack.isDamageableItem()) {
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
	
	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.item_admiral_stamp").withStyle(ChatFormatting.GRAY));
	}
}
