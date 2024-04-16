package com.ayutaki.chinjufumod.blocks.dish;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingWater;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class MeasureCup extends BaseFacingWater {

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.box(13.1D, 0.0, 0.7D, 15.5D, 2.7D, 3.5D);
	protected static final VoxelShape AABB_WEST = Block.box(12.5D, 0.0, 13.1D, 15.3D, 2.7D, 15.5D);
	protected static final VoxelShape AABB_NORTH = Block.box(0.5D, 0.0, 12.5D, 2.9D, 2.7D, 15.3D);
	protected static final VoxelShape AABB_EAST = Block.box(0.7D, 0.0, 0.5D, 3.5D, 2.7D, 2.9D);

	public MeasureCup(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getItemInHand(hand);

		if (stack.isEmpty()) {
			playerIn.inventory.add(new ItemStack(Items_Teatime.KEIRYO_CUP));
			CMEvents.soundItemPick(worldIn, pos);

			worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), 3); }
		
		if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
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
		}
	}
}
