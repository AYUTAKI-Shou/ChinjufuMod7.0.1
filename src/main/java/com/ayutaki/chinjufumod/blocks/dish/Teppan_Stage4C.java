package com.ayutaki.chinjufumod.blocks.dish;

import java.util.Random;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Teppan_Stage4C extends BaseTeppan {

	/* Property */
	public static final IntegerProperty STAGE_1_4 = IntegerProperty.create("stage", 1, 4);
	/* Collision */
	private static final VoxelShape AABB_BOX = Block.box(2.5D, 0.0D, 2.5D, 13.5D, 1.0D, 13.5D);
	
	public Teppan_Stage4C(BlockBehaviour.Properties properties) {
		super(properties);
		/** Default state **/
		registerDefaultState(this.stateDefinition.any().setValue(H_FACING, Direction.NORTH)
				.setValue(STAGE_1_4, Integer.valueOf(1))
				.setValue(DOWN, Boolean.valueOf(false))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		int i = state.getValue(STAGE_1_4);
		/** 1=raw, 2=re, 3=soba, 4=sauce **/
		boolean yakiSoba = (this == Dish_Blocks.YAKISOBA_click.get()) || (this == Dish_Blocks.YAKISOBASHIO_click.get());
		
		if (i != 4) {
			if (stack.isEmpty()) {
				CMEvents.soundSnowPlace(worldIn, pos);
				worldIn.setBlock(pos, this.toNama().defaultBlockState()
						.setValue(H_FACING,state.getValue(H_FACING))
						.setValue(DOWN,state.getValue(DOWN))
						.setValue(WATERLOGGED,state.getValue(WATERLOGGED))
						.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		if (i == 4 && !yakiSoba) {
			if (stack.isEmpty()) {
				CMEvents.soundSnowPlace(worldIn, pos);
				worldIn.setBlock(pos, this.to5th().defaultBlockState()
						.setValue(H_FACING,state.getValue(H_FACING))
						.setValue(DOWN,state.getValue(DOWN))
						.setValue(WATERLOGGED,state.getValue(WATERLOGGED))
						.setValue(Teppan_5th.STAGE_1_3, Integer.valueOf(1)), 3); }
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		} // i == 4
		
		/** SUCCESS to not put anything on top. **/
		return InteractionResult.SUCCESS;
	}

	private Block toNama() {
		if (this == Dish_Blocks.OKONOMISOBA_click.get()) { return Dish_Blocks.OKONOMISOBA_nama.get(); }
		if (this == Dish_Blocks.OKONOMISOBAS_click.get()) { return Dish_Blocks.OKONOMISOBAS_nama.get(); }
		if (this == Dish_Blocks.OKONOMISOBAC_click.get()) { return Dish_Blocks.OKONOMISOBAC_nama.get(); }
		if (this == Dish_Blocks.YAKISOBA_click.get()) { return Dish_Blocks.YAKISOBA_nama.get(); }
		if (this == Dish_Blocks.YAKISOBASHIO_click.get()) { return Dish_Blocks.YAKISOBASHIO_nama.get(); }
		return null;
	}
	
	private Block to5th() {
		if (this == Dish_Blocks.OKONOMISOBA_click.get()) { return Dish_Blocks.OKONOMISOBA_5.get(); }
		if (this == Dish_Blocks.OKONOMISOBAS_click.get()) { return Dish_Blocks.OKONOMISOBAS_5.get(); }
		if (this == Dish_Blocks.OKONOMISOBAC_click.get()) { return Dish_Blocks.OKONOMISOBAC_5.get(); }
		return null;
	}

	/* Update BlockState. */
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.getValue(WATERLOGGED)) {
			worldIn.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }

		if (inWater(state, worldIn, pos)) { worldIn.scheduleTick(pos, this, 60); }

		boolean down = connectTeppan(worldIn, pos, Direction.DOWN);
		return state.setValue(DOWN, down);
	}
	
	/* TickRandom */
	@Override
	public void onPlace(BlockState state, Level worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		if (inWater(state, worldIn, pos)) { worldIn.scheduleTick(pos, this, 60); }
	}

	@Override
	public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, Random rand) {

		if (inWater(state, worldIn, pos)) {
			worldIn.scheduleTick(pos, this, 60);
			CMEvents.soundSnowBreak(worldIn, pos);
			worldIn.setBlock(pos, Dish_Blocks.OKONOMIC_nama.get().defaultBlockState()
					.setValue(H_FACING,state.getValue(H_FACING))
					.setValue(DOWN,state.getValue(DOWN))
					.setValue(WATERLOGGED,state.getValue(WATERLOGGED))
					.setValue(STAGE_1_4, Integer.valueOf(4)), 3);
			this.dropRottenfood(worldIn, pos); }
		
		else { }
	}
	
	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(DOWN, H_FACING, STAGE_1_4, WATERLOGGED);
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return AABB_BOX;
	}
	
	/* Play Sound・Particle */
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState state, Level worldIn, BlockPos pos, Random rand) {

		double d0 = (double)pos.getX() + 0.5D;
		double d1 = (double)pos.getY() + 0.8D;
		double d2 = (double)pos.getZ() + 0.5D;
		double d4 = rand.nextDouble() * 0.6D - 0.3D;
		double d6 = rand.nextDouble() * 6.0D / 16.0D;

		if (this.isCooking(worldIn, pos)) {
			if (rand.nextDouble() < 0.1D) {
				worldIn.playLocalSound(d0, d1, d2, SoundEvents_CM.JUU.get(), SoundSource.BLOCKS, 0.2F, 1.0F, false); }

			if (rand.nextDouble() < 0.25D) {
				worldIn.addParticle(ParticleTypes.POOF, d0 + d4, d1 + d6 - 0.3D, d2 + d4, 0.0D, 0.0D, 0.0D); }
		}
		
		if (!this.isCooking(worldIn, pos)) { }
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return this.takeStack();
	}
	
	private ItemStack takeStack() {
		if (this == Dish_Blocks.OKONOMISOBA_click.get()) { return new ItemStack(Items_Teatime.OKONOMISOBA_nama.get(), 1); }
		if (this == Dish_Blocks.OKONOMISOBAS_click.get()) { return new ItemStack(Items_Teatime.OKONOMISOBAS_nama.get(), 1); }
		if (this == Dish_Blocks.OKONOMISOBAC_click.get()) { return new ItemStack(Items_Teatime.OKONOMISOBAC_nama.get(), 1); }
		if (this == Dish_Blocks.YAKISOBA_click.get()) { return new ItemStack(Items_Teatime.YAKISOBA_nama.get(), 1); }
		if (this == Dish_Blocks.YAKISOBASHIO_click.get()) { return new ItemStack(Items_Teatime.YAKISOBASHIO_nama.get(), 1); }
		return null;
	}
}
