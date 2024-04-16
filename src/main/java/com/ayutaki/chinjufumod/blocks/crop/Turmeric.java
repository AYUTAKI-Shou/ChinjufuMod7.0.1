package com.ayutaki.chinjufumod.blocks.crop;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Turmeric extends CropBlock {

	/* Collision */
	protected static final VoxelShape[] SHAPES = new VoxelShape[]{ Block.box(4.0D, -1.0D, 4.0D, 12.0D, 1.0D, 12.0D),
			Block.box(4.0D, -1.0D, 4.0D, 12.0D, 2.0D, 12.0D),
			Block.box(4.0D, -1.0D, 4.0D, 12.0D, 3.0D, 12.0D),
			Block.box(4.0D, -1.0D, 4.0D, 12.0D, 5.0D, 12.0D),
			Block.box(4.0D, -1.0D, 4.0D, 12.0D, 7.0D, 12.0D),
			Block.box(4.0D, -1.0D, 4.0D, 12.0D, 11.0D, 12.0D),
			Block.box(4.0D, -1.0D, 4.0D, 12.0D, 11.0D, 12.0D),
			Block.box(4.0D, -1.0D, 4.0D, 12.0D, 11.0D, 12.0D) };

	public Turmeric(BlockBehaviour.Properties properties) {
		super(properties);
	}
	
	/* Limit the place. */
	@Override
	protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return state.getBlock() instanceof FarmBlock;
	}
	
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		Level worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();

		float temp = worldIn.getBiome(pos).value().getBaseTemperature();
		Player playerIn = context.getPlayer();

		if (temp >= 0.5F) { return this.defaultBlockState(); }
		
		else {
			playerIn.displayClientMessage(Component.translatable("text.chinjufumod.too_cold"), true);
			return null; }
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return SHAPES[state.getValue(this.getAgeProperty())];
	}
	
	/* Clone Item in Creative. */
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.SEEDS_TURMERIC.get());
	}
	
	@Override
	public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
		float temp = worldIn.getBiome(pos).value().getBaseTemperature();
		if (temp < 0.5F && rand.nextInt(1) == 0) {
			worldIn.destroyBlock(pos, true); }
		
		super.randomTick(state, worldIn, pos, rand);
	}
	
	/* ToolTip */
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.item_seeds_turmeric").withStyle(ChatFormatting.GRAY));
		tooltip.add(Component.translatable("tips.item_crop_pepperdry").withStyle(ChatFormatting.GRAY));
	}
}
