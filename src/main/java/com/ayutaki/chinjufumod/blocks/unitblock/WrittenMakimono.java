package com.ayutaki.chinjufumod.blocks.unitblock;

import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingSlab_Water;
import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.blocks.jpblock.Base_Slab_JP;
import com.ayutaki.chinjufumod.blocks.jpdeco.BaseTatami;
import com.ayutaki.chinjufumod.blocks.wood.WoodSlab_CM;
import com.ayutaki.chinjufumod.registry.Unit_Blocks;
import com.ayutaki.chinjufumod.state.TatamiType;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

public class WrittenMakimono extends CM_WaterLogged {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final IntegerProperty STAGE_1_5 = IntegerProperty.create("stage", 1, 5);
	public static final BooleanProperty DOWN = BooleanProperty.create("down");
	public static final BooleanProperty LOST = BooleanProperty.create("lost");
	
	/* Collision */
	protected static final VoxelShape AABB_1S = Block.makeCuboidShape(6.75D, 0.0D, 4.0D, 9.25D, 2.5D, 12.0D);
	protected static final VoxelShape AABB_1W = Block.makeCuboidShape(4.0D, 0.0D, 6.75D, 12.0D, 2.5D, 9.25D);
	protected static final VoxelShape AABB_1N = Block.makeCuboidShape(6.75D, 0.0D, 4.0D, 9.25D, 2.5D, 12.0D);
	protected static final VoxelShape AABB_1E = Block.makeCuboidShape(4.0D, 0.0D, 6.75D, 12.0D, 2.5D, 9.25D);
	
	protected static final VoxelShape AABB_2S = Block.makeCuboidShape(4.25D, 0.0D, 4.0D, 9.25D, 2.5D, 12.0D);
	protected static final VoxelShape AABB_2W = Block.makeCuboidShape(4.0D, 0.0D, 4.25D, 12.0D, 2.5D, 9.25D);
	protected static final VoxelShape AABB_2N = Block.makeCuboidShape(6.75D, 0.0D, 4.0D, 11.75D, 2.5D, 12.0D);
	protected static final VoxelShape AABB_2E = Block.makeCuboidShape(4.0D, 0.0D, 6.75D, 12.0D, 2.5D, 11.75D);
	
	protected static final VoxelShape AABB_3S = Block.makeCuboidShape(4.25D, 0.0D, 4.0D, 11.75D, 2.5D, 12.0D);
	protected static final VoxelShape AABB_3W = Block.makeCuboidShape(4.0D, 0.0D, 4.25D, 12.0D, 2.5D, 11.75D);
	protected static final VoxelShape AABB_3N = Block.makeCuboidShape(4.25D, 0.0D, 4.0D, 11.75D, 2.5D, 12.0D);
	protected static final VoxelShape AABB_3E = Block.makeCuboidShape(4.0D, 0.0D, 4.25D, 12.0D, 2.5D, 11.75D);
	
	protected static final VoxelShape AABB_4S = Block.makeCuboidShape(4.25D, 0.0D, 4.0D, 11.75D, 5.0D, 12.0D);
	protected static final VoxelShape AABB_4W = Block.makeCuboidShape(4.0D, 0.0D, 4.25D, 12.0D, 5.0D, 11.75D);
	protected static final VoxelShape AABB_4N = Block.makeCuboidShape(4.25D, 0.0D, 4.0D, 11.75D, 5.0D, 12.0D);
	protected static final VoxelShape AABB_4E = Block.makeCuboidShape(4.0D, 0.0D, 4.25D, 12.0D, 5.0D, 11.75D);

	protected static final VoxelShape DOWN_SOUTH = Block.makeCuboidShape(4.25D, -8.0D, 4.0D, 11.75D, 0.1D, 12.0D);
	protected static final VoxelShape DOWN_WEST = Block.makeCuboidShape(4.0D, -8.0D, 4.25D, 12.0D, 0.1D, 11.75D);
	protected static final VoxelShape DOWN_NORTH = Block.makeCuboidShape(4.25D, -8.0D, 4.0D, 11.75D, 0.1D, 12.0D);
	protected static final VoxelShape DOWN_EAST = Block.makeCuboidShape(4.0D, -8.0D, 4.25D, 12.0D, 0.1D, 11.75D);

	public WrittenMakimono(Block.Properties properties) {
		super(properties);

		/** Default state **/
		setDefaultState(this.stateContainer.getBaseState().with(H_FACING, Direction.NORTH)
				.with(STAGE_1_5, Integer.valueOf(1))
				.with(DOWN, Boolean.valueOf(false))
				.with(WATERLOGGED, Boolean.valueOf(false))
				.with(LOST, Boolean.valueOf(false)));
	}

	/* Gives a value when placed. +180 .getOpposite() */
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getWorld();
		BlockPos pos = context.getPos();
		IFluidState fluid = worldIn.getFluidState(pos);

		if (context.getFace() == Direction.UP) {
			return this.getDefaultState().with(H_FACING, context.getPlacementHorizontalFacing().getOpposite())
					.with(DOWN, this.connectHalf(worldIn, pos, Direction.DOWN))
					.with(WATERLOGGED, fluid.getFluid() == Fluids.WATER); }

