package com.ayutaki.chinjufumod.blocks.crop;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;
import com.ayutaki.chinjufumod.registry.Items_NoTab;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
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
import net.minecraft.tags.FluidTags;
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
	protected static final VoxelShape S1_SOUTH = Block.makeCuboidShape(0.0D, 0.0D, 6.0D, 16.0D, 23.0D, 10.0D);
	protected static final VoxelShape S1_WEST = Block.makeCuboidShape(6.0D, 0.0D, 0.0D, 10.0D, 23.0D, 16.0D);
	protected static final VoxelShape S1_NORTH = Block.makeCuboidShape(0.0D, 0.0D, 6.0D, 16.0D, 23.0D, 10.0D);
	protected static final VoxelShape S1_EAST = Block.makeCuboidShape(6.0D, 0.0D, 0.0D, 10.0D, 23.0D, 16.0D);

	protected static final VoxelShape S2_SOUTH = Block.makeCuboidShape(0.0D, 0.0D, 6.0D, 16.0D, 17.0D, 11.0D);
	protected static final VoxelShape S2_WEST = Block.makeCuboidShape(5.0D, 0.0D, 0.0D, 10.0D, 17.0D, 16.0D);
	protected static final VoxelShape S2_NORTH = Block.makeCuboidShape(0.0D, 0.0D, 5.0D, 16.0D, 17.0D, 10.0D);
	protected static final VoxelShape S2_EAST = Block.makeCuboidShape(6.0D, 0.0D, 0.0D, 11.0D, 17.0D, 16.0D);

	protected static final VoxelShape S3_SOUTH = Block.makeCuboidShape(0.0D, 0.0D, 6.0D, 16.0D, 19.0D, 11.0D);
	protected static final VoxelShape S3_WEST = Block.makeCuboidShape(5.0D, 0.0D, 0.0D, 10.0D, 19.0D, 16.0D);
	protected static final VoxelShape S3_NORTH = Block.makeCuboidShape(0.0D, 0.0D, 5.0D, 16.0D, 19.0D, 10.0D);
	protected static final VoxelShape S3_EAST = Block.makeCuboidShape(6.0D, 0.0D, 0.0D, 11.0D, 19.0D, 16.0D);

	protected static final VoxelShape S4_SOUTH = Block.makeCuboidShape(0.0D, 0.0D, 5.0D, 16.0D, 21.0D, 12.0D);
	protected static final VoxelShape S4_WEST = Block.makeCuboidShape(4.0D, 0.0D, 0.0D, 11.0D, 21.0D, 16.0D);
	protected static final VoxelShape S4_NORTH = Block.makeCuboidShape(0.0D, 0.0D, 4.0D, 16.0D, 21.0D, 11.0D);
	protected static final VoxelShape S4_EAST = Block.makeCuboidShape(5.0D, 0.0D, 0.0D, 12.0D, 21.0D, 16.0D);

	protected static final VoxelShape S5_SOUTH = Block.makeCuboidShape(0.0D, 0.0D, 4.0D, 16.0D, 24.0D, 13.0D);
	protected static final VoxelShape S5_WEST = Block.makeCuboidShape(3.0D, 0.0D, 0.0D, 12.0D, 24.0D, 16.0D);
	protected static final VoxelShape S5_NORTH = Block.makeCuboidShape(0.0D, 0.0D, 3.0D, 16.0D, 24.0D, 12.0D);
	protected static final VoxelShape S5_EAST = Block.makeCuboidShape(4.0D, 0.0D, 0.0D, 13.0D, 24.0D, 16.0D);

	protected static final VoxelShape S6_SOUTH = Block.makeCuboidShape(0.0D, 0.0D, 4.0D, 16.0D, 24.0D, 13.0D);
	protected static final VoxelShape S6_WEST = Block.makeCuboidShape(3.0D, 0.0D, 0.0D, 12.0D, 24.0D, 16.0D);
	protected static final VoxelShape S6_NORTH = Block.makeCuboidShape(0.0D, 0.0D, 3.0D, 16.0D, 24.0D, 12.0D);
	protected static final VoxelShape S6_EAST = Block.makeCuboidShape(4.0D, 0.0D, 0.0D, 13.0D, 24.0D, 16.0D);

	protected static final VoxelShape S7_SOUTH = Block.makeCuboidShape(0.0D, 0.0D, 4.0D, 16.0D, 24.0D, 13.0D);
	protected static final VoxelShape S7_WEST = Block.makeCuboidShape(3.0D, 0.0D, 0.0D, 12.0D, 24.0D, 16.0D);
	protected static final VoxelShape S7_NORTH = Block.makeCuboidShape(0.0D, 0.0D, 3.0D, 16.0D, 24.0D, 12.0D);
	protected static final VoxelShape S7_EAST = Block.makeCuboidShape(4.0D, 0.0D, 0.0D, 13.0D, 24.0D, 16.0D);

	protected static final VoxelShape S8_SOUTH = Block.makeCuboidShape(0.0D, 0.0D, 4.0D, 16.0D, 24.0D, 13.0D);
	protected static final VoxelShape S8_WEST = Block.makeCuboidShape(3.0D, 0.0D, 0.0D, 12.0D, 24.0D, 16.0D);
	protected static final VoxelShape S8_NORTH = Block.makeCuboidShape(0.0D, 0.0D, 3.0D, 16.0D, 24.0D, 12.0D);
	protected static final VoxelShape S8_EAST = Block.makeCuboidShape(4.0D, 0.0D, 0.0D, 13.0D, 24.0D, 16.0D);

	protected static final VoxelShape S9_SOUTH = Block.makeCuboidShape(0.0D, 0.0D, 4.0D, 16.0D, 24.0D, 13.0D);
	protected static final VoxelShape S9_WEST = Block.makeCuboidShape(3.0D, 0.0D, 0.0D, 12.0D, 24.0D, 16.0D);
	protected static final VoxelShape S9_NORTH = Block.makeCuboidShape(0.0D, 0.0D, 3.0D, 16.0D, 24.0D, 12.0D);
	protected static final VoxelShape S9_EAST = Block.makeCuboidShape(4.0D, 0.0D, 0.0D, 13.0D, 24.0D, 16.0D);

	protected static final VoxelShape S10_SOUTH = Block.makeCuboidShape(0.0D, 0.0D, 6.0D, 16.0D, 23.0D, 10.0D);
	protected static final VoxelShape S10_WEST = Block.makeCuboidShape(6.0D, 0.0D, 0.0D, 10.0D, 23.0D, 16.0D);
	protected static final VoxelShape S10_NORTH = Block.makeCuboidShape(0.0D, 0.0D, 6.0D, 16.0D, 23.0D, 10.0D);
	protected static final VoxelShape S10_EAST = Block.makeCuboidShape(6.0D, 0.0D, 0.0D, 10.0D, 23.0D, 16.0D);

	protected static final VoxelShape S11_SOUTH = Block.makeCuboidShape(0.0D, 0.0D, 5.0D, 16.0D, 24.0D, 12.0D);
	protected static final VoxelShape S11_WEST = Block.makeCuboidShape(4.0D, 0.0D, 0.0D, 11.0D, 24.0D, 16.0D);
	protected static final VoxelShape S11_NORTH = Block.makeCuboidShape(0.0D, 0.0D, 4.0D, 16.0D, 24.0D, 11.0D);
	protected static final VoxelShape S11_EAST = Block.makeCuboidShape(5.0D, 0.0D, 0.0D, 12.0D, 24.0D, 16.0D);

	/* Property 0 1 2 3 4 5 6 (7) 8 9 10 -> 4 */
	public Grape(Block.Properties properties) {
		super(properties);

		/** Default state **/
		setDefaultState(this.stateContainer.getBaseState().with(H_FACING, Direction.NORTH)
				.with(STAGE_1_11, Integer.valueOf(1))
				.with(HALF, DoubleBlockHalf.LOWER)
				.with(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		int i = state.get(STAGE_1_11);
		/** Property 1 2 3 4 5 6 7 (8) 9 10 11 -> 5 **/

		BlockState lowFace = this.getDefaultState().with(HALF, DoubleBlockHalf.LOWER).with(H_FACING, state.get(H_FACING));
		BlockState upFace = this.getDefaultState().with(HALF, DoubleBlockHalf.UPPER).with(H_FACING, state.get(H_FACING));
		
		/** Too early to collect **/
		if (i < 8 && state.get(HALF) == DoubleBlockHalf.LOWER) {
			
			if (item == Items.BONE_MEAL) {
				CMEvents.Consume_1Item(playerIn, hand);
	
				/* BoneMealItem.spawnBonemealParticles(worldIn, pos, 15); の代替 */
				for(int n = 0; n < 15; ++n) {
					double d0 = worldIn.rand.nextGaussian() * 0.02D;
					double d1 = worldIn.rand.nextGaussian() * 0.02D;
					double d2 = worldIn.rand.nextGaussian() * 0.02D;
					worldIn.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + worldIn.rand.nextFloat(), pos.getY() +worldIn.rand.nextFloat(), pos.getZ() + worldIn.rand.nextFloat(), d0, d1, d2); }
				
				if (i < 7) {
					worldIn.setBlockState(pos, lowFace.with(STAGE_1_11, Integer.valueOf(i + 2)));
					worldIn.setBlockState(pos.up(), upFace.with(STAGE_1_11, Integer.valueOf(i + 2))); }
		
				if (i == 7) {
					worldIn.setBlockState(pos, lowFace.with(STAGE_1_11, Integer.valueOf(8)));
					worldIn.setBlockState(pos.up(), upFace.with(STAGE_1_11, Integer.valueOf(8))); }
			}
			
			if (item != Items.BONE_MEAL) {
				if (!stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (stack.isEmpty()) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }	
			}
		}
		
		/** Can harvest **/
		if (i == 8 && state.get(HALF) == DoubleBlockHalf.LOWER) {
			if (stack.isEmpty()) {
				
				CMEvents.soundTake_Pick(worldIn, pos);
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.FOOD_GRAPE, 2));
	
				worldIn.setBlockState(pos, lowFace.with(STAGE_1_11, Integer.valueOf(9)));
				worldIn.setBlockState(pos.up(), upFace.with(STAGE_1_11, Integer.valueOf(9))); }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		/** Sleeping **/
		if (i > 8) { CMEvents.textIsSleeping(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}
	
	/* Limit the place. */
	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return (state.getMaterial() == Material.EARTH && state.getMaterial().isSolid());
	}

	@SuppressWarnings("deprecation")
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockPos downPos = pos.down();
		BlockState downState = worldIn.getBlockState(downPos);
		
		if (state.get(HALF) != DoubleBlockHalf.UPPER) {
			return this.isValidGround(downState, worldIn, downPos); }

		else {
			if (state.getBlock() != this) return super.isValidPosition(state, worldIn, pos);
			return downState.getBlock() == this && downState.get(HALF) == DoubleBlockHalf.LOWER; }
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
					.with(STAGE_1_11, Integer.valueOf(1)).with(HALF, DoubleBlockHalf.LOWER); }

		else { return null; }
	}

	/* Add DoubleBlockHalf.UPPER on the Block. */
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		IFluidState fluidUp = worldIn.getFluidState(pos.up());

		worldIn.setBlockState(pos.up(), this.getDefaultState().with(HALF, DoubleBlockHalf.UPPER).with(H_FACING, state.get(H_FACING))
				.with(WATERLOGGED, Boolean.valueOf(fluidUp.isTagged(FluidTags.WATER))), 3);
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
	
	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {

		BlockState state1 = super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
		if (!state1.isAir(worldIn, pos)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
		}

		DoubleBlockHalf half = state.get(HALF);
		if (facing.getAxis() == Direction.Axis.Y && half == DoubleBlockHalf.LOWER == (facing == Direction.UP)) {
			return (facingState.getBlock() == Crop_Blocks.BUDOUNOKI && facingState.get(HALF) != half) ? state.with(H_FACING, facingState.get(H_FACING)).with(STAGE_1_11, facingState.get(STAGE_1_11)) : Blocks.AIR.getDefaultState();
		}
		else {
			return half == DoubleBlockHalf.LOWER && facing == Direction.DOWN && !state.isValidPosition(worldIn, pos) ? Blocks.AIR
					.getDefaultState() : super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
		}
	}

	/* TickRandom. Growth rate similar to that of wheat. rand.nextInt(8) == 0 */
	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		
		DoubleBlockHalf half = state.get(HALF);
		BlockState upState = worldIn.getBlockState(pos.up());
		int i = state.get(STAGE_1_11);
		/** Property 1 2 3 4 5 6 7 (8) 9 10 11 -> 5 **/
		
		BlockState lowFace = this.getDefaultState().with(HALF, DoubleBlockHalf.LOWER).with(H_FACING, state.get(H_FACING));
		BlockState upFace = this.getDefaultState().with(HALF, DoubleBlockHalf.UPPER).with(H_FACING, state.get(H_FACING));
		
		if (!worldIn.isAreaLoaded(pos, 2)) { return; }

		switch (half) {
		case LOWER:
		default:
			if (!state.get(WATERLOGGED) && !upState.get(WATERLOGGED)) {
				if (i < 8 && worldIn.getLightSubtracted(pos, 0) >= 9 && rand.nextInt(8) == 0) {
		
					worldIn.setBlockState(pos, lowFace.with(STAGE_1_11, Integer.valueOf(i + 1)));
					worldIn.setBlockState(pos.up(), upFace.with(STAGE_1_11, Integer.valueOf(i + 1))); }
		
				if (i == 8) { }
		
				if (i == 9 && worldIn.getLightSubtracted(pos, 0) >= 9 && rand.nextInt(8) == 0) {
		
					worldIn.setBlockState(pos, lowFace.with(STAGE_1_11, Integer.valueOf(i + 1)));
					worldIn.setBlockState(pos.up(), upFace.with(STAGE_1_11, Integer.valueOf(i + 1))); }
		
				if (i == 10 && worldIn.getLightSubtracted(pos, 0) >= 9 && rand.nextInt(8) == 0) {
		
					worldIn.setBlockState(pos, lowFace.with(STAGE_1_11, Integer.valueOf(i + 1)));
					worldIn.setBlockState(pos.up(), upFace.with(STAGE_1_11, Integer.valueOf(i + 1))); }
		
				if (i == 11 && worldIn.getLightSubtracted(pos, 0) >= 9 && rand.nextInt(8) == 0) {
		
					worldIn.setBlockState(pos, lowFace.with(STAGE_1_11, Integer.valueOf(5)));
					worldIn.setBlockState(pos.up(), upFace.with(STAGE_1_11, Integer.valueOf(5))); }
			}
			
			if (state.get(WATERLOGGED) || upState.get(WATERLOGGED)) {
				if (i >= 6 && i <= 8 && rand.nextInt(2) == 0) {
					CMEvents.soundSnowBreak(worldIn, pos);
					worldIn.setBlockState(pos, lowFace.with(STAGE_1_11, Integer.valueOf(5)), 3);
					worldIn.setBlockState(pos.up(), upFace.with(STAGE_1_11, Integer.valueOf(5)), 3);
					
					this.dropRottenfood(worldIn, pos); }
				
				else { }
			}
			break;

		case UPPER:
			break;
		} // switch LOWER-UPPER
	}

	protected void dropRottenfood(ServerWorld worldIn, BlockPos pos) {
		ItemStack stack = new ItemStack(Items_NoTab.ROTTEN_FOOD);
		InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

		int i = state.get(STAGE_1_11);
		Direction direction = state.get(H_FACING);

		switch(direction) {
		case SOUTH:
			return (state.get(HALF) == DoubleBlockHalf.UPPER)? VoxelShapes.empty() :
						((i == 1)? S1_SOUTH : ((i == 2)? S2_SOUTH : ((i == 3)? S3_SOUTH : ((i == 4)? S4_SOUTH : ((i == 5)? S5_SOUTH : ((i == 6)? S6_SOUTH :
							((i == 7)? S7_SOUTH : ((i == 8)? S8_SOUTH : ((i == 9)? S9_SOUTH : ((i == 10)? S10_SOUTH : S11_SOUTH))))))))));
		case WEST:
			return (state.get(HALF) == DoubleBlockHalf.UPPER)? VoxelShapes.empty() :
						((i == 1)? S1_WEST : ((i == 2)? S2_WEST : ((i == 3)? S3_WEST : ((i == 4)? S4_WEST : ((i == 5)? S5_WEST : ((i == 6)? S6_WEST :
							((i == 7)? S7_WEST : ((i == 8)? S8_WEST : ((i == 9)? S9_WEST : ((i == 10)? S10_WEST : S11_WEST))))))))));
		case NORTH:
		default:
			return (state.get(HALF) == DoubleBlockHalf.UPPER)? VoxelShapes.empty() :
						((i == 1)? S1_NORTH : ((i == 2)? S2_NORTH : ((i == 3)? S3_NORTH : ((i == 4)? S4_NORTH : ((i == 5)? S5_NORTH : ((i == 6)? S6_NORTH :
							((i == 7)? S7_NORTH : ((i == 8)? S8_NORTH : ((i == 9)? S9_NORTH : ((i == 10)? S10_NORTH : S11_NORTH))))))))));
		case EAST:
			return (state.get(HALF) == DoubleBlockHalf.UPPER)? VoxelShapes.empty() :
						((i == 1)? S1_EAST : ((i == 2)? S2_EAST : ((i == 3)? S3_EAST : ((i == 4)? S4_EAST : ((i == 5)? S5_EAST : ((i == 6)? S6_EAST :
							((i == 7)? S7_EAST : ((i == 8)? S8_EAST : ((i == 9)? S9_EAST : ((i == 10)? S10_EAST : S11_EAST))))))))));
		}
	}

	/* Destroy at the same time. & Drop item. */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {

		BlockState upState = worldIn.getBlockState(pos.up());
		BlockState downState = worldIn.getBlockState(pos.down());

		if (downState.getBlock() == this && !playerIn.isCreative()) { worldIn.destroyBlock(pos.down(), false); }
		if (upState.getBlock() == this && !playerIn.isCreative()) { worldIn.destroyBlock(pos.up(), false); }
		if (playerIn.isCreative()) { worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 35); }
		super.onBlockHarvested(worldIn, pos, state, playerIn);
	}

	@Override
	public void harvestBlock(World worldIn, PlayerEntity playerIn, BlockPos pos, BlockState state, @Nullable TileEntity te, ItemStack stack) {
		super.harvestBlock(worldIn, playerIn, pos, Blocks.AIR.getDefaultState(), te, stack);
	}

	/* Create Blockstate */
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(H_FACING, HALF, STAGE_1_11, WATERLOGGED);
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.BUDOUNOKI);
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

	public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
		return true;
	}
	
	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_wood_grape_nae").applyTextStyle(TextFormatting.GRAY));
	}
}
