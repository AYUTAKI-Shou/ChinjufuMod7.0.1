package com.ayutaki.chinjufumod.blocks.furniture;

import java.util.function.Supplier;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.tileentity.Tansu_TileEntity;

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
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Tansu extends AbstractTansu<Tansu_TileEntity> {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");
	public static final BooleanProperty OPEN = BooleanProperty.create("open");
	public static final EnumProperty<ChestType> TYPE = BlockStateProperties.CHEST_TYPE;
	
	public Tansu(BlockBehaviour.Properties properties, Supplier<BlockEntityType<? extends Tansu_TileEntity>> entityType) {
		super(properties, entityType);
		/** Default state **/
		registerDefaultState(this.stateDefinition.any().setValue(H_FACING, Direction.NORTH)
				.setValue(WATERLOGGED, Boolean.valueOf(false))
				.setValue(OPEN, Boolean.valueOf(false))
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
	
	public void setPlacedBy(Level worldIn, BlockPos pos, BlockState state, LivingEntity entity, ItemStack stack) {
		if (stack.hasCustomHoverName()) {
			BlockEntity tileentity = worldIn.getBlockEntity(pos);
			if (tileentity instanceof Tansu_TileEntity) {
				((Tansu_TileEntity)tileentity).setCustomName(stack.getHoverName());
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public void onRemove(BlockState state, Level worldIn, BlockPos pos, BlockState facingState, boolean p_196243_5_) {
		if (!state.is(facingState.getBlock())) {
			BlockEntity tileentity = worldIn.getBlockEntity(pos);
			if (tileentity instanceof Tansu_TileEntity) {
				Containers.dropContents(worldIn, pos, (Tansu_TileEntity)tileentity);
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
							if (tile instanceof Tansu_TileEntity) {
								// NetworkHooks.openScreen((ServerPlayer)playerIn, (Tansu_TileEntity)tile, pos);
								playerIn.openMenu((Tansu_TileEntity)tile); } // fix 20.2
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
							if (tile instanceof Tansu_TileEntity) { playerIn.openMenu((Tansu_TileEntity)tile); }
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
							if (tile instanceof Tansu_TileEntity) { playerIn.openMenu((Tansu_TileEntity)tile); }
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
							if (tile instanceof Tansu_TileEntity) { playerIn.openMenu((Tansu_TileEntity)tile); }
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
	public static Container getContainer(Tansu block, BlockState state, Level worldIn, BlockPos pos, boolean flag) {
		return (Container) worldIn.getBlockEntity(pos);
	}

	public DoubleBlockCombiner.NeighborCombineResult<? extends Tansu_TileEntity> combine(BlockState state, Level worldIn, BlockPos pos, boolean flag) {
		return null;
	}
	
	public static DoubleBlockCombiner.Combiner<Tansu_TileEntity, Float2FloatFunction> opennessCombiner(final LidBlockEntity lis) {
		return new DoubleBlockCombiner.Combiner<Tansu_TileEntity, Float2FloatFunction>() {
			public Float2FloatFunction acceptDouble(Tansu_TileEntity tileEntity_1, Tansu_TileEntity tileEntity_2) {
				return (p_51638_) -> {
					return Math.max(tileEntity_1.getOpenNess(p_51638_), tileEntity_2.getOpenNess(p_51638_));
				};
			}

			public Float2FloatFunction acceptSingle(Tansu_TileEntity tileEntity) {
				return tileEntity::getOpenNess;
			}

			public Float2FloatFunction acceptNone() {
				return lis::getOpenNess;
			}
		};
	}
	
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new Tansu_TileEntity(pos, state);
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

		return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER))
				.setValue(H_FACING, context.getHorizontalDirection().getOpposite());
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
		builder.add(H_FACING, OPEN, WATERLOGGED, TYPE);
	}
	
	public RenderShape getRenderShape(BlockState state) {
		return RenderShape.MODEL; // BlockRenderType.MODEL でブロックのモデルを表示
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return Shapes.block();
	}
}
