package com.ayutaki.chinjufumod.blocks.furnace;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.dish.BaseIrori_Sakana;
import com.ayutaki.chinjufumod.blocks.dish.BaseNabe;
import com.ayutaki.chinjufumod.blocks.dish.Kettle_full;
import com.ayutaki.chinjufumod.blocks.dish.NabeCooked_SNT;
import com.ayutaki.chinjufumod.blocks.dish.NabeNama_1_TMGC;
import com.ayutaki.chinjufumod.blocks.dish.NabeNama_2_SNTA;
import com.ayutaki.chinjufumod.blocks.dish.Nabe_kara;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Irori extends Block {

	/* Property 0=無し, 1=薪, 2=鎮火 */
	public static final PropertyInteger STAGE_0_2 = PropertyInteger.create("stage", 0, 2);
	public static final PropertyBool DONABE = PropertyBool.create("donabe");

	public Irori(String name) {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);
		setCreativeTab(ChinjufuModTabs.TEATIME);

		setDefaultState(this.blockState.getBaseState()
				.withProperty(STAGE_0_2, Integer.valueOf(0))
				.withProperty(DONABE, Boolean.valueOf(false)));

		setSoundType(SoundType.METAL);
		setHardness(1.0F);
		setResistance(10.0F);
		setLightLevel(0.0F);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		int i = ((Integer)state.getValue(STAGE_0_2)).intValue();

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		int k;
		k = stack.getMetadata();

		if (item == Items.COAL && k == 1) {
			
			if (i == 0) {
				CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
				worldIn.setBlockState(pos, state.withProperty(STAGE_0_2, Integer.valueOf(1)), 3); } }
		
		if (item == Items.FLINT_AND_STEEL) {
			if (i == 1) {
				stack.damageItem(1, playerIn);
				CMEvents.soundFlint(worldIn, pos);
				worldIn.setBlockState(pos, Kitchen_Blocks.LIT_IRORI.getDefaultState()
						.withProperty(Lit_Irori.STAGE_0_7, Integer.valueOf(0)), 3); } }


		if (item == Items_Teatime.Item_MATCH) {
			if (i == 1) {
				CMEvents.Consume1Item_Flint(worldIn, pos, playerIn, hand);	
				worldIn.setBlockState(pos, Kitchen_Blocks.LIT_IRORI.getDefaultState()
						.withProperty(Lit_Irori.STAGE_0_7, Integer.valueOf(0)), 3); } }

		/** 魚の串焼き **/
		boolean hitNorth = (hitX > 0.3D) && (hitX < 0.7D) && (hitZ < 0.3D);
		boolean hitSouth = (hitX > 0.3D) && (hitX < 0.7D) && (hitZ > 0.7D);
		boolean hitEast = (hitX > 0.7D) && (hitZ > 0.3D) && (hitZ < 0.7D);
		boolean hitWest = (hitX < 0.3D) && (hitZ > 0.3D) && (hitZ < 0.7D);

		if (item == Items_Teatime.KUSHI_SAKANA && worldIn.getBlockState(pos.up()).getMaterial().isReplaceable()) {

			if (hitNorth == true) {
				CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
				worldIn.setBlockState(pos.up(), Dish_Blocks.IRORISAKANA_E2.getDefaultState()
					.withProperty(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(10))); }

			if (hitSouth == true) {
				CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
				worldIn.setBlockState(pos.up(), Dish_Blocks.IRORISAKANA_E1.getDefaultState()
					.withProperty(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(2))); }

			if (hitEast == true) {
				CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
				worldIn.setBlockState(pos.up(), Dish_Blocks.IRORISAKANA_E1.getDefaultState()
					.withProperty(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(8))); }

			if (hitWest == true) {
				CMEvents.Consume1Item_SnowP(worldIn, pos, playerIn, hand);
				worldIn.setBlockState(pos.up(), Dish_Blocks.IRORISAKANA_E1.getDefaultState()
					.withProperty(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(0))); }
		}
		
		/** No usable items. **/
		if ((item != Items.COAL || k != 1) && item != Items_Teatime.KUSHI_SAKANA && item != Items_Teatime.Item_MATCH && item != Items.FLINT_AND_STEEL) {
		
			if (stack.isEmpty()) {
				if (i == 2) {
					CMEvents.soundTake_Pick(worldIn, pos);
					playerIn.inventory.addItemStackToInventory(new ItemStack(Items.DYE, 1, 15));
					worldIn.setBlockState(pos, state.withProperty(STAGE_0_2, Integer.valueOf(0)), 3); }
				
				if (i != 2) { CMEvents.textNotHave(worldIn, pos, playerIn); } }

			if (!stack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		}
		
		/** 'true' to not put anything on top. **/
		return true;
	}


	/* 直上ブロックに対する返し */
	public boolean canConnectTo(IBlockAccess worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos).getBlock() instanceof Nabe_kara || worldIn
				.getBlockState(pos).getBlock() instanceof NabeNama_1_TMGC || worldIn
				.getBlockState(pos).getBlock() instanceof NabeNama_2_SNTA || worldIn
				.getBlockState(pos).getBlock() instanceof NabeCooked_SNT || worldIn
				.getBlockState(pos).getBlock() instanceof BaseNabe || worldIn
				.getBlockState(pos).getBlock() instanceof Kettle_full;
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return state.withProperty(DONABE, Boolean.valueOf(this.canConnectTo(worldIn, pos.up())));
	}

	/* Data value */
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(STAGE_0_2, Integer.valueOf(meta));
	}

	public int getMetaFromState(IBlockState state) {
		return ((Integer)state.getValue(STAGE_0_2)).intValue();
	}

	public int getComparatorInputOverride(IBlockState state, World worldIn, BlockPos pos) {
		return (1 - ((Integer)state.getValue(STAGE_0_2)).intValue()) * 2;
	}

	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { STAGE_0_2, DONABE });
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

	/* 描画の処理 */
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
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

		int i = ((Integer)state.getValue(STAGE_0_2)).intValue();

		if (i == 1) { stack.add(new ItemStack(Items_Teatime.IRORI, 1, 0)); }
		if (i != 1) { stack.add(new ItemStack(Items_Teatime.IRORI, 1, 0));
							stack.add(new ItemStack(Items.DYE, 1, 15)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Items_Teatime.IRORI, 1, 0);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_irori.name", meta));
	}
}
