package com.ayutaki.chinjufumod.blocks.furnace;

import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Furniture_Blocks;
import com.ayutaki.chinjufumod.tileentity.CStove_TileEntity;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CStove_top extends BlockContainer {

	public static final PropertyDirection H_FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	private final boolean isBurning;
	private static boolean keepInventory;

	private static final AxisAlignedBB AABB = new AxisAlignedBB(0.0625, 0.0, 0.0625, 0.9375, 1.0, 0.9375);

	public CStove_top(boolean isBurning, String name) {
		super(Material.WOOD);
		setRegistryName(name);
		setUnlocalizedName(name);

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
	@SuppressWarnings("incomplete-switch")
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {

		if (this.isBurning) {
			EnumFacing direction = (EnumFacing)stateIn.getValue(H_FACING);
			double d0 = (double)pos.getX() + 0.5D;
			double d1 = (double)pos.getY() + rand.nextDouble() * 6.0D / 16.0D;
			double d2 = (double)pos.getZ() + 0.5D;
			double d3 = 0.2D;
			double d4 = rand.nextDouble() * 0.6D - 0.3D;

			if (rand.nextDouble() < 0.1D) {
				worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
			}

			switch (direction) {
			case WEST:
				worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 - d3 + 0.2, d1 - 0.5D, d2 + d4, 0.0D, 0.0D, 0.0D, new int[0]);
				break;
			case EAST:
				worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 + d3 - 0.2, d1 - 0.5D, d2 + d4, 0.0D, 0.0D, 0.0D, new int[0]);
				break;
			case NORTH:
				worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 + d4, d1 - 0.5D, d2, 0.0D, 0.0D, 0.0D, new int[0]);
				break;
			case SOUTH:
				worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 + d4, d1 - 0.5D, d2, 0.0D, 0.0D, 0.0D, new int[0]);
			}
		}
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		if (worldIn.isRemote) { return true; }

		else {
			TileEntity tileentity = worldIn.getTileEntity(pos);

			if (tileentity instanceof CStove_TileEntity) {
				worldIn.playSound(null, pos, SoundEvents_CM.OPEN, SoundCategory.BLOCKS, 0.8F, 1.0F);
				playerIn.displayGUIChest((CStove_TileEntity)tileentity);
				playerIn.addStat(StatList.FURNACE_INTERACTION);
			}

			return true;
		}
	}

	public static void setState(boolean active, World worldIn, BlockPos pos) {
		IBlockState state = worldIn.getBlockState(pos);
		TileEntity tileentity = worldIn.getTileEntity(pos);
		keepInventory = true;

		if (active) {
			worldIn.setBlockState(pos, Furniture_Blocks.LIT_CSTOVE_top.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING)), 3);
			worldIn.setBlockState(pos, Furniture_Blocks.LIT_CSTOVE_top.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING)), 3); }
		
		else {
			worldIn.setBlockState(pos, Furniture_Blocks.CSTOVE_top.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING)), 3);
			worldIn.setBlockState(pos, Furniture_Blocks.CSTOVE_top.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING)), 3); }

		keepInventory = false;

		if (tileentity != null) {
			tileentity.validate();
			worldIn.setTileEntity(pos, tileentity); }
	}

	/** Returns a new instance of a block's tile entity class. Called on placing the block. */
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new CStove_TileEntity();
	}

	/* こちらの .getOpposite() は, 呼び出し時の方向に無関係 */
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(H_FACING, placer.getHorizontalFacing().getOpposite());
	}

	/** Called by ItemBlocks after a block is set in the world, to allow post-place logic */
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		worldIn.setBlockState(pos, state.withProperty(H_FACING, placer.getHorizontalFacing().getOpposite()), 2);

		if (stack.hasDisplayName()) {
			TileEntity tileentity = worldIn.getTileEntity(pos);

			if (tileentity instanceof CStove_TileEntity) {
				((CStove_TileEntity)tileentity).setCustomInventoryName(stack.getDisplayName());
			}
		}
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		if (!keepInventory) {
			TileEntity tileentity = worldIn.getTileEntity(pos);

			if (tileentity instanceof CStove_TileEntity) {
				InventoryHelper.dropInventoryItems(worldIn, pos, (CStove_TileEntity)tileentity);
				worldIn.updateComparatorOutputLevel(pos, this);
			}
		}

		super.breakBlock(worldIn, pos, state);
	}

	@Override
	public boolean hasComparatorInputOverride(IBlockState state) {
		return true;
	}

	@Override
	public int getComparatorInputOverride(IBlockState state, World worldIn, BlockPos pos) {
		return Container.calcRedstone(worldIn.getTileEntity(pos));
	}

	/** The type of render function called. 3 for standard block models, 2 for TESR's, 1 for liquids, -1 is no render */
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

	/** Convert the given metadata into a BlockState for this Block */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		EnumFacing direction = EnumFacing.getFront(meta);

		if (direction.getAxis() == EnumFacing.Axis.Y) {
			direction = EnumFacing.NORTH;
		}

		return this.getDefaultState().withProperty(H_FACING, direction);
	}

	/** Convert the BlockState into the correct metadata value */
	@Override
	public int getMetaFromState(IBlockState state) {
		return ((EnumFacing)state.getValue(H_FACING)).getIndex();
	}

	/** Returns the blockstate with the given rotation from the passed blockstate. If inapplicable, returns the passed blockstate. */
	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		return state.withProperty(H_FACING, rot.rotate((EnumFacing)state.getValue(H_FACING)));
	}

	/** Returns the blockstate with the given mirror of the passed blockstate. If inapplicable, returns the passed blockstate. */
	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
		return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(H_FACING)));
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { H_FACING });
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return AABB;
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

	/* A block that breaks at the same time when it is broken. */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn) {
		if (worldIn.getBlockState(pos.down()).getBlock() instanceof CStove_bot) {
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
}
