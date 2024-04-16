package com.ayutaki.chinjufumod.blocks.amado;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.Slidedoor_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class Tobukuro_L extends Base_Tobukuro {

	/** 1=4枚、2=3枚、3=2枚、4=1枚、5=0枚 **/
	public Tobukuro_L(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		/** 1=4枚、2=3枚、3=2枚、4=1枚、5=0枚 **/
		int i = state.get(STAGE_1_5);
		Direction direction = state.get(H_FACING);
		DoubleBlockHalf half = state.get(HALF);

		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();

		BlockState this_FACEUP = this.getDefaultState().with(H_FACING, state.get(H_FACING)).with(HALF, DoubleBlockHalf.UPPER);
		BlockState this_FACELO = this.getDefaultState().with(H_FACING, state.get(H_FACING)).with(HALF, DoubleBlockHalf.LOWER);
		
		BlockState AMADO_FACEUP = this.takeBlock().getDefaultState().with(Amado.H_FACING, state.get(H_FACING)).with(Amado.HALF, DoubleBlockHalf.UPPER);
		BlockState AMADO_FACELO = this.takeBlock().getDefaultState().with(Amado.H_FACING, state.get(H_FACING)).with(Amado.HALF, DoubleBlockHalf.LOWER);

		if (i != 5) {
			CMEvents.soundAmado(worldIn, pos);
			
			switch (half) {
			case LOWER:
			default:

				switch (direction) {
				case NORTH:
				default:
					if (worldIn.getBlockState(new BlockPos(x + 1, y, z)).getMaterial().isReplaceable() && 
							worldIn.getBlockState(new BlockPos(x + 1, y + 1, z)).getMaterial().isReplaceable()) {
	
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_5, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.up(), this_FACEUP.with(STAGE_1_5, Integer.valueOf(i + 1)));
	
						worldIn.setBlockState(new BlockPos(x + 1, y, z), AMADO_FACELO.with(Amado.STAGE_1_4, Integer.valueOf(4)));
						worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), AMADO_FACEUP.with(Amado.STAGE_1_4, Integer.valueOf(4))); }
					
					if (!worldIn.getBlockState(new BlockPos(x + 1, y, z)).getMaterial().isReplaceable() || 
							!worldIn.getBlockState(new BlockPos(x + 1, y + 1, z)).getMaterial().isReplaceable()) { }
					break;

				case SOUTH:
					if (worldIn.getBlockState(new BlockPos(x - 1, y, z)).getMaterial().isReplaceable() && 
							worldIn.getBlockState(new BlockPos(x - 1, y + 1, z)).getMaterial().isReplaceable()) {
						
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_5, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.up(), this_FACEUP.with(STAGE_1_5, Integer.valueOf(i + 1)));
	
						worldIn.setBlockState(new BlockPos(x - 1, y, z), AMADO_FACELO.with(Amado.STAGE_1_4, Integer.valueOf(4)));
						worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), AMADO_FACEUP.with(Amado.STAGE_1_4, Integer.valueOf(4))); }
					
					if (!worldIn.getBlockState(new BlockPos(x - 1, y, z)).getMaterial().isReplaceable() ||
							!worldIn.getBlockState(new BlockPos(x - 1, y + 1, z)).getMaterial().isReplaceable()) { }
					break;

				case EAST:
					if (worldIn.getBlockState(new BlockPos(x, y, z + 1)).getMaterial().isReplaceable() && 
							worldIn.getBlockState(new BlockPos(x, y + 1, z + 1)).getMaterial().isReplaceable()) {
						
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_5, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.up(), this_FACEUP.with(STAGE_1_5, Integer.valueOf(i + 1)));
	
						worldIn.setBlockState(new BlockPos(x, y, z + 1), AMADO_FACELO.with(Amado.STAGE_1_4, Integer.valueOf(4)));
						worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), AMADO_FACEUP.with(Amado.STAGE_1_4, Integer.valueOf(4))); }
					
					if (!worldIn.getBlockState(new BlockPos(x, y, z + 1)).getMaterial().isReplaceable() || 
							!worldIn.getBlockState(new BlockPos(x, y + 1, z + 1)).getMaterial().isReplaceable()) { }
					break;
					
				case WEST:
					if (worldIn.getBlockState(new BlockPos(x, y, z - 1)).getMaterial().isReplaceable() && 
							worldIn.getBlockState(new BlockPos(x, y + 1, z - 1)).getMaterial().isReplaceable()) {
						
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_5, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.up(), this_FACEUP.with(STAGE_1_5, Integer.valueOf(i + 1)));
	
						worldIn.setBlockState(new BlockPos(x, y, z - 1), AMADO_FACELO.with(Amado.STAGE_1_4, Integer.valueOf(4)));
						worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), AMADO_FACEUP.with(Amado.STAGE_1_4, Integer.valueOf(4))); }
					
					if (!worldIn.getBlockState(new BlockPos(x, y, z - 1)).getMaterial().isReplaceable() || 
							!worldIn.getBlockState(new BlockPos(x, y + 1, z - 1)).getMaterial().isReplaceable()) { }
					break;
				} // switch
				break;

			case UPPER:

				switch (direction) {
				case NORTH:
				default:
					if (worldIn.getBlockState(new BlockPos(x + 1, y, z)).getMaterial().isReplaceable() && 
							worldIn.getBlockState(new BlockPos(x + 1, y - 1, z)).getMaterial().isReplaceable()) {
						
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_5, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.down(), this_FACELO.with(STAGE_1_5, Integer.valueOf(i + 1)));
	
						worldIn.setBlockState(new BlockPos(x + 1, y, z), AMADO_FACEUP.with(Amado.STAGE_1_4, Integer.valueOf(4)));
						worldIn.setBlockState(new BlockPos(x + 1, y - 1, z), AMADO_FACELO.with(Amado.STAGE_1_4, Integer.valueOf(4))); }
					
					if (!worldIn.getBlockState(new BlockPos(x + 1, y, z)).getMaterial().isReplaceable() || 
							!worldIn.getBlockState(new BlockPos(x + 1, y - 1, z)).getMaterial().isReplaceable()) { }
					break;

				case SOUTH:
					if (worldIn.getBlockState(new BlockPos(x - 1, y, z)).getMaterial().isReplaceable() && 
							worldIn.getBlockState(new BlockPos(x - 1, y - 1, z)).getMaterial().isReplaceable()) {
						
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_5, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.down(), this_FACELO.with(STAGE_1_5, Integer.valueOf(i + 1)));
	
						worldIn.setBlockState(new BlockPos(x - 1, y, z), AMADO_FACEUP.with(Amado.STAGE_1_4, Integer.valueOf(4)));
						worldIn.setBlockState(new BlockPos(x - 1, y - 1, z), AMADO_FACELO.with(Amado.STAGE_1_4, Integer.valueOf(4))); }
					
					if (!worldIn.getBlockState(new BlockPos(x - 1, y, z)).getMaterial().isReplaceable() ||
							!worldIn.getBlockState(new BlockPos(x - 1, y - 1, z)).getMaterial().isReplaceable()) { }
					break;

				case EAST:
					if (worldIn.getBlockState(new BlockPos(x, y, z + 1)).getMaterial().isReplaceable() && 
							worldIn.getBlockState(new BlockPos(x, y - 1, z + 1)).getMaterial().isReplaceable()) {
						
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_5, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.down(), this_FACELO.with(STAGE_1_5, Integer.valueOf(i + 1)));
	
						worldIn.setBlockState(new BlockPos(x, y, z + 1), AMADO_FACEUP.with(Amado.STAGE_1_4, Integer.valueOf(4)));
						worldIn.setBlockState(new BlockPos(x, y - 1, z + 1), AMADO_FACELO.with(Amado.STAGE_1_4, Integer.valueOf(4))); }
					
					if (!worldIn.getBlockState(new BlockPos(x, y, z + 1)).getMaterial().isReplaceable() || 
							!worldIn.getBlockState(new BlockPos(x, y - 1, z + 1)).getMaterial().isReplaceable()) { }
					break;
					
				case WEST:
					if (worldIn.getBlockState(new BlockPos(x, y, z - 1)).getMaterial().isReplaceable() && 
							worldIn.getBlockState(new BlockPos(x, y - 1, z - 1)).getMaterial().isReplaceable()) {
						
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_5, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.down(), this_FACELO.with(STAGE_1_5, Integer.valueOf(i + 1)));
	
						worldIn.setBlockState(new BlockPos(x, y, z - 1), AMADO_FACEUP.with(Amado.STAGE_1_4, Integer.valueOf(4)));
						worldIn.setBlockState(new BlockPos(x, y - 1, z - 1), AMADO_FACELO.with(Amado.STAGE_1_4, Integer.valueOf(4))); }
					
					if (!worldIn.getBlockState(new BlockPos(x, y, z - 1)).getMaterial().isReplaceable() ||
							!worldIn.getBlockState(new BlockPos(x, y - 1, z - 1)).getMaterial().isReplaceable()) { }
					break;
				} // switch
				break;
			} // switch LOWER-UPPER
		} // i != 5
		
		if (i == 5) { CMEvents.textIsEmpty(worldIn, pos, playerIn); }
		
		return ActionResultType.SUCCESS;
	}

	private Block takeBlock() {
		if (this == Slidedoor_Blocks.TOBUKURO_L) { return Slidedoor_Blocks.AMADO; }
		if (this == Slidedoor_Blocks.TOBUKURO_SL) { return Slidedoor_Blocks.AMADO_S; }
		return null;
	}
	
	/* Add DoubleBlockHalf.UPPER on the Block. */
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		IFluidState fluidUp = worldIn.getFluidState(pos.up());

		worldIn.setBlockState(pos.up(), this.getDefaultState().with(HALF, DoubleBlockHalf.UPPER)
				.with(H_FACING, state.get(H_FACING))
				.with(STAGE_1_5, Integer.valueOf(1))
				.with(WATERLOGGED, Boolean.valueOf(fluidUp.isTagged(FluidTags.WATER))), 3);
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Wadeco.TOBUKURO);
	}
}
