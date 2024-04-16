package com.ayutaki.chinjufumod.blocks.dish;

import java.util.Random;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
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

public class Hakusai_Duke extends BaseFood_Stage3Water {

	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 2.0D, 11.0D);
	protected static final VoxelShape AABB_DOWN = Block.box(5.0D, -8.0D, 5.0D, 11.0D, 0.1D, 11.0D);

	public Hakusai_Duke(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		int i = state.getValue(STAGE_1_3);

		if (i != 3) {
			/** Hand is empty. **/
			if (stack.isEmpty()) {
			CMEvents.soundEat(worldIn, pos);

			if (i == 1) {
				/** 採掘3600 1秒＝20 満腹は2で肉メモリの1個分 **/
				playerIn.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 300, 0));
				playerIn.addEffect(new MobEffectInstance(MobEffects.SATURATION, 1, 0)); }

			if (i == 2) {
				playerIn.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 300, 0));
				playerIn.addEffect(new MobEffectInstance(MobEffects.SATURATION, 1, 0)); }

			worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(i + 1)), 3); }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		if (i == 3) { CMEvents.textIsEmpty(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return InteractionResult.SUCCESS;
	}

	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, Random rand) {
		int i = state.getValue(STAGE_1_3);

		if (i != 3) {
			if (inWater(state, worldIn, pos)) {
				worldIn.scheduleTick(pos, this, 60);
				CMEvents.soundSnowBreak(worldIn, pos);
				worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(3)), 3);
				this.dropRottenfood(worldIn, pos); }
			
			else { } }
		
		if (i == 3) { }
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		boolean flag= !((Boolean)state.getValue(DOWN)).booleanValue();
		return flag? AABB_BOX : AABB_DOWN;
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.HAKUSAIDUKE.get());
	}
}
