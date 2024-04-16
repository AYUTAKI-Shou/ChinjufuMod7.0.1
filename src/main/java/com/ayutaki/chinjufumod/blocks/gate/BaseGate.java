package com.ayutaki.chinjufumod.blocks.gate;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Gate_Blocks;
import com.ayutaki.chinjufumod.state.TripleGate;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.PushReaction;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
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
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");
	public static final IntegerProperty STAGE_1_2 = IntegerProperty.create("stage", 1, 2);

	public BaseGate(Block.Properties properties) {
		super(properties);
		
		/** Default state **/
		setDefaultState(this.stateContainer.getBaseState().with(H_FACING, Direction.NORTH)
				.with(STAGE_1_2, Integer.valueOf(1))
				.with(OPEN, Boolean.valueOf(false))
				.with(HINGE, DoorHingeSide.LEFT)
				.with(POWERED, Boolean.valueOf(false))
				.with(HALF, TripleGate.LOWER)
				.with(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {
		return ActionResultType.FAIL;
	}
	
	/* Get POWER. */
	public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
		int i = state.get(STAGE_1_2);
		TripleGate half = state.get(HALF);
		DoorHingeSide hinge = state.get(HINGE);
		Direction direction = state.get(H_FACING);
		
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();

		/** Power Flag **/
		boolean flag = worldIn.isBlockPowered(pos) || worldIn.isBlockPowered(pos.offset(state.get(HALF) == TripleGate.LOWER ? Direction.UP : Direction.DOWN));

		BlockState directFlag = this.getDefaultState().with(H_FACING, direction).with(OPEN, Boolean.valueOf(flag));
		
		BlockState Top_LEFT1 = directFlag.with(STAGE_1_2, Integer.valueOf(1)).with(HALF, TripleGate.TOP).with(HINGE, DoorHingeSide.LEFT);
		BlockState Up_LEFT1 = directFlag.with(STAGE_1_2, Integer.valueOf(1)).with(HALF, TripleGate.UPPER).with(HINGE, DoorHingeSide.LEFT);
		BlockState Low_LEFT1 = directFlag.with(STAGE_1_2, Integer.valueOf(1)).with(HALF, TripleGate.LOWER).with(HINGE, DoorHingeSide.LEFT);
		BlockState Top_LEFT2 = directFlag.with(STAGE_1_2, Integer.valueOf(2)).with(HALF, TripleGate.TOP).with(HINGE, DoorHingeSide.LEFT);
		BlockState Up_LEFT2 = directFlag.with(STAGE_1_2, Integer.valueOf(2)).with(HALF, TripleGate.UPPER).with(HINGE, DoorHingeSide.LEFT);
		BlockState Low_LEFT2 = directFlag.with(STAGE_1_2, Integer.valueOf(2)).with(HALF, TripleGate.LOWER).with(HINGE, DoorHingeSide.LEFT);

		BlockState Top_RIGHT1 = directFlag.with(STAGE_1_2, Integer.valueOf(1)).with(HALF, TripleGate.TOP).with(HINGE, DoorHingeSide.RIGHT);
		BlockState Up_RIGHT1 = directFlag.with(STAGE_1_2, Integer.valueOf(1)).with(HALF, TripleGate.UPPER).with(HINGE, DoorHingeSide.RIGHT);
		BlockState Low_RIGHT1 = directFlag.with(STAGE_1_2, Integer.valueOf(1)).with(HALF, TripleGate.LOWER).with(HINGE, DoorHingeSide.RIGHT);
		BlockState Top_RIGHT2 = directFlag.with(STAGE_1_2, Integer.valueOf(2)).with(HALF, TripleGate.TOP).with(HINGE, DoorHingeSide.RIGHT);
		BlockState Up_RIGHT2 = directFlag.with(STAGE_1_2, Integer.valueOf(2)).with(HALF, TripleGate.UPPER).with(HINGE, DoorHingeSide.RIGHT);
		BlockState Low_RIGHT2 = directFlag.with(STAGE_1_2, Integer.valueOf(2)).with(HALF, TripleGate.LOWER).with(HINGE, DoorHingeSide.RIGHT);

		if (block != this && flag != state.get(POWERED) && half != TripleGate.TOP) {
			if (flag != state.get(OPEN)) { this.moveSound(worldIn, pos, flag); }
			worldIn.setBlockState(pos, state.with(POWERED, Boolean.valueOf(flag)).with(OPEN, Boolean.valueOf(flag)), 2);
			
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
						worldIn.setBlockState(pos.up(2), Top_LEFT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.up(2)).getFluid() == Fluids.WATER)), 2);
						worldIn.setBlockState(pos.up(), Up_LEFT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.up()).getFluid() == Fluids.WATER)), 2);
						
						switch (direction) {
						case NORTH :
						default :
							worldIn.setBlockState(new BlockPos(x - 1, y + 2, z), Top_LEFT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y + 2, z)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), Up_LEFT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y + 1, z)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x - 1, y, z), Low_LEFT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y, z)).getFluid() == Fluids.WATER)), 2);
							break;

						case SOUTH :
							worldIn.setBlockState(new BlockPos(x + 1, y + 2, z), Top_LEFT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y + 2, z)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), Up_LEFT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y + 1, z)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x + 1, y, z), Low_LEFT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y, z)).getFluid() == Fluids.WATER)), 2);
							break;

						case EAST :
							worldIn.setBlockState(new BlockPos(x, y + 2, z - 1), Top_LEFT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 2, z - 1)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), Up_LEFT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z - 1)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x, y, z - 1), Low_LEFT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z - 1)).getFluid() == Fluids.WATER)), 2);
							break;
							
						case WEST :
							worldIn.setBlockState(new BlockPos(x, y + 2, z + 1), Top_LEFT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 2, z + 1)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), Up_LEFT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z + 1)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x, y, z + 1), Low_LEFT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z + 1)).getFluid() == Fluids.WATER)), 2);
							break;
						} // direction
						break;

					case RIGHT :
						worldIn.setBlockState(pos.up(2), Top_RIGHT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.up(2)).getFluid() == Fluids.WATER)), 2);
						worldIn.setBlockState(pos.up(), Up_RIGHT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.up()).getFluid() == Fluids.WATER)), 2);
						
						switch (direction) {
						case NORTH :
						default :
							worldIn.setBlockState(new BlockPos(x + 1, y + 2, z), Top_RIGHT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y + 2, z)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), Up_RIGHT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y + 1, z)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x + 1, y, z), Low_RIGHT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y, z)).getFluid() == Fluids.WATER)), 2);
							break;

						case SOUTH :
							worldIn.setBlockState(new BlockPos(x - 1, y + 2, z), Top_RIGHT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y + 2, z)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), Up_RIGHT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y + 1, z)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x - 1, y, z), Low_RIGHT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y, z)).getFluid() == Fluids.WATER)), 2);
							break;

						case EAST :
							worldIn.setBlockState(new BlockPos(x, y + 2, z + 1), Top_RIGHT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 2, z + 1)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), Up_RIGHT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z + 1)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x, y, z + 1), Low_RIGHT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z + 1)).getFluid() == Fluids.WATER)), 2);
							break;
							
						case WEST :
							worldIn.setBlockState(new BlockPos(x, y + 2, z - 1), Top_RIGHT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 2, z - 1)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), Up_RIGHT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z - 1)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x, y, z - 1), Low_RIGHT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z - 1)).getFluid() == Fluids.WATER)), 2);
							break;
						} // direction
						break;
					} // LEFT-RIGHT
					break;


				case UPPER :
					switch (hinge) {
					case LEFT :
					default :
						worldIn.setBlockState(pos.up(), Top_LEFT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.up()).getFluid() == Fluids.WATER)), 2);
						worldIn.setBlockState(pos.down(), Low_LEFT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.down()).getFluid() == Fluids.WATER)), 2);
						
						switch (direction) {
						case NORTH :
						default :
							worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), Top_LEFT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y + 1, z)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x - 1, y, z), Up_LEFT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y, z)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x - 1, y - 1, z), Low_LEFT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y - 1, z)).getFluid() == Fluids.WATER)), 2);
							break;

						case SOUTH :
							worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), Top_LEFT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y + 1, z)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x + 1, y, z), Up_LEFT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y, z)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x + 1, y - 1, z), Low_LEFT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y - 1, z)).getFluid() == Fluids.WATER)), 2);
							break;

						case EAST :
							worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), Top_LEFT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z - 1)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x, y, z - 1), Up_LEFT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z - 1)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x, y - 1, z - 1), Low_LEFT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y - 1, z - 1)).getFluid() == Fluids.WATER)), 2);
							break;
							
						case WEST :
							worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), Top_LEFT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z + 1)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x, y, z + 1), Up_LEFT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z + 1)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x, y - 1, z + 1), Low_LEFT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y - 1, z + 1)).getFluid() == Fluids.WATER)), 2);
							break;
						} // direction
						break;

					case RIGHT :
						worldIn.setBlockState(pos.up(), Top_RIGHT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.up()).getFluid() == Fluids.WATER)), 2);
						worldIn.setBlockState(pos.down(), Low_RIGHT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.down()).getFluid() == Fluids.WATER)), 2);
						
						switch (direction) {
						case NORTH :
						default :
							worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), Top_RIGHT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y + 1, z)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x + 1, y, z), Up_RIGHT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y, z)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x + 1, y - 1, z), Low_RIGHT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y - 1, z)).getFluid() == Fluids.WATER)), 2);
							break;

						case SOUTH :
							worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), Top_RIGHT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y + 1, z)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x - 1, y, z), Up_RIGHT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y, z)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x - 1, y - 1, z), Low_RIGHT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y - 1, z)).getFluid() == Fluids.WATER)), 2);
							break;

						case EAST :
							worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), Top_RIGHT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z + 1)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x, y, z + 1), Up_RIGHT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z + 1)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x, y - 1, z + 1), Low_RIGHT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y - 1, z + 1)).getFluid() == Fluids.WATER)), 2);
							break;
							
						case WEST :
							worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), Top_RIGHT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z - 1)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x, y, z - 1), Up_RIGHT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z - 1)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x, y - 1, z - 1), Low_RIGHT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y - 1, z - 1)).getFluid() == Fluids.WATER)), 2);
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
						worldIn.setBlockState(pos.up(2), Top_LEFT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.up(2)).getFluid() == Fluids.WATER)), 2);
						worldIn.setBlockState(pos.up(), Up_LEFT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.up()).getFluid() == Fluids.WATER)), 2);

						switch (direction) {
						case NORTH :
						default :
							worldIn.setBlockState(new BlockPos(x + 1, y + 2, z), Top_LEFT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y + 2, z)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), Up_LEFT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y + 1, z)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x + 1, y, z), Low_LEFT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y, z)).getFluid() == Fluids.WATER)), 2);
							break;

						case SOUTH :
							worldIn.setBlockState(new BlockPos(x - 1, y + 2, z), Top_LEFT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y + 2, z)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), Up_LEFT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y + 1, z)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x - 1, y, z), Low_LEFT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y, z)).getFluid() == Fluids.WATER)), 2);
							break;

						case EAST :
							worldIn.setBlockState(new BlockPos(x, y + 2, z + 1), Top_LEFT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 2, z + 1)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), Up_LEFT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z + 1)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x, y, z + 1), Low_LEFT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z + 1)).getFluid() == Fluids.WATER)), 2);
							break;
							
						case WEST :
							worldIn.setBlockState(new BlockPos(x, y + 2, z - 1), Top_LEFT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 2, z - 1)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), Up_LEFT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z - 1)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x, y, z - 1), Low_LEFT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z - 1)).getFluid() == Fluids.WATER)), 2);
							break;
						} // direction
						break;

					case RIGHT :
						worldIn.setBlockState(pos.up(2), Top_RIGHT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.up(2)).getFluid() == Fluids.WATER)), 2);
						worldIn.setBlockState(pos.up(), Up_RIGHT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.up()).getFluid() == Fluids.WATER)), 2);
	
						switch (direction) {
						case NORTH :
						default :
							worldIn.setBlockState(new BlockPos(x - 1, y + 2, z), Top_RIGHT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y + 2, z)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), Up_RIGHT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y + 1, z)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x - 1, y, z), Low_RIGHT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y, z)).getFluid() == Fluids.WATER)), 2);
							break;

						case SOUTH :
							worldIn.setBlockState(new BlockPos(x + 1, y + 2, z), Top_RIGHT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y + 2, z)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), Up_RIGHT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y + 1, z)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x + 1, y, z), Low_RIGHT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y, z)).getFluid() == Fluids.WATER)), 2);
							break;

						case EAST :
							worldIn.setBlockState(new BlockPos(x, y + 2, z - 1), Top_RIGHT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 2, z - 1)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), Up_RIGHT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z - 1)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x, y, z - 1), Low_RIGHT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z - 1)).getFluid() == Fluids.WATER)), 2);
							break;
							
						case WEST :
							worldIn.setBlockState(new BlockPos(x, y + 2, z + 1), Top_RIGHT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 2, z + 1)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), Up_RIGHT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z + 1)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x, y, z + 1), Low_RIGHT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z + 1)).getFluid() == Fluids.WATER)), 2);
							break;
						} // direction
						break;
					} // LEFT-RIGHT
					break;

				case UPPER :
					switch (hinge) {
					case LEFT :
					default :
						worldIn.setBlockState(pos.up(), Top_LEFT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.up()).getFluid() == Fluids.WATER)), 2);
						worldIn.setBlockState(pos.down(), Low_LEFT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.down()).getFluid() == Fluids.WATER)), 2);

						switch (direction) {
						case NORTH :
						default :
							worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), Top_LEFT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y + 1, z)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x + 1, y, z), Up_LEFT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y, z)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x + 1, y - 1, z), Low_LEFT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y - 1, z)).getFluid() == Fluids.WATER)), 2);
							break;

						case SOUTH :
							worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), Top_LEFT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y + 1, z)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x - 1, y, z), Up_LEFT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y, z)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x - 1, y - 1, z), Low_LEFT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y - 1, z)).getFluid() == Fluids.WATER)), 2);
							break;

						case EAST :
							worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), Top_LEFT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z + 1)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x, y, z + 1), Up_LEFT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z + 1)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x, y - 1, z + 1), Low_LEFT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y - 1, z + 1)).getFluid() == Fluids.WATER)), 2);
							break;
							
						case WEST :
							worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), Top_LEFT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z - 1)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x, y, z - 1), Up_LEFT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z - 1)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x, y - 1, z - 1), Low_LEFT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y - 1, z - 1)).getFluid() == Fluids.WATER)), 2);
							break;
						} // direction
						break;

					case RIGHT :
						worldIn.setBlockState(pos.up(), Top_RIGHT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.up()).getFluid() == Fluids.WATER)), 2);
						worldIn.setBlockState(pos.down(), Low_RIGHT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.down()).getFluid() == Fluids.WATER)), 2);

						switch (direction) {
						case NORTH :
						default :
							worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), Top_RIGHT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y + 1, z)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x - 1, y, z), Up_RIGHT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y, z)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x - 1, y - 1, z), Low_RIGHT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y - 1, z)).getFluid() == Fluids.WATER)), 2);
							break;

						case SOUTH :
							worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), Top_RIGHT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y + 1, z)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x + 1, y, z), Up_RIGHT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y, z)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x + 1, y - 1, z), Low_RIGHT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y - 1, z)).getFluid() == Fluids.WATER)), 2);
							break;

						case EAST :
							worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), Top_RIGHT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z - 1)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x, y, z - 1), Up_RIGHT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z - 1)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x, y - 1, z - 1), Low_RIGHT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y - 1, z - 1)).getFluid() == Fluids.WATER)), 2);
							break;
							
						case WEST :
							worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), Top_RIGHT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z + 1)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x, y, z + 1), Up_RIGHT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z + 1)).getFluid() == Fluids.WATER)), 2);
							worldIn.setBlockState(new BlockPos(x, y - 1, z + 1), Low_RIGHT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y - 1, z + 1)).getFluid() == Fluids.WATER)), 2);
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

		if (isOpening == false) {
			worldIn.playSound(null, pos, flag? SoundEvents_CM.GATE_WOOD : (flag1? SoundEvents_CM.GATE_IRON_CLOSE : SoundEvents_CM.GATE_IRON_OPEN), SoundCategory.BLOCKS, 1.0F, 1.0F); }
	}
	
	
	/* Gives a value when placed. */
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getWorld();
		BlockPos pos = context.getPos();
		IFluidState fluid = worldIn.getFluidState(pos);
		PlayerEntity playerIn = context.getPlayer();

		/** pos.up() = Replaceable block. **/
		if (pos.getY() < 255 && worldIn.getBlockState(pos.up()).isReplaceable(context)) {
			/** Power Flag **/
			boolean flag = worldIn.isBlockPowered(pos) || worldIn.isBlockPowered(pos.up());

			Direction facing = playerIn.getHorizontalFacing();
			double x = (double) pos.getX();
			double y = (double) pos.getY();
			double z = (double) pos.getZ();
			
			BlockState directFlag = this.getDefaultState().with(H_FACING, context.getPlacementHorizontalFacing())
					.with(STAGE_1_2, Integer.valueOf(1)).with(POWERED, Boolean.valueOf(flag)).with(OPEN, Boolean.valueOf(flag));
			
			BlockState Right = directFlag.with(HINGE, DoorHingeSide.RIGHT).with(HALF, TripleGate.LOWER)
					.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER));
			BlockState Left = directFlag.with(HINGE, DoorHingeSide.LEFT).with(HALF, TripleGate.LOWER)
					.with(WATERLOGGED, Boolean.valueOf(fluid.getFluid() == Fluids.WATER));
			
			if (playerIn.isCrouching()) {
				if (facing == Direction.NORTH && worldIn.getBlockState(new BlockPos(x + 1, y, z)).isReplaceable(context)) { return Right; }
				if (facing == Direction.SOUTH && worldIn.getBlockState(new BlockPos(x - 1, y, z)).isReplaceable(context)) { return Right; }
				if (facing == Direction.EAST && worldIn.getBlockState(new BlockPos(x, y, z + 1)).isReplaceable(context)) { return Right; }
				if (facing == Direction.WEST && worldIn.getBlockState(new BlockPos(x, y, z - 1)).isReplaceable(context)) { return Right; }
				else { 
					CMEvents.textNoPlace(context.getWorld(), context.getPos(), context.getPlayer());
					return null; } } //isCrouching()
			
			if (facing == Direction.NORTH && worldIn.getBlockState(new BlockPos(x - 1, y, z)).isReplaceable(context)) { return Left; }
			if (facing == Direction.SOUTH && worldIn.getBlockState(new BlockPos(x + 1, y, z)).isReplaceable(context)) { return Left; }
			if (facing == Direction.EAST && worldIn.getBlockState(new BlockPos(x, y, z - 1)).isReplaceable(context)) { return Left; }
			if (facing == Direction.WEST && worldIn.getBlockState(new BlockPos(x, y, z + 1)).isReplaceable(context)) { return Left; }
			
			else { 
				CMEvents.textNoPlace(context.getWorld(), context.getPos(), context.getPlayer());
				return null; }
		}

		else { 
			CMEvents.textNoPlace(context.getWorld(), context.getPos(), context.getPlayer());
			return null; }
	}

	/* Add TripleGate.UPPER on the Block. */
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {

		Direction facing = placer.getHorizontalFacing();
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();

		BlockState directOnly = this.getDefaultState().with(H_FACING, state.get(H_FACING));
		
		if (placer.isCrouching()) {
			BlockState Up_RIGHT1 = directOnly.with(STAGE_1_2, Integer.valueOf(1)).with(HALF, TripleGate.UPPER).with(HINGE, DoorHingeSide.RIGHT);
			BlockState Top_RIGHT1 = directOnly.with(STAGE_1_2, Integer.valueOf(1)).with(HALF, TripleGate.TOP).with(HINGE, DoorHingeSide.RIGHT);
			
			BlockState Top_RIGHT2 = directOnly.with(STAGE_1_2, Integer.valueOf(2)).with(HALF, TripleGate.TOP).with(HINGE, DoorHingeSide.RIGHT);
			BlockState Up_RIGHT2 = directOnly.with(STAGE_1_2, Integer.valueOf(2)).with(HALF, TripleGate.UPPER).with(HINGE, DoorHingeSide.RIGHT);
			BlockState Low_RIGHT2 = directOnly.with(STAGE_1_2, Integer.valueOf(2)).with(HALF, TripleGate.LOWER).with(HINGE, DoorHingeSide.RIGHT);
			
			worldIn.setBlockState(pos.up(2), Top_RIGHT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.up(2)).getFluid() == Fluids.WATER)), 3);
			worldIn.setBlockState(pos.up(), Up_RIGHT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.up()).getFluid() == Fluids.WATER)), 3);

			switch (facing) {
			case NORTH :
			default :
				worldIn.setBlockState(new BlockPos(x + 1, y + 2, z), Top_RIGHT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y + 2, z)).getFluid() == Fluids.WATER)), 3);
				worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), Up_RIGHT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y + 1, z)).getFluid() == Fluids.WATER)), 3);
				worldIn.setBlockState(new BlockPos(x + 1, y, z), Low_RIGHT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y, z)).getFluid() == Fluids.WATER)), 3);
				break;

			case SOUTH :
				worldIn.setBlockState(new BlockPos(x - 1, y + 2, z), Top_RIGHT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y + 2, z)).getFluid() == Fluids.WATER)), 3);
				worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), Up_RIGHT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y + 1, z)).getFluid() == Fluids.WATER)), 3);
				worldIn.setBlockState(new BlockPos(x - 1, y, z), Low_RIGHT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y, z)).getFluid() == Fluids.WATER)), 3);
				break;

			case EAST :
				worldIn.setBlockState(new BlockPos(x, y + 2, z + 1), Top_RIGHT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 2, z + 1)).getFluid() == Fluids.WATER)), 3);
				worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), Up_RIGHT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z + 1)).getFluid() == Fluids.WATER)), 3);
				worldIn.setBlockState(new BlockPos(x, y, z + 1), Low_RIGHT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z + 1)).getFluid() == Fluids.WATER)), 3);
				break;
				
			case WEST :
				worldIn.setBlockState(new BlockPos(x, y + 2, z - 1), Top_RIGHT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 2, z - 1)).getFluid() == Fluids.WATER)), 3);
				worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), Up_RIGHT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z - 1)).getFluid() == Fluids.WATER)), 3);
				worldIn.setBlockState(new BlockPos(x, y, z - 1), Low_RIGHT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z - 1)).getFluid() == Fluids.WATER)), 3);
				break;
			} // direction
		} //placer.isCrouching()
		
		if (!placer.isCrouching()) {
			BlockState Up_LEFT1 = directOnly.with(STAGE_1_2, Integer.valueOf(1)).with(HALF, TripleGate.UPPER).with(HINGE, DoorHingeSide.LEFT);
			BlockState Top_LEFT1 = directOnly.with(STAGE_1_2, Integer.valueOf(1)).with(HALF, TripleGate.TOP).with(HINGE, DoorHingeSide.LEFT);
			
			BlockState Top_LEFT2 = directOnly.with(STAGE_1_2, Integer.valueOf(2)).with(HALF, TripleGate.TOP).with(HINGE, DoorHingeSide.LEFT);
			BlockState Up_LEFT2 = directOnly.with(STAGE_1_2, Integer.valueOf(2)).with(HALF, TripleGate.UPPER).with(HINGE, DoorHingeSide.LEFT);
			BlockState Low_LEFT2 = directOnly.with(STAGE_1_2, Integer.valueOf(2)).with(HALF, TripleGate.LOWER).with(HINGE, DoorHingeSide.LEFT);
			
			worldIn.setBlockState(pos.up(2), Top_LEFT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.up(2)).getFluid() == Fluids.WATER)), 3);
			worldIn.setBlockState(pos.up(), Up_LEFT1.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.up()).getFluid() == Fluids.WATER)), 3);

			switch (facing) {
			case NORTH :
			default :
				worldIn.setBlockState(new BlockPos(x - 1, y + 2, z), Top_LEFT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y + 2, z)).getFluid() == Fluids.WATER)), 3);
				worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), Up_LEFT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y + 1, z)).getFluid() == Fluids.WATER)), 3);
				worldIn.setBlockState(new BlockPos(x - 1, y, z), Low_LEFT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x - 1, y, z)).getFluid() == Fluids.WATER)), 3);
				break;

			case SOUTH :
				worldIn.setBlockState(new BlockPos(x + 1, y + 2, z), Top_LEFT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y + 2, z)).getFluid() == Fluids.WATER)), 3);
				worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), Up_LEFT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y + 1, z)).getFluid() == Fluids.WATER)), 3);
				worldIn.setBlockState(new BlockPos(x + 1, y, z), Low_LEFT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x + 1, y, z)).getFluid() == Fluids.WATER)), 3);
				break;

			case EAST :
				worldIn.setBlockState(new BlockPos(x, y + 2, z - 1), Top_LEFT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 2, z - 1)).getFluid() == Fluids.WATER)), 3);
				worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), Up_LEFT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z - 1)).getFluid() == Fluids.WATER)), 3);
				worldIn.setBlockState(new BlockPos(x, y, z - 1), Low_LEFT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z - 1)).getFluid() == Fluids.WATER)), 3);
				break;
				
			case WEST :
				worldIn.setBlockState(new BlockPos(x, y + 2, z + 1), Top_LEFT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 2, z + 1)).getFluid() == Fluids.WATER)), 3);
				worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), Up_LEFT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y + 1, z + 1)).getFluid() == Fluids.WATER)), 3);
				worldIn.setBlockState(new BlockPos(x, y, z + 1), Low_LEFT2.with(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(new BlockPos(x, y, z + 1)).getFluid() == Fluids.WATER)), 3);
				break;
			} // direction
		} //!placer.isCrouching()
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(H_FACING, rot.rotate(state.get(H_FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return mirrorIn == Mirror.NONE ? state : state.rotate(mirrorIn.toRotation(state.get(H_FACING))).cycle(HINGE);
	}

	/* Return a random long to be passed to {@link IBakedModel#getQuads}, used for random model rotations */
	@OnlyIn(Dist.CLIENT)
	public long getPositionRandom(BlockState state, BlockPos pos) {
		return MathHelper.getCoordinateRandom(pos.getX(), pos.down(state.get(HALF) == TripleGate.LOWER ? 0 : 1).getY(), pos.getZ());
	}

	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		BlockState state1 = super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
		if (!state1.isAir(worldIn, pos)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn)); }

		return super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
	}

	@Override
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.MODEL;
	}

	public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
		switch(type) {
		case LAND:
			return state.get(OPEN);
		case WATER:
			return false;
		case AIR:
			return state.get(OPEN);
		default:
			return false;
		}
	}

	/* Destroy a DoubleBlock from DoublePlantBlock.class */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {
		int i = state.get(STAGE_1_2);
		Direction direction = state.get(H_FACING);
		TripleGate half = state.get(HALF);

		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();

		boolean mode = playerIn.abilities.isCreativeMode;
		boolean left = (state.get(HINGE) == DoorHingeSide.LEFT);
		
		if (!worldIn.isRemote) {
			switch (i) {
			case 1 :
			default :
				switch (half) {
				case LOWER :
				default :
					worldIn.destroyBlock(pos, mode? false : true);
					worldIn.destroyBlock(pos.up(), false);
					worldIn.destroyBlock(pos.up(2), false);
					
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
					worldIn.destroyBlock(pos.down(), false);
					worldIn.destroyBlock(pos.up(), false);
					
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
					worldIn.destroyBlock(pos.down(), false);
					worldIn.destroyBlock(pos.down(2), false);
					
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
					worldIn.destroyBlock(pos.up(), false);
					worldIn.destroyBlock(pos.up(2), false);
					
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
					worldIn.destroyBlock(pos.down(), false);
					worldIn.destroyBlock(pos.up(), false);
					
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
					worldIn.destroyBlock(pos.down(), false);
					worldIn.destroyBlock(pos.down(2), false);
					
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
	public PushReaction getPushReaction(BlockState state) {
		return PushReaction.DESTROY;
	}

	/* Create Blockstate */
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(HALF, H_FACING, OPEN, HINGE, POWERED, STAGE_1_2, WATERLOGGED);
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
	
	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_gate").applyTextStyle(TextFormatting.GRAY));
	}
}
