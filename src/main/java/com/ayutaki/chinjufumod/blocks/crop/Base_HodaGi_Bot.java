package com.ayutaki.chinjufumod.blocks.crop;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage4_FaceWater;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_NoTab;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
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
import net.minecraftforge.common.ToolType;

public class Base_HodaGi_Bot extends BaseStage4_FaceWater {
	
	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.box(5.0D, 0.0D, 4.0D, 11.0D, 12.0D, 15.0D);
	protected static final VoxelShape AABB_WEST = Block.box(1.0D, 0.0D, 5.0D, 12.0D, 12.0D, 11.0D);
	protected static final VoxelShape AABB_NORTH = Block.box(5.0D, 0.0D, 1.0D, 11.0D, 12.0D, 12.0D);
	protected static final VoxelShape AABB_EAST = Block.box(4.0D, 0.0D, 5.0D, 15.0D, 12.0D, 11.0D);
	
	public Base_HodaGi_Bot(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* TickRandom */
	private boolean inShade(ServerWorld worldIn, BlockPos pos) {
		return ((worldIn.canSeeSky(pos) && !worldIn.isDay()) || (!worldIn.canSeeSky(pos) && worldIn.getRawBrightness(pos, 0) <= 11));
	}

	/* 個体差は大きいが簡易な .tickRandomly() 一晩当たりの成長速度から rand.nextInt(8) == 0 */
	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		int i = state.getValue(STAGE_1_4);

		if (!worldIn.isAreaLoaded(pos, 1)) { return; }

		if (state.getValue(WATERLOGGED) == false) {
			if (i != 4) {
				if (inShade(worldIn, pos) && rand.nextInt(8) == 0) {
					worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3); } }
			
			if (i == 4) { }
		}
		
		if (state.getValue(WATERLOGGED) != false) {
			if (i != 1) {
				if (rand.nextInt(2) == 0) {
					CMEvents.soundSnowBreak(worldIn, pos);
					worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(1)), 3);
					this.dropRottenfood(worldIn, pos); } }
			
			if (i == 1) { }
		}
	}

	protected void dropRottenfood(ServerWorld worldIn, BlockPos pos) {
		ItemStack stack = new ItemStack(Items_NoTab.ROTTEN_FOOD);
		InventoryHelper.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.getValue(H_FACING);
		
		switch (direction) {
		case NORTH:
		default: return AABB_NORTH;
		case SOUTH: return AABB_SOUTH;
		case WEST: return AABB_WEST;
		case EAST: return AABB_EAST;
		} // switch
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.HODAGI);
	}
	
	/* Destroy at the same time. & Drop item. */
	@Override
	public void playerWillDestroy(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {

		BlockState upState = worldIn.getBlockState(pos.above());
		/** False is not Drop. **/
		if (upState.getBlock() instanceof Base_HodaGi_Top) {
			worldIn.destroyBlock(pos.above(), false); }
		
		super.playerWillDestroy(worldIn, pos, state, playerIn);
	}
	
	/* The best harvesting tool. */
	@Nullable
	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.AXE;
	}

	@Override
	public int getHarvestLevel(BlockState state) {
		return 0;
	}
	
	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_hodagi_a_bot").withStyle(TextFormatting.GRAY));
	}
}
