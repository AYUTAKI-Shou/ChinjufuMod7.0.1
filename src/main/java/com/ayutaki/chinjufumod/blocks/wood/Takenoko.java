package com.ayutaki.chinjufumod.blocks.wood;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.registry.Wood_Blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SpreadableSnowyDirtBlock;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

public class Takenoko extends CM_WaterLogged {

	/* Property */
	public static final IntegerProperty STAGE_0_1 = IntegerProperty.create("stage", 0, 1);
	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 7.0D, 11.0D);

	public Takenoko(AbstractBlock.Properties properties) {
		super(properties);
		/** Default state **/
		registerDefaultState(this.defaultBlockState().setValue(STAGE_0_1, Integer.valueOf(0))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* Gives a value when placed. */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);

		return this.defaultBlockState().setValue(STAGE_0_1, Integer.valueOf(0))
				.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER));
	}


	/* Update BlockState. */
	@Override
	public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockState downState = worldIn.getBlockState(pos.below());
		return downState.getBlock() instanceof SpreadableSnowyDirtBlock || downState.getMaterial() == Material.DIRT;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.getValue(WATERLOGGED)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }
		
		if (!state.canSurvive(worldIn, pos)) { return Blocks.AIR.defaultBlockState(); } 
		
		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}

	/* TickRandom */
	@Override
	public boolean isRandomlyTicking(BlockState state) {
		return true;
	}
	
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		int i = state.getValue(STAGE_0_1);
		if (rand.nextInt(3) == 0 && worldIn.isEmptyBlock(pos.above()) && worldIn.getRawBrightness(pos.above(), 0) >= 9) {
			if (i != 1) { worldIn.setBlock(pos, state.setValue(STAGE_0_1, Integer.valueOf(i + 1)), 3); }
			if (i == 1) { this.placeBamboo(worldIn, pos, state); }
		}
	}
	
	protected void placeBamboo(World worldIn, BlockPos pos, BlockState state) {
		worldIn.setBlock(pos, Wood_Blocks.TAKE.defaultBlockState()
				.setValue(Take_CM.WATERLOGGED, worldIn.getFluidState(pos).getType() == Fluids.WATER)
				.setValue(Take_CM.STAGE_0_15, Integer.valueOf(11)), 3);
		worldIn.setBlock(pos.above(), Wood_Blocks.TAKE.defaultBlockState()
				.setValue(Take_CM.WATERLOGGED, worldIn.getFluidState(pos.above()).getType() == Fluids.WATER)
				.setValue(Take_CM.STAGE_0_15, Integer.valueOf(0)), 3);
	}
	
	/* Collisions for each property. */
	public AbstractBlock.OffsetType getOffsetType() {
		return AbstractBlock.OffsetType.XZ;
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Vector3d vector3d = state.getOffset(worldIn, pos);
		return AABB_BOX.move(vector3d.x, vector3d.y, vector3d.z);
	}
	
	@SuppressWarnings("deprecation")
	public float getDestroyProgress(BlockState state, PlayerEntity entity, IBlockReader worldIn, BlockPos pos) {
		return entity.getMainHandItem().getItem() instanceof SwordItem ? 1.0F : super.getDestroyProgress(state, entity, worldIn, pos);
	}

	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(STAGE_0_1, WATERLOGGED);
	}
	
	/* The best harvesting tool. */
	@Nullable
	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.HOE;
	}

	@Override
	public int getHarvestLevel(BlockState state) {
		return 0;
	}
	
	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_takenoko").withStyle(TextFormatting.GRAY));
		tooltip.add(new TranslationTextComponent("tips.block_takenoko2").withStyle(TextFormatting.GRAY));
	}
}
