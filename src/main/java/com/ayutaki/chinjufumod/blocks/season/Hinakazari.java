package com.ayutaki.chinjufumod.blocks.season;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage4_FaceWater;
import com.ayutaki.chinjufumod.handler.CMEvents;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Hinakazari extends BaseStage4_FaceWater {

	/* Collision */
	protected static final VoxelShape S1_SOUTH = Block.box(0.0D, 0.1D, 0.0D, 12.0D, 16.0D, 16.0D);
	protected static final VoxelShape S1_WEST = Block.box(0.0D, 0.1D, 0.0D, 16.0D, 16.0D, 12.0D);
	protected static final VoxelShape S1_NORTH = Block.box(4.0D, 0.1D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape S1_EAST = Block.box(0.0D, 0.1D, 4.0D, 16.0D, 16.0D, 16.0D);

	protected static final VoxelShape S2_SOUTH = Block.box(0.0D, 0.1D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape S2_WEST = Block.box(0.0D, 0.1D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape S2_NORTH = Block.box(0.0D, 0.1D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape S2_EAST = Block.box(0.0D, 0.1D, 0.0D, 16.0D, 16.0D, 16.0D);

	protected static final VoxelShape S3_SOUTH = Block.box(0.0D, 0.1D, 0.0D, 12.0D, 12.0D, 16.0D);
	protected static final VoxelShape S3_WEST = Block.box(0.0D, 0.1D, 0.0D, 16.0D, 12.0D, 12.0D);
	protected static final VoxelShape S3_NORTH = Block.box(4.0D, 0.1D, 0.0D, 16.0D, 12.0D, 16.0D);
	protected static final VoxelShape S3_EAST = Block.box(0.0D, 0.1D, 4.0D, 16.0D, 12.0D, 16.0D);

	protected static final VoxelShape S4_SOUTH = Block.box(0.0D, 0.1D, 0.0D, 16.0D, 12.0D, 16.0D);
	protected static final VoxelShape S4_WEST = Block.box(0.0D, 0.1D, 0.0D, 16.0D, 12.0D, 16.0D);
	protected static final VoxelShape S4_NORTH = Block.box(0.0D, 0.1D, 0.0D, 16.0D, 12.0D, 16.0D);
	protected static final VoxelShape S4_EAST = Block.box(0.0D, 0.1D, 0.0D, 16.0D, 12.0D, 16.0D);
	
	public Hinakazari(BlockBehaviour.Properties properties) {
		super(properties);
	}
	
	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		
		if (stack.isEmpty()) {
			if (playerIn.isCrouching()) {
				CMEvents.soundWoodPlace(worldIn, pos);
				worldIn.setBlock(pos, state.cycle(STAGE_1_4), 3);
				return InteractionResult.SUCCESS; }
			
			if (!playerIn.isCrouching()) {
				CMEvents.textNotSneak(worldIn, pos, playerIn);
				return InteractionResult.SUCCESS; }
		}

			return InteractionResult.SUCCESS;
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		int i = state.getValue(STAGE_1_4);
		Direction direction = state.getValue(H_FACING);

		switch (direction) {
		case NORTH:
		default:
			return (i == 1)? S1_NORTH : ((i == 2)? S2_NORTH : ((i == 3)? S3_NORTH : S4_NORTH));
		case SOUTH:
			return (i == 1)? S1_SOUTH : ((i == 2)? S2_SOUTH : ((i == 3)? S3_SOUTH : S4_SOUTH));
		case WEST:
			return (i == 1)? S1_WEST : ((i == 2)? S2_WEST : ((i == 3)? S3_WEST : S4_WEST));
		case EAST:
			return (i == 1)? S1_EAST : ((i == 2)? S2_EAST : ((i == 3)? S3_EAST : S4_EAST));
		}
	}
	
	/* ToolTip */
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.block_hinakazari").withStyle(ChatFormatting.GRAY));
	}
}
