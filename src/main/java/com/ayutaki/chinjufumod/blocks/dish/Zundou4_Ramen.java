package com.ayutaki.chinjufumod.blocks.dish;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class Zundou4_Ramen extends BaseZundou_4Cook {

	/** 1=raw-cold, 2=raw-hot, 3＝boiled-cold, 4=boiled-hot **/
	public Zundou4_Ramen(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();

		int i = state.getValue(STAGE_1_4);
		
		if (item != Items_Teatime.SHOUYU_Rsoup.get() && item != Items_Teatime.MISO_Rsoup.get() && item != Items_Teatime.SHIO_Rsoup.get() &&
				item != Items_Teatime.RAMEN_SHOUYU.get() && item != Items_Teatime.RAMEN_MISO.get() && item != Items_Teatime.RAMEN_SHIO.get() && 
				item != Items_Teatime.RAMEN_nama.get() && item != Items_Teatime.SARA.get()) {
			CMEvents.textNotHave(worldIn, pos, playerIn); }
		
		/** 1=raw-cold, 2=raw-hot, 3＝boiled-cold, 4=boiled-hot **/
		else {
	
			if (i == 3 || i == 4) { 
				if (item == Items_Teatime.SHOUYU_Rsoup.get()) {
					/** Collect with an Item **/
					CMEvents.Consume1Item_SnowB(worldIn, pos, playerIn, hand);
					/** Get EXP. **/
					worldIn.addFreshEntity(new ExperienceOrb(worldIn, pos.getX(), pos.getY() + 0.5D, pos.getZ(), 1));
					
					if (stack.isEmpty()) { playerIn.getInventory().add(new ItemStack(Items_Teatime.RAMEN_SHOUYU.get(), 1)); }
					else if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.RAMEN_SHOUYU.get(), 1))) {
						playerIn.drop(new ItemStack(Items_Teatime.RAMEN_SHOUYU.get(), 1), false); }
					
					worldIn.setBlock(pos, Dish_Blocks.ZUNDOU_MIZU.get().defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(BaseZundou_2Cook.STAGE_1_2, Integer.valueOf(i - 2)), 3); }
				
				if (item == Items_Teatime.MISO_Rsoup.get()) {
					CMEvents.Consume1Item_SnowB(worldIn, pos, playerIn, hand);
					/** Get EXP. **/
					worldIn.addFreshEntity(new ExperienceOrb(worldIn, pos.getX(), pos.getY() + 0.5D, pos.getZ(), 1));
					
					if (stack.isEmpty()) { playerIn.getInventory().add(new ItemStack(Items_Teatime.RAMEN_MISO.get(), 1)); }
					else if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.RAMEN_MISO.get(), 1))) {
						playerIn.drop(new ItemStack(Items_Teatime.RAMEN_MISO.get(), 1), false); }
					
					worldIn.setBlock(pos, Dish_Blocks.ZUNDOU_MIZU.get().defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(BaseZundou_2Cook.STAGE_1_2, Integer.valueOf(i - 2)), 3); }
				
				if (item == Items_Teatime.SHIO_Rsoup.get()) {
					CMEvents.Consume1Item_SnowB(worldIn, pos, playerIn, hand);
					/** Get EXP. **/
					worldIn.addFreshEntity(new ExperienceOrb(worldIn, pos.getX(), pos.getY() + 0.5D, pos.getZ(), 1));
					
					if (stack.isEmpty()) { playerIn.getInventory().add(new ItemStack(Items_Teatime.RAMEN_SHIO.get(), 1)); }
					else if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.RAMEN_SHIO.get(), 1))) {
						playerIn.drop(new ItemStack(Items_Teatime.RAMEN_SHIO.get(), 1), false); }
					
					worldIn.setBlock(pos, Dish_Blocks.ZUNDOU_MIZU.get().defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(BaseZundou_2Cook.STAGE_1_2, Integer.valueOf(i - 2)), 3); } 
				
				if (item == Items_Teatime.SARA.get()) {
					CMEvents.Consume1Item_SnowB(worldIn, pos, playerIn, hand);
					
					if (stack.isEmpty()) { playerIn.getInventory().add(new ItemStack(Items_Teatime.SOBA_PLATE.get(), 1)); }
					else if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.SOBA_PLATE.get(), 1))) {
						playerIn.drop(new ItemStack(Items_Teatime.SOBA_PLATE.get(), 1), false); }
					
					worldIn.setBlock(pos, Dish_Blocks.ZUNDOU_MIZU.get().defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(BaseZundou_2Cook.STAGE_1_2, Integer.valueOf(i - 2)), 3); } 
				
				else { }
			}
				
			if (i != 3 && i != 4) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
		}
		
		/** SUCCESS to not put anything on top. **/
		return InteractionResult.SUCCESS;
	}
}
