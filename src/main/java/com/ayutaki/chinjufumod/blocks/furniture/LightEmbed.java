package com.ayutaki.chinjufumod.blocks.furniture;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingSlab_Water;
import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.blocks.jpblock.Base_Slab_JP;
import com.ayutaki.chinjufumod.blocks.jpdeco.BaseTatami;
import com.ayutaki.chinjufumod.blocks.wood.WoodSlab_CM;
import com.ayutaki.chinjufumod.state.TatamiType;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class LightEmbed extends CM_WaterLogged {

	/* Property */
	public static final BooleanProperty NORTH = BooleanProperty.create("north");
	public static final BooleanProperty EAST = BooleanProperty.create("east");
	public static final BooleanProperty SOUTH = BooleanProperty.create("south");
	public static final BooleanProperty WEST = BooleanProperty.create("west");
	public static final IntegerProperty STAGE_1_4 = IntegerProperty.create("stage", 1, 4);

	/* Collision */
	protected static final VoxelShape AABB_1 = Block.makeCuboidShape(1.0D, 15.0D, 1.0D, 15.0D, 19.5D, 15.0D);
	protected static final VoxelShape AABB_2 = Block.makeCuboidShape(1.0D, 15.0D, 1.0D, 15.0D, 24.0D, 15.0D);
	protected static final VoxelShape AABB_3 = Block.makeCuboidShape(1.0D, -8.0D, 1.0D, 15.0D, 1.0D, 15.0D);
	protected static final VoxelShape AABB_4 = Block.makeCuboidShape(1.0D, -3.5D, 1.0D, 15.0D, 1.0D, 15.0D);

	public LightEmbed(Block.Properties properties) {
		super(properties);

		/** Default state **/
		setDefaultState(this.stateContainer.getBaseState().with(NORTH, Boolean.valueOf(false))
				.with(EAST, Boolean.valueOf(false))
				.with(SOUTH, Boolean.valueOf(false))
				.with(WEST, Boolean.valueOf(false))
				.with(STAGE_1_4, Integer.valueOf(1))
				.with(WATERLOGGED, Boolean.valueOf(false)));
	}

	public int getLightValue(BlockState state) {
		return 15;
	}

	/* Gives a value when placed. +180 .getOpposite() */
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getWorld();
		BlockPos pos = context.getPos();
		IFluidState fluid = worldIn.getFluidState(pos);
		
		Direction direction = context.getFace();
		boolean downFace = (direction == Direction.DOWN);
		boolean upFace = (direction == Direction.UP);
		
		BlockState downState = worldIn.getBlockState(pos.down());
		Block downBlock = downState.getBlock();
		boolean bottom = ((downBlock instanceof SlabBlock && downState.get(SlabBlock.TYPE) == SlabType.BOTTOM) ||
			(downBlock instanceof WoodSlab_CM && downState.get(SlabBlock.TYPE) == SlabType.BOTTOM) ||
			(downBlock instanceof BaseFacingSlab_Water && downState.get(SlabBlock.TYPE) == SlabType.BOTTOM) ||
			(downBlock instanceof Base_Slab_JP && downState.get(Base_Slab_JP.TYPE) == SlabType.BOTTOM) ||
			(downBlock instanceof BaseTatami && downState.get(BaseTatami.TYPE) == TatamiType.BOTTOM));
		
		BlockState upState = worldIn.getBlockState(pos.up());
		Block upBlock = upState.getBlock();
		boolean top = ((upBlock instanceof SlabBlock && upState.get(SlabBlock.TYPE) == SlabType.TOP) ||
			(upBlock instanceof WoodSlab_CM && upState.get(SlabBlock.TYPE) == SlabType.TOP) ||
			(upBlock instanceof BaseFacingSlab_Water && upState.get(SlabBlock.TYPE) == SlabType.TOP) ||
			(upBlock instanceof Base_Slab_JP && upState.get(Base_Slab_JP.TYPE) == SlabType.TOP) ||
			(upBlock instanceof BaseTatami && upState.get(BaseTatami.TYPE) == TatamiType.TOP));
		
		BlockState putState = this.getDefaultState().with(STAGE_1_4, Integer.valueOf(1))
				.with(WATERLOGGED, Boolean.valueOf(Boolean.valueOf(fluid.getFluid() == Fluids.WATER)));
		
		if (downFace) { return top? putState.with(STAGE_1_4, Integer.valueOf(2)) : putState; }
		if (upFace) { return bottom? putState.with(STAGE_1_4, Integer.valueOf(3)) : putState.with(STAGE_1_4, Integer.valueOf(4)); }
		else { return null; }
	}

	/* Connect the blocks. */
	private boolean canConnectTo(IWorld worldIn, BlockPos source, Direction direction, int i) {
		BlockState state = worldIn.getBlockState(source.offset(direction));
		return state.getBlock() == this && state.get(STAGE_1_4) == i;
	}

	/* Update BlockState. */
	@Override
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if (state.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn)); }
		
		int i = state.get(STAGE_1_4);
		boolean north = canConnectTo(worldIn, pos, Direction.NORTH, i);
		boolean east = canConnectTo(worldIn, pos, Direction.EAST, i);
		boolean south = canConnectTo(worldIn, pos, Direction.SOUTH, i);
		boolean west = canConnectTo(worldIn, pos, Direction.WEST, i);
		return state.with(NORTH, north).with(EAST, east).with(SOUTH, south).with(WEST, west);
	}


	/* Create Blockstate */
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(NORTH, EAST, SOUTH, WEST, STAGE_1_4, WATERLOGGED);
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
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		int i = state.get(STAGE_1_4);

		if (i == 2) { return AABB_2; }
		if (i == 3) { return AABB_3; }
		if (i == 4) { return AABB_4; }
		return AABB_1 ;
	}
}
