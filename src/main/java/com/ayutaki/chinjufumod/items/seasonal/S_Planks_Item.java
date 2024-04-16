package com.ayutaki.chinjufumod.items.seasonal;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.wood.Planks_CM;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class S_Planks_Item extends Item {

	/* 木剣の修理でサクラ, カエデ。イチョウを区別するため, サブアイテムにはしない */
	public S_Planks_Item(String name) {
		super();
		setUnlocalizedName(name);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setCreativeTab(ChinjufuModTabs.SEASONAL);
	}

	@Override
	public int getItemBurnTime(ItemStack stack) {
		return 300;
	}

	/* Place block */
	@Override
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {

		IBlockState state = worldIn.getBlockState(pos);
		Block block = state.getBlock();

		if (!block.isReplaceable(worldIn, pos)) { pos = pos.offset(facing); }

		ItemStack stack = playerIn.getHeldItem(hand);

		if (!stack.isEmpty() && playerIn.canPlayerEdit(pos, facing, stack) && worldIn.mayPlace(Seasonal_Blocks.PLANKS, pos, false, facing, (Entity)null)) {

			if (this == Items_Seasonal.PLANKS_sakura) {
				worldIn.setBlockState(pos, Seasonal_Blocks.PLANKS.getDefaultState().withProperty(Planks_CM.STAGE_1_3, Integer.valueOf(1)), 2); }

			if (this == Items_Seasonal.PLANKS_kaede) {
				worldIn.setBlockState(pos, Seasonal_Blocks.PLANKS.getDefaultState().withProperty(Planks_CM.STAGE_1_3, Integer.valueOf(2)), 2); }
			
			if (this == Items_Seasonal.PLANKS_ichoh) {
				worldIn.setBlockState(pos, Seasonal_Blocks.PLANKS.getDefaultState().withProperty(Planks_CM.STAGE_1_3, Integer.valueOf(3)), 2); }
			
			CMEvents.Consume_1Wood(worldIn, pos, playerIn, hand);
			return EnumActionResult.SUCCESS;
		}

		else { return EnumActionResult.FAIL; }
	}
}
