package com.ayutaki.chinjufumod.blocks.amado;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Slidedoor_Blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Amado extends CM_WaterLogged {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final IntegerProperty STAGE_1_4 = IntegerProperty.create("stage", 1, 4);
	public static final EnumProperty<DoubleBlockHalf> HALF = EnumProperty.create("half", DoubleBlockHalf.class);
	
	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.box(0.0D, 0.0D, -0.5D, 16.0D, 16.0D, 0.5D);
	protected static final VoxelShape AABB_WEST = Block.box(15.5D, 0.0D, 0.0D, 16.5D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_NORTH = Block.box(0.0D, 0.0D, 15.5D, 16.0D, 16.0D, 16.5D);
	protected static final VoxelShape AABB_EAST = Block.box(-0.5D, 0.0D, 0.0D, 0.5D, 16.0D, 16.0D);
	
	public Amado(BlockBehaviour.Properties properties) {
		super(properties);
		/** Default state **/
		registerDefaultState(this.stateDefinition.any().setValue(H_FACING, Direction.NORTH)
				.setValue(STAGE_1_4, Integer.valueOf(1))
				.setValue(HALF, DoubleBlockHalf.LOWER)
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		int i = state.getValue(STAGE_1_4);
		Direction direction = state.getValue(H_FACING);
		DoubleBlockHalf half = state.getValue(HALF);
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

		Block TOBUKURO = this.takeBlock();
		Block L_TOBUKURO = this.takeBlockL();

		BlockState TOBUKURO_FACEUP = TOBUKURO.defaultBlockState().setValue(Base_Tobukuro.H_FACING, state.getValue(H_FACING)).setValue(Base_Tobukuro.HALF, DoubleBlockHalf.UPPER);
		BlockState TOBUKURO_FACELO = TOBUKURO.defaultBlockState().setValue(Base_Tobukuro.H_FACING, state.getValue(H_FACING)).setValue(Base_Tobukuro.HALF, DoubleBlockHalf.LOWER);
		BlockState L_TOBUKURO_FACEUP = L_TOBUKURO.defaultBlockState().setValue(Base_Tobukuro.H_FACING, state.getValue(H_FACING)).setValue(Base_Tobukuro.HALF, DoubleBlockHalf.UPPER);
		BlockState L_TOBUKURO_FACELO = L_TOBUKURO.defaultBlockState().setValue(Base_Tobukuro.H_FACING, state.getValue(H_FACING)).setValue(Base_Tobukuro.HALF, DoubleBlockHalf.LOWER);
		
		BlockState this_FACEUP = this.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING)).setValue(HALF, DoubleBlockHalf.UPPER);
		BlockState this_FACELO = this.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING)).setValue(HALF, DoubleBlockHalf.LOWER);
		
		CMEvents.soundAmado(worldIn, pos);

		switch (half) {
		case LOWER:
		default:
			/** move to RIGHT.________________________________________________________________________________ **/
			/* Stored in TOBUKURO. */
			if (i == 4) {
				switch (direction) {
				case NORTH:
				default:
					/** RIGHT side is TOBUKURO. **/
					if (westBlock == L_TOBUKURO && westState.getValue(Base_Tobukuro.HALF) == DoubleBlockHalf.LOWER && westState.getValue(Base_Tobukuro.STAGE_1_5) > 1) {
						/** hit RIGHT side. **/
						if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() < 0.45D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.above(), airState, 3);

							worldIn.setBlock(new BlockPos(x - 1, y, z), westState.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(westState.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3);
							worldIn.setBlock(new BlockPos(x - 1, y + 1, z), L_TOBUKURO_FACEUP.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(westState.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3); } }
					break;

				case SOUTH:
					if (eastBlock == L_TOBUKURO && eastState.getValue(Base_Tobukuro.HALF) == DoubleBlockHalf.LOWER && eastState.getValue(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() > 0.55D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.above(), airState, 3);

							worldIn.setBlock(new BlockPos(x + 1, y, z), eastState.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(eastState.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3);
							worldIn.setBlock(new BlockPos(x + 1, y + 1, z), L_TOBUKURO_FACEUP.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(eastState.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3); } }
					break;

				case EAST:
					if (northBlock == L_TOBUKURO && northState.getValue(Base_Tobukuro.HALF) == DoubleBlockHalf.LOWER && northState.getValue(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() < 0.45D)) || (facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.above(), airState, 3);

							worldIn.setBlock(new BlockPos(x, y, z - 1), northState.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(northState.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3);
							worldIn.setBlock(new BlockPos(x, y + 1, z - 1), L_TOBUKURO_FACEUP.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(northState.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3); } }
					break;
					
				case WEST:
					if (southBlock == L_TOBUKURO && southState.getValue(Base_Tobukuro.HALF) == DoubleBlockHalf.LOWER && southState.getValue(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() > 0.55D)) || (facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.above(), airState, 3);

							worldIn.setBlock(new BlockPos(x, y, z + 1), southState.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(southState.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3);
							worldIn.setBlock(new BlockPos(x, y + 1, z + 1), L_TOBUKURO_FACEUP.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(southState.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3); } }
					break;
				} // switch
			} // i == 4

			/* move to RIGHT. */
			if (i < 4) {
				switch (direction) {
				case NORTH:
				default:
					/** RIGHT side is Empty. **/
					if (worldIn.getBlockState(new BlockPos(x - 1, y, z)).canBeReplaced() && worldIn.getBlockState(new BlockPos(x - 1, y + 1, z)).canBeReplaced()) {
						/** hit RIGHT side. **/
						if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() < 0.45D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.above(), airState, 3);

							worldIn.setBlock(new BlockPos(x - 1, y, z), state.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3);
							worldIn.setBlock(new BlockPos(x - 1, y + 1, z), this_FACEUP.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3); } }
					break;

				case SOUTH:
					if (worldIn.getBlockState(new BlockPos(x + 1, y, z)).canBeReplaced() && worldIn.getBlockState(new BlockPos(x + 1, y + 1, z)).canBeReplaced()) {
						if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() > 0.55D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.above(), airState, 3);

							worldIn.setBlock(new BlockPos(x + 1, y, z), state.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3);
							worldIn.setBlock(new BlockPos(x + 1, y + 1, z), this_FACEUP.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3); } }
					break;

				case EAST:
					if (worldIn.getBlockState(new BlockPos(x, y, z - 1)).canBeReplaced() && worldIn.getBlockState(new BlockPos(x, y + 1, z - 1)).canBeReplaced()) {
						if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() < 0.45D)) || (facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.above(), airState, 3);

							worldIn.setBlock(new BlockPos(x, y, z - 1), state.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3);
							worldIn.setBlock(new BlockPos(x, y + 1, z - 1), this_FACEUP.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3); } }
					break;
					
				case WEST:
					if (worldIn.getBlockState(new BlockPos(x, y, z + 1)).canBeReplaced() && worldIn.getBlockState(new BlockPos(x, y + 1, z + 1)).canBeReplaced()) {
						if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() > 0.55D)) || (facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.above(), airState, 3);

							worldIn.setBlock(new BlockPos(x, y, z + 1), state.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3);
							worldIn.setBlock(new BlockPos(x, y + 1, z + 1), this_FACEUP.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3); } }
					break;
				} // switch
			} // i < 4
			
			/** move to Left.________________________________________________________________________________ **/
			/* Stored in TOBUKURO. */
			if (i == 1) {
				switch (direction) {
				case NORTH:
				default:
					/** LEFT side is TOBUKURO. **/
					if (eastBlock == TOBUKURO && eastState.getValue(Base_Tobukuro.HALF) == DoubleBlockHalf.LOWER && eastState.getValue(Base_Tobukuro.STAGE_1_5) > 1) {
						/** hit LEFT side **/
						if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() > 0.55D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.above(), airState, 3);

							worldIn.setBlock(new BlockPos(x + 1, y, z), eastState.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(eastState.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3);
							worldIn.setBlock(new BlockPos(x + 1, y + 1, z), TOBUKURO_FACEUP.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(eastState.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3); } }
					break;

				case SOUTH:
					if (westBlock == TOBUKURO && westState.getValue(Base_Tobukuro.HALF) == DoubleBlockHalf.LOWER && westState.getValue(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() < 0.45D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.above(), airState, 3);

							worldIn.setBlock(new BlockPos(x - 1, y, z), westState.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(westState.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3);
							worldIn.setBlock(new BlockPos(x - 1, y + 1, z), TOBUKURO_FACEUP.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(westState.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3); } }
					break;

				case EAST:
					if (southBlock == TOBUKURO && southState.getValue(Base_Tobukuro.HALF) == DoubleBlockHalf.LOWER && southState.getValue(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() > 0.55D)) || (facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.above(), airState, 3);

							worldIn.setBlock(new BlockPos(x, y, z + 1), southState.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(southState.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3);
							worldIn.setBlock(new BlockPos(x, y + 1, z + 1), TOBUKURO_FACEUP.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(southState.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3); } }
					break;
					
				case WEST:
					if (northBlock == TOBUKURO && northState.getValue(Base_Tobukuro.HALF) == DoubleBlockHalf.LOWER && northState.getValue(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() < 0.45D)) || (facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.above(), airState, 3);

							worldIn.setBlock(new BlockPos(x, y, z - 1), northState.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(northState.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3);
							worldIn.setBlock(new BlockPos(x, y + 1, z - 1), TOBUKURO_FACEUP.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(northState.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3); } }
					break;
				} // switch
			} // i == 1

			/* move to LEFT. */
			if (i > 1) {
				switch (direction) {
				case NORTH:
				default:
					if (worldIn.getBlockState(new BlockPos(x + 1, y, z)).canBeReplaced() && worldIn.getBlockState(new BlockPos(x + 1, y + 1, z)).canBeReplaced()) {
						if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() > 0.55D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.above(), airState, 3);

							worldIn.setBlock(new BlockPos(x + 1, y, z), state.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3);
							worldIn.setBlock(new BlockPos(x + 1, y + 1, z), this_FACEUP.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3); } }
					break;

				case SOUTH:
					if (worldIn.getBlockState(new BlockPos(x - 1, y, z)).canBeReplaced() && worldIn.getBlockState(new BlockPos(x - 1, y + 1, z)).canBeReplaced()) {
						if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() < 0.45D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.above(), airState, 3);

							worldIn.setBlock(new BlockPos(x - 1, y, z), state.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3);
							worldIn.setBlock(new BlockPos(x - 1, y + 1, z), this_FACEUP.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3); } }
					break;

				case EAST:
					if (worldIn.getBlockState(new BlockPos(x, y, z + 1)).canBeReplaced() && worldIn.getBlockState(new BlockPos(x, y + 1, z + 1)).canBeReplaced()) {
						if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() > 0.55D)) || (facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.above(), airState, 3);

							worldIn.setBlock(new BlockPos(x, y, z + 1), state.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3);
							worldIn.setBlock(new BlockPos(x, y + 1, z + 1), this_FACEUP.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3); } }
					break;
					
				case WEST:
					if (worldIn.getBlockState(new BlockPos(x, y, z - 1)).canBeReplaced() && worldIn.getBlockState(new BlockPos(x, y + 1, z - 1)).canBeReplaced()) {
						if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() < 0.45D)) || (facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.above(), airState, 3);

							worldIn.setBlock(new BlockPos(x, y, z - 1), state.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3);
							worldIn.setBlock(new BlockPos(x, y + 1, z - 1), this_FACEUP.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3); } }
					break;
				} // switch
			} // i > 1
			
			break;

		case UPPER:
			/** move to RIGHT.________________________________________________________________________________ **/
			/* Stored in TOBUKURO. */
			if (i == 4) {
				switch (direction) {
				case NORTH:
				default:
					/** RIGHT side is TOBUKURO. **/
					if (westBlock == L_TOBUKURO && westState.getValue(Base_Tobukuro.HALF) == DoubleBlockHalf.UPPER && westState.getValue(Base_Tobukuro.STAGE_1_5) > 1) {
						/** hit RIGHT side. **/
						if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() < 0.45D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.below(), airState, 3);

							worldIn.setBlock(new BlockPos(x - 1, y, z), westState.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(westState.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3);
							worldIn.setBlock(new BlockPos(x - 1, y - 1, z), L_TOBUKURO_FACELO.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(westState.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3); } }
					break;

				case SOUTH:
					if (eastBlock == L_TOBUKURO && eastState.getValue(Base_Tobukuro.HALF) == DoubleBlockHalf.UPPER && eastState.getValue(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() > 0.55D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.below(), airState, 3);

							worldIn.setBlock(new BlockPos(x + 1, y, z), eastState.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(eastState.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3);
							worldIn.setBlock(new BlockPos(x + 1, y - 1, z), L_TOBUKURO_FACELO.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(eastState.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3); } }
					break;

				case EAST:
					if (northBlock == L_TOBUKURO && northState.getValue(Base_Tobukuro.HALF) == DoubleBlockHalf.UPPER && northState.getValue(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() < 0.45D)) || (facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() < 0.45D))) {
							/* Delete it. */	
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.below(), airState, 3);

							worldIn.setBlock(new BlockPos(x, y, z - 1), northState.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(northState.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3);
							worldIn.setBlock(new BlockPos(x, y - 1, z - 1), L_TOBUKURO_FACELO.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(northState.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3); } }
					break;
					
				case WEST:
					if (southBlock == L_TOBUKURO && southState.getValue(Base_Tobukuro.HALF) == DoubleBlockHalf.UPPER && southState.getValue(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() > 0.55D)) || (facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.below(), airState, 3);

							worldIn.setBlock(new BlockPos(x, y, z + 1), southState.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(southState.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3);
							worldIn.setBlock(new BlockPos(x, y - 1, z + 1), L_TOBUKURO_FACELO.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(southState.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3); } }
					break;
				} // switch
			} // i == 4

			/* move to RIGHT. */
			if (i < 4) {
				switch (direction) {
				case NORTH:
				default:
					/** RIGHT side is Empty. **/
					if (worldIn.getBlockState(new BlockPos(x - 1, y, z)).canBeReplaced() && worldIn.getBlockState(new BlockPos(x - 1, y - 1, z)).canBeReplaced()) {
						/** hit RIGHT side. **/
						if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() < 0.45D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.below(), airState, 3);

							worldIn.setBlock(new BlockPos(x - 1, y, z), state.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3);
							worldIn.setBlock(new BlockPos(x - 1, y - 1, z), this_FACELO.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3); } }
					break;

				case SOUTH:
					if (worldIn.getBlockState(new BlockPos(x + 1, y, z)).canBeReplaced() && worldIn.getBlockState(new BlockPos(x + 1, y - 1, z)).canBeReplaced()) {
						if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() > 0.55D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.below(), airState, 3);

							worldIn.setBlock(new BlockPos(x + 1, y, z), state.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3);
							worldIn.setBlock(new BlockPos(x + 1, y - 1, z), this_FACELO.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3); } }
					break;

				case EAST:
					if (worldIn.getBlockState(new BlockPos(x, y, z - 1)).canBeReplaced() && worldIn.getBlockState(new BlockPos(x, y - 1, z - 1)).canBeReplaced()) {
						if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() < 0.45D)) || (facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.below(), airState, 3);

							worldIn.setBlock(new BlockPos(x, y, z - 1), state.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3);
							worldIn.setBlock(new BlockPos(x, y - 1, z - 1), this_FACELO.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3); } }
					break;
					
				case WEST:
					if (worldIn.getBlockState(new BlockPos(x, y, z + 1)).canBeReplaced() && worldIn.getBlockState(new BlockPos(x, y - 1, z + 1)).canBeReplaced()) {
						if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() > 0.55D)) || (facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.below(), airState, 3);

							worldIn.setBlock(new BlockPos(x, y, z + 1), state.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3);
							worldIn.setBlock(new BlockPos(x, y - 1, z + 1), this_FACELO.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3); } }
					break;
				} // switch
			} // i < 4
			
			/** move to LEFT.________________________________________________________________________________ **/
			/* Stored in TOBUKURO. */
			if (i == 1) {
				switch (direction) {
				case NORTH:
				default:
					/** LEFT side is TOBUKURO. **/
					if (eastBlock == TOBUKURO && eastState.getValue(Base_Tobukuro.HALF) == DoubleBlockHalf.UPPER && eastState.getValue(Base_Tobukuro.STAGE_1_5) > 1) {
						/** hit LEFT side **/
						if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() > 0.55D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.below(), airState, 3);

							worldIn.setBlock(new BlockPos(x + 1, y, z), eastState.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(eastState.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3);
							worldIn.setBlock(new BlockPos(x + 1, y - 1, z), TOBUKURO_FACELO.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(eastState.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3); } }
					break;

				case SOUTH:
					if (westBlock == TOBUKURO && westState.getValue(Base_Tobukuro.HALF) == DoubleBlockHalf.UPPER && westState.getValue(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() < 0.45D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.below(), airState, 3);

							worldIn.setBlock(new BlockPos(x - 1, y, z), westState.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(westState.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3);
							worldIn.setBlock(new BlockPos(x - 1, y - 1, z), TOBUKURO_FACELO.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(westState.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3); } }
					break;

				case EAST:
					if (southBlock == TOBUKURO && southState.getValue(Base_Tobukuro.HALF) == DoubleBlockHalf.UPPER && southState.getValue(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() > 0.55D)) || (facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.below(), airState, 3);

							worldIn.setBlock(new BlockPos(x, y, z + 1), southState.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(southState.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3);
							worldIn.setBlock(new BlockPos(x, y - 1, z + 1), TOBUKURO_FACELO.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(southState.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3); } }
					break;
					
				case WEST:
					if (northBlock == TOBUKURO && northState.getValue(Base_Tobukuro.HALF) == DoubleBlockHalf.UPPER && northState.getValue(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() < 0.45D)) || (facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.below(), airState, 3);

							worldIn.setBlock(new BlockPos(x, y, z - 1), northState.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(northState.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3);
							worldIn.setBlock(new BlockPos(x, y - 1, z - 1), TOBUKURO_FACELO.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(northState.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3); } }
					break;
				} // switch
			} // i == 1

			/* move to LEFT. */
			if (i > 1) {
				switch (direction) {
				case NORTH:
				default:
					if (worldIn.getBlockState(new BlockPos(x + 1, y, z)).canBeReplaced() && worldIn.getBlockState(new BlockPos(x + 1, y - 1, z)).canBeReplaced()) {
						if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() > 0.55D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.below(), airState, 3);

							worldIn.setBlock(new BlockPos(x + 1, y, z), state.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3);
							worldIn.setBlock(new BlockPos(x + 1, y - 1, z), this_FACELO.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3); } }
					break;

				case SOUTH:
					if (worldIn.getBlockState(new BlockPos(x - 1, y, z)).canBeReplaced() && worldIn.getBlockState(new BlockPos(x - 1, y - 1, z)).canBeReplaced()) {
						if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() < 0.45D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.below(), airState, 3);

							worldIn.setBlock(new BlockPos(x - 1, y, z), state.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3);
							worldIn.setBlock(new BlockPos(x - 1, y - 1, z), this_FACELO.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3); } }
					break;

				case EAST:
					if (worldIn.getBlockState(new BlockPos(x, y, z + 1)).canBeReplaced() && worldIn.getBlockState(new BlockPos(x, y - 1, z + 1)).canBeReplaced()) {
						if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() > 0.55D)) || (facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.below(), airState, 3);

							worldIn.setBlock(new BlockPos(x, y, z + 1), state.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3);
							worldIn.setBlock(new BlockPos(x, y - 1, z + 1), this_FACELO.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3); } }
					break;
					
				case WEST:
					if (worldIn.getBlockState(new BlockPos(x, y, z - 1)).canBeReplaced() && worldIn.getBlockState(new BlockPos(x, y - 1, z - 1)).canBeReplaced()) {
						if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() < 0.45D)) || (facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.below(), airState, 3);

							worldIn.setBlock(new BlockPos(x, y, z - 1), state.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3);
							worldIn.setBlock(new BlockPos(x, y - 1, z - 1), this_FACELO.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3); } }
					break;
				} // switch
			} // i > 1
			
			break;
		} // switch LOWER-UPPER
		return InteractionResult.SUCCESS;
	}
	
	private Block takeBlock() {
		if (this == Slidedoor_Blocks.AMADO.get()) { return Slidedoor_Blocks.TOBUKURO.get(); }
		if (this == Slidedoor_Blocks.AMADO_S.get()) { return Slidedoor_Blocks.TOBUKURO_S.get(); }
		return null;
	}
	
	private Block takeBlockL() {
		if (this == Slidedoor_Blocks.AMADO.get()) { return Slidedoor_Blocks.TOBUKURO_L.get(); }
		if (this == Slidedoor_Blocks.AMADO_S.get()) { return Slidedoor_Blocks.TOBUKURO_SL.get(); }
		return null;
	}
	
	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		Level worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);

		return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER))
				.setValue(H_FACING, context.getHorizontalDirection().getOpposite());
	}
	
	/* Limit the place. */
	public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
		BlockPos downPos = pos.below();
		BlockState downState = worldIn.getBlockState(downPos);

		/** Lower part is true. **/
		if (state.getValue(HALF) == DoubleBlockHalf.LOWER) { return true; }

		/** Upper part is this block. **/
		else { return downState.getBlock() == this; }
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
	
	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos pos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			worldIn.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }
		
		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}
	
	/* Destroy a DoubleBlock from DoublePlantBlock.class */
	@Override
	public void playerWillDestroy(Level worldIn, BlockPos pos, BlockState state, Player playerIn) {
		if (!worldIn.isClientSide) {
			if (playerIn.isCreative()) { creativeDrop(worldIn, pos, state, playerIn); }
			else { notCreativeDrop(worldIn, pos, state, playerIn); }
		}
		super.playerWillDestroy(worldIn, pos, state, playerIn);
	}

	@Override
	public void playerDestroy(Level worldIn, Player playerIn, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack) {
		super.playerDestroy(worldIn, playerIn, pos, Blocks.AIR.defaultBlockState(), blockEntity, stack);
	}

	protected static void creativeDrop(Level worldIn, BlockPos pos, BlockState state, Player playerIn) {
		DoubleBlockHalf half = state.getValue(HALF);
		if (half == DoubleBlockHalf.UPPER) {
			BlockPos downPos = pos.below();
			BlockState downState = worldIn.getBlockState(downPos);

			if (downState.getBlock() == state.getBlock() && downState.getValue(HALF) == DoubleBlockHalf.LOWER) {
				worldIn.setBlock(downPos, Blocks.AIR.defaultBlockState(), 35);
				worldIn.levelEvent(playerIn, 2001, downPos, Block.getId(downState));
			}
		}

		if (half != DoubleBlockHalf.UPPER) {
			BlockPos upPos = pos.above();
			BlockState upState = worldIn.getBlockState(upPos);

			if (upState.getBlock() == state.getBlock() && upState.getValue(HALF) == DoubleBlockHalf.UPPER) {
				worldIn.setBlock(upPos, Blocks.AIR.defaultBlockState(), 35);
				worldIn.levelEvent(playerIn, 2001, upPos, Block.getId(upState));
			}
		}
	}

	protected static void notCreativeDrop(Level worldIn, BlockPos pos, BlockState state, Player playerIn) {
		DoubleBlockHalf half = state.getValue(HALF);
		if (half == DoubleBlockHalf.UPPER) {
			BlockPos downPos = pos.below();
			BlockState downState = worldIn.getBlockState(downPos);

			if (downState.getBlock() == state.getBlock() && downState.getValue(HALF) == DoubleBlockHalf.LOWER) {
				worldIn.setBlock(downPos, Blocks.AIR.defaultBlockState(), 35);
				worldIn.levelEvent(playerIn, 2001, downPos, Block.getId(downState));
			}
		}

		if (half != DoubleBlockHalf.UPPER) {
			BlockPos upPos = pos.above();
			BlockState upState = worldIn.getBlockState(upPos);

			if (upState.getBlock() == state.getBlock() && upState.getValue(HALF) == DoubleBlockHalf.UPPER) {
				worldIn.setBlock(upPos, Blocks.AIR.defaultBlockState(), 35);
				worldIn.levelEvent(playerIn, 2001, upPos, Block.getId(upState));
			}
		}
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items.AIR);
	}
	
	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(H_FACING, HALF, STAGE_1_4, WATERLOGGED);
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		Direction direction = state.getValue(H_FACING);

		switch (direction) {
		case NORTH:
		default: return AABB_NORTH;
		case SOUTH: return AABB_SOUTH;
		case WEST: return AABB_WEST;
		case EAST: return AABB_EAST;
		}
	}
}
