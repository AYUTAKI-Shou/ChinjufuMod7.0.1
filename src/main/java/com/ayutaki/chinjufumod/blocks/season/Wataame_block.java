package com.ayutaki.chinjufumod.blocks.season;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.google.common.base.Predicate;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Wataame_block extends Block {

	public static final PropertyDirection FACING = PropertyDirection.create("facing", new Predicate<EnumFacing>() {

		public boolean apply(@Nullable EnumFacing p_apply_1_) {
			return p_apply_1_ != EnumFacing.DOWN;
		}
	});

	private static final AxisAlignedBB TORCH_SOUTH_AABB = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.1875D, 0.0D, 0.1875D, 0.8125D, 0.875D, 0.8125D);
	private static final AxisAlignedBB TORCH_EAST_AABB = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.1875D, 0.0D, 0.1875D, 0.8125D, 0.875D, 0.8125D);
	private static final AxisAlignedBB TORCH_WEST_AABB = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.1875D, 0.0D, 0.1875D, 0.8125D, 0.875D, 0.8125D);
	private static final AxisAlignedBB TORCH_NORTH_AABB = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.1875D, 0.0D, 0.1875D, 0.8125D, 0.875D, 0.8125D);
	private static final AxisAlignedBB STANDING_AABB = new AxisAlignedBB(0.1875D, 0.125D, 0.1875D, 0.8125D, 1.0D, 0.8125D);

	public Wataame_block(String name) {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);
		setCreativeTab(ChinjufuModTabs.SEASONAL);

		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(5.0F);
		setLightOpacity(1);

		setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.UP));
	}

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

		EnumFacing facing = (EnumFacing)state.getValue(FACING);
		
		switch (facing) {
		case SOUTH:
			return TORCH_SOUTH_AABB;
			
		case EAST:
			return TORCH_EAST_AABB;
			
		case WEST:
			return TORCH_WEST_AABB;
			
		case NORTH:
			return TORCH_NORTH_AABB;
			
		default:
			return STANDING_AABB;
		}
	}

	private boolean canPlaceOn(World worldIn, BlockPos pos) {
		IBlockState state = worldIn.getBlockState(pos);
		return state.getBlock().canPlaceTorchOnTop(state, worldIn, pos);
	}

	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {

		for (EnumFacing direction : FACING.getAllowedValues()) {

			if (this.canPlaceAt(worldIn, pos, direction)) {
				return true;
			}
		}
		return false;
	}

	private boolean canPlaceAt(World worldIn, BlockPos pos, EnumFacing facing) {

		BlockPos pos1 = pos.offset(facing.getOpposite());
		IBlockState state1 = worldIn.getBlockState(pos1);
		Block block = state1.getBlock();
		BlockFaceShape blockfaceshape = state1.getBlockFaceShape(worldIn, pos1, facing);

		if (facing.equals(EnumFacing.UP) && this.canPlaceOn(worldIn, pos1)) {
			return true;
		}

		else if (facing != EnumFacing.UP && facing != EnumFacing.DOWN) {
			return !isExceptBlockForAttachWithPiston(block) && blockfaceshape == BlockFaceShape.SOLID;
		}

		else {
			return false;
		}
	}

	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing,
			float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {

		if (this.canPlaceAt(worldIn, pos, facing)) {
			return this.getDefaultState().withProperty(FACING, facing);
		}

		else {

			for (EnumFacing direction : EnumFacing.Plane.HORIZONTAL) {

				if (this.canPlaceAt(worldIn, pos, direction)) {
					return this.getDefaultState().withProperty(FACING, direction);
				}
			}
			return this.getDefaultState();
		}
	}


	public IBlockState getStateFromMeta(int meta) {
		IBlockState state = this.getDefaultState();

		switch (meta) {
		case 1:
			state = state.withProperty(FACING, EnumFacing.EAST);
			break;
		case 2:
			state = state.withProperty(FACING, EnumFacing.WEST);
			break;
		case 3:
			state = state.withProperty(FACING, EnumFacing.SOUTH);
			break;
		case 4:
			state = state.withProperty(FACING, EnumFacing.NORTH);
			break;
		case 5:
		default:
			state = state.withProperty(FACING, EnumFacing.UP);
		}
		return state;
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	public int getMetaFromState(IBlockState state) {
		int i = 0;

		switch ((EnumFacing)state.getValue(FACING)) {
			case EAST:
				i = i | 1;
				break;
			case WEST:
				i = i | 2;
				break;
			case SOUTH:
				i = i | 3;
				break;
			case NORTH:
				i = i | 4;
				break;
			case DOWN:
			case UP:
			default:
				i = i | 5;
		}
		return i;
	}

	public IBlockState withRotation(IBlockState state, Rotation rot) {
		return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
	}

	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
		return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
	}

	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { FACING });
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

	/* Rendering */
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_wataame.name", meta));
	}
}
