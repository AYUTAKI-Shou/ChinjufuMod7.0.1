package com.ayutaki.chinjufumod.blocks.crop;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;
import com.ayutaki.chinjufumod.registry.Items_NoTab;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
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

public class Grape extends CM_WaterLogged {

	/* Property 1 2 3 4 5 6 7 (8) 9 10 11 -> 5 */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final IntegerProperty STAGE_1_11 = IntegerProperty.create("stage", 1, 11);
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");
	public static final EnumProperty<DoubleBlockHalf> HALF = EnumProperty.create("half", DoubleBlockHalf.class);

	/* Collision */
	protected static final VoxelShape S1_SOUTH = Block.box(0.0D, 0.0D, 6.0D, 16.0D, 23.0D, 10.0D);
	protected static final VoxelShape S1_WEST = Block.box(6.0D, 0.0D, 0.0D, 10.0D, 23.0D, 16.0D);
	protected static final VoxelShape S1_NORTH = Block.box(0.0D, 0.0D, 6.0D, 16.0D, 23.0D, 10.0D);
	protected static final VoxelShape S1_EAST = Block.box(6.0D, 0.0D, 0.0D, 10.0D, 23.0D, 16.0D);

	protected static final VoxelShape S2_SOUTH = Block.box(0.0D, 0.0D, 6.0D, 16.0D, 17.0D, 11.0D);
	protected static final VoxelShape S2_WEST = Block.box(5.0D, 0.0D, 0.0D, 10.0D, 17.0D, 16.0D);
	protected static final VoxelShape S2_NORTH = Block.box(0.0D, 0.0D, 5.0D, 16.0D, 17.0D, 10.0D);
	protected static final VoxelShape S2_EAST = Block.box(6.0D, 0.0D, 0.0D, 11.0D, 17.0D, 16.0D);

	protected static final VoxelShape S3_SOUTH = Block.box(0.0D, 0.0D, 6.0D, 16.0D, 19.0D, 11.0D);
	protected static final VoxelShape S3_WEST = Block.box(5.0D, 0.0D, 0.0D, 10.0D, 19.0D, 16.0D);
	protected static final VoxelShape S3_NORTH = Block.box(0.0D, 0.0D, 5.0D, 16.0D, 19.0D, 10.0D);
	protected static final VoxelShape S3_EAST = Block.box(6.0D, 0.0D, 0.0D, 11.0D, 19.0D, 16.0D);

	protected static final VoxelShape S4_SOUTH = Block.box(0.0D, 0.0D, 5.0D, 16.0D, 21.0D, 12.0D);
	protected static final VoxelShape S4_WEST = Block.box(4.0D, 0.0D, 0.0D, 11.0D, 21.0D, 16.0D);
	protected static final VoxelShape S4_NORTH = Block.box(0.0D, 0.0D, 4.0D, 16.0D, 21.0D, 11.0D);
	protected static final VoxelShape S4_EAST = Block.box(5.0D, 0.0D, 0.0D, 12.0D, 21.0D, 16.0D);

	protected static final VoxelShape S5_SOUTH = Block.box(0.0D, 0.0D, 4.0D, 16.0D, 24.0D, 13.0D);
	protected static final VoxelShape S5_WEST = Block.box(3.0D, 0.0D, 0.0D, 12.0D, 24.0D, 16.0D);
	protected static final VoxelShape S5_NORTH = Block.box(0.0D, 0.0D, 3.0D, 16.0D, 24.0D, 12.0D);
	protected static final VoxelShape S5_EAST = Block.box(4.0D, 0.0D, 0.0D, 13.0D, 24.0D, 16.0D);

	protected static final VoxelShape S6_SOUTH = Block.box(0.0D, 0.0D, 4.0D, 16.0D, 24.0D, 13.0D);
	protected static final VoxelShape S6_WEST = Block.box(3.0D, 0.0D, 0.0D, 12.0D, 24.0D, 16.0D);
	protected static final VoxelShape S6_NORTH = Block.box(0.0D, 0.0D, 3.0D, 16.0D, 24.0D, 12.0D);
	protected static final VoxelShape S6_EAST = Block.box(4.0D, 0.0D, 0.0D, 13.0D, 24.0D, 16.0D);

	protected static final VoxelShape S7_SOUTH = Block.box(0.0D, 0.0D, 4.0D, 16.0D, 24.0D, 13.0D);
	protected static final VoxelShape S7_WEST = Block.box(3.0D, 0.0D, 0.0D, 12.0D, 24.0D, 16.0D);
	protected static final VoxelShape S7_NORTH = Block.box(0.0D, 0.0D, 3.0D, 16.0D, 24.0D, 12.0D);
	protected static final VoxelShape S7_EAST = Block.box(4.0D, 0.0D, 0.0D, 13.0D, 24.0D, 16.0D);

