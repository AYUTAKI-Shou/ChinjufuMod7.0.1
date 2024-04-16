package com.ayutaki.chinjufumod.blocks.wood;

import java.util.Optional;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Wood_Blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BambooBlock;
import net.minecraft.block.BambooSaplingBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SpreadableSnowyDirtBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

public class Take_CM extends CM_WaterLogged {

	/* Property */
	public static final IntegerProperty STAGE_0_15 = IntegerProperty.create("stage", 0, 15);

	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.box(6.5D, 0.0D, 6.5D, 9.5D, 16.0D, 9.5D);

	public Take_CM(AbstractBlock.Properties properties) {
		super(properties);
		/** Default state **/
		registerDefaultState(this.defaultBlockState().setValue(STAGE_0_15, Integer.valueOf(0))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* Check */
	private boolean checkDirt(BlockState state, World worldIn, BlockPos pos) {
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		BlockState downState1 = worldIn.getBlockState(new BlockPos(x - 1, y - 1, z - 1));
		BlockState downState2 = worldIn.getBlockState(new BlockPos(x, y - 1, z - 1));
		BlockState downState3 = worldIn.getBlockState(new BlockPos(x + 1, y - 1, z - 1));
		BlockState downState4 = worldIn.getBlockState(new BlockPos(x - 1, y - 1, z));
		BlockState downState6 = worldIn.getBlockState(new BlockPos(x + 1, y - 1, z));
		BlockState downState7 = worldIn.getBlockState(new BlockPos(x - 1, y - 1, z + 1));
		BlockState downState8 = worldIn.getBlockState(new BlockPos(x, y - 1, z + 1));
		BlockState downState9 = worldIn.getBlockState(new BlockPos(x + 1, y - 1, z + 1));
		
		return (downState1.getBlock() instanceof SpreadableSnowyDirtBlock || downState1.getMaterial() == Material.DIRT) ||
				(downState2.getBlock() instanceof SpreadableSnowyDirtBlock || downState2.getMaterial() == Material.DIRT) ||
				(downState3.getBlock() instanceof SpreadableSnowyDirtBlock || downState3.getMaterial() == Material.DIRT) ||
				(downState4.getBlock() instanceof SpreadableSnowyDirtBlock || downState4.getMaterial() == Material.DIRT) ||
				(downState6.getBlock() instanceof SpreadableSnowyDirtBlock || downState6.getMaterial() == Material.DIRT) ||
				(downState7.getBlock() instanceof SpreadableSnowyDirtBlock || downState7.getMaterial() == Material.DIRT) ||
				(downState8.getBlock() instanceof SpreadableSnowyDirtBlock || downState8.getMaterial() == Material.DIRT) ||
				(downState9.getBlock() instanceof SpreadableSnowyDirtBlock || downState9.getMaterial() == Material.DIRT);
	}
	
	private boolean checkDirt1(BlockState state, World worldIn, BlockPos pos) {
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		BlockState downState1 = worldIn.getBlockState(new BlockPos(x - 1, y - 1, z - 1));
		return (downState1.getBlock() instanceof SpreadableSnowyDirtBlock || downState1.getMaterial() == Material.DIRT); }
	
	private boolean checkDirt2(BlockState state, World worldIn, BlockPos pos) {
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		BlockState downState2 = worldIn.getBlockState(new BlockPos(x, y - 1, z - 1));
		return (downState2.getBlock() instanceof SpreadableSnowyDirtBlock || downState2.getMaterial() == Material.DIRT); }
	
	private boolean checkDirt3(BlockState state, World worldIn, BlockPos pos) {
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		BlockState downState3 = worldIn.getBlockState(new BlockPos(x + 1, y - 1, z - 1));
		return (downState3.getBlock() instanceof SpreadableSnowyDirtBlock || downState3.getMaterial() == Material.DIRT); }
	
	private boolean checkDirt4(BlockState state, World worldIn, BlockPos pos) {
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		BlockState downState4 = worldIn.getBlockState(new BlockPos(x - 1, y - 1, z));
		return (downState4.getBlock() instanceof SpreadableSnowyDirtBlock || downState4.getMaterial() == Material.DIRT); }
	
	private boolean checkDirt6(BlockState state, World worldIn, BlockPos pos) {
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		BlockState downState6 = worldIn.getBlockState(new BlockPos(x + 1, y - 1, z));
		return (downState6.getBlock() instanceof SpreadableSnowyDirtBlock || downState6.getMaterial() == Material.DIRT); }
	
	private boolean checkDirt7(BlockState state, World worldIn, BlockPos pos) {
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		BlockState downState7 = worldIn.getBlockState(new BlockPos(x - 1, y - 1, z + 1));
		return (downState7.getBlock() instanceof SpreadableSnowyDirtBlock || downState7.getMaterial() == Material.DIRT); }
	
	private boolean checkDirt8(BlockState state, World worldIn, BlockPos pos) {
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		BlockState downState8 = worldIn.getBlockState(new BlockPos(x, y - 1, z + 1));
		return(downState8.getBlock() instanceof SpreadableSnowyDirtBlock || downState8.getMaterial() == Material.DIRT); }
	
	private boolean checkDirt9(BlockState state, World worldIn, BlockPos pos) {
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		BlockState downState9 = worldIn.getBlockState(new BlockPos(x + 1, y - 1, z + 1));
		return (downState9.getBlock() instanceof SpreadableSnowyDirtBlock || downState9.getMaterial() == Material.DIRT); }
	
	private boolean checkSpace(BlockState state, World worldIn, BlockPos pos) {
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		BlockPos pos1 = new BlockPos(x - 1, y, z - 1);
		BlockPos pos2 = new BlockPos(x, y, z - 1);
		BlockPos pos3 = new BlockPos(x + 1, y, z - 1);
		BlockPos pos4 = new BlockPos(x - 1, y, z);
		BlockPos pos6 = new BlockPos(x + 1, y, z);
		BlockPos pos7 = new BlockPos(x - 1, y, z + 1);
		BlockPos pos8 = new BlockPos(x, y, z + 1);
		BlockPos pos9 = new BlockPos(x + 1, y, z + 1);
		BlockState state1 = worldIn.getBlockState(pos1);
		BlockState state2 = worldIn.getBlockState(pos2);
		BlockState state3 = worldIn.getBlockState(pos3);
		BlockState state4 = worldIn.getBlockState(pos4);
		BlockState state6 = worldIn.getBlockState(pos6);
		BlockState state7 = worldIn.getBlockState(pos7);
		BlockState state8 = worldIn.getBlockState(pos8);
		BlockState state9 = worldIn.getBlockState(pos9);
		
		return (state1.getMaterial().isReplaceable()) ||
				(state2.getMaterial().isReplaceable()) ||
				(state3.getMaterial().isReplaceable()) ||
				(state4.getMaterial().isReplaceable()) ||
				(state6.getMaterial().isReplaceable()) ||
				(state7.getMaterial().isReplaceable()) ||
				(state8.getMaterial().isReplaceable()) ||
				(state9.getMaterial().isReplaceable());
	}
	
	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {
		int i = state.getValue(STAGE_0_15);
		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		BlockState downState = worldIn.getBlockState(pos.below());
		
		if (i == 13 && (downState.getBlock() instanceof SpreadableSnowyDirtBlock || downState.getMaterial() == Material.DIRT)) {
			if (this.checkDirt(state, worldIn, pos) && this.checkSpace(state, worldIn, pos)) {
				
				if (item == Items.BONE_MEAL || item == Items_Seasonal.WARAHAI) {
					CMEvents.Consume_1Item(playerIn, hand);
					
					for(int n = 0; n < 15; ++n) {
						double d0 = worldIn.random.nextGaussian() * 0.02D;
						double d1 = worldIn.random.nextGaussian() * 0.02D;
						double d2 = worldIn.random.nextGaussian() * 0.02D;
						worldIn.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + worldIn.random.nextFloat(), pos.getY() +worldIn.random.nextFloat(), pos.getZ() + worldIn.random.nextFloat(), d0, d1, d2); }
					
					double x = (double) pos.getX();
					double y = (double) pos.getY();
					double z = (double) pos.getZ();
					
					BlockPos pos1 = new BlockPos(x - 1, y, z - 1);
					BlockPos pos2 = new BlockPos(x, y, z - 1);
					BlockPos pos3 = new BlockPos(x + 1, y, z - 1);
					BlockPos pos4 = new BlockPos(x - 1, y, z);
					BlockPos pos6 = new BlockPos(x + 1, y, z);
					BlockPos pos7 = new BlockPos(x - 1, y, z + 1);
					BlockPos pos8 = new BlockPos(x, y, z + 1);
					BlockPos pos9 = new BlockPos(x + 1, y, z + 1);
					
					BlockState state1 = worldIn.getBlockState(pos1);
					BlockState state2 = worldIn.getBlockState(pos2);
					BlockState state3 = worldIn.getBlockState(pos3);
					BlockState state4 = worldIn.getBlockState(pos4);
					BlockState state6 = worldIn.getBlockState(pos6);
					BlockState state7 = worldIn.getBlockState(pos7);
					BlockState state8 = worldIn.getBlockState(pos8);
					BlockState state9 = worldIn.getBlockState(pos9);
						
					BlockState TAKENOKO = Wood_Blocks.TAKENOKO.defaultBlockState();

					if (this.checkDirt1(state, worldIn, pos) && state1.getMaterial().isReplaceable()) {
						if (worldIn.random.nextInt(3) == 0) {
							worldIn.setBlock(pos1, TAKENOKO, 3); } }
	
					if (this.checkDirt2(state, worldIn, pos) && state2.getMaterial().isReplaceable()) {
						if (worldIn.random.nextInt(3) == 0) {
							worldIn.setBlock(pos2, TAKENOKO, 3); } }
					
					if (this.checkDirt3(state, worldIn, pos) && state3.getMaterial().isReplaceable()) {
						if (worldIn.random.nextInt(3) == 0) {
							worldIn.setBlock(pos3, TAKENOKO, 3); } }
					
					if (this.checkDirt4(state, worldIn, pos) && state4.getMaterial().isReplaceable()) {
						if (worldIn.random.nextInt(3) == 0) {
							worldIn.setBlock(pos4, TAKENOKO, 3); } }
					
					if (this.checkDirt6(state, worldIn, pos) && state6.getMaterial().isReplaceable()) {
						if (worldIn.random.nextInt(3) == 0) {
							worldIn.setBlock(pos6, TAKENOKO, 3); } }
					
					if (this.checkDirt7(state, worldIn, pos) && state7.getMaterial().isReplaceable()) {
						if (worldIn.random.nextInt(3) == 0) {
							worldIn.setBlock(pos7, TAKENOKO, 3); } }
					
					if (this.checkDirt8(state, worldIn, pos) && state8.getMaterial().isReplaceable()) {
						if (worldIn.random.nextInt(3) == 0) {
							worldIn.setBlock(pos8, TAKENOKO, 3); } }
					
					if (this.checkDirt9(state, worldIn, pos) && state9.getMaterial().isReplaceable()) {
						if (worldIn.random.nextInt(3) == 0) {
							worldIn.setBlock(pos9, TAKENOKO, 3); } }
				} //BONE_MEAL
			} // check
	
			if (!this.checkDirt(state, worldIn, pos) || !this.checkSpace(state, worldIn, pos)) {
				CMEvents.textNoPlace(worldIn, pos, playerIn);
			} // !check
		} //downBlock
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}
	
	/* Update BlockState. */
	@Override
	public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
		int i = state.getValue(STAGE_0_15);
		BlockState downState = worldIn.getBlockState(pos.below());
		Block upBlock = worldIn.getBlockState(pos.above()).getBlock();
		
		return (i > 10)? ((downState.getBlock() instanceof SpreadableSnowyDirtBlock || downState.getBlock() instanceof Take_CM || downState.getMaterial() == Material.DIRT) && upBlock instanceof Take_CM) : downState.getBlock() instanceof Take_CM;
	}
	
	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }
		
		if (!state.canSurvive(worldIn, pos)) { worldIn.getBlockTicks().scheduleTick(pos, this, 1); } 
		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}

	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		if (!state.canSurvive(worldIn, pos)) { worldIn.destroyBlock(pos, true); } 
	}
	
	@Override
	public boolean isRandomlyTicking(BlockState state) {
		return true;
	}
		
	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		int i = state.getValue(STAGE_0_15);
		int jump6 = (rand.nextInt(2) == 0)? 6 : i + 1;
		int jump10 = (rand.nextInt(2) == 0)? 10 : i + 1;
		BlockState downState = worldIn.getBlockState(pos.below());
		BlockState waterState = this.defaultBlockState().setValue(WATERLOGGED, state.getValue(WATERLOGGED));
		
		if (state.canSurvive(worldIn, pos)) { 
			switch (i) {
			case 0:
			default:
				if (this.airLight(worldIn, pos) && rand.nextInt(3) == 0) {
					worldIn.setBlock(pos, waterState.setValue(STAGE_0_15, Integer.valueOf(12)), 3);
					worldIn.setBlock(pos.above(1), waterState.setValue(STAGE_0_15, Integer.valueOf(i + 1)), 3); }
				break;

			case 1:
				if (this.airLight(worldIn, pos) && rand.nextInt(3) == 0) {
					worldIn.setBlock(pos.below(1), waterState.setValue(STAGE_0_15, Integer.valueOf(11)), 3);
					worldIn.setBlock(pos, waterState.setValue(STAGE_0_15, Integer.valueOf(12)), 3);
					worldIn.setBlock(pos.above(1), waterState.setValue(STAGE_0_15, Integer.valueOf(i + 1)), 3); }
				break;

			case 2:
				if (this.airLight(worldIn, pos) && rand.nextInt(3) == 0) {
					worldIn.setBlock(pos.below(3), waterState.setValue(STAGE_0_15, Integer.valueOf(13)), 3);
					worldIn.setBlock(pos.below(2), waterState.setValue(STAGE_0_15, Integer.valueOf(13)), 3);
					worldIn.setBlock(pos.below(1), waterState.setValue(STAGE_0_15, Integer.valueOf(14)), 3);
					worldIn.setBlock(pos, waterState.setValue(STAGE_0_15, Integer.valueOf(14)), 3);
					worldIn.setBlock(pos.above(1), waterState.setValue(STAGE_0_15, Integer.valueOf(i + 1)), 3); }
				break;
				
			case 3:
				if (this.airLight(worldIn, pos) && rand.nextInt(3) == 0) {
					worldIn.setBlock(pos.below(2), waterState.setValue(STAGE_0_15, Integer.valueOf(13)), 3);
					worldIn.setBlock(pos, waterState.setValue(STAGE_0_15, Integer.valueOf(14)), 3);
					worldIn.setBlock(pos.above(1), waterState.setValue(STAGE_0_15, Integer.valueOf(i + 1)), 3); }
				break;
				
			case 4:
				if (this.putJungle(worldIn, pos)) {
					if (this.airLight(worldIn, pos) && rand.nextInt(3) == 0) {
						worldIn.setBlock(pos.below(2), waterState.setValue(STAGE_0_15, Integer.valueOf(13)), 3);
						worldIn.setBlock(pos, waterState.setValue(STAGE_0_15, Integer.valueOf(15)), 3);
						worldIn.setBlock(pos.above(1), waterState.setValue(STAGE_0_15, Integer.valueOf(i + 1)), 3); }
				} //putJungle
				
				if (!this.putJungle(worldIn, pos)) {
					if (this.airLight(worldIn, pos) && rand.nextInt(3) == 0) {
						worldIn.setBlock(pos.below(2), waterState.setValue(STAGE_0_15, Integer.valueOf(13)), 3);
						worldIn.setBlock(pos, waterState.setValue(STAGE_0_15, Integer.valueOf(15)), 3);
						worldIn.setBlock(pos.above(1), waterState.setValue(STAGE_0_15, Integer.valueOf(jump6)), 3); }
				} //!putJungle

				break;

			case 5:
				if (this.airLight(worldIn, pos) && rand.nextInt(3) == 0) {
					worldIn.setBlock(pos.below(2), waterState.setValue(STAGE_0_15, Integer.valueOf(13)), 3);
					worldIn.setBlock(pos.below(1), waterState.setValue(STAGE_0_15, Integer.valueOf(14)), 3);
					worldIn.setBlock(pos, waterState.setValue(STAGE_0_15, Integer.valueOf(15)), 3);
					worldIn.setBlock(pos.above(1), waterState.setValue(STAGE_0_15, Integer.valueOf(i + 1)), 3); }
				break;
				
			case 6:
				if (this.putJungle(worldIn, pos) && this.airLight(worldIn, pos) && rand.nextInt(3) == 0) {
					worldIn.setBlock(pos.below(1), waterState.setValue(STAGE_0_15, Integer.valueOf(14)), 3);
					worldIn.setBlock(pos, waterState.setValue(STAGE_0_15, Integer.valueOf(15)), 3);
					worldIn.setBlock(pos.above(1), waterState.setValue(STAGE_0_15, Integer.valueOf(i + 1)), 3); }
				break;
				
			case 7:
				if (this.putJungle(worldIn, pos) && this.airLight(worldIn, pos) && rand.nextInt(3) == 0) {
					worldIn.setBlock(pos.below(3), waterState.setValue(STAGE_0_15, Integer.valueOf(13)), 3);
					worldIn.setBlock(pos.below(1), waterState.setValue(STAGE_0_15, Integer.valueOf(14)), 3);
					worldIn.setBlock(pos, waterState.setValue(STAGE_0_15, Integer.valueOf(15)), 3);
					worldIn.setBlock(pos.above(1), waterState.setValue(STAGE_0_15, Integer.valueOf(jump10)), 3); }
				break;

			case 8:
				if (this.putJungle(worldIn, pos) && this.airLight(worldIn, pos) && rand.nextInt(3) == 0) {
					worldIn.setBlock(pos.below(3), waterState.setValue(STAGE_0_15, Integer.valueOf(13)), 3);
					worldIn.setBlock(pos, waterState.setValue(STAGE_0_15, Integer.valueOf(15)), 3);
					worldIn.setBlock(pos.above(1), waterState.setValue(STAGE_0_15, Integer.valueOf(jump10)), 3); }
				break;
				
			case 9:
				if (this.putJungle(worldIn, pos) && this.airLight(worldIn, pos) && rand.nextInt(3) == 0) {
					worldIn.setBlock(pos.below(3), waterState.setValue(STAGE_0_15, Integer.valueOf(13)), 3);
					worldIn.setBlock(pos.below(2), waterState.setValue(STAGE_0_15, Integer.valueOf(14)), 3);
					worldIn.setBlock(pos, waterState.setValue(STAGE_0_15, Integer.valueOf(15)), 3);
					worldIn.setBlock(pos.above(1), waterState.setValue(STAGE_0_15, Integer.valueOf(i + 1)), 3); }
				break;
				
			case 10: break;				
			case 11: break;
			case 12: break;
				
			case 13:
				if (downState.getBlock() instanceof SpreadableSnowyDirtBlock || downState.getMaterial() == Material.DIRT) {
					
					double x = (double) pos.getX();
					double y = (double) pos.getY();
					double z = (double) pos.getZ();
					
					BlockPos pos1 = new BlockPos(x - 1, y, z - 1);
					BlockPos pos2 = new BlockPos(x, y, z - 1);
					BlockPos pos3 = new BlockPos(x + 1, y, z - 1);
					BlockPos pos4 = new BlockPos(x - 1, y, z);
					BlockPos pos6 = new BlockPos(x + 1, y, z);
					BlockPos pos7 = new BlockPos(x - 1, y, z + 1);
					BlockPos pos8 = new BlockPos(x, y, z + 1);
					BlockPos pos9 = new BlockPos(x + 1, y, z + 1);
					
					BlockState state1 = worldIn.getBlockState(pos1);
					BlockState state2 = worldIn.getBlockState(pos2);
					BlockState state3 = worldIn.getBlockState(pos3);
					BlockState state4 = worldIn.getBlockState(pos4);
					BlockState state6 = worldIn.getBlockState(pos6);
					BlockState state7 = worldIn.getBlockState(pos7);
					BlockState state8 = worldIn.getBlockState(pos8);
					BlockState state9 = worldIn.getBlockState(pos9);
					
					BlockState TAKENOKO = Wood_Blocks.TAKENOKO.defaultBlockState();
					
					if (this.countBamboo(state, worldIn, pos) < 7) {
						
						if (!worldIn.isRaining()) {
							if (this.checkDirt1(state, worldIn, pos) && state1.getMaterial().isReplaceable()) {
								if (rand.nextInt(10) == 0) {
									worldIn.setBlock(pos1, TAKENOKO, 3); } }

							if (this.checkDirt2(state, worldIn, pos) && state2.getMaterial().isReplaceable()) {
								if (rand.nextInt(10) == 0) {
									worldIn.setBlock(pos2, TAKENOKO, 3); } }
							
							if (this.checkDirt3(state, worldIn, pos) && state3.getMaterial().isReplaceable()) {
								if (rand.nextInt(10) == 0) {
									worldIn.setBlock(pos3, TAKENOKO, 3); } }
							
							if (this.checkDirt4(state, worldIn, pos) && state4.getMaterial().isReplaceable()) {
								if (rand.nextInt(10) == 0) {
									worldIn.setBlock(pos4, TAKENOKO, 3); } }
							
							if (this.checkDirt6(state, worldIn, pos) && state6.getMaterial().isReplaceable()) {
								if (rand.nextInt(10) == 0) {
									worldIn.setBlock(pos6, TAKENOKO, 3); } }
							
							if (this.checkDirt7(state, worldIn, pos) && state7.getMaterial().isReplaceable()) {
								if (rand.nextInt(10) == 0) {
									worldIn.setBlock(pos7, TAKENOKO, 3); } }
							
							if (this.checkDirt8(state, worldIn, pos) && state8.getMaterial().isReplaceable()) {
								if (rand.nextInt(10) == 0) {
									worldIn.setBlock(pos8, TAKENOKO, 3); } }
							
							if (this.checkDirt9(state, worldIn, pos) && state9.getMaterial().isReplaceable()) {
								if (rand.nextInt(10) == 0) {
									worldIn.setBlock(pos9, TAKENOKO, 3); } }
						} //!isRaining()
						
						if (worldIn.isRaining()) {
							if (this.checkDirt1(state, worldIn, pos) && state1.getMaterial().isReplaceable()) {
								if (rand.nextInt(6) == 0) {
									worldIn.setBlock(pos1, TAKENOKO, 3); } }

							if (this.checkDirt2(state, worldIn, pos) && state2.getMaterial().isReplaceable()) {
								if (rand.nextInt(6) == 0) {
									worldIn.setBlock(pos2, TAKENOKO, 3); } }
							
							if (this.checkDirt3(state, worldIn, pos) && state3.getMaterial().isReplaceable()) {
								if (rand.nextInt(6) == 0) {
									worldIn.setBlock(pos3, TAKENOKO, 3); } }
							
							if (this.checkDirt4(state, worldIn, pos) && state4.getMaterial().isReplaceable()) {
								if (rand.nextInt(6) == 0) {
									worldIn.setBlock(pos4, TAKENOKO, 3); } }
							
							if (this.checkDirt6(state, worldIn, pos) && state6.getMaterial().isReplaceable()) {
								if (rand.nextInt(6) == 0) {
									worldIn.setBlock(pos6, TAKENOKO, 3); } }
							
							if (this.checkDirt7(state, worldIn, pos) && state7.getMaterial().isReplaceable()) {
								if (rand.nextInt(6) == 0) {
									worldIn.setBlock(pos7, TAKENOKO, 3); } }
							
							if (this.checkDirt8(state, worldIn, pos) && state8.getMaterial().isReplaceable()) {
								if (rand.nextInt(6) == 0) {
									worldIn.setBlock(pos8, TAKENOKO, 3); } }
							
							if (this.checkDirt9(state, worldIn, pos) && state9.getMaterial().isReplaceable()) {
								if (rand.nextInt(6) == 0) {
									worldIn.setBlock(pos9, TAKENOKO, 3); } }
						} //isRaining()
					} //< 7
					
					if (this.countBamboo(state, worldIn, pos) >= 7) { } //>= 7
					
				} //SpreadableSnowyDirtBlock
				break;

			case 14: break;
			case 15: break;
			} // switch STAGE_0_15		
		} 
	}
	
	private boolean putJungle(ServerWorld worldIn, BlockPos pos) {
		Optional<RegistryKey<Biome>> biomeKey = worldIn.getBiomeName(pos);
		return (biomeKey.get().location().getPath().contains("jungle") || biomeKey.get().location().getPath().contains("jungle_hills") ||
				biomeKey.get().location().getPath().contains("jungle_edge") ||
				biomeKey.get().location().getPath().contains("bamboo_jungle") || biomeKey.get().location().getPath().contains("bamboo_jungle_hills"));
	}
	
	private boolean airLight(ServerWorld worldIn, BlockPos pos) {
		return worldIn.isEmptyBlock(pos.above()) && worldIn.getRawBrightness(pos.above(), 0) >= 9;
	}
	
	private int countBamboo(BlockState state, ServerWorld worldIn, BlockPos pos) {
		int count = 0;
		for (int rangeX = -3; rangeX <= 3; rangeX++) {
			for (int rangeZ = -3; rangeZ <= 3; rangeZ++) {
				if (worldIn.getBlockState(pos.offset(rangeX, 0, rangeZ)).getBlock() instanceof Take_CM) {
					count++; }
				
				if (worldIn.getBlockState(pos.offset(rangeX, 0, rangeZ)).getBlock() instanceof Takenoko) {
					count++; }
				
				if (worldIn.getBlockState(pos.offset(rangeX, 0, rangeZ)).getBlock() instanceof BambooBlock) {
					count++; }
				
				if (worldIn.getBlockState(pos.offset(rangeX, 0, rangeZ)).getBlock() instanceof BambooSaplingBlock) {
					count++; }
			}
		}
		return count;
	}
	
	
	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(STAGE_0_15, WATERLOGGED);
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Seasonal.TAKENOKO);
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
	
	public boolean isPathfindable(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
		return false;
	}
	
	public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
		return true;
	}
	
	@SuppressWarnings("deprecation")
	public float getDestroyProgress(BlockState state, PlayerEntity entity, IBlockReader worldIn, BlockPos pos) {
		return entity.getMainHandItem().getItem() instanceof SwordItem ? 1.0F : super.getDestroyProgress(state, entity, worldIn, pos);
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
}
