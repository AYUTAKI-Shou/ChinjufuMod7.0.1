package com.ayutaki.chinjufumod.blocks.pantry;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingSlab_Water;
import com.ayutaki.chinjufumod.registry.Pantry_Blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Pantry_Empty extends BaseFacingSlab_Water {

	/* Collision */
	protected static final VoxelShape EMPTY_BOTTOM = Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 0.5D, 16.0D),
			Block.box(0.0D, 0.5D, 0.0D, 16.0D, 8.0D, 0.5D),
			Block.box(0.0D, 0.5D, 15.5D, 16.0D, 8.0D, 16.0D),
			Block.box(0.0D, 0.5D, 0.0D, 0.5D, 8.0D, 16.0D),
			Block.box(15.5D, 0.5D, 0.0D, 16.0D, 8.0D, 16.0D));
	protected static final VoxelShape EMPTY_TOP = Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.5D, 16.0D),
			Block.box(0.0D, 8.5D, 0.0D, 16.0D, 16.0D, 0.5D),
			Block.box(0.0D, 8.5D, 15.5D, 16.0D, 16.0D, 16.0D),
			Block.box(0.0D, 8.5D, 0.0D, 0.5D, 16.0D, 16.0D),
			Block.box(15.5D, 8.5D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.box(0.5D, 7.5D, 0.5D, 15.5D, 8.0D, 15.5D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 0.5D),
			Block.box(0.0D, 0.0D, 15.5D, 16.0D, 8.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 0.5D, 8.0D, 16.0D),
			Block.box(15.5D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D));
	protected static final VoxelShape EMPTY_DOUBLE = Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.5D, 16.0D),
			Block.box(0.0D, 8.5D, 0.0D, 16.0D, 16.0D, 0.5D),
			Block.box(0.0D, 8.5D, 15.5D, 16.0D, 16.0D, 16.0D),
			Block.box(0.0D, 8.5D, 0.0D, 0.5D, 16.0D, 16.0D),
			Block.box(15.5D, 8.5D, 0.0D, 16.0D, 16.0D, 16.0D));

	protected static final VoxelShape EMPTY2_BOTTOM = Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.5D, 16.0D),
			Block.box(0.0D, 4.5D, 0.0D, 16.0D, 8.0D, 0.5D),
			Block.box(0.0D, 4.5D, 15.5D, 16.0D, 8.0D, 16.0D),
			Block.box(0.0D, 4.5D, 0.0D, 0.5D, 8.0D, 16.0D),
			Block.box(15.5D, 4.5D, 0.0D, 16.0D, 8.0D, 16.0D));
	protected static final VoxelShape EMPTY2_TOP = Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.5D, 16.0D),
			Block.box(0.0D, 12.5D, 0.0D, 16.0D, 16.0D, 0.5D),
			Block.box(0.0D, 12.5D, 15.5D, 16.0D, 16.0D, 16.0D),
			Block.box(0.0D, 12.5D, 0.0D, 0.5D, 16.0D, 16.0D),
			Block.box(15.5D, 12.5D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.box(0.5D, 7.5D, 0.5D, 15.5D, 8.0D, 15.5D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 0.5D),
			Block.box(0.0D, 0.0D, 15.5D, 16.0D, 8.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 0.5D, 8.0D, 16.0D),
			Block.box(15.5D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D));
	protected static final VoxelShape EMPTY2_DOUBLE = Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.5D, 16.0D),
			Block.box(0.0D, 12.5D, 0.0D, 16.0D, 16.0D, 0.5D),
			Block.box(0.0D, 12.5D, 15.5D, 16.0D, 16.0D, 16.0D),
			Block.box(0.0D, 12.5D, 0.0D, 0.5D, 16.0D, 16.0D),
			Block.box(15.5D, 12.5D, 0.0D, 16.0D, 16.0D, 16.0D));

	protected static final VoxelShape EMPTY3_BOTTOM = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
	protected static final VoxelShape EMPTY3_TOP = Shapes.or(Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.box(0.5D, 7.5D, 0.5D, 15.5D, 8.0D, 15.5D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 0.5D),
			Block.box(0.0D, 0.0D, 15.5D, 16.0D, 8.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 0.5D, 8.0D, 16.0D),
			Block.box(15.5D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D));

	/* BOX_H_EMPTY深底, BOX_H_EMPTY2浅底, BOX_H_EMPTY3袋 */
	public Pantry_Empty(BlockBehaviour.Properties properties) {
		super(properties);
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		SlabType slabType = state.getValue(TYPE);
		switch (slabType) {
		case DOUBLE:
			return (this == Pantry_Blocks.BOX_H_EMPTY.get())? EMPTY_DOUBLE : ((this == Pantry_Blocks.BOX_H_EMPTY2.get())? EMPTY2_DOUBLE : Shapes.block());
		case TOP:
			return (this == Pantry_Blocks.BOX_H_EMPTY.get())? EMPTY_TOP : ((this == Pantry_Blocks.BOX_H_EMPTY2.get())? EMPTY2_TOP : EMPTY3_TOP);
		default:
			return (this == Pantry_Blocks.BOX_H_EMPTY.get())? EMPTY_BOTTOM : ((this == Pantry_Blocks.BOX_H_EMPTY2.get())? EMPTY2_BOTTOM : EMPTY3_BOTTOM);
		}
	}
	
	/* Flammable Block */
	@Override
	public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction direct) { return true; }

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction direct) { return 5; }

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction direct) { return 20; }
	
}
