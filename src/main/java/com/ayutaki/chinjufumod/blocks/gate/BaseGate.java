package com.ayutaki.chinjufumod.blocks.gate;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Gate_Blocks;
import com.ayutaki.chinjufumod.state.TripleGate;

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
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BaseGate extends CM_WaterLogged {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final BooleanProperty OPEN = BooleanProperty.create("open");
	public static final EnumProperty<DoorHingeSide> HINGE = EnumProperty.create("hinge", DoorHingeSide.class);
	public static final BooleanProperty POWERED = BooleanProperty.create("powered");
	public static final EnumProperty<TripleGate> HALF = EnumProperty.create("half", TripleGate.class);
	public static final IntegerProperty STAGE_1_2 = IntegerProperty.create("stage", 1, 2);

	public BaseGate(AbstractBlock.Properties properties) {
		super(properties);
		/** Default state **/
		registerDefaultState(this.defaultBlockState().setValue(H_FACING, Direction.NORTH)
				.setValue(STAGE_1_2, Integer.valueOf(1))
				.setValue(OPEN, Boolean.valueOf(false))
				.setValue(HINGE, DoorHingeSide.LEFT)
				.setValue(POWERED, Boolean.valueOf(false))
				.setValue(HALF, TripleGate.LOWER)
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {
		return ActionResultType.FAIL;
	}

	/* Get POWER. */
	@Override
	public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
		int i = state.getValue(STAGE_1_2);
		TripleGate half = state.getValue(HALF);
		DoorHingeSide hinge = state.getValue(HINGE);
		Direction direction = state.getValue(H_FACING);
		
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		
		/** Power Flag **/
		boolean flag = worldIn.hasNeighborSignal(pos) || worldIn.hasNeighborSignal(pos.relative(state.getValue(HALF) == TripleGate.LOWER ? Direction.UP : Direction.DOWN));
		
		BlockState directFlag = this.defaultBlockState().setValue(H_FACING, direction).setValue(OPEN, Boolean.valueOf(flag));
		
		BlockState Top_LEFT1 = directFlag.setValue(STAGE_1_2, Integer.valueOf(1)).setValue(HALF, TripleGate.TOP).setValue(HINGE, DoorHingeSide.LEFT);
		BlockState Up_LEFT1 = directFlag.setValue(STAGE_1_2, Integer.valueOf(1)).setValue(HALF, TripleGate.UPPER).setValue(HINGE, DoorHingeSide.LEFT);
		BlockState Low_LEFT1 = directFlag.setValue(STAGE_1_2, Integer.valueOf(1)).setValue(HALF, TripleGate.LOWER).setValue(HINGE, DoorHingeSide.LEFT);
		BlockState Top_LEFT2 = directFlag.setValue(STAGE_1_2, Integer.valueOf(2)).setValue(HALF, TripleGate.TOP).setValue(HINGE, DoorHingeSide.LEFT);
		BlockState Up_LEFT2 = directFlag.setValue(STAGE_1_2, Integer.valueOf(2)).setValue(HALF, TripleGate.UPPER).setValue(HINGE, DoorHingeSide.LEFT);
		BlockState Low_LEFT2 = directFlag.setValue(STAGE_1_2, Integer.valueOf(2)).setValue(HALF, TripleGate.LOWER).setValue(HINGE, DoorHingeSide.LEFT);

		BlockState Top_RIGHT1 = directFlag.setValue(STAGE_1_2, Integer.valueOf(1)).setValue(HALF, TripleGate.TOP).setValue(HINGE, DoorHingeSide.RIGHT);
		BlockState Up_RIGHT1 = directFlag.setValue(STAGE_1_2, Integer.valueOf(1)).setValue(HALF, TripleGate.UPPER).setValue(HINGE, DoorHingeSide.RIGHT);
		BlockState Low_RIGHT1 = directFlag.setValue(STAGE_1_2, Integer.valueOf(1)).setValue(HALF, TripleGate.LOWER).setValue(HINGE, DoorHingeSide.RIGHT);
		BlockState Top_RIGHT2 = directFlag.setValue(STAGE_1_2, Integer.valueOf(2)).setValue(HALF, TripleGate.TOP).setValue(HINGE, DoorHingeSide.RIGHT);
		BlockState Up_RIGHT2 = directFlag.setValue(STAGE_1_2, Integer.valueOf(2)).setValue(HALF, TripleGate.UPPER).setValue(HINGE, DoorHingeSide.RIGHT);
		BlockState Low_RIGHT2 = directFlag.setValue(STAGE_1_2, Integer.valueOf(2)).setValue(HALF, TripleGate.LOWER).setValue(HINGE, DoorHingeSide.RIGHT);			

		if (block != this && flag != state.getValue(POWERED) && half != TripleGate.TOP) {
			if (flag != state.getValue(OPEN)) { this.moveSound(worldIn, pos, flag); }
			worldIn.setBlock(pos, state.setValue(POWERED, Boolean.valueOf(flag)).setValue(OPEN, Boolean.valueOf(flag)), 2);
			
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
						worldIn.setBlock(pos.above(2), Top_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.above(2)).getType() == Fluids.WATER)), 2);
						worldIn.setBlock(pos.above(), Up_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.above()).getType() == Fluids.WATER)), 2);
						
						switch (direction) {
						case NORTH :
						default :
							worldIn.setBlock(new BlockPos(x - 1, y + 2, z), Top_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y + 2, z)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x - 1, y + 1, z), Up_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y + 1, z)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x - 1, y, z), Low_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y, z)).getType() == Fluids.WATER)), 2);
							break;

						case SOUTH :
							worldIn.setBlock(new BlockPos(x + 1, y + 2, z), Top_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y + 2, z)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x + 1, y + 1, z), Up_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y + 1, z)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x + 1, y, z), Low_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y, z)).getType() == Fluids.WATER)), 2);
							break;

						case EAST :
							worldIn.setBlock(new BlockPos(x, y + 2, z - 1), Top_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 2, z - 1)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x, y + 1, z - 1), Up_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z - 1)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x, y, z - 1), Low_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z - 1)).getType() == Fluids.WATER)), 2);
							break;
							
						case WEST :
							worldIn.setBlock(new BlockPos(x, y + 2, z + 1), Top_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 2, z + 1)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x, y + 1, z + 1), Up_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z + 1)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x, y, z + 1), Low_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z + 1)).getType() == Fluids.WATER)), 2);
							break;
						} // direction
						break;

					case RIGHT :
						worldIn.setBlock(pos.above(2), Top_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.above(2)).getType() == Fluids.WATER)), 2);
						worldIn.setBlock(pos.above(), Up_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.above()).getType() == Fluids.WATER)), 2);
						
						switch (direction) {
						case NORTH :
						default :
							worldIn.setBlock(new BlockPos(x + 1, y + 2, z), Top_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y + 2, z)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x + 1, y + 1, z), Up_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y + 1, z)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x + 1, y, z), Low_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y, z)).getType() == Fluids.WATER)), 2);
							break;

						case SOUTH :
							worldIn.setBlock(new BlockPos(x - 1, y + 2, z), Top_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y + 2, z)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x - 1, y + 1, z), Up_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y + 1, z)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x - 1, y, z), Low_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y, z)).getType() == Fluids.WATER)), 2);
							break;

						case EAST :
							worldIn.setBlock(new BlockPos(x, y + 2, z + 1), Top_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 2, z + 1)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x, y + 1, z + 1), Up_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z + 1)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x, y, z + 1), Low_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z + 1)).getType() == Fluids.WATER)), 2);
							break;
							
						case WEST :
							worldIn.setBlock(new BlockPos(x, y + 2, z - 1), Top_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 2, z - 1)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x, y + 1, z - 1), Up_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z - 1)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x, y, z - 1), Low_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z - 1)).getType() == Fluids.WATER)), 2);
							break;
						} // direction
						break;
					} // LEFT-RIGHT
					break;


				case UPPER :
					switch (hinge) {
					case LEFT :
					default :
						worldIn.setBlock(pos.above(), Top_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.above()).getType() == Fluids.WATER)), 2);
						worldIn.setBlock(pos.below(), Low_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.below()).getType() == Fluids.WATER)), 2);
						
						switch (direction) {
						case NORTH :
						default :
							worldIn.setBlock(new BlockPos(x - 1, y + 1, z), Top_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y + 1, z)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x - 1, y, z), Up_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y, z)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x - 1, y - 1, z), Low_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y - 1, z)).getType() == Fluids.WATER)), 2);
							break;

						case SOUTH :
							worldIn.setBlock(new BlockPos(x + 1, y + 1, z), Top_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y + 1, z)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x + 1, y, z), Up_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y, z)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x + 1, y - 1, z), Low_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y - 1, z)).getType() == Fluids.WATER)), 2);
							break;

						case EAST :
							worldIn.setBlock(new BlockPos(x, y + 1, z - 1), Top_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z - 1)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x, y, z - 1), Up_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z - 1)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x, y - 1, z - 1), Low_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y - 1, z - 1)).getType() == Fluids.WATER)), 2);
							break;
							
						case WEST :
							worldIn.setBlock(new BlockPos(x, y + 1, z + 1), Top_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z + 1)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x, y, z + 1), Up_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z + 1)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x, y - 1, z + 1), Low_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y - 1, z + 1)).getType() == Fluids.WATER)), 2);
							break;
						} // direction
						break;

					case RIGHT :
						worldIn.setBlock(pos.above(), Top_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.above()).getType() == Fluids.WATER)), 2);
						worldIn.setBlock(pos.below(), Low_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.below()).getType() == Fluids.WATER)), 2);
						
						switch (direction) {
						case NORTH :
						default :
							worldIn.setBlock(new BlockPos(x + 1, y + 1, z), Top_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y + 1, z)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x + 1, y, z), Up_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y, z)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x + 1, y - 1, z), Low_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y - 1, z)).getType() == Fluids.WATER)), 2);
							break;

						case SOUTH :
							worldIn.setBlock(new BlockPos(x - 1, y + 1, z), Top_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y + 1, z)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x - 1, y, z), Up_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y, z)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x - 1, y - 1, z), Low_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y - 1, z)).getType() == Fluids.WATER)), 2);
							break;

						case EAST :
							worldIn.setBlock(new BlockPos(x, y + 1, z + 1), Top_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z + 1)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x, y, z + 1), Up_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z + 1)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x, y - 1, z + 1), Low_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y - 1, z + 1)).getType() == Fluids.WATER)), 2);
							break;
							
						case WEST :
							worldIn.setBlock(new BlockPos(x, y + 1, z - 1), Top_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z - 1)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x, y, z - 1), Up_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z - 1)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x, y - 1, z - 1), Low_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y - 1, z - 1)).getType() == Fluids.WATER)), 2);
							break;
						} // direction
						break;
					} // LEFT-RIGHT
					break;
					
				case TOP : break;
				} // half
				break;


			///// STAGE_2 ////////////////////
			case 2 :
				switch (half) {
				case LOWER :
				default :
					switch (hinge) {
					case LEFT :
					default :
						worldIn.setBlock(pos.above(2), Top_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.above(2)).getType() == Fluids.WATER)), 2);
						worldIn.setBlock(pos.above(), Up_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.above()).getType() == Fluids.WATER)), 2);

						switch (direction) {
						case NORTH :
						default :
							worldIn.setBlock(new BlockPos(x + 1, y + 2, z), Top_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y + 2, z)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x + 1, y + 1, z), Up_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y + 1, z)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x + 1, y, z), Low_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y, z)).getType() == Fluids.WATER)), 2);
							break;

						case SOUTH :
							worldIn.setBlock(new BlockPos(x - 1, y + 2, z), Top_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y + 2, z)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x - 1, y + 1, z), Up_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y + 1, z)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x - 1, y, z), Low_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y, z)).getType() == Fluids.WATER)), 2);
							break;

						case EAST :
							worldIn.setBlock(new BlockPos(x, y + 2, z + 1), Top_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 2, z + 1)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x, y + 1, z + 1), Up_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z + 1)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x, y, z + 1), Low_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z + 1)).getType() == Fluids.WATER)), 2);
							break;
							
						case WEST :
							worldIn.setBlock(new BlockPos(x, y + 2, z - 1), Top_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 2, z - 1)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x, y + 1, z - 1), Up_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z - 1)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x, y, z - 1), Low_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z - 1)).getType() == Fluids.WATER)), 2);
							break;
						} // direction
						break;

					case RIGHT :
						worldIn.setBlock(pos.above(2), Top_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.above(2)).getType() == Fluids.WATER)), 2);
						worldIn.setBlock(pos.above(), Up_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.above()).getType() == Fluids.WATER)), 2);
	
						switch (direction) {
						case NORTH :
						default :
							worldIn.setBlock(new BlockPos(x - 1, y + 2, z), Top_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y + 2, z)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x - 1, y + 1, z), Up_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y + 1, z)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x - 1, y, z), Low_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y, z)).getType() == Fluids.WATER)), 2);
							break;

						case SOUTH :
							worldIn.setBlock(new BlockPos(x + 1, y + 2, z), Top_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y + 2, z)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x + 1, y + 1, z), Up_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y + 1, z)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x + 1, y, z), Low_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y, z)).getType() == Fluids.WATER)), 2);
							break;

						case EAST :
							worldIn.setBlock(new BlockPos(x, y + 2, z - 1), Top_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 2, z - 1)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x, y + 1, z - 1), Up_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z - 1)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x, y, z - 1), Low_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z - 1)).getType() == Fluids.WATER)), 2);
							break;
							
						case WEST :
							worldIn.setBlock(new BlockPos(x, y + 2, z + 1), Top_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 2, z + 1)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x, y + 1, z + 1), Up_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z + 1)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x, y, z + 1), Low_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z + 1)).getType() == Fluids.WATER)), 2);
							break;
						} // direction
						break;
					} // LEFT-RIGHT
					break;

				case UPPER :
					switch (hinge) {
					case LEFT :
					default :
						worldIn.setBlock(pos.above(), Top_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.above()).getType() == Fluids.WATER)), 2);
						worldIn.setBlock(pos.below(), Low_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.below()).getType() == Fluids.WATER)), 2);

						switch (direction) {
						case NORTH :
						default :
							worldIn.setBlock(new BlockPos(x + 1, y + 1, z), Top_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y + 1, z)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x + 1, y, z), Up_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y, z)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x + 1, y - 1, z), Low_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y - 1, z)).getType() == Fluids.WATER)), 2);
							break;

						case SOUTH :
							worldIn.setBlock(new BlockPos(x - 1, y + 1, z), Top_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y + 1, z)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x - 1, y, z), Up_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y, z)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x - 1, y - 1, z), Low_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y - 1, z)).getType() == Fluids.WATER)), 2);
							break;

						case EAST :
							worldIn.setBlock(new BlockPos(x, y + 1, z + 1), Top_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z + 1)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x, y, z + 1), Up_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z + 1)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x, y - 1, z + 1), Low_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y - 1, z + 1)).getType() == Fluids.WATER)), 2);
							break;
							
						case WEST :
							worldIn.setBlock(new BlockPos(x, y + 1, z - 1), Top_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z - 1)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x, y, z - 1), Up_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z - 1)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x, y - 1, z - 1), Low_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y - 1, z - 1)).getType() == Fluids.WATER)), 2);
							break;
						} // direction
						break;

					case RIGHT :
						worldIn.setBlock(pos.above(), Top_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.above()).getType() == Fluids.WATER)), 2);
						worldIn.setBlock(pos.below(), Low_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.below()).getType() == Fluids.WATER)), 2);

						switch (direction) {
						case NORTH :
						default :
							worldIn.setBlock(new BlockPos(x - 1, y + 1, z), Top_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y + 1, z)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x - 1, y, z), Up_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y, z)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x - 1, y - 1, z), Low_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y - 1, z)).getType() == Fluids.WATER)), 2);
							break;

						case SOUTH :
							worldIn.setBlock(new BlockPos(x + 1, y + 1, z), Top_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y + 1, z)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x + 1, y, z), Up_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y, z)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x + 1, y - 1, z), Low_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y - 1, z)).getType() == Fluids.WATER)), 2);
							break;

						case EAST :
							worldIn.setBlock(new BlockPos(x, y + 1, z - 1), Top_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z - 1)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x, y, z - 1), Up_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z - 1)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x, y - 1, z - 1), Low_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y - 1, z - 1)).getType() == Fluids.WATER)), 2);
							break;
							
						case WEST :
							worldIn.setBlock(new BlockPos(x, y + 1, z + 1), Top_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z + 1)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x, y, z + 1), Up_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z + 1)).getType() == Fluids.WATER)), 2);
							worldIn.setBlock(new BlockPos(x, y - 1, z + 1), Low_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y - 1, z + 1)).getType() == Fluids.WATER)), 2);
							break;
						} // direction
						break;
					} // LEFT-RIGHT
					break;
					
				case TOP : break;
				} // half
				break;
			} // STAGE_1_2
		} //block != this
	}

	/* Play Sound */
	private void moveSound(World worldIn, BlockPos pos, boolean isOpening) {
		boolean flag = (this == Gate_Blocks.GATE_SPRUCE || this == Gate_Blocks.GATE_SPRUCE_B);
		boolean flag1 = (this == Gate_Blocks.GATE_IRON);
		
		if (isOpening == true) {
			worldIn.playSound(null, pos, flag? SoundEvents_CM.GATE_WOOD : SoundEvents_CM.GATE_IRON_OPEN, SoundCategory.BLOCKS, 1.0F, 1.0F); }

		if (isOpening != true) {
			worldIn.playSound(null, pos, flag? SoundEvents_CM.GATE_WOOD : (flag1? SoundEvents_CM.GATE_IRON_CLOSE : SoundEvents_CM.GATE_IRON_OPEN), SoundCategory.BLOCKS, 1.0F, 1.0F); }
	}
	

	/* Gives a value when placed. */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);
		PlayerEntity playerIn = context.getPlayer();
		
		/** pos.up() = Replaceable block. **/
		if (pos.getY() < 255 && worldIn.getBlockState(pos.above()).canBeReplaced(context)) {
			/** Power Flag **/
			boolean flag = worldIn.hasNeighborSignal(pos) || worldIn.hasNeighborSignal(pos.above());
			
			Direction facing = playerIn.getDirection();
			double x = (double) pos.getX();
			double y = (double) pos.getY();
			double z = (double) pos.getZ();
			
			BlockState directFlag = this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection())
					.setValue(STAGE_1_2, Integer.valueOf(1)).setValue(POWERED, Boolean.valueOf(flag)).setValue(OPEN, Boolean.valueOf(flag));
			
			BlockState Right = directFlag.setValue(HINGE, DoorHingeSide.RIGHT).setValue(HALF, TripleGate.LOWER)
					.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER));
			BlockState Left = directFlag.setValue(HINGE, DoorHingeSide.LEFT).setValue(HALF, TripleGate.LOWER)
					.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER));
			
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
		}

		else { 
			CMEvents.textNoPlace(context.getLevel(), context.getClickedPos(), context.getPlayer());
			return null; }
	}

	/* Add TripleGate.UPPER on the Block. */
	@Override
	public void setPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {

		Direction facing = placer.getDirection();
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();

		BlockState directOnly = this.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING));
		
		if (placer.isCrouching()) {
			BlockState Up_RIGHT1 = directOnly.setValue(STAGE_1_2, Integer.valueOf(1)).setValue(HALF, TripleGate.UPPER).setValue(HINGE, DoorHingeSide.RIGHT);
			BlockState Top_RIGHT1 = directOnly.setValue(STAGE_1_2, Integer.valueOf(1)).setValue(HALF, TripleGate.TOP).setValue(HINGE, DoorHingeSide.RIGHT);
			
			BlockState Top_RIGHT2 = directOnly.setValue(STAGE_1_2, Integer.valueOf(2)).setValue(HALF, TripleGate.TOP).setValue(HINGE, DoorHingeSide.RIGHT);
			BlockState Up_RIGHT2 = directOnly.setValue(STAGE_1_2, Integer.valueOf(2)).setValue(HALF, TripleGate.UPPER).setValue(HINGE, DoorHingeSide.RIGHT);
			BlockState Low_RIGHT2 = directOnly.setValue(STAGE_1_2, Integer.valueOf(2)).setValue(HALF, TripleGate.LOWER).setValue(HINGE, DoorHingeSide.RIGHT);
			
			worldIn.setBlock(pos.above(2), Top_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.above(2)).getType() == Fluids.WATER)), 3);
			worldIn.setBlock(pos.above(), Up_RIGHT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.above()).getType() == Fluids.WATER)), 3);
			
			switch (facing) {
			case NORTH :
			default :
				worldIn.setBlock(new BlockPos(x + 1, y + 2, z), Top_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y + 2, z)).getType() == Fluids.WATER)), 3);
				worldIn.setBlock(new BlockPos(x + 1, y + 1, z), Up_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y + 1, z)).getType() == Fluids.WATER)), 3);
				worldIn.setBlock(new BlockPos(x + 1, y, z), Low_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y, z)).getType() == Fluids.WATER)), 3);
				break;

			case SOUTH :
				worldIn.setBlock(new BlockPos(x - 1, y + 2, z), Top_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y + 2, z)).getType() == Fluids.WATER)), 3);
				worldIn.setBlock(new BlockPos(x - 1, y + 1, z), Up_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y + 1, z)).getType() == Fluids.WATER)), 3);
				worldIn.setBlock(new BlockPos(x - 1, y, z), Low_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y, z)).getType() == Fluids.WATER)), 3);
				break;

			case EAST :
				worldIn.setBlock(new BlockPos(x, y + 2, z + 1), Top_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 2, z + 1)).getType() == Fluids.WATER)), 3);
				worldIn.setBlock(new BlockPos(x, y + 1, z + 1), Up_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z + 1)).getType() == Fluids.WATER)), 3);
				worldIn.setBlock(new BlockPos(x, y, z + 1), Low_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z + 1)).getType() == Fluids.WATER)), 3);
				break;
				
			case WEST :
				worldIn.setBlock(new BlockPos(x, y + 2, z - 1), Top_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 2, z - 1)).getType() == Fluids.WATER)), 3);
				worldIn.setBlock(new BlockPos(x, y + 1, z - 1), Up_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z - 1)).getType() == Fluids.WATER)), 3);
				worldIn.setBlock(new BlockPos(x, y, z - 1), Low_RIGHT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z - 1)).getType() == Fluids.WATER)), 3);
				break;
			} // direction
		} //placer.isCrouching()
		
		if (!placer.isCrouching()) {
			BlockState Up_LEFT1 = directOnly.setValue(STAGE_1_2, Integer.valueOf(1)).setValue(HALF, TripleGate.UPPER).setValue(HINGE, DoorHingeSide.LEFT);
			BlockState Top_LEFT1 = directOnly.setValue(STAGE_1_2, Integer.valueOf(1)).setValue(HALF, TripleGate.TOP).setValue(HINGE, DoorHingeSide.LEFT);
			
			BlockState Top_LEFT2 = directOnly.setValue(STAGE_1_2, Integer.valueOf(2)).setValue(HALF, TripleGate.TOP).setValue(HINGE, DoorHingeSide.LEFT);
			BlockState Up_LEFT2 = directOnly.setValue(STAGE_1_2, Integer.valueOf(2)).setValue(HALF, TripleGate.UPPER).setValue(HINGE, DoorHingeSide.LEFT);
			BlockState Low_LEFT2 = directOnly.setValue(STAGE_1_2, Integer.valueOf(2)).setValue(HALF, TripleGate.LOWER).setValue(HINGE, DoorHingeSide.LEFT);
			
			worldIn.setBlock(pos.above(2), Top_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.above(2)).getType() == Fluids.WATER)), 3);
			worldIn.setBlock(pos.above(), Up_LEFT1.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.above()).getType() == Fluids.WATER)), 3);

			switch (facing) {
			case NORTH :
			default :
				worldIn.setBlock(new BlockPos(x - 1, y + 2, z), Top_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y + 2, z)).getType() == Fluids.WATER)), 3);
				worldIn.setBlock(new BlockPos(x - 1, y + 1, z), Up_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y + 1, z)).getType() == Fluids.WATER)), 3);
				worldIn.setBlock(new BlockPos(x - 1, y, z), Low_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y, z)).getType() == Fluids.WATER)), 3);
				break;

			case SOUTH :
				worldIn.setBlock(new BlockPos(x + 1, y + 2, z), Top_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y + 2, z)).getType() == Fluids.WATER)), 3);
				worldIn.setBlock(new BlockPos(x + 1, y + 1, z), Up_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y + 1, z)).getType() == Fluids.WATER)), 3);
				worldIn.setBlock(new BlockPos(x + 1, y, z), Low_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y, z)).getType() == Fluids.WATER)), 3);
				break;

			case EAST :
				worldIn.setBlock(new BlockPos(x, y + 2, z - 1), Top_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 2, z - 1)).getType() == Fluids.WATER)), 3);
				worldIn.setBlock(new BlockPos(x, y + 1, z - 1), Up_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z - 1)).getType() == Fluids.WATER)), 3);
				worldIn.setBlock(new BlockPos(x, y, z - 1), Low_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z - 1)).getType() == Fluids.WATER)), 3);
				break;
				
			case WEST :
				worldIn.setBlock(new BlockPos(x, y + 2, z + 1), Top_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 2, z + 1)).getType() == Fluids.WATER)), 3);
				worldIn.setBlock(new BlockPos(x, y + 1, z + 1), Up_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z + 1)).getType() == Fluids.WATER)), 3);
				worldIn.setBlock(new BlockPos(x, y, z + 1), Low_LEFT2.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z + 1)).getType() == Fluids.WATER)), 3);
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
		return MathHelper.getSeed(pos.getX(), pos.below(state.getValue(HALF) == TripleGate.LOWER ? 0 : 1).getY(), pos.getZ());
	}
	
	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		BlockState state1 = super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
		if (!state1.isAir(worldIn, pos)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }

		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}

	@Override
	public BlockRenderType getRenderShape(BlockState state) {
		return BlockRenderType.MODEL;
	}

	@Override
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
	
	/* Destroy a DoubleBlock from DoublePlantBlock.class */
	@Override
	public void playerWillDestroy(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {
		int i = state.getValue(STAGE_1_2);
		Direction direction = state.getValue(H_FACING);
		TripleGate half = state.getValue(HALF);

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
					worldIn.destroyBlock(pos.above(2), false);
					
					switch (direction) {
					case NORTH :
					default :
						worldIn.destroyBlock(left? new BlockPos(x - 1, y, z) : new BlockPos(x + 1, y, z), false);
						worldIn.destroyBlock(left? new BlockPos(x - 1, y + 1, z) : new BlockPos(x + 1, y + 1, z), false);
						worldIn.destroyBlock(left? new BlockPos(x - 1, y + 2, z) : new BlockPos(x + 1, y + 2, z), false);
						break;

					case SOUTH :
						worldIn.destroyBlock(left? new BlockPos(x + 1, y, z) : new BlockPos(x - 1, y, z), false);
						worldIn.destroyBlock(left? new BlockPos(x + 1, y + 1, z) : new BlockPos(x - 1, y + 1, z), false);
						worldIn.destroyBlock(left? new BlockPos(x + 1, y + 2, z) : new BlockPos(x - 1, y + 2, z), false);
						break;

					case EAST :
						worldIn.destroyBlock(left? new BlockPos(x, y, z - 1) : new BlockPos(x, y, z + 1), false);
						worldIn.destroyBlock(left? new BlockPos(x, y + 1, z - 1) : new BlockPos(x, y + 1, z + 1), false);
						worldIn.destroyBlock(left? new BlockPos(x, y + 2, z - 1) : new BlockPos(x, y + 2, z + 1), false);
						break;
						
					case WEST :
						worldIn.destroyBlock(left? new BlockPos(x, y, z + 1) : new BlockPos(x, y, z - 1), false);
						worldIn.destroyBlock(left? new BlockPos(x, y + 1, z + 1) : new BlockPos(x, y + 1, z - 1), false);
						worldIn.destroyBlock(left? new BlockPos(x, y + 2, z + 1) : new BlockPos(x, y + 2, z - 1), false);
						break;
					} // direction
					break; //case 1, LOWER


				case UPPER :
					worldIn.destroyBlock(pos, mode? false : true);
					worldIn.destroyBlock(pos.below(), false);
					worldIn.destroyBlock(pos.above(), false);
					
					switch (direction) {
					case NORTH :
					default :
						worldIn.destroyBlock(left? new BlockPos(x - 1, y, z) : new BlockPos(x + 1, y, z), false);
						worldIn.destroyBlock(left? new BlockPos(x - 1, y - 1, z) : new BlockPos(x + 1, y - 1, z), false);
						worldIn.destroyBlock(left? new BlockPos(x - 1, y + 1, z) : new BlockPos(x + 1, y + 1, z), false);
						break;

					case SOUTH :
						worldIn.destroyBlock(left? new BlockPos(x + 1, y, z) : new BlockPos(x - 1, y, z), false);
						worldIn.destroyBlock(left? new BlockPos(x + 1, y - 1, z) : new BlockPos(x - 1, y - 1, z), false);
						worldIn.destroyBlock(left? new BlockPos(x + 1, y + 1, z) : new BlockPos(x - 1, y + 1, z), false);
						break;

					case EAST :
						worldIn.destroyBlock(left? new BlockPos(x, y, z - 1) : new BlockPos(x, y, z + 1), false);
						worldIn.destroyBlock(left? new BlockPos(x, y - 1, z - 1) : new BlockPos(x, y - 1, z + 1), false);
						worldIn.destroyBlock(left? new BlockPos(x, y + 1, z - 1) : new BlockPos(x, y + 1, z + 1), false);
						break;
						
					case WEST :
						worldIn.destroyBlock(left? new BlockPos(x, y, z + 1) : new BlockPos(x, y, z - 1), false);
						worldIn.destroyBlock(left? new BlockPos(x, y - 1, z + 1) : new BlockPos(x, y - 1, z - 1), false);
						worldIn.destroyBlock(left? new BlockPos(x, y + 1, z + 1) : new BlockPos(x, y + 1, z - 1), false);
						break;
					} // direction
					break; //case 1, UPPER
					
				case TOP :
					worldIn.destroyBlock(pos, mode? false : true);
					worldIn.destroyBlock(pos.below(), false);
					worldIn.destroyBlock(pos.below(2), false);
					
					switch (direction) {
					case NORTH :
					default :
						worldIn.destroyBlock(left? new BlockPos(x - 1, y, z) : new BlockPos(x + 1, y, z), false);
						worldIn.destroyBlock(left? new BlockPos(x - 1, y - 1, z) : new BlockPos(x + 1, y - 1, z), false);
						worldIn.destroyBlock(left? new BlockPos(x - 1, y - 2, z) : new BlockPos(x + 1, y - 2, z), false);
						break;

					case SOUTH :
						worldIn.destroyBlock(left? new BlockPos(x + 1, y, z) : new BlockPos(x - 1, y, z), false);
						worldIn.destroyBlock(left? new BlockPos(x + 1, y - 1, z) : new BlockPos(x - 1, y - 1, z), false);
						worldIn.destroyBlock(left? new BlockPos(x + 1, y - 2, z) : new BlockPos(x - 1, y - 2, z), false);
						break;

					case EAST :
						worldIn.destroyBlock(left? new BlockPos(x, y, z - 1) : new BlockPos(x, y, z + 1), false);
						worldIn.destroyBlock(left? new BlockPos(x, y - 1, z - 1) : new BlockPos(x, y - 1, z + 1), false);
						worldIn.destroyBlock(left? new BlockPos(x, y - 2, z - 1) : new BlockPos(x, y - 2, z + 1), false);
						break;
						
					case WEST :
						worldIn.destroyBlock(left? new BlockPos(x, y, z + 1) : new BlockPos(x, y, z - 1), false);
						worldIn.destroyBlock(left? new BlockPos(x, y - 1, z + 1) : new BlockPos(x, y - 1, z - 1), false);
						worldIn.destroyBlock(left? new BlockPos(x, y - 2, z + 1) : new BlockPos(x, y - 2, z - 1), false);
						break;
					} // direction
					break; //case 1, TOP
				}
				break; //case 1


			case 2 :
				switch (half) {
				case LOWER :
				default :
					worldIn.destroyBlock(pos, mode? false : true);
					worldIn.destroyBlock(pos.above(), false);
					worldIn.destroyBlock(pos.above(2), false);
					
					switch (direction) {
					case NORTH :
					default :
						worldIn.destroyBlock(left? new BlockPos(x + 1, y, z) : new BlockPos(x - 1, y, z), false);
						worldIn.destroyBlock(left? new BlockPos(x + 1, y + 1, z) : new BlockPos(x - 1, y + 1, z), false);
						worldIn.destroyBlock(left? new BlockPos(x + 1, y + 2, z) : new BlockPos(x - 1, y + 2, z), false);
						break;

					case SOUTH :
						worldIn.destroyBlock(left? new BlockPos(x - 1, y, z) : new BlockPos(x + 1, y, z), false);
						worldIn.destroyBlock(left? new BlockPos(x - 1, y + 1, z) : new BlockPos(x + 1, y + 1, z), false);
						worldIn.destroyBlock(left? new BlockPos(x - 1, y + 2, z) : new BlockPos(x + 1, y + 2, z), false);
						break;

					case EAST :
						worldIn.destroyBlock(left? new BlockPos(x, y, z + 1) : new BlockPos(x, y, z - 1), false);
						worldIn.destroyBlock(left? new BlockPos(x, y + 1, z + 1) : new BlockPos(x, y + 1, z - 1), false);
						worldIn.destroyBlock(left? new BlockPos(x, y + 2, z + 1) : new BlockPos(x, y + 2, z - 1), false);
						break;
						
					case WEST :
						worldIn.destroyBlock(left? new BlockPos(x, y, z - 1) : new BlockPos(x, y, z + 1), false);
						worldIn.destroyBlock(left? new BlockPos(x, y + 1, z - 1) : new BlockPos(x, y + 1, z + 1), false);
						worldIn.destroyBlock(left? new BlockPos(x, y + 2, z - 1) : new BlockPos(x, y + 2, z + 1), false);
						break;
					} // direction
					break; //case 2, LOWER


				case UPPER :
					worldIn.destroyBlock(pos, mode? false : true);
					worldIn.destroyBlock(pos.below(), false);
					worldIn.destroyBlock(pos.above(), false);
					
					switch (direction) {
					case NORTH :
					default :
						worldIn.destroyBlock(left? new BlockPos(x + 1, y, z) : new BlockPos(x - 1, y, z), false);
						worldIn.destroyBlock(left? new BlockPos(x + 1, y - 1, z) : new BlockPos(x - 1, y - 1, z), false);
						worldIn.destroyBlock(left? new BlockPos(x + 1, y + 1, z) : new BlockPos(x - 1, y + 1, z), false);
						break;

					case SOUTH :
						worldIn.destroyBlock(left? new BlockPos(x - 1, y, z) : new BlockPos(x + 1, y, z), false);
						worldIn.destroyBlock(left? new BlockPos(x - 1, y - 1, z) : new BlockPos(x + 1, y - 1, z), false);
						worldIn.destroyBlock(left? new BlockPos(x - 1, y + 1, z) : new BlockPos(x + 1, y + 1, z), false);
						break;

					case EAST :
						worldIn.destroyBlock(left? new BlockPos(x, y, z + 1) : new BlockPos(x, y, z - 1), false);
						worldIn.destroyBlock(left? new BlockPos(x, y - 1, z + 1) : new BlockPos(x, y - 1, z - 1), false);
						worldIn.destroyBlock(left? new BlockPos(x, y + 1, z + 1) : new BlockPos(x, y + 1, z - 1), false);
						break;
						
					case WEST :
						worldIn.destroyBlock(left? new BlockPos(x, y, z - 1) : new BlockPos(x, y, z + 1), false);
						worldIn.destroyBlock(left? new BlockPos(x, y - 1, z - 1) : new BlockPos(x, y - 1, z + 1), false);
						worldIn.destroyBlock(left? new BlockPos(x, y + 1, z - 1) : new BlockPos(x, y + 1, z + 1), false);
						break;
					} // direction
					break; //case 2, UPPER
					
				case TOP :
					worldIn.destroyBlock(pos, mode? false : true);
					worldIn.destroyBlock(pos.below(), false);
					worldIn.destroyBlock(pos.below(2), false);
					
					switch (direction) {
					case NORTH :
					default :
						worldIn.destroyBlock(left? new BlockPos(x + 1, y, z) : new BlockPos(x - 1, y, z), false);
						worldIn.destroyBlock(left? new BlockPos(x + 1, y - 1, z) : new BlockPos(x - 1, y - 1, z), false);
						worldIn.destroyBlock(left? new BlockPos(x + 1, y - 2, z) : new BlockPos(x - 1, y - 2, z), false);
						break;

					case SOUTH :
						worldIn.destroyBlock(left? new BlockPos(x - 1, y, z) : new BlockPos(x + 1, y, z), false);
						worldIn.destroyBlock(left? new BlockPos(x - 1, y - 1, z) : new BlockPos(x + 1, y - 1, z), false);
						worldIn.destroyBlock(left? new BlockPos(x - 1, y - 2, z) : new BlockPos(x + 1, y - 2, z), false);
						break;

					case EAST :
						worldIn.destroyBlock(left? new BlockPos(x, y, z + 1) : new BlockPos(x, y, z - 1), false);
						worldIn.destroyBlock(left? new BlockPos(x, y - 1, z + 1) : new BlockPos(x, y - 1, z - 1), false);
						worldIn.destroyBlock(left? new BlockPos(x, y - 2, z + 1) : new BlockPos(x, y - 2, z - 1), false);
						break;
						
					case WEST :
						worldIn.destroyBlock(left? new BlockPos(x, y, z - 1) : new BlockPos(x, y, z + 1), false);
						worldIn.destroyBlock(left? new BlockPos(x, y - 1, z - 1) : new BlockPos(x, y - 1, z + 1), false);
						worldIn.destroyBlock(left? new BlockPos(x, y - 2, z - 1) : new BlockPos(x, y - 2, z + 1), false);
						break;
					} // direction
					break; //case 2, TOP
				}
				break; //case 2
			}
		}
	}

	/* @deprecated call via {@link IBlockState#getMobilityFlag()} whenever possible. Implementing/overriding is fine. */
	@Override
	public PushReaction getPistonPushReaction(BlockState state) {
		return PushReaction.DESTROY;
	}

	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(HALF, H_FACING, OPEN, HINGE, POWERED, STAGE_1_2, WATERLOGGED);
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_gate").withStyle(TextFormatting.GRAY));
	}
}
