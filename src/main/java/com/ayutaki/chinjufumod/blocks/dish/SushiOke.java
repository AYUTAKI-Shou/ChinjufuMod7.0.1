package com.ayutaki.chinjufumod.blocks.dish;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
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
	protected static final VoxelShape AABB_1 = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.5D, 16.0D);
	protected static final VoxelShape AABB_2 = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 5.0D, 16.0D);
	protected static final VoxelShape AABB_3 = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 7.5D, 16.0D);
	protected static final VoxelShape AABB_4 = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D);
	protected static final VoxelShape AABB_5 = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.5D, 16.0D);
	protected static final VoxelShape AABB_6 = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D);

	public SushiOke(Block.Properties properties) {
		super(properties);

		/** Default state **/
		setDefaultState(this.stateContainer.getBaseState().with(STAGE_1_6, Integer.valueOf(1))
				.with(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		int i = state.get(STAGE_1_6);
		boolean mode = playerIn.abilities.isCreativeMode;

		if (i !=6 && item == Items_Teatime.SUSHIOKE) {
			CMEvents.Consume1Item_Wood(worldIn, pos, playerIn, hand);			
			worldIn.setBlockState(pos, state.with(STAGE_1_6, Integer.valueOf(i + 1)));
		}

		if (stack.isEmpty() && item != Items_Teatime.SUSHIOKE && hit.getFace() == Direction.UP) {

			CMEvents.soundItemPick(worldIn, pos);
			if (!mode) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SUSHIOKE)); }
			if (mode) { }

			if (i != 1) { worldIn.setBlockState(pos, state.with(STAGE_1_6, Integer.valueOf(i - 1))); }
			if (i == 1) { worldIn.setBlockState(pos, Blocks.AIR.getDefaultState()); }
		}
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* Gives a value when placed. */
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getWorld();
		BlockPos pos = context.getPos();
		IFluidState fluid = worldIn.getFluidState(pos);
		
		return this.getDefaultState().with(WATERLOGGED, fluid.getFluid() == Fluids.WATER);
	}

	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn)); }
		
		return super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
	}

	/* Create Blockstate */
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(STAGE_1_6, WATERLOGGED);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		int i = state.get(STAGE_1_6);
		if (i == 2) { return AABB_2; }
		if (i == 3) { return AABB_3; }
		if (i == 4) { return AABB_4; }
		if (i == 5) { return AABB_5; }
		if (i == 6) { return AABB_6; }
		return AABB_1;
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
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
}
