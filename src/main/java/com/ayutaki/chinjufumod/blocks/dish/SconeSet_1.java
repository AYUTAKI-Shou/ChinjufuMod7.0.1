package com.ayutaki.chinjufumod.blocks.dish;

import java.util.Random;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingWater;
import com.ayutaki.chinjufumod.blocks.base.BaseStage8_FaceWater;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_NoTab;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.InventoryHelper;
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

public class SconeSet_1 extends BaseStage8_FaceWater {

	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 10.5D, 13.0D);

	public SconeSet_1(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getItemInHand(hand);
		int i = state.getValue(STAGE_1_8);

		/** Hand is empty. **/
		if (stack.isEmpty()) {

			CMEvents.soundTake_Pick(worldIn, pos);

			if (i != 8) {
				if (i == 1) { playerIn.inventory.add(new ItemStack(Items_Teatime.EGGSAND)); }
				if (i == 2) { playerIn.inventory.add(new ItemStack(Items_Teatime.CHICKENSAND)); }
				if (i == 3) { playerIn.inventory.add(new ItemStack(Items_Teatime.EGGSAND)); }
				if (i == 4) { playerIn.inventory.add(new ItemStack(Items_Teatime.CHICKENSAND)); }

				if (i == 5) { playerIn.inventory.add(new ItemStack(Items_Teatime.SCONE)); }
				if (i == 6) { playerIn.inventory.add(new ItemStack(Items_Teatime.SCONE)); }
				if (i == 7) { playerIn.inventory.add(new ItemStack(Items_Teatime.CAKE)); }

				worldIn.setBlock(pos, state.setValue(STAGE_1_8, Integer.valueOf(i + 1)), 3); }

			if (i == 8) {
				playerIn.inventory.add(new ItemStack(Items_Teatime.CAKE));

				worldIn.setBlock(pos, Dish_Blocks.SCONESET_kara.defaultBlockState()
						.setValue(BaseFacingWater.H_FACING, state.getValue(H_FACING)), 3); }
		}
		
		if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* TickRandom */
	@Override
	public void onPlace(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		worldIn.getBlockTicks().scheduleTick(pos, this, 60);
	}

	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		if (state.getValue(WATERLOGGED)) {
			worldIn.getBlockTicks().scheduleTick(pos, this, 60);
			CMEvents.soundSnowBreak(worldIn, pos);
			worldIn.setBlock(pos, Dish_Blocks.SCONESET_kara.defaultBlockState()
					.setValue(SconeSet_kara.H_FACING, state.getValue(H_FACING))
					.setValue(SconeSet_kara.WATERLOGGED, state.getValue(WATERLOGGED)), 3);
			this.dropRottenfood(worldIn, pos); }
		
		else { }
	}

	protected void dropRottenfood(ServerWorld worldIn, BlockPos pos) {
		ItemStack stack = new ItemStack(Items_NoTab.ROTTEN_FOOD);
		InventoryHelper.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return AABB_BOX;
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.SCONESET_1, 1);
	}
}
