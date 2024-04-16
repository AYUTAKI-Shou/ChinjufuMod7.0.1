package com.ayutaki.chinjufumod.blocks.hakkou;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.AbstractBlock;
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

public class TaruY_Cocoa extends BaseTaru_Yoh {

	/* 1,2,3=未発酵、4,5=ココア、6=空樽 */
	public TaruY_Cocoa(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		int i = state.getValue(STAGE_1_6);
		
		/** Too early to collect **/
		if (i <= 3) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
		
		/** Can harvest **/
		if (i == 4 || i == 5) {
			if (item == Items.BOWL) {
				/** Collect with an Item **/
				CMEvents.Consume1Item_SnowB(worldIn, pos, playerIn, hand);
	
				if (stack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items_Seasonal.COCOA_F)); }
				else if (!playerIn.inventory.add(new ItemStack(Items_Seasonal.COCOA_F))) {
					playerIn.drop(new ItemStack(Items_Seasonal.COCOA_F), false); }
	
				worldIn.setBlock(pos, state.setValue(STAGE_1_6, Integer.valueOf(6)), 3); }
			
			if (item != Items.BOWL) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		}
		
		/** Empty **/
		if (i == 6) { CMEvents.textIsEmpty(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* TickRandom */
	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		if (!worldIn.isAreaLoaded(pos, 2)) return;

		int i = state.getValue(STAGE_1_6);

		if (i < 5 && rand.nextInt(4) == 0) {
			worldIn.setBlock(pos, state.setValue(STAGE_1_6, Integer.valueOf(i + 1)), 3); }

		else { }
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		int i = state.getValue(STAGE_1_6);
		return (i == 6)? new ItemStack(Items_Teatime.HAKKOU_TARU) : new ItemStack(Items_Seasonal.COCOA_TARU);
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_taru_cocoa").withStyle(TextFormatting.GRAY));
	}
}