	protected static final VoxelShape S8_SOUTH = Block.box(0.0D, 0.0D, 4.0D, 16.0D, 24.0D, 13.0D);
	protected static final VoxelShape S8_WEST = Block.box(3.0D, 0.0D, 0.0D, 12.0D, 24.0D, 16.0D);
	protected static final VoxelShape S8_NORTH = Block.box(0.0D, 0.0D, 3.0D, 16.0D, 24.0D, 12.0D);
	protected static final VoxelShape S8_EAST = Block.box(4.0D, 0.0D, 0.0D, 13.0D, 24.0D, 16.0D);

	protected static final VoxelShape S9_SOUTH = Block.box(0.0D, 0.0D, 4.0D, 16.0D, 24.0D, 13.0D);
	protected static final VoxelShape S9_WEST = Block.box(3.0D, 0.0D, 0.0D, 12.0D, 24.0D, 16.0D);
	protected static final VoxelShape S9_NORTH = Block.box(0.0D, 0.0D, 3.0D, 16.0D, 24.0D, 12.0D);
	protected static final VoxelShape S9_EAST = Block.box(4.0D, 0.0D, 0.0D, 13.0D, 24.0D, 16.0D);

	protected static final VoxelShape S10_SOUTH = Block.box(0.0D, 0.0D, 6.0D, 16.0D, 23.0D, 10.0D);
	protected static final VoxelShape S10_WEST = Block.box(6.0D, 0.0D, 0.0D, 10.0D, 23.0D, 16.0D);
	protected static final VoxelShape S10_NORTH = Block.box(0.0D, 0.0D, 6.0D, 16.0D, 23.0D, 10.0D);
	protected static final VoxelShape S10_EAST = Block.box(6.0D, 0.0D, 0.0D, 10.0D, 23.0D, 16.0D);

	protected static final VoxelShape S11_SOUTH = Block.box(0.0D, 0.0D, 5.0D, 16.0D, 24.0D, 12.0D);
	protected static final VoxelShape S11_WEST = Block.box(4.0D, 0.0D, 0.0D, 11.0D, 24.0D, 16.0D);
	protected static final VoxelShape S11_NORTH = Block.box(0.0D, 0.0D, 4.0D, 16.0D, 24.0D, 11.0D);
	protected static final VoxelShape S11_EAST = Block.box(5.0D, 0.0D, 0.0D, 12.0D, 24.0D, 16.0D);

	public Grape(AbstractBlock.Properties properties) {
		super(properties);
		/** Default state **/
		registerDefaultState(this.defaultBlockState().setValue(H_FACING, Direction.NORTH)
				.setValue(STAGE_1_11, Integer.valueOf(1))
				.setValue(HALF, DoubleBlockHalf.LOWER)
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		int i = state.getValue(STAGE_1_11);
		/** Property 1 2 3 4 5 6 7 (8) 9 10 11 -> 5 **/

		BlockState lowFace = this.defaultBlockState().setValue(HALF, DoubleBlockHalf.LOWER).setValue(H_FACING, state.getValue(H_FACING));
		BlockState upFace = this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER).setValue(H_FACING, state.getValue(H_FACING));
		
		/** Too early to collect **/
		if (i < 8 && state.getValue(HALF) == DoubleBlockHalf.LOWER) {
			
			if (item == Items.BONE_MEAL) {
				CMEvents.Consume_1Item(playerIn, hand);
	
				/* BoneMealItem.spawnBonemealParticles(worldIn, pos, 15); の代替 */
				for(int n = 0; n < 15; ++n) {
					double d0 = worldIn.random.nextGaussian() * 0.02D;
					double d1 = worldIn.random.nextGaussian() * 0.02D;
					double d2 = worldIn.random.nextGaussian() * 0.02D;
					worldIn.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + worldIn.random.nextFloat(), pos.getY() +worldIn.random.nextFloat(), pos.getZ() + worldIn.random.nextFloat(), d0, d1, d2); }
				
			if (i < 7) {
				worldIn.setBlock(pos, lowFace.setValue(STAGE_1_11, Integer.valueOf(i + 2)), 3);
				worldIn.setBlock(pos.above(), upFace.setValue(STAGE_1_11, Integer.valueOf(i + 2)), 3); }
	
			if (i == 7) {
				worldIn.setBlock(pos, lowFace.setValue(STAGE_1_11, Integer.valueOf(8)), 3);
				worldIn.setBlock(pos.above(), upFace.setValue(STAGE_1_11, Integer.valueOf(8)), 3); }
			}
			
			if (item != Items.BONE_MEAL) {
				if (!stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (stack.isEmpty()) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }	
			}
		}
		
