package com.ayutaki.chinjufumod.blocks.jpblock;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage4_FaceWater;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.color.Base_ItemHake;

import net.minecraft.block.AbstractBlock;
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
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

public class Wall_Sama extends BaseStage4_FaceWater {

	/* Collision ...Based on the value of WallBlock.*/
	private static final VoxelShape AABB_NORTH = VoxelShapes.or(Block.box(0.0D, 0.0D, 5.0D, 16.0D, 6.0D, 11.0D),
			Block.box(0.0D, 10.0D, 5.0D, 16.0D, 16.0D, 11.0D),
			Block.box(10.0D, 6.0D, 5.0D, 16.0D, 10.0D, 11.0D),
			Block.box(0.0D, 6.0D, 5.0D, 6.0D, 10.0D, 11.0D));
	private static final VoxelShape AABB_EAST = VoxelShapes.or(Block.box(5.0D, 0.0D, 0.0D, 11.0D, 6.0D, 16.0D),
			Block.box(5.0D, 10.0D, 0.0D, 11.0D, 16.0D, 16.0D),
			Block.box(5.0D, 6.0D, 0.0D, 11.0D, 10.0D, 6.0D),
			Block.box(5.0D, 6.0D, 10.0D, 11.0D, 10.0D, 16.0D));
	private static final VoxelShape AABB_SOUTH = VoxelShapes.or(Block.box(0.0D, 0.0D, 5.0D, 16.0D, 6.0D, 11.0D),
			Block.box(0.0D, 10.0D, 5.0D, 16.0D, 16.0D, 11.0D),
			Block.box(0.0D, 6.0D, 5.0D, 6.0D, 10.0D, 11.0D),
			Block.box(10.0D, 6.0D, 5.0D, 16.0D, 10.0D, 11.0D));
	private static final VoxelShape AABB_WEST = VoxelShapes.or(Block.box(5.0D, 0.0D, 0.0D, 11.0D, 6.0D, 16.0D),
			Block.box(5.0D, 10.0D, 0.0D, 11.0D, 16.0D, 16.0D),
			Block.box(5.0D, 6.0D, 0.0D, 11.0D, 10.0D, 6.0D),
			Block.box(5.0D, 6.0D, 10.0D, 11.0D, 10.0D, 16.0D));
	
	private static final VoxelShape DOUBLE_NORTH = VoxelShapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
			Block.box(0.0D, 10.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.box(10.0D, 6.0D, 0.0D, 16.0D, 10.0D, 16.0D),
			Block.box(0.0D, 6.0D, 0.0D, 6.0D, 10.0D, 16.0D));
	private static final VoxelShape DOUBLE_EAST = VoxelShapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
			Block.box(0.0D, 10.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.box(0.0D, 6.0D, 0.0D, 16.0D, 10.0D, 6.0D),
			Block.box(0.0D, 6.0D, 10.0D, 16.0D, 10.0D, 16.0D));
	private static final VoxelShape DOUBLE_SOUTH = VoxelShapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
			Block.box(0.0D, 10.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.box(0.0D, 6.0D, 0.0D, 6.0D, 10.0D, 16.0D),
			Block.box(10.0D, 6.0D, 0.0D, 16.0D, 10.0D, 16.0D));
	private static final VoxelShape DOUBLE_WEST = VoxelShapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
			Block.box(0.0D, 10.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.box(0.0D, 6.0D, 0.0D, 16.0D, 10.0D, 6.0D),
			Block.box(0.0D, 6.0D, 10.0D, 16.0D, 10.0D, 16.0D));
	
	public Wall_Sama(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		int i = state.getValue(STAGE_1_4);
		
		if (item instanceof Base_ItemHake) { return ActionResultType.PASS; }

		if (stack.getItem() == this.asItem() && (i == 1 || i == 2)) {
			CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);
			worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(i + 2)), 3);
			return ActionResultType.SUCCESS; }
		
		else {
			if (stack.isEmpty()) {
				if (playerIn.isCrouching()) {
					CMEvents.soundStonePlace(worldIn, pos);

					switch (i) {
					case 1:
					default:
						worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3);
						break;

					case 2:
						worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3);
						break;

					case 3:
						worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3);
						break;
						
					case 4:
						worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3);
						break;
					} // switch STAGE_1_4
					return ActionResultType.SUCCESS; }
			}
			return ActionResultType.PASS;
		}
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.getValue(H_FACING);
		int i = state.getValue(STAGE_1_4);
		
		switch (i) {
		case 1:
		default:
		case 2:
			switch (direction) {
			case NORTH:
			default: return AABB_NORTH;
			case SOUTH: return AABB_SOUTH;
			case WEST: return AABB_WEST;
			case EAST: return AABB_EAST;
			}

		case 3:
		case 4:
			switch (direction) {
			case NORTH:
			default: return DOUBLE_NORTH;
			case SOUTH: return DOUBLE_SOUTH;
			case WEST: return DOUBLE_WEST;
			case EAST: return DOUBLE_EAST;
			}
		} // switch STAGE_1_4
	}
	
	/* The best harvesting tool. */
	@Nullable
	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.PICKAXE;
	}

	@Override
	public int getHarvestLevel(BlockState state) {
		return 0;
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_sama").withStyle(TextFormatting.GRAY));
	}
}
