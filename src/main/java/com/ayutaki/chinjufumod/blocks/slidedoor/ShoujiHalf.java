package com.ayutaki.chinjufumod.blocks.slidedoor;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage4_FaceWater;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.fuel.ItemCurtain;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
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
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

public class ShoujiHalf extends BaseStage4_FaceWater {

	/* Collision */
	protected static final VoxelShape FRAME_SOUTH = Block.box(0.0D, 0.0D, 7.0D, 16.0D, 0.01D, 9.0D);
	protected static final VoxelShape FRAME_WEST = Block.box(7.0D, 0.0D, 0.0D, 9.0D, 0.01D, 16.0D);
	protected static final VoxelShape FRAME_NORTH = Block.box(0.0D, 0.0D, 7.0D, 16.0D, 0.01D, 9.0D);
	protected static final VoxelShape FRAME_EAST = Block.box(7.0D, 0.0D, 0.0D, 9.0D, 0.01D, 16.0D);
	
	protected static final VoxelShape CLOSE1_SOUTH = VoxelShapes.or(FRAME_SOUTH, Block.box(0.0D, 0.0D, 8.0D, 16.0D, 16.0D, 9.5D));
	protected static final VoxelShape CLOSE1_WEST = VoxelShapes.or(FRAME_WEST, Block.box(6.5D, 0.0D, 0.0D, 8.0D, 16.0D, 16.0D));
	protected static final VoxelShape CLOSE1_NORTH = VoxelShapes.or(FRAME_NORTH, Block.box(0.0D, 0.0D, 6.5D, 16.0D, 16.0D, 8.0D));
	protected static final VoxelShape CLOSE1_EAST = VoxelShapes.or(FRAME_EAST, Block.box(8.0D, 0.0D, 0.0D, 9.5D, 16.0D, 16.0D));

	protected static final VoxelShape OPEN2_SOUTH = VoxelShapes.or(FRAME_SOUTH, Block.box(-14.0D, 0.0D, 8.0D, 2.0D, 16.0D, 9.5D));
	protected static final VoxelShape OPEN2_WEST = VoxelShapes.or(FRAME_WEST, Block.box(6.5D, 0.0D, -14.0D, 8.0D, 16.0D, 2.0D));
	protected static final VoxelShape OPEN2_NORTH = VoxelShapes.or(FRAME_NORTH, Block.box(14.0D, 0.0D, 6.5D, 30.0D, 16.0D, 8.0D));
	protected static final VoxelShape OPEN2_EAST = VoxelShapes.or(FRAME_EAST, Block.box(8.0D, 0.0D, 14.0D, 9.5D, 16.0D, 30.0D));

	protected static final VoxelShape CLOSE3_SOUTH = VoxelShapes.or(FRAME_SOUTH, Block.box(0.0D, 0.0D, 6.5D, 16.0D, 16.0D, 8.0D));
	protected static final VoxelShape CLOSE3_WEST = VoxelShapes.or(FRAME_WEST, Block.box(8.0D, 0.0D, 0.0D, 9.5D, 16.0D, 16.0D));
	protected static final VoxelShape CLOSE3_NORTH = VoxelShapes.or(FRAME_NORTH, Block.box(0.0D, 0.0D, 8.0D, 16.0D, 16.0D, 9.5D));
	protected static final VoxelShape CLOSE3_EAST = VoxelShapes.or(FRAME_EAST, Block.box(6.5D, 0.0D, 0.0D, 8.0D, 16.0D, 16.0D));

	protected static final VoxelShape OPEN4_SOUTH = VoxelShapes.or(FRAME_SOUTH, Block.box(14.0D, 0.0D, 6.5D, 30.0D, 16.0D, 8.0D));
	protected static final VoxelShape OPEN4_WEST = VoxelShapes.or(FRAME_WEST, Block.box(8.0D, 0.0D, 14.0D, 9.5D, 16.0D, 30.0D));
	protected static final VoxelShape OPEN4_NORTH = VoxelShapes.or(FRAME_NORTH, Block.box(-14.0D, 0.0D, 8.0D, 2.0D, 16.0D, 9.5D));
	protected static final VoxelShape OPEN4_EAST = VoxelShapes.or(FRAME_EAST, Block.box(6.5D, 0.0D, -14.0D, 8.0D, 16.0D, 2.0D));


	public ShoujiHalf(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {
		/** 1=Close、2=Open、3=Close、4=Open **/
		int i = state.getValue(STAGE_1_4);
		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();

		if (item instanceof ItemCurtain) { return ActionResultType.PASS; }

		else {
			if (i == 1 || i == 3) {
				CMEvents.soundFusumaS(worldIn, pos);
				worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
	
			if (i == 2 || i == 4) {
				CMEvents.soundFusumaS(worldIn, pos);
				worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3); }
	
			return ActionResultType.SUCCESS;
		}
	}

	/* Gives a value when placed. */
	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);
		PlayerEntity playerIn = context.getPlayer();

		if (playerIn.isCrouching()) {
			return this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection().getOpposite())
					.setValue(STAGE_1_4, Integer.valueOf(3)).setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)); }

		return this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection().getOpposite())
				.setValue(STAGE_1_4, Integer.valueOf(1)).setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER));
	}


	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.getValue(H_FACING);
		int i = state.getValue(STAGE_1_4);

		switch (direction) {
		case NORTH:
		default:
			return (i == 1)? CLOSE1_NORTH : ((i == 2)? OPEN2_NORTH : ((i == 3)? CLOSE3_NORTH : OPEN4_NORTH));
		case SOUTH:
			return (i == 1)? CLOSE1_SOUTH : ((i == 2)? OPEN2_SOUTH : ((i == 3)? CLOSE3_SOUTH : OPEN4_SOUTH));
		case WEST:
			return (i == 1)? CLOSE1_WEST : ((i == 2)? OPEN2_WEST : ((i == 3)? CLOSE3_WEST : OPEN4_WEST));
		case EAST:
			return (i == 1)? CLOSE1_EAST : ((i == 2)? OPEN2_EAST : ((i == 3)? CLOSE3_EAST : OPEN4_EAST));
		}
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
		tooltip.add(new TranslationTextComponent("tips.block_shoujihalf").withStyle(TextFormatting.GRAY));
	}
}
