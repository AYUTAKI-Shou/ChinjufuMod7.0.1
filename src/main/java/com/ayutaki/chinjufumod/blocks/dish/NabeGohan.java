package com.ayutaki.chinjufumod.blocks.dish;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class NabeGohan extends BaseNabe {

	public NabeGohan(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		int i = state.get(STAGE_1_4);

		if (item == Items_Teatime.CHAWAN) {
			/** Collect with an Item **/
			CMEvents.Consume1Item_SnowB(worldIn, pos, playerIn, hand);

			if (stack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.GOHAN)); }
			else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.GOHAN))) {
				playerIn.dropItem(new ItemStack(Items_Teatime.GOHAN), false); }

			if (i != 4) { worldIn.setBlockState(pos, state.with(BaseNabe.STAGE_1_4, Integer.valueOf(i + 1))); }

			if (i == 4) {
				worldIn.setBlockState(pos, Dish_Blocks.NABE_kara.getDefaultState().with(H_FACING, state.get(H_FACING))
						.with(COOK, state.get(COOK)).with(DOWN, state.get(DOWN))
						.with(Nabe_kara.STAGE_1_4, Integer.valueOf(3))); }
		}

		if (item == Items_Teatime.SARA) {
			/** Collect with an Item **/
			CMEvents.Consume1Item_SnowB(worldIn, pos, playerIn, hand);
			
			if (stack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.RICE)); }
			else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.RICE))) {
				playerIn.dropItem(new ItemStack(Items_Teatime.RICE), false); }

			if (i != 4) { worldIn.setBlockState(pos, state.with(BaseNabe.STAGE_1_4, Integer.valueOf(i + 1))); }

			if (i == 4) {
				worldIn.setBlockState(pos, Dish_Blocks.NABE_kara.getDefaultState().with(H_FACING, state.get(H_FACING))
						.with(COOK, state.get(COOK)).with(DOWN, state.get(DOWN))
						.with(Nabe_kara.STAGE_1_4, Integer.valueOf(3))); }
		}

		if (item == Items_Teatime.DONBURI) {
			if (i != 4) {
				/** Collect with an Item **/
				CMEvents.Consume1Item_SnowB(worldIn, pos, playerIn, hand);
				
				if (stack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.DONBURI_MESHI)); }
				else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.DONBURI_MESHI))) {
					playerIn.dropItem(new ItemStack(Items_Teatime.DONBURI_MESHI), false); }
	
				if (i == 3) {
					worldIn.setBlockState(pos, Dish_Blocks.NABE_kara.getDefaultState().with(H_FACING, state.get(H_FACING))
							.with(COOK, state.get(COOK)).with(DOWN, state.get(DOWN))
							.with(Nabe_kara.STAGE_1_4, Integer.valueOf(3))); }
	
				if (i != 3) { worldIn.setBlockState(pos, state.with(BaseNabe.STAGE_1_4, Integer.valueOf(i + 2))); }
			}
			
			if (i == 4) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		}

		if (item == Items.BOWL) {
			if (i == 1) {
				/** Collect with an Item **/
				CMEvents.Consume1Item_SnowB(worldIn, pos, playerIn, hand);
				
				if (stack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MUSHIGOME)); }
				else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MUSHIGOME))) {
					playerIn.dropItem(new ItemStack(Items_Teatime.MUSHIGOME), false); }
	
				worldIn.setBlockState(pos, Dish_Blocks.NABE_kara.getDefaultState().with(H_FACING, state.get(H_FACING))
						.with(COOK, state.get(COOK)).with(DOWN, state.get(DOWN))
						.with(Nabe_kara.STAGE_1_4, Integer.valueOf(3))); }
			
			if (i != 1) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		}
		
		if (item != Items_Teatime.CHAWAN && item != Items_Teatime.SARA && item != Items.BOWL && item != Items_Teatime.DONBURI) {
			CMEvents.textNotHave(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		if (inWater(state, worldIn, pos)) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, this, 60);
			CMEvents.soundSnowBreak(worldIn, pos);
			worldIn.setBlockState(pos, Dish_Blocks.NABE_kara.getDefaultState()
					.with(H_FACING, state.get(H_FACING))
					.with(COOK, state.get(COOK))
					.with(DOWN, state.get(DOWN))
					.with(Nabe_kara.STAGE_1_4, Integer.valueOf(3))
					.with(Nabe_kara.WATERLOGGED, state.get(WATERLOGGED)), 3);
			this.dropRottenfood(worldIn, pos); }
		
		else { }
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.NABEGOHAN);
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_food_nabegohan_1").applyTextStyle(TextFormatting.GRAY));
	}
}
