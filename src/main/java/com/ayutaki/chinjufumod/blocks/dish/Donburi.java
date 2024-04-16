package com.ayutaki.chinjufumod.blocks.dish;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.core.BlockPos;
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

public class Donburi extends BaseFood_Stage4Water {

	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.box(5.8D, 0.0D, 5.8D, 10.2D, 3.0D, 10.2D);
	protected static final VoxelShape AABB_DOWN = Block.box(5.8D, -8.0D, 5.8D, 10.2D, 0.1D, 10.2D);

	public Donburi(BlockBehaviour.Properties properties) {
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
	
				if (this == Dish_Blocks.DONBURI_MESHI.get()) {
					if (i == 1) { playerIn.addEffect(new MobEffectInstance(MobEffects.SATURATION, 2, 0)); }
					if (i == 2) { playerIn.addEffect(new MobEffectInstance(MobEffects.SATURATION, 2, 0)); }
					if (i == 3) { playerIn.addEffect(new MobEffectInstance(MobEffects.SATURATION, 2, 0)); }
				}
				
				if (this == Dish_Blocks.DONBURI_KATSU.get()) {
					if (i == 1) {
						/** 採掘3600 1秒＝20 満腹は2で肉メモリの1個分 カツ調理分加算 +600tick **/
						playerIn.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 4200, 0));
						playerIn.addEffect(new MobEffectInstance(MobEffects.SATURATION, 4, 0)); }
					
					if (i == 2) { 
						/** 即時回復は0,0でよい 満腹は2で肉メモリの1個分 **/
						playerIn.addEffect(new MobEffectInstance(MobEffects.HEAL, 0, 0));
						playerIn.addEffect(new MobEffectInstance(MobEffects.SATURATION, 4, 0)); }
					
					if (i == 3) {
						/** リジェネは3600 即時回復は0,0でよい 満腹は2で肉メモリの1個分 カツ調理分加算 +600tick **/
						playerIn.addEffect(new MobEffectInstance(MobEffects.HEAL, 0, 0));
						playerIn.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 4200, 0));
						playerIn.addEffect(new MobEffectInstance(MobEffects.SATURATION, 4, 0)); }
				}
				
				if (this == Dish_Blocks.DONBURI_GYU.get() || this == Dish_Blocks.DONBURI_OYAKO.get() || this == Dish_Blocks.DONBURI_KAISEN.get()) {
					if (i == 1) {
						/** 採掘3600 1秒＝20 満腹は2で肉メモリの1個分 **/
						playerIn.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 3600, 0));
						playerIn.addEffect(new MobEffectInstance(MobEffects.SATURATION, 4, 0)); }
					
					if (i == 2) { 
						/** 即時回復は0,0でよい 満腹は2で肉メモリの1個分 **/
						playerIn.addEffect(new MobEffectInstance(MobEffects.HEAL, 0, 0));
						playerIn.addEffect(new MobEffectInstance(MobEffects.SATURATION, 4, 0)); }
					
					if (i == 3) { 
						/** リジェネは3600 即時回復は0,0でよい 満腹は2で肉メモリの1個分 **/
						playerIn.addEffect(new MobEffectInstance(MobEffects.HEAL, 0, 0));
						playerIn.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 3600, 0));
						playerIn.addEffect(new MobEffectInstance(MobEffects.SATURATION, 4, 0)); }
				}
	
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
		boolean flag= !((Boolean)state.getValue(DOWN)).booleanValue();
		return flag? AABB_BOX : AABB_DOWN;
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return this.takeStack();
	}
	
	private ItemStack takeStack() {
		if (this == Dish_Blocks.DONBURI_MESHI.get()) { return new ItemStack(Items_Teatime.DONBURI_MESHI.get(), 1); }
		if (this == Dish_Blocks.DONBURI_KATSU.get()) { return new ItemStack(Items_Teatime.DONBURI_KATSU.get(), 1); }
		if (this == Dish_Blocks.DONBURI_OYAKO.get()) { return new ItemStack(Items_Teatime.DONBURI_OYAKO.get(), 1); }
		if (this == Dish_Blocks.DONBURI_GYU.get()) { return new ItemStack(Items_Teatime.DONBURI_GYU.get(), 1); }
		if (this == Dish_Blocks.DONBURI_KAISEN.get()) { return new ItemStack(Items_Teatime.DONBURI_KAISEN.get(), 1); }
		return null;
	}
}
