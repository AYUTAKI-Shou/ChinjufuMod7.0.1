package com.ayutaki.chinjufumod.blocks.crop;

import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Base_YoushokuAmi extends CM_WaterLogged {

	/* Property */
	public static final IntegerProperty STAGE_1_9 = IntegerProperty.create("stage", 1, 9);
	public static final IntegerProperty AGE_1_12 = IntegerProperty.create("age", 1, 12);
	public static final BooleanProperty DOWN = BooleanProperty.create("down");
	public static final BooleanProperty UP = BooleanProperty.create("up");
	public static final BooleanProperty WAKE = BooleanProperty.create("wake");

	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);
	
	protected static final VoxelShape AABB_1 = Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 2.0D),
			Block.box(0.0D, 0.0D, 0.0D, 2.0D, 16.0D, 16.0D));
	protected static final VoxelShape AABB_2 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 2.0D);
	protected static final VoxelShape AABB_3 = Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 2.0D),
			Block.box(14.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D));
	protected static final VoxelShape AABB_4 = Block.box(0.0D, 0.0D, 0.0D, 2.0D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_6 = Block.box(14.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_7 = Shapes.or(Block.box(0.0D, 0.0D, 14.0D, 16.0D, 16.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 2.0D, 16.0D, 16.0D));
	protected static final VoxelShape AABB_8 = Block.box(0.0D, 0.0D, 14.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_9 = Shapes.or(Block.box(0.0D, 0.0D, 14.0D, 16.0D, 16.0D, 16.0D),
			Block.box(14.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D));	
	
	protected static final VoxelShape BOT_BASE = Block.box(0.0D, -1.0D, 0.0D, 16.0D, 2.0D, 16.0D);
	protected static final VoxelShape BOT_1 = Shapes.or(AABB_1, BOT_BASE);
	protected static final VoxelShape BOT_2 = Shapes.or(AABB_2, BOT_BASE);
	protected static final VoxelShape BOT_3 = Shapes.or(AABB_3, BOT_BASE);
	protected static final VoxelShape BOT_4 = Shapes.or(AABB_4, BOT_BASE);
	protected static final VoxelShape BOT_6 = Shapes.or(AABB_6, BOT_BASE);
	protected static final VoxelShape BOT_7 = Shapes.or(AABB_7, BOT_BASE);
	protected static final VoxelShape BOT_8 = Shapes.or(AABB_8, BOT_BASE);
	protected static final VoxelShape BOT_9 = Shapes.or(AABB_9, BOT_BASE);
	
	protected static final VoxelShape TAKE_1 = Shapes.or(Block.box(0.0D, 13.0D, 0.0D, 16.0D, 16.0D, 3.0D),
			Block.box(0.0D, 13.0D, 3.0D, 3.0D, 16.0D, 16.0D));
	protected static final VoxelShape TAKE_2 = Block.box(0.0D, 13.0D, 0.0D, 16.0D, 16.0D, 3.0D);
	protected static final VoxelShape TAKE_3 = Shapes.or(Block.box(0.0D, 13.0D, 0.0D, 16.0D, 16.0D, 3.0D),
			Block.box(13.0D, 13.0D, 3.0D, 16.0D, 16.0D, 16.0D));
	protected static final VoxelShape TAKE_4 = Block.box(0.0D, 13.0D, 0.0D, 3.0D, 16.0D, 16.0D);
	protected static final VoxelShape TAKE_6 = Block.box(13.0D, 13.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape TAKE_7 = Shapes.or(Block.box(0.0D, 13.0D, 13.0D, 16.0D, 16.0D, 16.0D),
			Block.box(0.0D, 13.0D, 0.0D, 3.0D, 16.0D, 13.0D));
	protected static final VoxelShape TAKE_8 = Block.box(0.0D, 13.0D, 13.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape TAKE_9 = Shapes.or(Block.box(0.0D, 13.0D, 13.0D, 16.0D, 16.0D, 16.0D),
			Block.box(13.0D, 13.0D, 0.0D, 16.0D, 16.0D, 13.0D));
	
	protected static final VoxelShape TOP_1 = Shapes.or(AABB_1, TAKE_1);
	protected static final VoxelShape TOP_2 = Shapes.or(AABB_2, TAKE_2);
	protected static final VoxelShape TOP_3 = Shapes.or(AABB_3, TAKE_3);
	protected static final VoxelShape TOP_4 = Shapes.or(AABB_4, TAKE_4);
	protected static final VoxelShape TOP_6 = Shapes.or(AABB_6, TAKE_6);
	protected static final VoxelShape TOP_7 = Shapes.or(AABB_7, TAKE_7);
	protected static final VoxelShape TOP_8 = Shapes.or(AABB_8, TAKE_8);
	protected static final VoxelShape TOP_9 = Shapes.or(AABB_9, TAKE_9);
	
	protected static final VoxelShape TOPBOT_1 = Shapes.or(AABB_1, TAKE_1, BOT_BASE);
	protected static final VoxelShape TOPBOT_2 = Shapes.or(AABB_2, TAKE_2, BOT_BASE);
	protected static final VoxelShape TOPBOT_3 = Shapes.or(AABB_3, TAKE_3, BOT_BASE);
	protected static final VoxelShape TOPBOT_4 = Shapes.or(AABB_4, TAKE_4, BOT_BASE);
	protected static final VoxelShape TOPBOT_6 = Shapes.or(AABB_6, TAKE_6, BOT_BASE);
	protected static final VoxelShape TOPBOT_7 = Shapes.or(AABB_7, TAKE_7, BOT_BASE);
	protected static final VoxelShape TOPBOT_8 = Shapes.or(AABB_8, TAKE_8, BOT_BASE);
	protected static final VoxelShape TOPBOT_9 = Shapes.or(AABB_9, TAKE_9, BOT_BASE);
	
	public Base_YoushokuAmi(BlockBehaviour.Properties properties) {
		super(properties);
		/** Default state **/
		registerDefaultState(this.stateDefinition.any().setValue(STAGE_1_9, Integer.valueOf(5))
				.setValue(AGE_1_12, Integer.valueOf(1))
				.setValue(DOWN, Boolean.valueOf(false))
				.setValue(UP, Boolean.valueOf(false))
				.setValue(WAKE, Boolean.valueOf(false))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
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
		case 9: return Shapes.empty();
		}
	}
	
	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
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
				case 5: return Shapes.empty();
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
				case 5: return Shapes.empty();
				case 6: return TOP_6;
				case 7: return TOP_7;
				case 8: return TOP_8;
				case 9: return TOP_9;
				}
			}
		} // Down block is this.
	}
	
	/* Connect the blocks. */
	protected boolean connectThis(BlockGetter worldIn, BlockPos pos, Direction direct) {
		BlockPos newPos = pos.relative(direct);
		BlockState state = worldIn.getBlockState(newPos);
		Block block = state.getBlock();

		return block instanceof Base_YoushokuAmi;
	}
	
	protected boolean connectAir(BlockGetter worldIn, BlockPos pos, Direction direct) {
		BlockPos newPos = pos.relative(direct);
		BlockState state = worldIn.getBlockState(newPos);
		Block block = state.getBlock();

		return block instanceof AirBlock;
	}
	
	/* Update BlockState. */
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos pos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			worldIn.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }
		
		if (!state.canSurvive(worldIn, pos)) { return Blocks.AIR.defaultBlockState(); }
		
		boolean down = connectThis(worldIn, pos, Direction.DOWN);
		boolean up = connectAir(worldIn, pos, Direction.UP);
		return state.setValue(DOWN, down).setValue(UP, up);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
		int stage = state.getValue(STAGE_1_9);
		
		int x = (int) pos.getX();
		int y = (int) pos.getY();
		int z = (int) pos.getZ();
		
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
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(AGE_1_12, DOWN, STAGE_1_9, UP, WAKE, WATERLOGGED);
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.YOUSHOKU_AMI.get());
	}

	/* Destroy a DoubleBlock from DoublePlantBlock.class */
	@Override
	public void playerWillDestroy(Level worldIn, BlockPos pos, BlockState state, Player playerIn) {
		int x = (int) pos.getX();
		int y = (int) pos.getY();
		int z = (int) pos.getZ();
		
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
}
