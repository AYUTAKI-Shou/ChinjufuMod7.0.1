package com.ayutaki.chinjufumod.items.dish;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ItemGroups_CM;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/* MilkBucketItem を参照。extends は BlockNamedItem とする */
public class Dish_Donburi extends BlockNamedItem {

	public Dish_Donburi(Block block, Item.Properties properties) {
		super(block, properties.group(ItemGroups_CM.TEATIME));
	}

	/* Finish RightClick Action */
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {

		PlayerEntity playerIn = entityLiving instanceof PlayerEntity ? (PlayerEntity)entityLiving : null;

		/** add Potion Effect **/
		if (this == Items_Teatime.UDON_SU) {
			entityLiving.addPotionEffect(new EffectInstance(Effects.SATURATION, 5, 0)); }

		if (this == Items_Teatime.UDON_NIKU || this == Items_Teatime.UDON_TSUKIMI) {
			entityLiving.addPotionEffect(new EffectInstance(Effects.SATURATION, 10, 0));
			entityLiving.addPotionEffect(new EffectInstance(Effects.HASTE, 3000, 0));
			entityLiving.addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, 1, 0));
			entityLiving.addPotionEffect(new EffectInstance(Effects.REGENERATION, 3000, 0)); }

		if (this == Items_Teatime.DONBURI_MESHI) {
			entityLiving.addPotionEffect(new EffectInstance(Effects.SATURATION, 5, 0)); }

		if (this == Items_Teatime.DONBURI_GYU || this == Items_Teatime.DONBURI_OYAKO || this == Items_Teatime.DONBURI_KAISEN) {
			entityLiving.addPotionEffect(new EffectInstance(Effects.SATURATION, 10, 0));
			entityLiving.addPotionEffect(new EffectInstance(Effects.HASTE, 3000, 0));
			entityLiving.addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, 1, 0));
			entityLiving.addPotionEffect(new EffectInstance(Effects.REGENERATION, 3000, 0)); }

		if (this == Items_Teatime.DONBURI_KATSU || this == Items_Teatime.RAMEN_SHOUYU || 
				this == Items_Teatime.RAMEN_MISO || this == Items_Teatime.RAMEN_SHIO) {
			entityLiving.addPotionEffect(new EffectInstance(Effects.SATURATION, 10, 0));
			entityLiving.addPotionEffect(new EffectInstance(Effects.HASTE, 3500, 0));
			entityLiving.addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, 1, 0));
			entityLiving.addPotionEffect(new EffectInstance(Effects.REGENERATION, 3500, 0)); }
		
		
		/** add Item **/
		if (playerIn != null) {
			playerIn.addStat(Stats.ITEM_USED.get(this));

			if (!playerIn.abilities.isCreativeMode) {
				if (stack.isEmpty()) { return new ItemStack(Items_Teatime.DONBURI); }
				else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.DONBURI))) { playerIn.dropItem(new ItemStack(Items_Teatime.DONBURI), false); }
				
				stack.shrink(1);
			}
		}
		return stack;
	}

	public int getUseDuration(ItemStack stack) {
		return 32;
	}

	public UseAction getUseAction(ItemStack stack) {
		return UseAction.EAT;
	}

	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand hand) {

		/** 食物が必要な時だけ成功 **/
		if (playerIn.getFoodStats().needFood() == true) {
			playerIn.setActiveHand(hand);
			return ActionResult.resultSuccess(playerIn.getHeldItem(hand));
		}

		return ActionResult.resultFail(playerIn.getHeldItem(hand));
	}

	/* 設置処理の分岐 スニーク時 playerIn.isSneaking() 座っている時 playerIn.isPassenger() */
	public ActionResultType onItemUse(ItemUseContext context) {
		PlayerEntity playerIn = context.getPlayer();

		if (context.getFace() == Direction.UP && (playerIn.isSneaking() || playerIn.isPassenger()) ) {
			return this.tryPlace(new BlockItemUseContext(context)); }

		else {
			return this.onItemRightClick(context.getWorld(), context.getPlayer(), context.getHand()).getType(); }
	}

	/* ToolTip*/
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_simpledish").applyTextStyle(TextFormatting.GRAY));
		if (this == Items_Teatime.DONBURI_GYU) {
			tooltip.add(new TranslationTextComponent("tips.block_food_dongyu_1").applyTextStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.DONBURI_KATSU) {
			tooltip.add(new TranslationTextComponent("tips.block_food_donkatsu_1").applyTextStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.DONBURI_OYAKO) {
			tooltip.add(new TranslationTextComponent("tips.block_food_donoyako_1").applyTextStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.DONBURI_KAISEN) {
			tooltip.add(new TranslationTextComponent("tips.block_food_donkaisen_1").applyTextStyle(TextFormatting.GRAY)); }
	}
}
