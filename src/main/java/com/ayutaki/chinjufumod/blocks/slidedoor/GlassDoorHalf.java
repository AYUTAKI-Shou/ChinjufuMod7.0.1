package com.ayutaki.chinjufumod.blocks.slidedoor;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.blocks.base.BaseStage4_Face;
import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.window.CurtainTall_Item;
import com.ayutaki.chinjufumod.items.window.Curtain_Item;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.Slidedoor_Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class GlassDoorHalf extends BaseStage4_Face {

	/* Collision */
	private static final AxisAlignedBB CLOSE1_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.5, 0.0, 0.0, 0.59375, 1.0, 1.0);
	private static final AxisAlignedBB CLOSE1_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.5, 0.0, 0.0, 0.59375, 1.0, 1.0);
	private static final AxisAlignedBB CLOSE1_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.5, 0.0, 0.0, 0.59375, 1.0, 1.0);
	private static final AxisAlignedBB CLOSE1_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.5, 0.0, 0.0, 0.59375, 1.0, 1.0);
	private static final AxisAlignedBB[] CLOSE1 = { CLOSE1_SOUTH, CLOSE1_WEST, CLOSE1_NORTH, CLOSE1_EAST };

	private static final AxisAlignedBB OPEN2_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.5, 0.0, 0.875, 0.59375, 1.0, 1.875);
	private static final AxisAlignedBB OPEN2_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.5, 0.0, 0.875, 0.59375, 1.0, 1.875);
	private static final AxisAlignedBB OPEN2_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.5, 0.0, 0.875, 0.59375, 1.0, 1.875);
	private static final AxisAlignedBB OPEN2_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.5, 0.0, 0.875, 0.59375, 1.0, 1.875);
	private static final AxisAlignedBB[] OPEN2 = { OPEN2_SOUTH, OPEN2_WEST, OPEN2_NORTH, OPEN2_EAST };

	private static final AxisAlignedBB CLOSE3_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.40625, 0.0, 0.0, 0.5, 1.0, 1.0);
	private static final AxisAlignedBB CLOSE3_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.40625, 0.0, 0.0, 0.5, 1.0, 1.0);
	private static final AxisAlignedBB CLOSE3_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.40625, 0.0, 0.0, 0.5, 1.0, 1.0);
	private static final AxisAlignedBB CLOSE3_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.40625, 0.0, 0.0, 0.5, 1.0, 1.0);
	private static final AxisAlignedBB[] CLOSE3 = { CLOSE3_SOUTH, CLOSE3_WEST, CLOSE3_NORTH, CLOSE3_EAST };

	private static final AxisAlignedBB OPEN4_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.40625, 0.0, -0.875, 0.5, 1.0, 0.125);
	private static final AxisAlignedBB OPEN4_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.40625, 0.0, -0.875, 0.5, 1.0, 0.125);
	private static final AxisAlignedBB OPEN4_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.40625, 0.0, -0.875, 0.5, 1.0, 0.125);
	private static final AxisAlignedBB OPEN4_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.40625, 0.0, -0.875, 0.5, 1.0, 0.125);
	private static final AxisAlignedBB[] OPEN4 = { OPEN4_SOUTH, OPEN4_WEST, OPEN4_NORTH, OPEN4_EAST };


	public GlassDoorHalf(String name) {
		super(name);
		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(5.0F);
		setLightOpacity(0);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		/** 1=Close, 2=Open, 3=Close, 4=Open **/
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();

		if (item instanceof Curtain_Item || item instanceof CurtainTall_Item) { return false; }

		else {
			if (i == 1 || i == 3) {
				CMEvents.soundHikidoS(worldIn, pos);
				worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1))); }
	
			if (i == 2 || i == 4) {
				CMEvents.soundHikidoS(worldIn, pos);
				worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i - 1))); }
	
			return true;
		}
	}

	/* BlockState when it was placed. */
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing,
			float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {

		if (placer.isSneaking()) {
			return this.getDefaultState().withProperty(H_FACING, placer.getHorizontalFacing().getOpposite()).withProperty(STAGE_1_4, Integer.valueOf(3));
		}
		return this.getDefaultState().withProperty(H_FACING, placer.getHorizontalFacing().getOpposite()).withProperty(STAGE_1_4, Integer.valueOf(1));
	}


	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		EnumFacing facing = state.getValue(H_FACING);

		return (i == 1)? CLOSE1[facing.getHorizontalIndex()] : ((i == 2)? OPEN2[facing.getHorizontalIndex()] :
			((i == 3)? CLOSE3[facing.getHorizontalIndex()] : OPEN4[facing.getHorizontalIndex()]));
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
		if (this == Slidedoor_Blocks.GARASUDOH) { return new ItemStack(Items_Wadeco.GARASUDOH_item, 1, 0); }
		if (this == Slidedoor_Blocks.GARASUDOH_SPRU) { return new ItemStack(Items_Wadeco.GARASUDOH_item, 1, 1); }
		if (this == Slidedoor_Blocks.GARASUDOH_BIR) { return new ItemStack(Items_Wadeco.GARASUDOH_item, 1, 2); }
		if (this == Slidedoor_Blocks.GARASUDOH_JUN) { return new ItemStack(Items_Wadeco.GARASUDOH_item, 1, 3); }
		if (this == Slidedoor_Blocks.GARASUDOH_ACA) { return new ItemStack(Items_Wadeco.GARASUDOH_item, 1, 4); }
		if (this == Slidedoor_Blocks.GARASUDOH_DOAK) { return new ItemStack(Items_Wadeco.GARASUDOH_item, 1, 5); }
		
		if (this == Slidedoor_Blocks.GARASUDOH_SAKU) { return new ItemStack(Items_Seasonal.SGARASUDOH_item, 1, 0); }
		if (this == Slidedoor_Blocks.GARASUDOH_KAE) { return new ItemStack(Items_Seasonal.SGARASUDOH_item, 1, 1); }
		if (this == Slidedoor_Blocks.GARASUDOH_ICH) { return new ItemStack(Items_Seasonal.SGARASUDOH_item, 1, 2); }
		return null;
	}
}
