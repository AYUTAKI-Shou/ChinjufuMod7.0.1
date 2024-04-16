package com.ayutaki.chinjufumod.blocks.crop;

import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage4_FaceWater;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_NoTab;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

public class Base_HodaGi_Top extends BaseStage4_FaceWater {
	
	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.makeCuboidShape(5.0D, -4.0D, 0.0D, 11.0D, 8.0D, 10.0D);
	protected static final VoxelShape AABB_WEST = Block.makeCuboidShape(6.0D, -4.0D, 5.0D, 16.0D, 8.0D, 11.0D);
	protected static final VoxelShape AABB_NORTH = Block.makeCuboidShape(5.0D, -4.0D, 6.0D, 11.0D, 8.0D, 16.0D);
	protected static final VoxelShape AABB_EAST = Block.makeCuboidShape(0.0D, -4.0D, 5.0D, 10.0D, 8.0D, 11.0D);

	public Base_HodaGi_Top(Block.Properties properties) {
		super(properties);
	}

	/* TickRandom */
	private boolean inShade(ServerWorld worldIn, BlockPos pos) {
		return ((worldIn.canSeeSky(pos) && !worldIn.isDaytime()) || (!worldIn.canSeeSky(pos) && worldIn.getLightSubtracted(pos, 0) <= 11));
	}

	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		int i = state.get(STAGE_1_4);

		if (!worldIn.isAreaLoaded(pos, 1)) { return; }

		if (!state.get(WATERLOGGED)) {
			if (i != 4) {
				if (inShade(worldIn, pos) && rand.nextInt(8) == 0) {
					worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i + 1))); } }
			
			if (i == 4) { }
		}
		
		if (state.get(WATERLOGGED)) {
			if (i != 1) {
				if (rand.nextInt(2) == 0) {
					CMEvents.soundSnowBreak(worldIn, pos);
					worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(1)));
					this.dropRottenfood(worldIn, pos); } }
			
			if (i == 1) { }
		}
	}

	protected void dropRottenfood(ServerWorld worldIn, BlockPos pos) {
		ItemStack stack = new ItemStack(Items_NoTab.ROTTEN_FOOD);
		InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(H_FACING);
		switch(direction) {
		case NORTH:
		default: return AABB_NORTH;
		case SOUTH: return AABB_SOUTH;
		case WEST: return AABB_WEST;
		case EAST: return AABB_EAST;
		}
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.HODAGI);
	}

	/* Destroy at the same time. & Drop item. */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {
		BlockState downState = worldIn.getBlockState(pos.down());
		/** False is not Drop. **/
		if (downState.getBlock() instanceof Base_HodaGi_Bot) {
			worldIn.destroyBlock(pos.down(), false); }
		
		super.onBlockHarvested(worldIn, pos, state, playerIn);
	}

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

	/* Can't breathe. */
	@Override
	public boolean causesSuffocation(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	/* Block is a cube. */
	@Override
	public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	/* Mobs spawn. */
	@Override
	public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type) {
		return false;
	}
}
