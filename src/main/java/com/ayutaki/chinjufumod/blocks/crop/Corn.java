package com.ayutaki.chinjufumod.blocks.crop;

import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.registry.Crop_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class Corn extends CropsBlock implements IGrowable {

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

	public Corn(AbstractBlock.Properties properties) {
		super(properties);

		registerDefaultState(this.defaultBlockState().setValue(HALF, DoubleBlockHalf.LOWER)
				.setValue(AGE_0_7, Integer.valueOf(0)));
	}

	/* Gives a value when placed. */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		BlockPos pos = context.getClickedPos();
		return pos.getY() < 255 && context.getLevel().getBlockState(pos.above()).canBeReplaced(context) ?
				 super.getStateForPlacement(context) : null;
	}

	/* Add DoubleBlockHalf.UPPER on the Block. */
	public void setPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		worldIn.setBlock(pos.above(), this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER).setValue(AGE_0_7, Integer.valueOf(0)), 3);
	}

	/* Update BlockState. */
	public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {

		DoubleBlockHalf half = stateIn.getValue(HALF);
		if (facing.getAxis() == Direction.Axis.Y && half == DoubleBlockHalf.LOWER == (facing == Direction.UP)) {
			return (facingState.getBlock() == Crop_Blocks.CORN) &&
					facingState.getValue(HALF) != half ? stateIn.setValue(AGE_0_7, facingState.getValue(AGE_0_7)) : Blocks.AIR.defaultBlockState();
		}
		else {
			return half == DoubleBlockHalf.LOWER && facing == Direction.DOWN && !stateIn.canSurvive(worldIn, pos) ? Blocks.AIR
					.defaultBlockState() : super.updateShape(stateIn, facing, facingState, worldIn, pos, facingPos);
		}
	}

	/* Limit the place. Changed to instanceof or getMaterial(). */
	@Override
	protected boolean mayPlaceOn(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return state.getBlock() instanceof FarmlandBlock;
	}

	public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockPos downPos = pos.below();
		BlockState downState = worldIn.getBlockState(downPos);
		
		if (state.getValue(HALF) != DoubleBlockHalf.UPPER) {
			return this.mayPlaceOn(downState, worldIn, downPos); }

		else {
			if (state.getBlock() != this) return super.canSurvive(state, worldIn, pos);
			return downState.getBlock() == this && downState.getValue(HALF) == DoubleBlockHalf.LOWER; }
	}

	public boolean canBeReplaced(BlockState state, BlockItemUseContext context) {
		return false;
	}

	/* TickRandom. add this.defaultBlockState() 220810 */
	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

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

	protected static float getGrowthChance(Block blockIn, IBlockReader worldIn, BlockPos pos) {
		float f = 1.0F;
		BlockPos downPos = pos.below();

		for(int i = -1; i <= 1; ++i) {
			for(int j = -1; j <= 1; ++j) {
				float f1 = 0.0F;
				BlockState downState = worldIn.getBlockState(downPos.offset(i, 0, j));
				if (downState.canSustainPlant(worldIn, downPos.offset(i, 0, j), net.minecraft.util.Direction.UP, (net.minecraftforge.common.IPlantable)blockIn)) {
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

	/* Must item */
	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return state.getValue(AGE_0_7) < 7;
	}

	protected int getBonemealAgeIncrease(World worldIn) {
		return MathHelper.nextInt(worldIn.random, 2, 5);
	}

	public void growCrops(World worldIn, BlockPos pos, BlockState state) {
		if (state.getValue(HALF) == DoubleBlockHalf.LOWER) {
			int i = state.getValue(AGE_0_7) + this.getBonemealAgeIncrease(worldIn);
			int j = 7;
			if (i > j) { i = j; }

			worldIn.setBlock(pos, state.setValue(AGE_0_7, Integer.valueOf(i)), 2);
			worldIn.setBlock(pos.above(), this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER)
					.setValue(AGE_0_7, Integer.valueOf(i)), 2); }
	}
	
	/* auto-generated method */
	public boolean isMaxAge(BlockState state) {
		return state.getValue(AGE_0_7) >= 7;
	}

	@Override
	public boolean isValidBonemealTarget(IBlockReader worldIn, BlockPos pos, BlockState state, boolean tf) {
		return !this.isMaxAge(state);
	}

	@Override
	public boolean isBonemealSuccess(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return true;
	}

	@Override
	public void performBonemeal(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
		this.growCrops(worldIn, pos, state);
	}
	
	/* Collisions for each property. adopt...rotation, reject...getOffsetType() */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		DoubleBlockHalf half = state.getValue(HALF);
		int i = state.getValue(AGE_0_7);

		switch (i) {
		default:
		case 0:
			return (half == DoubleBlockHalf.UPPER)? VoxelShapes.empty() : AABB_BOT_0;
		case 1:
			return (half == DoubleBlockHalf.UPPER)? VoxelShapes.empty() : AABB_BOT_1;
		case 2:
			return (half == DoubleBlockHalf.UPPER)? VoxelShapes.empty() : AABB_BOT_2;
		case 3:
			return (half == DoubleBlockHalf.UPPER)? VoxelShapes.empty() : AABB_BOT_3;
		case 4:
			return (half == DoubleBlockHalf.UPPER)? VoxelShapes.empty() : AABB_BOT_4;
		case 5:
			return (half == DoubleBlockHalf.UPPER)? VoxelShapes.empty() : AABB_BOT_5;
		case 6:
			return (half == DoubleBlockHalf.UPPER)? VoxelShapes.empty() : AABB_BOT_6;
		case 7:
			return (half == DoubleBlockHalf.UPPER)? AABB_TOP_7 : AABB_BOT_7;
		}
	}

	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(AGE_0_7, HALF);
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.SEEDS_CORN);
	}

	/* Destroy a DoubleBlock from DoublePlantBlock.class */
	public void playerWillDestroy(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {

		if (!worldIn.isClientSide) {
			if (playerIn.isCreative()) { breakUpPart(worldIn, pos, state, playerIn); }
			else { dropResources(state, worldIn, pos, (TileEntity)null, playerIn, playerIn.getMainHandItem()); }
		}
		super.playerWillDestroy(worldIn, pos, state, playerIn);
	}

	public void playerDestroy(World worldIn, PlayerEntity playerIn, BlockPos pos, BlockState state, @Nullable TileEntity te, ItemStack stack) {
		super.playerDestroy(worldIn, playerIn, pos, Blocks.AIR.defaultBlockState(), te, stack);
	}

	protected static void breakUpPart(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {
		DoubleBlockHalf half = state.getValue(HALF);
		if (half == DoubleBlockHalf.LOWER) {
			BlockPos upPos = pos.above();
			BlockState upState = worldIn.getBlockState(upPos);

			if (upState.getBlock() == state.getBlock() && upState.getValue(HALF) == DoubleBlockHalf.UPPER) {
				worldIn.setBlock(upPos, Blocks.AIR.defaultBlockState(), 35);
				worldIn.levelEvent(playerIn, 2001, upPos, Block.getId(upState));
			}
		}
	}

	public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
		return true;
	}
}
