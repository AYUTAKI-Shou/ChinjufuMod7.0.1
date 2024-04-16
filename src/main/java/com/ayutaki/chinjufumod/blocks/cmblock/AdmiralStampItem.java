package com.ayutaki.chinjufumod.blocks.cmblock;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class AdmiralStampItem extends CM_WaterLogged {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final IntegerProperty AGE_1_16 = IntegerProperty.create("age", 1, 16);
	
	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.box(11.0D, 0.0, 11.0D, 15.0D, 4.0D, 15.0D);
	protected static final VoxelShape AABB_WEST = Block.box(1.0D, 0.0, 11.0D, 5.0D, 4.0D, 15.0D);
	protected static final VoxelShape AABB_NORTH = Block.box(1.0D, 0.0, 1.0D, 5.0D, 4.0D, 5.0D);
	protected static final VoxelShape AABB_EAST = Block.box(11.0D, 0.0, 1.0D, 15.0D, 4.0D, 5.0D);

	public AdmiralStampItem(AbstractBlock.Properties properties) {
		super(properties);
		/** Default state **/
		registerDefaultState(this.defaultBlockState().setValue(H_FACING, Direction.NORTH)
				.setValue(AGE_1_16, Integer.valueOf(1))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);
		ItemStack stack = context.getItemInHand();
		
		if ((stack.getDamageValue() > stack.getMaxDamage() - 16) &&
				(stack.getDamageValue() <= stack.getMaxDamage() - 15)) {
			return this.defaultBlockState().setValue(AGE_1_16, Integer.valueOf(2))
					.setValue(WATERLOGGED, fluid.getType() == Fluids.WATER)
					.setValue(H_FACING, context.getHorizontalDirection().getOpposite()); }
		
		if ((stack.getDamageValue() > stack.getMaxDamage() - 15) &&
				(stack.getDamageValue() <= stack.getMaxDamage() - 14)) {
			return this.defaultBlockState().setValue(AGE_1_16, Integer.valueOf(3))
					.setValue(WATERLOGGED, fluid.getType() == Fluids.WATER)
					.setValue(H_FACING, context.getHorizontalDirection().getOpposite()); }
		
		if ((stack.getDamageValue() > stack.getMaxDamage() - 14) &&
				(stack.getDamageValue() <= stack.getMaxDamage() - 13)) {
			return this.defaultBlockState().setValue(AGE_1_16, Integer.valueOf(4))
					.setValue(WATERLOGGED, fluid.getType() == Fluids.WATER)
					.setValue(H_FACING, context.getHorizontalDirection().getOpposite()); }
		
		if ((stack.getDamageValue() > stack.getMaxDamage() - 13) &&
				(stack.getDamageValue() <= stack.getMaxDamage() - 12)) {
			return this.defaultBlockState().setValue(AGE_1_16, Integer.valueOf(5))
					.setValue(WATERLOGGED, fluid.getType() == Fluids.WATER)
					.setValue(H_FACING, context.getHorizontalDirection().getOpposite()); }
		
		if ((stack.getDamageValue() > stack.getMaxDamage() - 12) &&
				(stack.getDamageValue() <= stack.getMaxDamage() - 11)) {
			return this.defaultBlockState().setValue(AGE_1_16, Integer.valueOf(6))
					.setValue(WATERLOGGED, fluid.getType() == Fluids.WATER)
					.setValue(H_FACING, context.getHorizontalDirection().getOpposite()); }
		
		if ((stack.getDamageValue() > stack.getMaxDamage() - 11) &&
				(stack.getDamageValue() <= stack.getMaxDamage() - 10)) {
			return this.defaultBlockState().setValue(AGE_1_16, Integer.valueOf(7))
					.setValue(WATERLOGGED, fluid.getType() == Fluids.WATER)
					.setValue(H_FACING, context.getHorizontalDirection().getOpposite()); }
		
		if ((stack.getDamageValue() > stack.getMaxDamage() - 10) &&
				(stack.getDamageValue() <= stack.getMaxDamage() - 9)) {
			return this.defaultBlockState().setValue(AGE_1_16, Integer.valueOf(8))
					.setValue(WATERLOGGED, fluid.getType() == Fluids.WATER)
					.setValue(H_FACING, context.getHorizontalDirection().getOpposite()); }
		
		if ((stack.getDamageValue() > stack.getMaxDamage() - 9) &&
				(stack.getDamageValue() <= stack.getMaxDamage() - 8)) {
			return this.defaultBlockState().setValue(AGE_1_16, Integer.valueOf(9))
					.setValue(WATERLOGGED, fluid.getType() == Fluids.WATER)
					.setValue(H_FACING, context.getHorizontalDirection().getOpposite()); }
		
		if ((stack.getDamageValue() > stack.getMaxDamage() - 8) &&
				(stack.getDamageValue() < stack.getMaxDamage() - 6)) {
			return this.defaultBlockState().setValue(AGE_1_16, Integer.valueOf(10))
					.setValue(WATERLOGGED, fluid.getType() == Fluids.WATER)
					.setValue(H_FACING, context.getHorizontalDirection().getOpposite()); }
		
		if (stack.getDamageValue() == stack.getMaxDamage() - 6) {
			return this.defaultBlockState().setValue(AGE_1_16, Integer.valueOf(11))
					.setValue(WATERLOGGED, fluid.getType() == Fluids.WATER)
					.setValue(H_FACING, context.getHorizontalDirection().getOpposite()); }
		
		if ((stack.getDamageValue() > stack.getMaxDamage() - 6) &&
				(stack.getDamageValue() <= stack.getMaxDamage() - 5)) {
			return this.defaultBlockState().setValue(AGE_1_16, Integer.valueOf(12))
					.setValue(WATERLOGGED, fluid.getType() == Fluids.WATER)
					.setValue(H_FACING, context.getHorizontalDirection().getOpposite()); }
		
		if ((stack.getDamageValue() > stack.getMaxDamage() - 5) &&
				(stack.getDamageValue() <= stack.getMaxDamage() - 4)) {
			return this.defaultBlockState().setValue(AGE_1_16, Integer.valueOf(13))
					.setValue(WATERLOGGED, fluid.getType() == Fluids.WATER)
					.setValue(H_FACING, context.getHorizontalDirection().getOpposite()); }
		
		if ((stack.getDamageValue() > stack.getMaxDamage() - 4) &&
				(stack.getDamageValue() <= stack.getMaxDamage() - 3)) {
			return this.defaultBlockState().setValue(AGE_1_16, Integer.valueOf(14))
					.setValue(WATERLOGGED, fluid.getType() == Fluids.WATER)
					.setValue(H_FACING, context.getHorizontalDirection().getOpposite()); }
		
		if ((stack.getDamageValue() > stack.getMaxDamage() - 3) &&
				(stack.getDamageValue() <= stack.getMaxDamage() - 2)) {
			return this.defaultBlockState().setValue(AGE_1_16, Integer.valueOf(15))
					.setValue(WATERLOGGED, fluid.getType() == Fluids.WATER)
					.setValue(H_FACING, context.getHorizontalDirection().getOpposite()); }
		
		if (stack.getDamageValue() > stack.getMaxDamage() - 2) {
			return this.defaultBlockState().setValue(AGE_1_16, Integer.valueOf(16))
					.setValue(WATERLOGGED, fluid.getType() == Fluids.WATER)
					.setValue(H_FACING, context.getHorizontalDirection().getOpposite()); }
		
		else {
			return this.defaultBlockState().setValue(AGE_1_16, Integer.valueOf(1))
					.setValue(WATERLOGGED, fluid.getType() == Fluids.WATER)
					.setValue(H_FACING, context.getHorizontalDirection().getOpposite()); }
	}
	
	/* HORIZONTAL Property */
	@Override
	public BlockState rotate(BlockState state, Rotation rotation) {
		return state.setValue(H_FACING, rotation.rotate(state.getValue(H_FACING)));
	}

	@SuppressWarnings("deprecation")
	public BlockState mirror(BlockState state, Mirror mirror) {
		return state.rotate(mirror.getRotation(state.getValue(H_FACING)));
	}

	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }
		
		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}
	
	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(H_FACING, AGE_1_16, WATERLOGGED);
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.getValue(H_FACING);
		
		switch (direction) {
		case NORTH:
		default: return AABB_NORTH;
		case SOUTH: return AABB_SOUTH;
		case WEST: return AABB_WEST;
		case EAST: return AABB_EAST;
		} // switch
	}
	
	/* The best harvesting tool. */
	@Nullable
	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.AXE;
	}

	@Override
	public int getHarvestLevel(BlockState state) {
		return 0;
	}

	/* 上からの光透過 */
	@Override
	public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
		return true;
	}
}
