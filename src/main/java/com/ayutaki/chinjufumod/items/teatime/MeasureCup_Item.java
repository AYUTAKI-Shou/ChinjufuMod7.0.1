package com.ayutaki.chinjufumod.items.teatime;

import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ItemGroups_CM;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CauldronBlock;
import net.minecraft.block.SoundType;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.server.MinecraftServer;
import net.minecraft.state.Property;
import net.minecraft.state.StateContainer;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/* BucketItem に BlockItem を追加して、設置処理で分岐。BlockItem への BucketItem は大釜で汲めない問題にぶつかる*/
public class MeasureCup_Item extends BucketItem {

	private final Fluid content;
	private final Block block;

	@SuppressWarnings("deprecation")
	public MeasureCup_Item(Fluid containedFluidIn, Block blockIn, Item.Properties properties) {
		super(containedFluidIn, properties.tab(ItemGroups_CM.TEATIME));
		this.block = blockIn;
		this.content = containedFluidIn;
	}

	/* 水を入れる BucketItem */
	@Override
	public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack stack = playerIn.getItemInHand(handIn);
		RayTraceResult raytraceresult = getPlayerPOVHitResult(worldIn, playerIn, this.content == Fluids.EMPTY ? RayTraceContext.FluidMode.SOURCE_ONLY : RayTraceContext.FluidMode.NONE);
		ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onBucketUse(playerIn, worldIn, stack, raytraceresult);

		boolean mode = playerIn.abilities.instabuild;

		BlockRayTraceResult blockResult = (BlockRayTraceResult)raytraceresult;
		BlockPos pos = blockResult.getBlockPos();
		Direction direction = blockResult.getDirection();
		BlockPos pos1 = pos.relative(direction);
		BlockState stateIn1 = worldIn.getBlockState(pos);
		Block block = stateIn1.getBlock();

		if (ret != null) return ret;

		if (raytraceresult.getType() == RayTraceResult.Type.MISS) { return ActionResult.pass(stack); }

		if (raytraceresult.getType() != RayTraceResult.Type.BLOCK) { return ActionResult.pass(stack); }

		else {
			if (!playerIn.isCrouching()) {
				if (worldIn.mayInteract(playerIn, pos) && playerIn.mayUseItemAt(pos1, direction, stack)) {

					if (this.content == Fluids.EMPTY) {
						/** 大釜からの給水 **/
						if (stateIn1.getBlock() == Blocks.CAULDRON) {
							int cauldron = stateIn1.getValue(CauldronBlock.LEVEL);

							if (cauldron == 0) { return ActionResult.pass(stack); }
							
							else {
								playerIn.awardStat(Stats.USE_CAULDRON);
								worldIn.playSound(playerIn, pos, SoundEvents.BOTTLE_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
								
								((CauldronBlock)block).setWaterLevel(worldIn, pos, stateIn1, cauldron - 1);
								if (!playerIn.inventory.add(new ItemStack(Items_Teatime.KEIRYO_CUP_full))) {
									playerIn.drop(new ItemStack(Items_Teatime.KEIRYO_CUP_full), false); }

								if (!mode) { stack.shrink(1); }
								if (mode) { }
								return ActionResult.success(stack); }
						}
						
						if (worldIn.getFluidState(pos).is(FluidTags.WATER)) {
							worldIn.playSound(playerIn, pos, SoundEvents.BOTTLE_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);

							if (!playerIn.inventory.add(new ItemStack(Items_Teatime.KEIRYO_CUP_full))) {
								playerIn.drop(new ItemStack(Items_Teatime.KEIRYO_CUP_full), false); }

							if (!mode) { stack.shrink(1); }
							if (mode) { }
							return ActionResult.success(stack);
						}
						return ActionResult.pass(stack);
					}//empty
				}
			}//!sneaking

			return ActionResult.pass(stack);
		}
	}

	@Override
	public void checkExtraContent(World worldIn, ItemStack stack, BlockPos pos) { }

	//////* BlockItem *///////////////////////////////////////////////
	/** 設置処理の分岐 **/
	@Override
	public ActionResultType useOn(ItemUseContext context) {
		PlayerEntity playerIn = context.getPlayer();

		if (context.getClickedFace() == Direction.UP && playerIn.isCrouching()) {
			return this.place(new BlockItemUseContext(context)); }

		else {
			return this.use(context.getLevel(), context.getPlayer(), context.getHand()).getResult(); }
	}

