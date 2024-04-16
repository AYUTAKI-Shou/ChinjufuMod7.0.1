package com.ayutaki.chinjufumod.blocks.wallpane;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Wablock;
import com.ayutaki.chinjufumod.registry.Items_WallPane;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Bricks_CM extends Block {

	/* Property */
	/** 1=レンガGRA, 2=レンガDIO, 3=レンガAND, 
	** 4=GRA_CH, 5=DIO_CH, 6=AND_CH, 
	** 7=GRA_CR, 8=DIO_CR, 9=AND_CR, 
	** 10=GRA_MOS, 11=DIO_MOS, 12=AND_MOS, 
	** 13=土壁, 14=土壁_CR **/
	public static final PropertyInteger STAGE_1_14 = PropertyInteger.create("stage", 1, 14);

	public Bricks_CM(String name) {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);
		
		setSoundType(SoundType.STONE);
		setHardness(2.0F);
		setResistance(10.0F);

		setDefaultState(this.blockState.getBaseState().withProperty(STAGE_1_14, Integer.valueOf(1)));
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack stack = playerIn.getHeldItem(hand);
		int i = ((Integer)state.getValue(STAGE_1_14)).intValue();

		if (i >= 13) {
			if (stack.isEmpty()) {
				if (playerIn.isSneaking()) {
					CMEvents.soundStonePlace(worldIn, pos);
		
					if (i == 13) { worldIn.setBlockState(pos, state.withProperty(Bricks_CM.STAGE_1_14, Integer.valueOf(14))); }
					if (i == 14) { worldIn.setBlockState(pos, state.withProperty(Bricks_CM.STAGE_1_14, Integer.valueOf(13))); } }
				return true;
			}
		}
		return false;
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

	/* Data value */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(STAGE_1_14, Integer.valueOf(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((Integer)state.getValue(STAGE_1_14)).intValue();
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { STAGE_1_14 });
	}

	/* Rendering */

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		int i = ((Integer)state.getValue(STAGE_1_14)).intValue();

		if (i == 1) { stack.add(new ItemStack(Items_WallPane.BRICK_C, 1, 1)); }
		if (i == 2) { stack.add(new ItemStack(Items_WallPane.BRICK_C, 1, 2)); }
		if (i == 3) { stack.add(new ItemStack(Items_WallPane.BRICK_C, 1, 3)); }
		if (i == 4) { stack.add(new ItemStack(Items_WallPane.BRICK_C, 1, 4)); }
		if (i == 5) { stack.add(new ItemStack(Items_WallPane.BRICK_C, 1, 5)); }
		if (i == 6) { stack.add(new ItemStack(Items_WallPane.BRICK_C, 1, 6)); }
		if (i == 7) { stack.add(new ItemStack(Items_WallPane.BRICK_C, 1, 7)); }
		if (i == 8) { stack.add(new ItemStack(Items_WallPane.BRICK_C, 1, 8)); }
		if (i == 9) { stack.add(new ItemStack(Items_WallPane.BRICK_C, 1, 9)); }
		if (i == 10) { stack.add(new ItemStack(Items_WallPane.BRICK_C, 1, 10)); }
		if (i == 11) { stack.add(new ItemStack(Items_WallPane.BRICK_C, 1, 11)); }
		if (i == 12) { stack.add(new ItemStack(Items_WallPane.BRICK_C, 1, 12)); }
		if (i == 13) { stack.add(new ItemStack(Items_Wablock.DIRTWALL, 1, 0)); }
		if (i == 14) { stack.add(new ItemStack(Items_Wablock.DIRTWALL, 1, 0)); }

		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {

		int i = ((Integer)state.getValue(STAGE_1_14)).intValue();

		if (i == 2) { return new ItemStack(Items_WallPane.BRICK_C, 1, 2); }
		if (i == 3) { return new ItemStack(Items_WallPane.BRICK_C, 1, 3); }
		if (i == 4) { return new ItemStack(Items_WallPane.BRICK_C, 1, 4); }
		if (i == 5) { return new ItemStack(Items_WallPane.BRICK_C, 1, 5); }
		if (i == 6) { return new ItemStack(Items_WallPane.BRICK_C, 1, 6); }
		if (i == 7) { return new ItemStack(Items_WallPane.BRICK_C, 1, 7); }
		if (i == 8) { return new ItemStack(Items_WallPane.BRICK_C, 1, 8); }
		if (i == 9) { return new ItemStack(Items_WallPane.BRICK_C, 1, 9); }
		if (i == 10) { return new ItemStack(Items_WallPane.BRICK_C, 1, 10); }
		if (i == 11) { return new ItemStack(Items_WallPane.BRICK_C, 1, 11); }
		if (i == 12) { return new ItemStack(Items_WallPane.BRICK_C, 1, 12); }
		if (i == 13) { return new ItemStack(Items_Wablock.DIRTWALL); }
		if (i == 14) { return new ItemStack(Items_Wablock.DIRTWALL); }
		return new ItemStack(Items_WallPane.BRICK_C, 1, 1);
	}

}
