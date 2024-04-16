package com.ayutaki.chinjufumod.items.dish;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.dish.Chauke_3shu;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;

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

public class JPChaUke_Item extends ItemBlockBace {

	public JPChaUke_Item(String name) {
		super(name, Dish_Blocks.JPCHAUKE);
		setCreativeTab(ChinjufuModTabs.TEATIME);

		/** Have sub items. **/
		setHasSubtypes(true);
	}

	/* Sub item meta and name. */
	public String getUnlocalizedName(ItemStack stack) {

		switch (stack.getMetadata()) {
		case 0:
		default:
			return "item." + "block_food_senbei";
		case 1:
			return "item." + "block_food_mikan";
		case 2:
			return "item." + "block_food_scone";
		}
	}

	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			items.add(new ItemStack(this, 1, 0));
			items.add(new ItemStack(this, 1, 1));
			items.add(new ItemStack(this, 1, 2));
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

		if (!stack.isEmpty() && playerIn.canPlayerEdit(pos, facing, stack) && worldIn.mayPlace(Dish_Blocks.JPCHAUKE, pos, false, facing, (Entity)null)) {

			if (k == 0) {
				/** Put the Block. **/
				IBlockState state1 = Dish_Blocks.JPCHAUKE.getDefaultState().withProperty(Chauke_3shu.STAGE_0_15, Integer.valueOf(0));
				worldIn.setBlockState(pos, state1, 10); }

			if (k == 1) {
				IBlockState state1 = Dish_Blocks.JPCHAUKE.getDefaultState().withProperty(Chauke_3shu.STAGE_0_15, Integer.valueOf(5));
				worldIn.setBlockState(pos, state1, 10); }

			if (k == 2) {
				IBlockState state1 = Dish_Blocks.JPCHAUKE.getDefaultState().withProperty(Chauke_3shu.STAGE_0_15, Integer.valueOf(11));
				worldIn.setBlockState(pos, state1, 10); }

			CMEvents.Consume_1Wood(worldIn, pos, playerIn, hand);
			return EnumActionResult.SUCCESS;
		}

		else { return EnumActionResult.FAIL; }
	}
}
