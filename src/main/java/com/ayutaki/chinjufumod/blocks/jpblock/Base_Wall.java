package com.ayutaki.chinjufumod.blocks.jpblock;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.color.Base_ItemHake;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.PaneBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

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
	
	public Base_Wall(AbstractBlock.Properties properties) {
		super(properties);
		/** Default state **/
		registerDefaultState(this.defaultBlockState().setValue(NORTH, Boolean.valueOf(false))
				.setValue(EAST, Boolean.valueOf(false))
				.setValue(SOUTH, Boolean.valueOf(false))
				.setValue(WEST, Boolean.valueOf(false))
				.setValue(WATERLOGGED, Boolean.valueOf(false))
				.setValue(CRACK, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();

		if (item instanceof Base_ItemHake) { return ActionResultType.PASS; }

		else {
			if (stack.isEmpty()) {
				if (playerIn.isCrouching()) {
					CMEvents.soundStonePlace(worldIn, pos);
					worldIn.setBlock(pos, state.cycle(CRACK), 3);
					return ActionResultType.SUCCESS; }
			}

			return ActionResultType.PASS;
		}
	}

	/* Gives a value when placed. */
	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getLevel();
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

	/* Connect the blocks. GLASSDOOR, SHOUJI, FUSUMA, WINDOW, RANMA, KOUSHI, SAMA, PaneBlock, FenceGate */
	private boolean canConnectTo(BlockState state, boolean sturdy, Direction direction) {
		Block block = state.getBlock();
		boolean flag = block instanceof FenceGateBlock && FenceGateBlock.connectsToDirection(state, direction);
		return state.is(BlockTags.WALLS) || !isExceptionForConnection(block) && sturdy || block instanceof PaneBlock || flag;
	}

	/* Update BlockState. */
	@Override
	public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if (stateIn.getValue(WATERLOGGED)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }

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
		
		return stateIn.setValue(NORTH, north).setValue(EAST, east).setValue(SOUTH, south).setValue(WEST, west);
	}

	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(NORTH, EAST, SOUTH, WEST, WATERLOGGED, CRACK);
	}
	
	/* Collision */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

		boolean north = state.getValue(NORTH).booleanValue();
		boolean east = state.getValue(EAST).booleanValue();
		boolean south = state.getValue(SOUTH).booleanValue();
		boolean west = state.getValue(WEST).booleanValue();

		VoxelShape shape = AABB_CENTER;

		if (!north && !south && !east && !west) {
			shape = VoxelShapes.or(shape); }

		if (north) {
			if (south) { shape = VoxelShapes.or(shape, AABB_NORTH); }
			if (!east && !west && !south) { shape = VoxelShapes.or(shape, AABB_NORTH); }
			shape = VoxelShapes.or(shape, AABB_NORTH);
		}

		if (south) {
			if (north) { shape = VoxelShapes.or(shape, AABB_SOUTH); }
			if (!east && !west && !north) { shape = VoxelShapes.or(shape, AABB_SOUTH); }
			shape = VoxelShapes.or(shape, AABB_SOUTH);
		}

		if (east) {
			if (west) { shape = VoxelShapes.or(shape, AABB_EAST); }
			if (!north && !south && !west) { shape = VoxelShapes.or(shape, AABB_EAST); }
			shape = VoxelShapes.or(shape, AABB_EAST);
		}

		if (west) {
			if (east) { shape = VoxelShapes.or(shape, AABB_WEST); }
			if (!north && !south && !east) { shape = VoxelShapes.or(shape, AABB_WEST); }
			shape = VoxelShapes.or(shape, AABB_WEST);
		}

		return shape;
	}

	/* The best harvesting tool. */
	@Nullable
	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.PICKAXE;
	}

	@Override
	public int getHarvestLevel(BlockState state) {
		return 0;
	}
}
