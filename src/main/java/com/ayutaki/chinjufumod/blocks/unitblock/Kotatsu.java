package com.ayutaki.chinjufumod.blocks.unitblock;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;

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

public class Kotatsu extends BaseUnitBlock {

	/* Collision */
	protected static final VoxelShape TTTT = Block.makeCuboidShape(0.0D, 6.0D, 0.0D, 16.0D, 8.0D, 16.0D);

	protected static final VoxelShape FFFF = VoxelShapes.or(Block.makeCuboidShape(2.0D, 6.0D, 2.0D, 14.0D, 8.0D, 14.0D),
			Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 4.5D, 6.0D, 4.5D),
			Block.makeCuboidShape(3.0D, 0.0D, 11.5D, 4.5D, 6.0D, 13.0D),
			Block.makeCuboidShape(11.5D, 0.0D, 3.0D, 13.0D, 6.0D, 4.5D),
			Block.makeCuboidShape(11.5D, 0.0D, 11.5D, 13.0D, 6.0D, 13.0D));

	protected static final VoxelShape TTFF = VoxelShapes.or(Block.makeCuboidShape(1.0D, 6.0D, 0.0D, 16.0D, 8.0D, 15.0D),
			Block.makeCuboidShape(3.0D, 0.0D, 10.5D, 5.5D, 6.0D, 13.0D));
	protected static final VoxelShape FTFT = VoxelShapes.or(Block.makeCuboidShape(0.0D, 6.0D, 0.0D, 15.0D, 8.0D, 15.0D),
			Block.makeCuboidShape(10.5D, 0.0D, 10.5D, 13.0D, 6.0D, 13.0D));
	protected static final VoxelShape TFTF = VoxelShapes.or(Block.makeCuboidShape(1.0D, 6.0D, 1.0D, 16.0D, 8.0D, 16.0D),
			Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 5.5D, 6.0D, 5.5D));
	protected static final VoxelShape FFTT = VoxelShapes.or(Block.makeCuboidShape(0.0D, 6.0D, 1.0D, 15.0D, 8.0D, 16.0D),
			Block.makeCuboidShape(10.5D, 0.0D, 3.0D, 13.0D, 6.0D, 5.5D));

	protected static final VoxelShape FTTT = VoxelShapes.or(Block.makeCuboidShape(0.0D, 6.0D, 0.0D, 15.0D, 8.0D, 16.0D));
	protected static final VoxelShape TTTF = VoxelShapes.or(Block.makeCuboidShape(1.0D, 6.0D, 0.0D, 16.0D, 8.0D, 16.0D));
	protected static final VoxelShape TTFT = VoxelShapes.or(Block.makeCuboidShape(0.0D, 6.0D, 0.0D, 16.0D, 8.0D, 15.0D));
	protected static final VoxelShape TFTT = VoxelShapes.or(Block.makeCuboidShape(0.0D, 6.0D, 1.0D, 16.0D, 8.0D, 16.0D));

	public Kotatsu(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getHeldItem(hand);
		
		/** Hand is empty. **/
		if (stack.isEmpty()) {
			if (playerIn.isSneaking()) {
				CMEvents.soundWoodPlace(worldIn, pos);
				worldIn.setBlockState(pos, state.cycle(WHICH));
				return ActionResultType.SUCCESS; }
			
			if (!playerIn.isSneaking()) {
				CMEvents.textNotSneak(worldIn, pos, playerIn);
				return ActionResultType.SUCCESS; }
		}
		
		return ActionResultType.PASS;
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

		boolean east = state.get(EAST).booleanValue();
		boolean north = state.get(NORTH).booleanValue();
		boolean south = state.get(SOUTH).booleanValue();
		boolean west = state.get(WEST).booleanValue();

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
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_kotatsu").applyTextStyle(TextFormatting.GRAY));
	}
}