		else { return null; }
	}
	
	/* HORIZONTAL Property */
	@Override
	public BlockState rotate(BlockState state, Rotation rotation) {
		return state.with(H_FACING, rotation.rotate(state.get(H_FACING)));
	}

	@Override
	public BlockState mirror(BlockState state, Mirror mirror) {
		return state.rotate(mirror.toRotation(state.get(H_FACING)));
	}
	
	/* Connect the blocks. */
	protected boolean connectHalf(IBlockReader worldIn, BlockPos pos, Direction face) {
		BlockPos newPos = pos.offset(face);
		BlockState state = worldIn.getBlockState(newPos);
		Block block = state.getBlock();

		return ((block instanceof SlabBlock && state.get(SlabBlock.TYPE) == SlabType.BOTTOM) ||
				(block instanceof WoodSlab_CM && state.get(SlabBlock.TYPE) == SlabType.BOTTOM) ||
				(block instanceof BaseFacingSlab_Water && state.get(SlabBlock.TYPE) == SlabType.BOTTOM) ||
				(block instanceof Base_Slab_JP && state.get(Base_Slab_JP.TYPE) == SlabType.BOTTOM) ||
				(block instanceof BaseTatami && state.get(BaseTatami.TYPE) == TatamiType.BOTTOM) ||
				block instanceof LowDesk || block instanceof Chabudai || block instanceof Kotatsu);
	}
	
	protected boolean connectWater(IBlockReader worldIn, BlockPos pos, Direction face) {
		BlockPos newPos = pos.offset(face);
		BlockState state = worldIn.getBlockState(newPos);
		Block block = state.getBlock();

		return ((block instanceof SlabBlock && state.get(SlabBlock.TYPE) == SlabType.BOTTOM && state.get(SlabBlock.WATERLOGGED)) ||
				(block instanceof WoodSlab_CM && state.get(SlabBlock.TYPE) == SlabType.BOTTOM && state.get(SlabBlock.WATERLOGGED)) ||
				(block instanceof BaseFacingSlab_Water && state.get(SlabBlock.TYPE) == SlabType.BOTTOM && state.get(SlabBlock.WATERLOGGED)) ||
				(block instanceof Base_Slab_JP && state.get(Base_Slab_JP.TYPE) == SlabType.BOTTOM && state.get(SlabBlock.WATERLOGGED)) ||
				(block instanceof BaseTatami && state.get(BaseTatami.TYPE) == TatamiType.BOTTOM && state.get(SlabBlock.WATERLOGGED)) ||
				(block instanceof LowDesk && state.get(LowDesk.WATERLOGGED)) ||
				(block instanceof Chabudai && state.get(Chabudai.WATERLOGGED)) ||
				(block instanceof Kotatsu && state.get(Kotatsu.WATERLOGGED)));
	}
	
	/* Distinguish LOST from WATERLOGGED. */
	protected boolean inWater(BlockState state, IBlockReader worldIn, BlockPos pos) {
		if (state.get(WATERLOGGED) || connectWater(worldIn, pos, Direction.DOWN)) { return true; }
		return false;
	}
	
	/* Update BlockState. */
	@Override
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn)); }

		if (connectWater(worldIn, pos, Direction.DOWN)) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, Unit_Blocks.WRITTEN_MAKIMONO, Fluids.WATER.getTickRate(worldIn)); }

		if (inWater(state, worldIn, pos)) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, Unit_Blocks.WRITTEN_MAKIMONO, 300); }
		
		boolean down = connectHalf(worldIn, pos, Direction.DOWN);
		return state.with(DOWN, down);
	}

	@Override
	public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		worldIn.getPendingBlockTicks().scheduleTick(pos, Unit_Blocks.WRITTEN_MAKIMONO, 300);
	}
	
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		if (inWater(state, worldIn, pos)) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, Unit_Blocks.WRITTEN_MAKIMONO, 300);
			worldIn.setBlockState(pos, state.with(LOST, Boolean.valueOf(true)), 3); }
		
		else { }
	}

	/* Create Blockstate */
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(DOWN, H_FACING, STAGE_1_5, WATERLOGGED, LOST);
	}

	/* Collisions that change with properties */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

		Direction direction = state.get(H_FACING);
		int i = state.get(STAGE_1_5);
		boolean flag= !((Boolean)state.get(DOWN)).booleanValue();

		switch(direction) {
		case NORTH:
		default:
			return flag? ((i == 1)? AABB_1N : ((i == 2)? AABB_2N : ((i == 3)? AABB_3N : AABB_4N))) : DOWN_NORTH;
		case SOUTH:
			return flag? ((i == 1)? AABB_1S : ((i == 2)? AABB_2S : ((i == 3)? AABB_3S : AABB_4S))) : DOWN_SOUTH;
		case WEST:
			return flag? ((i == 1)? AABB_1W : ((i == 2)? AABB_2W : ((i == 3)? AABB_3W : AABB_4W))) : DOWN_WEST;
		case EAST:
			return flag? ((i == 1)? AABB_1E : ((i == 2)? AABB_2E : ((i == 3)? AABB_3E : AABB_4E))) : DOWN_EAST;
		}
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items.BOOK);
	}
	
	/* Can't breathe. */
	@Override
	public boolean causesSuffocation(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	/* Block is a cube. */
	@Override
	public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	/* Mobs spawn. */
	@Override
	public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type) {
		return false;
	}
	
	/* The best harvesting tool. */
	@Nullable
	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.AXE;
	}

	@Override
	public int getHarvestLevel(BlockState state) {
		return 0;
	}
}
