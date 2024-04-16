package com.ayutaki.chinjufumod.blocks.cmblock;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage4_Face;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Chinjufu_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Chinjufu;

import net.minecraft.block.SoundType;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class AlumiBlock extends BaseStage4_Face {

	/** 1=アルミ, 2=鋼材, 3=金 **/
	public AlumiBlock(String name) {
		super(name);
		setSoundType(SoundType.METAL);
		setHardness(1.0F);
		setResistance(10.0F);
		setLightOpacity(1);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		int k;
		k = stack.getMetadata();

		/** Hand is Empty.。取り尽くしを考慮してクリエイティブでも回収はできるようにする **/
		if (stack.isEmpty() && facing == EnumFacing.UP) {
			if (i == 1) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Chinjufu.ALUMI, 1, 1));

				CMEvents.soundItemPick(worldIn, pos);
				worldIn.setBlockState(pos, Blocks.AIR.getDefaultState()); }

			if (i == 2) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Chinjufu.ALUMI, 1, 2));

				CMEvents.soundItemPick(worldIn, pos);
				worldIn.setBlockState(pos, Blocks.AIR.getDefaultState()); }

			if (i == 3) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Chinjufu.ALUMI, 1, 3));

				CMEvents.soundItemPick(worldIn, pos);
				worldIn.setBlockState(pos, Blocks.AIR.getDefaultState()); }
			return true;
		}

		if (!stack.isEmpty()) { 
			/** Double にする。クリエイティブではアイテムを消費させない **/
			if (i == 1 && item == Items_Chinjufu.ALUMI && k == 1 && facing == EnumFacing.UP) {
				CMEvents.Consume_1Item(playerIn, hand);
	
				worldIn.playSound(null, pos, SoundEvents.BLOCK_METAL_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F);
				worldIn.setBlockState(pos, Chinjufu_Blocks.ALUMI_W.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1))); }
	
			if (i == 2 && item == Items_Chinjufu.ALUMI && k == 2 && facing == EnumFacing.UP) {
				CMEvents.Consume_1Item(playerIn, hand);
	
				worldIn.playSound(null, pos, SoundEvents.BLOCK_METAL_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F);
				worldIn.setBlockState(pos, Chinjufu_Blocks.ALUMI_W.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(2))); }
	
			if (i == 3 && item == Items_Chinjufu.ALUMI && k == 3 && facing == EnumFacing.UP) {
				CMEvents.Consume_1Item(playerIn, hand);
	
				worldIn.playSound(null, pos, SoundEvents.BLOCK_METAL_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F);
				worldIn.setBlockState(pos, Chinjufu_Blocks.ALUMI_W.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(3))); }
			
			if (item != Items_Chinjufu.ALUMI) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			
			return true;
		}
		
		return false;
	}


	/*Collision*/
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D);
	}

	/* A torch can be placed on top. true or false */
	@Override
	public boolean isTopSolid(IBlockState state) {
		return false;
	}

	/* A torch can be placed on the side. */
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
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
	
	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
		return true;
	}
	
	protected ItemStack getSilkTouchDrop(IBlockState state) {
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		
		if (i == 2) { return new ItemStack(Items_Chinjufu.ALUMI, 1, 2); }
		if (i == 3) { return new ItemStack(Items_Chinjufu.ALUMI, 1, 3); }
		return new ItemStack(Items_Chinjufu.ALUMI, 1, 1);
	}
	
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		
		if (i == 1) { stack.add(new ItemStack(Items_Chinjufu.ALUMINUM, 4, 0)); }
		if (i == 2) { stack.add(new ItemStack(Items.IRON_INGOT, 4, 0)); }
		if (i == 3) { stack.add(new ItemStack(Items.GOLD_INGOT, 4, 0)); }
		return stack;
	}
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		
		if (i == 2) { return new ItemStack(Items_Chinjufu.ALUMI, 1, 2); }
		if (i == 3) { return new ItemStack(Items_Chinjufu.ALUMI, 1, 3); }
		return new ItemStack(Items_Chinjufu.ALUMI, 1, 1);
	}
}
