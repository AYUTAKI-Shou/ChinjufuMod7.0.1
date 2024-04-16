package com.ayutaki.chinjufumod.blocks.window;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.Config_CM;
import com.ayutaki.chinjufumod.blocks.base.BaseStage3_FaceWater;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.items.fuel.ItemCurtain;
import com.ayutaki.chinjufumod.registry.Items_Chinjufu;
import com.ayutaki.chinjufumod.registry.Window_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class WindowTall_Top extends BaseStage3_FaceWater {

	/* Collision */
	protected static final VoxelShape CLOSE_SOUTH = Block.makeCuboidShape(0.0D, -1.0D, 6.5D, 16.0D, 16.0D, 8.0D);
	protected static final VoxelShape CLOSE_WEST = Block.makeCuboidShape(8.0D, -1.0D, 0.0D, 9.5D, 16.0D, 16.0D);
	protected static final VoxelShape CLOSE_NORTH = Block.makeCuboidShape(0.0D, -1.0D, 8.0D, 16.0D, 16.0D, 9.5D);
	protected static final VoxelShape CLOSE_EAST = Block.makeCuboidShape(6.5D, -1.0D, 0.0D, 8.0D, 16.0D, 16.0D);

	protected static final VoxelShape OPEN2_SOUTH = Block.makeCuboidShape(0.0D, -8.0D, 6.5D, 16.0D, 9.0D, 8.0D);
	protected static final VoxelShape OPEN2_WEST = Block.makeCuboidShape(8.0D, -8.0D, 0.0D, 9.5D, 9.0D, 16.0D);
	protected static final VoxelShape OPEN2_NORTH = Block.makeCuboidShape(0.0D, -8.0D, 8.0D, 16.0D, 9.0D, 9.5D);
	protected static final VoxelShape OPEN2_EAST = Block.makeCuboidShape(6.5D, -8.0D, 0.0D, 8.0D, 9.0D, 16.0D);

	protected static final VoxelShape OPEN3_SOUTH = Block.makeCuboidShape(0.0D, -14.0D, 6.5D, 16.0D, 3.0D, 8.0D);
	protected static final VoxelShape OPEN3_WEST = Block.makeCuboidShape(8.0D, -14.0D, 0.0D, 9.5D, 3.0D, 16.0D);
	protected static final VoxelShape OPEN3_NORTH = Block.makeCuboidShape(0.0D, -14.0D, 8.0D, 16.0D, 3.0D, 9.5D);
	protected static final VoxelShape OPEN3_EAST = Block.makeCuboidShape(6.5D, -14.0D, 0.0D, 8.0D, 3.0D, 16.0D);

	public WindowTall_Top(Block.Properties properties) {
		super(properties);
	}

	/* Anti Shadow */
	public int getLightValue(BlockState state) {
		int i = state.get(STAGE_1_3);
		return (i == 3 && Config_CM.getInstance().antiShadow() == true)? 1 : 0;
	}

	/* RightClick Action */
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {
		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();

		if (item instanceof ItemCurtain) { return ActionResultType.PASS; }

		else {
			if (hit.getHitVec().y - (double)pos.getY() > 0.03125D) {
				worldIn.playSound(null, pos, SoundEvents_CM.WINDOW_UD, SoundCategory.BLOCKS, 1.0F, 1.0F);
				worldIn.setBlockState(pos, state.cycle(STAGE_1_3)); }
			return ActionResultType.SUCCESS;
		}
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(H_FACING);
		int i = state.get(STAGE_1_3);

		switch(direction) {
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
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.MODEL;
	}


	/* Destroy at the same time. & Drop item. */
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {

		BlockState downState = worldIn.getBlockState(pos.down());

		if (downState.getBlock() instanceof WindowTall_Bot) {
			worldIn.destroyBlock(pos.down(), false);
		}
		super.onBlockHarvested(worldIn, pos, state, playerIn);
	}

		/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		if (this == Window_Blocks.WINDOWTALLTOP_spruce) { return new ItemStack(Items_Chinjufu.WINDOWTALLBOT_spruce); }
		if (this == Window_Blocks.WINDOWTALLTOP_birch) { return new ItemStack(Items_Chinjufu.WINDOWTALLBOT_birch); }
		if (this == Window_Blocks.WINDOWTALLTOP_jungle) { return new ItemStack(Items_Chinjufu.WINDOWTALLBOT_jungle); }
		if (this == Window_Blocks.WINDOWTALLTOP_acacia) { return new ItemStack(Items_Chinjufu.WINDOWTALLBOT_acacia); }
		if (this == Window_Blocks.WINDOWTALLTOP_darkoak) { return new ItemStack(Items_Chinjufu.WINDOWTALLBOT_darkoak); }
		if (this == Window_Blocks.WINDOWTALLTOP_sakura) { return new ItemStack(Items_Chinjufu.WINDOWTALLBOT_sakura); }
		if (this == Window_Blocks.WINDOWTALLTOP_kaede) { return new ItemStack(Items_Chinjufu.WINDOWTALLBOT_kaede); }
		if (this == Window_Blocks.WINDOWTALLTOP_ichoh) { return new ItemStack(Items_Chinjufu.WINDOWTALLBOT_ichoh); }
		return new ItemStack(Items_Chinjufu.WINDOWTALLBOT_oak);
	}

	/* Can't breathe. */
	@Override
	public boolean causesSuffocation(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	/* Block is a cube. */
	@Override
	public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	public boolean isOpaqueCube(IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	/* Mobs spawn. */
	@Override
	public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type) {
		return false;
	}
	
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
}
