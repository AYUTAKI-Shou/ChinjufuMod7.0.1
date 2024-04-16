package com.ayutaki.chinjufumod.blocks.chair;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.entity.helper.SittableUtil;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Furniture_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Chinjufu;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class DiningChair extends Block {

	public static final PropertyDirection H_FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyEnum<Half> HALF = PropertyEnum.create("half", Half.class);
	
	private static final AxisAlignedBB AABB_BASE = new AxisAlignedBB(0.125, 0.0, 0.125, 0.875, 0.5625, 0.875);
	private static final AxisAlignedBB AABB_SOUTH = new AxisAlignedBB(0.125, 0.0, 0.125, 0.875, 0.25, 0.1875);
	private static final AxisAlignedBB AABB_EAST = new AxisAlignedBB(0.125, 0.0, 0.125, 0.1875, 0.25, 0.875);
	private static final AxisAlignedBB AABB_WEST = new AxisAlignedBB(0.8125, 0.0, 0.125, 0.875, 0.25, 0.875);
	private static final AxisAlignedBB AABB_NORTH = new AxisAlignedBB(0.125, 0.0, 0.8125, 0.875, 0.25, 0.875);

	public DiningChair(String name) {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);
		
		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(5.0F);
		setLightOpacity(1);
		
		setDefaultState(this.blockState.getBaseState().withProperty(H_FACING, EnumFacing.NORTH)
				.withProperty(HALF, Half.LOWER));
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		if (state.getValue(HALF) == Half.LOWER) {
			if (SittableUtil.sitOnBlock(worldIn, pos.getX(), pos.getY(), pos.getZ(), playerIn, 6 * 0.0625)) {
				worldIn.updateComparatorOutputLevel(pos, this);
				CMEvents.soundSitChair(worldIn, pos);
				return true;
			}
		}
		return false;
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

		state = state.getActualState(source, pos);
		EnumFacing direction = (EnumFacing)state.getValue(H_FACING);
		boolean flag = state.getValue(HALF) == Half.LOWER;

		switch (direction) {
		case SOUTH:
			return flag ? AABB_BASE : AABB_SOUTH;
			
		case EAST:
			return flag ? AABB_BASE : AABB_EAST;
			
		case WEST:
			return flag ? AABB_BASE : AABB_WEST;
			
		case NORTH:
		default:
			return flag ? AABB_BASE : AABB_NORTH;
		}
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox,
			List<AxisAlignedBB> collidingBoxes, Entity entityIn, boolean t_f) {

		boolean flag = state.getValue(HALF) == Half.LOWER;
		EnumFacing direction = state.getValue(H_FACING);

		switch (direction) {
		case SOUTH:
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, flag ? AABB_BASE : AABB_SOUTH);
			break;

		case EAST:
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, flag ? AABB_BASE : AABB_EAST);
			break;

		case WEST:
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, flag ? AABB_BASE : AABB_WEST);
			break;

		case NORTH :
		default:
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, flag ? AABB_BASE : AABB_NORTH);
			break;
		}
	}
	
	/* Power on/off. Destroy blocks. */
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {

		if (state.getValue(HALF) == Half.UPPER) {
			BlockPos downPos = pos.down();
			IBlockState downState = worldIn.getBlockState(downPos);

			if (downState.getBlock() != this) { worldIn.setBlockToAir(pos); }
			
			else if (blockIn != this) { downState.neighborChanged(worldIn, downPos, blockIn, fromPos); }
		}

		else {
			boolean flag1 = false;
			BlockPos upPos = pos.up();
			IBlockState upState = worldIn.getBlockState(upPos);

			if (upState.getBlock() != this) {
				worldIn.setBlockToAir(pos);
				flag1 = true; }

			if (flag1) {
				if (!worldIn.isRemote) { this.dropBlockAsItem(worldIn, pos, state, 0); }
			}

			else { }
		}
	}
	
	/* A block that breaks at the same time when it is broken. */
	@Override
	public void onBlockHarvested(World world, BlockPos pos, IBlockState state, EntityPlayer playerIn) {
		BlockPos down = pos.down();
		BlockPos up = pos.up();
		if (playerIn.capabilities.isCreativeMode && state.getValue(HALF) == Half.UPPER && world.getBlockState(down).getBlock() == this) {
			world.setBlockToAir(down); }
		
		if (state.getValue(HALF) == Half.LOWER && world.getBlockState(up).getBlock() == this) {
			if (playerIn.capabilities.isCreativeMode) { world.setBlockToAir(pos); }
			world.setBlockToAir(up);
		}
	}

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		stack.add(this.takeStack(state));
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return this.takeStack(state);
	}
	
	private ItemStack takeStack(IBlockState state) {
		if (state.getValue(HALF) == Half.UPPER) { return new ItemStack(Items.AIR); }
		
		if (state.getValue(HALF) != Half.UPPER) {
			if (this == Furniture_Blocks.DININGCHAIR) { return new ItemStack(Items_Chinjufu.DININGCHAIR_item, 1, 0); }
			if (this == Furniture_Blocks.DININGCHAIR_s) { return new ItemStack(Items_Chinjufu.DININGCHAIR_item, 1, 1); }
			if (this == Furniture_Blocks.DININGCHAIR_b) { return new ItemStack(Items_Chinjufu.DININGCHAIR_item, 1, 2); }
			if (this == Furniture_Blocks.DININGCHAIR_j) { return new ItemStack(Items_Chinjufu.DININGCHAIR_item, 1, 3); }
			if (this == Furniture_Blocks.DININGCHAIR_a) { return new ItemStack(Items_Chinjufu.DININGCHAIR_item, 1, 4); }
			if (this == Furniture_Blocks.DININGCHAIR_d) { return new ItemStack(Items_Chinjufu.DININGCHAIR_item, 1, 5); }
			if (this == Furniture_Blocks.DININGCHAIR_saku) { return new ItemStack(Items_Chinjufu.DININGCHAIR_item, 1, 6); }
			if (this == Furniture_Blocks.DININGCHAIR_kae) { return new ItemStack(Items_Chinjufu.DININGCHAIR_item, 1, 7); }
			if (this == Furniture_Blocks.DININGCHAIR_ich) { return new ItemStack(Items_Chinjufu.DININGCHAIR_item, 1, 8); } 
		}
		return null;
	}
	
	/* A place where you can put it. */
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos).getMaterial().isReplaceable() && worldIn.getBlockState(pos.up()).getMaterial().isReplaceable();
	}

	@Override
	public EnumPushReaction getMobilityFlag(IBlockState state) {
		return EnumPushReaction.DESTROY;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, HALF, H_FACING);
	}

	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		return state.withProperty(H_FACING, rot.rotate(state.getValue(H_FACING)));
	}

	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirror) {
		return state.withProperty(H_FACING, mirror.mirror(state.getValue(H_FACING)));
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		Half half = Half.fromMetadata(meta & 1);
		EnumFacing facing = EnumFacing.getHorizontal((meta >> 1) & 3);
		if (facing.getAxis() == Axis.Y) {
			facing = EnumFacing.NORTH;
		}
		return this.getDefaultState().withProperty(HALF, half).withProperty(H_FACING, facing);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(HALF).getMetadata() | (state.getValue(H_FACING).getIndex() << 1);
	}

	@Override
	public boolean hasTileEntity(IBlockState state) {
		return state.getValue(HALF) == Half.LOWER;
	}

	public enum Half implements IStringSerializable {
		LOWER("lower", 0),
		UPPER("upper", 1);

		private String name;
		private int metadata;

		Half(String name, int metadata) {
			this.name = name;
			this.metadata = metadata;
		}

		public String toString() {
			return this.getName();
		}

		@Override
		public String getName() {
			return this.name;
		}

		public int getMetadata() {
			return this.metadata;
		}

		public static Half fromMetadata(int metadata) {
			if (metadata == 1) {
				return UPPER;
			}
			return LOWER;
		}
	}
	
	/* A torch can be placed on top. true or false */
	public boolean isTopSolid(IBlockState state) {
		return false;
	}

	/* A torch can be placed on the side. */
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	/* Rendering */
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
}
