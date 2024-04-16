package com.ayutaki.chinjufumod.blocks.school;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingSapo;
import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.registry.Furniture_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Chinjufu;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class SchoolDesk extends BaseFacingSapo {

	/* Collision */
	private static final AxisAlignedBB AABB_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.0, 0.0, -0.1875, 1.0, 1.0, 1.1875);
	private static final AxisAlignedBB AABB_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.0, 0.0, -0.1875, 1.0, 1.0, 1.1875);
	private static final AxisAlignedBB AABB_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.0, 0.0, -0.1875, 1.0, 1.0, 1.1875);
	private static final AxisAlignedBB AABB_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.0, 0.0, -0.1875, 1.0, 1.0, 1.1875);
	private static final AxisAlignedBB[] AABB = { AABB_SOUTH, AABB_WEST, AABB_NORTH, AABB_EAST };

	public SchoolDesk(String name) {
		super(name, Material.WOOD);
		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(5.0F);
		setLightOpacity(1);
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		EnumFacing facing = state.getValue(H_FACING);
		return AABB[facing.getHorizontalIndex()];
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes,
			@Nullable Entity entityIn, boolean t_f) {
		EnumFacing facing = state.getValue(H_FACING);
		super.addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB[facing.getHorizontalIndex()]);
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

	/* Rendering */
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}
	
	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		stack.add(this.takeStack(state));
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return this.takeStack(state);
	}
	
	private ItemStack takeStack(IBlockState state) {
		if (this == Furniture_Blocks.SCHOOLDESK) { return new ItemStack(Items_Chinjufu.SCHOOLDESK_item, 1, 0); }
		if (this == Furniture_Blocks.SCHOOLDESK_s) { return new ItemStack(Items_Chinjufu.SCHOOLDESK_item, 1, 1); }
		if (this == Furniture_Blocks.SCHOOLDESK_b) { return new ItemStack(Items_Chinjufu.SCHOOLDESK_item, 1, 2); }
		if (this == Furniture_Blocks.SCHOOLDESK_j) { return new ItemStack(Items_Chinjufu.SCHOOLDESK_item, 1, 3); }
		if (this == Furniture_Blocks.SCHOOLDESK_a) { return new ItemStack(Items_Chinjufu.SCHOOLDESK_item, 1, 4); }
		if (this == Furniture_Blocks.SCHOOLDESK_d) { return new ItemStack(Items_Chinjufu.SCHOOLDESK_item, 1, 5); }
		if (this == Furniture_Blocks.SCHOOLDESK_saku) { return new ItemStack(Items_Chinjufu.SCHOOLDESK_item, 1, 6); }
		if (this == Furniture_Blocks.SCHOOLDESK_kae) { return new ItemStack(Items_Chinjufu.SCHOOLDESK_item, 1, 7); }
		if (this == Furniture_Blocks.SCHOOLDESK_ich) { return new ItemStack(Items_Chinjufu.SCHOOLDESK_item, 1, 8); } 
		return null;
	}
}
