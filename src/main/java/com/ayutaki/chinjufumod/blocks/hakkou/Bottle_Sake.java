package com.ayutaki.chinjufumod.blocks.hakkou;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class Bottle_Sake extends Base_Bottle {
	
	public Bottle_Sake(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		int i = state.getValue(STAGE_1_5);

		if (i != 5) {
			if (item == Items_Teatime.DRINKGLASS.get()) {
				/** Collect with an Item **/
				CMEvents.Consume_1Item(playerIn, hand);
				worldIn.playSound(null, pos, SoundEvents_CM.SAKE.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
	
				if (stack.isEmpty()) { playerIn.getInventory().add(takeGlass()); }
				else if (!playerIn.getInventory().add(takeGlass())) {
					playerIn.drop(takeGlass(), false); }
	
				worldIn.setBlock(pos, state.setValue(Base_Bottle.STAGE_1_5, Integer.valueOf(i + 1)), 3); }
			
			if (item != Items_Teatime.DRINKGLASS.get()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		}
		
		if (i == 5) { CMEvents.textIsEmpty(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return InteractionResult.SUCCESS;
	}
	
	private ItemStack takeGlass() {
		if (this == Hakkou_Blocks.NAMASAKEBOT.get()) { return new ItemStack(Items_Teatime.NAMASAKEGLASS.get(), 1); }
		if (this == Hakkou_Blocks.SAKEBOT.get()) { return new ItemStack(Items_Teatime.SAKEGLASS.get(), 1); }
		if (this == Hakkou_Blocks.JUKUSAKEBOT.get()) { return new ItemStack(Items_Teatime.JUKUSAKEGLASS.get(), 1); }
		if (this == Hakkou_Blocks.CIDERBOT.get()) { return new ItemStack(Items_Teatime.CIDERGLASS.get(), 1); }
		if (this == Hakkou_Blocks.JUKUCIDERBOT.get()) { return new ItemStack(Items_Teatime.JUKUCIDERGLASS.get(), 1); }
		if (this == Hakkou_Blocks.WINEBOT.get()) { return new ItemStack(Items_Teatime.WINEGLASS.get(), 1); }
		if (this == Hakkou_Blocks.JUKUWINEBOT.get()) { return new ItemStack(Items_Teatime.JUKUWINEGLASS.get(), 1); }
		if (this == Hakkou_Blocks.MEADBOT.get()) { return new ItemStack(Items_Teatime.MEADGLASS.get(), 1); }
		if (this == Hakkou_Blocks.JUKUMEADBOT.get()) { return new ItemStack(Items_Teatime.JUKUMEADGLASS.get(), 1); }
		return null;
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return this.takeStack();
	}
	
	private ItemStack takeStack() {
		if (this == Hakkou_Blocks.NAMASAKEBOT.get()) { return new ItemStack(Items_Teatime.NAMASAKEBOT.get(), 1); }
		if (this == Hakkou_Blocks.SAKEBOT.get()) { return new ItemStack(Items_Teatime.SAKEBOT.get(), 1); }
		if (this == Hakkou_Blocks.JUKUSAKEBOT.get()) { return new ItemStack(Items_Teatime.JUKUSAKEBOT.get(), 1); }
		if (this == Hakkou_Blocks.CIDERBOT.get()) { return new ItemStack(Items_Teatime.CIDERBOT.get(), 1); }
		if (this == Hakkou_Blocks.JUKUCIDERBOT.get()) { return new ItemStack(Items_Teatime.JUKUCIDERBOT.get(), 1); }
		if (this == Hakkou_Blocks.WINEBOT.get()) { return new ItemStack(Items_Teatime.WINEBOT.get(), 1); }
		if (this == Hakkou_Blocks.JUKUWINEBOT.get()) { return new ItemStack(Items_Teatime.JUKUWINEBOT.get(), 1); }
		if (this == Hakkou_Blocks.MEADBOT.get()) { return new ItemStack(Items_Teatime.MEADBOT.get(), 1); }
		if (this == Hakkou_Blocks.JUKUMEADBOT.get()) { return new ItemStack(Items_Teatime.JUKUMEADBOT.get(), 1); }
		return null;
	}
	
	/* ToolTip */
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.block_bot_sake").withStyle(ChatFormatting.GRAY));
	}
}
