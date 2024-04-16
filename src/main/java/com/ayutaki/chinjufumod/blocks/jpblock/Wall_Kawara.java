package com.ayutaki.chinjufumod.blocks.jpblock;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.blocks.garden.Itabei;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.PaneBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class Wall_Kawara extends CM_WaterLogged {

	/* Property */
	public static final BooleanProperty NORTH = BooleanProperty.create("north");
	public static final BooleanProperty EAST = BooleanProperty.create("east");
	public static final BooleanProperty SOUTH = BooleanProperty.create("south");
	public static final BooleanProperty WEST = BooleanProperty.create("west");
	
	/* Collision */
	private static final VoxelShape AABB_ALONE = VoxelShapes.or(Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 4.0D, 14.0D),
			Block.makeCuboidShape(5.0D, 4.0D, 5.0D, 11.0D, 8.0D, 11.0D));
	
	private static final VoxelShape AABB_CENTER = Block.makeCuboidShape(5.0D, 4.0D, 5.0D, 11.0D, 8.0D, 11.0D);
	private static final VoxelShape AABB_NORTH = VoxelShapes.or(Block.makeCuboidShape(2.0D, 0.0D, 0.0D, 14.0D, 4.0D, 11.0D),
			Block.makeCuboidShape(5.0D, 4.0D, 0.0D, 11.0D, 8.0D, 5.0D));
	private static final VoxelShape AABB_EAST = VoxelShapes.or(Block.makeCuboidShape(5.0D, 0.0D, 2.0D, 16.0D, 4.0D, 14.0D),
			Block.makeCuboidShape(11.0D, 4.0D, 5.0D, 16.0D, 8.0D, 11.0D));
	private static final VoxelShape AABB_SOUTH = VoxelShapes.or(Block.makeCuboidShape(2.0D, 0.0D, 5.0D, 14.0D, 4.0D, 16.0D),
			Block.makeCuboidShape(5.0D, 4.0D, 11.0D, 11.0D, 8.0D, 16.0D));
	private static final VoxelShape AABB_WEST = VoxelShapes.or(Block.makeCuboidShape(0.0D, 0.0D, 2.0D, 11.0D, 4.0D, 14.0D),
			Block.makeCuboidShape(0.0D, 4.0D, 5.0D, 5.0D, 8.0D, 11.0D));
	
	private static final VoxelShape UNDER_NE = Block.makeCuboidShape(2.0D, 0.0D, 11.0D, 5.0D, 4.0D, 14.0D);
	private static final VoxelShape UNDER_NW = Block.makeCuboidShape(11.0D, 0.0D, 11.0D, 14.0D, 4.0D, 14.0D);
	private static final VoxelShape UNDER_SE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 5.0D, 4.0D, 5.0D);
	private static final VoxelShape UNDER_SW = Block.makeCuboidShape(11.0D, 0.0D, 2.0D, 14.0D, 4.0D, 5.0D);
	
	private static final VoxelShape AABB_NORTH2 = VoxelShapes.or(Block.makeCuboidShape(2.0D, 0.0D, 11.0D, 14.0D, 4.0D, 12.0D),
			Block.makeCuboidShape(5.0D, 4.0D, 11.0D, 11.0D, 8.0D, 12.0D));
	private static final VoxelShape AABB_EAST2 = VoxelShapes.or(Block.makeCuboidShape(4.0D, 0.0D, 2.0D, 5.0D, 4.0D, 14.0D),
			Block.makeCuboidShape(4.0D, 4.0D, 5.0D, 5.0D, 8.0D, 11.0D));
	private static final VoxelShape AABB_SOUTH2 = VoxelShapes.or(Block.makeCuboidShape(2.0D, 0.0D, 4.0D, 14.0D, 4.0D, 5.0D),
			Block.makeCuboidShape(5.0D, 4.0D, 4.0D, 11.0D, 8.0D, 5.0D));
	private static final VoxelShape AABB_WEST2 = VoxelShapes.or(Block.makeCuboidShape(11.0D, 0.0D, 2.0D, 12.0D, 4.0D, 14.0D),
			Block.makeCuboidShape(11.0D, 4.0D, 5.0D, 12.0D, 8.0D, 11.0D));
	
	public Wall_Kawara(Block.Properties properties) {
		super(properties);
		
		/** Default state **/
		setDefaultState(this.stateContainer.getBaseState().with(NORTH, Boolean.valueOf(false))
				.with(EAST, Boolean.valueOf(false))
				.with(SOUTH, Boolean.valueOf(false))
				.with(WEST, Boolean.valueOf(false))
				.with(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* Gives a value when placed. +180 .getOpposite() */
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getWorld();
		BlockPos pos = context.getPos();
		IFluidState fluid = worldIn.getFluidState(pos);
		
		BlockPos northPos = pos.north();
		BlockPos eastPos = pos.east();
		BlockPos southPos = pos.south();
		BlockPos westPos = pos.west();
		BlockState northState = worldIn.getBlockState(northPos);
		BlockState eastState = worldIn.getBlockState(eastPos);
		BlockState southState = worldIn.getBlockState(southPos);
		BlockState westState = worldIn.getBlockState(westPos);
		
		BlockPos downPos = pos.down();
		BlockState downState = worldIn.getBlockState(downPos);
		
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		
		BlockPos DnorthPos = new BlockPos(x, y - 1, z - 1);
		BlockPos DeastPos = new BlockPos(x + 1, y - 1, z);
		BlockPos DsouthPos = new BlockPos(x, y - 1, z + 1);
		BlockPos DwestPos = new BlockPos(x - 1, y - 1, z);
		BlockState DnorthState = worldIn.getBlockState(DnorthPos);
		BlockState DeastState = worldIn.getBlockState(DeastPos);
		BlockState DsouthState = worldIn.getBlockState(DsouthPos);
		BlockState DwestState = worldIn.getBlockState(DwestPos);
		
		boolean cube = downState.isNormalCube(worldIn, downPos);
		
		boolean sama = downState.getBlock() instanceof Wall_Sama;
		boolean samaEW = sama && (downState.get(Wall_Sama.H_FACING) == Direction.EAST || downState.get(Wall_Sama.H_FACING) == Direction.WEST);
		boolean samaNS = sama && (downState.get(Wall_Sama.H_FACING) == Direction.NORTH || downState.get(Wall_Sama.H_FACING) == Direction.SOUTH);
		
		boolean itabei = downState.getBlock() instanceof Itabei && !downState.get(Itabei.CHECK);
		boolean itabeiEW = itabei && (downState.get(Itabei.H_FACING) == Direction.EAST || downState.get(Itabei.H_FACING) == Direction.WEST);
		boolean itabeiNS = itabei && (downState.get(Itabei.H_FACING) == Direction.NORTH || downState.get(Itabei.H_FACING) == Direction.SOUTH);
		
		boolean north = canConnectTo(northState, northState.isSolidSide(worldIn, northPos, Direction.SOUTH), Direction.SOUTH) ||
				(!cube && canConnectTo(DnorthState, DnorthState.isSolidSide(worldIn, DnorthPos, Direction.SOUTH), Direction.SOUTH)) || samaEW || itabeiEW;
			
		boolean east = canConnectTo(eastState, eastState.isSolidSide(worldIn, eastPos, Direction.WEST), Direction.WEST) || 
				(!cube && canConnectTo(DeastState, DeastState.isSolidSide(worldIn, DeastPos, Direction.WEST), Direction.WEST)) || samaNS || itabeiNS;
			
		boolean south = canConnectTo(southState, southState.isSolidSide(worldIn, southPos, Direction.NORTH), Direction.NORTH) ||
				(!cube && canConnectTo(DsouthState, DsouthState.isSolidSide(worldIn, DsouthPos, Direction.NORTH), Direction.NORTH)) || samaEW || itabeiEW;
			
		boolean west = canConnectTo(westState, westState.isSolidSide(worldIn, westPos, Direction.EAST), Direction.EAST) ||
				(!cube && canConnectTo(DwestState, DwestState.isSolidSide(worldIn, DwestPos, Direction.EAST), Direction.EAST)) || samaNS || itabeiNS;
				
		return this.getDefaultState().with(NORTH, north).with(EAST, east).with(SOUTH, south).with(WEST, west)
				.with(WATERLOGGED, fluid.getFluid() == Fluids.WATER);
	}
	
	/* Connect the blocks. */
	private boolean canConnectTo(BlockState state, boolean sturdy, Direction direction) {
		Block block = state.getBlock();
		boolean flag = block instanceof FenceGateBlock && FenceGateBlock.isParallel(state, direction);
		return state.isIn(BlockTags.WALLS) || !cannotAttach(block) && sturdy || block instanceof PaneBlock || flag;
	}

	/* Update BlockState. */
	@Override
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)stateIn.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn)); }
		
		BlockPos northPos = pos.north();
		BlockPos eastPos = pos.east();
		BlockPos southPos = pos.south();
		BlockPos westPos = pos.west();
		BlockState northState = worldIn.getBlockState(northPos);
		BlockState eastState = worldIn.getBlockState(eastPos);
		BlockState southState = worldIn.getBlockState(southPos);
		BlockState westState = worldIn.getBlockState(westPos);
			
		BlockPos downPos = pos.down();
		BlockState downState = worldIn.getBlockState(downPos);
		
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		
		BlockPos DnorthPos = new BlockPos(x, y - 1, z - 1);
		BlockPos DeastPos = new BlockPos(x + 1, y - 1, z);
		BlockPos DsouthPos = new BlockPos(x, y - 1, z + 1);
		BlockPos DwestPos = new BlockPos(x - 1, y - 1, z);
		BlockState DnorthState = worldIn.getBlockState(DnorthPos);
		BlockState DeastState = worldIn.getBlockState(DeastPos);
		BlockState DsouthState = worldIn.getBlockState(DsouthPos);
		BlockState DwestState = worldIn.getBlockState(DwestPos);
		
		boolean cube = downState.isNormalCube(worldIn, downPos);
		
		boolean sama = downState.getBlock() instanceof Wall_Sama;
		boolean samaEW = sama && (downState.get(Wall_Sama.H_FACING) == Direction.EAST || downState.get(Wall_Sama.H_FACING) == Direction.WEST);
		boolean samaNS = sama && (downState.get(Wall_Sama.H_FACING) == Direction.NORTH || downState.get(Wall_Sama.H_FACING) == Direction.SOUTH);
		
		boolean itabei = downState.getBlock() instanceof Itabei && !downState.get(Itabei.CHECK);
		boolean itabeiEW = itabei && (downState.get(Itabei.H_FACING) == Direction.EAST || downState.get(Itabei.H_FACING) == Direction.WEST);
		boolean itabeiNS = itabei && (downState.get(Itabei.H_FACING) == Direction.NORTH || downState.get(Itabei.H_FACING) == Direction.SOUTH);
		
		boolean north = canConnectTo(northState, northState.isSolidSide(worldIn, northPos, Direction.SOUTH), Direction.SOUTH) ||
				(!cube && canConnectTo(DnorthState, DnorthState.isSolidSide(worldIn, DnorthPos, Direction.SOUTH), Direction.SOUTH)) || samaEW || itabeiEW;
			
		boolean east = canConnectTo(eastState, eastState.isSolidSide(worldIn, eastPos, Direction.WEST), Direction.WEST) || 
				(!cube && canConnectTo(DeastState, DeastState.isSolidSide(worldIn, DeastPos, Direction.WEST), Direction.WEST)) || samaNS || itabeiNS;
			
		boolean south = canConnectTo(southState, southState.isSolidSide(worldIn, southPos, Direction.NORTH), Direction.NORTH) ||
				(!cube && canConnectTo(DsouthState, DsouthState.isSolidSide(worldIn, DsouthPos, Direction.NORTH), Direction.NORTH)) || samaEW || itabeiEW;
			
		boolean west = canConnectTo(westState, westState.isSolidSide(worldIn, westPos, Direction.EAST), Direction.EAST) ||
				(!cube && canConnectTo(DwestState, DwestState.isSolidSide(worldIn, DwestPos, Direction.EAST), Direction.EAST)) || samaNS || itabeiNS;
		
		return stateIn.with(NORTH, north).with(EAST, east).with(SOUTH, south).with(WEST, west);
	}
	
	/* Create Blockstate */
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(NORTH, EAST, WEST, SOUTH, WATERLOGGED);
	}
	
	/* Collision */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

		boolean north = state.get(NORTH).booleanValue();
		boolean east = state.get(EAST).booleanValue();
		boolean south = state.get(SOUTH).booleanValue();
		boolean west = state.get(WEST).booleanValue();

		VoxelShape shape = AABB_CENTER;

		if (!north && !south && !east && !west) { shape = AABB_ALONE; }

		if (north && !south && !east && !west) { shape = VoxelShapes.or(shape, AABB_NORTH, AABB_NORTH2); }
		if (!north && south && !east && !west) { shape = VoxelShapes.or(shape, AABB_SOUTH, AABB_SOUTH2); }
		if (!north && !south && east && !west) { shape = VoxelShapes.or(shape, AABB_EAST, AABB_EAST2); }
		if (!north && !south && !east && west) { shape = VoxelShapes.or(shape, AABB_WEST, AABB_WEST2); }
		
		if (north && south && !east && !west) { shape = VoxelShapes.or(shape, AABB_NORTH, AABB_SOUTH); }
		if (!north && !south && east && west) { shape = VoxelShapes.or(shape, AABB_EAST, AABB_WEST); }
		
		if (north && !south && east && !west) { shape = VoxelShapes.or(shape, AABB_NORTH, AABB_EAST, UNDER_NE); }
		if (north && !south && !east && west) { shape = VoxelShapes.or(shape, AABB_NORTH, AABB_WEST, UNDER_NW); }
		if (!north && south && east && !west) { shape = VoxelShapes.or(shape, AABB_SOUTH, AABB_EAST, UNDER_SE); }
		if (!north && south && !east && west) { shape = VoxelShapes.or(shape, AABB_SOUTH, AABB_WEST, UNDER_SW); }
		
		if (north && south && east && !west) { shape = VoxelShapes.or(shape, AABB_NORTH, AABB_EAST, AABB_SOUTH); }
		if (north && south && !east && west) { shape = VoxelShapes.or(shape, AABB_NORTH, AABB_WEST, AABB_SOUTH); }
		if (north && !south && east && west) { shape = VoxelShapes.or(shape, AABB_NORTH, AABB_EAST, AABB_WEST); }
		if (!north && south && east && west) { shape = VoxelShapes.or(shape, AABB_SOUTH, AABB_EAST, AABB_WEST); }
		
		if (north && east && west && south) { shape = VoxelShapes.or(shape, AABB_NORTH, AABB_EAST, AABB_WEST, AABB_SOUTH); }
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
}
