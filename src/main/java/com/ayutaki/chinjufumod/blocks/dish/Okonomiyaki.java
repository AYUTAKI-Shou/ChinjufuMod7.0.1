package com.ayutaki.chinjufumod.blocks.dish;

import java.util.Random;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.AbstractBlock;
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

public class Okonomiyaki extends BaseFood_Stage5Water {

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.box(3.5D, 0.0D, 2.5D, 12.5D, 3.0D, 11.5D);
	protected static final VoxelShape AABB_WEST = Block.box(4.5D, 0.0D, 3.5D, 13.5D, 3.0D, 12.5D);
	protected static final VoxelShape AABB_NORTH = Block.box(3.5D, 0.0D, 4.5D, 12.5D, 3.0D, 13.5D);
	protected static final VoxelShape AABB_EAST = Block.box(2.5D, 0.0D, 3.5D, 11.5D, 3.0D, 12.5D);

	protected static final VoxelShape DOWN_SOUTH = Block.box(3.5D, -8.0D, 2.5D, 12.5D, 0.1D, 11.5D);
	protected static final VoxelShape DOWN_WEST = Block.box(4.5D, -8.0D, 3.5D, 13.5D, 0.1D, 12.5D);
	protected static final VoxelShape DOWN_NORTH = Block.box(3.5D, -8.0D, 4.5D, 12.5D, 0.1D, 13.5D);
	protected static final VoxelShape DOWN_EAST = Block.box(2.5D, -8.0D, 3.5D, 11.5D, 0.1D, 12.5D);

	public Okonomiyaki(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getItemInHand(hand);
		int i = state.getValue(STAGE_1_5);

		if (i != 5) {
			/** Hand is empty. **/
			if (stack.isEmpty()) {
				CMEvents.soundEat(worldIn, pos);
	
				if (this == Dish_Blocks.OKONOMIC) {
					if (i == 1) {
						playerIn.addEffect(new EffectInstance(Effects.DIG_SPEED, 2600, 0));
						playerIn.addEffect(new EffectInstance(Effects.SATURATION, 2, 0)); }
		
					if (i == 2) {
						playerIn.addEffect(new EffectInstance(Effects.HEAL, 0, 0));
						playerIn.addEffect(new EffectInstance(Effects.SATURATION, 3, 0)); }
		
					if (i == 3) {
						playerIn.addEffect(new EffectInstance(Effects.HEAL, 0, 0));
						playerIn.addEffect(new EffectInstance(Effects.SATURATION, 3, 0)); }
		
					if (i == 4) {
						playerIn.addEffect(new EffectInstance(Effects.HEAL, 0, 0));
						playerIn.addEffect(new EffectInstance(Effects.SATURATION, 2, 0));
						playerIn.addEffect(new EffectInstance(Effects.REGENERATION, 2600, 0)); }
				}
				
				if (this == Dish_Blocks.OKONOMIYAKI || this == Dish_Blocks.OKONOMIS) {
					if (i == 1) {
						playerIn.addEffect(new EffectInstance(Effects.DIG_SPEED, 3200, 0));
						playerIn.addEffect(new EffectInstance(Effects.SATURATION, 3, 0)); }
		
					if (i == 2) {
						playerIn.addEffect(new EffectInstance(Effects.HEAL, 0, 0));
						playerIn.addEffect(new EffectInstance(Effects.SATURATION, 3, 0)); }
		
					if (i == 3) {
						playerIn.addEffect(new EffectInstance(Effects.HEAL, 0, 0));
						playerIn.addEffect(new EffectInstance(Effects.SATURATION, 3, 0)); }
		
					if (i == 4) {
						playerIn.addEffect(new EffectInstance(Effects.HEAL, 0, 0));
						playerIn.addEffect(new EffectInstance(Effects.SATURATION, 3, 0));
						playerIn.addEffect(new EffectInstance(Effects.REGENERATION, 3200, 0)); }
				}

				if (this == Dish_Blocks.OKONOMISOBAC) {
					if (i == 1) {
						playerIn.addEffect(new EffectInstance(Effects.DIG_SPEED, 2600, 0));
						playerIn.addEffect(new EffectInstance(Effects.SATURATION, 3, 0)); }
		
					if (i == 2) {
						playerIn.addEffect(new EffectInstance(Effects.HEAL, 0, 0));
						playerIn.addEffect(new EffectInstance(Effects.SATURATION, 3, 0)); }
		
					if (i == 3) {
						playerIn.addEffect(new EffectInstance(Effects.HEAL, 0, 0));
						playerIn.addEffect(new EffectInstance(Effects.SATURATION, 3, 0)); }
		
					if (i == 4) {
						playerIn.addEffect(new EffectInstance(Effects.HEAL, 0, 0));
						playerIn.addEffect(new EffectInstance(Effects.SATURATION, 3, 0));
						playerIn.addEffect(new EffectInstance(Effects.REGENERATION, 2600, 0)); }
				}
				
				if (this == Dish_Blocks.OKONOMISOBA || this == Dish_Blocks.OKONOMISOBAS) {
					if (i == 1) {
						playerIn.addEffect(new EffectInstance(Effects.DIG_SPEED, 3200, 0));
						playerIn.addEffect(new EffectInstance(Effects.SATURATION, 3, 0)); }
		
					if (i == 2) {
						playerIn.addEffect(new EffectInstance(Effects.HEAL, 0, 0));
						playerIn.addEffect(new EffectInstance(Effects.SATURATION, 4, 0)); }
		
					if (i == 3) {
						playerIn.addEffect(new EffectInstance(Effects.HEAL, 0, 0));
						playerIn.addEffect(new EffectInstance(Effects.SATURATION, 4, 0)); }
		
					if (i == 4) {
						playerIn.addEffect(new EffectInstance(Effects.HEAL, 0, 0));
						playerIn.addEffect(new EffectInstance(Effects.SATURATION, 3, 0));
						playerIn.addEffect(new EffectInstance(Effects.REGENERATION, 3200, 0)); }
				}
				
				worldIn.setBlock(pos, state.setValue(STAGE_1_5, Integer.valueOf(i + 1)), 3); }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		if (i == 5) { CMEvents.textIsEmpty(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		int i = state.getValue(STAGE_1_5);
		
		if (i != 5) {
			if (inWater(state, worldIn, pos)) {
				worldIn.getBlockTicks().scheduleTick(pos, this, 60);
				CMEvents.soundSnowBreak(worldIn, pos);
				worldIn.setBlock(pos, state.setValue(STAGE_1_5, Integer.valueOf(5)), 3);
				this.dropRottenfood(worldIn, pos); }
			
			else { } }
		
		if (i == 5) { }
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

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
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return this.takeStack();
	}
	
	private ItemStack takeStack() {
		if (this == Dish_Blocks.OKONOMIYAKI) { return new ItemStack(Items_Teatime.OKONOMIYAKI, 1); }
		if (this == Dish_Blocks.OKONOMIS) { return new ItemStack(Items_Teatime.OKONOMIS, 1); }
		if (this == Dish_Blocks.OKONOMIC) { return new ItemStack(Items_Teatime.OKONOMIC, 1); }
		if (this == Dish_Blocks.OKONOMISOBA) { return new ItemStack(Items_Teatime.OKONOMISOBA, 1); }
		if (this == Dish_Blocks.OKONOMISOBAS) { return new ItemStack(Items_Teatime.OKONOMISOBAS, 1); }
		if (this == Dish_Blocks.OKONOMISOBAC) { return new ItemStack(Items_Teatime.OKONOMISOBAC, 1); }
		return null;
	}
}
