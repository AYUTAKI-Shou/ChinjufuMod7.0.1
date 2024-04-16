package com.ayutaki.chinjufumod.blocks.season;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SnowMan_Top4 extends Base_SnowManTop {

	/** TOP4 LightGray=8, Cyan=9, Purple=10, Blue=11 **/
	public SnowMan_Top4(String name) {
		super(name);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		ItemStack stack = playerIn.getHeldItem(hand);
		IBlockState downState = worldIn.getBlockState(pos.down());
		Block downBlock = downState.getBlock();
		boolean mode = playerIn.capabilities.isCreativeMode;
		
		if (stack.isEmpty()) {
			CMEvents.soundSnowBreak(worldIn, pos);
			worldIn.setBlockState(pos, Seasonal_Blocks.SNOWMAN_TOP1.getDefaultState()
					.withProperty(Base_SnowManTop.H_FACING, state.getValue(H_FACING))
					.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(2)), 3);
			
			if (downBlock != Seasonal_Blocks.SNOWMAN_BOT4D) {
				worldIn.setBlockState(pos.down(), Seasonal_Blocks.SNOWMAN_BOT1.getDefaultState()
						.withProperty(Base_SnowManBot.H_FACING, state.getValue(H_FACING))
						.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(2)), 3); } 
			if (downBlock == Seasonal_Blocks.SNOWMAN_BOT4D) {
				worldIn.setBlockState(pos.down(), Seasonal_Blocks.SNOWMAN_BOT1D.getDefaultState()
						.withProperty(Base_SnowManBot.H_FACING, state.getValue(H_FACING))
						.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(2)), 3); }
			
			if (mode) { }
			
			if (!mode) {
				if (stack.isEmpty()) { playerIn.inventory.addItemStackToInventory(this.takeWool(state)); }
				else if (!playerIn.inventory.addItemStackToInventory(this.takeWool(state))) { playerIn.dropItem(this.takeWool(state), false); }
			} //!mode
		}
		
		if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		
		/** 'true' to not put anything on top. **/
		return true;
	}

	private ItemStack takeWool(IBlockState state) {
		/** TOP4 LightGray=8, Cyan=9, Purple=10, Blue=11 **/
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		if (i == 1) { return new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 8); }
		if (i == 2) { return new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 9); }
		if (i == 3) { return new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 10); }
		if (i == 4) { return new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 11); }
		return null;
	}
}
