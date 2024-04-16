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

public class Zundou4_Udon extends BaseZundou_4Cook {

	/** 1=raw-cold, 2=raw-hot, 3＝boiled-cold, 4=boiled-hot **/
	public Zundou4_Udon(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {
		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();

		int i = state.get(STAGE_1_4);
		/** 1=raw-cold, 2=raw-hot, 3＝boiled-cold, 4=boiled-hot **/

		if (item == Items_Teatime.TSUYU_donburi) {
			if (i == 3) {
				/** Collect with an Item **/
				CMEvents.Consume1Item_SnowB(worldIn, pos, playerIn, hand);
	
				/** Get EXP. **/
				worldIn.addEntity(new ExperienceOrbEntity(worldIn, pos.getX(), pos.getY() + 0.5D, pos.getZ(), 1));
	
				if (stack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.UDON_SU)); }
				else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.UDON_SU))) {
					playerIn.dropItem(new ItemStack(Items_Teatime.UDON_SU), false); }
	
				worldIn.setBlockState(pos, Dish_Blocks.ZUNDOU_MIZU.getDefaultState().with(H_FACING, state.get(H_FACING))
						.with(BaseZundou_2Cook.STAGE_1_2, Integer.valueOf(1))); }
	
			if (i == 4) {
				/** Collect with an Item **/
				CMEvents.Consume1Item_SnowB(worldIn, pos, playerIn, hand);
	
				/** Get EXP. **/
				worldIn.addEntity(new ExperienceOrbEntity(worldIn, pos.getX(), pos.getY() + 0.5D, pos.getZ(), 1));
	
				if (stack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.UDON_SU)); }
				else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.UDON_SU))) {
					playerIn.dropItem(new ItemStack(Items_Teatime.UDON_SU), false); }
	
				worldIn.setBlockState(pos, Dish_Blocks.ZUNDOU_MIZU.getDefaultState().with(H_FACING, state.get(H_FACING))
						.with(BaseZundou_2Cook.STAGE_1_2, Integer.valueOf(2))); }
			
			if (i != 3 && i != 4) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
		}
		
		if (item != Items_Teatime.TSUYU_donburi) { CMEvents.textNotHave(worldIn, pos, playerIn); }
	
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}
}
