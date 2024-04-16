package com.ayutaki.chinjufumod.blocks.dish;

import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
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
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

public class SushiOkeFull_1 extends BaseFood_Stage9Water {

	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.5D, 16.0D);
	protected static final VoxelShape AABB_DOWN = Block.box(0.0D, -8.0D, 0.0D, 16.0D, -0.1D, 16.0D);

	protected static final VoxelShape AABB9_BOX = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 2.5D, 15.0D);
	protected static final VoxelShape AABB9_DOWN = Block.box(1.0D, -8.0D, 1.0D, 15.0D, 0.1D, 15.0D);
	
	public SushiOkeFull_1(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getItemInHand(hand);
		int i = state.getValue(STAGE_1_9);

		/** Hand is empty. **/
		if (stack.isEmpty()) {
			
			CMEvents.soundTake_Pick(worldIn, pos);	
			if (i < 8) {
				if (i == 1) { playerIn.inventory.add(new ItemStack(Items_Teatime.SUSHI_S)); }
				if (i == 2) { playerIn.inventory.add(new ItemStack(Items_Teatime.SUSHI_F)); }
				if (i == 3) { playerIn.inventory.add(new ItemStack(Items_Teatime.SUSHI_B)); }
				if (i == 4) { playerIn.inventory.add(new ItemStack(Items_Teatime.SUSHI_T)); }

				if (i == 5) { playerIn.inventory.add(new ItemStack(Items_Teatime.SUSHI_S)); }
				if (i == 6) { playerIn.inventory.add(new ItemStack(Items_Teatime.SUSHI_F)); }
				if (i == 7) { playerIn.inventory.add(new ItemStack(Items_Teatime.SUSHI_B)); }

				worldIn.setBlock(pos, state.setValue(STAGE_1_9, Integer.valueOf(i + 1)), 3); }

			if (i == 8) {
				playerIn.inventory.add(new ItemStack(Items_Teatime.SUSHI_T));

				worldIn.setBlock(pos, Dish_Blocks.SUSHIOKE_FULL_9.defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(DOWN, state.getValue(DOWN))
						.setValue(STAGE_1_9, Integer.valueOf(1)), 3); }
			
			if (i == 9) { CMEvents.textIsEmpty(worldIn, pos, playerIn); }
		}
		
		if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		int i = state.getValue(STAGE_1_9);
		
		if (i != 9) { 
			if (inWater(state, worldIn, pos)) {
				worldIn.getBlockTicks().scheduleTick(pos, this, 60);
				CMEvents.soundSnowBreak(worldIn, pos);
				worldIn.setBlock(pos, Dish_Blocks.SUSHIOKE_FULL_9.defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(DOWN, state.getValue(DOWN))
						.setValue(SushiOkeFull_9.STAGE_1_9, Integer.valueOf(9))
						.setValue(SushiOkeFull_9.WATERLOGGED, state.getValue(WATERLOGGED)), 3);
				this.dropRottenfood(worldIn, pos); }
			
			else { } }
		
		if (i == 9) { }
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		boolean flag = !((Boolean)state.getValue(DOWN)).booleanValue();
		int i = state.getValue(STAGE_1_9);
		
		if (i == 9) { return flag? AABB9_BOX : AABB9_DOWN; }
		return flag? AABB_BOX : AABB_DOWN;
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		int i = state.getValue(STAGE_1_9);
		return (i != 9)? new ItemStack(Items_Teatime.SUSHIOKE_FULL_1) : new ItemStack(Items.AIR);
	}
	
	/* The best harvesting tool. */
	@Nullable
	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.AXE;
	}

	@Override
	public int getHarvestLevel(BlockState state) {
		return 0;
	}
}
