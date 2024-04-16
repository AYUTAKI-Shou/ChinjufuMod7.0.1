package com.ayutaki.chinjufumod.blocks.season;

import java.util.Optional;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.furnace.AbstractOvenBlock;
import com.ayutaki.chinjufumod.blocks.furnace.AbstractStoveBlock;
import com.ayutaki.chinjufumod.blocks.furnace.Irori;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Cooktop;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.SoulFireBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/* FallingBlock. When this falls, the only drop is this ItemBlock. */
public class SnowCore extends FallingBlock implements SimpleWaterloggedBlock {

	/* Property */
	public static final IntegerProperty STAGE_0_9 = IntegerProperty.create("stage", 0, 9);
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");
	
	/* Collision */
	protected static final VoxelShape AABB_01 = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 5.0D, 10.0D);
	protected static final VoxelShape AABB_23 = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 7.0D, 11.0D);
	protected static final VoxelShape AABB_45 = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 9.0D, 11.0D);
	protected static final VoxelShape AABB_67 = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 11.0D, 12.0D);
	protected static final VoxelShape AABB_89 = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 13.0D, 13.0D);
	protected static final VoxelShape COLL_89 = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 13.0D);

	private final int dustColor;
	
	public SnowCore(int value, BlockBehaviour.Properties properties) {
		super(properties);
		/** Default state **/
		registerDefaultState(this.stateDefinition.any().setValue(STAGE_0_9, Integer.valueOf(0))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
		
		this.dustColor = value;
	}

	@OnlyIn(Dist.CLIENT)
	public int getDustColor(BlockState stateIn, BlockGetter worldIn, BlockPos posIn) {
		return this.dustColor;
	}
	
	/* RightClick Action */
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		int i = state.getValue(STAGE_0_9);
		Direction facing = playerIn.getDirection();
		
		BlockState northState = worldIn.getBlockState(pos.north());
		BlockState southState = worldIn.getBlockState(pos.south());
		BlockState eastState = worldIn.getBlockState(pos.east());
		BlockState westState = worldIn.getBlockState(pos.west());
		
		int x = (int) pos.getX();
		int y = (int) pos.getY();
		int z = (int) pos.getZ();
		
		Block northBlock = northState.getBlock();
		Block southBlock = southState.getBlock();
		Block eastBlock = eastState.getBlock();
		Block westBlock = westState.getBlock();
		
		BlockState airState = Blocks.AIR.defaultBlockState();
		Block SNOW = Blocks.SNOW;
		BlockState placeSNOW = SNOW.defaultBlockState().setValue(SnowLayerBlock.LAYERS, Integer.valueOf(1));
		Block SNOWCORE = Seasonal_Blocks.SNOWCORE.get();
		
		/** Hand is empty. **/
		if (stack.isEmpty()) {

			if (i <= 7) {
				switch (facing) {
				case NORTH:
				default:
					if (northBlock == SNOW) {
						CMEvents.soundSnowPlace(worldIn, pos);
						worldIn.setBlock(pos, airState, 3);
						worldIn.setBlock(pos.north(), state.setValue(STAGE_0_9, Integer.valueOf(i + 1)), 3); }
					
					if (northBlock != SNOW) {
						if (northState.canBeReplaced()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.north(), state.setValue(STAGE_0_9, Integer.valueOf(i)), 3); }
						 
						if (!northState.canBeReplaced()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					break;
		
				case SOUTH:
					if (southBlock == SNOW) {
						CMEvents.soundSnowPlace(worldIn, pos);
						worldIn.setBlock(pos, airState, 3);
						worldIn.setBlock(pos.south(), state.setValue(STAGE_0_9, Integer.valueOf(i + 1)), 3); }
					
					if (southBlock != SNOW) {
						if (southState.canBeReplaced()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.south(), state.setValue(STAGE_0_9, Integer.valueOf(i)), 3); }
						 
						if (!southState.canBeReplaced()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					break;
		
				case EAST:
					if (eastBlock == SNOW) {
						CMEvents.soundSnowPlace(worldIn, pos);
						worldIn.setBlock(pos, airState, 3);
						worldIn.setBlock(pos.east(), state.setValue(STAGE_0_9, Integer.valueOf(i + 1)), 3); }
					
					if (eastBlock != SNOW) {
						if (eastState.canBeReplaced()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.east(), state.setValue(STAGE_0_9, Integer.valueOf(i)), 3); }
						 
						if (!eastState.canBeReplaced()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					break;
					
				case WEST:
					if (westBlock == SNOW) {
						CMEvents.soundSnowPlace(worldIn, pos);
						worldIn.setBlock(pos, airState, 3);
						worldIn.setBlock(pos.west(), state.setValue(STAGE_0_9, Integer.valueOf(i + 1)), 3); }
					
					if (westBlock != SNOW) {
						if (westState.canBeReplaced()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.west(), state.setValue(STAGE_0_9, Integer.valueOf(i)), 3); }
						 
						if (!westState.canBeReplaced()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					break;
				} // switch facing
			} //i <= 7
			
			
			if (i == 8) {
				switch (facing) {
				case NORTH:
				default:
					if (northBlock == SNOWCORE) {
						if (northState.getValue(SnowCore.STAGE_0_9) == 8 && worldIn.getBlockState(new BlockPos(x, y + 1, z - 1)).canBeReplaced()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(new BlockPos(x, y, z - 1), Seasonal_Blocks.SNOWMAN.get().defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.setValue(SnowMan.H_FACING, Direction.SOUTH)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(false))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlock(new BlockPos(x, y + 1, z - 1), Seasonal_Blocks.SNOWMAN.get().defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.setValue(SnowMan.H_FACING, Direction.SOUTH)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(false))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3); }
						
						if (northState.getValue(SnowCore.STAGE_0_9) == 9 && worldIn.getBlockState(new BlockPos(x, y + 1, z - 1)).canBeReplaced()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(new BlockPos(x, y, z - 1), Seasonal_Blocks.SNOWMAN.get().defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.setValue(SnowMan.H_FACING, Direction.SOUTH)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(true))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlock(new BlockPos(x, y + 1, z - 1), Seasonal_Blocks.SNOWMAN.get().defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.setValue(SnowMan.H_FACING, Direction.SOUTH)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(true))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3); }
					} // make SNOUMAN
					
					if (northBlock != SNOWCORE) {
						if (northBlock == SNOW) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.north(), state.setValue(STAGE_0_9, Integer.valueOf(9)), 3); }
						
						if (northBlock != SNOW) {
							if (northState.canBeReplaced()) {
								CMEvents.soundSnowPlace(worldIn, pos);
								worldIn.setBlock(pos, airState, 3);
								worldIn.setBlock(pos.north(), state.setValue(STAGE_0_9, Integer.valueOf(8)), 3); }
							
							if (!northState.canBeReplaced()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					} // not make SNOUMAN
					break;
	
				case SOUTH:
					if (southBlock == SNOWCORE) {
						if (southState.getValue(SnowCore.STAGE_0_9) == 8 && worldIn.getBlockState(new BlockPos(x, y + 1, z + 1)).canBeReplaced()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(new BlockPos(x, y, z + 1), Seasonal_Blocks.SNOWMAN.get().defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.setValue(SnowMan.H_FACING, Direction.NORTH)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(false))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlock(new BlockPos(x, y + 1, z + 1), Seasonal_Blocks.SNOWMAN.get().defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.H_FACING, Direction.NORTH)
									.setValue(SnowMan.DOWN, Boolean.valueOf(false))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3); }
						
						if (southState.getValue(SnowCore.STAGE_0_9) == 9 && worldIn.getBlockState(new BlockPos(x, y + 1, z + 1)).canBeReplaced()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(new BlockPos(x, y, z + 1), Seasonal_Blocks.SNOWMAN.get().defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.setValue(SnowMan.H_FACING, Direction.NORTH)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(true))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlock(new BlockPos(x, y + 1, z + 1), Seasonal_Blocks.SNOWMAN.get().defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.setValue(SnowMan.H_FACING, Direction.NORTH)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(true))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3); }
					} // make SNOUMAN
					
					if (southBlock != SNOWCORE) {
						if (southBlock == SNOW) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.south(), state.setValue(STAGE_0_9, Integer.valueOf(9)), 3); }
						
						if (southBlock != SNOW) {
							if (southState.canBeReplaced()) {
								CMEvents.soundSnowPlace(worldIn, pos);
								worldIn.setBlock(pos, airState, 3);
								worldIn.setBlock(pos.south(), state.setValue(STAGE_0_9, Integer.valueOf(8)), 3); }
							
							if (!southState.canBeReplaced()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					} // not make SNOUMAN
					break;
	
				case EAST:
					if (eastBlock == SNOWCORE) {
						if (eastState.getValue(SnowCore.STAGE_0_9) == 8 && worldIn.getBlockState(new BlockPos(x + 1, y + 1, z)).canBeReplaced()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(new BlockPos(x + 1, y, z), Seasonal_Blocks.SNOWMAN.get().defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.setValue(SnowMan.H_FACING, Direction.WEST)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(false))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlock(new BlockPos(x + 1, y + 1, z), Seasonal_Blocks.SNOWMAN.get().defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.setValue(SnowMan.H_FACING, Direction.WEST)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(false))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3); }
						
						if (eastState.getValue(SnowCore.STAGE_0_9) == 9 && worldIn.getBlockState(new BlockPos(x + 1, y + 1, z)).canBeReplaced()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(new BlockPos(x + 1, y, z), Seasonal_Blocks.SNOWMAN.get().defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.setValue(SnowMan.H_FACING, Direction.WEST)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(true))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlock(new BlockPos(x + 1, y + 1, z), Seasonal_Blocks.SNOWMAN.get().defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.setValue(SnowMan.H_FACING, Direction.WEST)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(true))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3); }
					} // make SNOUMAN
					
					if (eastBlock != SNOWCORE) {
						if (eastBlock == SNOW) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.east(), state.setValue(STAGE_0_9, Integer.valueOf(9)), 3); }
						
						if (eastBlock != SNOW) {
							if (eastState.canBeReplaced()) {
								CMEvents.soundSnowPlace(worldIn, pos);
								worldIn.setBlock(pos, airState, 3);
								worldIn.setBlock(pos.east(), state.setValue(STAGE_0_9, Integer.valueOf(8)), 3); }
							
							if (!eastState.canBeReplaced()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					} // not make SNOUMAN
					break;
					
				case WEST:
					if (westBlock == SNOWCORE) {
						if (westState.getValue(SnowCore.STAGE_0_9) == 8 && worldIn.getBlockState(new BlockPos(x - 1, y + 1, z)).canBeReplaced()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(new BlockPos(x - 1, y, z), Seasonal_Blocks.SNOWMAN.get().defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.setValue(SnowMan.H_FACING, Direction.EAST)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(false))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlock(new BlockPos(x - 1, y + 1, z), Seasonal_Blocks.SNOWMAN.get().defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.setValue(SnowMan.H_FACING, Direction.EAST)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(false))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3); }
						
						if (westState.getValue(SnowCore.STAGE_0_9) == 9 && worldIn.getBlockState(new BlockPos(x - 1, y + 1, z)).canBeReplaced()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(new BlockPos(x - 1, y, z), Seasonal_Blocks.SNOWMAN.get().defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.setValue(SnowMan.H_FACING, Direction.EAST)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(true))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlock(new BlockPos(x - 1, y + 1, z), Seasonal_Blocks.SNOWMAN.get().defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.setValue(SnowMan.H_FACING, Direction.EAST)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(true))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3); }
					} // make SNOUMAN
					
					if (westBlock != SNOWCORE) {
						if (westBlock == SNOW) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.west(), state.setValue(STAGE_0_9, Integer.valueOf(9)), 3); }
						
						if (westBlock != SNOW) {
							if (westState.canBeReplaced()) {
								CMEvents.soundSnowPlace(worldIn, pos);
								worldIn.setBlock(pos, airState, 3);
								worldIn.setBlock(pos.west(), state.setValue(STAGE_0_9, Integer.valueOf(8)), 3); }
							
							if (!westState.canBeReplaced()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					} // not make SNOUMAN
					break;
				} // switch
			} //i == 8
	
			
			if (i == 9) {
				switch (facing) {
				case NORTH:
				default:
					if (northBlock == SNOWCORE) {
						if (northState.getValue(SnowCore.STAGE_0_9) == 8 && worldIn.getBlockState(new BlockPos(x, y + 1, z - 1)).canBeReplaced()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, placeSNOW, 3);
							worldIn.setBlock(new BlockPos(x, y, z - 1), Seasonal_Blocks.SNOWMAN.get().defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.setValue(SnowMan.H_FACING, Direction.SOUTH)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(false))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlock(new BlockPos(x, y + 1, z - 1), Seasonal_Blocks.SNOWMAN.get().defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.setValue(SnowMan.H_FACING, Direction.SOUTH)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(false))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3); }
						
						if (northState.getValue(SnowCore.STAGE_0_9) == 9 && worldIn.getBlockState(new BlockPos(x, y + 1, z - 1)).canBeReplaced()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, placeSNOW, 3);
							worldIn.setBlock(new BlockPos(x, y, z - 1), Seasonal_Blocks.SNOWMAN.get().defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.setValue(SnowMan.H_FACING, Direction.SOUTH)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(true))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlock(new BlockPos(x, y + 1, z - 1), Seasonal_Blocks.SNOWMAN.get().defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.setValue(SnowMan.H_FACING, Direction.SOUTH)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(true))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3); }
					} // make SNOUMAN
					
					if (northBlock != SNOWCORE) {
						if (northBlock == SNOW) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, placeSNOW, 3);
							worldIn.setBlock(pos.north(), state.setValue(STAGE_0_9, Integer.valueOf(9)), 3); }
						
						if (northBlock != SNOW) {
							if (northState.canBeReplaced()) {
								CMEvents.soundSnowPlace(worldIn, pos);
								worldIn.setBlock(pos, placeSNOW, 3);
								worldIn.setBlock(pos.north(), state.setValue(STAGE_0_9, Integer.valueOf(8)), 3); }
							
							if (!northState.canBeReplaced()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					} // not make SNOUMAN
					break;
	
				case SOUTH:
					if (southBlock == SNOWCORE) {
						if (southState.getValue(SnowCore.STAGE_0_9) == 8 && worldIn.getBlockState(new BlockPos(x, y + 1, z + 1)).canBeReplaced()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, placeSNOW, 3);
							worldIn.setBlock(new BlockPos(x, y, z + 1), Seasonal_Blocks.SNOWMAN.get().defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.setValue(SnowMan.H_FACING, Direction.NORTH)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(false))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlock(new BlockPos(x, y + 1, z + 1), Seasonal_Blocks.SNOWMAN.get().defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.H_FACING, Direction.NORTH)
									.setValue(SnowMan.DOWN, Boolean.valueOf(false))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3); }
						
						if (southState.getValue(SnowCore.STAGE_0_9) == 9 && worldIn.getBlockState(new BlockPos(x, y + 1, z + 1)).canBeReplaced()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, placeSNOW, 3);
							worldIn.setBlock(new BlockPos(x, y, z + 1), Seasonal_Blocks.SNOWMAN.get().defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.setValue(SnowMan.H_FACING, Direction.NORTH)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(true))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlock(new BlockPos(x, y + 1, z + 1), Seasonal_Blocks.SNOWMAN.get().defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.setValue(SnowMan.H_FACING, Direction.NORTH)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(true))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3); }
					} // make SNOUMAN
					
					if (southBlock != SNOWCORE) {
						if (southBlock == SNOW) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, placeSNOW, 3);
							worldIn.setBlock(pos.south(), state.setValue(STAGE_0_9, Integer.valueOf(9)), 3); }
						
						if (southBlock != SNOW) {
							if (southState.canBeReplaced()) {
								CMEvents.soundSnowPlace(worldIn, pos);
								worldIn.setBlock(pos, placeSNOW, 3);
								worldIn.setBlock(pos.south(), state.setValue(STAGE_0_9, Integer.valueOf(8)), 3); }
							
							if (!southState.canBeReplaced()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					} // not make SNOUMAN
					break;
	
				case EAST:
					if (eastBlock == SNOWCORE) {
						if (eastState.getValue(SnowCore.STAGE_0_9) == 8 && worldIn.getBlockState(new BlockPos(x + 1, y + 1, z)).canBeReplaced()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, placeSNOW, 3);
							worldIn.setBlock(new BlockPos(x + 1, y, z), Seasonal_Blocks.SNOWMAN.get().defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.setValue(SnowMan.H_FACING, Direction.WEST)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(false))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlock(new BlockPos(x + 1, y + 1, z), Seasonal_Blocks.SNOWMAN.get().defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.setValue(SnowMan.H_FACING, Direction.WEST)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(false))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3); }
						
						if (eastState.getValue(SnowCore.STAGE_0_9) == 9 && worldIn.getBlockState(new BlockPos(x + 1, y + 1, z)).canBeReplaced()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, placeSNOW, 3);
							worldIn.setBlock(new BlockPos(x + 1, y, z), Seasonal_Blocks.SNOWMAN.get().defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.setValue(SnowMan.H_FACING, Direction.WEST)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(true))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlock(new BlockPos(x + 1, y + 1, z), Seasonal_Blocks.SNOWMAN.get().defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.setValue(SnowMan.H_FACING, Direction.WEST)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(true))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3); }
					} // make SNOUMAN
					
					if (eastBlock != SNOWCORE) {
						if (eastBlock == SNOW) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, placeSNOW, 3);
							worldIn.setBlock(pos.east(), state.setValue(STAGE_0_9, Integer.valueOf(9)), 3); }
						
						if (eastBlock != SNOW) {
							if (eastState.canBeReplaced()) {
								CMEvents.soundSnowPlace(worldIn, pos);
								worldIn.setBlock(pos, placeSNOW, 3);
								worldIn.setBlock(pos.east(), state.setValue(STAGE_0_9, Integer.valueOf(8)), 3); }
							
							if (!eastState.canBeReplaced()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					} // not make SNOUMAN
					break;
					
				case WEST:
					if (westBlock == SNOWCORE) {
						if (westState.getValue(SnowCore.STAGE_0_9) == 8 && worldIn.getBlockState(new BlockPos(x - 1, y + 1, z)).canBeReplaced()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, placeSNOW, 3);
							worldIn.setBlock(new BlockPos(x - 1, y, z), Seasonal_Blocks.SNOWMAN.get().defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.setValue(SnowMan.H_FACING, Direction.EAST)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(false))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlock(new BlockPos(x - 1, y + 1, z), Seasonal_Blocks.SNOWMAN.get().defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.setValue(SnowMan.H_FACING, Direction.EAST)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(false))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3); }
						
						if (westState.getValue(SnowCore.STAGE_0_9) == 9 && worldIn.getBlockState(new BlockPos(x - 1, y + 1, z)).canBeReplaced()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, placeSNOW, 3);
							worldIn.setBlock(new BlockPos(x - 1, y, z), Seasonal_Blocks.SNOWMAN.get().defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.setValue(SnowMan.H_FACING, Direction.EAST)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(true))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlock(new BlockPos(x - 1, y + 1, z), Seasonal_Blocks.SNOWMAN.get().defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.setValue(SnowMan.H_FACING, Direction.EAST)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(true))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3); }
					} // make SNOUMAN
					
					if (westBlock != SNOWCORE) {
						if (westBlock == SNOW) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, placeSNOW, 3);
							worldIn.setBlock(pos.west(), state.setValue(STAGE_0_9, Integer.valueOf(9)), 3); }
						
						if (westBlock != SNOW) {
							if (westState.canBeReplaced()) {
								CMEvents.soundSnowPlace(worldIn, pos);
								worldIn.setBlock(pos, placeSNOW, 3);
								worldIn.setBlock(pos.west(), state.setValue(STAGE_0_9, Integer.valueOf(8)), 3); }
							
							if (!westState.canBeReplaced()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					} // not make SNOUMAN
					break;
				} // switch
			} //i == 9
		}/** Hand is empty. **/
		
		if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		/** SUCCESS to not put anything on top. **/
		return InteractionResult.SUCCESS;
	}
	
	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		Level worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);
		Block block = worldIn.getBlockState(pos).getBlock();
		
		if (block == Blocks.SNOW) {
			return this.defaultBlockState().setValue(STAGE_0_9, Integer.valueOf(1))
					.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)); }
		
		else { return this.defaultBlockState().setValue(STAGE_0_9, Integer.valueOf(0))
				.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)); }
	}
	
	/* Waterlogged */
	@SuppressWarnings("deprecation")
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}
	
	@Override
	public boolean canPlaceLiquid(@Nullable Player playerIn, BlockGetter worldIn, BlockPos pos, BlockState state, Fluid fluid) {
		return fluid == Fluids.WATER;
	} // fix 20.2
	
	@Override
	public boolean placeLiquid(LevelAccessor worldIn, BlockPos pos, BlockState state, FluidState fluid) {
		if (!state.getValue(BlockStateProperties.WATERLOGGED) && fluid.getType() == Fluids.WATER) {
			if (!worldIn.isClientSide()) {
				worldIn.setBlock(pos, state.setValue(BlockStateProperties.WATERLOGGED, Boolean.valueOf(true)), 3);
				worldIn.scheduleTick(pos, fluid.getType(), fluid.getType().getTickDelay(worldIn)); }
			return true; }
		
		else { return false; }
	}
	
	@Override
	public ItemStack pickupBlock(@Nullable Player playerIn, LevelAccessor worldIn, BlockPos pos, BlockState state) {
		if (state.getValue(BlockStateProperties.WATERLOGGED)) {
			worldIn.setBlock(pos, state.setValue(BlockStateProperties.WATERLOGGED, Boolean.valueOf(false)), 3);
			
			if (!state.canSurvive(worldIn, pos)) { worldIn.destroyBlock(pos, true); }
			return new ItemStack(Items.WATER_BUCKET);
		}
		
		else { return ItemStack.EMPTY; }
	} // fix 20.2
	
	@Override
	public Optional<SoundEvent> getPickupSound() {
		return Fluids.WATER.getPickupSound();
	}
	
	/* Distinguish LOST from WATERLOGGED. */
	protected boolean inWater(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return state.getValue(WATERLOGGED);
	}
	
	private boolean hasHeat(BlockGetter worldIn, BlockPos pos) {
		for(BlockPos nearpos : BlockPos.betweenClosed(pos.offset(-2, -1, -2), pos.offset(2, 1, 2))) {
			BlockState nearstate = worldIn.getBlockState(nearpos);
			Block nearblock = nearstate.getBlock();

			if (nearblock == Blocks.LAVA || nearblock == Blocks.MAGMA_BLOCK ||
					nearblock instanceof FireBlock || nearblock instanceof SoulFireBlock || 
					(nearblock instanceof CampfireBlock && nearstate.getValue(CampfireBlock.LIT)) ||
					(nearblock instanceof AbstractFurnaceBlock && nearstate.getValue(AbstractFurnaceBlock.LIT)) ||
					(nearblock instanceof AbstractOvenBlock && nearstate.getValue(AbstractOvenBlock.LIT)) ||
					(nearblock instanceof AbstractStoveBlock && nearstate.getValue(AbstractStoveBlock.LIT)) ||
					(nearblock instanceof Irori && nearstate.getValue(Irori.LIT)) ||
					(nearblock instanceof Kit_Cooktop && nearstate.getValue(Kit_Cooktop.STAGE_1_3) == 2) ) {
				return true; }
		}
		return false;
	}
	
	private boolean hasAtama(BlockGetter worldIn, BlockPos pos) {
		BlockState upState = worldIn.getBlockState(pos.above());
		Block upBlock = upState.getBlock();
		return (upBlock instanceof SnowCore && upState.getValue(STAGE_0_9) >= 8);
	}
	
	/* Update BlockState. */
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.getValue(WATERLOGGED)) {
			worldIn.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }
		
		if ((worldIn.isEmptyBlock(pos.below()) || isFree(worldIn.getBlockState(pos.below())) && pos.getY() >= 0) || hasAtama(worldIn, pos)) {
			worldIn.scheduleTick(pos, this, this.getDelayAfterPlace()); }
		
		else{ worldIn.scheduleTick(pos, this, 200); }
		
		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}

	/* TickRandom */
	@Override
	public void onPlace(BlockState state, Level worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		if ((worldIn.isEmptyBlock(pos.below()) || isFree(worldIn.getBlockState(pos.below())) && pos.getY() >= 0) || hasAtama(worldIn, pos)) {
			worldIn.scheduleTick(pos, this, this.getDelayAfterPlace()); }
		
		else{ worldIn.scheduleTick(pos, this, 200); }
	}
	
	@Override
	public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
		int i = state.getValue(STAGE_0_9);
		Block downBlock = worldIn.getBlockState(pos.below()).getBlock();

		if (isFree(worldIn.getBlockState(pos.below())) && pos.getY() >= worldIn.getMinBuildHeight()) {
			FallingBlockEntity fallingblockentity = FallingBlockEntity.fall(worldIn, pos, state);
			this.falling(fallingblockentity);
			//worldIn.addFreshEntity(fallingblockentity); 
		}
		
		if (hasAtama(worldIn, pos)) {
			if (i <= 7) { }
			
			if (i == 8) {
				worldIn.scheduleTick(pos, this, this.getDelayAfterPlace());
				CMEvents.soundSnowPlace(worldIn, pos);
				worldIn.setBlock(pos, Seasonal_Blocks.SNOWMAN.get().defaultBlockState()
						.setValue(SnowMan.HALF, DoubleBlockHalf.LOWER)
						.setValue(SnowMan.H_FACING, Direction.SOUTH)
						.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
						.setValue(SnowMan.DOWN, Boolean.valueOf(false))
						.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3);
				worldIn.setBlock(pos.above(), Seasonal_Blocks.SNOWMAN.get().defaultBlockState()
						.setValue(SnowMan.HALF, DoubleBlockHalf.UPPER)
						.setValue(SnowMan.H_FACING, Direction.SOUTH)
						.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
						.setValue(SnowMan.DOWN, Boolean.valueOf(false))
						.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3); }
		
			if (i == 9) {
				worldIn.scheduleTick(pos, this, this.getDelayAfterPlace());
				CMEvents.soundSnowPlace(worldIn, pos);
				worldIn.setBlock(pos, Seasonal_Blocks.SNOWMAN.get().defaultBlockState()
						.setValue(SnowMan.HALF, DoubleBlockHalf.LOWER)
						.setValue(SnowMan.H_FACING, Direction.SOUTH)
						.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
						.setValue(SnowMan.DOWN, Boolean.valueOf(true))
						.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3);
				worldIn.setBlock(pos.above(), Seasonal_Blocks.SNOWMAN.get().defaultBlockState()
						.setValue(SnowMan.HALF, DoubleBlockHalf.UPPER)
						.setValue(SnowMan.H_FACING, Direction.SOUTH)
						.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
						.setValue(SnowMan.DOWN, Boolean.valueOf(true))
						.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3); }
		} //upBlock SnowCore
		
		if (!hasAtama(worldIn, pos)) {
			if (inWater(state, worldIn, pos)) { 
				worldIn.scheduleTick(pos, this, 200);
				breakBlock(state, worldIn, pos); }
			
			if (!inWater(state, worldIn, pos)) {
				if (downBlock == Blocks.ICE || downBlock == Blocks.PACKED_ICE ||
						downBlock == Blocks.BLUE_ICE || downBlock == Blocks.SNOW_BLOCK) { }
				
				if (downBlock != Blocks.ICE && downBlock != Blocks.PACKED_ICE &&
						downBlock != Blocks.BLUE_ICE && downBlock != Blocks.SNOW_BLOCK) {
					
					if (hasHeat(worldIn, pos)) {
						worldIn.scheduleTick(pos, this, 200);
						breakBlock(state, worldIn, pos); }
					
					if (!hasHeat(worldIn, pos)) {
						/** Plain 0.8F, Jungle 0.9F, Desert 2.0F **/
						if (worldIn.getBiome(pos).value().getBaseTemperature() > 0.85F) {
							worldIn.scheduleTick(pos, this, 200);
							breakBlock(state, worldIn, pos); }
						
						if (worldIn.getBiome(pos).value().getBaseTemperature() <= 0.85F) { }
					} //!hasHeat
				} //!ICE
			} //!WATERLOGGED			
		}
	}
	
	private void breakBlock(BlockState state, ServerLevel worldIn, BlockPos pos) {
		int i = state.getValue(STAGE_0_9);
		if (i != 0) { 
			CMEvents.soundSnowBreak(worldIn, pos);
			worldIn.setBlock(pos, state.setValue(STAGE_0_9, Integer.valueOf(i - 1)), 3); }
		if (i == 0) { worldIn.destroyBlock(pos, true); }
	}
	
	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(STAGE_0_9, WATERLOGGED);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		int i = state.getValue(STAGE_0_9);
		
		switch (i) {
		case 0 :
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
	public VoxelShape getCollisionShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		int i = state.getValue(STAGE_0_9);
		
		switch (i) {
		case 0 :
		default:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5: return Shapes.empty();
		case 6:
		case 7: return AABB_67;
		case 8:
		case 9: return COLL_89;
		} // switch STAGE_0_9
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Seasonal.SNOWCORE.get());
	}
}
