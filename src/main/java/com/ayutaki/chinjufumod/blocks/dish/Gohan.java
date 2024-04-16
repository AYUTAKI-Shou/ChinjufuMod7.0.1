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

public class Gohan extends BaseFood_Stage3Water {

	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.makeCuboidShape(6.5D, 0.0D, 6.5D, 9.5D, 2.0D, 9.5D);
	protected static final VoxelShape AABB_DOWN = Block.makeCuboidShape(6.5D, -8.0D, 6.5D, 9.5D, 0.1D, 9.5D);

	public Gohan(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getHeldItem(hand);
		int i = state.get(STAGE_1_3);

		if (i != 3) {
			/** Hand is empty. **/
			if (stack.isEmpty()) {
				CMEvents.soundEat(worldIn, pos);
	
				if (this == Dish_Blocks.GOHAN) { 
					if (i == 1) { playerIn.addPotionEffect(new EffectInstance(Effects.SATURATION, 2, 0)); }
					
					if (i == 2) { playerIn.addPotionEffect(new EffectInstance(Effects.SATURATION, 2, 0)); } }
				
				if (this != Dish_Blocks.GOHAN) { 
					if (i == 1) {
						playerIn.addPotionEffect(new EffectInstance(Effects.HASTE, 100, 0));
						playerIn.addPotionEffect(new EffectInstance(Effects.SATURATION, 2, 0)); }
					
					if (i == 2) {
						playerIn.addPotionEffect(new EffectInstance(Effects.HASTE, 100, 0));
						playerIn.addPotionEffect(new EffectInstance(Effects.SATURATION, 2, 0)); } }
	
				worldIn.setBlockState(pos, state.with(STAGE_1_3, Integer.valueOf(i + 1))); }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		if (i == 3) { CMEvents.textIsEmpty(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		int i = state.get(STAGE_1_3);
		
		if (i != 3) {
			if (inWater(state, worldIn, pos)) {
				worldIn.getPendingBlockTicks().scheduleTick(pos, this, 60);
				CMEvents.soundSnowBreak(worldIn, pos);
				worldIn.setBlockState(pos, state.with(STAGE_1_3, Integer.valueOf(3)));
				this.dropRottenfood(worldIn, pos); }
			
			else { } }
		
		if (i == 3) { }
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
		if (this == Dish_Blocks.GOHAN) { return new ItemStack(Items_Teatime.GOHAN, 1); }
		if (this == Dish_Blocks.GOHAN_TAKE) { return new ItemStack(Items_Teatime.GOHAN_TAKE, 1); }
		if (this == Dish_Blocks.GOHAN_KURI) { return new ItemStack(Items_Teatime.GOHAN_KURI, 1); }
		return null;
	}
}
