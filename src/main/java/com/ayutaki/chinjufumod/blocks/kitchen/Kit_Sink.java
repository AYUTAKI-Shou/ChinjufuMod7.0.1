package com.ayutaki.chinjufumod.blocks.kitchen;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IBucketPickupHandler;
import net.minecraft.block.ILiquidContainer;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.material.PushReaction;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tags.FluidTags;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

public class Kit_Sink extends Block implements IWaterLoggable, IBucketPickupHandler, ILiquidContainer {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final EnumProperty<DoubleBlockHalf> HALF = EnumProperty.create("half", DoubleBlockHalf.class);
	public static final BooleanProperty LIT = BooleanProperty.create("lit");
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");

	/* Collision */
	protected static final VoxelShape TOP_SOUTH = VoxelShapes.or(Block.box(3.5D, 0.0D, 2.5D, 5.5D, 1.0D, 4.5D), 
			Block.box(10.5D, 0.0D, 2.5D, 12.5D, 1.0D, 4.5D));
	protected static final VoxelShape TOP_WEST = VoxelShapes.or(Block.box(11.5D, 0.0D, 3.5D, 13.5D, 1.0D, 5.5D), 
			Block.box(11.5D, 0.0D, 10.5D, 13.5D, 1.0D, 12.5D));
	protected static final VoxelShape TOP_NORTH = VoxelShapes.or(Block.box(3.5D, 0.0D, 11.5D, 5.5D, 1.0D, 13.5D), 
			Block.box(10.5D, 0.0D, 11.5D, 12.5D, 1.0D, 13.5D));
	protected static final VoxelShape TOP_EAST = VoxelShapes.or(Block.box(2.5D, 0.0D, 3.5D, 4.5D, 1.0D, 5.5D), 
			Block.box(2.5D, 0.0D, 10.5D, 4.5D, 1.0D, 12.5D));

	protected static final VoxelShape BASE = Block.box(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape BOT_SOUTH = VoxelShapes.or(BASE, Block.box(0.0D, 0.0D, 1.0D, 16.0D, 15.0D, 15.0D));
	protected static final VoxelShape BOT_WEST = VoxelShapes.or(BASE, Block.box(1.0D, 0.0D, 0.0D, 15.0D, 15.0D, 16.0D));
	protected static final VoxelShape BOT_NORTH = VoxelShapes.or(BASE, Block.box(0.0D, 0.0D, 1.0D, 16.0D, 15.0D, 15.0D));
	protected static final VoxelShape BOT_EAST = VoxelShapes.or(BASE, Block.box(1.0D, 0.0D, 0.0D, 15.0D, 15.0D, 16.0D));

	public Kit_Sink(AbstractBlock.Properties properties) {
		super(properties);

		/** Default state **/
		registerDefaultState(this.defaultBlockState().setValue(H_FACING, Direction.NORTH)
				.setValue(HALF, DoubleBlockHalf.LOWER)
				.setValue(LIT, Boolean.valueOf(false))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		boolean lit = state.getValue(LIT);

		if (lit != true) {
			/** Hand is empty. **/
			if (stack.isEmpty()) {
				if (state.getValue(HALF) == DoubleBlockHalf.LOWER) {
					if (hasWater2(worldIn, pos) && state.getValue(WATERLOGGED) != true) {
						worldIn.playSound(null, pos, SoundEvents_CM.WATER_START, SoundCategory.BLOCKS, 1.0F, 1.0F);
						worldIn.setBlock(pos, state.setValue(LIT, Boolean.valueOf(true)), 3); }
					
					if (!hasWater2(worldIn, pos) || state.getValue(WATERLOGGED) == true) {
						CMEvents.soundTouchBlock(worldIn, pos); } }
				
				if (state.getValue(HALF) == DoubleBlockHalf.UPPER) {
					if (hasWater3(worldIn, pos) && state.getValue(WATERLOGGED) != true) {
						worldIn.playSound(null, pos, SoundEvents_CM.WATER_START, SoundCategory.BLOCKS, 1.0F, 1.0F);
						worldIn.setBlock(pos, state.setValue(LIT, Boolean.valueOf(true)), 3); }
					
					if (!hasWater3(worldIn, pos) || state.getValue(WATERLOGGED) == true) {
						CMEvents.soundTouchBlock(worldIn, pos); } }
			}
			
			/** Hand is not empty. **/
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
			
			return ActionResultType.SUCCESS;
		}
		
		if (lit == true) {
			/*水を止める*/
			if (stack.isEmpty()) {
				worldIn.playSound(null, pos, SoundEvents_CM.WATER_STOP, SoundCategory.BLOCKS, 1.0F, 1.0F);
				worldIn.setBlock(pos, state.setValue(LIT, Boolean.valueOf(false)), 3);
				return ActionResultType.SUCCESS;
			}

			if (!stack.isEmpty()) {
				/*水を汲む */
				if (item == Items.GLASS_BOTTLE) {
					CMEvents.Consume1Item_Bottle(worldIn, pos, playerIn, hand);

					ItemStack stack4 = PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER);
					if (stack.isEmpty()) { playerIn.setItemInHand(hand, stack4); }
					else if (!playerIn.inventory.add(stack4)) { playerIn.drop(stack4, false); }
					
					return ActionResultType.SUCCESS; }
	
				/* TTimeItems シンク台は真水のため土鍋は除外 */
				if (item == Items_Teatime.MIZUOKE) {
					CMEvents.Consume1Item_Bowl(worldIn, pos, playerIn, hand);
					
					if (stack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items_Teatime.MIZUOKE_full)); }
					else if (!playerIn.inventory.add(new ItemStack(Items_Teatime.MIZUOKE_full))) {
						playerIn.drop(new ItemStack(Items_Teatime.MIZUOKE_full), false); }
					
					return ActionResultType.SUCCESS; }
	
				if (item == Items_Teatime.KETTLE_kara) {
					CMEvents.Consume1Item_Bowl(worldIn, pos, playerIn, hand);
					
					if (stack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items_Teatime.KETTLE_full)); }
					else if (!playerIn.inventory.add(new ItemStack(Items_Teatime.KETTLE_full))) {
						playerIn.drop(new ItemStack(Items_Teatime.KETTLE_full), false); }
					
					return ActionResultType.SUCCESS; }
	
