package com.ayutaki.chinjufumod.blocks.unitblock;

import com.ayutaki.chinjufumod.handler.CMEvents;

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
	protected static final VoxelShape TTTT = Block.makeCuboidShape(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D);

	protected static final VoxelShape FFFF = VoxelShapes.or(Block.makeCuboidShape(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 15.0D, 2.0D),
			Block.makeCuboidShape(1.0D, 0.0D, 14.0D, 15.0D, 15.0D, 15.0D),
			Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 2.0D, 15.0D, 15.0D),
			Block.makeCuboidShape(14.0D, 0.0D, 1.0D, 15.0D, 15.0D, 15.0D));

	protected static final VoxelShape TTFF = VoxelShapes.or(Block.makeCuboidShape(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.makeCuboidShape(1.0D, 0.0D, 14.0D, 16.0D, 15.0D, 15.0D),
			Block.makeCuboidShape(1.0D, 0.0D, 0.0D, 2.0D, 15.0D, 15.0D));
	protected static final VoxelShape FTFT = VoxelShapes.or(Block.makeCuboidShape(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.makeCuboidShape(0.0D, 0.0D, 14.0D, 15.0D, 15.0D, 15.0D),
			Block.makeCuboidShape(14.0D, 0.0D, 0.0D, 15.0D, 15.0D, 15.0D));
	protected static final VoxelShape TFTF = VoxelShapes.or(Block.makeCuboidShape(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 16.0D, 15.0D, 2.0D),
			Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 2.0D, 15.0D, 16.0D));
	protected static final VoxelShape FFTT = VoxelShapes.or(Block.makeCuboidShape(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.makeCuboidShape(0.0D, 0.0D, 1.0D, 15.0D, 15.0D, 2.0D),
			Block.makeCuboidShape(14.0D, 0.0D, 1.0D, 15.0D, 15.0D, 16.0D));

	protected static final VoxelShape FTFF = VoxelShapes.or(Block.makeCuboidShape(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.makeCuboidShape(1.0D, 0.0D, 0.0D, 2.0D, 15.0D, 15.0D),
			Block.makeCuboidShape(14.0D, 0.0D, 0.0D, 15.0D, 15.0D, 15.0D),
			Block.makeCuboidShape(1.0D, 0.0D, 14.0D, 15.0D, 15.0D, 15.0D));
	protected static final VoxelShape FFTF = VoxelShapes.or(Block.makeCuboidShape(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 2.0D, 15.0D, 16.0D),
			Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 15.0D, 16.0D),
			Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 15.0D, 2.0D));
	protected static final VoxelShape TFFF = VoxelShapes.or(Block.makeCuboidShape(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 16.0D, 15.0D, 2.0D),
			Block.makeCuboidShape(1.0D, 0.0D, 14.0D, 16.0D, 15.0D, 15.0D),
			Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 2.0D, 15.0D, 15.0D));
	protected static final VoxelShape FFFT = VoxelShapes.or(Block.makeCuboidShape(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.makeCuboidShape(0.0D, 0.0D, 1.0D, 15.0D, 15.0D, 2.0D),
			Block.makeCuboidShape(0.0D, 0.0D, 14.0D, 15.0D, 15.0D, 15.0D),
			Block.makeCuboidShape(14.0D, 0.0D, 1.0D, 15.0D, 15.0D, 15.0D));

	protected static final VoxelShape FTTF = VoxelShapes.or(Block.makeCuboidShape(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.makeCuboidShape(1.0D, 0.0D, 0.0D, 2.0D, 15.0D, 16.0D),
			Block.makeCuboidShape(14.0D, 0.0D, 0.0D, 15.0D, 15.0D, 16.0D));
	protected static final VoxelShape TFFT = VoxelShapes.or(Block.makeCuboidShape(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.makeCuboidShape(0.0D, 0.0D, 1.0D, 16.0D, 15.0D, 2.0D),
			Block.makeCuboidShape(0.0D, 0.0D, 14.0D, 16.0D, 15.0D, 15.0D));

	public UnitDesk(Block.Properties properties) {
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
