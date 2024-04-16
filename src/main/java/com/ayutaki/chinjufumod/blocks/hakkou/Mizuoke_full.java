package com.ayutaki.chinjufumod.blocks.hakkou;

import com.ayutaki.chinjufumod.blocks.base.BaseStage2_FaceWater;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.color.Base_ItemHake;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BannerItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import net.minecraft.world.level.block.entity.BannerBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Mizuoke_full extends BaseStage2_FaceWater {

	/* Collision */
	protected static final VoxelShape BASE = Block.box(5.0D, 0.5D, 5.0D, 11.0D, 1.5D, 11.0D);
	protected static final VoxelShape BODY = Shapes.or(BASE, 
			Block.box(4.0D, 0.0D, 4.0D, 12.0D, 9.0D, 5.0D),
			Block.box(4.0D, 0.0D, 11.0D, 12.0D, 9.0D, 12.0D),
			Block.box(4.0D, 0.0D, 5.0D, 5.0D, 9.0D, 11.0D),
			Block.box(11.0D, 0.0D, 5.0D, 12.0D, 9.0D, 11.0D));
	
	protected static final VoxelShape AABB_SOUTH = Shapes.or(BODY, 
			Block.box(3.5D, 13.0D, 7.5D, 12.5D, 14.0D, 8.5D),
			Block.box(4.0D, 9.0D, 7.0D, 5.0D, 15.0D, 9.0D),
			Block.box(11.0D, 9.0D, 7.0D, 12.0D, 15.0D, 9.0D));
	protected static final VoxelShape AABB_WEST = Shapes.or(BODY, 
			Block.box(7.5D, 13.0D, 3.5D, 8.5D, 14.0D, 12.5D),
			Block.box(7.0D, 9.0D, 4.0D, 9.0D, 15.0D, 5.0D),
			Block.box(7.0D, 9.0D, 11.0D, 9.0D, 15.0D, 12.0D));
	protected static final VoxelShape AABB_NORTH = Shapes.or(BODY, 
			Block.box(3.5D, 13.0D, 7.5D, 12.5D, 14.0D, 8.5D),
			Block.box(4.0D, 9.0D, 7.0D, 5.0D, 15.0D, 9.0D),
			Block.box(11.0D, 9.0D, 7.0D, 12.0D, 15.0D, 9.0D));
	protected static final VoxelShape AABB_EAST = Shapes.or(BODY, 
			Block.box(7.5D, 13.0D, 3.5D, 8.5D, 14.0D, 12.5D),
			Block.box(7.0D, 9.0D, 4.0D, 9.0D, 15.0D, 5.0D),
			Block.box(7.0D, 9.0D, 11.0D, 9.0D, 15.0D, 12.0D));
	
	public Mizuoke_full(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action net.minecraft.core.cauldron.CauldronInteraction */
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		int i = state.getValue(STAGE_1_2);
		boolean mode = playerIn.getAbilities().instabuild;

		/** バケツ **/
		if (item == Items.BUCKET && !state.getValue(WATERLOGGED)) {
			
			if (!mode) { stack.shrink(1);
				if (stack.isEmpty()) { playerIn.getInventory().add(new ItemStack(Items.WATER_BUCKET)); }
				else if (!playerIn.getInventory().add(new ItemStack(Items.WATER_BUCKET))) {
					playerIn.drop(new ItemStack(Items.WATER_BUCKET), false); } }
			if (mode) { }

			CMEvents.soundBucketFill(worldIn, pos);

			if (i == 1) {
				worldIn.setBlock(pos, Hakkou_Blocks.MIZUOKE.get().defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(Mizuoke.STAGE_1_4, Integer.valueOf(1)), 3); }

			if (i != 1) {
				worldIn.setBlock(pos, Hakkou_Blocks.MIZUOKE.get().defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(Mizuoke.STAGE_1_4, Integer.valueOf(2)), 3); }

			return InteractionResult.SUCCESS;
		}

		if (item == Items_Teatime.MIZUOKE.get() && !state.getValue(WATERLOGGED)) {
			
			if (!mode) { stack.shrink(1);
				if (stack.isEmpty()) { playerIn.getInventory().add(new ItemStack(Items_Teatime.MIZUOKE_full.get())); }
				else if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.MIZUOKE_full.get()))) {
					playerIn.drop(new ItemStack(Items_Teatime.MIZUOKE_full.get()), false); } }
			if (mode) { }

			CMEvents.soundBucketFill(worldIn, pos);

			if (i == 1) {
				worldIn.setBlock(pos, Hakkou_Blocks.MIZUOKE.get().defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(Mizuoke.STAGE_1_4, Integer.valueOf(1)), 3); }

			if (i != 1) {
				worldIn.setBlock(pos, Hakkou_Blocks.MIZUOKE.get().defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(Mizuoke.STAGE_1_4, Integer.valueOf(2)), 3); }

			return InteractionResult.SUCCESS;
		}

		/** ガラス瓶 **/
		if (item == Items.GLASS_BOTTLE && !state.getValue(WATERLOGGED)) {

			if (!mode) {
				stack.shrink(1);
				ItemStack stack4 = PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER);
				if (stack.isEmpty()) { playerIn.setItemInHand(hand, stack4); }
				else if (!playerIn.getInventory().add(stack4)) { playerIn.drop(stack4, false); }
				else if (playerIn instanceof ServerPlayer) {
					((ServerPlayer)playerIn).inventoryMenu.sendAllDataToRemote(); } }
			if (mode) { }

			CMEvents.soundBottleFill(worldIn, pos);

			if (i == 1) {
				worldIn.setBlock(pos, Hakkou_Blocks.MIZUOKE.get().defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(Mizuoke.STAGE_1_4, Integer.valueOf(3)), 3); }

			if (i != 1) {
				worldIn.setBlock(pos, Hakkou_Blocks.MIZUOKE.get().defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(Mizuoke.STAGE_1_4, Integer.valueOf(4)), 3); }

			return InteractionResult.SUCCESS;
		}

		/** 計量カップ **/
		if (item == Items_Teatime.KEIRYO_CUP.get() && !state.getValue(WATERLOGGED)) {

			if (!mode) {
				stack.shrink(1);
				if (stack.isEmpty()) { playerIn.getInventory().add(new ItemStack(Items_Teatime.KEIRYO_CUP_full.get())); }
				else if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.KEIRYO_CUP_full.get()))) {
					playerIn.drop(new ItemStack(Items_Teatime.KEIRYO_CUP_full.get()), false); } }
			if (mode) { }

			CMEvents.soundBottleFill(worldIn, pos);

			if (i == 1) {
				worldIn.setBlock(pos, Hakkou_Blocks.MIZUOKE.get().defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(Mizuoke.STAGE_1_4, Integer.valueOf(3)), 3); }

			if (i != 1) {
				worldIn.setBlock(pos, Hakkou_Blocks.MIZUOKE.get().defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(Mizuoke.STAGE_1_4, Integer.valueOf(4)), 3); }

			return InteractionResult.SUCCESS;
		}
		
		/** 洗う **/
		else {

			if (item instanceof DyeableLeatherItem) {
				DyeableLeatherItem idyeablearmoritem = (DyeableLeatherItem)item;
				if (idyeablearmoritem.hasCustomColor(stack) && !worldIn.isClientSide) {
					idyeablearmoritem.clearColor(stack);

					CMEvents.soundWaterUse(worldIn, pos);

					if (i == 1) {
						worldIn.setBlock(pos, Hakkou_Blocks.MIZUOKE.get().defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(Mizuoke.STAGE_1_4, Integer.valueOf(3)), 3); }

					if (i != 1) {
						worldIn.setBlock(pos, Hakkou_Blocks.MIZUOKE.get().defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(Mizuoke.STAGE_1_4, Integer.valueOf(4)), 3); }

					playerIn.awardStat(Stats.CLEAN_ARMOR);
				}
				return InteractionResult.SUCCESS;
			} //鎧

			if (item instanceof BannerItem) {
				if (BannerBlockEntity.getPatternCount(stack) > 0 && !worldIn.isClientSide) {
					ItemStack stack2 = stack.copy();
					stack2.setCount(1);
					BannerBlockEntity.removeLastPattern(stack2);
					playerIn.awardStat(Stats.CLEAN_BANNER);
					
					if (!mode) { stack.shrink(1); }
					CMEvents.soundWaterUse(worldIn, pos);

					if (i == 1) {
						worldIn.setBlock(pos, Hakkou_Blocks.MIZUOKE.get().defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(Mizuoke.STAGE_1_4, Integer.valueOf(3)), 3); }

					if (i != 1) {
						worldIn.setBlock(pos, Hakkou_Blocks.MIZUOKE.get().defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(Mizuoke.STAGE_1_4, Integer.valueOf(4)), 3); }

					if (stack.isEmpty()) { playerIn.setItemInHand(hand, stack2); }
					else if (!playerIn.getInventory().add(stack2)) { playerIn.drop(stack2, false); }
					else if (playerIn instanceof ServerPlayer) {
						((ServerPlayer)playerIn).inventoryMenu.sendAllDataToRemote(); }
				}
				return InteractionResult.SUCCESS;
			} //旗

			if (item instanceof BlockItem) {
				Block block = ((BlockItem)item).getBlock();
				if (block instanceof ShulkerBoxBlock && !worldIn.isClientSide()) {
					ItemStack stack1 = new ItemStack(Blocks.SHULKER_BOX, 1);
					if (stack.hasTag()) { stack1.setTag(stack.getTag().copy()); }

					playerIn.setItemInHand(hand, stack1);
					CMEvents.soundWaterUse(worldIn, pos);

					if (i == 1) {
						worldIn.setBlock(pos, Hakkou_Blocks.MIZUOKE.get().defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(Mizuoke.STAGE_1_4, Integer.valueOf(3)), 3); }

					if (i != 1) {
						worldIn.setBlock(pos, Hakkou_Blocks.MIZUOKE.get().defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(Mizuoke.STAGE_1_4, Integer.valueOf(4)), 3); }

					playerIn.awardStat(Stats.CLEAN_SHULKER_BOX);
					return InteractionResult.SUCCESS;
				}
				else {
					return InteractionResult.CONSUME;
				}
			} //シェルカー

			if (item instanceof Base_ItemHake) {

				if (!mode) { stack.shrink(1); }
				CMEvents.soundWaterUse(worldIn, pos);

				if (i == 1) {
					worldIn.setBlock(pos, Hakkou_Blocks.MIZUOKE.get().defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(Mizuoke.STAGE_1_4, Integer.valueOf(3)), 3); }

				if (i != 1) {
					worldIn.setBlock(pos, Hakkou_Blocks.MIZUOKE.get().defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(Mizuoke.STAGE_1_4, Integer.valueOf(4)), 3); }

				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }

				return InteractionResult.SUCCESS;
			} //色筆

		}
		/** SUCCESS to not put anything on top. **/
		return InteractionResult.SUCCESS;
	}
	
	/* Update BlockState. */
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.getValue(WATERLOGGED)) {
			worldIn.scheduleTick(pos, Hakkou_Blocks.MIZUOKE_full.get(), 10); }
		
		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}
	
	/* TickRandom */
	@Override
	public void onPlace(BlockState state, Level worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		if ((Boolean)state.getValue(WATERLOGGED)) {
			worldIn.scheduleTick(pos, Hakkou_Blocks.MIZUOKE_full.get(), 10); }
	}
	
	@Override
	public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
		int i = state.getValue(STAGE_1_2);
		if (i == 1 && state.getValue(WATERLOGGED)) {
			worldIn.scheduleTick(pos, Hakkou_Blocks.MIZUOKE_full.get(), 10);
			CMEvents.soundBubble(worldIn, pos);
			worldIn.setBlock(pos, state.setValue(STAGE_1_2, Integer.valueOf(2)), 3); }
	}
	
	@Override
	public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
		int i = state.getValue(STAGE_1_2);

		if (i == 1 && !state.getValue(WATERLOGGED) && worldIn.isRainingAt(pos.above())) {
			if (rand.nextInt(1) == 0) { worldIn.setBlock(pos, state.setValue(STAGE_1_2, Integer.valueOf(2)), 3); }
		}
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		Direction direction = state.getValue(H_FACING);

		switch (direction) {
		case NORTH:
		default: return AABB_NORTH;
		case SOUTH: return AABB_SOUTH;
		case EAST: return AABB_EAST;
		case WEST: return AABB_WEST;
		} // switch
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.MIZUOKE_full.get());
	}
	
	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return true;
	}
}
