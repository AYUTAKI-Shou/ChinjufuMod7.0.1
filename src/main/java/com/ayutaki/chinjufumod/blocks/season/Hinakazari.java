package com.ayutaki.chinjufumod.blocks.season;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage4_FaceWater;
import com.ayutaki.chinjufumod.handler.CMEvents;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
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

public class Hinakazari extends BaseStage4_FaceWater {

	/* Collision */
	protected static final VoxelShape S1_SOUTH = Block.box(0.0D, 0.1D, 0.0D, 12.0D, 16.0D, 16.0D);
	protected static final VoxelShape S1_WEST = Block.box(0.0D, 0.1D, 0.0D, 16.0D, 16.0D, 12.0D);
	protected static final VoxelShape S1_NORTH = Block.box(4.0D, 0.1D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape S1_EAST = Block.box(0.0D, 0.1D, 4.0D, 16.0D, 16.0D, 16.0D);

	protected static final VoxelShape S2_SOUTH = Block.box(0.0D, 0.1D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape S2_WEST = Block.box(0.0D, 0.1D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape S2_NORTH = Block.box(0.0D, 0.1D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape S2_EAST = Block.box(0.0D, 0.1D, 0.0D, 16.0D, 16.0D, 16.0D);

	protected static final VoxelShape S3_SOUTH = Block.box(0.0D, 0.1D, 0.0D, 12.0D, 12.0D, 16.0D);
	protected static final VoxelShape S3_WEST = Block.box(0.0D, 0.1D, 0.0D, 16.0D, 12.0D, 12.0D);
	protected static final VoxelShape S3_NORTH = Block.box(4.0D, 0.1D, 0.0D, 16.0D, 12.0D, 16.0D);
	protected static final VoxelShape S3_EAST = Block.box(0.0D, 0.1D, 4.0D, 16.0D, 12.0D, 16.0D);

	protected static final VoxelShape S4_SOUTH = Block.box(0.0D, 0.1D, 0.0D, 16.0D, 12.0D, 16.0D);
	protected static final VoxelShape S4_WEST = Block.box(0.0D, 0.1D, 0.0D, 16.0D, 12.0D, 16.0D);
	protected static final VoxelShape S4_NORTH = Block.box(0.0D, 0.1D, 0.0D, 16.0D, 12.0D, 16.0D);
	protected static final VoxelShape S4_EAST = Block.box(0.0D, 0.1D, 0.0D, 16.0D, 12.0D, 16.0D);


	public Hinakazari(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getItemInHand(hand);
		
		if (stack.isEmpty()) {
			if (playerIn.isCrouching()) {
				CMEvents.soundWoodPlace(worldIn, pos);
				worldIn.setBlock(pos, state.cycle(STAGE_1_4), 3);
				return ActionResultType.SUCCESS; }
			
			if (!playerIn.isCrouching()) {
				CMEvents.textNotSneak(worldIn, pos, playerIn);
				return ActionResultType.SUCCESS; }
		}

		return ActionResultType.PASS;
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

		int i = state.getValue(STAGE_1_4);
		Direction direction = state.getValue(H_FACING);

		switch (direction) {
		case NORTH:
		default:
			return (i == 1)? S1_NORTH : ((i == 2)? S2_NORTH : ((i == 3)? S3_NORTH : S4_NORTH));
		case SOUTH:
			return (i == 1)? S1_SOUTH : ((i == 2)? S2_SOUTH : ((i == 3)? S3_SOUTH : S4_SOUTH));
		case WEST:
			return (i == 1)? S1_WEST : ((i == 2)? S2_WEST : ((i == 3)? S3_WEST : S4_WEST));
		case EAST:
			return (i == 1)? S1_EAST : ((i == 2)? S2_EAST : ((i == 3)? S3_EAST : S4_EAST));
		}
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
		tooltip.add(new TranslationTextComponent("tips.block_hinakazari").withStyle(TextFormatting.GRAY));
	}
}
