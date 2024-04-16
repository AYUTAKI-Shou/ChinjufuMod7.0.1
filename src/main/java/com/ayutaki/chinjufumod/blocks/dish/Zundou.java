package com.ayutaki.chinjufumod.blocks.dish;

import com.ayutaki.chinjufumod.blocks.base.BaseStage2_FaceWater;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Zundou extends BaseStage2_FaceWater {

	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D);

	/** 1=close, 2=open **/
	public Zundou(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();

		if (item == Items.WATER_BUCKET) {
			
			CMEvents.WaterBucket_Empty(worldIn, pos, playerIn, hand);
			worldIn.setBlock(pos, Dish_Blocks.ZUNDOU_MIZU.get().defaultBlockState()
					.setValue(H_FACING, state.getValue(H_FACING))
					.setValue(BaseZundou_2Cook.STAGE_1_2, Integer.valueOf(1)), 3); }

		if ( item == Items_Teatime.MIZUOKE_full.get()) {
			
			CMEvents.MIZUOKEfull_Empty(worldIn, pos, playerIn, hand);
			worldIn.setBlock(pos, Dish_Blocks.ZUNDOU_MIZU.get().defaultBlockState()
					.setValue(H_FACING, state.getValue(H_FACING))
					.setValue(BaseZundou_2Cook.STAGE_1_2, Integer.valueOf(1)), 3); }


		if (item == Items.MILK_BUCKET) {
			
			CMEvents.WaterBucket_Empty(worldIn, pos, playerIn, hand);
			worldIn.setBlock(pos, Dish_Blocks.ZUNDOU_MILK.get().defaultBlockState()
					.setValue(H_FACING, state.getValue(H_FACING))
					.setValue(BaseZundou_2Cook.STAGE_1_2, Integer.valueOf(1)), 3); }

		if (item == Items_Teatime.MIZUOKE_Milk.get()) {
			
			CMEvents.MIZUOKEfull_Empty(worldIn, pos, playerIn, hand);
			worldIn.setBlock(pos, Dish_Blocks.ZUNDOU_MILK.get().defaultBlockState()
					.setValue(H_FACING, state.getValue(H_FACING))
					.setValue(BaseZundou_2Cook.STAGE_1_2, Integer.valueOf(1)), 3); }
		
		if (item != Items.WATER_BUCKET && item != Items_Teatime.MIZUOKE_full.get() && item != Items.MILK_BUCKET && item != Items_Teatime.MIZUOKE_Milk.get()) {
			CMEvents.textNotHave(worldIn, pos, playerIn); }

		/** SUCCESS to not put anything on top. **/
		return InteractionResult.SUCCESS;
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return AABB_BOX;
	}
}
