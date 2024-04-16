package com.ayutaki.chinjufumod.items.foods;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ItemGroups_CM;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Bentou extends Item {

	public Bentou(Item.Properties properties) {
		super(properties.tab(ItemGroups_CM.TEATIME));
	}

	/* Finish RightClick Action */
	@Override
	public ItemStack finishUsingItem(ItemStack stack, World worldIn, LivingEntity entityLiving) {

		PlayerEntity playerIn = entityLiving instanceof PlayerEntity ? (PlayerEntity)entityLiving : null;

		/** add Potion Effect **/
		entityLiving.addEffect(new EffectInstance(Effects.SATURATION, 10, 0));
		entityLiving.addEffect(new EffectInstance(Effects.DIG_SPEED, 3500, 0));
		entityLiving.addEffect(new EffectInstance(Effects.HEAL, 1, 0)); 
		entityLiving.addEffect(new EffectInstance(Effects.REGENERATION, 3500, 0));

		/** add Item **/
		if (playerIn != null) {
			playerIn.awardStat(Stats.ITEM_USED.get(this));

			if (!playerIn.abilities.instabuild) {

				if (stack.isEmpty()) { return new ItemStack(Items_Teatime.BENTOUHAKO); }
				else if (!playerIn.inventory.add(new ItemStack(Items_Teatime.BENTOUHAKO))) {
					playerIn.drop(new ItemStack(Items_Teatime.BENTOUHAKO), false); }

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

	/* ToolTip ...Item.class 222(1.16.5) */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.item_bentou").withStyle(TextFormatting.GRAY));
	}
}
