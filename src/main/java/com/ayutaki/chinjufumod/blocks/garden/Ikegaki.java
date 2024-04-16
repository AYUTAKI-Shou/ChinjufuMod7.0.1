package com.ayutaki.chinjufumod.blocks.garden;

import com.ayutaki.chinjufumod.blocks.base.BaseWaterLogged;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Ikegaki extends BaseWaterLogged {

	/* Collision */
	protected static final VoxelShape AABB_BOX = Shapes.or(Block.box(0.1D, 3.5D, 0.1D, 15.9D, 16.0D, 15.9D),
			Block.box(7.0D, 0.0D, 7.0D, 9.0D, 3.5D, 9.0D));
	protected static final VoxelShape COLL_BOX = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 24.0D, 16.0D);
	
	public Ikegaki(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return AABB_BOX;
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return COLL_BOX;
	}
	
	/* Flammable Block */
	@Override
	public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction direct) { return true; }

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction direct) { return 5; }

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction direct) { return 20; }
}
