package com.ayutaki.chinjufumod.blocks.kamoislab;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_WallPanel;
import com.ayutaki.chinjufumod.registry.KamoiPlaster_Blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

public class Kamoi_DirtWall extends Block {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final IntegerProperty STAGE_1_4 = IntegerProperty.create("stage", 1, 4);

	public Kamoi_DirtWall(BlockBehaviour.Properties properties) {
		super(properties);
		/** Default state **/
		registerDefaultState(this.stateDefinition.any().setValue(H_FACING, Direction.NORTH)
				.setValue(STAGE_1_4, Integer.valueOf(1)));
	}
	
	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);

		if (stack.isEmpty()) {
			if (playerIn.isCrouching()) {
				CMEvents.soundStonePlace(worldIn, pos);
				worldIn.setBlock(pos, state.cycle(STAGE_1_4), 3);
				return InteractionResult.SUCCESS; }
			
			if (!playerIn.isCrouching()) {
				CMEvents.textNotSneak(worldIn, pos, playerIn);
				return InteractionResult.SUCCESS; }
		}

		return InteractionResult.PASS;
	}
	
	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection().getOpposite());
	}
	
	/* HORIZONTAL Property */
	@Override
	public BlockState rotate(BlockState state, Rotation rotation) {
		return state.setValue(H_FACING, rotation.rotate(state.getValue(H_FACING)));
	}

	@SuppressWarnings("deprecation")
	public BlockState mirror(BlockState state, Mirror mirror) {
		return state.rotate(mirror.getRotation(state.getValue(H_FACING)));
	}
	
	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(H_FACING, STAGE_1_4);
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		if (this == KamoiPlaster_Blocks.KAMOI_dirt_spru.get()) { return new ItemStack(Items_WallPanel.PILLARSLAB_spru.get()); }
		if (this == KamoiPlaster_Blocks.KAMOI_dirt_bir.get()) { return new ItemStack(Items_WallPanel.PILLARSLAB_bir.get()); }
		if (this == KamoiPlaster_Blocks.KAMOI_dirt_jun.get()) { return new ItemStack(Items_WallPanel.PILLARSLAB_jun.get()); }
		if (this == KamoiPlaster_Blocks.KAMOI_dirt_aca.get()) { return new ItemStack(Items_WallPanel.PILLARSLAB_aca.get()); }
		if (this == KamoiPlaster_Blocks.KAMOI_dirt_doak.get()) { return new ItemStack(Items_WallPanel.PILLARSLAB_doak.get()); }
		if (this == KamoiPlaster_Blocks.KAMOI_dirt_sakura.get()) { return new ItemStack(Items_Seasonal.PILLARSLAB_saku.get()); }
		if (this == KamoiPlaster_Blocks.KAMOI_dirt_kaede.get()) { return new ItemStack(Items_Seasonal.PILLARSLAB_kae.get()); }
		if (this == KamoiPlaster_Blocks.KAMOI_dirt_ichoh.get()) { return new ItemStack(Items_Seasonal.PILLARSLAB_ich.get()); }
		return new ItemStack(Items_WallPanel.PILLARSLAB_oak.get());
	}
}
