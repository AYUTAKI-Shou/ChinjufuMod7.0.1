package com.ayutaki.chinjufumod.blocks.kitchen;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Kitchen extends Base_Tana7 {

	/* Collision */
	protected static final VoxelShape TOP = Block.box(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	
	protected static final VoxelShape AABB_SOUTH = VoxelShapes.or(TOP, Block.box(0.0D, 0.0D, 1.0D, 16.0D, 15.0D, 15.0D));
	protected static final VoxelShape AABB_WEST = VoxelShapes.or(TOP, Block.box(1.0D, 0.0D, 0.0D, 15.0D, 15.0D, 16.0D));
	protected static final VoxelShape AABB_NORTH = VoxelShapes.or(TOP, Block.box(0.0D, 0.0D, 1.0D, 16.0D, 15.0D, 15.0D));
	protected static final VoxelShape AABB_EAST = VoxelShapes.or(TOP, Block.box(1.0D, 0.0D, 0.0D, 15.0D, 15.0D, 16.0D));

	/** 1=キッチン、2=やかん、3=寸胴、4=土鍋、5=土鍋、6=フライパン、7=フライパン **/
	public Kitchen(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		int i = state.getValue(STAGE_1_7);
		/** 1=キッチン、2=やかん、3=寸胴、4=土鍋、5=土鍋、6=フライパン、7=フライパン **/

		/** Hand is empty. **/
		if (stack.isEmpty()) {
			
			if (i == 1) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			
			if (i == 2) {
				playerIn.inventory.add(new ItemStack(Items_Teatime.KETTLE_kara));
				CMEvents.soundItemPick(worldIn, pos);
				
				worldIn.setBlock(pos, state.setValue(STAGE_1_7, Integer.valueOf(1)), 3); }
			
			if (i == 3) {
				playerIn.inventory.add(new ItemStack(Items_Teatime.ZUNDOU));
				CMEvents.soundItemPick(worldIn, pos);
				
				worldIn.setBlock(pos, state.setValue(STAGE_1_7, Integer.valueOf(1)), 3); }
			
			if (i == 4 && item != Items_Teatime.NABE_kara) {
				playerIn.inventory.add(new ItemStack(Items_Teatime.NABE_kara));
				CMEvents.soundItemPick(worldIn, pos);
				
				worldIn.setBlock(pos, state.setValue(STAGE_1_7, Integer.valueOf(1)), 3); }
	
			if (i == 5) {
				playerIn.inventory.add(new ItemStack(Items_Teatime.NABE_kara));
				CMEvents.soundItemPick(worldIn, pos);
				
				worldIn.setBlock(pos, state.setValue(STAGE_1_7, Integer.valueOf(4)), 3); }
			
			if (i == 6 && item != Items_Teatime.FRYPAN_kara) {
				playerIn.inventory.add(new ItemStack(Items_Teatime.FRYPAN_kara));
				CMEvents.soundItemPick(worldIn, pos);
				
				worldIn.setBlock(pos, state.setValue(STAGE_1_7, Integer.valueOf(1)), 3); }
			
			if (i == 7) {
				playerIn.inventory.add(new ItemStack(Items_Teatime.FRYPAN_kara));
				CMEvents.soundItemPick(worldIn, pos);
				
				worldIn.setBlock(pos, state.setValue(STAGE_1_7, Integer.valueOf(6)), 3); }
		}
		
		/** Hand is not empty. **/
		if (!stack.isEmpty()) {
			if (i == 1) {
				if (item == Items_Teatime.KETTLE_kara) {
					CMEvents.Consume_1Item(playerIn, hand);
					worldIn.playSound(null, pos, SoundEvents.METAL_PLACE, SoundCategory.BLOCKS, 1.0F, 3.0F);
					worldIn.setBlock(pos, state.setValue(STAGE_1_7, Integer.valueOf(2)), 3); }
	
				if (item == Items_Teatime.ZUNDOU) {
					CMEvents.Consume_1Item(playerIn, hand);
					worldIn.playSound(null, pos, SoundEvents.METAL_PLACE, SoundCategory.BLOCKS, 1.0F, 3.0F);
					worldIn.setBlock(pos, state.setValue(STAGE_1_7, Integer.valueOf(3)), 3); }
	
				if (item == Items_Teatime.NABE_kara) {
					CMEvents.Consume_1Item(playerIn, hand);
					worldIn.playSound(null, pos, SoundEvents.STONE_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);
					worldIn.setBlock(pos, state.setValue(STAGE_1_7, Integer.valueOf(4)), 3); }
	
				if (item == Items_Teatime.FRYPAN_kara) {
					CMEvents.Consume_1Item(playerIn, hand);
					worldIn.playSound(null, pos, SoundEvents.METAL_PLACE, SoundCategory.BLOCKS, 1.0F, 3.0F);
					worldIn.setBlock(pos, state.setValue(STAGE_1_7, Integer.valueOf(6)), 3); }
				
				if (item != Items_Teatime.KETTLE_kara && item != Items_Teatime.ZUNDOU &&
						item != Items_Teatime.NABE_kara && item != Items_Teatime.FRYPAN_kara) { 
					CMEvents.textNotHave(worldIn, pos, playerIn); }
			}
	
			if (i == 4) {
				if (item == Items_Teatime.NABE_kara) {
					CMEvents.Consume_1Item(playerIn, hand);
					worldIn.playSound(null, pos, SoundEvents.STONE_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);
					worldIn.setBlock(pos, state.setValue(STAGE_1_7, Integer.valueOf(5)), 3); }
				
				if (item != Items_Teatime.NABE_kara) { CMEvents.textFullItem(worldIn, pos, playerIn); }
			}
			
			if (i == 6) {
				if (item == Items_Teatime.FRYPAN_kara) {
					CMEvents.Consume_1Item(playerIn, hand);
					worldIn.playSound(null, pos, SoundEvents.METAL_PLACE, SoundCategory.BLOCKS, 1.0F, 3.0F);
					worldIn.setBlock(pos, state.setValue(STAGE_1_7, Integer.valueOf(7)), 3); }
				
				if (item != Items_Teatime.FRYPAN_kara) { CMEvents.textFullItem(worldIn, pos, playerIn); }
			}
			
			if (i != 1 && i != 4 && i != 6) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}

		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
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
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_kitchen").withStyle(TextFormatting.GRAY));
	}
}
