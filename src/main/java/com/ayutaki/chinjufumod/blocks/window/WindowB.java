package com.ayutaki.chinjufumod.blocks.window;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage4_FaceWater;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.fuel.ItemCurtain;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
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

public class WindowB extends BaseStage4_FaceWater {

	/* Collision */
	protected static final VoxelShape FRAME_SOUTH = Block.makeCuboidShape(0.0D, 0.0D, 7.0D, 16.0D, 0.01D, 9.0D);
	protected static final VoxelShape FRAME_WEST = Block.makeCuboidShape(7.0D, 0.0D, 0.0D, 9.0D, 0.01D, 16.0D);
	protected static final VoxelShape FRAME_NORTH = Block.makeCuboidShape(0.0D, 0.0D, 7.0D, 16.0D, 0.01D, 9.0D);
	protected static final VoxelShape FRAME_EAST = Block.makeCuboidShape(7.0D, 0.0D, 0.0D, 9.0D, 0.01D, 16.0D);

	protected static final VoxelShape CLOSE_SOUTH = VoxelShapes.or(FRAME_SOUTH, Block.makeCuboidShape(0.0D, 0.0D, 7.25D, 16.0D, 16.0D, 8.75D));
	protected static final VoxelShape CLOSE_WEST = VoxelShapes.or(FRAME_WEST, Block.makeCuboidShape(7.25D, 0.0D, 0.0D, 8.75D, 16.0D, 16.0D));
	protected static final VoxelShape CLOSE_NORTH = VoxelShapes.or(FRAME_NORTH, Block.makeCuboidShape(0.0D, 0.0D, 7.25D, 16.0D, 16.0D, 8.75D));
	protected static final VoxelShape CLOSE_EAST = VoxelShapes.or(FRAME_EAST, Block.makeCuboidShape(7.25D, 0.0D, 0.0D, 8.75D, 16.0D, 16.0D));

	protected static final VoxelShape OPENR_SOUTH = VoxelShapes.or(FRAME_SOUTH, Block.makeCuboidShape(8.0D, 0.0D, 7.25D, 16.0D, 16.0D, 8.75D));
	protected static final VoxelShape OPENR_WEST = VoxelShapes.or(FRAME_WEST, Block.makeCuboidShape(7.25D, 0.0D, 8.0D, 8.75D, 16.0D, 16.0D));
	protected static final VoxelShape OPENR_NORTH = VoxelShapes.or(FRAME_NORTH, Block.makeCuboidShape(0.0D, 0.0D, 7.25D, 8.0D, 16.0D, 8.75D));
	protected static final VoxelShape OPENR_EAST = VoxelShapes.or(FRAME_EAST, Block.makeCuboidShape(7.25D, 0.0D, 0.1D, 8.75D, 16.0D, 8.0D));

	protected static final VoxelShape OPENL_SOUTH = VoxelShapes.or(FRAME_SOUTH, Block.makeCuboidShape(0.0D, 0.0D, 7.25D, 8.0D, 16.0D, 8.75D));
	protected static final VoxelShape OPENL_WEST = VoxelShapes.or(FRAME_WEST, Block.makeCuboidShape(7.25D, 0.0D, 0.0D, 8.75D, 16.0D, 8.0D));
	protected static final VoxelShape OPENL_NORTH = VoxelShapes.or(FRAME_NORTH, Block.makeCuboidShape(8.0D, 0.0D, 7.25D, 16.0D, 16.0D, 8.75D));
	protected static final VoxelShape OPENL_EAST = VoxelShapes.or(FRAME_EAST, Block.makeCuboidShape(7.25D, 0.0D, 8.0D, 8.75D, 16.0D, 16.0D));

	public WindowB(Block.Properties properties) {
		super(properties);
	}
	
