package com.ayutaki.chinjufumod.blocks.dish;

import com.ayutaki.chinjufumod.blocks.base.BaseStage2_FaceWater;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.entity.player.PlayerEntity;
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

public class SconeSet_kara extends BaseStage2_FaceWater {

	/* Collision 1=空、2＝煮干し空*/
	protected static final VoxelShape AABB_1 = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 10.5D, 13.0D);
	protected static final VoxelShape AABB_2 = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 1.0D, 13.0D);

	public SconeSet_kara(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getItemInHand(hand);
		int i = state.getValue(STAGE_1_2);

		if (i == 2) {
			if (stack.isEmpty()) {
				
				CMEvents.soundTake_Pick(worldIn, pos);
				playerIn.inventory.add(new ItemStack(Items.PAPER));
				
				worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), 3); }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		if (i != 2) { CMEvents.textIsEmpty(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	public SoundType getSoundType(BlockState state) {
		int wet = state.getValue(STAGE_1_2);
		if (wet == 2) { return SoundType.SNOW; }
		 return this.soundType;
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return (state.getValue(STAGE_1_2) == 1)? AABB_1 : AABB_2;
	}

	/* Clone Item in Creative. : new ItemStack(Items.PAPER)*/
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return (this == Dish_Blocks.SCONESET_kara)? new ItemStack(Items_Teatime.SCONESET_kara, 1) : new ItemStack(Items.PAPER, 1);
	}
}
