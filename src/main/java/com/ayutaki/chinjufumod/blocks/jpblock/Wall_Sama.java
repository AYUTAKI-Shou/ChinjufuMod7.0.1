package com.ayutaki.chinjufumod.blocks.jpblock;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.base.BaseStage4_Face;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.color.Base_ItemHake;
import com.ayutaki.chinjufumod.registry.Items_Wablock;
import com.ayutaki.chinjufumod.registry.JPBlock_Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Wall_Sama extends BaseStage4_Face {

	/* BoundingBox *//* Collision */
	private static final AxisAlignedBB AABB_NS = new AxisAlignedBB(0.0D, 0.0D, 0.3125D, 1.0D, 1.0D, 0.6875D);
	private static final AxisAlignedBB AABB_EW = new AxisAlignedBB(0.3125D, 0.0D, 0.0D, 0.6875D, 1.0D, 1.0D);
	
	public Wall_Sama(String name) {
		super(name);
		setCreativeTab(ChinjufuModTabs.WABLOCK);

		setSoundType(SoundType.STONE);
		setHardness(2.0F);
		setResistance(10.0F);
		setLightOpacity(1);
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		EnumFacing direction = state.getValue(H_FACING);
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		
		switch (direction) {
		case NORTH :
		default : return (i == 1 || i == 2)? AABB_NS : FULL_BLOCK_AABB;
		case SOUTH : return (i == 1 || i == 2)? AABB_NS : FULL_BLOCK_AABB;
		case EAST : return (i == 1 || i == 2)? AABB_EW : FULL_BLOCK_AABB;	
		case WEST : return (i == 1 || i == 2)? AABB_EW : FULL_BLOCK_AABB;
		} // switch
	}
	
	@Override 
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox,
			List<AxisAlignedBB> collidingBoxes, Entity entityIn, boolean t_f) {
		EnumFacing direction = state.getValue(H_FACING);
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		
		if (i == 1 || i == 2) {
			switch (direction) {
			case NORTH :
			default :
				addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_NS);
			case SOUTH :
				addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_NS);
			case EAST :
				addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_EW);
			case WEST :
				addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_EW);
			} // switch
		} //i == 1 || i == 2
		
		else {
			addCollisionBoxToList(pos, entityBox, collidingBoxes, FULL_BLOCK_AABB);
		}
	}
	
	/* Arrow pass. */
	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return NULL_AABB;
	}
	
	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (item instanceof Base_ItemHake) { return false; }
		
		if ((this == JPBlock_Blocks.DIRTWALL_SAMA && item == Items_Wablock.DIRTWALL_SAMA) ||
				(this == JPBlock_Blocks.SHIKKUI_SAMA_white && item == Items_Wablock.SHIKKUI_SAMA_white) ||
				(this == JPBlock_Blocks.SHIKKUI_SAMA_orange && item == Items_Wablock.SHIKKUI_SAMA_orange) ||
				(this == JPBlock_Blocks.SHIKKUI_SAMA_magenta && item == Items_Wablock.SHIKKUI_SAMA_magenta) ||
				(this == JPBlock_Blocks.SHIKKUI_SAMA_yellow && item == Items_Wablock.SHIKKUI_SAMA_yellow) ||
				(this == JPBlock_Blocks.SHIKKUI_SAMA_lime && item == Items_Wablock.SHIKKUI_SAMA_lime) ||
				(this == JPBlock_Blocks.SHIKKUI_SAMA_pink && item == Items_Wablock.SHIKKUI_SAMA_pink) ||
				(this == JPBlock_Blocks.SHIKKUI_SAMA_gray && item == Items_Wablock.SHIKKUI_SAMA_gray) ||
				(this == JPBlock_Blocks.SHIKKUI_SAMA_lightb && item == Items_Wablock.SHIKKUI_SAMA_lightb) ||
				(this == JPBlock_Blocks.SHIKKUI_SAMA_lightg && item == Items_Wablock.SHIKKUI_SAMA_lightg) ||
				(this == JPBlock_Blocks.SHIKKUI_SAMA_cyan && item == Items_Wablock.SHIKKUI_SAMA_cyan) ||
				(this == JPBlock_Blocks.SHIKKUI_SAMA_purple && item == Items_Wablock.SHIKKUI_SAMA_purple) ||
				(this == JPBlock_Blocks.SHIKKUI_SAMA_blue && item == Items_Wablock.SHIKKUI_SAMA_blue) ||
				(this == JPBlock_Blocks.SHIKKUI_SAMA_brown && item == Items_Wablock.SHIKKUI_SAMA_brown) ||
				(this == JPBlock_Blocks.SHIKKUI_SAMA_green && item == Items_Wablock.SHIKKUI_SAMA_green) ||
				(this == JPBlock_Blocks.SHIKKUI_SAMA_red && item == Items_Wablock.SHIKKUI_SAMA_red) ||
				(this == JPBlock_Blocks.SHIKKUI_SAMA_black && item == Items_Wablock.SHIKKUI_SAMA_black)) {
			
			if (i == 1 || i == 2) {
				CMEvents.Consume1Item_Stone(worldIn, pos, playerIn, hand);
				worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 2)), 10);
				return true; }
		}
			
		else {
			if (stack.isEmpty()) {
				if (playerIn.isSneaking()) {
					CMEvents.soundStonePlace(worldIn, pos);
					switch (i) {
					case 1 :
					default :
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 10);
						break;

					case 2 :
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i - 1)), 10);
						break;

					case 3 :
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 10);
						break;
						
					case 4 :
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i - 1)), 10);
						break;
					} // switch STAGE_1_4
				}
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

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		
		if (i == 1 || i == 2) { stack.add(new ItemStack(this.takeItem(), 1, 0)); }
		if (i != 1 && i != 2) { stack.add(new ItemStack(this.takeItem(), 2, 0)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(this.takeItem());
	}

	private Item takeItem() {
		if (this == JPBlock_Blocks.DIRTWALL_SAMA) { return Items_Wablock.DIRTWALL_SAMA; }
		if (this == JPBlock_Blocks.SHIKKUI_SAMA_white) { return Items_Wablock.SHIKKUI_SAMA_white; }
		if (this == JPBlock_Blocks.SHIKKUI_SAMA_orange) { return Items_Wablock.SHIKKUI_SAMA_orange; }
		if (this == JPBlock_Blocks.SHIKKUI_SAMA_magenta) { return Items_Wablock.SHIKKUI_SAMA_magenta; }
		if (this == JPBlock_Blocks.SHIKKUI_SAMA_lightb) { return Items_Wablock.SHIKKUI_SAMA_lightb; }
		if (this == JPBlock_Blocks.SHIKKUI_SAMA_yellow) { return Items_Wablock.SHIKKUI_SAMA_yellow; }
		if (this == JPBlock_Blocks.SHIKKUI_SAMA_lime) { return Items_Wablock.SHIKKUI_SAMA_lime; }
		if (this == JPBlock_Blocks.SHIKKUI_SAMA_pink) { return Items_Wablock.SHIKKUI_SAMA_pink; }
		if (this == JPBlock_Blocks.SHIKKUI_SAMA_gray) { return Items_Wablock.SHIKKUI_SAMA_gray; }
		if (this == JPBlock_Blocks.SHIKKUI_SAMA_lightg) { return Items_Wablock.SHIKKUI_SAMA_lightg; }
		if (this == JPBlock_Blocks.SHIKKUI_SAMA_cyan) { return Items_Wablock.SHIKKUI_SAMA_cyan; }
		if (this == JPBlock_Blocks.SHIKKUI_SAMA_purple) { return Items_Wablock.SHIKKUI_SAMA_purple; }
		if (this == JPBlock_Blocks.SHIKKUI_SAMA_blue) { return Items_Wablock.SHIKKUI_SAMA_blue; }
		if (this == JPBlock_Blocks.SHIKKUI_SAMA_brown) { return Items_Wablock.SHIKKUI_SAMA_brown; }
		if (this == JPBlock_Blocks.SHIKKUI_SAMA_green) { return Items_Wablock.SHIKKUI_SAMA_green; }
		if (this == JPBlock_Blocks.SHIKKUI_SAMA_red) { return Items_Wablock.SHIKKUI_SAMA_red; }
		if (this == JPBlock_Blocks.SHIKKUI_SAMA_black) { return Items_Wablock.SHIKKUI_SAMA_black; }
		return null;
	}
	
	/* ToolTip*/
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_sama.name", meta));
	}
}
