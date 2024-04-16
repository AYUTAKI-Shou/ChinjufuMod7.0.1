package com.ayutaki.chinjufumod.items.dish;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class Dish_Plate extends ItemNameBlockItem {

	public Dish_Plate(Block block, Item.Properties properties) {
		super(block, properties);
	}

	public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
		Player playerIn = entityLiving instanceof Player ? (Player)entityLiving : null;
		
		/** add Potion Effect **/
		if (this == Items_Teatime.STEW.get()) {
			/** ポーションエフェクトの追加 一口100 通常 120 **/
			entityLiving.addEffect(new MobEffectInstance(MobEffects.SATURATION, 8, 0));
			entityLiving.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 3000, 0));
			entityLiving.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 0));
			entityLiving.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 3000, 0)); }

		if (this == Items_Teatime.RICE.get()) {
			entityLiving.addEffect(new MobEffectInstance(MobEffects.SATURATION, 3, 0)); }

		if (this == Items_Teatime.CORNSOUP.get()) {
			entityLiving.addEffect(new MobEffectInstance(MobEffects.SATURATION, 2, 0));
			entityLiving.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 2000, 0)); }

		if (this == Items_Teatime.HAKUSAIDUKE.get()) {
			entityLiving.addEffect(new MobEffectInstance(MobEffects.SATURATION, 1, 0));
			entityLiving.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 500, 0)); }

		if (this == Items_Teatime.TAMAGOYAKI.get() || this == Items_Teatime.CHICKEN_small.get()) {
			entityLiving.addEffect(new MobEffectInstance(MobEffects.SATURATION, 3, 0));
			entityLiving.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0)); }

		if (this == Items_Teatime.EGGBURG.get()) {
			entityLiving.addEffect(new MobEffectInstance(MobEffects.SATURATION, 5, 0));
			entityLiving.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 300, 0)); }

		if (this == Items_Teatime.PASTATOMATO.get() || this == Items_Teatime.PASTACHEESE.get() || this == Items_Teatime.PASTAKINOKO.get() || 
				this == Items_Teatime.OKONOMIYAKI.get() || this == Items_Teatime.OKONOMIS.get() || 
				this == Items_Teatime.YAKISOBA.get() || this == Items_Teatime.YAKISOBASHIO.get()) {
			entityLiving.addEffect(new MobEffectInstance(MobEffects.SATURATION, 10, 0));
			entityLiving.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 3000, 0));
			entityLiving.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 0));
			entityLiving.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 3000, 0)); }

		if (this == Items_Teatime.OKONOMIC.get()) {
			entityLiving.addEffect(new MobEffectInstance(MobEffects.SATURATION, 8, 0));
			entityLiving.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 2400, 0));
			entityLiving.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 0));
			entityLiving.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 2400, 0)); }
		
		if (this == Items_Teatime.OKONOMISOBAC.get()) {
			entityLiving.addEffect(new MobEffectInstance(MobEffects.SATURATION, 10, 0));
			entityLiving.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 2400, 0));
			entityLiving.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 0));
			entityLiving.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 2400, 0)); }
		
		if (this == Items_Teatime.OKONOMISOBA.get() || this == Items_Teatime.OKONOMISOBAS.get()) {
			entityLiving.addEffect(new MobEffectInstance(MobEffects.SATURATION, 12, 0));
			entityLiving.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 3000, 0));
			entityLiving.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 0));
			entityLiving.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 3000, 0)); }
		
		/** add Item **/
		if (playerIn != null) {
			playerIn.awardStat(Stats.ITEM_USED.get(this));

			if (!playerIn.getAbilities().instabuild) {
				if (stack.isEmpty()) { return new ItemStack(Items_Teatime.SARA.get()); }
				else if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.SARA.get()))) { playerIn.drop(new ItemStack(Items_Teatime.SARA.get()), false); }

				stack.shrink(1);
			}
		}
		return stack;
	}
	
	@Override
	public int getUseDuration(ItemStack stack) {
		return 32;
	}
	
	@Override
	public UseAnim getUseAnimation(ItemStack stack) {
		return UseAnim.EAT;
	}
	
	 public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand hand) {
			/** It works only when you're hungry. **/
			if (playerIn.getFoodData().needsFood()) {
				playerIn.startUsingItem(hand);
				return InteractionResultHolder.consume(playerIn.getItemInHand(hand));
			}
			return InteractionResultHolder.fail(playerIn.getItemInHand(hand));
	}
	 
	/* Branch the process. */
	@Override
	 public InteractionResult useOn(UseOnContext context) {
		Player playerIn = context.getPlayer();

		if (context.getClickedFace() == Direction.UP && (playerIn.isCrouching() || playerIn.isPassenger())) {
			return this.place(new BlockPlaceContext(context)); }

		else {
			return this.use(context.getLevel(), context.getPlayer(), context.getHand()).getResult(); }
	 }
	
	/* ToolTip */
	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.block_simpledish").withStyle(ChatFormatting.GRAY));
	}
}
