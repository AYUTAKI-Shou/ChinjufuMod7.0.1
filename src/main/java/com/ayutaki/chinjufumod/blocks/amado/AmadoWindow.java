package com.ayutaki.chinjufumod.blocks.amado;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage2_FaceWater;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Slidedoor_Blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class AmadoWindow extends BaseStage2_FaceWater {

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.box(0.0D, 0.0D, -0.5D, 16.0D, 16.0D, 0.5D);
	protected static final VoxelShape AABB_WEST = Block.box(15.5D, 0.0D, 0.0D, 16.5D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_NORTH = Block.box(0.0D, 0.0D, 15.5D, 16.0D, 16.0D, 16.5D);
	protected static final VoxelShape AABB_EAST = Block.box(-0.5D, 0.0D, 0.0D, 0.5D, 16.0D, 16.0D);

	public AmadoWindow(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		/** 1=左、2=右 **/
		int i = state.getValue(STAGE_1_2);
		Direction direction = state.getValue(H_FACING);
		Direction facing = playerIn.getDirection();

		BlockState northState = worldIn.getBlockState(pos.north());
		BlockState southState = worldIn.getBlockState(pos.south());
		BlockState eastState = worldIn.getBlockState(pos.east());
		BlockState westState = worldIn.getBlockState(pos.west());

		Block northBlock = northState.getBlock();
		Block southBlock = southState.getBlock();
		Block eastBlock = eastState.getBlock();
		Block westBlock = westState.getBlock();

		BlockState airState = Blocks.AIR.defaultBlockState();
		
		BlockState this_FACE1 = this.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING)).setValue(STAGE_1_2, Integer.valueOf(1));
		BlockState this_FACE2 = this.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING)).setValue(STAGE_1_2, Integer.valueOf(2));
		Block tobukuro = this.takeBlock();
		
		CMEvents.soundAmadoWin(worldIn, pos);
		
		switch (i) {
		case 1:
		default:
			
			switch (direction) {
			case NORTH:
			default:
				/** プレイヤーの向きと叩く位置 **/
				if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() < 0.45D) && westState.getMaterial().isReplaceable()) ||
						(facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() < 0.45D) && westState.getMaterial().isReplaceable())) {

					CMEvents.soundFusumaS(worldIn, pos);
					worldIn.setBlock(pos, airState, 3);
					worldIn.setBlock(pos.west(), this_FACE2, 3); }

				if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() > 0.55D) &&
						!eastState.getMaterial().isReplaceable() && eastBlock == tobukuro &&
						eastState.getValue(TobukuroWindow.WHICH) != true && eastState.getValue(TobukuroWindow.STAGE_1_3) > 1) ||
						(facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() > 0.55D) &&
						!eastState.getMaterial().isReplaceable() && eastBlock == tobukuro &&
						eastState.getValue(TobukuroWindow.WHICH) != true && eastState.getValue(TobukuroWindow.STAGE_1_3) > 1)) {

					CMEvents.soundFusumaS(worldIn, pos);
					worldIn.setBlock(pos, airState, 3);
					worldIn.setBlock(pos.east(), eastState.setValue(TobukuroWindow.STAGE_1_3, Integer.valueOf(eastState.getValue(TobukuroWindow.STAGE_1_3) - 1)), 3); }
				break;

			case SOUTH:
				if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() < 0.45D) &&
						!westState.getMaterial().isReplaceable() && westBlock == tobukuro &&
						westState.getValue(TobukuroWindow.WHICH) != true && westState.getValue(TobukuroWindow.STAGE_1_3) > 1) ||
						(facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() < 0.45D) &&
						!westState.getMaterial().isReplaceable() && westBlock == tobukuro &&
						westState.getValue(TobukuroWindow.WHICH) != true && westState.getValue(TobukuroWindow.STAGE_1_3) > 1)) {

					CMEvents.soundFusumaS(worldIn, pos);
					worldIn.setBlock(pos, airState, 3);
					worldIn.setBlock(pos.west(), westState.setValue(TobukuroWindow.STAGE_1_3, Integer.valueOf(westState.getValue(TobukuroWindow.STAGE_1_3) - 1)), 3); }
	
				if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() > 0.55D) && eastState.getMaterial().isReplaceable()) ||
						(facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() > 0.55D) && eastState.getMaterial().isReplaceable())) {
	
					CMEvents.soundFusumaS(worldIn, pos);
					worldIn.setBlock(pos, airState, 3);
					worldIn.setBlock(pos.east(), this_FACE2, 3); }
				break;

			case EAST:
				if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() < 0.45D) && northState.getMaterial().isReplaceable()) ||
						(facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() < 0.45D) && northState.getMaterial().isReplaceable())) {

					CMEvents.soundFusumaS(worldIn, pos);
					worldIn.setBlock(pos, airState, 3);
					worldIn.setBlock(pos.north(), this_FACE2, 3); }

				if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() > 0.55D) &&
						!southState.getMaterial().isReplaceable() && southBlock == tobukuro &&
						southState.getValue(TobukuroWindow.WHICH) != true && southState.getValue(TobukuroWindow.STAGE_1_3) > 1) ||
						(facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() > 0.55D) &&
						!southState.getMaterial().isReplaceable() && southBlock == tobukuro &&
						southState.getValue(TobukuroWindow.WHICH) != true && southState.getValue(TobukuroWindow.STAGE_1_3) > 1)) {

					CMEvents.soundFusumaS(worldIn, pos);
					worldIn.setBlock(pos, airState, 3);
					worldIn.setBlock(pos.south(), southState.setValue(TobukuroWindow.STAGE_1_3, Integer.valueOf(southState.getValue(TobukuroWindow.STAGE_1_3) - 1)), 3); }
				break;
				
			case WEST:
				if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() < 0.45D) &&
						!northState.getMaterial().isReplaceable() && northBlock == tobukuro &&
						northState.getValue(TobukuroWindow.WHICH) != true && northState.getValue(TobukuroWindow.STAGE_1_3) > 1) ||
						(facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() < 0.45D) &&
						!northState.getMaterial().isReplaceable() && northBlock == tobukuro &&
						northState.getValue(TobukuroWindow.WHICH) != true && northState.getValue(TobukuroWindow.STAGE_1_3) > 1)) {
	
					CMEvents.soundFusumaS(worldIn, pos);
					worldIn.setBlock(pos, airState, 3);
					worldIn.setBlock(pos.north(), northState.setValue(TobukuroWindow.STAGE_1_3, Integer.valueOf(northState.getValue(TobukuroWindow.STAGE_1_3) - 1)), 3); }
	
				if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() > 0.55D) && southState.getMaterial().isReplaceable()) ||
						(facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() > 0.55D) && southState.getMaterial().isReplaceable())) {
	
					CMEvents.soundFusumaS(worldIn, pos);
					worldIn.setBlock(pos, airState, 3);
					worldIn.setBlock(pos.south(), this_FACE2, 3); }
				break;
			} // switch
			break;

		case 2:
			
			switch (direction) {
			case NORTH:
			default:
				if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() < 0.45D) &&
						!westState.getMaterial().isReplaceable() && westBlock == tobukuro &&
						westState.getValue(TobukuroWindow.WHICH) == true && westState.getValue(TobukuroWindow.STAGE_1_3) > 1) ||
						(facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() < 0.45D) &&
						!westState.getMaterial().isReplaceable() && westBlock == tobukuro &&
						westState.getValue(TobukuroWindow.WHICH) == true && westState.getValue(TobukuroWindow.STAGE_1_3) > 1)) {
	
					CMEvents.soundFusumaS(worldIn, pos);
					worldIn.setBlock(pos, airState, 3);
					worldIn.setBlock(pos.west(), westState.setValue(TobukuroWindow.STAGE_1_3, Integer.valueOf(westState.getValue(TobukuroWindow.STAGE_1_3) - 1)), 3); }
	
	
				if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() > 0.55D) && eastState.getMaterial().isReplaceable()) ||
						(facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() > 0.55D) && eastState.getMaterial().isReplaceable())) {
	
					CMEvents.soundFusumaS(worldIn, pos);
					worldIn.setBlock(pos, airState, 3);
					worldIn.setBlock(pos.east(), this_FACE1, 3); }
				break;

			case SOUTH:
				if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() < 0.45D) && westState.getMaterial().isReplaceable()) ||
						(facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() < 0.45D) && westState.getMaterial().isReplaceable())) {

					CMEvents.soundFusumaS(worldIn, pos);
					worldIn.setBlock(pos, airState, 3);
					worldIn.setBlock(pos.west(), this_FACE1, 3); }

				if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() > 0.55D) &&
						!eastState.getMaterial().isReplaceable() && eastBlock == tobukuro &&
						eastState.getValue(TobukuroWindow.WHICH) == true && eastState.getValue(TobukuroWindow.STAGE_1_3) > 1) ||
						(facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() > 0.55D) &&
						!eastState.getMaterial().isReplaceable() && eastBlock == tobukuro &&
						eastState.getValue(TobukuroWindow.WHICH) == true && eastState.getValue(TobukuroWindow.STAGE_1_3) > 1)) {

					CMEvents.soundFusumaS(worldIn, pos);
					worldIn.setBlock(pos, airState, 3);
					worldIn.setBlock(pos.east(), eastState.setValue(TobukuroWindow.STAGE_1_3, Integer.valueOf(eastState.getValue(TobukuroWindow.STAGE_1_3) - 1)), 3); }
				break;

			case EAST:
				if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() < 0.45D) &&
						!northState.getMaterial().isReplaceable() && northBlock == tobukuro &&
						northState.getValue(TobukuroWindow.WHICH) == true && northState.getValue(TobukuroWindow.STAGE_1_3) > 1) ||
						(facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() < 0.45D) &&
						!northState.getMaterial().isReplaceable() && northBlock == tobukuro &&
						northState.getValue(TobukuroWindow.WHICH) == true && northState.getValue(TobukuroWindow.STAGE_1_3) > 1)) {
	
					CMEvents.soundFusumaS(worldIn, pos);
					worldIn.setBlock(pos, airState, 3);
					worldIn.setBlock(pos.north(), northState.setValue(TobukuroWindow.STAGE_1_3, Integer.valueOf(northState.getValue(TobukuroWindow.STAGE_1_3) - 1)), 3); }
	
	
				if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() > 0.55D) && southState.getMaterial().isReplaceable()) ||
						(facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() > 0.55D) && southState.getMaterial().isReplaceable())) {
	
					CMEvents.soundFusumaS(worldIn, pos);
					worldIn.setBlock(pos, airState, 3);
					worldIn.setBlock(pos.south(), this_FACE1, 3); }
				break;
				
			case WEST:
				if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() < 0.45D) && northState.getMaterial().isReplaceable()) ||
						(facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() < 0.45D) && northState.getMaterial().isReplaceable())) {

					CMEvents.soundFusumaS(worldIn, pos);
					worldIn.setBlock(pos, airState, 3);
					worldIn.setBlock(pos.north(), this_FACE1, 3); }

				if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() > 0.55D) &&
						!southState.getMaterial().isReplaceable() && southBlock == tobukuro &&
						southState.getValue(TobukuroWindow.WHICH) == true && southState.getValue(TobukuroWindow.STAGE_1_3) > 1) ||
						(facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() > 0.55D) &&
						!southState.getMaterial().isReplaceable() && southBlock == tobukuro &&
						southState.getValue(TobukuroWindow.WHICH) == true && southState.getValue(TobukuroWindow.STAGE_1_3) > 1)) {

					CMEvents.soundFusumaS(worldIn, pos);
					worldIn.setBlock(pos, airState, 3);
					worldIn.setBlock(pos.south(), southState.setValue(TobukuroWindow.STAGE_1_3, Integer.valueOf(southState.getValue(TobukuroWindow.STAGE_1_3) - 1)), 3); }
				break;
			} // switch
			break;
		} // switch STAGE_1_2
		
		return ActionResultType.SUCCESS;
	}

	private Block takeBlock() {
		if (this == Slidedoor_Blocks.AMADOWIN) { return Slidedoor_Blocks.TOBUKUROWIN; }
		if (this == Slidedoor_Blocks.AMADOWIN_S) { return Slidedoor_Blocks.TOBUKUROWIN_S; }
		return null;
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items.AIR);
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.getValue(H_FACING);

		switch (direction) {
		case NORTH:
		default: return AABB_NORTH;
		case SOUTH: return AABB_SOUTH;
		case WEST: return AABB_WEST;
		case EAST: return AABB_EAST;
		}
	}
	
	/* The best harvesting tool. */
	@Nullable
	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.AXE;
	}

	@Override
	public int getHarvestLevel(BlockState state) {
		return 0;
	}
}
