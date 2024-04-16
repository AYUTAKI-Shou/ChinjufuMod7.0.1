package com.ayutaki.chinjufumod.blocks.unitblock;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
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
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Wagasa extends BaseUnitBlock {

	/* Collision */
	protected static final VoxelShape TTTT = VoxelShapes.or(Block.box(6.0D, 14.0D, 6.0D, 10.0D, 16.0D, 10.0D),
			Block.box(6.0D, 13.25D, 6.0D, 10.0D, 14.0D, 10.0D),
			Block.box(4.0D, 12.5D, 4.0D, 12.0D, 13.25D, 12.0D),
			Block.box(2.0D, 11.75D, 2.0D, 14.0D, 12.5D, 14.0D),
			Block.box(0.0D, 11.0D, 0.0D, 16.0D, 11.75D, 16.0D),
			Block.box(6.0D, 0.0D, 6.0D, 10.0D, 11.0D, 10.0D));

	protected static final VoxelShape FFFF = VoxelShapes.or(Block.box(7.5D, 15.0D, 7.5D, 8.5D, 16.0D, 8.5D),
			Block.box(7.0D, 14.0D, 7.0D, 9.0D, 15.0D, 9.0D),
			Block.box(6.5D, 13.0D, 6.5D, 9.5D, 14.0D, 9.5D),
			Block.box(6.0D, 12.0D, 6.0D, 10.0D, 13.0D, 10.0D),
			Block.box(5.5D, 11.0D, 5.5D, 10.5D, 12.0D, 10.5D),
			Block.box(5.0D, 10.0D, 5.0D, 11.0D, 11.0D, 11.0D),
			Block.box(4.5D, 9.0D, 4.5D, 11.5D, 10.0D, 11.5D),
			Block.box(4.0D, 8.0D, 4.0D, 12.0D, 9.0D, 12.0D),
			Block.box(3.5D, 7.0D, 3.5D, 12.5D, 8.0D, 12.5D),
			Block.box(3.0D, 6.0D, 3.0D, 13.0D, 7.0D, 13.0D),
			Block.box(2.5D, 5.0D, 2.5D, 13.5D, 6.0D, 13.5D),
			Block.box(7.5D, 0.0D, 7.5D, 8.5D, 5.0D, 8.5D));

	protected static final VoxelShape TTFF = VoxelShapes.or(Block.box(14.0D, 10.25D, 0.0D, 16.0D, 11.0D, 2.0D),
			Block.box(12.0D, 9.5D, 0.0D, 16.0D, 10.25D, 4.0D),
			Block.box(10.0D, 8.75D, 0.0D, 16.0D, 9.5D, 6.0D),
			Block.box(8.0D, 8.0D, 0.0D, 16.0D, 8.75D, 8.0D),
			Block.box(6.0D, 7.25D, 0.0D, 16.0D, 8.0D, 10.0D),
			Block.box(4.0D, 6.5D, 0.0D, 16.0D, 7.25D, 12.0D),
			Block.box(2.0D, 5.75D, 0.0D, 16.0D, 6.5D, 14.0D),
			Block.box(0.0D, 5.0D, 0.0D, 16.0D, 5.75D, 16.0D));

	protected static final VoxelShape FTFT = VoxelShapes.or(Block.box(0.0D, 10.25D, 0.0D, 2.0D, 11.0D, 2.0D),
			Block.box(0.0D, 9.5D, 0.0D, 4.0D, 10.25D, 4.0D),
			Block.box(0.0D, 8.75D, 0.0D, 6.0D, 9.5D, 6.0D),
			Block.box(0.0D, 8.0D, 0.0D, 8.0D, 8.75D, 8.0D),
			Block.box(0.0D, 7.25D, 0.0D, 10.0D, 8.0D, 10.0D),
			Block.box(0.0D, 6.5D, 0.0D, 12.0D, 7.25D, 12.0D),
			Block.box(0.0D, 5.75D, 0.0D, 14.0D, 6.5D, 14.0D),
			Block.box(0.0D, 5.0D, 0.0D, 16.0D, 5.75D, 16.0D));
	protected static final VoxelShape TFTF = VoxelShapes.or(Block.box(14.0D, 10.25D, 14.0D, 16.0D, 11.0D, 16.0D),
			Block.box(12.0D, 9.5D, 12.0D, 16.0D, 10.25D, 16.0D),
			Block.box(10.0D, 8.75D, 10.0D, 16.0D, 9.5D, 16.0D),
			Block.box(8.0D, 8.0D, 8.0D, 16.0D, 8.75D, 16.0D),
			Block.box(6.0D, 7.25D, 6.0D, 16.0D, 8.0D, 16.0D),
			Block.box(4.0D, 6.5D, 4.0D, 16.0D, 7.25D, 16.0D),
			Block.box(2.0D, 5.75D, 2.0D, 16.0D, 6.5D, 16.0D),
			Block.box(0.0D, 5.0D, 0.0D, 16.0D, 5.75D, 16.0D));
	protected static final VoxelShape FFTT = VoxelShapes.or(Block.box(0.0D, 10.25D, 14.0D, 2.0D, 11.0D, 16.0D),
			Block.box(0.0D, 9.5D, 12.0D, 4.0D, 10.25D, 16.0D),
			Block.box(0.0D, 8.75D, 10.0D, 6.0D, 9.5D, 16.0D),
			Block.box(0.0D, 8.0D, 8.0D, 8.0D, 8.75D, 16.0D),
			Block.box(0.0D, 7.25D, 6.0D, 10.0D, 8.0D, 16.0D),
			Block.box(0.0D, 6.5D, 4.0D, 12.0D, 7.25D, 16.0D),
			Block.box(0.0D, 5.75D, 2.0D, 14.0D, 6.5D, 16.0D),
			Block.box(0.0D, 5.0D, 0.0D, 16.0D, 5.75D, 16.0D));

	protected static final VoxelShape FTTT = VoxelShapes.or(Block.box(0.0D, 10.25D, 0.0D, 2.0D, 11.0D, 16.0D),
			Block.box(0.0D, 9.5D, 0.0D, 4.0D, 10.25D, 16.0D),
			Block.box(0.0D, 8.75D, 0.0D, 6.0D, 9.5D, 16.0D),
			Block.box(0.0D, 8.0D, 0.0D, 8.0D, 8.75D, 16.0D),
			Block.box(0.0D, 7.25D, 0.0D, 10.0D, 8.0D, 16.0D),
			Block.box(0.0D, 6.5D, 0.0D, 12.0D, 7.25D, 16.0D),
			Block.box(0.0D, 5.75D, 0.0D, 14.0D, 6.5D, 16.0D),
			Block.box(0.0D, 5.0D, 0.0D, 16.0D, 5.75D, 16.0D));
	protected static final VoxelShape TTTF = VoxelShapes.or(Block.box(14.0D, 10.25D, 0.0D, 16.0D, 11.0D, 16.0D),
			Block.box(12.0D, 9.5D, 0.0D, 16.0D, 10.25D, 16.0D),
			Block.box(10.0D, 8.75D, 0.0D, 16.0D, 9.5D, 16.0D),
			Block.box(8.0D, 8.0D, 0.0D, 16.0D, 8.75D, 16.0D),
			Block.box(6.0D, 7.25D, 0.0D, 16.0D, 8.0D, 16.0D),
			Block.box(4.0D, 6.5D, 0.0D, 16.0D, 7.25D, 16.0D),
			Block.box(2.0D, 5.75D, 0.0D, 16.0D, 6.5D, 16.0D),
			Block.box(0.0D, 5.0D, 0.0D, 16.0D, 5.75D, 16.0D));
	protected static final VoxelShape TTFT = VoxelShapes.or(Block.box(0.0D, 10.25D, 0.0D, 16.0D, 11.0D, 2.0D),
			Block.box(0.0D, 9.5D, 0.0D, 16.0D, 10.25D, 4.0D),
			Block.box(0.0D, 8.75D, 0.0D, 16.0D, 9.5D, 6.0D),
			Block.box(0.0D, 8.0D, 0.0D, 16.0D, 8.75D, 8.0D),
			Block.box(0.0D, 7.25D, 0.0D, 16.0D, 8.0D, 10.0D),
			Block.box(0.0D, 6.5D, 0.0D, 16.0D, 7.25D, 12.0D),
			Block.box(0.0D, 5.75D, 0.0D, 16.0D, 6.5D, 14.0D),
			Block.box(0.0D, 5.0D, 0.0D, 16.0D, 5.75D, 16.0D));
	protected static final VoxelShape TFTT = VoxelShapes.or(Block.box(0.0D, 10.25D, 14.0D, 16.0D, 11.0D, 16.0D),
			Block.box(0.0D, 9.5D, 12.0D, 16.0D, 10.25D, 16.0D),
			Block.box(0.0D, 8.75D, 10.0D, 16.0D, 9.5D, 16.0D),
			Block.box(0.0D, 8.0D, 8.0D, 16.0D, 8.75D, 16.0D),
			Block.box(0.0D, 7.25D, 6.0D, 16.0D, 8.0D, 16.0D),
			Block.box(0.0D, 6.5D, 4.0D, 16.0D, 7.25D, 16.0D),
			Block.box(0.0D, 5.75D, 2.0D, 16.0D, 6.5D, 16.0D),
			Block.box(0.0D, 5.0D, 0.0D, 16.0D, 5.75D, 16.0D));

	public Wagasa(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getItemInHand(hand);
		
		/** Hand is empty. **/
		if (stack.isEmpty()) {
			if (playerIn.isCrouching()) {
				CMEvents.soundWoolPlace(worldIn, pos);
				worldIn.setBlock(pos, state.cycle(WHICH), 3);
				return ActionResultType.SUCCESS; }
			
			if (!playerIn.isCrouching()) {
				CMEvents.textNotSneak(worldIn, pos, playerIn);
				return ActionResultType.SUCCESS; }
		}
		
		return ActionResultType.PASS;
	}
	
	/* Gives a value when placed. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

		boolean east = state.getValue(EAST).booleanValue();
		boolean north = state.getValue(NORTH).booleanValue();
		boolean south = state.getValue(SOUTH).booleanValue();
		boolean west = state.getValue(WEST).booleanValue();

		if (east == true && north == true && south == false && west == false) { return TTFF; }
		if (east == false && north == true && south == false && west == true) { return FTFT; }
		if (east == true && north == false && south == true && west == false) { return TFTF; }
		if (east == false && north == false && south == true && west == true) { return FFTT; }

		if (east == false && north == true && south == true && west == true) { return FTTT; }
		if (east == true && north == true && south == true && west == false) { return TTTF; }
		if (east == true && north == true && south == false && west == true) { return TTFT; }
		if (east == true && north == false && south == true && west == true) { return TFTT; }

		if (east == true && north == true && south == true && west == true) { return TTTT; }

		return FFFF;
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_mkasa").withStyle(TextFormatting.GRAY));
	}
}
