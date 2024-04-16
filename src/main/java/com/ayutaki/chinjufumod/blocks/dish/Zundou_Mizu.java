package com.ayutaki.chinjufumod.blocks.dish;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Zundou_Mizu extends BaseZundou_2Cook {

	/** 1=cold, 2=hot **/
	public Zundou_Mizu(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();

		int i = state.get(STAGE_1_2);
		/** 1=cold, 2=hot **/

		/** 1=塩水、2=塩湯 **/
		if (item == Items_Teatime.SHIO) {
			if (i == 1) {
				CMEvents.Consume1Item_Splash(worldIn, pos, playerIn, hand);
				
				worldIn.setBlockState(pos, Dish_Blocks.ZUNDOU_SHIO.getDefaultState()
						.with(H_FACING, state.get(H_FACING))
						.with(STAGE_1_2, Integer.valueOf(1))); }
	
			if (i == 2) {
				CMEvents.Consume1Item_Splash(worldIn, pos, playerIn, hand);
				
				worldIn.setBlockState(pos, Dish_Blocks.ZUNDOU_SHIO.getDefaultState()
						.with(H_FACING, state.get(H_FACING))
						.with(STAGE_1_2, Integer.valueOf(2))); }
		}
		
		/** 1=灰汁水、2=灰汁湯 **/
		if (item == Items_Seasonal.WARAHAI) {
			if (i == 1) {
				CMEvents.Consume1Item_Splash(worldIn, pos, playerIn, hand);
				
				worldIn.setBlockState(pos, Dish_Blocks.ZUNDOU_AKU.getDefaultState()
						.with(H_FACING, state.get(H_FACING))
						.with(STAGE_1_2, Integer.valueOf(1))); }
	
			if (i == 2) {
				CMEvents.Consume1Item_Splash(worldIn, pos, playerIn, hand);
				
				worldIn.setBlockState(pos, Dish_Blocks.ZUNDOU_AKU.getDefaultState()
						.with(H_FACING, state.get(H_FACING))
						.with(STAGE_1_2, Integer.valueOf(2))); }
		}
		
		/** 出汁へ **/
		if (item == Items_Teatime.DASHI_bot_1) {
			if (i == 2) {
				CMEvents.Consume1Item_Splash(worldIn, pos, playerIn, hand);

				if (stack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE)); }
				else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE))) {
					playerIn.dropItem(new ItemStack(Items.GLASS_BOTTLE), false); }
				
				worldIn.setBlockState(pos, Dish_Blocks.ZUNDOU_DASHI.getDefaultState()
						.with(H_FACING, state.get(H_FACING))
						.with(BaseZundou_4Stage.STAGE_1_4, Integer.valueOf(1))); }
			
			/** Too early to use **/
			if (i != 2) { CMEvents.textEarlyUse(worldIn, pos, playerIn); }
		}
		
		/** うどん **/
		if (item == Items_Teatime.UDON_nama) {
			if (i == 2) {
				CMEvents.Consume1Item_Splash(worldIn, pos, playerIn, hand);
				
				worldIn.setBlockState(pos, Dish_Blocks.ZUNDOU_UDON.getDefaultState()
						.with(H_FACING, state.get(H_FACING))
						.with(BaseZundou_4Stage.STAGE_1_4, Integer.valueOf(1))); } //Large items cool it down.
		
			/** Too early to use **/
			if (i != 2) { CMEvents.textEarlyUse(worldIn, pos, playerIn); }
		}
		
		/** ラーメン**/
		if (item == Items_Teatime.RAMEN_nama) {
			if (i == 2) {
				CMEvents.Consume1Item_Splash(worldIn, pos, playerIn, hand);
				
				worldIn.setBlockState(pos, Dish_Blocks.ZUNDOU_RAMEN.getDefaultState()
						.with(H_FACING, state.get(H_FACING))
						.with(BaseZundou_4Stage.STAGE_1_4, Integer.valueOf(1))); } //Large items cool it down.
			
			/** Too early to use **/
			if (i != 2) { CMEvents.textEarlyUse(worldIn, pos, playerIn); }
		}
		
		if (item != Items_Teatime.SHIO && item != Items_Seasonal.WARAHAI && item != Items_Teatime.DASHI_bot_1 
				&& item != Items_Teatime.UDON_nama && item != Items_Teatime.RAMEN_nama) {
			CMEvents.textNotHave(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		int i = state.get(STAGE_1_2);
		/** 1=cold, 2=hot **/
		
		if (!inWater(state, worldIn, pos)) {
			if (i == 1) {
				if (isCooking(worldIn, pos)) {
					worldIn.getPendingBlockTicks().scheduleTick(pos, this, COOK_TIME + (20 * rand.nextInt(5)));
					worldIn.setBlockState(pos, state.with(STAGE_1_2, Integer.valueOf(2)), 3); }
				
				else { }
			}
			
			if (i != 1) {
				if (isCooking(worldIn, pos)) { }
				
				else {
					worldIn.getPendingBlockTicks().scheduleTick(pos, this, COOK_TIME);
					worldIn.setBlockState(pos, state.with(STAGE_1_2, Integer.valueOf(1)), 3); }
			}
		}
		
		if (inWater(state, worldIn, pos)) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, this, 60);
			CMEvents.soundBubble(worldIn, pos);
			worldIn.setBlockState(pos, Dish_Blocks.ZUNDOU.getDefaultState()
					.with(H_FACING, state.get(H_FACING))
					.with(Zundou.STAGE_1_2, Integer.valueOf(2))
					.with(Zundou.WATERLOGGED, state.get(WATERLOGGED)), 3); }
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_frypan").applyTextStyle(TextFormatting.GRAY));
	}
}
