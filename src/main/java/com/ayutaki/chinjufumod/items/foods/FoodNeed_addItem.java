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
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {

		PlayerEntity playerIn = entityLiving instanceof PlayerEntity ? (PlayerEntity)entityLiving : null;

		/** add SATURATION **/
		if (this == Items_Teatime.KUSHI_SAKANA_C) {
			entityLiving.addPotionEffect(new EffectInstance(Effects.HASTE, 1000, 0));
			entityLiving.addPotionEffect(new EffectInstance(Effects.SATURATION, 5, 0)); }

		if (this != Items_Teatime.KUSHI_SAKANA_C) {
			entityLiving.addPotionEffect(new EffectInstance(Effects.SATURATION, 2, 0)); }
		
		/** add Item **/
		if (playerIn != null) {
			playerIn.addStat(Stats.ITEM_USED.get(this));

			if (!playerIn.abilities.isCreativeMode) {

				if (this == Items_Teatime.KUSHI_SAKANA_C) {
					if (stack.isEmpty()) { return new ItemStack(Items.STICK); }
					else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.STICK))) {
						playerIn.dropItem(new ItemStack(Items.STICK), false); } }

				if (this != Items_Teatime.KUSHI_SAKANA_C) {
					if (stack.isEmpty()) { return new ItemStack(Items_NoTab.HAMAGURI_KARA); }
					else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_NoTab.HAMAGURI_KARA))) {
						playerIn.dropItem(new ItemStack(Items_NoTab.HAMAGURI_KARA), false); } }
				
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

}
