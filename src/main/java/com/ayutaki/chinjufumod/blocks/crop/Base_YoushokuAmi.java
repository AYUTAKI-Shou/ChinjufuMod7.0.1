package com.ayutaki.chinjufumod.blocks.crop;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AirBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class Base_YoushokuAmi extends CM_WaterLogged {

	/* Property */
	public static final IntegerProperty STAGE_1_9 = IntegerProperty.create("stage", 1, 9);
	public static final IntegerProperty AGE_1_12 = IntegerProperty.create("age", 1, 12);
	public static final BooleanProperty DOWN = BooleanProperty.create("down");
	public static final BooleanProperty UP = BooleanProperty.create("up");
	public static final BooleanProperty WAKE = BooleanProperty.create("wake");

	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);
	
	protected static final VoxelShape AABB_1 = VoxelShapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 2.0D),
			Block.box(0.0D, 0.0D, 0.0D, 2.0D, 16.0D, 16.0D));
	protected static final VoxelShape AABB_2 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 2.0D);
	protected static final VoxelShape AABB_3 = VoxelShapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 2.0D),
			Block.box(14.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D));
	protected static final VoxelShape AABB_4 = Block.box(0.0D, 0.0D, 0.0D, 2.0D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_6 = Block.box(14.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_7 = VoxelShapes.or(Block.box(0.0D, 0.0D, 14.0D, 16.0D, 16.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 2.0D, 16.0D, 16.0D));
	protected static final VoxelShape AABB_8 = Block.box(0.0D, 0.0D, 14.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_9 = VoxelShapes.or(Block.box(0.0D, 0.0D, 14.0D, 16.0D, 16.0D, 16.0D),
			Block.box(14.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D));	
	
	protected static final VoxelShape BOT_BASE = Block.box(0.0D, -1.0D, 0.0D, 16.0D, 2.0D, 16.0D);
	protected static final VoxelShape BOT_1 = VoxelShapes.or(AABB_1, BOT_BASE);
	protected static final VoxelShape BOT_2 = VoxelShapes.or(AABB_2, BOT_BASE);
	protected static final VoxelShape BOT_3 = VoxelShapes.or(AABB_3, BOT_BASE);
	protected static final VoxelShape BOT_4 = VoxelShapes.or(AABB_4, BOT_BASE);
	protected static final VoxelShape BOT_6 = VoxelShapes.or(AABB_6, BOT_BASE);
	protected static final VoxelShape BOT_7 = VoxelShapes.or(AABB_7, BOT_BASE);
	protected static final VoxelShape BOT_8 = VoxelShapes.or(AABB_8, BOT_BASE);
	protected static final VoxelShape BOT_9 = VoxelShapes.or(AABB_9, BOT_BASE);
	
	protected static final VoxelShape TAKE_1 = VoxelShapes.or(Block.box(0.0D, 13.0D, 0.0D, 16.0D, 16.0D, 3.0D),
			Block.box(0.0D, 13.0D, 3.0D, 3.0D, 16.0D, 16.0D));
	protected static final VoxelShape TAKE_2 = Block.box(0.0D, 13.0D, 0.0D, 16.0D, 16.0D, 3.0D);
	protected static final VoxelShape TAKE_3 = VoxelShapes.or(Block.box(0.0D, 13.0D, 0.0D, 16.0D, 16.0D, 3.0D),
			Block.box(13.0D, 13.0D, 3.0D, 16.0D, 16.0D, 16.0D));
	protected static final VoxelShape TAKE_4 = Block.box(0.0D, 13.0D, 0.0D, 3.0D, 16.0D, 16.0D);
	protected static final VoxelShape TAKE_6 = Block.box(13.0D, 13.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape TAKE_7 = VoxelShapes.or(Block.box(0.0D, 13.0D, 13.0D, 16.0D, 16.0D, 16.0D),
			Block.box(0.0D, 13.0D, 0.0D, 3.0D, 16.0D, 13.0D));
	protected static final VoxelShape TAKE_8 = Block.box(0.0D, 13.0D, 13.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape TAKE_9 = VoxelShapes.or(Block.box(0.0D, 13.0D, 13.0D, 16.0D, 16.0D, 16.0D),
			Block.box(13.0D, 13.0D, 0.0D, 16.0D, 16.0D, 13.0D));
	
	protected static final VoxelShape TOP_1 = VoxelShapes.or(AABB_1, TAKE_1);
	protected static final VoxelShape TOP_2 = VoxelShapes.or(AABB_2, TAKE_2);
	protected static final VoxelShape TOP_3 = VoxelShapes.or(AABB_3, TAKE_3);
	protected static final VoxelShape TOP_4 = VoxelShapes.or(AABB_4, TAKE_4);
	protected static final VoxelShape TOP_6 = VoxelShapes.or(AABB_6, TAKE_6);
	protected static final VoxelShape TOP_7 = VoxelShapes.or(AABB_7, TAKE_7);
	protected static final VoxelShape TOP_8 = VoxelShapes.or(AABB_8, TAKE_8);
	protected static final VoxelShape TOP_9 = VoxelShapes.or(AABB_9, TAKE_9);
	
	protected static final VoxelShape TOPBOT_1 = VoxelShapes.or(AABB_1, TAKE_1, BOT_BASE);
	protected static final VoxelShape TOPBOT_2 = VoxelShapes.or(AABB_2, TAKE_2, BOT_BASE);
	protected static final VoxelShape TOPBOT_3 = VoxelShapes.or(AABB_3, TAKE_3, BOT_BASE);
	protected static final VoxelShape TOPBOT_4 = VoxelShapes.or(AABB_4, TAKE_4, BOT_BASE);
	protected static final VoxelShape TOPBOT_6 = VoxelShapes.or(AABB_6, TAKE_6, BOT_BASE);
	protected static final VoxelShape TOPBOT_7 = VoxelShapes.or(AABB_7, TAKE_7, BOT_BASE);
	protected static final VoxelShape TOPBOT_8 = VoxelShapes.or(AABB_8, TAKE_8, BOT_BASE);
	protected static final VoxelShape TOPBOT_9 = VoxelShapes.or(AABB_9, TAKE_9, BOT_BASE);
	
	public Base_YoushokuAmi(AbstractBlock.Properties properties) {
		super(properties);
		
		/** Default state **/
		registerDefaultState(this.defaultBlockState().setValue(STAGE_1_9, Integer.valueOf(5))
				.setValue(AGE_1_12, Integer.valueOf(1))
				.setValue(DOWN, Boolean.valueOf(false))
				.setValue(UP, Boolean.valueOf(false))
				.setValue(WAKE, Boolean.valueOf(false))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		int stage = state.getValue(STAGE_1_9);
		
		switch (stage) {
		case 5:
		default: return AABB_BOX;
		case 1:
		case 2:
		case 3:
		case 4:
		case 6:
		case 7:
		case 8:
		case 9: return VoxelShapes.empty();
		}
	}
	
	@Override
	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		int stage = state.getValue(STAGE_1_9);
		
		boolean down = state.getValue(DOWN);
		boolean up = state.getValue(UP);
		
		if (down == false) {
			if (up == false) {
				switch (stage) {
				case 1:
				default: return BOT_1;
				case 2: return BOT_2;
				case 3: return BOT_3;
				case 4: return BOT_4;
				case 5: return BOT_BASE;
				case 6: return BOT_6;
				case 7: return BOT_7;
				case 8: return BOT_8;
				case 9: return BOT_9;
				}
			}
			
			else {
				switch (stage) {
				case 1:
				default: return TOPBOT_1;
				case 2: return TOPBOT_2;
				case 3: return TOPBOT_3;
				case 4: return TOPBOT_4;
				case 5: return BOT_BASE;
				case 6: return TOPBOT_6;
				case 7: return TOPBOT_7;
				case 8: return TOPBOT_8;
				case 9: return TOPBOT_9;
				}
			}
		} // Down block is Not this.
		
		else {
			if (up == false) {
				switch (stage) {
				case 1:
				default: return AABB_1;
				case 2: return AABB_2;
				case 3: return AABB_3;
				case 4: return AABB_4;
				case 5: return VoxelShapes.empty();
				case 6: return AABB_6;
				case 7: return AABB_7;
				case 8: return AABB_8;
				case 9: return AABB_9;
				}
			}
			
			else {
				switch (stage) {
				case 1:
				default: return TOP_1;
				case 2: return TOP_2;
				case 3: return TOP_3;
				case 4: return TOP_4;
				case 5: return VoxelShapes.empty();
				case 6: return TOP_6;
				case 7: return TOP_7;
				case 8: return TOP_8;
				case 9: return TOP_9;
				}
			}
		} // Down block is this.
	}
	
	/* Connect the blocks. */
	protected boolean connectThis(IBlockReader worldIn, BlockPos pos, Direction face) {
		BlockPos newPos = pos.relative(face);
		BlockState state = worldIn.getBlockState(newPos);
		Block block = state.getBlock();

		return block instanceof Base_YoushokuAmi;
	}
	
	protected boolean connectAir(IBlockReader worldIn, BlockPos pos, Direction face) {
		BlockPos newPos = pos.relative(face);
		BlockState state = worldIn.getBlockState(newPos);
		Block block = state.getBlock();

		return block instanceof AirBlock;
	}
	
	/* Update BlockState. */
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }
		
		if (!state.canSurvive(worldIn, pos)) { return Blocks.AIR.defaultBlockState(); }
		
		boolean down = connectThis(worldIn, pos, Direction.DOWN);
		boolean up = connectAir(worldIn, pos, Direction.UP);
		return state.setValue(DOWN, down).setValue(UP, up);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
		int stage = state.getValue(STAGE_1_9);
		
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		
		if (stage == 1) { return worldIn.getBlockState(new BlockPos(x + 1, y, z)).getBlock() instanceof Base_YoushokuAmi; }
		if (stage == 2) { return worldIn.getBlockState(new BlockPos(x, y, z + 1)).getBlock() instanceof Base_YoushokuAmi; }
		if (stage == 3) { return worldIn.getBlockState(new BlockPos(x - 1, y, z)).getBlock() instanceof Base_YoushokuAmi; }
		if (stage == 4) { return worldIn.getBlockState(new BlockPos(x + 1, y, z)).getBlock() instanceof Base_YoushokuAmi; }
		if (stage == 6) { return worldIn.getBlockState(new BlockPos(x - 1, y, z)).getBlock() instanceof Base_YoushokuAmi; }
		if (stage == 7) { return worldIn.getBlockState(new BlockPos(x + 1, y, z)).getBlock() instanceof Base_YoushokuAmi; }
		if (stage == 8) { return worldIn.getBlockState(new BlockPos(x, y, z - 1)).getBlock() instanceof Base_YoushokuAmi; }
		if (stage == 9) { return worldIn.getBlockState(new BlockPos(x - 1, y, z)).getBlock() instanceof Base_YoushokuAmi; }
		return super.canSurvive(state, worldIn, pos);
	}
	
	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(AGE_1_12, DOWN, STAGE_1_9, UP, WAKE, WATERLOGGED);
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.YOUSHOKU_AMI);
	}
	
	/* Destroy at the same time. & Drop item. */
	@Override
	public void playerWillDestroy(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {

		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		
		BlockState state1 = worldIn.getBlockState(new BlockPos(x - 1, y, z - 1));
		BlockState state2 = worldIn.getBlockState(new BlockPos(x, y, z - 1));
		BlockState state3 = worldIn.getBlockState(new BlockPos(x + 1, y, z - 1));
		BlockState state4 = worldIn.getBlockState(new BlockPos(x - 1, y, z));
		BlockState state6 = worldIn.getBlockState(new BlockPos(x + 1, y, z));
		BlockState state7 = worldIn.getBlockState(new BlockPos(x - 1, y, z + 1));
		BlockState state8 = worldIn.getBlockState(new BlockPos(x, y, z + 1));
		BlockState state9 = worldIn.getBlockState(new BlockPos(x + 1, y, z + 1));

		/** False is not Drop. **/
		if (state1.getBlock() instanceof Base_YoushokuAmi) { worldIn.destroyBlock(new BlockPos(x - 1, y, z - 1), false); }
		if (state2.getBlock() instanceof Base_YoushokuAmi) { worldIn.destroyBlock(new BlockPos(x, y, z - 1), false); }
		if (state3.getBlock() instanceof Base_YoushokuAmi) { worldIn.destroyBlock(new BlockPos(x + 1, y, z - 1), false); }
		if (state4.getBlock() instanceof Base_YoushokuAmi) { worldIn.destroyBlock(new BlockPos(x - 1, y, z), false); }
		if (state6.getBlock() instanceof Base_YoushokuAmi) { worldIn.destroyBlock(new BlockPos(x + 1, y, z), false); }
		if (state7.getBlock() instanceof Base_YoushokuAmi) { worldIn.destroyBlock(new BlockPos(x - 1, y, z + 1), false); }
		if (state8.getBlock() instanceof Base_YoushokuAmi) { worldIn.destroyBlock(new BlockPos(x, y, z + 1), false); }
		if (state9.getBlock() instanceof Base_YoushokuAmi) { worldIn.destroyBlock(new BlockPos(x + 1, y, z + 1), false); }
		super.playerWillDestroy(worldIn, pos, state, playerIn);
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
