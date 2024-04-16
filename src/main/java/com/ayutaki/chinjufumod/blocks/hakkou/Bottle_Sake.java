package com.ayutaki.chinjufumod.blocks.hakkou;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Bottle_Sake extends Base_Bottle {

	public Bottle_Sake(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		int i = state.get(STAGE_1_5);

		if (i != 5) {
			if (item == Items_Teatime.DRINKGLASS) {
				/** Collect with an Item **/
				CMEvents.Consume_1Item(playerIn, hand);
				worldIn.playSound(null, pos, SoundEvents_CM.SAKE, SoundCategory.PLAYERS, 1.0F, 1.0F);

				if (stack.isEmpty()) { playerIn.inventory.addItemStackToInventory(this.takeGlass()); }
				else if (!playerIn.inventory.addItemStackToInventory(this.takeGlass())) {
					playerIn.dropItem(this.takeGlass(), false); }
	
				worldIn.setBlockState(pos, state.with(Base_Bottle.STAGE_1_5, Integer.valueOf(i + 1))); }
			
			if (item != Items_Teatime.DRINKGLASS) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		}
		
		if (i == 5) { CMEvents.textIsEmpty(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	private ItemStack takeGlass() {
		if (this == Hakkou_Blocks.NAMASAKEBOT) { return new ItemStack(Items_Teatime.NAMASAKEGLASS, 1); }
		if (this == Hakkou_Blocks.SAKEBOT) { return new ItemStack(Items_Teatime.SAKEGLASS, 1); }
		if (this == Hakkou_Blocks.JUKUSAKEBOT) { return new ItemStack(Items_Teatime.JUKUSAKEGLASS, 1); }
		if (this == Hakkou_Blocks.CIDERBOT) { return new ItemStack(Items_Teatime.CIDERGLASS, 1); }
		if (this == Hakkou_Blocks.JUKUCIDERBOT) { return new ItemStack(Items_Teatime.JUKUCIDERGLASS, 1); }
		if (this == Hakkou_Blocks.WINEBOT) { return new ItemStack(Items_Teatime.WINEGLASS, 1); }
		if (this == Hakkou_Blocks.JUKUWINEBOT) { return new ItemStack(Items_Teatime.JUKUWINEGLASS, 1); }
		if (this == Hakkou_Blocks.MEADBOT) { return new ItemStack(Items_Teatime.MEADGLASS, 1); }
		if (this == Hakkou_Blocks.JUKUMEADBOT) { return new ItemStack(Items_Teatime.JUKUMEADGLASS, 1); }
		return null;
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return this.takeStack();
	}

	private ItemStack takeStack() {
		if (this == Hakkou_Blocks.NAMASAKEBOT) { return new ItemStack(Items_Teatime.NAMASAKEBOT, 1); }
		if (this == Hakkou_Blocks.SAKEBOT) { return new ItemStack(Items_Teatime.SAKEBOT, 1); }
		if (this == Hakkou_Blocks.JUKUSAKEBOT) { return new ItemStack(Items_Teatime.JUKUSAKEBOT, 1); }
		if (this == Hakkou_Blocks.CIDERBOT) { return new ItemStack(Items_Teatime.CIDERBOT, 1); }
		if (this == Hakkou_Blocks.JUKUCIDERBOT) { return new ItemStack(Items_Teatime.JUKUCIDERBOT, 1); }
		if (this == Hakkou_Blocks.WINEBOT) { return new ItemStack(Items_Teatime.WINEBOT, 1); }
		if (this == Hakkou_Blocks.JUKUWINEBOT) { return new ItemStack(Items_Teatime.JUKUWINEBOT, 1); }
		if (this == Hakkou_Blocks.MEADBOT) { return new ItemStack(Items_Teatime.MEADBOT, 1); }
		if (this == Hakkou_Blocks.JUKUMEADBOT) { return new ItemStack(Items_Teatime.JUKUMEADBOT, 1); }
		return null;
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_bot_sake").applyTextStyle(TextFormatting.GRAY));
	}
}
