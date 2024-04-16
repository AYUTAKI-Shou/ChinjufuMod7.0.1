package com.ayutaki.chinjufumod.blocks.amado;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage2_FaceWater;
import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Slidedoor_Blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

public class TobukuroWindow extends CM_WaterLogged {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final IntegerProperty STAGE_1_3 = IntegerProperty.create("stage", 1, 3);
	public static final BooleanProperty WHICH = BooleanProperty.create("which");

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.box(-0.5D, -0.5D, 0.0D, 16.5D, 16.5D, 3.0D);
	protected static final VoxelShape AABB_WEST = Block.box(13.0D, -0.5D, -0.5D, 16.0D, 16.5D, 16.5D);
	protected static final VoxelShape AABB_NORTH = Block.box(-0.5D, -0.5D, 13.0D, 16.5D, 16.5D, 16.0D);
	protected static final VoxelShape AABB_EAST = Block.box(0.0D, -0.5D, -0.5D, 3.0D, 16.5D, 16.5D);

	/** 1=2枚、2=1枚、3=0枚 **/
	public TobukuroWindow(AbstractBlock.Properties properties) {
		super(properties);

		/** Default state **/
		registerDefaultState(this.defaultBlockState().setValue(H_FACING, Direction.NORTH)
				.setValue(STAGE_1_3, Integer.valueOf(1))
				.setValue(WHICH, Boolean.valueOf(false))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		/** 1=2枚、2=1枚、3=0枚 **/
		int i = state.getValue(STAGE_1_3);
		Direction direction = state.getValue(H_FACING);
		boolean which = state.getValue(WHICH);

		BlockState northState = worldIn.getBlockState(pos.north());
		BlockState southState = worldIn.getBlockState(pos.south());
		BlockState eastState = worldIn.getBlockState(pos.east());
		BlockState westState = worldIn.getBlockState(pos.west());

		if (i != 3) {
			CMEvents.soundAmadoWin(worldIn, pos);
			
			if (which != true) {
				BlockState AMADOWIN_FACE1 = this.takeBlock().defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING)).setValue(BaseStage2_FaceWater.STAGE_1_2, Integer.valueOf(1));
				
				switch (direction) {
				case NORTH:
				default:
					if (westState.getMaterial().isReplaceable()) {
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(i + 1)), 3);
						worldIn.setBlock(pos.west(), AMADOWIN_FACE1, 3); }
					
					if (!westState.getMaterial().isReplaceable()) { }
					break;

				case SOUTH:
					if (eastState.getMaterial().isReplaceable()) {
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(i + 1)), 3);
						worldIn.setBlock(pos.east(), AMADOWIN_FACE1, 3); }
					
					if (!eastState.getMaterial().isReplaceable()) { }
					break;

				case EAST:
					if (northState.getMaterial().isReplaceable()) {
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(i + 1)), 3);
						worldIn.setBlock(pos.north(), AMADOWIN_FACE1, 3); }
					
					if (!northState.getMaterial().isReplaceable()) { }
					break;
					
				case WEST:
					if (southState.getMaterial().isReplaceable()) {
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(i + 1)), 3);
						worldIn.setBlock(pos.south(), AMADOWIN_FACE1, 3); }
					
					if (!southState.getMaterial().isReplaceable()) { }
					break;
				} // switch
			}

			if (which == true) {
				BlockState AMADOWIN_FACE2 = this.takeBlock().defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING)).setValue(BaseStage2_FaceWater.STAGE_1_2, Integer.valueOf(2));
				
				switch (direction) {
				case NORTH:
				default:
					if (eastState.getMaterial().isReplaceable()) {
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(i + 1)), 3);
						worldIn.setBlock(pos.east(), AMADOWIN_FACE2, 3); }
					
					if (!eastState.getMaterial().isReplaceable()) { }
					break;

				case SOUTH:
					if (westState.getMaterial().isReplaceable()) {
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(i + 1)), 3);
						worldIn.setBlock(pos.west(), AMADOWIN_FACE2, 3); }
					
					if (!westState.getMaterial().isReplaceable()) { }
					break;

				case EAST:
					if (southState.getMaterial().isReplaceable()) {
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(i + 1)), 3);
						worldIn.setBlock(pos.south(), AMADOWIN_FACE2, 3); }
					
					if (!southState.getMaterial().isReplaceable()) { }
					break;
					
				case WEST:
					if (northState.getMaterial().isReplaceable()) {
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(i + 1)), 3);
						worldIn.setBlock(pos.north(), AMADOWIN_FACE2, 3); }
					
					if (!northState.getMaterial().isReplaceable()) { }
					break;
				} // switch
			}
		} // i != 3
		
		if (i == 3) { CMEvents.textIsEmpty(worldIn, pos, playerIn); }
		
		return ActionResultType.SUCCESS;
	}

	private Block takeBlock() {
		if (this == Slidedoor_Blocks.TOBUKUROWIN) { return Slidedoor_Blocks.AMADOWIN; }
		if (this == Slidedoor_Blocks.TOBUKUROWIN_S) { return Slidedoor_Blocks.AMADOWIN_S; }
		return null;
	}
	
	/* Gives a value when placed. */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);
		PlayerEntity playerIn = context.getPlayer();

		if (playerIn.isCrouching()) {
			return this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection().getOpposite())
					.setValue(STAGE_1_3, Integer.valueOf(1))
					.setValue(WHICH, Boolean.valueOf(true))
					.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)); }

		return this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection().getOpposite())
				.setValue(STAGE_1_3, Integer.valueOf(1))
				.setValue(WHICH, Boolean.valueOf(false))
				.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER));
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
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
		}
		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}

	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(H_FACING, STAGE_1_3, WHICH, WATERLOGGED);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.getValue(H_FACING);

		switch (direction) {
		case NORTH:
		default: return AABB_NORTH;
		case SOUTH: return AABB_SOUTH;
		case EAST: return AABB_EAST;
		case WEST: return AABB_WEST;
		} // switch
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
		tooltip.add(new TranslationTextComponent("tips.block_tobukuro").withStyle(TextFormatting.GRAY));
	}
}
