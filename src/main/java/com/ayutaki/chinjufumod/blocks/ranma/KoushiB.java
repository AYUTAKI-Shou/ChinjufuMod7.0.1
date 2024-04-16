package com.ayutaki.chinjufumod.blocks.ranma;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.JPDeco_Blocks;
import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class KoushiB extends Block {

	public static final PropertyDirection H_FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyBool DOWN = PropertyBool.create("down");
	public static final PropertyBool UP = PropertyBool.create("up");
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

	public KoushiB(String name) {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);

		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(5.0F);
		setLightOpacity(0);

		setDefaultState(this.blockState.getBaseState()
				.withProperty(H_FACING, EnumFacing.NORTH)
				.withProperty(UP, Boolean.valueOf(false))
				.withProperty(DOWN, Boolean.valueOf(false))
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

	/* BlockState when it was placed. */
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing,
			float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(H_FACING, placer.getHorizontalFacing().getOpposite());
	}

	public IBlockState withRotation(IBlockState state, Rotation rot) {
		return state.withProperty(H_FACING, rot.rotate((EnumFacing)state.getValue(H_FACING)));
	}

	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
		return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(H_FACING)));
	}

	/* IBlockStateからItemStackのmetadataを生成。ドロップ時とテクスチャ・モデル参照時に呼ばれる */
	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | ((EnumFacing)state.getValue(H_FACING)).getHorizontalIndex();
		i = i | ((Integer)state.getValue(VER)).intValue() - 1 << 2;
		return i;
	}

	/* ItemStackのmetadataからIBlockStateを生成。設置時に呼ばれる */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(H_FACING, EnumFacing.getHorizontal(meta))
				.withProperty(VER, Integer.valueOf(1 + (meta >> 2)));
	}

	public int getComparatorInputOverride(IBlockState state, World worldIn, BlockPos pos) {
		return (2 - ((Integer)state.getValue(VER)).intValue()) * 2;
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
		default :
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

	/* Reaction to Neighboring blocks. */
	public boolean canConnectTo(IBlockAccess worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos).getBlock() == this;
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return state.withProperty(DOWN, this.canConnectTo(worldIn, pos.down()))
				.withProperty(UP, this.canConnectTo(worldIn, pos.up()));
	}

	/*Create BlockStates in this block. */
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { DOWN, H_FACING, UP, VER });
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
		if (this == JPDeco_Blocks.KOUSHIB_oak) { return new ItemStack(Items_Wadeco.KOUSHI_item, 1, 6); }
		if (this == JPDeco_Blocks.KOUSHIB_spru) { return new ItemStack(Items_Wadeco.KOUSHI_item, 1, 7); }
		if (this == JPDeco_Blocks.KOUSHIB_bir) { return new ItemStack(Items_Wadeco.KOUSHI_item, 1, 8); }
		if (this == JPDeco_Blocks.KOUSHIB_jun) { return new ItemStack(Items_Wadeco.KOUSHI_item, 1, 9); }
		if (this == JPDeco_Blocks.KOUSHIB_aca) { return new ItemStack(Items_Wadeco.KOUSHI_item, 1, 10); }
		if (this == JPDeco_Blocks.KOUSHIB_doak) { return new ItemStack(Items_Wadeco.KOUSHI_item, 1, 11); }
		
		if (this == Seasonal_Blocks.KOUSHIB_saku) { return new ItemStack(Items_Seasonal.SKANKI_item, 1, 6); }
		if (this == Seasonal_Blocks.KOUSHIB_kae) { return new ItemStack(Items_Seasonal.SKANKI_item, 1, 7); }
		if (this == Seasonal_Blocks.KOUSHIB_ich) { return new ItemStack(Items_Seasonal.SKANKI_item, 1, 8); }
		return null;
	}
}
