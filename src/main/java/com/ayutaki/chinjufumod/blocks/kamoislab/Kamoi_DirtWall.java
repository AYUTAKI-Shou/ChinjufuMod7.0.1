package com.ayutaki.chinjufumod.blocks.kamoislab;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_WallPanel;
import com.ayutaki.chinjufumod.registry.KamoiPlaster_Blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class Kamoi_DirtWall extends Block {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final IntegerProperty STAGE_1_4 = IntegerProperty.create("stage", 1, 4);

	public Kamoi_DirtWall(AbstractBlock.Properties properties) {
		super(properties);
		
		/** Default state **/
		registerDefaultState(this.defaultBlockState().setValue(H_FACING, Direction.NORTH)
				.setValue(STAGE_1_4, Integer.valueOf(1)));
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		
		if (stack.isEmpty()) {
			if (playerIn.isCrouching()) {
				CMEvents.soundStonePlace(worldIn, pos);
				worldIn.setBlock(pos, state.cycle(STAGE_1_4), 3);
				return ActionResultType.SUCCESS; }
		}

		return ActionResultType.PASS;
	}
	
	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
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
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(H_FACING, STAGE_1_4);
	}

	/* Clone Item in Creative.*/
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {

		if (this == KamoiPlaster_Blocks.KAMOI_dirt_spru) { return new ItemStack(Items_WallPanel.PILLARSLAB_spru); }
		if (this == KamoiPlaster_Blocks.KAMOI_dirt_bir) { return new ItemStack(Items_WallPanel.PILLARSLAB_bir); }
		if (this == KamoiPlaster_Blocks.KAMOI_dirt_jun) { return new ItemStack(Items_WallPanel.PILLARSLAB_jun); }
		if (this == KamoiPlaster_Blocks.KAMOI_dirt_aca) { return new ItemStack(Items_WallPanel.PILLARSLAB_aca); }
		if (this == KamoiPlaster_Blocks.KAMOI_dirt_doak) { return new ItemStack(Items_WallPanel.PILLARSLAB_doak); }
		if (this == KamoiPlaster_Blocks.KAMOI_dirt_sakura) { return new ItemStack(Items_Seasonal.PILLARSLAB_saku); }
		if (this == KamoiPlaster_Blocks.KAMOI_dirt_kaede) { return new ItemStack(Items_Seasonal.PILLARSLAB_kae); }
		if (this == KamoiPlaster_Blocks.KAMOI_dirt_ichoh) { return new ItemStack(Items_Seasonal.PILLARSLAB_ich); }
		return new ItemStack(Items_WallPanel.PILLARSLAB_oak);
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
}
