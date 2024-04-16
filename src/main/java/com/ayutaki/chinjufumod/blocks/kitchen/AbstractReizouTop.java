package com.ayutaki.chinjufumod.blocks.kitchen;

import java.util.function.Supplier;

import com.ayutaki.chinjufumod.tileentity.ReizouTop_TileEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.DoubleBlockCombiner.NeighborCombineResult;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public abstract class AbstractReizouTop <E extends BlockEntity> extends BaseEntityBlock {

	protected final Supplier<BlockEntityType<? extends E>> blockEntityType;
	
	public AbstractReizouTop(BlockBehaviour.Properties properties, Supplier<BlockEntityType<? extends E>> tileEntity) {
		super(properties);
		blockEntityType = tileEntity;
	}
	
	public abstract NeighborCombineResult<? extends ReizouTop_TileEntity> combine(BlockState state, Level worldIn, BlockPos pos, boolean flag);
}
