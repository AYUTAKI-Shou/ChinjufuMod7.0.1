package com.ayutaki.chinjufumod.blocks.chair;

import com.ayutaki.chinjufumod.entity.SitableEntity;
import com.ayutaki.chinjufumod.handler.CMEvents;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class Bench extends BaseSofa {

	/* Collision */
	protected static final VoxelShape BASE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D);
	
	protected static final VoxelShape AABB_SOUTH = VoxelShapes.or(BASE, Block.makeCuboidShape(0.0D, 7.0D, 0.0D, 16.0D, 15.0D, 5.0D));
	protected static final VoxelShape AABB_WEST = VoxelShapes.or(BASE, Block.makeCuboidShape(11.0D, 7.0D, 0.0D, 16.0D, 15.0D, 16.0D));
	protected static final VoxelShape AABB_NORTH = VoxelShapes.or(BASE, Block.makeCuboidShape(0.0D, 7.0D, 11.0D, 16.0D, 15.0D, 16.0D));
	protected static final VoxelShape AABB_EAST = VoxelShapes.or(BASE, Block.makeCuboidShape(0.0D, 7.0D, 0.0D, 5.0D, 15.0D, 16.0D));

	public Bench(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		CMEvents.soundKinuzure(worldIn, pos);
		return SitableEntity.create(worldIn, pos, 0.25, playerIn);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(H_FACING);

		switch (direction) {
		case NORTH:
		default: return AABB_NORTH;
		case SOUTH: return AABB_SOUTH;
		case EAST: return AABB_EAST;
		case WEST: return AABB_WEST;
		} // switch
	}

}
