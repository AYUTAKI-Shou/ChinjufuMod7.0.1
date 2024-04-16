package com.ayutaki.chinjufumod.blocks.garden;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage3_Face;
import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.Lamp_Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Takeakari extends BaseStage3_Face {

	private static final AxisAlignedBB AABB_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.09375, 0.0, 0.40625, 0.28125, 0.5, 0.59375);
	private static final AxisAlignedBB AABB_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.09375, 0.0, 0.40625, 0.28125, 0.5, 0.59375);
	private static final AxisAlignedBB AABB_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.09375, 0.0, 0.40625, 0.28125, 0.5, 0.59375);
	private static final AxisAlignedBB AABB_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.09375, 0.0, 0.40625, 0.28125, 0.5, 0.59375);
	private static final AxisAlignedBB[] AABB = { AABB_SOUTH, AABB_WEST, AABB_NORTH, AABB_EAST };

	public Takeakari(String name) {
		super(name);
		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(1.0F);

		setLightOpacity(0);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		EnumFacing facing = state.getValue(H_FACING);
		return AABB[facing.getHorizontalIndex()];
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		/** Have no collision. **/
		return NULL_AABB;
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		int i = state.getValue(STAGE_1_3);
		
		if (item == Items.FLINT_AND_STEEL) {
			CMEvents.soundFlint(worldIn, pos);

			if (i == 1) {
				worldIn.setBlockState(pos, Lamp_Blocks.LIT_TAKEAKARI.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(STAGE_1_3, Integer.valueOf(1))); }
			
			if (i == 2) {
				worldIn.setBlockState(pos, Lamp_Blocks.LIT_TAKEAKARI.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(STAGE_1_3, Integer.valueOf(2))); }
			
			if (i == 3) {
				worldIn.setBlockState(pos, Lamp_Blocks.LIT_TAKEAKARI.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(STAGE_1_3, Integer.valueOf(3))); }
			
			stack.damageItem(1, playerIn);
		}

		if (item == Items_Teatime.Item_MATCH) {
			CMEvents.Consume1Item_Flint(worldIn, pos, playerIn, hand);	
			
			if (i == 1) {
				worldIn.setBlockState(pos, Lamp_Blocks.LIT_TAKEAKARI.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(STAGE_1_3, Integer.valueOf(1))); }
			
			if (i == 2) {
				worldIn.setBlockState(pos, Lamp_Blocks.LIT_TAKEAKARI.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(STAGE_1_3, Integer.valueOf(2))); }
			
			if (i == 3) {
				worldIn.setBlockState(pos, Lamp_Blocks.LIT_TAKEAKARI.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(STAGE_1_3, Integer.valueOf(3))); }
		}
		/** 'true' to not put anything on top. **/
		return true;
	}

	/* A torch can be placed on top. true or false */
	public boolean isTopSolid(IBlockState state) {
		return false;
	}

	/* A torch can be placed on the side. */
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	/* Rendering */
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	public boolean isFullCube(IBlockState state) {
		return false;
	}

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		int i = state.getValue(STAGE_1_3);
		
		if (i == 1) { stack.add(new ItemStack(Items_Wadeco.TAKEAKARI, 1, 0)); }
		if (i == 2) { stack.add(new ItemStack(Items_Wadeco.TAKEAKARI, 1, 1)); }
		if (i == 3) { stack.add(new ItemStack(Items_Wadeco.TAKEAKARI, 1, 2)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		int i = state.getValue(STAGE_1_3);
		
		if (i == 2) { return new ItemStack(Items_Wadeco.TAKEAKARI, 1, 1); }
		if (i == 3) { return new ItemStack(Items_Wadeco.TAKEAKARI, 1, 2); }
		return new ItemStack(Items_Wadeco.TAKEAKARI, 1, 0);
	}

}
