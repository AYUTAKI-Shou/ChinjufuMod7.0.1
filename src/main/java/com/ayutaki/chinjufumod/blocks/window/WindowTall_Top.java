package com.ayutaki.chinjufumod.blocks.window;

import com.ayutaki.chinjufumod.blocks.base.BaseStage3_FaceWater;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.items.fuel.ItemCurtain;
import com.ayutaki.chinjufumod.registry.Items_Chinjufu;
import com.ayutaki.chinjufumod.registry.Window_Blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WindowTall_Top extends BaseStage3_FaceWater {

	/* Collision */
	protected static final VoxelShape CLOSE_SOUTH = Block.box(0.0D, -1.0D, 6.5D, 16.0D, 16.0D, 8.0D);
	protected static final VoxelShape CLOSE_WEST = Block.box(8.0D, -1.0D, 0.0D, 9.5D, 16.0D, 16.0D);
	protected static final VoxelShape CLOSE_NORTH = Block.box(0.0D, -1.0D, 8.0D, 16.0D, 16.0D, 9.5D);
	protected static final VoxelShape CLOSE_EAST = Block.box(6.5D, -1.0D, 0.0D, 8.0D, 16.0D, 16.0D);

	protected static final VoxelShape OPEN2_SOUTH = Block.box(0.0D, -8.0D, 6.5D, 16.0D, 9.0D, 8.0D);
	protected static final VoxelShape OPEN2_WEST = Block.box(8.0D, -8.0D, 0.0D, 9.5D, 9.0D, 16.0D);
	protected static final VoxelShape OPEN2_NORTH = Block.box(0.0D, -8.0D, 8.0D, 16.0D, 9.0D, 9.5D);
	protected static final VoxelShape OPEN2_EAST = Block.box(6.5D, -8.0D, 0.0D, 8.0D, 9.0D, 16.0D);

	protected static final VoxelShape OPEN3_SOUTH = Block.box(0.0D, -14.0D, 6.5D, 16.0D, 3.0D, 8.0D);
	protected static final VoxelShape OPEN3_WEST = Block.box(8.0D, -14.0D, 0.0D, 9.5D, 3.0D, 16.0D);
	protected static final VoxelShape OPEN3_NORTH = Block.box(0.0D, -14.0D, 8.0D, 16.0D, 3.0D, 9.5D);
	protected static final VoxelShape OPEN3_EAST = Block.box(6.5D, -14.0D, 0.0D, 8.0D, 3.0D, 16.0D);
	
	public WindowTall_Top(BlockBehaviour.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player playerIn, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = playerIn.getItemInHand(hand);
		Item item = stack.getItem();

		if (item instanceof ItemCurtain) { return InteractionResult.PASS; }

		else {
			if (hit.getLocation().y - (double)pos.getY() > 0.03125D) {
				worldIn.playSound(null, pos, SoundEvents_CM.WINDOW_UD.get(), SoundSource.BLOCKS, 1.0F, 1.0F);
				worldIn.setBlock(pos, state.cycle(STAGE_1_3), 3); }
			
			return InteractionResult.SUCCESS;
		}
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		Direction direction = state.getValue(H_FACING);
		int i = state.getValue(STAGE_1_3);

		switch (direction) {
		case NORTH:
		default:
			return (i == 1)? CLOSE_NORTH : ((i == 2)? OPEN2_NORTH : OPEN3_NORTH);
		case SOUTH:
			return (i == 1)? CLOSE_SOUTH : ((i == 2)? OPEN2_SOUTH : OPEN3_SOUTH);
		case WEST:
			return (i == 1)? CLOSE_WEST : ((i == 2)? OPEN2_WEST : OPEN3_WEST);
		case EAST:
			return (i == 1)? CLOSE_EAST : ((i == 2)? OPEN2_EAST : OPEN3_EAST);
		}
	}
			
	@Override
	public RenderShape getRenderShape(BlockState state) {
		return RenderShape.MODEL;
	}
	
	/* Destroy a DoubleBlock from DoublePlantBlock.class */
	@Override
	public void playerWillDestroy(Level worldIn, BlockPos pos, BlockState state, Player playerIn) {
		BlockState downState = worldIn.getBlockState(pos.below());

		if (downState.getBlock() instanceof WindowTall_Bot) {
			worldIn.destroyBlock(pos.below(), false);
		}
		super.playerWillDestroy(worldIn, pos, state, playerIn);
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		if (this == Window_Blocks.WINDOWTALLTOP_spruce.get()) { return new ItemStack(Items_Chinjufu.WINDOWTALLBOT_spruce.get()); }
		if (this == Window_Blocks.WINDOWTALLTOP_birch.get()) { return new ItemStack(Items_Chinjufu.WINDOWTALLBOT_birch.get()); }
		if (this == Window_Blocks.WINDOWTALLTOP_jungle.get()) { return new ItemStack(Items_Chinjufu.WINDOWTALLBOT_jungle.get()); }
		if (this == Window_Blocks.WINDOWTALLTOP_acacia.get()) { return new ItemStack(Items_Chinjufu.WINDOWTALLBOT_acacia.get()); }
		if (this == Window_Blocks.WINDOWTALLTOP_darkoak.get()) { return new ItemStack(Items_Chinjufu.WINDOWTALLBOT_darkoak.get()); }
		if (this == Window_Blocks.WINDOWTALLTOP_sakura.get()) { return new ItemStack(Items_Chinjufu.WINDOWTALLBOT_sakura.get()); }
		if (this == Window_Blocks.WINDOWTALLTOP_kaede.get()) { return new ItemStack(Items_Chinjufu.WINDOWTALLBOT_kaede.get()); }
		if (this == Window_Blocks.WINDOWTALLTOP_ichoh.get()) { return new ItemStack(Items_Chinjufu.WINDOWTALLBOT_ichoh.get()); }
		return new ItemStack(Items_Chinjufu.WINDOWTALLBOT_oak.get());
	}
}
