package com.ayutaki.chinjufumod.items.dish;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
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

public class Dish_always extends ItemNameBlockItem {

	public Dish_always(Block block, Item.Properties properties) {
		super(block, properties);
	}

	public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
		Player playerIn = entityLiving instanceof Player ? (Player)entityLiving : null;
		
		/** add Potion Effect **/
		if (this == Items_Teatime.JPTEACUP.get()) {
			/** ポーションエフェクトの追加 一口100 通常 120 **/
			entityLiving.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 2000, 0)); }

		if (this == Items_Teatime.ICECREAM.get()) {
			entityLiving.addEffect(new MobEffectInstance(MobEffects.LUCK, 3750, 0)); }

		if (this == Items_Seasonal.KAKIGOURI_block.get()) {
			entityLiving.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1250, 0)); }

		if (this == Items_Seasonal.KAKIGOURI_pink.get()) {
			entityLiving.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1900, 0)); }

		if (this == Items_Seasonal.KAKIGOURI_red.get()) {
			entityLiving.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 1900, 0)); }

		if (this == Items_Seasonal.KAKIGOURI_yellow.get()) {
			entityLiving.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1900, 0)); }

		if (this == Items_Seasonal.KAKIGOURI_green.get()) {
			entityLiving.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 1900, 0)); }

		/** add Item **/
		if (playerIn != null) {
			playerIn.awardStat(Stats.ITEM_USED.get(this));

			if (!playerIn.getAbilities().instabuild) {

				if (this == Items_Teatime.JPTEACUP.get()) {
					if (stack.isEmpty()) { return new ItemStack(Items_Teatime.YUNOMI.get()); }
					else if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.YUNOMI.get()))) { playerIn.drop(new ItemStack(Items_Teatime.YUNOMI.get()), false); }
				}

				else if (this == Items_Teatime.ICECREAM.get() || this == Items_Seasonal.KAKIGOURI_block.get() || this == Items_Seasonal.KAKIGOURI_pink.get() ||
						this == Items_Seasonal.KAKIGOURI_red.get() || this == Items_Seasonal.KAKIGOURI_yellow.get() || this == Items_Seasonal.KAKIGOURI_green.get()) {

					if (stack.isEmpty()) { return new ItemStack(Items_Teatime.DRINKGLASS.get()); }
					else if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.DRINKGLASS.get()))) { playerIn.drop(new ItemStack(Items_Teatime.DRINKGLASS.get()), false); } }

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
		if (this == Items_Teatime.JPTEACUP.get()) { return UseAnim.DRINK; }
		return UseAnim.EAT;
	}
	
	 public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand hand) {
		playerIn.startUsingItem(hand);
		return InteractionResultHolder.consume(playerIn.getItemInHand(hand));
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

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(new TranslatableComponent("tips.block_simpledish").withStyle(ChatFormatting.GRAY));
	}
}
