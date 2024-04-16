package com.ayutaki.chinjufumod.items.hakkou;

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

public class SakeGlass extends ItemNameBlockItem {

	public SakeGlass(Block block, Item.Properties properties) {
		super(block, properties);
	}
	
	public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
		Player playerIn = entityLiving instanceof Player ? (Player)entityLiving : null;
	
		if (this == Items_Teatime.NAMASAKEGLASS.get()) {
			entityLiving.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2250, 0));
			entityLiving.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2600, 0)); }
		if (this == Items_Teatime.SAKEGLASS.get()) {
			entityLiving.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2250, 1));
			entityLiving.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2600, 0)); }
		if (this == Items_Teatime.JUKUSAKEGLASS.get()) {
			entityLiving.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2250, 2));
			entityLiving.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2250, 0)); }

		if (this == Items_Teatime.AMAZAKEGLASS.get()) {
			entityLiving.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 2000, 0)); }

		if (this == Items_Teatime.CIDERGLASS.get()) {
			entityLiving.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2250, 0));
			entityLiving.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2600, 0)); }
		if (this == Items_Teatime.JUKUCIDERGLASS.get()) {
			entityLiving.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2250, 1));
			entityLiving.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2250, 0)); }
		if (this == Items_Teatime.WINEGLASS.get()) {
			entityLiving.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2250, 0));
			entityLiving.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2600, 0)); }
		if (this == Items_Teatime.JUKUWINEGLASS.get()) {
			entityLiving.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2250, 1));
			entityLiving.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2250, 0)); }

		if (this == Items_Teatime.MEADGLASS.get()) {
			entityLiving.removeEffect(MobEffects.POISON);
			entityLiving.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2250, 0));
			entityLiving.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2600, 0)); }
		if (this == Items_Teatime.JUKUMEADGLASS.get()) {
			entityLiving.removeEffect(MobEffects.POISON);
			entityLiving.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2250, 1));
			entityLiving.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2250, 0)); }

		if (playerIn != null) {
			playerIn.awardStat(Stats.ITEM_USED.get(this));

			if (!playerIn.getAbilities().instabuild) {
				if (this != Items_Teatime.AMAZAKEGLASS.get()) {
					if (stack.isEmpty()) { return new ItemStack(Items_Teatime.DRINKGLASS.get()); }
					else if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.DRINKGLASS.get()))) {
						playerIn.drop(new ItemStack(Items_Teatime.DRINKGLASS.get()), false); } }

				if (this == Items_Teatime.AMAZAKEGLASS.get()) {
					if (stack.isEmpty()) { return new ItemStack(Items_Teatime.YUNOMI.get()); }
					else if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.YUNOMI.get()))) {
						playerIn.drop(new ItemStack(Items_Teatime.YUNOMI.get()), false); } }

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
		return UseAnim.DRINK;
	}
	
	 public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand hand) {
		playerIn.startUsingItem(hand);
		return InteractionResultHolder.consume(playerIn.getItemInHand(hand));
	}
	
	/* Branch the process. スニーク時 playerIn.isCrouching() 座っている時 playerIn.isPassenger() */
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
