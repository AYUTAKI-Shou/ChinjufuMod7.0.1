package com.ayutaki.chinjufumod.blocks.crop;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.handler.CMEvents;
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
import net.minecraft.state.EnumProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.DoubleBlockHalf;
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

	/* Collision */
	protected static final VoxelShape BOT_0 = Block.box(5.5D, 0.0D, 5.5D, 10.5D, 12.0D, 10.5D);
	protected static final VoxelShape BOT_3 = Block.box(3.5D, 0.0D, 3.5D, 12.5D, 16.0D, 12.5D);
	protected static final VoxelShape BOT_7 = Block.box(2.5D, 0.0D, 2.5D, 13.5D, 16.0D, 13.5D);
	protected static final VoxelShape AABB_TOP = Block.box(7.5D, 0.0D, 7.5D, 8.5D, 8.0D, 8.5D);
	protected static final VoxelShape TOP_3 = Block.box(4.5D, 0.0D, 4.5D, 11.5D, 4.0D, 11.5D);
	protected static final VoxelShape TOP_7 = Block.box(3.5D, 0.0D, 3.5D, 12.5D, 8.0D, 12.5D);

	public Pepper(AbstractBlock.Properties properties) {
		super(properties);
		registerDefaultState(this.defaultBlockState().setValue(STAGE_0_7, Integer.valueOf(0))
				.setValue(HALF, DoubleBlockHalf.LOWER)
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		int i = state.getValue(STAGE_0_7);
		/** Property 0 1 2 3 4, 5 6 7 **/
		
		BlockState lowFace = this.defaultBlockState().setValue(HALF, DoubleBlockHalf.LOWER);
		BlockState upFace = this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER);
		
		/** Too early to collect **/
		if (i < 6 && state.getValue(HALF) == DoubleBlockHalf.LOWER) {
			
			if (item == Items.BONE_MEAL) {
				CMEvents.Consume_1Item(playerIn, hand);
	
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
				playerIn.inventory.add(new ItemStack(Items_Teatime.PEPPER_RAW, 4));
	
				worldIn.setBlock(pos, lowFace.setValue(STAGE_0_7, Integer.valueOf(4)), 3);
				worldIn.setBlock(pos.above(), upFace.setValue(STAGE_0_7, Integer.valueOf(4)), 3); }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* Limit the place. */
	protected boolean mayPlaceOn(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return (state.getMaterial() == Material.DIRT && state.getMaterial().isSolid());
	}

	@Override
	public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockPos downPos = pos.below();
		return this.mayPlaceOn(worldIn.getBlockState(downPos), worldIn, downPos);
	}
	
	/* Gives a value when placed. */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);
		
		float temp = worldIn.getBiome(pos).getTemperature(pos);
		PlayerEntity playerIn = context.getPlayer();
		
		if (temp >= 0.5F) {
			/** pos.up() = Replaceable block. **/
			if (pos.getY() < 255 && worldIn.getBlockState(pos.above()).canBeReplaced(context)) {
				return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)); }
	
			else { return null; }
		}
		
		else {
			playerIn.displayClientMessage(new TranslationTextComponent("text.chinjufumod.too_cold"), true);
			return null; }
	}

	/* Add DoubleBlockHalf.UPPER on the Block. */
	public void setPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		FluidState fluidUp = worldIn.getFluidState(pos.above());

		worldIn.setBlock(pos.above(), this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER)
				.setValue(WATERLOGGED, Boolean.valueOf(fluidUp.getType() == Fluids.WATER)), 3);
	}

	public boolean canBeReplaced(BlockState state, BlockItemUseContext context) {
		return false;
	}
	
	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {

		BlockState state1 = super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
		if (!state1.isAir(worldIn, pos)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }

		DoubleBlockHalf half = state.getValue(HALF);
		if (facing.getAxis() != Direction.Axis.Y || half == DoubleBlockHalf.LOWER != (facing == Direction.UP) ||
				 facingState.getBlock() == this && facingState.getValue(HALF) != half) {
			return half == DoubleBlockHalf.LOWER && facing == Direction.DOWN && !state.canSurvive(worldIn, pos) ?
					 Blocks.AIR.defaultBlockState() : super.updateShape(state, facing, facingState, worldIn, pos, facingPos); }

		else { return Blocks.AIR.defaultBlockState(); }
	}
	
	/* TickRandom. Growth rate similar to that of wheat. rand.nextInt(8) == 0 */
	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

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
			float temp = worldIn.getBiome(pos).getTemperature(pos);
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

	protected void dropRottenfood(ServerWorld worldIn, BlockPos pos) {
		ItemStack stack = new ItemStack(Items_NoTab.ROTTEN_FOOD);
		InventoryHelper.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
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
		builder.add(STAGE_0_7, HALF, WATERLOGGED);
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.SEEDS_PEPPER);
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
		tooltip.add(new TranslationTextComponent("tips.item_seeds_pepper").withStyle(TextFormatting.GRAY));
	}
}
