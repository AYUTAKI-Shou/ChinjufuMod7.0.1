package com.ayutaki.chinjufumod.blocks.base;

import java.util.List;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.state.SlabHalf;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BaseSlabW extends Block {

	/** ハーフブロックを応用(岩ハーフ, 桜・銀杏・楓ハーフ) **/
	public static final PropertyBool DOUBLE = PropertyBool.create("double");
	public static final PropertyEnum<SlabHalf> HALF = PropertyEnum.<SlabHalf>create("half", SlabHalf.class);

	protected static final AxisAlignedBB DOUBLE_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	protected static final AxisAlignedBB BOTTOM_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D);
	protected static final AxisAlignedBB TOP_AABB = new AxisAlignedBB(0.0D, 0.5D, 0.0D, 1.0D, 1.0D, 1.0D);

	public BaseSlabW(String name) {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);
		setLightOpacity(2);

		setDefaultState(this.blockState.getBaseState()
				.withProperty(DOUBLE, Boolean.valueOf(false))
				.withProperty(HALF, SlabHalf.BOTTOM));
	}

	/* RightClick Action */

	/** Called by ItemBlocks just before a block is actually set in the world, to allow for adjustments to the IBlockstate */
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing,
			float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {

		IBlockState state = this.getDefaultState();

		if (facing.getAxis().isHorizontal()) {
			state = state.withProperty(HALF, (hitY > 0.6F)? SlabHalf.TOP : SlabHalf.BOTTOM); }

		else {
			state = state.withProperty(HALF, (facing == EnumFacing.UP)? SlabHalf.BOTTOM : SlabHalf.TOP); }

		return state;
	}

	/* 隣接ブロックへのチェック */
	@Override
	public boolean canPlaceBlockOnSide(World worldIn, BlockPos pos, EnumFacing side) {
		return true;
	}

	/* Data valueをBlockstate に変換…BaseFacingSlabW から FACING を除外 */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(DOUBLE, Boolean.valueOf((meta & 1) != 0))
				.withProperty(HALF, (meta & 2) == 0 ? SlabHalf.BOTTOM : SlabHalf.TOP);
	}

	/* Data valueの変換 */
	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0;
		/** 「 i |= 4 」は「 i = i | 4 」で「 i = i OR i = 4 」**/
		if (state.getValue(DOUBLE) == true) { i |= 1; }
		if (state.getValue(HALF) == SlabHalf.TOP) { i |= 2; }

		return i;
	}

	@Override
	public BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { DOUBLE, HALF });
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

		if (state.getValue(DOUBLE) == true) { return DOUBLE_AABB; }

		else { return (state.getValue(HALF) == SlabHalf.TOP)? TOP_AABB : BOTTOM_AABB; }
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox,
			List<AxisAlignedBB> collidingBoxes, Entity entityIn, boolean t_f) {

		boolean flag = (state.getValue(DOUBLE) == true);
		SlabHalf blockhalf = state.getValue(HALF);

		switch(blockhalf) {
		case TOP :
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, flag? DOUBLE_AABB : TOP_AABB); /** flag? true : false; **/
			break;
			
		case BOTTOM :
		default:
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, flag? DOUBLE_AABB : BOTTOM_AABB);
			break;
		}
	}

	/* A torch can be placed on top. true or false */
	@Override
	public boolean isTopSolid(IBlockState state) {
		return (state.getValue(DOUBLE) == true || state.getValue(HALF) == SlabHalf.TOP);
	}

	/* A torch can be placed on the side. */
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {

		if (state.getValue(DOUBLE) == true || (face == EnumFacing.UP && state.getValue(HALF) == SlabHalf.TOP)) {
			return BlockFaceShape.SOLID;
		}

		else {
			return (face == EnumFacing.DOWN && state.getValue(HALF) == SlabHalf.BOTTOM)? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
		}
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
}
