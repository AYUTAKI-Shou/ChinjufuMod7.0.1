package com.ayutaki.chinjufumod.blocks.jpdeco;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage2_FaceWater;
import com.ayutaki.chinjufumod.entity.SitableEntity;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.color.Base_ItemHake;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

public class Futon extends BaseStage2_FaceWater {

	/* Collision */
	protected static final VoxelShape S1_SOUTH = Block.box(0.0D, 0.0D, 5.5D, 16.0D, 11.0D, 16.0D);
	protected static final VoxelShape S1_WEST = Block.box(0.0D, 0.0D, 0.0D, 10.5D, 11.0D, 16.0D);
	protected static final VoxelShape S1_NORTH = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 11.0D, 10.5D);
	protected static final VoxelShape S1_EAST = Block.box(5.5D, 0.0D, 0.0D, 16.0D, 11.0D, 16.0D);

	protected static final VoxelShape S2_SOUTH = Block.box(0.0D, 0.0D, -16.0D, 16.0D, 3.6D, 16.0D);
	protected static final VoxelShape S2_WEST = Block.box(0.0D, 0.0D, 0.0D, 32.0D, 3.6D, 16.0D);
	protected static final VoxelShape S2_NORTH = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 3.6D, 32.0D);
	protected static final VoxelShape S2_EAST = Block.box(-16.0D, 0.0D, 0.0D, 16.0D, 3.6D, 16.0D);


	public Futon(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		int i = state.getValue(STAGE_1_2);

		if (item instanceof Base_ItemHake) { return ActionResultType.PASS; }

		else {
			if (i == 1) {
				if (playerIn.isCrouching()) {
					CMEvents.soundKinuzure(worldIn, pos);
					worldIn.setBlock(pos, state.setValue(STAGE_1_2, Integer.valueOf(2)), 3); }
				
				if (!playerIn.isCrouching()) { CMEvents.textNotSneak(worldIn, pos, playerIn); }
			}
			
			if (i == 2) {
				if (playerIn.isCrouching()) {
					CMEvents.soundKinuzure(worldIn, pos);
					worldIn.setBlock(pos, state.setValue(STAGE_1_2, Integer.valueOf(1)), 3); }
	
				if (!playerIn.isCrouching()) {
					CMEvents.soundKinuzure(worldIn, pos);
					playerIn.addEffect(new EffectInstance(Effects.REGENERATION, 200, 0));
					return SitableEntity.create(worldIn, pos, 0.0, playerIn); }
			}
			
			return ActionResultType.SUCCESS;
		}
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

		int i = state.getValue(STAGE_1_2);
		Direction direction = state.getValue(H_FACING);

		switch (direction) {
		case NORTH:
		default:
			return (i == 1)? S1_NORTH : S2_NORTH;
		case SOUTH:
			return (i == 1)? S1_SOUTH : S2_SOUTH;
		case WEST:
			return (i == 1)? S1_WEST : S2_WEST;
		case EAST:
			return (i == 1)? S1_EAST : S2_EAST;
		}
	}

	@Override
	public BlockRenderType getRenderShape(BlockState state) {
		return BlockRenderType.MODEL;
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
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_futon").withStyle(TextFormatting.GRAY));
	}
}
