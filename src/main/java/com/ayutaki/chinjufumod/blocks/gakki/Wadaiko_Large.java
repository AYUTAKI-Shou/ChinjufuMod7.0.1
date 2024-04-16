package com.ayutaki.chinjufumod.blocks.gakki;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class Wadaiko_Large extends Wadaiko_Base {

	/* Collision */
	protected static final VoxelShape BOT1_SOUTH = Block.makeCuboidShape(2.5D, 0.0D, 3.5D, 13.5D, 15.25D, 12.5D);
	protected static final VoxelShape BOT1_WEST = Block.makeCuboidShape(3.5D, 0.0D, 2.5D, 12.5D, 15.25D, 13.5D);
	protected static final VoxelShape BOT1_NORTH = Block.makeCuboidShape(2.5D, 0.0D, 3.5D, 13.5D, 15.25D, 12.5D);
	protected static final VoxelShape BOT1_EAST = Block.makeCuboidShape(3.5D, 0.0D, 2.5D, 12.5D, 15.25D, 13.5D);

	protected static final VoxelShape TOP1_SOUTH = Block.makeCuboidShape(3.25D, 0.0D, 1.0D, 12.75D, 9.5D, 15.0D);
	protected static final VoxelShape TOP1_WEST = Block.makeCuboidShape(1.0D, 0.0D, 3.25D, 15.0D, 9.5D, 12.75D);
	protected static final VoxelShape TOP1_NORTH = Block.makeCuboidShape(3.25D, 0.0D, 1.0D, 12.75D, 9.5D, 15.0D);
	protected static final VoxelShape TOP1_EAST = Block.makeCuboidShape(1.0D, 0.0D, 3.25D, 15.0D, 9.5D, 12.75D);

	protected static final VoxelShape BOT2_SOUTH = Block.makeCuboidShape(3.25D, 0.0D, 0.5D, 12.75D, 16.0D, 15.5D);
	protected static final VoxelShape BOT2_WEST = Block.makeCuboidShape(0.5D, 0.0D, 3.25D, 15.0D, 15.5D, 12.75D);
	protected static final VoxelShape BOT2_NORTH = Block.makeCuboidShape(3.25D, 0.0D, 0.5D, 12.75D, 16.0D, 15.5D);
	protected static final VoxelShape BOT2_EAST = Block.makeCuboidShape(0.5D, 0.0D, 3.25D, 15.0D, 15.5D, 12.75D);

	protected static final VoxelShape TOP2_SOUTH = VoxelShapes.or(Block.makeCuboidShape(3.75D, 0.0D, 0.5D, 12.25D, 3.0D, 8.0D),
																										Block.makeCuboidShape(3.75D, 0.0D, 8.0D, 12.25D, 7.0D, 15.5D));
	protected static final VoxelShape TOP2_WEST = VoxelShapes.or(Block.makeCuboidShape(0.5D, 0.0D, 3.75D, 8.0D, 7.0D, 12.25D),
																									Block.makeCuboidShape(8.0D, 0.0D, 3.75D, 15.5D, 3.0D, 12.25D));
	protected static final VoxelShape TOP2_NORTH = VoxelShapes.or(Block.makeCuboidShape(3.75D, 0.0D, 0.5D, 12.25D, 7.0D, 8.0D),
																										Block.makeCuboidShape(3.75D, 0.0D, 8.0D, 12.25D, 3.0D, 15.5D));
	protected static final VoxelShape TOP2_EAST = VoxelShapes.or(Block.makeCuboidShape(0.5D, 0.0D, 3.75D, 8.0D, 3.0D, 12.25D),
																									Block.makeCuboidShape(8.0D, 0.0D, 3.75D, 15.5D, 7.0D, 12.25D));

	protected static final VoxelShape BOT3_BOX = Block.makeCuboidShape(3.25D, 0.0D, 3.25D, 12.75D, 14.0D, 12.75D);


	public Wadaiko_Large(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		int i = state.get(STAGE_1_3);
		Direction direction = state.get(H_FACING);
		DoubleBlockHalf half = state.get(HALF);
		
		switch (half) {
		case LOWER:
		default:

			switch (i) {
			case 1:
			default:
				if (playerIn.isSneaking()) {
					if (stack.isEmpty()) {
						CMEvents.soundWoodPlace(worldIn, pos);
						
						worldIn.setBlockState(pos, state.with(STAGE_1_3, Integer.valueOf(2)));
						worldIn.setBlockState(pos.up(), this.getDefaultState().with(H_FACING, state.get(H_FACING))
						.with(HALF, DoubleBlockHalf.UPPER).with(STAGE_1_3, Integer.valueOf(2))); }
					
					if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); } }
				break;

			case 2:
				if (playerIn.isSneaking()) {
					if (stack.isEmpty()) {
						CMEvents.soundWoodPlace(worldIn, pos);
						
						worldIn.setBlockState(pos, state.with(STAGE_1_3, Integer.valueOf(3)));
						worldIn.setBlockState(pos.up(), this.getDefaultState().with(H_FACING, state.get(H_FACING))
						.with(HALF, DoubleBlockHalf.UPPER).with(STAGE_1_3, Integer.valueOf(3))); }
					
					if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); } }
				break;

			case 3:
				if (playerIn.isSneaking()) {
					if (stack.isEmpty()) {
						CMEvents.soundWoodPlace(worldIn, pos);
						
						worldIn.setBlockState(pos, state.with(STAGE_1_3, Integer.valueOf(1)));
						worldIn.setBlockState(pos.up(), this.getDefaultState().with(H_FACING, state.get(H_FACING))
								.with(HALF, DoubleBlockHalf.UPPER).with(STAGE_1_3, Integer.valueOf(1))); }
					
					if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); } }
				
				if (!playerIn.isSneaking()) { 
					if (hit.getFace() == Direction.UP) {
						if (item == Items.STICK) { CMEvents.wadaikoTop(worldIn, pos, 1.25F, 1.0F); }
						else { CMEvents.wadaikoTop(worldIn, pos, 0.2F, 1.0F); } }

					if (hit.getFace() != Direction.UP) {
						if (item == Items.STICK) { CMEvents.wadaikoSide(worldIn, pos, 1.25F, 1.0F); }
						else { CMEvents.wadaikoSide(worldIn, pos, 0.2F, 1.0F); } } }
				break;
			} // STAGE_1_3
			break;

		case UPPER:

			switch (i) {
			case 1:
			default:

				switch (direction) {
				case NORTH:
				default:
					if (hit.getFace() == Direction.NORTH || hit.getFace() == Direction.SOUTH) {
						if (item == Items.STICK) { CMEvents.wadaikoTop(worldIn, pos, 1.25F, 1.0F); }
						else { CMEvents.wadaikoTop(worldIn, pos, 0.2F, 1.0F); } }

					if (hit.getFace() != Direction.NORTH && hit.getFace() != Direction.SOUTH) {
						if (item == Items.STICK) { CMEvents.wadaikoSide(worldIn, pos, 1.25F, 1.0F); }
						else { CMEvents.wadaikoSide(worldIn, pos, 0.2F, 1.0F); } }
					break;

				case SOUTH:
					if (hit.getFace() == Direction.NORTH || hit.getFace() == Direction.SOUTH) {
						if (item == Items.STICK) { CMEvents.wadaikoTop(worldIn, pos, 1.25F, 1.0F); }
						else { CMEvents.wadaikoTop(worldIn, pos, 0.2F, 1.0F); } }

					if (hit.getFace() != Direction.NORTH && hit.getFace() != Direction.SOUTH) {
						if (item == Items.STICK) { CMEvents.wadaikoSide(worldIn, pos, 1.25F, 1.0F); }
						else { CMEvents.wadaikoSide(worldIn, pos, 0.2F, 1.0F); } }
					break;

				case EAST:
					if (hit.getFace() == Direction.EAST || hit.getFace() == Direction.WEST) {
						if (item == Items.STICK) { CMEvents.wadaikoTop(worldIn, pos, 1.25F, 1.0F); }
						else { CMEvents.wadaikoTop(worldIn, pos, 0.2F, 1.0F); } }

					if (hit.getFace() != Direction.EAST && hit.getFace() != Direction.WEST) {
						if (item == Items.STICK) { CMEvents.wadaikoSide(worldIn, pos, 1.25F, 1.0F); }
						else { CMEvents.wadaikoSide(worldIn, pos, 0.2F, 1.0F); } }
					break;
					
				case WEST:
					if (hit.getFace() == Direction.EAST || hit.getFace() == Direction.WEST) {
						if (item == Items.STICK) { CMEvents.wadaikoTop(worldIn, pos, 1.25F, 1.0F); }
						else { CMEvents.wadaikoTop(worldIn, pos, 0.2F, 1.0F); } }

					if (hit.getFace() != Direction.EAST && hit.getFace() != Direction.WEST) {
						if (item == Items.STICK) { CMEvents.wadaikoSide(worldIn, pos, 1.25F, 1.0F); }
						else { CMEvents.wadaikoSide(worldIn, pos, 0.2F, 1.0F); } }
					break;
				} // switch
				break;

			case 2:

				switch (direction) {
				case NORTH:
				default:
					if (hit.getFace() == Direction.NORTH) {
						if (item == Items.STICK) { CMEvents.wadaikoTop(worldIn, pos, 1.25F, 1.0F); }
						else { CMEvents.wadaikoTop(worldIn, pos, 0.2F, 1.0F); } }

					if (hit.getFace() != Direction.NORTH) {
						if (item == Items.STICK) { CMEvents.wadaikoSide(worldIn, pos, 1.25F, 1.0F); }
						else { CMEvents.wadaikoSide(worldIn, pos, 0.2F, 1.0F); } }
					break;

				case SOUTH:
					if (hit.getFace() == Direction.SOUTH) {
						if (item == Items.STICK) { CMEvents.wadaikoTop(worldIn, pos, 1.25F, 1.0F); }
						else { CMEvents.wadaikoTop(worldIn, pos, 0.2F, 1.0F); } }

					if (hit.getFace() != Direction.SOUTH) {
						if (item == Items.STICK) { CMEvents.wadaikoSide(worldIn, pos, 1.25F, 1.0F); }
						else { CMEvents.wadaikoSide(worldIn, pos, 0.2F, 1.0F); } }
					break;

				case EAST:
					if (hit.getFace() == Direction.EAST) {
						if (item == Items.STICK) { CMEvents.wadaikoTop(worldIn, pos, 1.25F, 1.0F); }
						else { CMEvents.wadaikoTop(worldIn, pos, 0.2F, 1.0F); } }

					if (hit.getFace() != Direction.EAST) {
						if (item == Items.STICK) { CMEvents.wadaikoSide(worldIn, pos, 1.25F, 1.0F); }
						else { CMEvents.wadaikoSide(worldIn, pos, 0.2F, 1.0F); } }
					break;
					
				case WEST:
					if (hit.getFace() == Direction.WEST) {
						if (item == Items.STICK) { CMEvents.wadaikoTop(worldIn, pos, 1.25F, 1.0F); }
						else { CMEvents.wadaikoTop(worldIn, pos, 0.2F, 1.0F); } }

					if (hit.getFace() != Direction.WEST) {
						if (item == Items.STICK) { CMEvents.wadaikoSide(worldIn, pos, 1.25F, 1.0F); }
						else { CMEvents.wadaikoSide(worldIn, pos, 0.2F, 1.0F); } }
					break;
				} // switch
				break;

			case 3:
				break;
			} // STAGE_1_3
			break;
		} // switch LOWER-UPPER

		return ActionResultType.SUCCESS;
	}

	/* Gives a value when placed. */
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getWorld();
		BlockPos pos = context.getPos();
		IFluidState fluid = worldIn.getFluidState(pos);

		/** pos.up() = Replaceable block. **/
		if (pos.getY() < 255 && worldIn.getBlockState(pos.up()).isReplaceable(context)) {
			return this.getDefaultState().with(H_FACING, context.getPlacementHorizontalFacing().getOpposite())
					.with(WATERLOGGED, fluid.getFluid() == Fluids.WATER)
					.with(HALF, DoubleBlockHalf.LOWER)
					.with(STAGE_1_3, Integer.valueOf(1)); }

		else { return null; }
	}

	/* Add DoubleBlockHalf.UPPER on the Block. */
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		IFluidState fluidUp = worldIn.getFluidState(pos.up());

		worldIn.setBlockState(pos.up(), this.getDefaultState().with(HALF, DoubleBlockHalf.UPPER)
				.with(H_FACING, state.get(H_FACING)).with(STAGE_1_3, Integer.valueOf(1))
				.with(WATERLOGGED, Boolean.valueOf(fluidUp.isTagged(FluidTags.WATER))), 3);
	}

	/* Limit the place. */
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockPos downPos = pos.down();
		BlockState downState = worldIn.getBlockState(downPos);

		if (state.get(HALF) == DoubleBlockHalf.LOWER) { return true; }
		
		else { return downState.getBlock() == this; }
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(H_FACING);
		DoubleBlockHalf half = state.get(HALF);
		int i = state.get(STAGE_1_3);

		switch(direction) {
		case NORTH:
		default:
			return (i == 1 && half == DoubleBlockHalf.LOWER)? BOT1_NORTH :
						((i == 1 && half != DoubleBlockHalf.LOWER)? TOP1_NORTH :
						((i == 2 && half == DoubleBlockHalf.LOWER)? BOT2_NORTH :
						((i == 2 && half != DoubleBlockHalf.LOWER)? TOP2_NORTH :
						((i == 3 && half == DoubleBlockHalf.LOWER)? BOT3_BOX : VoxelShapes.empty() ))));
			
		case SOUTH:
			return (i == 1 && half == DoubleBlockHalf.LOWER)? BOT1_SOUTH :
						((i == 1 && half != DoubleBlockHalf.LOWER)? TOP1_SOUTH :
						((i == 2 && half == DoubleBlockHalf.LOWER)? BOT2_SOUTH :
						((i == 2 && half != DoubleBlockHalf.LOWER)? TOP2_SOUTH :
						((i == 3 && half == DoubleBlockHalf.LOWER)? BOT3_BOX : VoxelShapes.empty() ))));

		case WEST:
			return (i == 1 && half == DoubleBlockHalf.LOWER)? BOT1_WEST :
						((i == 1 && half != DoubleBlockHalf.LOWER)? TOP1_WEST :
						((i == 2 && half == DoubleBlockHalf.LOWER)? BOT2_WEST :
						((i == 2 && half != DoubleBlockHalf.LOWER)? TOP2_WEST :
						((i == 3 && half == DoubleBlockHalf.LOWER)? BOT3_BOX : VoxelShapes.empty() ))));

		case EAST:
			return (i == 1 && half == DoubleBlockHalf.LOWER)? BOT1_EAST :
						((i == 1 && half != DoubleBlockHalf.LOWER)? TOP1_EAST :
						((i == 2 && half == DoubleBlockHalf.LOWER)? BOT2_EAST :
						((i == 2 && half != DoubleBlockHalf.LOWER)? TOP2_EAST :
						((i == 3 && half == DoubleBlockHalf.LOWER)? BOT3_BOX : VoxelShapes.empty() ))));
		}
	}

	@Override
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.MODEL;
	}
}