	/* RightClick Action */
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {
		/** 1=Close、2=Open Left、3=Open Right、4=Open **/
		int i = state.get(STAGE_1_4);
		Direction direction = state.get(H_FACING);
		Direction facing = playerIn.getHorizontalFacing();
		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();

		if (item instanceof ItemCurtain) { return ActionResultType.PASS; }

		else {
			switch (i) {
			case 1:
			default:
	
				switch (direction) {
				case NORTH:
				default:
					if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() < 0.5D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() < 0.5D))) {
						CMEvents.soundWin_Open(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i + 1))); }
	
					if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() > 0.5D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() > 0.5D))) {
						CMEvents.soundWin_Open(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i + 2))); }
					break;
	
				case SOUTH:
					if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() < 0.5D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() < 0.5D))) {
						CMEvents.soundWin_Open(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i + 2))); }
	
					if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() > 0.5D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() > 0.5D))) {
						CMEvents.soundWin_Open(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i + 1))); }
					break;
	
				case EAST:
					if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() < 0.5D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() < 0.5D))) {
						CMEvents.soundWin_Open(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i + 1))); }
	
					if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() > 0.5D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() > 0.5D))) {
						CMEvents.soundWin_Open(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i + 2))); }
					break;
					
				case WEST:
					if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() < 0.5D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() < 0.5D))) {
						CMEvents.soundWin_Open(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i + 2))); }
	
					if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() > 0.5D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() > 0.5D))) {
						CMEvents.soundWin_Open(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i + 1))); }
					break;
				} // switch
				break;
	
			case 2:
	
				switch (direction) {
				case NORTH:
				default:
					if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() < 0.5D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() < 0.5D))) {
						CMEvents.soundWin_Close(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i - 1))); }
	
					if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() > 0.5D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() > 0.5D))) {
						CMEvents.soundWin_Open(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i + 2))); }
					break;
	
				case SOUTH:
					if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() < 0.5D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() < 0.5D))) {
						CMEvents.soundWin_Open(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i + 2))); }
	
					if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() > 0.5D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() > 0.5D))) {
						CMEvents.soundWin_Close(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i - 1))); }
					break;
	
				case EAST:
					if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() < 0.5D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() < 0.5D))) {
						CMEvents.soundWin_Close(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i - 1))); }
	
					if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() > 0.5D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() > 0.5D))) {
						CMEvents.soundWin_Open(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i + 2))); }
					break;
					
				case WEST:
					if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() < 0.5D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() < 0.5D))) {
						CMEvents.soundWin_Open(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i + 2))); }
	
					if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() > 0.5D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() > 0.5D))) {
						CMEvents.soundWin_Close(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i - 1))); }
					break;
				} // switch
				break;
	
			case 3:
	
				switch (direction) {
				case NORTH:
				default:
					if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() < 0.5D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() < 0.5D))) {
						CMEvents.soundWin_Open(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i + 1))); }
	
					if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() > 0.5D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() > 0.5D))) {
						CMEvents.soundWin_Close(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i - 2))); }
					break;
	
				case SOUTH:
					if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() < 0.5D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() < 0.5D))) {
						CMEvents.soundWin_Close(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i - 2))); }
	
					if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() > 0.5D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() > 0.5D))) {
						CMEvents.soundWin_Open(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i + 1))); }
					break;
	
				case EAST:
					if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() < 0.5D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() < 0.5D))) {
						CMEvents.soundWin_Open(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i + 1))); }
	
					if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() > 0.5D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() > 0.5D))) {
						CMEvents.soundWin_Close(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i - 2))); }
					break;
					
				case WEST:
					if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() < 0.5D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() < 0.5D))) {
						CMEvents.soundWin_Close(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i - 2))); }
	
					if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() > 0.5D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() > 0.5D))) {
						CMEvents.soundWin_Open(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i + 1))); }
					break;
				} // switch
				break;
				
			case 4:
	
				switch (direction) {
				case NORTH:
				default:
					if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() < 0.5D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() < 0.5D))) {
						CMEvents.soundWin_Close(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i- 1))); }
	
					if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() > 0.5D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() > 0.5D))) {
						CMEvents.soundWin_Close(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i - 2))); }
					break;
	
				case SOUTH:
					if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() < 0.5D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() < 0.5D))) {
						CMEvents.soundWin_Close(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i - 2))); }
	
					if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() > 0.5D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() > 0.5D))) {
						CMEvents.soundWin_Close(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i - 1))); }
					break;
	
				case EAST:
					if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() < 0.5D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() < 0.5D))) {
						CMEvents.soundWin_Close(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i - 1))); }
	
					if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() > 0.5D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() > 0.5D))) {
						CMEvents.soundWin_Close(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i - 2))); }
					break;
					
				case WEST:
					if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() < 0.5D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() < 0.5D))) {
						CMEvents.soundWin_Close(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i - 2))); }
	
					if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() > 0.5D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() > 0.5D))) {
						CMEvents.soundWin_Close(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i - 1))); }
					break;
				} // switch
				break;
			} // switch STAGE_1_4
	
			return ActionResultType.SUCCESS;
		}
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(H_FACING);

		/** 1=Close、2=Open Left、3=Open Right、4=Open **/
		switch(direction) {
		case NORTH:
		default:
			return CLOSE_NORTH;
		case SOUTH:
			return CLOSE_SOUTH;
		case WEST:
			return CLOSE_WEST;
		case EAST:
			return CLOSE_EAST;
		}
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(H_FACING);
		int i = state.get(STAGE_1_4);

		/** 1=Close、2=Open Left、3=Open Right、4=Open **/
		if (i < 4) {
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
		
		else {
			switch (direction) {
			case NORTH:
			default:
				return FRAME_NORTH;
			case SOUTH:
				return FRAME_SOUTH;
			case EAST:
				return FRAME_EAST;
			case WEST:
				return FRAME_WEST;
			} // switch
		}
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
		tooltip.add(new TranslationTextComponent("tips.block_windowb").applyTextStyle(TextFormatting.GRAY));
	}
}
