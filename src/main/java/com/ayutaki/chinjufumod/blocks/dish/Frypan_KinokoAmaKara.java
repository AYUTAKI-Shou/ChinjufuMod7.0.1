package com.ayutaki.chinjufumod.blocks.dish;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.base.BaseStage4_Face;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Frypan_KinokoAmaKara extends BaseStage4_Face {

	protected static final int COOK_TIME = 1000;
	/** 1=きのこ甘辛(生), 2=きのこ甘辛, 3=空やかん, 4=空き **/
	public Frypan_KinokoAmaKara(String name) {
		super(name);
		setCreativeTab(ChinjufuModTabs.TEATIME);

		setSoundType(SoundType.METAL);
		setHardness(1.0F);
		setResistance(5.0F);
		setLightOpacity(0);
	}
	
	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		if (i == 1) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
		/** 'true' to not put anything on top. **/
		return true;
	}

	/* Cooking */
	private boolean isCooking(World worldIn, BlockPos pos) {
		Block downBlock = worldIn.getBlockState(pos.down()).getBlock();
		return (downBlock == Blocks.LIT_FURNACE || downBlock == Kitchen_Blocks.LIT_KITSTOVE || 
				downBlock == Kitchen_Blocks.LIT_KITOVEN || downBlock == Kitchen_Blocks.LIT_KITOVEN_B);
	}
	
	@Override
	public void observedNeighborChange(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		if (this.isCooking(worldIn, pos)) { worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn)); }
	}
	
	@Override
	public int tickRate(World worldIn) {
		return COOK_TIME;
	}
	
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		super.onBlockAdded(worldIn, pos, state);
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		super.updateTick(worldIn, pos, state, rand);

		/** 1=きのこ甘辛(生), 2=きのこ甘辛, 3=空やかん, 4=空き **/
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (i == 1) {
			if (this.isCooking(worldIn, pos)) {
				worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
				worldIn.setBlockState(pos, state.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(2))); }
		}

		else { }
	}

	/* add Effect */
	@Override
	public void randomDisplayTick(IBlockState state, World worldIn, BlockPos pos, Random rand) {
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		World par1World = worldIn;
		int par2 = x;
		int par3 = y;
		int par4 = z;
		Random par5Random = rand;
		
		/** 1=きのこ甘辛(生), 2=きのこ甘辛, 3=空やかん, 4=空き **/
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();


		if (rand.nextDouble() < 0.1D) {
			if (i <= 2) {
				if (this.isCooking(worldIn, pos)) {
					worldIn.playSound(x, y, z, SoundEvents_CM.GUTSUGUTSU, SoundCategory.BLOCKS, 0.2F, 1.0F, false); }
			}
		}

		if (i == 2) {
			if (this.isCooking(worldIn, pos)) {

				for (int la = 0; la < 1; ++la) {
					double d0 = (double) ((float) par2 + 0.5F) + (double) (par5Random.nextFloat() - 0.5F) * 0.01D;
					double d1 = ((double) ((float) par3 + 0.5F) + (double) (par5Random.nextFloat() - 0.5F) * 0.01D) + 0.5D;
					double d2 = (double) ((float) par4 + 0.5F) + (double) (par5Random.nextFloat() - 0.5F) * 0.01D;
					double d3 = 0.12D;
					double d4 = 0.17D;
					par1World.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, d0 - d4 + 0.25, d1 + d3 -0.5, d2, 0.0D, 0.0D, 0.0D);
				}
			}
		}
		
		else { }
	}
	
	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		return (i == 3)? new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 0.4375D, 0.75D) : new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 0.125D, 0.75D);
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		/** Have no collision. **/
		return NULL_AABB;
	}

	/* Rendering */
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	/*Drop Item and Clone Item.*/
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		stack.add(this.takeStack(state));
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return this.takeStack(state);
	}

	private ItemStack takeStack(IBlockState state) {
		/** 1=きのこ甘辛(生), 2=きのこ甘辛, 3=空やかん, 4=空き **/
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		
		if (i == 1) { return new ItemStack(Items_Teatime.FPKINOKOAK_nama, 1, 0); }
		if (i == 2) { return new ItemStack(Items_Teatime.FPKINOKOAK, 1, 0); }
		if (i == 3) { return new ItemStack(Items_Teatime.Item_YAKAN_kara, 1, 0); }
		return null;
	}
	
	/* Do not connect to a Fence. */
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}
}