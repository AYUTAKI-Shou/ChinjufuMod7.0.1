package com.ayutaki.chinjufumod.blocks.jpdeco;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.JPDeco_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class TatamiWood extends Block {
	
	/* Property */
	public static final PropertyInteger STAGE_0_8 = PropertyInteger.create("stage", 0, 8);

	public TatamiWood(String name) {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);
		
		setHardness(1.0F);
		setResistance(5.0F);
		setSoundType(SoundType.PLANT);
		
		setDefaultState(this.blockState.getBaseState().withProperty(STAGE_0_8, Integer.valueOf(0)));
		setLightOpacity(1);
	}

	/* Data value */
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(STAGE_0_8, Integer.valueOf(meta));
	}

	public int getMetaFromState(IBlockState state) {
		return ((Integer)state.getValue(STAGE_0_8)).intValue();
	}

	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { STAGE_0_8 });
	}

	/* Harvest by Pickaxe. */
	@Nullable
	@Override
	public String getHarvestTool(IBlockState state) {
		return "pickaxe";
	}

	@Override
	public int getHarvestLevel(IBlockState state) {
		return 0;
	}

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}
	
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		int i = ((Integer)state.getValue(STAGE_0_8)).intValue();
		
		if (this == JPDeco_Blocks.TATAMI_WOOD_ew || this == JPDeco_Blocks.TATAMI_WOOD_ns) { 
			stack.add(new ItemStack(Items_Wadeco.TATAMI, 1, 0)); }
		
		if (this == JPDeco_Blocks.TATAMIY_WOOD_ew || this == JPDeco_Blocks.TATAMIY_WOOD_ns) { 
			stack.add(new ItemStack(Items_Wadeco.TATAMIY, 1, 0)); }
		
		if (i == 0) { stack.add(new ItemStack(Blocks.WOODEN_SLAB, 1, 0)); }
		if (i == 1) { stack.add(new ItemStack(Blocks.WOODEN_SLAB, 1, 1)); }
		if (i == 2) { stack.add(new ItemStack(Blocks.WOODEN_SLAB, 1, 2)); }
		if (i == 3) { stack.add(new ItemStack(Blocks.WOODEN_SLAB, 1, 3)); }
		if (i == 4) { stack.add(new ItemStack(Blocks.WOODEN_SLAB, 1, 4)); }
		if (i == 5) { stack.add(new ItemStack(Blocks.WOODEN_SLAB, 1, 5)); }
		if (i == 6) { stack.add(new ItemStack(Items_Seasonal.SAKURA_slabhalf, 1, 0)); }
		if (i == 7) { stack.add(new ItemStack(Items_Seasonal.KAEDE_slabhalf, 1, 0)); }
		if (i == 8) { stack.add(new ItemStack(Items_Seasonal.ICHOH_slabhalf, 1, 0)); }

		return stack;
	}
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		if (this == JPDeco_Blocks.TATAMIY_WOOD_ew || this == JPDeco_Blocks.TATAMIY_WOOD_ns) { 
			return new ItemStack(Items_Wadeco.TATAMIY); }

		return new ItemStack(Items_Wadeco.TATAMI);
	}
}
