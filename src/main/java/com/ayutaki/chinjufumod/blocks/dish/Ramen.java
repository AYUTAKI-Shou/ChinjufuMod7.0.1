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

public class Ramen extends BaseFood_Stage4Water {

	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.box(5.8D, 0.0D, 5.8D, 10.2D, 3.0D, 10.2D);
	protected static final VoxelShape AABB_DOWN = Block.box(5.8D, -8.0D, 5.8D, 10.2D, 0.1D, 10.2D);
	
	public Ramen(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		int i = state.getValue(STAGE_1_4);

		if (i != 5) {
			/** Hand is empty. **/
			if (stack.isEmpty()) {
				CMEvents.soundEat(worldIn, pos);
				/** カツ丼と同値 **/
				if (i == 1) {
					playerIn.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 4200, 0));
					playerIn.addEffect(new MobEffectInstance(MobEffects.SATURATION, 3, 0));
					worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
	
				if (i == 2) {
					playerIn.addEffect(new MobEffectInstance(MobEffects.HEAL, 0, 0));
					playerIn.addEffect(new MobEffectInstance(MobEffects.SATURATION, 3, 0));
					worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
	
				if (i == 3) {
					playerIn.addEffect(new MobEffectInstance(MobEffects.HEAL, 0, 0));
					playerIn.addEffect(new MobEffectInstance(MobEffects.SATURATION, 3, 0));
					worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
	
				if (i == 4) {
					playerIn.addEffect(new MobEffectInstance(MobEffects.HEAL, 0, 0));
					playerIn.addEffect(new MobEffectInstance(MobEffects.SATURATION, 3, 0));
					playerIn.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 4200, 0));
					worldIn.setBlock(pos, Dish_Blocks.UDON_SU.get().defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(DOWN, state.getValue(DOWN))
							.setValue(STAGE_1_4, Integer.valueOf(4)), 3); }
	
				 }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		if (i == 5) { CMEvents.textIsEmpty(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return InteractionResult.SUCCESS;
	}
	
	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
		int i = state.getValue(STAGE_1_4);
		
		if (i != 5) {
			if (inWater(state, worldIn, pos)) {
				worldIn.scheduleTick(pos, this, 60);
				CMEvents.soundSnowBreak(worldIn, pos);
				worldIn.setBlock(pos, Dish_Blocks.UDON_SU.get().defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(DOWN, state.getValue(DOWN))
						.setValue(STAGE_1_4, Integer.valueOf(4)), 3);
				this.dropRottenfood(worldIn, pos); }
			
			else { } }
		
		if (i == 5) { }
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
		if (this == Dish_Blocks.RAMEN_SHOUYU.get()) { return new ItemStack(Items_Teatime.RAMEN_SHOUYU.get(), 1); }
		if (this == Dish_Blocks.RAMEN_MISO.get()) { return new ItemStack(Items_Teatime.RAMEN_MISO.get(), 1); }
		if (this == Dish_Blocks.RAMEN_SHIO.get()) { return new ItemStack(Items_Teatime.RAMEN_SHIO.get(), 1); }
		return null;
	}
}
