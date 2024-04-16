package com.ayutaki.chinjufumod.blocks.cmblock;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.ChinjufuMod_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Chinjufu;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

public class Report_Box extends Block {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final IntegerProperty STAGE_1_15 = IntegerProperty.create("stage", 1, 15);
	
	public Report_Box(AbstractBlock.Properties properties) {
		super(properties);
		registerDefaultState(this.defaultBlockState().setValue(H_FACING, Direction.NORTH)
				.setValue(STAGE_1_15, Integer.valueOf(1)));
	}
	
	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection().getOpposite())
				.setValue(STAGE_1_15, Integer.valueOf(1));
	}
	
	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();
		int i = state.getValue(STAGE_1_15);
		int gc = stack.getCount();
		boolean mode = playerIn.abilities.instabuild;
		
		Direction direction = state.getValue(H_FACING);
	
		BlockState northState = worldIn.getBlockState(pos.north());
		BlockState southState = worldIn.getBlockState(pos.south());
		BlockState eastState = worldIn.getBlockState(pos.east());
		BlockState westState = worldIn.getBlockState(pos.west());
		
		boolean wait = (i == 4 || i == 6 || i == 8 || i == 10 || i == 12 || i == 14);
		boolean repo = (i == 5 || i == 7 || i == 9 || i == 11 || i == 13 || i == 15);
		
		switch (direction) {
		case NORTH:
		default:
			if (!northState.getMaterial().isReplaceable()) {
				CMEvents.textIsBlocked(worldIn, pos, playerIn);
				return ActionResultType.SUCCESS; }
			
			if (northState.getMaterial().isReplaceable()) {
				if (northState.getBlock() instanceof FlowingFluidBlock) {
					CMEvents.textIsBlocked(worldIn, pos, playerIn);
					return ActionResultType.SUCCESS; }
				
				if (!(northState.getBlock() instanceof FlowingFluidBlock)) {
					if (i == 1) {
						if (item == Items.BLACK_DYE) {
							CMEvents.Consume_1Item(playerIn, hand);
							CMEvents.soundBottleFill(worldIn, pos);
							worldIn.setBlock(pos, state.setValue(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
						
						if (item != Items.BLACK_DYE && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					}
					
					if (i == 2) {
						if (item == Items.RED_DYE) {
							CMEvents.Consume_1Item(playerIn, hand);
							CMEvents.soundBottleFill(worldIn, pos);
							worldIn.setBlock(pos, state.setValue(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
						
						if (item != Items.RED_DYE && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					}
					
					if (i == 3) {
						if (item == Items.PAPER && gc >= 30) { 
								if (!mode) { stack.shrink(30); }
								if (mode) { } 
								CMEvents.soundWoolPlace(worldIn, pos);
								worldIn.setBlock(pos, state.setValue(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
						
						if (item == Items.PAPER && gc < 30) { CMEvents.textNotEnough_Items(worldIn, pos, playerIn); }
						
						if (item != Items.PAPER && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					}
					
					if (wait) {
						if (item == Items.ROTTEN_FLESH && gc >= 16) { 
							if (!mode) { stack.shrink(16); }
							if (mode) { } 
							CMEvents.soundWoolPlace(worldIn, pos);
							worldIn.setBlock(pos, state.setValue(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
						
						if (item == Items.ROTTEN_FLESH && gc < 16) { CMEvents.textNotEnough_Items(worldIn, pos, playerIn); }
						
						if (item != Items.ROTTEN_FLESH && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					} 
					
					if (repo && stack.isEmpty()) {
						worldIn.playSound(null, pos, SoundEvents.NOTE_BLOCK_BELL, SoundCategory.BLOCKS, 1.0F, 1.0F);
						playerIn.inventory.add(new ItemStack(Items_Chinjufu.WORK_ORDER, 5));
						
						if (i != 15) { worldIn.setBlock(pos, state.setValue(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
						if (i == 15) { worldIn.setBlock(pos, state.setValue(STAGE_1_15, Integer.valueOf(1)), 3); }
					} } }
			break;

		case SOUTH:
			if (!southState.getMaterial().isReplaceable()) {
				CMEvents.textIsBlocked(worldIn, pos, playerIn);
				return ActionResultType.SUCCESS; }
			
			if (southState.getMaterial().isReplaceable()) {
				if (southState.getBlock() instanceof FlowingFluidBlock) {
					CMEvents.textIsBlocked(worldIn, pos, playerIn);
					return ActionResultType.SUCCESS; }
				
				if (!(southState.getBlock() instanceof FlowingFluidBlock)) {
					if (i == 1) {
						if (item == Items.BLACK_DYE) {
							CMEvents.Consume_1Item(playerIn, hand);
							CMEvents.soundBottleFill(worldIn, pos);
							worldIn.setBlock(pos, state.setValue(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
						
						if (item != Items.BLACK_DYE && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					}
					
					if (i == 2) {
						if (item == Items.RED_DYE) {
							CMEvents.Consume_1Item(playerIn, hand);
							CMEvents.soundBottleFill(worldIn, pos);
							worldIn.setBlock(pos, state.setValue(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
						
						if (item != Items.RED_DYE && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					}
					
					if (i == 3) {
						if (item == Items.PAPER && gc >= 30) { 
								if (!mode) { stack.shrink(30); }
								if (mode) { } 
								CMEvents.soundWoolPlace(worldIn, pos);
								worldIn.setBlock(pos, state.setValue(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
						
						if (item == Items.PAPER && gc < 30) { CMEvents.textNotEnough_Items(worldIn, pos, playerIn); }
						
						if (item != Items.PAPER && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					}
					
					if (wait) {
						if (item == Items.ROTTEN_FLESH && gc >= 16) { 
							if (!mode) { stack.shrink(16); }
							if (mode) { } 
							CMEvents.soundWoolPlace(worldIn, pos);
							worldIn.setBlock(pos, state.setValue(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
						
						if (item == Items.ROTTEN_FLESH && gc < 16) { CMEvents.textNotEnough_Items(worldIn, pos, playerIn); }
						
						if (item != Items.ROTTEN_FLESH && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					} 
					
					if (repo && stack.isEmpty()) {
						worldIn.playSound(null, pos, SoundEvents.NOTE_BLOCK_BELL, SoundCategory.BLOCKS, 1.0F, 1.0F);
						playerIn.inventory.add(new ItemStack(Items_Chinjufu.WORK_ORDER, 5));
						
						if (i != 15) { worldIn.setBlock(pos, state.setValue(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
						if (i == 15) { worldIn.setBlock(pos, state.setValue(STAGE_1_15, Integer.valueOf(1)), 3); }
					} } }
			break;

		case EAST:
			if (!eastState.getMaterial().isReplaceable()) {
				CMEvents.textIsBlocked(worldIn, pos, playerIn);
				return ActionResultType.SUCCESS; }
			
			if (eastState.getMaterial().isReplaceable()) {
				if (eastState.getBlock() instanceof FlowingFluidBlock) {
					CMEvents.textIsBlocked(worldIn, pos, playerIn);
					return ActionResultType.SUCCESS; }
				
				if (!(eastState.getBlock() instanceof FlowingFluidBlock)) {
					if (i == 1) {
						if (item == Items.BLACK_DYE) {
							CMEvents.Consume_1Item(playerIn, hand);
							CMEvents.soundBottleFill(worldIn, pos);
							worldIn.setBlock(pos, state.setValue(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
						
						if (item != Items.BLACK_DYE && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					}
					
					if (i == 2) {
						if (item == Items.RED_DYE) {
							CMEvents.Consume_1Item(playerIn, hand);
							CMEvents.soundBottleFill(worldIn, pos);
							worldIn.setBlock(pos, state.setValue(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
						
						if (item != Items.RED_DYE && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					}
					
					if (i == 3) {
						if (item == Items.PAPER && gc >= 30) { 
								if (!mode) { stack.shrink(30); }
								if (mode) { } 
								CMEvents.soundWoolPlace(worldIn, pos);
								worldIn.setBlock(pos, state.setValue(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
						
						if (item == Items.PAPER && gc < 30) { CMEvents.textNotEnough_Items(worldIn, pos, playerIn); }
						
						if (item != Items.PAPER && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					}
					
					if (wait) {
						if (item == Items.ROTTEN_FLESH && gc >= 16) { 
							if (!mode) { stack.shrink(16); }
							if (mode) { } 
							CMEvents.soundWoolPlace(worldIn, pos);
							worldIn.setBlock(pos, state.setValue(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
						
						if (item == Items.ROTTEN_FLESH && gc < 16) { CMEvents.textNotEnough_Items(worldIn, pos, playerIn); }
						
						if (item != Items.ROTTEN_FLESH && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					} 
					
					if (repo && stack.isEmpty()) {
						worldIn.playSound(null, pos, SoundEvents.NOTE_BLOCK_BELL, SoundCategory.BLOCKS, 1.0F, 1.0F);
						playerIn.inventory.add(new ItemStack(Items_Chinjufu.WORK_ORDER, 5));
						
						if (i != 15) { worldIn.setBlock(pos, state.setValue(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
						if (i == 15) { worldIn.setBlock(pos, state.setValue(STAGE_1_15, Integer.valueOf(1)), 3); }
					} } }
			break;
			
		case WEST:
			if (!westState.getMaterial().isReplaceable()) {
				CMEvents.textIsBlocked(worldIn, pos, playerIn);
				return ActionResultType.SUCCESS; }
			
			if (westState.getMaterial().isReplaceable()) {
				if (westState.getBlock() instanceof FlowingFluidBlock) {
					CMEvents.textIsBlocked(worldIn, pos, playerIn);
					return ActionResultType.SUCCESS; }
				
				if (!(westState.getBlock() instanceof FlowingFluidBlock)) {
					if (i == 1) {
						if (item == Items.BLACK_DYE) {
							CMEvents.Consume_1Item(playerIn, hand);
							CMEvents.soundBottleFill(worldIn, pos);
							worldIn.setBlock(pos, state.setValue(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
						
						if (item != Items.BLACK_DYE && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					}
					
					if (i == 2) {
						if (item == Items.RED_DYE) {
							CMEvents.Consume_1Item(playerIn, hand);
							CMEvents.soundBottleFill(worldIn, pos);
							worldIn.setBlock(pos, state.setValue(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
						
						if (item != Items.RED_DYE && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					}
					
					if (i == 3) {
						if (item == Items.PAPER && gc >= 30) { 
								if (!mode) { stack.shrink(30); }
								if (mode) { } 
								CMEvents.soundWoolPlace(worldIn, pos);
								worldIn.setBlock(pos, state.setValue(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
						
						if (item == Items.PAPER && gc < 30) { CMEvents.textNotEnough_Items(worldIn, pos, playerIn); }
						
						if (item != Items.PAPER && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					}
					
					if (wait) {
						if (item == Items.ROTTEN_FLESH && gc >= 16) { 
							if (!mode) { stack.shrink(16); }
							if (mode) { } 
							CMEvents.soundWoolPlace(worldIn, pos);
							worldIn.setBlock(pos, state.setValue(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
						
						if (item == Items.ROTTEN_FLESH && gc < 16) { CMEvents.textNotEnough_Items(worldIn, pos, playerIn); }
						
						if (item != Items.ROTTEN_FLESH && !stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
					} 
					
					if (repo && stack.isEmpty()) {
						worldIn.playSound(null, pos, SoundEvents.NOTE_BLOCK_BELL, SoundCategory.BLOCKS, 1.0F, 1.0F);
						playerIn.inventory.add(new ItemStack(Items_Chinjufu.WORK_ORDER, 5));
						
						if (i != 15) { worldIn.setBlock(pos, state.setValue(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
						if (i == 15) { worldIn.setBlock(pos, state.setValue(STAGE_1_15, Integer.valueOf(1)), 3); }
					} } }
			break;
		} // switch
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* HORIZONTAL Property */
	@Override
	public BlockState rotate(BlockState state, Rotation rotation) {
		return state.setValue(H_FACING, rotation.rotate(state.getValue(H_FACING)));
	}

	@SuppressWarnings("deprecation")
	public BlockState mirror(BlockState state, Mirror mirror) {
		return state.rotate(mirror.getRotation(state.getValue(H_FACING)));
	}
	
	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		worldIn.getBlockTicks().scheduleTick(pos, ChinjufuMod_Blocks.REPORT_BOX, 120);
		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}
	
	/* TickRandom */
	@Override
	public void onPlace(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		int i = state.getValue(STAGE_1_15);
		boolean repo = (i == 5 || i == 7 || i == 9 || i == 11 || i == 13 || i == 15);
		if (repo) { worldIn.getBlockTicks().scheduleTick(pos, ChinjufuMod_Blocks.REPORT_BOX, 120); }
	}
	
	protected void dropOrder(BlockState state, ServerWorld worldIn, BlockPos pos) {
		ItemStack stack = new ItemStack(Items_Chinjufu.WORK_ORDER, 5);
		
		Direction direction = state.getValue(H_FACING);
		double sn = (direction == Direction.SOUTH)? 1.2D : ((direction == Direction.NORTH)? - 0.7D : 0.0D); 
		double ew = (direction == Direction.EAST)? 1.2D : ((direction == Direction.WEST)? - 0.7D : 0.0D);
		
		InventoryHelper.dropItemStack(worldIn, pos.getX() + ew, pos.getY() + 0.5D, pos.getZ() + sn, stack);
	}
	
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		int i = state.getValue(STAGE_1_15);
		boolean repo = (i == 5 || i == 7 || i == 9 || i == 11 || i == 13 || i == 15);
		
		if (repo) {
			worldIn.getBlockTicks().scheduleTick(pos, ChinjufuMod_Blocks.REPORT_BOX, 120);
			worldIn.playSound(null, pos, SoundEvents.NOTE_BLOCK_BELL, SoundCategory.BLOCKS, 1.0F, 1.0F);
			this.dropOrder(state, worldIn, pos); 
			
			if (i != 15) { worldIn.setBlock(pos, state.setValue(STAGE_1_15, Integer.valueOf(i + 1)), 3); }
			if (i == 15) { worldIn.setBlock(pos, state.setValue(STAGE_1_15, Integer.valueOf(1)), 3); }
		}

		else { }
	}

	/* Play Sound・Particle */
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState state, World worldIn, BlockPos pos, Random rand) {
		int i = state.getValue(STAGE_1_15);
		boolean repo = (i == 5 || i == 7 || i == 9 || i == 11 || i == 13 || i == 15);
		
		if (repo) {
			for(int k = 0; k < 5; ++k) {
				double x = pos.getX();
				double y = pos.getY();
				double z = pos.getZ();
				worldIn.playLocalSound(x, y, z, SoundEvents_CM.NOISE, SoundCategory.BLOCKS, 0.5F, 1.0F, false); } }
	}
	
	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(STAGE_1_15, H_FACING);
	}

	
	/* The best harvesting tool. */
	@Nullable
	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.PICKAXE;
	}

	@Override
	public int getHarvestLevel(BlockState state) {
		return 0;
	}
	
	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_report_box").withStyle(TextFormatting.GRAY));
	}
}
