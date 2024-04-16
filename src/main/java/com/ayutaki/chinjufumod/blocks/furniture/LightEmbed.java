package com.ayutaki.chinjufumod.blocks.furniture;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingSlab_Water;
import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.blocks.jpblock.Base_Slab_JP;
import com.ayutaki.chinjufumod.blocks.jpdeco.BaseTatami;
import com.ayutaki.chinjufumod.blocks.wood.WoodSlab_CM;
import com.ayutaki.chinjufumod.state.TatamiType;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class LightEmbed extends CM_WaterLogged {

	/* Property */
	public static final BooleanProperty NORTH = BooleanProperty.create("north");
	public static final BooleanProperty EAST = BooleanProperty.create("east");
	public static final BooleanProperty SOUTH = BooleanProperty.create("south");
	public static final BooleanProperty WEST = BooleanProperty.create("west");
	public static final IntegerProperty STAGE_1_4 = IntegerProperty.create("stage", 1, 4);

	/* Collision */
	protected static final VoxelShape AABB_1 = Block.box(1.0D, 15.0D, 1.0D, 15.0D, 19.5D, 15.0D);
	protected static final VoxelShape AABB_2 = Block.box(1.0D, 15.0D, 1.0D, 15.0D, 24.0D, 15.0D);
	protected static final VoxelShape AABB_3 = Block.box(1.0D, -8.0D, 1.0D, 15.0D, 1.0D, 15.0D);
	protected static final VoxelShape AABB_4 = Block.box(1.0D, -3.5D, 1.0D, 15.0D, 1.0D, 15.0D);
	
	public LightEmbed(BlockBehaviour.Properties properties) {
		super(properties);
		/** Default state **/
		registerDefaultState(this.stateDefinition.any().setValue(NORTH, Boolean.valueOf(false))
				.setValue(EAST, Boolean.valueOf(false))
				.setValue(SOUTH, Boolean.valueOf(false))
				.setValue(WEST, Boolean.valueOf(false))
				.setValue(STAGE_1_4, Integer.valueOf(1))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		Level worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);

		Direction direction = context.getClickedFace();
		boolean downFace = (direction == Direction.DOWN);
		boolean upFace = (direction == Direction.UP);
		
		BlockState downState = worldIn.getBlockState(pos.below());
		Block downBlock = downState.getBlock();
		boolean bottom = ((downBlock instanceof SlabBlock && downState.getValue(SlabBlock.TYPE) == SlabType.BOTTOM) ||
			(downBlock instanceof WoodSlab_CM && downState.getValue(SlabBlock.TYPE) == SlabType.BOTTOM) ||
			(downBlock instanceof BaseFacingSlab_Water && downState.getValue(SlabBlock.TYPE) == SlabType.BOTTOM) ||
			(downBlock instanceof Base_Slab_JP && downState.getValue(Base_Slab_JP.TYPE) == SlabType.BOTTOM) ||
			(downBlock instanceof BaseTatami && downState.getValue(BaseTatami.TYPE) == TatamiType.BOTTOM));
		
		BlockState upState = worldIn.getBlockState(pos.above());
		Block upBlock = upState.getBlock();
		boolean top = ((upBlock instanceof SlabBlock && upState.getValue(SlabBlock.TYPE) == SlabType.TOP) ||
			(upBlock instanceof WoodSlab_CM && upState.getValue(SlabBlock.TYPE) == SlabType.TOP) ||
			(upBlock instanceof BaseFacingSlab_Water && upState.getValue(SlabBlock.TYPE) == SlabType.TOP) ||
			(upBlock instanceof Base_Slab_JP && upState.getValue(Base_Slab_JP.TYPE) == SlabType.TOP) ||
			(upBlock instanceof BaseTatami && upState.getValue(BaseTatami.TYPE) == TatamiType.TOP));
		
		BlockState putState = this.defaultBlockState().setValue(STAGE_1_4, Integer.valueOf(1))
				.setValue(WATERLOGGED, Boolean.valueOf(Boolean.valueOf(fluid.getType() == Fluids.WATER)));
		
		if (downFace) { return top? putState.setValue(STAGE_1_4, Integer.valueOf(2)) : putState; }
		if (upFace) { return bottom? putState.setValue(STAGE_1_4, Integer.valueOf(3)) : putState.setValue(STAGE_1_4, Integer.valueOf(4)); }
		else { return null; }
	}
	
	/* Connect the blocks. */
	private boolean canConnectTo(BlockGetter worldIn, BlockPos pos, Direction direction, int i) {
		BlockState state = worldIn.getBlockState(pos.relative(direction));
		return state.is(this) && state.getValue(STAGE_1_4) == i;
	}

	/* Update BlockState. */
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.getValue(WATERLOGGED)) {
			worldIn.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }

		int i = state.getValue(STAGE_1_4);
		boolean north = canConnectTo(worldIn, pos, Direction.NORTH, i);
		boolean east = canConnectTo(worldIn, pos, Direction.EAST, i);
		boolean south = canConnectTo(worldIn, pos, Direction.SOUTH, i);
		boolean west = canConnectTo(worldIn, pos, Direction.WEST, i);
		return state.setValue(NORTH, north).setValue(EAST, east).setValue(SOUTH, south).setValue(WEST, west);
	}

	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(NORTH, EAST, SOUTH, WEST, STAGE_1_4, WATERLOGGED);
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		int i = state.getValue(STAGE_1_4);

		if (i == 2) { return AABB_2; }
		if (i == 3) { return AABB_3; }
		if (i == 4) { return AABB_4; }
		return AABB_1 ;
	}
}
