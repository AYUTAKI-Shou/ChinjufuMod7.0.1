package com.ayutaki.chinjufumod.blocks.dish;

import com.ayutaki.chinjufumod.blocks.base.BaseStage2_FaceWater;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class Zundou extends BaseStage2_FaceWater {

	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D);

	/** 1=蓋閉め、2=蓋開き **/
	public Zundou(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();

		if (item == Items.WATER_BUCKET) {
			
			CMEvents.WaterBucket_Empty(worldIn, pos, playerIn, hand);
			worldIn.setBlock(pos, Dish_Blocks.ZUNDOU_MIZU.defaultBlockState()
					.setValue(H_FACING, state.getValue(H_FACING))
					.setValue(BaseZundou_2Cook.STAGE_1_2, Integer.valueOf(1)), 3); }

		if ( item == Items_Teatime.MIZUOKE_full) {
			
			CMEvents.MIZUOKEfull_Empty(worldIn, pos, playerIn, hand);
			worldIn.setBlock(pos, Dish_Blocks.ZUNDOU_MIZU.defaultBlockState()
					.setValue(H_FACING, state.getValue(H_FACING))
					.setValue(BaseZundou_2Cook.STAGE_1_2, Integer.valueOf(1)), 3); }


		if (item == Items.MILK_BUCKET) {
			
			CMEvents.WaterBucket_Empty(worldIn, pos, playerIn, hand);
			worldIn.setBlock(pos, Dish_Blocks.ZUNDOU_MILK.defaultBlockState()
					.setValue(H_FACING, state.getValue(H_FACING))
					.setValue(BaseZundou_2Cook.STAGE_1_2, Integer.valueOf(1)), 3); }

		if (item == Items_Teatime.MIZUOKE_Milk) {
			
			CMEvents.MIZUOKEfull_Empty(worldIn, pos, playerIn, hand);
			worldIn.setBlock(pos, Dish_Blocks.ZUNDOU_MILK.defaultBlockState()
					.setValue(H_FACING, state.getValue(H_FACING))
					.setValue(BaseZundou_2Cook.STAGE_1_2, Integer.valueOf(1)), 3); }
		
		if (item != Items.WATER_BUCKET && item != Items_Teatime.MIZUOKE_full && item != Items.MILK_BUCKET && item != Items_Teatime.MIZUOKE_Milk) {
			CMEvents.textNotHave(worldIn, pos, playerIn); }

		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return AABB_BOX;
	}
}
