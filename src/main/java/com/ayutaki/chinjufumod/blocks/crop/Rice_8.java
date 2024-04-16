package com.ayutaki.chinjufumod.blocks.crop;

import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.wood.Suiden;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Rice_8 extends Block implements IGrowable {

	public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 8);

	protected static final double cw = 0.0625;
	private static final AxisAlignedBB[] CROPS_AABB = new AxisAlignedBB[] { new AxisAlignedBB(0.0D * cw, -1.0D * cw, 0.0D * cw, 16.0D * cw, 2.0D * cw, 16.0D * cw),
			new AxisAlignedBB(2.0D * cw, -1.0D * cw, 2.0D * cw, 14.0D * cw, 5.0D * cw, 14.0D * cw),
			new AxisAlignedBB(2.0D * cw, -1.0D * cw, 2.0D * cw, 14.0D * cw, 7.0D * cw, 14.0D * cw),
			new AxisAlignedBB(2.0D * cw, -1.0D * cw, 2.0D * cw, 14.0D * cw, 10.0D * cw, 14.0D * cw),
			new AxisAlignedBB(2.0D * cw, -1.0D * cw, 2.0D * cw, 14.0D * cw, 12.0D * cw, 14.0D * cw),
			new AxisAlignedBB(2.0D * cw, -1.0D * cw, 2.0D * cw, 14.0D * cw, 15.0D * cw, 14.0D * cw),
			new AxisAlignedBB(2.0D * cw, -1.0D * cw, 2.0D * cw, 14.0D * cw, 15.0D * cw, 14.0D * cw),
			new AxisAlignedBB(2.0D * cw, -1.0D * cw, 2.0D * cw, 14.0D * cw, 15.0D * cw, 14.0D * cw),
			new AxisAlignedBB(2.0D * cw, -1.0D * cw, 2.0D * cw, 14.0D * cw, 15.0D * cw, 14.0D * cw) };

	public Rice_8(String name) {
		super(Material.PLANTS);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);

		setSoundType(SoundType.PLANT);
		setHardness(0.1F);
		setResistance(0.1F);
		setLightOpacity(0);
	}

	/* RandomTick */
	@Override
	public int tickRate(World worldIn) {
		/** 1000tick = Minecraft内 1h = リアル時間 50秒 **/
		return 4500;
	}
	
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		super.onBlockAdded(worldIn, pos, state);
		worldIn.scheduleUpdate(pos, Crop_Blocks.RICE_8, this.tickRate(worldIn) + (500 * worldIn.rand.nextInt(5)));
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		super.updateTick(worldIn, pos, state, rand);

		int i = ((Integer)state.getValue(AGE)).intValue();

		if (worldIn.getLightFromNeighbors(pos.up()) >= 9) {

			if (i <= 4) {
				worldIn.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(i + 1))); }

			if (i == 5) {
				worldIn.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(i + 1)));
				worldIn.setBlockState(pos.down(), Seasonal_Blocks.SUIDEN.getDefaultState()
						.withProperty(Suiden.WET_1_7, Integer.valueOf(3))); }

			if (i == 6 || i == 7) {
				worldIn.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(i + 1)));
				worldIn.setBlockState(pos.down(), Seasonal_Blocks.SUIDEN.getDefaultState()
						.withProperty(Suiden.WET_1_7, Integer.valueOf(4))); }

			if (i == 8) {
				worldIn.setBlockState(pos.down(), Seasonal_Blocks.SUIDEN.getDefaultState()
					.withProperty(Suiden.WET_1_7, Integer.valueOf(4))); }
		}

		worldIn.scheduleUpdate(pos, Crop_Blocks.RICE_8, this.tickRate(worldIn) + (500 * rand.nextInt(5)));
	}

	/* Change DownBlock. */
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block neighborBlock, BlockPos fromPos) {

		if (worldIn.getBlockState(pos.down()).getBlock() != Seasonal_Blocks.SUIDEN) {
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockToAir(pos);
		}

		else { }
	}

	protected boolean canSustainBush(IBlockState state) {
		return state.getBlock() == Seasonal_Blocks.SUIDEN;
	}

	/* RandomTick段階 */
	protected PropertyInteger getAgeProperty() {
		return AGE;
	}

	public int getMaxAge() {
		return 8;
	}

	protected int getAge(IBlockState state) {
		return ((Integer)state.getValue(this.getAgeProperty())).intValue();
	}

	public IBlockState withAge(int age) {
		return this.getDefaultState().withProperty(this.getAgeProperty(), Integer.valueOf(age));
	}

	public boolean isMaxAge(IBlockState state) {
		return ((Integer)state.getValue(this.getAgeProperty())).intValue() >= this.getMaxAge();
	}

	/* Data value */
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { AGE });
	}

	public int getComparatorInputOverride(IBlockState state, World worldIn, BlockPos pos) {
		return (8 - ((Integer)state.getValue(AGE)).intValue()) * 2;
	}

	/* Collision */
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return CROPS_AABB[((Integer)state.getValue(this.getAgeProperty())).intValue()];
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		/** Have no collision. **/
		return NULL_AABB;
	}

	/* 骨粉 */
	public void grow(World worldIn, BlockPos pos, IBlockState state) {
		int i = this.getAge(state) + this.getBonemealAgeIncrease(worldIn);
		int j = this.getMaxAge();

		if (i > j) { i = j; }

		if (i == 6) {
			worldIn.setBlockState(pos, this.withAge(i));
			worldIn.setBlockState(pos.down(), Seasonal_Blocks.SUIDEN.getDefaultState()
					.withProperty(Suiden.WET_1_7, Integer.valueOf(3))); }

		if (i == 7) {
			worldIn.setBlockState(pos, this.withAge(i));
			worldIn.setBlockState(pos.down(), Seasonal_Blocks.SUIDEN.getDefaultState()
					.withProperty(Suiden.WET_1_7, Integer.valueOf(4))); }

		if (i == 8) {
			worldIn.setBlockState(pos, this.withAge(i));
			worldIn.setBlockState(pos.down(), Seasonal_Blocks.SUIDEN.getDefaultState()
					.withProperty(Suiden.WET_1_7, Integer.valueOf(4))); }

		else { worldIn.setBlockState(pos, this.withAge(i)); }
	}

	protected int getBonemealAgeIncrease(World worldIn) {
		return MathHelper.getInt(worldIn.rand, 2, 5);
	}

	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
		return !this.isMaxAge(state);
	}

	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		int i = this.getAge(state);
		return (i == this.getMaxAge())? false : true;
	}

	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		this.grow(worldIn, pos, state);
	}

	public IBlockState getStateFromMeta(int meta) {
		return this.withAge(meta);
	}

	public int getMetaFromState(IBlockState state) {
		return this.getAge(state);
	}

	/* Render */
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	/*Drop Item and Clone Item.*/
	protected Item getSeed() {
		return Items_Teatime.SEEDS_RICE;
	}

	protected Item getCrop() {
		return Items_Teatime.INE;
	}

	@Override
	public void getDrops(net.minecraft.util.NonNullList<ItemStack> drops, net.minecraft.world.IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		super.getDrops(drops, world, pos, state, 0);

		int age = getAge(state);
		Random rand = world instanceof World ? ((World)world).rand : new Random();

		if (age == 7) {
			int k = 3 + fortune;

			for (int i = 0; i < k; ++i) {
				if (rand.nextInt(2 * 7) <= age) { drops.add(new ItemStack(this.getSeed(), 1, 0)); }
			}
		}

		if (age == 8) {
			int k = 3 + fortune;

			for (int i = 0; i < k; ++i) {
				if (rand.nextInt(2 * 8) <= age) { drops.add(new ItemStack(this.getSeed(), this.getSeedsRand(world), 0)); }
			}
		}
	}

	protected int getSeedsRand(IBlockAccess world) {
		return MathHelper.getInt(((World)world).rand, 1, 2);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ((Integer)state.getValue(AGE)).intValue() >= 7 ? this.getCrop() : this.getSeed();
	}

	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(this.getSeed());
	}

	/* Do not connect to a Fence. */
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

}
