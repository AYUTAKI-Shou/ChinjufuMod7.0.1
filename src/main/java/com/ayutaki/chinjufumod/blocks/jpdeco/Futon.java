package com.ayutaki.chinjufumod.blocks.jpdeco;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.blocks.base.BaseStage2_Face;
import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.entity.helper.SittableUtil;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.color.Base_ItemHake;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.JPDeco_Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Futon extends BaseStage2_Face {

	/* Collision */
	protected static final AxisAlignedBB AABB_1_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.34375, 0.0, 0.0, 1.0, 0.6875, 1.0);
	protected static final AxisAlignedBB AABB_1_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.34375, 0.0, 0.0, 1.0, 0.6875, 1.0);
	protected static final AxisAlignedBB AABB_1_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.34375, 0.0, 0.0, 1.0, 0.6875, 1.0);
	protected static final AxisAlignedBB AABB_1_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.34375, 0.0, 0.0, 1.0, 0.6875, 1.0);

	protected static final AxisAlignedBB AABB_2_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, -1.0, 0.0, 0.0, 1.0, 0.225, 1.0);
	protected static final AxisAlignedBB AABB_2_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, -1.0, 0.0, 0.0, 1.0, 0.225, 1.0);
	protected static final AxisAlignedBB AABB_2_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, -1.0, 0.0, 0.0, 1.0, 0.225, 1.0);
	protected static final AxisAlignedBB AABB_2_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, -1.0, 0.0, 0.0, 1.0, 0.225, 1.0);

	public Futon(String name) {
		super(name);
		setSoundType(SoundType.CLOTH);
		setHardness(1.0F);
		setResistance(5.0F);
		setLightOpacity(1);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		/** 1=Close, 2=Open **/
		int i = ((Integer)state.getValue(STAGE_1_2)).intValue();

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();

		if (item instanceof Base_ItemHake) { return false; }

		else {
			if (i == 1) {
				if (playerIn.isSneaking()) {
					CMEvents.soundKinuzure(worldIn, pos);
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_2, Integer.valueOf(i + 1)), 3); }
				
				if (!playerIn.isSneaking()) { CMEvents.textNotSneak(worldIn, pos, playerIn); } }
			
			if (i == 2) {
				if (playerIn.isSneaking()) {
					CMEvents.soundKinuzure(worldIn, pos);
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_2, Integer.valueOf(i - 1)), 3); }
				
				if (!playerIn.isSneaking() && SittableUtil.sitOnBlock(worldIn, pos.getX(), pos.getY(), pos.getZ(), playerIn, 0 * 0.0625)) {
					worldIn.updateComparatorOutputLevel(pos, this);
					CMEvents.soundKinuzure(worldIn, pos);

					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 200, 0)); } }
		}
		return true;
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

		state = state.getActualState(source, pos);
		int i = ((Integer)state.getValue(STAGE_1_2)).intValue();
		EnumFacing direction = (EnumFacing)state.getValue(H_FACING);

		switch (direction) {
		case SOUTH:
			return (i == 1)? AABB_1_SOUTH : AABB_2_SOUTH;

		case EAST:
			return (i == 1)? AABB_1_EAST : AABB_2_EAST;

		case WEST:
			return (i == 1)? AABB_1_WEST : AABB_2_WEST;

		case NORTH:
		default:
			return (i == 1)? AABB_1_NORTH : AABB_2_NORTH;
		}
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox,
			List<AxisAlignedBB> collidingBoxes, Entity entityIn, boolean t_f) {

		int i = ((Integer)state.getValue(STAGE_1_2)).intValue();
		EnumFacing direction = state.getValue(H_FACING);

		switch (direction) {
		case SOUTH:
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, (i == 1)? AABB_1_SOUTH : AABB_2_SOUTH);
			break;

		case EAST:
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, (i == 1)? AABB_1_EAST : AABB_2_EAST);
			break;

		case WEST:
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, (i == 1)? AABB_1_WEST : AABB_2_WEST);
			break;

		case NORTH :
		default:
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, (i == 1)? AABB_1_NORTH : AABB_2_NORTH);
			break;
		}
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
		if (this == JPDeco_Blocks.FUTON_white) { return new ItemStack(Items_Wadeco.FUTON_item, 1, 0); }
		if (this == JPDeco_Blocks.FUTON_orange) { return new ItemStack(Items_Wadeco.FUTON_item, 1, 1); }
		if (this == JPDeco_Blocks.FUTON_magenta) { return new ItemStack(Items_Wadeco.FUTON_item, 1, 2); }
		if (this == JPDeco_Blocks.FUTON_lightb) { return new ItemStack(Items_Wadeco.FUTON_item, 1, 3); }
		if (this == JPDeco_Blocks.FUTON_yellow) { return new ItemStack(Items_Wadeco.FUTON_item, 1, 4); }
		if (this == JPDeco_Blocks.FUTON_lime) { return new ItemStack(Items_Wadeco.FUTON_item, 1, 5); }
		if (this == JPDeco_Blocks.FUTON_pink) { return new ItemStack(Items_Wadeco.FUTON_item, 1, 6); }
		if (this == JPDeco_Blocks.FUTON_gray) { return new ItemStack(Items_Wadeco.FUTON_item, 1, 7); }
		if (this == JPDeco_Blocks.FUTON_lightg) { return new ItemStack(Items_Wadeco.FUTON_item, 1, 8); }
		if (this == JPDeco_Blocks.FUTON_cyan) { return new ItemStack(Items_Wadeco.FUTON_item, 1, 9); }
		if (this == JPDeco_Blocks.FUTON_purple) { return new ItemStack(Items_Wadeco.FUTON_item, 1, 10); }
		if (this == JPDeco_Blocks.FUTON_blue) { return new ItemStack(Items_Wadeco.FUTON_item, 1, 11); }
		if (this == JPDeco_Blocks.FUTON_brown) { return new ItemStack(Items_Wadeco.FUTON_item, 1, 12); }
		if (this == JPDeco_Blocks.FUTON_green) { return new ItemStack(Items_Wadeco.FUTON_item, 1, 13); }
		if (this == JPDeco_Blocks.FUTON_red) { return new ItemStack(Items_Wadeco.FUTON_item, 1, 14); }
		if (this == JPDeco_Blocks.FUTON_black) { return new ItemStack(Items_Wadeco.FUTON_item, 1, 15); }
		return null;
	}
}
