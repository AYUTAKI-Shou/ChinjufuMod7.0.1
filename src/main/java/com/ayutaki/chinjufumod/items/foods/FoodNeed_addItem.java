package com.ayutaki.chinjufumod.items.foods;

import com.ayutaki.chinjufumod.registry.Items_NoTab;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class FoodNeed_addItem extends Item {

	public FoodNeed_addItem(Item.Properties properties) {
		super(properties);
	}
	
	public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
		Player playerIn = entityLiving instanceof Player ? (Player)entityLiving : null;

		/** add SATURATION **/
		if (this == Items_Teatime.KUSHI_SAKANA_C.get()) {
			entityLiving.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 1000, 0));
			entityLiving.addEffect(new MobEffectInstance(MobEffects.SATURATION, 5, 0)); }

		if (this != Items_Teatime.KUSHI_SAKANA_C.get()) {
			entityLiving.addEffect(new MobEffectInstance(MobEffects.SATURATION, 2, 0)); }
		
		/** add Item **/
		if (playerIn != null) {
			playerIn.awardStat(Stats.ITEM_USED.get(this));

			if (!playerIn.getAbilities().instabuild) {
				
				if (this == Items_Teatime.KUSHI_SAKANA_C.get()) {
					if (stack.isEmpty()) { return new ItemStack(Items.STICK); }
					else if (!playerIn.getInventory().add(new ItemStack(Items.STICK))) {
						playerIn.drop(new ItemStack(Items.STICK), false); } }

				if (this != Items_Teatime.KUSHI_SAKANA_C.get()) {
					if (stack.isEmpty()) { return new ItemStack(Items_NoTab.HAMAGURI_KARA.get()); }
					else if (!playerIn.getInventory().add(new ItemStack(Items_NoTab.HAMAGURI_KARA.get()))) {
						playerIn.drop(new ItemStack(Items_NoTab.HAMAGURI_KARA.get()), false); } }
				
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
}
