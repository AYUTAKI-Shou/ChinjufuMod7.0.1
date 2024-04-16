package com.ayutaki.chinjufumod.blocks.gakki;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage2_FaceWater;
import com.ayutaki.chinjufumod.handler.CMEvents;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
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
	protected static final VoxelShape BOT_SOUTH = Block.box(4.0D, 1.0D, 4.0D, 12.0D, 6.5D, 13.0D);
	protected static final VoxelShape BOT_WEST = Block.box(3.0D, 1.0D, 4.0D, 12.0D, 6.5D, 12.0D);
	protected static final VoxelShape BOT_NORTH = Block.box(4.0D, 1.0D, 3.0D, 12.0D, 6.5D, 12.0D);
	protected static final VoxelShape BOT_EAST = Block.box(4.0D, 1.0D, 4.0D, 13.0D, 6.5D, 12.0D);

	protected static final VoxelShape BOT2_SOUTH = Block.box(4.0D, 11.0D, 4.0D, 12.0D, 16.0D, 13.0D);
	protected static final VoxelShape BOT2_WEST = Block.box(3.0D, 11.0D, 4.0D, 12.0D, 16.0D, 12.0D);
	protected static final VoxelShape BOT2_NORTH = Block.box(4.0D, 11.0D, 3.0D, 12.0D, 16.0D, 12.0D);
	protected static final VoxelShape BOT2_EAST = Block.box(4.0D, 11.0D, 4.0D, 13.0D, 16.0D, 12.0D);


	public Wadaiko_Small(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();

		if (!playerIn.isCrouching()) {
			if (hit.getDirection() == Direction.UP) {
				if (item == Items.STICK) { CMEvents.wadaikoTop(worldIn, pos, 0.8F, 1.4F); }
				else { CMEvents.wadaikoTop(worldIn, pos, 0.2F, 1.4F); } }

			if (hit.getDirection() != Direction.UP) {
				if (item == Items.STICK) { CMEvents.wadaikoSide(worldIn, pos, 0.8F, 1.3F); }
				else { CMEvents.wadaikoSide(worldIn, pos, 0.2F, 1.3F); } }
		}

		if (playerIn.isCrouching()) {
			if (stack.isEmpty()) {
				CMEvents.soundWoodPlace(worldIn, pos);
				worldIn.setBlock(pos, state.cycle(STAGE_1_2), 3); }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		return ActionResultType.SUCCESS;
	}

	/* Gives a value when placed. */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);
		PlayerEntity playerIn = context.getPlayer();
		
		if (playerIn.isCrouching()) {
			return this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection().getOpposite())
					.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER))
					.setValue(STAGE_1_2, Integer.valueOf(2)); }

		else { return this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection().getOpposite())
				.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER))
				.setValue(STAGE_1_2, Integer.valueOf(1)); }
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.getValue(H_FACING);
		int i = state.getValue(STAGE_1_2);

		switch (direction) {
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
	public BlockRenderType getRenderShape(BlockState state) {
		return BlockRenderType.MODEL;
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
		tooltip.add(new TranslationTextComponent("tips.block_wadaiko").withStyle(TextFormatting.GRAY));
	}
}
