package com.ayutaki.chinjufumod.blocks.wood;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.Config_CM;
import com.ayutaki.chinjufumod.handler.ParticleTypes_CM;
import com.ayutaki.chinjufumod.registry.Wood_Blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.particles.IParticleData;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

/* data\minecraft\tags\blocks\leaves.json と logs.json で消失を予防 */
public class WoodLeaf_Kuri extends Block implements net.minecraftforge.common.IForgeShearable {

	public static final IntegerProperty DISTANCE = IntegerProperty.create("distance", 1, 7);
	public static final BooleanProperty PERSISTENT = BooleanProperty.create("persistent");
	public static final BooleanProperty DROP = BooleanProperty.create("drop");
	
	public WoodLeaf_Kuri(AbstractBlock.Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(DISTANCE, Integer.valueOf(7))
				.setValue(PERSISTENT, Boolean.valueOf(false))
				.setValue(DROP, Boolean.valueOf(false)));
	}

	/* Gives a value when placed. */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return updateDistance(this.defaultBlockState().setValue(PERSISTENT, Boolean.valueOf(true))
				.setValue(DROP, Boolean.valueOf(true)), context.getLevel(), context.getClickedPos());
	}
	
	/* Update BlockState. */
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		int i = getDistance(facingState) + 1;
		if (i != 1 || state.getValue(DISTANCE) != i) {
			worldIn.getBlockTicks().scheduleTick(pos, this, 1);
		}
		return state;
	}
	
	private static BlockState updateDistance(BlockState state, IWorld worldIn, BlockPos pos) {
		int i = 7;
		BlockPos.Mutable mutable = new BlockPos.Mutable();
		
		for(Direction direction : Direction.values()) {
			mutable.setWithOffset(pos, direction);
			i = Math.min(i, getDistance(worldIn.getBlockState(mutable)) + 1);
			
			if (i == 1) { break; }
		}
		return state.setValue(DISTANCE, Integer.valueOf(i)).setValue(PERSISTENT, state.getValue(PERSISTENT))
				.setValue(DROP, state.getValue(DROP));
	}
	
	private static int getDistance(BlockState neighbor) {
		if (BlockTags.LOGS.contains(neighbor.getBlock())) { return 0; } 
		
		else { return neighbor.getBlock() instanceof WoodLeaf_Kuri ? neighbor.getValue(DISTANCE) : 7; }
	}

	/* This is necessary for TickRandom.*/
	@Override
	public boolean isRandomlyTicking(BlockState state) {
		return !state.getValue(PERSISTENT);
	}
	
	/* TickRandom 16 32 48 64 80 96 112 */
	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		/** Delete this. **/
		boolean putByPlayer = state.getValue(PERSISTENT);
		boolean distance7 = (state.getValue(DISTANCE) == 7);
		boolean deleteFlag = !putByPlayer && distance7;
		
		if (deleteFlag) {
			dropResources(state, worldIn, pos);
			worldIn.removeBlock(pos, false); }
		
		/** Drop chestnut. **/
		boolean config = (Config_CM.getInstance().chestnutsFall() == true);
		boolean dropDone = state.getValue(DROP);
		boolean haveSpace = worldIn.isEmptyBlock(pos.below());
		
		AxisAlignedBB CHECK_80 = new AxisAlignedBB(pos.getX() - 80, pos.getY() - 80, pos.getZ() - 80, pos.getX() + 80, pos.getY() + 80, pos.getZ() + 80);
		List<PlayerEntity> list80 = worldIn.getEntitiesOfClass(PlayerEntity.class, CHECK_80); //too far
		
		AxisAlignedBB CHECK_48 = new AxisAlignedBB(pos.getX() - 48, pos.getY() - 48, pos.getZ() - 48, pos.getX() + 48, pos.getY() + 48, pos.getZ() + 48);
		List<PlayerEntity> list48 = worldIn.getEntitiesOfClass(PlayerEntity.class, CHECK_48); //too close
		
		boolean checkDrop = !putByPlayer && config && !dropDone && haveSpace && (list80.size() != 0) && (list48.size() == 0);
				
		if (checkDrop) { if (rand.nextInt(48) == 0) { this.dropKuri(state, worldIn, pos); } }
		
		if (!deleteFlag && !checkDrop) { }
	}
	
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		worldIn.setBlock(pos, updateDistance(state, worldIn, pos), 3);
	}
	
	public int getLightBlock(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return 1;
	}
	
	private void dropKuri(BlockState state, World worldIn, BlockPos pos) {
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		FluidState fluidDown = worldIn.getFluidState(new BlockPos(x, y - 1, z));
		
		worldIn.setBlock(new BlockPos(x, y, z), this.defaultBlockState().setValue(DISTANCE, state.getValue(DISTANCE))
				.setValue(PERSISTENT, state.getValue(PERSISTENT))
				.setValue(DROP, Boolean.valueOf(true)), 3);
		worldIn.setBlock(new BlockPos(x, y - 1, z), Wood_Blocks.KURIIGA_FALL.defaultBlockState()
				.setValue(KuriIga_Fall.WATERLOGGED, Boolean.valueOf(fluidDown.getType() == Fluids.WATER)), 3);
	}
	
	@SuppressWarnings("deprecation")
	public static boolean isFree(BlockState state) {
		Material material = state.getMaterial();
		return state.isAir() || state.is(BlockTags.FIRE) || material.isLiquid() || material.isReplaceable();
	}

	/* Add Particle */
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		super.animateTick(stateIn, worldIn, pos, rand);

		if (rand.nextInt(400) == 0) {

			if (worldIn.isEmptyBlock(pos.below()) || isFree(worldIn.getBlockState(pos.below())) ) {

				double d0 = (double)((float)pos.getX() + rand.nextFloat());
				double d1 = (double)pos.getY() - 0.05D;
				double d2 = (double)((float)pos.getZ() + rand.nextFloat());

				worldIn.addParticle((IParticleData) ParticleTypes_CM.FALLKARE, d0, d1, d2, 0.0D, 0.0D, 0.0D); } }
	}

	/* 周囲の光透過 影0.0F -> 1.0F透過*/
	@OnlyIn(Dist.CLIENT)
	public float getShadeBrightness(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return 0.5F;
	}

	/* Flammable Block */
	@Override
	public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face) { return true; }

	@Override
	public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) { return 30; }

	@Override
	public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) { return 60; }

	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(DROP, DISTANCE, PERSISTENT);
	}
	
	/* The best harvesting tool. */
	@Nullable
	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.HOE;
	}

	@Override
	public int getHarvestLevel(BlockState state) {
		return 0;
	}
}
