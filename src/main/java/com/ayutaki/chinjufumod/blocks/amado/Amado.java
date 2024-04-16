package com.ayutaki.chinjufumod.blocks.amado;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Slidedoor_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class Amado extends CM_WaterLogged {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final IntegerProperty STAGE_1_4 = IntegerProperty.create("stage", 1, 4);
	public static final EnumProperty<DoubleBlockHalf> HALF = EnumProperty.create("half", DoubleBlockHalf.class);

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.makeCuboidShape(0.0D, 0.0D, -0.5D, 16.0D, 16.0D, 0.5D);
	protected static final VoxelShape AABB_WEST = Block.makeCuboidShape(15.5D, 0.0D, 0.0D, 16.5D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_NORTH = Block.makeCuboidShape(0.0D, 0.0D, 15.5D, 16.0D, 16.0D, 16.5D);
	protected static final VoxelShape AABB_EAST = Block.makeCuboidShape(-0.5D, 0.0D, 0.0D, 0.5D, 16.0D, 16.0D);

	public Amado(Block.Properties properties) {
		super(properties);

		/** Default state **/
		setDefaultState(this.stateContainer.getBaseState().with(H_FACING, Direction.NORTH)
				.with(STAGE_1_4, Integer.valueOf(1))
				.with(HALF, DoubleBlockHalf.LOWER)
				.with(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		int i = state.get(STAGE_1_4);
		Direction direction = state.get(H_FACING);
		DoubleBlockHalf half = state.get(HALF);
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

		Block TOBUKURO = this.takeBlock();
		Block L_TOBUKURO = this.takeBlockL();

		BlockState TOBUKURO_FACEUP = TOBUKURO.getDefaultState().with(Base_Tobukuro.H_FACING, state.get(H_FACING)).with(Base_Tobukuro.HALF, DoubleBlockHalf.UPPER);
		BlockState TOBUKURO_FACELO = TOBUKURO.getDefaultState().with(Base_Tobukuro.H_FACING, state.get(H_FACING)).with(Base_Tobukuro.HALF, DoubleBlockHalf.LOWER);
		BlockState L_TOBUKURO_FACEUP = L_TOBUKURO.getDefaultState().with(Base_Tobukuro.H_FACING, state.get(H_FACING)).with(Base_Tobukuro.HALF, DoubleBlockHalf.UPPER);
		BlockState L_TOBUKURO_FACELO = L_TOBUKURO.getDefaultState().with(Base_Tobukuro.H_FACING, state.get(H_FACING)).with(Base_Tobukuro.HALF, DoubleBlockHalf.LOWER);

		BlockState this_FACEUP = this.getDefaultState().with(H_FACING, state.get(H_FACING)).with(HALF, DoubleBlockHalf.UPPER);
		BlockState this_FACELO = this.getDefaultState().with(H_FACING, state.get(H_FACING)).with(HALF, DoubleBlockHalf.LOWER);
		
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
					if (westBlock == L_TOBUKURO && westState.get(Base_Tobukuro.HALF) == DoubleBlockHalf.LOWER && westState.get(Base_Tobukuro.STAGE_1_5) > 1) {
						/** hit RIGHT side. **/
						if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airState);
							worldIn.setBlockState(pos.up(), airState);

							worldIn.setBlockState(new BlockPos(x - 1, y, z), westState.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(westState.get(Base_Tobukuro.STAGE_1_5) - 1)));
							worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), L_TOBUKURO_FACEUP.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(westState.get(Base_Tobukuro.STAGE_1_5) - 1))); } }
					break;

				case SOUTH:
					if (eastBlock == L_TOBUKURO && eastState.get(Base_Tobukuro.HALF) == DoubleBlockHalf.LOWER && eastState.get(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airState);
							worldIn.setBlockState(pos.up(), airState);

							worldIn.setBlockState(new BlockPos(x + 1, y, z), eastState.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(eastState.get(Base_Tobukuro.STAGE_1_5) - 1)));
							worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), L_TOBUKURO_FACEUP.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(eastState.get(Base_Tobukuro.STAGE_1_5) - 1))); } }
					break;

				case EAST:
					if (northBlock == L_TOBUKURO && northState.get(Base_Tobukuro.HALF) == DoubleBlockHalf.LOWER && northState.get(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airState);
							worldIn.setBlockState(pos.up(), airState);

							worldIn.setBlockState(new BlockPos(x, y, z - 1), northState.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(northState.get(Base_Tobukuro.STAGE_1_5) - 1)));
							worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), L_TOBUKURO_FACEUP.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(northState.get(Base_Tobukuro.STAGE_1_5) - 1))); } }
					break;
					
				case WEST:
					if (southBlock == L_TOBUKURO && southState.get(Base_Tobukuro.HALF) == DoubleBlockHalf.LOWER && southState.get(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airState);
							worldIn.setBlockState(pos.up(), airState);

							worldIn.setBlockState(new BlockPos(x, y, z + 1), southState.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(southState.get(Base_Tobukuro.STAGE_1_5) - 1)));
							worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), L_TOBUKURO_FACEUP.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(southState.get(Base_Tobukuro.STAGE_1_5) - 1))); } }
					break;
				} // switch
			} // i == 4

			/* move to RIGHT. */
			if (i < 4) {
				switch (direction) {
				case NORTH:
				default:
					/** RIGHT side is Empty. **/
					if (worldIn.getBlockState(new BlockPos(x - 1, y, z)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x - 1, y + 1, z)).getMaterial().isReplaceable()) {
						/** hit RIGHT side. **/
						if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airState);
							worldIn.setBlockState(pos.up(), airState);

							worldIn.setBlockState(new BlockPos(x - 1, y, z), state.with(STAGE_1_4, Integer.valueOf(i + 1)));
							worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), this_FACEUP.with(STAGE_1_4, Integer.valueOf(i + 1))); } }
					break;

				case SOUTH:
					if (worldIn.getBlockState(new BlockPos(x + 1, y, z)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x + 1, y + 1, z)).getMaterial().isReplaceable()) {
						if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airState);
							worldIn.setBlockState(pos.up(), airState);

							worldIn.setBlockState(new BlockPos(x + 1, y, z), state.with(STAGE_1_4, Integer.valueOf(i + 1)));
							worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), this_FACEUP.with(STAGE_1_4, Integer.valueOf(i + 1))); } }
					break;

				case EAST:
					if (worldIn.getBlockState(new BlockPos(x, y, z - 1)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x, y + 1, z - 1)).getMaterial().isReplaceable()) {
						if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airState);
							worldIn.setBlockState(pos.up(), airState);

							worldIn.setBlockState(new BlockPos(x, y, z - 1), state.with(STAGE_1_4, Integer.valueOf(i + 1)));
							worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), this_FACEUP.with(STAGE_1_4, Integer.valueOf(i + 1))); } }
					break;
					
				case WEST:
					if (worldIn.getBlockState(new BlockPos(x, y, z + 1)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x, y + 1, z + 1)).getMaterial().isReplaceable()) {
						if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airState);
							worldIn.setBlockState(pos.up(), airState);

							worldIn.setBlockState(new BlockPos(x, y, z + 1), state.with(STAGE_1_4, Integer.valueOf(i + 1)));
							worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), this_FACEUP.with(STAGE_1_4, Integer.valueOf(i + 1))); } }
					break;
				} // switch
			} // i < 4
			
			/** move to Left.________________________________________________________________________________ **/
			/* Stored in TOBUKURO.*/
			if (i == 1) {
				switch (direction) {
				case NORTH:
				default:
					/** LEFT side is TOBUKURO. **/
					if (eastBlock == TOBUKURO && eastState.get(Base_Tobukuro.HALF) == DoubleBlockHalf.LOWER && eastState.get(Base_Tobukuro.STAGE_1_5) > 1) {
						/** hit LEFT side **/
						if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airState);
							worldIn.setBlockState(pos.up(), airState);

							worldIn.setBlockState(new BlockPos(x + 1, y, z), eastState.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(eastState.get(Base_Tobukuro.STAGE_1_5) - 1)));
							worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), TOBUKURO_FACEUP.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(eastState.get(Base_Tobukuro.STAGE_1_5) - 1))); } }
					break;

				case SOUTH:
					if (westBlock == TOBUKURO && westState.get(Base_Tobukuro.HALF) == DoubleBlockHalf.LOWER && westState.get(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airState);
							worldIn.setBlockState(pos.up(), airState);

							worldIn.setBlockState(new BlockPos(x - 1, y, z), westState.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(westState.get(Base_Tobukuro.STAGE_1_5) - 1)));
							worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), TOBUKURO_FACEUP.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(westState.get(Base_Tobukuro.STAGE_1_5) - 1))); } }
					break;

				case EAST:
					if (southBlock == TOBUKURO && southState.get(Base_Tobukuro.HALF) == DoubleBlockHalf.LOWER && southState.get(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airState);
							worldIn.setBlockState(pos.up(), airState);

							worldIn.setBlockState(new BlockPos(x, y, z + 1), southState.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(southState.get(Base_Tobukuro.STAGE_1_5) - 1)));
							worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), TOBUKURO_FACEUP.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(southState.get(Base_Tobukuro.STAGE_1_5) - 1))); } }
					break;
					
				case WEST:
					if (northBlock == TOBUKURO && northState.get(Base_Tobukuro.HALF) == DoubleBlockHalf.LOWER && northState.get(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airState);
							worldIn.setBlockState(pos.up(), airState);

							worldIn.setBlockState(new BlockPos(x, y, z - 1), northState.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(northState.get(Base_Tobukuro.STAGE_1_5) - 1)));
							worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), TOBUKURO_FACEUP.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(northState.get(Base_Tobukuro.STAGE_1_5) - 1))); } }
					break;
				} // switch
			} // i == 1

			/* move to LEFT. */
			if (i > 1) {
				switch (direction) {
				case NORTH:
				default:
					if (worldIn.getBlockState(new BlockPos(x + 1, y, z)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x + 1, y + 1, z)).getMaterial().isReplaceable()) {
						if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airState);
							worldIn.setBlockState(pos.up(), airState);

							worldIn.setBlockState(new BlockPos(x + 1, y, z), state.with(STAGE_1_4, Integer.valueOf(i - 1)));
							worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), this_FACEUP.with(STAGE_1_4, Integer.valueOf(i - 1))); } }
					break;

				case SOUTH:
					if (worldIn.getBlockState(new BlockPos(x - 1, y, z)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x - 1, y + 1, z)).getMaterial().isReplaceable()) {
						if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airState);
							worldIn.setBlockState(pos.up(), airState);

							worldIn.setBlockState(new BlockPos(x - 1, y, z), state.with(STAGE_1_4, Integer.valueOf(i - 1)));
							worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), this_FACEUP.with(STAGE_1_4, Integer.valueOf(i - 1))); } }
					break;

				case EAST:
					if (worldIn.getBlockState(new BlockPos(x, y, z + 1)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x, y + 1, z + 1)).getMaterial().isReplaceable()) {
						if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airState);
							worldIn.setBlockState(pos.up(), airState);

							worldIn.setBlockState(new BlockPos(x, y, z + 1), state.with(STAGE_1_4, Integer.valueOf(i - 1)));
							worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), this_FACEUP.with(STAGE_1_4, Integer.valueOf(i - 1))); } }
					break;
					
				case WEST:
					if (worldIn.getBlockState(new BlockPos(x, y, z - 1)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x, y + 1, z - 1)).getMaterial().isReplaceable()) {
						if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airState);
							worldIn.setBlockState(pos.up(), airState);

							worldIn.setBlockState(new BlockPos(x, y, z - 1), state.with(STAGE_1_4, Integer.valueOf(i - 1)));
							worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), this_FACEUP.with(STAGE_1_4, Integer.valueOf(i - 1))); } }
					break;
				} // switch
			}
			break;

		case UPPER:
			/** move to RIGHT.________________________________________________________________________________ **/
			/* Stored in TOBUKURO. */
			if (i == 4) {
				switch (direction) {
				case NORTH:
				default:
					/** RIGHT side is TOBUKURO. **/
					if (westBlock == L_TOBUKURO && westState.get(Base_Tobukuro.HALF) == DoubleBlockHalf.UPPER && westState.get(Base_Tobukuro.STAGE_1_5) > 1) {
						/** hit RIGHT side. **/
						if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airState);
							worldIn.setBlockState(pos.down(), airState);

							worldIn.setBlockState(new BlockPos(x - 1, y, z), westState.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(westState.get(Base_Tobukuro.STAGE_1_5) - 1)));
							worldIn.setBlockState(new BlockPos(x - 1, y - 1, z), L_TOBUKURO_FACELO.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(westState.get(Base_Tobukuro.STAGE_1_5) - 1))); } }
					break;

				case SOUTH:
					if (eastBlock == L_TOBUKURO && eastState.get(Base_Tobukuro.HALF) == DoubleBlockHalf.UPPER && eastState.get(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airState);
							worldIn.setBlockState(pos.down(), airState);

							worldIn.setBlockState(new BlockPos(x + 1, y, z), eastState.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(eastState.get(Base_Tobukuro.STAGE_1_5) - 1)));
							worldIn.setBlockState(new BlockPos(x + 1, y - 1, z), L_TOBUKURO_FACELO.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(eastState.get(Base_Tobukuro.STAGE_1_5) - 1))); } }
					break;

				case EAST:
					if (northBlock == L_TOBUKURO && northState.get(Base_Tobukuro.HALF) == DoubleBlockHalf.UPPER && northState.get(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airState);
							worldIn.setBlockState(pos.down(), airState);

							worldIn.setBlockState(new BlockPos(x, y, z - 1), northState.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(northState.get(Base_Tobukuro.STAGE_1_5) - 1)));
							worldIn.setBlockState(new BlockPos(x, y - 1, z - 1), L_TOBUKURO_FACELO.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(northState.get(Base_Tobukuro.STAGE_1_5) - 1))); } }
					break;
					
				case WEST:
					if (southBlock == L_TOBUKURO && southState.get(Base_Tobukuro.HALF) == DoubleBlockHalf.UPPER && southState.get(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airState);
							worldIn.setBlockState(pos.down(), airState);

							worldIn.setBlockState(new BlockPos(x, y, z + 1), southState.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(southState.get(Base_Tobukuro.STAGE_1_5) - 1)));
							worldIn.setBlockState(new BlockPos(x, y - 1, z + 1), L_TOBUKURO_FACELO.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(southState.get(Base_Tobukuro.STAGE_1_5) - 1))); } }
					break;
				} // switch
			} // i == 4

			/* move to RIGHT. */
			if (i < 4) {
				switch (direction) {
				case NORTH:
				default:
					/** RIGHT side is Empty. **/
					if (worldIn.getBlockState(new BlockPos(x - 1, y, z)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x - 1, y - 1, z)).getMaterial().isReplaceable()) {
						/** hit RIGHT side. **/
						if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airState);
							worldIn.setBlockState(pos.down(), airState);

							worldIn.setBlockState(new BlockPos(x - 1, y, z), state.with(STAGE_1_4, Integer.valueOf(i + 1)));
							worldIn.setBlockState(new BlockPos(x - 1, y - 1, z), this_FACELO.with(STAGE_1_4, Integer.valueOf(i + 1))); } }
					break;

				case SOUTH:
					if (worldIn.getBlockState(new BlockPos(x + 1, y, z)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x + 1, y - 1, z)).getMaterial().isReplaceable()) {
						if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airState);
							worldIn.setBlockState(pos.down(), airState);

							worldIn.setBlockState(new BlockPos(x + 1, y, z), state.with(STAGE_1_4, Integer.valueOf(i + 1)));
							worldIn.setBlockState(new BlockPos(x + 1, y - 1, z), this_FACELO.with(STAGE_1_4, Integer.valueOf(i + 1))); } }
					break;

				case EAST:
					if (worldIn.getBlockState(new BlockPos(x, y, z - 1)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x, y - 1, z - 1)).getMaterial().isReplaceable()) {
						if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airState);
							worldIn.setBlockState(pos.down(), airState);

							worldIn.setBlockState(new BlockPos(x, y, z - 1), state.with(STAGE_1_4, Integer.valueOf(i + 1)));
							worldIn.setBlockState(new BlockPos(x, y - 1, z - 1), this_FACELO.with(STAGE_1_4, Integer.valueOf(i + 1))); } }
					break;
					
				case WEST:
					if (worldIn.getBlockState(new BlockPos(x, y, z + 1)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x, y - 1, z + 1)).getMaterial().isReplaceable()) {
						if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airState);
							worldIn.setBlockState(pos.down(), airState);

							worldIn.setBlockState(new BlockPos(x, y, z + 1), state.with(STAGE_1_4, Integer.valueOf(i + 1)));
							worldIn.setBlockState(new BlockPos(x, y - 1, z + 1), this_FACELO.with(STAGE_1_4, Integer.valueOf(i + 1))); } }
					break;
				} // switch
			} // i < 4
			
			/** move to LEFT.________________________________________________________________________________ **/
			/* Stored in TOBUKURO.*/
			if (i == 1) {
				switch (direction) {
				case NORTH:
				default:
					/** LEFT side is TOBUKURO. **/
					if (eastBlock == TOBUKURO && eastState.get(Base_Tobukuro.HALF) == DoubleBlockHalf.UPPER && eastState.get(Base_Tobukuro.STAGE_1_5) > 1) {
						/** hit LEFT side **/
						if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airState);
							worldIn.setBlockState(pos.down(), airState);

							worldIn.setBlockState(new BlockPos(x + 1, y, z), eastState.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(eastState.get(Base_Tobukuro.STAGE_1_5) - 1)));
							worldIn.setBlockState(new BlockPos(x + 1, y - 1, z), TOBUKURO_FACELO.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(eastState.get(Base_Tobukuro.STAGE_1_5) - 1))); } }
					break;

				case SOUTH:
					if (westBlock == TOBUKURO && westState.get(Base_Tobukuro.HALF) == DoubleBlockHalf.UPPER && westState.get(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airState);
							worldIn.setBlockState(pos.down(), airState);

							worldIn.setBlockState(new BlockPos(x - 1, y, z), westState.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(westState.get(Base_Tobukuro.STAGE_1_5) - 1)));
							worldIn.setBlockState(new BlockPos(x - 1, y - 1, z), TOBUKURO_FACELO.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(westState.get(Base_Tobukuro.STAGE_1_5) - 1))); } }
					break;

				case EAST:
					if (southBlock == TOBUKURO && southState.get(Base_Tobukuro.HALF) == DoubleBlockHalf.UPPER && southState.get(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airState);
							worldIn.setBlockState(pos.down(), airState);

							worldIn.setBlockState(new BlockPos(x, y, z + 1), southState.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(southState.get(Base_Tobukuro.STAGE_1_5) - 1)));
							worldIn.setBlockState(new BlockPos(x, y - 1, z + 1), TOBUKURO_FACELO.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(southState.get(Base_Tobukuro.STAGE_1_5) - 1))); } }
					break;
					
				case WEST:
					if (northBlock == TOBUKURO && northState.get(Base_Tobukuro.HALF) == DoubleBlockHalf.UPPER && northState.get(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airState);
							worldIn.setBlockState(pos.down(), airState);

							worldIn.setBlockState(new BlockPos(x, y, z - 1), northState.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(northState.get(Base_Tobukuro.STAGE_1_5) - 1)));
							worldIn.setBlockState(new BlockPos(x, y - 1, z - 1), TOBUKURO_FACELO.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(northState.get(Base_Tobukuro.STAGE_1_5) - 1))); } }
					break;
				} // switch
			} // i == 1

			/* move to LEFT. */
			if (i > 1) {
				switch (direction) {
				case NORTH:
				default:
					/** LEFT side is Empty. **/
					if (worldIn.getBlockState(new BlockPos(x + 1, y, z)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x + 1, y - 1, z)).getMaterial().isReplaceable()) {
						/** hit LEFT side **/
						if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airState);
							worldIn.setBlockState(pos.down(), airState);

							worldIn.setBlockState(new BlockPos(x + 1, y, z), state.with(STAGE_1_4, Integer.valueOf(i - 1)));
							worldIn.setBlockState(new BlockPos(x + 1, y - 1, z), this_FACELO.with(STAGE_1_4, Integer.valueOf(i - 1))); } }
					break;

				case SOUTH:
					if (worldIn.getBlockState(new BlockPos(x - 1, y, z)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x - 1, y - 1, z)).getMaterial().isReplaceable()) {
						if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airState);
							worldIn.setBlockState(pos.down(), airState);

							worldIn.setBlockState(new BlockPos(x - 1, y, z), state.with(STAGE_1_4, Integer.valueOf(i - 1)));
							worldIn.setBlockState(new BlockPos(x - 1, y - 1, z), this_FACELO.with(STAGE_1_4, Integer.valueOf(i - 1))); } }
					break;

				case EAST:
					if (worldIn.getBlockState(new BlockPos(x, y, z + 1)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x, y - 1, z + 1)).getMaterial().isReplaceable()) {
						if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airState);
							worldIn.setBlockState(pos.down(), airState);

							worldIn.setBlockState(new BlockPos(x, y, z + 1), state.with(STAGE_1_4, Integer.valueOf(i - 1)));
							worldIn.setBlockState(new BlockPos(x, y - 1, z + 1), this_FACELO.with(STAGE_1_4, Integer.valueOf(i - 1))); } }
					break;
					
				case WEST:
					if (worldIn.getBlockState(new BlockPos(x, y, z - 1)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x, y - 1, z - 1)).getMaterial().isReplaceable()) {
						if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airState);
							worldIn.setBlockState(pos.down(), airState);

							worldIn.setBlockState(new BlockPos(x, y, z - 1), state.with(STAGE_1_4, Integer.valueOf(i - 1)));
							worldIn.setBlockState(new BlockPos(x, y - 1, z - 1), this_FACELO.with(STAGE_1_4, Integer.valueOf(i - 1))); } }
					break;
				} // switch
			}
			break;
		} // switch LOWER-UPPER

		return ActionResultType.SUCCESS;
	}

	private Block takeBlock() {
		if (this == Slidedoor_Blocks.AMADO) { return Slidedoor_Blocks.TOBUKURO; }
		if (this == Slidedoor_Blocks.AMADO_S) { return Slidedoor_Blocks.TOBUKURO_S; }
		return null;
	}
	
	private Block takeBlockL() {
		if (this == Slidedoor_Blocks.AMADO) { return Slidedoor_Blocks.TOBUKURO_L; }
		if (this == Slidedoor_Blocks.AMADO_S) { return Slidedoor_Blocks.TOBUKURO_SL; }
		return null;
	}
	
	/* Gives a value when placed. +180 .getOpposite() */
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getWorld();
		BlockPos pos = context.getPos();
		IFluidState fluid = worldIn.getFluidState(pos);
		
		return this.getDefaultState().with(WATERLOGGED, fluid.getFluid() == Fluids.WATER)
				.with(H_FACING, context.getPlacementHorizontalFacing().getOpposite());
	}

	/* HORIZONTAL Property */
	@Override
	public BlockState rotate(BlockState state, Rotation rotation) {
		return state.with(H_FACING, rotation.rotate(state.get(H_FACING)));
	}

	@Override
	public BlockState mirror(BlockState state, Mirror mirror) {
		return state.rotate(mirror.toRotation(state.get(H_FACING)));
	}

	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
		}
		return super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
	}
	
	/* Destroy at the same time. & Drop item. */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {

		BlockState upState = worldIn.getBlockState(pos.up());
		BlockState downState = worldIn.getBlockState(pos.down());
		/** False is not Drop. **/
		if (upState.getBlock() == this) { worldIn.destroyBlock(pos.up(), false); }
		if (downState.getBlock() == this) { worldIn.destroyBlock(pos.down(), false); }
		super.onBlockHarvested(worldIn, pos, state, playerIn);
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items.AIR);
	}
	
	/* Create Blockstate */
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(H_FACING, HALF, STAGE_1_4, WATERLOGGED);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(H_FACING);

		switch(direction) {
		case NORTH:
		default: return AABB_NORTH;
		case SOUTH: return AABB_SOUTH;
		case WEST: return AABB_WEST;
		case EAST: return AABB_EAST;
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
