package com.ayutaki.chinjufumod.items.foods;

import com.ayutaki.chinjufumod.registry.Items_Seasonal;
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

public class FoodAnytime_addItem extends Item {

	public FoodAnytime_addItem(Item.Properties properties) {
		super(properties);
	}
	
	public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
		Player playerIn = entityLiving instanceof Player ? (Player)entityLiving : null;

		/** add SATURATION **/
		entityLiving.addEffect(new MobEffectInstance(MobEffects.SATURATION, 1, 0));

		/** add Potion Effect **/
		if (this == Items_Seasonal.FOOD_WATAGASHI.get()) { entityLiving.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 0)); }
		if (this == Items_Seasonal.FOOD_WATAGASHI_A.get()) { entityLiving.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1000, 0)); }
		if (this == Items_Seasonal.FOOD_WATAGASHI_C.get()) { entityLiving.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1000, 0)); }
		if (this == Items_Seasonal.FOOD_WATAGASHI_G.get()) { entityLiving.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 1000, 0)); }
		if (this == Items_Seasonal.FOOD_WATAGASHI_T.get()) { entityLiving.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 1000, 0)); }

		/** add Item **/
		if (playerIn != null) {
			playerIn.awardStat(Stats.ITEM_USED.get(this));

			if (!playerIn.getAbilities().instabuild) {

				if (this != Items_Teatime.FOOD_CHERRY.get()) {
					if (stack.isEmpty()) { return new ItemStack(Items.STICK); }
					else if (!playerIn.getInventory().add(new ItemStack(Items.STICK))) {
						playerIn.drop(new ItemStack(Items.STICK), false); } }

				if (this == Items_Teatime.FOOD_CHERRY.get()) {
					if (stack.isEmpty()) { return new ItemStack(Items_Teatime.SEEDS_CHERRY.get()); }
					else if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.SEEDS_CHERRY.get()))) {
						playerIn.drop(new ItemStack(Items_Teatime.SEEDS_CHERRY.get()), false); } }

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
		playerIn.startUsingItem(hand);
		return InteractionResultHolder.consume(playerIn.getItemInHand(hand));
	}
}
