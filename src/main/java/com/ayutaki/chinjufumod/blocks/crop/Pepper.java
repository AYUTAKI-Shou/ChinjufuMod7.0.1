package com.ayutaki.chinjufumod.blocks.crop;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.handler.CMEvents;
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
import net.minecraft.state.EnumProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tags.FluidTags;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
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

public class Pepper extends CM_WaterLogged {

	/* Property 0 1 2 3 4, 5 6 7 */
	public static final IntegerProperty STAGE_0_7 = IntegerProperty.create("stage", 0, 7);
	public static final EnumProperty<DoubleBlockHalf> HALF = EnumProperty.create("half", DoubleBlockHalf.class);
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");

	/* Collision */
	protected static final VoxelShape BOT_0 = Block.makeCuboidShape(5.5D, 0.0D, 5.5D, 10.5D, 12.0D, 10.5D);
	protected static final VoxelShape BOT_3 = Block.makeCuboidShape(3.5D, 0.0D, 3.5D, 12.5D, 16.0D, 12.5D);
	protected static final VoxelShape BOT_7 = Block.makeCuboidShape(2.5D, 0.0D, 2.5D, 13.5D, 16.0D, 13.5D);
	protected static final VoxelShape AABB_TOP = Block.makeCuboidShape(7.5D, 0.0D, 7.5D, 8.5D, 8.0D, 8.5D);
	protected static final VoxelShape TOP_3 = Block.makeCuboidShape(4.5D, 0.0D, 4.5D, 11.5D, 4.0D, 11.5D);
	protected static final VoxelShape TOP_7 = Block.makeCuboidShape(3.5D, 0.0D, 3.5D, 12.5D, 8.0D, 12.5D);
	
