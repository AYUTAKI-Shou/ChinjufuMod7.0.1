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
import net.minecraft.state.IProperty;
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

	private final Fluid containedBlock;
	private final Block block;

	@SuppressWarnings("deprecation")
	public MeasureCup_Item(Fluid containedFluidIn, Block blockIn, Item.Properties properties) {
		super(containedFluidIn, properties.group(ItemGroups_CM.TEATIME));
		this.block = blockIn;
		this.containedBlock = containedFluidIn;
	}

	/* 水を入れる BucketItem */
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack stack = playerIn.getHeldItem(handIn);
		RayTraceResult raytraceresult = rayTrace(worldIn, playerIn, this.containedBlock == Fluids.EMPTY ? RayTraceContext.FluidMode.SOURCE_ONLY : RayTraceContext.FluidMode.NONE);
		ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onBucketUse(playerIn, worldIn, stack, raytraceresult);

		boolean mode = playerIn.abilities.isCreativeMode;

		BlockRayTraceResult blockResult = (BlockRayTraceResult)raytraceresult;
		BlockPos pos = blockResult.getPos();
		Direction direction = blockResult.getFace();
		BlockPos pos1 = pos.offset(direction);
		BlockState stateIn1 = worldIn.getBlockState(pos);
		Block block = stateIn1.getBlock();

		if (ret != null) return ret;

		if (raytraceresult.getType() == RayTraceResult.Type.MISS) { return ActionResult.resultPass(stack); }

		if (raytraceresult.getType() != RayTraceResult.Type.BLOCK) { return ActionResult.resultPass(stack); }

		else {
			if (!playerIn.isSneaking()) {
				if (worldIn.isBlockModifiable(playerIn, pos) && playerIn.canPlayerEdit(pos1, direction, stack)) {

					if (this.containedBlock == Fluids.EMPTY) {
						/** 大釜からの給水 **/
						if (stateIn1.getBlock() == Blocks.CAULDRON) {
							int cauldron = stateIn1.get(CauldronBlock.LEVEL);

							if (cauldron == 0) { return ActionResult.resultPass(stack); }
							
							else {
								playerIn.addStat(Stats.USE_CAULDRON);
								worldIn.playSound(playerIn, pos, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
								
								((CauldronBlock)block).setWaterLevel(worldIn, pos, stateIn1, cauldron - 1);
								if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.KEIRYO_CUP_full))) {
									playerIn.dropItem(new ItemStack(Items_Teatime.KEIRYO_CUP_full), false); }

								if (!mode) { stack.shrink(1); }
								if (mode) { }
								
								return ActionResult.resultSuccess(stack); }
						}

						/** 水ブロック **/
						if (worldIn.getFluidState(pos).isTagged(FluidTags.WATER)) {
							
							playerIn.addStat(Stats.ITEM_USED.get(this));
							worldIn.playSound(playerIn, pos, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
							if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.KEIRYO_CUP_full))) {
								playerIn.dropItem(new ItemStack(Items_Teatime.KEIRYO_CUP_full), false); }
	
							if (!mode) { stack.shrink(1); }
							if (mode) { }

							return ActionResult.resultSuccess(stack);
						}
						return ActionResult.resultPass(stack);
					}//empty

				}
			}//!sneaking
			return ActionResult.resultPass(stack);
		}
	}

	public void checkExtraContent(World worldIn, ItemStack stack, BlockPos pos) { }

	//////* BlockItem *///////////////////////////////////////////////
	/** 設置処理の分岐 **/
	public ActionResultType onItemUse(ItemUseContext context) {
		PlayerEntity playerIn = context.getPlayer();

		if (context.getFace() == Direction.UP && playerIn.isSneaking()) {
			return this.tryPlace(new BlockItemUseContext(context)); }

		else {
			return this.onItemRightClick(context.getWorld(), context.getPlayer(), context.getHand()).getType(); }
	}

	public ActionResultType tryPlace(BlockItemUseContext context) {

		if (!context.canPlace()) { return ActionResultType.FAIL; }

		else {
			BlockItemUseContext blockitemusecontext = this.getBlockItemUseContext(context);

			if (blockitemusecontext == null) { return ActionResultType.FAIL; }

			else {
				BlockState stateIn = this.getStateForPlacement(blockitemusecontext);

				if (stateIn == null) { return ActionResultType.FAIL; }

				else if (!this.placeBlock(blockitemusecontext, stateIn)) { return ActionResultType.FAIL; }

				else {
					BlockPos pos = blockitemusecontext.getPos();
					World world = blockitemusecontext.getWorld();
					PlayerEntity playerIn = blockitemusecontext.getPlayer();
					ItemStack stack = blockitemusecontext.getItem();
					BlockState stateIn1 = world.getBlockState(pos);
					Block block = stateIn1.getBlock();
					if (block == stateIn.getBlock()) {
						stateIn1 = this.getBlockStateTag(pos, world, stack, stateIn1);
						this.onBlockPlaced(pos, world, playerIn, stack, stateIn1);
						block.onBlockPlacedBy(world, pos, stateIn1, playerIn, stack);
						if (playerIn instanceof ServerPlayerEntity) {
							CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayerEntity)playerIn, pos, stack);
						}
					}

					SoundType soundtype = stateIn1.getSoundType(world, pos, context.getPlayer());
					world.playSound(playerIn, pos, this.getPlaceSound(stateIn1, world, pos, context.getPlayer()), SoundCategory.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
					stack.shrink(1);
					return ActionResultType.SUCCESS;
				}
			}
		}
	}

	@Deprecated //Forge: Use more sensitive version {@link BlockItem#getPlaceSound(BlockState, IBlockReader, BlockPos, Entity) }
	protected SoundEvent getPlaceSound(BlockState state) {
		return state.getSoundType().getPlaceSound();
	}

	protected SoundEvent getPlaceSound(BlockState state, World world, BlockPos pos, PlayerEntity entity) {
		return state.getSoundType(world, pos, entity).getPlaceSound();
	}

	@Nullable
	public BlockItemUseContext getBlockItemUseContext(BlockItemUseContext context) {
		return context;
	}

	protected boolean onBlockPlaced(BlockPos pos, World worldIn, @Nullable PlayerEntity playerIn, ItemStack stack, BlockState state) {
		return setTileEntityNBT(worldIn, playerIn, pos, stack);
	}

	@Nullable
	protected BlockState getStateForPlacement(BlockItemUseContext context) {
		BlockState stateIn = this.getBlock().getStateForPlacement(context);
		return stateIn != null && this.canPlace(context, stateIn) ? stateIn : null;
	}

	private BlockState getBlockStateTag(BlockPos pos, World worldIn, ItemStack stack, BlockState state) {
		BlockState stateIn = state;
		CompoundNBT compoundnbt = stack.getTag();
		if (compoundnbt != null) {
			CompoundNBT compoundnbt1 = compoundnbt.getCompound("BlockStateTag");
			StateContainer<Block, BlockState> statecontainer = state.getBlock().getStateContainer();

			for(String s : compoundnbt1.keySet()) {
				IProperty<?> iproperty = statecontainer.getProperty(s);
				if (iproperty != null) {
					String s1 = compoundnbt1.get(s).getString();
					stateIn = comBlockState(stateIn, iproperty, s1);
				}
			}
		}

		if (stateIn != state) {
			worldIn.setBlockState(pos, stateIn, 2);
		}

		return stateIn;
	}

	private static <T extends Comparable<T>> BlockState comBlockState(BlockState state, IProperty<T> property, String string) {
		return property.parseValue(string).map((mapper) -> {
			return state.with(property, mapper);
		}).orElse(state);
	}

	protected boolean canPlace(BlockItemUseContext context, BlockState state) {
		PlayerEntity playerIn = context.getPlayer();
		ISelectionContext iselectioncontext = playerIn == null ? ISelectionContext.dummy() : ISelectionContext.forEntity(playerIn);
		return (!this.checkPosition() || state.isValidPosition(context.getWorld(), context.getPos())) && context.getWorld().func_226663_a_(state, context.getPos(), iselectioncontext);
	}

	protected boolean checkPosition() {
		return true;
	}

	protected boolean placeBlock(BlockItemUseContext context, BlockState state) {
		return context.getWorld().setBlockState(context.getPos(), state, 11);
	}

	public static boolean setTileEntityNBT(World worldIn, @Nullable PlayerEntity playerIn, BlockPos pos, ItemStack stack) {
		MinecraftServer minecraftserver = worldIn.getServer();
		if (minecraftserver == null) {
			return false;
		}

		else {
			CompoundNBT compoundnbt = stack.getChildTag("BlockEntityTag");
			if (compoundnbt != null) {
				TileEntity tileentity = worldIn.getTileEntity(pos);
				if (tileentity != null) {
					if (!worldIn.isRemote && tileentity.onlyOpsCanSetNbt() && (playerIn == null || !playerIn.canUseCommandBlock())) {
						return false;
					}

					CompoundNBT compoundnbt1 = tileentity.write(new CompoundNBT());
					CompoundNBT compoundnbt2 = compoundnbt1.copy();
					compoundnbt1.merge(compoundnbt);
					compoundnbt1.putInt("x", pos.getX());
					compoundnbt1.putInt("y", pos.getY());
					compoundnbt1.putInt("z", pos.getZ());
					if (!compoundnbt1.equals(compoundnbt2)) {
						tileentity.read(compoundnbt1);
						tileentity.markDirty();
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

	public void addToBlockToItemMap(Map<Block, Item> blockToItemMap, Item itemIn) {
		blockToItemMap.put(this.getBlock(), itemIn);
	}

	public void removeFromBlockToItemMap(Map<Block, Item> blockToItemMap, Item itemIn) {
		blockToItemMap.remove(this.getBlock());
	}

	/* ToolTip*/
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		tooltip.add(new TranslationTextComponent("tips.block_measurecup").applyTextStyle(TextFormatting.GRAY));
		tooltip.add(new TranslationTextComponent("tips.block_simpledish").applyTextStyle(TextFormatting.GRAY));
	}
}
