package com.ayutaki.chinjufumod.handler;

import com.ayutaki.chinjufumod.registry.Items_NoTab;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class CMEvents {

	/* Item Sound */
	public static void soundPaint(Level worldIn, Player playerIn, BlockPos pos) {
		worldIn.playSound(playerIn, pos, SoundEvents_CM.PAINT.get(), SoundSource.BLOCKS, 1.0F, 0.8F); }
	
	public static void soundChisel(Level worldIn, Player playerIn, BlockPos pos) {
		worldIn.playSound(playerIn, pos, SoundEvents.STONE_BREAK, SoundSource.BLOCKS, 1.0F, 0.8F); }
	
	public static void soundChiselWood(Level worldIn, Player playerIn, BlockPos pos) {
		worldIn.playSound(playerIn, pos, SoundEvents.WOOD_BREAK, SoundSource.BLOCKS, 1.0F, 0.8F); }
	
	public static void soundKumade(Level worldIn, Player playerIn, BlockPos pos) {
		worldIn.playSound(playerIn, pos, SoundEvents.SAND_PLACE, SoundSource.BLOCKS, 1.0F, 0.8F); }
	
	public static void soundWash(Level worldIn, Player playerIn, BlockPos pos) {
		worldIn.playSound(playerIn, pos, SoundEvents_CM.WATER_SPLASH.get(), SoundSource.BLOCKS, 0.5F, 1.2F); }
	
	
	/* Sound Only */
	public static void soundAmado(Level worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.AMADO_CANCEL.get(), SoundSource.BLOCKS, 1.0F, 1.0F); }
	
	public static void soundAmadoWin(Level worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.AMADO_CANCEL.get(), SoundSource.BLOCKS, 0.8F, 1.1F); }


	public static void soundBottleFill(Level worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents.BOTTLE_FILL, SoundSource.PLAYERS, 0.7F, 1.0F); } //keep
	
	public static void soundBubble(Level worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents.BUBBLE_COLUMN_BUBBLE_POP, SoundSource.BLOCKS, 2.0F, 0.8F); }
	
	public static void soundBucketFill(Level worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents.BUCKET_FILL, SoundSource.PLAYERS, 0.7F, 1.0F); }

	public static void soundDrink(Level worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.GOKU.get(), SoundSource.PLAYERS, 1.0F, 1.0F); }
	
	public static void soundEat(Level worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.PAKU.get(), SoundSource.PLAYERS, 1.0F, 1.0F); }

	public static void soundFlint(Level worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, 0.8F); }
	
	public static void soundFireExting(Level worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 0.2F, 2.0F); }

	public static void soundFish(Level worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents.FISH_SWIM, SoundSource.NEUTRAL, 0.3F, 1.0F); }
	
	public static void soundFusumaL(Level worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.FUSUMA.get(), SoundSource.BLOCKS, 1.0F, 1.0F); }
	
	public static void soundFusumaS(Level worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.FUSUMA_SHORT.get(), SoundSource.BLOCKS, 1.0F, 1.0F); }


	public static void soundHikidoL(Level worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.HIKIDO.get(), SoundSource.BLOCKS, 1.0F, 1.0F); }
	
	public static void soundHikidoS(Level worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.HIKIDO_SHORT.get(), SoundSource.BLOCKS, 0.7F, 1.0F); }


	public static void soundItemPick(Level worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents.ITEM_PICKUP, SoundSource.PLAYERS, 0.2F, 2.0F); }
	
	public static void soundKinuzure(Level worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.KINUZURE.get(), SoundSource.BLOCKS, 1.0F, 1.0F); }
	
	public static void soundKotePlace(Level worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents.METAL_HIT, SoundSource.BLOCKS, 0.8F, 3.0F); }
	
	public static void soundOpenOven(Level worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.OPEN_OVEN.get(), SoundSource.BLOCKS, 0.8F, 1.0F); }

	
	public static void soundSakeBottleFill(Level worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents.BOTTLE_FILL, SoundSource.PLAYERS, 0.7F, 0.8F); }
	
	public static void soundSitChair(Level worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.SIT_CHAIR.get(), SoundSource.BLOCKS, 1.0F, 1.0F); }
	
	public static void soundSnowBreak(Level worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents.SNOW_BREAK, SoundSource.BLOCKS, 1.0F, 0.8F); }

	public static void soundSnowPlace(Level worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents.SNOW_PLACE, SoundSource.BLOCKS, 0.7F, 1.2F); } //keep
	
	public static void soundStoneButton_Off(Level worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents.STONE_BUTTON_CLICK_OFF, SoundSource.BLOCKS, 0.8F, 0.65F); }
	
	public static void soundStoneButton_On(Level worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents.STONE_BUTTON_CLICK_ON, SoundSource.BLOCKS, 1.0F, 0.8F); }
	
	public static void soundStoneBreak(Level worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents.STONE_BREAK, SoundSource.BLOCKS, 1.0F, 0.8F); }
	
	public static void soundStonePlace(Level worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents.STONE_PLACE, SoundSource.BLOCKS, 1.0F, 0.8F); }
	
	
	public static void soundTakeSakeBottle(Level worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents.ITEM_PICKUP, SoundSource.PLAYERS, 0.2F, 2.0F);
		worldIn.playSound(null, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 0.7F, 0.8F); }
	
	public static void soundTake_Pick(Level worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents.SNOW_BREAK, SoundSource.BLOCKS, 0.8F, 1.2F);
		worldIn.playSound(null, pos, SoundEvents.ITEM_PICKUP, SoundSource.PLAYERS, 0.2F, 2.0F); }
		
	public static void soundTouchBlock(Level worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.TOUCH_BLOCK.get(), SoundSource.BLOCKS, 1.0F, 0.75F); }

	
	public static void soundWaterUse(Level worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.WATER_SPLASH.get(), SoundSource.PLAYERS, 0.5F, 1.2F); }
	
	public static void soundWin_Open(Level worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.WINDOW_OPEN.get(), SoundSource.BLOCKS, 0.8F, 1.1F); }
	
	public static void soundWin_Close(Level worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.WINDOW_CLOSE.get(), SoundSource.BLOCKS, 0.8F, 1.1F); }
	
	public static void soundWin_OpenL(Level worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.WINDOW_OPEN.get(), SoundSource.BLOCKS, 1.0F, 1.0F); }
	
	public static void soundWin_CloseL(Level worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.WINDOW_CLOSE.get(), SoundSource.BLOCKS, 1.0F, 1.0F); }

	
	public static void soundWoodPlace(Level worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents.WOOD_PLACE, SoundSource.BLOCKS, 1.0F, 0.8F); }

	public static void soundWoolPlace(Level worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents.WOOL_PLACE, SoundSource.BLOCKS, 1.0F, 0.8F); }


	public static void wadaikoTop(Level worldIn, BlockPos pos, float volume, float pitch) {
		worldIn.playSound(null, pos, SoundEvents_CM.WADAIKO_TOP.get(), SoundSource.BLOCKS, volume, pitch); }
	
	public static void wadaikoSide(Level worldIn, BlockPos pos, float volume, float pitch) {
		worldIn.playSound(null, pos, SoundEvents_CM.WADAIKO_SIDE.get(), SoundSource.BLOCKS, volume, pitch); }
	
	public static void soundCurtain(Level worldIn, BlockPos pos, float volume, float pitch) {
		worldIn.playSound(null, pos, SoundEvents_CM.CURTAIN.get(), SoundSource.BLOCKS, volume, pitch); }
	
	
	/* Sound & Message */
	public static void textEarlyCollect(Level worldIn, BlockPos pos, Player playerIn) {
		worldIn.playSound(null, pos, SoundEvents_CM.TOUCH_BLOCK.get(), SoundSource.BLOCKS, 1.0F, 0.75F);
		playerIn.displayClientMessage(Component.translatable("text.chinjufumod.rightclick.earlycollect"), true); }
	
	public static void textEarlyUse(Level worldIn, BlockPos pos, Player playerIn) {
		worldIn.playSound(null, pos, SoundEvents_CM.TOUCH_BLOCK.get(), SoundSource.BLOCKS, 1.0F, 0.75F);
		playerIn.displayClientMessage(Component.translatable("text.chinjufumod.rightclick.earlyuse"), true); }
	
	public static void textFullItem(Level worldIn, BlockPos pos, Player playerIn) {
		worldIn.playSound(null, pos, SoundEvents_CM.TOUCH_BLOCK.get(), SoundSource.BLOCKS, 1.0F, 0.75F);
		playerIn.displayClientMessage(Component.translatable("text.chinjufumod.rightclick.fullitem"), true); }
	
	public static void textNoPlace(Level worldIn, BlockPos pos, Player playerIn) {
		worldIn.playSound(null, pos, SoundEvents_CM.TOUCH_BLOCK.get(), SoundSource.BLOCKS, 1.0F, 0.75F);
		playerIn.displayClientMessage(Component.translatable("text.chinjufumod.rightclick.noplace"), true); }
	
	public static void textNotEnough_Items(Level worldIn, BlockPos pos, Player playerIn) {
		worldIn.playSound(null, pos, SoundEvents_CM.TOUCH_BLOCK.get(), SoundSource.BLOCKS, 1.0F, 0.75F);
		playerIn.displayClientMessage(Component.translatable("text.chinjufumod.rightclick.notenough_items"), true); }
	
	public static void textNotHave(Level worldIn, BlockPos pos, Player playerIn) {
		worldIn.playSound(null, pos, SoundEvents_CM.TOUCH_BLOCK.get(), SoundSource.BLOCKS, 1.0F, 0.75F);
		playerIn.displayClientMessage(Component.translatable("text.chinjufumod.rightclick.nothave"), true); }
	
	public static void textNotSneak(Level worldIn, BlockPos pos, Player playerIn) {
		worldIn.playSound(null, pos, SoundEvents_CM.TOUCH_BLOCK.get(), SoundSource.BLOCKS, 1.0F, 0.75F);
		playerIn.displayClientMessage(Component.translatable("text.chinjufumod.rightclick.notsneak"), true); }
	
	public static void textIsBlocked(Level worldIn, BlockPos pos, Player playerIn) {
		worldIn.playSound(null, pos, SoundEvents_CM.TOUCH_BLOCK.get(), SoundSource.BLOCKS, 1.0F, 0.75F);
		playerIn.displayClientMessage(Component.translatable("text.chinjufumod.rightclick.blocked"), true); }

	public static void textIsEmpty(Level worldIn, BlockPos pos, Player playerIn) {
		worldIn.playSound(null, pos, SoundEvents_CM.TOUCH_BLOCK.get(), SoundSource.BLOCKS, 1.0F, 0.75F);
		playerIn.displayClientMessage(Component.translatable("text.chinjufumod.rightclick.empty"), true); }
	
	public static void textIsSleeping(Level worldIn, BlockPos pos, Player playerIn) {
		worldIn.playSound(null, pos, SoundEvents_CM.TOUCH_BLOCK.get(), SoundSource.BLOCKS, 1.0F, 0.75F);
		playerIn.displayClientMessage(Component.translatable("text.chinjufumod.rightclick.sleeping"), true); }
	
	public static void textIsWaterlogged(Level worldIn, BlockPos pos, Player playerIn) {
		worldIn.playSound(null, pos, SoundEvents_CM.TOUCH_BLOCK.get(), SoundSource.BLOCKS, 1.0F, 0.75F);
		playerIn.displayClientMessage(Component.translatable("text.chinjufumod.rightclick.waterlogged"), true); }
	
	public static void textRequestHeat(Level worldIn, BlockPos pos, Player playerIn) {
		worldIn.playSound(null, pos, SoundEvents_CM.TOUCH_BLOCK.get(), SoundSource.BLOCKS, 1.0F, 0.75F);
		playerIn.displayClientMessage(Component.translatable("text.chinjufumod.rightclick.heat"), true); }
	
	public static void textRequestCool(Level worldIn, BlockPos pos, Player playerIn) {
		worldIn.playSound(null, pos, SoundEvents_CM.TOUCH_BLOCK.get(), SoundSource.BLOCKS, 1.0F, 0.75F);
		playerIn.displayClientMessage(Component.translatable("text.chinjufumod.rightclick.cool"), true); }
	
	public static void textNotEnough_EXP(Level worldIn, BlockPos pos, Player playerIn) {
		worldIn.playSound(null, pos, SoundEvents_CM.TOUCH_BLOCK.get(), SoundSource.BLOCKS, 1.0F, 0.75F);
		playerIn.displayClientMessage(Component.translatable("text.chinjufumod.rightclick.notenough_exp"), true); }
	
	public static void textNotDig(Player playerIn) {
		playerIn.displayClientMessage(Component.translatable("text.chinjufumod.rightclick.notdig"), true); }
	
	
	/** Sound & Message & add Item **/
	public static void takeKinoko(Level worldIn, BlockPos pos, Player playerIn) {
		worldIn.playSound(null, pos, SoundEvents.SNOW_BREAK, SoundSource.BLOCKS, 0.8F, 1.2F);
		worldIn.playSound(null, pos, SoundEvents.ITEM_PICKUP, SoundSource.PLAYERS, 0.2F, 2.0F);
		playerIn.getInventory().add(new ItemStack(Items.BROWN_MUSHROOM, 1)); }
	
	public static void takeSakana(Level worldIn, BlockPos pos, Player playerIn) {
		worldIn.playSound(null, pos, SoundEvents.SNOW_BREAK, SoundSource.BLOCKS, 0.8F, 1.2F);
		worldIn.playSound(null, pos, SoundEvents.ITEM_PICKUP, SoundSource.PLAYERS, 0.2F, 2.0F);
		playerIn.getInventory().add(new ItemStack(Items_Teatime.KUSHI_SAKANA_C.get())); }

	
	/** Item consumption by mode. **/
	public static void Consume_1Item(Player playerIn, InteractionHand hand) {
		ItemStack stack = playerIn.getItemInHand(hand);
		boolean mode = playerIn.getAbilities().instabuild;
		if (!mode) { stack.shrink(1); }
		if (mode) { } }
	
	public static void Consume1Item_Bottle(Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand) {
		ItemStack stack = playerIn.getItemInHand(hand);
		boolean mode = playerIn.getAbilities().instabuild;
		if (!mode) { stack.shrink(1); }
		if (mode) { } 
		worldIn.playSound(null, pos, SoundEvents.BOTTLE_FILL, SoundSource.PLAYERS, 0.7F, 1.0F); }
	
	public static void Consume1Item_Bowl(Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand) {
		ItemStack stack = playerIn.getItemInHand(hand);
		boolean mode = playerIn.getAbilities().instabuild;
		if (!mode) { stack.shrink(1); }
		if (mode) { } 
		worldIn.playSound(null, pos, SoundEvents.BUCKET_FILL, SoundSource.PLAYERS, 0.8F, 1.2F); }
	
	public static void Consume1Item_Cheese(Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand) {
		ItemStack stack = playerIn.getItemInHand(hand);
		boolean mode = playerIn.getAbilities().instabuild;
		if (!mode) { stack.shrink(1); }
		if (mode) { } 
		worldIn.playSound(null, pos, SoundEvents.WOOD_PLACE, SoundSource.BLOCKS, 1.0F, 1.2F); }
	
	public static void Consume1Item_Dish(Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand) {
		ItemStack stack = playerIn.getItemInHand(hand);
		boolean mode = playerIn.getAbilities().instabuild;
		if (!mode) { stack.shrink(1); }
		if (mode) { } 
		worldIn.playSound(null, pos, SoundEvents.GLASS_PLACE, SoundSource.BLOCKS, 1.0F, 3.0F); }
	
	public static void Consume1Item_Flint(Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand) {
		ItemStack stack = playerIn.getItemInHand(hand);
		boolean mode = playerIn.getAbilities().instabuild;
		if (!mode) { stack.shrink(1); }
		if (mode) { } 
		worldIn.playSound(null, pos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, 0.8F); }
	
	public static void Consume1Item_SnowB(Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand) {
		ItemStack stack = playerIn.getItemInHand(hand);
		boolean mode = playerIn.getAbilities().instabuild;
		if (!mode) { stack.shrink(1); }
		if (mode) { } 
		worldIn.playSound(null, pos, SoundEvents.SNOW_BREAK, SoundSource.BLOCKS, 1.0F, 0.8F); }
	
	public static void Consume1Item_SnowP(Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand) {
		ItemStack stack = playerIn.getItemInHand(hand);
		boolean mode = playerIn.getAbilities().instabuild;
		if (!mode) { stack.shrink(1); }
		if (mode) { } 
		worldIn.playSound(null, pos, SoundEvents.SNOW_PLACE, SoundSource.BLOCKS, 0.8F, 1.2F); }
	
	public static void Consume1Item_Splash(Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand) {
		ItemStack stack = playerIn.getItemInHand(hand);
		boolean mode = playerIn.getAbilities().instabuild;
		if (!mode) { stack.shrink(1); }
		if (mode) { } 
		worldIn.playSound(null, pos, SoundEvents_CM.WATER_SPLASH.get(), SoundSource.PLAYERS, 0.5F, 1.2F); }
	
	public static void Consume1Item_Stone(Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand) {
		ItemStack stack = playerIn.getItemInHand(hand);
		boolean mode = playerIn.getAbilities().instabuild;
		if (!mode) { stack.shrink(1); }
		if (mode) { } 
		worldIn.playSound(null, pos, SoundEvents.STONE_PLACE, SoundSource.BLOCKS, 1.0F, 0.8F); }
	
	public static void Consume1Item_Tea(Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand) {
		ItemStack stack = playerIn.getItemInHand(hand);
		boolean mode = playerIn.getAbilities().instabuild;
		if (!mode) { stack.shrink(1); }
		if (mode) { } 
		worldIn.playSound(null, pos, SoundEvents_CM.TEA.get(), SoundSource.PLAYERS, 1.0F, 1.0F); }
	
	public static void Consume1Item_Wood(Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand) {
		ItemStack stack = playerIn.getItemInHand(hand);
		boolean mode = playerIn.getAbilities().instabuild;
		if (!mode) { stack.shrink(1); }
		if (mode) { } 
		worldIn.playSound(null, pos, SoundEvents.WOOD_PLACE, SoundSource.BLOCKS, 1.0F, 0.8F); }
	
	public static void Consume1Item_WDish(Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand) {
		ItemStack stack = playerIn.getItemInHand(hand);
		boolean mode = playerIn.getAbilities().instabuild;
		if (!mode) { stack.shrink(1); }
		if (mode) { } 
		worldIn.playSound(null, pos, SoundEvents.WOOD_PLACE, SoundSource.BLOCKS, 1.0F, 3.0F); }
	
	public static void Consume1Item_Write(Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand) {
		ItemStack stack = playerIn.getItemInHand(hand);
		boolean mode = playerIn.getAbilities().instabuild;
		if (!mode) { stack.shrink(1); }
		if (mode) { } 
		worldIn.playSound(null, pos, SoundEvents_CM.WRITE_REPORT.get(), SoundSource.BLOCKS, 1.0F, 1.0F); }
	
	
	public static void Consume_4Item(Player playerIn, InteractionHand hand) {
		ItemStack stack = playerIn.getItemInHand(hand);
		boolean mode = playerIn.getAbilities().instabuild;
		if (!mode) { stack.shrink(4); }
		if (mode) { } }
	
	public static void Consume_8Item(Player playerIn, InteractionHand hand) {
		ItemStack stack = playerIn.getItemInHand(hand);
		boolean mode = playerIn.getAbilities().instabuild;
		if (!mode) { stack.shrink(8); }
		if (mode) { } }
	
	public static void WaterBucket_Empty(Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand) {
		ItemStack stack = playerIn.getItemInHand(hand);
		boolean mode = playerIn.getAbilities().instabuild;
		
		if (!mode) { stack.shrink(1);
			if (stack.isEmpty()) { playerIn.getInventory().add(new ItemStack(Items.BUCKET)); }
			else if (!playerIn.getInventory().add(new ItemStack(Items.BUCKET))) {
				playerIn.drop(new ItemStack(Items.BUCKET), false); } }
		if (mode) { } 
		
		worldIn.playSound(null, pos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F); }
	
	public static void MIZUOKEfull_Empty(Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand) {
		ItemStack stack = playerIn.getItemInHand(hand);
		boolean mode = playerIn.getAbilities().instabuild;
		
		if (!mode) { stack.shrink(1);
			if (stack.isEmpty()) { playerIn.getInventory().add(new ItemStack(Items_Teatime.MIZUOKE.get())); }
			else if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.MIZUOKE.get()))) {
				playerIn.drop(new ItemStack(Items_Teatime.MIZUOKE.get()), false); } }
		if (mode) { } 
		
		worldIn.playSound(null, pos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F); }
	
	
	public static void SoysauceTo2(Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand) {
		ItemStack stack = playerIn.getItemInHand(hand);
		boolean mode = playerIn.getAbilities().instabuild;
		
		if (!mode) { stack.shrink(1);
			if (stack.isEmpty()) { playerIn.getInventory().add(new ItemStack(Items_NoTab.SHOUYU_bot_2.get())); }
			else if (!playerIn.getInventory().add(new ItemStack(Items_NoTab.SHOUYU_bot_2.get()))) {
				playerIn.drop(new ItemStack(Items_NoTab.SHOUYU_bot_2.get()), false); } }
		if (mode) { } 
		
		worldIn.playSound(null, pos, SoundEvents_CM.SHOUYU.get(), SoundSource.BLOCKS, 1.0F, 1.0F); }
	
	public static void SoysauceTo3(Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand) {
		ItemStack stack = playerIn.getItemInHand(hand);
		boolean mode = playerIn.getAbilities().instabuild;
		
		if (!mode) { stack.shrink(1);
			if (stack.isEmpty()) { playerIn.getInventory().add(new ItemStack(Items_NoTab.SHOUYU_bot_3.get())); }
			else if (!playerIn.getInventory().add(new ItemStack(Items_NoTab.SHOUYU_bot_3.get()))) {
				playerIn.drop(new ItemStack(Items_NoTab.SHOUYU_bot_3.get()), false); } }
		if (mode) { } 
		
		worldIn.playSound(null, pos, SoundEvents_CM.SHOUYU.get(), SoundSource.BLOCKS, 1.0F, 1.0F); }
	
	public static void SoysauceTo4(Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand) {
		ItemStack stack = playerIn.getItemInHand(hand);
		boolean mode = playerIn.getAbilities().instabuild;
		
		if (!mode) { stack.shrink(1);
			if (stack.isEmpty()) { playerIn.getInventory().add(new ItemStack(Items_NoTab.SHOUYU_bot_4.get())); }
			else if (!playerIn.getInventory().add(new ItemStack(Items_NoTab.SHOUYU_bot_4.get()))) {
				playerIn.drop(new ItemStack(Items_NoTab.SHOUYU_bot_4.get()), false); } }
		if (mode) { } 
		
		worldIn.playSound(null, pos, SoundEvents_CM.SHOUYU.get(), SoundSource.BLOCKS, 1.0F, 1.0F); }
	
	public static void SoysauceToBottle(Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand) {
		ItemStack stack = playerIn.getItemInHand(hand);
		boolean mode = playerIn.getAbilities().instabuild;
		
		if (!mode) { stack.shrink(1);
			if (stack.isEmpty()) { playerIn.getInventory().add(new ItemStack(Items.GLASS_BOTTLE)); }
			else if (!playerIn.getInventory().add(new ItemStack(Items.GLASS_BOTTLE))) {
				playerIn.drop(new ItemStack(Items.GLASS_BOTTLE), false); } }
		if (mode) { } 
		
		worldIn.playSound(null, pos, SoundEvents_CM.SHOUYU.get(), SoundSource.BLOCKS, 1.0F, 1.0F); }
	
	public static void Use_BoneMeal(Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand) {
		ItemStack stack = playerIn.getItemInHand(hand);
		boolean mode = playerIn.getAbilities().instabuild;
		if (!mode) { stack.shrink(1); }
		if (mode) { }
		
		worldIn.playSound(null, pos, SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS, 1.0F, 1.0F); }
}
