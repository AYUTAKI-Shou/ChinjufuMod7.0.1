package com.ayutaki.chinjufumod.blocks.wood;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Planks_CM extends Block {

	/* Property */
	/** 1=サクラ, 2=カエデ, 3=イチョウ **/
	public static final PropertyInteger STAGE_1_3 = PropertyInteger.create("stage", 1, 3);

	public Planks_CM(String name) {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);

		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(10.0F);

		setDefaultState(this.blockState.getBaseState().withProperty(STAGE_1_3, Integer.valueOf(1)));
	}

	/* RightClick Action */

	/* Collision */

	/* Data value */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(STAGE_1_3, Integer.valueOf(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((Integer)state.getValue(STAGE_1_3)).intValue();
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { STAGE_1_3 });
	}

	/* Rendering */

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		int i = ((Integer)state.getValue(STAGE_1_3)).intValue();

		if (i == 1) { stack.add(new ItemStack(Items_Seasonal.PLANKS_sakura, 1, 0)); }
		if (i == 2) { stack.add(new ItemStack(Items_Seasonal.PLANKS_kaede, 1, 0)); }
		if (i == 3) { stack.add(new ItemStack(Items_Seasonal.PLANKS_ichoh, 1, 0)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {

		int i = ((Integer)state.getValue(STAGE_1_3)).intValue();

		if (i == 2) { return new ItemStack(Items_Seasonal.PLANKS_kaede); }
		if (i == 3) { return new ItemStack(Items_Seasonal.PLANKS_ichoh); }
		return new ItemStack(Items_Seasonal.PLANKS_sakura);
	}

}

