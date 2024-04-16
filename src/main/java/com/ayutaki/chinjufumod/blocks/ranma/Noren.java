package com.ayutaki.chinjufumod.blocks.ranma;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingSapo;
import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.JPDeco_Blocks;
import com.ayutaki.chinjufumod.state.TypeLR;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
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

public class Noren extends BaseFacingSapo {

	public static final PropertyEnum<TypeLR> TYPE = PropertyEnum.create("type", TypeLR.class);

	protected static final AxisAlignedBB AABB_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.0, 0.875, 0.0, 0.125, 1.0, 1.0);
	protected static final AxisAlignedBB AABB_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.0, 0.875, 0.0, 0.125, 1.0, 1.0);
	protected static final AxisAlignedBB AABB_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.0, 0.875, 0.0, 0.125, 1.0, 1.0);
	protected static final AxisAlignedBB AABB_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.0, 0.875, 0.0, 0.125, 1.0, 1.0);
	protected static final AxisAlignedBB[] AABB = { AABB_SOUTH, AABB_WEST, AABB_NORTH, AABB_EAST };

	public Noren(String name) {
		super(name, Material.WOOD);
		setSoundType(SoundType.WOOD);
		setHardness(0.5F);
		setResistance(1.0F);
		setLightOpacity(1);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		EnumFacing facing = state.getValue(H_FACING);
		return AABB[facing.getHorizontalIndex()];
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox,
			List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean t_f) {

		EnumFacing facing = state.getValue(H_FACING);
		super.addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB[facing.getHorizontalIndex()]);
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {

		EnumFacing facing = (EnumFacing) state.getValue(H_FACING);
		IBlockState left_block = worldIn.getBlockState(pos.offset(facing.rotateYCCW()));
		IBlockState right_block = worldIn.getBlockState(pos.offset(facing.rotateY()));
		boolean left = (left_block.getBlock() == this) && left_block.getValue(H_FACING).equals(facing);
		boolean right = (right_block.getBlock() == this) && right_block.getValue(H_FACING).equals(facing);

		 if (right) {

			if (left) { return state.withProperty(TYPE, TypeLR.BOTH); }

			else { return state.withProperty(TYPE, TypeLR.RIGHT); }
		}

		else if (left) {

			if (right) { return state.withProperty(TYPE, TypeLR.BOTH); }

			else { return state.withProperty(TYPE, TypeLR.LEFT); } }
		 
		return state.withProperty(TYPE, TypeLR.DEFAULT);
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { H_FACING, TYPE }) ;
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

	/* Rendering */
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
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
		stack.add(this.takeStack());
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return this.takeStack();
	}
	
	private ItemStack takeStack() {
		if (this == JPDeco_Blocks.NOREN_white) { return new ItemStack(Items_Wadeco.NOREN_item, 1, 0); }
		if (this == JPDeco_Blocks.NOREN_orange) { return new ItemStack(Items_Wadeco.NOREN_item, 1, 1); }
		if (this == JPDeco_Blocks.NOREN_magenta) { return new ItemStack(Items_Wadeco.NOREN_item, 1, 2); }
		if (this == JPDeco_Blocks.NOREN_lightb) { return new ItemStack(Items_Wadeco.NOREN_item, 1, 3); }
		if (this == JPDeco_Blocks.NOREN_yellow) { return new ItemStack(Items_Wadeco.NOREN_item, 1, 4); }
		if (this == JPDeco_Blocks.NOREN_lime) { return new ItemStack(Items_Wadeco.NOREN_item, 1, 5); }
		if (this == JPDeco_Blocks.NOREN_pink) { return new ItemStack(Items_Wadeco.NOREN_item, 1, 6); }
		if (this == JPDeco_Blocks.NOREN_gray) { return new ItemStack(Items_Wadeco.NOREN_item, 1, 7); }
		if (this == JPDeco_Blocks.NOREN_lightg) { return new ItemStack(Items_Wadeco.NOREN_item, 1, 8); }
		if (this == JPDeco_Blocks.NOREN_cyan) { return new ItemStack(Items_Wadeco.NOREN_item, 1, 9); }
		if (this == JPDeco_Blocks.NOREN_purple) { return new ItemStack(Items_Wadeco.NOREN_item, 1, 10); }
		if (this == JPDeco_Blocks.NOREN_blue) { return new ItemStack(Items_Wadeco.NOREN_item, 1, 11); }
		if (this == JPDeco_Blocks.NOREN_brown) { return new ItemStack(Items_Wadeco.NOREN_item, 1, 12); }
		if (this == JPDeco_Blocks.NOREN_green) { return new ItemStack(Items_Wadeco.NOREN_item, 1, 13); }
		if (this == JPDeco_Blocks.NOREN_red) { return new ItemStack(Items_Wadeco.NOREN_item, 1, 14); }
		if (this == JPDeco_Blocks.NOREN_black) { return new ItemStack(Items_Wadeco.NOREN_item, 1, 15); }
		return null;
	}
}
