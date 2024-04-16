package com.ayutaki.chinjufumod.blocks.base;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.state.SlabHalf;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BaseFacingSlabW extends Block {

	/** 上下と方角, 変化のあるブロックであるトラップドアを応用(パントリー, 畳) **/
	public static final PropertyDirection H_FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyBool DOUBLE = PropertyBool.create("double");
	public static final PropertyEnum<SlabHalf> HALF = PropertyEnum.<SlabHalf>create("half", SlabHalf.class);

	/* Collision…パントリーと畳で別々 */

	public BaseFacingSlabW(String name) {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);
		setLightOpacity(2);

		setDefaultState(this.blockState.getBaseState()
				.withProperty(H_FACING, EnumFacing.NORTH)
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
			state = state.withProperty(H_FACING, facing).withProperty(DOUBLE, Boolean.valueOf(false));
			state = state.withProperty(HALF, (hitY > 0.6F)? SlabHalf.TOP : SlabHalf.BOTTOM); }

		else {
			state = state.withProperty(H_FACING, placer.getHorizontalFacing().getOpposite()).withProperty(DOUBLE, Boolean.valueOf(false));
			state = state.withProperty(HALF, (facing == EnumFacing.UP)? SlabHalf.BOTTOM : SlabHalf.TOP); }

		return state;
	}

	/* 隣接ブロックへのチェック */
	@Override
	public boolean canPlaceBlockOnSide(World worldIn, BlockPos pos, EnumFacing side) {
		return true;
	}

	/* トラップドアのData value */
	public static EnumFacing getFacing(int meta) {
		switch (meta & 3) {
		case 0:
			return EnumFacing.NORTH;
		case 1:
			return EnumFacing.SOUTH;
		case 2:
			return EnumFacing.WEST;
		case 3:
		default:
			return EnumFacing.EAST;
		}
	}

	public static int getMetaForFacing(EnumFacing facing) {
		switch (facing) {
		case NORTH:
			return 0;
		case SOUTH:
			return 1;
		case WEST:
			return 2;
		case EAST:
		default:
			return 3;
		}
	}

	/* Data valueをBlockstate に変換…トラップドアの OPEN(t/f) を DOUBLE(t/f) で使う */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(H_FACING, getFacing(meta))
				.withProperty(DOUBLE, Boolean.valueOf((meta & 4) != 0))
				.withProperty(HALF, (meta & 8) == 0 ? SlabHalf.BOTTOM : SlabHalf.TOP);
	}

	/* Data valueの変換 */
	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | getMetaForFacing((EnumFacing)state.getValue(H_FACING));
		if (state.getValue(DOUBLE) == true) { i |= 4; }
		if (state.getValue(HALF) == SlabHalf.TOP) { i |= 8; }

		return i;
	}

	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		return state.withProperty(H_FACING, rot.rotate((EnumFacing)state.getValue(H_FACING)));
	}

	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
		return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(H_FACING)));
	}

	@Override
	public BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { DOUBLE, H_FACING, HALF });
	}

	/* Collision */

	/* A torch can be placed on top. true or false…パントリーと畳で別々 */

	/* A torch can be placed on the side.…パントリーと畳で別々 */

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
