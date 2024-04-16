package com.ayutaki.chinjufumod.blocks.season;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tags.FluidTags;
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

	public SnowMan(Block.Properties properties) {
		super(properties);
		/** Default state **/
		setDefaultState(this.stateContainer.getBaseState().with(H_FACING, Direction.NORTH)
				.with(HALF, DoubleBlockHalf.LOWER)
				.with(STAGE_1_4, Integer.valueOf(1))
				.with(DOWN, Boolean.valueOf(false))
				.with(WATERLOGGED, false));
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {
		
		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		
		/** 1=normai, 2=carrot, 3=Roma, 4=blank **/
		int i = state.get(STAGE_1_4);
		DoubleBlockHalf half = state.get(HALF);
		
		BlockState upState = this.getDefaultState().with(H_FACING, state.get(H_FACING))
				.with(HALF, DoubleBlockHalf.UPPER)
				.with(STAGE_1_4, Integer.valueOf(i))
				.with(WATERLOGGED, state.get(WATERLOGGED));
		BlockState downState = this.getDefaultState().with(H_FACING, state.get(H_FACING))
				.with(HALF, DoubleBlockHalf.LOWER)
				.with(DOWN, state.get(DOWN))
				.with(WATERLOGGED, state.get(WATERLOGGED));
		
		boolean mode = playerIn.abilities.isCreativeMode;
		BlockState colorUp = Seasonal_Blocks.SNOWMAN_COLOR.getDefaultState()
				.with(SnowMan_Color.H_FACING, state.get(H_FACING))
				.with(SnowMan_Color.HALF, DoubleBlockHalf.UPPER)
				.with(SnowMan_Color.DOWN, state.get(DOWN))
				.with(SnowMan_Color.WATERLOGGED, state.get(WATERLOGGED));
		BlockState colorDown = Seasonal_Blocks.SNOWMAN_COLOR.getDefaultState()
				.with(SnowMan_Color.H_FACING, state.get(H_FACING))
				.with(SnowMan_Color.HALF, DoubleBlockHalf.LOWER)
				.with(SnowMan_Color.DOWN, state.get(DOWN))
				.with(SnowMan_Color.WATERLOGGED, state.get(WATERLOGGED));
	
		switch (half) {
		case LOWER:
		default:
			if (!state.get(DOWN)) {
				if (item == Items.SNOW) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos.up(), upState.with(DOWN, Boolean.valueOf(true)), 3);
					worldIn.setBlockState(pos, state.with(DOWN, Boolean.valueOf(true)), 3); }
				
				if (item != Items.SNOW) { CMEvents.textNotHave(worldIn, pos, playerIn); } }

			if (state.get(DOWN)) { }
			break;

		case UPPER:
			switch (i) {
			case 1:
			default:
				if (item == Items.CARROT) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(2)), 3);
					worldIn.setBlockState(pos.down(), downState.with(STAGE_1_4, Integer.valueOf(2)), 3); }
				
				if (item != Items.CARROT) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				break;

			/** 1=normai, 2=carrot, 3=Roma, 4=blank **/
			/** White=1, Orange=2, Magenta=3, LightBlue=4, Yellow=5, Lime=6, Pink=7, Gray=8, **/
			/** LightGray=9, Cyan=10, Purple=11, Blue=12, Brown=13, Green=14, Red=15, Black=16 **/
			case 2:
				if (item == Items_Teatime.FOOD_TOMATO) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(3)), 3);
					worldIn.setBlockState(pos.down(), downState.with(STAGE_1_4, Integer.valueOf(3)), 3); }
				
				if (item == Items.BUCKET) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(4)), 3);
					worldIn.setBlockState(pos.down(), downState.with(STAGE_1_4, Integer.valueOf(4)), 3); }
				
				if (item == Items.WHITE_WOOL) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, colorUp.with(SnowMan_Color.STAGE_1_16, Integer.valueOf(1)), 3);
					worldIn.setBlockState(pos.down(), colorDown.with(SnowMan_Color.STAGE_1_16, Integer.valueOf(1)), 3); }
				
				if (item == Items.ORANGE_WOOL) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, colorUp.with(SnowMan_Color.STAGE_1_16, Integer.valueOf(2)), 3);
					worldIn.setBlockState(pos.down(), colorDown.with(SnowMan_Color.STAGE_1_16, Integer.valueOf(2)), 3); }
				
				if (item == Items.MAGENTA_WOOL) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, colorUp.with(SnowMan_Color.STAGE_1_16, Integer.valueOf(3)), 3);
					worldIn.setBlockState(pos.down(), colorDown.with(SnowMan_Color.STAGE_1_16, Integer.valueOf(3)), 3); }
				
				if (item == Items.LIGHT_BLUE_WOOL) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, colorUp.with(SnowMan_Color.STAGE_1_16, Integer.valueOf(4)), 3);
					worldIn.setBlockState(pos.down(), colorDown.with(SnowMan_Color.STAGE_1_16, Integer.valueOf(4)), 3); }
				
				if (item == Items.YELLOW_WOOL) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, colorUp.with(SnowMan_Color.STAGE_1_16, Integer.valueOf(5)), 3);
					worldIn.setBlockState(pos.down(), colorDown.with(SnowMan_Color.STAGE_1_16, Integer.valueOf(5)), 3); }
				
				if (item == Items.LIME_WOOL) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, colorUp.with(SnowMan_Color.STAGE_1_16, Integer.valueOf(6)), 3);
					worldIn.setBlockState(pos.down(), colorDown.with(SnowMan_Color.STAGE_1_16, Integer.valueOf(6)), 3); }
				
				if (item == Items.PINK_WOOL) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, colorUp.with(SnowMan_Color.STAGE_1_16, Integer.valueOf(7)), 3);
					worldIn.setBlockState(pos.down(), colorDown.with(SnowMan_Color.STAGE_1_16, Integer.valueOf(7)), 3); }
				
				if (item == Items.GRAY_WOOL) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, colorUp.with(SnowMan_Color.STAGE_1_16, Integer.valueOf(8)), 3);
					worldIn.setBlockState(pos.down(), colorDown.with(SnowMan_Color.STAGE_1_16, Integer.valueOf(8)), 3); }
				
				if (item == Items.LIGHT_GRAY_WOOL) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, colorUp.with(SnowMan_Color.STAGE_1_16, Integer.valueOf(9)), 3);
					worldIn.setBlockState(pos.down(), colorDown.with(SnowMan_Color.STAGE_1_16, Integer.valueOf(9)), 3); }
				
				if (item == Items.CYAN_WOOL) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, colorUp.with(SnowMan_Color.STAGE_1_16, Integer.valueOf(10)), 3);
					worldIn.setBlockState(pos.down(), colorDown.with(SnowMan_Color.STAGE_1_16, Integer.valueOf(10)), 3); }
				
				if (item == Items.PURPLE_WOOL) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, colorUp.with(SnowMan_Color.STAGE_1_16, Integer.valueOf(11)), 3);
					worldIn.setBlockState(pos.down(), colorDown.with(SnowMan_Color.STAGE_1_16, Integer.valueOf(11)), 3); }
				
				if (item == Items.BLUE_WOOL) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, colorUp.with(SnowMan_Color.STAGE_1_16, Integer.valueOf(12)), 3);
					worldIn.setBlockState(pos.down(), colorDown.with(SnowMan_Color.STAGE_1_16, Integer.valueOf(12)), 3); }
				
				if (item == Items.BROWN_WOOL) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, colorUp.with(SnowMan_Color.STAGE_1_16, Integer.valueOf(13)), 3);
					worldIn.setBlockState(pos.down(), colorDown.with(SnowMan_Color.STAGE_1_16, Integer.valueOf(13)), 3); }
				
				if (item == Items.GREEN_WOOL) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, colorUp.with(SnowMan_Color.STAGE_1_16, Integer.valueOf(14)), 3);
					worldIn.setBlockState(pos.down(), colorDown.with(SnowMan_Color.STAGE_1_16, Integer.valueOf(14)), 3); }
				
				if (item == Items.RED_WOOL) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, colorUp.with(SnowMan_Color.STAGE_1_16, Integer.valueOf(15)), 3);
					worldIn.setBlockState(pos.down(), colorDown.with(SnowMan_Color.STAGE_1_16, Integer.valueOf(15)), 3); }
				
				if (item == Items.BLACK_WOOL) {
					CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, colorUp.with(SnowMan_Color.STAGE_1_16, Integer.valueOf(16)), 3);
					worldIn.setBlockState(pos.down(), colorDown.with(SnowMan_Color.STAGE_1_16, Integer.valueOf(16)), 3); }
				
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
						if (stack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.FOOD_TOMATO)); }
						else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.FOOD_TOMATO))) {
							playerIn.dropItem(new ItemStack(Items_Teatime.FOOD_TOMATO), false); } }
					if (mode) { } 
				
					worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(2)), 3);
					worldIn.setBlockState(pos.down(), downState.with(STAGE_1_4, Integer.valueOf(2)), 3); }
				
				if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
				break;
				
			case 4:
				if (stack.isEmpty()) {
					CMEvents.soundSnowBreak(worldIn, pos);
					
					if (!mode) {
						if (stack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items.BUCKET)); }
						else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.BUCKET))) {
							playerIn.dropItem(new ItemStack(Items.BUCKET), false); } }
					if (mode) { } 
				
					worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(2)), 3);
					worldIn.setBlockState(pos.down(), downState.with(STAGE_1_4, Integer.valueOf(2)), 3); }
				
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
		World worldIn = context.getWorld();
		BlockPos pos = context.getPos();
		IFluidState fluid = worldIn.getFluidState(pos);
		Block blockIn = worldIn.getBlockState(pos).getBlock();
	
		/** pos.up() = Replaceable block. **/
		if (pos.getY() < 255 && worldIn.getBlockState(pos.up()).isReplaceable(context)) {
			
			if (blockIn == Blocks.SNOW) {
				return this.getDefaultState().with(WATERLOGGED, fluid.getFluid() == Fluids.WATER)
						.with(H_FACING, context.getPlacementHorizontalFacing().getOpposite())
						.with(STAGE_1_4, Integer.valueOf(1))
						.with(DOWN, Boolean.valueOf(true)); }
			
			else {
				return this.getDefaultState().with(WATERLOGGED, fluid.getFluid() == Fluids.WATER)
						.with(H_FACING, context.getPlacementHorizontalFacing().getOpposite())
						.with(STAGE_1_4, Integer.valueOf(1))
						.with(DOWN, Boolean.valueOf(false)); }
		}

		else { return null; }
	}
	
	/* Add DoubleBlockHalf.UPPER on the Block. */
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		IFluidState fluidUp = worldIn.getFluidState(pos.up());

		worldIn.setBlockState(pos.up(), this.getDefaultState().with(HALF, DoubleBlockHalf.UPPER)
				.with(H_FACING, state.get(H_FACING))
				.with(STAGE_1_4, Integer.valueOf(1))
				.with(DOWN, state.get(DOWN))
				.with(WATERLOGGED, Boolean.valueOf(fluidUp.isTagged(FluidTags.WATER))), 3);
	}
	
	/* Create Blockstate */
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(DOWN, H_FACING, HALF, STAGE_1_4, WATERLOGGED);
	}
}
