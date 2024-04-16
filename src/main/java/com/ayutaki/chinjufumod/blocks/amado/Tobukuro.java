package com.ayutaki.chinjufumod.blocks.amado;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.Slidedoor_Blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;

public class Tobukuro extends Base_Tobukuro {

	/** 1=4枚、2=3枚、3=2枚、4=1枚、5=0枚 **/
	public Tobukuro(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		/** 1=4枚、2=3枚、3=2枚、4=1枚、5=0枚 **/
		int i = state.getValue(STAGE_1_5);
		Direction direction = state.getValue(H_FACING);
		DoubleBlockHalf half = state.getValue(HALF);

		int x = (int) pos.getX();
		int y = (int) pos.getY();
		int z = (int) pos.getZ();

		BlockState this_FACEUP = this.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING)).setValue(HALF, DoubleBlockHalf.UPPER);
		BlockState this_FACELO = this.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING)).setValue(HALF, DoubleBlockHalf.LOWER);

		BlockState AMADO_FACEUP = this.takeBlock().defaultBlockState().setValue(Amado.H_FACING, state.getValue(H_FACING)).setValue(Amado.HALF, DoubleBlockHalf.UPPER);
		BlockState AMADO_FACELO = this.takeBlock().defaultBlockState().setValue(Amado.H_FACING, state.getValue(H_FACING)).setValue(Amado.HALF, DoubleBlockHalf.LOWER);
		
		if (i != 5) {
			CMEvents.soundAmado(worldIn, pos);
			
			switch (half) {
			case LOWER:
			default:

				switch (direction) {
				case NORTH:
				default:
					if (worldIn.getBlockState(new BlockPos(x - 1, y, z)).canBeReplaced() &&
							worldIn.getBlockState(new BlockPos(x - 1, y + 1, z)).canBeReplaced()) {
	
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, state.setValue(STAGE_1_5, Integer.valueOf(i + 1)), 3);
						worldIn.setBlock(pos.above(), this_FACEUP.setValue(STAGE_1_5, Integer.valueOf(i + 1)), 3);
	
						worldIn.setBlock(new BlockPos(x - 1, y, z), AMADO_FACELO.setValue(Amado.STAGE_1_4, Integer.valueOf(1)), 3);
						worldIn.setBlock(new BlockPos(x - 1, y + 1, z), AMADO_FACEUP.setValue(Amado.STAGE_1_4, Integer.valueOf(1)), 3); }
					
					if (!worldIn.getBlockState(new BlockPos(x - 1, y, z)).canBeReplaced() ||
							!worldIn.getBlockState(new BlockPos(x - 1, y + 1, z)).canBeReplaced()) { }
					break;

				case SOUTH:
					if (worldIn.getBlockState(new BlockPos(x + 1, y, z)).canBeReplaced() &&
							worldIn.getBlockState(new BlockPos(x + 1, y + 1, z)).canBeReplaced()) {
	
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, state.setValue(STAGE_1_5, Integer.valueOf(i + 1)), 3);
						worldIn.setBlock(pos.above(), this_FACEUP.setValue(STAGE_1_5, Integer.valueOf(i + 1)), 3);
	
						worldIn.setBlock(new BlockPos(x + 1, y, z), AMADO_FACELO.setValue(Amado.STAGE_1_4, Integer.valueOf(1)), 3);
						worldIn.setBlock(new BlockPos(x + 1, y + 1, z), AMADO_FACEUP.setValue(Amado.STAGE_1_4, Integer.valueOf(1)), 3); }
					
					if (!worldIn.getBlockState(new BlockPos(x + 1, y, z)).canBeReplaced() ||
							!worldIn.getBlockState(new BlockPos(x + 1, y + 1, z)).canBeReplaced()) { }
					break;

				case EAST:
					if (worldIn.getBlockState(new BlockPos(x, y, z - 1)).canBeReplaced() &&
							worldIn.getBlockState(new BlockPos(x, y + 1, z - 1)).canBeReplaced()) {
	
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, state.setValue(STAGE_1_5, Integer.valueOf(i + 1)), 3);
						worldIn.setBlock(pos.above(), this_FACEUP.setValue(STAGE_1_5, Integer.valueOf(i + 1)), 3);
	
						worldIn.setBlock(new BlockPos(x, y, z - 1), AMADO_FACELO.setValue(Amado.STAGE_1_4, Integer.valueOf(1)), 3);
						worldIn.setBlock(new BlockPos(x, y + 1, z - 1), AMADO_FACEUP.setValue(Amado.STAGE_1_4, Integer.valueOf(1)), 3); }
					
					if (!worldIn.getBlockState(new BlockPos(x, y, z - 1)).canBeReplaced() ||
							!worldIn.getBlockState(new BlockPos(x, y + 1, z - 1)).canBeReplaced()) { }
					break;
					
				case WEST:
					if (worldIn.getBlockState(new BlockPos(x, y, z + 1)).canBeReplaced() &&
							worldIn.getBlockState(new BlockPos(x, y + 1, z + 1)).canBeReplaced()) {
	
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, state.setValue(STAGE_1_5, Integer.valueOf(i + 1)), 3);
						worldIn.setBlock(pos.above(), this_FACEUP.setValue(STAGE_1_5, Integer.valueOf(i + 1)), 3);
	
						worldIn.setBlock(new BlockPos(x, y, z + 1), AMADO_FACELO.setValue(Amado.STAGE_1_4, Integer.valueOf(1)), 3);
						worldIn.setBlock(new BlockPos(x, y + 1, z + 1), AMADO_FACEUP.setValue(Amado.STAGE_1_4, Integer.valueOf(1)), 3); }
					
					if (!worldIn.getBlockState(new BlockPos(x, y, z + 1)).canBeReplaced() ||
							!worldIn.getBlockState(new BlockPos(x, y + 1, z + 1)).canBeReplaced()) { }
					break;
				} // switch
				break;


			case UPPER:

				switch (direction) {
				case NORTH:
				default:
					if (worldIn.getBlockState(new BlockPos(x - 1, y, z)).canBeReplaced() &&
							worldIn.getBlockState(new BlockPos(x - 1, y - 1, z)).canBeReplaced()) {
	
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, state.setValue(STAGE_1_5, Integer.valueOf(i + 1)), 3);
						worldIn.setBlock(pos.below(), this_FACELO.setValue(STAGE_1_5, Integer.valueOf(i + 1)), 3);
	
						worldIn.setBlock(new BlockPos(x - 1, y, z), AMADO_FACEUP.setValue(Amado.STAGE_1_4, Integer.valueOf(1)), 3);
						worldIn.setBlock(new BlockPos(x - 1, y - 1, z), AMADO_FACELO.setValue(Amado.STAGE_1_4, Integer.valueOf(1)), 3); }
					
					if (!worldIn.getBlockState(new BlockPos(x - 1, y, z)).canBeReplaced() ||
							!worldIn.getBlockState(new BlockPos(x - 1, y - 1, z)).canBeReplaced()) { }
					break;

				case SOUTH:
					if (worldIn.getBlockState(new BlockPos(x + 1, y, z)).canBeReplaced() &&
							worldIn.getBlockState(new BlockPos(x + 1, y - 1, z)).canBeReplaced()) {
	
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, state.setValue(STAGE_1_5, Integer.valueOf(i + 1)), 3);
						worldIn.setBlock(pos.below(), this_FACELO.setValue(STAGE_1_5, Integer.valueOf(i + 1)), 3);
	
						worldIn.setBlock(new BlockPos(x + 1, y, z), AMADO_FACEUP.setValue(Amado.STAGE_1_4, Integer.valueOf(1)), 3);
						worldIn.setBlock(new BlockPos(x + 1, y - 1, z), AMADO_FACELO.setValue(Amado.STAGE_1_4, Integer.valueOf(1)), 3); }
					
					if (!worldIn.getBlockState(new BlockPos(x + 1, y, z)).canBeReplaced() ||
							!worldIn.getBlockState(new BlockPos(x + 1, y - 1, z)).canBeReplaced()) { }
					break;

				case EAST:
					if (worldIn.getBlockState(new BlockPos(x, y, z - 1)).canBeReplaced() &&
							worldIn.getBlockState(new BlockPos(x, y - 1, z - 1)).canBeReplaced()) {
	
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, state.setValue(STAGE_1_5, Integer.valueOf(i + 1)), 3);
						worldIn.setBlock(pos.below(), this_FACELO.setValue(STAGE_1_5, Integer.valueOf(i + 1)), 3);
	
						worldIn.setBlock(new BlockPos(x, y, z - 1), AMADO_FACEUP.setValue(Amado.STAGE_1_4, Integer.valueOf(1)), 3);
						worldIn.setBlock(new BlockPos(x, y - 1, z - 1), AMADO_FACELO.setValue(Amado.STAGE_1_4, Integer.valueOf(1)), 3); }
					
					if (!worldIn.getBlockState(new BlockPos(x, y, z - 1)).canBeReplaced() ||
							!worldIn.getBlockState(new BlockPos(x, y - 1, z - 1)).canBeReplaced()) { }
					break;
					
				case WEST:
					if (worldIn.getBlockState(new BlockPos(x, y, z + 1)).canBeReplaced() &&
							worldIn.getBlockState(new BlockPos(x, y - 1, z + 1)).canBeReplaced()) {
	
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, state.setValue(STAGE_1_5, Integer.valueOf(i + 1)), 3);
						worldIn.setBlock(pos.below(), this_FACELO.setValue(STAGE_1_5, Integer.valueOf(i + 1)), 3);
	
						worldIn.setBlock(new BlockPos(x, y, z + 1), AMADO_FACEUP.setValue(Amado.STAGE_1_4, Integer.valueOf(1)), 3);
						worldIn.setBlock(new BlockPos(x, y - 1, z + 1), AMADO_FACELO.setValue(Amado.STAGE_1_4, Integer.valueOf(1)), 3); }
					
					if (!worldIn.getBlockState(new BlockPos(x, y, z + 1)).canBeReplaced() ||
							!worldIn.getBlockState(new BlockPos(x, y - 1, z + 1)).canBeReplaced()) { }
					break;
				} // switch
				break;
			} // switch LOWER-UPPER
		} // i != 5
		
		if (i == 5) { CMEvents.textIsEmpty(worldIn, pos, playerIn); }
		
		return InteractionResult.SUCCESS;
	}
	
	private Block takeBlock() {
		if (this == Slidedoor_Blocks.TOBUKURO.get()) { return Slidedoor_Blocks.AMADO.get(); }
		if (this == Slidedoor_Blocks.TOBUKURO_S.get()) { return Slidedoor_Blocks.AMADO_S.get(); }
		return null;
	}
	
	private Block takeLBlock() {
		if (this == Slidedoor_Blocks.TOBUKURO.get()) { return Slidedoor_Blocks.TOBUKURO_L.get(); }
		if (this == Slidedoor_Blocks.TOBUKURO_S.get()) { return Slidedoor_Blocks.TOBUKURO_SL.get(); }
		return null;
	}
	
	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		Level worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);
		Player playerIn = context.getPlayer();

		/** pos.up() = Replaceable block. **/
		if (pos.getY() < worldIn.getMaxBuildHeight() - 1 && worldIn.getBlockState(pos.above()).canBeReplaced(context)) {
			if (playerIn.isCrouching()) {
				return this.takeLBlock().defaultBlockState().setValue(H_FACING, context.getHorizontalDirection().getOpposite())
						.setValue(STAGE_1_5, Integer.valueOf(1))
						.setValue(HALF, DoubleBlockHalf.LOWER)
						.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)); }

			return this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection().getOpposite())
					.setValue(STAGE_1_5, Integer.valueOf(1))
					.setValue(HALF, DoubleBlockHalf.LOWER)
					.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER));
		}

		else { return null; }
	}
	
	/* Add DoubleBlockHalf.UPPER on the Block. */
	public void setPlacedBy(Level worldIn, BlockPos pos, BlockState state, LivingEntity entityIn, ItemStack stack) {
		FluidState fluidUp = worldIn.getFluidState(pos.above());

		worldIn.setBlock(pos.above(), this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER)
				.setValue(H_FACING, state.getValue(H_FACING))
				.setValue(STAGE_1_5, Integer.valueOf(1))
				.setValue(WATERLOGGED, Boolean.valueOf(fluidUp.getType() == Fluids.WATER)), 3);
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		if (this == Slidedoor_Blocks.TOBUKURO_S.get()) { return new ItemStack(Items_Wadeco.TOBUKURO_S.get()); }
		return new ItemStack(Items_Wadeco.TOBUKURO.get());
	}
}
