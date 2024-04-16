package com.ayutaki.chinjufumod.blocks.kamoi;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage4_FaceWater;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

public class Base_Kamoi extends BaseStage4_FaceWater {

	/* Collision */
	protected static final VoxelShape BOTTOM = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
	protected static final VoxelShape TOP = Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape SOUTH_2 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 8.0D);
	protected static final VoxelShape WEST_2 = Block.box(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape NORTH_2 = Block.box(0.0D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape EAST_2 = Block.box(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 16.0D);
	protected static final VoxelShape SOUTH_3 = VoxelShapes.or(Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 8.0D),
																		Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D));
	protected static final VoxelShape WEST_3 = VoxelShapes.or(Block.box(8.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D),
																		Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D));
	protected static final VoxelShape NORTH_3 = VoxelShapes.or(Block.box(0.0D, 8.0D, 8.0D, 16.0D, 16.0D, 16.0D),
																		Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D));
	protected static final VoxelShape EAST_3 = VoxelShapes.or(Block.box(0.0D, 8.0D, 0.0D, 8.0D, 16.0D, 16.0D),
																		Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D));

	public Base_Kamoi(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

		Direction direction = state.getValue(H_FACING);
		int i = state.getValue(STAGE_1_4);

		switch (direction) {
		case NORTH:
		default:
			return (i == 1)? BOTTOM : ((i == 2)? NORTH_2 : ((i == 3)? NORTH_3 : TOP));
		case SOUTH:
			return (i == 1)? BOTTOM : ((i == 2)? SOUTH_2 : ((i == 3)? SOUTH_3 : TOP));
		case WEST:
			return (i == 1)? BOTTOM : ((i == 2)? WEST_2 : ((i == 3)? WEST_3 : TOP));
		case EAST:
			return (i == 1)? BOTTOM : ((i == 2)? EAST_2 : ((i == 3)? EAST_3 : TOP));
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
		tooltip.add(new TranslationTextComponent("tips.wp_stage4").withStyle(TextFormatting.GRAY));
	}
}
