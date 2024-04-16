package com.ayutaki.chinjufumod.blocks.dish;

import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
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

public class SushiOkeFull_9 extends BaseFood_Stage9Water {

	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.5D, 16.0D);
	protected static final VoxelShape AABB_DOWN = Block.makeCuboidShape(0.0D, -8.0D, 0.0D, 16.0D, -0.1D, 16.0D);

	public SushiOkeFull_9(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getHeldItem(hand);
		int i = state.get(STAGE_1_9);

		if (i != 9) {
			/** Hand is empty. **/
			if (stack.isEmpty()) {
				CMEvents.soundTake_Pick(worldIn, pos);
	
				if (i == 1) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SUSHI_S)); }
				if (i == 2) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SUSHI_F)); }
				if (i == 3) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SUSHI_B)); }
				if (i == 4) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SUSHI_T)); }
	
				if (i == 5) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SUSHI_S)); }
				if (i == 6) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SUSHI_F)); }
				if (i == 7) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SUSHI_B)); }
				if (i == 8) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SUSHI_T)); }
	
				worldIn.setBlockState(pos, state.with(STAGE_1_9, Integer.valueOf(i + 1))); }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
	
		if (i == 9) { CMEvents.textIsEmpty(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		int i = state.get(STAGE_1_9);
		
		if (i != 9) {
			if (inWater(state, worldIn, pos)) {
				worldIn.getPendingBlockTicks().scheduleTick(pos, this, 60);
				CMEvents.soundSnowBreak(worldIn, pos);
				worldIn.setBlockState(pos, state.with(STAGE_1_9, Integer.valueOf(9)));
				this.dropRottenfood(worldIn, pos); }
			
			else { } }
	
		if (i == 9) { }
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
		return new ItemStack(Items_Teatime.SUSHIOKE_FULL_1);
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
