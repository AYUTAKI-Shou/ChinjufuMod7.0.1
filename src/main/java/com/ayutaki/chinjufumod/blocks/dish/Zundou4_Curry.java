package com.ayutaki.chinjufumod.blocks.dish;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
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
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Zundou4_Curry extends BaseZundou_4Stage {

	public Zundou4_Curry(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {
		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();

		int i = state.get(STAGE_1_4);

		if (item == Items_Teatime.RICE) {
			/** Collect with an Item **/
			CMEvents.Consume1Item_SnowB(worldIn, pos, playerIn, hand);

			if (stack.isEmpty()) { playerIn.inventory.addItemStackToInventory(this.takeRice()); }
			else if (!playerIn.inventory.addItemStackToInventory(this.takeRice())) {
				playerIn.dropItem(this.takeRice(), false); }

			if (i != 4) { worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i + 1))); }
			if (i == 4) {
				worldIn.setBlockState(pos, Dish_Blocks.ZUNDOU.getDefaultState().with(H_FACING, state.get(H_FACING))
						.with(Zundou.STAGE_1_2, Integer.valueOf(2))); }
		}
		
		if (item != Items_Teatime.RICE) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	private ItemStack takeRice() {
		if (this == Dish_Blocks.ZUNDOU_CURRY) { return new ItemStack(Items_Teatime.CURRY, 1); }
		if (this == Dish_Blocks.ZUNDOU_CURRY_C) { return new ItemStack(Items_Teatime.CURRY_C, 1); }
		if (this == Dish_Blocks.ZUNDOU_CURRY_T) { return new ItemStack(Items_Teatime.CURRY_T, 1); }
		return null;
	}
	
	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		if (inWater(state, worldIn, pos)) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, this, 60);
			CMEvents.soundSnowBreak(worldIn, pos);
			worldIn.setBlockState(pos, Dish_Blocks.ZUNDOU.getDefaultState()
					.with(Zundou.H_FACING, state.get(H_FACING))
					.with(Zundou.STAGE_1_2, Integer.valueOf(2))
					.with(Zundou.WATERLOGGED, state.get(WATERLOGGED)), 3);
			this.dropRottenfood(worldIn, pos); }
		
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
		return this.takeStack();
	}

	private ItemStack takeStack() {
		if (this == Dish_Blocks.ZUNDOU_CURRY) { return new ItemStack(Items_Teatime.ZUNDOU_CURRY, 1); }
		if (this == Dish_Blocks.ZUNDOU_CURRY_C) { return new ItemStack(Items_Teatime.ZUNDOU_CURRY_C, 1); }
		if (this == Dish_Blocks.ZUNDOU_CURRY_T) { return new ItemStack(Items_Teatime.ZUNDOU_CURRY_T, 1); }
		return null;
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_food_cunabe_1").applyTextStyle(TextFormatting.GRAY));
	}
}
