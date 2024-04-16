package com.ayutaki.chinjufumod.items.color;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ItemGroups_CM;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Base_ItemHake extends Item {

	public Base_ItemHake(Properties properties) {
		super(properties.durability(128).tab(ItemGroups_CM.WADECO));
	} //127

	@Override
	public boolean isRepairable(ItemStack stack) {
		return false;
	}
	
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.item_hake_color").withStyle(TextFormatting.GRAY));
	}
}
/*
public Item.Properties durability(int maxDamage) {
	this.maxDamage = maxDamage;
	this.maxStackSize = 1;
	return this;
}
*/
