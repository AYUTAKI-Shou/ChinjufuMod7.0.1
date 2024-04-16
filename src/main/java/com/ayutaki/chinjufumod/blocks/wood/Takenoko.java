package com.ayutaki.chinjufumod.blocks.wood;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.registry.Wood_Blocks;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SpreadingSnowyDirtBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Takenoko extends CM_WaterLogged {

	/* Property */
	public static final IntegerProperty STAGE_0_1 = IntegerProperty.create("stage", 0, 1);
	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 7.0D, 11.0D);

	public Takenoko(BlockBehaviour.Properties properties) {
		super(properties);
		/** Default state **/
		registerDefaultState(this.defaultBlockState().setValue(STAGE_0_1, Integer.valueOf(0))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* Gives a value when placed. */
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		Level worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);

		return this.defaultBlockState().setValue(STAGE_0_1, Integer.valueOf(0))
				.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER));
	}


	/* Update BlockState. */
	@Override
	public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
		BlockState dawnState = worldIn.getBlockState(pos.below());
		return dawnState.getBlock() instanceof SpreadingSnowyDirtBlock || dawnState.is(BlockTags.DIRT);
	}
	
	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos pos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			worldIn.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }
		
		return !(state.canSurvive(worldIn, pos)) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}

	/* TickRandom */
	@Override
	public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
		int i = state.getValue(STAGE_0_1);
		if (rand.nextInt(3) == 0 && worldIn.isEmptyBlock(pos.above()) && worldIn.getRawBrightness(pos.above(), 0) >= 9) {
			if (i != 1) { worldIn.setBlock(pos, state.setValue(STAGE_0_1, Integer.valueOf(i + 1)), 3); }
			if (i == 1) { this.placeBamboo(worldIn, pos, state); }
		}
	}
	
	protected void placeBamboo(ServerLevel worldIn, BlockPos pos, BlockState state) {
		worldIn.setBlock(pos, Wood_Blocks.TAKE.get().defaultBlockState()
				.setValue(Take_CM.WATERLOGGED, worldIn.getFluidState(pos).getType() == Fluids.WATER)
				.setValue(Take_CM.STAGE_0_15, Integer.valueOf(11)), 3);
		worldIn.setBlock(pos.above(), Wood_Blocks.TAKE.get().defaultBlockState()
				.setValue(Take_CM.WATERLOGGED, worldIn.getFluidState(pos.above()).getType() == Fluids.WATER)
				.setValue(Take_CM.STAGE_0_15, Integer.valueOf(0)), 3);
	}
	
	/* Collisions for each property. + .dynamicShape() */
	public BlockBehaviour.OffsetType getOffsetType() {
		return BlockBehaviour.OffsetType.XZ;
	}
	
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		Vec3 vector3d = state.getOffset(worldIn, pos);
		return AABB_BOX.move(vector3d.x, vector3d.y, vector3d.z);
	}
	
	@SuppressWarnings("deprecation")
	public float getDestroyProgress(BlockState state, Player entity, BlockGetter worldIn, BlockPos pos) {
		return entity.getMainHandItem().canPerformAction(net.minecraftforge.common.ToolActions.SWORD_DIG) ? 1.0F : super.getDestroyProgress(state, entity, worldIn, pos);
	}

	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(STAGE_0_1, WATERLOGGED);
	}
	
	/* ToolTip */
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.block_takenoko").withStyle(ChatFormatting.GRAY));
		tooltip.add(Component.translatable("tips.block_takenoko2").withStyle(ChatFormatting.GRAY));
	}
}
