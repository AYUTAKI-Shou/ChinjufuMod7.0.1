package com.ayutaki.chinjufumod.blocks.wood;

import java.util.Random;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Wood_Blocks;

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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.server.ServerWorld;

public class Take_CM extends CM_WaterLogged {

	/* Property */
	public static final IntegerProperty STAGE_0_15 = IntegerProperty.create("stage", 0, 15);

	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.makeCuboidShape(6.5D, 0.0D, 6.5D, 9.5D, 16.0D, 9.5D);

	public Take_CM(Block.Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(STAGE_0_15, Integer.valueOf(0))
				.with(WATERLOGGED, Boolean.valueOf(false)));
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
		
		return (downState1.getBlock() instanceof SpreadableSnowyDirtBlock || downState1.getMaterial() == Material.EARTH) ||
				(downState2.getBlock() instanceof SpreadableSnowyDirtBlock || downState2.getMaterial() == Material.EARTH) ||
				(downState3.getBlock() instanceof SpreadableSnowyDirtBlock || downState3.getMaterial() == Material.EARTH) ||
				(downState4.getBlock() instanceof SpreadableSnowyDirtBlock || downState4.getMaterial() == Material.EARTH) ||
				(downState6.getBlock() instanceof SpreadableSnowyDirtBlock || downState6.getMaterial() == Material.EARTH) ||
				(downState7.getBlock() instanceof SpreadableSnowyDirtBlock || downState7.getMaterial() == Material.EARTH) ||
				(downState8.getBlock() instanceof SpreadableSnowyDirtBlock || downState8.getMaterial() == Material.EARTH) ||
				(downState9.getBlock() instanceof SpreadableSnowyDirtBlock || downState9.getMaterial() == Material.EARTH);
	}
	
	private boolean checkDirt1(BlockState state, World worldIn, BlockPos pos) {
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		BlockState downState1 = worldIn.getBlockState(new BlockPos(x - 1, y - 1, z - 1));
		return (downState1.getBlock() instanceof SpreadableSnowyDirtBlock || downState1.getMaterial() == Material.EARTH); }
	
	private boolean checkDirt2(BlockState state, World worldIn, BlockPos pos) {
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		BlockState downState2 = worldIn.getBlockState(new BlockPos(x, y - 1, z - 1));
		return (downState2.getBlock() instanceof SpreadableSnowyDirtBlock || downState2.getMaterial() == Material.EARTH); }
	
	private boolean checkDirt3(BlockState state, World worldIn, BlockPos pos) {
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		BlockState downState3 = worldIn.getBlockState(new BlockPos(x + 1, y - 1, z - 1));
		return (downState3.getBlock() instanceof SpreadableSnowyDirtBlock || downState3.getMaterial() == Material.EARTH); }
	
	private boolean checkDirt4(BlockState state, World worldIn, BlockPos pos) {
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		BlockState downState4 = worldIn.getBlockState(new BlockPos(x - 1, y - 1, z));
		return (downState4.getBlock() instanceof SpreadableSnowyDirtBlock || downState4.getMaterial() == Material.EARTH); }
	
	private boolean checkDirt6(BlockState state, World worldIn, BlockPos pos) {
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		BlockState downState6 = worldIn.getBlockState(new BlockPos(x + 1, y - 1, z));
		return (downState6.getBlock() instanceof SpreadableSnowyDirtBlock || downState6.getMaterial() == Material.EARTH); }
	
	private boolean checkDirt7(BlockState state, World worldIn, BlockPos pos) {
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		BlockState downState7 = worldIn.getBlockState(new BlockPos(x - 1, y - 1, z + 1));
		return (downState7.getBlock() instanceof SpreadableSnowyDirtBlock || downState7.getMaterial() == Material.EARTH); }
	
	private boolean checkDirt8(BlockState state, World worldIn, BlockPos pos) {
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		BlockState downState8 = worldIn.getBlockState(new BlockPos(x, y - 1, z + 1));
		return(downState8.getBlock() instanceof SpreadableSnowyDirtBlock || downState8.getMaterial() == Material.EARTH); }
	
	private boolean checkDirt9(BlockState state, World worldIn, BlockPos pos) {
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		BlockState downState9 = worldIn.getBlockState(new BlockPos(x + 1, y - 1, z + 1));
		return (downState9.getBlock() instanceof SpreadableSnowyDirtBlock || downState9.getMaterial() == Material.EARTH); }
	
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
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {
		int i = state.get(STAGE_0_15);
		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		BlockState downState = worldIn.getBlockState(pos.down());
		
		if (i == 13 && (downState.getBlock() instanceof SpreadableSnowyDirtBlock || downState.getMaterial() == Material.EARTH)) {
			if (this.checkDirt(state, worldIn, pos) && this.checkSpace(state, worldIn, pos)) {
				
				if (item == Items.BONE_MEAL || item == Items_Seasonal.WARAHAI) {
					CMEvents.Consume_1Item(playerIn, hand);
					
					for(int n = 0; n < 15; ++n) {
						double d0 = worldIn.rand.nextGaussian() * 0.02D;
						double d1 = worldIn.rand.nextGaussian() * 0.02D;
						double d2 = worldIn.rand.nextGaussian() * 0.02D;
						worldIn.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + worldIn.rand.nextFloat(), pos.getY() +worldIn.rand.nextFloat(), pos.getZ() + worldIn.rand.nextFloat(), d0, d1, d2); }
					
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
					
					BlockState TAKENOKO = Wood_Blocks.TAKENOKO.getDefaultState();

					if (this.checkDirt1(state, worldIn, pos) && state1.getMaterial().isReplaceable()) {
						if (worldIn.rand.nextInt(3) == 0) {
							worldIn.setBlockState(pos1, TAKENOKO, 3); } }
	
					if (this.checkDirt2(state, worldIn, pos) && state2.getMaterial().isReplaceable()) {
						if (worldIn.rand.nextInt(3) == 0) {
							worldIn.setBlockState(pos2, TAKENOKO, 3); } }
					
					if (this.checkDirt3(state, worldIn, pos) && state3.getMaterial().isReplaceable()) {
						if (worldIn.rand.nextInt(3) == 0) {
							worldIn.setBlockState(pos3, TAKENOKO, 3); } }
					
					if (this.checkDirt4(state, worldIn, pos) && state4.getMaterial().isReplaceable()) {
						if (worldIn.rand.nextInt(3) == 0) {
							worldIn.setBlockState(pos4, TAKENOKO, 3); } }
					
					if (this.checkDirt6(state, worldIn, pos) && state6.getMaterial().isReplaceable()) {
						if (worldIn.rand.nextInt(3) == 0) {
							worldIn.setBlockState(pos6, TAKENOKO, 3); } }
					
					if (this.checkDirt7(state, worldIn, pos) && state7.getMaterial().isReplaceable()) {
						if (worldIn.rand.nextInt(3) == 0) {
							worldIn.setBlockState(pos7, TAKENOKO, 3); } }
					
					if (this.checkDirt8(state, worldIn, pos) && state8.getMaterial().isReplaceable()) {
						if (worldIn.rand.nextInt(3) == 0) {
							worldIn.setBlockState(pos8, TAKENOKO, 3); } }
					
					if (this.checkDirt9(state, worldIn, pos) && state9.getMaterial().isReplaceable()) {
						if (worldIn.rand.nextInt(3) == 0) {
							worldIn.setBlockState(pos9, TAKENOKO, 3); } }
				} //BONE_MEAL
			} // check
	
			if (!this.checkDirt(state, worldIn, pos) || !this.checkSpace(state, worldIn, pos)) {
				CMEvents.textNoPlace(worldIn, pos, playerIn);
			} // !check
		} //downBlock
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}
	
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		int i = state.get(STAGE_0_15);
		BlockState downState = worldIn.getBlockState(pos.down());
		Block upBlock = worldIn.getBlockState(pos.up()).getBlock();
		
		return (i > 10)? ((downState.getBlock() instanceof SpreadableSnowyDirtBlock || downState.getBlock() instanceof Take_CM || downState.getMaterial() == Material.EARTH) && upBlock instanceof Take_CM) : downState.getBlock() instanceof Take_CM;
	}
	
	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn)); }
		
		if (!state.isValidPosition(worldIn, pos)) { worldIn.getPendingBlockTicks().scheduleTick(pos, this, 1); }

		return super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
	}

	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		if (!state.isValidPosition(worldIn, pos)) { worldIn.destroyBlock(pos, true); } 
	}
	
	public boolean ticksRandomly(BlockState state) {
		return true;
	}
	
	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		int i = state.get(STAGE_0_15);
		int jump6 = (rand.nextInt(2) == 0)? 6 : i + 1;
		int jump10 = (rand.nextInt(2) == 0)? 10 : i + 1;
		BlockState downState = worldIn.getBlockState(pos.down());
		BlockState waterState = this.getDefaultState().with(WATERLOGGED, state.get(WATERLOGGED));
		if (state.isValidPosition(worldIn, pos)) { 
			switch (i) {
			case 0:
			default:
				if (this.airLight(worldIn, pos) && rand.nextInt(3) == 0) {
					worldIn.setBlockState(pos, waterState.with(STAGE_0_15, Integer.valueOf(12)));
					worldIn.setBlockState(pos.up(1), waterState.with(STAGE_0_15, Integer.valueOf(i + 1))); }
				break;

			case 1:
				if (this.airLight(worldIn, pos) && rand.nextInt(3) == 0) {
					worldIn.setBlockState(pos.down(1), waterState.with(STAGE_0_15, Integer.valueOf(11)));
					worldIn.setBlockState(pos, waterState.with(STAGE_0_15, Integer.valueOf(12)));
					worldIn.setBlockState(pos.up(1), waterState.with(STAGE_0_15, Integer.valueOf(i + 1))); }
				break;

			case 2:
				if (this.airLight(worldIn, pos) && rand.nextInt(3) == 0) {
					worldIn.setBlockState(pos.down(3), waterState.with(STAGE_0_15, Integer.valueOf(13)));
					worldIn.setBlockState(pos.down(2), waterState.with(STAGE_0_15, Integer.valueOf(13)));
					worldIn.setBlockState(pos.down(1), waterState.with(STAGE_0_15, Integer.valueOf(14)));
					worldIn.setBlockState(pos, waterState.with(STAGE_0_15, Integer.valueOf(14)));
					worldIn.setBlockState(pos.up(1), waterState.with(STAGE_0_15, Integer.valueOf(i + 1))); }
				break;
				
			case 3:
				if (this.airLight(worldIn, pos) && rand.nextInt(3) == 0) {
					worldIn.setBlockState(pos.down(2), waterState.with(STAGE_0_15, Integer.valueOf(13)));
					worldIn.setBlockState(pos, waterState.with(STAGE_0_15, Integer.valueOf(14)));
					worldIn.setBlockState(pos.up(1), waterState.with(STAGE_0_15, Integer.valueOf(i + 1))); }
				break;
				
			case 4:
				if (this.putJungle(worldIn, pos)) {
					if (this.airLight(worldIn, pos) && rand.nextInt(3) == 0) {
						worldIn.setBlockState(pos.down(2), waterState.with(STAGE_0_15, Integer.valueOf(13)));
						worldIn.setBlockState(pos, waterState.with(STAGE_0_15, Integer.valueOf(15)));
						worldIn.setBlockState(pos.up(1), waterState.with(STAGE_0_15, Integer.valueOf(i + 1))); }
				} //putJungle
				
				if (!this.putJungle(worldIn, pos)) {
					if (this.airLight(worldIn, pos) && rand.nextInt(3) == 0) {
						worldIn.setBlockState(pos.down(2), waterState.with(STAGE_0_15, Integer.valueOf(13)));
						worldIn.setBlockState(pos, waterState.with(STAGE_0_15, Integer.valueOf(15)));
						worldIn.setBlockState(pos.up(1), waterState.with(STAGE_0_15, Integer.valueOf(jump6))); }
				} //!putJungle
				break;

			case 5:
				if (this.airLight(worldIn, pos) && rand.nextInt(3) == 0) {
					worldIn.setBlockState(pos.down(2), waterState.with(STAGE_0_15, Integer.valueOf(13)));
					worldIn.setBlockState(pos.down(1), waterState.with(STAGE_0_15, Integer.valueOf(14)));
					worldIn.setBlockState(pos, waterState.with(STAGE_0_15, Integer.valueOf(15)));
					worldIn.setBlockState(pos.up(1), waterState.with(STAGE_0_15, Integer.valueOf(i + 1))); }
				break;
				
			case 6:
				if (this.putJungle(worldIn, pos) && this.airLight(worldIn, pos) && rand.nextInt(3) == 0) {
					worldIn.setBlockState(pos.down(1), waterState.with(STAGE_0_15, Integer.valueOf(14)));
					worldIn.setBlockState(pos, waterState.with(STAGE_0_15, Integer.valueOf(15)));
					worldIn.setBlockState(pos.up(1), waterState.with(STAGE_0_15, Integer.valueOf(i + 1))); }
				break;
				
			case 7:
				if (this.putJungle(worldIn, pos) && this.airLight(worldIn, pos) && rand.nextInt(3) == 0) {
					worldIn.setBlockState(pos.down(3), waterState.with(STAGE_0_15, Integer.valueOf(13)));
					worldIn.setBlockState(pos.down(1), waterState.with(STAGE_0_15, Integer.valueOf(14)));
					worldIn.setBlockState(pos, waterState.with(STAGE_0_15, Integer.valueOf(15)));
					worldIn.setBlockState(pos.up(1), waterState.with(STAGE_0_15, Integer.valueOf(jump10))); }
				break;

			case 8:
				if (this.putJungle(worldIn, pos) && this.airLight(worldIn, pos) && rand.nextInt(3) == 0) {
					worldIn.setBlockState(pos.down(3), waterState.with(STAGE_0_15, Integer.valueOf(13)));
					worldIn.setBlockState(pos, waterState.with(STAGE_0_15, Integer.valueOf(15)));
					worldIn.setBlockState(pos.up(1), waterState.with(STAGE_0_15, Integer.valueOf(jump10))); }
				break;
				
			case 9:
				if (this.putJungle(worldIn, pos) && this.airLight(worldIn, pos) && rand.nextInt(3) == 0) {
					worldIn.setBlockState(pos.down(3), waterState.with(STAGE_0_15, Integer.valueOf(13)));
					worldIn.setBlockState(pos.down(2), waterState.with(STAGE_0_15, Integer.valueOf(14)));
					worldIn.setBlockState(pos, waterState.with(STAGE_0_15, Integer.valueOf(15)));
					worldIn.setBlockState(pos.up(1), waterState.with(STAGE_0_15, Integer.valueOf(i + 1))); }
				break;
				
			case 10: break;				
			case 11: break;
			case 12: break;
				
			case 13:
				if (downState.getBlock() instanceof SpreadableSnowyDirtBlock || downState.getMaterial() == Material.EARTH) {
					
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
					
					BlockState TAKENOKO = Wood_Blocks.TAKENOKO.getDefaultState();
					
					if (this.countBamboo(state, worldIn, pos) < 7) {
						
						if (!worldIn.isRaining()) {
							if (this.checkDirt1(state, worldIn, pos) && state1.getMaterial().isReplaceable()) {
								if (rand.nextInt(10) == 0) {
									worldIn.setBlockState(pos1, TAKENOKO, 3); } }

							if (this.checkDirt2(state, worldIn, pos) && state2.getMaterial().isReplaceable()) {
								if (rand.nextInt(10) == 0) {
									worldIn.setBlockState(pos2, TAKENOKO, 3); } }
							
							if (this.checkDirt3(state, worldIn, pos) && state3.getMaterial().isReplaceable()) {
								if (rand.nextInt(10) == 0) {
									worldIn.setBlockState(pos3, TAKENOKO, 3); } }
							
							if (this.checkDirt4(state, worldIn, pos) && state4.getMaterial().isReplaceable()) {
								if (rand.nextInt(10) == 0) {
									worldIn.setBlockState(pos4, TAKENOKO, 3); } }
							
							if (this.checkDirt6(state, worldIn, pos) && state6.getMaterial().isReplaceable()) {
								if (rand.nextInt(10) == 0) {
									worldIn.setBlockState(pos6, TAKENOKO, 3); } }
							
							if (this.checkDirt7(state, worldIn, pos) && state7.getMaterial().isReplaceable()) {
								if (rand.nextInt(10) == 0) {
									worldIn.setBlockState(pos7, TAKENOKO, 3); } }
							
							if (this.checkDirt8(state, worldIn, pos) && state8.getMaterial().isReplaceable()) {
								if (rand.nextInt(10) == 0) {
									worldIn.setBlockState(pos8, TAKENOKO, 3); } }
							
							if (this.checkDirt9(state, worldIn, pos) && state9.getMaterial().isReplaceable()) {
								if (rand.nextInt(10) == 0) {
									worldIn.setBlockState(pos9, TAKENOKO, 3); } }
						} //!isRaining()
						
						if (worldIn.isRaining()) {
							if (this.checkDirt1(state, worldIn, pos) && state1.getMaterial().isReplaceable()) {
								if (rand.nextInt(6) == 0) {
									worldIn.setBlockState(pos1, TAKENOKO, 3); } }

							if (this.checkDirt2(state, worldIn, pos) && state2.getMaterial().isReplaceable()) {
								if (rand.nextInt(6) == 0) {
									worldIn.setBlockState(pos2, TAKENOKO, 3); } }
							
							if (this.checkDirt3(state, worldIn, pos) && state3.getMaterial().isReplaceable()) {
								if (rand.nextInt(6) == 0) {
									worldIn.setBlockState(pos3, TAKENOKO, 3); } }
							
							if (this.checkDirt4(state, worldIn, pos) && state4.getMaterial().isReplaceable()) {
								if (rand.nextInt(6) == 0) {
									worldIn.setBlockState(pos4, TAKENOKO, 3); } }
							
							if (this.checkDirt6(state, worldIn, pos) && state6.getMaterial().isReplaceable()) {
								if (rand.nextInt(6) == 0) {
									worldIn.setBlockState(pos6, TAKENOKO, 3); } }
							
							if (this.checkDirt7(state, worldIn, pos) && state7.getMaterial().isReplaceable()) {
								if (rand.nextInt(6) == 0) {
									worldIn.setBlockState(pos7, TAKENOKO, 3); } }
							
							if (this.checkDirt8(state, worldIn, pos) && state8.getMaterial().isReplaceable()) {
								if (rand.nextInt(6) == 0) {
									worldIn.setBlockState(pos8, TAKENOKO, 3); } }
							
							if (this.checkDirt9(state, worldIn, pos) && state9.getMaterial().isReplaceable()) {
								if (rand.nextInt(6) == 0) {
									worldIn.setBlockState(pos9, TAKENOKO, 3); } }
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
		Biome biome = worldIn.getBiome(pos);
		return (biome == Biomes.JUNGLE || biome == Biomes.JUNGLE_HILLS || biome == Biomes.JUNGLE_EDGE || 
				biome == Biomes.BAMBOO_JUNGLE || biome == Biomes.BAMBOO_JUNGLE_HILLS);
	}
	
	private boolean airLight(ServerWorld worldIn, BlockPos pos) {
		return worldIn.isAirBlock(pos.up()) && worldIn.getLightSubtracted(pos.up(), 0) >= 9;
	}
	
	private int countBamboo(BlockState state, ServerWorld worldIn, BlockPos pos) {
		int count = 0;
		for (int rangeX = -3; rangeX <= 3; rangeX++) {
			for (int rangeZ = -3; rangeZ <= 3; rangeZ++) {
				if (worldIn.getBlockState(pos.add(rangeX, 0, rangeZ)).getBlock() instanceof Take_CM) {
					count++; }
				
				if (worldIn.getBlockState(pos.add(rangeX, 0, rangeZ)).getBlock() instanceof Takenoko) {
					count++; }
				
				if (worldIn.getBlockState(pos.add(rangeX, 0, rangeZ)).getBlock() instanceof BambooBlock) {
					count++; }
				
				if (worldIn.getBlockState(pos.add(rangeX, 0, rangeZ)).getBlock() instanceof BambooSaplingBlock) {
					count++; }
			}
		}
		return count;
	}
	
	/* Create Blockstate */
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(STAGE_0_15, WATERLOGGED);
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Seasonal.TAKENOKO);
	}
	
	/* Collisions for each property. */
	public Block.OffsetType getOffsetType() {
		return Block.OffsetType.XZ;
	}

	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Vec3d vec3d = state.getOffset(worldIn, pos);
		return AABB_BOX.withOffset(vec3d.x, vec3d.y, vec3d.z);
	}

	public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
		return false;
	}

	public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
		return true;
	}

	/** @deprecated call via {@link IBlockState#getPlayerRelativeBlockHardness(EntityPlayer,World,BlockPos)} */
	public float getPlayerRelativeBlockHardness(BlockState state, PlayerEntity player, IBlockReader worldIn, BlockPos pos) {
			return player.getHeldItemMainhand().getItem() instanceof SwordItem ? 1.0F : super.getPlayerRelativeBlockHardness(state, player, worldIn, pos);
	}
}
