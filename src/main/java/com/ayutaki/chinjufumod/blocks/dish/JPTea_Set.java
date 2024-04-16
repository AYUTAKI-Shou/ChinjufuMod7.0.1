package com.ayutaki.chinjufumod.blocks.dish;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class JPTea_Set extends BaseFood_Stage4Water {

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.box(2.0D, 0.0D, 4.5D, 14.0D, 3.0D, 11.5D);
	protected static final VoxelShape AABB_WEST = Block.box(4.5D, 0.0D, 2.0D, 11.5D, 3.0D, 14.0D);
	protected static final VoxelShape AABB_NORTH = Block.box(2.0D, 0.0D, 4.5D, 14.0D, 3.0D, 11.5D);
	protected static final VoxelShape AABB_EAST = Block.box(4.5D, 0.0D, 2.0D, 11.5D, 3.0D, 14.0D);

	protected static final VoxelShape DOWN_SOUTH = Block.box(2.0D, -8.0D, 4.5D, 14.0D, 0.1D, 11.5D);
	protected static final VoxelShape DOWN_WEST = Block.box(4.5D, -8.0D, 2.0D, 11.5D, 0.1D, 14.0D);
	protected static final VoxelShape DOWN_NORTH = Block.box(2.0D, -8.0D, 4.5D, 14.0D, 0.1D, 11.5D);
	protected static final VoxelShape DOWN_EAST = Block.box(4.5D, -8.0D, 2.0D, 11.5D, 0.1D, 14.0D);

	public JPTea_Set(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		int i = state.getValue(STAGE_1_4);

		if (i != 4) {
			/** Hand is empty. **/
			if (stack.isEmpty()) {
				CMEvents.soundEat(worldIn, pos);
	
				if (i == 1) {
					/** 採掘速度60秒 1秒＝20 **/
					playerIn.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 1200, 0));
					playerIn.addEffect(new MobEffectInstance(MobEffects.SATURATION, 4, 0)); }
	
				if (i == 2) {
					playerIn.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 1200, 0));
					playerIn.addEffect(new MobEffectInstance(MobEffects.SATURATION, 4, 0)); }
	
				if (i == 3) {
					playerIn.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 1200, 0));
					playerIn.addEffect(new MobEffectInstance(MobEffects.SATURATION, 4, 0)); }
	
				worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		if (i == 4) { CMEvents.textIsEmpty(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return InteractionResult.SUCCESS;
	}

	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
		int i = state.getValue(STAGE_1_4);
		
		if (i != 4) {
			if (inWater(state, worldIn, pos)) {
				worldIn.scheduleTick(pos, this, 60);
				CMEvents.soundSnowBreak(worldIn, pos);
				worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(4)), 3);
				this.dropRottenfood(worldIn, pos); }
			
			else { } }
		
		if (i == 4) { }
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		Direction direction = state.getValue(H_FACING);
		boolean flag= !((Boolean)state.getValue(DOWN)).booleanValue();

		switch (direction) {
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
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.JPTEASET.get());
	}
}
