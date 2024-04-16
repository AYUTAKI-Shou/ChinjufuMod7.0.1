package com.ayutaki.chinjufumod.blocks.chair;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingSapo;
import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.entity.SitableEntity;
import com.ayutaki.chinjufumod.entity.helper.SittableUtil;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Furniture_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Chinjufu;
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
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Bench extends BaseFacingSapo {

	public static final PropertyEnum<TypeLR> TYPE = PropertyEnum.create("type", TypeLR.class);

	protected static final AxisAlignedBB AABB_SOUTH = new AxisAlignedBB(0.0, 0.0, 0.3125, 1.0, 0.4375, 1.0);
	protected static final AxisAlignedBB AABB_EAST = new AxisAlignedBB(0.3125, 0.0, 0.0, 1.0, 0.4375, 1.0);
	protected static final AxisAlignedBB AABB_WEST = new AxisAlignedBB(0.0, 0.0, 0.0, 0.6875, 0.4375, 1.0);
	protected static final AxisAlignedBB AABB_NORTH = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.4375, 0.6875);

	protected static final AxisAlignedBB CHAIR_BASE = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.4375, 1.0);
	protected static final AxisAlignedBB CHAIR_BACKREST_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.125, 0.4375, 0.125, 0.1875, 1.0, 0.875);
	protected static final AxisAlignedBB CHAIR_BACKREST_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.125, 0.4375, 0.125, 0.1875, 1.0, 0.875);
	protected static final AxisAlignedBB CHAIR_BACKREST_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.125, 0.4375, 0.125, 0.1875, 1.0, 0.875);
	protected static final AxisAlignedBB CHAIR_BACKREST_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.125, 0.4375, 0.125, 0.1875, 1.0, 0.875);

	public Bench(String name) {
		super(name, Material.WOOD);
		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(5.0F);
		setLightOpacity(1);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		if (SittableUtil.sitOnBlock(worldIn, pos.getX(), pos.getY(), pos.getZ(), playerIn, 3.5 * 0.0625)) {
			worldIn.updateComparatorOutputLevel(pos, this);
			CMEvents.soundKinuzure(worldIn, pos);
			return true;
		}
		return false;
	}

	@Override
	public boolean hasComparatorInputOverride(IBlockState state) {
		return true;
	}

	@Override
	public int getComparatorInputOverride(IBlockState state, World worldIn, BlockPos pos) {
		return SittableUtil.isSomeoneSitting(worldIn, pos.getX(), pos.getY(), pos.getZ()) ? 1 : 0;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

		state = state.getActualState(source, pos);
		EnumFacing direction = (EnumFacing)state.getValue(H_FACING);

		switch (direction) {
		case SOUTH:
			return AABB_SOUTH;

		case EAST:
			return AABB_EAST;

		case WEST:
			return AABB_WEST;

		case NORTH:
		default:
			return AABB_NORTH;
		}
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox,
			List<AxisAlignedBB> collidingBoxes, Entity entityIn, boolean t_f) {

		if (!(entityIn instanceof SitableEntity)) {

			EnumFacing direction = state.getValue(H_FACING);
			switch (direction) {
			case SOUTH:
				super.addCollisionBoxToList(pos, entityBox, collidingBoxes, CHAIR_BACKREST_SOUTH);
				break;
				
			case EAST:
				super.addCollisionBoxToList(pos, entityBox, collidingBoxes, CHAIR_BACKREST_EAST);
				break;
				
			case WEST:
				super.addCollisionBoxToList(pos, entityBox, collidingBoxes, CHAIR_BACKREST_WEST);
				break;
				
			case NORTH:
			default:
				super.addCollisionBoxToList(pos, entityBox, collidingBoxes, CHAIR_BACKREST_NORTH);
				break;
			}
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, CHAIR_BASE);
		}
	}

	/* 隣と連結 */
	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {

		EnumFacing facing = (EnumFacing) state.getValue(H_FACING);
		IBlockState left_block = worldIn.getBlockState(pos.offset(facing.rotateYCCW()));
		IBlockState right_block = worldIn.getBlockState(pos.offset(facing.rotateY()));
		boolean left = (left_block.getBlock() == this) && left_block.getValue(H_FACING).equals(facing);
		boolean right = (right_block.getBlock() == this) && right_block.getValue(H_FACING).equals(facing);

		 if (right) {

			if (left) { return state.withProperty(TYPE, TypeLR.BOTH); }

			else { return state.withProperty(TYPE, TypeLR.RIGHT); } }

		else if (left) {

			if (right) { return state.withProperty(TYPE, TypeLR.BOTH); }

			else { return state.withProperty(TYPE, TypeLR.LEFT); } }
		 
		return state.withProperty(TYPE, TypeLR.DEFAULT);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { H_FACING, TYPE });
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
		stack.add(this.takeStack(state));
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return this.takeStack(state);
	}
	
	private ItemStack takeStack(IBlockState state) {
		if (this == Furniture_Blocks.BENCH) { return new ItemStack(Items_Chinjufu.BENCH_item, 1, 0); }
		if (this == Furniture_Blocks.BENCH_spru) { return new ItemStack(Items_Chinjufu.BENCH_item, 1, 1); }
		if (this == Furniture_Blocks.BENCH_bir) { return new ItemStack(Items_Chinjufu.BENCH_item, 1, 2); }
		if (this == Furniture_Blocks.BENCH_jun) { return new ItemStack(Items_Chinjufu.BENCH_item, 1, 3); }
		if (this == Furniture_Blocks.BENCH_aca) { return new ItemStack(Items_Chinjufu.BENCH_item, 1, 4); }
		if (this == Furniture_Blocks.BENCH_doak) { return new ItemStack(Items_Chinjufu.BENCH_item, 1, 5); }
		if (this == Furniture_Blocks.BENCH_saku) { return new ItemStack(Items_Chinjufu.BENCH_item, 1, 6); }
		if (this == Furniture_Blocks.BENCH_kae) { return new ItemStack(Items_Chinjufu.BENCH_item, 1, 7); }
		if (this == Furniture_Blocks.BENCH_ich) { return new ItemStack(Items_Chinjufu.BENCH_item, 1, 8); } 
		return null;
	}
}
