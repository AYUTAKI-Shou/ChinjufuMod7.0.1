package com.ayutaki.chinjufumod.blocks.hakkou;

import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage4_FaceWater;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.color.Base_ItemHake;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShulkerBoxBlock;
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
	protected static final VoxelShape BASE = Block.box(5.0D, 0.5D, 5.0D, 11.0D, 1.5D, 11.0D);
	protected static final VoxelShape BODY = VoxelShapes.or(BASE, 
			Block.box(4.0D, 0.0D, 4.0D, 12.0D, 9.0D, 5.0D),
			Block.box(4.0D, 0.0D, 11.0D, 12.0D, 9.0D, 12.0D),
			Block.box(4.0D, 0.0D, 5.0D, 5.0D, 9.0D, 11.0D),
			Block.box(11.0D, 0.0D, 5.0D, 12.0D, 9.0D, 11.0D));
	
	protected static final VoxelShape AABB_SOUTH = VoxelShapes.or(BODY, 
			Block.box(3.5D, 13.0D, 7.5D, 12.5D, 14.0D, 8.5D),
			Block.box(4.0D, 9.0D, 7.0D, 5.0D, 15.0D, 9.0D),
			Block.box(11.0D, 9.0D, 7.0D, 12.0D, 15.0D, 9.0D));
	protected static final VoxelShape AABB_WEST = VoxelShapes.or(BODY, 
			Block.box(7.5D, 13.0D, 3.5D, 8.5D, 14.0D, 12.5D),
			Block.box(7.0D, 9.0D, 4.0D, 9.0D, 15.0D, 5.0D),
			Block.box(7.0D, 9.0D, 11.0D, 9.0D, 15.0D, 12.0D));
	protected static final VoxelShape AABB_NORTH = VoxelShapes.or(BODY, 
			Block.box(3.5D, 13.0D, 7.5D, 12.5D, 14.0D, 8.5D),
			Block.box(4.0D, 9.0D, 7.0D, 5.0D, 15.0D, 9.0D),
			Block.box(11.0D, 9.0D, 7.0D, 12.0D, 15.0D, 9.0D));
	protected static final VoxelShape AABB_EAST = VoxelShapes.or(BODY, 
			Block.box(7.5D, 13.0D, 3.5D, 8.5D, 14.0D, 12.5D),
			Block.box(7.0D, 9.0D, 4.0D, 9.0D, 15.0D, 5.0D),
			Block.box(7.0D, 9.0D, 11.0D, 9.0D, 15.0D, 12.0D));

	/* Property 空=1, 2=1.7, 3=3.4, 4=5.1, 水入り5=6.8, 水入り6=8.5 */
	public Mizuoke(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action Cauldron */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		int i = state.getValue(STAGE_1_4);
		boolean mode = playerIn.abilities.instabuild;

		/** バケツ **/
		if (item == Items.WATER_BUCKET && !state.getValue(WATERLOGGED)) {
			
			CMEvents.WaterBucket_Empty(worldIn, pos, playerIn, hand);
			if (i == 1) {
				worldIn.setBlock(pos, Hakkou_Blocks.MIZUOKE_full.defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(Mizuoke_full.STAGE_1_2, Integer.valueOf(1)), 3); }

			if (i != 1) {
				worldIn.setBlock(pos, Hakkou_Blocks.MIZUOKE_full.defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(Mizuoke_full.STAGE_1_2, Integer.valueOf(2)), 3); }

			return ActionResultType.SUCCESS;
		}

		if (item == Items_Teatime.MIZUOKE_full && !state.getValue(WATERLOGGED)) {
			
			CMEvents.MIZUOKEfull_Empty(worldIn, pos, playerIn, hand);
			if (i == 1) {
				worldIn.setBlock(pos, Hakkou_Blocks.MIZUOKE_full.defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(Mizuoke_full.STAGE_1_2, Integer.valueOf(1)), 3); }

			if (i != 1) {
				worldIn.setBlock(pos, Hakkou_Blocks.MIZUOKE_full.defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(Mizuoke_full.STAGE_1_2, Integer.valueOf(2)), 3); }
			return ActionResultType.SUCCESS;
		}

		/** ガラス瓶 **/
		if (i > 2 && item == Items.GLASS_BOTTLE && !state.getValue(WATERLOGGED)) {

			if (!mode) { 
				stack.shrink(1);
				ItemStack stack4 = PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER);
				if (stack.isEmpty()) { playerIn.setItemInHand(hand, stack4); }
				else if (!playerIn.inventory.add(stack4)) { playerIn.drop(stack4, false); }
				else if (playerIn instanceof ServerPlayerEntity) {
					((ServerPlayerEntity)playerIn).refreshContainer(playerIn.inventoryMenu); } }
			if (mode) { }

			CMEvents.soundBottleFill(worldIn, pos);
			worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(i - 2)), 3);
			return ActionResultType.SUCCESS;
		}

		/** 水入りガラス瓶 **/
		if (item == Items.POTION && PotionUtils.getPotion(stack) == Potions.WATER) {
			
			worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
			
			if (!mode) { 
				stack.shrink(1);
				if (stack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items.GLASS_BOTTLE)); }
				else if (!playerIn.inventory.add(new ItemStack(Items.GLASS_BOTTLE))) {
					playerIn.drop(new ItemStack(Items.GLASS_BOTTLE), false); } }
			if (mode) { }

			if (i < 3) {worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(i + 2)), 3); }
			if (i == 3) {
				worldIn.setBlock(pos, Hakkou_Blocks.MIZUOKE_full.defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(Mizuoke_full.STAGE_1_2, Integer.valueOf(1)), 3); }

			if (i == 4) {
				worldIn.setBlock(pos, Hakkou_Blocks.MIZUOKE_full.defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(Mizuoke_full.STAGE_1_2, Integer.valueOf(2)), 3); }

			return ActionResultType.SUCCESS;
		}

		/** 計量カップ **/
		if (i > 2 && item == Items_Teatime.KEIRYO_CUP && !state.getValue(WATERLOGGED)) {

			if (!mode) { 
				stack.shrink(1);
				if (stack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items_Teatime.KEIRYO_CUP_full)); }
				else if (!playerIn.inventory.add(new ItemStack(Items_Teatime.KEIRYO_CUP_full))) {
					playerIn.drop(new ItemStack(Items_Teatime.KEIRYO_CUP_full), false); } }
			if (mode) { }

			CMEvents.soundBottleFill(worldIn, pos);
			worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(i - 2)), 3);
			return ActionResultType.SUCCESS;
		}
		
		/** 洗う **/
		else {

			if (i > 2 && item instanceof IDyeableArmorItem) {
				IDyeableArmorItem idyeablearmoritem = (IDyeableArmorItem)item;
				if (idyeablearmoritem.hasCustomColor(stack) && !worldIn.isClientSide) {
					idyeablearmoritem.clearColor(stack);

					CMEvents.soundWaterUse(worldIn, pos);
					worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(i - 2)), 3);
					playerIn.awardStat(Stats.CLEAN_ARMOR);
				}
				return ActionResultType.SUCCESS;
			} //鎧

			if (i > 2 && item instanceof BannerItem) {
				if (BannerTileEntity.getPatternCount(stack) > 0 && !worldIn.isClientSide) {
					ItemStack stack2 = stack.copy();
					stack2.setCount(1);
					BannerTileEntity.removeLastPattern(stack2);
					playerIn.awardStat(Stats.CLEAN_BANNER);
					
					if (!mode) { stack.shrink(1); }
					CMEvents.soundWaterUse(worldIn, pos);
					
					worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(i - 2)), 3);

					if (stack.isEmpty()) { playerIn.setItemInHand(hand, stack2); }
					else if (!playerIn.inventory.add(stack2)) { playerIn.drop(stack2, false); }
					else if (playerIn instanceof ServerPlayerEntity) {
						((ServerPlayerEntity)playerIn).refreshContainer(playerIn.inventoryMenu); }
				}
				return ActionResultType.SUCCESS;
			} //旗

			if (i > 2 && item instanceof BlockItem) {
				Block block = ((BlockItem)item).getBlock();
				if (block instanceof ShulkerBoxBlock && !worldIn.isClientSide()) {
					ItemStack stack1 = new ItemStack(Blocks.SHULKER_BOX, 1);
					if (stack.hasTag()) { stack1.setTag(stack.getTag().copy()); }

					playerIn.setItemInHand(hand, stack1);
					CMEvents.soundWaterUse(worldIn, pos);
					worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(i - 2)), 3);
					playerIn.awardStat(Stats.CLEAN_SHULKER_BOX);
					return ActionResultType.SUCCESS;
				}
				else {
					return ActionResultType.CONSUME;
				}
			} //シェルカー

			if (i > 2 && item instanceof Base_ItemHake) {
				
				if (!mode) { stack.shrink(1); }
				CMEvents.soundWaterUse(worldIn, pos);
				
				worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(i - 2)), 3);

				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }

				return ActionResultType.SUCCESS;
			} //色筆

		}
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* Update BlockState. */
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.getValue(WATERLOGGED)) {
			worldIn.getBlockTicks().scheduleTick(pos, Hakkou_Blocks.MIZUOKE, 10); }

		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}
	
	/* TickRandom */
	@Override
	public void onPlace(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		if ((Boolean)state.getValue(WATERLOGGED)) {
			worldIn.getBlockTicks().scheduleTick(pos, Hakkou_Blocks.MIZUOKE, 10); }
	}
	
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		if (state.getValue(WATERLOGGED)) {
			worldIn.getBlockTicks().scheduleTick(pos, Hakkou_Blocks.MIZUOKE, 10);
			CMEvents.soundBubble(worldIn, pos);
			worldIn.setBlock(pos, Hakkou_Blocks.MIZUOKE_full.defaultBlockState()
					.setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Mizuoke_full.STAGE_1_2, Integer.valueOf(2))
					.setValue(Mizuoke_full.WATERLOGGED, state.getValue(WATERLOGGED)), 3); }
	}
	
	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		int i = state.getValue(STAGE_1_4);

		if (!state.getValue(WATERLOGGED) && worldIn.isRainingAt(pos.above())) {
			if (rand.nextInt(1) == 0) {
				if (i != 4) { worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
				if (i == 4) {
					worldIn.setBlock(pos, Hakkou_Blocks.MIZUOKE_full.defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING)), 3); } }	
		}
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
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
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.MIZUOKE);
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
