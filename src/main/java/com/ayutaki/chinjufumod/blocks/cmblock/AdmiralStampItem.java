package com.ayutaki.chinjufumod.blocks.cmblock;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AdmiralStampItem extends CM_WaterLogged {
	
	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final IntegerProperty AGE_1_16 = IntegerProperty.create("age", 1, 16);
	
	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.box(11.0D, 0.0, 11.0D, 15.0D, 4.0D, 15.0D);
	protected static final VoxelShape AABB_WEST = Block.box(1.0D, 0.0, 11.0D, 5.0D, 4.0D, 15.0D);
	protected static final VoxelShape AABB_NORTH = Block.box(1.0D, 0.0, 1.0D, 5.0D, 4.0D, 5.0D);
	protected static final VoxelShape AABB_EAST = Block.box(11.0D, 0.0, 1.0D, 15.0D, 4.0D, 5.0D);
	
	public AdmiralStampItem(BlockBehaviour.Properties properties) {
		super(properties);
		/** Default state **/
		this.registerDefaultState(this.stateDefinition.any().setValue(H_FACING, Direction.NORTH)
				.setValue(AGE_1_16, Integer.valueOf(1))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}
	
	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		Level worldIn = context.getLevel();
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
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos pos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			worldIn.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }
		
		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}
	
	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(H_FACING, AGE_1_16, WATERLOGGED);
	}
	
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		Direction direction = state.getValue(H_FACING);
		switch (direction) {
		case NORTH:
		default: return AABB_NORTH;
		case SOUTH: return AABB_SOUTH;
		case WEST: return AABB_WEST;
		case EAST: return AABB_EAST;
		}
	}
}
