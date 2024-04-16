package com.ayutaki.chinjufumod.items.jpdeco;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.garden.IkegakiLong_Bottom;
import com.ayutaki.chinjufumod.blocks.garden.IkegakiLong_Top;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.Garden_Blocks;

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

public class IkegakiLong_Item extends ItemBlockBace {

	public IkegakiLong_Item(String name) {
		super(name, Garden_Blocks.IKEGAKI_L_BOT);
		setCreativeTab(ChinjufuModTabs.WADECO);
		/** Have sub items. **/
		setHasSubtypes(true);
	}

	@Override
	public int getItemBurnTime(ItemStack stack) {
		return 300;
	}
	
	/* Sub item meta and name. */
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		switch (stack.getMetadata()) {
		case 0:
		default:
			return "item." + "block_longoak_bot";
		case 1:
			return "item." + "block_longspruce_bot";
		case 2:
			return "item." + "block_longbirch_bot";
		case 3:
			return "item." + "block_longjungle_bot";
		case 4:
			return "item." + "block_longacacia_bot";
		case 5:
			return "item." + "block_longdarkoak_bot";
		}
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			items.add(new ItemStack(this, 1, 0));
			items.add(new ItemStack(this, 1, 1));
			items.add(new ItemStack(this, 1, 2));
			items.add(new ItemStack(this, 1, 3));
			items.add(new ItemStack(this, 1, 4));
			items.add(new ItemStack(this, 1, 5));
		}
	}

	/* Call this when you use the item. ex) Place a block. */
	@Override
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {

		IBlockState state = worldIn.getBlockState(pos);
		Block block = state.getBlock();

		if (!block.isReplaceable(worldIn, pos)) { pos = pos.offset(facing); }

		ItemStack stack = playerIn.getHeldItem(hand);
		int k;
		k = stack.getMetadata();

		if (!stack.isEmpty() && playerIn.canPlayerEdit(pos, facing, stack) && worldIn.mayPlace(Garden_Blocks.IKEGAKI_L_BOT, pos, false, facing, (Entity)null)) {

			IBlockState state1 = Garden_Blocks.IKEGAKI_L_BOT.getDefaultState().withProperty(IkegakiLong_Bottom.STAGE_0_9, Integer.valueOf(k));
			IBlockState state2 = Garden_Blocks.IKEGAKI_L_TOP.getDefaultState().withProperty(IkegakiLong_Top.STAGE_0_9, Integer.valueOf(k));
			worldIn.setBlockState(pos, state1);
			worldIn.setBlockState(pos.up(), state2);

			CMEvents.Consume_1Wood(worldIn, pos, playerIn, hand);
			return EnumActionResult.SUCCESS;
		}

		else { return EnumActionResult.FAIL; }
	}
}
