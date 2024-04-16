package com.ayutaki.chinjufumod.items.jpdeco;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.garden.Chouzubachi;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.Garden_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
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
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Chouzubachi_Item extends ItemBlockBace {

	public Chouzubachi_Item(String name) {
		super(name, Garden_Blocks.CHOUZUBACHI);
		setCreativeTab(ChinjufuModTabs.WADECO);
		/** Have sub items. **/
		setHasSubtypes(true);
	}

	/* Sub item meta and name. */
	public String getUnlocalizedName(ItemStack stack) {
		switch (stack.getMetadata()) {
		case 0:
		default:
			return "item." + "block_chouzubachi_kara";
		case 1:
			return "item." + "block_chouzu_gra_kara";
		case 2:
			return "item." + "block_chouzu_dio_kara";
		case 3:
			return "item." + "block_chouzu_and_kara";
		}
	}

	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			items.add(new ItemStack(this, 1, 0));
			items.add(new ItemStack(this, 1, 1));
			items.add(new ItemStack(this, 1, 2));
			items.add(new ItemStack(this, 1, 3));
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

		if (!stack.isEmpty() && playerIn.canPlayerEdit(pos, facing, stack) && worldIn.mayPlace(Garden_Blocks.CHOUZUBACHI, pos, false, facing, (Entity)null)) {

			if (k == 0) {
				IBlockState state1 = Garden_Blocks.CHOUZUBACHI.getDefaultState().withProperty(Chouzubachi.STAGE_0_15, Integer.valueOf(0));
				worldIn.setBlockState(pos, state1, 10); }

			if (k == 1) {
				IBlockState state1 = Garden_Blocks.CHOUZUBACHI.getDefaultState().withProperty(Chouzubachi.STAGE_0_15, Integer.valueOf(4));
				worldIn.setBlockState(pos, state1, 10); }

			if (k == 2) {
				IBlockState state1 = Garden_Blocks.CHOUZUBACHI.getDefaultState().withProperty(Chouzubachi.STAGE_0_15, Integer.valueOf(8));
				worldIn.setBlockState(pos, state1, 10); }

			if (k == 3) {
				IBlockState state1 = Garden_Blocks.CHOUZUBACHI.getDefaultState().withProperty(Chouzubachi.STAGE_0_15, Integer.valueOf(12));
				worldIn.setBlockState(pos, state1, 10); }

			CMEvents.Consume_1Stone(worldIn, pos, playerIn, hand);
			return EnumActionResult.SUCCESS;

		}
		else { return EnumActionResult.FAIL; }
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_chouzubachi.name", meta));
	}
}
