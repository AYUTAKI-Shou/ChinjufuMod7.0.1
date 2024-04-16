package com.ayutaki.chinjufumod.items.jpdeco;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.garden.Itabei;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Garden_Blocks;
import com.ayutaki.chinjufumod.state.HalfState;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Itabei_Item extends Item {

	public Itabei_Item(String name) {
		super();
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setCreativeTab(ChinjufuModTabs.WADECO);
		/** Have sub items. **/
		setHasSubtypes(true);
	}

	@Override
	public int getItemBurnTime(ItemStack stack) {
		return 200;
	}

	/* Sub item meta and name. */
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		switch (stack.getMetadata()) {
		case 0:
		default:
			return "item." + "block_itabei";
		case 1:
			return "item." + "block_itabei_spruce";
		case 2:
			return "item." + "block_itabei_birch";
		case 3:
			return "item." + "block_itabei_jungle";
		case 4:
			return "item." + "block_itabei_acacia";
		case 5:
			return "item." + "block_itabei_darkoak";
		}
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			items.add(new ItemStack(this, 1, 0));
			items.add(new ItemStack(this, 1, 1));
			items.add(new ItemStack(this, 1, 2));
			items.add(new ItemStack(this, 1, 3));
			items.add(new ItemStack(this, 1, 4));
			items.add(new ItemStack(this, 1, 5));
		}
	}
	
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {

		if (facing != EnumFacing.UP) { return EnumActionResult.FAIL; }

		else {
			IBlockState state = worldIn.getBlockState(pos);
			Block block = state.getBlock();

			if (!block.isReplaceable(worldIn, pos)) { pos = pos.offset(facing); }

			ItemStack stack = playerIn.getHeldItem(hand);
			EnumFacing direction = EnumFacing.fromAngle((double)playerIn.rotationYaw);
			
			/** Put "this.block". **/
			if (playerIn.canPlayerEdit(pos, facing, stack) && this.takeBlock(playerIn, hand).canPlaceBlockAt(worldIn, pos)) {

				if (playerIn.isSneaking()) {
					placeTrue(worldIn, pos, direction, this.takeBlock(playerIn, hand));
					CMEvents.Consume_1Wood(worldIn, pos, playerIn, hand);
					return EnumActionResult.SUCCESS; }
				
				else { 
					placeFalse(worldIn, pos, direction, this.takeBlock(playerIn, hand));
					CMEvents.Consume_1Wood(worldIn, pos, playerIn, hand);
					return EnumActionResult.SUCCESS; }
			}

			else { return EnumActionResult.FAIL; }
		}
	}

	/* put_1 */
	public static void placeFalse(World worldIn, BlockPos pos, EnumFacing facing, Block block) {
		BlockPos upPos = pos.up();
		IBlockState state = block.getDefaultState().withProperty(Itabei.H_FACING, facing).withProperty(Itabei.CHECK, false);
		worldIn.setBlockState(pos, state.withProperty(Itabei.HALF, HalfState.LOWER), 2);
		worldIn.setBlockState(upPos, state.withProperty(Itabei.HALF, HalfState.UPPER), 2);
	}

	/* put_2 */
	public static void placeTrue(World worldIn, BlockPos pos, EnumFacing facing, Block block) {
		BlockPos upPos = pos.up();
		IBlockState state = block.getDefaultState().withProperty(Itabei.H_FACING, facing).withProperty(Itabei.CHECK,true);
		worldIn.setBlockState(pos, state.withProperty(Itabei.HALF, HalfState.LOWER), 2);
		worldIn.setBlockState(upPos, state.withProperty(Itabei.HALF, HalfState.UPPER), 2);
	}
	
	private Block takeBlock(EntityPlayer playerIn, EnumHand hand) {
		ItemStack stack = playerIn.getHeldItem(hand);
		int k;
		k = stack.getMetadata();
		
		if (k == 0) { return Garden_Blocks.ITABEI; }
		if (k == 1) { return Garden_Blocks.ITABEI_spruce; }
		if (k == 2) { return Garden_Blocks.ITABEI_birch; }
		if (k == 3) { return Garden_Blocks.ITABEI_jungle; }
		if (k == 4) { return Garden_Blocks.ITABEI_acacia; }
		if (k == 5) { return Garden_Blocks.ITABEI_darkoak; }
		return null;
	}
	
	/* tips */
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_kanyou.name", meta));
	}
}