package com.ayutaki.chinjufumod.blocks.wood;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.doors.Door_Blocks;

import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class FenceGate_CM extends BlockFenceGate {

	public FenceGate_CM(String name) {
		super(BlockPlanks.EnumType.OAK);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);

		setSoundType(SoundType.WOOD);
		setHardness(2.0F);
		setResistance(5.0F);
		setLightOpacity(1);

		/** Registry **/
		ForgeRegistries.BLOCKS.register(this);
	}

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		stack.add(this.takeStack());
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return this.takeStack();
	}

	public ItemStack takeStack() {
		if (this == Door_Blocks.SAKURA_FGATE) { return new ItemStack(Items_Seasonal.S_FGATE, 1, 0); }
		if (this == Door_Blocks.KAEDE_FGATE) { return new ItemStack(Items_Seasonal.S_FGATE, 1, 1); }
		if (this == Door_Blocks.ICHOH_FGATE) { return new ItemStack(Items_Seasonal.S_FGATE, 1, 2); }
		return null;
	}
}
