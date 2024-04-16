package com.ayutaki.chinjufumod.blocks.slidedoor;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage3_FaceWater;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.fuel.ItemCurtain;
import com.ayutaki.chinjufumod.registry.Slidedoor_Blocks;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
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

public class ShoujiWindow extends BaseStage3_FaceWater {

	/* Collision */
	protected static final VoxelShape FRAME_SOUTH = Block.box(0.0D, 0.0D, 7.0D, 16.0D, 0.01D, 9.0D);
	protected static final VoxelShape FRAME_WEST = Block.box(7.0D, 0.0D, 0.0D, 9.0D, 0.01D, 16.0D);
	protected static final VoxelShape FRAME_NORTH = Block.box(0.0D, 0.0D, 7.0D, 16.0D, 0.01D, 9.0D);
	protected static final VoxelShape FRAME_EAST = Block.box(7.0D, 0.0D, 0.0D, 9.0D, 0.01D, 16.0D);
	
	protected static final VoxelShape CLOSE_SOUTH = Shapes.or(FRAME_SOUTH, Block.box(0.0D, 0.0D, 6.5D, 16.0D, 16.0D, 9.5D));
	protected static final VoxelShape CLOSE_WEST = Shapes.or(FRAME_WEST, Block.box(6.5D, 0.0D, 0.0D, 9.5D, 16.0D, 16.0D));
	protected static final VoxelShape CLOSE_NORTH = Shapes.or(FRAME_NORTH, Block.box(0.0D, 0.0D, 6.5D, 16.0D, 16.0D, 9.5D));
	protected static final VoxelShape CLOSE_EAST = Shapes.or(FRAME_EAST, Block.box(6.5D, 0.0D, 0.0D, 9.5D, 16.0D, 16.0D));

	protected static final VoxelShape OPENR_SOUTH = Shapes.or(FRAME_SOUTH, Block.box(7.5D, 0.0D, 6.5D, 16.0D, 16.0D, 9.5D));
	protected static final VoxelShape OPENR_WEST = Shapes.or(FRAME_WEST, Block.box(6.5D, 0.0D, 7.5D, 9.5D, 16.0D, 16.0D));
	protected static final VoxelShape OPENR_NORTH = Shapes.or(FRAME_NORTH, Block.box(0.0D, 0.0D, 6.5D, 8.5D, 16.0D, 9.5D));
	protected static final VoxelShape OPENR_EAST = Shapes.or(FRAME_EAST, Block.box(6.5D, 0.0D, 0.0D, 9.5D, 16.0D, 8.5D));

	protected static final VoxelShape OPENL_SOUTH = Shapes.or(FRAME_SOUTH, Block.box(0.0D, 0.0D, 6.5D, 8.5D, 16.0D, 9.5D));
	protected static final VoxelShape OPENL_WEST = Shapes.or(FRAME_WEST, Block.box(6.5D, 0.0D, 0.0D, 9.5D, 16.0D, 8.5D));
	protected static final VoxelShape OPENL_NORTH = Shapes.or(FRAME_NORTH, Block.box(7.5D, 0.0D, 6.5D, 16.0D, 16.0D, 9.5D));
	protected static final VoxelShape OPENL_EAST = Shapes.or(FRAME_EAST, Block.box(6.5D, 0.0D, 7.5D, 9.5D, 16.0D, 16.0D));