				if (item == Items_Teatime.ZUNDOU) {
					CMEvents.Consume1Item_Bowl(worldIn, pos, playerIn, hand);
					
					if (stack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items_Teatime.ZUNDOU_MIZU)); }
					else if (!playerIn.inventory.add(new ItemStack(Items_Teatime.ZUNDOU_MIZU))) {
						playerIn.drop(new ItemStack(Items_Teatime.ZUNDOU_MIZU), false); }
					
					return ActionResultType.SUCCESS; }
	
				if (item == Items_Teatime.KEIRYO_CUP) {
					CMEvents.Consume1Item_Bottle(worldIn, pos, playerIn, hand);
					
					if (stack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items_Teatime.KEIRYO_CUP_full)); }
					else if (!playerIn.inventory.add(new ItemStack(Items_Teatime.KEIRYO_CUP_full))) {
						playerIn.drop(new ItemStack(Items_Teatime.KEIRYO_CUP_full), false); }
					
					return ActionResultType.SUCCESS; }
	
				/* シンク台は真水のため土鍋は除外 */
				if (item == Items_Teatime.NABE_kara) {
					CMEvents.textNotHave(worldIn, pos, playerIn);
					return ActionResultType.SUCCESS; }
			}
		}

		/* Items.BUCKET で水を汲むため、上記以外は PASS */
		return ActionResultType.PASS;
	}

	/* Gives a value when placed. */
	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);

		/** pos.up() = Replaceable block. **/
		if (pos.getY() < 255 && worldIn.getBlockState(pos.above()).canBeReplaced(context)) {
			return this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection().getOpposite())
					.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER))
					.setValue(LIT, Boolean.valueOf(false)).setValue(HALF, DoubleBlockHalf.LOWER); }

		else { return null; }
	}

	/* Add DoubleBlockHalf.UPPER on the Block. */
	public void setPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		FluidState fluidUp = worldIn.getFluidState(pos.above());

		worldIn.setBlock(pos.above(), this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER).setValue(H_FACING, state.getValue(H_FACING))
				.setValue(WATERLOGGED, Boolean.valueOf(fluidUp.getType() == Fluids.WATER)), 3);
	}

	/* Limit the place. */
	public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
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

	@OnlyIn(Dist.CLIENT)
	public long getSeed(BlockState state, BlockPos pos) {
		return MathHelper.getSeed(pos.getX(), pos.below(state.getValue(HALF) == DoubleBlockHalf.LOWER ? 0 : 1).getY(), pos.getZ());
	}
	
	/* Waterlogged */
	@SuppressWarnings("deprecation")
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}
	
	/* block.IBucketPickupHandler Items.BUCKET など Fluids.WATER の有るアイテムで水を汲む */
	@Override
	public Fluid takeLiquid(IWorld worldIn, BlockPos pos, BlockState state) {
		boolean lit = state.getValue(LIT);
		boolean water = state.getValue(BlockStateProperties.WATERLOGGED);

		if (lit == true && water == true) { return Fluids.WATER; }
		if (lit == true && water != true) { return Fluids.WATER; }
		if (lit != true && water == true) {
			worldIn.setBlock(pos, state.setValue(BlockStateProperties.WATERLOGGED, Boolean.valueOf(false)), 3);
			return Fluids.WATER; }
		else { return Fluids.EMPTY; }
	}
	
	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {

		BlockState state1 = super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
		if (!state1.isAir(worldIn, pos)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
		}

		DoubleBlockHalf half = state.getValue(HALF);
		if (facing.getAxis() == Direction.Axis.Y && half == DoubleBlockHalf.LOWER == (facing == Direction.UP)) {
			return facingState.getBlock() == this && facingState.getValue(HALF) != half ? state.setValue(H_FACING, facingState.getValue(H_FACING))
					.setValue(LIT, facingState.getValue(LIT)) : Blocks.AIR.defaultBlockState();
		}
		else {
			return half == DoubleBlockHalf.LOWER && facing == Direction.DOWN && !state.canSurvive(worldIn, pos) ? Blocks.AIR
					.defaultBlockState() : super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
		}
	}

	/* TickRandom */
	private static boolean hasWater2(World worldIn, BlockPos pos) {
		BlockState downState2 = worldIn.getBlockState(pos.below(2));
		Block downBlock2 = downState2.getBlock();
		return (downBlock2 == Blocks.WATER);
	}

	private static boolean hasWater3(World worldIn, BlockPos pos) {
		BlockState downState3 = worldIn.getBlockState(pos.below(3));
		Block downBlock3 = downState3.getBlock();
		return (downBlock3 == Blocks.WATER);
	}
	
	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		if (state.getValue(LIT) == true && !hasWater2(worldIn, pos) && !hasWater3(worldIn, pos)) { 
			worldIn.setBlock(pos, state.setValue(LIT, Boolean.valueOf(false)), 3); }
		
		else { }
	}
	
	/* Conditions for TickRandom. */
	@SuppressWarnings("deprecation")
	public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block block, BlockPos pos2, boolean flag) {
		if (state.getValue(HALF) == DoubleBlockHalf.LOWER) {
			if (!worldIn.getFluidState(pos.below(2)).is(FluidTags.WATER)) {
				worldIn.setBlock(pos, state.setValue(LIT, Boolean.valueOf(false)), 3); }
		}
		super.neighborChanged(state, worldIn, pos, block, pos2, flag);
	}

	/* Destroy a DoubleBlock from DoublePlantBlock.class */
	public void playerWillDestroy(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {

		if (!worldIn.isClientSide) {
			if (playerIn.isCreative()) { breakLowerPart(worldIn, pos, state, playerIn); }
			else { dropResources(state, worldIn, pos, (TileEntity)null, playerIn, playerIn.getMainHandItem()); }
		}
		super.playerWillDestroy(worldIn, pos, state, playerIn);
	}

	public void playerDestroy(World worldIn, PlayerEntity playerIn, BlockPos pos, BlockState state, @Nullable TileEntity te, ItemStack stack) {
		super.playerDestroy(worldIn, playerIn, pos, Blocks.AIR.defaultBlockState(), te, stack);
	}

	protected static void breakLowerPart(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {
		DoubleBlockHalf half = state.getValue(HALF);
		if (half == DoubleBlockHalf.UPPER) {
			BlockPos downPos = pos.below();
			BlockState downState = worldIn.getBlockState(downPos);

			if (downState.getBlock() == state.getBlock() && downState.getValue(HALF) == DoubleBlockHalf.LOWER) {
				worldIn.setBlock(downPos, Blocks.AIR.defaultBlockState(), 35);
				worldIn.levelEvent(playerIn, 2001, downPos, Block.getId(downState));
			}
		}
	}

	public PushReaction getPistonPushReaction(BlockState state) {
		return PushReaction.DESTROY;
	}

	/* Create Blockstate */
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(HALF, H_FACING, LIT, WATERLOGGED);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
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
	
	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_kit_sink").withStyle(TextFormatting.GRAY));
	}
}
