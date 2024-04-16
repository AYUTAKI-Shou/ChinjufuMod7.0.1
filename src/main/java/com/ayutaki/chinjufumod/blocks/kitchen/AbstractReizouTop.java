package com.ayutaki.chinjufumod.blocks.kitchen;

import java.util.function.Supplier;

import com.ayutaki.chinjufumod.tileentity.ReizouTop_TileEntity;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMerger;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public abstract class AbstractReizouTop<E extends TileEntity> extends ContainerBlock {

	protected final Supplier<TileEntityType<? extends E>> blockEntityType;

	protected AbstractReizouTop(AbstractBlock.Properties properties, Supplier<TileEntityType<? extends E>> tileEntity) {
		super(properties);
		this.blockEntityType = tileEntity;
	}

	@OnlyIn(Dist.CLIENT)
	public abstract TileEntityMerger.ICallbackWrapper<? extends ReizouTop_TileEntity> combine(BlockState state, World worldIn, BlockPos pos, boolean flag);

}
