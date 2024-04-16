package com.ayutaki.chinjufumod.blocks.jpblock;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.blocks.garden.Itabei;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.PaneBlock;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
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
	private static final VoxelShape AABB_ALONE = VoxelShapes.or(Block.box(2.0D, 0.0D, 2.0D, 14.0D, 4.0D, 14.0D),
			Block.box(5.0D, 4.0D, 5.0D, 11.0D, 8.0D, 11.0D));
	
	private static final VoxelShape AABB_CENTER = Block.box(5.0D, 4.0D, 5.0D, 11.0D, 8.0D, 11.0D);
	private static final VoxelShape AABB_NORTH = VoxelShapes.or(Block.box(2.0D, 0.0D, 0.0D, 14.0D, 4.0D, 11.0D),
			Block.box(5.0D, 4.0D, 0.0D, 11.0D, 8.0D, 5.0D));
	private static final VoxelShape AABB_EAST = VoxelShapes.or(Block.box(5.0D, 0.0D, 2.0D, 16.0D, 4.0D, 14.0D),
			Block.box(11.0D, 4.0D, 5.0D, 16.0D, 8.0D, 11.0D));
	private static final VoxelShape AABB_SOUTH = VoxelShapes.or(Block.box(2.0D, 0.0D, 5.0D, 14.0D, 4.0D, 16.0D),
			Block.box(5.0D, 4.0D, 11.0D, 11.0D, 8.0D, 16.0D));
	private static final VoxelShape AABB_WEST = VoxelShapes.or(Block.box(0.0D, 0.0D, 2.0D, 11.0D, 4.0D, 14.0D),
			Block.box(0.0D, 4.0D, 5.0D, 5.0D, 8.0D, 11.0D));
	
	private static final VoxelShape UNDER_NE = Block.box(2.0D, 0.0D, 11.0D, 5.0D, 4.0D, 14.0D);
	private static final VoxelShape UNDER_NW = Block.box(11.0D, 0.0D, 11.0D, 14.0D, 4.0D, 14.0D);
	private static final VoxelShape UNDER_SE = Block.box(2.0D, 0.0D, 2.0D, 5.0D, 4.0D, 5.0D);
	private static final VoxelShape UNDER_SW = Block.box(11.0D, 0.0D, 2.0D, 14.0D, 4.0D, 5.0D);
	
	private static final VoxelShape AABB_NORTH2 = VoxelShapes.or(Block.box(2.0D, 0.0D, 11.0D, 14.0D, 4.0D, 12.0D),
			Block.box(5.0D, 4.0D, 11.0D, 11.0D, 8.0D, 12.0D));
	private static final VoxelShape AABB_EAST2 = VoxelShapes.or(Block.box(4.0D, 0.0D, 2.0D, 5.0D, 4.0D, 14.0D),
			Block.box(4.0D, 4.0D, 5.0D, 5.0D, 8.0D, 11.0D));
	private static final VoxelShape AABB_SOUTH2 = VoxelShapes.or(Block.box(2.0D, 0.0D, 4.0D, 14.0D, 4.0D, 5.0D),
			Block.box(5.0D, 4.0D, 4.0D, 11.0D, 8.0D, 5.0D));
	private static final VoxelShape AABB_WEST2 = VoxelShapes.or(Block.box(11.0D, 0.0D, 2.0D, 12.0D, 4.0D, 14.0D),
			Block.box(11.0D, 4.0D, 5.0D, 12.0D, 8.0D, 11.0D));
	
	public Wall_Kawara(AbstractBlock.Properties properties) {
		super(properties);
		/** Default state **/
		registerDefaultState(this.defaultBlockState().setValue(NORTH, Boolean.valueOf(false))
				.setValue(EAST, Boolean.valueOf(false))
				.setValue(SOUTH, Boolean.valueOf(false))
				.setValue(WEST, Boolean.valueOf(false))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* Gives a value when placed. */
	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);
		
		BlockPos northPos = pos.north();
		BlockPos eastPos = pos.east();
		BlockPos southPos = pos.south();
		BlockPos westPos = pos.west();
		BlockState northState = worldIn.getBlockState(northPos);
		BlockState eastState = worldIn.getBlockState(eastPos);
		BlockState southState = worldIn.getBlockState(southPos);
		BlockState westState = worldIn.getBlockState(westPos);
			
		BlockPos downPos = pos.below();
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
		
		boolean cube = downState.isCollisionShapeFullBlock(worldIn, downPos);
		
		boolean sama = downState.getBlock() instanceof Wall_Sama;
		boolean samaEW = sama && (downState.getValue(Wall_Sama.H_FACING) == Direction.EAST || downState.getValue(Wall_Sama.H_FACING) == Direction.WEST);
		boolean samaNS = sama && (downState.getValue(Wall_Sama.H_FACING) == Direction.NORTH || downState.getValue(Wall_Sama.H_FACING) == Direction.SOUTH);
		
		boolean itabei = downState.getBlock() instanceof Itabei && !downState.getValue(Itabei.CHECK);
		boolean itabeiEW = itabei && (downState.getValue(Itabei.H_FACING) == Direction.EAST || downState.getValue(Itabei.H_FACING) == Direction.WEST);
		boolean itabeiNS = itabei && (downState.getValue(Itabei.H_FACING) == Direction.NORTH || downState.getValue(Itabei.H_FACING) == Direction.SOUTH);
		
		boolean north = canConnectTo(northState, northState.isFaceSturdy(worldIn, northPos, Direction.SOUTH), Direction.SOUTH) ||
				(!cube && canConnectTo(DnorthState, DnorthState.isFaceSturdy(worldIn, DnorthPos, Direction.SOUTH), Direction.SOUTH)) || samaEW || itabeiEW;
			
		boolean east = canConnectTo(eastState, eastState.isFaceSturdy(worldIn, eastPos, Direction.WEST), Direction.WEST) || 
				(!cube && canConnectTo(DeastState, DeastState.isFaceSturdy(worldIn, DeastPos, Direction.WEST), Direction.WEST)) || samaNS || itabeiNS;
			
		boolean south = canConnectTo(southState, southState.isFaceSturdy(worldIn, southPos, Direction.NORTH), Direction.NORTH) ||
				(!cube && canConnectTo(DsouthState, DsouthState.isFaceSturdy(worldIn, DsouthPos, Direction.NORTH), Direction.NORTH)) || samaEW || itabeiEW;
			
		boolean west = canConnectTo(westState, westState.isFaceSturdy(worldIn, westPos, Direction.EAST), Direction.EAST) ||
				(!cube && canConnectTo(DwestState, DwestState.isFaceSturdy(worldIn, DwestPos, Direction.EAST), Direction.EAST)) || samaNS || itabeiNS;
				
		return this.defaultBlockState().setValue(NORTH, north).setValue(EAST, east).setValue(SOUTH, south).setValue(WEST, west)
				.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER));
	}

	/* Connect the blocks. */
	private boolean canConnectTo(BlockState state, boolean sturdy, Direction direction) {
		Block block = state.getBlock();
		boolean flag = block instanceof FenceGateBlock && FenceGateBlock.connectsToDirection(state, direction);
		return block instanceof Wall_Kawara || state.is(BlockTags.WALLS) || !isExceptionForConnection(block) && sturdy || block instanceof PaneBlock || flag;
	}
	
	/* Update BlockState. */
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }

		BlockPos northPos = pos.north();
		BlockPos eastPos = pos.east();
		BlockPos southPos = pos.south();
		BlockPos westPos = pos.west();
		BlockState northState = worldIn.getBlockState(northPos);
		BlockState eastState = worldIn.getBlockState(eastPos);
		BlockState southState = worldIn.getBlockState(southPos);
		BlockState westState = worldIn.getBlockState(westPos);
			
		BlockPos downPos = pos.below();
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
		
		boolean cube = downState.isCollisionShapeFullBlock(worldIn, downPos);
		
		boolean sama = downState.getBlock() instanceof Wall_Sama;
		boolean samaEW = sama && (downState.getValue(Wall_Sama.H_FACING) == Direction.EAST || downState.getValue(Wall_Sama.H_FACING) == Direction.WEST);
		boolean samaNS = sama && (downState.getValue(Wall_Sama.H_FACING) == Direction.NORTH || downState.getValue(Wall_Sama.H_FACING) == Direction.SOUTH);
		
		boolean itabei = downState.getBlock() instanceof Itabei && !downState.getValue(Itabei.CHECK);
		boolean itabeiEW = itabei && (downState.getValue(Itabei.H_FACING) == Direction.EAST || downState.getValue(Itabei.H_FACING) == Direction.WEST);
		boolean itabeiNS = itabei && (downState.getValue(Itabei.H_FACING) == Direction.NORTH || downState.getValue(Itabei.H_FACING) == Direction.SOUTH);
		
		boolean north = canConnectTo(northState, northState.isFaceSturdy(worldIn, northPos, Direction.SOUTH), Direction.SOUTH) ||
				(!cube && canConnectTo(DnorthState, DnorthState.isFaceSturdy(worldIn, DnorthPos, Direction.SOUTH), Direction.SOUTH)) || samaEW || itabeiEW;
			
		boolean east = canConnectTo(eastState, eastState.isFaceSturdy(worldIn, eastPos, Direction.WEST), Direction.WEST) || 
				(!cube && canConnectTo(DeastState, DeastState.isFaceSturdy(worldIn, DeastPos, Direction.WEST), Direction.WEST)) || samaNS || itabeiNS;
			
		boolean south = canConnectTo(southState, southState.isFaceSturdy(worldIn, southPos, Direction.NORTH), Direction.NORTH) ||
				(!cube && canConnectTo(DsouthState, DsouthState.isFaceSturdy(worldIn, DsouthPos, Direction.NORTH), Direction.NORTH)) || samaEW || itabeiEW;
			
		boolean west = canConnectTo(westState, westState.isFaceSturdy(worldIn, westPos, Direction.EAST), Direction.EAST) ||
				(!cube && canConnectTo(DwestState, DwestState.isFaceSturdy(worldIn, DwestPos, Direction.EAST), Direction.EAST)) || samaNS || itabeiNS;

		return state.setValue(NORTH, north).setValue(EAST, east).setValue(SOUTH, south).setValue(WEST, west);
	}

	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(NORTH, EAST, SOUTH, WEST, WATERLOGGED);
	}
	
	/* Collision */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

		boolean north = state.getValue(NORTH).booleanValue();
		boolean east = state.getValue(EAST).booleanValue();
		boolean south = state.getValue(SOUTH).booleanValue();
		boolean west = state.getValue(WEST).booleanValue();
		
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
}
