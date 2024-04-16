package com.ayutaki.chinjufumod.blocks.season;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class SnowMan extends Base_SnowMan {

	/* Property */
	/** 1=normai, 2=carrot, 3=Roma, 4=blank **/
	public static final IntegerProperty STAGE_1_4 = IntegerProperty.create("stage", 1, 4);

	public SnowMan(AbstractBlock.Properties properties) {
		super(properties);
		/** Default state **/
		registerDefaultState(this.defaultBlockState().setValue(H_FACING, Direction.NORTH)
				.setValue(HALF, DoubleBlockHalf.LOWER)
				.setValue(STAGE_1_4, Integer.valueOf(1))
				.setValue(DOWN, Boolean.valueOf(false))
				.setValue(WATERLOGGED, false));
	}

	/* RightClick Action */
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {
		
		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		
		/** 1=normai, 2=carrot, 3=Roma, 4=blank **/
		int i = state.getValue(STAGE_1_4);
		DoubleBlockHalf half = state.getValue(HALF);
		
		BlockState upState = this.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
				.setValue(HALF, DoubleBlockHalf.UPPER)
				.setValue(STAGE_1_4, Integer.valueOf(i))
				.setValue(WATERLOGGED, state.getValue(WATERLOGGED));
		BlockState downState = this.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
				.setValue(HALF, DoubleBlockHalf.LOWER)
				.setValue(DOWN, state.getValue(DOWN))
				.setValue(WATERLOGGED, state.getValue(WATERLOGGED));
		
		boolean mode = playerIn.abilities.instabuild;
		BlockState colorup = Seasonal_Blocks.SNOWMAN_COLOR.defaultBlockState()
				.setValue(SnowMan_Color.H_FACING, state.getValue(H_FACING))
				.setValue(SnowMan_Color.HALF, DoubleBlockHalf.UPPER)
				.setValue(SnowMan_Color.DOWN, state.getValue(DOWN))
				.setValue(SnowMan_Color.WATERLOGGED, state.getValue(WATERLOGGED));
		BlockState colordown = Seasonal_Blocks.SNOWMAN_COLOR.defaultBlockState()
				.setValue(SnowMan_Color.H_FACING, state.getValue(H_FACING))
				.setValue(SnowMan_Color.HALF, DoubleBlockHalf.LOWER)
				.setValue(SnowMan_Color.DOWN, state.getValue(DOWN))
				.setValue(SnowMan_Color.WATERLOGGED, state.getValue(WATERLOGGED));
		
		switch (half) {
		case LOWER:
		default:
			if (!state.getValue(DOWN)) {
				if (item == Items.SNOW) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlock(pos.above(), upState.setValue(DOWN, Boolean.valueOf(true)), 3);
					worldIn.setBlock(pos, state.setValue(DOWN, Boolean.valueOf(true)), 3); }
				
				if (item != Items.SNOW) { CMEvents.textNotHave(worldIn, pos, playerIn); } }
			
			if (state.getValue(DOWN)) { }
			break;

		case UPPER:
			switch (i) {
			case 1:
			default:
				if (item == Items.CARROT) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(2)), 3);
					worldIn.setBlock(pos.below(), downState.setValue(STAGE_1_4, Integer.valueOf(2)), 3); }
				
				if (item != Items.CARROT) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				break;

			/** 1=normai, 2=carrot, 3=Roma, 4=blank **/
			/** White=1, Orange=2, Magenta=3, LightBlue=4, Yellow=5, Lime=6, Pink=7, Gray=8, **/
			/** LightGray=9, Cyan=10, Purple=11, Blue=12, Brown=13, Green=14, Red=15, Black=16 **/
			case 2:
				if (item == Items_Teatime.FOOD_TOMATO) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(3)), 3);
					worldIn.setBlock(pos.below(), downState.setValue(STAGE_1_4, Integer.valueOf(3)), 3); }
				
				if (item == Items.BUCKET) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(4)), 3);
					worldIn.setBlock(pos.below(), downState.setValue(STAGE_1_4, Integer.valueOf(4)), 3); }
				
				if (item == Items.WHITE_WOOL) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlock(pos, colorup.setValue(SnowMan_Color.STAGE_1_16, Integer.valueOf(1)), 3);
					worldIn.setBlock(pos.below(), colordown.setValue(SnowMan_Color.STAGE_1_16, Integer.valueOf(1)), 3); }
				
				if (item == Items.ORANGE_WOOL) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlock(pos, colorup.setValue(SnowMan_Color.STAGE_1_16, Integer.valueOf(2)), 3);
					worldIn.setBlock(pos.below(), colordown.setValue(SnowMan_Color.STAGE_1_16, Integer.valueOf(2)), 3); }
				
				if (item == Items.MAGENTA_WOOL) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlock(pos, colorup.setValue(SnowMan_Color.STAGE_1_16, Integer.valueOf(3)), 3);
					worldIn.setBlock(pos.below(), colordown.setValue(SnowMan_Color.STAGE_1_16, Integer.valueOf(3)), 3); }
				
				if (item == Items.LIGHT_BLUE_WOOL) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlock(pos, colorup.setValue(SnowMan_Color.STAGE_1_16, Integer.valueOf(4)), 3);
					worldIn.setBlock(pos.below(), colordown.setValue(SnowMan_Color.STAGE_1_16, Integer.valueOf(4)), 3); }
				
				if (item == Items.YELLOW_WOOL) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlock(pos, colorup.setValue(SnowMan_Color.STAGE_1_16, Integer.valueOf(5)), 3);
					worldIn.setBlock(pos.below(), colordown.setValue(SnowMan_Color.STAGE_1_16, Integer.valueOf(5)), 3); }
				
				if (item == Items.LIME_WOOL) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlock(pos, colorup.setValue(SnowMan_Color.STAGE_1_16, Integer.valueOf(6)), 3);
					worldIn.setBlock(pos.below(), colordown.setValue(SnowMan_Color.STAGE_1_16, Integer.valueOf(6)), 3); }
				
				if (item == Items.PINK_WOOL) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlock(pos, colorup.setValue(SnowMan_Color.STAGE_1_16, Integer.valueOf(7)), 3);
					worldIn.setBlock(pos.below(), colordown.setValue(SnowMan_Color.STAGE_1_16, Integer.valueOf(7)), 3); }
				
				if (item == Items.GRAY_WOOL) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlock(pos, colorup.setValue(SnowMan_Color.STAGE_1_16, Integer.valueOf(8)), 3);
					worldIn.setBlock(pos.below(), colordown.setValue(SnowMan_Color.STAGE_1_16, Integer.valueOf(8)), 3); }
				
				if (item == Items.LIGHT_GRAY_WOOL) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlock(pos, colorup.setValue(SnowMan_Color.STAGE_1_16, Integer.valueOf(9)), 3);
					worldIn.setBlock(pos.below(), colordown.setValue(SnowMan_Color.STAGE_1_16, Integer.valueOf(9)), 3); }
				
				if (item == Items.CYAN_WOOL) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlock(pos, colorup.setValue(SnowMan_Color.STAGE_1_16, Integer.valueOf(10)), 3);
					worldIn.setBlock(pos.below(), colordown.setValue(SnowMan_Color.STAGE_1_16, Integer.valueOf(10)), 3); }
				
				if (item == Items.PURPLE_WOOL) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlock(pos, colorup.setValue(SnowMan_Color.STAGE_1_16, Integer.valueOf(11)), 3);
					worldIn.setBlock(pos.below(), colordown.setValue(SnowMan_Color.STAGE_1_16, Integer.valueOf(11)), 3); }
				
				if (item == Items.BLUE_WOOL) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlock(pos, colorup.setValue(SnowMan_Color.STAGE_1_16, Integer.valueOf(12)), 3);
					worldIn.setBlock(pos.below(), colordown.setValue(SnowMan_Color.STAGE_1_16, Integer.valueOf(12)), 3); }
				
				if (item == Items.BROWN_WOOL) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlock(pos, colorup.setValue(SnowMan_Color.STAGE_1_16, Integer.valueOf(13)), 3);
					worldIn.setBlock(pos.below(), colordown.setValue(SnowMan_Color.STAGE_1_16, Integer.valueOf(13)), 3); }
				
				if (item == Items.GREEN_WOOL) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlock(pos, colorup.setValue(SnowMan_Color.STAGE_1_16, Integer.valueOf(14)), 3);
					worldIn.setBlock(pos.below(), colordown.setValue(SnowMan_Color.STAGE_1_16, Integer.valueOf(14)), 3); }
				
				if (item == Items.RED_WOOL) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlock(pos, colorup.setValue(SnowMan_Color.STAGE_1_16, Integer.valueOf(15)), 3);
					worldIn.setBlock(pos.below(), colordown.setValue(SnowMan_Color.STAGE_1_16, Integer.valueOf(15)), 3); }
				
				if (item == Items.BLACK_WOOL) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlock(pos, colorup.setValue(SnowMan_Color.STAGE_1_16, Integer.valueOf(16)), 3);
					worldIn.setBlock(pos.below(), colordown.setValue(SnowMan_Color.STAGE_1_16, Integer.valueOf(16)), 3); }
				
				if (item != Items_Teatime.FOOD_TOMATO && item != Items.BUCKET &&
						item != Items.WHITE_WOOL && item != Items.ORANGE_WOOL && item != Items.MAGENTA_WOOL && item != Items.LIGHT_BLUE_WOOL && 
						item != Items.YELLOW_WOOL && item != Items.LIME_WOOL && item != Items.PINK_WOOL && item != Items.GRAY_WOOL && 
						item != Items.LIGHT_GRAY_WOOL && item != Items.CYAN_WOOL && item != Items.PURPLE_WOOL && item != Items.BLUE_WOOL && 
						item != Items.BROWN_WOOL && item != Items.GREEN_WOOL && item != Items.RED_WOOL && item != Items.BLACK_WOOL) { 
					CMEvents.textNotHave(worldIn, pos, playerIn); }
				break;

			case 3:
				if (stack.isEmpty()) {
					CMEvents.soundSnowBreak(worldIn, pos);
					
					if (!mode) {
						if (stack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items_Teatime.FOOD_TOMATO)); }
						else if (!playerIn.inventory.add(new ItemStack(Items_Teatime.FOOD_TOMATO))) {
							playerIn.drop(new ItemStack(Items_Teatime.FOOD_TOMATO), false); } }
					if (mode) { } 
				
					worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(2)), 3);
					worldIn.setBlock(pos.below(), downState.setValue(STAGE_1_4, Integer.valueOf(2)), 3); }
				
				if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
				break;
				
			case 4:
				if (stack.isEmpty()) {
					CMEvents.soundSnowBreak(worldIn, pos);
					
					if (!mode) {
						if (stack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items.BUCKET)); }
						else if (!playerIn.inventory.add(new ItemStack(Items.BUCKET))) {
							playerIn.drop(new ItemStack(Items.BUCKET), false); } }
					if (mode) { } 
				
					worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(2)), 3);
					worldIn.setBlock(pos.below(), downState.setValue(STAGE_1_4, Integer.valueOf(2)), 3); }
				
				if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
				break;
			} // switch STAGE_1_4
			break;
		} // switch LOWER-UPPER
		
		return ActionResultType.SUCCESS;
	}

	/* Gives a value when placed. */
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = worldIn.getFluidState(pos);
		Block blockIn = worldIn.getBlockState(pos).getBlock();
		
		/** pos.up() = Replaceable block. **/
		if (pos.getY() < 255 && worldIn.getBlockState(pos.above()).canBeReplaced(context)) {
			
			if (blockIn == Blocks.SNOW) {
				return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER))
						.setValue(H_FACING, context.getHorizontalDirection().getOpposite())
						.setValue(STAGE_1_4, Integer.valueOf(1))
						.setValue(DOWN, Boolean.valueOf(true)); }
			
			else {
				return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER))
						.setValue(H_FACING, context.getHorizontalDirection().getOpposite())
						.setValue(STAGE_1_4, Integer.valueOf(1))
						.setValue(DOWN, Boolean.valueOf(false)); }
		}

		else { return null; }
	}

	/* Add DoubleBlockHalf.UPPER on the Block. */
	public void setPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		FluidState fluidUp = worldIn.getFluidState(pos.above());

		worldIn.setBlock(pos.above(), this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER)
				.setValue(H_FACING, state.getValue(H_FACING))
				.setValue(STAGE_1_4, Integer.valueOf(1))
				.setValue(DOWN, state.getValue(DOWN))
				.setValue(WATERLOGGED, Boolean.valueOf(fluidUp.getType() == Fluids.WATER)), 3);
	}
	
	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(DOWN, H_FACING, HALF, STAGE_1_4, WATERLOGGED);
	}
}
