package com.ayutaki.chinjufumod.blocks.crop;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Chanoki extends CM_WaterLogged {

	/* Property */
	public static final IntegerProperty STAGE_0_4 = IntegerProperty.create("stage", 0, 4);
	
	/* Collision */
	protected static final VoxelShape AABB_BASE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 0.1D, 14.0D);
	
	protected static final VoxelShape AABB_0 = Shapes.or(AABB_BASE, Block.box(7.0D, 0.1D, 7.0D, 9.0D, 12.0D, 9.0D));
	protected static final VoxelShape AABB_1 = Shapes.or(AABB_BASE, Block.box(2.0D, 4.0D, 2.0D, 14.0D, 14.0D, 14.0D),
			Block.box(7.0D, 0.1D, 7.0D, 9.0D, 4.0D, 9.0D));
	protected static final VoxelShape AABB_2 = Shapes.or(AABB_BASE, Block.box(1.0D, 4.0D, 1.0D, 15.0D, 15.0D, 15.0D),
			Block.box(7.0D, 0.1D, 7.0D, 9.0D, 4.0D, 9.0D));
	protected static final VoxelShape AABB_3 = Shapes.or(AABB_BASE, Block.box(0.5D, 3.5D, 0.5D, 15.5D, 15.5D, 15.5D),
			Block.box(7.0D, 0.1D, 7.0D, 9.0D, 3.5D, 9.0D));
	protected static final VoxelShape AABB_4 = Shapes.or(AABB_BASE, Block.box(0.0D, 3.5D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.box(7.0D, 0.1D, 7.0D, 9.0D, 3.5D, 9.0D));

	public Chanoki(BlockBehaviour.Properties properties) {
		super(properties);
		registerDefaultState(this.stateDefinition.any().setValue(STAGE_0_4, Integer.valueOf(0))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}
	
	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		int i = state.getValue(STAGE_0_4);

		/** Too early to collect **/
		if (i != 4) {
			
			if (item == Items.BONE_MEAL) {
				CMEvents.Use_BoneMeal(worldIn, pos, playerIn, hand);
	
				for(int n = 0; n < 15; ++n) {
					double d0 = worldIn.random.nextGaussian() * 0.02D;
					double d1 = worldIn.random.nextGaussian() * 0.02D;
					double d2 = worldIn.random.nextGaussian() * 0.02D;
					worldIn.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + worldIn.random.nextFloat(), pos.getY() +worldIn.random.nextFloat(), pos.getZ() + worldIn.random.nextFloat(), d0, d1, d2); }
				
				if (i < 3) { worldIn.setBlock(pos, state.setValue(STAGE_0_4, Integer.valueOf(i + 2)), 3); }
				if (i == 3) { worldIn.setBlock(pos, state.setValue(STAGE_0_4, Integer.valueOf(i + 1)), 3); }
			}
		
			if (item != Items.BONE_MEAL) {
				if (!stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (stack.isEmpty()) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }	
			}
		}
		
		/** Can harvest **/
		if (i == 4) {

			if (stack.isEmpty()) {
				CMEvents.soundTake_Pick(worldIn, pos);
				playerIn.getInventory().add(new ItemStack(Items_Teatime.CHABA.get(), 4));
				
				worldIn.setBlock(pos, state.setValue(STAGE_0_4, Integer.valueOf(i - 1)), 3); }

			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
				
		/** SUCCESS to not put anything on top. **/
		return InteractionResult.SUCCESS;
	}
	
	/* Limit the place. */
	@SuppressWarnings("deprecation")
	protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return (state.is(BlockTags.DIRT) && state.isSolid() && !state.is(BlockTags.ANIMALS_SPAWNABLE_ON));
	}
	
	@Override
	public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
		BlockPos downPos = pos.below();
		return this.mayPlaceOn(worldIn.getBlockState(downPos), worldIn, downPos);
	}
	
	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		Level worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);

		/** pos.up() = Replaceable block. **/
		if (pos.getY() < worldIn.getMaxBuildHeight() - 1 && worldIn.getBlockState(pos.above()).canBeReplaced(context)) {
			return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)); }

		else { return null; }
	}
	
	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos pos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			worldIn.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }
		
		return (facing == Direction.DOWN && !state.canSurvive(worldIn, pos)) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}
	
	/* TickRandom. Slow growth rate. rand.nextInt(12) == 0 */
	@SuppressWarnings("deprecation")
	public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {

		int i = state.getValue(STAGE_0_4);

		if (!worldIn.isAreaLoaded(pos, 2)) { return; }

		if (i < 4 && worldIn.getRawBrightness(pos, 0) >= 9 && state.getValue(WATERLOGGED) == false && rand.nextInt(12) == 0) {
			worldIn.setBlock(pos, state.setValue(STAGE_0_4, Integer.valueOf(i + 1)), 2);
		}

		else { }
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		int i = state.getValue(STAGE_0_4);
		
		switch (i) {
		case 0 :
		default:
			return AABB_0;
		case 1:
			return AABB_1;
		case 2:
			return AABB_2;
		case 3:
			return AABB_3;
		case 4:
			return AABB_4;
		} // switch
	}
	
	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(STAGE_0_4, WATERLOGGED);
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.CHANOKI.get());
	}

	/* ToolTip */
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.block_wood_chanoki_nae").withStyle(ChatFormatting.GRAY));
	}
}
