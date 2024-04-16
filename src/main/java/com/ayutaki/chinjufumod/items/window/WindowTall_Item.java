package com.ayutaki.chinjufumod.items.window;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.window.WindowTall;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Window_Blocks;
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

public class WindowTall_Item extends Item {

	public WindowTall_Item(String name) {
		super();
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setCreativeTab(ChinjufuModTabs.CHINJUFU);
		/** Have sub items. **/
		setHasSubtypes(true);
	}

	/* Sub item meta and name. */
	@Override
	public String getUnlocalizedName(ItemStack stack) {

		switch (stack.getMetadata()) {
		case 0:
		default:
			return "item." + "block_windowtall";
		case 1:
			return "item." + "block_windowtall_spruce";
		case 2:
			return "item." + "block_windowtall_birch";
		case 3:
			return "item." + "block_windowtall_jungle";
		case 4:
			return "item." + "block_windowtall_acacia";
		case 5:
			return "item." + "block_windowtall_darkoak";
		case 6:
			return "item." + "block_windowtall_sakura";
		case 7:
			return "item." + "block_windowtall_kaede";
		case 8:
			return "item." + "block_windowtall_ichoh";
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
			items.add(new ItemStack(this, 1, 6));
			items.add(new ItemStack(this, 1, 7));
			items.add(new ItemStack(this, 1, 8));
		}
	}

	/* Place block */
	@Override
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {

		IBlockState state = worldIn.getBlockState(pos);
		Block block = state.getBlock();

		if (!block.isReplaceable(worldIn, pos)) { pos = pos.offset(facing); }

		ItemStack stack = playerIn.getHeldItem(hand);
		EnumFacing direction = EnumFacing.fromAngle((double)playerIn.rotationYaw);
		
		/** Put "this.block". **/
		if (playerIn.canPlayerEdit(pos, facing, stack) && this.takeBlock(playerIn, hand).canPlaceBlockAt(worldIn, pos)) {

			if (playerIn.isSneaking()) {
				placeWindow_right(worldIn, pos, direction, this.takeBlock(playerIn, hand));
				CMEvents.Consume_1Wood(worldIn, pos, playerIn, hand);
				return EnumActionResult.SUCCESS;
			}

			/** デフォルトは left。右取手・左蝶番で開くのが hinge=left **/
			else {
				placeWindow_left(worldIn, pos, direction, this.takeBlock(playerIn, hand));
				CMEvents.Consume_1Wood(worldIn, pos, playerIn, hand);
				return EnumActionResult.SUCCESS;
			}
		}

		else { return EnumActionResult.FAIL; }
	}

	/* put_1 */
	public static void placeWindow_right(World worldIn, BlockPos pos, EnumFacing facing, Block door) {

		BlockPos upPos = pos.up();
		IBlockState state = door.getDefaultState().withProperty(WindowTall.H_FACING, facing)
				.withProperty(WindowTall.HINGE, HingeState.RIGHT)
				.withProperty(WindowTall.OPEN, Boolean.valueOf(false));
		worldIn.setBlockState(pos, state.withProperty(WindowTall.HALF, HalfState.LOWER), 2);
		worldIn.setBlockState(upPos, state.withProperty(WindowTall.HALF, HalfState.UPPER), 2);
	}

	/* put_2 */
	public static void placeWindow_left(World worldIn, BlockPos pos, EnumFacing facing, Block door) {

		BlockPos upPos = pos.up();
		IBlockState state = door.getDefaultState().withProperty(WindowTall.H_FACING, facing)
				.withProperty(WindowTall.HINGE, HingeState.LEFT)
				.withProperty(WindowTall.OPEN, Boolean.valueOf(false));
		worldIn.setBlockState(pos, state.withProperty(WindowTall.HALF, HalfState.LOWER), 2);
		worldIn.setBlockState(upPos, state.withProperty(WindowTall.HALF, HalfState.UPPER), 2);
	}
	
	private Block takeBlock(EntityPlayer playerIn, EnumHand hand) {
		ItemStack stack = playerIn.getHeldItem(hand);
		int k;
		k = stack.getMetadata();

		if (k == 0) { return Window_Blocks.WINDOWTALL_oak; }
		if (k == 1) { return Window_Blocks.WINDOWTALL_spruce; }
		if (k == 2) { return Window_Blocks.WINDOWTALL_birch; }
		if (k == 3) { return Window_Blocks.WINDOWTALL_jungle; }
		if (k == 4) { return Window_Blocks.WINDOWTALL_acacia; }
		if (k == 5) { return Window_Blocks.WINDOWTALL_darkoak; }
		if (k == 6) { return Window_Blocks.WINDOWTALL_sakura; }
		if (k == 7) { return Window_Blocks.WINDOWTALL_kaede; }
		if (k == 8) { return Window_Blocks.WINDOWTALL_ichoh; }
		return null;
	}
	
	/* ToolTip */
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_window.name", meta));
	}
}
