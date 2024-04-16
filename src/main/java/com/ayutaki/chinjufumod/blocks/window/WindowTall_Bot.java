package com.ayutaki.chinjufumod.blocks.window;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.Config_CM;
import com.ayutaki.chinjufumod.blocks.base.BaseStage3_FaceWater;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.items.fuel.ItemCurtain;
import com.ayutaki.chinjufumod.registry.Window_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
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

public class WindowTall_Bot extends BaseStage3_FaceWater {

	/* Collision */
	protected static final VoxelShape FRAME_SOUTH = Block.makeCuboidShape(0.0D, 0.0D, 7.0D, 16.0D, 0.01D, 9.0D);
	protected static final VoxelShape FRAME_WEST = Block.makeCuboidShape(7.0D, 0.0D, 0.0D, 9.0D, 0.01D, 16.0D);
	protected static final VoxelShape FRAME_NORTH = Block.makeCuboidShape(0.0D, 0.0D, 7.0D, 16.0D, 0.01D, 9.0D);
	protected static final VoxelShape FRAME_EAST = Block.makeCuboidShape(7.0D, 0.0D, 0.0D, 9.0D, 0.01D, 16.0D);
	
	protected static final VoxelShape CLOSE_SOUTH = VoxelShapes.or(FRAME_SOUTH, Block.makeCuboidShape(0.0D, 0.0D, 8.0D, 16.0D, 17.0D, 9.5D));
	protected static final VoxelShape CLOSE_WEST = VoxelShapes.or(FRAME_WEST, Block.makeCuboidShape(6.5D, 0.0D, 0.0D, 8.0D, 17.0D, 16.0D));
	protected static final VoxelShape CLOSE_NORTH = VoxelShapes.or(FRAME_NORTH, Block.makeCuboidShape(0.0D, 0.0D, 6.5D, 16.0D, 17.0D, 8.0D));
	protected static final VoxelShape CLOSE_EAST = VoxelShapes.or(FRAME_EAST, Block.makeCuboidShape(8.0D, 0.0D, 0.0D, 9.5D, 17.0D, 16.0D));

	protected static final VoxelShape OPEN2_SOUTH = VoxelShapes.or(FRAME_SOUTH, Block.makeCuboidShape(0.0D, 8.0D, 8.0D, 16.0D, 25.0D, 9.5D));
	protected static final VoxelShape OPEN2_WEST = VoxelShapes.or(FRAME_WEST, Block.makeCuboidShape(6.5D, 8.0D, 0.0D, 8.0D, 25.0D, 16.0D));
	protected static final VoxelShape OPEN2_NORTH = VoxelShapes.or(FRAME_NORTH, Block.makeCuboidShape(0.0D, 8.0D, 6.5D, 16.0D, 25.0D, 8.0D));
	protected static final VoxelShape OPEN2_EAST = VoxelShapes.or(FRAME_EAST, Block.makeCuboidShape(8.0D, 8.0D, 0.0D, 9.5D, 25.0D, 16.0D));

	protected static final VoxelShape OPEN3_SOUTH = VoxelShapes.or(FRAME_SOUTH, Block.makeCuboidShape(0.0D, 14.0D, 8.0D, 16.0D, 31.0D, 9.5D));
	protected static final VoxelShape OPEN3_WEST = VoxelShapes.or(FRAME_WEST, Block.makeCuboidShape(6.5D, 14.0D, 0.0D, 8.0D, 31.0D, 16.0D));
	protected static final VoxelShape OPEN3_NORTH = VoxelShapes.or(FRAME_NORTH, Block.makeCuboidShape(0.0D, 14.0D, 6.5D, 16.0D, 31.0D, 8.0D));
	protected static final VoxelShape OPEN3_EAST = VoxelShapes.or(FRAME_EAST, Block.makeCuboidShape(8.0D, 14.0D, 0.0D, 9.5D, 31.0D, 16.0D));

	public WindowTall_Bot(Block.Properties properties) {
		super(properties);
	}

	/* Anti Shadow */
	public int getLightValue(BlockState state) {
		int i = state.get(STAGE_1_3);
		return (i == 3 && Config_CM.getInstance().antiShadow() == true)? 1 : 0;
	}

