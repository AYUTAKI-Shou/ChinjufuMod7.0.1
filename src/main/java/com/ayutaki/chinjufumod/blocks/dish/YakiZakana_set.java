package com.ayutaki.chinjufumod.blocks.dish;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
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

public class YakiZakana_set extends BaseFood_Stage5Water {

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.box(2.0D, 0.0D, 3.0D, 14.0D, 3.0D, 11.0D);
	protected static final VoxelShape AABB_WEST = Block.box(5.0D, 0.0D, 2.0D, 13.0D, 3.0D, 14.0D);
	protected static final VoxelShape AABB_NORTH = Block.box(2.0D, 0.0D, 5.0D, 14.0D, 3.0D, 13.0D);
	protected static final VoxelShape AABB_EAST = Block.box(3.0D, 0.0D, 2.0D, 11.0D, 3.0D, 14.0D);

	protected static final VoxelShape DOWN_SOUTH = Block.box(2.0D, -8.0D, 3.0D, 14.0D, 0.1D, 11.0D);
	protected static final VoxelShape DOWN_WEST = Block.box(5.0D, -8.0D, 2.0D, 13.0D, 0.1D, 14.0D);
	protected static final VoxelShape DOWN_NORTH = Block.box(2.0D, -8.0D, 5.0D, 14.0D, 0.1D, 13.0D);
	protected static final VoxelShape DOWN_EAST = Block.box(3.0D, -8.0D, 2.0D, 11.0D, 0.1D, 14.0D);

	public YakiZakana_set(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		int i = state.getValue(STAGE_1_5);

		if (i != 5) {
			/** Hand is empty. **/
			if (stack.isEmpty()) {
				CMEvents.soundEat(worldIn, pos);
	
				if (this == Dish_Blocks.YAKIZAKANATEI.get()) { 
					if (i == 1) {
						/** 採掘6000/20=300秒 1秒＝20 満腹は2で肉メモリの1個分 レシピ変更分加算+200 **/
						playerIn.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 6200, 0));
						playerIn.addEffect(new MobEffectInstance(MobEffects.SATURATION, 4, 0)); }
		
					if (i == 2) {
						/** 即時回復は0,0でよい 満腹は2で肉メモリの1個分 **/
						playerIn.addEffect(new MobEffectInstance(MobEffects.HEAL, 0, 0));
						playerIn.addEffect(new MobEffectInstance(MobEffects.SATURATION, 4, 0)); }
		
					if (i == 3) {
						/** リジェネは3600 即時回復は0,0でよい 満腹は2で肉メモリの1個分 レシピ変更分加算+200 **/
						playerIn.addEffect(new MobEffectInstance(MobEffects.HEAL, 0, 0));
						playerIn.addEffect(new MobEffectInstance(MobEffects.SATURATION, 4, 0));
						playerIn.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 3800, 0)); }
		
					if (i == 4) {
						/** 耐性は3600 即時回復は0,0でよい 満腹は2で肉メモリの1個分 レシピ変更分加算+200 **/
						playerIn.addEffect(new MobEffectInstance(MobEffects.HEAL, 0, 0));
						playerIn.addEffect(new MobEffectInstance(MobEffects.SATURATION, 4, 0));
						playerIn.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3800, 1)); }
				}
				
				if (this != Dish_Blocks.YAKIZAKANATEI.get()) { 
					if (i == 1) {
						/** +100 **/
						playerIn.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 6300, 0));
						playerIn.addEffect(new MobEffectInstance(MobEffects.SATURATION, 4, 0)); }
		
					if (i == 2) {
						playerIn.addEffect(new MobEffectInstance(MobEffects.HEAL, 0, 0));
						playerIn.addEffect(new MobEffectInstance(MobEffects.SATURATION, 4, 0)); }
		
					if (i == 3) {
						/** +100 **/
						playerIn.addEffect(new MobEffectInstance(MobEffects.HEAL, 0, 0));
						playerIn.addEffect(new MobEffectInstance(MobEffects.SATURATION, 4, 0));
						playerIn.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 3900, 0)); }
		
					if (i == 4) {
						/** +100 **/
						playerIn.addEffect(new MobEffectInstance(MobEffects.HEAL, 0, 0));
						playerIn.addEffect(new MobEffectInstance(MobEffects.SATURATION, 4, 0));
						playerIn.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3900, 1)); }
				}
	
				worldIn.setBlock(pos, state.setValue(STAGE_1_5, Integer.valueOf(i + 1)), 3); }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		if (i == 5) { CMEvents.textIsEmpty(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return InteractionResult.SUCCESS;
	}
	
	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
		int i = state.getValue(STAGE_1_5);
		
		if (i != 5) {
			if (inWater(state, worldIn, pos)) {
				worldIn.scheduleTick(pos, this, 60);
				CMEvents.soundSnowBreak(worldIn, pos);
				worldIn.setBlock(pos, state.setValue(STAGE_1_5, Integer.valueOf(5)), 3);
				this.dropRottenfood(worldIn, pos); }
			
			else { } }
		
		if (i == 5) { }
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
		return this.takeStack();
	}
	
	private ItemStack takeStack() {
		if (this == Dish_Blocks.YAKIZAKANATEI.get()) { return new ItemStack(Items_Teatime.YAKIZAKANATEI.get(), 1); }
		if (this == Dish_Blocks.YAKIZAKANATEI_TAKE.get()) { return new ItemStack(Items_Teatime.YAKIZAKANATEI_TAKE.get(), 1); }
		if (this == Dish_Blocks.YAKIZAKANATEI_KURI.get()) { return new ItemStack(Items_Teatime.YAKIZAKANATEI_KURI.get(), 1); }
		return null;
	}
}
