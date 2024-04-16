package com.ayutaki.chinjufumod.blocks.unitblock;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
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
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Kotatsu extends BaseUnitBlock {

	/* Collision */
	protected static final VoxelShape TTTT = Block.box(0.0D, 6.0D, 0.0D, 16.0D, 8.0D, 16.0D);

	protected static final VoxelShape FFFF = Shapes.or(Block.box(2.0D, 6.0D, 2.0D, 14.0D, 8.0D, 14.0D),
			Block.box(3.0D, 0.0D, 3.0D, 4.5D, 6.0D, 4.5D),
			Block.box(3.0D, 0.0D, 11.5D, 4.5D, 6.0D, 13.0D),
			Block.box(11.5D, 0.0D, 3.0D, 13.0D, 6.0D, 4.5D),
			Block.box(11.5D, 0.0D, 11.5D, 13.0D, 6.0D, 13.0D));

	protected static final VoxelShape TTFF = Shapes.or(Block.box(1.0D, 6.0D, 0.0D, 16.0D, 8.0D, 15.0D),
			Block.box(3.0D, 0.0D, 10.5D, 5.5D, 6.0D, 13.0D));
	protected static final VoxelShape FTFT = Shapes.or(Block.box(0.0D, 6.0D, 0.0D, 15.0D, 8.0D, 15.0D),
			Block.box(10.5D, 0.0D, 10.5D, 13.0D, 6.0D, 13.0D));
	protected static final VoxelShape TFTF = Shapes.or(Block.box(1.0D, 6.0D, 1.0D, 16.0D, 8.0D, 16.0D),
			Block.box(3.0D, 0.0D, 3.0D, 5.5D, 6.0D, 5.5D));
	protected static final VoxelShape FFTT = Shapes.or(Block.box(0.0D, 6.0D, 1.0D, 15.0D, 8.0D, 16.0D),
			Block.box(10.5D, 0.0D, 3.0D, 13.0D, 6.0D, 5.5D));

	protected static final VoxelShape FTTT = Shapes.or(Block.box(0.0D, 6.0D, 0.0D, 15.0D, 8.0D, 16.0D));
	protected static final VoxelShape TTTF = Shapes.or(Block.box(1.0D, 6.0D, 0.0D, 16.0D, 8.0D, 16.0D));
	protected static final VoxelShape TTFT = Shapes.or(Block.box(0.0D, 6.0D, 0.0D, 16.0D, 8.0D, 15.0D));
	protected static final VoxelShape TFTT = Shapes.or(Block.box(0.0D, 6.0D, 1.0D, 16.0D, 8.0D, 16.0D));
	
	public Kotatsu(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		
		/** Hand is empty. **/
		if (stack.isEmpty()) {
			if (playerIn.isCrouching()) {
				CMEvents.soundWoodPlace(worldIn, pos);
				worldIn.setBlock(pos, state.cycle(WHICH), 3);
				return InteractionResult.SUCCESS; }
			
			if (!playerIn.isCrouching()) {
				CMEvents.textNotSneak(worldIn, pos, playerIn);
				return InteractionResult.SUCCESS; }
		}
		
		return InteractionResult.PASS;
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		boolean east = state.getValue(EAST).booleanValue();
		boolean north = state.getValue(NORTH).booleanValue();
		boolean south = state.getValue(SOUTH).booleanValue();
		boolean west = state.getValue(WEST).booleanValue();

		if (east == true && north == true && south == false && west == false) { return TTFF; }
		if (east == false && north == true && south == false && west == true) { return FTFT; }
		if (east == true && north == false && south == true && west == false) { return TFTF; }
		if (east == false && north == false && south == true && west == true) { return FFTT; }

		if (east == false && north == true && south == true && west == true) { return FTTT; }
		if (east == true && north == true && south == true && west == false) { return TTTF; }
		if (east == true && north == true && south == false && west == true) { return TTFT; }
		if (east == true && north == false && south == true && west == true) { return TFTT; }

		if (east == true && north == true && south == true && west == true) { return TTTT; }

		return FFFF;
	}

	/* ToolTip */
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.block_kotatsu").withStyle(ChatFormatting.GRAY));
	}
}
