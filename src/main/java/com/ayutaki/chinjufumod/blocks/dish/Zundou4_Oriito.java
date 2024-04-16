package com.ayutaki.chinjufumod.blocks.dish;

import java.util.Random;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class Zundou4_Oriito extends BaseZundou_4LongCook {

	/** 1=raw-cold, 2=raw-hot, 3＝boiled-cold, 4=boiled-hot **/
	public Zundou4_Oriito(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		int i = state.getValue(STAGE_1_4);
		/** 1=raw-cold, 2=raw-hot, 3＝boiled-cold, 4=boiled-hot **/

		if (stack.isEmpty()) {
			
			if (i == 3) {	
				CMEvents.soundTake_Pick(worldIn, pos);	
				if (stack.isEmpty()) { playerIn.getInventory().add(new ItemStack(Items_Seasonal.ORIITO.get(), 10)); }
				else if (!playerIn.getInventory().add(new ItemStack(Items_Seasonal.ORIITO.get(), 10))) {
					playerIn.drop(new ItemStack(Items_Seasonal.ORIITO.get(), 10), false); }
	
				worldIn.setBlock(pos, Dish_Blocks.ZUNDOU_AKU.get().defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(BaseZundou_2Cook.STAGE_1_2, Integer.valueOf(1)), 3); }
	
			if (i == 4) {	
				CMEvents.soundTake_Pick(worldIn, pos);	
				if (stack.isEmpty()) { playerIn.getInventory().add(new ItemStack(Items_Seasonal.ORIITO.get(), 10)); }
				else if (!playerIn.getInventory().add(new ItemStack(Items_Seasonal.ORIITO.get(), 10))) {
					playerIn.drop(new ItemStack(Items_Seasonal.ORIITO.get(), 10), false); }
	
				worldIn.setBlock(pos, Dish_Blocks.ZUNDOU_AKU.get().defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(BaseZundou_2Cook.STAGE_1_2, Integer.valueOf(2)), 3); }
			
			if (i != 3 && i != 4) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
		}
		
		if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return InteractionResult.SUCCESS;
	}
	
	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, Random rand) {
		int i = state.getValue(STAGE_1_4);
		/** 1=raw-cold, 2=raw-hot, 3＝boiled-cold, 4=boiled-hot **/

		if (!inWater(state, worldIn, pos)) {
			if (i == 1) {
				if (isCooking(worldIn, pos)) { 
					worldIn.scheduleTick(pos, this, COOK_TIME + (20 * rand.nextInt(5)));
					worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(2)), 3); }
				
				else { } }
			
			if (i == 2) {
				if (isCooking(worldIn, pos)) { 
					worldIn.scheduleTick(pos, this, COOK_TIME + (20 * rand.nextInt(5)));
					worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(4)), 3); }
				
				else { 
					worldIn.scheduleTick(pos, this, COOK_TIME);
					worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(1)), 3); } }
			
			if (i == 3) {
				if (isCooking(worldIn, pos)) { 
					worldIn.scheduleTick(pos, this, COOK_TIME + (20 * rand.nextInt(5)));
					worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(4)), 3); }
				
				else { } }
			
			else {
				if (isCooking(worldIn, pos)) { }
				
				else { 
					worldIn.scheduleTick(pos, this, COOK_TIME);
					worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(3)), 3); } }
		}
		
		if (inWater(state, worldIn, pos)) {
			worldIn.scheduleTick(pos, this, 60);
			CMEvents.soundSnowBreak(worldIn, pos);
			worldIn.setBlock(pos, Dish_Blocks.ZUNDOU.get().defaultBlockState()
					.setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Zundou.STAGE_1_2, Integer.valueOf(2))
					.setValue(Zundou.WATERLOGGED, state.getValue(WATERLOGGED)), 3); }
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Seasonal.ZUNDOU_AKU.get());
	}
}
