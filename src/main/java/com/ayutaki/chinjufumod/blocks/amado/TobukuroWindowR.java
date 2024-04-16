package com.ayutaki.chinjufumod.blocks.amado;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.blocks.base.BaseStage2_Face;
import com.ayutaki.chinjufumod.blocks.base.BaseStage3_Face;
import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.Slidedoor_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class TobukuroWindowR extends BaseStage3_Face {

	/* Collision */
	private static final AxisAlignedBB AABB_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.0, -0.03125, -0.03125, 0.1875, 1.03125, 1.03125);
	private static final AxisAlignedBB AABB_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.0, -0.03125, -0.03125, 0.1875, 1.03125, 1.03125);
	private static final AxisAlignedBB AABB_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.0, -0.03125, -0.03125, 0.1875, 1.03125, 1.03125);
	private static final AxisAlignedBB AABB_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.0, -0.03125, -0.03125, 0.1875, 1.03125, 1.03125);
	private static final AxisAlignedBB[] AABB = { AABB_SOUTH, AABB_WEST, AABB_NORTH, AABB_EAST };

	/** 1=2枚, 2=1枚, 3=0枚 **/
	public TobukuroWindowR(String name) {
		super(name);
		setHardness(2.0F);
		setResistance(5.0F);
		setSoundType(SoundType.WOOD);
		setLightOpacity(1);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		/** 1=2枚, 2=1枚, 3=0枚 **/
		int i = ((Integer)state.getValue(STAGE_1_3)).intValue();
		EnumFacing direction = state.getValue(H_FACING);

		IBlockState northState = worldIn.getBlockState(pos.north());
		IBlockState southState = worldIn.getBlockState(pos.south());
		IBlockState eastState = worldIn.getBlockState(pos.east());
		IBlockState westState = worldIn.getBlockState(pos.west());

		if (i != 3) {
			CMEvents.soundAmadoWin(worldIn, pos);
			IBlockState win_FACE = this.takeBlock().getDefaultState().withProperty(H_FACING, state.getValue(H_FACING));
			
			switch (direction) {
			case NORTH :
			default :
				if (westState.getMaterial().isReplaceable()) {
					CMEvents.soundFusumaS(worldIn, pos);
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_3, Integer.valueOf(i + 1)));
					worldIn.setBlockState(pos.west(), win_FACE.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); }
				
				if (!westState.getMaterial().isReplaceable()) { }
				break;

			case SOUTH :
				if (eastState.getMaterial().isReplaceable()) {
					CMEvents.soundFusumaS(worldIn, pos);
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_3, Integer.valueOf(i + 1)));
					worldIn.setBlockState(pos.east(), win_FACE.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); }
				
				if (!eastState.getMaterial().isReplaceable()) { }
				break;

			case EAST :
				if (northState.getMaterial().isReplaceable()) {
					CMEvents.soundFusumaS(worldIn, pos);
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_3, Integer.valueOf(i + 1)));
					worldIn.setBlockState(pos.north(), win_FACE.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); }
				
				if (!northState.getMaterial().isReplaceable()) { }
				break;
				
			case WEST :
				if (southState.getMaterial().isReplaceable()) {
					CMEvents.soundFusumaS(worldIn, pos);
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_3, Integer.valueOf(i + 1)));
					worldIn.setBlockState(pos.south(), win_FACE.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); }
				
				if (!southState.getMaterial().isReplaceable()) { }
				break;
			} // switch
		}
		
		if (i == 3) { CMEvents.textIsEmpty(worldIn, pos, playerIn); }
		
		return true;
	}

	private Block takeBlock() {
		if (this == Slidedoor_Blocks.TOBUKURO_WINR) { return Slidedoor_Blocks.AMADO_WIN; }
		if (this == Slidedoor_Blocks.TOBUKUROS_WINR) { return Slidedoor_Blocks.AMADOS_WIN; }
		return null;
	}
	
	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		EnumFacing facing = state.getValue(H_FACING);
		return AABB[facing.getHorizontalIndex()];
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
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	public boolean isFullCube(IBlockState state) {
		return false;
	}

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		if (this == Slidedoor_Blocks.TOBUKURO_WINR) { stack.add(new ItemStack(Items_Wadeco.TOBUKURO_WINR)); }
		if (this == Slidedoor_Blocks.TOBUKUROS_WINR) { stack.add(new ItemStack(Items_Wadeco.TOBUKUROS_WINR)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		if (this == Slidedoor_Blocks.TOBUKUROS_WINR) { return new ItemStack(Items_Wadeco.TOBUKUROS_WINR); }
		return new ItemStack(Items_Wadeco.TOBUKURO_WINR);
	}

}
