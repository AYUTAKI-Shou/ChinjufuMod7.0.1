package com.ayutaki.chinjufumod.items.crops;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class TestCrop_Item extends ItemBlockBace {

	public TestCrop_Item(String name) {
		super(name, Crop_Blocks.CABBAGE);
		setCreativeTab(ChinjufuModTabs.TEATIME);
		/** Have sub items. **/
		setHasSubtypes(true);
	}

	/* Sub item meta and name. */
	public String getUnlocalizedName(ItemStack stack) {
		switch (stack.getMetadata()) {
		case 0:
		default:
			return "item." + "test_crop_0";
		case 1:
			return "item." + "test_crop_1";
		case 2:
			return "item." + "test_crop_2";
		case 3:
			return "item." + "test_crop_3";
		case 4:
			return "item." + "test_crop_4";
		case 5:
			return "item." + "test_crop_5";
		case 6:
			return "item." + "test_crop_6";
		case 7:
			return "item." + "test_crop_7";
		case 8:
			return "item." + "test_crop_8";
		case 9:
			return "item." + "test_crop_9";
		case 10:
			return "item." + "test_crop_10";
		case 11:
			return "item." + "test_crop_11";
		case 12:
			return "item." + "test_crop_12";
		case 13:
			return "item." + "test_crop_13";
		case 14:
			return "item." + "test_crop_14";
		case 15:
			return "item." + "test_crop_15";
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

	/* Place block
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {

		IBlockState state = worldIn.getBlockState(pos);
		Block block = state.getBlock();

		if (!block.isReplaceable(worldIn, pos)) { pos = pos.offset(facing); }

		ItemStack stack = playerIn.getHeldItem(hand);
		int k;
		k = stack.getMetadata();

		if (!stack.isEmpty() && playerIn.canPlayerEdit(pos, facing, stack) && worldIn.mayPlace(Crop_Blocks.TEST, pos, false, facing, (Entity)null)) {

			if (k == 0) {
				IBlockState state1 = Crop_Blocks.TEST.getDefaultState().withProperty(TestCrop.STAGE_0_15, Integer.valueOf(0));
				worldIn.setBlockState(pos, state1, 10); }

			if (k == 1) {
				IBlockState state1 = Crop_Blocks.TEST.getDefaultState().withProperty(TestCrop.STAGE_0_15, Integer.valueOf(1));
				worldIn.setBlockState(pos, state1, 10); }

			if (k == 2) {
				IBlockState state1 = Crop_Blocks.TEST.getDefaultState().withProperty(TestCrop.STAGE_0_15, Integer.valueOf(2));
				worldIn.setBlockState(pos, state1, 10); }

			if (k == 3) {
				IBlockState state1 = Crop_Blocks.TEST.getDefaultState().withProperty(TestCrop.STAGE_0_15, Integer.valueOf(3));
				worldIn.setBlockState(pos, state1, 10); }

			if (k == 4) {
				IBlockState state1 = Crop_Blocks.TEST.getDefaultState().withProperty(TestCrop.STAGE_0_15, Integer.valueOf(4));
				worldIn.setBlockState(pos, state1, 10); }

			if (k == 5) {
				IBlockState state1 = Crop_Blocks.TEST.getDefaultState().withProperty(TestCrop.STAGE_0_15, Integer.valueOf(5));
				worldIn.setBlockState(pos, state1, 10); }

			if (k == 6) {
				IBlockState state1 = Crop_Blocks.TEST.getDefaultState().withProperty(TestCrop.STAGE_0_15, Integer.valueOf(6));
				worldIn.setBlockState(pos, state1, 10); }

			if (k == 7) {
				IBlockState state1 = Crop_Blocks.TEST.getDefaultState().withProperty(TestCrop.STAGE_0_15, Integer.valueOf(7));
				worldIn.setBlockState(pos, state1, 10); }

			if (k == 8) {
				IBlockState state1 = Crop_Blocks.TEST.getDefaultState().withProperty(TestCrop.STAGE_0_15, Integer.valueOf(8));
				worldIn.setBlockState(pos, state1, 10); }

			if (k == 9) {
				IBlockState state1 = Crop_Blocks.TEST.getDefaultState().withProperty(TestCrop.STAGE_0_15, Integer.valueOf(9));
				worldIn.setBlockState(pos, state1, 10); }

			if (k == 10) {
				IBlockState state1 = Crop_Blocks.TEST.getDefaultState().withProperty(TestCrop.STAGE_0_15, Integer.valueOf(10));
				worldIn.setBlockState(pos, state1, 10); }

			if (k == 11) {
				IBlockState state1 = Crop_Blocks.TEST.getDefaultState().withProperty(TestCrop.STAGE_0_15, Integer.valueOf(11));
				worldIn.setBlockState(pos, state1, 10); }

			if (k == 12) {
				IBlockState state1 = Crop_Blocks.TEST.getDefaultState().withProperty(TestCrop.STAGE_0_15, Integer.valueOf(12));
				worldIn.setBlockState(pos, state1, 10); }

			if (k == 13) {
				IBlockState state1 = Crop_Blocks.TEST.getDefaultState().withProperty(TestCrop.STAGE_0_15, Integer.valueOf(13));
				worldIn.setBlockState(pos, state1, 10); }

			if (k == 14) {
				IBlockState state1 = Crop_Blocks.TEST.getDefaultState().withProperty(TestCrop.STAGE_0_15, Integer.valueOf(14));
				worldIn.setBlockState(pos, state1, 10); }

			if (k == 15) {
				IBlockState state1 = Crop_Blocks.TEST.getDefaultState().withProperty(TestCrop.STAGE_0_15, Integer.valueOf(15));
				worldIn.setBlockState(pos, state1, 10); }

			CMEvents.Consume_1Grass(worldIn, pos, playerIn, hand);
			return EnumActionResult.SUCCESS;
		}

		else { return EnumActionResult.FAIL; }
	} */
}
