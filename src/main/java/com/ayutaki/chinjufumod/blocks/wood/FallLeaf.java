package com.ayutaki.chinjufumod.blocks.wood;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.registry.Wood_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.GrassBlock;
import net.minecraft.block.SnowBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.lighting.LightEngine;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

public class FallLeaf extends GrassBlock {

	public FallLeaf(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();

		if (item instanceof ShovelItem) {
			stack.damageItem(1, playerIn, user -> { user.sendBreakAnimation(hand); } );
			worldIn.playSound(null, pos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
			worldIn.setBlockState(pos, Blocks.GRASS_PATH.getDefaultState());
			return ActionResultType.SUCCESS; }

		if (item instanceof HoeItem) {
			stack.damageItem(1, playerIn, user -> { user.sendBreakAnimation(hand); } );
			worldIn.playSound(null, pos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
			worldIn.setBlockState(pos, Wood_Blocks.SUIDEN.getDefaultState());
			return ActionResultType.SUCCESS; }

		/* Mobs spawn.のため PASS */
		return ActionResultType.PASS;
	}


	/* Conditions to grow. */
	private static boolean getUpBlockState(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockPos upPos = pos.up();
		BlockState upState = worldIn.getBlockState(upPos);
		if (upState.getBlock() == Blocks.SNOW && upState.get(SnowBlock.LAYERS) == 1) {
			return true;
		}
		else {
		int i = LightEngine.func_215613_a(worldIn, state, pos, upState, upPos, Direction.UP, upState.getOpacity(worldIn, upPos));
			return i < worldIn.getMaxLightLevel();
		}
	}

	private static boolean getUpBlockFluid(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockPos upPos = pos.up();
		return getUpBlockState(state, worldIn, pos) && !worldIn.getFluidState(upPos).isTagged(FluidTags.WATER);
	}

	/* TickRandom */
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		if (!getUpBlockState(state, worldIn, pos)) {
			if (!worldIn.isAreaLoaded(pos, 3)) return;
			worldIn.setBlockState(pos, Blocks.DIRT.getDefaultState());
		}

		else {
			if (worldIn.getLight(pos.up()) >= 9) {
				BlockState defaultState = this.getDefaultState();

				for(int i = 0; i < 4; ++i) {
					BlockPos nearPos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);
					/** 付近の土ブロックを落ち葉ブロックに変える **/
					if (worldIn.getBlockState(nearPos).getBlock() == Blocks.DIRT && getUpBlockFluid(defaultState, worldIn, nearPos)) {
						worldIn.setBlockState(nearPos, defaultState.with(SNOWY, Boolean.valueOf(worldIn.getBlockState(nearPos.up()).getBlock() == Blocks.SNOW)));
					}
				}
			}
		}
	}

	/* バイオーム生成時に、木や草が生えるようにする -> forge:dirt タグに追加する必要がある */
	@Override
	public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing, net.minecraftforge.common.IPlantable plantable) {
		return true;
	}

	/* Mobs spawn. */
	@Override
	public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type) {
		return true;
	}

	/* The best harvesting tool. */
	@Nullable
	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.SHOVEL;
	}

	@Override
	public int getHarvestLevel(BlockState state) {
		return 0;
	}
	
	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_fall_leaf").applyTextStyle(TextFormatting.GRAY));
	}
}
