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

public class Ramen extends BaseFood_Stage4Water {

	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.makeCuboidShape(5.8D, 0.0D, 5.8D, 10.2D, 3.0D, 10.2D);
	protected static final VoxelShape AABB_DOWN = Block.makeCuboidShape(5.8D, -8.0D, 5.8D, 10.2D, 0.1D, 10.2D);

	public Ramen(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getHeldItem(hand);
		int i = state.get(STAGE_1_4);

		if (i != 5) {
			/** Hand is empty. **/
			if (stack.isEmpty()) {
				CMEvents.soundEat(worldIn, pos);
				/** カツ丼と同値 **/
				if (i == 1) {
					playerIn.addPotionEffect(new EffectInstance(Effects.HASTE, 4200, 0));
					playerIn.addPotionEffect(new EffectInstance(Effects.SATURATION, 3, 0));
					worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i + 1))); }
	
				if (i == 2) {
					playerIn.addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, 0, 0));
					playerIn.addPotionEffect(new EffectInstance(Effects.SATURATION, 3, 0));
					worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i + 1))); }
	
				if (i == 3) {
					playerIn.addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, 0, 0));
					playerIn.addPotionEffect(new EffectInstance(Effects.SATURATION, 3, 0));
					worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i + 1))); }
	
				if (i == 4) {
					playerIn.addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, 0, 0));
					playerIn.addPotionEffect(new EffectInstance(Effects.SATURATION, 3, 0));
					playerIn.addPotionEffect(new EffectInstance(Effects.REGENERATION, 4200, 0));
					worldIn.setBlockState(pos, Dish_Blocks.UDON_SU.getDefaultState()
							.with(H_FACING, state.get(H_FACING)).with(DOWN, state.get(DOWN))
							.with(STAGE_1_4, Integer.valueOf(4))); }
			}
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		if (i == 5) { CMEvents.textIsEmpty(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		int i = state.get(STAGE_1_4);
		
		if (i != 5) {
			if (inWater(state, worldIn, pos)) {
				worldIn.getPendingBlockTicks().scheduleTick(pos, this, 60);
				CMEvents.soundSnowBreak(worldIn, pos);
				worldIn.setBlockState(pos, Dish_Blocks.UDON_SU.getDefaultState()
						.with(H_FACING, state.get(H_FACING)).with(DOWN, state.get(DOWN))
						.with(STAGE_1_4, Integer.valueOf(4)));
				this.dropRottenfood(worldIn, pos); }
			
			else { } }
		
		if (i == 5) { }
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
		if (this == Dish_Blocks.RAMEN_SHOUYU) { return new ItemStack(Items_Teatime.RAMEN_SHOUYU, 1); }
		if (this == Dish_Blocks.RAMEN_MISO) { return new ItemStack(Items_Teatime.RAMEN_MISO, 1); }
		if (this == Dish_Blocks.RAMEN_SHIO) { return new ItemStack(Items_Teatime.RAMEN_SHIO, 1); }
		return null;
	}
}
