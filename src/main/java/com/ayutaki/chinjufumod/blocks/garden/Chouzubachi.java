package com.ayutaki.chinjufumod.blocks.garden;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
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
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

public class Chouzubachi extends CM_WaterLogged {

	/* Property 空=0,1,2,3=満,4=溢 */
	public static final IntegerProperty STAGE_0_3 = IntegerProperty.create("stage", 0, 3);

	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 10.0D, 15.0D);

	public Chouzubachi(Block.Properties properties) {
		super(properties);

		/** Default state **/
		setDefaultState(this.stateContainer.getBaseState().with(STAGE_0_3, Integer.valueOf(0))
				.with(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		int i = state.get(STAGE_0_3);

		if (!state.get(WATERLOGGED)) {
			if (i > 0) {
				if (stack.isEmpty()) {
					CMEvents.soundWaterUse(worldIn, pos);
					worldIn.setBlockState(pos, state.with(STAGE_0_3, Integer.valueOf(i - 1))); }
				
				if (!stack.isEmpty()) {
					CMEvents.textFullItem(worldIn, pos, playerIn); }
			}
			
			if (i < 3) {
				if (item == Items.WATER_BUCKET) {

					CMEvents.WaterBucket_Empty(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, state.with(STAGE_0_3, Integer.valueOf(3))); }
				
				if (item == Items_Teatime.MIZUOKE_full) {

					CMEvents.MIZUOKEfull_Empty(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, state.with(STAGE_0_3, Integer.valueOf(3))); }
				
				if (i == 0 && item != Items.WATER_BUCKET && item != Items_Teatime.MIZUOKE_full) { 
					CMEvents.textNotHave(worldIn, pos, playerIn); }
			}
		}
		
		if (state.get(WATERLOGGED)) { 
			CMEvents.textIsWaterlogged(worldIn, pos, playerIn);
			return ActionResultType.SUCCESS;
		}

		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* Gives a value when placed. +180 .getOpposite() */
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getWorld();
		BlockPos pos = context.getPos();
		IFluidState fluid = worldIn.getFluidState(pos);

		return this.getDefaultState().with(WATERLOGGED, fluid.getFluid() == Fluids.WATER);
	}

	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.get(WATERLOGGED)) { worldIn.getPendingBlockTicks().scheduleTick(pos, this, 10); }

		return super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
	}

	/* TickRandom */
	@Override
	public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		if ((Boolean)state.get(WATERLOGGED)) { worldIn.getPendingBlockTicks().scheduleTick(pos, this, 10); }
	}

	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		int i = state.get(STAGE_0_3);

		if (i != 3 && state.get(WATERLOGGED)) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, this, 10);
			CMEvents.soundBubble(worldIn, pos);
			worldIn.setBlockState(pos, state.with(STAGE_0_3, Integer.valueOf(3))); }
	}

	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		int i = state.get(STAGE_0_3);

		if (i != 3 && !state.get(WATERLOGGED) && worldIn.isRainingAt(pos.up())) {
			if (rand.nextInt(1) == 0) { worldIn.setBlockState(pos, state.with(STAGE_0_3, Integer.valueOf(i + 1))); }
		}
	}
	
	/* Create Blockstate */
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(STAGE_0_3, WATERLOGGED);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return AABB_BOX;
	}

	/* The best harvesting tool. */
	@Nullable
	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.PICKAXE;
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
	
	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_chouzubachi").applyTextStyle(TextFormatting.GRAY));
	}
}
