package com.ayutaki.chinjufumod.blocks.window;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.handler.CMEvents;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CurtainLarge extends CM_WaterLogged {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final BooleanProperty OPEN = BooleanProperty.create("open");
	public static final EnumProperty<DoorHingeSide> HINGE = EnumProperty.create("hinge", DoorHingeSide.class);
	public static final EnumProperty<DoubleBlockHalf> HALF = EnumProperty.create("half", DoubleBlockHalf.class);
	public static final IntegerProperty STAGE_1_2 = IntegerProperty.create("stage", 1, 2);
	
	/* Collision */
	protected static final VoxelShape CLOSE_NORTH = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D);
	protected static final VoxelShape CLOSE_EAST = Block.box(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape CLOSE_SOUTH = Block.box(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape CLOSE_WEST = Block.box(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D);

	protected static final VoxelShape RAIL_NORTH = Block.box(0.0D, 15.25D, 0.0D, 16.0D, 16.0D, 0.75D);
	protected static final VoxelShape RAIL_EAST = Block.box(15.25D, 15.25D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape RAIL_SOUTH = Block.box(0.0D, 15.25D, 15.25D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape RAIL_WEST = Block.box(0.0D, 15.25D, 0.0D, 0.75D, 16.0D, 16.0D);
	
	protected static final VoxelShape OPENR_NORTH = Block.box(13.5D, 0.0D, 0.0D, 16.0D, 16.0D, 2.6D);
	protected static final VoxelShape OPENR_EAST = Block.box(13.4D, 0.0D, 13.5D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape OPENR_SOUTH = Block.box(0.0D, 0.0D, 13.4D, 2.5D, 16.0D, 16.0D);
	protected static final VoxelShape OPENR_WEST = Block.box(0.0D, 0.0D, 0.0D, 2.6D, 16.0D, 2.5D);

	protected static final VoxelShape OPENL_NORTH = Block.box(0.0D, 0.0D, 0.0D, 2.5D, 16.0D, 2.6D);
	protected static final VoxelShape OPENL_EAST = Block.box(13.4D, 0.0D, 0.0D, 16.0D, 16.0D, 2.5D);
	protected static final VoxelShape OPENL_SOUTH = Block.box(13.5D, 0.0D, 13.4D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape OPENL_WEST = Block.box(0.0D, 0.0D, 13.5D, 2.6D, 16.0D, 16.0D);
	
	public CurtainLarge(BlockBehaviour.Properties properties) {
		super(properties);
		
		/** Default state **/
		registerDefaultState(this.stateDefinition.any().setValue(H_FACING, Direction.NORTH)
				.setValue(STAGE_1_2, Integer.valueOf(1))
				.setValue(OPEN, Boolean.valueOf(false))
				.setValue(HINGE, DoorHingeSide.LEFT)
				.setValue(HALF, DoubleBlockHalf.UPPER)
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		// if (item instanceof Base_ItemHake) { return InteractionResult.PASS; } Too Complex.

		int i = state.getValue(STAGE_1_2);
		Direction direction = state.getValue(H_FACING);
		DoubleBlockHalf half = state.getValue(HALF);
		DoorHingeSide hinge = state.getValue(HINGE);

		int x = (int) pos.getX();
		int y = (int) pos.getY();
		int z = (int) pos.getZ();
		
		CMEvents.soundCurtain(worldIn, pos, 0.8F, 0.8F);
		
		boolean flag = state.getValue(OPEN)? false : true;

		BlockState directFlag = this.defaultBlockState().setValue(H_FACING, direction).setValue(OPEN, Boolean.valueOf(flag));
		
		BlockState Up_LEFT1 = directFlag.setValue(STAGE_1_2, Integer.valueOf(1)).setValue(HALF, DoubleBlockHalf.UPPER).setValue(HINGE, DoorHingeSide.LEFT);
		BlockState Low_LEFT1 = directFlag.setValue(STAGE_1_2, Integer.valueOf(1)).setValue(HALF, DoubleBlockHalf.LOWER).setValue(HINGE, DoorHingeSide.LEFT);
		BlockState Up_LEFT2 = directFlag.setValue(STAGE_1_2, Integer.valueOf(2)).setValue(HALF, DoubleBlockHalf.UPPER).setValue(HINGE, DoorHingeSide.LEFT);
		BlockState Low_LEFT2 = directFlag.setValue(STAGE_1_2, Integer.valueOf(2)).setValue(HALF, DoubleBlockHalf.LOWER).setValue(HINGE, DoorHingeSide.LEFT);
		
		BlockState Up_RIGHT1 = directFlag.setValue(STAGE_1_2, Integer.valueOf(1)).setValue(HALF, DoubleBlockHalf.UPPER).setValue(HINGE, DoorHingeSide.RIGHT);
		BlockState Low_RIGHT1 = directFlag.setValue(STAGE_1_2, Integer.valueOf(1)).setValue(HALF, DoubleBlockHalf.LOWER).setValue(HINGE, DoorHingeSide.RIGHT);
		BlockState Up_RIGHT2 = directFlag.setValue(STAGE_1_2, Integer.valueOf(2)).setValue(HALF, DoubleBlockHalf.UPPER).setValue(HINGE, DoorHingeSide.RIGHT);
		BlockState Low_RIGHT2 = directFlag.setValue(STAGE_1_2, Integer.valueOf(2)).setValue(HALF, DoubleBlockHalf.LOWER).setValue(HINGE, DoorHingeSide.RIGHT);

		
		///// STAGE_1 ////////////////////
		switch (i) {
		case 1 :
		default :
			switch (half) {
			case LOWER :
			default :
				switch (hinge) {
				case LEFT :
				default :
					worldIn.setBlock(pos.above(), Up_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.above()).getType() == Fluids.WATER)), 3);
					worldIn.setBlock(pos, Low_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos).getType() == Fluids.WATER)), 3);
					
					switch (direction) {
					case NORTH :
					default :
						worldIn.setBlock(new BlockPos(x - 1, y + 1, z), Up_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y + 1, z)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x - 1, y, z), Low_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y, z)).getType() == Fluids.WATER)), 3);
						break;

					case SOUTH :
						worldIn.setBlock(new BlockPos(x + 1, y + 1, z), Up_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y + 1, z)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x + 1, y, z), Low_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y, z)).getType() == Fluids.WATER)), 3);
						break;

					case EAST :
						worldIn.setBlock(new BlockPos(x, y + 1, z - 1), Up_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z - 1)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x, y, z - 1), Low_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z - 1)).getType() == Fluids.WATER)), 3);
						break;
						
					case WEST :
						worldIn.setBlock(new BlockPos(x, y + 1, z + 1), Up_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z + 1)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x, y, z + 1), Low_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z + 1)).getType() == Fluids.WATER)), 3);
						break;
					} // direction
					break;

				case RIGHT :
					worldIn.setBlock(pos.above(), Up_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.above()).getType() == Fluids.WATER)), 3);
					worldIn.setBlock(pos, Low_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos).getType() == Fluids.WATER)), 3);

					switch (direction) {
					case NORTH :
					default :
						worldIn.setBlock(new BlockPos(x + 1, y + 1, z), Up_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y + 1, z)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x + 1, y, z), Low_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y, z)).getType() == Fluids.WATER)), 3);
						break;

					case SOUTH :
						worldIn.setBlock(new BlockPos(x - 1, y + 1, z), Up_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y + 1, z)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x - 1, y, z), Low_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y, z)).getType() == Fluids.WATER)), 3);
						break;

					case EAST :
						worldIn.setBlock(new BlockPos(x, y + 1, z + 1), Up_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z + 1)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x, y, z + 1), Low_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z + 1)).getType() == Fluids.WATER)), 3);
						break;
						
					case WEST :
						worldIn.setBlock(new BlockPos(x, y + 1, z - 1), Up_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z - 1)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x, y, z - 1), Low_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z - 1)).getType() == Fluids.WATER)), 3);
						break;
					} // direction
					break;
				} // LEFT-RIGHT
				break;


			case UPPER :
				switch (hinge) {
				case LEFT :
				default :
					worldIn.setBlock(pos, Up_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos).getType() == Fluids.WATER)), 3);
					worldIn.setBlock(pos.below(), Low_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.below()).getType() == Fluids.WATER)), 3);

					switch (direction) {
					case NORTH :
					default :
						worldIn.setBlock(new BlockPos(x - 1, y, z), Up_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y, z)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x - 1, y - 1, z), Low_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y - 1, z)).getType() == Fluids.WATER)), 3);
						break;

					case SOUTH :
						worldIn.setBlock(new BlockPos(x + 1, y, z), Up_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y, z)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x + 1, y - 1, z), Low_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y - 1, z)).getType() == Fluids.WATER)), 3);
						break;

					case EAST :
						worldIn.setBlock(new BlockPos(x, y, z - 1), Up_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z - 1)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x, y - 1, z - 1), Low_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y - 1, z - 1)).getType() == Fluids.WATER)), 3);
						break;
						
					case WEST :
						worldIn.setBlock(new BlockPos(x, y, z + 1), Up_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z + 1)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x, y - 1, z + 1), Low_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y - 1, z + 1)).getType() == Fluids.WATER)), 3);
						break;
					} // direction
					break;

				case RIGHT :
					worldIn.setBlock(pos, Up_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos).getType() == Fluids.WATER)), 3);
					worldIn.setBlock(pos.below(), Low_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.below()).getType() == Fluids.WATER)), 3);

					switch (direction) {
					case NORTH :
					default :
						worldIn.setBlock(new BlockPos(x + 1, y, z), Up_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y, z)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x + 1, y - 1, z), Low_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y - 1, z)).getType() == Fluids.WATER)), 3);
						break;

					case SOUTH :
						worldIn.setBlock(new BlockPos(x - 1, y, z), Up_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y, z)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x - 1, y - 1, z), Low_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y - 1, z)).getType() == Fluids.WATER)), 3);
						break;

					case EAST :
						worldIn.setBlock(new BlockPos(x, y, z + 1), Up_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z + 1)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x, y - 1, z + 1), Low_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y - 1, z + 1)).getType() == Fluids.WATER)), 3);
						break;
						
					case WEST :
						worldIn.setBlock(new BlockPos(x, y, z - 1), Up_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z - 1)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x, y - 1, z - 1), Low_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y - 1, z - 1)).getType() == Fluids.WATER)), 3);
						break;
					} // direction
					break;
				} // LEFT-RIGHT
				break;
			} // LOWER-UPPER
			break;


		///// STAGE_2 ////////////////////
		case 2 :
			switch (half) {
			case LOWER :
			default :
				switch (hinge) {
				case LEFT :
				default :
					worldIn.setBlock(pos.above(), Up_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.above()).getType() == Fluids.WATER)), 3);
					worldIn.setBlock(pos, Low_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos).getType() == Fluids.WATER)), 3);

					switch (direction) {
					case NORTH :
					default :
						worldIn.setBlock(new BlockPos(x + 1, y + 1, z), Up_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y + 1, z)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x + 1, y, z), Low_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y, z)).getType() == Fluids.WATER)), 3);
						break;

					case SOUTH :
						worldIn.setBlock(new BlockPos(x - 1, y + 1, z), Up_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y + 1, z)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x - 1, y, z), Low_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y, z)).getType() == Fluids.WATER)), 3);
						break;

					case EAST :
						worldIn.setBlock(new BlockPos(x, y + 1, z + 1), Up_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z + 1)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x, y, z + 1), Low_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z + 1)).getType() == Fluids.WATER)), 3);
						break;
						
					case WEST :
						worldIn.setBlock(new BlockPos(x, y + 1, z - 1), Up_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z - 1)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x, y, z - 1), Low_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z - 1)).getType() == Fluids.WATER)), 3);
						break;
					} // direction
					break;

				case RIGHT :
					worldIn.setBlock(pos.above(), Up_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.above()).getType() == Fluids.WATER)), 3);
					worldIn.setBlock(pos, Low_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos).getType() == Fluids.WATER)), 3);

					switch (direction) {
					case NORTH :
					default :
						worldIn.setBlock(new BlockPos(x - 1, y + 1, z), Up_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y + 1, z)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x - 1, y, z), Low_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y, z)).getType() == Fluids.WATER)), 3);
						break;

					case SOUTH :
						worldIn.setBlock(new BlockPos(x + 1, y + 1, z), Up_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y + 1, z)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x + 1, y, z), Low_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y, z)).getType() == Fluids.WATER)), 3);
						break;

					case EAST :
						worldIn.setBlock(new BlockPos(x, y + 1, z - 1), Up_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z - 1)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x, y, z - 1), Low_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z - 1)).getType() == Fluids.WATER)), 3);
						break;
						
					case WEST :
						worldIn.setBlock(new BlockPos(x, y + 1, z + 1), Up_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z + 1)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x, y, z + 1), Low_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z + 1)).getType() == Fluids.WATER)), 3);
						break;
					} // direction
					break;
				} // LEFT-RIGHT
				break;

			case UPPER :
				switch (hinge) {
				case LEFT :
				default :
					worldIn.setBlock(pos, Up_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos).getType() == Fluids.WATER)), 3);
					worldIn.setBlock(pos.below(), Low_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.below()).getType() == Fluids.WATER)), 3);

					switch (direction) {
					case NORTH :
					default :
						worldIn.setBlock(new BlockPos(x + 1, y, z), Up_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y, z)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x + 1, y - 1, z), Low_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y - 1, z)).getType() == Fluids.WATER)), 3);
						break;

					case SOUTH :
						worldIn.setBlock(new BlockPos(x - 1, y, z), Up_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y, z)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x - 1, y - 1, z), Low_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y - 1, z)).getType() == Fluids.WATER)), 3);
						break;

					case EAST :
						worldIn.setBlock(new BlockPos(x, y, z + 1), Up_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z + 1)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x, y - 1, z + 1), Low_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y - 1, z + 1)).getType() == Fluids.WATER)), 3);
						break;
						
					case WEST :
						worldIn.setBlock(new BlockPos(x, y, z - 1), Up_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z - 1)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x, y - 1, z - 1), Low_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y - 1, z - 1)).getType() == Fluids.WATER)), 3);
						break;
					} // direction
					break;

				case RIGHT :
					worldIn.setBlock(pos, Up_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos).getType() == Fluids.WATER)), 3);
					worldIn.setBlock(pos.below(), Low_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.below()).getType() == Fluids.WATER)), 3);

					switch (direction) {
					case NORTH :
					default :
						worldIn.setBlock(new BlockPos(x - 1, y, z), Up_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y, z)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x - 1, y - 1, z), Low_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y - 1, z)).getType() == Fluids.WATER)), 3);
						break;

					case SOUTH :
						worldIn.setBlock(new BlockPos(x + 1, y, z), Up_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y, z)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x + 1, y - 1, z), Low_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y - 1, z)).getType() == Fluids.WATER)), 3);
						break;

					case EAST :
						worldIn.setBlock(new BlockPos(x, y, z - 1), Up_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z - 1)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x, y - 1, z - 1), Low_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y - 1, z - 1)).getType() == Fluids.WATER)), 3);
						break;
						
					case WEST :
						worldIn.setBlock(new BlockPos(x, y, z + 1), Up_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z + 1)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x, y - 1, z + 1), Low_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y - 1, z + 1)).getType() == Fluids.WATER)), 3);
						break;
					} // direction
					break;
				} // LEFT-RIGHT
				break;
			} // LOWER-UPPER
			break;
		} // STAGE_1_2

		return InteractionResult.SUCCESS;
	}
	
	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		Level worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);
		Player playerIn = context.getPlayer();

		/** pos.up() = Replaceable block. **/
		if (worldIn.getBlockState(pos.below()).canBeReplaced(context)) {
			
			Direction facing = playerIn.getDirection();
			int x = (int) pos.getX();
			int y = (int) pos.getY();
			int z = (int) pos.getZ();
			
			BlockState directFlag = this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection())
					.setValue(STAGE_1_2, Integer.valueOf(1)).setValue(OPEN, Boolean.valueOf(false))
					.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER));
			
			BlockState Right = directFlag.setValue(HINGE, DoorHingeSide.RIGHT).setValue(HALF, DoubleBlockHalf.UPPER);
			BlockState Left = directFlag.setValue(HINGE, DoorHingeSide.LEFT).setValue(HALF, DoubleBlockHalf.UPPER);
			
			if (playerIn.isCrouching()) {
				if (facing == Direction.NORTH && worldIn.getBlockState(new BlockPos(x + 1, y, z)).canBeReplaced(context)) { return Right; }
				if (facing == Direction.SOUTH && worldIn.getBlockState(new BlockPos(x - 1, y, z)).canBeReplaced(context)) { return Right; }
				if (facing == Direction.EAST && worldIn.getBlockState(new BlockPos(x, y, z + 1)).canBeReplaced(context)) { return Right; }
				if (facing == Direction.WEST && worldIn.getBlockState(new BlockPos(x, y, z - 1)).canBeReplaced(context)) { return Right; }
				else { 
					CMEvents.textNoPlace(context.getLevel(), context.getClickedPos(), context.getPlayer());
					return null; } } //isCrouching()
			
			if (facing == Direction.NORTH && worldIn.getBlockState(new BlockPos(x - 1, y, z)).canBeReplaced(context)) { return Left; }
			if (facing == Direction.SOUTH && worldIn.getBlockState(new BlockPos(x + 1, y, z)).canBeReplaced(context)) { return Left; }
			if (facing == Direction.EAST && worldIn.getBlockState(new BlockPos(x, y, z - 1)).canBeReplaced(context)) { return Left; }
			if (facing == Direction.WEST && worldIn.getBlockState(new BlockPos(x, y, z + 1)).canBeReplaced(context)) { return Left; }
			else { 
				CMEvents.textNoPlace(context.getLevel(), context.getClickedPos(), context.getPlayer());
				return null; }
			
		} //pos.below()).canBeReplaced(context)

		else { 
			CMEvents.textNoPlace(context.getLevel(), context.getClickedPos(), context.getPlayer());
			return null; }
	}
	
	/* Add DoubleBlockHalf.UPPER on the Block. */
	public void setPlacedBy(Level worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {

		Direction facing = placer.getDirection();
		int x = (int) pos.getX();
		int y = (int) pos.getY();
		int z = (int) pos.getZ();
		
		BlockState directFlag = this.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING)).setValue(OPEN, Boolean.valueOf(false));
		
		if (placer.isCrouching()) {
			BlockState Low_RIGHT1 = directFlag.setValue(STAGE_1_2, Integer.valueOf(1)).setValue(HALF, DoubleBlockHalf.LOWER).setValue(HINGE, DoorHingeSide.RIGHT);
			BlockState Up_RIGHT2 = directFlag.setValue(STAGE_1_2, Integer.valueOf(2)).setValue(HALF, DoubleBlockHalf.UPPER).setValue(HINGE, DoorHingeSide.RIGHT);
			BlockState Low_RIGHT2 = directFlag.setValue(STAGE_1_2, Integer.valueOf(2)).setValue(HALF, DoubleBlockHalf.LOWER).setValue(HINGE, DoorHingeSide.RIGHT);
			
			worldIn.setBlock(pos.below(), Low_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.below()).getType() == Fluids.WATER)), 3);
			
			switch (facing) {
			case NORTH :
			default :
				worldIn.setBlock(new BlockPos(x + 1, y, z), Up_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y, z)).getType() == Fluids.WATER)), 3);
				worldIn.setBlock(new BlockPos(x + 1, y - 1, z), Low_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y - 1, z)).getType() == Fluids.WATER)), 3);
				break;

			case SOUTH :
				worldIn.setBlock(new BlockPos(x - 1, y, z), Up_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y, z)).getType() == Fluids.WATER)), 3);
				worldIn.setBlock(new BlockPos(x - 1, y - 1, z), Low_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y - 1, z)).getType() == Fluids.WATER)), 3);
				break;

			case EAST :
				worldIn.setBlock(new BlockPos(x, y, z + 1), Up_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z + 1)).getType() == Fluids.WATER)), 3);
				worldIn.setBlock(new BlockPos(x, y - 1, z + 1), Low_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y - 1, z + 1)).getType() == Fluids.WATER)), 3);
				break;
				
			case WEST :
				worldIn.setBlock(new BlockPos(x, y, z - 1), Up_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z - 1)).getType() == Fluids.WATER)), 3);
				worldIn.setBlock(new BlockPos(x, y - 1, z - 1), Low_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y - 1, z - 1)).getType() == Fluids.WATER)), 3);
				break;
			} // direction
		} //placer.isCrouching()


		if (!placer.isCrouching()) {
			BlockState Low_LEFT1 = directFlag.setValue(STAGE_1_2, Integer.valueOf(1)).setValue(HALF, DoubleBlockHalf.LOWER).setValue(HINGE, DoorHingeSide.LEFT);
			BlockState Up_LEFT2 = directFlag.setValue(STAGE_1_2, Integer.valueOf(2)).setValue(HALF, DoubleBlockHalf.UPPER).setValue(HINGE, DoorHingeSide.LEFT);
			BlockState Low_LEFT2 = directFlag.setValue(STAGE_1_2, Integer.valueOf(2)).setValue(HALF, DoubleBlockHalf.LOWER).setValue(HINGE, DoorHingeSide.LEFT);
			
			worldIn.setBlock(pos.below(), Low_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.below()).getType() == Fluids.WATER)), 3);

			switch (facing) {
			case NORTH :
			default :
				worldIn.setBlock(new BlockPos(x - 1, y, z), Up_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y, z)).getType() == Fluids.WATER)), 3);
				worldIn.setBlock(new BlockPos(x - 1, y - 1, z), Low_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y - 1, z)).getType() == Fluids.WATER)), 3);
				break;

			case SOUTH :
				worldIn.setBlock(new BlockPos(x + 1, y, z), Up_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y, z)).getType() == Fluids.WATER)), 3);
				worldIn.setBlock(new BlockPos(x + 1, y - 1, z), Low_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y - 1, z)).getType() == Fluids.WATER)), 3);
				break;

			case EAST :
				worldIn.setBlock(new BlockPos(x, y, z - 1), Up_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z - 1)).getType() == Fluids.WATER)), 3);
				worldIn.setBlock(new BlockPos(x, y - 1, z - 1), Low_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y - 1, z - 1)).getType() == Fluids.WATER)), 3);
				break;
				
			case WEST :
				worldIn.setBlock(new BlockPos(x, y, z + 1), Up_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z + 1)).getType() == Fluids.WATER)), 3);
				worldIn.setBlock(new BlockPos(x, y - 1, z + 1), Low_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y - 1, z + 1)).getType() == Fluids.WATER)), 3);
				break;
			} // direction
		} //!placer.isCrouching()
	}
	
	/* HORIZONTAL Property */
	@Override
	public BlockState rotate(BlockState state, Rotation rotation) {
		return state.setValue(H_FACING, rotation.rotate(state.getValue(H_FACING)));
	}

	@SuppressWarnings("deprecation")
	public BlockState mirror(BlockState state, Mirror mirror) {
		return mirror == Mirror.NONE ? state : state.rotate(mirror.getRotation(state.getValue(H_FACING))).cycle(HINGE);
	}
	
	@SuppressWarnings("deprecation")
	public long getSeed(BlockState state, BlockPos pos) {
		return Mth.getSeed(pos.getX(), pos.below(state.getValue(HALF) == DoubleBlockHalf.LOWER ? 0 : 1).getY(), pos.getZ());
	}
	
	/* Update BlockState. is(this) */
	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos pos, BlockPos facingPos) {
		BlockState state1 = super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
		if (!state1.isAir()) {
			worldIn.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }

		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		int i = state.getValue(STAGE_1_2);
		Direction direction = state.getValue(H_FACING);
		DoubleBlockHalf half = state.getValue(HALF);
		boolean flagopen = !state.getValue(OPEN);
		boolean flagright = (state.getValue(HINGE) == DoorHingeSide.RIGHT);

		switch (half) {
		case LOWER:
		default:
			switch (direction) {
			case NORTH:
			default:
				return flagopen? CLOSE_NORTH : ((i == 1)? Shapes.empty() : (flagright? OPENR_NORTH : OPENL_NORTH));
			case SOUTH:
				return flagopen? CLOSE_SOUTH : ((i == 1)? Shapes.empty() : (flagright? OPENR_SOUTH : OPENL_SOUTH));
			case WEST:
				return flagopen? CLOSE_WEST : ((i == 1)? Shapes.empty() : (flagright? OPENR_WEST : OPENL_WEST));
			case EAST:
				return flagopen? CLOSE_EAST : ((i == 1)? Shapes.empty() : (flagright? OPENR_EAST : OPENL_EAST));
			}

		case UPPER:
			switch (direction) {
			case NORTH:
			default:
				return flagopen? CLOSE_NORTH : ((i == 1)? RAIL_NORTH : (flagright? OPENR_NORTH : OPENL_NORTH));
			case SOUTH:
				return flagopen? CLOSE_SOUTH : ((i == 1)? RAIL_SOUTH : (flagright? OPENR_SOUTH : OPENL_SOUTH));
			case WEST:
				return flagopen? CLOSE_WEST : ((i == 1)? RAIL_WEST : (flagright? OPENR_WEST : OPENL_WEST));
			case EAST:
				return flagopen? CLOSE_EAST : ((i == 1)? RAIL_EAST : (flagright? OPENR_EAST : OPENL_EAST));
			}
		} // switch LOWER-UPPER
	}
	
	@Override
	public RenderShape getRenderShape(BlockState state) {
		return RenderShape.MODEL;
	}
	
	/* Controls drops when broken. End the process with "break;".*/
	@Override
	public void playerWillDestroy(Level worldIn, BlockPos pos, BlockState state, Player playerIn) {
		int i = state.getValue(STAGE_1_2);
		Direction direction = state.getValue(H_FACING);
		DoubleBlockHalf half = state.getValue(HALF);

		int x = (int) pos.getX();
		int y = (int) pos.getY();
		int z = (int) pos.getZ();

		boolean mode = playerIn.getAbilities().instabuild;
		boolean left = (state.getValue(HINGE) == DoorHingeSide.LEFT);
		
		if (!worldIn.isClientSide) {
			switch (i) {
			case 1 :
			default :
				switch (half) {
				case LOWER :
				default :
					worldIn.destroyBlock(pos, mode? false : true);
					worldIn.destroyBlock(pos.above(), false);
					
					switch (direction) {
					case NORTH :
					default :
						worldIn.destroyBlock(left? new BlockPos(x - 1, y, z) : new BlockPos(x + 1, y, z), false);
						worldIn.destroyBlock(left? new BlockPos(x - 1, y + 1, z) : new BlockPos(x + 1, y + 1, z), false);
						break;

					case SOUTH :
						worldIn.destroyBlock(left? new BlockPos(x + 1, y, z) : new BlockPos(x - 1, y, z), false);
						worldIn.destroyBlock(left? new BlockPos(x + 1, y + 1, z) : new BlockPos(x - 1, y + 1, z), false);
						break;

					case EAST :
						worldIn.destroyBlock(left? new BlockPos(x, y, z - 1) : new BlockPos(x, y, z + 1), false);
						worldIn.destroyBlock(left? new BlockPos(x, y + 1, z - 1) : new BlockPos(x, y + 1, z + 1), false);
						break;
						
					case WEST :
						worldIn.destroyBlock(left? new BlockPos(x, y, z + 1) : new BlockPos(x, y, z - 1), false);
						worldIn.destroyBlock(left? new BlockPos(x, y + 1, z + 1) : new BlockPos(x, y + 1, z - 1), false);
						break;
					} // direction
					break; //case 1, LOWER


				case UPPER :
					worldIn.destroyBlock(pos, mode? false : true);
					worldIn.destroyBlock(pos.below(), false);
					
					switch (direction) {
					case NORTH :
					default :
						worldIn.destroyBlock(left? new BlockPos(x - 1, y, z) : new BlockPos(x + 1, y, z), false);
						worldIn.destroyBlock(left? new BlockPos(x - 1, y - 1, z) : new BlockPos(x + 1, y - 1, z), false);
						break;

					case SOUTH :
						worldIn.destroyBlock(left? new BlockPos(x + 1, y, z) : new BlockPos(x - 1, y, z), false);
						worldIn.destroyBlock(left? new BlockPos(x + 1, y - 1, z) : new BlockPos(x - 1, y - 1, z), false);
						break;

					case EAST :
						worldIn.destroyBlock(left? new BlockPos(x, y, z - 1) : new BlockPos(x, y, z + 1), false);
						worldIn.destroyBlock(left? new BlockPos(x, y - 1, z - 1) : new BlockPos(x, y - 1, z + 1), false);
						break;
						
					case WEST :
						worldIn.destroyBlock(left? new BlockPos(x, y, z + 1) : new BlockPos(x, y, z - 1), false);
						worldIn.destroyBlock(left? new BlockPos(x, y - 1, z + 1) : new BlockPos(x, y - 1, z - 1), false);
						break;
					} // direction
					break; //case 1, UPPER
				}
				break; //case 1


			case 2 :
				switch (half) {
				case LOWER :
				default :
					worldIn.destroyBlock(pos, mode? false : true);
					worldIn.destroyBlock(pos.above(), false);
					
					switch (direction) {
					case NORTH :
					default :
						worldIn.destroyBlock(left? new BlockPos(x + 1, y, z) : new BlockPos(x - 1, y, z), false);
						worldIn.destroyBlock(left? new BlockPos(x + 1, y + 1, z) : new BlockPos(x - 1, y + 1, z), false);
						break;

					case SOUTH :
						worldIn.destroyBlock(left? new BlockPos(x - 1, y, z) : new BlockPos(x + 1, y, z), false);
						worldIn.destroyBlock(left? new BlockPos(x - 1, y + 1, z) : new BlockPos(x + 1, y + 1, z), false);
						break;

					case EAST :
						worldIn.destroyBlock(left? new BlockPos(x, y, z + 1) : new BlockPos(x, y, z - 1), false);
						worldIn.destroyBlock(left? new BlockPos(x, y + 1, z + 1) : new BlockPos(x, y + 1, z - 1), false);
						break;
						
					case WEST :
						worldIn.destroyBlock(left? new BlockPos(x, y, z - 1) : new BlockPos(x, y, z + 1), false);
						worldIn.destroyBlock(left? new BlockPos(x, y + 1, z - 1) : new BlockPos(x, y + 1, z + 1), false);
						break;
					} // direction
					break; //case 2, LOWER


				case UPPER :
					worldIn.destroyBlock(pos, mode? false : true);
					worldIn.destroyBlock(pos.below(), false);
					
					switch (direction) {
					case NORTH :
					default :
						worldIn.destroyBlock(left? new BlockPos(x + 1, y, z) : new BlockPos(x - 1, y, z), false);
						worldIn.destroyBlock(left? new BlockPos(x + 1, y - 1, z) : new BlockPos(x - 1, y - 1, z), false);
						break;

					case SOUTH :
						worldIn.destroyBlock(left? new BlockPos(x - 1, y, z) : new BlockPos(x + 1, y, z), false);
						worldIn.destroyBlock(left? new BlockPos(x - 1, y - 1, z) : new BlockPos(x + 1, y - 1, z), false);
						break;

					case EAST :
						worldIn.destroyBlock(left? new BlockPos(x, y, z + 1) : new BlockPos(x, y, z - 1), false);
						worldIn.destroyBlock(left? new BlockPos(x, y - 1, z + 1) : new BlockPos(x, y - 1, z - 1), false);
						break;
						
					case WEST :
						worldIn.destroyBlock(left? new BlockPos(x, y, z - 1) : new BlockPos(x, y, z + 1), false);
						worldIn.destroyBlock(left? new BlockPos(x, y - 1, z - 1) : new BlockPos(x, y - 1, z + 1), false);
						break;
					} // direction
					break; //case 2, UPPER
				}
				break; //case 2
			}
		}
	}
	
	@Override
	public PushReaction getPistonPushReaction(BlockState state) {
		return PushReaction.DESTROY;
	}
	
	@Override
	public boolean isPathfindable(BlockState state, BlockGetter worldIn, BlockPos pos, PathComputationType type) {
		switch (type) {
		case LAND:
			return state.getValue(OPEN);
		case WATER:
			return false;
		case AIR:
			return state.getValue(OPEN);
		default:
			return false;
		}
	}
	
	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(HALF, H_FACING, OPEN, HINGE, STAGE_1_2, WATERLOGGED);
	}
	
	/* ToolTip */
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.block_window").withStyle(ChatFormatting.GRAY));
	}
}
