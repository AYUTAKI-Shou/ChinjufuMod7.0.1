package com.ayutaki.chinjufumod.blocks.season;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.blocks.base.BaseStage4_Face;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class SnowMan_Bot3 extends Base_SnowManBot {

	/** TOP3 Yellow=5, Lime=6, Pink=7, Gray=8, **/
	public SnowMan_Bot3(String name) {
		super(name);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		
		if (item == Item.getItemFromBlock(Blocks.SNOW_LAYER)) {
			CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
			
			switch (i) {
			case 1 :
			default :
				worldIn.setBlockState(pos, Seasonal_Blocks.SNOWMAN_BOT3D.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1)), 3);
				break;

			case 2 :
				worldIn.setBlockState(pos, Seasonal_Blocks.SNOWMAN_BOT3D.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(2)), 3);
				break;

			case 3 :
				worldIn.setBlockState(pos, Seasonal_Blocks.SNOWMAN_BOT3D.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(3)), 3);
				break;
				
			case 4 :
				worldIn.setBlockState(pos, Seasonal_Blocks.SNOWMAN_BOT3D.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(4)), 3);
				break;
			} // switch
		}
		
		if (item != Item.getItemFromBlock(Blocks.SNOW_LAYER)) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		/** 'true' to not put anything on top. **/
		return true;
	}
	
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		
		/** TOP3 Yellow=5, Lime=6, Pink=7, Gray=8, **/
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (i == 1) { 
			stack.add(new ItemStack(Items_Seasonal.SNOWMAN));
			stack.add(new ItemStack(Items.CARROT));
			stack.add(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 4)); }
		if (i == 2) { 
			stack.add(new ItemStack(Items_Seasonal.SNOWMAN));
			stack.add(new ItemStack(Items.CARROT));
			stack.add(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 5)); }
		if (i == 3) { 
			stack.add(new ItemStack(Items_Seasonal.SNOWMAN));
			stack.add(new ItemStack(Items.CARROT));
			stack.add(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 6)); }
		if (i == 4) { 
			stack.add(new ItemStack(Items_Seasonal.SNOWMAN));
			stack.add(new ItemStack(Items.CARROT));
			stack.add(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 7)); }
		return stack;
	}

}
