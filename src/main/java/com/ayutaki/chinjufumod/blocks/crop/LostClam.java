package com.ayutaki.chinjufumod.blocks.crop;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FallingBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

public class LostClam extends FallingBlock {
	
	/* Property */
	public static final IntegerProperty STAGE_0_4 = IntegerProperty.create("stage", 0, 4);
	private final int dustColor;
	
	public LostClam(int color, AbstractBlock.Properties properties) {
		super(properties);
		this.dustColor = color;
		registerDefaultState(this.defaultBlockState().setValue(STAGE_0_4, Integer.valueOf(0)));
	}

	@OnlyIn(Dist.CLIENT)
	public int getDustColor(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return this.dustColor;
	}
	
	/* TickRandom */
	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		int i = state.getValue(STAGE_0_4);
		
		if (rand.nextInt(6) == 0) {
			if (i != 4) { worldIn.setBlock(pos, state.setValue(STAGE_0_4, Integer.valueOf(i + 1)), 3); }
			
			if (i == 4) { worldIn.setBlock(pos, Blocks.SAND.defaultBlockState(), 3); }
		}
	}
	
	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(STAGE_0_4);
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items.SAND);
	}
	
	/* The best harvesting tool.. */
	@Nullable
	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.SHOVEL;
	}

	@Override
	public int getHarvestLevel(BlockState state) {
		return 0;
	}
}
