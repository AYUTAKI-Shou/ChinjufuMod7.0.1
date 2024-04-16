package com.ayutaki.chinjufumod.items.jpblock;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.wallpane.Bricks_CM;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.WallBrick_Blocks;

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

public class DirtWall_Item extends ItemBlockBace {

	public DirtWall_Item(String name) {
		super(name, WallBrick_Blocks.ROCK);
		setUnlocalizedName(name);
		setCreativeTab(ChinjufuModTabs.WABLOCK);
	}

	/* Place block */
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {

		IBlockState state = worldIn.getBlockState(pos);
		Block block = state.getBlock();

		if (!block.isReplaceable(worldIn, pos)) { pos = pos.offset(facing); }

		ItemStack stack = playerIn.getHeldItem(hand);

		if (!stack.isEmpty() && playerIn.canPlayerEdit(pos, facing, stack) && worldIn.mayPlace(WallBrick_Blocks.ROCK, pos, false, facing, (Entity)null)) {

			IBlockState state1 = WallBrick_Blocks.ROCK.getDefaultState()
					.withProperty(Bricks_CM.STAGE_1_14, Integer.valueOf(13));

			if (placeBlockAt(stack, playerIn, worldIn, pos, facing, hitX, hitY, hitZ, state1)) {
				state1 = worldIn.getBlockState(pos);
				worldIn.setBlockState(pos, state1, 10);
				CMEvents.Consume_1Stone(worldIn, pos, playerIn, hand);
			}
			return EnumActionResult.SUCCESS;
		}

		else { return EnumActionResult.FAIL; }
	}
}
