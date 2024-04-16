package com.ayutaki.chinjufumod.blocks.crop;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage4_FaceWater;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_NoTab;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Base_HodaGi_Bot extends BaseStage4_FaceWater {

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.box(5.0D, 0.0D, 4.0D, 11.0D, 12.0D, 15.0D);
	protected static final VoxelShape AABB_WEST = Block.box(1.0D, 0.0D, 5.0D, 12.0D, 12.0D, 11.0D);
	protected static final VoxelShape AABB_NORTH = Block.box(5.0D, 0.0D, 1.0D, 11.0D, 12.0D, 12.0D);
	protected static final VoxelShape AABB_EAST = Block.box(4.0D, 0.0D, 5.0D, 15.0D, 12.0D, 11.0D);

	public Base_HodaGi_Bot(BlockBehaviour.Properties properties) {
		super(properties);
	}
	
	/* TickRandom */
	private boolean inShade(ServerLevel worldIn, BlockPos pos) {
		return ((worldIn.canSeeSky(pos) && !worldIn.isDay()) || (!worldIn.canSeeSky(pos) && worldIn.getRawBrightness(pos, 0) <= 11));
	}
	
	/* TickRandom */
	@SuppressWarnings("deprecation")
	public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
		int i = state.getValue(STAGE_1_4);

		if (!worldIn.isAreaLoaded(pos, 1)) { return; }

		if (state.getValue(WATERLOGGED) == false) {
			if (i != 4) {
				if (inShade(worldIn, pos) && rand.nextInt(8) == 0) {
					worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3); } }
			
			if (i == 4) { }
		}
		
		if (state.getValue(WATERLOGGED) != false) {
			if (i != 1) {
				if (rand.nextInt(2) == 0) {
					CMEvents.soundSnowBreak(worldIn, pos);
					worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(1)), 3);
					this.dropRottenfood(worldIn, pos); } }
			
			if (i == 1) { }
		}
	}
	
	protected void dropRottenfood(ServerLevel worldIn, BlockPos pos) {
		ItemStack stack = new ItemStack(Items_NoTab.ROTTEN_FOOD.get());
		Containers.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		Direction direction = state.getValue(H_FACING);
		switch (direction) {
		case NORTH:
		default: return AABB_NORTH;
		case SOUTH: return AABB_SOUTH;
		case WEST: return AABB_WEST;
		case EAST: return AABB_EAST;
		}
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.HODAGI.get());
	}

	/* Destroy a DoubleBlock from DoublePlantBlock.class */
	@Override
	public void playerWillDestroy(Level worldIn, BlockPos pos, BlockState state, Player playerIn) {
		BlockState upState = worldIn.getBlockState(pos.above());
		/** False is not Drop. **/
		if (upState.getBlock() instanceof Base_HodaGi_Top) {
			worldIn.destroyBlock(pos.above(), false); }
		
		super.playerWillDestroy(worldIn, pos, state, playerIn);
	}

	/* ToolTip */
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.block_hodagi_a_bot").withStyle(ChatFormatting.GRAY));
	}
}
