package com.ayutaki.chinjufumod.items.teatime;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.unitblock.Endai;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.Unit_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TeaTable_Item extends ItemBlockBace {

	public TeaTable_Item(String name) {
		super(name, Unit_Blocks.ENDAI);
		setUnlocalizedName(name);
		setCreativeTab(ChinjufuModTabs.TEATIME);
	}

	@Override
	public int getItemBurnTime(ItemStack stack) {
		return 200;
	}

	/* Place block */
	@Override
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {

		IBlockState state = worldIn.getBlockState(pos);
		Block block = state.getBlock();

		if (!block.isReplaceable(worldIn, pos)) { pos = pos.offset(facing); }

		ItemStack stack = playerIn.getHeldItem(hand);

		if (!stack.isEmpty() && playerIn.canPlayerEdit(pos, facing, stack) && worldIn.mayPlace(Unit_Blocks.ENDAI, pos, false, facing, (Entity)null)) {

			IBlockState state1 = Unit_Blocks.ENDAI.getDefaultState().withProperty(Endai.STAGE_0_2, Integer.valueOf(2));

			if (placeBlockAt(stack, playerIn, worldIn, pos, facing, hitX, hitY, hitZ, state1)) {
				state1 = worldIn.getBlockState(pos);
				CMEvents.Consume_1Wood(worldIn, pos, playerIn, hand);
			}
			return EnumActionResult.SUCCESS;
		}

		else { return EnumActionResult.FAIL; }
	}
}
