package com.ayutaki.chinjufumod.blocks.wood;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.registry.Wood_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SpreadableSnowyDirtBlock;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
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

public class Takenoko extends CM_WaterLogged {
	
	/* Property */
	public static final IntegerProperty STAGE_0_1 = IntegerProperty.create("stage", 0, 1);
	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.makeCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 7.0D, 11.0D);

	public Takenoko(Block.Properties properties) {
		super(properties);
		/** Default state **/
		setDefaultState(this.stateContainer.getBaseState().with(STAGE_0_1, Integer.valueOf(0))
				.with(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* Gives a value when placed. */
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getWorld();
		BlockPos pos = context.getPos();
		IFluidState fluid = worldIn.getFluidState(pos);
		
		return this.getDefaultState().with(STAGE_0_1, Integer.valueOf(0))
				.with(WATERLOGGED, fluid.getFluid() == Fluids.WATER);
	}
	
	/* Update BlockState. */
	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockState downState = worldIn.getBlockState(pos.down());
		return downState.getBlock() instanceof SpreadableSnowyDirtBlock || downState.getMaterial() == Material.EARTH;
	}

	@SuppressWarnings("deprecation")
	@Override
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn)); }
		
		if (!state.isValidPosition(worldIn, pos)) { return Blocks.AIR.getDefaultState(); } 
		
		return super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
	}
	
	/* TickRandom */
	public boolean ticksRandomly(BlockState state) {
		return true;
	}
	
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		int i = state.get(STAGE_0_1);
		if (rand.nextInt(3) == 0 && worldIn.isAirBlock(pos.up()) && worldIn.getLightSubtracted(pos.up(), 0) >= 9) {
			if (i != 1) { worldIn.setBlockState(pos, state.with(STAGE_0_1, Integer.valueOf(i + 1))); }
			if (i == 1) { this.placeBamboo(worldIn, pos, state); }
		}
	}
	
	protected void placeBamboo(World worldIn, BlockPos pos, BlockState state) {
		worldIn.setBlockState(pos, Wood_Blocks.TAKE.getDefaultState()
				.with(Take_CM.WATERLOGGED, worldIn.getFluidState(pos).getFluid() == Fluids.WATER)
				.with(Take_CM.STAGE_0_15, Integer.valueOf(11)));
		worldIn.setBlockState(pos.up(), Wood_Blocks.TAKE.getDefaultState()
				.with(Take_CM.WATERLOGGED, worldIn.getFluidState(pos.up()).getFluid() == Fluids.WATER)
				.with(Take_CM.STAGE_0_15, Integer.valueOf(0)));
	}
	
	/* Collisions for each property. */
	@Override
	public Block.OffsetType getOffsetType() {
		return Block.OffsetType.XZ;
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Vec3d vec3d = state.getOffset(worldIn, pos);
		return AABB_BOX.withOffset(vec3d.x, vec3d.y, vec3d.z);
	}

	/** @deprecated call via {@link IBlockState#getPlayerRelativeBlockHardness(EntityPlayer,World,BlockPos)} */
	public float getPlayerRelativeBlockHardness(BlockState state, PlayerEntity player, IBlockReader worldIn, BlockPos pos) {
		return player.getHeldItemMainhand().getItem() instanceof SwordItem ? 1.0F : super.getPlayerRelativeBlockHardness(state, player, worldIn, pos);
	}
	
	/* Create Blockstate */
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(STAGE_0_1, WATERLOGGED);
	}
	
	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_takenoko").applyTextStyle(TextFormatting.GRAY));
		tooltip.add(new TranslationTextComponent("tips.block_takenoko2").applyTextStyle(TextFormatting.GRAY));
	}
}
