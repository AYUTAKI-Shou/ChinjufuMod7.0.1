package com.ayutaki.chinjufumod.blocks.dish;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class Zundou4_Ramen extends BaseZundou_4Cook {

	/** 1=raw-cold, 2=raw-hot, 3＝boiled-cold, 4=boiled-hot **/
	public Zundou4_Ramen(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {
		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();

		int i = state.get(STAGE_1_4);
		
		if (item != Items_Teatime.SHOUYU_Rsoup && item != Items_Teatime.MISO_Rsoup && item != Items_Teatime.SHIO_Rsoup &&
				item != Items_Teatime.RAMEN_SHOUYU && item != Items_Teatime.RAMEN_MISO && item != Items_Teatime.RAMEN_SHIO && 
				item != Items_Teatime.RAMEN_nama && item != Items_Teatime.SARA && item != Items_Teatime.SOBA_PLATE) {
			CMEvents.textNotHave(worldIn, pos, playerIn); }
		
		/** 1=raw-cold, 2=raw-hot, 3＝boiled-cold, 4=boiled-hot **/
		else {
	
			if (i == 3 || i == 4) { 
				if (item == Items_Teatime.SHOUYU_Rsoup) {
					/** Collect with an Item **/
					CMEvents.Consume1Item_SnowB(worldIn, pos, playerIn, hand);
					/** Get EXP. **/
					worldIn.addEntity(new ExperienceOrbEntity(worldIn, pos.getX(), pos.getY() + 0.5D, pos.getZ(), 1));
					
					if (stack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.RAMEN_SHOUYU, 1)); }
					else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.RAMEN_SHOUYU, 1))) {
						playerIn.dropItem(new ItemStack(Items_Teatime.RAMEN_SHOUYU, 1), false); }
					
					worldIn.setBlockState(pos, Dish_Blocks.ZUNDOU_MIZU.getDefaultState()
							.with(H_FACING, state.get(H_FACING))
							.with(BaseZundou_2Cook.STAGE_1_2, Integer.valueOf(i - 2)), 3); }
				
				if (item == Items_Teatime.MISO_Rsoup) {
					CMEvents.Consume1Item_SnowB(worldIn, pos, playerIn, hand);
					/** Get EXP. **/
					worldIn.addEntity(new ExperienceOrbEntity(worldIn, pos.getX(), pos.getY() + 0.5D, pos.getZ(), 1));
					
					if (stack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.RAMEN_MISO, 1)); }
					else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.RAMEN_MISO, 1))) {
						playerIn.dropItem(new ItemStack(Items_Teatime.RAMEN_MISO, 1), false); }
					
					worldIn.setBlockState(pos, Dish_Blocks.ZUNDOU_MIZU.getDefaultState()
							.with(H_FACING, state.get(H_FACING))
							.with(BaseZundou_2Cook.STAGE_1_2, Integer.valueOf(i - 2)), 3); }
				
				if (item == Items_Teatime.SHIO_Rsoup) {
					CMEvents.Consume1Item_SnowB(worldIn, pos, playerIn, hand);
					/** Get EXP. **/
					worldIn.addEntity(new ExperienceOrbEntity(worldIn, pos.getX(), pos.getY() + 0.5D, pos.getZ(), 1));
					
					if (stack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.RAMEN_SHIO, 1)); }
					else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.RAMEN_SHIO, 1))) {
						playerIn.dropItem(new ItemStack(Items_Teatime.RAMEN_SHIO, 1), false); }
					
					worldIn.setBlockState(pos, Dish_Blocks.ZUNDOU_MIZU.getDefaultState()
							.with(H_FACING, state.get(H_FACING))
							.with(BaseZundou_2Cook.STAGE_1_2, Integer.valueOf(i - 2)), 3); } 
				
				if (item == Items_Teatime.SARA) {
					CMEvents.Consume1Item_SnowB(worldIn, pos, playerIn, hand);
					
					if (stack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SOBA_PLATE, 1)); }
					else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SOBA_PLATE, 1))) {
						playerIn.dropItem(new ItemStack(Items_Teatime.SOBA_PLATE, 1), false); }
					
					worldIn.setBlockState(pos, Dish_Blocks.ZUNDOU_MIZU.getDefaultState()
							.with(H_FACING, state.get(H_FACING))
							.with(BaseZundou_2Cook.STAGE_1_2, Integer.valueOf(i - 2)), 3); } 
				
				else { }
			}
				
			if (i != 3 && i != 4) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
		}
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}
}
