package com.ayutaki.chinjufumod.blocks.kitchen;

import java.util.List;
import java.util.Optional;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Kit_Sink extends Block implements SimpleWaterloggedBlock {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final EnumProperty<DoubleBlockHalf> HALF = EnumProperty.create("half", DoubleBlockHalf.class);
	public static final BooleanProperty LIT = BooleanProperty.create("lit");
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");

	/* Collision */
	protected static final VoxelShape TOP_SOUTH = Shapes.or(Block.box(3.5D, 0.0D, 2.5D, 5.5D, 1.0D, 4.5D), 
			Block.box(10.5D, 0.0D, 2.5D, 12.5D, 1.0D, 4.5D));
	protected static final VoxelShape TOP_WEST = Shapes.or(Block.box(11.5D, 0.0D, 3.5D, 13.5D, 1.0D, 5.5D), 
			Block.box(11.5D, 0.0D, 10.5D, 13.5D, 1.0D, 12.5D));
	protected static final VoxelShape TOP_NORTH = Shapes.or(Block.box(3.5D, 0.0D, 11.5D, 5.5D, 1.0D, 13.5D), 
			Block.box(10.5D, 0.0D, 11.5D, 12.5D, 1.0D, 13.5D));
	protected static final VoxelShape TOP_EAST = Shapes.or(Block.box(2.5D, 0.0D, 3.5D, 4.5D, 1.0D, 5.5D), 
			Block.box(2.5D, 0.0D, 10.5D, 4.5D, 1.0D, 12.5D));

	protected static final VoxelShape BASE = Block.box(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape BOT_SOUTH = Shapes.or(BASE, Block.box(0.0D, 0.0D, 1.0D, 16.0D, 15.0D, 15.0D));
	protected static final VoxelShape BOT_WEST = Shapes.or(BASE, Block.box(1.0D, 0.0D, 0.0D, 15.0D, 15.0D, 16.0D));
	protected static final VoxelShape BOT_NORTH = Shapes.or(BASE, Block.box(0.0D, 0.0D, 1.0D, 16.0D, 15.0D, 15.0D));
	protected static final VoxelShape BOT_EAST = Shapes.or(BASE, Block.box(1.0D, 0.0D, 0.0D, 15.0D, 15.0D, 16.0D));

	public Kit_Sink(BlockBehaviour.Properties properties) {
		super(properties);
		/** Default state **/
		registerDefaultState(this.stateDefinition.any().setValue(H_FACING, Direction.NORTH)
				.setValue(HALF, DoubleBlockHalf.LOWER)
				.setValue(LIT, Boolean.valueOf(false))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		boolean lit = state.getValue(LIT);

		if (lit != true) {
			/** Hand is empty. **/
			if (stack.isEmpty()) {
				if (state.getValue(HALF) == DoubleBlockHalf.LOWER) {
					if (hasWater2(worldIn, pos) && state.getValue(WATERLOGGED) != true) {
						worldIn.playSound(null, pos, SoundEvents_CM.WATER_START.get(), SoundSource.BLOCKS, 1.0F, 1.0F);
						worldIn.setBlock(pos, state.setValue(LIT, Boolean.valueOf(true)), 3); }
					
					if (!hasWater2(worldIn, pos) || state.getValue(WATERLOGGED) == true) {
						CMEvents.soundTouchBlock(worldIn, pos); } }
				
				if (state.getValue(HALF) == DoubleBlockHalf.UPPER) {
					if (hasWater3(worldIn, pos) && state.getValue(WATERLOGGED) != true) {
						worldIn.playSound(null, pos, SoundEvents_CM.WATER_START.get(), SoundSource.BLOCKS, 1.0F, 1.0F);
						worldIn.setBlock(pos, state.setValue(LIT, Boolean.valueOf(true)), 3); }
					
					if (!hasWater3(worldIn, pos) || state.getValue(WATERLOGGED)== true) {
						CMEvents.soundTouchBlock(worldIn, pos); } }
			}
			
			/** Hand is not empty. **/
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
			
			return InteractionResult.SUCCESS;
		}
		
		if (lit == true) {
			/*水を止める*/
			if (stack.isEmpty()) {
				worldIn.playSound(null, pos, SoundEvents_CM.WATER_STOP.get(), SoundSource.BLOCKS, 1.0F, 1.0F);
				worldIn.setBlock(pos, state.setValue(LIT, Boolean.valueOf(false)), 3);
				return InteractionResult.SUCCESS;
			}

			if (!stack.isEmpty()) {
				/*水を汲む */
				if (item == Items.GLASS_BOTTLE) {
					CMEvents.Consume1Item_Bottle(worldIn, pos, playerIn, hand);

					ItemStack stack4 = PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER);
					if (stack.isEmpty()) { playerIn.setItemInHand(hand, stack4); }
					else if (!playerIn.getInventory().add(stack4)) { playerIn.drop(stack4, false); }
					
					return InteractionResult.SUCCESS; }
	
				/* TTimeItems シンク台は真水のため土鍋は除外 */
				if (item == Items_Teatime.MIZUOKE.get()) {
					CMEvents.Consume1Item_Bowl(worldIn, pos, playerIn, hand);
					
					if (stack.isEmpty()) { playerIn.getInventory().add(new ItemStack(Items_Teatime.MIZUOKE_full.get())); }
					else if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.MIZUOKE_full.get()))) {
						playerIn.drop(new ItemStack(Items_Teatime.MIZUOKE_full.get()), false); }
					
					return InteractionResult.SUCCESS; }
	
				if (item == Items_Teatime.KETTLE_kara.get()) {
					CMEvents.Consume1Item_Bowl(worldIn, pos, playerIn, hand);
					
					if (stack.isEmpty()) { playerIn.getInventory().add(new ItemStack(Items_Teatime.KETTLE_full.get())); }
					else if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.KETTLE_full.get()))) {
						playerIn.drop(new ItemStack(Items_Teatime.KETTLE_full.get()), false); }
					
					return InteractionResult.SUCCESS; }
	
				if (item == Items_Teatime.ZUNDOU.get()) {
					CMEvents.Consume1Item_Bowl(worldIn, pos, playerIn, hand);
					
					if (stack.isEmpty()) { playerIn.getInventory().add(new ItemStack(Items_Teatime.ZUNDOU_MIZU.get())); }
					else if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.ZUNDOU_MIZU.get()))) {
						playerIn.drop(new ItemStack(Items_Teatime.ZUNDOU_MIZU.get()), false); }
					
					return InteractionResult.SUCCESS; }
	
				if (item == Items_Teatime.KEIRYO_CUP.get()) {
					CMEvents.Consume1Item_Bottle(worldIn, pos, playerIn, hand);
					
					if (stack.isEmpty()) { playerIn.getInventory().add(new ItemStack(Items_Teatime.KEIRYO_CUP_full.get())); }
					else if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.KEIRYO_CUP_full.get()))) {
						playerIn.drop(new ItemStack(Items_Teatime.KEIRYO_CUP_full.get()), false); }
					
					return InteractionResult.SUCCESS; }
	
				/* シンク台は真水のため土鍋は除外 */
				if (item == Items_Teatime.NABE_kara.get()) {
					CMEvents.textNotHave(worldIn, pos, playerIn);
					return InteractionResult.SUCCESS; }
			}
		}

		/* Items.BUCKET で水を汲むため、上記以外は PASS */		
		return InteractionResult.PASS;
	}
	
	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		Level worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);
	
		/** pos.up() = Replaceable block. **/
		if (pos.getY() < worldIn.getMaxBuildHeight() - 1 && worldIn.getBlockState(pos.above()).canBeReplaced(context)) {
			return this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection().getOpposite())
					.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER))
					.setValue(LIT, Boolean.valueOf(false)).setValue(HALF, DoubleBlockHalf.LOWER);
		}

		else { return null; }
	}
	
	/* Add DoubleBlockHalf.UPPER on the Block. */
	public void setPlacedBy(Level worldIn, BlockPos pos, BlockState state, LivingEntity entityIn, ItemStack stack) {
		FluidState fluidUp = worldIn.getFluidState(pos.above());
		worldIn.setBlock(pos.above(), this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER)
				.setValue(H_FACING, state.getValue(H_FACING))
				.setValue(WATERLOGGED, Boolean.valueOf(fluidUp.getType() == Fluids.WATER)), 3);
	}
	
	/* Limit the place. */
	public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
		BlockPos downPos = pos.below();
		BlockState downState = worldIn.getBlockState(downPos);

		/** Lower part is true. **/
		if (state.getValue(HALF) == DoubleBlockHalf.LOWER) { return true; }

		/** Upper part is this block. **/
		else { return downState.getBlock() == this; }
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

	/* Items.BUCKET など Fluids.WATER の有るアイテムで水を汲む */
	@Override
	public ItemStack pickupBlock(@Nullable Player playerIn, LevelAccessor worldIn, BlockPos pos, BlockState state) {
		boolean lit = state.getValue(LIT);
		boolean water = state.getValue(BlockStateProperties.WATERLOGGED);
		
		if (lit == true && water == true) { return new ItemStack(Items.WATER_BUCKET); }
		if (lit == true && water != true) { return new ItemStack(Items.WATER_BUCKET); }
		if (lit != true && water == true) {
			worldIn.setBlock(pos, state.setValue(BlockStateProperties.WATERLOGGED, Boolean.valueOf(false)), 3);
			return new ItemStack(Items.WATER_BUCKET); }
		
		else { return ItemStack.EMPTY; }
	}
	
	@Override
	public Optional<SoundEvent> getPickupSound() {
		return Fluids.WATER.getPickupSound();
	}
	
	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos pos, BlockPos facingPos) {
		BlockState state1 = super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
		if (!state1.isAir()) {
			worldIn.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }

		DoubleBlockHalf half = state.getValue(HALF);
		if (facing.getAxis() == Direction.Axis.Y && half == DoubleBlockHalf.LOWER == (facing == Direction.UP)) {
			return (facingState.getBlock() == this && facingState.getValue(HALF) != half) ? state.setValue(H_FACING, facingState.getValue(H_FACING))
					.setValue(LIT, facingState.getValue(LIT)) : Blocks.AIR.defaultBlockState();
		}
		else {
			return (half == DoubleBlockHalf.LOWER && facing == Direction.DOWN && !state.canSurvive(worldIn, pos)) ? Blocks.AIR
					.defaultBlockState() : super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
		}
	}
	
	/* TickRandom */
	private static boolean hasWater2(Level worldIn, BlockPos pos) {
		BlockState downState2 = worldIn.getBlockState(pos.below(2));
		Block downBlock2 = downState2.getBlock();
		return (downBlock2 == Blocks.WATER);
	}

	private static boolean hasWater3(Level worldIn, BlockPos pos) {
		BlockState downState3 = worldIn.getBlockState(pos.below(3));
		Block downBlock3 = downState3.getBlock();
		return (downBlock3 == Blocks.WATER);
	}

	@Override
	public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
		if (state.getValue(LIT) == true && !hasWater2(worldIn, pos) && !hasWater3(worldIn, pos)) { 
			worldIn.setBlock(pos, state.setValue(LIT, Boolean.valueOf(false)), 3); }
		
		else { }
	}
	
	/* Destroy a DoubleBlock from DoublePlantBlock.class */
	@Override
	public void playerWillDestroy(Level worldIn, BlockPos pos, BlockState state, Player playerIn) {
		if (!worldIn.isClientSide) {
			if (playerIn.isCreative()) { breakLowerPart(worldIn, pos, state, playerIn); } 
			
			else { dropResources(state, worldIn, pos, (BlockEntity)null, playerIn, playerIn.getMainHandItem()); }
		}
		super.playerWillDestroy(worldIn, pos, state, playerIn);
	}

	@Override
	public void playerDestroy(Level worldIn, Player playerIn, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack) {
		super.playerDestroy(worldIn, playerIn, pos, Blocks.AIR.defaultBlockState(), blockEntity, stack);
	}

	protected static void breakLowerPart(Level worldIn, BlockPos pos, BlockState state, Player playerIn) {
		DoubleBlockHalf half = state.getValue(HALF);
		if (half == DoubleBlockHalf.UPPER) {
			BlockPos downPos = pos.below();
			BlockState downState = worldIn.getBlockState(downPos);
			if (downState.is(state.getBlock()) && downState.getValue(HALF) == DoubleBlockHalf.LOWER) {
				BlockState downState1 = downState.hasProperty(BlockStateProperties.WATERLOGGED) && downState.getValue(BlockStateProperties.WATERLOGGED) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
				worldIn.setBlock(downPos, downState1, 35);
				worldIn.levelEvent(playerIn, 2001, downPos, Block.getId(downState)); }
		}
	}
	
	@Override
	public PushReaction getPistonPushReaction(BlockState state) {
		return PushReaction.DESTROY;
	}
	
	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(HALF, H_FACING, LIT, WATERLOGGED);
	}
	
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		Direction direction = state.getValue(H_FACING);
		DoubleBlockHalf half = state.getValue(HALF);
		
		switch (half) {
		case LOWER:
		default:
			
			switch (direction) {
			case NORTH:
			default: return BOT_NORTH;
			case SOUTH: return BOT_SOUTH;
			case WEST: return BOT_WEST;
			case EAST: return BOT_EAST;
			} // switch

		case UPPER:
			
			switch (direction) {
			case NORTH:
			default: return TOP_NORTH;
			case SOUTH: return TOP_SOUTH;
			case WEST: return TOP_WEST;
			case EAST: return TOP_EAST;
			} // switch
		} // switch LOWER-UPPER
	}

	/* ToolTip */
	@Override
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.block_kit_sink").withStyle(ChatFormatting.GRAY));
	}
}
