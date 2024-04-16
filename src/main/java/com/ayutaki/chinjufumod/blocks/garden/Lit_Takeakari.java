package com.ayutaki.chinjufumod.blocks.garden;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage3_Face;
import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.Lamp_Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Lit_Takeakari extends BaseStage3_Face {

	private static final AxisAlignedBB AABB_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.09375, 0.0, 0.40625, 0.28125, 0.5, 0.59375);
	private static final AxisAlignedBB AABB_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.09375, 0.0, 0.40625, 0.28125, 0.5, 0.59375);
	private static final AxisAlignedBB AABB_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.09375, 0.0, 0.40625, 0.28125, 0.5, 0.59375);
	private static final AxisAlignedBB AABB_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.09375, 0.0, 0.40625, 0.28125, 0.5, 0.59375);
	private static final AxisAlignedBB[] AABB = { AABB_SOUTH, AABB_WEST, AABB_NORTH, AABB_EAST };

	public Lit_Takeakari(String name) {
		super(name);
		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(1.0F);
		setLightOpacity(0);

		/* グロウストーン=1.0F 松明=0.9375F */
		setLightLevel(0.9375F);
		setTickRandomly(true);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		EnumFacing facing = state.getValue(H_FACING);
		return AABB[facing.getHorizontalIndex()];
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		/** Have no collision. **/
		return NULL_AABB;
	}

	/* SMOKE */
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState state, World worldIn, BlockPos pos, Random rand) {

		double d0 = (double)pos.getX() + 0.5D;
		double d1 = (double)pos.getY() + 0.7D;
		double d2 = (double)pos.getZ() + 0.5D;

		if (rand.nextDouble() < 0.02D) {
			EnumFacing direction = state.getValue(H_FACING);
			
			switch (direction) {
			case NORTH :
			default :
				worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0, d1 + 0.2D, d2 + 0.3125D, 0.0D, 0.0D, 0.0D);
				break;

			case SOUTH :
				worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0, d1 + 0.2D, d2 - 0.3125D, 0.0D, 0.0D, 0.0D);
				break;

			case EAST :
				worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 - 0.3125D, d1 + 0.2D, d2, 0.0D, 0.0D, 0.0D);
				break;
				
			case WEST :
				worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 + 0.3125D, d1 + 0.2D, d2, 0.0D, 0.0D, 0.0D);
				break;
			} // direction
		}
	}
	
	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack stack = playerIn.getHeldItem(hand);
		int i = state.getValue(STAGE_1_3);
		
		if (stack.isEmpty()) {
			CMEvents.soundFireExting(worldIn, pos);
			if (i == 1) {
				worldIn.setBlockState(pos, Lamp_Blocks.TAKEAKARI.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(STAGE_1_3, Integer.valueOf(1))); }
			
			if (i == 2) {
				worldIn.setBlockState(pos, Lamp_Blocks.TAKEAKARI.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(STAGE_1_3, Integer.valueOf(2))); }
			
			if (i == 3) {
				worldIn.setBlockState(pos, Lamp_Blocks.TAKEAKARI.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(STAGE_1_3, Integer.valueOf(3))); }
		}
		/** 'true' to not put anything on top. **/
		return true;
	}

	/* A torch can be placed on top. true or false */
	public boolean isTopSolid(IBlockState state) {
		return false;
	}

	/* A torch can be placed on the side. */
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	/* Rendering */
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}
	
	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		int i = state.getValue(STAGE_1_3);
		
		if (i == 1) { stack.add(new ItemStack(Items_Wadeco.TAKEAKARI, 1, 0)); }
		if (i == 2) { stack.add(new ItemStack(Items_Wadeco.TAKEAKARI, 1, 1)); }
		if (i == 3) { stack.add(new ItemStack(Items_Wadeco.TAKEAKARI, 1, 2)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		int i = state.getValue(STAGE_1_3);
		
		if (i == 2) { return new ItemStack(Items_Wadeco.TAKEAKARI, 1, 1); }
		if (i == 3) { return new ItemStack(Items_Wadeco.TAKEAKARI, 1, 2); }
		return new ItemStack(Items_Wadeco.TAKEAKARI, 1, 0);
	}

}
