package com.ayutaki.chinjufumod.blocks.furnace;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.BlockEntity_CM;
import com.ayutaki.chinjufumod.registry.Items_Chinjufu;
import com.ayutaki.chinjufumod.registry.School_Blocks;
import com.ayutaki.chinjufumod.tileentity.Stove_TileEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CStove_Top extends AbstractStoveBlock {

	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

	public CStove_Top(BlockBehaviour.Properties properties) {
		super(properties);
	}

	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new Stove_TileEntity(pos, state);
	}

	@Nullable
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level worldIn, BlockState state, BlockEntityType<T> blockEntity) {
		return createFurnaceTicker(worldIn, blockEntity, BlockEntity_CM.C_STOVE.get());
	}

	protected void openContainer(Level worldIn, BlockPos pos, Player playerIn) {
		BlockEntity blockentity = worldIn.getBlockEntity(pos);
		if (blockentity instanceof Stove_TileEntity) {
			playerIn.openMenu((MenuProvider)blockentity);
			playerIn.awardStat(Stats.INTERACT_WITH_FURNACE);
		}
	}

	/* Destroy a DoubleBlock from DoublePlantBlock.class */
	@Override
	public void playerWillDestroy(Level worldIn, BlockPos pos, BlockState state, Player playerIn) {
		BlockState downState = worldIn.getBlockState(pos.below());
		/** False is not Drop. **/
		if (downState.getBlock() == School_Blocks.CSTOVE_bot.get()) {
			worldIn.destroyBlock(pos.below(), false);
		}
		super.playerWillDestroy(worldIn, pos, state, playerIn);
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return AABB_BOX;
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Chinjufu.CSTOVE_bot.get());
	}
}