	/* RightClick Action */
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {
		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();

		if (item instanceof ItemCurtain) { return ActionResultType.PASS; }

		else {
			if (hit.getHitVec().y - (double)pos.getY() < 0.96875D) {
				worldIn.playSound(null, pos, SoundEvents_CM.WINDOW_UD, SoundCategory.BLOCKS, 1.0F, 1.0F);
				worldIn.setBlockState(pos, state.cycle(STAGE_1_3)); }
			
			return ActionResultType.SUCCESS;
		}
	}
	
	/* Gives a value when placed. */
	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getWorld();
		BlockPos pos = context.getPos();
		IFluidState fluid = worldIn.getFluidState(pos);

		/** pos.up() = Replaceable block. **/
		if (pos.getY() < 255 && worldIn.getBlockState(pos.up()).isReplaceable(context)) {
			return this.getDefaultState().with(H_FACING, context.getPlacementHorizontalFacing().getOpposite())
					.with(WATERLOGGED, fluid.getFluid() == Fluids.WATER); }

		else { return null; }
	}

	/* Add DoubleBlockHalf.UPPER on the Block. */
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		IFluidState fluidUp = worldIn.getFluidState(pos.up());
		
		worldIn.setBlockState(pos.up(), this.takeBlock().getDefaultState().with(H_FACING, state.get(H_FACING))
				.with(WATERLOGGED, fluidUp.getFluid() == Fluids.WATER).with(STAGE_1_3, Integer.valueOf(1)));
	}
	
	private Block takeBlock() {
		if (this == Window_Blocks.WINDOWTALLBOT_oak) { return Window_Blocks.WINDOWTALLTOP_oak; }
		if (this == Window_Blocks.WINDOWTALLBOT_spruce) { return Window_Blocks.WINDOWTALLTOP_spruce; }
		if (this == Window_Blocks.WINDOWTALLBOT_birch) { return Window_Blocks.WINDOWTALLTOP_birch; }
		if (this == Window_Blocks.WINDOWTALLBOT_jungle) { return Window_Blocks.WINDOWTALLTOP_jungle; }
		if (this == Window_Blocks.WINDOWTALLBOT_acacia) { return Window_Blocks.WINDOWTALLTOP_acacia; }
		if (this == Window_Blocks.WINDOWTALLBOT_darkoak) { return Window_Blocks.WINDOWTALLTOP_darkoak; }
		if (this == Window_Blocks.WINDOWTALLBOT_sakura) { return Window_Blocks.WINDOWTALLTOP_sakura; }
		if (this == Window_Blocks.WINDOWTALLBOT_kaede) { return Window_Blocks.WINDOWTALLTOP_kaede; }
		if (this == Window_Blocks.WINDOWTALLBOT_ichoh) { return Window_Blocks.WINDOWTALLTOP_ichoh; }
		return null;
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(H_FACING);
		int i = state.get(STAGE_1_3);

		switch(direction) {
		case NORTH:
		default:
			return (i == 1)? CLOSE_NORTH : ((i == 2)? OPEN2_NORTH : OPEN3_NORTH);
		case SOUTH:
			return (i == 1)? CLOSE_SOUTH : ((i == 2)? OPEN2_SOUTH : OPEN3_SOUTH);
		case WEST:
			return (i == 1)? CLOSE_WEST : ((i == 2)? OPEN2_WEST : OPEN3_WEST);
		case EAST:
			return (i == 1)? CLOSE_EAST : ((i == 2)? OPEN2_EAST : OPEN3_EAST);
		}
	}

	@Override
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.MODEL;
	}

	/* Destroy at the same time. & Drop item. */
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {

		BlockState upState = worldIn.getBlockState(pos.up());

		if (upState.getBlock() instanceof WindowTall_Top) {
			worldIn.destroyBlock(pos.up(), false);
		}
		super.onBlockHarvested(worldIn, pos, state, playerIn);
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

	public boolean isOpaqueCube(IBlockReader worldIn, BlockPos pos) {
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
		tooltip.add(new TranslationTextComponent("tips.block_windowb").applyTextStyle(TextFormatting.GRAY));
	}
}
