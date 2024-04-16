package com.ayutaki.chinjufumod.blocks.dish;

import java.util.Random;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class Donburi extends BaseFood_Stage4Water {

	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.makeCuboidShape(5.8D, 0.0D, 5.8D, 10.2D, 3.0D, 10.2D);
	protected static final VoxelShape AABB_DOWN = Block.makeCuboidShape(5.8D, -8.0D, 5.8D, 10.2D, 0.1D, 10.2D);

	public Donburi(Block.Properties properties) {
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
	
				if (this == Dish_Blocks.DONBURI_MESHI) {
					if (i == 1) { playerIn.addPotionEffect(new EffectInstance(Effects.SATURATION, 2, 0)); }
					if (i == 2) { playerIn.addPotionEffect(new EffectInstance(Effects.SATURATION, 2, 0)); }
					if (i == 3) { playerIn.addPotionEffect(new EffectInstance(Effects.SATURATION, 2, 0)); }
				}
				
				if (this == Dish_Blocks.DONBURI_KATSU) {
					if (i == 1) { 
						/** 採掘3600 1秒＝20 満腹は2で肉メモリの1個分 カツ調理分加算 +600tick **/
						playerIn.addPotionEffect(new EffectInstance(Effects.HASTE, 4200, 0));
						playerIn.addPotionEffect(new EffectInstance(Effects.SATURATION, 4, 0)); }
					
					if (i == 2) { 
						/** 即時回復は0,0でよい 満腹は2で肉メモリの1個分 **/
						playerIn.addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, 0, 0));
						playerIn.addPotionEffect(new EffectInstance(Effects.SATURATION, 4, 0)); }
					
					if (i == 3) { 
						/** リジェネは3600 即時回復は0,0でよい 満腹は2で肉メモリの1個分 カツ調理分加算 +600tick **/
						playerIn.addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, 0, 0));
						playerIn.addPotionEffect(new EffectInstance(Effects.REGENERATION, 4200, 0));
						playerIn.addPotionEffect(new EffectInstance(Effects.SATURATION, 4, 0)); }
				}
				
				if (this == Dish_Blocks.DONBURI_GYU || this == Dish_Blocks.DONBURI_OYAKO || this == Dish_Blocks.DONBURI_KAISEN) {
					if (i == 1) { 
						/** 採掘3600 1秒＝20 満腹は2で肉メモリの1個分 **/
						playerIn.addPotionEffect(new EffectInstance(Effects.HASTE, 3600, 0));
						playerIn.addPotionEffect(new EffectInstance(Effects.SATURATION, 4, 0)); }
					
					if (i == 2) { 
						/** 即時回復は0,0でよい 満腹は2で肉メモリの1個分 **/
						playerIn.addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, 0, 0));
						playerIn.addPotionEffect(new EffectInstance(Effects.SATURATION, 4, 0)); }
					
					if (i == 3) {
						/** リジェネは3600 即時回復は0,0でよい 満腹は2で肉メモリの1個分 **/
						playerIn.addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, 0, 0));
						playerIn.addPotionEffect(new EffectInstance(Effects.REGENERATION, 3600, 0));
						playerIn.addPotionEffect(new EffectInstance(Effects.SATURATION, 4, 0)); }
				}
	
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
			
			else { }
		}
		
		if (i == 4) { }
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		boolean flag= !((Boolean)state.get(DOWN)).booleanValue();
		return flag? AABB_BOX : AABB_DOWN;
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return this.takeStack();
	}
	
	private ItemStack takeStack() {
		if (this == Dish_Blocks.DONBURI_MESHI) { return new ItemStack(Items_Teatime.DONBURI_MESHI, 1); }
		if (this == Dish_Blocks.DONBURI_KATSU) { return new ItemStack(Items_Teatime.DONBURI_KATSU, 1); }
		if (this == Dish_Blocks.DONBURI_OYAKO) { return new ItemStack(Items_Teatime.DONBURI_OYAKO, 1); }
		if (this == Dish_Blocks.DONBURI_GYU) { return new ItemStack(Items_Teatime.DONBURI_GYU, 1); }
		if (this == Dish_Blocks.DONBURI_KAISEN) { return new ItemStack(Items_Teatime.DONBURI_KAISEN, 1); }
		return null;
	}
}
