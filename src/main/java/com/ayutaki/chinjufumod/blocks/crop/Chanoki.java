package com.ayutaki.chinjufumod.blocks.crop;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
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

public class Chanoki extends CM_WaterLogged {

	/* Property */
	public static final IntegerProperty STAGE_0_4 = IntegerProperty.create("stage", 0, 4);

	/* Collision */
	protected static final VoxelShape AABB_BASE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 0.1D, 14.0D);
	
	protected static final VoxelShape AABB_0 = VoxelShapes.or(AABB_BASE, Block.box(7.0D, 0.1D, 7.0D, 9.0D, 12.0D, 9.0D));
	protected static final VoxelShape AABB_1 = VoxelShapes.or(AABB_BASE, Block.box(2.0D, 4.0D, 2.0D, 14.0D, 14.0D, 14.0D),
			Block.box(7.0D, 0.1D, 7.0D, 9.0D, 4.0D, 9.0D));
	protected static final VoxelShape AABB_2 = VoxelShapes.or(AABB_BASE, Block.box(1.0D, 4.0D, 1.0D, 15.0D, 15.0D, 15.0D),
			Block.box(7.0D, 0.1D, 7.0D, 9.0D, 4.0D, 9.0D));
	protected static final VoxelShape AABB_3 = VoxelShapes.or(AABB_BASE, Block.box(0.5D, 3.5D, 0.5D, 15.5D, 15.5D, 15.5D),
			Block.box(7.0D, 0.1D, 7.0D, 9.0D, 3.5D, 9.0D));
	protected static final VoxelShape AABB_4 = VoxelShapes.or(AABB_BASE, Block.box(0.0D, 3.5D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.box(7.0D, 0.1D, 7.0D, 9.0D, 3.5D, 9.0D));

	public Chanoki(AbstractBlock.Properties properties) {
		super(properties);
		registerDefaultState(this.defaultBlockState().setValue(STAGE_0_4, Integer.valueOf(0))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		int i = state.getValue(STAGE_0_4);

		/** Too early to collect **/
		if (i != 4) {
			
			if (item == Items.BONE_MEAL) {
				CMEvents.Consume_1Item(playerIn, hand);
	
				for(int n = 0; n < 15; ++n) {
					double d0 = worldIn.random.nextGaussian() * 0.02D;
					double d1 = worldIn.random.nextGaussian() * 0.02D;
					double d2 = worldIn.random.nextGaussian() * 0.02D;
					worldIn.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + worldIn.random.nextFloat(), pos.getY() +worldIn.random.nextFloat(), pos.getZ() + worldIn.random.nextFloat(), d0, d1, d2); }
				
				if (i < 3) { worldIn.setBlock(pos, state.setValue(STAGE_0_4, Integer.valueOf(i + 2)), 3); }
				if (i == 3) { worldIn.setBlock(pos, state.setValue(STAGE_0_4, Integer.valueOf(i + 1)), 3); }
			}
		
			if (item != Items.BONE_MEAL) {
				if (!stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (stack.isEmpty()) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }	
			}
		}
		
		/** Can harvest **/
		if (i == 4) {

			if (stack.isEmpty()) {
				CMEvents.soundTake_Pick(worldIn, pos);
				playerIn.inventory.add(new ItemStack(Items_Teatime.CHABA, 4));
				
				worldIn.setBlock(pos, state.setValue(STAGE_0_4, Integer.valueOf(i - 1)), 3); }

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

		/** pos.up() = Replaceable block. **/
		if (pos.getY() < 255 && worldIn.getBlockState(pos.above()).canBeReplaced(context)) {
			return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)); }

		else { return null; }
	}
	
	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.getValue(WATERLOGGED)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }
		
		return facing == Direction.DOWN && !state.canSurvive(worldIn, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}
	
	/* TickRandom. Slow growth rate. rand.nextInt(12) == 0 */
	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		int i = state.getValue(STAGE_0_4);

		if (!worldIn.isAreaLoaded(pos, 2)) { return; }

		if (i < 4 && worldIn.getRawBrightness(pos, 0) >= 9 && state.getValue(WATERLOGGED) == false && rand.nextInt(12) == 0) {
			worldIn.setBlock(pos, state.setValue(STAGE_0_4, Integer.valueOf(i + 1)), 2);
		}

		else { }
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		int i = state.getValue(STAGE_0_4);
		
		switch (i) {
		case 0:
		default:
			return AABB_0;
		case 1:
			return AABB_1;
		case 2:
			return AABB_2;
		case 3:
			return AABB_3;
		case 4:
			return AABB_4;
		} // switch
	}

	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(STAGE_0_4, WATERLOGGED);
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.CHANOKI);
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
		tooltip.add(new TranslationTextComponent("tips.block_wood_chanoki_nae").withStyle(TextFormatting.GRAY));
	}
}
