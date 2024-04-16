package com.ayutaki.chinjufumod.items.teatime;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.gameevent.GameEvent;

public class Match_Item extends Item {

	public Match_Item(Item.Properties properties) {
		super(properties);
	}
	
	public InteractionResult useOn(UseOnContext context) {
		Player playerIn = context.getPlayer();
		Level worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		BlockState state = worldIn.getBlockState(pos);
		ItemStack stack = context.getItemInHand();
		boolean mode = playerIn.getAbilities().instabuild;
		
		if (!CampfireBlock.canLight(state) && !CandleBlock.canLight(state) && !CandleCakeBlock.canLight(state)) {
			BlockPos posFace = pos.relative(context.getClickedFace());
			
			if (BaseFireBlock.canBePlacedAt(worldIn, posFace, context.getHorizontalDirection())) {
				worldIn.playSound(playerIn, posFace, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, worldIn.getRandom().nextFloat() * 0.4F + 0.8F);
				BlockState state1 = BaseFireBlock.getState(worldIn, posFace);
				worldIn.setBlock(posFace, state1, 11);
				worldIn.gameEvent(playerIn, GameEvent.BLOCK_PLACE, pos);
				
				if (playerIn instanceof ServerPlayer) {
					CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer)playerIn, posFace, stack);
					if (!mode) { stack.shrink(1); }
					if (mode) { }
				}

				return InteractionResult.sidedSuccess(worldIn.isClientSide());
			} 
			
			else { return InteractionResult.FAIL; }
		} 
		
		else {
			worldIn.playSound(playerIn, pos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, worldIn.getRandom().nextFloat() * 0.4F + 0.8F);
			worldIn.setBlock(pos, state.setValue(BlockStateProperties.LIT, Boolean.valueOf(true)), 11);
			worldIn.gameEvent(playerIn, GameEvent.BLOCK_PLACE, pos);

			if (!mode) { stack.shrink(1); }
			if (mode) { }

			return InteractionResult.sidedSuccess(worldIn.isClientSide());
		}
	}
	
	/* ToolTip */
	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.item_match_cm").withStyle(ChatFormatting.GRAY));
	}
}
