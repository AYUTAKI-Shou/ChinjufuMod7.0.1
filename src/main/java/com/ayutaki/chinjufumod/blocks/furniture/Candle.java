package com.ayutaki.chinjufumod.blocks.furniture;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingSlab_Water;
import com.ayutaki.chinjufumod.blocks.base.CM_WaterLogged;
import com.ayutaki.chinjufumod.blocks.jpblock.Base_Slab_JP;
import com.ayutaki.chinjufumod.blocks.jpdeco.BaseTatami;
import com.ayutaki.chinjufumod.blocks.unitblock.Chabudai;
import com.ayutaki.chinjufumod.blocks.unitblock.Kotatsu;
import com.ayutaki.chinjufumod.blocks.unitblock.LowDesk;
import com.ayutaki.chinjufumod.blocks.wood.WoodSlab_CM;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.color.Base_ItemHake;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.state.TatamiType;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Candle extends CM_WaterLogged {

	/* Property */
	public static final BooleanProperty DOWN = BooleanProperty.create("down");
	public static final BooleanProperty LIT = BooleanProperty.create("lit");

	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.makeCuboidShape(6.8D, 0.0D, 6.8D, 9.2D, 2.5D, 9.2D);
	protected static final VoxelShape AABB_DOWN = Block.makeCuboidShape(6.8D, -8.0D, 6.8D, 9.2D, 0.1D, 9.2D);

	public Candle(Block.Properties properties) {
		super(properties);

		/** Default state **/
		setDefaultState(this.stateContainer.getBaseState()
				.with(LIT, Boolean.valueOf(false))
				.with(DOWN, Boolean.valueOf(false))
				.with(WATERLOGGED, Boolean.valueOf(false)));
	}

	public int getLightValue(BlockState state) {
		return state.get(LIT) ? 13 : 0;
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack stack = playerIn.getHeldItem(hand);
		Item item = stack.getItem();
		boolean lit = state.get(LIT);

		if (item instanceof Base_ItemHake) { return ActionResultType.PASS; }

		else {
			if (lit == false) {
				
				if (!state.get(WATERLOGGED) && !connectWater(worldIn, pos, Direction.DOWN)) {
					
					if (item == Items.FLINT_AND_STEEL) {
						stack.damageItem(1, playerIn, user -> { user.sendBreakAnimation(hand); } );
						
						CMEvents.soundFlint(worldIn, pos);
						worldIn.setBlockState(pos, state.with(LIT, Boolean.valueOf(true))); }

					if (item == Items_Teatime.MATCH) {
						CMEvents.Consume1Item_Flint(worldIn, pos, playerIn, hand);	
						worldIn.setBlockState(pos, state.with(LIT, Boolean.valueOf(true))); }
					
					if (item != Items.FLINT_AND_STEEL && item != Items_Teatime.MATCH) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				}
				
				if (state.get(WATERLOGGED) || connectWater(worldIn, pos, Direction.DOWN)) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); }
			}
			
			if (lit == true) {
				if (stack.isEmpty()) {
					CMEvents.soundFireExting(worldIn, pos);
					worldIn.setBlockState(pos, state.with(LIT, Boolean.valueOf(false))); }
				
				if (!stack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
			}

			/** SUCCESS to not put anything on top. **/
			return ActionResultType.SUCCESS;
		}
	}

	/* Gives a value when placed. */
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		World worldIn = context.getWorld();
		BlockPos pos = context.getPos();
		IFluidState fluid = worldIn.getFluidState(pos);
		
		return this.getDefaultState().with(WATERLOGGED, fluid.getFluid() == Fluids.WATER)
				.with(DOWN, this.connectHalf(worldIn, pos, Direction.DOWN));
	}

	/* Connect the blocks. */
	protected boolean connectHalf(IBlockReader worldIn, BlockPos pos, Direction face) {
		BlockPos newPos = pos.offset(face);
		BlockState state = worldIn.getBlockState(newPos);
		Block block = state.getBlock();

		return ((block instanceof SlabBlock && state.get(SlabBlock.TYPE) == SlabType.BOTTOM) ||
				(block instanceof WoodSlab_CM && state.get(SlabBlock.TYPE) == SlabType.BOTTOM) ||
				(block instanceof BaseFacingSlab_Water && state.get(SlabBlock.TYPE) == SlabType.BOTTOM) ||
				(block instanceof Base_Slab_JP && state.get(Base_Slab_JP.TYPE) == SlabType.BOTTOM) ||
				(block instanceof BaseTatami && state.get(BaseTatami.TYPE) == TatamiType.BOTTOM) ||
				block instanceof LowDesk || block instanceof Chabudai || block instanceof Kotatsu);
	}

	protected boolean connectWater(IBlockReader worldIn, BlockPos pos, Direction face) {
		BlockPos newPos = pos.offset(face);
		BlockState state = worldIn.getBlockState(newPos);
		Block block = state.getBlock();

		return ((block instanceof SlabBlock && state.get(SlabBlock.TYPE) == SlabType.BOTTOM && state.get(SlabBlock.WATERLOGGED)) ||
				(block instanceof WoodSlab_CM && state.get(SlabBlock.TYPE) == SlabType.BOTTOM && state.get(SlabBlock.WATERLOGGED)) ||
				(block instanceof BaseFacingSlab_Water && state.get(SlabBlock.TYPE) == SlabType.BOTTOM && state.get(SlabBlock.WATERLOGGED)) ||
				(block instanceof Base_Slab_JP && state.get(Base_Slab_JP.TYPE) == SlabType.BOTTOM && state.get(SlabBlock.WATERLOGGED)) ||
				(block instanceof BaseTatami && state.get(BaseTatami.TYPE) == TatamiType.BOTTOM && state.get(SlabBlock.WATERLOGGED)) ||
				(block instanceof LowDesk && state.get(LowDesk.WATERLOGGED)) ||
				(block instanceof Chabudai && state.get(Chabudai.WATERLOGGED)) ||
				(block instanceof Kotatsu && state.get(Kotatsu.WATERLOGGED)));
	}

	/* Distinguish LOST from WATERLOGGED. */
	protected boolean inWater(BlockState state, IBlockReader worldIn, BlockPos pos) {
		if (state.get(WATERLOGGED) || connectWater(worldIn, pos, Direction.DOWN)) { return true; }
		return false;
	}
	
	/* Update BlockState. */
	@Override
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if (inWater(state, worldIn, pos)) { worldIn.getPendingBlockTicks().scheduleTick(pos, this, 10); }

		boolean down = connectHalf(worldIn, pos, Direction.DOWN);
		return state.with(DOWN, down);
	}

	/* TickRandom */
	@Override
	public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		if (inWater(state, worldIn, pos)) { worldIn.getPendingBlockTicks().scheduleTick(pos, this, 10); }
	}

	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		if (state.get(LIT) == true && (inWater(state, worldIn, pos) || connectWater(worldIn, pos, Direction.DOWN))) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, this, 10);
			CMEvents.soundFireExting(worldIn, pos);
			worldIn.setBlockState(pos, state.with(LIT, Boolean.valueOf(false))); }
		
		else { }
	}

	/* Create Blockstate */
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(DOWN, LIT, WATERLOGGED);
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		boolean flag= !((Boolean)state.get(DOWN)).booleanValue();
		return flag ? AABB_BOX : AABB_DOWN;
	}

	/* Can't breathe. */
	@Override
	public boolean causesSuffocation(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	/* Block is a cube. */
	@Override
	public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	/* Mobs spawn. */
	@Override
	public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type) {
		return false;
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_andon").applyTextStyle(TextFormatting.GRAY));
	}
}
