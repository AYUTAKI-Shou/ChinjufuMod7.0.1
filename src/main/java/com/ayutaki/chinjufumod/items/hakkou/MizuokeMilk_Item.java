package com.ayutaki.chinjufumod.items.hakkou;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MilkBucketItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class MizuokeMilk_Item extends MilkBucketItem {

	public MizuokeMilk_Item(Item.Properties properties) {
		super(properties);
	}
	
	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
		/** 牛乳入りバケツの効果を呼び出す **/
		if (!worldIn.isClientSide) entityLiving.curePotionEffects(new ItemStack(Items.MILK_BUCKET));

		if (entityLiving instanceof ServerPlayer) {
			ServerPlayer serverplayerentity = (ServerPlayer)entityLiving;
			CriteriaTriggers.CONSUME_ITEM.trigger(serverplayerentity, stack);
			serverplayerentity.awardStat(Stats.ITEM_USED.get(this));
		}

		if (entityLiving instanceof Player && !((Player)entityLiving).getAbilities().instabuild) {
			Player playerIn = entityLiving instanceof Player ? (Player)entityLiving : null;

			if (stack.isEmpty()) { return new ItemStack(Items_Teatime.MIZUOKE.get()); }
			else if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.MIZUOKE.get()))) {
				playerIn.drop(new ItemStack(Items_Teatime.MIZUOKE.get()), false); }

			stack.shrink(1);
		}

		return stack;
	}

	/* ToolTip */
	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.item_mizuoke_milk").withStyle(ChatFormatting.GRAY));
	}
}
