package com.ayutaki.chinjufumod.blocks.window;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage3_FaceWater;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.items.fuel.ItemCurtain;
import com.ayutaki.chinjufumod.registry.Window_Blocks;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WindowTall_Bot extends BaseStage3_FaceWater {

	/* Collision */
	protected static final VoxelShape FRAME_SOUTH = Block.box(0.0D, 0.0D, 7.0D, 16.0D, 0.01D, 9.0D);
	protected static final VoxelShape FRAME_WEST = Block.box(7.0D, 0.0D, 0.0D, 9.0D, 0.01D, 16.0D);
	protected static final VoxelShape FRAME_NORTH = Block.box(0.0D, 0.0D, 7.0D, 16.0D, 0.01D, 9.0D);
	protected static final VoxelShape FRAME_EAST = Block.box(7.0D, 0.0D, 0.0D, 9.0D, 0.01D, 16.0D);
	
	protected static final VoxelShape CLOSE_SOUTH = Shapes.or(FRAME_SOUTH, Block.box(0.0D, 0.0D, 8.0D, 16.0D, 17.0D, 9.5D));
	protected static final VoxelShape CLOSE_WEST = Shapes.or(FRAME_WEST, Block.box(6.5D, 0.0D, 0.0D, 8.0D, 17.0D, 16.0D));
	protected static final VoxelShape CLOSE_NORTH = Shapes.or(FRAME_NORTH, Block.box(0.0D, 0.0D, 6.5D, 16.0D, 17.0D, 8.0D));
	protected static final VoxelShape CLOSE_EAST = Shapes.or(FRAME_EAST, Block.box(8.0D, 0.0D, 0.0D, 9.5D, 17.0D, 16.0D));

	protected static final VoxelShape OPEN2_SOUTH = Shapes.or(FRAME_SOUTH, Block.box(0.0D, 8.0D, 8.0D, 16.0D, 25.0D, 9.5D));
	protected static final VoxelShape OPEN2_WEST = Shapes.or(FRAME_WEST, Block.box(6.5D, 8.0D, 0.0D, 8.0D, 25.0D, 16.0D));
	protected static final VoxelShape OPEN2_NORTH = Shapes.or(FRAME_NORTH, Block.box(0.0D, 8.0D, 6.5D, 16.0D, 25.0D, 8.0D));
	protected static final VoxelShape OPEN2_EAST = Shapes.or(FRAME_EAST, Block.box(8.0D, 8.0D, 0.0D, 9.5D, 25.0D, 16.0D));

	protected static final VoxelShape OPEN3_SOUTH = Shapes.or(FRAME_SOUTH, Block.box(0.0D, 14.0D, 8.0D, 16.0D, 31.0D, 9.5D));
	protected static final VoxelShape OPEN3_WEST = Shapes.or(FRAME_WEST, Block.box(6.5D, 14.0D, 0.0D, 8.0D, 31.0D, 16.0D));
	protected static final VoxelShape OPEN3_NORTH = Shapes.or(FRAME_NORTH, Block.box(0.0D, 14.0D, 6.5D, 16.0D, 31.0D, 8.0D));
	protected static final VoxelShape OPEN3_EAST = Shapes.or(FRAME_EAST, Block.box(8.0D, 14.0D, 0.0D, 9.5D, 31.0D, 16.0D));
	
	public WindowTall_Bot(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();

		if (item instanceof ItemCurtain) { return InteractionResult.PASS; }

		else {
			if (hit.getLocation().y - (double)pos.getY() < 0.96875D) {
				worldIn.playSound(null, pos, SoundEvents_CM.WINDOW_UD.get(), SoundSource.BLOCKS, 1.0F, 1.0F);
				worldIn.setBlock(pos, state.cycle(STAGE_1_3), 3); }
			
			return InteractionResult.SUCCESS;
		}
	}
	
	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		Level worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);

		/** pos.up() = Replaceable block. **/
		if (pos.getY() < worldIn.getMaxBuildHeight() - 1 && worldIn.getBlockState(pos.above()).canBeReplaced(context)) {
			return this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection().getOpposite())
					.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER));
		}

		else { return null; }
	}
	
	/* Add DoubleBlockHalf.UPPER on the Block. */
	public void setPlacedBy(Level worldIn, BlockPos pos, BlockState state, LivingEntity entityIn, ItemStack stack) {
		FluidState fluidUp = worldIn.getFluidState(pos.above());
		
		worldIn.setBlock(pos.above(), this.takeBlock().defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
				.setValue(WATERLOGGED, Boolean.valueOf(fluidUp.getType() == Fluids.WATER))
				.setValue(STAGE_1_3, Integer.valueOf(1)), 3);
	}
	
	private Block takeBlock() {
		if (this == Window_Blocks.WINDOWTALLBOT_oak.get()) { return Window_Blocks.WINDOWTALLTOP_oak.get(); }
		if (this == Window_Blocks.WINDOWTALLBOT_spruce.get()) { return Window_Blocks.WINDOWTALLTOP_spruce.get(); }
		if (this == Window_Blocks.WINDOWTALLBOT_birch.get()) { return Window_Blocks.WINDOWTALLTOP_birch.get(); }
		if (this == Window_Blocks.WINDOWTALLBOT_jungle.get()) { return Window_Blocks.WINDOWTALLTOP_jungle.get(); }
		if (this == Window_Blocks.WINDOWTALLBOT_acacia.get()) { return Window_Blocks.WINDOWTALLTOP_acacia.get(); }
		if (this == Window_Blocks.WINDOWTALLBOT_darkoak.get()) { return Window_Blocks.WINDOWTALLTOP_darkoak.get(); }
		if (this == Window_Blocks.WINDOWTALLBOT_sakura.get()) { return Window_Blocks.WINDOWTALLTOP_sakura.get(); }
		if (this == Window_Blocks.WINDOWTALLBOT_kaede.get()) { return Window_Blocks.WINDOWTALLTOP_kaede.get(); }
		if (this == Window_Blocks.WINDOWTALLBOT_ichoh.get()) { return Window_Blocks.WINDOWTALLTOP_ichoh.get(); }
		return null;
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		Direction direction = state.getValue(H_FACING);
		int i = state.getValue(STAGE_1_3);

		switch (direction) {
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
	public RenderShape getRenderShape(BlockState state) {
		return RenderShape.MODEL;
	}
	
	/* Destroy a DoubleBlock from DoublePlantBlock.class */
	@Override
	public void playerWillDestroy(Level worldIn, BlockPos pos, BlockState state, Player playerIn) {
		BlockState upState = worldIn.getBlockState(pos.above());

		if (upState.getBlock() instanceof WindowTall_Top) {
			worldIn.destroyBlock(pos.above(), false);
		}
		super.playerWillDestroy(worldIn, pos, state, playerIn);
	}
	
	/* ToolTip */
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.block_windowb").withStyle(ChatFormatting.GRAY));
	}
}
