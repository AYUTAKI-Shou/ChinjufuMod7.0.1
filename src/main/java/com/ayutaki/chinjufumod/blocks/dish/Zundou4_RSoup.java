package com.ayutaki.chinjufumod.blocks.dish;

import java.util.Random;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Zundou4_RSoup extends BaseZundou_4Stage {

	public Zundou4_RSoup(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {
		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();

		int i = state.get(STAGE_1_4);
		boolean tare = (item == Items_Teatime.SHOUYU_TARE || item == Items_Teatime.MISO_TARE || item == Items_Teatime.SHIO_TARE);
		
		if (tare) {
			if (item == Items_Teatime.SHOUYU_TARE) {
				/** Collect with an Item **/
				CMEvents.Consume1Item_Bowl(worldIn, pos, playerIn, hand);

				if (stack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SHOUYU_Rsoup, 1)); }
				else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SHOUYU_Rsoup, 1))) {
					playerIn.dropItem(new ItemStack(Items_Teatime.SHOUYU_Rsoup, 1), false); } }
			
			if (item == Items_Teatime.MISO_TARE) { 
				CMEvents.Consume1Item_Bowl(worldIn, pos, playerIn, hand);

				if (stack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MISO_Rsoup, 1)); }
				else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MISO_Rsoup, 1))) {
					playerIn.dropItem(new ItemStack(Items_Teatime.MISO_Rsoup, 1), false); } }
			
			if (item == Items_Teatime.SHIO_TARE) { 
				CMEvents.Consume1Item_Bowl(worldIn, pos, playerIn, hand);

				if (stack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SHIO_Rsoup, 1)); }
				else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SHIO_Rsoup, 1))) {
					playerIn.dropItem(new ItemStack(Items_Teatime.SHIO_Rsoup, 1), false); } }

			if (i != 4) {
				worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i + 1)), 3); }

			if (i == 4) {
				worldIn.setBlockState(pos, Dish_Blocks.ZUNDOU.getDefaultState()
						.with(H_FACING, state.get(H_FACING))
						.with(Zundou.STAGE_1_2, Integer.valueOf(2)), 3); }
		}
		
		if (!tare && item != Items_Teatime.SHOUYU_Rsoup && item != Items_Teatime.MISO_Rsoup && item != Items_Teatime.SHIO_Rsoup) {
			CMEvents.textNotHave(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		if (inWater(state, worldIn, pos)) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, this, 60);
			CMEvents.soundBubble(worldIn, pos);
			worldIn.setBlockState(pos, Dish_Blocks.ZUNDOU.getDefaultState()
					.with(H_FACING, state.get(H_FACING))
					.with(Zundou.STAGE_1_2, Integer.valueOf(2))
					.with(Zundou.WATERLOGGED, state.get(WATERLOGGED)), 3); }
		
		else { }
	}
	
	/* Play Sound and Particle */
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState state, World worldIn, BlockPos pos, Random rand) {

		double d0 = (double)pos.getX() + 0.5D;
		double d1 = (double)pos.getY() + 0.8D;
		double d2 = (double)pos.getZ() + 0.5D;
		double d4 = rand.nextDouble() * 0.6D - 0.3D;
		double d6 = rand.nextDouble() * 6.0D / 16.0D;

		if (isCooking(worldIn, pos)) {

			if (rand.nextDouble() < 0.1D) {
				worldIn.playSound(d0, d1, d2, SoundEvents_CM.GUTSUGUTSU, SoundCategory.BLOCKS, 0.3F, 0.7F, false); }

			if (rand.nextDouble() < 0.25D) {
				/** which. position x y z, speed x y z **/
				worldIn.addParticle(ParticleTypes.POOF, d0 + d4, d1 + d6, d2 + d4, 0.0D, 0.0D, 0.0D); }
		}
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.ZUNDOU_DASHI);
	}
}
