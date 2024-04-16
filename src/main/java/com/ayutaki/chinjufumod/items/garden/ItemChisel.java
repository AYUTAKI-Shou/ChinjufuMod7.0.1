package com.ayutaki.chinjufumod.items.garden;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.garden.Base_Niwaishi;
import com.ayutaki.chinjufumod.blocks.kitchen.UsuTsuki;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Garden_Blocks;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ItemChisel extends Item {

	public ItemChisel(Item.Properties properties) {
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
			/** Stone **/
			if (block == Blocks.STONE) {
				CMEvents.soundChisel(iworld, playerIn, pos);
				iworld.setBlock(pos, Garden_Blocks.NIWAISHI.get().defaultBlockState().setValue(Base_Niwaishi.STAGE_0_15, Integer.valueOf(0)), 3);

				stack.hurtAndBreak(1, playerIn, user -> { user.broadcastBreakEvent(context.getHand()); } );
				playerIn.getCooldowns().addCooldown(this, 10);
				return InteractionResult.SUCCESS; }

			if (block == Blocks.GRANITE) {
				CMEvents.soundChisel(iworld, playerIn, pos);
				iworld.setBlock(pos, Garden_Blocks.NIWAISHI_gra.get().defaultBlockState().setValue(Base_Niwaishi.STAGE_0_15, Integer.valueOf(0)), 3);

				stack.hurtAndBreak(1, playerIn, user -> { user.broadcastBreakEvent(context.getHand()); } );
				playerIn.getCooldowns().addCooldown(this, 10);
				return InteractionResult.SUCCESS; }

			if (block == Blocks.DIORITE) {
				CMEvents.soundChisel(iworld, playerIn, pos);
				iworld.setBlock(pos, Garden_Blocks.NIWAISHI_dio.get().defaultBlockState().setValue(Base_Niwaishi.STAGE_0_15, Integer.valueOf(0)), 3);

				stack.hurtAndBreak(1, playerIn, user -> { user.broadcastBreakEvent(context.getHand()); } );
				playerIn.getCooldowns().addCooldown(this, 10);
				return InteractionResult.SUCCESS; }

			if (block == Blocks.ANDESITE) {
				CMEvents.soundChisel(iworld, playerIn, pos);
				iworld.setBlock(pos, Garden_Blocks.NIWAISHI_and.get().defaultBlockState().setValue(Base_Niwaishi.STAGE_0_15, Integer.valueOf(0)), 3);

				stack.hurtAndBreak(1, playerIn, user -> { user.broadcastBreakEvent(context.getHand()); } );
				playerIn.getCooldowns().addCooldown(this, 10);
				return InteractionResult.SUCCESS; }

			
			/** Slab **/
			if (block == Blocks.STONE_SLAB) {
				CMEvents.soundChisel(iworld, playerIn, pos);
				iworld.setBlock(pos, Garden_Blocks.NIWAISHI_slab.get().defaultBlockState().setValue(Base_Niwaishi.STAGE_0_15, Integer.valueOf(0)), 3);

				stack.hurtAndBreak(1, playerIn, user -> { user.broadcastBreakEvent(context.getHand()); } );
				playerIn.getCooldowns().addCooldown(this, 10);
				return InteractionResult.SUCCESS; }

			if (block == Blocks.GRANITE_SLAB) {
				CMEvents.soundChisel(iworld, playerIn, pos);
				iworld.setBlock(pos, Garden_Blocks.NIWAISHI_slab_gra.get().defaultBlockState().setValue(Base_Niwaishi.STAGE_0_15, Integer.valueOf(0)), 3);

				stack.hurtAndBreak(1, playerIn, user -> { user.broadcastBreakEvent(context.getHand()); } );
				playerIn.getCooldowns().addCooldown(this, 10);
				return InteractionResult.SUCCESS; }

			if (block == Blocks.DIORITE_SLAB) {
				CMEvents.soundChisel(iworld, playerIn, pos);
				iworld.setBlock(pos, Garden_Blocks.NIWAISHI_slab_dio.get().defaultBlockState().setValue(Base_Niwaishi.STAGE_0_15, Integer.valueOf(0)), 3);

				stack.hurtAndBreak(1, playerIn, user -> { user.broadcastBreakEvent(context.getHand()); } );
				playerIn.getCooldowns().addCooldown(this, 10);
				return InteractionResult.SUCCESS; }

			if (block == Blocks.ANDESITE_SLAB) {
				CMEvents.soundChisel(iworld, playerIn, pos);
				iworld.setBlock(pos, Garden_Blocks.NIWAISHI_slab_and.get().defaultBlockState().setValue(Base_Niwaishi.STAGE_0_15, Integer.valueOf(0)), 3);

				stack.hurtAndBreak(1, playerIn, user -> { user.broadcastBreakEvent(context.getHand()); } );
				playerIn.getCooldowns().addCooldown(this, 10);
				return InteractionResult.SUCCESS; }
			
			
			/** Base_Niwaishi **/
			if (block instanceof Base_Niwaishi) {
				int i = state.getValue(Base_Niwaishi.STAGE_0_15);
				boolean mode = playerIn.getAbilities().instabuild;
				
				if (i <= 13) {
					CMEvents.soundChisel(iworld, playerIn, pos);
					iworld.setBlock(pos, state.setValue(Base_Niwaishi.STAGE_0_15, Integer.valueOf(i + 2)), 3);
					
					stack.hurtAndBreak(1, playerIn, user -> { user.broadcastBreakEvent(context.getHand()); } );
					playerIn.getCooldowns().addCooldown(this, 10);
					return InteractionResult.SUCCESS; }
				
				if (i == 14 || i == 15) {
					CMEvents.soundChisel(iworld, playerIn, pos);
					if (!mode) { iworld.destroyBlock(pos, true); }
					if (mode) { iworld.destroyBlock(pos, false); }
				
					stack.hurtAndBreak(1, playerIn, user -> { user.broadcastBreakEvent(context.getHand()); } );
					playerIn.getCooldowns().addCooldown(this, 10);
					return InteractionResult.SUCCESS; }
			}
			
			
			/** oak **/
			if (block == Blocks.OAK_LOG) {
				Direction.Axis axis = state.getValue(RotatedPillarBlock.AXIS);
				
				if (axis == Direction.Axis.Y) {
					CMEvents.soundChiselWood(iworld, playerIn, pos);
					iworld.setBlock(pos, Kitchen_Blocks.USU_TSUKI.get().defaultBlockState().setValue(UsuTsuki.STAGE_0_15, Integer.valueOf(0)), 3);

					stack.hurtAndBreak(1, playerIn, user -> { user.broadcastBreakEvent(context.getHand()); } );
					playerIn.getCooldowns().addCooldown(this, 10);
					return InteractionResult.SUCCESS; }
			}
			
			/** USU **/
			if (block instanceof UsuTsuki) {
				int i = state.getValue(UsuTsuki.STAGE_0_15);
		
				if (i <= 2) {
					CMEvents.soundChiselWood(iworld, playerIn, pos);
					iworld.setBlock(pos, state.setValue(UsuTsuki.STAGE_0_15, Integer.valueOf(i + 1)), 3);
					
					stack.hurtAndBreak(1, playerIn, user -> { user.broadcastBreakEvent(context.getHand()); } );
					playerIn.getCooldowns().addCooldown(this, 10);
					return InteractionResult.SUCCESS; }
			}
		}

		return InteractionResult.FAIL;
	}
	
	@Override
	public boolean isValidRepairItem(ItemStack toRepair, ItemStack material) {
		return material.getItem() == Items.IRON_INGOT; }
	
	/* ToolTip */
	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.item_chisel").withStyle(ChatFormatting.GRAY));
	}
}
