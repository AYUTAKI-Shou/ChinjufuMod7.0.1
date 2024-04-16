package com.ayutaki.chinjufumod.items.chinjufu;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.base.BaseFacingSlabW;
import com.ayutaki.chinjufumod.blocks.base.BaseSlabW;
import com.ayutaki.chinjufumod.blocks.base.BaseSlabWType2;
import com.ayutaki.chinjufumod.blocks.furniture.LightEmbed;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.Lamp_Blocks;
import com.ayutaki.chinjufumod.state.SlabHalf;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfStoneSlab;
import net.minecraft.block.BlockHalfStoneSlabNew;
import net.minecraft.block.BlockHalfWoodSlab;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LightEmbed_Item extends ItemBlockBace {

	public LightEmbed_Item(String name, Block putBlock) {
		super(name, putBlock);
		setUnlocalizedName(name);
		setCreativeTab(ChinjufuModTabs.CHINJUFU);
	}

	/* Place block */
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {

		IBlockState state = worldIn.getBlockState(pos);
		Block block = state.getBlock();

		if (!block.isReplaceable(worldIn, pos)) { pos = pos.offset(facing); }

		ItemStack stack = playerIn.getHeldItem(hand);

		if (!stack.isEmpty() && playerIn.canPlayerEdit(pos, facing, stack) && worldIn.mayPlace(Lamp_Blocks.E_LIGHT, pos, false, facing, (Entity)null)) {

			boolean downFace = (facing == EnumFacing.DOWN);
			boolean upFace = (facing == EnumFacing.UP);
			
			IBlockState downState = worldIn.getBlockState(pos.down());
			Block downBlock = downState.getBlock();
			boolean bottom = ((downBlock instanceof BaseFacingSlabW && downState.getValue(BaseFacingSlabW.HALF) == SlabHalf.BOTTOM && downState.getValue(BaseFacingSlabW.DOUBLE) == false) ||
					(downBlock instanceof BaseSlabW && downState.getValue(BaseSlabW.HALF) == SlabHalf.BOTTOM && downState.getValue(BaseSlabW.DOUBLE) == false) ||
					(downBlock instanceof BaseSlabWType2 && downState.getValue(BaseSlabWType2.HALF) == SlabHalf.BOTTOM && downState.getValue(BaseSlabWType2.DOUBLE) == false) ||
					(downBlock instanceof BlockHalfWoodSlab && downState.getValue(BlockSlab.HALF) == BlockSlab.EnumBlockHalf.BOTTOM) ||
					(downBlock instanceof BlockHalfStoneSlab && downState.getValue(BlockSlab.HALF) == BlockSlab.EnumBlockHalf.BOTTOM) ||
					(downBlock instanceof BlockHalfStoneSlabNew && downState.getValue(BlockSlab.HALF) == BlockSlab.EnumBlockHalf.BOTTOM));
			
			IBlockState upState = worldIn.getBlockState(pos.up());
			Block upBlock = upState.getBlock();
			boolean top = ((upBlock instanceof BaseFacingSlabW && upState.getValue(BaseFacingSlabW.HALF) == SlabHalf.TOP && upState.getValue(BaseFacingSlabW.DOUBLE) == false) ||
					(upBlock instanceof BaseSlabW && upState.getValue(BaseSlabW.HALF) == SlabHalf.TOP && upState.getValue(BaseSlabW.DOUBLE) == false) ||
					(upBlock instanceof BaseSlabWType2 && upState.getValue(BaseSlabWType2.HALF) == SlabHalf.TOP && upState.getValue(BaseSlabWType2.DOUBLE) == false) ||
					(upBlock instanceof BlockHalfWoodSlab && upState.getValue(BlockSlab.HALF) == BlockSlab.EnumBlockHalf.TOP) ||
					(upBlock instanceof BlockHalfStoneSlab && upState.getValue(BlockSlab.HALF) == BlockSlab.EnumBlockHalf.TOP) ||
					(upBlock instanceof BlockHalfStoneSlabNew && upState.getValue(BlockSlab.HALF) == BlockSlab.EnumBlockHalf.TOP));

			IBlockState putState = Lamp_Blocks.E_LIGHT.getDefaultState().withProperty(LightEmbed.STAGE_1_4, Integer.valueOf(1));
			
			if (downFace) {
				if (top) { worldIn.setBlockState(pos, putState.withProperty(LightEmbed.STAGE_1_4, Integer.valueOf(2)), 10); }
				else { worldIn.setBlockState(pos, putState, 10); }
				
				CMEvents.Consume_1Metal(worldIn, pos, playerIn, hand);
				return EnumActionResult.SUCCESS; }
			
			if (upFace) { 
				if (bottom) { worldIn.setBlockState(pos, putState.withProperty(LightEmbed.STAGE_1_4, Integer.valueOf(3)), 10); }
				else { worldIn.setBlockState(pos, putState.withProperty(LightEmbed.STAGE_1_4, Integer.valueOf(4)), 10); }
				
				CMEvents.Consume_1Metal(worldIn, pos, playerIn, hand);
				return EnumActionResult.SUCCESS; }
			
			else { return EnumActionResult.FAIL; }
		}
		
		else { return EnumActionResult.FAIL; }
	}
}
