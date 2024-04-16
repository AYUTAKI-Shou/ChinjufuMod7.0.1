package com.ayutaki.chinjufumod.blocks.kitchen;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage3_FaceWater;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
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

public class Kit_Ductend extends BaseStage3_FaceWater {

	/* Collision */
	protected static final VoxelShape S1_SOUTH = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 5.0D);
	protected static final VoxelShape S1_WEST = Block.box(11.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape S1_NORTH = Block.box(0.0D, 0.0D, 11.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape S1_EAST = Block.box(0.0D, 0.0D, 0.0D, 5.0D, 16.0D, 16.0D);

	protected static final VoxelShape S23_SOUTH = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape S23_WEST = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape S23_NORTH = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape S23_EAST = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

	public Kit_Ductend(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getItemInHand(hand);
		
		if (stack.isEmpty()) {
			if (playerIn.isCrouching()) {
				worldIn.playSound(null, pos, SoundEvents.METAL_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F);
				worldIn.setBlock(pos, state.cycle(STAGE_1_3), 3);
				return ActionResultType.SUCCESS; }
		}

		return ActionResultType.PASS;
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

		int i = state.getValue(STAGE_1_3);
		Direction direction = state.getValue(H_FACING);

		switch (direction) {
		case NORTH:
		default:
			return (i == 1)? S1_NORTH : S23_NORTH;
		case SOUTH:
			return (i == 1)? S1_SOUTH : S23_SOUTH;
		case WEST:
			return (i == 1)? S1_WEST : S23_WEST;
		case EAST:
			return (i == 1)? S1_EAST : S23_EAST;
		}
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_kit_ductend").withStyle(TextFormatting.GRAY));
	}
}
