package com.ayutaki.chinjufumod.items.garden;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.garden.Samon;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Garden_Blocks;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class ItemKumade extends Item {

	public ItemKumade(Item.Properties properties) {
		super(properties.durability(256));
	}
	
	public InteractionResult useOn(UseOnContext context) {
		Player playerIn = context.getPlayer();
		Level iworld = context.getLevel();
		BlockPos pos = context.getClickedPos();
		BlockState state = iworld.getBlockState(pos);
		Block block = state.getBlock();
		ItemStack stack = context.getItemInHand();
		
		if (!playerIn.getCooldowns().isOnCooldown(this)) {
			
			if (block == Blocks.SAND) {
				CMEvents.soundKumade(iworld, playerIn, pos);
				iworld.setBlock(pos, Garden_Blocks.SAMON.get().defaultBlockState().setValue(Samon.STAGE_0_7, Integer.valueOf(0)), 3);

				stack.hurtAndBreak(1, playerIn, user -> { user.broadcastBreakEvent(context.getHand()); } );
				playerIn.getCooldowns().addCooldown(this, 10);
				return InteractionResult.SUCCESS; }

			if (block == Blocks.GRAVEL) {
				CMEvents.soundKumade(iworld, playerIn, pos);
				iworld.setBlock(pos, Garden_Blocks.SAMON_B.get().defaultBlockState().setValue(Samon.STAGE_0_7, Integer.valueOf(0)), 3);

				stack.hurtAndBreak(1, playerIn, user -> { user.broadcastBreakEvent(context.getHand()); } );
				playerIn.getCooldowns().addCooldown(this, 10);
				return InteractionResult.SUCCESS; }
			
			/** Samon **/
			if (block instanceof Samon) {
				CMEvents.soundKumade(iworld, playerIn, pos);
				iworld.setBlock(pos, state.cycle(Samon.STAGE_0_7), 3);
				
				playerIn.getCooldowns().addCooldown(this, 10);
				return InteractionResult.SUCCESS; }
		}

		return InteractionResult.FAIL;
	}
	
	@Override
	public boolean isValidRepairItem(ItemStack toRepair, ItemStack material) {
		return material.getItem() == Items.STICK; }
	
	/* ToolTip */
	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.item_kumade").withStyle(ChatFormatting.GRAY));
	}
}
