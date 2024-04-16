package com.ayutaki.chinjufumod.blocks.garden;

import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage4_Face;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Garden_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.SoundType;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Longtourou_Top extends BaseStage4_Face {

	public Longtourou_Top(String name) {
		super(name);
		setSoundType(SoundType.STONE);
		setHardness(1.0F);
		setResistance(5.0F);
		setLightOpacity(1);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (item == Items.FLINT_AND_STEEL) {
			CMEvents.soundFlint(worldIn, pos);

			if (i == 1) {
				worldIn.setBlockState(pos, Garden_Blocks.LIT_LONGTOUROU_TOP.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(Lit_Longtourou.STAGE_1_4, Integer.valueOf(1))); }

			if (i == 2) {
				worldIn.setBlockState(pos, Garden_Blocks.LIT_LONGTOUROU_TOP.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(Lit_Longtourou.STAGE_1_4, Integer.valueOf(2))); }


			if (i == 3) {
				worldIn.setBlockState(pos, Garden_Blocks.LIT_LONGTOUROU_TOP.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(Lit_Longtourou.STAGE_1_4, Integer.valueOf(3))); }

			if (i == 4) {
				worldIn.setBlockState(pos, Garden_Blocks.LIT_LONGTOUROU_TOP.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(Lit_Longtourou.STAGE_1_4, Integer.valueOf(4))); }

			stack.damageItem(1, playerIn); }

		if (item == Items_Teatime.Item_MATCH) {
			CMEvents.Consume1Item_Flint(worldIn, pos, playerIn, hand);	

			if (i == 1) {
				worldIn.setBlockState(pos, Garden_Blocks.LIT_LONGTOUROU_TOP.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(Lit_Longtourou.STAGE_1_4, Integer.valueOf(1))); }

			if (i == 2) {
				worldIn.setBlockState(pos, Garden_Blocks.LIT_LONGTOUROU_TOP.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(Lit_Longtourou.STAGE_1_4, Integer.valueOf(2))); }


			if (i == 3) {
				worldIn.setBlockState(pos, Garden_Blocks.LIT_LONGTOUROU_TOP.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(Lit_Longtourou.STAGE_1_4, Integer.valueOf(3))); }

			if (i == 4) {
				worldIn.setBlockState(pos, Garden_Blocks.LIT_LONGTOUROU_TOP.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(Lit_Longtourou.STAGE_1_4, Integer.valueOf(4))); } }
		
		if (item != Items.FLINT_AND_STEEL && item != Items_Teatime.Item_MATCH) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		
		/** 'true' to not put anything on top. **/
		return true;
	}

	/* A block that breaks at the same time when it is broken. */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn) {
		if (worldIn.getBlockState(pos.down()).getBlock() instanceof Longtourou_Bottom) {
			if (playerIn.capabilities.isCreativeMode) { worldIn.destroyBlock(pos.down(), false); }
			else { worldIn.destroyBlock(pos.down(), true); }
		}
	}

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}
	
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Items.AIR;
	}
	
	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 0.875D, 0.875D);
	}

	/* A torch can be placed on top. true or false */
	@Override
	public boolean isTopSolid(IBlockState state) {
		return false;
	}

	/* A torch can be placed on the side. */
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
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
}
