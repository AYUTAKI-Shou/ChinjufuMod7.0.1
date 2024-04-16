package com.ayutaki.chinjufumod.blocks.wood;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class KuriIga_Fall extends BlockFalling {

	/* Collision */
	protected static final AxisAlignedBB AABB_BOX = new AxisAlignedBB(0.375D, -0.0625D, 0.375D, 0.625D, 0.21875D, 0.625D);
	
	public KuriIga_Fall(String name) {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, name));
		setUnlocalizedName(name);
		setCreativeTab(ChinjufuModTabs.SEASONAL);

		setSoundType(SoundType.SNOW);
		setHardness(0.1F);
		setResistance(0.1F);
		setLightOpacity(0);
	}

	/* TickRandom */
	protected boolean onBush(IBlockState state, World worldIn, BlockPos pos) {
		Block downBlock = worldIn.getBlockState(pos.down()).getBlock();
		return downBlock instanceof BlockBush || downBlock instanceof KuriIga_Fall;
	}
	
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		worldIn.scheduleUpdate(pos, Seasonal_Blocks.KURIIGA_FALL, this.tickRate(worldIn));
	}
	
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		Block downBlock = worldIn.getBlockState(pos.down()).getBlock();
		
		if (!worldIn.isRemote) { this.checkFallable(worldIn, pos); }
		
		if (downBlock instanceof BlockLiquid) {
			worldIn.scheduleUpdate(pos, Seasonal_Blocks.KURIIGA_FALL, this.tickRate(worldIn));
			worldIn.destroyBlock(pos, true); }
		
		if (onBush(state, worldIn, pos)) {
			worldIn.scheduleUpdate(pos, Seasonal_Blocks.KURIIGA_FALL, this.tickRate(worldIn));
			this.dropKuri(state, worldIn, pos); }
	}
	
	private void dropKuri(IBlockState state, World worldIn, BlockPos pos) {
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		
		worldIn.setBlockToAir(new BlockPos(x, y, z));
		worldIn.setBlockState(new BlockPos(x, y - 1, z), Seasonal_Blocks.KURIIGA_FALL.getDefaultState(), 3);
	}
	
	private void checkFallable(World worldIn, BlockPos pos) {
		if ((worldIn.isAirBlock(pos.down()) || canFallThrough(worldIn.getBlockState(pos.down()))) && pos.getY() >= 0) {

			if (!fallInstantly && worldIn.isAreaLoaded(pos.add(-32, -32, -32), pos.add(32, 32, 32))) {
				if (!worldIn.isRemote) {
					EntityFallingBlock entityfallingblock = new EntityFallingBlock(worldIn, (double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, worldIn.getBlockState(pos));
					this.onStartFalling(entityfallingblock);
					worldIn.spawnEntity(entityfallingblock); }
			}
			
			else {
				IBlockState state = worldIn.getBlockState(pos);
				worldIn.setBlockToAir(pos);
				BlockPos pos1;

				for (pos1 = pos.down(); (worldIn.isAirBlock(pos1) || canFallThrough(worldIn.getBlockState(pos1))) && pos1.getY() > 0; pos1 = pos1.down()) { ; }

				if (pos1.getY() > 0) {
					worldIn.setBlockState(pos1.up(), state); //Forge: Fix loss of state information during world gen.
				}
			}
		}
	}
	
	/* Collisions for each property. */
	/* Collision */
	public Block.EnumOffsetType getOffsetType() {
		return Block.EnumOffsetType.XZ;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return AABB_BOX.offset(state.getOffset(source, pos));
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		/** Have no collision. **/
		return NULL_AABB;
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

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
		return true;
	}
	
	protected ItemStack getSilkTouchDrop(IBlockState state) {
		return new ItemStack(Items_Seasonal.KURI_IGA, 1, 0);
	}

	public int quantityDropped(Random random) {
		return MathHelper.getInt(random, 1, 2);
	}
	
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Items_Seasonal.KURI;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Items_Seasonal.KURI_IGA, 1, 0);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_chestnuts.name", meta));
	}
}
