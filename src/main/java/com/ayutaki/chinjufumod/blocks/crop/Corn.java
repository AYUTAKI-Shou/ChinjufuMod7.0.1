package com.ayutaki.chinjufumod.blocks.crop;

import java.util.Random;

import com.ayutaki.chinjufumod.registry.Crop_Blocks;

import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Corn extends BaseFarmCrop {

	private static final AxisAlignedBB[] CROPS_AABB = new AxisAlignedBB[] { new AxisAlignedBB(0.0D * cw, -1.0D * cw, 0.0D * cw, 16.0D * cw, 1.0D * cw, 16.0D * cw),
			new AxisAlignedBB(2.0D * cw, -1.0D * cw, 2.0D * cw, 14.0D * cw, 1.0D * cw, 14.0D * cw),
			new AxisAlignedBB(2.0D * cw, -1.0D * cw, 2.0D * cw, 14.0D * cw, 7.0D * cw, 14.0D * cw),
			new AxisAlignedBB(2.0D * cw, -1.0D * cw, 2.0D * cw, 14.0D * cw, 11.0D * cw, 14.0D * cw),
			new AxisAlignedBB(2.0D * cw, -1.0D * cw, 2.0D * cw, 14.0D * cw, 18.0D * cw, 14.0D * cw),
			new AxisAlignedBB(2.0D * cw, 0.0D * cw, 2.0D * cw, 14.0D * cw, 24.0D * cw, 14.0D * cw),
			new AxisAlignedBB(2.0D * cw, 0.0D * cw, 2.0D * cw, 14.0D * cw, 28.0D * cw, 14.0D * cw),
			new AxisAlignedBB(2.0D * cw, 0.0D * cw, 2.0D * cw, 14.0D * cw, 16.0D * cw, 14.0D * cw) };

	public Corn(String name) {
		super(name);
		setDefaultState(this.blockState.getBaseState().withProperty(AGE, Integer.valueOf(0)));
		setTickRandomly(true);
	}

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return CROPS_AABB[((Integer)state.getValue(AGE)).intValue()];
	}
	
	/* RandomTick */
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		super.updateTick(worldIn, pos, state, rand);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		
		if (!worldIn.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
		
		IBlockState upState = worldIn.getBlockState(pos.up());
		if (upState.getBlock() != Crop_Blocks.CORN_TOP) { worldIn.destroyBlock(pos, false); }
		
		if (upState.getBlock() == Crop_Blocks.CORN_TOP) {
			
			int i = ((Integer)state.getValue(AGE)).intValue();
			int k = ((Integer)upState.getValue(Corn_Top.AGE)).intValue();
			
			if (i != k) { 
				worldIn.setBlockState(pos.up(), Crop_Blocks.CORN_TOP.getDefaultState().withProperty(Corn_Top.AGE, Integer.valueOf(i)), 3); }
			
			if (i < this.getMaxAge()) {
				float f = getGrowthChance(this, worldIn, pos);
				if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt((int)(25.0F / f) + 1) == 0)) {
					int i1 = i + 1;
					worldIn.setBlockState(new BlockPos(x, y, z), this.withAge(i1), 3);
					worldIn.setBlockState(new BlockPos(x, y + 1, z), Crop_Blocks.CORN_TOP.getDefaultState().withProperty(Corn_Top.AGE, Integer.valueOf(i1)), 3);
					
					net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state, worldIn.getBlockState(pos)); } //CropsGrow
			}
		}
	}
		
	public void grow(World worldIn, BlockPos pos, IBlockState state) {
		int i = this.getAge(state) + this.getBonemealAgeIncrease(worldIn);
		int j = this.getMaxAge();

		if (i > j) { i = j; }
		worldIn.setBlockState(pos, this.withAge(i));
		worldIn.setBlockState(pos.up(), Crop_Blocks.CORN_TOP.getDefaultState().withProperty(Corn_Top.AGE, Integer.valueOf(i)));
	}
	
	/* A place where you can put it. */
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos).getMaterial().isReplaceable() && worldIn.getBlockState(pos.up()).getMaterial().isReplaceable();
	}

	@Override
	protected Item getSeed() {
		return Items.AIR;
	}

	@Override
	protected Item getCrop() {
		return Items.AIR;
	}
	
	/* Cabbage 1, Corn 1, CCabbage 1, Onion 4, Rice 1, Soy 2, Spinach 1, Tomato 4 */
	@Override
	public int quantityDropped(Random rand) {
		return 1;
	}

	/* A block that breaks at the same time when it is broken. */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn) {
		if (worldIn.getBlockState(pos.up()).getBlock() instanceof Corn_Top) {
			if (playerIn.capabilities.isCreativeMode) { worldIn.destroyBlock(pos.up(), false); }
			worldIn.destroyBlock(pos.up(), true);
		}
	}

	/* Do not connect to a Fence. */
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}
}
