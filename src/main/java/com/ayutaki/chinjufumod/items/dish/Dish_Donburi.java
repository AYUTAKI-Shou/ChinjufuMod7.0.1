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

public class Dish_Donburi extends ItemNameBlockItem {

	public Dish_Donburi(Block block, Item.Properties properties) {
		super(block, properties);
	}

	public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
		Player playerIn = entityLiving instanceof Player ? (Player)entityLiving : null;
		
		/** add Potion Effect **/
		if (this == Items_Teatime.UDON_SU.get()) {
			entityLiving.addEffect(new MobEffectInstance(MobEffects.SATURATION, 5, 0)); }

		if (this == Items_Teatime.UDON_NIKU.get() || this == Items_Teatime.UDON_TSUKIMI.get()) {
			entityLiving.addEffect(new MobEffectInstance(MobEffects.SATURATION, 10, 0));
			entityLiving.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 3000, 0));
			entityLiving.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 0));
			entityLiving.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 3000, 0)); }

		if (this == Items_Teatime.DONBURI_MESHI.get()) {
			entityLiving.addEffect(new MobEffectInstance(MobEffects.SATURATION, 5, 0)); }

		if (this == Items_Teatime.DONBURI_GYU.get() || this == Items_Teatime.DONBURI_OYAKO.get() || this == Items_Teatime.DONBURI_KAISEN.get()) {
			entityLiving.addEffect(new MobEffectInstance(MobEffects.SATURATION, 10, 0));
			entityLiving.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 3000, 0));
			entityLiving.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 0));
			entityLiving.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 3000, 0)); }

		if (this == Items_Teatime.DONBURI_KATSU.get() || this == Items_Teatime.RAMEN_SHOUYU.get() || 
				this == Items_Teatime.RAMEN_MISO.get() || this == Items_Teatime.RAMEN_SHIO.get()) {
			entityLiving.addEffect(new MobEffectInstance(MobEffects.SATURATION, 10, 0));
			entityLiving.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 3500, 0));
			entityLiving.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 0));
			entityLiving.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 3500, 0)); }


		/** add Item **/
		if (playerIn != null) {
			playerIn.awardStat(Stats.ITEM_USED.get(this));

			if (!playerIn.getAbilities().instabuild) {
				if (stack.isEmpty()) { return new ItemStack(Items_Teatime.DONBURI.get()); }
				else if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.DONBURI.get()))) { playerIn.drop(new ItemStack(Items_Teatime.DONBURI.get()), false); }
				
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
		
		if (this == Items_Teatime.DONBURI_GYU.get()) {
			tooltip.add(Component.translatable("tips.block_food_dongyu_1").withStyle(ChatFormatting.GRAY)); }
		if (this == Items_Teatime.DONBURI_KATSU.get()) {
			tooltip.add(Component.translatable("tips.block_food_donkatsu_1").withStyle(ChatFormatting.GRAY)); }
		if (this == Items_Teatime.DONBURI_OYAKO.get()) {
			tooltip.add(Component.translatable("tips.block_food_donoyako_1").withStyle(ChatFormatting.GRAY)); }
		if (this == Items_Teatime.DONBURI_KAISEN.get()) {
			tooltip.add(Component.translatable("tips.block_food_donkaisen_1").withStyle(ChatFormatting.GRAY)); }
	}
}
