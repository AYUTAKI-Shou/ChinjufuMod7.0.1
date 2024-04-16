package com.ayutaki.chinjufumod.blocks.ranma;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingSapo;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.JPDeco_Blocks;
import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;
import com.ayutaki.chinjufumod.state.TypeLR;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BaseRanma extends BaseFacingSapo {

	public static final PropertyEnum<TypeLR> TYPE = PropertyEnum.create("type", TypeLR.class);
	public static final PropertyInteger VER = PropertyInteger.create("ver", 1, 2);

	/* Collision */
	protected static final AxisAlignedBB AABB_SOUTH = new AxisAlignedBB(0.0, 0.0, 0.40625, 1.0, 1.0, 0.59375);
	protected static final AxisAlignedBB AABB_EAST = new AxisAlignedBB(0.40625, 0.0, 0.0, 0.59375, 1.0, 1.0);
	protected static final AxisAlignedBB AABB_WEST = new AxisAlignedBB(0.40625, 0.0, 0.0, 0.59375, 1.0, 1.0);
	protected static final AxisAlignedBB AABB_NORTH = new AxisAlignedBB(0.0, 0.0, 0.40625, 1.0, 1.0, 0.59375);

	protected static final AxisAlignedBB AABB_SOUTH2 = new AxisAlignedBB(0.0, 0.0, 0.8125, 1.0, 1.0, 1.0);
	protected static final AxisAlignedBB AABB_EAST2 = new AxisAlignedBB(0.8125, 0.0, 0.0, 1.0, 1.0, 1.0);
	protected static final AxisAlignedBB AABB_WEST2 = new AxisAlignedBB(0.0, 0.0, 0.0, 0.1875, 1.0, 1.0);
	protected static final AxisAlignedBB AABB_NORTH2 = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 0.1875);

	public BaseRanma(String name, Material material) {
		super(name, material);
		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(5.0F);

		setDefaultState(this.blockState.getBaseState().withProperty(H_FACING, EnumFacing.NORTH)
				.withProperty(VER, Integer.valueOf(1)));
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack stack = playerIn.getHeldItem(hand);
		
		if (stack.isEmpty()) {
			if (playerIn.isSneaking()) {
				CMEvents.soundWoodPlace(worldIn, pos);
				worldIn.setBlockState(pos, state.cycleProperty(VER), 3); }
			return true; 
		}
		return false;
	}

	/* Data value */
	protected int getVer(IBlockState state) {
		return ((Integer)state.getValue(VER)).intValue() * 2;
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(H_FACING, EnumFacing.getHorizontal(meta)).withProperty(VER, Integer.valueOf(1 + (meta >> 2)));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | ((EnumFacing)state.getValue(H_FACING)).getHorizontalIndex();
		i = i | ((Integer)state.getValue(VER)).intValue() - 1 << 2;
		return i;
	}

	@Override
	public boolean hasComparatorInputOverride(IBlockState state) {
		return true;
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

		int i = ((Integer)state.getValue(VER)).intValue();
		EnumFacing direction = (EnumFacing)state.getValue(H_FACING);

		switch (direction) {
		case SOUTH :
			return (i == 1)? AABB_SOUTH : AABB_SOUTH2;

		case EAST :
			return (i == 1)? AABB_EAST : AABB_EAST2;

		case WEST :
			return (i == 1)? AABB_WEST : AABB_WEST2;

		case NORTH :
		default:
			return (i == 1)? AABB_NORTH : AABB_NORTH2;
		}
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox,
			List<AxisAlignedBB> collidingBoxes, Entity entityIn, boolean t_f) {

		int i = ((Integer)state.getValue(VER)).intValue();
		EnumFacing direction = state.getValue(H_FACING);

		switch (direction) {
		case SOUTH :
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, (i == 1)? AABB_SOUTH : AABB_SOUTH2);
			break;
			
		case EAST :
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, (i == 1)? AABB_EAST : AABB_EAST2);
			break;
			
		case WEST :
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, (i == 1)? AABB_WEST : AABB_WEST2);
			break;
			
		case NORTH :
		default :
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, (i == 1)? AABB_NORTH : AABB_NORTH2);
			break;
		}
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {

		Integer integer = (Integer)state.getValue(VER);
		EnumFacing facing = (EnumFacing) state.getValue(H_FACING);
		IBlockState left_block = worldIn.getBlockState(pos.offset(facing.rotateYCCW()));
		IBlockState right_block = worldIn.getBlockState(pos.offset(facing.rotateY()));
		boolean left = (left_block.getBlock() == this) && left_block.getValue(H_FACING).equals(facing);
		boolean right = (right_block.getBlock() == this) && right_block.getValue(H_FACING).equals(facing);

		if (right) {

			if (left) { return state.withProperty(TYPE, TypeLR.BOTH).withProperty(VER, integer); }

			else { return state.withProperty(TYPE, TypeLR.RIGHT).withProperty(VER, integer); } }

		else if (left) {

			if (right) { return state.withProperty(TYPE, TypeLR.BOTH).withProperty(VER, integer); }

			else { return state.withProperty(TYPE, TypeLR.LEFT).withProperty(VER, integer); } }
		 
		return state.withProperty(TYPE, TypeLR.DEFAULT).withProperty(VER, integer);
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { H_FACING, TYPE, VER });
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

	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}
	
	/*Drop Item and Clone Item.*/
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
		if (this == JPDeco_Blocks.RANMA_oak) { return new ItemStack(Items_Wadeco.RANMA_item, 1, 0); }
		if (this == JPDeco_Blocks.RANMA_spru) { return new ItemStack(Items_Wadeco.RANMA_item, 1, 1); }
		if (this == JPDeco_Blocks.RANMA_bir) { return new ItemStack(Items_Wadeco.RANMA_item, 1, 2); }
		if (this == JPDeco_Blocks.RANMA_jun) { return new ItemStack(Items_Wadeco.RANMA_item, 1, 3); }
		if (this == JPDeco_Blocks.RANMA_aca) { return new ItemStack(Items_Wadeco.RANMA_item, 1, 4); }
		if (this == JPDeco_Blocks.RANMA_doak) { return new ItemStack(Items_Wadeco.RANMA_item, 1, 5); }
		
		if (this == JPDeco_Blocks.RANMAB_oak) { return new ItemStack(Items_Wadeco.RANMA_item, 1, 6); }
		if (this == JPDeco_Blocks.RANMAB_spru) { return new ItemStack(Items_Wadeco.RANMA_item, 1, 7); }
		if (this == JPDeco_Blocks.RANMAB_bir) { return new ItemStack(Items_Wadeco.RANMA_item, 1, 8); }
		if (this == JPDeco_Blocks.RANMAB_jun) { return new ItemStack(Items_Wadeco.RANMA_item, 1, 9); }
		if (this == JPDeco_Blocks.RANMAB_aca) { return new ItemStack(Items_Wadeco.RANMA_item, 1, 10); }
		if (this == JPDeco_Blocks.RANMAB_doak) { return new ItemStack(Items_Wadeco.RANMA_item, 1, 11); }
		
		if (this == JPDeco_Blocks.RANMAC_oak) { return new ItemStack(Items_Wadeco.KANKI_item, 1, 0); }
		if (this == JPDeco_Blocks.RANMAC_spru) { return new ItemStack(Items_Wadeco.KANKI_item, 1, 1); }
		if (this == JPDeco_Blocks.RANMAC_bir) { return new ItemStack(Items_Wadeco.KANKI_item, 1, 2); }
		if (this == JPDeco_Blocks.RANMAC_jun) { return new ItemStack(Items_Wadeco.KANKI_item, 1, 3); }
		if (this == JPDeco_Blocks.RANMAC_aca) { return new ItemStack(Items_Wadeco.KANKI_item, 1, 4); }
		if (this == JPDeco_Blocks.RANMAC_doak) { return new ItemStack(Items_Wadeco.KANKI_item, 1, 5); }
		
		if (this == Seasonal_Blocks.RANMA_saku) { return new ItemStack(Items_Seasonal.SRANMA_item, 1, 0); }
		if (this == Seasonal_Blocks.RANMA_kae) { return new ItemStack(Items_Seasonal.SRANMA_item, 1, 1); }
		if (this == Seasonal_Blocks.RANMA_ich) { return new ItemStack(Items_Seasonal.SRANMA_item, 1, 2); }
		if (this == Seasonal_Blocks.RANMAB_saku) { return new ItemStack(Items_Seasonal.SRANMA_item, 1, 3); }
		if (this == Seasonal_Blocks.RANMAB_kae) { return new ItemStack(Items_Seasonal.SRANMA_item, 1, 4); }
		if (this == Seasonal_Blocks.RANMAB_ich) { return new ItemStack(Items_Seasonal.SRANMA_item, 1, 5); }
		if (this == Seasonal_Blocks.RANMAC_saku) { return new ItemStack(Items_Seasonal.SRANMA_item, 1, 6); }
		if (this == Seasonal_Blocks.RANMAC_kae) { return new ItemStack(Items_Seasonal.SRANMA_item, 1, 7); }
		if (this == Seasonal_Blocks.RANMAC_ich) { return new ItemStack(Items_Seasonal.SRANMA_item, 1, 8); }
		
		if (this == JPDeco_Blocks.KANKI_oak) { return new ItemStack(Items_Wadeco.KANKI_item, 1, 6); }
		if (this == JPDeco_Blocks.KANKI_spru) { return new ItemStack(Items_Wadeco.KANKI_item, 1, 7); }
		if (this == JPDeco_Blocks.KANKI_bir) { return new ItemStack(Items_Wadeco.KANKI_item, 1, 8); }
		if (this == JPDeco_Blocks.KANKI_jun) { return new ItemStack(Items_Wadeco.KANKI_item, 1, 9); }
		if (this == JPDeco_Blocks.KANKI_aca) { return new ItemStack(Items_Wadeco.KANKI_item, 1, 10); }
		if (this == JPDeco_Blocks.KANKI_doak) { return new ItemStack(Items_Wadeco.KANKI_item, 1, 11); }
		
		if (this == JPDeco_Blocks.KOUSHI_oak) { return new ItemStack(Items_Wadeco.KOUSHI_item, 1, 0); }
		if (this == JPDeco_Blocks.KOUSHI_spru) { return new ItemStack(Items_Wadeco.KOUSHI_item, 1, 1); }
		if (this == JPDeco_Blocks.KOUSHI_bir) { return new ItemStack(Items_Wadeco.KOUSHI_item, 1, 2); }
		if (this == JPDeco_Blocks.KOUSHI_jun) { return new ItemStack(Items_Wadeco.KOUSHI_item, 1, 3); }
		if (this == JPDeco_Blocks.KOUSHI_aca) { return new ItemStack(Items_Wadeco.KOUSHI_item, 1, 4); }
		if (this == JPDeco_Blocks.KOUSHI_doak) { return new ItemStack(Items_Wadeco.KOUSHI_item, 1, 5); }

		if (this == Seasonal_Blocks.KANKI_saku) { return new ItemStack(Items_Seasonal.SKANKI_item, 1, 0); }
		if (this == Seasonal_Blocks.KANKI_kae) { return new ItemStack(Items_Seasonal.SKANKI_item, 1, 1); }
		if (this == Seasonal_Blocks.KANKI_ich) { return new ItemStack(Items_Seasonal.SKANKI_item, 1, 2); }
		if (this == Seasonal_Blocks.KOUSHI_saku) { return new ItemStack(Items_Seasonal.SKANKI_item, 1, 3); }
		if (this == Seasonal_Blocks.KOUSHI_kae) { return new ItemStack(Items_Seasonal.SKANKI_item, 1, 4); }
		if (this == Seasonal_Blocks.KOUSHI_ich) { return new ItemStack(Items_Seasonal.SKANKI_item, 1, 5); }
		return null;
	}
}
