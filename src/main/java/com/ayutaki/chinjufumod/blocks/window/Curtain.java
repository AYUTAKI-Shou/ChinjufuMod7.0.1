package com.ayutaki.chinjufumod.blocks.window;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage4_FaceWater;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.color.Base_ItemHake;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

public class Curtain extends BaseStage4_FaceWater {

	/* Collision */
	protected static final VoxelShape CLOSE_SOUTH = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D);
	protected static final VoxelShape CLOSE_WEST = Block.makeCuboidShape(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape CLOSE_NORTH = Block.makeCuboidShape(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape CLOSE_EAST = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D);

	protected static final VoxelShape OPENR_SOUTH = Block.makeCuboidShape(14.0D, 0.0D, 0.0D, 16.0D, 16.0D, 2.1D);
	protected static final VoxelShape OPENR_WEST = Block.makeCuboidShape(13.9D, 0.0D, 14.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape OPENR_NORTH = Block.makeCuboidShape(0.0D, 0.0D, 13.9D, 2.0D, 16.0D, 16.0D);
	protected static final VoxelShape OPENR_EAST = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 2.1D, 16.0D, 2.0D);

	protected static final VoxelShape OPENL_SOUTH = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 2.0D, 16.0D, 2.1D);
	protected static final VoxelShape OPENL_WEST = Block.makeCuboidShape(13.9D, 0.0D, 0.0D, 16.0D, 16.0D, 2.0D);
	protected static final VoxelShape OPENL_NORTH = Block.makeCuboidShape(14.0D, 0.0D, 13.9D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape OPENL_EAST = Block.makeCuboidShape(0.0D, 0.0D, 14.0D, 2.1D, 16.0D, 16.0D);

	public Curtain(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {
		/** 1=Close Left、2=Open Left、3=Close Right、4=Open Right **/
		int i = state.get(STAGE_1_4);
		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();

		if (item instanceof Base_ItemHake) { return ActionResultType.PASS; }

		else {
			CMEvents.soundCurtain(worldIn, pos, 0.8F, 0.9F);
			
			if (i == 1) { worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i + 1))); }
	
			if (i == 2) { worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i - 1))); }
	
			if (i == 3) { worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i + 1))); }
	
			if (i == 4) { worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i - 1))); }
	
			return ActionResultType.SUCCESS;
		}
	}

	/* Gives a value when placed. +180 .getOpposite() */
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getWorld();
		BlockPos pos = context.getPos();
		IFluidState fluid = worldIn.getFluidState(pos);
		PlayerEntity playerIn = context.getPlayer();

		if (playerIn.isSneaking()) {
			return this.getDefaultState().with(H_FACING, context.getPlacementHorizontalFacing().getOpposite())
					.with(WATERLOGGED, fluid.getFluid() == Fluids.WATER).with(STAGE_1_4, Integer.valueOf(3)); }

		return this.getDefaultState().with(H_FACING, context.getPlacementHorizontalFacing().getOpposite())
				.with(WATERLOGGED, fluid.getFluid() == Fluids.WATER).with(STAGE_1_4, Integer.valueOf(1));
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(H_FACING);
		int i = state.get(STAGE_1_4);

		switch(direction) {
		case NORTH:
		default:
			return (i == 1)? CLOSE_NORTH : ((i == 2)? OPENL_NORTH : ((i == 3)? CLOSE_NORTH : OPENR_NORTH));
		case SOUTH:
			return (i == 1)? CLOSE_SOUTH : ((i == 2)? OPENL_SOUTH : ((i == 3)? CLOSE_SOUTH : OPENR_SOUTH));
		case WEST:
			return (i == 1)? CLOSE_WEST : ((i == 2)? OPENL_WEST : ((i == 3)? CLOSE_WEST : OPENR_WEST));
		case EAST:
			return (i == 1)? CLOSE_EAST : ((i == 2)? OPENL_EAST : ((i == 3)? CLOSE_EAST : OPENR_EAST));
		}
	}

	@Override
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.MODEL;
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
		tooltip.add(new TranslationTextComponent("tips.block_window").applyTextStyle(TextFormatting.GRAY));
	}
}
