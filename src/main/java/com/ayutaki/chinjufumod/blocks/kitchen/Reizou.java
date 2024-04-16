package com.ayutaki.chinjufumod.blocks.kitchen;

import java.util.function.Supplier;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;
import com.ayutaki.chinjufumod.tileentity.Reizou_TileEntity;

import it.unimi.dsi.fastutil.floats.Float2FloatFunction;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stat;
import net.minecraft.stats.Stats;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoubleBlockCombiner;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.LidBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.ChestType;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Reizou extends AbstractReizou<Reizou_TileEntity> {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");
	public static final BooleanProperty OPEN = BooleanProperty.create("open");
	public static final BooleanProperty RIGHT = BooleanProperty.create("right");
	public static final EnumProperty<ChestType> TYPE = BlockStateProperties.CHEST_TYPE;
	
	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 13.4D);
	protected static final VoxelShape AABB_WEST = Block.box(2.6D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_NORTH = Block.box(0.0D, 0.0D, 2.6D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_EAST = Block.box(0.0D, 0.0D, 0.0D, 13.4D, 16.0D, 16.0D);

	public Reizou(BlockBehaviour.Properties properties, Supplier<BlockEntityType<? extends Reizou_TileEntity>> entityType) {
		super(properties, entityType);
		/** Default state **/
		registerDefaultState(this.stateDefinition.any().setValue(H_FACING, Direction.NORTH)
				.setValue(WATERLOGGED, Boolean.valueOf(false))
				.setValue(OPEN, Boolean.valueOf(false))
				.setValue(RIGHT, Boolean.valueOf(false))
				.setValue(TYPE, ChestType.SINGLE));
	}

	public static DoubleBlockCombiner.BlockType getBlockType(BlockState state) {
		return DoubleBlockCombiner.BlockType.SINGLE;
	}
	
	@SuppressWarnings("unused")
	private Direction candidatePartnerFacing(BlockPlaceContext context, Direction direct) {
		BlockState state = context.getLevel().getBlockState(context.getClickedPos().relative(direct));
		return state.is(this) && state.getValue(TYPE) == ChestType.SINGLE ? state.getValue(H_FACING) : null;
	}
	
	@SuppressWarnings("deprecation")
	public void onRemove(BlockState state, Level worldIn, BlockPos pos, BlockState facingState, boolean p_196243_5_) {
		if (!state.is(facingState.getBlock())) {
			BlockEntity tileentity = worldIn.getBlockEntity(pos);
			if (tileentity instanceof Reizou_TileEntity) {
				Containers.dropContents(worldIn, pos, (Reizou_TileEntity)tileentity);
				worldIn.updateNeighbourForOutputSignal(pos, this);
			}
			super.onRemove(state, worldIn, pos, facingState, p_196243_5_);
		}
	}
	
	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		
		if (worldIn.isClientSide) { return InteractionResult.SUCCESS; }

		else {
			if (!state.getValue(WATERLOGGED)) {
				Direction direction = state.getValue(H_FACING);
				BlockEntity tile = worldIn.getBlockEntity(pos);
				
				BlockState northState = worldIn.getBlockState(pos.north());
				BlockState southState = worldIn.getBlockState(pos.south());
				BlockState eastState = worldIn.getBlockState(pos.east());
				BlockState westState = worldIn.getBlockState(pos.west());
				
				switch (direction) {
				case NORTH :
				default :
					if (!northState.canBeReplaced()) {
						CMEvents.textIsBlocked(worldIn, pos, playerIn);
						return InteractionResult.SUCCESS; }
					
					if (northState.canBeReplaced()) {
						if (northState.getBlock() instanceof LiquidBlock) {
							CMEvents.textIsBlocked(worldIn, pos, playerIn);
							return InteractionResult.SUCCESS; }
						
						if (!(northState.getBlock() instanceof LiquidBlock)) {
							if (tile instanceof Reizou_TileEntity) {
								// NetworkHooks.openScreen((ServerPlayer)playerIn, (Reizou_TileEntity)tile, pos);
								playerIn.openMenu((Reizou_TileEntity)tile); } // fix 20.2
							return InteractionResult.CONSUME; } }
					break;

				case SOUTH:
					if (!southState.canBeReplaced()) {
						CMEvents.textIsBlocked(worldIn, pos, playerIn);
						return InteractionResult.SUCCESS; }
					
					if (southState.canBeReplaced()) {
						if (southState.getBlock() instanceof LiquidBlock) {
							CMEvents.textIsBlocked(worldIn, pos, playerIn);
							return InteractionResult.SUCCESS; }
						
						if (!(southState.getBlock() instanceof LiquidBlock)) {
							if (tile instanceof Reizou_TileEntity) { playerIn.openMenu((Reizou_TileEntity)tile); }
							return InteractionResult.CONSUME; } }
					break;

				case EAST:
					if (!eastState.canBeReplaced()) {
						CMEvents.textIsBlocked(worldIn, pos, playerIn);
						return InteractionResult.SUCCESS; }
				
					if (eastState.canBeReplaced()) {
						if (eastState.getBlock() instanceof LiquidBlock) {
							CMEvents.textIsBlocked(worldIn, pos, playerIn);
							return InteractionResult.SUCCESS; }
						
						if (!(eastState.getBlock() instanceof LiquidBlock)) {
							if (tile instanceof Reizou_TileEntity) { playerIn.openMenu((Reizou_TileEntity)tile); }
							return InteractionResult.CONSUME; } }
					break;
					
				case WEST:
					if (!westState.canBeReplaced()) {
						CMEvents.textIsBlocked(worldIn, pos, playerIn);
						return InteractionResult.SUCCESS; }
					
					if (westState.canBeReplaced()) {
						if (westState.getBlock() instanceof LiquidBlock) {
							CMEvents.textIsBlocked(worldIn, pos, playerIn);
							return InteractionResult.SUCCESS; }
						
						if (!(westState.getBlock() instanceof LiquidBlock)) {
							if (tile instanceof Reizou_TileEntity) { playerIn.openMenu((Reizou_TileEntity)tile); }
							return InteractionResult.CONSUME; } }
					break;
				} // direction
			}
			
			else {
				CMEvents.textIsWaterlogged(worldIn, pos, playerIn);
				return InteractionResult.SUCCESS; }
		}
		
		return InteractionResult.SUCCESS;
	}
	
	protected Stat<ResourceLocation> getOpenChestStat() {
		return Stats.CUSTOM.get(Stats.OPEN_CHEST);
	}
	
	@Nullable
	public static Container getContainer(Reizou block, BlockState state, Level worldIn, BlockPos pos, boolean flag) {
		return (Container) worldIn.getBlockEntity(pos);
	}

	public DoubleBlockCombiner.NeighborCombineResult<? extends Reizou_TileEntity> combine(BlockState state, Level worldIn, BlockPos pos, boolean flag) {
		return null;
	}
	
	public static DoubleBlockCombiner.Combiner<Reizou_TileEntity, Float2FloatFunction> opennessCombiner(final LidBlockEntity lis) {
		return new DoubleBlockCombiner.Combiner<Reizou_TileEntity, Float2FloatFunction>() {
			public Float2FloatFunction acceptDouble(Reizou_TileEntity tileEntity_1, Reizou_TileEntity tileEntity_2) {
				return (p_51638_) -> {
					return Math.max(tileEntity_1.getOpenNess(p_51638_), tileEntity_2.getOpenNess(p_51638_));
				};
			}

			public Float2FloatFunction acceptSingle(Reizou_TileEntity tileEntity) {
				return tileEntity::getOpenNess;
			}

			public Float2FloatFunction acceptNone() {
				return lis::getOpenNess;
			}
		};
	}
	
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new Reizou_TileEntity(pos, state);
	}
	
	@Override
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}
	
	@Override
	public int getAnalogOutputSignal(BlockState state, Level worldIn, BlockPos pos) {
		return AbstractContainerMenu.getRedstoneSignalFromContainer(getContainer(this, state, worldIn, pos, false));
	}
	
	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		Level worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);
		Player playerIn = context.getPlayer();
		
		/** pos.up() = Replaceable block. **/
		if (pos.getY() < worldIn.getMaxBuildHeight() - 1 && worldIn.getBlockState(pos.above()).canBeReplaced(context)) {
			return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER))
					.setValue(RIGHT, Boolean.valueOf(playerIn.isCrouching()))
					.setValue(H_FACING, context.getHorizontalDirection().getOpposite()); }

		else { return null; }
	}
	
	public void setPlacedBy(Level worldIn, BlockPos pos, BlockState state, LivingEntity entity, ItemStack stack) {

		worldIn.setBlock(pos.above(), Kitchen_Blocks.KIT_REIZOU_TOP.get().defaultBlockState()
				.setValue(H_FACING, state.getValue(H_FACING))
				.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.above()).getType() == Fluids.WATER))
				.setValue(RIGHT, Boolean.valueOf(entity.isCrouching())), 3);
		
		if (stack.hasCustomHoverName()) {
			BlockEntity tileentity = worldIn.getBlockEntity(pos);
			if (tileentity instanceof Reizou_TileEntity) { ((Reizou_TileEntity)tileentity).setCustomName(stack.getHoverName()); }
		}
	}
	
	/* HORIZONTAL Property */
	@Override
	public BlockState rotate(BlockState state, Rotation rotation) {
		return state.setValue(H_FACING, rotation.rotate(state.getValue(H_FACING)));
	}

	@SuppressWarnings("deprecation")
	public BlockState mirror(BlockState state, Mirror mirror) {
		return state.rotate(mirror.getRotation(state.getValue(H_FACING)));
	}

	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.getValue(WATERLOGGED)) {
			worldIn.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }

		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}
	
	@Override
	public boolean isPathfindable(BlockState state, BlockGetter worldIn, BlockPos pos, PathComputationType type) {
		return false;
	}
	
	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(H_FACING, OPEN, WATERLOGGED, TYPE, RIGHT);
	}
	
	public RenderShape getRenderShape(BlockState state) {
		return RenderShape.MODEL; // BlockRenderType.MODEL でブロックのモデルを表示
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		Direction direction = state.getValue(H_FACING);

		switch (direction) {
		case NORTH:
		default: return AABB_NORTH;
		case SOUTH: return AABB_SOUTH;
		case WEST: return AABB_WEST;
		case EAST: return AABB_EAST;
		} // switch
	}
	
	/* Destroy a DoubleBlock from DoublePlantBlock.class */
	@Override
	public void playerWillDestroy(Level worldIn, BlockPos pos, BlockState state, Player playerIn) {
		BlockState upState = worldIn.getBlockState(pos.above());
		/** False is not Drop. **/
		if (upState.getBlock() == Kitchen_Blocks.KIT_REIZOU_TOP.get()) {
			worldIn.destroyBlock(pos.above(), false);
		}
		super.playerWillDestroy(worldIn, pos, state, playerIn);
	}
}
