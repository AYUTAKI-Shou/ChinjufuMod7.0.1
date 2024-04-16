package com.ayutaki.chinjufumod.blocks.furnace;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.School_Blocks;
import com.ayutaki.chinjufumod.tileentity.AbstractOvenTileEntity;

import net.minecraft.block.AbstractBlock;
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
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
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
import net.minecraft.util.math.vector.Vector3d;
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
	public static final BooleanProperty LIT = BlockStateProperties.LIT;
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");

	protected AbstractOvenBlock(AbstractBlock.Properties properties) {
		super(properties);
		registerDefaultState(this.defaultBlockState().setValue(H_FACING, Direction.NORTH)
				.setValue(LIT, Boolean.valueOf(false))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* 前か後が埋まっている時は開かない */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		Direction direction = state.getValue(AbstractOvenBlock.H_FACING);

		if (!state.getValue(WATERLOGGED)) {
			
			switch (direction) {
			case NORTH:
			default:
				if ((worldIn.getBlockState(pos.north()).getMaterial().isReplaceable() || worldIn.getBlockState(pos.north()).getBlock() instanceof CarpetBlock) &&
						(worldIn.getBlockState(pos.south()).getMaterial().isReplaceable() || worldIn.getBlockState(pos.south()).getBlock() instanceof CarpetBlock ||
								worldIn.getBlockState(pos.south()).getBlock() == School_Blocks.STOVECHIMNEY_joint)) {

					CMEvents.soundOpenOven(worldIn, pos);
					this.openContainer(worldIn, pos, playerIn); }
				
				else { CMEvents.textIsBlocked(worldIn, pos, playerIn); }
				break;

			case SOUTH:
				if ((worldIn.getBlockState(pos.south()).getMaterial().isReplaceable() || worldIn.getBlockState(pos.south()).getBlock() instanceof CarpetBlock) &&
						(worldIn.getBlockState(pos.north()).getMaterial().isReplaceable() || worldIn.getBlockState(pos.north()).getBlock() instanceof CarpetBlock ||
								worldIn.getBlockState(pos.north()).getBlock() == School_Blocks.STOVECHIMNEY_joint)) {

					CMEvents.soundOpenOven(worldIn, pos);
					this.openContainer(worldIn, pos, playerIn); }
				
				else { CMEvents.textIsBlocked(worldIn, pos, playerIn); }
				break;

			case EAST:
				if ((worldIn.getBlockState(pos.east()).getMaterial().isReplaceable() || worldIn.getBlockState(pos.east()).getBlock() instanceof CarpetBlock) &&
						(worldIn.getBlockState(pos.west()).getMaterial().isReplaceable() || worldIn.getBlockState(pos.west()).getBlock() instanceof CarpetBlock ||
								worldIn.getBlockState(pos.west()).getBlock() == School_Blocks.STOVECHIMNEY_joint)) {

				CMEvents.soundOpenOven(worldIn, pos);
				this.openContainer(worldIn, pos, playerIn); }
				
				else { CMEvents.textIsBlocked(worldIn, pos, playerIn); }
				break;
				
			case WEST:
				if ((worldIn.getBlockState(pos.west()).getMaterial().isReplaceable() || worldIn.getBlockState(pos.west()).getBlock() instanceof CarpetBlock) &&
						(worldIn.getBlockState(pos.east()).getMaterial().isReplaceable() || worldIn.getBlockState(pos.east()).getBlock() instanceof CarpetBlock ||
								worldIn.getBlockState(pos.east()).getBlock() == School_Blocks.STOVECHIMNEY_joint)) {

					CMEvents.soundOpenOven(worldIn, pos);
					this.openContainer(worldIn, pos, playerIn); }
				
				else { CMEvents.textIsBlocked(worldIn, pos, playerIn); }
				break;
			} // switch
		}

		/** Waterlogged **/
		if (state.getValue(WATERLOGGED)) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); }
		
		return ActionResultType.SUCCESS;
	}

	protected abstract void openContainer(World worldIn, BlockPos pos, PlayerEntity playerIn);

	@Override
	public void setPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		if (stack.hasCustomHoverName()) {
			TileEntity tileentity = worldIn.getBlockEntity(pos);
			if (tileentity instanceof AbstractOvenTileEntity) {
				((AbstractOvenTileEntity)tileentity).setCustomName(stack.getHoverName());
			}
		}
	}

	@SuppressWarnings("deprecation")
	public void onRemove(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			TileEntity tileentity = worldIn.getBlockEntity(pos);
			if (tileentity instanceof AbstractOvenTileEntity) {
				InventoryHelper.dropContents(worldIn, pos, (AbstractOvenTileEntity)tileentity);
				((AbstractOvenTileEntity)tileentity).getRecipesToAwardAndPopExperience(worldIn, Vector3d.atCenterOf(pos));
				worldIn.updateNeighbourForOutputSignal(pos, this);
			}
			super.onRemove(state, worldIn, pos, newState, isMoving);
		}
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState blockState, World worldIn, BlockPos pos) {
		return Container.getRedstoneSignalFromBlockEntity(worldIn.getBlockEntity(pos));
	}

	@Override
	public BlockRenderType getRenderShape(BlockState state) {
		return BlockRenderType.MODEL;
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);
		
		return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER))
				.setValue(H_FACING, context.getHorizontalDirection().getOpposite());
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rotation) {
		return state.setValue(H_FACING, rotation.rotate(state.getValue(H_FACING)));
	}

	@SuppressWarnings("deprecation")
	public BlockState mirror(BlockState state, Mirror mirror) {
		return state.rotate(mirror.getRotation(state.getValue(H_FACING)));
	}

	/* Waterlogged */
	@SuppressWarnings("deprecation")
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Override
	public boolean canPlaceLiquid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluid) {
		return !state.getValue(BlockStateProperties.WATERLOGGED) && fluid == Fluids.WATER;
	}

	@Override
	public boolean placeLiquid(IWorld worldIn, BlockPos pos, BlockState state, FluidState fluid) {
		if (!state.getValue(BlockStateProperties.WATERLOGGED) && fluid.getType() == Fluids.WATER) {
			if (!worldIn.isClientSide()) {
				worldIn.setBlock(pos, state.setValue(BlockStateProperties.WATERLOGGED, Boolean.valueOf(true)), 3);
				worldIn.getLiquidTicks().scheduleTick(pos, fluid.getType(), fluid.getType().getTickDelay(worldIn)); }
			return true; }
		
		else { return false; }
	}

	@Override
	public Fluid takeLiquid(IWorld worldIn, BlockPos pos, BlockState state) {
		if (state.getValue(BlockStateProperties.WATERLOGGED)) {
			worldIn.setBlock(pos, state.setValue(BlockStateProperties.WATERLOGGED, Boolean.valueOf(false)), 3);
			return Fluids.WATER; }
		
		else { return Fluids.EMPTY; }
	}

	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.getValue(WATERLOGGED)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }
		
		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}

	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(H_FACING, LIT, WATERLOGGED);
	}

	/* 燃焼中に上を歩くとダメージを受ける */
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entity) {

		int px = pos.getX();
		int py = pos.getY();
		int pz = pos.getZ();

		BlockState state = worldIn.getBlockState(new BlockPos(px, py, pz));
		if (state.getValue(LIT) == true) {
			if (!entity.fireImmune() && entity instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)entity)) {
				entity.hurt(DamageSource.HOT_FLOOR, 1.0F);
			}
			super.stepOn(worldIn, pos, entity);
		}
	}

	/* Play Sound・Particle */
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState state, World worldIn, BlockPos pos, Random rand) {

		double d0 = (double)pos.getX() + 0.5D;
		double d1 = (double)pos.getY() + 0.8D;
		double d2 = (double)pos.getZ() + 0.5D;

		if (state.getValue(LIT) == true) {
				if (rand.nextDouble() < 0.1D) {
					worldIn.playLocalSound(d0, d1, d2, SoundEvents.FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 1.0F, false); }
		}
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_kit_oven").withStyle(TextFormatting.GRAY));
	}
}
