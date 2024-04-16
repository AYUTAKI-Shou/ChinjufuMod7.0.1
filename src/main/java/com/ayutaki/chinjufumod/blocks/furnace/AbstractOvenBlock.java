package com.ayutaki.chinjufumod.blocks.furnace;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.School_Blocks;
import com.ayutaki.chinjufumod.tileentity.AbstractOvenTileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.CarpetBlock;
import net.minecraft.block.ContainerBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public abstract class AbstractOvenBlock extends ContainerBlock implements IWaterLoggable {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final BooleanProperty LIT = BooleanProperty.create("lit");
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");

	protected AbstractOvenBlock(Block.Properties properties) {
		super(properties);
		setDefaultState(this.stateContainer.getBaseState().with(H_FACING, Direction.NORTH)
				.with(LIT, Boolean.valueOf(false))
				.with(WATERLOGGED, Boolean.valueOf(false)));
	}

	public int getLightValue(BlockState state) {
		return state.get(LIT) ? 14 : 0;
	}

	/* 前か後が埋まっている時は開かない */
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		Direction direction = state.get(AbstractOvenBlock.H_FACING);

		if (!state.get(WATERLOGGED)) {
			
			switch (direction) {
			case NORTH:
			default:
				if ((worldIn.getBlockState(pos.north()).getMaterial().isReplaceable() || worldIn.getBlockState(pos.north()).getBlock() instanceof CarpetBlock) &&
						(worldIn.getBlockState(pos.south()).getMaterial().isReplaceable() || worldIn.getBlockState(pos.south()).getBlock() instanceof CarpetBlock ||
								worldIn.getBlockState(pos.south()).getBlock() == School_Blocks.STOVECHIMNEY_joint)) {

					CMEvents.soundOpenOven(worldIn, pos);
					this.interactWith(worldIn, pos, playerIn); }
				
				else { CMEvents.textIsBlocked(worldIn, pos, playerIn); }
				break;

			case SOUTH:
				if ((worldIn.getBlockState(pos.south()).getMaterial().isReplaceable() || worldIn.getBlockState(pos.south()).getBlock() instanceof CarpetBlock) &&
						(worldIn.getBlockState(pos.north()).getMaterial().isReplaceable() || worldIn.getBlockState(pos.north()).getBlock() instanceof CarpetBlock ||
								worldIn.getBlockState(pos.north()).getBlock() == School_Blocks.STOVECHIMNEY_joint)) {

					CMEvents.soundOpenOven(worldIn, pos);
					this.interactWith(worldIn, pos, playerIn); }
				
				else { CMEvents.textIsBlocked(worldIn, pos, playerIn); }
				break;

			case EAST:
				if ((worldIn.getBlockState(pos.east()).getMaterial().isReplaceable() || worldIn.getBlockState(pos.east()).getBlock() instanceof CarpetBlock) &&
						(worldIn.getBlockState(pos.west()).getMaterial().isReplaceable() || worldIn.getBlockState(pos.west()).getBlock() instanceof CarpetBlock ||
								worldIn.getBlockState(pos.west()).getBlock() == School_Blocks.STOVECHIMNEY_joint)) {
	
					CMEvents.soundOpenOven(worldIn, pos);
					this.interactWith(worldIn, pos, playerIn); }
			
				else { CMEvents.textIsBlocked(worldIn, pos, playerIn); }
				break;
				
			case WEST:
				if ((worldIn.getBlockState(pos.west()).getMaterial().isReplaceable() || worldIn.getBlockState(pos.west()).getBlock() instanceof CarpetBlock) &&
						(worldIn.getBlockState(pos.east()).getMaterial().isReplaceable() || worldIn.getBlockState(pos.east()).getBlock() instanceof CarpetBlock ||
								worldIn.getBlockState(pos.east()).getBlock() == School_Blocks.STOVECHIMNEY_joint)) {

					CMEvents.soundOpenOven(worldIn, pos);
					this.interactWith(worldIn, pos, playerIn); }
				
				else { CMEvents.textIsBlocked(worldIn, pos, playerIn); }
				break;
			} // switch
		}

		/** Waterlogged **/
		if (state.get(WATERLOGGED)) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); }
		
		return ActionResultType.SUCCESS;
	}

	protected abstract void interactWith(World worldIn, BlockPos pos, PlayerEntity playerIn);

	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		if (stack.hasDisplayName()) {
			TileEntity tileentity = worldIn.getTileEntity(pos);
			if (tileentity instanceof AbstractOvenTileEntity) {
				((AbstractOvenTileEntity)tileentity).setCustomName(stack.getDisplayName());
			}
		}
	}

	@SuppressWarnings("deprecation")
	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			TileEntity tileentity = worldIn.getTileEntity(pos);
			if (tileentity instanceof AbstractOvenTileEntity) {
				InventoryHelper.dropInventoryItems(worldIn, pos, (AbstractOvenTileEntity)tileentity);
				worldIn.updateComparatorOutputLevel(pos, this);
			}

			super.onReplaced(state, worldIn, pos, newState, isMoving);
		}
	}

	public boolean hasComparatorInputOverride(BlockState state) {
		return true;
	}

	public int getComparatorInputOverride(BlockState blockState, World worldIn, BlockPos pos) {
		return Container.calcRedstone(worldIn.getTileEntity(pos));
	}

	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.MODEL;
	}

	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getWorld();
		BlockPos pos = context.getPos();
		IFluidState fluid = worldIn.getFluidState(pos);
		
		return this.getDefaultState().with(WATERLOGGED, fluid.getFluid() == Fluids.WATER)
				.with(H_FACING, context.getPlacementHorizontalFacing().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(H_FACING, rot.rotate(state.get(H_FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.toRotation(state.get(H_FACING)));
	}

	/* Waterlogged */
	@SuppressWarnings("deprecation")
	public IFluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}

	public boolean canContainFluid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluidIn) {
		return IWaterLoggable.super.canContainFluid(worldIn, pos, state, fluidIn);
	}
	
	public boolean receiveFluid(IWorld worldIn, BlockPos pos, BlockState state, IFluidState fluidStateIn) {
		return IWaterLoggable.super.receiveFluid(worldIn, pos, state, fluidStateIn);
	}
	
	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
		}
		return super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
	}

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(H_FACING, LIT, WATERLOGGED);
	}

	/* 燃焼中に上を歩くとダメージを受ける */
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entity) {

		int px = pos.getX();
		int py = pos.getY();
		int pz = pos.getZ();

		BlockState state = worldIn.getBlockState(new BlockPos(px, py, pz));
		if (state.get(LIT) == true) {
			if (!entity.isImmuneToFire() && entity instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)entity)) {
				entity.attackEntityFrom(DamageSource.HOT_FLOOR, 1.0F);
			}
			super.onEntityWalk(worldIn, pos, entity);
		}
	}

	/* Play Sound and Particle */
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState state, World worldIn, BlockPos pos, Random rand) {

		double d0 = (double)pos.getX() + 0.5D;
		double d1 = (double)pos.getY() + 0.8D;
		double d2 = (double)pos.getZ() + 0.5D;

		if (state.get(LIT) == true) {
				if (rand.nextDouble() < 0.1D) {
					worldIn.playSound(d0, d1, d2, SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 1.0F, false); }
		}
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_kit_oven").applyTextStyle(TextFormatting.GRAY));
	}
}
