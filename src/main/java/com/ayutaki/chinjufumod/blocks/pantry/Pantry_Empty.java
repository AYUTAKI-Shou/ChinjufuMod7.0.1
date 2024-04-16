package com.ayutaki.chinjufumod.blocks.pantry;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingSlab_Water;
import com.ayutaki.chinjufumod.registry.Pantry_Blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class Pantry_Empty extends BaseFacingSlab_Water {

	/* BOX_H_EMPTY深底, BOX_H_EMPTY2浅底, BOX_H_EMPTY3袋 */
	/* Collision */
	protected static final VoxelShape EMPTY_BOTTOM = VoxelShapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 0.5D, 16.0D),
			Block.box(0.0D, 0.5D, 0.0D, 16.0D, 8.0D, 0.5D),
			Block.box(0.0D, 0.5D, 15.5D, 16.0D, 8.0D, 16.0D),
			Block.box(0.0D, 0.5D, 0.0D, 0.5D, 8.0D, 16.0D),
			Block.box(15.5D, 0.5D, 0.0D, 16.0D, 8.0D, 16.0D));
	protected static final VoxelShape EMPTY_TOP = VoxelShapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.5D, 16.0D),
			Block.box(0.0D, 8.5D, 0.0D, 16.0D, 16.0D, 0.5D),
			Block.box(0.0D, 8.5D, 15.5D, 16.0D, 16.0D, 16.0D),
			Block.box(0.0D, 8.5D, 0.0D, 0.5D, 16.0D, 16.0D),
			Block.box(15.5D, 8.5D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.box(0.5D, 7.5D, 0.5D, 15.5D, 8.0D, 15.5D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 0.5D),
			Block.box(0.0D, 0.0D, 15.5D, 16.0D, 8.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 0.5D, 8.0D, 16.0D),
			Block.box(15.5D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D));
	protected static final VoxelShape EMPTY_DOUBLE = VoxelShapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.5D, 16.0D),
			Block.box(0.0D, 8.5D, 0.0D, 16.0D, 16.0D, 0.5D),
			Block.box(0.0D, 8.5D, 15.5D, 16.0D, 16.0D, 16.0D),
			Block.box(0.0D, 8.5D, 0.0D, 0.5D, 16.0D, 16.0D),
			Block.box(15.5D, 8.5D, 0.0D, 16.0D, 16.0D, 16.0D));

	protected static final VoxelShape EMPTY2_BOTTOM = VoxelShapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.5D, 16.0D),
			Block.box(0.0D, 4.5D, 0.0D, 16.0D, 8.0D, 0.5D),
			Block.box(0.0D, 4.5D, 15.5D, 16.0D, 8.0D, 16.0D),
			Block.box(0.0D, 4.5D, 0.0D, 0.5D, 8.0D, 16.0D),
			Block.box(15.5D, 4.5D, 0.0D, 16.0D, 8.0D, 16.0D));
	protected static final VoxelShape EMPTY2_TOP = VoxelShapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.5D, 16.0D),
			Block.box(0.0D, 12.5D, 0.0D, 16.0D, 16.0D, 0.5D),
			Block.box(0.0D, 12.5D, 15.5D, 16.0D, 16.0D, 16.0D),
			Block.box(0.0D, 12.5D, 0.0D, 0.5D, 16.0D, 16.0D),
			Block.box(15.5D, 12.5D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.box(0.5D, 7.5D, 0.5D, 15.5D, 8.0D, 15.5D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 0.5D),
			Block.box(0.0D, 0.0D, 15.5D, 16.0D, 8.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 0.5D, 8.0D, 16.0D),
			Block.box(15.5D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D));
	protected static final VoxelShape EMPTY2_DOUBLE = VoxelShapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.5D, 16.0D),
			Block.box(0.0D, 12.5D, 0.0D, 16.0D, 16.0D, 0.5D),
			Block.box(0.0D, 12.5D, 15.5D, 16.0D, 16.0D, 16.0D),
			Block.box(0.0D, 12.5D, 0.0D, 0.5D, 16.0D, 16.0D),
			Block.box(15.5D, 12.5D, 0.0D, 16.0D, 16.0D, 16.0D));

	protected static final VoxelShape EMPTY3_BOTTOM = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
	protected static final VoxelShape EMPTY3_TOP = VoxelShapes.or(Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.box(0.5D, 7.5D, 0.5D, 15.5D, 8.0D, 15.5D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 0.5D),
			Block.box(0.0D, 0.0D, 15.5D, 16.0D, 8.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 0.5D, 8.0D, 16.0D),
			Block.box(15.5D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D));

	public Pantry_Empty(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* Collisions for each property. */
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		SlabType slabType = state.getValue(TYPE);
		switch (slabType) {
		case DOUBLE:
			return (this == Pantry_Blocks.BOX_H_EMPTY)? EMPTY_DOUBLE : ((this == Pantry_Blocks.BOX_H_EMPTY2)? EMPTY2_DOUBLE : VoxelShapes.block());
		case TOP:
			return (this == Pantry_Blocks.BOX_H_EMPTY)? EMPTY_TOP : ((this == Pantry_Blocks.BOX_H_EMPTY2)? EMPTY2_TOP : EMPTY3_TOP);
		default:
			return (this == Pantry_Blocks.BOX_H_EMPTY)? EMPTY_BOTTOM : ((this == Pantry_Blocks.BOX_H_EMPTY2)? EMPTY2_BOTTOM : EMPTY3_BOTTOM);
		}
	}

	/* Flammable Block */
	@Override
	public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face) { return true; }

	@Override
	public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) { return 5; }

	@Override
	public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) { return 20; }
	
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
}
