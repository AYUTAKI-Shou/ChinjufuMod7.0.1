package com.ayutaki.chinjufumod.blocks.crop;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.registry.Crop_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Corn extends CropBlock {

	/* Property DoubleBlock */
	public static final EnumProperty<DoubleBlockHalf> HALF = EnumProperty.create("half", DoubleBlockHalf.class);
	public static final IntegerProperty AGE_0_7 = IntegerProperty.create("age", 0, 7);
	
	/* Collision */
	protected static final VoxelShape AABB_BOT_0 = Block.box(1.0D, -1.0D, 1.0D, 15.0D, 1.0D, 15.0D);
	protected static final VoxelShape AABB_BOT_1 = Block.box(2.0D, -1.0D, 2.0D, 14.0D, 1.0D, 14.0D);
	protected static final VoxelShape AABB_BOT_2 = Block.box(2.0D, -1.0D, 2.0D, 14.0D, 7.0D, 14.0D);
	protected static final VoxelShape AABB_BOT_3 = Block.box(2.0D, -1.0D, 2.0D, 14.0D, 11.0D, 14.0D);
	protected static final VoxelShape AABB_BOT_4 = Block.box(2.0D, -1.0D, 2.0D, 14.0D, 18.0D, 14.0D);
	protected static final VoxelShape AABB_BOT_5 = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 24.0D, 14.0D);
	protected static final VoxelShape AABB_BOT_6 = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 28.0D, 14.0D);

	protected static final VoxelShape AABB_BOT_7 = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);
	protected static final VoxelShape AABB_TOP_7 = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);

	public Corn(BlockBehaviour.Properties properties) {
		super(properties);
		registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER)
				.setValue(AGE_0_7, Integer.valueOf(0)));
	}
	
	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		Level worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();

		return (pos.getY() < worldIn.getMaxBuildHeight() - 1 && context.getLevel().getBlockState(pos.above()).canBeReplaced(context)) ?
				 super.getStateForPlacement(context) : null;
	}
	
	/* Add DoubleBlockHalf.UPPER on the Block. */
	@Override
	public void setPlacedBy(Level worldIn, BlockPos pos, BlockState state, LivingEntity entityIn, ItemStack stack) {
		worldIn.setBlock(pos.above(), this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER).setValue(AGE_0_7, Integer.valueOf(0)), 3);
	}
	
	/* Update BlockState. */
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos pos, BlockPos facingPos) {
		DoubleBlockHalf half = state.getValue(HALF);
		if (facing.getAxis() == Direction.Axis.Y && half == DoubleBlockHalf.LOWER == (facing == Direction.UP)) {
			return (facingState.getBlock() == Crop_Blocks.CORN.get()) &&
					facingState.getValue(HALF) != half ? state.setValue(AGE_0_7, facingState.getValue(AGE_0_7)) : Blocks.AIR.defaultBlockState();
		}
		else {
			return (half == DoubleBlockHalf.LOWER && facing == Direction.DOWN && !state.canSurvive(worldIn, pos)) ? Blocks.AIR
					.defaultBlockState() : super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
		}
	}
	
	/* Limit the place. */
	@Override
	protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return state.getBlock() instanceof FarmBlock;
	}

	@Override
	public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
		BlockPos downPos = pos.below();
		BlockState downState = worldIn.getBlockState(downPos);
		
		if (state.getValue(HALF) != DoubleBlockHalf.UPPER) {
			return this.mayPlaceOn(downState, worldIn, downPos); }

		else {
			if (state.getBlock() != this) return super.canSurvive(state, worldIn, pos);
			return downState.getBlock() == this && downState.getValue(HALF) == DoubleBlockHalf.LOWER; }
	}
	
	@Override
	public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
		return false;
	}
	
	/* TickRandom. add this.defaultBlockState() */
	@SuppressWarnings("deprecation")
	public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
		
		BlockState lowFace = this.defaultBlockState().setValue(HALF, DoubleBlockHalf.LOWER);
		BlockState upFace = this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER);
		
		if (!worldIn.isAreaLoaded(pos, 2)) { return; }
		
		if (state.getValue(HALF) == DoubleBlockHalf.LOWER) {
			
			BlockState upState = worldIn.getBlockState(pos.above());
			if (upState.getBlock() != this || upState.getValue(HALF) != DoubleBlockHalf.UPPER) { 
				worldIn.destroyBlock(pos, false); }
		
			if (upState.getBlock() == this && upState.getValue(HALF) == DoubleBlockHalf.UPPER) {
				int i = state.getValue(AGE_0_7);
				int k = upState.getValue(AGE_0_7);
			
				if (i != k) { 
					worldIn.setBlock(pos.above(), upFace.setValue(AGE_0_7, Integer.valueOf(i)), 2); }
				
				float f = getGrowthChance(this, worldIn, pos);
				if (i < 7 && worldIn.getRawBrightness(pos.above(), 0) >= 9 && 
							net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt((int)(25.0F / f) + 1) == 0)) {
					
					worldIn.setBlock(pos, lowFace.setValue(AGE_0_7, Integer.valueOf(i + 1)), 2);
					worldIn.setBlock(pos.above(), upFace.setValue(AGE_0_7, Integer.valueOf(i + 1)), 2);
					net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state); }
			} //upState.getBlock() == this
			
		} //== DoubleBlockHalf.LOWER
	}
	
	protected static float getGrowthChance(Block blockIn, BlockGetter worldIn, BlockPos pos) {
		float f = 1.0F;
		BlockPos downPos = pos.below();

		for(int i = -1; i <= 1; ++i) {
			for(int j = -1; j <= 1; ++j) {
				float f1 = 0.0F;
				BlockState downState = worldIn.getBlockState(downPos.offset(i, 0, j));
				if (downState.canSustainPlant(worldIn, downPos.offset(i, 0, j), net.minecraft.core.Direction.UP, (net.minecraftforge.common.IPlantable)blockIn)) {
					f1 = 1.0F;
					if (downState.isFertile(worldIn, downPos.offset(i, 0, j))) { f1 = 3.0F; }
				}

				if (i != 0 || j != 0) { f1 /= 4.0F; }

				f += f1;
			}
		}

		BlockPos northPos = pos.north();
		BlockPos southPos = pos.south();
		BlockPos westPos = pos.west();
		BlockPos eastPos = pos.east();
		boolean flag = blockIn == worldIn.getBlockState(westPos).getBlock() || blockIn == worldIn.getBlockState(eastPos).getBlock();
		boolean flag1 = blockIn == worldIn.getBlockState(northPos).getBlock() || blockIn == worldIn.getBlockState(southPos).getBlock();
		if (flag && flag1) { f /= 2.0F; } 
		
		else {
			boolean flag2 = blockIn == worldIn.getBlockState(westPos.north()).getBlock() || blockIn == worldIn.getBlockState(eastPos.north()).getBlock() || blockIn == worldIn.getBlockState(eastPos.south()).getBlock() || blockIn == worldIn.getBlockState(westPos.south()).getBlock();
			if (flag2) { f /= 2.0F; }
		}

		return f;
	}
	
	/* Use Bonemeal */
	public boolean canGrow(BlockGetter worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return state.getValue(AGE_0_7) < 7;
	}

	protected int getBonemealAgeIncrease(Level worldIn) {
		return Mth.nextInt(worldIn.random, 2, 5);
	}
	
	public void growCrops(Level worldIn, BlockPos pos, BlockState state) {
		if (state.getValue(HALF) == DoubleBlockHalf.LOWER) {
			int i = state.getValue(AGE_0_7) + this.getBonemealAgeIncrease(worldIn);
			int j = 7;
			if (i > j) { i = j; }

			worldIn.setBlock(pos, state.setValue(AGE_0_7, Integer.valueOf(i)), 2);
			worldIn.setBlock(pos.above(), this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER)
					.setValue(AGE_0_7, Integer.valueOf(i)), 2); }
	}
	
	@Override
	public boolean isValidBonemealTarget(LevelReader worldIn, BlockPos pos, BlockState state) {
		return !this.isMaxAge(state);
	} // fix 20.2

	@Override
	public boolean isBonemealSuccess(Level worldIn, RandomSource rand, BlockPos pos, BlockState state) {
		return true;
	}

	@Override
	public void performBonemeal(ServerLevel worldIn, RandomSource rand, BlockPos pos, BlockState state) {
		this.growCrops(worldIn, pos, state);
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		DoubleBlockHalf half = state.getValue(HALF);
		int i = state.getValue(AGE_0_7);

		switch (i) {
		default:
		case 0:
			return (half == DoubleBlockHalf.UPPER)? Shapes.empty() : AABB_BOT_0;
		case 1:
			return (half == DoubleBlockHalf.UPPER)? Shapes.empty() : AABB_BOT_1;
		case 2:
			return (half == DoubleBlockHalf.UPPER)? Shapes.empty(): AABB_BOT_2;
		case 3:
			return (half == DoubleBlockHalf.UPPER)? Shapes.empty() : AABB_BOT_3;
		case 4:
			return (half == DoubleBlockHalf.UPPER)? Shapes.empty() : AABB_BOT_4;
		case 5:
			return (half == DoubleBlockHalf.UPPER)? Shapes.empty() : AABB_BOT_5;
		case 6:
			return (half == DoubleBlockHalf.UPPER)? Shapes.empty() : AABB_BOT_6;
		case 7:
			return (half == DoubleBlockHalf.UPPER)? AABB_TOP_7 : AABB_BOT_7;
		}
	}
	
	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(AGE_0_7, HALF);
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.SEEDS_CORN.get());
	}

	/* Destroy a DoubleBlock from DoublePlantBlock.class */
	@Override
	public void playerWillDestroy(Level worldIn, BlockPos pos, BlockState state, Player playerIn) {
		if (!worldIn.isClientSide) {
			if (playerIn.isCreative()) { breakUpPart(worldIn, pos, state, playerIn); } 
			
			else { dropResources(state, worldIn, pos, (BlockEntity)null, playerIn, playerIn.getMainHandItem()); }
		}
		super.playerWillDestroy(worldIn, pos, state, playerIn);
	}

	@Override
	public void playerDestroy(Level worldIn, Player playerIn, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack) {
		super.playerDestroy(worldIn, playerIn, pos, Blocks.AIR.defaultBlockState(), blockEntity, stack);
	}

	protected static void breakUpPart(Level worldIn, BlockPos pos, BlockState state, Player playerIn) {
		DoubleBlockHalf half = state.getValue(HALF);
		if (half == DoubleBlockHalf.LOWER) {
			BlockPos upPos = pos.above();
			BlockState upState = worldIn.getBlockState(upPos);
			
			if (upState.is(state.getBlock()) && upState.getValue(HALF) == DoubleBlockHalf.UPPER) {
				BlockState downState1 = upState.hasProperty(BlockStateProperties.WATERLOGGED) && upState.getValue(BlockStateProperties.WATERLOGGED) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
				worldIn.setBlock(upPos, downState1, 35);
				worldIn.levelEvent(playerIn, 2001, upPos, Block.getId(upState)); }
		}
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}
}
