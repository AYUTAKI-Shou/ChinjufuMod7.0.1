package com.ayutaki.chinjufumod.blocks.furniture;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingSapo;
import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.entity.SitableEntity;
import com.ayutaki.chinjufumod.registry.Furniture_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Chinjufu;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class DressingTable extends BaseFacingSapo {

	private static final AxisAlignedBB AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.75, 1.0);

	private static final AxisAlignedBB AABB_BASE = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.75, 1.0);
	private static final AxisAlignedBB AABB_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.125, 0.75, 0.125, 0.1875, 1.0, 0.875);
	private static final AxisAlignedBB AABB_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.125, 0.75, 0.125, 0.1875, 1.0, 0.875);
	private static final AxisAlignedBB AABB_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.125, 0.75, 0.125, 0.1875, 1.0, 0.875);
	private static final AxisAlignedBB AABB_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.125, 0.75, 0.125, 0.1875, 1.0, 0.875);

	public DressingTable(String name) {
		super(name, Material.WOOD);
		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(5.0F);
		setLightOpacity(1);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return AABB;
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, Entity entityIn, boolean t_f) {

		if (!(entityIn instanceof SitableEntity)) {

			EnumFacing facing = state.getValue(H_FACING);
			switch(facing) {
			case SOUTH:
				super.addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_SOUTH);
				break;
				
			case EAST:
				super.addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_EAST);
				break;
				
			case WEST:
				super.addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_WEST);
				break;
				
			case NORTH:
			default:
				super.addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_NORTH);
				break;
			}
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_BASE);
		}
	}

	/* A place where you can put it. */
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos).getMaterial().isReplaceable() && worldIn.getBlockState(pos.up()).getMaterial().isReplaceable();
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
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	/* A block that breaks at the same time when it is broken. */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn) {
		if (worldIn.getBlockState(pos.up()).getBlock() instanceof DressingTable_Top) {
			worldIn.destroyBlock(pos.up(), false);
		}
	}

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		stack.add(this.takeStack());
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return this.takeStack();
	}
	
	private ItemStack takeStack() {

		if (this == Furniture_Blocks.DRESSINGTABLE) { return new ItemStack(Items_Chinjufu.DRESSINGTABLE_item, 1, 0); }
		if (this == Furniture_Blocks.DRESSINGTABLE_s) { return new ItemStack(Items_Chinjufu.DRESSINGTABLE_item, 1, 1); }
		if (this == Furniture_Blocks.DRESSINGTABLE_b) { return new ItemStack(Items_Chinjufu.DRESSINGTABLE_item, 1, 2); }
		if (this == Furniture_Blocks.DRESSINGTABLE_j) { return new ItemStack(Items_Chinjufu.DRESSINGTABLE_item, 1, 3); }
		if (this == Furniture_Blocks.DRESSINGTABLE_a) { return new ItemStack(Items_Chinjufu.DRESSINGTABLE_item, 1, 4); }
		if (this == Furniture_Blocks.DRESSINGTABLE_d) { return new ItemStack(Items_Chinjufu.DRESSINGTABLE_item, 1, 5); }
		if (this == Furniture_Blocks.DRESSINGTABLE_saku) { return new ItemStack(Items_Chinjufu.DRESSINGTABLE_item, 1, 6); }
		if (this == Furniture_Blocks.DRESSINGTABLE_kae) { return new ItemStack(Items_Chinjufu.DRESSINGTABLE_item, 1, 7); }
		if (this == Furniture_Blocks.DRESSINGTABLE_ich) { return new ItemStack(Items_Chinjufu.DRESSINGTABLE_item, 1, 8); }
		return null;
	}
}
