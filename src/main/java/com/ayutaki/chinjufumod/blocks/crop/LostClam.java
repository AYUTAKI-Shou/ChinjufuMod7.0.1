package com.ayutaki.chinjufumod.blocks.crop;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class LostClam extends FallingBlock {
	
	/* Property */
	public static final IntegerProperty STAGE_0_4 = IntegerProperty.create("stage", 0, 4);
	private final int dustColor;
	
	public LostClam(int color, BlockBehaviour.Properties properties) {
		super(properties);
		this.dustColor = color;
		registerDefaultState(this.defaultBlockState().setValue(STAGE_0_4, Integer.valueOf(0)));
	}

	@OnlyIn(Dist.CLIENT)
	public int getDustColor(BlockState stateIn, BlockGetter worldIn, BlockPos posIn) {
		return this.dustColor;
	}
	
	/* TickRandom */
	@Override
	public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
		int i = state.getValue(STAGE_0_4);
		
		if (rand.nextInt(6) == 0) {
			if (i != 4) { worldIn.setBlock(pos, state.setValue(STAGE_0_4, Integer.valueOf(i + 1)), 3); }
			
			if (i == 4) { worldIn.setBlock(pos, Blocks.SAND.defaultBlockState(), 3); }
		}
	}
	
	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(STAGE_0_4);
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items.SAND);
	}
}
