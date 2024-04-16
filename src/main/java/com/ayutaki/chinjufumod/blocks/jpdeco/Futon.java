package com.ayutaki.chinjufumod.blocks.jpdeco;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage2_FaceWater;
import com.ayutaki.chinjufumod.entity.SitableEntity;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.color.Base_ItemHake;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

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

	public Futon(BlockBehaviour.Properties properties) {
		super(properties);
	}
	
	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		int i = state.getValue(STAGE_1_2);

		if (item instanceof Base_ItemHake) { return InteractionResult.PASS; }

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
					playerIn.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0));
					return SitableEntity.create(worldIn, pos, 0.0, playerIn); }
			}
			
			return InteractionResult.SUCCESS;
		}
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
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
	public RenderShape getRenderShape(BlockState state) {
		return RenderShape.MODEL;
	}
	
	/* ToolTip */
	@Override
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.block_futon").withStyle(ChatFormatting.GRAY));
	}
}
