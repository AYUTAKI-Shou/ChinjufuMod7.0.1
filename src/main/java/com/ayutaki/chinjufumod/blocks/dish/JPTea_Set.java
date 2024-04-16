package com.ayutaki.chinjufumod.blocks.dish;

import java.util.Random;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class JPTea_Set extends BaseFood_Stage4Water {

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.makeCuboidShape(2.0D, 0.0D, 4.5D, 14.0D, 3.0D, 11.5D);
	protected static final VoxelShape AABB_WEST = Block.makeCuboidShape(4.5D, 0.0D, 2.0D, 11.5D, 3.0D, 14.0D);
	protected static final VoxelShape AABB_NORTH = Block.makeCuboidShape(2.0D, 0.0D, 4.5D, 14.0D, 3.0D, 11.5D);
	protected static final VoxelShape AABB_EAST = Block.makeCuboidShape(4.5D, 0.0D, 2.0D, 11.5D, 3.0D, 14.0D);

	protected static final VoxelShape DOWN_SOUTH = Block.makeCuboidShape(2.0D, -8.0D, 4.5D, 14.0D, 0.1D, 11.5D);
	protected static final VoxelShape DOWN_WEST = Block.makeCuboidShape(4.5D, -8.0D, 2.0D, 11.5D, 0.1D, 14.0D);
	protected static final VoxelShape DOWN_NORTH = Block.makeCuboidShape(2.0D, -8.0D, 4.5D, 14.0D, 0.1D, 11.5D);
	protected static final VoxelShape DOWN_EAST = Block.makeCuboidShape(4.5D, -8.0D, 2.0D, 11.5D, 0.1D, 14.0D);

	public JPTea_Set(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getHeldItem(hand);
		int i = state.get(STAGE_1_4);

		if (i != 4) {
			/** Hand is empty. **/
			if (stack.isEmpty()) {
				CMEvents.soundEat(worldIn, pos);
	
				if (i == 1) {
					/** 採掘速度60秒 1秒＝20 **/
					playerIn.addPotionEffect(new EffectInstance(Effects.HASTE, 1200, 0));
					playerIn.addPotionEffect(new EffectInstance(Effects.SATURATION, 4, 0)); }
	
				if (i == 2) {
					playerIn.addPotionEffect(new EffectInstance(Effects.HASTE, 1200, 0));
					playerIn.addPotionEffect(new EffectInstance(Effects.SATURATION, 4, 0)); }
	
				if (i == 3) {
					playerIn.addPotionEffect(new EffectInstance(Effects.HASTE, 1200, 0));
					playerIn.addPotionEffect(new EffectInstance(Effects.SATURATION, 4, 0)); }
	
				worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i + 1))); }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		if (i == 4) { CMEvents.textIsEmpty(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		int i = state.get(STAGE_1_4);
		
		if (i != 4) {
			if (inWater(state, worldIn, pos)) {
				worldIn.getPendingBlockTicks().scheduleTick(pos, this, 60);
				CMEvents.soundSnowBreak(worldIn, pos);
				worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(4)));
				this.dropRottenfood(worldIn, pos); }
			
			else { } }
		
		if (i == 4) { }
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

		Direction direction = state.get(H_FACING);
		boolean flag= !((Boolean)state.get(DOWN)).booleanValue();

		switch(direction) {
		case NORTH:
		default:
			return flag? AABB_NORTH : DOWN_NORTH;
		case SOUTH:
			return flag? AABB_SOUTH : DOWN_SOUTH;
		case WEST:
			return flag? AABB_WEST : DOWN_WEST;
		case EAST:
			return flag? AABB_EAST : DOWN_EAST;
		}
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.JPTEASET);
	}
}
