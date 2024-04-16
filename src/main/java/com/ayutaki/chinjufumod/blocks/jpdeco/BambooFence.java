package com.ayutaki.chinjufumod.blocks.jpdeco;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BambooFence extends FenceBlock {

	private static final VoxelShape AABB_CENTER = Block.box(6.5D, 0.0D, 6.5D, 9.5D, 16.0D, 9.5D);
	private static final VoxelShape AABB_NORTH = Block.box(6.5D, 0.0D, 0.0D, 9.5D, 16.0D, 6.5D);
	private static final VoxelShape AABB_EAST = Block.box(9.5D, 0.0D, 6.5D, 16.0D, 16.0D, 9.5D);
	private static final VoxelShape AABB_SOUTH = Block.box(6.5D, 0.0D, 9.5D, 9.5D, 16.0D, 16.0D);
	private static final VoxelShape AABB_WEST = Block.box(0.0D, 0.0D, 6.5D, 6.5D, 16.0D, 9.5D);
	
	public BambooFence(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		boolean north = state.getValue(NORTH).booleanValue();
		boolean east = state.getValue(EAST).booleanValue();
		boolean south = state.getValue(SOUTH).booleanValue();
		boolean west = state.getValue(WEST).booleanValue();

		VoxelShape shape = AABB_CENTER;

		if (!north && !south && !east && !west) { shape = Shapes.or(shape); }
		if (north) { shape = Shapes.or(shape, AABB_NORTH); }
		if (south) { shape = Shapes.or(shape, AABB_SOUTH); }
		if (east) { shape = Shapes.or(shape, AABB_EAST); }
		if (west) { shape = Shapes.or(shape, AABB_WEST); }

		return shape;
	}
	
	/* Flammable Block */
	@Override
	public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction direct) { return true; }

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction direct) { return 5; }

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction direct) { return 20; }
	
}