	public ShoujiWindow(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		/** 1=Close、2=Open Left、3=Open Right **/
		int i = state.getValue(STAGE_1_3);
		Direction direction = state.getValue(H_FACING);
		Direction facing = playerIn.getDirection();
		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();

		if (item instanceof ItemCurtain) { return InteractionResult.PASS; }

		else {
			switch (i) {
			case 1:
			default:
				
				switch (direction) {
				case NORTH:
				default:
					if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() < 0.5D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() < 0.5D))) {
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(i + 1)), 3); }
	
					if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() > 0.5D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() > 0.5D))) {
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(i + 2)), 3); }
					break;
	
				case SOUTH:
					if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() < 0.5D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() < 0.5D))) {
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(i + 2)), 3); }
	
					if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() > 0.5D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() > 0.5D))) {
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(i + 1)), 3); }
					break;
	
				case EAST:
					if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() < 0.5D)) || (facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() < 0.5D))) {
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(i + 1)), 3); }
	
					if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() > 0.5D)) || (facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() > 0.5D))) {
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(i + 2)), 3); }
					break;
					
				case WEST:
					if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() < 0.5D)) || (facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() < 0.5D))) {
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(i + 2)), 3); }
	
					if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() > 0.5D)) || (facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() > 0.5D))) {
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(i + 1)), 3); }
					break;
				} // direction
				break;
	
			case 2:
				CMEvents.soundFusumaS(worldIn, pos);
				worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(1)), 3);
				break;
	
			case 3:
				CMEvents.soundFusumaS(worldIn, pos);
				worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(1)), 3);
				break;
			} // STAGE_1_3
			
			return InteractionResult.SUCCESS;
		}
	}

	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		Level worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);
		Player playerIn = context.getPlayer();
		
		if (playerIn.isCrouching()) {
			Block takeBlock = this == Slidedoor_Blocks.SHOUJI_WIN.get() ? Slidedoor_Blocks.SHOUJI_WINR.get() : 
				(this == Slidedoor_Blocks.SHOUJI_WIN_SPRU.get() ? Slidedoor_Blocks.SHOUJI_WINR_SPRU.get() : 
					(this == Slidedoor_Blocks.SHOUJI_WIN_BIR.get() ? Slidedoor_Blocks.SHOUJI_WINR_BIR.get() : 
						(this == Slidedoor_Blocks.SHOUJI_WIN_JUN.get()? Slidedoor_Blocks.SHOUJI_WINR_JUN.get() : 
							(this == Slidedoor_Blocks.SHOUJI_WIN_ACA.get()? Slidedoor_Blocks.SHOUJI_WINR_ACA.get() : 
								(this == Slidedoor_Blocks.SHOUJI_WIN_DOAK.get()? Slidedoor_Blocks.SHOUJI_WINR_DOAK.get() : 
									(this == Slidedoor_Blocks.SHOUJI_WIN_SAKU.get())? Slidedoor_Blocks.SHOUJI_WINR_SAKU.get() : 
										(this == Slidedoor_Blocks.SHOUJI_WIN_KAE.get()? Slidedoor_Blocks.SHOUJI_WINR_KAE.get() : Slidedoor_Blocks.SHOUJI_WINR_ICH.get()))))));
			
			return takeBlock.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection().getOpposite())
					.setValue(STAGE_1_3, Integer.valueOf(1)).setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)); }

		return this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection().getOpposite())
				.setValue(STAGE_1_3, Integer.valueOf(1)).setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER));
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		Direction direction = state.getValue(H_FACING);
		int i = state.getValue(STAGE_1_3);

		switch (direction) {
		case NORTH:
		default:
			return (i == 1)? CLOSE_NORTH : ((i == 2)? OPENL_NORTH : OPENR_NORTH);
		case SOUTH:
			return (i == 1)? CLOSE_SOUTH : ((i == 2)? OPENL_SOUTH : OPENR_SOUTH);
		case WEST:
			return (i == 1)? CLOSE_WEST : ((i == 2)? OPENL_WEST : OPENR_WEST);
		case EAST:
			return (i == 1)? CLOSE_EAST : ((i == 2)? OPENL_EAST : OPENR_EAST);
		}
	}

	@Override
	public RenderShape getRenderShape(BlockState state) {
		return RenderShape.MODEL;
	}
	
	/* ToolTip */
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.block_shoujihalf").withStyle(ChatFormatting.GRAY));
	}
}
