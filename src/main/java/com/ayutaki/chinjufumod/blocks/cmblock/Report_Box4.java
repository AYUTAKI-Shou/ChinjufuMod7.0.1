package com.ayutaki.chinjufumod.blocks.cmblock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Chinjufu_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Chinjufu;

import net.minecraft.block.BlockDynamicLiquid;
import net.minecraft.block.BlockStaticLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Report_Box4 extends Base_Report {

	public Report_Box4(String name) {
		super(name);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		int i = state.getValue(STAGE_1_4);
		int gc = stack.getCount();
	
		EnumFacing direction = state.getValue(H_FACING);

		IBlockState northState = worldIn.getBlockState(pos.north());
		IBlockState southState = worldIn.getBlockState(pos.south());
		IBlockState eastState = worldIn.getBlockState(pos.east());
		IBlockState westState = worldIn.getBlockState(pos.west());
		/* 1=E, 2=B, 3=R, 4=P | 5=N, 6=-1, 7=N, 8=-2 | 9=N, 10=-3, 11=N, 12=-4 | 13=N, 14=-5, 15=N | */
		boolean repo = (i == 1 || i == 3);
		
		switch (direction) {
		case NORTH:
		default:
			if (!northState.getMaterial().isReplaceable()) { 
				CMEvents.textIsBlocked(worldIn, pos, playerIn); }
			
			if (northState.getMaterial().isReplaceable()) {
				if (northState.getBlock() instanceof BlockStaticLiquid || northState.getBlock() instanceof BlockDynamicLiquid) {
					CMEvents.textIsBlocked(worldIn, pos, playerIn); }
				
				if (!(northState.getBlock() instanceof BlockStaticLiquid) && !(northState.getBlock() instanceof BlockDynamicLiquid)) {

					if (i == 2) {
						if (item == Items.ROTTEN_FLESH && gc >= 16) { 
							this.Consume_1(worldIn, pos, playerIn, hand);
							worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
						
						if (item == Items.ROTTEN_FLESH && gc < 16) { CMEvents.textNotEnough_Items(worldIn, pos, playerIn); }
						
						if (item != Items.ROTTEN_FLESH && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					} 
					
					if (repo && stack.isEmpty()) {
						worldIn.playSound(null, pos, SoundEvents.BLOCK_NOTE_BELL, SoundCategory.BLOCKS, 1.0F, 1.0F);
						playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Chinjufu.WORK_ORDER, 5, 0));
						
						if (i == 1) { worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
						if (i == 3) {
							worldIn.setBlockState(pos, Chinjufu_Blocks.REPORT_BOX1.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(STAGE_1_4, Integer.valueOf(1)), 3); } }
				} }
			break;

		case SOUTH:
			if (!southState.getMaterial().isReplaceable()) { 
				CMEvents.textIsBlocked(worldIn, pos, playerIn); }
			
			if (southState.getMaterial().isReplaceable()) {
				if (southState.getBlock() instanceof BlockStaticLiquid || southState.getBlock() instanceof BlockDynamicLiquid) {
					CMEvents.textIsBlocked(worldIn, pos, playerIn); }
				
				if (!(southState.getBlock() instanceof BlockStaticLiquid) && !(southState.getBlock() instanceof BlockDynamicLiquid)) {

					if (i == 2) {
						if (item == Items.ROTTEN_FLESH && gc >= 16) { 
							this.Consume_1(worldIn, pos, playerIn, hand);
							worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
						
						if (item == Items.ROTTEN_FLESH && gc < 16) { CMEvents.textNotEnough_Items(worldIn, pos, playerIn); }
						
						if (item != Items.ROTTEN_FLESH && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					} 
					
					if (repo && stack.isEmpty()) {
						worldIn.playSound(null, pos, SoundEvents.BLOCK_NOTE_BELL, SoundCategory.BLOCKS, 1.0F, 1.0F);
						playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Chinjufu.WORK_ORDER, 5, 0));
						
						if (i == 1) { worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
						if (i == 3) {
							worldIn.setBlockState(pos, Chinjufu_Blocks.REPORT_BOX1.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(STAGE_1_4, Integer.valueOf(1)), 3); } }
				} }
			break;

		case EAST:
			if (!eastState.getMaterial().isReplaceable()) { 
				CMEvents.textIsBlocked(worldIn, pos, playerIn); }
			
			if (eastState.getMaterial().isReplaceable()) {
				if (eastState.getBlock() instanceof BlockStaticLiquid || eastState.getBlock() instanceof BlockDynamicLiquid) {
					CMEvents.textIsBlocked(worldIn, pos, playerIn); }
				
				if (!(eastState.getBlock() instanceof BlockStaticLiquid) && !(eastState.getBlock() instanceof BlockDynamicLiquid)) {

					if (i == 2) {
						if (item == Items.ROTTEN_FLESH && gc >= 16) { 
							this.Consume_1(worldIn, pos, playerIn, hand);
							worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
						
						if (item == Items.ROTTEN_FLESH && gc < 16) { CMEvents.textNotEnough_Items(worldIn, pos, playerIn); }
						
						if (item != Items.ROTTEN_FLESH && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					} 
					
					if (repo && stack.isEmpty()) {
						worldIn.playSound(null, pos, SoundEvents.BLOCK_NOTE_BELL, SoundCategory.BLOCKS, 1.0F, 1.0F);
						playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Chinjufu.WORK_ORDER, 5, 0));
						
						if (i == 1) { worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
						if (i == 3) {
							worldIn.setBlockState(pos, Chinjufu_Blocks.REPORT_BOX1.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(STAGE_1_4, Integer.valueOf(1)), 3); } }
				} }
			break;
			
		case WEST:
			if (!westState.getMaterial().isReplaceable()) { 
				CMEvents.textIsBlocked(worldIn, pos, playerIn); }
			
			if (westState.getMaterial().isReplaceable()) {
				if (westState.getBlock() instanceof BlockStaticLiquid || westState.getBlock() instanceof BlockDynamicLiquid) {
					CMEvents.textIsBlocked(worldIn, pos, playerIn); }
				
				if (!(westState.getBlock() instanceof BlockStaticLiquid) && !(westState.getBlock() instanceof BlockDynamicLiquid)) {

					if (i == 2) {
						if (item == Items.ROTTEN_FLESH && gc >= 16) { 
							this.Consume_1(worldIn, pos, playerIn, hand);
							worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
						
						if (item == Items.ROTTEN_FLESH && gc < 16) { CMEvents.textNotEnough_Items(worldIn, pos, playerIn); }
						
						if (item != Items.ROTTEN_FLESH && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					} 
					
					if (repo && stack.isEmpty()) {
						worldIn.playSound(null, pos, SoundEvents.BLOCK_NOTE_BELL, SoundCategory.BLOCKS, 1.0F, 1.0F);
						playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Chinjufu.WORK_ORDER, 5, 0));
						
						if (i == 1) { worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
						if (i == 3) {
							worldIn.setBlockState(pos, Chinjufu_Blocks.REPORT_BOX1.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(STAGE_1_4, Integer.valueOf(1)), 3); } }
				} }
			break;
		} // switch
		
		return true;
	}

	private void Consume_1(World worldIn, BlockPos pos, EntityPlayer playerIn, EnumHand hand) {
		ItemStack stack = playerIn.getHeldItem(hand);
		boolean mode = playerIn.capabilities.isCreativeMode;
		if (!mode) { stack.shrink(16); }
		if (mode) { }
		worldIn.playSound(null, pos, SoundEvents.BLOCK_CLOTH_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F); }
	
	
	/* RandomTick */
	@Override
	public void randomTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (!worldIn.isAreaLoaded(pos, 1)) return;
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (i != 2 && i != 4) {
			worldIn.playSound(null, pos, SoundEvents.BLOCK_NOTE_BELL, SoundCategory.BLOCKS, 1.0F, 1.0F);
			this.dropOrder(state, worldIn, pos);
			
			if (i == 1) { worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
			if (i == 3) {
				worldIn.setBlockState(pos, Chinjufu_Blocks.REPORT_BOX1.getDefaultState()
					.withProperty(H_FACING, state.getValue(H_FACING))
					.withProperty(STAGE_1_4, Integer.valueOf(1)), 3); }
		}
	}
	
	@Override
	public int tickRate(World worldIn) {
		return 120;
	}
	
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		worldIn.scheduleUpdate(pos, Chinjufu_Blocks.REPORT_BOX4, this.tickRate(worldIn));
	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (i != 2 && i != 4) {
			worldIn.scheduleUpdate(pos, Chinjufu_Blocks.REPORT_BOX4, this.tickRate(worldIn));
			worldIn.playSound(null, pos, SoundEvents.BLOCK_NOTE_BELL, SoundCategory.BLOCKS, 1.0F, 1.0F);
			this.dropOrder(state, worldIn, pos);
			if (i == 1) { worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
			
			if (i == 3) {
				worldIn.setBlockState(pos, Chinjufu_Blocks.REPORT_BOX1.getDefaultState()
					.withProperty(H_FACING, state.getValue(H_FACING))
					.withProperty(STAGE_1_4, Integer.valueOf(1)), 3); }
		}
	}

	@Override
	public void randomDisplayTick(IBlockState state, World worldIn, BlockPos pos, Random rand) {
		int i = state.getValue(STAGE_1_4);
		
		if (i == 1 || i == 3) {
			for(int k = 0; k < 5; ++k) {
			double x = pos.getX();
			double y = pos.getY();
			double z = pos.getZ();
			worldIn.playSound(x, y, z, SoundEvents_CM.NOISE, SoundCategory.BLOCKS, 0.3F, 1.0F, false); }
		}
	}
	
	/*Drop Item and Clone Item.*/
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (i == 1) { 
			stack.add(new ItemStack(Items.PAPER, 10, 0));
			stack.add(new ItemStack(Items_Chinjufu.REPORT_BOX, 1, 0)); }
		if (i == 2) { 
			stack.add(new ItemStack(Items.PAPER, 5, 0));
			stack.add(new ItemStack(Items_Chinjufu.REPORT_BOX, 1, 0)); }
		if (i == 3) { 
			stack.add(new ItemStack(Items.PAPER, 5, 0));
			stack.add(new ItemStack(Items_Chinjufu.REPORT_BOX, 1, 0)); }
		if (i == 4) { 
			stack.add(new ItemStack(Items.PAPER, 5, 0));
			stack.add(new ItemStack(Items_Chinjufu.REPORT_BOX, 1, 0)); }
		return stack;
	}
}
