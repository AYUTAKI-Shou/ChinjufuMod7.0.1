package com.ayutaki.chinjufumod.items.jpdeco;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.garden.Kido;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.doors.Door_Blocks;
import com.ayutaki.chinjufumod.state.HalfState;
import com.ayutaki.chinjufumod.state.HingeState;

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

public class Kido_Item extends Item {

	public Kido_Item(String name) {
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
			return "item." + "block_kido";
		case 1:
			return "item." + "block_kido_spruce";
		case 2:
			return "item." + "block_kido_birch";
		case 3:
			return "item." + "block_kido_jungle";
		case 4:
			return "item." + "block_kido_acacia";
		case 5:
			return "item." + "block_kido_darkoak";
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
					placeDoor_right(worldIn, pos, direction, this.takeBlock(playerIn, hand));
					CMEvents.Consume_1Wood(worldIn, pos, playerIn, hand);
					return EnumActionResult.SUCCESS; }

				/** デフォルトは left。右取手・左蝶番で開くのが hinge=left **/
				else {
					placeDoor_left(worldIn, pos, direction, this.takeBlock(playerIn, hand));
					CMEvents.Consume_1Wood(worldIn, pos, playerIn, hand);
					return EnumActionResult.SUCCESS; }
			}

			else { return EnumActionResult.FAIL; }
		}
	}

	/* put_1 */
	public static void placeDoor_right(World worldIn, BlockPos pos, EnumFacing facing, Block door) {

		BlockPos upPos = pos.up();
		boolean flag2 = worldIn.isBlockPowered(pos) || worldIn.isBlockPowered(upPos);
		IBlockState state = door.getDefaultState().withProperty(Kido.H_FACING, facing)
				.withProperty(Kido.HINGE, HingeState.RIGHT)
				.withProperty(Kido.POWERED, Boolean.valueOf(flag2))
				.withProperty(Kido.OPEN, Boolean.valueOf(flag2));
		worldIn.setBlockState(pos, state.withProperty(Kido.HALF, HalfState.LOWER), 2);
		worldIn.setBlockState(upPos, state.withProperty(Kido.HALF, HalfState.UPPER), 2);
		worldIn.notifyNeighborsOfStateChange(pos, door, false);
		worldIn.notifyNeighborsOfStateChange(upPos, door, false);
	}

	/* put_2 */
	public static void placeDoor_left(World worldIn, BlockPos pos, EnumFacing facing, Block door) {

		BlockPos upPos = pos.up();
		boolean flag2 = worldIn.isBlockPowered(pos) || worldIn.isBlockPowered(upPos);
		IBlockState state = door.getDefaultState().withProperty(Kido.H_FACING, facing)
				.withProperty(Kido.HINGE, HingeState.LEFT)
				.withProperty(Kido.POWERED, Boolean.valueOf(flag2))
				.withProperty(Kido.OPEN, Boolean.valueOf(flag2));
		worldIn.setBlockState(pos, state.withProperty(Kido.HALF, HalfState.LOWER), 2);
		worldIn.setBlockState(upPos, state.withProperty(Kido.HALF, HalfState.UPPER), 2);
		worldIn.notifyNeighborsOfStateChange(pos, door, false);
		worldIn.notifyNeighborsOfStateChange(upPos, door, false);
	}

	private Block takeBlock(EntityPlayer playerIn, EnumHand hand) {
		ItemStack stack = playerIn.getHeldItem(hand);
		int k;
		k = stack.getMetadata();
		
		if (k == 0) { return Door_Blocks.KIDO; }
		if (k == 1) { return Door_Blocks.KIDO_spruce; }
		if (k == 2) { return Door_Blocks.KIDO_birch; }
		if (k == 3) { return Door_Blocks.KIDO_jungle; }
		if (k == 4) { return Door_Blocks.KIDO_acacia; }
		if (k == 5) { return Door_Blocks.KIDO_darkoak; }
		return null;
	}
	
	
	/* tips */
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_window.name", meta));
	}
}
