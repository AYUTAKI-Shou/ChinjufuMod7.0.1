package com.ayutaki.chinjufumod.blocks.hakkou;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class TaruF_Shouyu extends BaseTaru_Stage08 {

	/** 0=未発酵の醤油、5=醤油、 6=醤油、7=醤油、 8=醤油 **/
	public TaruF_Shouyu(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		int i = state.getValue(STAGE_0_8);

		/** Too early to collect **/
		if (i <= 4) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
		
		/** Can harvest **/
		if (i > 4) {
			if (item == Items.GLASS_BOTTLE) {
				/** Collect with an Item **/
				CMEvents.Consume1Item_Bottle(worldIn, pos, playerIn, hand);
	
				if (stack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items_Teatime.SHOUYU_bot_1)); }
				else if (!playerIn.inventory.add(new ItemStack(Items_Teatime.SHOUYU_bot_1))) {
					playerIn.drop(new ItemStack(Items_Teatime.SHOUYU_bot_1), false); }
	
				if (i != 8) {
					worldIn.setBlock(pos, state.setValue(STAGE_0_8, Integer.valueOf(i + 1)), 3); }
	
				if (i == 8) {
					worldIn.setBlock(pos, Hakkou_Blocks.HAKKOU_TARU.defaultBlockState()
							.setValue(Taru_Hakkou.STAGE_0_5, Integer.valueOf(0)), 3); }
			}
			
			if (item != Items.GLASS_BOTTLE) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		}
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_taru_shouyu").withStyle(TextFormatting.GRAY));
	}
}
