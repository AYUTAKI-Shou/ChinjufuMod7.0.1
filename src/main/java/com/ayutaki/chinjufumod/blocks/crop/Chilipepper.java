package com.ayutaki.chinjufumod.blocks.crop;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.registry.Items_Teatime;

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

public class Chilipepper extends CropsBlock {

	/* Collision */
	protected static final VoxelShape[] SHAPES = new VoxelShape[]{ Block.makeCuboidShape(2.0D, -1.0D, 2.0D, 14.0D, 1.0D, 14.0D),
			Block.makeCuboidShape(6.0D, -1.0D, 6.0D, 10.0D, 4.0D, 10.0D),
			Block.makeCuboidShape(5.0D, -1.0D, 5.0D, 11.0D, 6.0D, 11.0D),
			Block.makeCuboidShape(4.5D, -1.0D, 4.5D, 11.5D, 8.0D, 11.5D),
			Block.makeCuboidShape(4.0D, -1.0D, 4.0D, 12.0D, 11.5D, 12.0D),
			Block.makeCuboidShape(4.0D, -1.0D, 4.0D, 12.0D, 13.5D, 12.0D),
			Block.makeCuboidShape(4.0D, -1.0D, 4.0D, 12.0D, 14.0D, 12.0D),
			Block.makeCuboidShape(4.0D, -1.0D, 4.0D, 12.0D, 14.0D, 12.0D) };

	public Chilipepper(Block.Properties properties) {
		super(properties);
	}

	/* Limit the place. */
	@Override
	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return state.getBlock() instanceof FarmlandBlock;
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getWorld();
		BlockPos pos = context.getPos();

		float temp = worldIn.getBiome(pos).getTemperature(pos);
		PlayerEntity playerIn = context.getPlayer();

		if (temp >= 0.5F) { return this.getDefaultState(); }
		
		else {
			playerIn.sendStatusMessage(new TranslationTextComponent("text.chinjufumod.too_cold"), true);
			return null; }
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPES[state.get(this.getAgeProperty())];
	}

	/* Clone Item in Creative. */
	@Override
	protected IItemProvider getSeedsItem() {
		return Items_Teatime.SEEDS_CHILI;
	}
	
	/* TickRandom. add this.defaultBlockState() */
	@SuppressWarnings("deprecation")
	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		float temp = worldIn.getBiome(pos).getTemperature(pos);
		if (temp < 0.5F && rand.nextInt(1) == 0) {
			worldIn.destroyBlock(pos, true); }
		
		super.randomTick(state, worldIn, pos, rand);
	}
	
	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.item_seeds_turmeric").applyTextStyle(TextFormatting.GRAY));
	}
}
