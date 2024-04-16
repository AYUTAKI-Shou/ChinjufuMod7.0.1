package com.ayutaki.chinjufumod.blocks.jpblock;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.color.Base_ItemHake;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Base_Wall extends CM_WaterLogged {

	/* Property */
	public static final BooleanProperty NORTH = BooleanProperty.create("north");
	public static final BooleanProperty EAST = BooleanProperty.create("east");
	public static final BooleanProperty SOUTH = BooleanProperty.create("south");
	public static final BooleanProperty WEST = BooleanProperty.create("west");
	public static final BooleanProperty CRACK = BooleanProperty.create("cra");
	
	/* Collision ...Based on the value of WallBlock.*/
	private static final VoxelShape AABB_CENTER = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 16.0D, 11.0D);
	private static final VoxelShape AABB_NORTH = Block.box(5.0D, 0.0D, 0.0D, 11.0D, 16.0D, 5.0D);
	private static final VoxelShape AABB_EAST = Block.box(11.0D, 0.0D, 5.0D, 16.0D, 16.0D, 11.0D);
	private static final VoxelShape AABB_SOUTH = Block.box(5.0D, 0.0D, 11.0D, 11.0D, 16.0D, 16.0D);
	private static final VoxelShape AABB_WEST = Block.box(0.0D, 0.0D, 5.0D, 5.0D, 16.0D, 11.0D);
	
	public Base_Wall(BlockBehaviour.Properties properties) {
		super(properties);
		/** Default state **/
		registerDefaultState(this.stateDefinition.any().setValue(NORTH, Boolean.valueOf(false))
				.setValue(EAST, Boolean.valueOf(false))
				.setValue(SOUTH, Boolean.valueOf(false))
				.setValue(WEST, Boolean.valueOf(false))
				.setValue(WATERLOGGED, Boolean.valueOf(false))
				.setValue(CRACK, Boolean.valueOf(false)));
	}

	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();

		if (item instanceof Base_ItemHake) { return InteractionResult.PASS; }

		else {
			if (stack.isEmpty()) {
				if (playerIn.isCrouching()) {
					CMEvents.soundStonePlace(worldIn, pos);
					worldIn.setBlock(pos, state.cycle(CRACK), 3);
					return InteractionResult.SUCCESS; }
				
				if (!playerIn.isCrouching()) {
					CMEvents.textNotSneak(worldIn, pos, playerIn);
					return InteractionResult.SUCCESS; }
			}

			return InteractionResult.PASS;
		}
	}
	
	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		Level worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);

		BlockPos northpos = pos.north();
		BlockPos eastpos = pos.east();
		BlockPos southpos = pos.south();
		BlockPos westpos = pos.west();
		BlockState northState = worldIn.getBlockState(northpos);
		BlockState eastState = worldIn.getBlockState(eastpos);
		BlockState southState = worldIn.getBlockState(southpos);
		BlockState westState = worldIn.getBlockState(westpos);

		boolean north = this.canConnectTo(northState, northState.isFaceSturdy(worldIn, northpos, Direction.SOUTH), Direction.SOUTH);
		boolean east = this.canConnectTo(eastState, eastState.isFaceSturdy(worldIn, eastpos, Direction.WEST), Direction.WEST);
		boolean south = this.canConnectTo(southState, southState.isFaceSturdy(worldIn, southpos, Direction.NORTH), Direction.NORTH);
		boolean west = this.canConnectTo(westState, westState.isFaceSturdy(worldIn, westpos, Direction.EAST), Direction.EAST);

		return this.defaultBlockState().setValue(NORTH, north).setValue(EAST, east).setValue(SOUTH, south).setValue(WEST, west)
				.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER));
	}

	/* Connect the blocks. */
	private boolean canConnectTo(BlockState state, boolean sturdy, Direction direction) {
		Block block = state.getBlock();
		boolean flag = block instanceof FenceGateBlock && FenceGateBlock.connectsToDirection(state, direction);
		return state.is(BlockTags.WALLS) || !isExceptionForConnection(state) && sturdy || block instanceof IronBarsBlock || flag;
	}
	
	/* Update BlockState. */
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos pos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			worldIn.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }
		
		BlockPos northpos = pos.north();
		BlockPos eastpos = pos.east();
		BlockPos southpos = pos.south();
		BlockPos westpos = pos.west();
		BlockState northState = worldIn.getBlockState(northpos);
		BlockState eastState = worldIn.getBlockState(eastpos);
		BlockState southState = worldIn.getBlockState(southpos);
		BlockState westState = worldIn.getBlockState(westpos);

		boolean north = canConnectTo(northState, northState.isFaceSturdy(worldIn, northpos, Direction.SOUTH), Direction.SOUTH);
		boolean east = canConnectTo(eastState, eastState.isFaceSturdy(worldIn, eastpos, Direction.WEST), Direction.WEST);
		boolean south = canConnectTo(southState, southState.isFaceSturdy(worldIn, southpos, Direction.NORTH), Direction.NORTH);
		boolean west = canConnectTo(westState, westState.isFaceSturdy(worldIn, westpos, Direction.EAST), Direction.EAST);
		
		return state.setValue(NORTH, north).setValue(EAST, east).setValue(SOUTH, south).setValue(WEST, west);
	}

	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(NORTH, EAST, SOUTH, WEST, WATERLOGGED, CRACK);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		boolean north = state.getValue(NORTH).booleanValue();
		boolean east = state.getValue(EAST).booleanValue();
		boolean south = state.getValue(SOUTH).booleanValue();
		boolean west = state.getValue(WEST).booleanValue();

		VoxelShape shape = AABB_CENTER;

		if (!north && !south && !east && !west) {
			shape = Shapes.or(shape); }

		if (north) {
			if (south) { shape = Shapes.or(shape, AABB_NORTH); }
			if (!east && !west && !south) { shape = Shapes.or(shape, AABB_NORTH); }
			shape = Shapes.or(shape, AABB_NORTH);
		}

		if (south) {
			if (north) { shape = Shapes.or(shape, AABB_SOUTH); }
			if (!east && !west && !north) { shape = Shapes.or(shape, AABB_SOUTH); }
			shape = Shapes.or(shape, AABB_SOUTH);
		}

		if (east) {
			if (west) { shape = Shapes.or(shape, AABB_EAST); }
			if (!north && !south && !west) { shape = Shapes.or(shape, AABB_EAST); }
			shape = Shapes.or(shape, AABB_EAST);
		}

		if (west) {
			if (east) { shape = Shapes.or(shape, AABB_WEST); }
			if (!north && !south && !east) { shape = Shapes.or(shape, AABB_WEST); }
			shape = Shapes.or(shape, AABB_WEST);
		}

		return shape;
	}
}
