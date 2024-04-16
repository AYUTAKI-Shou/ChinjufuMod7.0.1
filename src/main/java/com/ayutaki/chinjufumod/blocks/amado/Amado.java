package com.ayutaki.chinjufumod.blocks.amado;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Slidedoor_Blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tileentity.TileEntity;
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
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

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

	public Amado(AbstractBlock.Properties properties) {
		super(properties);

		/** Default state **/
		registerDefaultState(this.defaultBlockState().setValue(H_FACING, Direction.NORTH)
				.setValue(STAGE_1_4, Integer.valueOf(1))
				.setValue(HALF, DoubleBlockHalf.LOWER)
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		int i = state.getValue(STAGE_1_4);
		Direction direction = state.getValue(H_FACING);
		DoubleBlockHalf half = state.getValue(HALF);
		Direction facing = playerIn.getDirection();

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
					if (worldIn.getBlockState(new BlockPos(x - 1, y, z)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x - 1, y + 1, z)).getMaterial().isReplaceable()) {
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
					if (worldIn.getBlockState(new BlockPos(x + 1, y, z)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x + 1, y + 1, z)).getMaterial().isReplaceable()) {
						if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() > 0.55D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.above(), airState, 3);

							worldIn.setBlock(new BlockPos(x + 1, y, z), state.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3);
							worldIn.setBlock(new BlockPos(x + 1, y + 1, z), this_FACEUP.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3); } }
					break;

				case EAST:
					if (worldIn.getBlockState(new BlockPos(x, y, z - 1)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x, y + 1, z - 1)).getMaterial().isReplaceable()) {
						if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() < 0.45D)) || (facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.above(), airState, 3);

							worldIn.setBlock(new BlockPos(x, y, z - 1), state.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3);
							worldIn.setBlock(new BlockPos(x, y + 1, z - 1), this_FACEUP.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3); } }
					break;
					
				case WEST:
					if (worldIn.getBlockState(new BlockPos(x, y, z + 1)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x, y + 1, z + 1)).getMaterial().isReplaceable()) {
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
					if (worldIn.getBlockState(new BlockPos(x + 1, y, z)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x + 1, y + 1, z)).getMaterial().isReplaceable()) {
						if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() > 0.55D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.above(), airState, 3);

							worldIn.setBlock(new BlockPos(x + 1, y, z), state.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3);
							worldIn.setBlock(new BlockPos(x + 1, y + 1, z), this_FACEUP.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3); } }
					break;

				case SOUTH:
					if (worldIn.getBlockState(new BlockPos(x - 1, y, z)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x - 1, y + 1, z)).getMaterial().isReplaceable()) {
						if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() < 0.45D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.above(), airState, 3);

							worldIn.setBlock(new BlockPos(x - 1, y, z), state.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3);
							worldIn.setBlock(new BlockPos(x - 1, y + 1, z), this_FACEUP.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3); } }
					break;

				case EAST:
					if (worldIn.getBlockState(new BlockPos(x, y, z + 1)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x, y + 1, z + 1)).getMaterial().isReplaceable()) {
						if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() > 0.55D)) || (facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.above(), airState, 3);

							worldIn.setBlock(new BlockPos(x, y, z + 1), state.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3);
							worldIn.setBlock(new BlockPos(x, y + 1, z + 1), this_FACEUP.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3); } }
					break;
					
				case WEST:
					if (worldIn.getBlockState(new BlockPos(x, y, z - 1)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x, y + 1, z - 1)).getMaterial().isReplaceable()) {
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
					if (worldIn.getBlockState(new BlockPos(x - 1, y, z)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x - 1, y - 1, z)).getMaterial().isReplaceable()) {
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
					if (worldIn.getBlockState(new BlockPos(x + 1, y, z)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x + 1, y - 1, z)).getMaterial().isReplaceable()) {
						if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() > 0.55D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.below(), airState, 3);

							worldIn.setBlock(new BlockPos(x + 1, y, z), state.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3);
							worldIn.setBlock(new BlockPos(x + 1, y - 1, z), this_FACELO.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3); } }
					break;

				case EAST:
					if (worldIn.getBlockState(new BlockPos(x, y, z - 1)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x, y - 1, z - 1)).getMaterial().isReplaceable()) {
						if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() < 0.45D)) || (facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.below(), airState, 3);

							worldIn.setBlock(new BlockPos(x, y, z - 1), state.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3);
							worldIn.setBlock(new BlockPos(x, y - 1, z - 1), this_FACELO.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3); } }
					break;
					
				case WEST:
					if (worldIn.getBlockState(new BlockPos(x, y, z + 1)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x, y - 1, z + 1)).getMaterial().isReplaceable()) {
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
					if (worldIn.getBlockState(new BlockPos(x + 1, y, z)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x + 1, y - 1, z)).getMaterial().isReplaceable()) {
						if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() > 0.55D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.below(), airState, 3);

							worldIn.setBlock(new BlockPos(x + 1, y, z), state.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3);
							worldIn.setBlock(new BlockPos(x + 1, y - 1, z), this_FACELO.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3); } }
					break;

				case SOUTH:
					if (worldIn.getBlockState(new BlockPos(x - 1, y, z)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x - 1, y - 1, z)).getMaterial().isReplaceable()) {
						if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() < 0.45D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.below(), airState, 3);

							worldIn.setBlock(new BlockPos(x - 1, y, z), state.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3);
							worldIn.setBlock(new BlockPos(x - 1, y - 1, z), this_FACELO.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3); } }
					break;

				case EAST:
					if (worldIn.getBlockState(new BlockPos(x, y, z + 1)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x, y - 1, z + 1)).getMaterial().isReplaceable()) {
						if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() > 0.55D)) || (facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, airState, 3);
							worldIn.setBlock(pos.below(), airState, 3);

							worldIn.setBlock(new BlockPos(x, y, z + 1), state.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3);
							worldIn.setBlock(new BlockPos(x, y - 1, z + 1), this_FACELO.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3); } }
					break;
					
				case WEST:
					if (worldIn.getBlockState(new BlockPos(x, y, z - 1)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x, y - 1, z - 1)).getMaterial().isReplaceable()) {
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
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);

		return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER))
				.setValue(H_FACING, context.getHorizontalDirection().getOpposite());
	}

	/* Limit the place. */
	@Override
	public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
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
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.getValue(WATERLOGGED)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }
		
		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}

	/* Destroy a DoubleBlock from DoublePlantBlock.class */
	@Override
	public void playerWillDestroy(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {

		if (!worldIn.isClientSide) {
			if (playerIn.isCreative()) { creativeDrop(worldIn, pos, state, playerIn); }
			else { notCreativeDrop(worldIn, pos, state, playerIn); }
		}
		super.playerWillDestroy(worldIn, pos, state, playerIn);
	}

	@Override
	public void playerDestroy(World worldIn, PlayerEntity playerIn, BlockPos pos, BlockState state, @Nullable TileEntity te, ItemStack stack) {
		super.playerDestroy(worldIn, playerIn, pos, Blocks.AIR.defaultBlockState(), te, stack);
	}

	protected static void creativeDrop(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {
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

	protected static void notCreativeDrop(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {
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
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items.AIR);
	}

	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(H_FACING, HALF, STAGE_1_4, WATERLOGGED);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.getValue(H_FACING);

		switch (direction) {
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
}
