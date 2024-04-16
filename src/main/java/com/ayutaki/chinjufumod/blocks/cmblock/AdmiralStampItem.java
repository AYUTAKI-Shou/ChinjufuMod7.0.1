package com.ayutaki.chinjufumod.blocks.cmblock;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
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
	protected static final VoxelShape AABB_SOUTH = Block.makeCuboidShape(11.0D, 0.0, 11.0D, 15.0D, 4.0D, 15.0D);
	protected static final VoxelShape AABB_WEST = Block.makeCuboidShape(1.0D, 0.0, 11.0D, 5.0D, 4.0D, 15.0D);
	protected static final VoxelShape AABB_NORTH = Block.makeCuboidShape(1.0D, 0.0, 1.0D, 5.0D, 4.0D, 5.0D);
	protected static final VoxelShape AABB_EAST = Block.makeCuboidShape(11.0D, 0.0, 1.0D, 15.0D, 4.0D, 5.0D);

	public AdmiralStampItem(Block.Properties properties) {
		super(properties);
		/** Default state **/
		setDefaultState(this.stateContainer.getBaseState().with(H_FACING, Direction.NORTH)
				.with(AGE_1_16, Integer.valueOf(1))
				.with(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* Gives a value when placed. +180 .getOpposite() */
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getWorld();
		BlockPos pos = context.getPos();
		IFluidState fluid = worldIn.getFluidState(pos);
		ItemStack stack = context.getItem();
		
		if ((stack.getDamage() > stack.getMaxDamage() - 16) &&
				(stack.getDamage() <= stack.getMaxDamage() - 15)) {
			return this.getDefaultState().with(AGE_1_16, Integer.valueOf(2))
					.with(WATERLOGGED, fluid.getFluid() == Fluids.WATER)
					.with(H_FACING, context.getPlacementHorizontalFacing().getOpposite()); }
		
		if ((stack.getDamage() > stack.getMaxDamage() - 15) &&
				(stack.getDamage() <= stack.getMaxDamage() - 14)) {
			return this.getDefaultState().with(AGE_1_16, Integer.valueOf(3))
					.with(WATERLOGGED, fluid.getFluid() == Fluids.WATER)
					.with(H_FACING, context.getPlacementHorizontalFacing().getOpposite()); }
		
		if ((stack.getDamage() > stack.getMaxDamage() - 14) &&
				(stack.getDamage() <= stack.getMaxDamage() - 13)) {
			return this.getDefaultState().with(AGE_1_16, Integer.valueOf(4))
					.with(WATERLOGGED, fluid.getFluid() == Fluids.WATER)
					.with(H_FACING, context.getPlacementHorizontalFacing().getOpposite()); }
		
		if ((stack.getDamage() > stack.getMaxDamage() - 13) &&
				(stack.getDamage() <= stack.getMaxDamage() - 12)) {
			return this.getDefaultState().with(AGE_1_16, Integer.valueOf(5))
					.with(WATERLOGGED, fluid.getFluid() == Fluids.WATER)
					.with(H_FACING, context.getPlacementHorizontalFacing().getOpposite()); }
		
		if ((stack.getDamage() > stack.getMaxDamage() - 12) &&
				(stack.getDamage() <= stack.getMaxDamage() - 11)) {
			return this.getDefaultState().with(AGE_1_16, Integer.valueOf(6))
					.with(WATERLOGGED, fluid.getFluid() == Fluids.WATER)
					.with(H_FACING, context.getPlacementHorizontalFacing().getOpposite()); }
		
		if ((stack.getDamage() > stack.getMaxDamage() - 11) &&
				(stack.getDamage() <= stack.getMaxDamage() - 10)) {
			return this.getDefaultState().with(AGE_1_16, Integer.valueOf(7))
					.with(WATERLOGGED, fluid.getFluid() == Fluids.WATER)
					.with(H_FACING, context.getPlacementHorizontalFacing().getOpposite()); }
		
		if ((stack.getDamage() > stack.getMaxDamage() - 10) &&
				(stack.getDamage() <= stack.getMaxDamage() - 9)) {
			return this.getDefaultState().with(AGE_1_16, Integer.valueOf(8))
					.with(WATERLOGGED, fluid.getFluid() == Fluids.WATER)
					.with(H_FACING, context.getPlacementHorizontalFacing().getOpposite()); }
		
		if ((stack.getDamage() > stack.getMaxDamage() - 9) &&
				(stack.getDamage() <= stack.getMaxDamage() - 8)) {
			return this.getDefaultState().with(AGE_1_16, Integer.valueOf(9))
					.with(WATERLOGGED, fluid.getFluid() == Fluids.WATER)
					.with(H_FACING, context.getPlacementHorizontalFacing().getOpposite()); }
		
		if ((stack.getDamage() > stack.getMaxDamage() - 8) &&
				(stack.getDamage() < stack.getMaxDamage() - 6)) {
			return this.getDefaultState().with(AGE_1_16, Integer.valueOf(10))
					.with(WATERLOGGED, fluid.getFluid() == Fluids.WATER)
					.with(H_FACING, context.getPlacementHorizontalFacing().getOpposite()); }
		
		if (stack.getDamage() == stack.getMaxDamage() - 6) {
			return this.getDefaultState().with(AGE_1_16, Integer.valueOf(11))
					.with(WATERLOGGED, fluid.getFluid() == Fluids.WATER)
					.with(H_FACING, context.getPlacementHorizontalFacing().getOpposite()); }
		
		if ((stack.getDamage() > stack.getMaxDamage() - 6) &&
				(stack.getDamage() <= stack.getMaxDamage() - 5)) {
			return this.getDefaultState().with(AGE_1_16, Integer.valueOf(12))
					.with(WATERLOGGED, fluid.getFluid() == Fluids.WATER)
					.with(H_FACING, context.getPlacementHorizontalFacing().getOpposite()); }
		
		if ((stack.getDamage() > stack.getMaxDamage() - 5) &&
				(stack.getDamage() <= stack.getMaxDamage() - 4)) {
			return this.getDefaultState().with(AGE_1_16, Integer.valueOf(13))
					.with(WATERLOGGED, fluid.getFluid() == Fluids.WATER)
					.with(H_FACING, context.getPlacementHorizontalFacing().getOpposite()); }
		
		if ((stack.getDamage() > stack.getMaxDamage() - 4) &&
				(stack.getDamage() <= stack.getMaxDamage() - 3)) {
			return this.getDefaultState().with(AGE_1_16, Integer.valueOf(14))
					.with(WATERLOGGED, fluid.getFluid() == Fluids.WATER)
					.with(H_FACING, context.getPlacementHorizontalFacing().getOpposite()); }
		
		if ((stack.getDamage() > stack.getMaxDamage() - 3) &&
				(stack.getDamage() <= stack.getMaxDamage() - 2)) {
			return this.getDefaultState().with(AGE_1_16, Integer.valueOf(15))
					.with(WATERLOGGED, fluid.getFluid() == Fluids.WATER)
					.with(H_FACING, context.getPlacementHorizontalFacing().getOpposite()); }
		
		if (stack.getDamage() > stack.getMaxDamage() - 2) {
			return this.getDefaultState().with(AGE_1_16, Integer.valueOf(16))
					.with(WATERLOGGED, fluid.getFluid() == Fluids.WATER)
					.with(H_FACING, context.getPlacementHorizontalFacing().getOpposite()); }
		
		else {
			return this.getDefaultState().with(AGE_1_16, Integer.valueOf(1))
					.with(WATERLOGGED, fluid.getFluid() == Fluids.WATER)
					.with(H_FACING, context.getPlacementHorizontalFacing().getOpposite()); }
	}
	
	/* HORIZONTAL Property */
	@Override
	public BlockState rotate(BlockState state, Rotation rotation) {
		return state.with(H_FACING, rotation.rotate(state.get(H_FACING)));
	}

	@Override
	public BlockState mirror(BlockState state, Mirror mirror) {
		return state.rotate(mirror.toRotation(state.get(H_FACING)));
	}

	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn)); }
		
		return super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
	}

	/* Create Blockstate */
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(H_FACING, AGE_1_16, WATERLOGGED);
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(H_FACING);
		switch(direction) {
		case NORTH:
		default: return AABB_NORTH;
		case SOUTH: return AABB_SOUTH;
		case WEST: return AABB_WEST;
		case EAST: return AABB_EAST;
		}
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

	/* Can't breathe. */
	@Override
	public boolean causesSuffocation(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	/* Block is a cube. */
	@Override
	public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	/* Mobs spawn. */
	@Override
	public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type) {
		return false;
	}
}
