package com.ayutaki.chinjufumod.items.foods;

import com.ayutaki.chinjufumod.registry.Items_NoTab;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class FoodNeed_addItem extends Item {

	public FoodNeed_addItem(Item.Properties properties) {
		super(properties);
	}

	/* Finish RightClick Action */
	@Override
	public ItemStack finishUsingItem(ItemStack stack, World worldIn, LivingEntity entityLiving) {

		PlayerEntity playerIn = entityLiving instanceof PlayerEntity ? (PlayerEntity)entityLiving : null;

		/** add Potion Effect **/
		if (this == Items_Teatime.KUSHI_SAKANA_C) {
			entityLiving.addEffect(new EffectInstance(Effects.DIG_SPEED, 1000, 0));
			entityLiving.addEffect(new EffectInstance(Effects.SATURATION, 5, 0)); }

		if (this != Items_Teatime.KUSHI_SAKANA_C) {
			entityLiving.addEffect(new EffectInstance(Effects.SATURATION, 2, 0)); }
		
		/** add Item **/
		if (playerIn != null) {
			playerIn.awardStat(Stats.ITEM_USED.get(this));

			if (!playerIn.abilities.instabuild) {

				if (this == Items_Teatime.KUSHI_SAKANA_C) {
					if (stack.isEmpty()) { return new ItemStack(Items.STICK); }
					else if (!playerIn.inventory.add(new ItemStack(Items.STICK))) {
						playerIn.drop(new ItemStack(Items.STICK), false); } }

				if (this != Items_Teatime.KUSHI_SAKANA_C) {
					if (stack.isEmpty()) { return new ItemStack(Items_NoTab.HAMAGURI_KARA); }
					else if (!playerIn.inventory.add(new ItemStack(Items_NoTab.HAMAGURI_KARA))) {
						playerIn.drop(new ItemStack(Items_NoTab.HAMAGURI_KARA), false); } }
				
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
	public UseAction getUseAnimation(ItemStack stack) {
		return UseAction.EAT;
	}

	@Override
	public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand hand) {
		/** It works only when you're hungry. **/
		if (playerIn.getFoodData().needsFood()) {
			playerIn.startUsingItem(hand);
			return ActionResult.consume(playerIn.getItemInHand(hand));
		}
		return ActionResult.fail(playerIn.getItemInHand(hand));
	}

}
