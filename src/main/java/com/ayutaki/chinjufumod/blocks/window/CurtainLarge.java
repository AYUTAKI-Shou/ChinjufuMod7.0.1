package com.ayutaki.chinjufumod.blocks.window;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.handler.CMEvents;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.PushReaction;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.DoorHingeSide;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

public class CurtainLarge extends CM_WaterLogged {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final BooleanProperty OPEN = BooleanProperty.create("open");
	public static final EnumProperty<DoorHingeSide> HINGE = EnumProperty.create("hinge", DoorHingeSide.class);
	public static final EnumProperty<DoubleBlockHalf> HALF = EnumProperty.create("half", DoubleBlockHalf.class);
	public static final IntegerProperty STAGE_1_2 = IntegerProperty.create("stage", 1, 2);

	/* Collision */
	protected static final VoxelShape CLOSE_NORTH = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D);
	protected static final VoxelShape CLOSE_EAST = Block.box(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape CLOSE_SOUTH = Block.box(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape CLOSE_WEST = Block.box(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D);

	protected static final VoxelShape RAIL_NORTH = Block.box(0.0D, 15.25D, 0.0D, 16.0D, 16.0D, 0.75D);
	protected static final VoxelShape RAIL_EAST = Block.box(15.25D, 15.25D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape RAIL_SOUTH = Block.box(0.0D, 15.25D, 15.25D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape RAIL_WEST = Block.box(0.0D, 15.25D, 0.0D, 0.75D, 16.0D, 16.0D);
	
	protected static final VoxelShape OPENR_NORTH = Block.box(13.5D, 0.0D, 0.0D, 16.0D, 16.0D, 2.6D);
	protected static final VoxelShape OPENR_EAST = Block.box(13.4D, 0.0D, 13.5D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape OPENR_SOUTH = Block.box(0.0D, 0.0D, 13.4D, 2.5D, 16.0D, 16.0D);
	protected static final VoxelShape OPENR_WEST = Block.box(0.0D, 0.0D, 0.0D, 2.6D, 16.0D, 2.5D);

	protected static final VoxelShape OPENL_NORTH = Block.box(0.0D, 0.0D, 0.0D, 2.5D, 16.0D, 2.6D);
	protected static final VoxelShape OPENL_EAST = Block.box(13.4D, 0.0D, 0.0D, 16.0D, 16.0D, 2.5D);
	protected static final VoxelShape OPENL_SOUTH = Block.box(13.5D, 0.0D, 13.4D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape OPENL_WEST = Block.box(0.0D, 0.0D, 13.5D, 2.6D, 16.0D, 16.0D);

	public CurtainLarge(AbstractBlock.Properties properties) {
		super(properties);

		/** Default state **/
		registerDefaultState(this.defaultBlockState().setValue(H_FACING, Direction.NORTH)
				.setValue(STAGE_1_2, Integer.valueOf(1))
				.setValue(OPEN, Boolean.valueOf(false))
				.setValue(HINGE, DoorHingeSide.LEFT)
				.setValue(HALF, DoubleBlockHalf.UPPER)
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {
		// if (item instanceof Base_ItemHake) { return ActionResultType.PASS; } Too Complex.

		int i = state.getValue(STAGE_1_2);
		Direction direction = state.getValue(H_FACING);
		DoubleBlockHalf half = state.getValue(HALF);
		DoorHingeSide hinge = state.getValue(HINGE);

		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();

		CMEvents.soundCurtain(worldIn, pos, 0.8F, 0.8F);
		
		boolean flag = state.getValue(OPEN)? false : true;

		BlockState directFlag = this.defaultBlockState().setValue(H_FACING, direction).setValue(OPEN, Boolean.valueOf(flag));
		
		BlockState Up_LEFT1 = directFlag.setValue(STAGE_1_2, Integer.valueOf(1)).setValue(HALF, DoubleBlockHalf.UPPER).setValue(HINGE, DoorHingeSide.LEFT);
		BlockState Low_LEFT1 = directFlag.setValue(STAGE_1_2, Integer.valueOf(1)).setValue(HALF, DoubleBlockHalf.LOWER).setValue(HINGE, DoorHingeSide.LEFT);
		BlockState Up_LEFT2 = directFlag.setValue(STAGE_1_2, Integer.valueOf(2)).setValue(HALF, DoubleBlockHalf.UPPER).setValue(HINGE, DoorHingeSide.LEFT);
		BlockState Low_LEFT2 = directFlag.setValue(STAGE_1_2, Integer.valueOf(2)).setValue(HALF, DoubleBlockHalf.LOWER).setValue(HINGE, DoorHingeSide.LEFT);
		
		BlockState Up_RIGHT1 = directFlag.setValue(STAGE_1_2, Integer.valueOf(1)).setValue(HALF, DoubleBlockHalf.UPPER).setValue(HINGE, DoorHingeSide.RIGHT);
		BlockState Low_RIGHT1 = directFlag.setValue(STAGE_1_2, Integer.valueOf(1)).setValue(HALF, DoubleBlockHalf.LOWER).setValue(HINGE, DoorHingeSide.RIGHT);
		BlockState Up_RIGHT2 = directFlag.setValue(STAGE_1_2, Integer.valueOf(2)).setValue(HALF, DoubleBlockHalf.UPPER).setValue(HINGE, DoorHingeSide.RIGHT);
		BlockState Low_RIGHT2 = directFlag.setValue(STAGE_1_2, Integer.valueOf(2)).setValue(HALF, DoubleBlockHalf.LOWER).setValue(HINGE, DoorHingeSide.RIGHT);

		///// STAGE_1 ////////////////////
		switch (i) {
		case 1 :
		default :
			switch (half) {
			case LOWER :
			default :
				switch (hinge) {
				case LEFT :
				default :
					worldIn.setBlock(pos.above(), Up_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.above()).getType() == Fluids.WATER)), 3);
					worldIn.setBlock(pos, Low_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos).getType() == Fluids.WATER)), 3);
					
					switch (direction) {
					case NORTH :
					default :
						worldIn.setBlock(new BlockPos(x - 1, y + 1, z), Up_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y + 1, z)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x - 1, y, z), Low_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y, z)).getType() == Fluids.WATER)), 3);
						break;

					case SOUTH :
						worldIn.setBlock(new BlockPos(x + 1, y + 1, z), Up_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y + 1, z)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x + 1, y, z), Low_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y, z)).getType() == Fluids.WATER)), 3);
						break;

					case EAST :
						worldIn.setBlock(new BlockPos(x, y + 1, z - 1), Up_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z - 1)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x, y, z - 1), Low_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z - 1)).getType() == Fluids.WATER)), 3);
						break;
						
					case WEST :
						worldIn.setBlock(new BlockPos(x, y + 1, z + 1), Up_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z + 1)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x, y, z + 1), Low_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z + 1)).getType() == Fluids.WATER)), 3);
						break;
					} // direction
					break;

				case RIGHT :
					worldIn.setBlock(pos.above(), Up_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.above()).getType() == Fluids.WATER)), 3);
					worldIn.setBlock(pos, Low_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos).getType() == Fluids.WATER)), 3);

					switch (direction) {
					case NORTH :
					default :
						worldIn.setBlock(new BlockPos(x + 1, y + 1, z), Up_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y + 1, z)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x + 1, y, z), Low_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y, z)).getType() == Fluids.WATER)), 3);
						break;

					case SOUTH :
						worldIn.setBlock(new BlockPos(x - 1, y + 1, z), Up_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y + 1, z)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x - 1, y, z), Low_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y, z)).getType() == Fluids.WATER)), 3);
						break;

					case EAST :
						worldIn.setBlock(new BlockPos(x, y + 1, z + 1), Up_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z + 1)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x, y, z + 1), Low_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z + 1)).getType() == Fluids.WATER)), 3);
						break;
						
					case WEST :
						worldIn.setBlock(new BlockPos(x, y + 1, z - 1), Up_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z - 1)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x, y, z - 1), Low_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z - 1)).getType() == Fluids.WATER)), 3);
						break;
					} // direction
					break;
				} // LEFT-RIGHT
				break;


			case UPPER :
				switch (hinge) {
				case LEFT :
				default :
					worldIn.setBlock(pos, Up_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos).getType() == Fluids.WATER)), 3);
					worldIn.setBlock(pos.below(), Low_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.below()).getType() == Fluids.WATER)), 3);

					switch (direction) {
					case NORTH :
					default :
						worldIn.setBlock(new BlockPos(x - 1, y, z), Up_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y, z)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x - 1, y - 1, z), Low_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y - 1, z)).getType() == Fluids.WATER)), 3);
						break;

					case SOUTH :
						worldIn.setBlock(new BlockPos(x + 1, y, z), Up_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y, z)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x + 1, y - 1, z), Low_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y - 1, z)).getType() == Fluids.WATER)), 3);
						break;

					case EAST :
						worldIn.setBlock(new BlockPos(x, y, z - 1), Up_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z - 1)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x, y - 1, z - 1), Low_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y - 1, z - 1)).getType() == Fluids.WATER)), 3);
						break;
						
					case WEST :
						worldIn.setBlock(new BlockPos(x, y, z + 1), Up_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z + 1)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x, y - 1, z + 1), Low_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y - 1, z + 1)).getType() == Fluids.WATER)), 3);
						break;
					} // direction
					break;

				case RIGHT :
					worldIn.setBlock(pos, Up_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos).getType() == Fluids.WATER)), 3);
					worldIn.setBlock(pos.below(), Low_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.below()).getType() == Fluids.WATER)), 3);

					switch (direction) {
					case NORTH :
					default :
						worldIn.setBlock(new BlockPos(x + 1, y, z), Up_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y, z)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x + 1, y - 1, z), Low_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y - 1, z)).getType() == Fluids.WATER)), 3);
						break;

					case SOUTH :
						worldIn.setBlock(new BlockPos(x - 1, y, z), Up_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y, z)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x - 1, y - 1, z), Low_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y - 1, z)).getType() == Fluids.WATER)), 3);
						break;

					case EAST :
						worldIn.setBlock(new BlockPos(x, y, z + 1), Up_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z + 1)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x, y - 1, z + 1), Low_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y - 1, z + 1)).getType() == Fluids.WATER)), 3);
						break;
						
					case WEST :
						worldIn.setBlock(new BlockPos(x, y, z - 1), Up_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z - 1)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x, y - 1, z - 1), Low_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y - 1, z - 1)).getType() == Fluids.WATER)), 3);
						break;
					} // direction
					break;
				} // LEFT-RIGHT
				break;
			} // LOWER-UPPER
			break;


		///// STAGE_2 ////////////////////
		case 2 :
			switch (half) {
			case LOWER :
			default :
				switch (hinge) {
				case LEFT :
				default :
					worldIn.setBlock(pos.above(), Up_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.above()).getType() == Fluids.WATER)), 3);
					worldIn.setBlock(pos, Low_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos).getType() == Fluids.WATER)), 3);

					switch (direction) {
					case NORTH :
					default :
						worldIn.setBlock(new BlockPos(x + 1, y + 1, z), Up_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y + 1, z)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x + 1, y, z), Low_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y, z)).getType() == Fluids.WATER)), 3);
						break;

					case SOUTH :
						worldIn.setBlock(new BlockPos(x - 1, y + 1, z), Up_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y + 1, z)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x - 1, y, z), Low_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y, z)).getType() == Fluids.WATER)), 3);
						break;

					case EAST :
						worldIn.setBlock(new BlockPos(x, y + 1, z + 1), Up_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z + 1)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x, y, z + 1), Low_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z + 1)).getType() == Fluids.WATER)), 3);
						break;
						
					case WEST :
						worldIn.setBlock(new BlockPos(x, y + 1, z - 1), Up_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z - 1)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x, y, z - 1), Low_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z - 1)).getType() == Fluids.WATER)), 3);
						break;
					} // direction
					break;

				case RIGHT :
					worldIn.setBlock(pos.above(), Up_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.above()).getType() == Fluids.WATER)), 3);
					worldIn.setBlock(pos, Low_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos).getType() == Fluids.WATER)), 3);

					switch (direction) {
					case NORTH :
					default :
						worldIn.setBlock(new BlockPos(x - 1, y + 1, z), Up_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y + 1, z)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x - 1, y, z), Low_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y, z)).getType() == Fluids.WATER)), 3);
						break;

					case SOUTH :
						worldIn.setBlock(new BlockPos(x + 1, y + 1, z), Up_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y + 1, z)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x + 1, y, z), Low_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y, z)).getType() == Fluids.WATER)), 3);
						break;

					case EAST :
						worldIn.setBlock(new BlockPos(x, y + 1, z - 1), Up_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z - 1)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x, y, z - 1), Low_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z - 1)).getType() == Fluids.WATER)), 3);
						break;
						
					case WEST :
						worldIn.setBlock(new BlockPos(x, y + 1, z + 1), Up_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z + 1)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x, y, z + 1), Low_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z + 1)).getType() == Fluids.WATER)), 3);
						break;
					} // direction
					break;
				} // LEFT-RIGHT
				break;

			case UPPER :
				switch (hinge) {
				case LEFT :
				default :
					worldIn.setBlock(pos, Up_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos).getType() == Fluids.WATER)), 3);
					worldIn.setBlock(pos.below(), Low_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.below()).getType() == Fluids.WATER)), 3);

					switch (direction) {
					case NORTH :
					default :
						worldIn.setBlock(new BlockPos(x + 1, y, z), Up_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y, z)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x + 1, y - 1, z), Low_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y - 1, z)).getType() == Fluids.WATER)), 3);
						break;

					case SOUTH :
						worldIn.setBlock(new BlockPos(x - 1, y, z), Up_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y, z)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x - 1, y - 1, z), Low_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y - 1, z)).getType() == Fluids.WATER)), 3);
						break;

					case EAST :
						worldIn.setBlock(new BlockPos(x, y, z + 1), Up_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z + 1)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x, y - 1, z + 1), Low_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y - 1, z + 1)).getType() == Fluids.WATER)), 3);
						break;
						
					case WEST :
						worldIn.setBlock(new BlockPos(x, y, z - 1), Up_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z - 1)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x, y - 1, z - 1), Low_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y - 1, z - 1)).getType() == Fluids.WATER)), 3);
						break;
					} // direction
					break;

				case RIGHT :
					worldIn.setBlock(pos, Up_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos).getType() == Fluids.WATER)), 3);
					worldIn.setBlock(pos.below(), Low_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.below()).getType() == Fluids.WATER)), 3);

					switch (direction) {
					case NORTH :
					default :
						worldIn.setBlock(new BlockPos(x - 1, y, z), Up_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y, z)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x - 1, y - 1, z), Low_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y - 1, z)).getType() == Fluids.WATER)), 3);
						break;

					case SOUTH :
						worldIn.setBlock(new BlockPos(x + 1, y, z), Up_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y, z)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x + 1, y - 1, z), Low_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y - 1, z)).getType() == Fluids.WATER)), 3);
						break;

					case EAST :
						worldIn.setBlock(new BlockPos(x, y, z - 1), Up_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z - 1)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x, y - 1, z - 1), Low_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y - 1, z - 1)).getType() == Fluids.WATER)), 3);
						break;
						
					case WEST :
						worldIn.setBlock(new BlockPos(x, y, z + 1), Up_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z + 1)).getType() == Fluids.WATER)), 3);
						worldIn.setBlock(new BlockPos(x, y - 1, z + 1), Low_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y - 1, z + 1)).getType() == Fluids.WATER)), 3);
						break;
					} // direction
					break;
				} // LEFT-RIGHT
				break;
			} // LOWER-UPPER
			break;
		} // STAGE_1_2
		
		return ActionResultType.SUCCESS;
	}

	
	/* Gives a value when placed. */
	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);
		PlayerEntity playerIn = context.getPlayer();

		/** pos.up() = Replaceable block. **/
		if (worldIn.getBlockState(pos.below()).canBeReplaced(context)) {
			
			Direction facing = playerIn.getDirection();
			double x = (double) pos.getX();
			double y = (double) pos.getY();
			double z = (double) pos.getZ();
			
			BlockState directFlag = this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection())
					.setValue(STAGE_1_2, Integer.valueOf(1)).setValue(OPEN, Boolean.valueOf(false))
					.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER));
			
			BlockState Right = directFlag.setValue(HINGE, DoorHingeSide.RIGHT).setValue(HALF, DoubleBlockHalf.UPPER);
			BlockState Left = directFlag.setValue(HINGE, DoorHingeSide.LEFT).setValue(HALF, DoubleBlockHalf.UPPER);
			
			if (playerIn.isCrouching()) {
				if (facing == Direction.NORTH && worldIn.getBlockState(new BlockPos(x + 1, y, z)).canBeReplaced(context)) { return Right; }
				if (facing == Direction.SOUTH && worldIn.getBlockState(new BlockPos(x - 1, y, z)).canBeReplaced(context)) { return Right; }
				if (facing == Direction.EAST && worldIn.getBlockState(new BlockPos(x, y, z + 1)).canBeReplaced(context)) { return Right; }
				if (facing == Direction.WEST && worldIn.getBlockState(new BlockPos(x, y, z - 1)).canBeReplaced(context)) { return Right; }
				else { 
					CMEvents.textNoPlace(context.getLevel(), context.getClickedPos(), context.getPlayer());
					return null; } } //isCrouching()
			
			if (facing == Direction.NORTH && worldIn.getBlockState(new BlockPos(x - 1, y, z)).canBeReplaced(context)) { return Left; }
			if (facing == Direction.SOUTH && worldIn.getBlockState(new BlockPos(x + 1, y, z)).canBeReplaced(context)) { return Left; }
			if (facing == Direction.EAST && worldIn.getBlockState(new BlockPos(x, y, z - 1)).canBeReplaced(context)) { return Left; }
			if (facing == Direction.WEST && worldIn.getBlockState(new BlockPos(x, y, z + 1)).canBeReplaced(context)) { return Left; }
			else { 
				CMEvents.textNoPlace(context.getLevel(), context.getClickedPos(), context.getPlayer());
				return null; }
			
		} //pos.below()).canBeReplaced(context)

		else { 
			CMEvents.textNoPlace(context.getLevel(), context.getClickedPos(), context.getPlayer());
			return null; }
	}

	/* Add DoubleBlockHalf.UPPER on the Block. */
	public void setPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {

		Direction facing = placer.getDirection();
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		
		BlockState directFlag = this.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING)).setValue(OPEN, Boolean.valueOf(false));
		
		if (placer.isCrouching()) {
			BlockState Low_RIGHT1 = directFlag.setValue(STAGE_1_2, Integer.valueOf(1)).setValue(HALF, DoubleBlockHalf.LOWER).setValue(HINGE, DoorHingeSide.RIGHT);
			BlockState Up_RIGHT2 = directFlag.setValue(STAGE_1_2, Integer.valueOf(2)).setValue(HALF, DoubleBlockHalf.UPPER).setValue(HINGE, DoorHingeSide.RIGHT);
			BlockState Low_RIGHT2 = directFlag.setValue(STAGE_1_2, Integer.valueOf(2)).setValue(HALF, DoubleBlockHalf.LOWER).setValue(HINGE, DoorHingeSide.RIGHT);
			
			worldIn.setBlock(pos.below(), Low_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.below()).getType() == Fluids.WATER)), 3);

			switch (facing) {
			case NORTH :
			default :
				worldIn.setBlock(new BlockPos(x + 1, y, z), Up_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y, z)).getType() == Fluids.WATER)), 3);
				worldIn.setBlock(new BlockPos(x + 1, y - 1, z), Low_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y - 1, z)).getType() == Fluids.WATER)), 3);
				break;

			case SOUTH :
				worldIn.setBlock(new BlockPos(x - 1, y, z), Up_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y, z)).getType() == Fluids.WATER)), 3);
				worldIn.setBlock(new BlockPos(x - 1, y - 1, z), Low_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y - 1, z)).getType() == Fluids.WATER)), 3);
				break;

			case EAST :
				worldIn.setBlock(new BlockPos(x, y, z + 1), Up_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z + 1)).getType() == Fluids.WATER)), 3);
				worldIn.setBlock(new BlockPos(x, y - 1, z + 1), Low_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y - 1, z + 1)).getType() == Fluids.WATER)), 3);
				break;
				
			case WEST :
				worldIn.setBlock(new BlockPos(x, y, z - 1), Up_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z - 1)).getType() == Fluids.WATER)), 3);
				worldIn.setBlock(new BlockPos(x, y - 1, z - 1), Low_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y - 1, z - 1)).getType() == Fluids.WATER)), 3);
				break;
			} // direction
		} //placer.isCrouching()

		if (!placer.isCrouching()) {
			BlockState Low_LEFT1 = directFlag.setValue(STAGE_1_2, Integer.valueOf(1)).setValue(HALF, DoubleBlockHalf.LOWER).setValue(HINGE, DoorHingeSide.LEFT);
			BlockState Up_LEFT2 = directFlag.setValue(STAGE_1_2, Integer.valueOf(2)).setValue(HALF, DoubleBlockHalf.UPPER).setValue(HINGE, DoorHingeSide.LEFT);
			BlockState Low_LEFT2 = directFlag.setValue(STAGE_1_2, Integer.valueOf(2)).setValue(HALF, DoubleBlockHalf.LOWER).setValue(HINGE, DoorHingeSide.LEFT);
			
			worldIn.setBlock(pos.below(), Low_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.below()).getType() == Fluids.WATER)), 3);

			switch (facing) {
			case NORTH :
			default :
				worldIn.setBlock(new BlockPos(x - 1, y, z), Up_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y, z)).getType() == Fluids.WATER)), 3);
				worldIn.setBlock(new BlockPos(x - 1, y - 1, z), Low_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y - 1, z)).getType() == Fluids.WATER)), 3);
				break;

			case SOUTH :
				worldIn.setBlock(new BlockPos(x + 1, y, z), Up_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y, z)).getType() == Fluids.WATER)), 3);
				worldIn.setBlock(new BlockPos(x + 1, y - 1, z), Low_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y - 1, z)).getType() == Fluids.WATER)), 3);
				break;

			case EAST :
				worldIn.setBlock(new BlockPos(x, y, z - 1), Up_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z - 1)).getType() == Fluids.WATER)), 3);
				worldIn.setBlock(new BlockPos(x, y - 1, z - 1), Low_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y - 1, z - 1)).getType() == Fluids.WATER)), 3);
				break;
				
			case WEST :
				worldIn.setBlock(new BlockPos(x, y, z + 1), Up_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z + 1)).getType() == Fluids.WATER)), 3);
				worldIn.setBlock(new BlockPos(x, y - 1, z + 1), Low_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y - 1, z + 1)).getType() == Fluids.WATER)), 3);
				break;
			} // direction
		} //!placer.isCrouching()
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rotation) {
		return state.setValue(H_FACING, rotation.rotate(state.getValue(H_FACING)));
	}

	@SuppressWarnings("deprecation")
	public BlockState mirror(BlockState state, Mirror mirror) {
		return mirror == Mirror.NONE ? state : state.rotate(mirror.getRotation(state.getValue(H_FACING)));
	}

	/* Return a random long to be passed to {@link IBakedModel#getQuads}, used for random model rotations */
	@OnlyIn(Dist.CLIENT)
	public long getSeed(BlockState state, BlockPos pos) {
		return MathHelper.getSeed(pos.getX(), pos.below(state.getValue(HALF) == DoubleBlockHalf.LOWER ? 0 : 1).getY(), pos.getZ());
	}
	
	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		BlockState state1 = super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
		if (!state1.isAir(worldIn, pos)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }

		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}
	
	/* Create Blockstate */
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(HALF, H_FACING, OPEN, HINGE, STAGE_1_2, WATERLOGGED);
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		int i = state.getValue(STAGE_1_2);
		Direction direction = state.getValue(H_FACING);
		DoubleBlockHalf half = state.getValue(HALF);
		boolean flagopen = !state.getValue(OPEN);
		boolean flagright = (state.getValue(HINGE) == DoorHingeSide.RIGHT);
		
		switch (half) {
		case LOWER:
		default:
			switch (direction) {
			case NORTH:
			default:
				return flagopen? CLOSE_NORTH : ((i == 1)? VoxelShapes.empty() : (flagright? OPENR_NORTH : OPENL_NORTH));
			case SOUTH:
				return flagopen? CLOSE_SOUTH : ((i == 1)? VoxelShapes.empty() : (flagright? OPENR_SOUTH : OPENL_SOUTH));
			case WEST:
				return flagopen? CLOSE_WEST : ((i == 1)? VoxelShapes.empty() : (flagright? OPENR_WEST : OPENL_WEST));
			case EAST:
				return flagopen? CLOSE_EAST : ((i == 1)? VoxelShapes.empty() : (flagright? OPENR_EAST : OPENL_EAST));
			}

		case UPPER:
			switch (direction) {
			case NORTH:
			default:
				return flagopen? CLOSE_NORTH : ((i == 1)? RAIL_NORTH : (flagright? OPENR_NORTH : OPENL_NORTH));
			case SOUTH:
				return flagopen? CLOSE_SOUTH : ((i == 1)? RAIL_SOUTH : (flagright? OPENR_SOUTH : OPENL_SOUTH));
			case WEST:
				return flagopen? CLOSE_WEST : ((i == 1)? RAIL_WEST : (flagright? OPENR_WEST : OPENL_WEST));
			case EAST:
				return flagopen? CLOSE_EAST : ((i == 1)? RAIL_EAST : (flagright? OPENR_EAST : OPENL_EAST));
			}
		} // switch LOWER-UPPER
	}

	@Override
	public BlockRenderType getRenderShape(BlockState state) {
		return BlockRenderType.MODEL;
	}

	/* Controls drops when broken. End the process with "break;".*/
	public void playerWillDestroy(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {
		int i = state.getValue(STAGE_1_2);
		Direction direction = state.getValue(H_FACING);
		DoubleBlockHalf half = state.getValue(HALF);
	
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();

		boolean mode = playerIn.abilities.instabuild;
		boolean left = (state.getValue(HINGE) == DoorHingeSide.LEFT);
		
		if (!worldIn.isClientSide) {
			switch (i) {
			case 1 :
			default :
				switch (half) {
				case LOWER :
				default :
					worldIn.destroyBlock(pos, mode? false : true);
					worldIn.destroyBlock(pos.above(), false);
					
					switch (direction) {
					case NORTH :
					default :
						worldIn.destroyBlock(left? new BlockPos(x - 1, y, z) : new BlockPos(x + 1, y, z), false);
						worldIn.destroyBlock(left? new BlockPos(x - 1, y + 1, z) : new BlockPos(x + 1, y + 1, z), false);
						break;

					case SOUTH :
						worldIn.destroyBlock(left? new BlockPos(x + 1, y, z) : new BlockPos(x - 1, y, z), false);
						worldIn.destroyBlock(left? new BlockPos(x + 1, y + 1, z) : new BlockPos(x - 1, y + 1, z), false);
						break;

					case EAST :
						worldIn.destroyBlock(left? new BlockPos(x, y, z - 1) : new BlockPos(x, y, z + 1), false);
						worldIn.destroyBlock(left? new BlockPos(x, y + 1, z - 1) : new BlockPos(x, y + 1, z + 1), false);
						break;
						
					case WEST :
						worldIn.destroyBlock(left? new BlockPos(x, y, z + 1) : new BlockPos(x, y, z - 1), false);
						worldIn.destroyBlock(left? new BlockPos(x, y + 1, z + 1) : new BlockPos(x, y + 1, z - 1), false);
						break;
					} // direction
					break; //case 1, LOWER


				case UPPER :
					worldIn.destroyBlock(pos, mode? false : true);
					worldIn.destroyBlock(pos.below(), false);
					
					switch (direction) {
					case NORTH :
					default :
						worldIn.destroyBlock(left? new BlockPos(x - 1, y, z) : new BlockPos(x + 1, y, z), false);
						worldIn.destroyBlock(left? new BlockPos(x - 1, y - 1, z) : new BlockPos(x + 1, y - 1, z), false);
						break;

					case SOUTH :
						worldIn.destroyBlock(left? new BlockPos(x + 1, y, z) : new BlockPos(x - 1, y, z), false);
						worldIn.destroyBlock(left? new BlockPos(x + 1, y - 1, z) : new BlockPos(x - 1, y - 1, z), false);
						break;

					case EAST :
						worldIn.destroyBlock(left? new BlockPos(x, y, z - 1) : new BlockPos(x, y, z + 1), false);
						worldIn.destroyBlock(left? new BlockPos(x, y - 1, z - 1) : new BlockPos(x, y - 1, z + 1), false);
						break;
						
					case WEST :
						worldIn.destroyBlock(left? new BlockPos(x, y, z + 1) : new BlockPos(x, y, z - 1), false);
						worldIn.destroyBlock(left? new BlockPos(x, y - 1, z + 1) : new BlockPos(x, y - 1, z - 1), false);
						break;
					} // direction
					break; //case 1, UPPER
				}
				break; //case 1


			case 2 :
				switch (half) {
				case LOWER :
				default :
					worldIn.destroyBlock(pos, mode? false : true);
					worldIn.destroyBlock(pos.above(), false);
					
					switch (direction) {
					case NORTH :
					default :
						worldIn.destroyBlock(left? new BlockPos(x + 1, y, z) : new BlockPos(x - 1, y, z), false);
						worldIn.destroyBlock(left? new BlockPos(x + 1, y + 1, z) : new BlockPos(x - 1, y + 1, z), false);
						break;

					case SOUTH :
						worldIn.destroyBlock(left? new BlockPos(x - 1, y, z) : new BlockPos(x + 1, y, z), false);
						worldIn.destroyBlock(left? new BlockPos(x - 1, y + 1, z) : new BlockPos(x + 1, y + 1, z), false);
						break;

					case EAST :
						worldIn.destroyBlock(left? new BlockPos(x, y, z + 1) : new BlockPos(x, y, z - 1), false);
						worldIn.destroyBlock(left? new BlockPos(x, y + 1, z + 1) : new BlockPos(x, y + 1, z - 1), false);
						break;
						
					case WEST :
						worldIn.destroyBlock(left? new BlockPos(x, y, z - 1) : new BlockPos(x, y, z + 1), false);
						worldIn.destroyBlock(left? new BlockPos(x, y + 1, z - 1) : new BlockPos(x, y + 1, z + 1), false);
						break;
					} // direction
					break; //case 2, LOWER


				case UPPER :
					worldIn.destroyBlock(pos, mode? false : true);
					worldIn.destroyBlock(pos.below(), false);
					
					switch (direction) {
					case NORTH :
					default :
						worldIn.destroyBlock(left? new BlockPos(x + 1, y, z) : new BlockPos(x - 1, y, z), false);
						worldIn.destroyBlock(left? new BlockPos(x + 1, y - 1, z) : new BlockPos(x - 1, y - 1, z), false);
						break;

					case SOUTH :
						worldIn.destroyBlock(left? new BlockPos(x - 1, y, z) : new BlockPos(x + 1, y, z), false);
						worldIn.destroyBlock(left? new BlockPos(x - 1, y - 1, z) : new BlockPos(x + 1, y - 1, z), false);
						break;

					case EAST :
						worldIn.destroyBlock(left? new BlockPos(x, y, z + 1) : new BlockPos(x, y, z - 1), false);
						worldIn.destroyBlock(left? new BlockPos(x, y - 1, z + 1) : new BlockPos(x, y - 1, z - 1), false);
						break;
						
					case WEST :
						worldIn.destroyBlock(left? new BlockPos(x, y, z - 1) : new BlockPos(x, y, z + 1), false);
						worldIn.destroyBlock(left? new BlockPos(x, y - 1, z - 1) : new BlockPos(x, y - 1, z + 1), false);
						break;
					} // direction
					break; //case 2, UPPER
				}
				break; //case 2
			}
		}
	}

	/* @deprecated call via {@link IBlockState#getMobilityFlag()} whenever possible. Implementing/overriding is fine. */
	public PushReaction getPistonPushReaction(BlockState state) {
		return PushReaction.DESTROY;
	}
	
	public boolean isPathfindable(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
		switch (type) {
		case LAND:
			return state.getValue(OPEN);
		case WATER:
			return false;
		case AIR:
			return state.getValue(OPEN);
		default:
			return false;
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
		tooltip.add(new TranslationTextComponent("tips.block_window").withStyle(TextFormatting.GRAY));
	}
}
