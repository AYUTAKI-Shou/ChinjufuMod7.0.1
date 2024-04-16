package com.ayutaki.chinjufumod.blocks.dish;

import java.util.Random;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Teppan_Stage4C extends BaseTeppan {

	/* Property */
	public static final IntegerProperty STAGE_1_4 = IntegerProperty.create("stage", 1, 4);
	/* Collision */
	private static final VoxelShape AABB_BOX = Block.makeCuboidShape(2.5D, 0.0D, 2.5D, 13.5D, 1.0D, 13.5D);
	
	public Teppan_Stage4C(Block.Properties properties) {
		super(properties);
		/** Default state **/
		setDefaultState(this.stateContainer.getBaseState().with(H_FACING, Direction.NORTH)
				.with(STAGE_1_4, Integer.valueOf(1))
				.with(DOWN, Boolean.valueOf(false))
				.with(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getHeldItem(hand);
		int i = state.get(STAGE_1_4);
		/** 1=raw, 2=re, 3=soba, 4=sauce **/
		boolean yakiSoba = (this == Dish_Blocks.YAKISOBA_click) || (this == Dish_Blocks.YAKISOBASHIO_click);
	
		if (i != 4) {
			if (stack.isEmpty()) {
				CMEvents.soundSnowPlace(worldIn, pos);
				worldIn.setBlockState(pos, this.toNama().getDefaultState()
						.with(H_FACING,state.get(H_FACING))
						.with(DOWN,state.get(DOWN))
						.with(WATERLOGGED,state.get(WATERLOGGED))
						.with(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		if (i == 4 && !yakiSoba) {
			if (stack.isEmpty()) {
				CMEvents.soundSnowPlace(worldIn, pos);
				worldIn.setBlockState(pos, this.to5th().getDefaultState()
						.with(H_FACING,state.get(H_FACING))
						.with(DOWN,state.get(DOWN))
						.with(WATERLOGGED,state.get(WATERLOGGED))
						.with(Teppan_5th.STAGE_1_3, Integer.valueOf(1)), 3); }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		} // i == 4
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	private Block toNama() {
		if (this == Dish_Blocks.OKONOMISOBA_click) { return Dish_Blocks.OKONOMISOBA_nama; }
		if (this == Dish_Blocks.OKONOMISOBAS_click) { return Dish_Blocks.OKONOMISOBAS_nama; }
		if (this == Dish_Blocks.OKONOMISOBAC_click) { return Dish_Blocks.OKONOMISOBAC_nama; }
		if (this == Dish_Blocks.YAKISOBA_click) { return Dish_Blocks.YAKISOBA_nama; }
		if (this == Dish_Blocks.YAKISOBASHIO_click) { return Dish_Blocks.YAKISOBASHIO_nama; }
		return null;
	}
	
	private Block to5th() {
		if (this == Dish_Blocks.OKONOMISOBA_click) { return Dish_Blocks.OKONOMISOBA_5; }
		if (this == Dish_Blocks.OKONOMISOBAS_click) { return Dish_Blocks.OKONOMISOBAS_5; }
		if (this == Dish_Blocks.OKONOMISOBAC_click) { return Dish_Blocks.OKONOMISOBAC_5; }
		return null;
	}
	
	/* Update BlockState. */
	@Override
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {

		if ((Boolean)state.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn)); }

		if (inWater(state, worldIn, pos)) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, this, 60); }

		boolean down = connectTeppan(worldIn, pos, Direction.DOWN);
		return state.with(DOWN, down);
	}

	/* TickRandom */
	@Override
	public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		if (inWater(state, worldIn, pos)) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, this, 60); }
	}

	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		
		if (inWater(state, worldIn, pos)) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, this, 60);
			CMEvents.soundSnowBreak(worldIn, pos);
			worldIn.setBlockState(pos, Dish_Blocks.OKONOMIC_nama.getDefaultState()
					.with(H_FACING,state.get(H_FACING))
					.with(DOWN,state.get(DOWN))
					.with(WATERLOGGED,state.get(WATERLOGGED))
					.with(STAGE_1_4, Integer.valueOf(4)), 3);
			this.dropRottenfood(worldIn, pos); }
		
		else { }
	}

	/* Create Blockstate */
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(DOWN, H_FACING, STAGE_1_4, WATERLOGGED);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return AABB_BOX;
	}
	
	/* Play Sound and Particle */
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState state, World worldIn, BlockPos pos, Random rand) {

		double d0 = (double)pos.getX() + 0.5D;
		double d1 = (double)pos.getY() + 0.8D;
		double d2 = (double)pos.getZ() + 0.5D;
		double d4 = rand.nextDouble() * 0.6D - 0.3D;
		double d6 = rand.nextDouble() * 6.0D / 16.0D;

		if (this.isCooking(worldIn, pos)) {
			if (rand.nextDouble() < 0.1D) {
				worldIn.playSound(d0, d1, d2, SoundEvents_CM.JUU, SoundCategory.BLOCKS, 0.2F, 1.0F, false); }
			
			if (rand.nextDouble() < 0.25D) {
				worldIn.addParticle(ParticleTypes.POOF, d0 + d4, d1 + d6 - 0.3D, d2 + d4, 0.0D, 0.0D, 0.0D); }
		}
		
		if (!this.isCooking(worldIn, pos)) { }
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return this.takeStack();
	}
	
	private ItemStack takeStack() {
		if (this == Dish_Blocks.OKONOMISOBA_click) { return new ItemStack(Items_Teatime.OKONOMISOBA_nama, 1); }
		if (this == Dish_Blocks.OKONOMISOBAS_click) { return new ItemStack(Items_Teatime.OKONOMISOBAS_nama, 1); }
		if (this == Dish_Blocks.OKONOMISOBAC_click) { return new ItemStack(Items_Teatime.OKONOMISOBAC_nama, 1); }
		if (this == Dish_Blocks.YAKISOBA_click) { return new ItemStack(Items_Teatime.YAKISOBA_nama, 1); }
		if (this == Dish_Blocks.YAKISOBASHIO_click) { return new ItemStack(Items_Teatime.YAKISOBASHIO_nama, 1); }
		return null;
	}
}
