package com.ayutaki.chinjufumod.items.jpdeco;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.gate.BaseGate;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.doors.Gate_Blocks;
import com.ayutaki.chinjufumod.state.HalfState;
import com.ayutaki.chinjufumod.state.HingeState;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Gate_Item extends Item {
	
	public Gate_Item(String name) {
		super();
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setCreativeTab(ChinjufuModTabs.WADECO);
		/** Have sub items. **/
		setHasSubtypes(true);
	}

	/* Sub item meta and name. */
	public String getUnlocalizedName(ItemStack stack) {
		switch (stack.getMetadata()) {
		case 0:
		default:
			return "item." + "block_gate_spruce_b";
		case 1:
			return "item." + "block_gate_spruce";
		case 2:
			return "item." + "block_gate_iron";
		case 3:
			return "item." + "block_gate_irongrill";
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
	
	/* Call this when you use the item. ex) Place a block. */
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {

		IBlockState state = worldIn.getBlockState(pos);
		Block block = state.getBlock();

		if (!block.isReplaceable(worldIn, pos)) { pos = pos.offset(facing); }

		ItemStack stack = playerIn.getHeldItem(hand);
		int k;
		k = stack.getMetadata();
		EnumFacing direction = EnumFacing.fromAngle((double)playerIn.rotationYaw);
		
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		
		boolean woodSE = (k == 0 || k == 1); 
		SoundEvent SE = woodSE? SoundEvents.BLOCK_WOOD_PLACE : SoundEvents.BLOCK_METAL_PLACE;
		boolean mode = playerIn.capabilities.isCreativeMode;
		
		/** Put "this.block". **/
		if (playerIn.canPlayerEdit(pos, facing, stack) && this.takeBlock(playerIn, hand).canPlaceBlockAt(worldIn, pos)) {

			if (playerIn.isSneaking()) {

				IBlockState Upper1 = this.takeBlock(playerIn, hand).getDefaultState().withProperty(BaseGate.H_FACING, direction)
						.withProperty(BaseGate.HALF, HalfState.UPPER).withProperty(BaseGate.OPEN, Boolean.valueOf(false))
						.withProperty(BaseGate.HINGE, HingeState.RIGHT).withProperty(BaseGate.POWERED, Boolean.valueOf(false));
				IBlockState Lower1 = this.takeBlock(playerIn, hand).getDefaultState().withProperty(BaseGate.H_FACING, direction)
						.withProperty(BaseGate.HALF, HalfState.LOWER).withProperty(BaseGate.OPEN, Boolean.valueOf(false))
						.withProperty(BaseGate.HINGE, HingeState.RIGHT).withProperty(BaseGate.POWERED, Boolean.valueOf(false));
				IBlockState Upper2 = this.takeBlock2(playerIn, hand).getDefaultState().withProperty(BaseGate.H_FACING, direction)
						.withProperty(BaseGate.HALF, HalfState.UPPER).withProperty(BaseGate.OPEN, Boolean.valueOf(false))
						.withProperty(BaseGate.HINGE, HingeState.RIGHT).withProperty(BaseGate.POWERED, Boolean.valueOf(false));
				IBlockState Lower2 = this.takeBlock2(playerIn, hand).getDefaultState().withProperty(BaseGate.H_FACING, direction)
						.withProperty(BaseGate.HALF, HalfState.LOWER).withProperty(BaseGate.OPEN, Boolean.valueOf(false))
						.withProperty(BaseGate.HINGE, HingeState.RIGHT).withProperty(BaseGate.POWERED, Boolean.valueOf(false));

				if (direction == EnumFacing.NORTH && block.isReplaceable(worldIn, new BlockPos(x + 1, y, z))) {
					worldIn.setBlockState(pos.up(), Upper1, 3);
					worldIn.setBlockState(pos, Lower1, 3);
					worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), Upper2, 3);
					worldIn.setBlockState(new BlockPos(x + 1, y, z), Lower2, 3);
					
					worldIn.playSound(playerIn, pos, SE, SoundCategory.BLOCKS, 1.0F, 0.8F);
					if (!mode) { stack.shrink(1); }
					return EnumActionResult.SUCCESS; }
				
				if (direction == EnumFacing.SOUTH && block.isReplaceable(worldIn, new BlockPos(x - 1, y, z))) {
					worldIn.setBlockState(pos.up(), Upper1, 3);
					worldIn.setBlockState(pos, Lower1, 3);
					worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), Upper2, 3);
					worldIn.setBlockState(new BlockPos(x - 1, y, z), Lower2, 3);
					
					worldIn.playSound(playerIn, pos, SE, SoundCategory.BLOCKS, 1.0F, 0.8F);
					if (!mode) { stack.shrink(1); }
					return EnumActionResult.SUCCESS; }
				
				if (direction == EnumFacing.EAST && block.isReplaceable(worldIn, new BlockPos(x, y, z + 1))) {
					worldIn.setBlockState(pos.up(), Upper1, 3);
					worldIn.setBlockState(pos, Lower1, 3);
					worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), Upper2, 3);
					worldIn.setBlockState(new BlockPos(x, y, z + 1), Lower2, 3);
					
					worldIn.playSound(playerIn, pos, SE, SoundCategory.BLOCKS, 1.0F, 0.8F);
					if (!mode) { stack.shrink(1); }
					return EnumActionResult.SUCCESS; }
				
				if (direction == EnumFacing.WEST && block.isReplaceable(worldIn, new BlockPos(x, y, z - 1))) {
					worldIn.setBlockState(pos.up(), Upper1, 3);
					worldIn.setBlockState(pos, Lower1, 3);
					worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), Upper2, 3);
					worldIn.setBlockState(new BlockPos(x, y, z - 1), Lower2, 3);
					
					worldIn.playSound(playerIn, pos, SE, SoundCategory.BLOCKS, 1.0F, 0.8F);
					if (!mode) { stack.shrink(1); }
					return EnumActionResult.SUCCESS; }
				
				else { 
					CMEvents.textNoSpace(worldIn, playerIn);
					return EnumActionResult.FAIL; }
			}

			/** デフォルトは left。右取手・左蝶番で開くのが hinge=left **/
			else {
				
				IBlockState Upper1 = this.takeBlock(playerIn, hand).getDefaultState().withProperty(BaseGate.H_FACING, direction)
						.withProperty(BaseGate.HALF, HalfState.UPPER).withProperty(BaseGate.OPEN, Boolean.valueOf(false))
						.withProperty(BaseGate.HINGE, HingeState.LEFT).withProperty(BaseGate.POWERED, Boolean.valueOf(false));
				IBlockState Lower1 = this.takeBlock(playerIn, hand).getDefaultState().withProperty(BaseGate.H_FACING, direction)
						.withProperty(BaseGate.HALF, HalfState.LOWER).withProperty(BaseGate.OPEN, Boolean.valueOf(false))
						.withProperty(BaseGate.HINGE, HingeState.LEFT).withProperty(BaseGate.POWERED, Boolean.valueOf(false));
				IBlockState Upper2 = this.takeBlock2(playerIn, hand).getDefaultState().withProperty(BaseGate.H_FACING, direction)
						.withProperty(BaseGate.HALF, HalfState.UPPER).withProperty(BaseGate.OPEN, Boolean.valueOf(false))
						.withProperty(BaseGate.HINGE, HingeState.LEFT).withProperty(BaseGate.POWERED, Boolean.valueOf(false));
				IBlockState Lower2 = this.takeBlock2(playerIn, hand).getDefaultState().withProperty(BaseGate.H_FACING, direction)
						.withProperty(BaseGate.HALF, HalfState.LOWER).withProperty(BaseGate.OPEN, Boolean.valueOf(false))
						.withProperty(BaseGate.HINGE, HingeState.LEFT).withProperty(BaseGate.POWERED, Boolean.valueOf(false));
				
				if (direction == EnumFacing.NORTH && block.isReplaceable(worldIn, new BlockPos(x - 1, y, z))) {
					worldIn.setBlockState(pos.up(), Upper1, 3);
					worldIn.setBlockState(pos, Lower1, 3);
					worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), Upper2, 3);
					worldIn.setBlockState(new BlockPos(x - 1, y, z), Lower2, 3);
					
					worldIn.playSound(playerIn, pos, SE, SoundCategory.BLOCKS, 1.0F, 0.8F);
					if (!mode) { stack.shrink(1); }
					return EnumActionResult.SUCCESS; }
				
				if (direction == EnumFacing.SOUTH && block.isReplaceable(worldIn, new BlockPos(x + 1, y, z))) {
					worldIn.setBlockState(pos.up(), Upper1, 3);
					worldIn.setBlockState(pos, Lower1, 3);
					worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), Upper2, 3);
					worldIn.setBlockState(new BlockPos(x + 1, y, z), Lower2, 3);
					
					worldIn.playSound(playerIn, pos, SE, SoundCategory.BLOCKS, 1.0F, 0.8F);
					if (!mode) { stack.shrink(1); }
					return EnumActionResult.SUCCESS; }
				
				if (direction == EnumFacing.EAST && block.isReplaceable(worldIn, new BlockPos(x, y, z - 1))) {
					worldIn.setBlockState(pos.up(), Upper1, 3);
					worldIn.setBlockState(pos, Lower1, 3);
					worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), Upper2, 3);
					worldIn.setBlockState(new BlockPos(x, y, z - 1), Lower2, 3);
					
					worldIn.playSound(playerIn, pos, SE, SoundCategory.BLOCKS, 1.0F, 0.8F);
					if (!mode) { stack.shrink(1); }
					return EnumActionResult.SUCCESS; }
				
				if (direction == EnumFacing.WEST && block.isReplaceable(worldIn, new BlockPos(x, y, z + 1))) {
					worldIn.setBlockState(pos.up(), Upper1, 3);
					worldIn.setBlockState(pos, Lower1, 3);
					worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), Upper2, 3);
					worldIn.setBlockState(new BlockPos(x, y, z + 1), Lower2, 3);
					
					worldIn.playSound(playerIn, pos, SE, SoundCategory.BLOCKS, 1.0F, 0.8F);
					if (!mode) { stack.shrink(1); }
					return EnumActionResult.SUCCESS; }

				else { 
					CMEvents.textNoSpace(worldIn, playerIn);
					return EnumActionResult.FAIL; }
			}
		}

		else { return EnumActionResult.FAIL; }
	}

	private Block takeBlock(EntityPlayer playerIn, EnumHand hand) {
		ItemStack stack = playerIn.getHeldItem(hand);
		int k;
		k = stack.getMetadata();
		
		if (k == 0) { return Gate_Blocks.GATE_SPRUCE_B; }
		if (k == 1) { return Gate_Blocks.GATE_SPRUCE; }
		if (k == 2) { return Gate_Blocks.GATE_IRON; }
		if (k == 3) { return Gate_Blocks.GATE_IRONGRILL; }
		return null;
	}
	
	private Block takeBlock2(EntityPlayer playerIn, EnumHand hand) {
		ItemStack stack = playerIn.getHeldItem(hand);
		int k;
		k = stack.getMetadata();
		
		if (k == 0) { return Gate_Blocks.GATE_SPRUCE_B2; }
		if (k == 1) { return Gate_Blocks.GATE_SPRUCE2; }
		if (k == 2) { return Gate_Blocks.GATE_IRON2; }
		if (k == 3) { return Gate_Blocks.GATE_IRONGRILL2; }
		return null;
	}
	
	/* tips */
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_gate.name", meta));
	}
}
