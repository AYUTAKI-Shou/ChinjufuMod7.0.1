package com.ayutaki.chinjufumod.blocks.gakki;

import com.ayutaki.chinjufumod.handler.CMEvents;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class Wadaiko_Large extends Wadaiko_Base {

	/* Collision */
	protected static final VoxelShape BOT1_SOUTH = Block.box(2.5D, 0.0D, 3.5D, 13.5D, 15.25D, 12.5D);
	protected static final VoxelShape BOT1_WEST = Block.box(3.5D, 0.0D, 2.5D, 12.5D, 15.25D, 13.5D);
	protected static final VoxelShape BOT1_NORTH = Block.box(2.5D, 0.0D, 3.5D, 13.5D, 15.25D, 12.5D);
	protected static final VoxelShape BOT1_EAST = Block.box(3.5D, 0.0D, 2.5D, 12.5D, 15.25D, 13.5D);

	protected static final VoxelShape TOP1_SOUTH = Block.box(3.25D, 0.0D, 1.0D, 12.75D, 9.5D, 15.0D);
	protected static final VoxelShape TOP1_WEST = Block.box(1.0D, 0.0D, 3.25D, 15.0D, 9.5D, 12.75D);
	protected static final VoxelShape TOP1_NORTH = Block.box(3.25D, 0.0D, 1.0D, 12.75D, 9.5D, 15.0D);
	protected static final VoxelShape TOP1_EAST = Block.box(1.0D, 0.0D, 3.25D, 15.0D, 9.5D, 12.75D);

	protected static final VoxelShape BOT2_SOUTH = Block.box(3.25D, 0.0D, 0.5D, 12.75D, 16.0D, 15.5D);
	protected static final VoxelShape BOT2_WEST = Block.box(0.5D, 0.0D, 3.25D, 15.0D, 15.5D, 12.75D);
	protected static final VoxelShape BOT2_NORTH = Block.box(3.25D, 0.0D, 0.5D, 12.75D, 16.0D, 15.5D);
	protected static final VoxelShape BOT2_EAST = Block.box(0.5D, 0.0D, 3.25D, 15.0D, 15.5D, 12.75D);

	protected static final VoxelShape TOP2_SOUTH = VoxelShapes.or(Block.box(3.75D, 0.0D, 0.5D, 12.25D, 3.0D, 8.0D),
																										Block.box(3.75D, 0.0D, 8.0D, 12.25D, 7.0D, 15.5D));
	protected static final VoxelShape TOP2_WEST = VoxelShapes.or(Block.box(0.5D, 0.0D, 3.75D, 8.0D, 7.0D, 12.25D),
																									Block.box(8.0D, 0.0D, 3.75D, 15.5D, 3.0D, 12.25D));
	protected static final VoxelShape TOP2_NORTH = VoxelShapes.or(Block.box(3.75D, 0.0D, 0.5D, 12.25D, 7.0D, 8.0D),
																										Block.box(3.75D, 0.0D, 8.0D, 12.25D, 3.0D, 15.5D));
	protected static final VoxelShape TOP2_EAST = VoxelShapes.or(Block.box(0.5D, 0.0D, 3.75D, 8.0D, 3.0D, 12.25D),
																									Block.box(8.0D, 0.0D, 3.75D, 15.5D, 7.0D, 12.25D));

	protected static final VoxelShape BOT3_BOX = Block.box(3.25D, 0.0D, 3.25D, 12.75D, 14.0D, 12.75D);


	public Wadaiko_Large(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		int i = state.getValue(STAGE_1_3);
		Direction direction = state.getValue(H_FACING);
		DoubleBlockHalf half = state.getValue(HALF);
		
		switch (half) {
		case LOWER:
		default:
			
			switch (i) {
			case 1:
			default:
				if (playerIn.isCrouching()) {
					if (stack.isEmpty()) {
						CMEvents.soundWoodPlace(worldIn, pos);
						
						worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(2)), 3);
						worldIn.setBlock(pos.above(), this.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
						.setValue(HALF, DoubleBlockHalf.UPPER).setValue(STAGE_1_3, Integer.valueOf(2)), 3); }
					
					if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); } }
				break;

			case 2:
				if (playerIn.isCrouching()) {
					if (stack.isEmpty()) {
						CMEvents.soundWoodPlace(worldIn, pos);
						
						worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(3)), 3);
						worldIn.setBlock(pos.above(), this.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
						.setValue(HALF, DoubleBlockHalf.UPPER).setValue(STAGE_1_3, Integer.valueOf(3)), 3); }
					
					if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); } }
				break;

			case 3:
				if (playerIn.isCrouching()) {
					if (stack.isEmpty()) {
						CMEvents.soundWoodPlace(worldIn, pos);
						
						worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(1)), 3);
						worldIn.setBlock(pos.above(), this.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
								.setValue(HALF, DoubleBlockHalf.UPPER).setValue(STAGE_1_3, Integer.valueOf(1)), 3); }
					
					if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); } }
				
				if (!playerIn.isCrouching()) {
					if (hit.getDirection() == Direction.UP) {
						if (item == Items.STICK) { CMEvents.wadaikoTop(worldIn, pos, 1.25F, 1.0F); }
						else { CMEvents.wadaikoTop(worldIn, pos, 0.2F, 1.0F); } }

					if (hit.getDirection() != Direction.UP) {
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
					if (hit.getDirection() == Direction.NORTH || hit.getDirection() == Direction.SOUTH) {
						if (item == Items.STICK) { CMEvents.wadaikoTop(worldIn, pos, 1.25F, 1.0F); }
						else { CMEvents.wadaikoTop(worldIn, pos, 0.2F, 1.0F); } }

					if (hit.getDirection() != Direction.NORTH && hit.getDirection() != Direction.SOUTH) {
						if (item == Items.STICK) { CMEvents.wadaikoSide(worldIn, pos, 1.25F, 1.0F); }
						else { CMEvents.wadaikoSide(worldIn, pos, 0.2F, 1.0F); } }
					break;

				case SOUTH:
					if (hit.getDirection() == Direction.NORTH || hit.getDirection() == Direction.SOUTH) {
						if (item == Items.STICK) { CMEvents.wadaikoTop(worldIn, pos, 1.25F, 1.0F); }
						else { CMEvents.wadaikoTop(worldIn, pos, 0.2F, 1.0F); } }

					if (hit.getDirection() != Direction.NORTH && hit.getDirection() != Direction.SOUTH) {
						if (item == Items.STICK) { CMEvents.wadaikoSide(worldIn, pos, 1.25F, 1.0F); }
						else { CMEvents.wadaikoSide(worldIn, pos, 0.2F, 1.0F); } }
					break;

				case EAST:
					if (hit.getDirection() == Direction.EAST || hit.getDirection() == Direction.WEST) {
						if (item == Items.STICK) { CMEvents.wadaikoTop(worldIn, pos, 1.25F, 1.0F); }
						else { CMEvents.wadaikoTop(worldIn, pos, 0.2F, 1.0F); } }

					if (hit.getDirection() != Direction.EAST && hit.getDirection() != Direction.WEST) {
						if (item == Items.STICK) { CMEvents.wadaikoSide(worldIn, pos, 1.25F, 1.0F); }
						else { CMEvents.wadaikoSide(worldIn, pos, 0.2F, 1.0F); } }
					break;
					
				case WEST:
					if (hit.getDirection() == Direction.EAST || hit.getDirection() == Direction.WEST) {
						if (item == Items.STICK) { CMEvents.wadaikoTop(worldIn, pos, 1.25F, 1.0F); }
						else { CMEvents.wadaikoTop(worldIn, pos, 0.2F, 1.0F); } }

					if (hit.getDirection() != Direction.EAST && hit.getDirection() != Direction.WEST) {
						if (item == Items.STICK) { CMEvents.wadaikoSide(worldIn, pos, 1.25F, 1.0F); }
						else { CMEvents.wadaikoSide(worldIn, pos, 0.2F, 1.0F); } }
					break;
				} // direction
				break;

			case 2:
				
				switch (direction) {
				case NORTH:
				default:
					if (hit.getDirection() == Direction.NORTH) {
						if (item == Items.STICK) { CMEvents.wadaikoTop(worldIn, pos, 1.25F, 1.0F); }
						else { CMEvents.wadaikoTop(worldIn, pos, 0.2F, 1.0F); } }

					if (hit.getDirection() != Direction.NORTH) {
						if (item == Items.STICK) { CMEvents.wadaikoSide(worldIn, pos, 1.25F, 1.0F); }
						else { CMEvents.wadaikoSide(worldIn, pos, 0.2F, 1.0F); } }
					break;

				case SOUTH:
					if (hit.getDirection() == Direction.SOUTH) {
						if (item == Items.STICK) { CMEvents.wadaikoTop(worldIn, pos, 1.25F, 1.0F); }
						else { CMEvents.wadaikoTop(worldIn, pos, 0.2F, 1.0F); } }

					if (hit.getDirection() != Direction.SOUTH) {
						if (item == Items.STICK) { CMEvents.wadaikoSide(worldIn, pos, 1.25F, 1.0F); }
						else { CMEvents.wadaikoSide(worldIn, pos, 0.2F, 1.0F); } }
					break;

				case EAST:
					if (hit.getDirection() == Direction.EAST) {
						if (item == Items.STICK) { CMEvents.wadaikoTop(worldIn, pos, 1.25F, 1.0F); }
						else { CMEvents.wadaikoTop(worldIn, pos, 0.2F, 1.0F); } }

					if (hit.getDirection() != Direction.EAST) {
						if (item == Items.STICK) { CMEvents.wadaikoSide(worldIn, pos, 1.25F, 1.0F); }
						else { CMEvents.wadaikoSide(worldIn, pos, 0.2F, 1.0F); } }
					break;
					
				case WEST:
					if (hit.getDirection() == Direction.WEST) {
						if (item == Items.STICK) { CMEvents.wadaikoTop(worldIn, pos, 1.25F, 1.0F); }
						else { CMEvents.wadaikoTop(worldIn, pos, 0.2F, 1.0F); } }

					if (hit.getDirection() != Direction.WEST) {
						if (item == Items.STICK) { CMEvents.wadaikoSide(worldIn, pos, 1.25F, 1.0F); }
						else { CMEvents.wadaikoSide(worldIn, pos, 0.2F, 1.0F); } }
					break;
				} // switch
				
				break;

			case 3:
				break;
			} // STAGE_1_3
			
			break;
		} // HALF

		return ActionResultType.SUCCESS;
	}

	/* Gives a value when placed. */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);

		/** pos.up() = Replaceable block. **/
		if (pos.getY() < 255 && worldIn.getBlockState(pos.above()).canBeReplaced(context)) {
			return this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection().getOpposite())
					.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER))
					.setValue(HALF, DoubleBlockHalf.LOWER)
					.setValue(STAGE_1_3, Integer.valueOf(1)); }

		else { return null; }
	}

	/* Add DoubleBlockHalf.UPPER on the Block. */
	public void setPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		FluidState fluidUp = worldIn.getFluidState(pos.above());

		worldIn.setBlock(pos.above(), this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER)
				.setValue(H_FACING, state.getValue(H_FACING)).setValue(STAGE_1_3, Integer.valueOf(1))
				.setValue(WATERLOGGED, Boolean.valueOf(fluidUp.getType() == Fluids.WATER)), 3);
	}

	/* Limit the place. */
	public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockPos downPos = pos.below();
		BlockState downState = worldIn.getBlockState(downPos);

		/** Lower part is true. **/
		if (state.getValue(HALF) == DoubleBlockHalf.LOWER) { return true; }

		/** Upper part is this block. **/
		else { return downState.getBlock() == this; }
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.getValue(H_FACING);
		DoubleBlockHalf half = state.getValue(HALF);
		int i = state.getValue(STAGE_1_3);

		switch (direction) {
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
	public BlockRenderType getRenderShape(BlockState state) {
		return BlockRenderType.MODEL;
	}

}
