package com.ayutaki.chinjufumod.blocks.chair;

import com.ayutaki.chinjufumod.entity.SitableEntity;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.color.Base_ItemHake;
import com.ayutaki.chinjufumod.state.TypeLR;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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

public class Sofa extends BaseSofa {

	/* Collision */
	protected static final VoxelShape DEFAULT_SOUTH = VoxelShapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 14.0D),
			Block.box(0.0D, 6.0D, 0.0D, 16.0D, 12.0D, 2.0D),
			Block.box(14.0D, 6.0D, 2.0D, 16.0D, 12.0D, 14.0D),
			Block.box(0.0D, 6.0D, 2.0D, 2.0D, 12.0D, 14.0D));
	protected static final VoxelShape DEFAULT_WEST = VoxelShapes.or(Block.box(2.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
			Block.box(14.0D, 6.0D, 0.0D, 16.0D, 12.0D, 16.0D),
			Block.box(2.0D, 6.0D, 14.0D, 14.0D, 12.0D, 16.0D),
			Block.box(2.0D, 6.0D, 0.0D, 14.0D, 12.0D, 2.0D));
	protected static final VoxelShape DEFAULT_NORTH = VoxelShapes.or(Block.box(0.0D, 0.0D, 2.0D, 16.0D, 6.0D, 16.0D),
			Block.box(0.0D, 6.0D, 14.0D, 16.0D, 12.0D, 16.0D),
			Block.box(14.0D, 6.0D, 2.0D, 16.0D, 12.0D, 14.0D),
			Block.box(0.0D, 6.0D, 2.0D, 2.0D, 12.0D, 14.0D));
	protected static final VoxelShape DEFAULT_EAST = VoxelShapes.or(Block.box(0.0D, 0.0D, 0.0D, 14.0D, 6.0D, 16.0D),
			Block.box(0.0D, 6.0D, 0.0D, 2.0D, 12.0D, 16.0D),
			Block.box(2.0D, 6.0D, 14.0D, 14.0D, 12.0D, 16.0D),
			Block.box(2.0D, 6.0D, 0.0D, 14.0D, 12.0D, 2.0D));
	
	protected static final VoxelShape LEFT_SOUTH = VoxelShapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 14.0D),
			Block.box(0.0D, 6.0D, 0.0D, 16.0D, 12.0D, 2.0D),
			Block.box(0.0D, 6.0D, 2.0D, 2.0D, 12.0D, 14.0D));
	protected static final VoxelShape LEFT_WEST = VoxelShapes.or(Block.box(2.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
			Block.box(14.0D, 6.0D, 0.0D, 16.0D, 12.0D, 16.0D),
			Block.box(2.0D, 6.0D, 0.0D, 14.0D, 12.0D, 2.0D));
	protected static final VoxelShape LEFT_NORTH = VoxelShapes.or(Block.box(0.0D, 0.0D, 2.0D, 16.0D, 6.0D, 16.0D),
			Block.box(0.0D, 6.0D, 14.0D, 16.0D, 12.0D, 16.0D),
			Block.box(14.0D, 6.0D, 2.0D, 16.0D, 12.0D, 14.0D));
	protected static final VoxelShape LEFT_EAST = VoxelShapes.or(Block.box(0.0D, 0.0D, 0.0D, 14.0D, 6.0D, 16.0D),
			Block.box(0.0D, 6.0D, 0.0D, 2.0D, 12.0D, 16.0D),
			Block.box(2.0D, 6.0D, 14.0D, 14.0D, 12.0D, 16.0D));
	
	protected static final VoxelShape RIGHT_SOUTH = VoxelShapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 14.0D),
			Block.box(0.0D, 6.0D, 0.0D, 16.0D, 12.0D, 2.0D),
			Block.box(14.0D, 6.0D, 2.0D, 16.0D, 12.0D, 14.0D));
	protected static final VoxelShape RIGHT_WEST = VoxelShapes.or(Block.box(2.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
			Block.box(14.0D, 6.0D, 0.0D, 16.0D, 12.0D, 16.0D),
			Block.box(2.0D, 6.0D, 14.0D, 14.0D, 12.0D, 16.0D));
	protected static final VoxelShape RIGHT_NORTH = VoxelShapes.or(Block.box(0.0D, 0.0D, 2.0D, 16.0D, 6.0D, 16.0D),
			Block.box(0.0D, 6.0D, 14.0D, 16.0D, 12.0D, 16.0D),
			Block.box(0.0D, 6.0D, 2.0D, 2.0D, 12.0D, 14.0D));
	protected static final VoxelShape RIGHT_EAST = VoxelShapes.or(Block.box(0.0D, 0.0D, 0.0D, 14.0D, 6.0D, 16.0D),
			Block.box(0.0D, 6.0D, 0.0D, 2.0D, 12.0D, 16.0D),
			Block.box(2.0D, 6.0D, 0.0D, 14.0D, 12.0D, 2.0D));
	
	protected static final VoxelShape BOTH_SOUTH = VoxelShapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 14.0D),
			Block.box(0.0D, 6.0D, 0.0D, 16.0D, 12.0D, 2.0D));
	protected static final VoxelShape BOTH_WEST = VoxelShapes.or(Block.box(2.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
			Block.box(14.0D, 6.0D, 0.0D, 16.0D, 12.0D, 16.0D));
	protected static final VoxelShape BOTH_NORTH = VoxelShapes.or(Block.box(0.0D, 0.0D, 2.0D, 16.0D, 6.0D, 16.0D),
			Block.box(0.0D, 6.0D, 14.0D, 16.0D, 12.0D, 16.0D));
	protected static final VoxelShape BOTH_EAST = VoxelShapes.or(Block.box(0.0D, 0.0D, 0.0D, 14.0D, 6.0D, 16.0D),
			Block.box(0.0D, 6.0D, 0.0D, 2.0D, 12.0D, 16.0D));

	public Sofa(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();

		if (item instanceof Base_ItemHake) { return ActionResultType.PASS; }

		else {
			CMEvents.soundKinuzure(worldIn, pos);
			return SitableEntity.create(worldIn, pos, 0.15, playerIn);
		}
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.getValue(H_FACING);
		TypeLR type = state.getValue(TYPE);

		switch (type) {
		case DEFAULT:
		default:
			switch (direction) {
			case NORTH:
			default: return DEFAULT_NORTH;
			case SOUTH: return DEFAULT_SOUTH;
			case EAST: return DEFAULT_EAST;
			case WEST: return DEFAULT_WEST;
			} // switch
			
		case LEFT:
			switch (direction) {
			case NORTH:
			default: return LEFT_NORTH;
			case SOUTH: return LEFT_SOUTH;
			case EAST: return LEFT_EAST;
			case WEST: return LEFT_WEST;
			} // switch
			
		case RIGHT:
			switch (direction) {
			case NORTH:
			default: return RIGHT_NORTH;
			case SOUTH: return RIGHT_SOUTH;
			case EAST: return RIGHT_EAST;
			case WEST: return RIGHT_WEST;
			} // switch
			
		case BOTH:			
			switch (direction) {
			case NORTH:
			default: return BOTH_NORTH;
			case SOUTH: return BOTH_SOUTH;
			case EAST: return BOTH_EAST;
			case WEST: return BOTH_WEST;
			} // switch
		}
	}
}
