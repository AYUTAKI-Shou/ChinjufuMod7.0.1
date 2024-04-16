package com.ayutaki.chinjufumod.blocks.wood;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.Config_CM;
import com.ayutaki.chinjufumod.handler.ParticleTypes_CM;
import com.ayutaki.chinjufumod.registry.Wood_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.particles.IParticleData;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/* data\minecraft\tags\blocks\leaves.json と logs.json で消失を予防 */
@SuppressWarnings("deprecation")
public class WoodLeaf_Kuri extends Block implements net.minecraftforge.common.IShearable {

	public static final IntegerProperty DISTANCE = IntegerProperty.create("distance", 1, 7);
	public static final BooleanProperty PERSISTENT = BooleanProperty.create("persistent");
	public static final BooleanProperty DROP = BooleanProperty.create("drop");
	
	public WoodLeaf_Kuri(Block.Properties properties) {
		super(properties);
		
		/** Default state **/
		setDefaultState(this.stateContainer.getBaseState().with(DISTANCE, Integer.valueOf(7))
				.with(PERSISTENT, Boolean.valueOf(false))
				.with(DROP, Boolean.valueOf(false)));
	}

	/* Gives a value when placed. +180 .getOpposite() */
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return updateDistance(this.getDefaultState().with(PERSISTENT, Boolean.valueOf(true))
				.with(DROP, Boolean.valueOf(true)), context.getWorld(), context.getPos());
	}
	
	/* Update BlockState. */
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		int i = getDistance(facingState) + 1;
		if (i != 1 || stateIn.get(DISTANCE) != i) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, this, 1);
		}
		return stateIn;
	}

	private static BlockState updateDistance(BlockState state, IWorld worldIn, BlockPos pos) {
		int i = 7;

		try (BlockPos.PooledMutable mutable = BlockPos.PooledMutable.retain()) {
			for(Direction direction : Direction.values()) {
				mutable.setPos(pos).move(direction);
				i = Math.min(i, getDistance(worldIn.getBlockState(mutable)) + 1);
				
				if (i == 1) { break; }
			}
		}
		return state.with(DISTANCE, Integer.valueOf(i)).with(PERSISTENT, state.get(PERSISTENT)).with(DROP, state.get(DROP));
	}

	private static int getDistance(BlockState neighbor) {
		if (BlockTags.LOGS.contains(neighbor.getBlock())) { return 0; } 
		
		else { return neighbor.getBlock() instanceof WoodLeaf_Kuri ? neighbor.get(DISTANCE) : 7; }
	}
			
	/* This is necessary for TickRandom.*/
	public boolean ticksRandomly(BlockState state) {
		return !state.get(PERSISTENT);
	}
	
	/* TickRandom 16 32 48 64 80 96 112 */
	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		/** Delete this. **/
		boolean putByPlayer = state.get(PERSISTENT);
		boolean distance7 = (state.get(DISTANCE) == 7);
		boolean deleteFlag = !putByPlayer && distance7;
		
		if (deleteFlag) {
			spawnDrops(state, worldIn, pos);
			worldIn.removeBlock(pos, false); }
		
		/** Drop chestnut. **/
		boolean config = (Config_CM.getInstance().chestnutsFall() == true);
		boolean dropDone = state.get(DROP);
		boolean haveSpace = worldIn.isAirBlock(pos.down());
		
		AxisAlignedBB CHECK_80 = new AxisAlignedBB(pos.getX() - 80, pos.getY() - 80, pos.getZ() - 80, pos.getX() + 80, pos.getY() + 80, pos.getZ() + 80);
		List<PlayerEntity> list80 = worldIn.getEntitiesWithinAABB(PlayerEntity.class, CHECK_80); //too far
		
		AxisAlignedBB CHECK_48 = new AxisAlignedBB(pos.getX() - 48, pos.getY() - 48, pos.getZ() - 48, pos.getX() + 48, pos.getY() + 48, pos.getZ() + 48);
		List<PlayerEntity> list48 = worldIn.getEntitiesWithinAABB(PlayerEntity.class, CHECK_48); //too close
		
		boolean checkDrop = !putByPlayer && config && !dropDone && haveSpace && (list80.size() != 0) && (list48.size() == 0);
		
		if (checkDrop) { if (rand.nextInt(48) == 0) { this.dropKuri(state, worldIn, pos); } }
		
		if (!deleteFlag && !checkDrop) { }
	}
	
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		worldIn.setBlockState(pos, updateDistance(state, worldIn, pos), 3);
	}
	
	public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return 1;
	}
	
	private void dropKuri(BlockState state, World worldIn, BlockPos pos) {
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		IFluidState fluidDown = worldIn.getFluidState(new BlockPos(x, y - 1, z));
		
		worldIn.setBlockState(new BlockPos(x, y, z), this.getDefaultState().with(DISTANCE, state.get(DISTANCE))
				.with(PERSISTENT, state.get(PERSISTENT))
				.with(DROP, Boolean.valueOf(true)), 3);
		worldIn.setBlockState(new BlockPos(x, y - 1, z), Wood_Blocks.KURIIGA_FALL.getDefaultState()
				.with(KuriIga_Fall.WATERLOGGED, Boolean.valueOf(fluidDown.isTagged(FluidTags.WATER))), 3);
	}
	
	/* Add Particle */
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		super.animateTick(stateIn, worldIn, pos, rand);

		if (rand.nextInt(400) == 0) {
			if (worldIn.isAirBlock(pos.down())) {

				double d0 = (double)((float)pos.getX() + rand.nextFloat());
				double d1 = (double)pos.getY() - 0.05D;
				double d2 = (double)((float)pos.getZ() + rand.nextFloat());

				worldIn.addParticle((IParticleData) ParticleTypes_CM.FALLKARE, d0, d1, d2, 0.0D, 0.0D, 0.0D); }
		}
	}

	/* 周囲の光透過 影0.0F -> 1.0F透過*/
	@OnlyIn(Dist.CLIENT)
	public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return 0.5F;
	}

	/* Can't breathe. */
	@Override
	public boolean causesSuffocation(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	/* Block is a cube. */
	@Override
	public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return true;
	}

	/* Mobs spawn. */
	@Override
	public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type) {
		return type == EntityType.OCELOT || type == EntityType.PARROT;
	}

	/* Create Blockstate */
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(DROP, DISTANCE, PERSISTENT);
	}
}
