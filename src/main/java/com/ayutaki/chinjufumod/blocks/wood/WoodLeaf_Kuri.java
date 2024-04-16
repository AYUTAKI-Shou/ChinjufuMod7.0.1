package com.ayutaki.chinjufumod.blocks.wood;

import java.util.List;

import com.ayutaki.chinjufumod.Config_CM;
import com.ayutaki.chinjufumod.handler.ParticleTypes_CM;
import com.ayutaki.chinjufumod.registry.Wood_Blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/* Avoid loss. data\minecraft\tags\blocks\leaves.json and logs.json */
public class WoodLeaf_Kuri extends Block implements net.minecraftforge.common.IForgeShearable {

	public static final IntegerProperty DISTANCE = IntegerProperty.create("distance", 1, 7);
	public static final BooleanProperty PERSISTENT = BooleanProperty.create("persistent");
	public static final BooleanProperty DROP = BooleanProperty.create("drop");
	
	public WoodLeaf_Kuri(BlockBehaviour.Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(DISTANCE, Integer.valueOf(7))
				.setValue(PERSISTENT, Boolean.valueOf(false))
				.setValue(DROP, Boolean.valueOf(false)));
	}
	
	/* Gives a value when placed. */
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return updateDistance(this.defaultBlockState().setValue(PERSISTENT, Boolean.valueOf(true))
				.setValue(DROP, Boolean.valueOf(true)), context.getLevel(), context.getClickedPos());
	}
	
	/* Update BlockState. */
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos pos, BlockPos facingPos) {
		int i = getDistance(facingState) + 1;
		if (i != 1 || state.getValue(DISTANCE) != i) { worldIn.scheduleTick(pos, this, 1); }
		return state;
	}
	
	private static BlockState updateDistance(BlockState state, LevelAccessor worldIn, BlockPos pos) {
		int i = 7;
		BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
		
		for(Direction direction : Direction.values()) {
			mutable.setWithOffset(pos, direction);
			i = Math.min(i, getDistance(worldIn.getBlockState(mutable)) + 1);
			
			if (i == 1) { break; }
		}
		return state.setValue(DISTANCE, Integer.valueOf(i)).setValue(PERSISTENT, state.getValue(PERSISTENT))
				.setValue(DROP, state.getValue(DROP));
	}
	
	private static int getDistance(BlockState neighbor) {
		if (neighbor.is(BlockTags.LOGS)) { return 0; }
		
		else { return neighbor.getBlock() instanceof WoodLeaf_Kuri ? neighbor.getValue(DISTANCE) : 7; }
	}

	/* This is necessary for TickRandom.*/
	@Override
	public boolean isRandomlyTicking(BlockState state) {
		return !state.getValue(PERSISTENT);
	}
	
	/* TickRandom 16 32 48 64 80 96 112 */
	@Override
	public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
		/** Delete this. **/
		boolean putByPlayer = state.getValue(PERSISTENT);
		boolean distance7 = (state.getValue(DISTANCE) == 7);
		boolean deleteFlag = !putByPlayer && distance7;
		
		if (deleteFlag) {
			dropResources(state, worldIn, pos);
			worldIn.removeBlock(pos, false); }
		
		/** Drop chestnut. **/
		boolean config = (Config_CM.INSTANCE.chestnutsFall.get() == true);
		boolean dropDone = state.getValue(DROP);
		boolean haveSpace = worldIn.isEmptyBlock(pos.below());
		
		AABB CHECK_80 = new AABB(pos.getX() - 80, pos.getY() - 80, pos.getZ() - 80, pos.getX() + 80, pos.getY() + 80, pos.getZ() + 80);
		List<Player> list80 = worldIn.getEntitiesOfClass(Player.class, CHECK_80); //too far
		
		AABB CHECK_48 = new AABB(pos.getX() - 48, pos.getY() - 48, pos.getZ() - 48, pos.getX() + 48, pos.getY() + 48, pos.getZ() + 48);
		List<Player> list48 = worldIn.getEntitiesOfClass(Player.class, CHECK_48); //too close
		
		boolean checkDrop = !putByPlayer && config && !dropDone && haveSpace && (list80.size() != 0) && (list48.size() == 0);
		
		if (checkDrop) { if (rand.nextInt(48) == 0) { this.dropKuri(state, worldIn, pos); } }
		
		if (!deleteFlag && !checkDrop) { }
	}
	
	public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
		worldIn.setBlock(pos, updateDistance(state, worldIn, pos), 3);
	}
	
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 1;
	}
	
	private void dropKuri(BlockState state, ServerLevel worldIn, BlockPos pos) {
		int x = (int) pos.getX();
		int y = (int) pos.getY();
		int z = (int) pos.getZ();
		FluidState fluidDown = worldIn.getFluidState(new BlockPos(x, y - 1, z));
		
		worldIn.setBlock(new BlockPos(x, y, z), this.defaultBlockState().setValue(DISTANCE, state.getValue(DISTANCE))
				.setValue(PERSISTENT, state.getValue(PERSISTENT))
				.setValue(DROP, Boolean.valueOf(true)), 3);
		worldIn.setBlock(new BlockPos(x, y - 1, z), Wood_Blocks.KURIIGA_FALL.get().defaultBlockState()
				.setValue(KuriIga_Fall.WATERLOGGED, Boolean.valueOf(fluidDown.getType() == Fluids.WATER)), 3);
	}
	
	/* Add Particle */
	@SuppressWarnings("deprecation")
	public static boolean isFree(BlockState state) {
		return state.isAir() || state.is(BlockTags.FIRE) || state.liquid() || state.canBeReplaced();
	}
	
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState state, Level worldIn, BlockPos pos, RandomSource rand) {
		super.animateTick(state, worldIn, pos, rand);

		if (rand.nextInt(400) == 0) {

			if (worldIn.isEmptyBlock(pos.below()) || isFree(worldIn.getBlockState(pos.below())) ) {

				double d0 = (double)((float)pos.getX() + rand.nextFloat());
				double d1 = (double)pos.getY() - 0.05D;
				double d2 = (double)((float)pos.getZ() + rand.nextFloat());

				worldIn.addParticle((ParticleOptions) ParticleTypes_CM.FALLKARE.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D); } }
		
		
		if (worldIn.isRainingAt(pos.above())) {
			 if (rand.nextInt(15) == 1) {
				 BlockPos downPos = pos.below();
				 BlockState downState = worldIn.getBlockState(downPos);
				 if (!downState.canOcclude() || !downState.isFaceSturdy(worldIn, downPos, Direction.UP)) {
					 double d0 = (double)pos.getX() + rand.nextDouble();
					 double d1 = (double)pos.getY() - 0.05D;
					 double d2 = (double)pos.getZ() + rand.nextDouble();
					 worldIn.addParticle(ParticleTypes.DRIPPING_WATER, d0, d1, d2, 0.0D, 0.0D, 0.0D);
				 }
			 }
		 }
	}
	
	/* drak 0.0F -> 1.0F light */
	@Override
	public float getShadeBrightness(BlockState state, BlockGetter world, BlockPos pos) {
		return 0.8F;
	}
	
	/* Flammable Block */
	@Override
	public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction direct) { return true; }

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction direct) { return 30; }

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction direct) { return 60; }
	
	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(DROP, DISTANCE, PERSISTENT);
	}
}
