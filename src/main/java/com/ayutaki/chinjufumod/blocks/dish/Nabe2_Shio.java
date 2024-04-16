package com.ayutaki.chinjufumod.blocks.dish;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Nabe2_Shio extends BaseNabe_2Cook {

	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.makeCuboidShape(3.5D, 0.0D, 3.5D, 12.5D, 4.0D, 12.5D);

	public Nabe2_Shio(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getHeldItem(hand);
		int i = state.get(STAGE_1_2);

		if (i != 1) {
			/** Hand is empty. **/
			if (stack.isEmpty()) {
				
				CMEvents.soundTake_Pick(worldIn, pos);	
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SHIO, 3));
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.NIGARI, 1))) {
					playerIn.dropItem(new ItemStack(Items_Teatime.NIGARI, 1), false); }
	
				worldIn.setBlockState(pos, Dish_Blocks.NABE_kara.getDefaultState().with(Nabe_kara.H_FACING, state.get(H_FACING))
						.with(Nabe_kara.STAGE_1_4, Integer.valueOf(4))); }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		if (i == 1) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		if (!inWater(state, worldIn, pos)) {
			if (isCooking(worldIn, pos)) {
				worldIn.getPendingBlockTicks().scheduleTick(pos, this, COOK_TIME + (20 * rand.nextInt(5)));
				worldIn.setBlockState(pos, state.with(STAGE_1_2, Integer.valueOf(2))); }
			
			else { } }

		if (inWater(state, worldIn, pos)) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, this, 60);
			CMEvents.soundBubble(worldIn, pos);
			worldIn.setBlockState(pos, Dish_Blocks.NABE_kara.getDefaultState()
					.with(Nabe_kara.H_FACING, state.get(H_FACING))
					.with(Nabe_kara.STAGE_1_4, Integer.valueOf(4))
					.with(Nabe_kara.WATERLOGGED, state.get(WATERLOGGED)), 3); }
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_nabe").applyTextStyle(TextFormatting.GRAY));
		tooltip.add(new TranslationTextComponent("tips.block_food_nabetoufu_b").applyTextStyle(TextFormatting.GRAY));
	}
}
