package com.ayutaki.chinjufumod.blocks.kitchen;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.blocks.base.BaseStage4_Face;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Kitchen_Donabe extends BaseStage4_Face {

	public Kitchen_Donabe(String name) {
		super(name);
		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(10.0F);
		setLightOpacity(1);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side,
			float hitX, float hitY, float hitZ) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (stack.isEmpty()) {
			CMEvents.soundItemPick(worldIn, pos);

			if (i == 1) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.NABE_kara, 1, 0));
				worldIn.setBlockState(pos, Kitchen_Blocks.KITCHEN.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))); }

			if (i == 2) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.NABE_kara, 1, 0));
				worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i - 1)), 3); }

			if (i == 3) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.FRYPAN_kara, 1, 0));
				worldIn.setBlockState(pos, Kitchen_Blocks.KITCHEN.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))); }

			if (i == 4) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.FRYPAN_kara, 1, 0));
				worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i - 1)), 3); }
		}

		if (!stack.isEmpty()) {
			if (item == Items_Teatime.NABE_kara) {
				if (i == 1) {
					CMEvents.Consume_1Item(playerIn, hand);
					worldIn.playSound(null, pos, SoundEvents.BLOCK_STONE_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
				
				if (i != 1) { CMEvents.textFullItem(worldIn, pos, playerIn); } }
			
			if (item == Items_Teatime.FRYPAN_kara) {
				if (i == 3) {
					CMEvents.Consume_1Item(playerIn, hand);
					worldIn.playSound(null, pos, SoundEvents.BLOCK_METAL_PLACE, SoundCategory.BLOCKS, 1.0F, 3.0F);
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
				
				if (i != 3) { CMEvents.textFullItem(worldIn, pos, playerIn); } }
			
			if (item != Items_Teatime.NABE_kara && item != Items_Teatime.FRYPAN_kara) {
				CMEvents.textFullItem(worldIn, pos, playerIn); }
		}

		/** 'true' to not put anything on top. **/
		return true;
	}


	/* A torch can be placed on top. true or false */
	@Override
	public boolean isTopSolid(IBlockState state) {
		return true;
	}

	/* A torch can be placed on the side. */
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	/*Rendering */
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	/* Rendering */

	/*Drop Item and Clone Item.*/
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (i == 1) {
			stack.add(new ItemStack(Items_Teatime.KITCHEN, 1, 0));
			stack.add(new ItemStack(Items_Teatime.NABE_kara, 1, 0)); }

		if (i == 2) {
			stack.add(new ItemStack(Items_Teatime.KITCHEN, 1, 0));
			stack.add(new ItemStack(Items_Teatime.NABE_kara, 2, 0)); }

		if (i == 3) {
			stack.add(new ItemStack(Items_Teatime.KITCHEN, 1, 0));
			stack.add(new ItemStack(Items_Teatime.FRYPAN_kara, 1, 0)); }

		if (i == 4) {
			stack.add(new ItemStack(Items_Teatime.KITCHEN, 1, 0));
			stack.add(new ItemStack(Items_Teatime.FRYPAN_kara, 2, 0)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Items_Teatime.KITCHEN);
	}

}
