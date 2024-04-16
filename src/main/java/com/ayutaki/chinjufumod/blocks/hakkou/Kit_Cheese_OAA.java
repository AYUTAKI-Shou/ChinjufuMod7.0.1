package com.ayutaki.chinjufumod.blocks.hakkou;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.ayutaki.chinjufumod.blocks.base.BaseStage3_Face;
import com.ayutaki.chinjufumod.blocks.base.BaseStage4_Face;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Kit_Cheese_OAA extends BaseCheese_Tana {

	/* stage1=OAA, stage2=OBA, stage3=OBB */
	public Kit_Cheese_OAA(String name) {
		super(name);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side,
			float hitX, float hitY, float hitZ) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		int i = ((Integer)state.getValue(STAGE_1_3)).intValue();

		/** Hand is empty. **/
		if (stack.isEmpty() && item != Items_Teatime.CHEESE_CURD && item != Items_Teatime.CHEESE) {
			/** stage1=OAA **/
			if (i == 1) {
				CMEvents.soundTake_Pick(worldIn, pos);
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.CHEESE_CURD));

				worldIn.setBlockState(pos, Kitchen_Blocks.CHEESE_TANA.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(2))); } /* -> OOA */
			
			/** stage2=OBA **/
			if (i == 2) {
				CMEvents.soundTake_Pick(worldIn, pos);
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.CHEESE));

				worldIn.setBlockState(pos, Kitchen_Blocks.CHEESE_TANA.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(2))); } /* -> OOA */
			
			/** stage3=OBB **/
			if (i == 3) {
				CMEvents.soundTake_Pick(worldIn, pos);
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.CHEESE));

				worldIn.setBlockState(pos, Kitchen_Blocks.CHEESE_TANA.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3))); } /* -> OOB */

		}
		
		/** Hand is not empty. **/
		if (!stack.isEmpty()) {
			if (item == Items_Teatime.CHEESE_CURD) {
				if (i == 1) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);

					worldIn.setBlockState(pos, Kitchen_Blocks.CHEESE_AAA.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1))); } /* -> AAA */
				
				if (i == 2) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);

					worldIn.setBlockState(pos, Kitchen_Blocks.CHEESE_AAA.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(2))); } /* -> BAA */
				
				if (i == 3) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);

					worldIn.setBlockState(pos, Kitchen_Blocks.CHEESE_AAA.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(3))); } /* -> BBA */
			}
			
			if (item == Items_Teatime.CHEESE) {
				if (i == 1 && item == Items_Teatime.CHEESE) {
					CMEvents.Consume1Item_Cheese(worldIn, pos, playerIn, hand);
					
					worldIn.setBlockState(pos, Kitchen_Blocks.CHEESE_AAA.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(2))); } /* -> BAA */
				
				if (i == 2 && item == Items_Teatime.CHEESE) {
					CMEvents.Consume1Item_Cheese(worldIn, pos, playerIn, hand);
					
					worldIn.setBlockState(pos, Kitchen_Blocks.CHEESE_AAA.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(3))); } /* -> BBA */
				
				if (i == 3 && item == Items_Teatime.CHEESE) {
					CMEvents.Consume1Item_Cheese(worldIn, pos, playerIn, hand);
					
					worldIn.setBlockState(pos, Kitchen_Blocks.CHEESE_AAA.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(4))); } /* -> BBB */
			}
			
			if (item != Items_Teatime.CHEESE_CURD && item != Items_Teatime.CHEESE) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}

		/** 'true' to not put anything on top. **/
		return true;
	}

	/* TickRandom */
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		super.updateTick(worldIn, pos, state, rand);

		/* stage1=OAA, stage2=OBA, stage3=OBB */
		int i = ((Integer)state.getValue(STAGE_1_3)).intValue();

		if (i != 3) { worldIn.setBlockState(pos, state.withProperty(STAGE_1_3, Integer.valueOf(i + 1))); }
		if (i == 3) { }

		worldIn.scheduleUpdate(pos, Kitchen_Blocks.CHEESE_OAA, this.tickRate(worldIn) + (500 * rand.nextInt(5)));
	}

	/* Drop Item and Clone Item. */
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		/* stage1=OAA, stage2=OBA, stage3=OBB */
		int i = ((Integer)state.getValue(STAGE_1_3)).intValue();

		if (i == 1) { stack.add(new ItemStack(Items_Teatime.CHEESE_TANA, 1, 0));
							stack.add(new ItemStack(Items_Teatime.CHEESE_CURD, 2, 0)); }

		if (i == 2) { stack.add(new ItemStack(Items_Teatime.CHEESE_TANA, 1, 0));
							stack.add(new ItemStack(Items_Teatime.CHEESE_CURD, 1, 0));
							stack.add(new ItemStack(Items_Teatime.CHEESE, 1, 0)); }

		if (i == 3) { stack.add(new ItemStack(Items_Teatime.CHEESE_TANA, 1, 0));
							stack.add(new ItemStack(Items_Teatime.CHEESE, 2, 0)); }
		return stack;
	}
}
