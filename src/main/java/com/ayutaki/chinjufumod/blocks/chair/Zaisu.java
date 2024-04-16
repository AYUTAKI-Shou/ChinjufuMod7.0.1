package com.ayutaki.chinjufumod.blocks.chair;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingWater;
import com.ayutaki.chinjufumod.entity.SitableEntity;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.color.Base_ItemHake;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
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

public class Zaisu extends BaseFacingWater {

	/* Collision */
	protected static final VoxelShape BASE = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 3.0D, 15.0D);
	
	protected static final VoxelShape AABB_SOUTH = VoxelShapes.or(BASE, Block.makeCuboidShape(1.0D, 0.0D, 0.0D, 15.0D, 14.0D, 1.0D));
	protected static final VoxelShape AABB_WEST = VoxelShapes.or(BASE, Block.makeCuboidShape(15.0D, 0.0D, 1.0D, 16.0D, 14.0D, 15.0D));
	protected static final VoxelShape AABB_NORTH = VoxelShapes.or(BASE, Block.makeCuboidShape(1.0D, 0.0D, 15.0D, 15.0D, 14.0D, 16.0D));
	protected static final VoxelShape AABB_EAST = VoxelShapes.or(BASE, Block.makeCuboidShape(0.0D, 0.0D, 1.0D, 1.0D, 14.0D, 15.0D));

	public Zaisu(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();

		if (item instanceof Base_ItemHake) { return ActionResultType.PASS; }

		else {
			CMEvents.soundKinuzure(worldIn, pos);
			return SitableEntity.create(worldIn, pos, 0.0, playerIn);
		}
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(H_FACING);

		switch (direction) {
		case NORTH:
		default: return AABB_NORTH;
		case SOUTH: return AABB_SOUTH;
		case EAST: return AABB_EAST;
		case WEST: return AABB_WEST;
		} // switch
	}

	/* Can't breathe. */
	@Override
	public boolean causesSuffocation(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	/* Block is a cube. */
	@Override
	public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	/* Mobs spawn. */
	@Override
	public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type) {
		return false;
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_zaisu").applyTextStyle(TextFormatting.GRAY));
	}
}