	public Pepper(Block.Properties properties) {
		super(properties);
		setDefaultState(this.stateContainer.getBaseState().with(STAGE_0_7, Integer.valueOf(0))
				.with(HALF, DoubleBlockHalf.LOWER)
				.with(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		int i = state.get(STAGE_0_7);

		BlockState lowFace = this.getDefaultState().with(HALF, DoubleBlockHalf.LOWER);
		BlockState upFace = this.getDefaultState().with(HALF, DoubleBlockHalf.UPPER);
		
		/** Too early to collect **/
		if (i < 6 && state.get(HALF) == DoubleBlockHalf.LOWER) {
			
			if (item == Items.BONE_MEAL) {
				CMEvents.Consume_1Item(playerIn, hand);
				
				for(int n = 0; n < 15; ++n) {
					double d0 = worldIn.rand.nextGaussian() * 0.02D;
					double d1 = worldIn.rand.nextGaussian() * 0.02D;
					double d2 = worldIn.rand.nextGaussian() * 0.02D;
					worldIn.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + worldIn.rand.nextFloat(), pos.getY() +worldIn.rand.nextFloat(), pos.getZ() + worldIn.rand.nextFloat(), d0, d1, d2); }

				worldIn.setBlockState(pos, lowFace.with(STAGE_0_7, Integer.valueOf(i + 2)), 3);
				worldIn.setBlockState(pos.up(), upFace.with(STAGE_0_7, Integer.valueOf(i + 2)), 3);
			}
			
			if (item != Items.BONE_MEAL) {
				if (!stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (stack.isEmpty()) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }	
			}
		}
		
		/** Can harvest **/
		if (i >= 6 && state.get(HALF) == DoubleBlockHalf.UPPER) {
			if (stack.isEmpty()) {
				
				CMEvents.soundTake_Pick(worldIn, pos);
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.PEPPER_RAW, 4));

				worldIn.setBlockState(pos, upFace.with(STAGE_0_7, Integer.valueOf(4)), 3);
				worldIn.setBlockState(pos.down(), lowFace.with(STAGE_0_7, Integer.valueOf(4)), 3); }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}

		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* Limit the place. */
	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return (state.getMaterial() == Material.EARTH && state.getMaterial().isSolid());
	}

	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockPos downPos = pos.down();
		return this.isValidGround(worldIn.getBlockState(downPos), worldIn, downPos);
	}
	
	/* Gives a value when placed. */
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getWorld();
		BlockPos pos = context.getPos();
		IFluidState fluid = worldIn.getFluidState(pos);

		float temp = worldIn.getBiome(pos).getTemperature(pos);
		PlayerEntity playerIn = context.getPlayer();
		
		if (temp >= 0.5F) {
			/** pos.up() = Replaceable block. **/
			if (pos.getY() < 255 && worldIn.getBlockState(pos.up()).isReplaceable(context)) {
				return this.getDefaultState().with(WATERLOGGED, fluid.getFluid() == Fluids.WATER); }
	
			else { return null; }
		}
		
		else {
			playerIn.sendStatusMessage(new TranslationTextComponent("text.chinjufumod.too_cold"), true);
			return null; }
	}
	
	/* Add DoubleBlockHalf.UPPER on the Block. */
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		IFluidState fluidUp = worldIn.getFluidState(pos.up());

		worldIn.setBlockState(pos.up(), this.getDefaultState().with(HALF, DoubleBlockHalf.UPPER)
				.with(WATERLOGGED, Boolean.valueOf(fluidUp.isTagged(FluidTags.WATER))), 3);
	}

	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	@Override
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {

		BlockState state1 = super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
		if (!state1.isAir(worldIn, pos)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
		}

		DoubleBlockHalf half = state.get(HALF);
		if (facing.getAxis() != Direction.Axis.Y || half == DoubleBlockHalf.LOWER != (facing == Direction.UP) ||
				 facingState.getBlock() == this && facingState.get(HALF) != half) {
			return half == DoubleBlockHalf.LOWER && facing == Direction.DOWN && !state.isValidPosition(worldIn, pos) ?
					 Blocks.AIR.getDefaultState() : super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
		}

		else {
			return Blocks.AIR.getDefaultState();
		}
	}

	public boolean isReplaceable(BlockState state, BlockItemUseContext useContext) {
		return false;
	}

	/* TickRandom. Growth rate similar to that of wheat. rand.nextInt(8) == 0 */
	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		BlockState upState = worldIn.getBlockState(pos.up());
		DoubleBlockHalf half = state.get(HALF);
		int i = state.get(STAGE_0_7);
		/** Property 0 1 2 3 4, 5 6 7 **/
		BlockState lowFace = this.getDefaultState().with(HALF, DoubleBlockHalf.LOWER);
		BlockState upFace = this.getDefaultState().with(HALF, DoubleBlockHalf.UPPER);
		
		if (!worldIn.isAreaLoaded(pos, 2)) { return; }

		switch (half) {
		case LOWER:
		default:
			float temp = worldIn.getBiome(pos).getTemperature(pos);
			boolean water = (state.get(WATERLOGGED) || upState.get(WATERLOGGED));
			
			if (temp >= 0.5F) {
				if (!water) {
					if (i < 7 && worldIn.getLightSubtracted(pos, 0) >= 9 && rand.nextInt(8) == 0) {
						worldIn.setBlockState(pos, lowFace.with(STAGE_0_7, Integer.valueOf(i + 1)), 3);
						worldIn.setBlockState(pos.up(), upFace.with(STAGE_0_7, Integer.valueOf(i + 1)), 3); }
			
					if (i == 7) { } }//It is not Waterlogged.
				
				if (water) {
					if (i > 4 && rand.nextInt(2) == 0) {
						worldIn.setBlockState(pos, lowFace.with(STAGE_0_7, Integer.valueOf(4)), 3);
						worldIn.setBlockState(pos.up(), upFace.with(STAGE_0_7, Integer.valueOf(4)), 3);
						this.dropRottenfood(worldIn, pos); }
					
					else { } }
			}
			
			if (temp < 0.5F && rand.nextInt(1) == 0) {
				worldIn.destroyBlock(pos, true);
				worldIn.destroyBlock(pos.up(), false); }
			break;

		case UPPER : break;
		} // switch LOWER-UPPER
	}

	protected void dropRottenfood(ServerWorld worldIn, BlockPos pos) {
		ItemStack stack = new ItemStack(Items_NoTab.ROTTEN_FOOD);
		InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		boolean half = (state.get(HALF) == DoubleBlockHalf.UPPER);
		int i = state.get(STAGE_0_7);

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

	/* Destroy at the same time. & Drop item. */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {

		BlockState upState = worldIn.getBlockState(pos.up());
		BlockState downState = worldIn.getBlockState(pos.down());

		if (downState.getBlock() == this && !playerIn.isCreative()) { worldIn.destroyBlock(pos.down(), true); }
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
		builder.add(STAGE_0_7, HALF, WATERLOGGED);
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.SEEDS_PEPPER);
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
		tooltip.add(new TranslationTextComponent("tips.block_wood_mikan").applyTextStyle(TextFormatting.GRAY));
	}
}
