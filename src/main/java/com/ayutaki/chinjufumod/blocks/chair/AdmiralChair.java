package com.ayutaki.chinjufumod.blocks.chair;

import com.ayutaki.chinjufumod.entity.SitableEntity;
import com.ayutaki.chinjufumod.handler.CMEvents;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.properties.DoubleBlockHalf;
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

public class AdmiralChair extends BaseDoubleChair {

	/* Collision */
	protected static final VoxelShape BASE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 9.0D, 16.0D);

	protected static final VoxelShape BOT_SOUTH = VoxelShapes.or(BASE, Block.box(0.0D, 9.0D, 0.0D, 16.0D, 16.0D, 2.0D));
	protected static final VoxelShape BOT_WEST = VoxelShapes.or(BASE, Block.box(14.0D, 9.0D, 0.0D, 16.0D, 16.0D, 16.0D));
	protected static final VoxelShape BOT_NORTH = VoxelShapes.or(BASE, Block.box(0.0D, 9.0D, 14.0D, 16.0D, 16.0D, 16.0D));
	protected static final VoxelShape BOT_EAST = VoxelShapes.or(BASE, Block.box(0.0D, 9.0D, 0.0D, 2.0D, 16.0D, 16.0D));

	protected static final VoxelShape TOP_SOUTH = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 13.0D, 2.0D);
	protected static final VoxelShape TOP_WEST = Block.box(14.0D, 0.0D, 0.0D, 16.0D, 13.0D, 16.0D);
	protected static final VoxelShape TOP_NORTH = Block.box(0.0D, 0.0D, 14.0D, 16.0D, 13.0D, 16.0D);
	protected static final VoxelShape TOP_EAST = Block.box(0.0D, 0.0D, 0.0D, 2.0D, 13.0D, 16.0D);
	
	public AdmiralChair(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		if (state.getValue(HALF) == DoubleBlockHalf.LOWER) {
			CMEvents.soundSitChair(worldIn, pos);
			return SitableEntity.create(worldIn, pos, 0.35, playerIn);
		}
		return ActionResultType.PASS;
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.getValue(H_FACING);
		DoubleBlockHalf half = state.getValue(HALF);
		
		switch (half) {
		case LOWER:
		default:
			
			switch (direction) {
			case NORTH:
			default: return BOT_NORTH;
			case SOUTH: return BOT_SOUTH;
			case EAST: return BOT_EAST;
			case WEST: return BOT_WEST;
			} // switch

		case UPPER:
			
			switch (direction) {
			case NORTH:
			default: return TOP_NORTH;
			case SOUTH: return TOP_SOUTH;
			case EAST: return TOP_EAST;
			case WEST: return TOP_WEST;
			} // switch
		} // switch LOWER-UPPER
	}
}
