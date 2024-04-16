package com.ayutaki.chinjufumod.blocks.wood;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.registry.Wood_Blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.GrassBlock;
import net.minecraft.block.SnowBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
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

	public FallLeaf(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();

		if (item instanceof ShovelItem) {
			stack.hurtAndBreak(1, playerIn, user -> { user.broadcastBreakEvent(hand); } );
			worldIn.playSound(null, pos, SoundEvents.SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
			worldIn.setBlock(pos, Blocks.GRASS_PATH.defaultBlockState(), 3);
			return ActionResultType.SUCCESS;
		}

		if (item instanceof HoeItem) {
			stack.hurtAndBreak(1, playerIn, user -> { user.broadcastBreakEvent(hand); } );
			worldIn.playSound(null, pos, SoundEvents.HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
			worldIn.setBlock(pos, Wood_Blocks.SUIDEN.defaultBlockState(), 3);
			return ActionResultType.SUCCESS;
		}

		/* PASS for Mob Spawn. */
		return ActionResultType.PASS;
	}


	/* Conditions to grow. */
	private static boolean canBeGrass(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockPos upPos = pos.above();
		BlockState upState = worldIn.getBlockState(upPos);
		if (upState.getBlock() == Blocks.SNOW && upState.getValue(SnowBlock.LAYERS) == 1) {
			return true;
		}
		else {
		int i = LightEngine.getLightBlockInto(worldIn, state, pos, upState, upPos, Direction.UP, upState.getLightBlock(worldIn, upPos));
			return i < worldIn.getMaxLightLevel();
		}
	}

	private static boolean canPropagate(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockPos upPos = pos.above();
		return canBeGrass(state, worldIn, pos) && !worldIn.getFluidState(upPos).is(FluidTags.WATER);
	}

	/* TickRandom */
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		if (!canBeGrass(state, worldIn, pos)) {
			if (!worldIn.isAreaLoaded(pos, 3)) return;
			worldIn.setBlock(pos, Blocks.DIRT.defaultBlockState(), 3);
		}

		else {
			if (worldIn.getMaxLocalRawBrightness(pos.above()) >= 9) {
				BlockState defaultState = this.defaultBlockState();

				for(int i = 0; i < 4; ++i) {
					BlockPos nearPos = pos.offset(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);
					/** 付近の土ブロックを落ち葉ブロックに変える **/
					if (worldIn.getBlockState(nearPos).getBlock() == Blocks.DIRT && canPropagate(defaultState, worldIn, nearPos)) {
						worldIn.setBlock(nearPos, defaultState.setValue(SNOWY, Boolean.valueOf(worldIn.getBlockState(nearPos.above()).getBlock() == Blocks.SNOW)), 3);
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

	/* モブ湧き -> ReplaceSpawn でスポーンルールを改変 */
	@Override
	public boolean canCreatureSpawn(BlockState state, IBlockReader world, BlockPos pos, EntitySpawnPlacementRegistry.PlacementType type, @Nullable EntityType<?> entityType) {
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
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_fall_leaf").withStyle(TextFormatting.GRAY));
	}
}
