package com.ayutaki.chinjufumod.blocks.hakkou;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

public class Taru_Hakkou extends CM_WaterLogged {

	/* Property */
	public static final IntegerProperty STAGE_0_5 = IntegerProperty.create("stage", 0, 5);

	/* Collision */
	protected static final VoxelShape AABB_BOX = VoxelShapes.or(Block.box(0.0D, 12.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.box(0.25D, 8.0D, 0.25D, 15.75D, 12.0D, 15.75D),
			Block.box(0.5D, 4.0D, 0.5D, 15.5D, 8.0D, 15.5D),
			Block.box(0.75D, 0.0D, 0.75D, 15.25D, 4.0D, 15.25D));
	protected static final VoxelShape AABB_TANA = VoxelShapes.or(Block.box(0.0D, 2.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 2.0D, 2.0D, 2.0D),
			Block.box(0.0D, 0.0D, 14.0D, 2.0D, 2.0D, 16.0D),
			Block.box(14.0D, 0.0D, 0.0D, 16.0D, 2.0D, 2.0D),
			Block.box(14.0D, 0.0D, 14.0D, 16.0D, 2.0D, 16.0D));

	/** 0=空、1=麹の空棚、2=味噌の空樽、3=紅茶の空棚、4=浅漬けの空樽、5=白菜漬の空樽 **/
	public Taru_Hakkou(AbstractBlock.Properties properties) {
		super(properties);
		registerDefaultState(this.defaultBlockState().setValue(STAGE_0_5, Integer.valueOf(0))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		int i = state.getValue(STAGE_0_5);

		int gc = stack.getCount();

		/** Hand is empty. **/
		if (stack.isEmpty()) {
			if (i == 1) {
				CMEvents.soundTake_Pick(worldIn, pos);
				playerIn.inventory.add(new ItemStack(Items_Seasonal.TANMONO, 4));
	
				worldIn.setBlock(pos, state.setValue(STAGE_0_5, Integer.valueOf(3)), 3); }
			
			if (i == 0 || i == 3) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			
			if (i != 0 && i != 1 && i != 3) { CMEvents.textIsEmpty(worldIn, pos, playerIn); }
		}

		/** Hand is not empty. **/
		if (!stack.isEmpty()) {
			
			if (i == 0 || i == 3) { 
				if (!state.getValue(WATERLOGGED)) {
					/* Empty barrel */
					if (i == 0) {
						if (item == Items_Teatime.SAKEBOT) {
							/** Collect with an Item **/
							CMEvents.Consume1Item_Dish(worldIn, pos, playerIn, hand);
							CMEvents.soundSakeBottleFill(worldIn, pos);
							
							worldIn.setBlock(pos, Hakkou_Blocks.JUKUSEI_TARU.defaultBlockState()
									.setValue(Taru_Jukusei.STAGE_0_5, Integer.valueOf(0)), 3); }
						
						if (item != Items_Teatime.SAKEBOT) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					} //i == 1
					
					/* Dry shelf */
					if (i == 3) {
						
						if (item == Items_Teatime.CHADUTSU) {
							CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
							
							worldIn.setBlock(pos, Hakkou_Blocks.KOUCHA_TARU.defaultBlockState()
									.setValue(Tana_Koucha.STAGE_0_5, Integer.valueOf(0)), 3); }
						
						if (item == Items_Teatime.CHABA_GREEN && gc >= 8) {
							/* Consume 8 Items. */
							CMEvents.Consume_8Item(playerIn, hand);
							CMEvents.soundSnowPlace(worldIn, pos);
							
							worldIn.setBlock(pos, Hakkou_Blocks.KOUCHA_TARU.defaultBlockState()
									.setValue(Tana_Koucha.STAGE_0_5, Integer.valueOf(0)), 3); }
						
						if (item == Items.BROWN_MUSHROOM && gc >= 8) {
							/* Consume 8 Items. */
							CMEvents.Consume_8Item(playerIn, hand);
							CMEvents.soundSnowPlace(worldIn, pos);
							
							worldIn.setBlock(pos, Hakkou_Blocks.KINOKO_TARU.defaultBlockState()
									.setValue(Tana_Kinoko.STAGE_0_5, Integer.valueOf(0)), 3); }
						
						if (item == Items.KELP && gc >= 4) {
							/** Consume 4 Items. **/
							CMEvents.Consume_4Item(playerIn, hand);
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, Hakkou_Blocks.KONBU_TARU.defaultBlockState()
									.setValue(Tana_Konbu.STAGE_0_5, Integer.valueOf(0)), 3); }
						
						if (item == Items_Teatime.NORI_N && gc >= 8) {
							/* Consume 8 Items. */
							CMEvents.Consume_8Item(playerIn, hand);
							CMEvents.soundSnowPlace(worldIn, pos);
							
							worldIn.setBlock(pos, Hakkou_Blocks.NORI_TARU.defaultBlockState()
									.setValue(Tana_Nori.STAGE_0_5, Integer.valueOf(0)), 3); }
						
						if (item == Items_Teatime.PEPPER_RAW && gc >= 8) {
							/* Consume 8 Items. */
							CMEvents.Consume_8Item(playerIn, hand);
							CMEvents.soundSnowPlace(worldIn, pos);
							
							worldIn.setBlock(pos, Hakkou_Blocks.PEPPER_TARU.defaultBlockState()
									.setValue(Tana_Pepper.STAGE_0_5, Integer.valueOf(0)), 3); }
						
						if ((item == Items_Teatime.CHABA_GREEN && gc < 8) || (item == Items.BROWN_MUSHROOM && gc < 8) ||
								(item == Items.KELP && gc < 4) || (item == Items_Teatime.NORI_N && gc < 8) || (item == Items_Teatime.PEPPER_RAW && gc < 8)) {
							CMEvents.textNotEnough_Items(worldIn, pos, playerIn); }
						
						if (item != Items_Teatime.CHADUTSU && item != Items_Teatime.CHABA_GREEN && item != Items.BROWN_MUSHROOM &&
								item != Items.KELP && item != Items_Teatime.NORI_N && item != Items_Teatime.PEPPER_RAW) { 
							CMEvents.textNotHave(worldIn, pos, playerIn); }
					} //i == 3
				} //It is not Waterlogged.
				
				if (state.getValue(WATERLOGGED)) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn);
				}
			} //i == 0 || i == 3
			
			if (i != 0 && i != 3) { CMEvents.textIsEmpty(worldIn, pos, playerIn); }
		}

		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* Gives a value when placed. */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);
		
		return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER));
	}

	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.getValue(WATERLOGGED)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
		}
		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}

	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(STAGE_0_5, WATERLOGGED);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		int i = state.getValue(STAGE_0_5);
		return (i == 1 || i == 3)? AABB_TANA : AABB_BOX;
	}

	/* Flammable Block */
	@Override
	public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face) { return true; }

	@Override
	public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) { return 5; }

	@Override
	public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) { return 20; }
	
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
		tooltip.add(new TranslationTextComponent("tips.block_taru_hakkou").withStyle(TextFormatting.GRAY));
	}
}
