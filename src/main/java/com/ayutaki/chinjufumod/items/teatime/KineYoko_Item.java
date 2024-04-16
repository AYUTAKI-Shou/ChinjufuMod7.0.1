package com.ayutaki.chinjufumod.items.teatime;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.kitchen.UsuTsuki;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class KineYoko_Item extends Item {

	public KineYoko_Item(Item.Properties properties) {
		super(properties.durability(128));
	}
	
	public InteractionResult useOn(UseOnContext context) {
		Player playerIn = context.getPlayer();
		Level iworld = context.getLevel();
		BlockPos pos = context.getClickedPos();
		BlockState state = iworld.getBlockState(pos);
		Block block = state.getBlock();
		Direction direction = context.getClickedFace();
		ItemStack stack = context.getItemInHand();
		
		if (!playerIn.getCooldowns().isOnCooldown(this)) {
	
			if (block instanceof UsuTsuki) {
				int i = state.getValue(UsuTsuki.STAGE_0_15);
				if (direction == Direction.UP) {
					
					if (i >= 4 && i <= 14) {
						if (i >= 4 && i <= 6) { //volume, pitch
							iworld.playSound(playerIn, pos, SoundEvents.SNOW_BREAK, SoundSource.BLOCKS, 1.0F, 0.8F); }
			
						if (i >= 7 && i <= 14) {
							iworld.playSound(playerIn, pos, SoundEvents.PLAYER_ATTACK_STRONG, SoundSource.BLOCKS, 0.8F, 1.1F);
							iworld.playSound(playerIn, pos, SoundEvents.SLIME_JUMP, SoundSource.BLOCKS, 0.1F, 0.8F); }

						iworld.setBlock(pos, Kitchen_Blocks.USU_TSUKI.get().defaultBlockState().setValue(UsuTsuki.STAGE_0_15, Integer.valueOf(i + 1)), 3);
						stack.hurtAndBreak(1, playerIn, user -> { user.broadcastBreakEvent(context.getHand()); } ); 
						playerIn.getCooldowns().addCooldown(this, 10); }
					
					else { }
				}
				
				if (direction != Direction.UP) { iworld.playSound(playerIn, pos, SoundEvents_CM.TOUCH_BLOCK.get(), SoundSource.BLOCKS, 1.0F, 0.8F); }

				return InteractionResult.SUCCESS;
			}
		}

		return InteractionResult.FAIL;
	}
	
	@Override
	public boolean isValidRepairItem(ItemStack toRepair, ItemStack material) {
		return material.getItem() == Items.OAK_LOG; }
	
	/* ToolTip */
	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.block_usutsuki").withStyle(ChatFormatting.GRAY));
	}
}
