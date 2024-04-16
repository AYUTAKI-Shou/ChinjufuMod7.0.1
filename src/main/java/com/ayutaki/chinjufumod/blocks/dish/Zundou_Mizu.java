package com.ayutaki.chinjufumod.blocks.dish;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
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

public class Zundou_Mizu extends BaseZundou_2Cook {

	/** 1=cold, 2=hot **/
	public Zundou_Mizu(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();

		int i = state.getValue(STAGE_1_2);
		/** 1=cold, 2=hot **/

		/** 1=塩水、2=塩湯 **/
		if (item == Items_Teatime.SHIO.get()) {
			if (i == 1) {
				CMEvents.Consume1Item_Splash(worldIn, pos, playerIn, hand);
				
				worldIn.setBlock(pos, Dish_Blocks.ZUNDOU_SHIO.get().defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(STAGE_1_2, Integer.valueOf(1)), 3); }
	
			if (i == 2) {
				CMEvents.Consume1Item_Splash(worldIn, pos, playerIn, hand);
				
				worldIn.setBlock(pos, Dish_Blocks.ZUNDOU_SHIO.get().defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(STAGE_1_2, Integer.valueOf(2)), 3); }
		}
		
		/**1=灰汁水、2=灰汁湯 **/
		if (item == Items_Seasonal.WARAHAI.get()) {
			if (i == 1) {
				CMEvents.Consume1Item_Splash(worldIn, pos, playerIn, hand);
				
				worldIn.setBlock(pos, Dish_Blocks.ZUNDOU_AKU.get().defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(STAGE_1_2, Integer.valueOf(1)), 3); }
	
			if (i == 2) {
				CMEvents.Consume1Item_Splash(worldIn, pos, playerIn, hand);
				
				worldIn.setBlock(pos, Dish_Blocks.ZUNDOU_AKU.get().defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(STAGE_1_2, Integer.valueOf(2)), 3); }
		}
		
		/** 出汁へ **/
		if (item == Items_Teatime.DASHI_bot_1.get()) {
			if (i == 2) {
				CMEvents.Consume1Item_Splash(worldIn, pos, playerIn, hand);
	
				if (stack.isEmpty()) { playerIn.getInventory().add(new ItemStack(Items.GLASS_BOTTLE)); }
				else if (!playerIn.getInventory().add(new ItemStack(Items.GLASS_BOTTLE))) {
					playerIn.drop(new ItemStack(Items.GLASS_BOTTLE), false); }
				
				worldIn.setBlock(pos, Dish_Blocks.ZUNDOU_DASHI.get().defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(BaseZundou_4Stage.STAGE_1_4, Integer.valueOf(1)), 3); }
			
			/** Too early to use **/
			if (i != 2) { CMEvents.textEarlyUse(worldIn, pos, playerIn); }
		}
		
		/** うどん**/
		if (item == Items_Teatime.UDON_nama.get()) {
			if (i == 2) {
				CMEvents.Consume1Item_Splash(worldIn, pos, playerIn, hand);
				
				worldIn.setBlock(pos, Dish_Blocks.ZUNDOU_UDON.get().defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(BaseZundou_4Stage.STAGE_1_4, Integer.valueOf(1)), 3); } //Large items cool it down.
			
			/** Too early to use **/
			if (i != 2) { CMEvents.textEarlyUse(worldIn, pos, playerIn); }
		}
		
		/** ラーメン**/
		if (item == Items_Teatime.RAMEN_nama.get()) {
			if (i == 2) {
				CMEvents.Consume1Item_Splash(worldIn, pos, playerIn, hand);
				
				worldIn.setBlock(pos, Dish_Blocks.ZUNDOU_RAMEN.get().defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(BaseZundou_4Stage.STAGE_1_4, Integer.valueOf(1)), 3); } //Large items cool it down.
			
			/** Too early to use **/
			if (i != 2) { CMEvents.textEarlyUse(worldIn, pos, playerIn); }
		}
		
		if (item != Items_Teatime.SHIO.get() && item != Items_Seasonal.WARAHAI.get() && item != Items_Teatime.DASHI_bot_1.get() && 
				item != Items_Teatime.UDON_nama.get() && item != Items_Teatime.RAMEN_nama.get()) {
			CMEvents.textNotHave(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return InteractionResult.SUCCESS;
	}
	
	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
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
		tooltip.add(Component.translatable("tips.block_frypan").withStyle(ChatFormatting.GRAY));
	}
}
