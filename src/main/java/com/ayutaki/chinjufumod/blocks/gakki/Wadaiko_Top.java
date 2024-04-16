package com.ayutaki.chinjufumod.blocks.gakki;

import java.util.Random;

import com.ayutaki.chinjufumod.blocks.base.BaseStage3_Face;
import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.handler.CMEvents;

import net.minecraft.block.SoundType;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Wadaiko_Top extends BaseStage3_Face {

	private static final AxisAlignedBB TOP1_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.0625, 0.0, 0.203125, 0.9375, 0.59375, 0.796875);
	private static final AxisAlignedBB TOP1_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.0625, 0.0, 0.203125, 0.9375, 0.59375, 0.796875);
	private static final AxisAlignedBB TOP1_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.0625, 0.0, 0.203125, 0.9375, 0.59375, 0.796875);
	private static final AxisAlignedBB TOP1_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.0625, 0.0, 0.203125, 0.9375, 0.59375, 0.796875);
	private static final AxisAlignedBB[] TOP1 = { TOP1_SOUTH, TOP1_WEST, TOP1_NORTH, TOP1_EAST };

	private static final AxisAlignedBB TOP2_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.5, 0.0, 0.234375, 0.96875, 0.4375, 0.765625);
	private static final AxisAlignedBB TOP2_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.5, 0.0, 0.234375, 0.96875, 0.4375, 0.765625);
	private static final AxisAlignedBB TOP2_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.5, 0.0, 0.234375, 0.96875, 0.4375, 0.765625);
	private static final AxisAlignedBB TOP2_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.5, 0.0, 0.234375, 0.96875, 0.4375, 0.765625);
	private static final AxisAlignedBB[] TOP2 = { TOP2_SOUTH, TOP2_WEST, TOP2_NORTH, TOP2_EAST };

	private static final AxisAlignedBB TOP3_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 0.01, 0.01, 0.01);

	public Wadaiko_Top(String name) {
		super(name);
		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(10.0F);
		setLightOpacity(1);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		int i = ((Integer)state.getValue(STAGE_1_3)).intValue();

		EnumFacing direction = state.getValue(H_FACING);

		switch (i) {
		case 1 :
		default :
			switch (direction) {
			case NORTH :
			default :
			case SOUTH :
				if (hitZ >= 0.9375D || hitZ <= 0.0625D) {
					if (item == Items.STICK) { CMEvents.wadaikoTop(worldIn, pos, 1.25F, 1.0F); }
					else { CMEvents.wadaikoTop(worldIn, pos, 0.2F, 1.0F); } }

				if (hitZ < 0.9375D && hitZ > 0.0625D) {
					if (item == Items.STICK) { CMEvents.wadaikoSide(worldIn, pos, 1.25F, 1.0F); }
					else { CMEvents.wadaikoSide(worldIn, pos, 0.2F, 1.0F); } }
				break;

			case EAST :
			case WEST :
				if (hitX >= 0.9375D || hitX <= 0.0625D) {
					if (item == Items.STICK) { CMEvents.wadaikoTop(worldIn, pos, 1.25F, 1.0F); }
					else { CMEvents.wadaikoTop(worldIn, pos, 0.2F, 1.0F); } }

				if (hitX < 0.9375D && hitX > 0.0625D) {
					if (item == Items.STICK) { CMEvents.wadaikoSide(worldIn, pos, 1.25F, 1.0F); }
					else { CMEvents.wadaikoSide(worldIn, pos, 0.2F, 1.0F); } }
				break;
			} // switch
			break;

		case 2 :
			switch (direction) {
			case NORTH :
			default :
				if (hitZ <= 0.03125D) {
					if (item == Items.STICK) { CMEvents.wadaikoTop(worldIn, pos, 1.25F, 1.0F); }
					else { CMEvents.wadaikoTop(worldIn, pos, 0.2F, 1.0F); } }

				if (hitZ > 0.03125D) {
					if (item == Items.STICK) { CMEvents.wadaikoSide(worldIn, pos, 1.25F, 1.0F); }
					else { CMEvents.wadaikoSide(worldIn, pos, 0.2F, 1.0F); } }
				break;

			case SOUTH :
				if (hitZ >= 0.96875D) {
					if (item == Items.STICK) { CMEvents.wadaikoTop(worldIn, pos, 1.25F, 1.0F); }
					else { CMEvents.wadaikoTop(worldIn, pos, 0.2F, 1.0F); } }

				if (hitZ < 0.96875D) {
					if (item == Items.STICK) { CMEvents.wadaikoSide(worldIn, pos, 1.25F, 1.0F); }
					else { CMEvents.wadaikoSide(worldIn, pos, 0.2F, 1.0F); } }
				break;

			case EAST :
				if (hitX >= 0.96875D) {
					if (item == Items.STICK) { CMEvents.wadaikoTop(worldIn, pos, 1.25F, 1.0F); }
					else { CMEvents.wadaikoTop(worldIn, pos, 0.2F, 1.0F); } }

				if (hitX < 0.96875D) {
					if (item == Items.STICK) { CMEvents.wadaikoSide(worldIn, pos, 1.25F, 1.0F); }
					else { CMEvents.wadaikoSide(worldIn, pos, 0.2F, 1.0F); } }
				break;
				
			case WEST :
				if (hitX <= 0.03125D) {
					if (item == Items.STICK) { CMEvents.wadaikoTop(worldIn, pos, 1.25F, 1.0F); }
					else { CMEvents.wadaikoTop(worldIn, pos, 0.2F, 1.0F); } }

				if (hitX > 0.03125D) {
					if (item == Items.STICK) { CMEvents.wadaikoSide(worldIn, pos, 1.25F, 1.0F); }
					else { CMEvents.wadaikoSide(worldIn, pos, 0.2F, 1.0F); } }
				break;
			} // switch
			break;
			
		case 3 :
			break;
		} // switch
		return true;
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

		state = state.getActualState(source, pos);
		EnumFacing facing = state.getValue(H_FACING);
		int i = ((Integer)state.getValue(STAGE_1_3)).intValue();

		return (i == 1)? TOP1[facing.getHorizontalIndex()] : ((i == 2)? TOP2[facing.getHorizontalIndex()] : TOP3_AABB);
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

	/*Rendering */
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	/* A block that breaks at the same time when it is broken. */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn) {
		if (worldIn.getBlockState(pos.down()).getBlock() instanceof Wadaiko_Bot) {
			if (playerIn.capabilities.isCreativeMode) { worldIn.destroyBlock(pos.down(), false); }
			else { worldIn.destroyBlock(pos.down(), true); }
		}
	}

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Items.AIR;
	}
}