	public ActionResultType place(BlockItemUseContext context) {

		if (!context.canPlace()) { return ActionResultType.FAIL; }

		else {
			BlockItemUseContext blockcontext = this.updatePlacementContext(context);

			if (blockcontext == null) { return ActionResultType.FAIL; }

			else {
				BlockState stateIn = this.getPlacementState(blockcontext);

				if (stateIn == null) { return ActionResultType.FAIL; }

				else if (!this.placeBlock(blockcontext, stateIn)) { return ActionResultType.FAIL; }

				else {
					BlockPos pos1 = blockcontext.getClickedPos();
					World worldIn = blockcontext.getLevel();
					PlayerEntity playerIn = blockcontext.getPlayer();
					ItemStack stack = blockcontext.getItemInHand();
					BlockState stateIn1 = worldIn.getBlockState(pos1);
					Block block = stateIn1.getBlock();
					if (block == stateIn.getBlock()) {
						stateIn1 = this.updateBlockStateFromTag(pos1, worldIn, stack, stateIn1);
						this.updateCustomBlockEntityTag(pos1, worldIn, playerIn, stack, stateIn1);
						block.setPlacedBy(worldIn, pos1, stateIn1, playerIn, stack);
						if (playerIn instanceof ServerPlayerEntity) {
							CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayerEntity)playerIn, pos1, stack);
						}
					}

					SoundType soundtype = stateIn1.getSoundType(worldIn, pos1, context.getPlayer());
					worldIn.playSound(playerIn, pos1, this.getPlaceSound(stateIn1, worldIn, pos1, context.getPlayer()), SoundCategory.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);

					if (playerIn == null || !playerIn.abilities.instabuild) { stack.shrink(1); }

					return ActionResultType.sidedSuccess(worldIn.isClientSide);
				}
			}
		}
	}

	@Deprecated //Forge: Use more sensitive version {@link BlockItem#getPlaceSound(BlockState, IBlockReader, BlockPos, Entity) }
	protected SoundEvent getPlaceSound(BlockState state) {
		return state.getSoundType().getPlaceSound();
	}

	protected SoundEvent getPlaceSound(BlockState state, World worldIn, BlockPos pos, PlayerEntity entity) {
		return state.getSoundType(worldIn, pos, entity).getPlaceSound();
	}

	@Nullable
	public BlockItemUseContext updatePlacementContext(BlockItemUseContext context) {
		return context;
	}

	protected boolean updateCustomBlockEntityTag(BlockPos pos, World worldIn, @Nullable PlayerEntity playerIn, ItemStack stack, BlockState state) {
		return updateCustomBlockEntityTag(worldIn, playerIn, pos, stack);
	}

	@Nullable
	protected BlockState getPlacementState(BlockItemUseContext context) {
		BlockState stateIn = this.getBlock().getStateForPlacement(context);
		return stateIn != null && this.canPlace(context, stateIn) ? stateIn : null;
	}

	private BlockState updateBlockStateFromTag(BlockPos pos, World worldIn, ItemStack stack, BlockState state) {
		BlockState stateIn = state;
		CompoundNBT compoundnbt = stack.getTag();
		if (compoundnbt != null) {
			CompoundNBT compoundnbt1 = compoundnbt.getCompound("BlockStateTag");
			StateContainer<Block, BlockState> statecontainer = state.getBlock().getStateDefinition();

			for(String s : compoundnbt1.getAllKeys()) {
				Property<?> iproperty = statecontainer.getProperty(s);
				if (iproperty != null) {
					String s1 = compoundnbt1.get(s).getAsString();
					stateIn = updateState(stateIn, iproperty, s1);
				}
			}
		}

		if (stateIn != state) {
			worldIn.setBlock(pos, stateIn, 2);
		}

		return stateIn;
	}

	private static <T extends Comparable<T>> BlockState updateState(BlockState state, Property<T> property, String string) {
		return property.getValue(string).map((mapper) -> {
			return state.setValue(property, mapper);
		}).orElse(state);
	}

	protected boolean canPlace(BlockItemUseContext context, BlockState state) {
		PlayerEntity playerIn = context.getPlayer();
		ISelectionContext iselectioncontext = playerIn == null ? ISelectionContext.empty() : ISelectionContext.of(playerIn);
		return (!this.mustSurvive() || state.canSurvive(context.getLevel(), context.getClickedPos())) && context.getLevel().isUnobstructed(state, context.getClickedPos(), iselectioncontext);
	}

	protected boolean mustSurvive() {
		return true;
	}

	protected boolean placeBlock(BlockItemUseContext context, BlockState state) {
		return context.getLevel().setBlock(context.getClickedPos(), state, 11);
	}

	public static boolean updateCustomBlockEntityTag(World worldIn, @Nullable PlayerEntity playerIn, BlockPos pos, ItemStack stack) {
		MinecraftServer minecraftserver = worldIn.getServer();
		if (minecraftserver == null) {
			return false;
		}

		else {
			CompoundNBT compoundnbt = stack.getTagElement("BlockEntityTag");
			if (compoundnbt != null) {
				TileEntity tileentity = worldIn.getBlockEntity(pos);
				if (tileentity != null) {
					if (!worldIn.isClientSide && tileentity.onlyOpCanSetNbt() && (playerIn == null || !playerIn.canUseGameMasterBlocks())) {
						return false;
					}

					CompoundNBT compoundnbt1 = tileentity.save(new CompoundNBT());
					CompoundNBT compoundnbt2 = compoundnbt1.copy();
					compoundnbt1.merge(compoundnbt);
					compoundnbt1.putInt("x", pos.getX());
					compoundnbt1.putInt("y", pos.getY());
					compoundnbt1.putInt("z", pos.getZ());
					if (!compoundnbt1.equals(compoundnbt2)) {
						tileentity.load(worldIn.getBlockState(pos), compoundnbt1);
						tileentity.setChanged();
						return true;
					}
				}
			}
			return false;
		}
	}

	/* getNameTextComponent に影響するためコメントアウト
	public String getTranslationKey() {
		return this.getBlock().getTranslationKey();
	}

	ItemGroup に影響するためコメントアウト
	public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
		if (this.isInGroup(group)) {
			this.getBlock().fillItemGroup(group, items);
		}
	}*/

	public Block getBlock() {
		return this.getBlockRaw() == null ? null : this.getBlockRaw().delegate.get();
	}

	private Block getBlockRaw() {
		return this.block;
	}

	public void registerBlocks(Map<Block, Item> blockToItemMap, Item itemIn) {
		blockToItemMap.put(this.getBlock(), itemIn);
	}

	public void removeFromBlockToItemMap(Map<Block, Item> blockToItemMap, Item itemIn) {
		blockToItemMap.remove(this.getBlock());
	}

	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_measurecup").withStyle(TextFormatting.GRAY));
		tooltip.add(new TranslationTextComponent("tips.block_simpledish").withStyle(TextFormatting.GRAY));
	}
}
