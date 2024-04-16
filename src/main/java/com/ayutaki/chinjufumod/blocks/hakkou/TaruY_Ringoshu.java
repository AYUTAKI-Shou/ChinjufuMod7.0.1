package com.ayutaki.chinjufumod.blocks.hakkou;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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

public class TaruY_Ringoshu extends BaseTaru_Yoh {

	/* 1,2,3=未発酵、4,5=シードル、6=熟成シードル */
	public TaruY_Ringoshu(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		int i = state.get(STAGE_1_6);

		/** Too early to collect **/
		if (i <= 3) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
		
		/** Can harvest **/
		if (i > 3) {
			if (item == Items_Teatime.SAKEBOTTLE) {
				/** Collect with an Item **/
				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundSakeBottleFill(worldIn, pos);
				
				if (i == 4 || i == 5) {
					if (stack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.CIDERBOT)); }
					else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.CIDERBOT))) {
						playerIn.dropItem(new ItemStack(Items_Teatime.CIDERBOT), false); } }
		
				if (i == 6) {
					if (stack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.JUKUCIDERBOT)); }
					else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.JUKUCIDERBOT))) {
						playerIn.dropItem(new ItemStack(Items_Teatime.JUKUCIDERBOT), false); } }
				
				/** Get EXP. **/
				worldIn.addEntity(new ExperienceOrbEntity(worldIn, pos.getX(), pos.getY() + 0.5D, pos.getZ(), 1));
				worldIn.setBlockState(pos, Hakkou_Blocks.COCOA_TARU.getDefaultState()
						.with(AXIS, state.get(AXIS)).with(BaseTaru_Yoh.STAGE_1_6, Integer.valueOf(6)));
			}
			
			if (item != Items_Teatime.SAKEBOTTLE) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		}
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* TickRandom */
	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		if (!worldIn.isAreaLoaded(pos, 2)) return;

		int i = state.get(STAGE_1_6);

		if (i != 6 && rand.nextInt(6) == 0) {
			worldIn.setBlockState(pos, state.with(STAGE_1_6, Integer.valueOf(i + 1))); }

		else { }
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.RINGOSHU_TARU);
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_taru_ringoshu").applyTextStyle(TextFormatting.GRAY));
	}
}
