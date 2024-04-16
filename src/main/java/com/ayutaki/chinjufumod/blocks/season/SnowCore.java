package com.ayutaki.chinjufumod.blocks.season;

import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.furnace.AbstractOvenBlock;
import com.ayutaki.chinjufumod.blocks.furnace.AbstractStoveBlock;
import com.ayutaki.chinjufumod.blocks.furnace.Irori;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Cooktop;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;

import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.FireBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.SnowBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

/* FallingBlock. When this falls, the only drop is this ItemBlock. */
public class SnowCore extends FallingBlock implements IWaterLoggable {

	public static final IntegerProperty STAGE_0_9 = IntegerProperty.create("stage", 0, 9);
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");

	/* Collision */
	protected static final VoxelShape AABB_01 = Block.makeCuboidShape(6.0D, 0.0D, 6.0D, 10.0D, 5.0D, 10.0D);
	protected static final VoxelShape AABB_23 = Block.makeCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 7.0D, 11.0D);
	protected static final VoxelShape AABB_45 = Block.makeCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 9.0D, 11.0D);
	protected static final VoxelShape AABB_67 = Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 11.0D, 12.0D);
	protected static final VoxelShape AABB_89 = Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 13.0D, 13.0D);
	protected static final VoxelShape COLL_89 = Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 13.0D);
	
	private final int dustColor;
	
	public SnowCore(int value, Block.Properties properties) {
		super(properties);
		this.dustColor = value;
		/** Default state **/
		setDefaultState(this.stateContainer.getBaseState()
				.with(STAGE_0_9, Integer.valueOf(0))
				.with(WATERLOGGED, Boolean.valueOf(false)));
	}

	@OnlyIn(Dist.CLIENT)
	public int getDustColor(BlockState stateIn, IBlockReader worldIn, BlockPos posIn) {
		return this.dustColor;
	}
	
	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {
	
		ItemStack stack = playerIn.getHeldItem(hand);
		int i = state.get(STAGE_0_9);
		Direction facing = playerIn.getHorizontalFacing();
		
		BlockState northState = worldIn.getBlockState(pos.north());
		BlockState southState = worldIn.getBlockState(pos.south());
		BlockState eastState = worldIn.getBlockState(pos.east());
		BlockState westState = worldIn.getBlockState(pos.west());
		
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		
		Block northBlock = northState.getBlock();
		Block southBlock = southState.getBlock();
		Block eastBlock = eastState.getBlock();
		Block westBlock = westState.getBlock();
		
		BlockState airState = Blocks.AIR.getDefaultState();
		Block SNOW = Blocks.SNOW;
		BlockState placeSNOW = SNOW.getDefaultState().with(SnowBlock.LAYERS, Integer.valueOf(1));
		Block SNOWCORE = Seasonal_Blocks.SNOWCORE;
		
		/** Hand is empty. **/
		if (stack.isEmpty()) {
			
			if (i <= 7) {
				switch (facing) {
				case NORTH:
				default:
					if (northBlock == SNOW) {
						CMEvents.soundSnowPlace(worldIn, pos);
						worldIn.setBlockState(pos, airState, 3);
						worldIn.setBlockState(pos.north(), state.with(STAGE_0_9, Integer.valueOf(i + 1)), 3); }
					
					if (northBlock != SNOW) {
						if (northState.getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, airState, 3);
							worldIn.setBlockState(pos.north(), state.with(STAGE_0_9, Integer.valueOf(i)), 3); }
						 
						if (!northState.getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					break;

				case SOUTH:
					if (southBlock == SNOW) {
						CMEvents.soundSnowPlace(worldIn, pos);
						worldIn.setBlockState(pos, airState, 3);
						worldIn.setBlockState(pos.south(), state.with(STAGE_0_9, Integer.valueOf(i + 1)), 3); }
					
					if (southBlock != SNOW) {
						if (southState.getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, airState, 3);
							worldIn.setBlockState(pos.south(), state.with(STAGE_0_9, Integer.valueOf(i)), 3); }
						 
						if (!southState.getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					break;

				case EAST:
					if (eastBlock == SNOW) {
						CMEvents.soundSnowPlace(worldIn, pos);
						worldIn.setBlockState(pos, airState, 3);
						worldIn.setBlockState(pos.east(), state.with(STAGE_0_9, Integer.valueOf(i + 1)), 3); }
					
					if (eastBlock != SNOW) {
						if (eastState.getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, airState, 3);
							worldIn.setBlockState(pos.east(), state.with(STAGE_0_9, Integer.valueOf(i)), 3); }
						 
						if (!eastState.getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					break;
					
				case WEST:
					if (westBlock == SNOW) {
						CMEvents.soundSnowPlace(worldIn, pos);
						worldIn.setBlockState(pos, airState, 3);
						worldIn.setBlockState(pos.west(), state.with(STAGE_0_9, Integer.valueOf(i + 1)), 3); }
					
					if (westBlock != SNOW) {
						if (westState.getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, airState, 3);
							worldIn.setBlockState(pos.west(), state.with(STAGE_0_9, Integer.valueOf(i)), 3); }
						 
						if (!westState.getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					break;
				} // switch facing
			} //i <= 7
			
			
			if (i == 8) {
				switch (facing) {
				case NORTH:
				default:
					if (northBlock == SNOWCORE) {
						if (northState.get(SnowCore.STAGE_0_9) == 8 && worldIn.getBlockState(new BlockPos(x, y + 1, z - 1)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, airState, 3);
							worldIn.setBlockState(new BlockPos(x, y, z - 1), Seasonal_Blocks.SNOWMAN.getDefaultState()
									.with(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.with(SnowMan.H_FACING, Direction.SOUTH)
									.with(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.with(SnowMan.DOWN, Boolean.valueOf(false))
									.with(SnowMan.WATERLOGGED, state.get(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), Seasonal_Blocks.SNOWMAN.getDefaultState()
									.with(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.with(SnowMan.H_FACING, Direction.SOUTH)
									.with(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.with(SnowMan.DOWN, Boolean.valueOf(false))
									.with(SnowMan.WATERLOGGED, state.get(SnowMan.WATERLOGGED)), 3); }
						
						if (northState.get(SnowCore.STAGE_0_9) == 9 && worldIn.getBlockState(new BlockPos(x, y + 1, z - 1)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, airState, 3);
							worldIn.setBlockState(new BlockPos(x, y, z - 1), Seasonal_Blocks.SNOWMAN.getDefaultState()
									.with(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.with(SnowMan.H_FACING, Direction.SOUTH)
									.with(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.with(SnowMan.DOWN, Boolean.valueOf(true))
									.with(SnowMan.WATERLOGGED, state.get(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), Seasonal_Blocks.SNOWMAN.getDefaultState()
									.with(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.with(SnowMan.H_FACING, Direction.SOUTH)
									.with(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.with(SnowMan.DOWN, Boolean.valueOf(true))
									.with(SnowMan.WATERLOGGED, state.get(SnowMan.WATERLOGGED)), 3); }
					} // make SNOUMAN
					
					if (northBlock != SNOWCORE) {
						if (northBlock == SNOW) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, airState, 3);
							worldIn.setBlockState(pos.north(), state.with(STAGE_0_9, Integer.valueOf(9)), 3); }
						
						if (northBlock != SNOW) {
							if (northState.getMaterial().isReplaceable()) {
								CMEvents.soundSnowPlace(worldIn, pos);
								worldIn.setBlockState(pos, airState, 3);
								worldIn.setBlockState(pos.north(), state.with(STAGE_0_9, Integer.valueOf(8)), 3); }
							
							if (!northState.getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					} // not make SNOUMAN
					break;

				case SOUTH:
					if (southBlock == SNOWCORE) {
						if (southState.get(SnowCore.STAGE_0_9) == 8 && worldIn.getBlockState(new BlockPos(x, y + 1, z + 1)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, airState, 3);
							worldIn.setBlockState(new BlockPos(x, y, z + 1), Seasonal_Blocks.SNOWMAN.getDefaultState()
									.with(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.with(SnowMan.H_FACING, Direction.NORTH)
									.with(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.with(SnowMan.DOWN, Boolean.valueOf(false))
									.with(SnowMan.WATERLOGGED, state.get(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), Seasonal_Blocks.SNOWMAN.getDefaultState()
									.with(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.with(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.with(SnowMan.H_FACING, Direction.NORTH)
									.with(SnowMan.DOWN, Boolean.valueOf(false))
									.with(SnowMan.WATERLOGGED, state.get(SnowMan.WATERLOGGED)), 3); }
						
						if (southState.get(SnowCore.STAGE_0_9) == 9 && worldIn.getBlockState(new BlockPos(x, y + 1, z + 1)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, airState, 3);
							worldIn.setBlockState(new BlockPos(x, y, z + 1), Seasonal_Blocks.SNOWMAN.getDefaultState()
									.with(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.with(SnowMan.H_FACING, Direction.NORTH)
									.with(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.with(SnowMan.DOWN, Boolean.valueOf(true))
									.with(SnowMan.WATERLOGGED, state.get(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), Seasonal_Blocks.SNOWMAN.getDefaultState()
									.with(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.with(SnowMan.H_FACING, Direction.NORTH)
									.with(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.with(SnowMan.DOWN, Boolean.valueOf(true))
									.with(SnowMan.WATERLOGGED, state.get(SnowMan.WATERLOGGED)), 3); }
					} // make SNOUMAN
					
					if (southBlock != SNOWCORE) {
						if (southBlock == SNOW) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, airState, 3);
							worldIn.setBlockState(pos.south(), state.with(STAGE_0_9, Integer.valueOf(9)), 3); }
						
						if (southBlock != SNOW) {
							if (southState.getMaterial().isReplaceable()) {
								CMEvents.soundSnowPlace(worldIn, pos);
								worldIn.setBlockState(pos, airState, 3);
								worldIn.setBlockState(pos.south(), state.with(STAGE_0_9, Integer.valueOf(8)), 3); }
							
							if (!southState.getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					} // not make SNOUMAN
					break;

				case EAST:
					if (eastBlock == SNOWCORE) {
						if (eastState.get(SnowCore.STAGE_0_9) == 8 && worldIn.getBlockState(new BlockPos(x + 1, y + 1, z)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, airState, 3);
							worldIn.setBlockState(new BlockPos(x + 1, y, z), Seasonal_Blocks.SNOWMAN.getDefaultState()
									.with(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.with(SnowMan.H_FACING, Direction.WEST)
									.with(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.with(SnowMan.DOWN, Boolean.valueOf(false))
									.with(SnowMan.WATERLOGGED, state.get(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), Seasonal_Blocks.SNOWMAN.getDefaultState()
									.with(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.with(SnowMan.H_FACING, Direction.WEST)
									.with(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.with(SnowMan.DOWN, Boolean.valueOf(false))
									.with(SnowMan.WATERLOGGED, state.get(SnowMan.WATERLOGGED)), 3); }
						
						if (eastState.get(SnowCore.STAGE_0_9) == 9 && worldIn.getBlockState(new BlockPos(x + 1, y + 1, z)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, airState, 3);
							worldIn.setBlockState(new BlockPos(x + 1, y, z), Seasonal_Blocks.SNOWMAN.getDefaultState()
									.with(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.with(SnowMan.H_FACING, Direction.WEST)
									.with(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.with(SnowMan.DOWN, Boolean.valueOf(true))
									.with(SnowMan.WATERLOGGED, state.get(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), Seasonal_Blocks.SNOWMAN.getDefaultState()
									.with(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.with(SnowMan.H_FACING, Direction.WEST)
									.with(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.with(SnowMan.DOWN, Boolean.valueOf(true))
									.with(SnowMan.WATERLOGGED, state.get(SnowMan.WATERLOGGED)), 3); }
					} // make SNOUMAN
					
					if (eastBlock != SNOWCORE) {
						if (eastBlock == SNOW) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, airState, 3);
							worldIn.setBlockState(pos.east(), state.with(STAGE_0_9, Integer.valueOf(9)), 3); }
						
						if (eastBlock != SNOW) {
							if (eastState.getMaterial().isReplaceable()) {
								CMEvents.soundSnowPlace(worldIn, pos);
								worldIn.setBlockState(pos, airState, 3);
								worldIn.setBlockState(pos.east(), state.with(STAGE_0_9, Integer.valueOf(8)), 3); }
							
							if (!eastState.getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					} // not make SNOUMAN
					break;
					
				case WEST:
					if (westBlock == SNOWCORE) {
						if (westState.get(SnowCore.STAGE_0_9) == 8 && worldIn.getBlockState(new BlockPos(x - 1, y + 1, z)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, airState, 3);
							worldIn.setBlockState(new BlockPos(x - 1, y, z), Seasonal_Blocks.SNOWMAN.getDefaultState()
									.with(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.with(SnowMan.H_FACING, Direction.EAST)
									.with(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.with(SnowMan.DOWN, Boolean.valueOf(false))
									.with(SnowMan.WATERLOGGED, state.get(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), Seasonal_Blocks.SNOWMAN.getDefaultState()
									.with(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.with(SnowMan.H_FACING, Direction.EAST)
									.with(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.with(SnowMan.DOWN, Boolean.valueOf(false))
									.with(SnowMan.WATERLOGGED, state.get(SnowMan.WATERLOGGED)), 3); }
						
						if (westState.get(SnowCore.STAGE_0_9) == 9 && worldIn.getBlockState(new BlockPos(x - 1, y + 1, z)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, airState, 3);
							worldIn.setBlockState(new BlockPos(x - 1, y, z), Seasonal_Blocks.SNOWMAN.getDefaultState()
									.with(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.with(SnowMan.H_FACING, Direction.EAST)
									.with(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.with(SnowMan.DOWN, Boolean.valueOf(true))
									.with(SnowMan.WATERLOGGED, state.get(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), Seasonal_Blocks.SNOWMAN.getDefaultState()
									.with(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.with(SnowMan.H_FACING, Direction.EAST)
									.with(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.with(SnowMan.DOWN, Boolean.valueOf(true))
									.with(SnowMan.WATERLOGGED, state.get(SnowMan.WATERLOGGED)), 3); }
					} // make SNOUMAN
					
					if (westBlock != SNOWCORE) {
						if (westBlock == SNOW) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, airState, 3);
							worldIn.setBlockState(pos.west(), state.with(STAGE_0_9, Integer.valueOf(9)), 3); }
						
						if (westBlock != SNOW) {
							if (westState.getMaterial().isReplaceable()) {
								CMEvents.soundSnowPlace(worldIn, pos);
								worldIn.setBlockState(pos, airState, 3);
								worldIn.setBlockState(pos.west(), state.with(STAGE_0_9, Integer.valueOf(8)), 3); }
							
							if (!westState.getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					} // not make SNOUMAN
					break;
				} // switch facing
			} //i == 8

			
			if (i == 9) {
				switch (facing) {
				case NORTH:
				default:
					if (northBlock == SNOWCORE) {
						if (northState.get(SnowCore.STAGE_0_9) == 8 && worldIn.getBlockState(new BlockPos(x, y + 1, z - 1)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, placeSNOW, 3);
							worldIn.setBlockState(new BlockPos(x, y, z - 1), Seasonal_Blocks.SNOWMAN.getDefaultState()
									.with(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.with(SnowMan.H_FACING, Direction.SOUTH)
									.with(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.with(SnowMan.DOWN, Boolean.valueOf(false))
									.with(SnowMan.WATERLOGGED, state.get(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), Seasonal_Blocks.SNOWMAN.getDefaultState()
									.with(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.with(SnowMan.H_FACING, Direction.SOUTH)
									.with(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.with(SnowMan.DOWN, Boolean.valueOf(false))
									.with(SnowMan.WATERLOGGED, state.get(SnowMan.WATERLOGGED)), 3); }
						
						if (northState.get(SnowCore.STAGE_0_9) == 9 && worldIn.getBlockState(new BlockPos(x, y + 1, z - 1)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, placeSNOW, 3);
							worldIn.setBlockState(new BlockPos(x, y, z - 1), Seasonal_Blocks.SNOWMAN.getDefaultState()
									.with(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.with(SnowMan.H_FACING, Direction.SOUTH)
									.with(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.with(SnowMan.DOWN, Boolean.valueOf(true))
									.with(SnowMan.WATERLOGGED, state.get(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), Seasonal_Blocks.SNOWMAN.getDefaultState()
									.with(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.with(SnowMan.H_FACING, Direction.SOUTH)
									.with(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.with(SnowMan.DOWN, Boolean.valueOf(true))
									.with(SnowMan.WATERLOGGED, state.get(SnowMan.WATERLOGGED)), 3); }
					} // make SNOUMAN
					
					if (northBlock != SNOWCORE) {
						if (northBlock == SNOW) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, placeSNOW, 3);
							worldIn.setBlockState(pos.north(), state.with(STAGE_0_9, Integer.valueOf(9)), 3); }
						
						if (northBlock != SNOW) {
							if (northState.getMaterial().isReplaceable()) {
								CMEvents.soundSnowPlace(worldIn, pos);
								worldIn.setBlockState(pos, placeSNOW, 3);
								worldIn.setBlockState(pos.north(), state.with(STAGE_0_9, Integer.valueOf(8)), 3); }
							
							if (!northState.getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					} // not make SNOUMAN
					break;

				case SOUTH:
					if (southBlock == SNOWCORE) {
						if (southState.get(SnowCore.STAGE_0_9) == 8 && worldIn.getBlockState(new BlockPos(x, y + 1, z + 1)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, placeSNOW, 3);
							worldIn.setBlockState(new BlockPos(x, y, z + 1), Seasonal_Blocks.SNOWMAN.getDefaultState()
									.with(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.with(SnowMan.H_FACING, Direction.NORTH)
									.with(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.with(SnowMan.DOWN, Boolean.valueOf(false))
									.with(SnowMan.WATERLOGGED, state.get(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), Seasonal_Blocks.SNOWMAN.getDefaultState()
									.with(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.with(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.with(SnowMan.H_FACING, Direction.NORTH)
									.with(SnowMan.DOWN, Boolean.valueOf(false))
									.with(SnowMan.WATERLOGGED, state.get(SnowMan.WATERLOGGED)), 3); }
						
						if (southState.get(SnowCore.STAGE_0_9) == 9 && worldIn.getBlockState(new BlockPos(x, y + 1, z + 1)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, placeSNOW, 3);
							worldIn.setBlockState(new BlockPos(x, y, z + 1), Seasonal_Blocks.SNOWMAN.getDefaultState()
									.with(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.with(SnowMan.H_FACING, Direction.NORTH)
									.with(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.with(SnowMan.DOWN, Boolean.valueOf(true))
									.with(SnowMan.WATERLOGGED, state.get(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), Seasonal_Blocks.SNOWMAN.getDefaultState()
									.with(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.with(SnowMan.H_FACING, Direction.NORTH)
									.with(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.with(SnowMan.DOWN, Boolean.valueOf(true))
									.with(SnowMan.WATERLOGGED, state.get(SnowMan.WATERLOGGED)), 3); }
					} // make SNOUMAN
					
					if (southBlock != SNOWCORE) {
						if (southBlock == SNOW) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, placeSNOW, 3);
							worldIn.setBlockState(pos.south(), state.with(STAGE_0_9, Integer.valueOf(9)), 3); }
						
						if (southBlock != SNOW) {
							if (southState.getMaterial().isReplaceable()) {
								CMEvents.soundSnowPlace(worldIn, pos);
								worldIn.setBlockState(pos, placeSNOW, 3);
								worldIn.setBlockState(pos.south(), state.with(STAGE_0_9, Integer.valueOf(8)), 3); }
							
							if (!southState.getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					} // not make SNOUMAN
					break;

				case EAST:
					if (eastBlock == SNOWCORE) {
						if (eastState.get(SnowCore.STAGE_0_9) == 8 && worldIn.getBlockState(new BlockPos(x + 1, y + 1, z)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, placeSNOW, 3);
							worldIn.setBlockState(new BlockPos(x + 1, y, z), Seasonal_Blocks.SNOWMAN.getDefaultState()
									.with(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.with(SnowMan.H_FACING, Direction.WEST)
									.with(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.with(SnowMan.DOWN, Boolean.valueOf(false))
									.with(SnowMan.WATERLOGGED, state.get(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), Seasonal_Blocks.SNOWMAN.getDefaultState()
									.with(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.with(SnowMan.H_FACING, Direction.WEST)
									.with(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.with(SnowMan.DOWN, Boolean.valueOf(false))
									.with(SnowMan.WATERLOGGED, state.get(SnowMan.WATERLOGGED)), 3); }
						
						if (eastState.get(SnowCore.STAGE_0_9) == 9 && worldIn.getBlockState(new BlockPos(x + 1, y + 1, z)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, placeSNOW, 3);
							worldIn.setBlockState(new BlockPos(x + 1, y, z), Seasonal_Blocks.SNOWMAN.getDefaultState()
									.with(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.with(SnowMan.H_FACING, Direction.WEST)
									.with(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.with(SnowMan.DOWN, Boolean.valueOf(true))
									.with(SnowMan.WATERLOGGED, state.get(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), Seasonal_Blocks.SNOWMAN.getDefaultState()
									.with(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.with(SnowMan.H_FACING, Direction.WEST)
									.with(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.with(SnowMan.DOWN, Boolean.valueOf(true))
									.with(SnowMan.WATERLOGGED, state.get(SnowMan.WATERLOGGED)), 3); }
					} // make SNOUMAN
					
					if (eastBlock != SNOWCORE) {
						if (eastBlock == SNOW) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, placeSNOW, 3);
							worldIn.setBlockState(pos.east(), state.with(STAGE_0_9, Integer.valueOf(9)), 3); }
						
						if (eastBlock != SNOW) {
							if (eastState.getMaterial().isReplaceable()) {
								CMEvents.soundSnowPlace(worldIn, pos);
								worldIn.setBlockState(pos, placeSNOW, 3);
								worldIn.setBlockState(pos.east(), state.with(STAGE_0_9, Integer.valueOf(8)), 3); }
							
							if (!eastState.getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					} // not make SNOUMAN
					break;
					
				case WEST:
					if (westBlock == SNOWCORE) {
						if (westState.get(SnowCore.STAGE_0_9) == 8 && worldIn.getBlockState(new BlockPos(x - 1, y + 1, z)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, placeSNOW, 3);
							worldIn.setBlockState(new BlockPos(x - 1, y, z), Seasonal_Blocks.SNOWMAN.getDefaultState()
									.with(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.with(SnowMan.H_FACING, Direction.EAST)
									.with(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.with(SnowMan.DOWN, Boolean.valueOf(false))
									.with(SnowMan.WATERLOGGED, state.get(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), Seasonal_Blocks.SNOWMAN.getDefaultState()
									.with(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.with(SnowMan.H_FACING, Direction.EAST)
									.with(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.with(SnowMan.DOWN, Boolean.valueOf(false))
									.with(SnowMan.WATERLOGGED, state.get(SnowMan.WATERLOGGED)), 3); }
						
						if (westState.get(SnowCore.STAGE_0_9) == 9 && worldIn.getBlockState(new BlockPos(x - 1, y + 1, z)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, placeSNOW, 3);
							worldIn.setBlockState(new BlockPos(x - 1, y, z), Seasonal_Blocks.SNOWMAN.getDefaultState()
									.with(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.with(SnowMan.H_FACING, Direction.EAST)
									.with(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.with(SnowMan.DOWN, Boolean.valueOf(true))
									.with(SnowMan.WATERLOGGED, state.get(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), Seasonal_Blocks.SNOWMAN.getDefaultState()
									.with(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.with(SnowMan.H_FACING, Direction.EAST)
									.with(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.with(SnowMan.DOWN, Boolean.valueOf(true))
									.with(SnowMan.WATERLOGGED, state.get(SnowMan.WATERLOGGED)), 3); }
					} // make SNOUMAN
					
					if (westBlock != SNOWCORE) {
						if (westBlock == SNOW) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlockState(pos, placeSNOW, 3);
							worldIn.setBlockState(pos.west(), state.with(STAGE_0_9, Integer.valueOf(9)), 3); }
						
						if (westBlock != SNOW) {
							if (westState.getMaterial().isReplaceable()) {
								CMEvents.soundSnowPlace(worldIn, pos);
								worldIn.setBlockState(pos, placeSNOW, 3);
								worldIn.setBlockState(pos.west(), state.with(STAGE_0_9, Integer.valueOf(8)), 3); }
							
							if (!westState.getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					} // not make SNOUMAN
					break;
				} // switch facing
			} //i == 9
		} // Hand is empty.
		
		if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		
		return ActionResultType.SUCCESS;
	}
	
	
	/* Gives a value when placed. */
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getWorld();
		BlockPos pos = context.getPos();
		IFluidState fluid = worldIn.getFluidState(pos);
		Block blockIn = worldIn.getBlockState(pos).getBlock();

		if (blockIn == Blocks.SNOW) {
			return this.getDefaultState().with(STAGE_0_9, Integer.valueOf(1)).with(WATERLOGGED, fluid.getFluid() == Fluids.WATER); }
		
		return this.getDefaultState().with(STAGE_0_9, Integer.valueOf(0)).with(WATERLOGGED, fluid.getFluid() == Fluids.WATER);
	}
	
	/* Waterlogged */
	@SuppressWarnings("deprecation")
	public IFluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}
	
	public boolean canContainFluid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluidIn) {
		return IWaterLoggable.super.canContainFluid(worldIn, pos, state, fluidIn);
	}
	
	public boolean receiveFluid(IWorld worldIn, BlockPos pos, BlockState state, IFluidState fluidStateIn) {
		return IWaterLoggable.super.receiveFluid(worldIn, pos, state, fluidStateIn);
	}

	@Override
	public Fluid pickupFluid(IWorld worldIn, BlockPos pos, BlockState state) {
		if (state.get(BlockStateProperties.WATERLOGGED)) {
			worldIn.setBlockState(pos, state.with(BlockStateProperties.WATERLOGGED, Boolean.valueOf(false)), 3);
			return Fluids.WATER; }
		
		else { return Fluids.EMPTY; }
	}
	
	/* Update BlockState. */
	protected boolean inWater(BlockState state, IWorld worldIn, BlockPos pos) {
		return state.get(WATERLOGGED);
	}
	
	private boolean hasHeat(IWorldReader worldIn, BlockPos pos) {
		for(BlockPos nearpos : BlockPos.getAllInBoxMutable(pos.add(-2, -1, -2), pos.add(2, 1, 2))) {
			BlockState nearstate = worldIn.getBlockState(nearpos);
			Block nearblock = nearstate.getBlock();

			if (nearblock == Blocks.LAVA || nearblock == Blocks.MAGMA_BLOCK ||
					nearblock instanceof FireBlock ||
					(nearblock instanceof CampfireBlock && nearstate.get(CampfireBlock.LIT)) ||
					(nearblock instanceof AbstractFurnaceBlock && nearstate.get(AbstractFurnaceBlock.LIT)) ||
					(nearblock instanceof AbstractOvenBlock && nearstate.get(AbstractOvenBlock.LIT)) ||
					(nearblock instanceof AbstractStoveBlock && nearstate.get(AbstractStoveBlock.LIT)) ||
					(nearblock instanceof Irori && nearstate.get(Irori.LIT)) ||
					(nearblock instanceof Kit_Cooktop && nearstate.get(Kit_Cooktop.STAGE_1_3) == 2) ) {
				return true; }
		}
		return false;
	}
	
	private boolean hasAtama(IWorld worldIn, BlockPos pos) {
		BlockState upState = worldIn.getBlockState(pos.up());
		Block upBlock = upState.getBlock();
		return (upBlock instanceof SnowCore && upState.get(STAGE_0_9) >= 8);
	}
	
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn)); }
		
		if ((worldIn.isAirBlock(pos.down()) || canFallThrough(worldIn.getBlockState(pos.down())) && pos.getY() >= 0) || hasAtama(worldIn, pos)) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, this, this.tickRate(worldIn)); }
		
		else{ worldIn.getPendingBlockTicks().scheduleTick(pos, this, 200); }
		
		return super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
	}
	
	
	/* TickRandom */
	@Override
	public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		if ((worldIn.isAirBlock(pos.down()) || canFallThrough(worldIn.getBlockState(pos.down())) && pos.getY() >= 0) || hasAtama(worldIn, pos)) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, this, this.tickRate(worldIn)); }
		
		else{ worldIn.getPendingBlockTicks().scheduleTick(pos, this, 200); }
	}
	
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		int i = state.get(STAGE_0_9);
		Block downBlock = worldIn.getBlockState(pos.down()).getBlock();
	
		if (worldIn.isAirBlock(pos.down()) || canFallThrough(worldIn.getBlockState(pos.down())) && pos.getY() >= 0) {
			FallingBlockEntity fallingblockentity = new FallingBlockEntity(worldIn, (double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, worldIn.getBlockState(pos));
			this.onStartFalling(fallingblockentity);
			worldIn.addEntity(fallingblockentity); }
		
		if (hasAtama(worldIn, pos)) {
			if (i <= 7) { }
			
			if (i == 8) {
				worldIn.getPendingBlockTicks().scheduleTick(pos, this, 2);
				CMEvents.soundSnowPlace(worldIn, pos);
				worldIn.setBlockState(pos, Seasonal_Blocks.SNOWMAN.getDefaultState()
						.with(SnowMan.HALF, DoubleBlockHalf.LOWER)
						.with(SnowMan.H_FACING, Direction.SOUTH)
						.with(SnowMan.STAGE_1_4, Integer.valueOf(1))
						.with(SnowMan.DOWN, Boolean.valueOf(false))
						.with(SnowMan.WATERLOGGED, state.get(SnowMan.WATERLOGGED)), 3);
				worldIn.setBlockState(pos.up(), Seasonal_Blocks.SNOWMAN.getDefaultState()
						.with(SnowMan.HALF, DoubleBlockHalf.UPPER)
						.with(SnowMan.H_FACING, Direction.SOUTH)
						.with(SnowMan.STAGE_1_4, Integer.valueOf(1))
						.with(SnowMan.DOWN, Boolean.valueOf(false))
						.with(SnowMan.WATERLOGGED, state.get(SnowMan.WATERLOGGED)), 3); }
		
			if (i == 9) {
				worldIn.getPendingBlockTicks().scheduleTick(pos, this, 2);
				CMEvents.soundSnowPlace(worldIn, pos);
				worldIn.setBlockState(pos, Seasonal_Blocks.SNOWMAN.getDefaultState()
						.with(SnowMan.HALF, DoubleBlockHalf.LOWER)
						.with(SnowMan.H_FACING, Direction.SOUTH)
						.with(SnowMan.STAGE_1_4, Integer.valueOf(1))
						.with(SnowMan.DOWN, Boolean.valueOf(true))
						.with(SnowMan.WATERLOGGED, state.get(SnowMan.WATERLOGGED)), 3);
				worldIn.setBlockState(pos.up(), Seasonal_Blocks.SNOWMAN.getDefaultState()
						.with(SnowMan.HALF, DoubleBlockHalf.UPPER)
						.with(SnowMan.H_FACING, Direction.SOUTH)
						.with(SnowMan.STAGE_1_4, Integer.valueOf(1))
						.with(SnowMan.DOWN, Boolean.valueOf(true))
						.with(SnowMan.WATERLOGGED, state.get(SnowMan.WATERLOGGED)), 3); }
		} //upBlock SnowCore
		
		if (inWater(state, worldIn, pos)) { 
			worldIn.getPendingBlockTicks().scheduleTick(pos, this, 200);
			breakBlock(state, worldIn, pos); }
		
		if (!inWater(state, worldIn, pos)) {
			if (downBlock == Blocks.ICE || downBlock == Blocks.PACKED_ICE ||
					downBlock == Blocks.BLUE_ICE || downBlock == Blocks.SNOW_BLOCK) { }
			
			if (downBlock != Blocks.ICE && downBlock != Blocks.PACKED_ICE &&
					downBlock != Blocks.BLUE_ICE && downBlock != Blocks.SNOW_BLOCK) {
				
				if (hasHeat(worldIn, pos)) {
					worldIn.getPendingBlockTicks().scheduleTick(pos, this, 200);
					breakBlock(state, worldIn, pos); }
				
				if (!hasHeat(worldIn, pos)) {
					/** Plain 0.8F, Jungle 0.9F, Desert 2.0F **/
					if (worldIn.getBiome(pos).getTemperature(pos) > 0.85F) {
						worldIn.getPendingBlockTicks().scheduleTick(pos, this, 200);
						breakBlock(state, worldIn, pos); }
					
					if (worldIn.getBiome(pos).getTemperature(pos) <= 0.85F) { }
				} //!hasHeat
			} //!ICE
		} //!WATERLOGGED
	}

	private void breakBlock(BlockState state, World worldIn, BlockPos pos) {
		int i = state.get(STAGE_0_9);
		if (i != 0) { 
			CMEvents.soundSnowBreak(worldIn, pos);
			worldIn.setBlockState(pos, state.with(STAGE_0_9, Integer.valueOf(i - 1)), 3); }
		if (i == 0) { worldIn.destroyBlock(pos, true); }
	}
	
	/* Create Blockstate */
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(STAGE_0_9, WATERLOGGED);
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		int i = state.get(STAGE_0_9);
		
		switch (i) {
		case 0:
		default:
		case 1: return AABB_01;
		case 2:
		case 3: return AABB_23;
		case 4:
		case 5: return AABB_45;
		case 6:
		case 7: return AABB_67;
		case 8:
		case 9: return AABB_89;
		} // switch STAGE_0_9
	}
	
	@Override
	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		int i = state.get(STAGE_0_9);
		
		switch (i) {
		case 0:
		default:
		case 1: 
		case 2:
		case 3: 
		case 4:
		case 5: return VoxelShapes.empty();
		case 6:
		case 7: return AABB_67;
		case 8:
		case 9: return COLL_89;
		} // switch STAGE_0_9
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Seasonal.SNOWCORE);
	}
	
	/* The best harvesting tool. */
	@Nullable
	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.SHOVEL;
	}

	@Override
	public int getHarvestLevel(BlockState state) {
		return 0;
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
}
