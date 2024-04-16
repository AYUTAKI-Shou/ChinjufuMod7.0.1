package com.ayutaki.chinjufumod.blocks.unitblock;

import com.ayutaki.chinjufumod.handler.CMEvents;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class UnitDesk extends BaseUnitBlock {

	/* Collision */
	protected static final VoxelShape TTTT = Block.box(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D);

	protected static final VoxelShape FFFF = VoxelShapes.or(Block.box(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.box(1.0D, 0.0D, 1.0D, 15.0D, 15.0D, 2.0D),
			Block.box(1.0D, 0.0D, 14.0D, 15.0D, 15.0D, 15.0D),
			Block.box(1.0D, 0.0D, 1.0D, 2.0D, 15.0D, 15.0D),
			Block.box(14.0D, 0.0D, 1.0D, 15.0D, 15.0D, 15.0D));

	protected static final VoxelShape TTFF = VoxelShapes.or(Block.box(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.box(1.0D, 0.0D, 14.0D, 16.0D, 15.0D, 15.0D),
			Block.box(1.0D, 0.0D, 0.0D, 2.0D, 15.0D, 15.0D));
	protected static final VoxelShape FTFT = VoxelShapes.or(Block.box(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.box(0.0D, 0.0D, 14.0D, 15.0D, 15.0D, 15.0D),
			Block.box(14.0D, 0.0D, 0.0D, 15.0D, 15.0D, 15.0D));
	protected static final VoxelShape TFTF = VoxelShapes.or(Block.box(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.box(1.0D, 0.0D, 1.0D, 16.0D, 15.0D, 2.0D),
			Block.box(1.0D, 0.0D, 1.0D, 2.0D, 15.0D, 16.0D));
	protected static final VoxelShape FFTT = VoxelShapes.or(Block.box(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.box(0.0D, 0.0D, 1.0D, 15.0D, 15.0D, 2.0D),
			Block.box(14.0D, 0.0D, 1.0D, 15.0D, 15.0D, 16.0D));

	protected static final VoxelShape FTFF = VoxelShapes.or(Block.box(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.box(1.0D, 0.0D, 0.0D, 2.0D, 15.0D, 15.0D),
			Block.box(14.0D, 0.0D, 0.0D, 15.0D, 15.0D, 15.0D),
			Block.box(1.0D, 0.0D, 14.0D, 15.0D, 15.0D, 15.0D));
	protected static final VoxelShape FFTF = VoxelShapes.or(Block.box(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.box(1.0D, 0.0D, 1.0D, 2.0D, 15.0D, 16.0D),
			Block.box(1.0D, 0.0D, 1.0D, 15.0D, 15.0D, 16.0D),
			Block.box(1.0D, 0.0D, 1.0D, 15.0D, 15.0D, 2.0D));
	protected static final VoxelShape TFFF = VoxelShapes.or(Block.box(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.box(1.0D, 0.0D, 1.0D, 16.0D, 15.0D, 2.0D),
			Block.box(1.0D, 0.0D, 14.0D, 16.0D, 15.0D, 15.0D),
			Block.box(1.0D, 0.0D, 1.0D, 2.0D, 15.0D, 15.0D));
	protected static final VoxelShape FFFT = VoxelShapes.or(Block.box(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.box(0.0D, 0.0D, 1.0D, 15.0D, 15.0D, 2.0D),
			Block.box(0.0D, 0.0D, 14.0D, 15.0D, 15.0D, 15.0D),
			Block.box(14.0D, 0.0D, 1.0D, 15.0D, 15.0D, 15.0D));

	protected static final VoxelShape FTTF = VoxelShapes.or(Block.box(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.box(1.0D, 0.0D, 0.0D, 2.0D, 15.0D, 16.0D),
			Block.box(14.0D, 0.0D, 0.0D, 15.0D, 15.0D, 16.0D));
	protected static final VoxelShape TFFT = VoxelShapes.or(Block.box(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.box(0.0D, 0.0D, 1.0D, 16.0D, 15.0D, 2.0D),
			Block.box(0.0D, 0.0D, 14.0D, 16.0D, 15.0D, 15.0D));

	public UnitDesk(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getItemInHand(hand);
		
		/** Hand is empty. **/
		if (stack.isEmpty()) {
			if (playerIn.isCrouching()) {
				CMEvents.soundWoodPlace(worldIn, pos);
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

		if (east == false && north == true && south == false && west == false) { return FTFF; }
		if (east == true && north == false && south == false && west == false) { return TFFF; }
		if (east == false && north == false && south == false && west == true) { return FFFT; }
		if (east == false && north == false && south == true && west == false) { return FFTF; }
		if (east == false && north == true && south == true && west == false) { return FTTF; }
		if (east == true && north == false && south == false && west == true) { return TFFT; }

		if (east == false && north == true && south == true && west == true) { return FTTF; }
		if (east == true && north == true && south == true && west == false) { return FTTF; }
		if (east == true && north == true && south == false && west == true) { return TFFT; }
		if (east == true && north == false && south == true && west == true) { return TFFT; }
		if (east == true && north == true && south == true && west == true) { return TTTT; }

		return FFFF;
	}

}
