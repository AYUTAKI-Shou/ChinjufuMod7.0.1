package com.ayutaki.chinjufumod.blocks.garden;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.registry.Garden_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.state.HalfState;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Itabei extends Block {

	/* Property */
	public static final PropertyDirection H_FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyBool CHECK = PropertyBool.create("check");
	public static final PropertyEnum<HalfState> HALF = PropertyEnum.<HalfState>create("half", HalfState.class);
	private static final double cw = 0.0625;
	
	/* Collision */
	protected static final AxisAlignedBB SN_AABB = new AxisAlignedBB(0.0D * cw, 0.0D * cw, 6.0D * cw, 16.0D * cw, 16.0D * cw, 10.0D * cw);
	protected static final AxisAlignedBB EW_AABB = new AxisAlignedBB(6.0D * cw, 0.0D * cw, 0.0D * cw, 10.0D * cw, 16.0D * cw, 16.0D * cw);

	protected static final AxisAlignedBB ES_AABB = new AxisAlignedBB(6.0D * cw, 0.0D * cw, 6.0D * cw, 16.0D * cw, 16.0D * cw, 16.0D * cw);
	protected static final AxisAlignedBB NE_AABB = new AxisAlignedBB(6.0D * cw, 0.0D * cw, 0.0D * cw, 16.0D * cw, 16.0D * cw, 10.0D * cw);
	protected static final AxisAlignedBB SW_AABB = new AxisAlignedBB(0.0D * cw, 0.0D * cw, 6.0D * cw, 10.0D * cw, 16.0D * cw, 16.0D * cw);
	protected static final AxisAlignedBB WN_AABB = new AxisAlignedBB(0.0D * cw, 0.0D * cw, 0.0D * cw, 10.0D * cw, 16.0D * cw, 10.0D * cw);
	
	public Itabei(String name) {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);

		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(3.0F);
		setLightOpacity(1);
		
		setDefaultState(this.blockState.getBaseState().withProperty(H_FACING, EnumFacing.NORTH)
				.withProperty(CHECK, Boolean.valueOf(false))
				.withProperty(HALF, HalfState.LOWER));
	}

	/* Collision */
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

		state = state.getActualState(source, pos);
		EnumFacing direction = (EnumFacing)state.getValue(H_FACING);
		boolean flag = !((Boolean)state.getValue(CHECK)).booleanValue();

		switch (direction) {
		case SOUTH:
			return flag ? SN_AABB : SW_AABB;
			
		case EAST:
			return flag ? EW_AABB : ES_AABB;
			
		case WEST:
			return flag ? EW_AABB : WN_AABB;
			
		case NORTH:
		default:
			return flag ? SN_AABB : NE_AABB;
		}
	}

	/* A place where you can put it. */
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos).getMaterial().isReplaceable() && worldIn.getBlockState(pos.up()).getMaterial().isReplaceable();
	}

	public EnumPushReaction getMobilityFlag(IBlockState state) {
		return EnumPushReaction.DESTROY;
	}

	/* A block that breaks at the same time when it is broken. */
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn) {
		BlockPos downPos = pos.down();
		BlockPos upPos = pos.up();

		if (playerIn.capabilities.isCreativeMode && state.getValue(HALF) == HalfState.UPPER && worldIn.getBlockState(downPos).getBlock() == this) {
			worldIn.setBlockToAir(downPos); }

		if (state.getValue(HALF) == HalfState.LOWER && worldIn.getBlockState(upPos).getBlock() == this) {
			if (playerIn.capabilities.isCreativeMode) { worldIn.setBlockToAir(pos); }
			worldIn.setBlockToAir(upPos); }
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
		if (state.getValue(HALF) == HalfState.UPPER) { return new ItemStack(Items.AIR); }
		
		if (state.getValue(HALF) != HalfState.UPPER) {
			if (this == Garden_Blocks.ITABEI) { return new ItemStack(Items_Wadeco.ITABEI_item, 1, 0); }
			if (this == Garden_Blocks.ITABEI_spruce) { return new ItemStack(Items_Wadeco.ITABEI_item, 1, 1); }
			if (this == Garden_Blocks.ITABEI_birch) { return new ItemStack(Items_Wadeco.ITABEI_item, 1, 2); }
			if (this == Garden_Blocks.ITABEI_jungle) { return new ItemStack(Items_Wadeco.ITABEI_item, 1, 3); }
			if (this == Garden_Blocks.ITABEI_acacia) { return new ItemStack(Items_Wadeco.ITABEI_item, 1, 4); }
			if (this == Garden_Blocks.ITABEI_darkoak) { return new ItemStack(Items_Wadeco.ITABEI_item, 1, 5); }
			
			if (this == Garden_Blocks.ITABEI_sakura) { return new ItemStack(Items_Seasonal.SITABEI_item, 1, 0); }
			if (this == Garden_Blocks.ITABEI_kaede) { return new ItemStack(Items_Seasonal.SITABEI_item, 1, 1); }
			if (this == Garden_Blocks.ITABEI_ichoh) { return new ItemStack(Items_Seasonal.SITABEI_item, 1, 2); }
		}
		return null;
	}

	public IBlockState withRotation(IBlockState state, Rotation rot) {
		return state.getValue(HALF) != HalfState.LOWER ? state : state.withProperty(H_FACING, rot.rotate((EnumFacing)state.getValue(H_FACING)));
	}

	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
		return mirrorIn == Mirror.NONE ? state : state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(H_FACING)));
	}

	protected static EnumFacing getFacing(int meta) {
		switch (meta & 3) {
			case 0 : return EnumFacing.NORTH;
			case 1 : return EnumFacing.SOUTH;
			case 2 : return EnumFacing.WEST;
			case 3:
			default : return EnumFacing.EAST; }
	}

	protected static int getMetaForFacing(EnumFacing facing) {
		switch (facing) {
			case NORTH : return 0;
			case SOUTH : return 1;
			case WEST : return 2;
			case EAST :
			default : return 3; }
	}
	
	public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | getMetaForFacing((EnumFacing)state.getValue(H_FACING));
		if (((Boolean)state.getValue(CHECK)).booleanValue()) { i |= 4; }
		if (state.getValue(HALF) == HalfState.UPPER) { i |= 8; }
		return i;
	}
	
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(H_FACING, getFacing(meta)).withProperty(CHECK, Boolean.valueOf((meta & 4) != 0))
				.withProperty(HALF, (meta & 8) == 0 ? HalfState.LOWER : HalfState.UPPER);
	}
	
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { HALF, H_FACING, CHECK });
	}

	/* A torch can be placed on top. true or false */
	public boolean isTopSolid(IBlockState state) {
		return false;
	}

	/* A torch can be placed on the side. */
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.SOLID;
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
