package com.ayutaki.chinjufumod.blocks.dish;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Zundou4_RSoup extends BaseZundou_4Stage {

	/* 色が安定しないため flow は却下、still のみ */
	public Zundou4_RSoup(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action*/
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();

		int i = state.getValue(STAGE_1_4);
		boolean tare = (item == Items_Teatime.SHOUYU_TARE.get() || item == Items_Teatime.MISO_TARE.get() || item == Items_Teatime.SHIO_TARE.get());
		
		if (tare) {
			if (item == Items_Teatime.SHOUYU_TARE.get()) {
				/** Collect with an Item **/
				CMEvents.Consume1Item_Bowl(worldIn, pos, playerIn, hand);

				if (stack.isEmpty()) { playerIn.getInventory().add(new ItemStack(Items_Teatime.SHOUYU_Rsoup.get(), 1)); }
				else if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.SHOUYU_Rsoup.get(), 1))) {
					playerIn.drop(new ItemStack(Items_Teatime.SHOUYU_Rsoup.get(), 1), false); } }
			
			if (item == Items_Teatime.MISO_TARE.get()) { 
				CMEvents.Consume1Item_Bowl(worldIn, pos, playerIn, hand);

				if (stack.isEmpty()) { playerIn.getInventory().add(new ItemStack(Items_Teatime.MISO_Rsoup.get(), 1)); }
				else if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.MISO_Rsoup.get(), 1))) {
					playerIn.drop(new ItemStack(Items_Teatime.MISO_Rsoup.get(), 1), false); } }
			
			if (item == Items_Teatime.SHIO_TARE.get()) { 
				CMEvents.Consume1Item_Bowl(worldIn, pos, playerIn, hand);

				if (stack.isEmpty()) { playerIn.getInventory().add(new ItemStack(Items_Teatime.SHIO_Rsoup.get(), 1)); }
				else if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.SHIO_Rsoup.get(), 1))) {
					playerIn.drop(new ItemStack(Items_Teatime.SHIO_Rsoup.get(), 1), false); } }

			if (i != 4) {
				worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3); }

			if (i == 4) {
				worldIn.setBlock(pos, Dish_Blocks.ZUNDOU.get().defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(Zundou.STAGE_1_2, Integer.valueOf(2)), 3); }
		}
		
		if (!tare && item != Items_Teatime.SHOUYU_Rsoup.get() && item != Items_Teatime.MISO_Rsoup.get() && item != Items_Teatime.SHIO_Rsoup.get()) {
			CMEvents.textNotHave(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return InteractionResult.SUCCESS;
	}
	
	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
		if (inWater(state, worldIn, pos)) {
			worldIn.scheduleTick(pos, this, 60);
			CMEvents.soundBubble(worldIn, pos);
			worldIn.setBlock(pos, Dish_Blocks.ZUNDOU.get().defaultBlockState()
					.setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Zundou.STAGE_1_2, Integer.valueOf(2))
					.setValue(Zundou.WATERLOGGED, state.getValue(WATERLOGGED)), 3); }
		
		else { }
	}

	/* Play Sound・Particle */
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState state, Level worldIn, BlockPos pos, RandomSource rand) {
		double d0 = (double)pos.getX() + 0.5D;
		double d1 = (double)pos.getY() + 0.8D;
		double d2 = (double)pos.getZ() + 0.5D;
		double d4 = rand.nextDouble() * 0.6D - 0.3D;
		double d6 = rand.nextDouble() * 6.0D / 16.0D;

		if (isCooking(worldIn, pos)) {

			if (rand.nextDouble() < 0.1D) {
				worldIn.playLocalSound(d0, d1, d2, SoundEvents_CM.GUTSUGUTSU.get(), SoundSource.BLOCKS, 0.3F, 0.7F, false); }

			if (rand.nextDouble() < 0.25D) {
				/** which, position x y z, speed x y z **/
				worldIn.addParticle(ParticleTypes.POOF, d0 + d4, d1 + d6, d2 + d4, 0.0D, 0.0D, 0.0D); }
		}
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.ZUNDOU_RSOUP.get());
	}
}
