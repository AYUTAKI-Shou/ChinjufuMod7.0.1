package com.ayutaki.chinjufumod.blocks.hakkou;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class TaruY_Ringoshu extends BaseTaru_Yoh {

	/* 1,2,3=Early、4,5=Complete、6=Aged */
	public TaruY_Ringoshu(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		int i = state.getValue(STAGE_1_6);

		/** Too early to collect **/
		if (i <= 3) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
		
		/** Can harvest **/
		if (i > 3) {
			if (item == Items_Teatime.SAKEBOTTLE.get()) {
				/** Collect with an Item **/
				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundSakeBottleFill(worldIn, pos);
				
				if (i == 4 || i == 5) {
					if (stack.isEmpty()) { playerIn.getInventory().add(new ItemStack(Items_Teatime.CIDERBOT.get())); }
					else if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.CIDERBOT.get()))) {
						playerIn.drop(new ItemStack(Items_Teatime.CIDERBOT.get()), false); } }
		
				if (i == 6) {
					if (stack.isEmpty()) { playerIn.getInventory().add(new ItemStack(Items_Teatime.JUKUCIDERBOT.get())); }
					else if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.JUKUCIDERBOT.get()))) {
						playerIn.drop(new ItemStack(Items_Teatime.JUKUCIDERBOT.get()), false); } }
				
				/** Get EXP. **/
				worldIn.addFreshEntity(new ExperienceOrb(worldIn, pos.getX(), pos.getY() + 0.5D, pos.getZ(), 1));
				worldIn.setBlock(pos, Hakkou_Blocks.COCOA_TARU.get().defaultBlockState()
						.setValue(AXIS, state.getValue(AXIS)).setValue(BaseTaru_Yoh.STAGE_1_6, Integer.valueOf(6)), 3);
			}
			
			if (item != Items_Teatime.SAKEBOTTLE.get()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		}
		
		/** SUCCESS to not put anything on top. **/
		return InteractionResult.SUCCESS;
	}

	/* TickRandom */
	@SuppressWarnings("deprecation")
	public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {

		if (!worldIn.isAreaLoaded(pos, 2)) return;

		int i = state.getValue(STAGE_1_6);

		if (i != 6 && rand.nextInt(6) == 0) {
			worldIn.setBlock(pos, state.setValue(STAGE_1_6, Integer.valueOf(i + 1)), 3); }

		else { }
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.RINGOSHU_TARU.get());
	}
	
	/* ToolTip */
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.block_taru_ringoshu").withStyle(ChatFormatting.GRAY));
	}
}
