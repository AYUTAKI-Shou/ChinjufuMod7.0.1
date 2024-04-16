package com.ayutaki.chinjufumod.blocks.dish;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerLevel;
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

public class Zundou_Shio extends BaseZundou_2Cook {

	/** 1=cold, 2=hot **/
	public Zundou_Shio(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();

		int i = state.getValue(STAGE_1_2);
		/** 1=cold, 2=hot **/

		if (i == 2) {
			if (item == Items_Teatime.PASTA_nama.get()) {
				CMEvents.Consume1Item_Splash(worldIn, pos, playerIn, hand);
				
				worldIn.setBlock(pos, Dish_Blocks.ZUNDOU_PASTA.get().defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(BaseZundou_4Stage.STAGE_1_4, Integer.valueOf(1)), 3); } //Large items cool it down.
	
			if (item == Items.COD) {
				CMEvents.Consume1Item_Splash(worldIn, pos, playerIn, hand);
				
				worldIn.setBlock(pos, Dish_Blocks.ZUNDOU_FISH.get().defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(BaseZundou_4Stage.STAGE_1_4, Integer.valueOf(1)), 3); } //Large items cool it down.
			
			if (item != Items_Teatime.PASTA_nama.get() && item != Items.COD && item != Items_Teatime.SHIO.get()) {
				CMEvents.textNotHave(worldIn, pos, playerIn); }
		}
		
		/** Too early to use **/
		if (i != 2) { CMEvents.textEarlyUse(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return InteractionResult.SUCCESS;
	}
	
	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, Random rand) {
		int i = state.getValue(STAGE_1_2);
		/** 1=cold, 2=hot **/

		if (!inWater(state, worldIn, pos)) {
			if (i == 1) {
				if (isCooking(worldIn, pos)) {
					worldIn.scheduleTick(pos, this, COOK_TIME + (20 * rand.nextInt(5)));
					worldIn.setBlock(pos, state.setValue(STAGE_1_2, Integer.valueOf(2)), 3); }
				
				else { }
			}
			
			if (i != 1) {
				if (isCooking(worldIn, pos)) { }
				
				else {
					worldIn.scheduleTick(pos, this, COOK_TIME);
					worldIn.setBlock(pos, state.setValue(STAGE_1_2, Integer.valueOf(1)), 3); }
			}
		}
		
		if (inWater(state, worldIn, pos)) {
			worldIn.scheduleTick(pos, this, 60);
			CMEvents.soundBubble(worldIn, pos);
			worldIn.setBlock(pos, Dish_Blocks.ZUNDOU.get().defaultBlockState()
					.setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Zundou.STAGE_1_2, Integer.valueOf(2))
					.setValue(Zundou.WATERLOGGED, state.getValue(WATERLOGGED)), 3); }
	}

	/* ToolTip */
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(new TranslatableComponent("tips.block_zundou_shiomizu").withStyle(ChatFormatting.GRAY));
	}
}
