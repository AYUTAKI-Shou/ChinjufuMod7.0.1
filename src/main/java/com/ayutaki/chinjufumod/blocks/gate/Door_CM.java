package com.ayutaki.chinjufumod.blocks.gate;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.doors.Door_Blocks;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class Door_CM extends BlockDoor {

	public Door_CM(String name) {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);

		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(10.0F);

		/** Registry **/
		ForgeRegistries.BLOCKS.register(this);
	}

	/* Control the drop item. */
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		
		if (state.getValue(HALF) != BlockDoor.EnumDoorHalf.LOWER) { stack.add(new ItemStack(Items.AIR, 1, 0)); }
		if (state.getValue(HALF) == BlockDoor.EnumDoorHalf.LOWER) { stack.add(this.takeStack()); }
		return stack;
	}
	
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return this.takeStack();
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return this.takeStack();
	}
	
	private ItemStack takeStack() {
		if (this == Door_Blocks.DOOR_SAKURA) { return new ItemStack(Items_Seasonal.S_DOOR, 1 ,0); }
		if (this == Door_Blocks.DOOR_KAEDE) { return new ItemStack(Items_Seasonal.S_DOOR, 1 ,1); }
		if (this == Door_Blocks.DOOR_ICHOH) { return new ItemStack(Items_Seasonal.S_DOOR, 1 ,2); }
		if (this == Door_Blocks.TAKEDOOR) { return new ItemStack(Items_Wadeco.TAKEDOOR, 1 ,0); }
		if (this == Door_Blocks.TAKEDOOR_Y) { return new ItemStack(Items_Wadeco.TAKEDOOR, 1 ,1); }
		if (this == Door_Blocks.TAKEDOOR_K) { return new ItemStack(Items_Wadeco.TAKEDOOR, 1 ,2); }
		return null;
	}
}