		/** Can harvest **/
		if (i == 8 && state.getValue(HALF) == DoubleBlockHalf.LOWER) {
			if (stack.isEmpty()) {				

				CMEvents.soundTake_Pick(worldIn, pos);
				playerIn.inventory.add(new ItemStack(Items_Teatime.FOOD_GRAPE, 2));
	
				worldIn.setBlock(pos, lowFace.setValue(STAGE_1_11, Integer.valueOf(9)), 3);
				worldIn.setBlock(pos.above(), upFace.setValue(STAGE_1_11, Integer.valueOf(9)), 3); }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		/** Sleeping **/
		if (i > 8) { CMEvents.textIsSleeping(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* Limit the place. */
	protected boolean mayPlaceOn(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return (state.getMaterial() == Material.DIRT && state.getMaterial().isSolid());
	}

	@SuppressWarnings("deprecation")
	public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockPos downPos = pos.below();
		BlockState downState = worldIn.getBlockState(downPos);
		
		if (state.getValue(HALF) != DoubleBlockHalf.UPPER) {
			return this.mayPlaceOn(downState, worldIn, downPos); }

		else {
			if (state.getBlock() != this) return super.canSurvive(state, worldIn, pos);
			return downState.getBlock() == this && downState.getValue(HALF) == DoubleBlockHalf.LOWER; }
	}
	
	/* Gives a value when placed. */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);

		/** pos.up() = Replaceable block. **/
		if (pos.getY() < 255 && worldIn.getBlockState(pos.above()).canBeReplaced(context)) {
			return this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection().getOpposite())
					.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER))
					.setValue(STAGE_1_11, Integer.valueOf(1)).setValue(HALF, DoubleBlockHalf.LOWER); }

		else { return null; }
	}

	/* Add DoubleBlockHalf.UPPER on the Block. */
	public void setPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		FluidState fluidUp = worldIn.getFluidState(pos.above());

		worldIn.setBlock(pos.above(), this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER).setValue(H_FACING, state.getValue(H_FACING))
				.setValue(WATERLOGGED, Boolean.valueOf(fluidUp.getType() == Fluids.WATER)), 3);
	}

	/* HORIZONTAL Property */
	@Override
	public BlockState rotate(BlockState state, Rotation rotation) {
		return state.setValue(H_FACING, rotation.rotate(state.getValue(H_FACING)));
	}

	@SuppressWarnings("deprecation")
	@Override
	public BlockState mirror(BlockState state, Mirror mirror) {
		return state.rotate(mirror.getRotation(state.getValue(H_FACING)));
	}

	@OnlyIn(Dist.CLIENT)
	public long getSeed(BlockState state, BlockPos pos) {
		return MathHelper.getSeed(pos.getX(), pos.below(state.getValue(HALF) == DoubleBlockHalf.LOWER ? 0 : 1).getY(), pos.getZ());
	}
	
	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {

		BlockState state1 = super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
		if (!state1.isAir(worldIn, pos)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }

		DoubleBlockHalf half = state.getValue(HALF);
		if (facing.getAxis() == Direction.Axis.Y && half == DoubleBlockHalf.LOWER == (facing == Direction.UP)) {
			return (facingState.getBlock() == Crop_Blocks.BUDOUNOKI && facingState.getValue(HALF) != half) ? state.setValue(H_FACING, facingState.getValue(H_FACING)).setValue(STAGE_1_11, facingState.getValue(STAGE_1_11)) : Blocks.AIR.defaultBlockState();
		}
		else {
			return half == DoubleBlockHalf.LOWER && facing == Direction.DOWN && !state.canSurvive(worldIn, pos) ? Blocks.AIR
					.defaultBlockState() : super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
		}
	}

	/* TickRandom. Growth rate similar to that of wheat. rand.nextInt(8) == 0 */
	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		/** Property 1 2 3 4 5 6 7 (8) 9 10 11 -> 5 **/
		int i = state.getValue(STAGE_1_11);
		BlockState upState = worldIn.getBlockState(pos.above());
		DoubleBlockHalf half = state.getValue(HALF);
		
		BlockState lowFace = this.defaultBlockState().setValue(HALF, DoubleBlockHalf.LOWER).setValue(H_FACING, state.getValue(H_FACING));
		BlockState upFace = this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER).setValue(H_FACING, state.getValue(H_FACING));
		
		if (!worldIn.isAreaLoaded(pos, 2)) { return; }

		switch (half) {
		case LOWER:
		default:
			if (!state.getValue(WATERLOGGED) && !upState.getValue(WATERLOGGED)) {
				if (i < 8 && worldIn.getRawBrightness(pos, 0) >= 9 && rand.nextInt(8) == 0) {
		
					worldIn.setBlock(pos, lowFace.setValue(STAGE_1_11, Integer.valueOf(i + 1)), 3);
					worldIn.setBlock(pos.above(), upFace.setValue(STAGE_1_11, Integer.valueOf(i + 1)), 3); }
		
				if (i == 8) { }
		
				if (i == 9 && worldIn.getRawBrightness(pos, 0) >= 9 && rand.nextInt(8) == 0) {
		
					worldIn.setBlock(pos, lowFace.setValue(STAGE_1_11, Integer.valueOf(i + 1)), 3);
					worldIn.setBlock(pos.above(), upFace.setValue(STAGE_1_11, Integer.valueOf(i + 1)), 3); }
		
				if (i == 10 && worldIn.getRawBrightness(pos, 0) >= 9 && rand.nextInt(8) == 0) {
		
					worldIn.setBlock(pos, lowFace.setValue(STAGE_1_11, Integer.valueOf(i + 1)), 3);
					worldIn.setBlock(pos.above(), upFace.setValue(STAGE_1_11, Integer.valueOf(i + 1)), 3); }
		
				if (i == 11 && worldIn.getRawBrightness(pos, 0) >= 9 && rand.nextInt(8) == 0) {
		
					worldIn.setBlock(pos, lowFace.setValue(STAGE_1_11, Integer.valueOf(5)), 3);
					worldIn.setBlock(pos.above(), upFace.setValue(STAGE_1_11, Integer.valueOf(5)), 3); }
			}
			
			if (state.getValue(WATERLOGGED) || upState.getValue(WATERLOGGED)) {
				if (i >= 6 && i <= 8 && rand.nextInt(2) == 0) {
					CMEvents.soundSnowBreak(worldIn, pos);
					worldIn.setBlock(pos, lowFace.setValue(STAGE_1_11, Integer.valueOf(5)), 3);
					worldIn.setBlock(pos.above(), upFace.setValue(STAGE_1_11, Integer.valueOf(5)), 3);
					
					this.dropRottenfood(worldIn, pos); }
				
				else { }
			}
			break;

		case UPPER:
			break;
		} // switch
	}

	protected void dropRottenfood(ServerWorld worldIn, BlockPos pos) {
		ItemStack stack = new ItemStack(Items_NoTab.ROTTEN_FOOD);
		InventoryHelper.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

		int i = state.getValue(STAGE_1_11);
		Direction direction = state.getValue(H_FACING);

		switch (direction) {
		case NORTH:
		default:
			return (state.getValue(HALF) == DoubleBlockHalf.UPPER)? VoxelShapes.empty() :
						((i == 1)? S1_NORTH : ((i == 2)? S2_NORTH : ((i == 3)? S3_NORTH : ((i == 4)? S4_NORTH : ((i == 5)? S5_NORTH : ((i == 6)? S6_NORTH :
							((i == 7)? S7_NORTH : ((i == 8)? S8_NORTH : ((i == 9)? S9_NORTH : ((i == 10)? S10_NORTH : S11_NORTH))))))))));
		case SOUTH:
			return (state.getValue(HALF) == DoubleBlockHalf.UPPER)? VoxelShapes.empty() :
						((i == 1)? S1_SOUTH : ((i == 2)? S2_SOUTH : ((i == 3)? S3_SOUTH : ((i == 4)? S4_SOUTH : ((i == 5)? S5_SOUTH : ((i == 6)? S6_SOUTH :
							((i == 7)? S7_SOUTH : ((i == 8)? S8_SOUTH : ((i == 9)? S9_SOUTH : ((i == 10)? S10_SOUTH : S11_SOUTH))))))))));
		case WEST:
			return (state.getValue(HALF) == DoubleBlockHalf.UPPER)? VoxelShapes.empty() :
						((i == 1)? S1_WEST : ((i == 2)? S2_WEST : ((i == 3)? S3_WEST : ((i == 4)? S4_WEST : ((i == 5)? S5_WEST : ((i == 6)? S6_WEST :
							((i == 7)? S7_WEST : ((i == 8)? S8_WEST : ((i == 9)? S9_WEST : ((i == 10)? S10_WEST : S11_WEST))))))))));
		case EAST:
			return (state.getValue(HALF) == DoubleBlockHalf.UPPER)? VoxelShapes.empty() :
						((i == 1)? S1_EAST : ((i == 2)? S2_EAST : ((i == 3)? S3_EAST : ((i == 4)? S4_EAST : ((i == 5)? S5_EAST : ((i == 6)? S6_EAST :
							((i == 7)? S7_EAST : ((i == 8)? S8_EAST : ((i == 9)? S9_EAST : ((i == 10)? S10_EAST : S11_EAST))))))))));
		}
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

	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(H_FACING, HALF, STAGE_1_11, WATERLOGGED);
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.BUDOUNOKI);
	}

	public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
		return true;
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
		tooltip.add(new TranslationTextComponent("tips.block_wood_grape_nae").withStyle(TextFormatting.GRAY));
	}
}
