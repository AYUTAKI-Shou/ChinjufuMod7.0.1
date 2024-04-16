package com.ayutaki.chinjufumod.blocks.wood;

import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.handler.ParticleTypes_CM;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Leaf_Ichoh extends BlockLeaves {

	public static final PropertyBool DECAYABLE = PropertyBool.create("decayable");
	public static final PropertyBool CHECK_DECAY = PropertyBool.create("check_decay");
	protected boolean leavesFancy;

	public Leaf_Ichoh(String name) {
		super();
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);
		setCreativeTab(ChinjufuModTabs.SEASONAL);

		setSoundType(SoundType.PLANT);
		setHardness(0.1F);
		setResistance(0.1F);
		setLightOpacity(1);

		setDefaultState(blockState.getBaseState()
				.withProperty(CHECK_DECAY, Boolean.valueOf(true))
				.withProperty(DECAYABLE, Boolean.valueOf(true)));
	}

	public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return MapColor.YELLOW;
	}

	/* IDが同じで, メタData valueが異なるブロックのリストを返す */
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		items.add(new ItemStack(this));
	}

	/* シルクタッチを使ったときの処理 */
	@Override
	protected ItemStack getSilkTouchDrop(IBlockState state) {
		return new ItemStack(Item.getItemFromBlock(this));
	}

	/* デフォルトのメタData valueを呼び出し */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(DECAYABLE, Boolean.valueOf((meta & 4) == 0))
				.withProperty(CHECK_DECAY, Boolean.valueOf((meta & 8) > 0));
	}

	/* メタData valueを拾う */
	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0;

		if (!state.getValue(DECAYABLE).booleanValue()) {
			i |= 4;
		}
		if (state.getValue(CHECK_DECAY).booleanValue()) {
			i |= 8;
		}
		return i;
	}

	/* メタData valueとして CHECK_DECAY, DECAYABLE を設ける */
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { CHECK_DECAY, DECAYABLE });
	}

	/* ドロップアイテムに適用するメタData value */
	@Override
	public int damageDropped(IBlockState state) {
		return 0;
	}

	/* ハサミで回収できるようにする */
	@Override
	public void harvestBlock(World worldIn, EntityPlayer playerIn, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack) {

		if (!worldIn.isRemote && stack.getItem() == Items.SHEARS) {
			playerIn.addStat(StatList.getBlockStats(this));
		}
		else {
			super.harvestBlock(worldIn, playerIn, pos, state, te, stack);
		}
	}

	/* ハサミで回収したときの数？ */
	@Override
	public NonNullList<ItemStack> onSheared(ItemStack item, net.minecraft.world.IBlockAccess worldIn, BlockPos pos, int fortune) {
		return NonNullList.withSize(1, new ItemStack(this));
	}

	@Override
	public EnumType getWoodType(int meta) {
		return null;
	}

	/* Drop items. */
	@Override
	public java.util.List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		java.util.List<ItemStack> stack = new java.util.ArrayList<ItemStack>();
		Random rand = worldIn instanceof World ? ((World)worldIn).rand : new Random();
		int chance = fortune > 0? (fortune == 1 ? 30 : 25) : 40;

		if (rand.nextInt(chance) == 0) { stack.add(new ItemStack(Items_Seasonal.ICHOH_nae, 1, 0)); }
		if (rand.nextInt(chance) == 0) { stack.add(new ItemStack(Items_Seasonal.ICHOH_nae, 1, 0)); }
		if (rand.nextInt(chance) == 0) { stack.add(new ItemStack(Items.STICK, 1, 0)); }
		return stack;
	}
	
	/* Render */
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

	/* 落葉 */
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {

		if (worldIn.isAirBlock(pos.down())) {

			if (rand.nextInt(200) == 0) {
				int j = rand.nextInt(2) * 2 - 1;
				int k = rand.nextInt(2) * 2 - 1;

				double d0 = pos.getX() + 0.5D + 0.25D * j;
				double d1 = pos.getY() - 0.15D;
				double d2 = pos.getZ() + 0.5D + 0.25D * k;
				double d3 = rand.nextFloat() * j * 0.1D;
				double d4 = (rand.nextFloat() * 0.055D) + 0.015D;
				double d5 = rand.nextFloat() * k * 0.1D;

				ChinjufuMod.proxy.spawnParticle(ParticleTypes_CM.FALLICHOH, d0, d1, d2, d3, -d4, d5);
			}
		}
	}

	/* プレイヤーが設置したときは消失しない */
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		if (placer != null) {
			worldIn.setBlockState(pos, state.withProperty(DECAYABLE, Boolean.valueOf(false)), 4);
		}
	}

}
