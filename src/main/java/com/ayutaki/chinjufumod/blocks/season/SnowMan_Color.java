package com.ayutaki.chinjufumod.blocks.season;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
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

public class SnowMan_Color extends Base_SnowMan {

	/* Property */
	/** White=1, Orange=2, Magenta=3, LightBlue=4, Yellow=5, Lime=6, Pink=7, Gray=8, **/
	/** LightGray=9, Cyan=10, Purple=11, Blue=12, Brown=13, Green=14, Red=15, Black=16 **/
	public static final IntegerProperty STAGE_1_16 = IntegerProperty.create("stage", 1, 16);

	public SnowMan_Color(AbstractBlock.Properties properties) {
		super(properties);
		/** Default state **/
		registerDefaultState(this.defaultBlockState().setValue(H_FACING, Direction.NORTH)
				.setValue(HALF, DoubleBlockHalf.LOWER)
				.setValue(STAGE_1_16, Integer.valueOf(1))
				.setValue(DOWN, Boolean.valueOf(false))
				.setValue(WATERLOGGED, false));
	}

	/* RightClick Action */
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {
		
		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();

		int i = state.getValue(STAGE_1_16);
		DoubleBlockHalf half = state.getValue(HALF);
		BlockState upState = this.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
				.setValue(HALF, DoubleBlockHalf.UPPER)
				.setValue(WATERLOGGED, state.getValue(WATERLOGGED))
				.setValue(STAGE_1_16, Integer.valueOf(i));
		
		boolean mode = playerIn.abilities.instabuild;
		
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

		/** White=1, Orange=2, Magenta=3, LightBlue=4, Yellow=5, Lime=6, Pink=7, Gray=8, **/
		/** LightGray=9, Cyan=10, Purple=11, Blue=12, Brown=13, Green=14, Red=15, Black=16 **/
		case UPPER:
			if (stack.isEmpty()) {
				CMEvents.soundSnowBreak(worldIn, pos);
				worldIn.setBlock(pos, Seasonal_Blocks.SNOWMAN.defaultBlockState()
						.setValue(SnowMan.H_FACING, state.getValue(H_FACING))
						.setValue(SnowMan.HALF, DoubleBlockHalf.UPPER)
						.setValue(SnowMan.DOWN, state.getValue(DOWN))
						.setValue(SnowMan.WATERLOGGED, state.getValue(WATERLOGGED))
						.setValue(SnowMan.STAGE_1_4, Integer.valueOf(2)), 3);
				worldIn.setBlock(pos.below(), Seasonal_Blocks.SNOWMAN.defaultBlockState()
						.setValue(SnowMan.H_FACING, state.getValue(H_FACING))
						.setValue(SnowMan.HALF, DoubleBlockHalf.LOWER)
						.setValue(SnowMan.DOWN, state.getValue(DOWN))
						.setValue(SnowMan.WATERLOGGED, state.getValue(WATERLOGGED))
						.setValue(SnowMan.STAGE_1_4, Integer.valueOf(2)), 3);
	
				if (mode) { }
				
				if (!mode) {
					if (stack.isEmpty()) { playerIn.inventory.add(this.takeWool(state)); }
					else if (!playerIn.inventory.add(this.takeWool(state))) { playerIn.drop(this.takeWool(state), false); }
				} //!mode
			} //stack.isEmpty()
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		} // switch LOWER-UPPER
		
		return ActionResultType.SUCCESS;
	}

	private ItemStack takeWool(BlockState state) {
		int i = state.getValue(STAGE_1_16);
		if (i == 1) { return new ItemStack(Items.WHITE_WOOL); }
		if (i == 2) { return new ItemStack(Items.ORANGE_WOOL); }
		if (i == 3) { return new ItemStack(Items.MAGENTA_WOOL); }
		if (i == 4) { return new ItemStack(Items.LIGHT_BLUE_WOOL); }
		if (i == 5) { return new ItemStack(Items.YELLOW_WOOL); }
		if (i == 6) { return new ItemStack(Items.LIME_WOOL); }
		if (i == 7) { return new ItemStack(Items.PINK_WOOL); }
		if (i == 8) { return new ItemStack(Items.GRAY_WOOL); }
		if (i == 9) { return new ItemStack(Items.LIGHT_GRAY_WOOL); }
		if (i == 10) { return new ItemStack(Items.CYAN_WOOL); }
		if (i == 11) { return new ItemStack(Items.PURPLE_WOOL); }
		if (i == 12) { return new ItemStack(Items.BLUE_WOOL); }
		if (i == 13) { return new ItemStack(Items.BROWN_WOOL); }
		if (i == 14) { return new ItemStack(Items.GREEN_WOOL); }
		if (i == 15) { return new ItemStack(Items.RED_WOOL); }
		if (i == 16) { return new ItemStack(Items.BLACK_WOOL); }
		return null;
	}
	
	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(DOWN, H_FACING, HALF, STAGE_1_16, WATERLOGGED);
	}
}
