package com.ayutaki.chinjufumod.items.weapon;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ItemGroups_CM;
import com.ayutaki.chinjufumod.entity.AbstractAmmo_Kijyuu;
import com.ayutaki.chinjufumod.entity.AmmoEntity_Kijyuu;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Ammo_Kijyuu extends Item {

	public Ammo_Kijyuu(Item.Properties properties) {
		super(properties.tab(ItemGroups_CM.CMARMOR));
	}

	public AbstractAmmo_Kijyuu createAmmo(World worldIn, ItemStack stack, LivingEntity shooter) {
		return new AmmoEntity_Kijyuu(worldIn, shooter);
	}

	public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.PlayerEntity playerIn) {
		int enchant = net.minecraft.enchantment.EnchantmentHelper.getItemEnchantmentLevel(net.minecraft.enchantment.Enchantments.INFINITY_ARROWS, bow);
		return enchant <= 0 ? false : this.getClass() == Ammo_Kijyuu.class;
	}
	
	
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.item_ammunition_kijyuu").withStyle(TextFormatting.GOLD));
	}
}
