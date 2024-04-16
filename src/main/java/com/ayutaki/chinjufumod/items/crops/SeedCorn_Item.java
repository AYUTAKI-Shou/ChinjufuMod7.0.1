package com.ayutaki.chinjufumod.items.crops;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SeedCorn_Item extends ItemBlockBace {

	public SeedCorn_Item(String name) {
		super(name, Crop_Blocks.CORN);
		setUnlocalizedName(name);
		setCreativeTab(ChinjufuModTabs.TEATIME);
	}

	/* Place block */
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {

		IBlockState state = worldIn.getBlockState(pos);
		Block block = state.getBlock();

		if (!block.isReplaceable(worldIn, pos)) { pos = pos.offset(facing); }

		ItemStack stack = playerIn.getHeldItem(hand);
		boolean canPlace = (facing == EnumFacing.UP && playerIn.canPlayerEdit(pos, facing, stack) && worldIn.getBlockState(pos.up()).getMaterial().isReplaceable());
		
		if (state.getBlock() instanceof BlockFarmland && !stack.isEmpty() && canPlace) {

			worldIn.setBlockState(pos, Crop_Blocks.CORN.getDefaultState().withProperty(BlockCrops.AGE, Integer.valueOf(0)), 10);
			worldIn.setBlockState(pos.up(), Crop_Blocks.CORN_TOP.getDefaultState().withProperty(BlockCrops.AGE, Integer.valueOf(0)), 10);
			CMEvents.Consume_1Grass(worldIn, pos, playerIn, hand);
			return EnumActionResult.SUCCESS;
		}

		else { return EnumActionResult.FAIL; }
	}
}
