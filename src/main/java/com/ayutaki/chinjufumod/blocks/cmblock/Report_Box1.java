package com.ayutaki.chinjufumod.blocks.cmblock;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.base.BaseStage4_Face;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Chinjufu_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Chinjufu;

import net.minecraft.block.BlockDynamicLiquid;
import net.minecraft.block.BlockStaticLiquid;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Report_Box1 extends BaseStage4_Face {

	public Report_Box1(String name) {
		super(name);
		setCreativeTab(ChinjufuModTabs.CHINJUFU);
		setSoundType(SoundType.METAL);
		setHardness(1.0F);
		setResistance(10.0F);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		int k;
		k = stack.getMetadata();

		int i = state.getValue(STAGE_1_4);
		int gc = stack.getCount();
		boolean mode = playerIn.capabilities.isCreativeMode;
		
		EnumFacing direction = state.getValue(H_FACING);

		IBlockState northState = worldIn.getBlockState(pos.north());
		IBlockState southState = worldIn.getBlockState(pos.south());
		IBlockState eastState = worldIn.getBlockState(pos.east());
		IBlockState westState = worldIn.getBlockState(pos.west());
		
		switch (direction) {
		case NORTH:
		default:
			if (!northState.getMaterial().isReplaceable()) { 
				CMEvents.textIsBlocked(worldIn, pos, playerIn); }
			
			if (northState.getMaterial().isReplaceable()) {
				if (northState.getBlock() instanceof BlockStaticLiquid || northState.getBlock() instanceof BlockDynamicLiquid) {
					CMEvents.textIsBlocked(worldIn, pos, playerIn); }
				
				if (!(northState.getBlock() instanceof BlockStaticLiquid) && !(northState.getBlock() instanceof BlockDynamicLiquid)) {
					if (i == 1) {
						if (item == Items.DYE && k == 0) {
							CMEvents.Consume_1Item(playerIn, hand);
							CMEvents.soundBottleFill(worldIn, pos);
							worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
						
						if (item != Items.DYE && k != 0 && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					}
					
					if (i == 2) {
						if (item == Items.DYE && k == 1) {
							CMEvents.Consume_1Item(playerIn, hand);
							CMEvents.soundBottleFill(worldIn, pos);
							worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
						
						if (item != Items.DYE && k != 1 && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					}
					
					if (i == 3) {
						if (item == Items.PAPER && gc >= 30) { 
								if (!mode) { stack.shrink(30); }
								if (mode) { } 
								CMEvents.soundWoolPlace(worldIn, pos);
								worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
						
						if (item == Items.PAPER && gc < 30) { CMEvents.textNotEnough_Items(worldIn, pos, playerIn); }
						
						if (item != Items.PAPER && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					}
					
					if (i == 4) {
						if (item == Items.ROTTEN_FLESH && gc >= 16) { 
							if (!mode) { stack.shrink(16); }
							if (mode) { } 
							CMEvents.soundWoolPlace(worldIn, pos);
							worldIn.setBlockState(pos, Chinjufu_Blocks.REPORT_BOX2.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(STAGE_1_4, Integer.valueOf(1)), 3); }
						
						if (item == Items.ROTTEN_FLESH && gc < 16) { CMEvents.textNotEnough_Items(worldIn, pos, playerIn); }
						
						if (item != Items.ROTTEN_FLESH && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					} } }
			break;

		case SOUTH:
			if (!southState.getMaterial().isReplaceable()) { 
				CMEvents.textIsBlocked(worldIn, pos, playerIn); }
			
			if (southState.getMaterial().isReplaceable()) {
				if (southState.getBlock() instanceof BlockStaticLiquid || southState.getBlock() instanceof BlockDynamicLiquid) {
					CMEvents.textIsBlocked(worldIn, pos, playerIn); }
				
				if (!(southState.getBlock() instanceof BlockStaticLiquid) && !(southState.getBlock() instanceof BlockDynamicLiquid)) {
					if (i == 1) {
						if (item == Items.DYE && k == 0) {
							CMEvents.Consume_1Item(playerIn, hand);
							CMEvents.soundBottleFill(worldIn, pos);
							worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
						
						if (item != Items.DYE && k != 0 && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					}
					
					if (i == 2) {
						if (item == Items.DYE && k == 1) {
							CMEvents.Consume_1Item(playerIn, hand);
							CMEvents.soundBottleFill(worldIn, pos);
							worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
						
						if (item != Items.DYE && k != 1 && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					}
					
					if (i == 3) {
						if (item == Items.PAPER && gc >= 30) { 
								if (!mode) { stack.shrink(30); }
								if (mode) { } 
								CMEvents.soundWoolPlace(worldIn, pos);
								worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
						
						if (item == Items.PAPER && gc < 30) { CMEvents.textNotEnough_Items(worldIn, pos, playerIn); }
						
						if (item != Items.PAPER && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					}
					
					if (i == 4) {
						if (item == Items.ROTTEN_FLESH && gc >= 16) { 
							if (!mode) { stack.shrink(16); }
							if (mode) { } 
							CMEvents.soundWoolPlace(worldIn, pos);
							worldIn.setBlockState(pos, Chinjufu_Blocks.REPORT_BOX2.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(STAGE_1_4, Integer.valueOf(1)), 3); }
						
						if (item == Items.ROTTEN_FLESH && gc < 16) { CMEvents.textNotEnough_Items(worldIn, pos, playerIn); }
						
						if (item != Items.ROTTEN_FLESH && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					} } }
			break;

		case EAST:
			if (!eastState.getMaterial().isReplaceable()) { 
				CMEvents.textIsBlocked(worldIn, pos, playerIn); }
			
			if (eastState.getMaterial().isReplaceable()) {
				if (eastState.getBlock() instanceof BlockStaticLiquid || eastState.getBlock() instanceof BlockDynamicLiquid) {
					CMEvents.textIsBlocked(worldIn, pos, playerIn); }
				
				if (!(eastState.getBlock() instanceof BlockStaticLiquid) && !(eastState.getBlock() instanceof BlockDynamicLiquid)) {
					if (i == 1) {
						if (item == Items.DYE && k == 0) {
							CMEvents.Consume_1Item(playerIn, hand);
							CMEvents.soundBottleFill(worldIn, pos);
							worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
						
						if (item != Items.DYE && k != 0 && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					}
					
					if (i == 2) {
						if (item == Items.DYE && k == 1) {
							CMEvents.Consume_1Item(playerIn, hand);
							CMEvents.soundBottleFill(worldIn, pos);
							worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
						
						if (item != Items.DYE && k != 1 && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					}
					
					if (i == 3) {
						if (item == Items.PAPER && gc >= 30) { 
								if (!mode) { stack.shrink(30); }
								if (mode) { } 
								CMEvents.soundWoolPlace(worldIn, pos);
								worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
						
						if (item == Items.PAPER && gc < 30) { CMEvents.textNotEnough_Items(worldIn, pos, playerIn); }
						
						if (item != Items.PAPER && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					}
					
					if (i == 4) {
						if (item == Items.ROTTEN_FLESH && gc >= 16) { 
							if (!mode) { stack.shrink(16); }
							if (mode) { } 
							CMEvents.soundWoolPlace(worldIn, pos);
							worldIn.setBlockState(pos, Chinjufu_Blocks.REPORT_BOX2.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(STAGE_1_4, Integer.valueOf(1)), 3); }
						
						if (item == Items.ROTTEN_FLESH && gc < 16) { CMEvents.textNotEnough_Items(worldIn, pos, playerIn); }
						
						if (item != Items.ROTTEN_FLESH && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					} } }
			break;
			
		case WEST:
			if (!westState.getMaterial().isReplaceable()) { 
				CMEvents.textIsBlocked(worldIn, pos, playerIn); }
			
			if (westState.getMaterial().isReplaceable()) {
				if (westState.getBlock() instanceof BlockStaticLiquid || westState.getBlock() instanceof BlockDynamicLiquid) {
					CMEvents.textIsBlocked(worldIn, pos, playerIn); }
				
				if (!(westState.getBlock() instanceof BlockStaticLiquid) && !(westState.getBlock() instanceof BlockDynamicLiquid)) {
					if (i == 1) {
						if (item == Items.DYE && k == 0) {
							CMEvents.Consume_1Item(playerIn, hand);
							CMEvents.soundBottleFill(worldIn, pos);
							worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
						
						if (item != Items.DYE && k != 0 && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					}
					
					if (i == 2) {
						if (item == Items.DYE && k == 1) {
							CMEvents.Consume_1Item(playerIn, hand);
							CMEvents.soundBottleFill(worldIn, pos);
							worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
						
						if (item != Items.DYE && k != 1 && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					}
					
					if (i == 3) {
						if (item == Items.PAPER && gc >= 30) { 
								if (!mode) { stack.shrink(30); }
								if (mode) { } 
								CMEvents.soundWoolPlace(worldIn, pos);
								worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
						
						if (item == Items.PAPER && gc < 30) { CMEvents.textNotEnough_Items(worldIn, pos, playerIn); }
						
						if (item != Items.PAPER && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					}
					
					if (i == 4) {
						if (item == Items.ROTTEN_FLESH && gc >= 16) { 
							if (!mode) { stack.shrink(16); }
							if (mode) { } 
							CMEvents.soundWoolPlace(worldIn, pos);
							worldIn.setBlockState(pos, Chinjufu_Blocks.REPORT_BOX2.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(STAGE_1_4, Integer.valueOf(1)), 3); }
						
						if (item == Items.ROTTEN_FLESH && gc < 16) { CMEvents.textNotEnough_Items(worldIn, pos, playerIn); }
						
						if (item != Items.ROTTEN_FLESH && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					} } }
			break;
		} // switch
		
		return true;
	}
	
	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}
	
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (i == 1) { stack.add(new ItemStack(Items_Chinjufu.REPORT_BOX, 1, 0)); }
		if (i == 2) { 
			stack.add(new ItemStack(Items.DYE, 1, 0));
			stack.add(new ItemStack(Items_Chinjufu.REPORT_BOX, 1, 0)); }
		if (i == 3) { 
			stack.add(new ItemStack(Items.DYE, 1, 0));
			stack.add(new ItemStack(Items.DYE, 1, 1));
			stack.add(new ItemStack(Items_Chinjufu.REPORT_BOX, 1, 0)); }
		if (i == 4) { 
			stack.add(new ItemStack(Items.DYE, 1, 0));
			stack.add(new ItemStack(Items.DYE, 1, 1));
			stack.add(new ItemStack(Items.PAPER, 30, 0));
			stack.add(new ItemStack(Items_Chinjufu.REPORT_BOX, 1, 0)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn,
			BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Items_Chinjufu.REPORT_BOX, 1, 0);
	}

	/* Harvest by Pickaxe. */
	@Nullable
	@Override
	public String getHarvestTool(IBlockState state) {
		return "pickaxe";
	}

	@Override
	public int getHarvestLevel(IBlockState state) {
		return 0;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_report_box.name", meta));
	}
}
