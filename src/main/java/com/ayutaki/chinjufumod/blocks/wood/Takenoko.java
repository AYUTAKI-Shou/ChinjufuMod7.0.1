package com.ayutaki.chinjufumod.blocks.wood;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Takenoko extends Block {

	/* Property */
	public static final PropertyInteger STAGE_0_1 = PropertyInteger.create("stage", 0, 1);
	/* Collision */
	protected static final AxisAlignedBB AABB_BOX = new AxisAlignedBB(0.3125D, 0.0D, 0.3125D, 0.6875D, 0.4375D, 0.6875D);

	public Takenoko(String name) {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);
		setCreativeTab(ChinjufuModTabs.SEASONAL);
		
		setSoundType(SoundType.GROUND);
		setHardness(1.0F);
		setResistance(1.0F);
		setLightOpacity(0);
		
		setDefaultState(this.blockState.getBaseState().withProperty(STAGE_0_1, Integer.valueOf(0)));
		setTickRandomly(true);
	}
	
	/* Update BlockState. */
	public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state) {
		Block downBlock = worldIn.getBlockState(pos.down()).getBlock();
		return downBlock instanceof BlockDirt || downBlock instanceof BlockGrass || downBlock instanceof FallLeaf;
	}
	
	protected void checkAndDropBlock(World worldIn, BlockPos pos, IBlockState state) {
		if (!this.canBlockStay(worldIn, pos, state)) {
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
		}
	}

	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block neighborBlock, BlockPos fromPos) {
		this.checkAndDropBlock(worldIn, pos, state);
	}
	
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		super.updateTick(worldIn, pos, state, rand);
		int i = ((Integer)state.getValue(STAGE_0_1)).intValue();
		
		if (!worldIn.isAreaLoaded(pos, 1)) return; 
		
		this.checkAndDropBlock(worldIn, pos, state);
		
		if (this.airLight(worldIn, pos) && rand.nextInt(3) == 0) {
			if (i != 1) { worldIn.setBlockState(pos, state.withProperty(STAGE_0_1, Integer.valueOf(i + 1)), 3); }
			if (i == 1) { this.placeBamboo(worldIn, pos, state); }
		}
	}
	
	private boolean airLight(World worldIn, BlockPos pos) {
		return worldIn.isAirBlock(pos.up()) && worldIn.getLightFromNeighbors(pos.up()) >= 9;
	}
	
	protected void placeBamboo(World worldIn, BlockPos pos, IBlockState state) {
		worldIn.setBlockState(pos, Seasonal_Blocks.TAKE.getDefaultState().withProperty(Take_CM.STAGE_0_15, Integer.valueOf(11)), 3);
		worldIn.setBlockState(pos.up(1), Seasonal_Blocks.TAKE.getDefaultState().withProperty(Take_CM.STAGE_0_15, Integer.valueOf(0)), 3);
	}
	
	/* Collision */
	public Block.EnumOffsetType getOffsetType() {
		return Block.EnumOffsetType.XZ;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return AABB_BOX.offset(state.getOffset(source, pos));
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		/** Have no collision. **/
		return NULL_AABB;
	}
	
	/* Rendering */
	@Override
	public boolean isTopSolid(IBlockState state) {
		return true;
	}

	/* A torch can be placed on the side. */
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
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
	
	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}
	
	/* デフォルトのメタData valueを呼び出し */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(STAGE_0_1, Integer.valueOf(meta));
	}

	/* メタData valueを拾う */
	@Override
	public int getMetaFromState(IBlockState state) {
		return ((Integer)state.getValue(STAGE_0_1)).intValue();
	}

	/* メタData valueとして STAGE_0_1 を設ける */
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {STAGE_0_1});
	}
	
	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		stack.add(new ItemStack(Items_Seasonal.TAKENOKO, 1, 0));
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Items_Seasonal.TAKENOKO);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_takenoko.name", meta));
		tooltip.add(I18n.format("tips.block_takenoko2.name", meta));
	}

}
