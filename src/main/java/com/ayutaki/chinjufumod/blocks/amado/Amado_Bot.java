package com.ayutaki.chinjufumod.blocks.amado;

import java.util.Random;

import com.ayutaki.chinjufumod.blocks.base.BaseStage2_Face;
import com.ayutaki.chinjufumod.blocks.base.BaseStage3_Face;
import com.ayutaki.chinjufumod.blocks.base.BaseStage4_Face;
import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Slidedoor_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Amado_Bot extends BaseStage4_Face {

	/* Collision */
	private static final AxisAlignedBB AABB_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, -0.03125, 0.0, 0.0, 0.03125, 1.0, 1.0);
	private static final AxisAlignedBB AABB_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, -0.03125, 0.0, 0.0, 0.03125, 1.0, 1.0);
	private static final AxisAlignedBB AABB_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, -0.03125, 0.0, 0.0, 0.03125, 1.0, 1.0);
	private static final AxisAlignedBB AABB_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, -0.03125, 0.0, 0.0, 0.03125, 1.0, 1.0);
	private static final AxisAlignedBB[] AABB = { AABB_SOUTH, AABB_WEST, AABB_NORTH, AABB_EAST };

	public Amado_Bot(String name) {
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

		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		EnumFacing direction = state.getValue(H_FACING);
		EnumFacing playerfacing = playerIn.getHorizontalFacing();

		IBlockState northState = worldIn.getBlockState(pos.north());
		IBlockState southState = worldIn.getBlockState(pos.south());
		IBlockState eastState = worldIn.getBlockState(pos.east());
		IBlockState westState = worldIn.getBlockState(pos.west());

		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();

		Block northBlock = northState.getBlock();
		Block southBlock = southState.getBlock();
		Block eastBlock = eastState.getBlock();
		Block westBlock = westState.getBlock();

		IBlockState airState = Blocks.AIR.getDefaultState();

		CMEvents.soundAmado(worldIn, pos);
		
		Block tobuBotL2 = this.takeLeftBot2(); /** 1=1枚, 2=0枚 **/
		Block tobuBotL = this.takeLeftBot(); /** 1=4枚, 2=3枚, 3=2枚 **/
		Block tobuBotR2 = this.takeRightBot2();
		Block tobuBotR = this.takeRightBot();

		Block tobuTopL2 = this.takeLeftTop2();
		Block tobuTopL = this.takeLeftTop();
		Block tobuTopR2 = this.takeRightTop2();
		Block tobuTopR = this.takeRightTop();

		Block amadoTop = this.takeTop();
		
		
		IBlockState tobuBotL2_FACE = tobuBotL2.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING));
		IBlockState tobuBotL_FACE = tobuBotL.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING));
		IBlockState tobuBotR2_FACE = tobuBotR2.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING));
		IBlockState tobuBotR_FACE = tobuBotR.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING));

		IBlockState tobuTopL2_FACE = tobuTopL2.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING));
		IBlockState tobuTopL_FACE = tobuTopL.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING));
		IBlockState tobuTopR2_FACE = tobuTopR2.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING));
		IBlockState tobuTopR_FACE = tobuTopR.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING));

		IBlockState amadoTop_FACE = amadoTop.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING));
		IBlockState this_FACE = this.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING));
		
		/* Stored in TOBUKURO. */
		if (i == 4) {
			switch (direction) {
			case NORTH :
			default:
				/** RIGHT side is TOBUKURO. **/
				if (westBlock == tobuBotL && westState.getValue(BaseStage3_Face.STAGE_1_3) > 1) {
					/** hit RIGHT side. **/
					if ((playerfacing == EnumFacing.NORTH && hitX < 0.45D) || (playerfacing == EnumFacing.SOUTH && hitX < 0.45D)) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airState);
						worldIn.setBlockState(pos.up(), airState);
						
						worldIn.setBlockState(new BlockPos(x - 1, y, z), tobuBotL_FACE.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(westState.getValue(BaseStage3_Face.STAGE_1_3) - 1)));
						worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), tobuTopL_FACE.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(westState.getValue(BaseStage3_Face.STAGE_1_3) - 1))); } }
				
				/** RIGHT side is TOBUKURO.2 **/
				else if (westBlock == tobuBotL2) {
					/** hit RIGHT side. **/
					if ((playerfacing == EnumFacing.NORTH && hitX < 0.45D) || (playerfacing == EnumFacing.SOUTH && hitX < 0.45D)) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airState);
						worldIn.setBlockState(pos.up(), airState);
						
						if (westState.getValue(BaseStage2_Face.STAGE_1_2) == 1) {
							worldIn.setBlockState(new BlockPos(x - 1, y, z), tobuBotL_FACE.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3)));
							worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), tobuTopL_FACE.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3))); }
						
						if (westState.getValue(BaseStage2_Face.STAGE_1_2) != 1) {
							worldIn.setBlockState(new BlockPos(x - 1, y, z), tobuBotL2_FACE.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1)));
							worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), tobuTopL2_FACE.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); } } }
				break;

			case SOUTH :
				/** RIGHT side is TOBUKURO. **/
				if (eastBlock == tobuBotL && eastState.getValue(BaseStage3_Face.STAGE_1_3) > 1) {
					/** hit RIGHT side. **/
					if ((playerfacing == EnumFacing.NORTH && hitX > 0.55D) || (playerfacing == EnumFacing.SOUTH && hitX > 0.55D)) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airState);
						worldIn.setBlockState(pos.up(), airState);
						
						worldIn.setBlockState(new BlockPos(x + 1, y, z), tobuBotL_FACE.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(eastState.getValue(BaseStage3_Face.STAGE_1_3) - 1)));
						worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), tobuTopL_FACE.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(eastState.getValue(BaseStage3_Face.STAGE_1_3) - 1))); } }
				
				/** RIGHT side is TOBUKURO.2 **/
				else if (eastBlock == tobuBotL2) { 
					/** hit RIGHT side. **/
					if ((playerfacing == EnumFacing.NORTH && hitX > 0.55D) || (playerfacing == EnumFacing.SOUTH && hitX > 0.55D)) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airState);
						worldIn.setBlockState(pos.up(), airState);
						
						if (eastState.getValue(BaseStage2_Face.STAGE_1_2) == 1) {
							worldIn.setBlockState(new BlockPos(x + 1, y, z), tobuBotL_FACE.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3)));
							worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), tobuTopL_FACE.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3))); }
						
						if (eastState.getValue(BaseStage2_Face.STAGE_1_2) != 1) {
							worldIn.setBlockState(new BlockPos(x + 1, y, z), tobuBotL2_FACE.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1)));
							worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), tobuTopL2_FACE.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); } } }
				break;

			case EAST :
				/** RIGHT side is TOBUKURO. **/
				if (northBlock == tobuBotL && northState.getValue(BaseStage3_Face.STAGE_1_3) > 1) {
					/** hit RIGHT side. **/
					if ((playerfacing == EnumFacing.EAST && hitZ < 0.45D) || (playerfacing == EnumFacing.WEST && hitZ < 0.45D)) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airState);
						worldIn.setBlockState(pos.up(), airState);
						
						worldIn.setBlockState(new BlockPos(x, y, z - 1), tobuBotL_FACE.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(northState.getValue(BaseStage3_Face.STAGE_1_3) - 1)));
						worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), tobuTopL_FACE.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(northState.getValue(BaseStage3_Face.STAGE_1_3) - 1))); } }
				
				/** RIGHT side is TOBUKURO.2 **/
				else if (northBlock == tobuBotL2) {
					/** hit RIGHT side. **/
					if ((playerfacing == EnumFacing.EAST && hitZ < 0.45D) || (playerfacing == EnumFacing.WEST && hitZ < 0.45D)) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airState);
						worldIn.setBlockState(pos.up(), airState);
						
						if (northState.getValue(BaseStage2_Face.STAGE_1_2) == 1) {
							worldIn.setBlockState(new BlockPos(x, y, z - 1), tobuBotL_FACE.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3)));
							worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), tobuTopL_FACE.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3))); }
						
						if (northState.getValue(BaseStage2_Face.STAGE_1_2) != 1) {
							worldIn.setBlockState(new BlockPos(x, y, z - 1), tobuBotL2_FACE.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1)));
							worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), tobuTopL2_FACE.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); } } }
				break;
				
			case WEST :
				/** RIGHT side is TOBUKURO. **/
				if (southBlock == tobuBotL && southState.getValue(BaseStage3_Face.STAGE_1_3) > 1) {
					/** hit RIGHT side. **/
					if ((playerfacing == EnumFacing.EAST && hitZ > 0.55D) || (playerfacing == EnumFacing.WEST && hitZ > 0.55D)) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airState);
						worldIn.setBlockState(pos.up(), airState);
						
						worldIn.setBlockState(new BlockPos(x, y, z + 1), tobuBotL_FACE.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(southState.getValue(BaseStage3_Face.STAGE_1_3) - 1)));
						worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), tobuTopL_FACE.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(southState.getValue(BaseStage3_Face.STAGE_1_3) - 1))); } }
				
				/** RIGHT side is TOBUKURO.2 **/
				else if (southBlock == tobuBotL2) {
					/** hit RIGHT side. **/
					if ((playerfacing == EnumFacing.EAST && hitZ > 0.55D) || (playerfacing == EnumFacing.WEST && hitZ > 0.55D)) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airState);
						worldIn.setBlockState(pos.up(), airState);
						
						if (southState.getValue(BaseStage2_Face.STAGE_1_2) == 1) {
							worldIn.setBlockState(new BlockPos(x, y, z + 1), tobuBotL_FACE.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3)));
							worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), tobuTopL_FACE.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3))); }
						
						if (southState.getValue(BaseStage2_Face.STAGE_1_2) != 1) {
							worldIn.setBlockState(new BlockPos(x, y, z + 1), tobuBotL2_FACE.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1)));
							worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), tobuTopL2_FACE.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); } } }
				break;
			} // switch
		} //i == 4
		
		
		/* move to Right. */
		if (i < 4) {
			switch (direction) {
			case NORTH :
			default:
				/** RIGHT side is Empty. **/
				if (worldIn.getBlockState(new BlockPos(x - 1, y, z)).getMaterial().isReplaceable() && 
						worldIn.getBlockState(new BlockPos(x - 1, y + 1, z)).getMaterial().isReplaceable()) {
					/** hit RIGHT side. **/
					if ((playerfacing == EnumFacing.NORTH && hitX < 0.45D) || (playerfacing == EnumFacing.SOUTH && hitX < 0.45D)) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airState);
						worldIn.setBlockState(pos.up(), airState);
						
						worldIn.setBlockState(new BlockPos(x - 1, y, z), this_FACE.withProperty(STAGE_1_4, Integer.valueOf(i + 1)));
						worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), amadoTop_FACE.withProperty(STAGE_1_4, Integer.valueOf(i + 1))); } }
				break;

			case SOUTH :
				/** RIGHT side is Empty. **/
				if (worldIn.getBlockState(new BlockPos(x + 1, y, z)).getMaterial().isReplaceable() && 
						worldIn.getBlockState(new BlockPos(x + 1, y + 1, z)).getMaterial().isReplaceable()) {
					/** hit RIGHT side. **/
					if ((playerfacing == EnumFacing.NORTH && hitX > 0.55D) || (playerfacing == EnumFacing.SOUTH && hitX > 0.55D)) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airState);
						worldIn.setBlockState(pos.up(), airState);
						
						worldIn.setBlockState(new BlockPos(x + 1, y, z), this_FACE.withProperty(STAGE_1_4, Integer.valueOf(i + 1)));
						worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), amadoTop_FACE.withProperty(STAGE_1_4, Integer.valueOf(i + 1))); } }
				break;

			case EAST :
				/** RIGHT side is Empty. **/
				if (worldIn.getBlockState(new BlockPos(x, y, z - 1)).getMaterial().isReplaceable() && 
						worldIn.getBlockState(new BlockPos(x, y + 1, z - 1)).getMaterial().isReplaceable()) {
					/** hit RIGHT side. **/
					if ((playerfacing == EnumFacing.EAST && hitZ < 0.45D) || (playerfacing == EnumFacing.WEST && hitZ < 0.45D)) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airState);
						worldIn.setBlockState(pos.up(), airState);

						worldIn.setBlockState(new BlockPos(x, y, z - 1), this_FACE.withProperty(STAGE_1_4, Integer.valueOf(i + 1)));
						worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), amadoTop_FACE.withProperty(STAGE_1_4, Integer.valueOf(i + 1))); } }
				break;
				
			case WEST :
				/** RIGHT side is Empty. **/
				if (worldIn.getBlockState(new BlockPos(x, y, z + 1)).getMaterial().isReplaceable() && 
						worldIn.getBlockState(new BlockPos(x, y + 1, z + 1)).getMaterial().isReplaceable()) {
					/** hit RIGHT side. **/
					if ((playerfacing == EnumFacing.EAST && hitZ > 0.55D) || (playerfacing == EnumFacing.WEST && hitZ > 0.55D)) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airState);
						worldIn.setBlockState(pos.up(), airState);

						worldIn.setBlockState(new BlockPos(x, y, z + 1), this_FACE.withProperty(STAGE_1_4, Integer.valueOf(i + 1)));
						worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), amadoTop_FACE.withProperty(STAGE_1_4, Integer.valueOf(i + 1))); } }
				break;
			} // switch
		} //i < 4
		
		
		/* Stored in TOBUKURO. */
		if (i == 1) {
			switch (direction) {
			case NORTH :
			default:
				/** LEFT side is TOBUKURO. **/
				if (eastBlock == tobuBotR && eastState.getValue(BaseStage3_Face.STAGE_1_3) > 1) {
					/** hit LEFT side **/
					if ((playerfacing == EnumFacing.NORTH && hitX > 0.55D) || (playerfacing == EnumFacing.SOUTH && hitX > 0.55D)) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airState);
						worldIn.setBlockState(pos.up(), airState);
						
						worldIn.setBlockState(new BlockPos(x + 1, y, z), tobuBotR_FACE.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(eastState.getValue(BaseStage3_Face.STAGE_1_3) - 1)));
						worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), tobuTopR_FACE.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(eastState.getValue(BaseStage3_Face.STAGE_1_3) - 1))); } }
				
				/** LEFT side is TOBUKURO.2 **/
				else if (eastBlock == tobuBotR2) {
					/** hit LEFT side **/
					if ((playerfacing == EnumFacing.NORTH && hitX > 0.55D) || (playerfacing == EnumFacing.SOUTH && hitX > 0.55D)) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airState);
						worldIn.setBlockState(pos.up(), airState);
						
						if (eastState.getValue(BaseStage2_Face.STAGE_1_2) == 1) {
							worldIn.setBlockState(new BlockPos(x + 1, y, z), tobuBotR_FACE.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3)));
							worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), tobuTopR_FACE.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3))); }
						
						if (eastState.getValue(BaseStage2_Face.STAGE_1_2) != 1) {
							worldIn.setBlockState(new BlockPos(x + 1, y, z), tobuBotR2_FACE.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1)));
							worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), tobuTopR2_FACE.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); } } }
				break;

			case SOUTH :
				/** LEFT side is TOBUKURO. **/
				if (westBlock == tobuBotR && westState.getValue(BaseStage3_Face.STAGE_1_3) > 1) {
					/** hit LEFT side **/
					if ((playerfacing == EnumFacing.NORTH && hitX < 0.45D) || (playerfacing == EnumFacing.SOUTH && hitX < 0.45D)) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airState);
						worldIn.setBlockState(pos.up(), airState);
						
						worldIn.setBlockState(new BlockPos(x - 1, y, z), tobuBotR_FACE.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(westState.getValue(BaseStage3_Face.STAGE_1_3) - 1)));
						worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), tobuTopR_FACE.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(westState.getValue(BaseStage3_Face.STAGE_1_3) - 1))); } }
				
				/** LEFT side is TOBUKURO.2 **/
				else if (westBlock == tobuBotR2) {
					/** hit LEFT side **/
					if ((playerfacing == EnumFacing.NORTH && hitX < 0.45D) || (playerfacing == EnumFacing.SOUTH && hitX < 0.45D)) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airState);
						worldIn.setBlockState(pos.up(), airState);
						
						if (westState.getValue(BaseStage2_Face.STAGE_1_2) == 1) {
							worldIn.setBlockState(new BlockPos(x - 1, y, z), tobuBotR_FACE.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3)));
							worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), tobuTopR_FACE.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3))); }
						
						if (westState.getValue(BaseStage2_Face.STAGE_1_2) != 1) {
							worldIn.setBlockState(new BlockPos(x - 1, y, z), tobuBotR2_FACE.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1)));
							worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), tobuTopR2_FACE.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); } } }
				break;

			case EAST :
				/** LEFT side is TOBUKURO. **/
				if (southBlock == tobuBotR && southState.getValue(BaseStage3_Face.STAGE_1_3) > 1) {
					/** hit LEFT side **/
					if ((playerfacing == EnumFacing.EAST && hitZ > 0.55D) || (playerfacing == EnumFacing.WEST && hitZ > 0.55D)) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airState);
						worldIn.setBlockState(pos.up(), airState);
						
						worldIn.setBlockState(new BlockPos(x, y, z + 1), tobuBotR_FACE.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(southState.getValue(BaseStage3_Face.STAGE_1_3) - 1)));
						worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), tobuTopR_FACE.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(southState.getValue(BaseStage3_Face.STAGE_1_3) - 1))); } }
				
				/** LEFT side is TOBUKURO.2 **/
				if (southBlock == tobuBotR2) {
					/** hit LEFT side **/
					if ((playerfacing == EnumFacing.EAST && hitZ > 0.55D) || (playerfacing == EnumFacing.WEST && hitZ > 0.55D)) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airState);
						worldIn.setBlockState(pos.up(), airState);
						
						if (southState.getValue(BaseStage2_Face.STAGE_1_2) == 1) {
							worldIn.setBlockState(new BlockPos(x, y, z + 1), tobuBotR_FACE.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3)));
							worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), tobuTopR_FACE.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3))); }
						
						if (southState.getValue(BaseStage2_Face.STAGE_1_2) != 1) {
							worldIn.setBlockState(new BlockPos(x, y, z + 1), tobuBotR2_FACE.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1)));
							worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), tobuTopR2_FACE.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); } } }
				break;
				
			case WEST :
				/** LEFT side is TOBUKURO. **/
				if (northBlock == tobuBotR && northState.getValue(BaseStage3_Face.STAGE_1_3) > 1) {
					/** hit LEFT side **/
					if ((playerfacing == EnumFacing.EAST && hitZ < 0.45D) || (playerfacing == EnumFacing.WEST && hitZ < 0.45D)) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airState);
						worldIn.setBlockState(pos.up(), airState);

						worldIn.setBlockState(new BlockPos(x, y, z - 1), tobuBotR_FACE.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(northState.getValue(BaseStage3_Face.STAGE_1_3) - 1)));
						worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), tobuTopR_FACE.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(northState.getValue(BaseStage3_Face.STAGE_1_3) - 1))); } }
				
				/** LEFT side is TOBUKURO.2 **/
				if (northBlock == tobuBotR2) {
					/** hit LEFT side **/
					if ((playerfacing == EnumFacing.EAST && hitZ < 0.45D) || (playerfacing == EnumFacing.WEST && hitZ < 0.45D)) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airState);
						worldIn.setBlockState(pos.up(), airState);
						
						if (northState.getValue(BaseStage2_Face.STAGE_1_2) == 1) {
							worldIn.setBlockState(new BlockPos(x, y, z - 1), tobuBotR_FACE.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3)));
							worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), tobuTopR_FACE.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3))); }
						
						if (northState.getValue(BaseStage2_Face.STAGE_1_2) != 1) {
							worldIn.setBlockState(new BlockPos(x, y, z - 1), tobuBotR2_FACE.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1)));
							worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), tobuTopR2_FACE.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); } } }
				break;
			} // switch
		} //i == 1
		
		
		/* move to Left. */
		if (i > 1) {
			switch (direction) {
			case NORTH :
			default:
				/** LEFT side is Empty. **/
				if (worldIn.getBlockState(new BlockPos(x + 1, y, z)).getMaterial().isReplaceable() && 
						worldIn.getBlockState(new BlockPos(x + 1, y + 1, z)).getMaterial().isReplaceable()) {
					/** hit LEFT side **/
					if ((playerfacing == EnumFacing.NORTH && hitX > 0.55D) || (playerfacing == EnumFacing.SOUTH && hitX > 0.55D)) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airState);
						worldIn.setBlockState(pos.up(), airState);

						worldIn.setBlockState(new BlockPos(x + 1, y, z), this_FACE.withProperty(STAGE_1_4, Integer.valueOf(i - 1)));
						worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), amadoTop_FACE.withProperty(STAGE_1_4, Integer.valueOf(i - 1))); } }
				break;

			case SOUTH :
				if (worldIn.getBlockState(new BlockPos(x - 1, y, z)).getMaterial().isReplaceable() && 
						worldIn.getBlockState(new BlockPos(x - 1, y + 1, z)).getMaterial().isReplaceable()) {
					/** hit LEFT side **/
					if ((playerfacing == EnumFacing.NORTH && hitX < 0.45D) || (playerfacing == EnumFacing.SOUTH && hitX < 0.45D)) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airState);
						worldIn.setBlockState(pos.up(), airState);
						
						worldIn.setBlockState(new BlockPos(x - 1, y, z), this_FACE.withProperty(STAGE_1_4, Integer.valueOf(i - 1)));
						worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), amadoTop_FACE.withProperty(STAGE_1_4, Integer.valueOf(i - 1))); } }
				break;

			case EAST :
				if (worldIn.getBlockState(new BlockPos(x, y, z + 1)).getMaterial().isReplaceable() && 
						worldIn.getBlockState(new BlockPos(x, y + 1, z + 1)).getMaterial().isReplaceable()) {
					/** hit LEFT side **/
					if ((playerfacing == EnumFacing.EAST && hitZ > 0.55D) || (playerfacing == EnumFacing.WEST && hitZ > 0.55D)) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airState);
						worldIn.setBlockState(pos.up(), airState);

						worldIn.setBlockState(new BlockPos(x, y, z + 1), this_FACE.withProperty(STAGE_1_4, Integer.valueOf(i - 1)));
						worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), amadoTop_FACE.withProperty(STAGE_1_4, Integer.valueOf(i - 1))); } }
				break;
				
			case WEST :
				if (worldIn.getBlockState(new BlockPos(x, y, z - 1)).getMaterial().isReplaceable() && 
						worldIn.getBlockState(new BlockPos(x, y + 1, z - 1)).getMaterial().isReplaceable()) {
					/** hit LEFT side **/
					if ((playerfacing == EnumFacing.EAST && hitZ < 0.45D) || (playerfacing == EnumFacing.WEST && hitZ < 0.45D)) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airState);
						worldIn.setBlockState(pos.up(), airState);

						worldIn.setBlockState(new BlockPos(x, y, z - 1), this_FACE.withProperty(STAGE_1_4, Integer.valueOf(i - 1)));
						worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), amadoTop_FACE.withProperty(STAGE_1_4, Integer.valueOf(i - 1))); } }
				break;
			} // switch
		} //i > 1

		return true;
	}

	private Block takeRightBot() {
		if (this == Slidedoor_Blocks.AMADO_BOT) { return Slidedoor_Blocks.TOBUKURO_BOTR; }
		if (this == Slidedoor_Blocks.AMADOS_BOT) { return Slidedoor_Blocks.TOBUKUROS_BOTR; }
		return null;
	}
	
	private Block takeRightBot2() {
		if (this == Slidedoor_Blocks.AMADO_BOT) { return Slidedoor_Blocks.TOBUKURO_BOTR2; }
		if (this == Slidedoor_Blocks.AMADOS_BOT) { return Slidedoor_Blocks.TOBUKUROS_BOTR2; }
		return null;
	}
	
	private Block takeLeftBot() {
		if (this == Slidedoor_Blocks.AMADO_BOT) { return Slidedoor_Blocks.TOBUKURO_BOTL; }
		if (this == Slidedoor_Blocks.AMADOS_BOT) { return Slidedoor_Blocks.TOBUKUROS_BOTL; }
		return null;
	}
	
	private Block takeLeftBot2() {
		if (this == Slidedoor_Blocks.AMADO_BOT) { return Slidedoor_Blocks.TOBUKURO_BOTL2; }
		if (this == Slidedoor_Blocks.AMADOS_BOT) { return Slidedoor_Blocks.TOBUKUROS_BOTL2; }
		return null;
	}
	
	private Block takeRightTop() {
		if (this == Slidedoor_Blocks.AMADO_BOT) { return Slidedoor_Blocks.TOBUKURO_TOPR; }
		if (this == Slidedoor_Blocks.AMADOS_BOT) { return Slidedoor_Blocks.TOBUKUROS_TOPR; }
		return null;
	}
	
	private Block takeRightTop2() {
		if (this == Slidedoor_Blocks.AMADO_BOT) { return Slidedoor_Blocks.TOBUKURO_TOPR2; }
		if (this == Slidedoor_Blocks.AMADOS_BOT) { return Slidedoor_Blocks.TOBUKUROS_TOPR2; }
		return null;
	}
	
	private Block takeLeftTop() {
		if (this == Slidedoor_Blocks.AMADO_BOT) { return Slidedoor_Blocks.TOBUKURO_TOPL; }
		if (this == Slidedoor_Blocks.AMADOS_BOT) { return Slidedoor_Blocks.TOBUKUROS_TOPL; }
		return null;
	}
	
	private Block takeLeftTop2() {
		if (this == Slidedoor_Blocks.AMADO_BOT) { return Slidedoor_Blocks.TOBUKURO_TOPL2; }
		if (this == Slidedoor_Blocks.AMADOS_BOT) { return Slidedoor_Blocks.TOBUKUROS_TOPL2; }
		return null;
	}
	
	private Block takeTop() {
		if (this == Slidedoor_Blocks.AMADO_BOT) { return Slidedoor_Blocks.AMADO_TOP; }
		if (this == Slidedoor_Blocks.AMADOS_BOT) { return Slidedoor_Blocks.AMADOS_TOP; }
		return null;
	}
	
	/* A block that breaks at the same time when it is broken. */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn) {
		if (worldIn.getBlockState(pos.up()).getBlock() instanceof Amado_Top) {
			worldIn.destroyBlock(pos.up(), false); }
	}
	
	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Items.AIR;
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

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		EnumFacing facing = state.getValue(H_FACING);
		return AABB[facing.getHorizontalIndex()];
	}
}
