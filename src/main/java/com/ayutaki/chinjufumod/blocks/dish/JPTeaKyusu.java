package com.ayutaki.chinjufumod.blocks.dish;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
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

public class JPTeaKyusu extends BaseFood_Stage5Water {

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.makeCuboidShape(4.0D, 0.0D, 6.0D, 10.0D, 3.5D, 10.0D);
	protected static final VoxelShape AABB_WEST = Block.makeCuboidShape(6.0D, 0.0D, 4.0D, 10.0D, 3.5D, 10.0D);
	protected static final VoxelShape AABB_NORTH = Block.makeCuboidShape(6.0D, 0.0D, 6.0D, 12.0D, 3.5D, 10.0D);
	protected static final VoxelShape AABB_EAST = Block.makeCuboidShape(6.0D, 0.0D, 6.0D, 10.0D, 3.5D, 12.0D);

	protected static final VoxelShape DOWN_SOUTH = Block.makeCuboidShape(4.0D, -8.0D, 2.0D, 10.0D, 0.1D, 6.0D);
	protected static final VoxelShape DOWN_WEST = Block.makeCuboidShape(10.0D, -8.0D, 4.0D, 14.0D, 0.1D, 10.0D);
	protected static final VoxelShape DOWN_NORTH = Block.makeCuboidShape(6.0D, -8.0D, 10.0D, 12.0D, 0.1D, 14.0D);
	protected static final VoxelShape DOWN_EAST = Block.makeCuboidShape(2.0D, -8.0D, 6.0D, 6.0D, 0.1D, 12.0D);

	public JPTeaKyusu(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		int i = state.get(STAGE_1_5);

		if (i != 5) {
			if (item == Items_Teatime.YUNOMI) {
				/** Collect with an Item **/
				CMEvents.Consume1Item_Tea(worldIn, pos, playerIn, hand);
	
				if (stack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.JPTEACUP)); }
				else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.JPTEACUP))) {
					playerIn.dropItem(new ItemStack(Items_Teatime.JPTEACUP), false); }
	
				worldIn.setBlockState(pos, state.with(STAGE_1_5, Integer.valueOf(i + 1))); }
			
			if (item != Items_Teatime.YUNOMI) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		}
		
		if (i == 5) { CMEvents.textIsEmpty(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		int i = state.get(STAGE_1_5);
		
		if (i != 5) {
			if (inWater(state, worldIn, pos)) {
				worldIn.getPendingBlockTicks().scheduleTick(pos, this, 60);
				CMEvents.soundBubble(worldIn, pos);
				worldIn.setBlockState(pos, state.with(STAGE_1_5, Integer.valueOf(5))); }
			
			else { } }
		
		if (i == 5) { }
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

		Direction direction = state.get(H_FACING);
		boolean flag= !((Boolean)state.get(DOWN)).booleanValue();

		switch(direction) {
		case NORTH:
		default:
			return flag? AABB_NORTH : DOWN_NORTH;
		case SOUTH:
			return flag? AABB_SOUTH : DOWN_SOUTH;
		case WEST:
			return flag? AABB_WEST : DOWN_WEST;
		case EAST:
			return flag? AABB_EAST : DOWN_EAST;
		}
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.KYUSU);
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_food_kyusu_1").applyTextStyle(TextFormatting.GRAY));
	}
}
