package com.ayutaki.chinjufumod.blocks.crop;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_NoTab;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Pepper extends CM_WaterLogged {

	/* Property 0 1 2 3 4, 5 6 7 */
	public static final IntegerProperty STAGE_0_7 = IntegerProperty.create("stage", 0, 7);
	public static final EnumProperty<DoubleBlockHalf> HALF = EnumProperty.create("half", DoubleBlockHalf.class);
	
	/* Collision */
	protected static final VoxelShape AABB_BASE = Block.box(7.5D, 0.0D, 7.5D, 8.5D, 16.0D, 8.5D);
	protected static final VoxelShape BOT_0 = Shapes.or(AABB_BASE, Block.box(5.5D, 0.0D, 5.5D, 10.5D, 12.0D, 10.5D));
	protected static final VoxelShape BOT_3 = Shapes.or(AABB_BASE, Block.box(3.5D, 0.0D, 3.5D, 12.5D, 16.0D, 12.5D));
	protected static final VoxelShape BOT_7 = Shapes.or(AABB_BASE, Block.box(2.5D, 0.0D, 2.5D, 13.5D, 16.0D, 13.5D));
	protected static final VoxelShape AABB_TOP = Block.box(7.5D, 0.0D, 7.5D, 8.5D, 8.0D, 8.5D);
	protected static final VoxelShape TOP_3 = Block.box(4.5D, 0.0D, 4.5D, 11.5D, 4.0D, 11.5D);
	protected static final VoxelShape TOP_7 = Block.box(3.5D, 0.0D, 3.5D, 12.5D, 8.0D, 12.5D);

	public Pepper(BlockBehaviour.Properties properties) {
		super(properties);
		registerDefaultState(this.stateDefinition.any().setValue(STAGE_0_7, Integer.valueOf(0))
				.setValue(HALF, DoubleBlockHalf.LOWER)
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}
	
	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		int i = state.getValue(STAGE_0_7);
		/** Property 0 1 2 3 4, 5 6 7 **/
		
		BlockState lowFace = this.defaultBlockState().setValue(HALF, DoubleBlockHalf.LOWER);
		BlockState upFace = this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER);
		
		/** Too early to collect **/
		if (i < 6 && state.getValue(HALF) == DoubleBlockHalf.LOWER) {
			
			if (item == Items.BONE_MEAL) {
				CMEvents.Use_BoneMeal(worldIn, pos, playerIn, hand);
	
				for(int n = 0; n < 15; ++n) {
					double d0 = worldIn.random.nextGaussian() * 0.02D;
					double d1 = worldIn.random.nextGaussian() * 0.02D;
					double d2 = worldIn.random.nextGaussian() * 0.02D;
					worldIn.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + worldIn.random.nextFloat(), pos.getY() +worldIn.random.nextFloat(), pos.getZ() + worldIn.random.nextFloat(), d0, d1, d2); }
				
				worldIn.setBlock(pos, lowFace.setValue(STAGE_0_7, Integer.valueOf(i + 2)), 3);
				worldIn.setBlock(pos.above(), upFace.setValue(STAGE_0_7, Integer.valueOf(i + 2)), 3);
			}
			
			if (item != Items.BONE_MEAL) {
				if (!stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (stack.isEmpty()) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }	
			}
		}
	
		/** Can harvest **/
		if (i >= 6 && state.getValue(HALF) == DoubleBlockHalf.LOWER) {
			if (stack.isEmpty()) {

				CMEvents.soundTake_Pick(worldIn, pos);
				playerIn.getInventory().add(new ItemStack(Items_Teatime.PEPPER_RAW.get(), 4));
	
				worldIn.setBlock(pos, lowFace.setValue(STAGE_0_7, Integer.valueOf(4)), 3);
				worldIn.setBlock(pos.above(), upFace.setValue(STAGE_0_7, Integer.valueOf(4)), 3); }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		/** SUCCESS to not put anything on top. **/
		return InteractionResult.SUCCESS;
	}
	
	/* Limit the place. */
	@SuppressWarnings("deprecation")
	protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return (state.is(BlockTags.DIRT) && state.isSolid() && !state.is(BlockTags.ANIMALS_SPAWNABLE_ON));
	}
	
	@Override
	public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
		BlockPos downPos = pos.below();
		return this.mayPlaceOn(worldIn.getBlockState(downPos), worldIn, downPos);
	}
	
	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		Level worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);

		float temp = worldIn.getBiome(pos).value().getBaseTemperature();
		Player playerIn = context.getPlayer();
		
		if (temp >= 0.5F) {
			/** pos.up() = Replaceable block. **/
			if (pos.getY() < worldIn.getMaxBuildHeight() - 1 && worldIn.getBlockState(pos.above()).canBeReplaced(context)) {
				return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)); }
	
			else { return null; }
		}
	
		else {
			playerIn.displayClientMessage(Component.translatable("text.chinjufumod.too_cold"), true);
			return null; }
	}
	
	/* Add DoubleBlockHalf.UPPER on the Block. */
	public void setPlacedBy(Level worldIn, BlockPos pos, BlockState state, LivingEntity entityIn, ItemStack stack) {
		FluidState fluidUp = worldIn.getFluidState(pos.above());

		worldIn.setBlock(pos.above(), this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER)
				.setValue(WATERLOGGED, Boolean.valueOf(fluidUp.getType() == Fluids.WATER)), 3);
	}
	
	public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
		return false;
	}
	
	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos pos, BlockPos facingPos) {
		BlockState state1 = super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
		if (!state1.isAir()) {
			worldIn.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }

		DoubleBlockHalf half = state.getValue(HALF);
		if (facing.getAxis() != Direction.Axis.Y || half == DoubleBlockHalf.LOWER != (facing == Direction.UP) ||
				 facingState.getBlock() == this && facingState.getValue(HALF) != half) {
			return (half == DoubleBlockHalf.LOWER && facing == Direction.DOWN && !state.canSurvive(worldIn, pos)) ?
					 Blocks.AIR.defaultBlockState() : super.updateShape(state, facing, facingState, worldIn, pos, facingPos); }

		else { return Blocks.AIR.defaultBlockState(); }
	}

	/* TickRandom */
	@SuppressWarnings("deprecation")
	public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {

		BlockState upState = worldIn.getBlockState(pos.above());
		DoubleBlockHalf half = state.getValue(HALF);
		int i = state.getValue(STAGE_0_7);
		/** Property 0 1 2 3 4, 5 6 7 **/
		
		BlockState lowFace = this.defaultBlockState().setValue(HALF, DoubleBlockHalf.LOWER);
		BlockState upFace = this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER);
		
		if (!worldIn.isAreaLoaded(pos, 2)) { return; }

		switch (half) {
		case LOWER:
		default:
			float temp = worldIn.getBiome(pos).value().getBaseTemperature();
			boolean water = (state.getValue(WATERLOGGED) || upState.getValue(WATERLOGGED));
			
			if (temp >= 0.5F) {
				
				if (!water) {
					if (i < 7 && worldIn.getRawBrightness(pos, 0) >= 9 && rand.nextInt(8) == 0) {
						worldIn.setBlock(pos, lowFace.setValue(STAGE_0_7, Integer.valueOf(i + 1)), 3);
						worldIn.setBlock(pos.above(), upFace.setValue(STAGE_0_7, Integer.valueOf(i + 1)), 3); }
			
					if (i == 7) { } }//It is not Waterlogged.
				
				if (water) {
					if (i > 4 && rand.nextInt(2) == 0) {
						worldIn.setBlock(pos, lowFace.setValue(STAGE_0_7, Integer.valueOf(4)), 3);
						worldIn.setBlock(pos.above(), upFace.setValue(STAGE_0_7, Integer.valueOf(4)), 3);
						this.dropRottenfood(worldIn, pos); }
					
					else { } }
			}
			
			if (temp < 0.5F && rand.nextInt(1) == 0) {
				worldIn.destroyBlock(pos, true);
				worldIn.destroyBlock(pos.above(), false); }
			break;

		case UPPER: break;
		} // switch
	}
	
	protected void dropRottenfood(ServerLevel worldIn, BlockPos pos) {
		ItemStack stack = new ItemStack(Items_NoTab.ROTTEN_FOOD.get());
		Containers.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		int i = state.getValue(STAGE_0_7);
		boolean half = (state.getValue(HALF) == DoubleBlockHalf.UPPER);
		
		switch (i) {
		case 0 :
		default :
		case 1 : return (half)? AABB_TOP : BOT_0;
		case 2 : return (half)? AABB_TOP : BOT_3;
		case 3 : return (half)? TOP_3 : BOT_3;
		case 4 :
		case 5 :
		case 6 :
		case 7 : return (half)? TOP_7 : BOT_7;
		} // // STAGE0_7
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
	
	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(STAGE_0_7, HALF, WATERLOGGED);
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.SEEDS_PEPPER.get());
	}

	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}
	
	/* ToolTip */
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.item_seeds_pepper").withStyle(ChatFormatting.GRAY));
	}
}
