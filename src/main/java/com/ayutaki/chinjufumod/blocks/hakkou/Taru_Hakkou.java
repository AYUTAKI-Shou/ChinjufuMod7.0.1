package com.ayutaki.chinjufumod.blocks.hakkou;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Taru_Hakkou extends CM_WaterLogged {

	/* Property */
	public static final IntegerProperty STAGE_0_5 = IntegerProperty.create("stage", 0, 5);

	/* Collision */
	protected static final VoxelShape AABB_BOX = Shapes.or(Block.box(0.0D, 12.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.box(0.25D, 8.0D, 0.25D, 15.75D, 12.0D, 15.75D),
			Block.box(0.5D, 4.0D, 0.5D, 15.5D, 8.0D, 15.5D),
			Block.box(0.75D, 0.0D, 0.75D, 15.25D, 4.0D, 15.25D));
	protected static final VoxelShape AABB_TANA = Shapes.or(Block.box(0.0D, 2.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 2.0D, 2.0D, 2.0D),
			Block.box(0.0D, 0.0D, 14.0D, 2.0D, 2.0D, 16.0D),
			Block.box(14.0D, 0.0D, 0.0D, 16.0D, 2.0D, 2.0D),
			Block.box(14.0D, 0.0D, 14.0D, 16.0D, 2.0D, 16.0D));

	/** 0=空、1=麹の空棚、2=味噌の空樽、3=紅茶の空棚、4=浅漬けの空樽、5=白菜漬の空樽 **/
	public Taru_Hakkou(BlockBehaviour.Properties properties) {
		super(properties);
		/** Default state **/
		registerDefaultState(this.stateDefinition.any().setValue(STAGE_0_5, Integer.valueOf(0))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		int i = state.getValue(STAGE_0_5);

		int gc = stack.getCount();

		/** Hand is empty. **/
		if (stack.isEmpty()) {
			if (i == 1) {
				CMEvents.soundTake_Pick(worldIn, pos);
				playerIn.getInventory().add(new ItemStack(Items_Seasonal.TANMONO.get(), 4));
	
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
						if (item == Items_Teatime.SAKEBOT.get()) {
							/** Collect with an Item **/
							CMEvents.Consume1Item_Dish(worldIn, pos, playerIn, hand);
							CMEvents.soundSakeBottleFill(worldIn, pos);
							
							worldIn.setBlock(pos, Hakkou_Blocks.JUKUSEI_TARU.get().defaultBlockState()
									.setValue(Taru_Jukusei.STAGE_0_5, Integer.valueOf(0)), 3); }
						
						if (item != Items_Teatime.SAKEBOT.get()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					} //i == 1
					
					/* Dry shelf */
					if (i == 3) {
						
						if (item == Items_Teatime.CHADUTSU.get()) {
							CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
							
							worldIn.setBlock(pos, Hakkou_Blocks.KOUCHA_TARU.get().defaultBlockState()
									.setValue(Tana_Koucha.STAGE_0_5, Integer.valueOf(0)), 3); }
						
						if (item == Items_Teatime.CHABA_GREEN.get() && gc >= 8) {
							/* Consume 8 Items. */
							CMEvents.Consume_8Item(playerIn, hand);
							CMEvents.soundSnowPlace(worldIn, pos);
							
							worldIn.setBlock(pos, Hakkou_Blocks.KOUCHA_TARU.get().defaultBlockState()
									.setValue(Tana_Koucha.STAGE_0_5, Integer.valueOf(0)), 3); }
						
						if (item == Items.BROWN_MUSHROOM && gc >= 8) {
							/* Consume 8 Items. */
							CMEvents.Consume_8Item(playerIn, hand);
							CMEvents.soundSnowPlace(worldIn, pos);
							
							worldIn.setBlock(pos, Hakkou_Blocks.KINOKO_TARU.get().defaultBlockState()
									.setValue(Tana_Kinoko.STAGE_0_5, Integer.valueOf(0)), 3); }
						
						if (item == Items.KELP && gc >= 4) {
							/** Consume 4 Items. **/
							CMEvents.Consume_4Item(playerIn, hand);
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, Hakkou_Blocks.KONBU_TARU.get().defaultBlockState()
									.setValue(Tana_Konbu.STAGE_0_5, Integer.valueOf(0)), 3); }
						
						if (item == Items_Teatime.NORI_N.get() && gc >= 8) {
							/* Consume 8 Items. */
							CMEvents.Consume_8Item(playerIn, hand);
							CMEvents.soundSnowPlace(worldIn, pos);
							
							worldIn.setBlock(pos, Hakkou_Blocks.NORI_TARU.get().defaultBlockState()
									.setValue(Tana_Nori.STAGE_0_5, Integer.valueOf(0)), 3); }
						
						if (item == Items_Teatime.PEPPER_RAW.get() && gc >= 8) {
							/* Consume 8 Items. */
							CMEvents.Consume_8Item(playerIn, hand);
							CMEvents.soundSnowPlace(worldIn, pos);
							
							worldIn.setBlock(pos, Hakkou_Blocks.PEPPER_TARU.get().defaultBlockState()
									.setValue(Tana_Pepper.STAGE_0_5, Integer.valueOf(0)), 3); }
						
						if ((item == Items_Teatime.CHABA_GREEN.get() && gc < 8) || (item == Items.BROWN_MUSHROOM && gc < 8) ||
								(item == Items.KELP && gc < 4) || (item == Items_Teatime.NORI_N.get() && gc < 8) || (item == Items_Teatime.PEPPER_RAW.get() && gc < 8)) {
							CMEvents.textNotEnough_Items(worldIn, pos, playerIn); }
						
						if (item != Items_Teatime.CHADUTSU.get() && item != Items_Teatime.CHABA_GREEN.get() && item != Items.BROWN_MUSHROOM && 
								item != Items.KELP && item != Items_Teatime.NORI_N.get() && item != Items_Teatime.PEPPER_RAW.get()) {
							CMEvents.textNotHave(worldIn, pos, playerIn); }
					} //i == 3
				} //It is not Waterlogged.
				
				if (state.getValue(WATERLOGGED)) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn);
				}
			} //i == 0 || i == 3
			
			if (i != 0 && i != 3) { CMEvents.textIsEmpty(worldIn, pos, playerIn); }
		}

		/** SUCCESS to not put anything on top. **/
		return InteractionResult.SUCCESS;
	}
	
	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		Level worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);

		return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER));		
	}
	
	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.getValue(WATERLOGGED)) {
			worldIn.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }
		
		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}
	
	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(STAGE_0_5, WATERLOGGED);
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		int i = state.getValue(STAGE_0_5);
		return (i == 1 || i == 3)? AABB_TANA : AABB_BOX;
	}
	
	/* Flammable Block */
	@Override
	public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction direct) { return true; }

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction direct) { return 5; }

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction direct) { return 20; }
	
	/* ToolTip */
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.block_taru_hakkou").withStyle(ChatFormatting.GRAY));
	}
}
