package com.ayutaki.chinjufumod.blocks.kitchen;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Kitchen extends Base_Tana7 {

	/* Collision */
	protected static final VoxelShape TOP = Block.box(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	
	protected static final VoxelShape AABB_SOUTH = Shapes.or(TOP, Block.box(0.0D, 0.0D, 1.0D, 16.0D, 15.0D, 15.0D));
	protected static final VoxelShape AABB_WEST = Shapes.or(TOP, Block.box(1.0D, 0.0D, 0.0D, 15.0D, 15.0D, 16.0D));
	protected static final VoxelShape AABB_NORTH = Shapes.or(TOP, Block.box(0.0D, 0.0D, 1.0D, 16.0D, 15.0D, 15.0D));
	protected static final VoxelShape AABB_EAST = Shapes.or(TOP, Block.box(1.0D, 0.0D, 0.0D, 15.0D, 15.0D, 16.0D));
	
	public Kitchen(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		int i = state.getValue(STAGE_1_7);
		/** 1=キッチン、2=やかん、3=寸胴、4=土鍋、5=土鍋、6=フライパン、7=フライパン **/

		/** Hand is empty. **/
		if (stack.isEmpty()) {
			
			if (i == 1) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			
			if (i == 2) {
				playerIn.getInventory().add(new ItemStack(Items_Teatime.KETTLE_kara.get()));
				CMEvents.soundItemPick(worldIn, pos);
				
				worldIn.setBlock(pos, state.setValue(STAGE_1_7, Integer.valueOf(1)), 3); }
			
			if (i == 3) {
				playerIn.getInventory().add(new ItemStack(Items_Teatime.ZUNDOU.get()));
				CMEvents.soundItemPick(worldIn, pos);
				
				worldIn.setBlock(pos, state.setValue(STAGE_1_7, Integer.valueOf(1)), 3); }
			
			if (i == 4 && item != Items_Teatime.NABE_kara.get()) {
				playerIn.getInventory().add(new ItemStack(Items_Teatime.NABE_kara.get()));
				CMEvents.soundItemPick(worldIn, pos);
				
				worldIn.setBlock(pos, state.setValue(STAGE_1_7, Integer.valueOf(1)), 3); }
	
			if (i == 5) {
				playerIn.getInventory().add(new ItemStack(Items_Teatime.NABE_kara.get()));
				CMEvents.soundItemPick(worldIn, pos);
				
				worldIn.setBlock(pos, state.setValue(STAGE_1_7, Integer.valueOf(4)), 3); }
			
			if (i == 6 && item != Items_Teatime.FRYPAN_kara.get()) {
				playerIn.getInventory().add(new ItemStack(Items_Teatime.FRYPAN_kara.get()));
				CMEvents.soundItemPick(worldIn, pos);
				
				worldIn.setBlock(pos, state.setValue(STAGE_1_7, Integer.valueOf(1)), 3); }
			
			if (i == 7) {
				playerIn.getInventory().add(new ItemStack(Items_Teatime.FRYPAN_kara.get()));
				CMEvents.soundItemPick(worldIn, pos);
				
				worldIn.setBlock(pos, state.setValue(STAGE_1_7, Integer.valueOf(6)), 3); }
		}
		
		/** Hand is not empty. **/
		if (!stack.isEmpty()) {
			if (i == 1) {
				if (item == Items_Teatime.KETTLE_kara.get()) {
					CMEvents.Consume_1Item(playerIn, hand);
					worldIn.playSound(null, pos, SoundEvents.METAL_PLACE, SoundSource.BLOCKS, 1.0F, 3.0F);
					worldIn.setBlock(pos, state.setValue(STAGE_1_7, Integer.valueOf(2)), 3); }
	
				if (item == Items_Teatime.ZUNDOU.get()) {
					CMEvents.Consume_1Item(playerIn, hand);
					worldIn.playSound(null, pos, SoundEvents.METAL_PLACE, SoundSource.BLOCKS, 1.0F, 3.0F);
					worldIn.setBlock(pos, state.setValue(STAGE_1_7, Integer.valueOf(3)), 3); }
	
				if (item == Items_Teatime.NABE_kara.get()) {
					CMEvents.Consume_1Item(playerIn, hand);
					worldIn.playSound(null, pos, SoundEvents.STONE_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
					worldIn.setBlock(pos, state.setValue(STAGE_1_7, Integer.valueOf(4)), 3); }
	
				if (item == Items_Teatime.FRYPAN_kara.get()) {
					CMEvents.Consume_1Item(playerIn, hand);
					worldIn.playSound(null, pos, SoundEvents.METAL_PLACE, SoundSource.BLOCKS, 1.0F, 3.0F);
					worldIn.setBlock(pos, state.setValue(STAGE_1_7, Integer.valueOf(6)), 3); }
				
				if (item != Items_Teatime.KETTLE_kara.get() && item != Items_Teatime.ZUNDOU.get() &&
						item != Items_Teatime.NABE_kara.get() && item != Items_Teatime.FRYPAN_kara.get()) { 
					CMEvents.textNotHave(worldIn, pos, playerIn); }
			}
	
			if (i == 4) {
				if (item == Items_Teatime.NABE_kara.get()) {
					CMEvents.Consume_1Item(playerIn, hand);
					worldIn.playSound(null, pos, SoundEvents.STONE_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
					worldIn.setBlock(pos, state.setValue(STAGE_1_7, Integer.valueOf(5)), 3); }
				
				if (item != Items_Teatime.NABE_kara.get()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
			}
			
			if (i == 6) {
				if (item == Items_Teatime.FRYPAN_kara.get()) {
					CMEvents.Consume_1Item(playerIn, hand);
					worldIn.playSound(null, pos, SoundEvents.METAL_PLACE, SoundSource.BLOCKS, 1.0F, 3.0F);
					worldIn.setBlock(pos, state.setValue(STAGE_1_7, Integer.valueOf(7)), 3); }
				
				if (item != Items_Teatime.FRYPAN_kara.get()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
			}
			
			if (i != 1 && i != 4 && i != 6) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}

		/** SUCCESS to not put anything on top. **/
		return InteractionResult.SUCCESS;
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		Direction direction = state.getValue(H_FACING);

		switch (direction) {
		case NORTH:
		default: return AABB_NORTH;
		case SOUTH: return AABB_SOUTH;
		case WEST: return AABB_WEST;
		case EAST: return AABB_EAST;
		} // switch
	}

	/* ToolTip */
	@Override
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.block_kitchen").withStyle(ChatFormatting.GRAY));
	}
}
