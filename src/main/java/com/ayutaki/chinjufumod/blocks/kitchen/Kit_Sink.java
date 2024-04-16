package com.ayutaki.chinjufumod.blocks.kitchen;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IBucketPickupHandler;
import net.minecraft.block.ILiquidContainer;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.material.PushReaction;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
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
	protected static final VoxelShape TOP_SOUTH = VoxelShapes.or(Block.makeCuboidShape(3.5D, 0.0D, 2.5D, 5.5D, 1.0D, 4.5D), 
			Block.makeCuboidShape(10.5D, 0.0D, 2.5D, 12.5D, 1.0D, 4.5D));
	protected static final VoxelShape TOP_WEST = VoxelShapes.or(Block.makeCuboidShape(11.5D, 0.0D, 3.5D, 13.5D, 1.0D, 5.5D), 
			Block.makeCuboidShape(11.5D, 0.0D, 10.5D, 13.5D, 1.0D, 12.5D));
	protected static final VoxelShape TOP_NORTH = VoxelShapes.or(Block.makeCuboidShape(3.5D, 0.0D, 11.5D, 5.5D, 1.0D, 13.5D), 
			Block.makeCuboidShape(10.5D, 0.0D, 11.5D, 12.5D, 1.0D, 13.5D));
	protected static final VoxelShape TOP_EAST = VoxelShapes.or(Block.makeCuboidShape(2.5D, 0.0D, 3.5D, 4.5D, 1.0D, 5.5D), 
			Block.makeCuboidShape(2.5D, 0.0D, 10.5D, 4.5D, 1.0D, 12.5D));

	protected static final VoxelShape BASE = Block.makeCuboidShape(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape BOT_SOUTH = VoxelShapes.or(BASE, Block.makeCuboidShape(0.0D, 0.0D, 1.0D, 16.0D, 15.0D, 15.0D));
	protected static final VoxelShape BOT_WEST = VoxelShapes.or(BASE, Block.makeCuboidShape(1.0D, 0.0D, 0.0D, 15.0D, 15.0D, 16.0D));
	protected static final VoxelShape BOT_NORTH = VoxelShapes.or(BASE, Block.makeCuboidShape(0.0D, 0.0D, 1.0D, 16.0D, 15.0D, 15.0D));
	protected static final VoxelShape BOT_EAST = VoxelShapes.or(BASE, Block.makeCuboidShape(1.0D, 0.0D, 0.0D, 15.0D, 15.0D, 16.0D));

	public Kit_Sink(Block.Properties properties) {
		super(properties);
		/** Default state **/
		setDefaultState(this.stateContainer.getBaseState().with(H_FACING, Direction.NORTH)
				.with(HALF, DoubleBlockHalf.LOWER)
				.with(LIT, Boolean.valueOf(false))
				.with(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		boolean lit = state.get(LIT);

		if (lit != true) {
			/** Hand is empty. **/
			if (stack.isEmpty()) {
				if (state.get(HALF) == DoubleBlockHalf.LOWER) {
					if (hasWater2(worldIn, pos) && state.get(WATERLOGGED) != true) {
						worldIn.playSound(null, pos, SoundEvents_CM.WATER_START, SoundCategory.BLOCKS, 1.0F, 1.0F);
						worldIn.setBlockState(pos, state.with(LIT, Boolean.valueOf(true))); }
					
					if (!hasWater2(worldIn, pos) || state.get(WATERLOGGED) == true) {
						CMEvents.soundTouchBlock(worldIn, pos); } }
				
				if (state.get(HALF) == DoubleBlockHalf.UPPER) {
					if (hasWater3(worldIn, pos) && state.get(WATERLOGGED) != true) {
						worldIn.playSound(null, pos, SoundEvents_CM.WATER_START, SoundCategory.BLOCKS, 1.0F, 1.0F);
						worldIn.setBlockState(pos, state.with(LIT, Boolean.valueOf(true))); }
					
					if (!hasWater3(worldIn, pos) || state.get(WATERLOGGED) == true) {
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
				worldIn.setBlockState(pos, state.with(LIT, Boolean.valueOf(false)));
				return ActionResultType.SUCCESS; }

			if (!stack.isEmpty()) {
				/*水を汲む */
				if (item == Items.GLASS_BOTTLE) {
					CMEvents.Consume1Item_Bottle(worldIn, pos, playerIn, hand);
					
					ItemStack stack4 = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.WATER);
					if (stack.isEmpty()) { playerIn.setHeldItem(hand, stack4); }
					else if (!playerIn.inventory.addItemStackToInventory(stack4)) {
						playerIn.dropItem(stack4, false); }
					
					return ActionResultType.SUCCESS; }
	
				/* TTimeItems シンク台は真水のため土鍋は除外 */
				if (item == Items_Teatime.MIZUOKE) {
					CMEvents.Consume1Item_Bowl(worldIn, pos, playerIn, hand);
					
					if (stack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MIZUOKE_full)); }
					else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MIZUOKE_full))) {
						playerIn.dropItem(new ItemStack(Items_Teatime.MIZUOKE_full), false); }
					
					return ActionResultType.SUCCESS; }
	
				if (item == Items_Teatime.KETTLE_kara) {
					CMEvents.Consume1Item_Bowl(worldIn, pos, playerIn, hand);
					
					if (stack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.KETTLE_full)); }
					else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.KETTLE_full))) {
						playerIn.dropItem(new ItemStack(Items_Teatime.KETTLE_full), false); }
					
					return ActionResultType.SUCCESS; }
	
				if (item == Items_Teatime.ZUNDOU) {
					CMEvents.Consume1Item_Bowl(worldIn, pos, playerIn, hand);
					
					if (stack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.ZUNDOU_MIZU)); }
					else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.ZUNDOU_MIZU))) {
						playerIn.dropItem(new ItemStack(Items_Teatime.ZUNDOU_MIZU), false); }
					
					return ActionResultType.SUCCESS; }
	
				if (item == Items_Teatime.KEIRYO_CUP) {
					CMEvents.Consume1Item_Bottle(worldIn, pos, playerIn, hand);
					
					if (stack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.KEIRYO_CUP_full)); }
					else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.KEIRYO_CUP_full))) {
						playerIn.dropItem(new ItemStack(Items_Teatime.KEIRYO_CUP_full), false); }
					
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
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getWorld();
		BlockPos pos = context.getPos();
		IFluidState fluid = worldIn.getFluidState(pos);

		/** pos.up() = Replaceable block. **/
		if (pos.getY() < 255 && worldIn.getBlockState(pos.up()).isReplaceable(context)) {
			return this.getDefaultState().with(H_FACING, context.getPlacementHorizontalFacing().getOpposite())
					.with(WATERLOGGED, fluid.getFluid() == Fluids.WATER)
					.with(LIT, Boolean.valueOf(false)).with(HALF, DoubleBlockHalf.LOWER); }

		else { return null; }
	}

	/* Add DoubleBlockHalf.UPPER on the Block. */
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		IFluidState fluidUp = worldIn.getFluidState(pos.up());

		worldIn.setBlockState(pos.up(), this.getDefaultState().with(HALF, DoubleBlockHalf.UPPER).with(H_FACING, state.get(H_FACING))
				.with(WATERLOGGED, Boolean.valueOf(fluidUp.isTagged(FluidTags.WATER))), 3);
	}

	/* Limit the place. */
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockPos downPos = pos.down();
		BlockState downState = worldIn.getBlockState(downPos);

		if (state.get(HALF) == DoubleBlockHalf.LOWER) { return true; }
		
		else { return downState.getBlock() == this; }
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

	@OnlyIn(Dist.CLIENT)
	public long getPositionRandom(BlockState state, BlockPos pos) {
		return MathHelper.getCoordinateRandom(pos.getX(), pos.down(state.get(HALF) == DoubleBlockHalf.LOWER ? 0 : 1).getY(), pos.getZ());
	}

	/* Waterlogged */
	@SuppressWarnings("deprecation")
	public IFluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}
	
	/* Items.BUCKET など Fluids.WATER の有るアイテムで水を汲む */
	@Override
	public Fluid pickupFluid(IWorld worldIn, BlockPos pos, BlockState state) {
		boolean lit = state.get(LIT);
		boolean water = state.get(BlockStateProperties.WATERLOGGED);

		if (lit == true && water == true) { return Fluids.WATER; }
		if (lit == true && water != true) { return Fluids.WATER; }
		if (lit != true && water == true) {
			worldIn.setBlockState(pos, state.with(BlockStateProperties.WATERLOGGED, Boolean.valueOf(false)), 3);
			return Fluids.WATER; }
		else { return Fluids.EMPTY; }
	}
	
	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {

		BlockState state1 = super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
		if (!state1.isAir(worldIn, pos)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn)); }

		DoubleBlockHalf half = state.get(HALF);
		if (facing.getAxis() == Direction.Axis.Y && half == DoubleBlockHalf.LOWER == (facing == Direction.UP)) {
			return facingState.getBlock() == this && facingState.get(HALF) != half ? state.with(H_FACING, facingState.get(H_FACING))
					.with(LIT, facingState.get(LIT)) : Blocks.AIR.getDefaultState();
		}
		else {
			return half == DoubleBlockHalf.LOWER && facing == Direction.DOWN && !state.isValidPosition(worldIn, pos) ? Blocks.AIR
					.getDefaultState() : super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
		}
	}

	/* TickRandom */
	private static boolean hasWater2(World worldIn, BlockPos pos) {
		BlockState downState2 = worldIn.getBlockState(pos.down(2));
		Block downBlock2 = downState2.getBlock();
		return (downBlock2 == Blocks.WATER);
	}

	private static boolean hasWater3(World worldIn, BlockPos pos) {
		BlockState downState3 = worldIn.getBlockState(pos.down(3));
		Block downBlock3 = downState3.getBlock();
		return (downBlock3 == Blocks.WATER);
	}

	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		if (state.get(LIT) == true && !hasWater2(worldIn, pos) && !hasWater3(worldIn, pos)) { 
			worldIn.setBlockState(pos, state.with(LIT, Boolean.valueOf(false))); }
		
		else { }
	}
	
	/* Destroy a DoubleBlock from DoublePlantBlock.class */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {
		DoubleBlockHalf half = state.get(HALF);
		BlockPos pos1 = half == DoubleBlockHalf.LOWER ? pos.up() : pos.down();
		BlockState state1 = worldIn.getBlockState(pos1);

		if (state1.getBlock() == this && state1.get(HALF) != half) {
			worldIn.setBlockState(pos1, Blocks.AIR.getDefaultState(), 35);
			worldIn.playEvent(playerIn, 2001, pos1, Block.getStateId(state1));

			ItemStack stack = playerIn.getHeldItemMainhand();
			if (!worldIn.isRemote && !playerIn.isCreative() && playerIn.canHarvestBlock(state1)) {
				Block.spawnDrops(state, worldIn, pos, (TileEntity)null, playerIn, stack);
				Block.spawnDrops(state1, worldIn, pos1, (TileEntity)null, playerIn, stack);
			}
		}
		super.onBlockHarvested(worldIn, pos, state, playerIn);
	}

	@Override
	public void harvestBlock(World worldIn, PlayerEntity playerIn, BlockPos pos, BlockState state, @Nullable TileEntity te, ItemStack stack) {
		super.harvestBlock(worldIn, playerIn, pos, Blocks.AIR.getDefaultState(), te, stack);
	}

	public PushReaction getPushReaction(BlockState state) {
		return PushReaction.DESTROY;
	}

	/* Create Blockstate */
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(HALF, H_FACING, LIT, WATERLOGGED);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(H_FACING);
		DoubleBlockHalf half = state.get(HALF);
		
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
	
	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_kit_sink").applyTextStyle(TextFormatting.GRAY));
	}
}
