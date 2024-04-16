package com.ayutaki.chinjufumod.items.window;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.window.BaseCurtainLarge;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Window_Blocks;
import com.ayutaki.chinjufumod.state.HalfState;
import com.ayutaki.chinjufumod.state.HingeState;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CurtainLarge_Item extends Item {
	
	public CurtainLarge_Item(String name) {
		super();
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setCreativeTab(ChinjufuModTabs.CHINJUFU);
		/** Have sub items. **/
		setHasSubtypes(true);
	}

	/* Sub item meta and name. */
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		switch (stack.getMetadata()) {
		case 0:
		default:
			return "item." + "block_curtainlarge_white";
		case 1:
			return "item." + "block_curtainlarge_orange";
		case 2:
			return "item." + "block_curtainlarge_magenta";
		case 3:
			return "item." + "block_curtainlarge_lightblue";
		case 4:
			return "item." + "block_curtainlarge_yellow";
		case 5:
			return "item." + "block_curtainlarge_lime";
		case 6:
			return "item." + "block_curtainlarge_pink";
		case 7:
			return "item." + "block_curtainlarge_gray";
		case 8:
			return "item." + "block_curtainlarge_lightgray";
		case 9:
			return "item." + "block_curtainlarge_cyan";
		case 10:
			return "item." + "block_curtainlarge_purple";
		case 11:
			return "item." + "block_curtainlarge_blue";
		case 12:
			return "item." + "block_curtainlarge_brown";
		case 13:
			return "item." + "block_curtainlarge_green";
		case 14:
			return "item." + "block_curtainlarge_red";
		case 15:
			return "item." + "block_curtainlarge_black";
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
	
	/* Call this when you use the item. ex) Place a block. */
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {

		if (facing != EnumFacing.UP && facing != EnumFacing.DOWN) { 
			
			IBlockState state = worldIn.getBlockState(pos);
			Block block = state.getBlock();
	
			if (!block.isReplaceable(worldIn, pos)) { pos = pos.offset(facing); }
	
			ItemStack stack = playerIn.getHeldItem(hand);
			
			double x = (double) pos.getX();
			double y = (double) pos.getY();
			double z = (double) pos.getZ();
			
			/** Put "this.block". **/
			if (playerIn.canPlayerEdit(pos, facing, stack) && this.takeBlock(playerIn, hand).canPlaceBlockAt(worldIn, pos)) {
	
				if (playerIn.isSneaking()) {
	
					IBlockState Upper1 = this.takeBlock(playerIn, hand).getDefaultState().withProperty(BaseCurtainLarge.H_FACING, facing.getOpposite())
							.withProperty(BaseCurtainLarge.HALF, HalfState.UPPER).withProperty(BaseCurtainLarge.OPEN, Boolean.valueOf(false))
							.withProperty(BaseCurtainLarge.HINGE, HingeState.RIGHT);
					IBlockState Lower1 = this.takeBlock(playerIn, hand).getDefaultState().withProperty(BaseCurtainLarge.H_FACING, facing.getOpposite())
							.withProperty(BaseCurtainLarge.HALF, HalfState.LOWER).withProperty(BaseCurtainLarge.OPEN, Boolean.valueOf(false))
							.withProperty(BaseCurtainLarge.HINGE, HingeState.RIGHT);
					IBlockState Upper2 = this.takeBlock2(playerIn, hand).getDefaultState().withProperty(BaseCurtainLarge.H_FACING, facing.getOpposite())
							.withProperty(BaseCurtainLarge.HALF, HalfState.UPPER).withProperty(BaseCurtainLarge.OPEN, Boolean.valueOf(false))
							.withProperty(BaseCurtainLarge.HINGE, HingeState.RIGHT);
					IBlockState Lower2 = this.takeBlock2(playerIn, hand).getDefaultState().withProperty(BaseCurtainLarge.H_FACING, facing.getOpposite())
							.withProperty(BaseCurtainLarge.HALF, HalfState.LOWER).withProperty(BaseCurtainLarge.OPEN, Boolean.valueOf(false))
							.withProperty(BaseCurtainLarge.HINGE, HingeState.RIGHT);
	
					if (facing == EnumFacing.NORTH && block.isReplaceable(worldIn, new BlockPos(x - 1, y, z))) {
						worldIn.setBlockState(pos, Upper1, 3);
						worldIn.setBlockState(pos.down(), Lower1, 3);
						worldIn.setBlockState(new BlockPos(x - 1, y, z), Upper2, 3);
						worldIn.setBlockState(new BlockPos(x - 1, y - 1, z), Lower2, 3);
						
						CMEvents.Consume_1Cloth(worldIn, pos, playerIn, hand);
						return EnumActionResult.SUCCESS; }
					
					if (facing == EnumFacing.SOUTH && block.isReplaceable(worldIn, new BlockPos(x + 1, y, z))) {
						worldIn.setBlockState(pos, Upper1, 3);
						worldIn.setBlockState(pos.down(), Lower1, 3);
						worldIn.setBlockState(new BlockPos(x + 1, y, z), Upper2, 3);
						worldIn.setBlockState(new BlockPos(x + 1, y - 1, z), Lower2, 3);
						
						CMEvents.Consume_1Cloth(worldIn, pos, playerIn, hand);
						return EnumActionResult.SUCCESS; }
					
					if (facing == EnumFacing.EAST && block.isReplaceable(worldIn, new BlockPos(x, y, z - 1))) {
						worldIn.setBlockState(pos, Upper1, 3);
						worldIn.setBlockState(pos.down(), Lower1, 3);
						worldIn.setBlockState(new BlockPos(x, y, z - 1), Upper2, 3);
						worldIn.setBlockState(new BlockPos(x, y - 1, z - 1), Lower2, 3);
						
						CMEvents.Consume_1Cloth(worldIn, pos, playerIn, hand);
						return EnumActionResult.SUCCESS; }
					
					if (facing == EnumFacing.WEST && block.isReplaceable(worldIn, new BlockPos(x, y, z + 1))) {
						worldIn.setBlockState(pos, Upper1, 3);
						worldIn.setBlockState(pos.down(), Lower1, 3);
						worldIn.setBlockState(new BlockPos(x, y, z + 1), Upper2, 3);
						worldIn.setBlockState(new BlockPos(x, y - 1, z + 1), Lower2, 3);
						
						CMEvents.Consume_1Cloth(worldIn, pos, playerIn, hand);
						return EnumActionResult.SUCCESS; }
					
					else { 
						CMEvents.textNoSpace(worldIn, playerIn);
						return EnumActionResult.FAIL; }
				}
	
				/** デフォルトは left。右取手・左蝶番で開くのが hinge=left **/
				else {
					
					IBlockState Upper1 = this.takeBlock(playerIn, hand).getDefaultState().withProperty(BaseCurtainLarge.H_FACING, facing.getOpposite())
							.withProperty(BaseCurtainLarge.HALF, HalfState.UPPER).withProperty(BaseCurtainLarge.OPEN, Boolean.valueOf(false))
							.withProperty(BaseCurtainLarge.HINGE, HingeState.LEFT);
					IBlockState Lower1 = this.takeBlock(playerIn, hand).getDefaultState().withProperty(BaseCurtainLarge.H_FACING, facing.getOpposite())
							.withProperty(BaseCurtainLarge.HALF, HalfState.LOWER).withProperty(BaseCurtainLarge.OPEN, Boolean.valueOf(false))
							.withProperty(BaseCurtainLarge.HINGE, HingeState.LEFT);
					IBlockState Upper2 = this.takeBlock2(playerIn, hand).getDefaultState().withProperty(BaseCurtainLarge.H_FACING, facing.getOpposite())
							.withProperty(BaseCurtainLarge.HALF, HalfState.UPPER).withProperty(BaseCurtainLarge.OPEN, Boolean.valueOf(false))
							.withProperty(BaseCurtainLarge.HINGE, HingeState.LEFT);
					IBlockState Lower2 = this.takeBlock2(playerIn, hand).getDefaultState().withProperty(BaseCurtainLarge.H_FACING, facing.getOpposite())
							.withProperty(BaseCurtainLarge.HALF, HalfState.LOWER).withProperty(BaseCurtainLarge.OPEN, Boolean.valueOf(false))
							.withProperty(BaseCurtainLarge.HINGE, HingeState.LEFT);
					
					if (facing == EnumFacing.NORTH && block.isReplaceable(worldIn, new BlockPos(x + 1, y, z))) {
						worldIn.setBlockState(pos, Upper1, 3);
						worldIn.setBlockState(pos.down(), Lower1, 3);
						worldIn.setBlockState(new BlockPos(x + 1, y, z), Upper2, 3);
						worldIn.setBlockState(new BlockPos(x + 1, y - 1, z), Lower2, 3);
						
						CMEvents.Consume_1Cloth(worldIn, pos, playerIn, hand);
						return EnumActionResult.SUCCESS; }
					
					if (facing == EnumFacing.SOUTH && block.isReplaceable(worldIn, new BlockPos(x - 1, y, z))) {
						worldIn.setBlockState(pos, Upper1, 3);
						worldIn.setBlockState(pos.down(), Lower1, 3);
						worldIn.setBlockState(new BlockPos(x - 1, y, z), Upper2, 3);
						worldIn.setBlockState(new BlockPos(x - 1, y - 1, z), Lower2, 3);
						
						CMEvents.Consume_1Cloth(worldIn, pos, playerIn, hand);
						return EnumActionResult.SUCCESS; }
					
					if (facing == EnumFacing.EAST && block.isReplaceable(worldIn, new BlockPos(x, y, z + 1))) {
						worldIn.setBlockState(pos, Upper1, 3);
						worldIn.setBlockState(pos.down(), Lower1, 3);
						worldIn.setBlockState(new BlockPos(x, y, z + 1), Upper2, 3);
						worldIn.setBlockState(new BlockPos(x, y - 1, z + 1), Lower2, 3);
						
						CMEvents.Consume_1Cloth(worldIn, pos, playerIn, hand);
						return EnumActionResult.SUCCESS; }
					
					if (facing == EnumFacing.WEST && block.isReplaceable(worldIn, new BlockPos(x, y, z - 1))) {
						worldIn.setBlockState(pos, Upper1, 3);
						worldIn.setBlockState(pos.down(), Lower1, 3);
						worldIn.setBlockState(new BlockPos(x, y, z - 1), Upper2, 3);
						worldIn.setBlockState(new BlockPos(x, y - 1, z - 1), Lower2, 3);
						
						CMEvents.Consume_1Cloth(worldIn, pos, playerIn, hand);
						return EnumActionResult.SUCCESS; }
	
					else { 
						CMEvents.textNoSpace(worldIn, playerIn);
						return EnumActionResult.FAIL; }
				}
			}
			
			return EnumActionResult.FAIL;
		}
		else { return EnumActionResult.FAIL; }
	}

	private Block takeBlock(EntityPlayer playerIn, EnumHand hand) {
		ItemStack stack = playerIn.getHeldItem(hand);
		int k;
		k = stack.getMetadata();
		
		if (k == 0) { return Window_Blocks.CURTAINL1_white; }
		if (k == 1) { return Window_Blocks.CURTAINL1_orange; }
		if (k == 2) { return Window_Blocks.CURTAINL1_magenta; }
		if (k == 3) { return Window_Blocks.CURTAINL1_lightblue; }
		if (k == 4) { return Window_Blocks.CURTAINL1_yellow; }
		if (k == 5) { return Window_Blocks.CURTAINL1_lime; }
		if (k == 6) { return Window_Blocks.CURTAINL1_pink; }
		if (k == 7) { return Window_Blocks.CURTAINL1_gray; }
		if (k == 8) { return Window_Blocks.CURTAINL1_lightgray; }
		if (k == 9) { return Window_Blocks.CURTAINL1_cyan; }
		if (k == 10) { return Window_Blocks.CURTAINL1_purple; }
		if (k == 11) { return Window_Blocks.CURTAINL1_blue; }
		if (k == 12) { return Window_Blocks.CURTAINL1_brown; }
		if (k == 13) { return Window_Blocks.CURTAINL1_green; }
		if (k == 14) { return Window_Blocks.CURTAINL1_red; }
		if (k == 15) { return Window_Blocks.CURTAINL1_black; }
		return null;
	}
	
	private Block takeBlock2(EntityPlayer playerIn, EnumHand hand) {
		ItemStack stack = playerIn.getHeldItem(hand);
		int k;
		k = stack.getMetadata();
		
		if (k == 0) { return Window_Blocks.CURTAINL2_white; }
		if (k == 1) { return Window_Blocks.CURTAINL2_orange; }
		if (k == 2) { return Window_Blocks.CURTAINL2_magenta; }
		if (k == 3) { return Window_Blocks.CURTAINL2_lightblue; }
		if (k == 4) { return Window_Blocks.CURTAINL2_yellow; }
		if (k == 5) { return Window_Blocks.CURTAINL2_lime; }
		if (k == 6) { return Window_Blocks.CURTAINL2_pink; }
		if (k == 7) { return Window_Blocks.CURTAINL2_gray; }
		if (k == 8) { return Window_Blocks.CURTAINL2_lightgray; }
		if (k == 9) { return Window_Blocks.CURTAINL2_cyan; }
		if (k == 10) { return Window_Blocks.CURTAINL2_purple; }
		if (k == 11) { return Window_Blocks.CURTAINL2_blue; }
		if (k == 12) { return Window_Blocks.CURTAINL2_brown; }
		if (k == 13) { return Window_Blocks.CURTAINL2_green; }
		if (k == 14) { return Window_Blocks.CURTAINL2_red; }
		if (k == 15) { return Window_Blocks.CURTAINL2_black; }
		return null;
	}
	
	/* tips */
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_window.name", meta));
	}
}
