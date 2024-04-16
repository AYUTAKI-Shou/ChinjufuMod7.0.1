package com.ayutaki.chinjufumod.blocks.hakkou;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class TaruF_Shouyu extends BaseTaru_Stage08 {

	/** 0=未発酵の醤油、5=醤油、 6=醤油、7=醤油、 8=醤油 **/
	public TaruF_Shouyu(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		int i = state.getValue(STAGE_0_8);

		/** Too early to collect **/
		if (i <= 4) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
		
		/** Can harvest **/
		if (i > 4) {
			if (item == Items.GLASS_BOTTLE) {
				/** Collect with an Item **/
				CMEvents.Consume1Item_Bottle(worldIn, pos, playerIn, hand);
	
				if (stack.isEmpty()) { playerIn.getInventory().add(new ItemStack(Items_Teatime.SHOUYU_bot_1.get())); }
				else if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.SHOUYU_bot_1.get()))) {
					playerIn.drop(new ItemStack(Items_Teatime.SHOUYU_bot_1.get()), false); }
	
				if (i != 8) {
					worldIn.setBlock(pos, state.setValue(STAGE_0_8, Integer.valueOf(i + 1)), 3); }
	
				if (i == 8) {
					worldIn.setBlock(pos, Hakkou_Blocks.HAKKOU_TARU.get().defaultBlockState()
							.setValue(Taru_Hakkou.STAGE_0_5, Integer.valueOf(0)), 3); }
			}
			
			if (item != Items.GLASS_BOTTLE) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		}
		
		/** SUCCESS to not put anything on top. **/
		return InteractionResult.SUCCESS;
	}

	/* ToolTip */
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(new TranslatableComponent("tips.block_taru_shouyu").withStyle(ChatFormatting.GRAY));
	}
}
