package com.ayutaki.chinjufumod.blocks.hakkou;

import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage4_FaceWater;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.color.Base_ItemHake;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BannerItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.IDyeableArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.BannerTileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

public class Mizuoke extends BaseStage4_FaceWater {

	/* Collision */
	protected static final VoxelShape BASE = Block.makeCuboidShape(5.0D, 0.5D, 5.0D, 11.0D, 1.5D, 11.0D);
	protected static final VoxelShape BODY = VoxelShapes.or(BASE, 
			Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 9.0D, 5.0D),
			Block.makeCuboidShape(4.0D, 0.0D, 11.0D, 12.0D, 9.0D, 12.0D),
			Block.makeCuboidShape(4.0D, 0.0D, 5.0D, 5.0D, 9.0D, 11.0D),
			Block.makeCuboidShape(11.0D, 0.0D, 5.0D, 12.0D, 9.0D, 11.0D));
	
	protected static final VoxelShape AABB_SOUTH = VoxelShapes.or(BODY, 
			Block.makeCuboidShape(3.5D, 13.0D, 7.5D, 12.5D, 14.0D, 8.5D),
			Block.makeCuboidShape(4.0D, 9.0D, 7.0D, 5.0D, 15.0D, 9.0D),
			Block.makeCuboidShape(11.0D, 9.0D, 7.0D, 12.0D, 15.0D, 9.0D));
	protected static final VoxelShape AABB_WEST = VoxelShapes.or(BODY, 
			Block.makeCuboidShape(7.5D, 13.0D, 3.5D, 8.5D, 14.0D, 12.5D),
			Block.makeCuboidShape(7.0D, 9.0D, 4.0D, 9.0D, 15.0D, 5.0D),
			Block.makeCuboidShape(7.0D, 9.0D, 11.0D, 9.0D, 15.0D, 12.0D));
	protected static final VoxelShape AABB_NORTH = VoxelShapes.or(BODY, 
			Block.makeCuboidShape(3.5D, 13.0D, 7.5D, 12.5D, 14.0D, 8.5D),
			Block.makeCuboidShape(4.0D, 9.0D, 7.0D, 5.0D, 15.0D, 9.0D),
			Block.makeCuboidShape(11.0D, 9.0D, 7.0D, 12.0D, 15.0D, 9.0D));
	protected static final VoxelShape AABB_EAST = VoxelShapes.or(BODY, 
			Block.makeCuboidShape(7.5D, 13.0D, 3.5D, 8.5D, 14.0D, 12.5D),
			Block.makeCuboidShape(7.0D, 9.0D, 4.0D, 9.0D, 15.0D, 5.0D),
			Block.makeCuboidShape(7.0D, 9.0D, 11.0D, 9.0D, 15.0D, 12.0D));

	/* Property 空=1, 2=1.7, 3=3.4, 4=5.1, 水入り5=6.8, 水入り6=8.5 */
	public Mizuoke(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action Cauldron */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		int i = state.get(STAGE_1_4);
		boolean mode = playerIn.abilities.isCreativeMode;

		/** バケツ **/
		if (item == Items.WATER_BUCKET && !state.get(WATERLOGGED)) {

			CMEvents.WaterBucket_Empty(worldIn, pos, playerIn, hand);
			if (i == 1) {
				worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE_full.getDefaultState()
						.with(H_FACING, state.get(H_FACING))
						.with(Mizuoke_full.STAGE_1_2, Integer.valueOf(1))); }

			if (i != 1) {
				worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE_full.getDefaultState()
						.with(H_FACING, state.get(H_FACING))
						.with(Mizuoke_full.STAGE_1_2, Integer.valueOf(2))); }

			return ActionResultType.SUCCESS;
		}

		if (item == Items_Teatime.MIZUOKE_full && !state.get(WATERLOGGED)) {

			CMEvents.MIZUOKEfull_Empty(worldIn, pos, playerIn, hand);
			if (i == 1) {
				worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE_full.getDefaultState()
						.with(H_FACING, state.get(H_FACING))
						.with(Mizuoke_full.STAGE_1_2, Integer.valueOf(1))); }

			if (i != 1) {
				worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE_full.getDefaultState()
						.with(H_FACING, state.get(H_FACING))
						.with(Mizuoke_full.STAGE_1_2, Integer.valueOf(2))); }
			return ActionResultType.SUCCESS;
		}

		/** ガラス瓶 **/
		if (i > 2 && item == Items.GLASS_BOTTLE && !state.get(WATERLOGGED)) {

			if (!mode) {
				stack.shrink(1);

				ItemStack stack4 = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.WATER);
				if (stack.isEmpty()) { playerIn.setHeldItem(hand, stack4); }
				else if (!playerIn.inventory.addItemStackToInventory(stack4)) { playerIn.dropItem(stack4, false); }
				else if (playerIn instanceof ServerPlayerEntity) {
					((ServerPlayerEntity)playerIn).sendContainerToPlayer(playerIn.container); } }
			if (mode) { }

			CMEvents.soundBottleFill(worldIn, pos);
			worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i - 2)));
			return ActionResultType.SUCCESS;
		}

		/** 水入りガラス瓶 **/
		if (item == Items.POTION && PotionUtils.getPotionFromItem(stack) == Potions.WATER) {
			
			worldIn.playSound((PlayerEntity)null, pos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
			
			if (!mode) {
				stack.shrink(1);
				if (stack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE)); }
				else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE))) {
					playerIn.dropItem(new ItemStack(Items.GLASS_BOTTLE), false); } }
			if (mode) { }

			if (i < 3) {worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i + 2))); }
			if (i == 3) {
				worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE_full.getDefaultState()
						.with(H_FACING, state.get(H_FACING))
						.with(Mizuoke_full.STAGE_1_2, Integer.valueOf(1))); }

			if (i == 4) {
				worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE_full.getDefaultState()
						.with(H_FACING, state.get(H_FACING))
						.with(Mizuoke_full.STAGE_1_2, Integer.valueOf(2))); }

			return ActionResultType.SUCCESS;
		}

		/** 計量カップ **/
		if (i > 2 && item == Items_Teatime.KEIRYO_CUP && !state.get(WATERLOGGED)) {

			if (!mode) {
				stack.shrink(1);
				if (stack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.KEIRYO_CUP_full)); }
				else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.KEIRYO_CUP_full))) {
					playerIn.dropItem(new ItemStack(Items_Teatime.KEIRYO_CUP_full), false); } }
			if (mode) { }

			CMEvents.soundBottleFill(worldIn, pos);
			worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i - 2)));
			return ActionResultType.SUCCESS;
		}

		/** 洗う **/
		else {

			if (i > 2 && item instanceof IDyeableArmorItem) {
				IDyeableArmorItem idyeablearmoritem = (IDyeableArmorItem)item;
				if (idyeablearmoritem.hasColor(stack) && !worldIn.isRemote) {
					idyeablearmoritem.removeColor(stack);

					CMEvents.soundWaterUse(worldIn, pos);
					worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i - 2)));
					playerIn.addStat(Stats.CLEAN_ARMOR);
				}
				return ActionResultType.SUCCESS;
			} //鎧

			if (i > 2 && item instanceof BannerItem) {
				if (BannerTileEntity.getPatterns(stack) > 0 && !worldIn.isRemote) {
					ItemStack stack2 = stack.copy();
					stack2.setCount(1);
					BannerTileEntity.removeBannerData(stack2);
					playerIn.addStat(Stats.CLEAN_BANNER);
					if (!mode) { stack.shrink(1); }

					CMEvents.soundWaterUse(worldIn, pos);
					worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i - 2)));

					if (stack.isEmpty()) { playerIn.setHeldItem(hand, stack2); }
					else if (!playerIn.inventory.addItemStackToInventory(stack2)) { playerIn.dropItem(stack2, false); }
					else if (playerIn instanceof ServerPlayerEntity) {
						((ServerPlayerEntity)playerIn).sendContainerToPlayer(playerIn.container); }
				}
				return ActionResultType.SUCCESS;
			} //旗

			if (i > 2 && item instanceof BlockItem) {
				Block block = ((BlockItem)item).getBlock();
				if (block instanceof ShulkerBoxBlock && !worldIn.isRemote()) {
					ItemStack stack1 = new ItemStack(Blocks.SHULKER_BOX, 1);
					if (stack.hasTag()) { stack1.setTag(stack.getTag().copy()); }

					playerIn.setHeldItem(hand, stack1);
					CMEvents.soundWaterUse(worldIn, pos);
					worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i - 2)));
					playerIn.addStat(Stats.CLEAN_SHULKER_BOX);
					return ActionResultType.SUCCESS;
				}
				else {
					return ActionResultType.CONSUME;
				}
			} //シェルカー

			if (i > 2 && item instanceof Base_ItemHake) {
				if (!mode) { stack.shrink(1); }

				CMEvents.soundWaterUse(worldIn, pos);
				worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i - 2)));

				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }

				return ActionResultType.SUCCESS;
			} //色筆

		}
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* Update BlockState. */
	@Override
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.get(WATERLOGGED)) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, Hakkou_Blocks.MIZUOKE, 10); }

		return super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
	}
	
	/* TickRandom */
	@Override
	public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		if ((Boolean)state.get(WATERLOGGED)) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, Hakkou_Blocks.MIZUOKE, 10); }
	}

	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		if (state.get(WATERLOGGED)) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, Hakkou_Blocks.MIZUOKE, 10);
			CMEvents.soundBubble(worldIn, pos);
			worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE_full.getDefaultState()
					.with(H_FACING, state.get(H_FACING))
					.with(Mizuoke_full.STAGE_1_2, Integer.valueOf(2))
					.with(Mizuoke_full.WATERLOGGED, state.get(WATERLOGGED))); }
	}

	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		int i = state.get(STAGE_1_4);

		if (!state.get(WATERLOGGED) && worldIn.isRainingAt(pos.up())) {
			if (rand.nextInt(1) == 0) {
				if (i < 4) { worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i + 1))); }
				if (i == 4) {
					worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE_full.getDefaultState()
							.with(H_FACING, state.get(H_FACING))); } } }
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(H_FACING);

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
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.MIZUOKE);
	}

	/* Can't breathe. */
	@Override
	public boolean causesSuffocation(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	/* Block is a cube. */
	@Override
	public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	/* Mobs spawn. */
	@Override
	public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type) {
		return false;
	}

	/* The best harvesting tool. */
	@Nullable
	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.AXE;
	}

	@Override
	public int getHarvestLevel(BlockState state) {
		return 0;
	}
}
