package com.ayutaki.chinjufumod.blocks.furnace;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.blocks.dish.BaseIrori_Sakana;
import com.ayutaki.chinjufumod.blocks.dish.BaseNabe;
import com.ayutaki.chinjufumod.blocks.dish.BaseNabe_2Cook;
import com.ayutaki.chinjufumod.blocks.dish.BaseNabe_nama;
import com.ayutaki.chinjufumod.blocks.dish.Kettle_full;
import com.ayutaki.chinjufumod.blocks.dish.Nabe_kara;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
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
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Irori extends CM_WaterLogged {

	protected static final int FIRE_OFF = 120;
	/* Property */
	public static final IntegerProperty STAGE_0_10 = IntegerProperty.create("stage", 0, 10);
	public static final BooleanProperty LIT = BooleanProperty.create("lit");
	public static final BooleanProperty DONABE = BooleanProperty.create("donabe");

	/* Collision */
	protected static final VoxelShape AABB_BOX = Shapes.or(Block.box(0.0D, 11.0D, 0.0D, 16.0D, 15.0D, 0.5D),
			Block.box(0.0D, 11.0D, 15.5D, 16.0D, 15.0D, 16.0D),
			Block.box(0.0D, 11.0D, 0.0D, 0.5D, 15.0D, 16.0D),
			Block.box(15.5D, 11.0D, 0.0D, 16.0D, 15.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 11.0D, 16.0D));

	public Irori(BlockBehaviour.Properties properties) {
		super(properties);
		/** Default state **/
		registerDefaultState(this.stateDefinition.any().setValue(STAGE_0_10, Integer.valueOf(0))
				.setValue(WATERLOGGED, Boolean.valueOf(false))
				.setValue(LIT, Boolean.valueOf(false))
				.setValue(DONABE, Boolean.valueOf(false)));
	}
	
	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		int i = state.getValue(STAGE_0_10);
		boolean mode = playerIn.getAbilities().instabuild;

		if (!state.getValue(WATERLOGGED)) {

			if (item == Items.CHARCOAL) {
				if (i == 0) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlock(pos, state.setValue(STAGE_0_10, Integer.valueOf(1)), 3); }
				
				if (i > 2 && i < 10) {
					if (!mode) { 
						stack.shrink(1);
						Containers.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.BONE_MEAL)); }
					if (mode) { }
					
					CMEvents.soundSnowPlace(worldIn, pos);
					worldIn.setBlock(pos, state.setValue(STAGE_0_10, Integer.valueOf(2)).setValue(LIT, Boolean.valueOf(true)), 3); }
				
				if (i == 10) {
					if (!mode) { 
						stack.shrink(1);
						Containers.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.BONE_MEAL)); }
					if (mode) { }
					
					CMEvents.soundSnowPlace(worldIn, pos);
					worldIn.setBlock(pos, state.setValue(STAGE_0_10, Integer.valueOf(1)), 3); } }


			if (item == Items.FLINT_AND_STEEL) {
				if (i == 1) {
					stack.hurtAndBreak(1, playerIn, user -> { user.broadcastBreakEvent(hand); } );
					CMEvents.soundFlint(worldIn, pos);
					worldIn.setBlock(pos, state.setValue(STAGE_0_10, Integer.valueOf(2)).setValue(LIT, Boolean.valueOf(true)), 3); } }


			if (item == Items_Teatime.MATCH.get()) {
				if (i == 1) {
					CMEvents.Consume1Item_Flint(worldIn, pos, playerIn, hand);
					worldIn.setBlock(pos, state.setValue(STAGE_0_10, Integer.valueOf(2)).setValue(LIT, Boolean.valueOf(true)), 3); } }
			
			/** 魚の串焼き **/
			boolean hitNorth = (hit.getLocation().x - (double)pos.getX() > 0.3D) && (hit.getLocation().x - (double)pos.getX() < 0.7D) && (hit.getLocation().z - (double)pos.getZ() < 0.3D);
			boolean hitSouth = (hit.getLocation().x - (double)pos.getX() > 0.3D) && (hit.getLocation().x - (double)pos.getX() < 0.7D) && (hit.getLocation().z - (double)pos.getZ() > 0.7D);
			boolean hitEast = (hit.getLocation().x - (double)pos.getX() > 0.7D) && (hit.getLocation().z - (double)pos.getZ() > 0.3D) && (hit.getLocation().z - (double)pos.getZ() < 0.7D);
			boolean hitWest = (hit.getLocation().x - (double)pos.getX() < 0.3D) && (hit.getLocation().z - (double)pos.getZ() > 0.3D) && (hit.getLocation().z - (double)pos.getZ() < 0.7D);

			if (item == Items_Teatime.KUSHI_SAKANA.get() && worldIn.getBlockState(pos.above()).canBeReplaced()) {

				if (hitNorth) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlock(pos.above(), Dish_Blocks.IRORISAKANA_E2.get().defaultBlockState()
						.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(10)), 3); }

				if (hitSouth) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlock(pos.above(), Dish_Blocks.IRORISAKANA_E1.get().defaultBlockState()
						.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(2)), 3); }

				if (hitEast) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);	
					worldIn.setBlock(pos.above(), Dish_Blocks.IRORISAKANA_E1.get().defaultBlockState()
						.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(8)), 3); }

				if (hitWest) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);	
					worldIn.setBlock(pos.above(), Dish_Blocks.IRORISAKANA_E1.get().defaultBlockState()
						.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(0)), 3); } }


			/** No usable items. **/
			if (item != Items.CHARCOAL && item != Items_Teatime.KUSHI_SAKANA.get() && item != Items_Teatime.MATCH.get() && item != Items.FLINT_AND_STEEL) {
				if (stack.isEmpty()) {
					if (i == 10) {
						CMEvents.soundTake_Pick(worldIn, pos);
						playerIn.getInventory().add(new ItemStack(Items.BONE_MEAL));
						worldIn.setBlock(pos, state.setValue(STAGE_0_10, Integer.valueOf(0)), 3); }
					
					if (i != 10) { CMEvents.textNotHave(worldIn, pos, playerIn); } }
				
				if (!stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			}
		} // It is not waterlogged.

		/** Waterlogged **/
		if (state.getValue(WATERLOGGED)) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); }
		
		return InteractionResult.SUCCESS;
	}
	
	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		Level worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);

		return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER));
	}
	
	/* Connect the blocks. */
	private boolean connectNabe(BlockGetter worldIn, BlockPos pos, Direction direct) {
		BlockPos newPos = pos.relative(direct);
		BlockState state = worldIn.getBlockState(newPos);
		Block block = state.getBlock();

		return (block instanceof BaseNabe || block instanceof BaseNabe_2Cook || block instanceof BaseNabe_nama ||
				block instanceof Nabe_kara || block instanceof Kettle_full);
	}

	/* Distinguish LOST from WATERLOGGED. */
	protected boolean inWater(BlockState state, BlockGetter worldIn, BlockPos pos) {
		if (state.getValue(WATERLOGGED)) { return true; }
		return false;
	}
	
	/* Update BlockState. */
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.getValue(WATERLOGGED)) {
			worldIn.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }

		if (inWater(state, worldIn, pos)) { worldIn.scheduleTick(pos, Kitchen_Blocks.IRORI.get(), FIRE_OFF); }

		boolean donabe = connectNabe(worldIn, pos, Direction.UP);
		return state.setValue(DONABE, donabe);
	}
	
	/* TickRandom */
	@Override
	public void onPlace(BlockState state, Level worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		if (inWater(state, worldIn, pos)) { worldIn.scheduleTick(pos, Kitchen_Blocks.IRORI.get(), FIRE_OFF); }
	}
	
	@Override
	public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
		int i = state.getValue(STAGE_0_10);

		if (inWater(state, worldIn, pos)) {
			/** Nothing on the top. **/
			if (i == 0) { }
			
			if (i != 0) { 
				worldIn.scheduleTick(pos, Kitchen_Blocks.IRORI.get(), FIRE_OFF);
				worldIn.setBlock(pos, state.setValue(STAGE_0_10, Integer.valueOf(0)).setValue(LIT, Boolean.valueOf(false)), 3);
				
				/** Charcoal on the top. **/
				if (i == 1) {
					CMEvents.soundSnowPlace(worldIn, pos);
					this.dropCharcoal(worldIn, pos); }
				
				/** Charcoal is burning. **/
				if (i >= 2 && i <= 9) {
					CMEvents.soundFireExting(worldIn, pos);
					this.dropBonemeal(worldIn, pos); }
				
				/** Ash on the top. **/
				if (i == 10) {
					CMEvents.soundSnowPlace(worldIn, pos);
					this.dropBonemeal(worldIn, pos); }
			}
		}

		if (!inWater(state, worldIn, pos)) { }
	}
	
	@Override
	public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
		int i = state.getValue(STAGE_0_10);

		/** Charcoal is burning. **/
		if (i >= 2 && i <= 9) {

			if (!inWater(state, worldIn, pos)) {
				if (rand.nextInt(1) == 0) {
					if (i <= 6) { worldIn.setBlock(pos, state.setValue(STAGE_0_10, Integer.valueOf(i + 1)).setValue(LIT, Boolean.valueOf(true)), 3); }

					if (i >= 7) { worldIn.setBlock(pos, state.setValue(STAGE_0_10, Integer.valueOf(i + 1)).setValue(LIT, Boolean.valueOf(false)), 3); }
				}
			}
		}

		else { }
	}
	
	protected void dropBonemeal(ServerLevel worldIn, BlockPos pos) {
		ItemStack stack = new ItemStack(Items.BONE_MEAL);
		Containers.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
	}
	
	protected void dropCharcoal(ServerLevel worldIn, BlockPos pos) {
		ItemStack stack = new ItemStack(Items.CHARCOAL);
		Containers.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
	}
	
	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(DONABE, LIT, STAGE_0_10, WATERLOGGED);
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return AABB_BOX;
	}

	/* If you walk on it while it's burning, you'll take damage. */
	public void stepOn(Level worldIn, BlockPos pos, BlockState state, Entity entityIn) {
		int i = state.getValue(STAGE_0_10);

		if (i > 1 && i < 10) {
			if (!entityIn.fireImmune() && entityIn instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)entityIn)) {
				entityIn.hurt(worldIn.damageSources().hotFloor(), 1.0F); }
			super.stepOn(worldIn, pos, state, entityIn); }
	}

	/* Play Sound・Particle */
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState state, Level worldIn, BlockPos pos, RandomSource rand) {
		double d0 = (double)pos.getX() + 0.5D;
		double d1 = (double)pos.getY() + 0.8D;
		double d2 = (double)pos.getZ() + 0.5D;
		double d4 = rand.nextDouble() * 0.6D - 0.3D;
		double d6 = rand.nextDouble() * 6.0D / 16.0D;

		int i = state.getValue(STAGE_0_10);
		if (i != 0 && i != 1 && i != 10) {
				if (rand.nextDouble() < 0.1D) {
					worldIn.playLocalSound(d0, d1, d2, SoundEvents.FURNACE_FIRE_CRACKLE, SoundSource.BLOCKS, 1.0F, 1.0F, false); }

				if (rand.nextDouble() < 0.25D) {
					/** which, position x y z, speed x y z **/
					worldIn.addParticle(ParticleTypes.SMOKE, d0 + d4, d1 + d6, d2 + d4, 0.0D, 0.0D, 0.0D); }
		}
	}
	
	/* ToolTip */
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.block_irori").withStyle(ChatFormatting.GRAY));
	}
}
