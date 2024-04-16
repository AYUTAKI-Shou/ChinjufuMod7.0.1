package com.ayutaki.chinjufumod.blocks.jpdeco;

import java.util.List;
import java.util.Optional;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.items.color.Base_ItemHake;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.state.TatamiType;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BaseTatami extends Block implements SimpleWaterloggedBlock {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final EnumProperty<TatamiType> TYPE = EnumProperty.create("type", TatamiType.class);
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");
	
	/* Collision */
	protected static final VoxelShape AABB_BOTTOM = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
	protected static final VoxelShape AABB_TOP = Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	
	public BaseTatami(BlockBehaviour.Properties properties) {
		super(properties);
		/** Default state **/
		registerDefaultState(this.stateDefinition.any().setValue(H_FACING, Direction.NORTH)
				.setValue(TYPE, TatamiType.BOTTOM)
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}
	
	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		boolean flag = (state.getValue(TYPE) == TatamiType.TOP && hit.getLocation().y - (double)pos.getY() <= 0.6D);
		
		if (item instanceof Base_ItemHake) { return InteractionResult.PASS; }
		
		if (item == Items.OAK_SLAB && flag) {
			this.putWoodSlab(worldIn, pos, playerIn, hand);
			worldIn.setBlock(pos, state.setValue(TYPE, TatamiType.OAK), 3);
			return InteractionResult.SUCCESS; }
		
		if (item == Items.SPRUCE_SLAB && flag) {
			this.putWoodSlab(worldIn, pos, playerIn, hand);
			worldIn.setBlock(pos, state.setValue(TYPE, TatamiType.SPRUCE), 3);
			return InteractionResult.SUCCESS; }
		
		if (item == Items.BIRCH_SLAB && flag) {
			this.putWoodSlab(worldIn, pos, playerIn, hand);
			worldIn.setBlock(pos, state.setValue(TYPE, TatamiType.BIRCH), 3);
			return InteractionResult.SUCCESS; }
		
		if (item == Items.JUNGLE_SLAB && flag) {
			this.putWoodSlab(worldIn, pos, playerIn, hand);
			worldIn.setBlock(pos, state.setValue(TYPE, TatamiType.JUNGLE), 3);
			return InteractionResult.SUCCESS; }
		
		if (item == Items.ACACIA_SLAB && flag) {
			this.putWoodSlab(worldIn, pos, playerIn, hand);
			worldIn.setBlock(pos, state.setValue(TYPE, TatamiType.ACACIA), 3);
			return InteractionResult.SUCCESS; }
		
		if (item == Items.DARK_OAK_SLAB && flag) {
			this.putWoodSlab(worldIn, pos, playerIn, hand);
			worldIn.setBlock(pos, state.setValue(TYPE, TatamiType.DARKOAK), 3);
			return InteractionResult.SUCCESS; }
		
		if (item == Items_Seasonal.SAKURA_slabhalf.get() && flag) {
			this.putWoodSlab(worldIn, pos, playerIn, hand);
			worldIn.setBlock(pos, state.setValue(TYPE, TatamiType.SAKURA), 3);
			return InteractionResult.SUCCESS; }
		
		if (item == Items_Seasonal.KAEDE_slabhalf.get() && flag) {
			this.putWoodSlab(worldIn, pos, playerIn, hand);
			worldIn.setBlock(pos, state.setValue(TYPE, TatamiType.KAEDE), 3);
			return InteractionResult.SUCCESS; }
		
		if (item == Items_Seasonal.ICHOH_slabhalf.get() && flag) {
			this.putWoodSlab(worldIn, pos, playerIn, hand);
			worldIn.setBlock(pos, state.setValue(TYPE, TatamiType.ICHOH), 3);
			return InteractionResult.SUCCESS; }
		
		return InteractionResult.PASS;
	}
	
	private void putWoodSlab(Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand) {
		ItemStack stack = playerIn.getItemInHand(hand);
		boolean mode = playerIn.getAbilities().instabuild;
		if (!mode) { stack.shrink(1); }
		if (mode) { }
		
		worldIn.playSound(null, pos, SoundEvents.WOOD_PLACE, SoundSource.BLOCKS, 1.0F, 0.8F); }
	
	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		Level worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		BlockState state = worldIn.getBlockState(pos);
		FluidState fluid = worldIn.getFluidState(pos);

		Direction direction = context.getClickedFace();
		BlockState botState = this.defaultBlockState().setValue(TYPE, TatamiType.BOTTOM)
				.setValue(WATERLOGGED, Boolean.valueOf(Boolean.valueOf(fluid.getType() == Fluids.WATER)))
				.setValue(H_FACING, context.getHorizontalDirection().getOpposite());
		BlockState topState = this.defaultBlockState().setValue(TYPE, TatamiType.TOP)
				.setValue(WATERLOGGED, Boolean.valueOf(Boolean.valueOf(fluid.getType() == Fluids.WATER)))
				.setValue(H_FACING, context.getHorizontalDirection().getOpposite());
		
		if (state.is(this)) {
			/** Change to TatamiType.DOUBLE. **/
			TatamiType slabType = state.getValue(TYPE);
			if (slabType == TatamiType.TOP || slabType == TatamiType.BOTTOM) { return state.setValue(TYPE, TatamiType.DOUBLE); }

			else {
				return direction != Direction.DOWN && (direction == Direction.UP || context.getClickLocation().y - (double)pos.getY() <= 0.5D) ? botState : topState; }
		}
		
		else {
			return direction != Direction.DOWN && (direction == Direction.UP || context.getClickLocation().y - (double)pos.getY() <= 0.5D) ? botState : topState;
		}
	}

	/* Replace to DOUBLE. boolean t/f */
	@Override
	public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
		ItemStack stack = context.getItemInHand();
		TatamiType slabType = state.getValue(TYPE);

		if ((slabType == TatamiType.TOP || slabType == TatamiType.BOTTOM) && stack.getItem() == this.asItem()) {

			if (context.replacingClickedOnBlock()) {
				boolean flag = context.getClickLocation().y - (double)context.getClickedPos().getY() > 0.5D;
				Direction direction = context.getClickedFace();

				if (slabType == TatamiType.BOTTOM) { return direction == Direction.UP || flag && direction.getAxis().isHorizontal(); }

				else { return direction == Direction.DOWN || !flag && direction.getAxis().isHorizontal(); }
			}
			else { return true; }
		}
		else { return false; }
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
	
	/* Waterlogged */
	@SuppressWarnings("deprecation")
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}
	
	@Override
	public boolean placeLiquid(LevelAccessor worldIn, BlockPos pos, BlockState state, FluidState fluid) {
		return (state.getValue(TYPE) == TatamiType.TOP || state.getValue(TYPE) == TatamiType.BOTTOM) ? SimpleWaterloggedBlock.super.placeLiquid(worldIn, pos, state, fluid) : false;
	}

	@Override
	public boolean canPlaceLiquid(@Nullable Player playerIn, BlockGetter worldIn, BlockPos pos, BlockState state, Fluid fluid) {
		return (state.getValue(TYPE) == TatamiType.TOP || state.getValue(TYPE) == TatamiType.BOTTOM) ? SimpleWaterloggedBlock.super.canPlaceLiquid(playerIn, worldIn, pos, state, fluid) : false;
	}
	
	@Override
	public ItemStack pickupBlock(@Nullable Player playerIn, LevelAccessor worldIn, BlockPos pos, BlockState state) {
		if (state.getValue(BlockStateProperties.WATERLOGGED)) {
			worldIn.setBlock(pos, state.setValue(BlockStateProperties.WATERLOGGED, Boolean.valueOf(false)), 3);
			
			if (!state.canSurvive(worldIn, pos)) { worldIn.destroyBlock(pos, true); }
			return new ItemStack(Items.WATER_BUCKET);
		}
		
		else { return ItemStack.EMPTY; }
	} // fix 20.2
	
	@Override
	public Optional<SoundEvent> getPickupSound() {
		return Fluids.WATER.getPickupSound();
	}

	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos pos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			worldIn.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }
		
		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}

	@Override
	public boolean isPathfindable(BlockState state, BlockGetter worldIn, BlockPos pos, PathComputationType type) {
		switch (type) {
		case LAND:
			return false;
		case WATER:
			return worldIn.getFluidState(pos).is(FluidTags.WATER);
		case AIR:
			return false;
		default:
			return false;
		}
	}
	
	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(H_FACING, TYPE, WATERLOGGED);
	}
	
	@Override
	public boolean useShapeForLightOcclusion(BlockState state) {
		return (state.getValue(TYPE) == TatamiType.TOP || state.getValue(TYPE) == TatamiType.BOTTOM);
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		TatamiType slabType = state.getValue(TYPE);
		switch (slabType) {
		case TOP:
			return AABB_TOP;
		case BOTTOM:
		default:
			return AABB_BOTTOM;
		case DOUBLE:
		case OAK:
		case SPRUCE:
		case BIRCH:
		case JUNGLE:
		case ACACIA:
		case DARKOAK:
		case SAKURA:
		case KAEDE:
		case ICHOH:
			return Shapes.block();
		}
	}
	
	/* Flammable Block */
	@Override
	public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction direct) { return true; }

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction direct) { return 5; }

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction direct) { return 20; }
	
	/* ToolTip */
	@Override
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.block_tatami").withStyle(ChatFormatting.GRAY));
	}
}
