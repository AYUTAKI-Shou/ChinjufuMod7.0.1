package com.ayutaki.chinjufumod.blocks.dish;

import java.util.Random;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class Zundou4_Fish extends BaseZundou_4LongCook {

	/** 1=raw-cold, 2=raw-hot, 3＝boiled-cold, 4=boiled-hot **/
	public Zundou4_Fish(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {
		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();

		int i = state.get(STAGE_1_4);
		/** 1=raw-cold, 2=raw-hot, 3＝boiled-cold, 4=boiled-hot **/

		if (item == Items.PAPER) {
			if (i == 3) {
				/** Collect with an Item **/
				CMEvents.Consume1Item_SnowB(worldIn, pos, playerIn, hand);
	
				if (stack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.NIBOSHI)); }
				else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.NIBOSHI))) {
					playerIn.dropItem(new ItemStack(Items_Teatime.NIBOSHI), false); }
	
				worldIn.setBlockState(pos, Dish_Blocks.ZUNDOU_SHIO.getDefaultState().with(H_FACING, state.get(H_FACING))
						.with(BaseZundou_2Cook.STAGE_1_2, Integer.valueOf(1))); }
	
			if (i == 4) {
				/** Collect with an Item **/
				CMEvents.Consume1Item_SnowB(worldIn, pos, playerIn, hand);
	
				if (stack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.NIBOSHI)); }
				else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.NIBOSHI))) {
					playerIn.dropItem(new ItemStack(Items_Teatime.NIBOSHI), false); }
	
				worldIn.setBlockState(pos, Dish_Blocks.ZUNDOU_SHIO.getDefaultState()
						.with(H_FACING, state.get(H_FACING))
						.with(BaseZundou_2Cook.STAGE_1_2, Integer.valueOf(2))
						.with(Zundou.WATERLOGGED, state.get(WATERLOGGED)), 3); }
			
			if (i != 3 && i != 4) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
		}
		
		if (item != Items.PAPER) { CMEvents.textNotHave(worldIn, pos, playerIn); }
	
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		int i = state.get(STAGE_1_4);
		/** 1=raw-cold, 2=raw-hot, 3＝boiled-cold, 4=boiled-hot **/
		
		if (!inWater(state, worldIn, pos)) {
			if (i == 1) {
				if (isCooking(worldIn, pos)) { 
					worldIn.getPendingBlockTicks().scheduleTick(pos, this, COOK_TIME + (20 * rand.nextInt(5)));
					worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(2)), 3); }
				
				else { } }
			
			if (i == 2) {
				if (isCooking(worldIn, pos)) { 
					worldIn.getPendingBlockTicks().scheduleTick(pos, this, COOK_TIME + (20 * rand.nextInt(5)));
					worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(4)), 3); }
				
				else { 
					worldIn.getPendingBlockTicks().scheduleTick(pos, this, COOK_TIME);
					worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(1)), 3); } }
			
			if (i == 3) {
				if (isCooking(worldIn, pos)) { 
					worldIn.getPendingBlockTicks().scheduleTick(pos, this, COOK_TIME + (20 * rand.nextInt(5)));
					worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(4)), 3); }
				
				else { } }
			
			else {
				if (isCooking(worldIn, pos)) { }
				
				else { 
					worldIn.getPendingBlockTicks().scheduleTick(pos, this, COOK_TIME);
					worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(3)), 3); } }
		}
		
		if (inWater(state, worldIn, pos)) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, this, 60);
			CMEvents.soundSnowBreak(worldIn, pos);
			worldIn.setBlockState(pos, Dish_Blocks.ZUNDOU.getDefaultState()
					.with(Zundou.H_FACING, state.get(H_FACING))
					.with(Zundou.STAGE_1_2, Integer.valueOf(2))
					.with(Zundou.WATERLOGGED, state.get(WATERLOGGED)), 3);
			this.dropRottenfood(worldIn, pos); }
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.ZUNDOU);
	}
}
