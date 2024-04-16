package com.ayutaki.chinjufumod.blocks.furnace;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Furniture_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;
import com.ayutaki.chinjufumod.tileentity.KitOven_TileEntity;

import net.minecraft.block.BlockCarpet;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Kitchen_Oven extends BlockContainer {

	public static final PropertyDirection H_FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	private final boolean isBurning;
	private static boolean keepInventory;

	public Kitchen_Oven(boolean isBurning, String name) {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);
		setCreativeTab(ChinjufuModTabs.TEATIME);

		setSoundType(SoundType.METAL);
		setHardness(1.0F);
		setResistance(10.0F);
		setLightOpacity(1);

		setDefaultState(this.blockState.getBaseState().withProperty(H_FACING, EnumFacing.NORTH));
		this.isBurning = isBurning;

		if (isBurning) {
			/* Glow Stone=1.0F, Torch=0.9375F */
			setLightLevel(0.875F);
		}
	}

	/* You will take damage if you walk on it. */
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {

		if (isBurning) {
			if (!(entityIn.isImmuneToFire()) && entityIn instanceof EntityLivingBase &&
					!(EnchantmentHelper.hasFrostWalkerEnchantment((EntityLivingBase)entityIn))) {
				entityIn.attackEntityFrom(DamageSource.HOT_FLOOR, 1.0F); }
		super.onEntityWalk(worldIn, pos, entityIn);
		}
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

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Items_Teatime.KIT_OVEN;
	}

	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		this.setDefaultFacing(worldIn, pos, state);
	}

	private void setDefaultFacing(World worldIn, BlockPos pos, IBlockState state) {

		if (!worldIn.isRemote) {
			IBlockState northState = worldIn.getBlockState(pos.north());
			IBlockState southState = worldIn.getBlockState(pos.south());
			IBlockState westState = worldIn.getBlockState(pos.west());
			IBlockState eastState = worldIn.getBlockState(pos.east());
			EnumFacing direction = (EnumFacing)state.getValue(H_FACING);

			if (direction == EnumFacing.NORTH && northState.isFullBlock() && !southState.isFullBlock()) {
				direction = EnumFacing.SOUTH; }
			
			else if (direction == EnumFacing.SOUTH && southState.isFullBlock() && !northState.isFullBlock()) {
				direction = EnumFacing.NORTH; }
			
			else if (direction == EnumFacing.WEST && westState.isFullBlock() && !eastState.isFullBlock()) {
				direction = EnumFacing.EAST; }
			
			else if (direction == EnumFacing.EAST && eastState.isFullBlock() && !westState.isFullBlock()) {
				direction = EnumFacing.WEST; }

			worldIn.setBlockState(pos, state.withProperty(H_FACING, direction), 2);
		}
	}

	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {

		if (this.isBurning) {

			if (rand.nextDouble() < 0.1D) {
				worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D,
						SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
			}
		}
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		EnumFacing direction = (EnumFacing)state.getValue(H_FACING);
		TileEntity tileentity = worldIn.getTileEntity(pos);
		
		switch (direction) {
		case NORTH :
		default:
			if ((worldIn.getBlockState(pos.north()).getMaterial().isReplaceable() || worldIn.getBlockState(pos.north()).getBlock() instanceof BlockCarpet) && 
					(worldIn.getBlockState(pos.south()).getMaterial().isReplaceable() || worldIn.getBlockState(pos.south()).getBlock() instanceof BlockCarpet ||
						worldIn.getBlockState(pos.south()).getBlock() == Furniture_Blocks.STOVECHIMNEY_joint)) {
					
					if (tileentity instanceof KitOven_TileEntity) {
						CMEvents.soundOpenOven(worldIn, pos);
						playerIn.displayGUIChest((KitOven_TileEntity)tileentity);
						playerIn.addStat(StatList.FURNACE_INTERACTION); } }
				
				else { CMEvents.textIsBlocked(worldIn, pos, playerIn); }
			break;
	
		case SOUTH :
			if ((worldIn.getBlockState(pos.south()).getMaterial().isReplaceable() || worldIn.getBlockState(pos.south()).getBlock() instanceof BlockCarpet) && 
					(worldIn.getBlockState(pos.north()).getMaterial().isReplaceable() || worldIn.getBlockState(pos.north()).getBlock() instanceof BlockCarpet ||
						worldIn.getBlockState(pos.north()).getBlock() == Furniture_Blocks.STOVECHIMNEY_joint)) {
					
					if (tileentity instanceof KitOven_TileEntity) {
						CMEvents.soundOpenOven(worldIn, pos);
						playerIn.displayGUIChest((KitOven_TileEntity)tileentity);
						playerIn.addStat(StatList.FURNACE_INTERACTION); } }
				
				else { CMEvents.textIsBlocked(worldIn, pos, playerIn); }
			break;
	
		case EAST :
			if ((worldIn.getBlockState(pos.east()).getMaterial().isReplaceable() || worldIn.getBlockState(pos.east()).getBlock() instanceof BlockCarpet) && 
					(worldIn.getBlockState(pos.west()).getMaterial().isReplaceable() || worldIn.getBlockState(pos.west()).getBlock() instanceof BlockCarpet ||
						worldIn.getBlockState(pos.west()).getBlock() == Furniture_Blocks.STOVECHIMNEY_joint)) {
				
				if (tileentity instanceof KitOven_TileEntity) {
					CMEvents.soundOpenOven(worldIn, pos);
					playerIn.displayGUIChest((KitOven_TileEntity)tileentity);
					playerIn.addStat(StatList.FURNACE_INTERACTION); } }
				
				else { CMEvents.textIsBlocked(worldIn, pos, playerIn); }
			break;
			
		case WEST :
			if ((worldIn.getBlockState(pos.west()).getMaterial().isReplaceable() || worldIn.getBlockState(pos.west()).getBlock() instanceof BlockCarpet) && 
					(worldIn.getBlockState(pos.east()).getMaterial().isReplaceable() || worldIn.getBlockState(pos.east()).getBlock() instanceof BlockCarpet ||
						worldIn.getBlockState(pos.east()).getBlock() == Furniture_Blocks.STOVECHIMNEY_joint)) {
					
					if (tileentity instanceof KitOven_TileEntity) {
						CMEvents.soundOpenOven(worldIn, pos);
						playerIn.displayGUIChest((KitOven_TileEntity)tileentity);
						playerIn.addStat(StatList.FURNACE_INTERACTION); } }
				
				else { CMEvents.textIsBlocked(worldIn, pos, playerIn); }
			break;
		} // switch

		return true;
	}

	public static void setState(boolean active, World worldIn, BlockPos pos) {
		IBlockState state = worldIn.getBlockState(pos);
		TileEntity tileentity = worldIn.getTileEntity(pos);
		keepInventory = true;

		if (active) {
			worldIn.setBlockState(pos, Kitchen_Blocks.LIT_KITOVEN.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING)), 3);
			worldIn.setBlockState(pos, Kitchen_Blocks.LIT_KITOVEN.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING)), 3); }
		
		else {
			worldIn.setBlockState(pos, Kitchen_Blocks.KIT_OVEN.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING)), 3);
			worldIn.setBlockState(pos, Kitchen_Blocks.KIT_OVEN.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING)), 3); }

		keepInventory = false;

		if (tileentity != null) {
			tileentity.validate();
			worldIn.setTileEntity(pos, tileentity); }
	}

	/** Returns a new instance of a block's tile entity class. Called on placing the block. */
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new KitOven_TileEntity();
	}

	/** Called by ItemBlocks just before a block is actually set in the world, to allow for adjustments to the IBlockstate */
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(H_FACING, placer.getHorizontalFacing().getOpposite());
	}

	/** Called by ItemBlocks after a block is set in the world, to allow post-place logic */
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		worldIn.setBlockState(pos, state.withProperty(H_FACING, placer.getHorizontalFacing().getOpposite()), 2);

		if (stack.hasDisplayName()) {
			TileEntity tileentity = worldIn.getTileEntity(pos);

			if (tileentity instanceof KitOven_TileEntity) {
				((KitOven_TileEntity)tileentity).setCustomInventoryName(stack.getDisplayName());
			}
		}
	}

	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {

		if (!keepInventory) {
			TileEntity tileentity = worldIn.getTileEntity(pos);

			if (tileentity instanceof KitOven_TileEntity) {
				InventoryHelper.dropInventoryItems(worldIn, pos, (KitOven_TileEntity)tileentity);
				worldIn.updateComparatorOutputLevel(pos, this);
			}
		}

		super.breakBlock(worldIn, pos, state);
	}

	public boolean hasComparatorInputOverride(IBlockState state) {
		return true;
	}

	public int getComparatorInputOverride(IBlockState state, World worldIn, BlockPos pos) {
		return Container.calcRedstone(worldIn.getTileEntity(pos));
	}

	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(Kitchen_Blocks.KIT_OVEN);
	}

	/** The type of render function called. 3 for standard block models, 2 for TESR's, 1 for liquids, -1 is no render */
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

	/** Convert the given metadata into a BlockState for this Block */
	public IBlockState getStateFromMeta(int meta) {
		EnumFacing direction = EnumFacing.getFront(meta);

		if (direction.getAxis() == EnumFacing.Axis.Y) {
			direction = EnumFacing.NORTH;
		}

		return this.getDefaultState().withProperty(H_FACING, direction);
	}

	/** Convert the BlockState into the correct metadata value */
	public int getMetaFromState(IBlockState state) {
		return ((EnumFacing)state.getValue(H_FACING)).getIndex();
	}

	/** Returns the blockstate with the given rotation from the passed blockstate. If inapplicable, returns the passed blockstate. */
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		return state.withProperty(H_FACING, rot.rotate((EnumFacing)state.getValue(H_FACING)));
	}

	/** Returns the blockstate with the given mirror of the passed blockstate. If inapplicable, returns the passed blockstate. */
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
		return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(H_FACING)));
	}

	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { H_FACING });
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

	@SideOnly(Side.CLIENT)
	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_kit_oven.name", meta));
	}
}
