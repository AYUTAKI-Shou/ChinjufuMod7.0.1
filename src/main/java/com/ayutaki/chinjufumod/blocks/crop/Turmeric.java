package com.ayutaki.chinjufumod.blocks.crop;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Turmeric extends CropsBlock {

	/* Collision */
	protected static final VoxelShape[] SHAPES = new VoxelShape[]{ Block.box(4.0D, -1.0D, 4.0D, 12.0D, 1.0D, 12.0D),
			Block.box(4.0D, -1.0D, 4.0D, 12.0D, 2.0D, 12.0D),
			Block.box(4.0D, -1.0D, 4.0D, 12.0D, 3.0D, 12.0D),
			Block.box(4.0D, -1.0D, 4.0D, 12.0D, 5.0D, 12.0D),
			Block.box(4.0D, -1.0D, 4.0D, 12.0D, 7.0D, 12.0D),
			Block.box(4.0D, -1.0D, 4.0D, 12.0D, 11.0D, 12.0D),
			Block.box(4.0D, -1.0D, 4.0D, 12.0D, 11.0D, 12.0D),
			Block.box(4.0D, -1.0D, 4.0D, 12.0D, 11.0D, 12.0D) };

	public Turmeric(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* Limit the place. */
	@Override
	protected boolean mayPlaceOn(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return state.getBlock() instanceof FarmlandBlock;
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();

		float temp = worldIn.getBiome(pos).getTemperature(pos);
		PlayerEntity playerIn = context.getPlayer();

		if (temp >= 0.5F) { return this.defaultBlockState(); }
		
		else {
			playerIn.displayClientMessage(new TranslationTextComponent("text.chinjufumod.too_cold"), true);
			return null; }
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPES[state.getValue(this.getAgeProperty())];
	}

	/* Clone Item in Creative. */
	@Override
	protected IItemProvider getBaseSeedId() {
		return Items_Teatime.SEEDS_TURMERIC;
	}
	
	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		float temp = worldIn.getBiome(pos).getTemperature(pos);
		if (temp < 0.5F && rand.nextInt(1) == 0) {
			worldIn.destroyBlock(pos, true); }
		
		super.randomTick(state, worldIn, pos, rand);
	}
	
	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.item_seeds_turmeric").withStyle(TextFormatting.GRAY));
		tooltip.add(new TranslationTextComponent("tips.item_crop_pepperdry").withStyle(TextFormatting.GRAY));
	}
}
