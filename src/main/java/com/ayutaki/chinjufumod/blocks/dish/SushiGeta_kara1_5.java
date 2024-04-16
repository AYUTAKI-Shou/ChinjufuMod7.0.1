package com.ayutaki.chinjufumod.blocks.dish;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_NoTab;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

public class SushiGeta_kara1_5 extends BaseFood_Stage5Water {

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.makeCuboidShape(1.0D, 0.0D, 7.0D, 14.0D, 1.5D, 12.5D);
	protected static final VoxelShape AABB_WEST = Block.makeCuboidShape(3.5D, 0.0D, 1.0D, 9.0D, 1.5D, 14.0D);
	protected static final VoxelShape AABB_NORTH = Block.makeCuboidShape(2.0D, 0.0D, 3.5D, 15.0D, 1.5D, 9.0D);
	protected static final VoxelShape AABB_EAST = Block.makeCuboidShape(7.0D, 0.0D, 2.0D, 12.5D, 1.5D, 15.0D);

	protected static final VoxelShape DOWN_SOUTH = Block.makeCuboidShape(1.0D, -8.0D, 7.0D, 14.0D, 0.1D, 12.5D);
	protected static final VoxelShape DOWN_WEST = Block.makeCuboidShape(3.5D, -8.0D, 1.0D, 9.0D, 0.1D, 14.0D);
	protected static final VoxelShape DOWN_NORTH = Block.makeCuboidShape(2.0D, -8.0D, 3.5D, 15.0D, 0.1D, 9.0D);
	protected static final VoxelShape DOWN_EAST = Block.makeCuboidShape(7.0D, -8.0D, 2.0D, 12.5D, 0.1D, 15.0D);

	public SushiGeta_kara1_5(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		int i = state.get(STAGE_1_5);
		boolean sushi = (item == Items_Teatime.SUSHI_S || item == Items_Teatime.SUSHI_F || item == Items_Teatime.SUSHI_B || item == Items_Teatime.SUSHI_T);
		boolean shouyu = (item == Items_Teatime.SHOUYU_bot_1 || item == Items_NoTab.SHOUYU_bot_2 || item == Items_NoTab.SHOUYU_bot_3 || item == Items_NoTab.SHOUYU_bot_4);

		if (!state.get(WATERLOGGED)) {
			/** Soy sauce is empty **/
			if (i == 1) {
				if (shouyu) {
					if (item == Items_Teatime.SHOUYU_bot_1) { CMEvents.SoysauceTo2(worldIn, pos, playerIn, hand); }
					if (item == Items_NoTab.SHOUYU_bot_2) { CMEvents.SoysauceTo3(worldIn, pos, playerIn, hand); }
					if (item == Items_NoTab.SHOUYU_bot_3) { CMEvents.SoysauceTo4(worldIn, pos, playerIn, hand); }
					if (item == Items_NoTab.SHOUYU_bot_4) { CMEvents.SoysauceToBottle(worldIn, pos, playerIn, hand); }
					
					worldIn.setBlockState(pos, state.with(STAGE_1_5, Integer.valueOf(2))); }
				
				if (!shouyu) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			}
			
			/** Soy sauce is not empty **/
			if (i != 1) {
				if (item == Items_Teatime.SUSHI_S) {
					/** Collect with an Item **/
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					
					worldIn.setBlockState(pos, Dish_Blocks.SUSHIGETA_salmon.getDefaultState()
							.with(H_FACING, state.get(H_FACING))
							.with(DOWN, state.get(DOWN))
							.with(BaseFood_Stage4Water.STAGE_1_4, Integer.valueOf(i - 1)), 3); }
				
				if (item == Items_Teatime.SUSHI_F) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					
					worldIn.setBlockState(pos, Dish_Blocks.SUSHIGETA_fish.getDefaultState()
							.with(H_FACING, state.get(H_FACING))
							.with(DOWN, state.get(DOWN))
							.with(BaseFood_Stage4Water.STAGE_1_4, Integer.valueOf(i - 1)), 3); }
				
				if (item == Items_Teatime.SUSHI_B) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					
					worldIn.setBlockState(pos, Dish_Blocks.SUSHIGETA_beef.getDefaultState()
							.with(H_FACING, state.get(H_FACING))
							.with(DOWN, state.get(DOWN))
							.with(BaseFood_Stage4Water.STAGE_1_4, Integer.valueOf(i - 1)), 3); }
				
				if (item == Items_Teatime.SUSHI_T) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					
					worldIn.setBlockState(pos, Dish_Blocks.SUSHIGETA_tamago.getDefaultState()
							.with(H_FACING, state.get(H_FACING))
							.with(DOWN, state.get(DOWN))
							.with(BaseFood_Stage4Water.STAGE_1_4, Integer.valueOf(i - 1)), 3); }
	
				
				if (!sushi) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			}
		}
		
		if (state.get(WATERLOGGED)) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); }

		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		int i = state.get(STAGE_1_5);
		
		if (i != 1) {
			if (inWater(state, worldIn, pos)) {
				worldIn.getPendingBlockTicks().scheduleTick(pos, this, 60);
				CMEvents.soundBubble(worldIn, pos);
				worldIn.setBlockState(pos, state.with(STAGE_1_5, Integer.valueOf(1))); }

			else { }
		}

		if (i == 1) { }
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(H_FACING);
		boolean flag= !((Boolean)state.get(DOWN)).booleanValue();

		switch(direction) {
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
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.SUSHIGETA_kara);
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

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_food_sushigeta_kara").applyTextStyle(TextFormatting.GRAY));
	}
}
