package com.ayutaki.chinjufumod.blocks.gakki;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage2_FaceWater;
import com.ayutaki.chinjufumod.handler.CMEvents;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
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
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

public class Wadaiko_Small extends BaseStage2_FaceWater {

	/* Collision */
	protected static final VoxelShape BOT_SOUTH = Block.makeCuboidShape(4.0D, 1.0D, 4.0D, 12.0D, 6.5D, 13.0D);
	protected static final VoxelShape BOT_WEST = Block.makeCuboidShape(3.0D, 1.0D, 4.0D, 12.0D, 6.5D, 12.0D);
	protected static final VoxelShape BOT_NORTH = Block.makeCuboidShape(4.0D, 1.0D, 3.0D, 12.0D, 6.5D, 12.0D);
	protected static final VoxelShape BOT_EAST = Block.makeCuboidShape(4.0D, 1.0D, 4.0D, 13.0D, 6.5D, 12.0D);

	protected static final VoxelShape BOT2_SOUTH = Block.makeCuboidShape(4.0D, 11.0D, 4.0D, 12.0D, 16.0D, 13.0D);
	protected static final VoxelShape BOT2_WEST = Block.makeCuboidShape(3.0D, 11.0D, 4.0D, 12.0D, 16.0D, 12.0D);
	protected static final VoxelShape BOT2_NORTH = Block.makeCuboidShape(4.0D, 11.0D, 3.0D, 12.0D, 16.0D, 12.0D);
	protected static final VoxelShape BOT2_EAST = Block.makeCuboidShape(4.0D, 11.0D, 4.0D, 13.0D, 16.0D, 12.0D);


	public Wadaiko_Small(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();

		if (!playerIn.isSneaking()) {

			if (hit.getFace() == Direction.UP) {
				if (item == Items.STICK) { CMEvents.wadaikoTop(worldIn, pos, 0.8F, 1.4F); }
				else { CMEvents.wadaikoTop(worldIn, pos, 0.2F, 1.4F); } }

			if (hit.getFace() != Direction.UP) {
				if (item == Items.STICK) { CMEvents.wadaikoSide(worldIn, pos, 0.8F, 1.3F); }
				else { CMEvents.wadaikoSide(worldIn, pos, 0.2F, 1.3F); } }
		}

		if (playerIn.isSneaking()) {
			if (stack.isEmpty()) {
				CMEvents.soundWoodPlace(worldIn, pos);
				worldIn.setBlockState(pos, state.cycle(STAGE_1_2)); }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		return ActionResultType.SUCCESS;
	}

	/* Gives a value when placed. */
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getWorld();
		BlockPos pos = context.getPos();
		IFluidState fluid = worldIn.getFluidState(pos);
		PlayerEntity playerIn = context.getPlayer();

		if (playerIn.isSneaking()) {
			return this.getDefaultState().with(H_FACING, context.getPlacementHorizontalFacing().getOpposite())
					.with(WATERLOGGED, fluid.getFluid() == Fluids.WATER)
					.with(STAGE_1_2, Integer.valueOf(2)); }

		else { return this.getDefaultState().with(H_FACING, context.getPlacementHorizontalFacing().getOpposite())
				.with(WATERLOGGED, fluid.getFluid() == Fluids.WATER)
				.with(STAGE_1_2, Integer.valueOf(1)); }
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(H_FACING);
		int i = state.get(STAGE_1_2);

		switch(direction) {
		case NORTH:
		default:
			return (i == 1)? BOT_NORTH : BOT2_NORTH;
		case SOUTH:
			return (i == 1)? BOT_SOUTH : BOT2_SOUTH;
		case WEST:
			return (i == 1)? BOT_WEST : BOT2_WEST;
		case EAST:
			return (i == 1)? BOT_EAST : BOT2_EAST;
		}
	}

	@Override
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.MODEL;
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
		tooltip.add(new TranslationTextComponent("tips.block_wadaiko").applyTextStyle(TextFormatting.GRAY));
	}
}
