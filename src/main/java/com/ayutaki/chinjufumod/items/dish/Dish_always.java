package com.ayutaki.chinjufumod.items.dish;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.registry.Items_Seasonal;
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
public class Dish_always extends BlockNamedItem {

	public Dish_always(Block block, Item.Properties properties) {
		super(block, properties);
	}

	/* Finish RightClick Action */
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {

		PlayerEntity playerIn = entityLiving instanceof PlayerEntity ? (PlayerEntity)entityLiving : null;

		/** add Potion Effect **/
		if (this == Items_Teatime.JPTEACUP) {
			/** ポーションエフェクトの追加 一口100 通常 120 **/
			entityLiving.addPotionEffect(new EffectInstance(Effects.HASTE, 2000, 0)); }

		if (this == Items_Teatime.ICECREAM) {
			entityLiving.addPotionEffect(new EffectInstance(Effects.LUCK, 3750, 0)); }

		if (this == Items_Seasonal.KAKIGOURI_block) {
			entityLiving.addPotionEffect(new EffectInstance(Effects.SPEED, 1250, 0)); }

		if (this == Items_Seasonal.KAKIGOURI_pink) {
			entityLiving.addPotionEffect(new EffectInstance(Effects.STRENGTH, 1900, 0)); }

		if (this == Items_Seasonal.KAKIGOURI_red) {
			entityLiving.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 1900, 0)); }

		if (this == Items_Seasonal.KAKIGOURI_yellow) {
			entityLiving.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 1900, 0)); }

		if (this == Items_Seasonal.KAKIGOURI_green) {
			entityLiving.addPotionEffect(new EffectInstance(Effects.HASTE, 1900, 0)); }

		/** add Item **/
		if (playerIn != null) {
			playerIn.addStat(Stats.ITEM_USED.get(this));

			if (!playerIn.abilities.isCreativeMode) {

				if (this == Items_Teatime.JPTEACUP) {
					if (stack.isEmpty()) { return new ItemStack(Items_Teatime.YUNOMI); }
					else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.YUNOMI))) {
						playerIn.dropItem(new ItemStack(Items_Teatime.YUNOMI), false); } }

				else if (this == Items_Teatime.ICECREAM || this == Items_Seasonal.KAKIGOURI_block || this == Items_Seasonal.KAKIGOURI_pink ||
						this == Items_Seasonal.KAKIGOURI_red || this == Items_Seasonal.KAKIGOURI_yellow || this == Items_Seasonal.KAKIGOURI_green) {
					if (stack.isEmpty()) { return new ItemStack(Items_Teatime.DRINKGLASS); }
					else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.DRINKGLASS))) {
						playerIn.dropItem(new ItemStack(Items_Teatime.DRINKGLASS), false); } }

				stack.shrink(1);
			}
		}
		return stack;
	}

	public int getUseDuration(ItemStack stack) {
		return 32;
	}

	public UseAction getUseAction(ItemStack stack) {
		if (this == Items_Teatime.JPTEACUP) {
			return UseAction.DRINK;
		}
		return UseAction.EAT;
	}

	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand hand) {
		playerIn.setActiveHand(hand);
		return ActionResult.resultSuccess(playerIn.getHeldItem(hand));
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
	}
}
