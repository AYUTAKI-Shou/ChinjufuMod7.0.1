package com.ayutaki.chinjufumod.blocks.season;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;

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

	public SnowMan_Color(Block.Properties properties) {
		super(properties);
		/** Default state **/
		setDefaultState(this.stateContainer.getBaseState().with(H_FACING, Direction.NORTH)
				.with(HALF, DoubleBlockHalf.LOWER)
				.with(STAGE_1_16, Integer.valueOf(1))
				.with(DOWN, Boolean.valueOf(false))
				.with(WATERLOGGED, false));
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {
		
		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		
		int i = state.get(STAGE_1_16);
		DoubleBlockHalf half = state.get(HALF);
		BlockState upState = this.getDefaultState().with(H_FACING, state.get(H_FACING))
				.with(HALF, DoubleBlockHalf.UPPER)
				.with(STAGE_1_16, Integer.valueOf(i))
				.with(WATERLOGGED, state.get(WATERLOGGED));
		
		boolean mode = playerIn.abilities.isCreativeMode;
		
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

		/** White=1, Orange=2, Magenta=3, LightBlue=4, Yellow=5, Lime=6, Pink=7, Gray=8, **/
		/** LightGray=9, Cyan=10, Purple=11, Blue=12, Brown=13, Green=14, Red=15, Black=16 **/
		case UPPER:
			if (stack.isEmpty()) {
				CMEvents.soundSnowBreak(worldIn, pos);
				worldIn.setBlockState(pos, Seasonal_Blocks.SNOWMAN.getDefaultState()
						.with(SnowMan.H_FACING, state.get(H_FACING))
						.with(SnowMan.HALF, DoubleBlockHalf.UPPER)
						.with(SnowMan.DOWN, state.get(DOWN))
						.with(SnowMan.WATERLOGGED, state.get(WATERLOGGED))
						.with(SnowMan.STAGE_1_4, Integer.valueOf(2)), 3);
				worldIn.setBlockState(pos.down(), Seasonal_Blocks.SNOWMAN.getDefaultState()
						.with(SnowMan.H_FACING, state.get(H_FACING))
						.with(SnowMan.HALF, DoubleBlockHalf.LOWER)
						.with(SnowMan.DOWN, state.get(DOWN))
						.with(SnowMan.WATERLOGGED, state.get(WATERLOGGED))
						.with(SnowMan.STAGE_1_4, Integer.valueOf(2)), 3);
	
				if (mode) { }
				
				if (!mode) {
					if (stack.isEmpty()) { playerIn.inventory.addItemStackToInventory(this.takeWool(state)); }
					else if (!playerIn.inventory.addItemStackToInventory(this.takeWool(state))) {
						playerIn.dropItem(this.takeWool(state), false); }
				} //!mode
			} //stack.isEmpty()
			
			if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		} // switch LOWER-UPPER
		
		return ActionResultType.SUCCESS;
	}

	private ItemStack takeWool(BlockState state) {
		int i = state.get(STAGE_1_16);
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
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(DOWN, H_FACING, HALF, STAGE_1_16, WATERLOGGED);
	}
}
