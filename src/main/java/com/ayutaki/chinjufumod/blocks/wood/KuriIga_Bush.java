package com.ayutaki.chinjufumod.blocks.wood;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Wood_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.SpreadableSnowyDirtBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.ToolType;

public class KuriIga_Bush extends BushBlock {
	
	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.makeCuboidShape(6.0D, -1.0D, 6.0D, 10.0D, 3.5D, 10.0D);

	public KuriIga_Bush(Block.Properties properties) {
		super(properties);
		/** Default state **/
		setDefaultState(this.stateContainer.getBaseState());
	}

	//Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		for(BlockPos nearPos : BlockPos.getAllInBoxMutable(pos.add(-2, 0, -2), pos.add(2, 2, 2))) {
			if (worldIn.getBlockState(nearPos).getBlock() == Wood_Blocks.OAKKARE_log) {
				return this.isValidGround(worldIn.getBlockState(pos.down()), worldIn, pos.down());
			}
		}
		return false;
	}
	
	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return (state.getBlock() instanceof SpreadableSnowyDirtBlock ||state.getMaterial() == Material.EARTH);
	}
	
	/* Collisions for each property. */
	@Override
	public Block.OffsetType getOffsetType() {
		return Block.OffsetType.XZ;
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Vec3d vec3d = state.getOffset(worldIn, pos);
		return AABB_BOX.withOffset(vec3d.x, vec3d.y, vec3d.z);
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Seasonal.KURI_IGA);
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