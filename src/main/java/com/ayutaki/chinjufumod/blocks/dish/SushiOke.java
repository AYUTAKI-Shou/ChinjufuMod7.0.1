package com.ayutaki.chinjufumod.blocks.dish;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class SushiOke extends CM_WaterLogged {

	/* Property */
	public static final IntegerProperty STAGE_1_6 = IntegerProperty.create("stage", 1, 6);

	/* Collision */
	protected static final VoxelShape AABB_1 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.5D, 16.0D);
	protected static final VoxelShape AABB_2 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 5.0D, 16.0D);
	protected static final VoxelShape AABB_3 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 7.5D, 16.0D);
	protected static final VoxelShape AABB_4 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D);
	protected static final VoxelShape AABB_5 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.5D, 16.0D);
	protected static final VoxelShape AABB_6 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D);

	public SushiOke(AbstractBlock.Properties properties) {
		super(properties);

		/** Default state **/
		registerDefaultState(this.defaultBlockState().setValue(STAGE_1_6, Integer.valueOf(1))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		int i = state.getValue(STAGE_1_6);
		boolean mode = playerIn.abilities.instabuild;

		if (i != 6 && item == Items_Teatime.SUSHIOKE) {
			CMEvents.Consume1Item_Wood(worldIn, pos, playerIn, hand);
			worldIn.setBlock(pos, state.setValue(STAGE_1_6, Integer.valueOf(i + 1)), 3);
		}

		if (stack.isEmpty() && item != Items_Teatime.SUSHIOKE && hit.getDirection() == Direction.UP) {
			
			CMEvents.soundItemPick(worldIn, pos);
			if (!mode) { playerIn.inventory.add(new ItemStack(Items_Teatime.SUSHIOKE)); }
			if (mode) { }

			if (i != 1) { worldIn.setBlock(pos, state.setValue(STAGE_1_6, Integer.valueOf(i - 1)), 3); }
			if (i == 1) { worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), 3); }
		}
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* Gives a value when placed. */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);
		
		return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER));
	}

	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.getValue(WATERLOGGED)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }
		
		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}

	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(STAGE_1_6, WATERLOGGED);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		int i = state.getValue(STAGE_1_6);
		if (i == 2) { return AABB_2; }
		if (i == 3) { return AABB_3; }
		if (i == 4) { return AABB_4; }
		if (i == 5) { return AABB_5; }
		if (i == 6) { return AABB_6; }
		return AABB_1;
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.SUSHIOKE);
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
}
