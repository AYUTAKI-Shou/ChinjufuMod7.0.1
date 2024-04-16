package com.ayutaki.chinjufumod.items.jpblock;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.jpblock.Base_Wall;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.JPBlock_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WallPlaster_Item extends ItemBlockBace {

	public WallPlaster_Item(String name) {
		super(name, JPBlock_Blocks.SHIKKUI_WALL);
		setCreativeTab(ChinjufuModTabs.WABLOCK);
		/** Have sub items. **/
		setHasSubtypes(true);
	}

	/* Sub item meta and name. */
	public String getUnlocalizedName(ItemStack stack) {
		switch (stack.getMetadata()) {
		case 0:
		default:
			return "item." + "block_pwall_white";
		case 1:
			return "item." + "block_pwall_orange";
		case 2:
			return "item." + "block_pwall_magenta";
		case 3:
			return "item." + "block_pwall_lightb";
		case 4:
			return "item." + "block_pwall_yellow";
		case 5:
			return "item." + "block_pwall_lime";
		case 6:
			return "item." + "block_pwall_pink";
		case 7:
			return "item." + "block_pwall_gray";
		case 8:
			return "item." + "block_pwall_lightg";
		case 9:
			return "item." + "block_pwall_cyan";
		case 10:
			return "item." + "block_pwall_purple";
		case 11:
			return "item." + "block_pwall_blue";
		case 12:
			return "item." + "block_pwall_brown";
		case 13:
			return "item." + "block_pwall_green";
		case 14:
			return "item." + "block_pwall_red";
		case 15:
			return "item." + "block_pwall_black";
		}
	}

	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			items.add(new ItemStack(this, 1, 0));
			items.add(new ItemStack(this, 1, 1));
			items.add(new ItemStack(this, 1, 2));
			items.add(new ItemStack(this, 1, 3));
			items.add(new ItemStack(this, 1, 4));
			items.add(new ItemStack(this, 1, 5));
			items.add(new ItemStack(this, 1, 6));
			items.add(new ItemStack(this, 1, 7));
			items.add(new ItemStack(this, 1, 8));
			items.add(new ItemStack(this, 1, 9));
			items.add(new ItemStack(this, 1, 10));
			items.add(new ItemStack(this, 1, 11));
			items.add(new ItemStack(this, 1, 12));
			items.add(new ItemStack(this, 1, 13));
			items.add(new ItemStack(this, 1, 14));
			items.add(new ItemStack(this, 1, 15));
		}
	}

	/* Place block */
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {

		IBlockState state = worldIn.getBlockState(pos);
		Block block = state.getBlock();

		if (!block.isReplaceable(worldIn, pos)) { pos = pos.offset(facing); }

		ItemStack stack = playerIn.getHeldItem(hand);
		int k;
		k = stack.getMetadata();

		if (!stack.isEmpty() && playerIn.canPlayerEdit(pos, facing, stack) && worldIn.mayPlace(JPBlock_Blocks.SHIKKUI_WALL, pos, false, facing, (Entity)null)) {

			IBlockState state1 = JPBlock_Blocks.SHIKKUI_WALL.getDefaultState().withProperty(Base_Wall.STAGE_0_15, Integer.valueOf(k));
			worldIn.setBlockState(pos, state1, 10);

			CMEvents.Consume_1Stone(worldIn, pos, playerIn, hand);
			return EnumActionResult.SUCCESS;
		}

		else { return EnumActionResult.FAIL; }
	}

}
