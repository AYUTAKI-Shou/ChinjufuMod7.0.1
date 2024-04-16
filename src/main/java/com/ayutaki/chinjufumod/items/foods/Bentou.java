package com.ayutaki.chinjufumod.items.foods;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class Bentou extends Item {

	public Bentou(Item.Properties properties) {
		super(properties);
	}

	/* Finish RightClick Action */
	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
		Player playerIn = entityLiving instanceof Player ? (Player)entityLiving : null;

		/** add Potion Effect **/
		entityLiving.addEffect(new MobEffectInstance(MobEffects.SATURATION, 10, 0));
		entityLiving.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 3500, 0));
		entityLiving.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 0)); 
		entityLiving.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 3500, 0));

		/** add Item **/
		if (playerIn != null) {
			playerIn.awardStat(Stats.ITEM_USED.get(this));

			if (!playerIn.getAbilities().instabuild) {

				if (stack.isEmpty()) { return new ItemStack(Items_Teatime.BENTOUHAKO.get()); }
				else if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.BENTOUHAKO.get()))) {
					playerIn.drop(new ItemStack(Items_Teatime.BENTOUHAKO.get()), false); }

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

	@Override
	public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand hand) {
		/** It works only when you're hungry. **/
		if (playerIn.getFoodData().needsFood()) {
			playerIn.startUsingItem(hand);
			return InteractionResultHolder.consume(playerIn.getItemInHand(hand));
		}
		return InteractionResultHolder.fail(playerIn.getItemInHand(hand));
	}

	/* ToolTip */
	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.item_bentou").withStyle(ChatFormatting.GRAY));
	}
}
