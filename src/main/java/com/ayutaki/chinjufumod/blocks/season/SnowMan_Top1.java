package com.ayutaki.chinjufumod.blocks.season;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SnowMan_Top1 extends Base_SnowManTop {

	/** TOP1 1=normai, 2=carrot, 3=Roma, 4=blank **/
	public SnowMan_Top1(String name) {
		super(name);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		int k = stack.getMetadata();
		
		/** TOP1 1=normai, 2=carrot, 3=Roma, 4=blank **/
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		Block downBlock = worldIn.getBlockState(pos.down()).getBlock();
		
		IBlockState downState1 = Seasonal_Blocks.SNOWMAN_BOT1.getDefaultState()
				.withProperty(Base_SnowManBot.H_FACING, state.getValue(H_FACING));
		IBlockState downState1d = Seasonal_Blocks.SNOWMAN_BOT1D.getDefaultState()
				.withProperty(Base_SnowManBot.H_FACING, state.getValue(H_FACING));
		
		boolean mode = playerIn.capabilities.isCreativeMode;
		
		IBlockState colorUp2 = Seasonal_Blocks.SNOWMAN_TOP2.getDefaultState()
				.withProperty(Base_SnowManTop.H_FACING, state.getValue(H_FACING));
		IBlockState colorUp3 = Seasonal_Blocks.SNOWMAN_TOP3.getDefaultState()
				.withProperty(Base_SnowManTop.H_FACING, state.getValue(H_FACING));
		IBlockState colorUp4 = Seasonal_Blocks.SNOWMAN_TOP4.getDefaultState()
				.withProperty(Base_SnowManTop.H_FACING, state.getValue(H_FACING));
		IBlockState colorUp5 = Seasonal_Blocks.SNOWMAN_TOP5.getDefaultState()
				.withProperty(Base_SnowManTop.H_FACING, state.getValue(H_FACING));
		
		IBlockState colorDown2 = Seasonal_Blocks.SNOWMAN_BOT2.getDefaultState()
				.withProperty(Base_SnowManBot.H_FACING, state.getValue(H_FACING));
		IBlockState colorDown3 = Seasonal_Blocks.SNOWMAN_BOT3.getDefaultState()
				.withProperty(Base_SnowManBot.H_FACING, state.getValue(H_FACING));
		IBlockState colorDown4 = Seasonal_Blocks.SNOWMAN_BOT4.getDefaultState()
				.withProperty(Base_SnowManBot.H_FACING, state.getValue(H_FACING));
		IBlockState colorDown5 = Seasonal_Blocks.SNOWMAN_BOT5.getDefaultState()
				.withProperty(Base_SnowManBot.H_FACING, state.getValue(H_FACING));
		
		IBlockState colorDown2d = Seasonal_Blocks.SNOWMAN_BOT2D.getDefaultState()
				.withProperty(Base_SnowManBot.H_FACING, state.getValue(H_FACING));
		IBlockState colorDown3d = Seasonal_Blocks.SNOWMAN_BOT3D.getDefaultState()
				.withProperty(Base_SnowManBot.H_FACING, state.getValue(H_FACING));
		IBlockState colorDown4d = Seasonal_Blocks.SNOWMAN_BOT4D.getDefaultState()
				.withProperty(Base_SnowManBot.H_FACING, state.getValue(H_FACING));
		IBlockState colorDown5d = Seasonal_Blocks.SNOWMAN_BOT5D.getDefaultState()
				.withProperty(Base_SnowManBot.H_FACING, state.getValue(H_FACING));
		
		if (downBlock != Seasonal_Blocks.SNOWMAN_BOT1D) {
			switch (i) {
			case 1 :
			default :
				if (item == Items.CARROT) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(2)), 3);
					worldIn.setBlockState(pos.down(), downState1.withProperty(STAGE_1_4, Integer.valueOf(2)), 3); }
				
				if (item != Items.CARROT) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				break;

				
			case 2 :
				if (item == Items_Teatime.FOOD_TOMATO) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(3)), 3);
					worldIn.setBlockState(pos.down(), downState1.withProperty(STAGE_1_4, Integer.valueOf(3)), 3); }
				
				if (item == Items.BUCKET) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(4)), 3);
					worldIn.setBlockState(pos.down(), downState1.withProperty(STAGE_1_4, Integer.valueOf(4)), 3); }
				
				/** TOP1 1=normai, 2=carrot, 3=Roma, 4=blank **/
				/** TOP2 White=1, Orange=2, Magenta=3, LightBlue=4 **/
				/** TOP3 Yellow=5, Lime=6, Pink=7, Gray=8, **/
				/** TOP4 LightGray=9, Cyan=10, Purple=11, Blue=12 **/
				/** TOP5 Brown=13, Green=14, Red=15, Black=16 **/
				if (item == Item.getItemFromBlock(Blocks.WOOL)) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					
					switch (k) {
					case 0 :
					default :
						worldIn.setBlockState(pos, colorUp2.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(1)), 3);
						worldIn.setBlockState(pos.down(), colorDown2.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(1)), 3);
						break;

					case 1 :
						worldIn.setBlockState(pos, colorUp2.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(2)), 3);
						worldIn.setBlockState(pos.down(), colorDown2.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(2)), 3);
						break;

					case 2 :
						worldIn.setBlockState(pos, colorUp2.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(3)), 3);
						worldIn.setBlockState(pos.down(), colorDown2.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(3)), 3);
						break;
						
					case 3 :
						worldIn.setBlockState(pos, colorUp2.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(4)), 3);
						worldIn.setBlockState(pos.down(), colorDown2.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(4)), 3);
						break;
						
					case 4 :
						worldIn.setBlockState(pos, colorUp3.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(1)), 3);
						worldIn.setBlockState(pos.down(), colorDown3.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(1)), 3);
						break;

					case 5 :
						worldIn.setBlockState(pos, colorUp3.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(2)), 3);
						worldIn.setBlockState(pos.down(), colorDown3.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(2)), 3);
						break;
						
					case 6 :
						worldIn.setBlockState(pos, colorUp3.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(3)), 3);
						worldIn.setBlockState(pos.down(), colorDown3.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(3)), 3);
						break;
						
					case 7 :
						worldIn.setBlockState(pos, colorUp3.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(4)), 3);
						worldIn.setBlockState(pos.down(), colorDown3.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(4)), 3);
						break;

					case 8 :
						worldIn.setBlockState(pos, colorUp4.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(1)), 3);
						worldIn.setBlockState(pos.down(), colorDown4.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(1)), 3);
						break;
						
					case 9 :
						worldIn.setBlockState(pos, colorUp4.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(2)), 3);
						worldIn.setBlockState(pos.down(), colorDown4.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(2)), 3);
						break;
						
					case 10 :
						worldIn.setBlockState(pos, colorUp4.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(3)), 3);
						worldIn.setBlockState(pos.down(), colorDown4.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(3)), 3);
						break;
						
					case 11 :
						worldIn.setBlockState(pos, colorUp4.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(4)), 3);
						worldIn.setBlockState(pos.down(), colorDown4.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(4)), 3);
						break;

					case 12 :
						worldIn.setBlockState(pos, colorUp5.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(1)), 3);
						worldIn.setBlockState(pos.down(), colorDown5.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(1)), 3);
						break;
						
					case 13 :
						worldIn.setBlockState(pos, colorUp5.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(2)), 3);
						worldIn.setBlockState(pos.down(), colorDown5.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(2)), 3);
						break;

					case 14 :
						worldIn.setBlockState(pos, colorUp5.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(3)), 3);
						worldIn.setBlockState(pos.down(), colorDown5.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(3)), 3);
						break;

					case 15 :
						worldIn.setBlockState(pos, colorUp5.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(4)), 3);
						worldIn.setBlockState(pos.down(), colorDown5.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(4)), 3);
						break;
					} 
				} // switch k=0-15
				
				if (item != Items_Teatime.FOOD_TOMATO && item != Items.BUCKET && item != Item.getItemFromBlock(Blocks.WOOL)) {
					CMEvents.textNotHave(worldIn, pos, playerIn); }
				break;
				
			case 3 :
				if (stack.isEmpty()) {
					CMEvents.soundSnowBreak(worldIn, pos);
					
					if (!mode) {
						if (stack.isEmpty()) { 
							playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.FOOD_TOMATO)); }
						else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.FOOD_TOMATO))) {
							playerIn.dropItem(new ItemStack(Items_Teatime.FOOD_TOMATO), false); } }
					if (mode) { } 
				
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(2)), 3);
					worldIn.setBlockState(pos.down(), downState1.withProperty(STAGE_1_4, Integer.valueOf(2)), 3); }
				
				if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
				break;
				
			case 4 :
				if (stack.isEmpty()) {
					CMEvents.soundSnowBreak(worldIn, pos);
					
					if (!mode) {
						if (stack.isEmpty()) { 
							playerIn.inventory.addItemStackToInventory(new ItemStack(Items.BUCKET)); }
						else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.BUCKET))) {
							playerIn.dropItem(new ItemStack(Items.BUCKET), false); } }
					if (mode) { } 
				
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(2)), 3);
					worldIn.setBlockState(pos.down(), downState1.withProperty(STAGE_1_4, Integer.valueOf(2)), 3); }
				
				if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
				break;
			} // STAGE1_4
		} // != Seasonal_Blocks.SNOWMAN_BOT1D
		
		
		if (downBlock == Seasonal_Blocks.SNOWMAN_BOT1D) {
			switch (i) {
			case 1 :
			default :
				if (item == Items.CARROT) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(2)), 3);
					worldIn.setBlockState(pos.down(), downState1d.withProperty(STAGE_1_4, Integer.valueOf(2)), 3); }
				
				if (item != Items.CARROT) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				break;

			case 2 :
				if (item == Items_Teatime.FOOD_TOMATO) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(3)), 3);
					worldIn.setBlockState(pos.down(), downState1d.withProperty(STAGE_1_4, Integer.valueOf(3)), 3); }
				
				if (item == Items.BUCKET) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(4)), 3);
					worldIn.setBlockState(pos.down(), downState1d.withProperty(STAGE_1_4, Integer.valueOf(4)), 3); }

				/** TOP1 1=normai, 2=carrot, 3=Roma, 4=blank **/
				/** TOP2 White=1, Orange=2, Magenta=3, LightBlue=4 **/
				/** TOP3 Yellow=5, Lime=6, Pink=7, Gray=8, **/
				/** TOP4 LightGray=9, Cyan=10, Purple=11, Blue=12 **/
				/** TOP5 Brown=13, Green=14, Red=15, Black=16 **/
				if (item == Item.getItemFromBlock(Blocks.WOOL)) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					
					switch (k) {
					case 0 :
					default :
						worldIn.setBlockState(pos, colorUp2.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(1)), 3);
						worldIn.setBlockState(pos.down(), colorDown2d.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(1)), 3);
						break;

					case 1 :
						worldIn.setBlockState(pos, colorUp2.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(2)), 3);
						worldIn.setBlockState(pos.down(), colorDown2d.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(2)), 3);
						break;

					case 2 :
						worldIn.setBlockState(pos, colorUp2.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(3)), 3);
						worldIn.setBlockState(pos.down(), colorDown2d.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(3)), 3);
						break;
						
					case 3 :
						worldIn.setBlockState(pos, colorUp2.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(4)), 3);
						worldIn.setBlockState(pos.down(), colorDown2d.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(4)), 3);
						break;
						
					case 4 :
						worldIn.setBlockState(pos, colorUp3.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(1)), 3);
						worldIn.setBlockState(pos.down(), colorDown3d.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(1)), 3);
						break;

					case 5 :
						worldIn.setBlockState(pos, colorUp3.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(2)), 3);
						worldIn.setBlockState(pos.down(), colorDown3d.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(2)), 3);
						break;
						
					case 6 :
						worldIn.setBlockState(pos, colorUp3.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(3)), 3);
						worldIn.setBlockState(pos.down(), colorDown3d.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(3)), 3);
						break;
						
					case 7 :
						worldIn.setBlockState(pos, colorUp3.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(4)), 3);
						worldIn.setBlockState(pos.down(), colorDown3d.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(4)), 3);
						break;

					case 8 :
						worldIn.setBlockState(pos, colorUp4.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(1)), 3);
						worldIn.setBlockState(pos.down(), colorDown4d.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(1)), 3);
						break;
						
					case 9 :
						worldIn.setBlockState(pos, colorUp4.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(2)), 3);
						worldIn.setBlockState(pos.down(), colorDown4d.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(2)), 3);
						break;
						
					case 10 :
						worldIn.setBlockState(pos, colorUp4.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(3)), 3);
						worldIn.setBlockState(pos.down(), colorDown4d.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(3)), 3);
						break;
						
					case 11 :
						worldIn.setBlockState(pos, colorUp4.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(4)), 3);
						worldIn.setBlockState(pos.down(), colorDown4d.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(4)), 3);
						break;

					case 12 :
						worldIn.setBlockState(pos, colorUp5.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(1)), 3);
						worldIn.setBlockState(pos.down(), colorDown5d.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(1)), 3);
						break;
						
					case 13 :
						worldIn.setBlockState(pos, colorUp5.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(2)), 3);
						worldIn.setBlockState(pos.down(), colorDown5d.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(2)), 3);
						break;

					case 14 :
						worldIn.setBlockState(pos, colorUp5.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(3)), 3);
						worldIn.setBlockState(pos.down(), colorDown5d.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(3)), 3);
						break;

					case 15 :
						worldIn.setBlockState(pos, colorUp5.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(4)), 3);
						worldIn.setBlockState(pos.down(), colorDown5d.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(4)), 3);
						break;
					}
				} // switch k=0-15
				
				if (item != Items_Teatime.FOOD_TOMATO && item != Items.BUCKET && item != Item.getItemFromBlock(Blocks.WOOL)) {
					CMEvents.textNotHave(worldIn, pos, playerIn); }
				break;
				
			case 3 :
				if (stack.isEmpty()) {
					CMEvents.soundSnowBreak(worldIn, pos);
					
					if (!mode) {
						if (stack.isEmpty()) { 
							playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.FOOD_TOMATO)); }
						else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.FOOD_TOMATO))) {
							playerIn.dropItem(new ItemStack(Items_Teatime.FOOD_TOMATO), false); } }
					if (mode) { } 
				
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(2)), 3);
					worldIn.setBlockState(pos.down(), downState1d.withProperty(STAGE_1_4, Integer.valueOf(2)), 3); }
				
				if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
				break;
				
			case 4 :
				if (stack.isEmpty()) {
					CMEvents.soundSnowBreak(worldIn, pos);
					
					if (!mode) {
						if (stack.isEmpty()) { 
							playerIn.inventory.addItemStackToInventory(new ItemStack(Items.BUCKET)); }
						else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.BUCKET))) {
							playerIn.dropItem(new ItemStack(Items.BUCKET), false); } }
					if (mode) { } 
				
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(2)), 3);
					worldIn.setBlockState(pos.down(), downState1d.withProperty(STAGE_1_4, Integer.valueOf(2)), 3); }
				
				if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
				break;
			} // STAGE1_4
		} // == Seasonal_Blocks.SNOWMAN_BOT1D
		
		/** 'true' to not put anything on top. **/
		return true;
	}
}
