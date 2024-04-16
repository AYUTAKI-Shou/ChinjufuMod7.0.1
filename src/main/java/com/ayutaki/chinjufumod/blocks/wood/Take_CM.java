package com.ayutaki.chinjufumod.blocks.wood;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Wood_Blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.BambooSaplingBlock;
import net.minecraft.world.level.block.BambooStalkBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SpreadingSnowyDirtBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Take_CM extends CM_WaterLogged {

	/* Property */
	public static final IntegerProperty STAGE_0_15 = IntegerProperty.create("stage", 0, 15);

	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.box(6.5D, 0.0D, 6.5D, 9.5D, 16.0D, 9.5D);

	public Take_CM(BlockBehaviour.Properties properties) {
		super(properties);
		/** Default state **/
		registerDefaultState(this.defaultBlockState().setValue(STAGE_0_15, Integer.valueOf(0))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* Check */
	private boolean checkDirt(BlockState state, Level worldIn, BlockPos pos) {
		int x = (int) pos.getX();
		int y = (int) pos.getY();
		int z = (int) pos.getZ();
		BlockState downState1 = worldIn.getBlockState(new BlockPos(x - 1, y - 1, z - 1));
		BlockState downState2 = worldIn.getBlockState(new BlockPos(x, y - 1, z - 1));
		BlockState downState3 = worldIn.getBlockState(new BlockPos(x + 1, y - 1, z - 1));
		BlockState downState4 = worldIn.getBlockState(new BlockPos(x - 1, y - 1, z));
		BlockState downState6 = worldIn.getBlockState(new BlockPos(x + 1, y - 1, z));
		BlockState downState7 = worldIn.getBlockState(new BlockPos(x - 1, y - 1, z + 1));
		BlockState downState8 = worldIn.getBlockState(new BlockPos(x, y - 1, z + 1));
		BlockState downState9 = worldIn.getBlockState(new BlockPos(x + 1, y - 1, z + 1));
		
		return (downState1.getBlock() instanceof SpreadingSnowyDirtBlock || downState1.is(BlockTags.DIRT)) ||
				(downState2.getBlock() instanceof SpreadingSnowyDirtBlock || downState2.is(BlockTags.DIRT)) ||
				(downState3.getBlock() instanceof SpreadingSnowyDirtBlock || downState3.is(BlockTags.DIRT)) ||
				(downState4.getBlock() instanceof SpreadingSnowyDirtBlock || downState4.is(BlockTags.DIRT)) ||
				(downState6.getBlock() instanceof SpreadingSnowyDirtBlock || downState6.is(BlockTags.DIRT)) ||
				(downState7.getBlock() instanceof SpreadingSnowyDirtBlock || downState7.is(BlockTags.DIRT)) ||
				(downState8.getBlock() instanceof SpreadingSnowyDirtBlock || downState8.is(BlockTags.DIRT)) ||
				(downState9.getBlock() instanceof SpreadingSnowyDirtBlock || downState9.is(BlockTags.DIRT));
	}
	
	private boolean checkDirt1(BlockState state, Level worldIn, BlockPos pos) {
		int x = (int) pos.getX();
		int y = (int) pos.getY();
		int z = (int) pos.getZ();
		BlockState downState1 = worldIn.getBlockState(new BlockPos(x - 1, y - 1, z - 1));
		return (downState1.getBlock() instanceof SpreadingSnowyDirtBlock || downState1.is(BlockTags.DIRT)); }
	
	private boolean checkDirt2(BlockState state, Level worldIn, BlockPos pos) {
		int x = (int) pos.getX();
		int y = (int) pos.getY();
		int z = (int) pos.getZ();
		BlockState downState2 = worldIn.getBlockState(new BlockPos(x, y - 1, z - 1));
		return (downState2.getBlock() instanceof SpreadingSnowyDirtBlock || downState2.is(BlockTags.DIRT)); }
	
	private boolean checkDirt3(BlockState state, Level worldIn, BlockPos pos) {
		int x = (int) pos.getX();
		int y = (int) pos.getY();
		int z = (int) pos.getZ();
		BlockState downState3 = worldIn.getBlockState(new BlockPos(x + 1, y - 1, z - 1));
		return (downState3.getBlock() instanceof SpreadingSnowyDirtBlock || downState3.is(BlockTags.DIRT)); }
	
	private boolean checkDirt4(BlockState state, Level worldIn, BlockPos pos) {
		int x = (int) pos.getX();
		int y = (int) pos.getY();
		int z = (int) pos.getZ();
		BlockState downState4 = worldIn.getBlockState(new BlockPos(x - 1, y - 1, z));
		return (downState4.getBlock() instanceof SpreadingSnowyDirtBlock || downState4.is(BlockTags.DIRT)); }
	
	private boolean checkDirt6(BlockState state, Level worldIn, BlockPos pos) {
		int x = (int) pos.getX();
		int y = (int) pos.getY();
		int z = (int) pos.getZ();
		BlockState downState6 = worldIn.getBlockState(new BlockPos(x + 1, y - 1, z));
		return (downState6.getBlock() instanceof SpreadingSnowyDirtBlock || downState6.is(BlockTags.DIRT)); }
	
	private boolean checkDirt7(BlockState state, Level worldIn, BlockPos pos) {
		int x = (int) pos.getX();
		int y = (int) pos.getY();
		int z = (int) pos.getZ();
		BlockState downState7 = worldIn.getBlockState(new BlockPos(x - 1, y - 1, z + 1));
		return (downState7.getBlock() instanceof SpreadingSnowyDirtBlock || downState7.is(BlockTags.DIRT)); }
	
	private boolean checkDirt8(BlockState state, Level worldIn, BlockPos pos) {
		int x = (int) pos.getX();
		int y = (int) pos.getY();
		int z = (int) pos.getZ();
		BlockState downState8 = worldIn.getBlockState(new BlockPos(x, y - 1, z + 1));
		return(downState8.getBlock() instanceof SpreadingSnowyDirtBlock || downState8.is(BlockTags.DIRT)); }
	
	private boolean checkDirt9(BlockState state, Level worldIn, BlockPos pos) {
		int x = (int) pos.getX();
		int y = (int) pos.getY();
		int z = (int) pos.getZ();
		BlockState downState9 = worldIn.getBlockState(new BlockPos(x + 1, y - 1, z + 1));
		return (downState9.getBlock() instanceof SpreadingSnowyDirtBlock || downState9.is(BlockTags.DIRT)); }
	
	private boolean checkSpace(BlockState state, Level worldIn, BlockPos pos) {
		int x = (int) pos.getX();
		int y = (int) pos.getY();
		int z = (int) pos.getZ();
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
		
		return (state1.canBeReplaced()) ||
				(state2.canBeReplaced()) ||
				(state3.canBeReplaced()) ||
				(state4.canBeReplaced()) ||
				(state6.canBeReplaced()) ||
				(state7.canBeReplaced()) ||
				(state8.canBeReplaced()) ||
				(state9.canBeReplaced());
	}
	
	/* RightClick Action */
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		int i = state.getValue(STAGE_0_15);
		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		BlockState downState = worldIn.getBlockState(pos.below());
		
		if (i == 13 && (downState.getBlock() instanceof SpreadingSnowyDirtBlock || downState.is(BlockTags.DIRT))) {
			if (this.checkDirt(state, worldIn, pos) && this.checkSpace(state, worldIn, pos)) {
				
				if (item == Items.BONE_MEAL || item == Items_Seasonal.WARAHAI.get()) {
					CMEvents.Use_BoneMeal(worldIn, pos, playerIn, hand);
					
					for(int n = 0; n < 15; ++n) {
						double d0 = worldIn.random.nextGaussian() * 0.02D;
						double d1 = worldIn.random.nextGaussian() * 0.02D;
						double d2 = worldIn.random.nextGaussian() * 0.02D;
						worldIn.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + worldIn.random.nextFloat(), pos.getY() +worldIn.random.nextFloat(), pos.getZ() + worldIn.random.nextFloat(), d0, d1, d2); }
					
					int x = (int) pos.getX();
					int y = (int) pos.getY();
					int z = (int) pos.getZ();
					
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
					
					BlockState TAKENOKO = Wood_Blocks.TAKENOKO.get().defaultBlockState();

					if (this.checkDirt1(state, worldIn, pos) && state1.canBeReplaced()) {
						if (worldIn.random.nextInt(3) == 0) {
							worldIn.setBlock(pos1, TAKENOKO, 3); } }
	
					if (this.checkDirt2(state, worldIn, pos) && state2.canBeReplaced()) {
						if (worldIn.random.nextInt(3) == 0) {
							worldIn.setBlock(pos2, TAKENOKO, 3); } }
					
					if (this.checkDirt3(state, worldIn, pos) && state3.canBeReplaced()) {
						if (worldIn.random.nextInt(3) == 0) {
							worldIn.setBlock(pos3, TAKENOKO, 3); } }
					
					if (this.checkDirt4(state, worldIn, pos) && state4.canBeReplaced()) {
						if (worldIn.random.nextInt(3) == 0) {
							worldIn.setBlock(pos4, TAKENOKO, 3); } }
					
					if (this.checkDirt6(state, worldIn, pos) && state6.canBeReplaced()) {
						if (worldIn.random.nextInt(3) == 0) {
							worldIn.setBlock(pos6, TAKENOKO, 3); } }
					
					if (this.checkDirt7(state, worldIn, pos) && state7.canBeReplaced()) {
						if (worldIn.random.nextInt(3) == 0) {
							worldIn.setBlock(pos7, TAKENOKO, 3); } }
					
					if (this.checkDirt8(state, worldIn, pos) && state8.canBeReplaced()) {
						if (worldIn.random.nextInt(3) == 0) {
							worldIn.setBlock(pos8, TAKENOKO, 3); } }
					
					if (this.checkDirt9(state, worldIn, pos) && state9.canBeReplaced()) {
						if (worldIn.random.nextInt(3) == 0) {
							worldIn.setBlock(pos9, TAKENOKO, 3); } }
				} //BONE_MEAL
			} // check
	
			if (!this.checkDirt(state, worldIn, pos) || !this.checkSpace(state, worldIn, pos)) {
				CMEvents.textNoPlace(worldIn, pos, playerIn);
			} // !check
		} //downBlock
		
		/** SUCCESS to not put anything on top. **/
		return InteractionResult.SUCCESS;
	}


	/* Update BlockState. */
	@Override
	public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
		int i = state.getValue(STAGE_0_15);
		BlockState downState = worldIn.getBlockState(pos.below());
		Block upBlock = worldIn.getBlockState(pos.above()).getBlock();
		
		return (i > 10)? ((downState.getBlock() instanceof SpreadingSnowyDirtBlock || downState.is(BlockTags.DIRT) || downState.getBlock() instanceof Take_CM) && upBlock instanceof Take_CM) : downState.getBlock() instanceof Take_CM;
	}
	
	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos pos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			worldIn.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }
		
		if (!state.canSurvive(worldIn, pos)) { worldIn.scheduleTick(pos, this, 1); }
		
		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}

	/* TickRandom */
	public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
		if (!state.canSurvive(worldIn, pos)) { worldIn.destroyBlock(pos, true); }
	}
	
	public boolean isRandomlyTicking(BlockState state) {
		return true;
	}
	
	@Override
	public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
		int i = state.getValue(STAGE_0_15);
		int jump6 = (rand.nextInt(2) == 0)? 6 : i + 1;
		int jump10 = (rand.nextInt(2) == 0)? 10 : i + 1;
		BlockState downState = worldIn.getBlockState(pos.below());
		BlockState waterState = this.defaultBlockState().setValue(WATERLOGGED, state.getValue(WATERLOGGED));
		
		if (state.canSurvive(worldIn, pos)) { 
			switch (i) {
			case 0 :
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
				if (downState.getBlock() instanceof SpreadingSnowyDirtBlock || downState.is(BlockTags.DIRT)) {
					
					int x = (int) pos.getX();
					int y = (int) pos.getY();
					int z = (int) pos.getZ();
					
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
					
					BlockState TAKENOKO = Wood_Blocks.TAKENOKO.get().defaultBlockState();
					
					if (this.countBamboo(state, worldIn, pos) < 7) {
						
						if (!worldIn.isRaining()) {
							if (this.checkDirt1(state, worldIn, pos) && state1.canBeReplaced()) {
								if (rand.nextInt(10) == 0) {
									worldIn.setBlock(pos1, TAKENOKO, 3); } }

							if (this.checkDirt2(state, worldIn, pos) && state2.canBeReplaced()) {
								if (rand.nextInt(10) == 0) {
									worldIn.setBlock(pos2, TAKENOKO, 3); } }
							
							if (this.checkDirt3(state, worldIn, pos) && state3.canBeReplaced()) {
								if (rand.nextInt(10) == 0) {
									worldIn.setBlock(pos3, TAKENOKO, 3); } }
							
							if (this.checkDirt4(state, worldIn, pos) && state4.canBeReplaced()) {
								if (rand.nextInt(10) == 0) {
									worldIn.setBlock(pos4, TAKENOKO, 3); } }
							
							if (this.checkDirt6(state, worldIn, pos) && state6.canBeReplaced()) {
								if (rand.nextInt(10) == 0) {
									worldIn.setBlock(pos6, TAKENOKO, 3); } }
							
							if (this.checkDirt7(state, worldIn, pos) && state7.canBeReplaced()) {
								if (rand.nextInt(10) == 0) {
									worldIn.setBlock(pos7, TAKENOKO, 3); } }
							
							if (this.checkDirt8(state, worldIn, pos) && state8.canBeReplaced()) {
								if (rand.nextInt(10) == 0) {
									worldIn.setBlock(pos8, TAKENOKO, 3); } }
							
							if (this.checkDirt9(state, worldIn, pos) && state9.canBeReplaced()) {
								if (rand.nextInt(10) == 0) {
									worldIn.setBlock(pos9, TAKENOKO, 3); } }
						} //!isRaining()
						
						if (worldIn.isRaining()) {
							if (this.checkDirt1(state, worldIn, pos) && state1.canBeReplaced()) {
								if (rand.nextInt(6) == 0) {
									worldIn.setBlock(pos1, TAKENOKO, 3); } }

							if (this.checkDirt2(state, worldIn, pos) && state2.canBeReplaced()) {
								if (rand.nextInt(6) == 0) {
									worldIn.setBlock(pos2, TAKENOKO, 3); } }
							
							if (this.checkDirt3(state, worldIn, pos) && state3.canBeReplaced()) {
								if (rand.nextInt(6) == 0) {
									worldIn.setBlock(pos3, TAKENOKO, 3); } }
							
							if (this.checkDirt4(state, worldIn, pos) && state4.canBeReplaced()) {
								if (rand.nextInt(6) == 0) {
									worldIn.setBlock(pos4, TAKENOKO, 3); } }
							
							if (this.checkDirt6(state, worldIn, pos) && state6.canBeReplaced()) {
								if (rand.nextInt(6) == 0) {
									worldIn.setBlock(pos6, TAKENOKO, 3); } }
							
							if (this.checkDirt7(state, worldIn, pos) && state7.canBeReplaced()) {
								if (rand.nextInt(6) == 0) {
									worldIn.setBlock(pos7, TAKENOKO, 3); } }
							
							if (this.checkDirt8(state, worldIn, pos) && state8.canBeReplaced()) {
								if (rand.nextInt(6) == 0) {
									worldIn.setBlock(pos8, TAKENOKO, 3); } }
							
							if (this.checkDirt9(state, worldIn, pos) && state9.canBeReplaced()) {
								if (rand.nextInt(6) == 0) {
									worldIn.setBlock(pos9, TAKENOKO, 3); } }
						} //isRaining()
					} //< 7
					
					if (this.countBamboo(state, worldIn, pos) >= 7) { } //>= 7
					
				} //SpreadingSnowyDirtBlock
				break;

			case 14: break;
			case 15: break;
			} // switch STAGE_0_15		
		} 
	}
	
	private boolean putJungle(ServerLevel worldIn, BlockPos pos) {
		Holder<Biome> biome = worldIn.getBiome(pos);
		return (biome.is(Biomes.JUNGLE) || biome.is(Biomes.BAMBOO_JUNGLE) || biome.is(Biomes.SPARSE_JUNGLE));
	}
	
	private boolean airLight(ServerLevel worldIn, BlockPos pos) {
		return worldIn.isEmptyBlock(pos.above()) && worldIn.getRawBrightness(pos.above(), 0) >= 9;
	}
	
	private int countBamboo(BlockState state, ServerLevel worldIn, BlockPos pos) {
		int count = 0;
		for (int rangeX = -3; rangeX <= 3; rangeX++) {
			for (int rangeZ = -3; rangeZ <= 3; rangeZ++) {
				if (worldIn.getBlockState(pos.offset(rangeX, 0, rangeZ)).getBlock() instanceof Take_CM) {
					count++; }
				
				if (worldIn.getBlockState(pos.offset(rangeX, 0, rangeZ)).getBlock() instanceof Takenoko) {
					count++; }
				
				if (worldIn.getBlockState(pos.offset(rangeX, 0, rangeZ)).getBlock() instanceof BambooStalkBlock) {
					count++; }
				
				if (worldIn.getBlockState(pos.offset(rangeX, 0, rangeZ)).getBlock() instanceof BambooSaplingBlock) {
					count++; }
			}
		}
		return count;
	}
	
	
	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(STAGE_0_15, WATERLOGGED);
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Seasonal.TAKENOKO.get());
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
	
	@Override
	public boolean isPathfindable(BlockState state, BlockGetter worldIn, BlockPos pos, PathComputationType type) {
		return false;
	}
	
	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}
	
	@SuppressWarnings("deprecation")
	public float getDestroyProgress(BlockState state, Player entity, BlockGetter worldIn, BlockPos pos) {
		return entity.getMainHandItem().canPerformAction(net.minecraftforge.common.ToolActions.SWORD_DIG) ? 1.0F : super.getDestroyProgress(state, entity, worldIn, pos);
	}
}
