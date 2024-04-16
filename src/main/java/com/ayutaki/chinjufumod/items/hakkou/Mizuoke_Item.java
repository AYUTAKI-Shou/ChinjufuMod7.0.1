package com.ayutaki.chinjufumod.items.hakkou;

import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ItemGroups_CM;
import com.ayutaki.chinjufumod.blocks.crop.Enden;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CauldronBlock;
import net.minecraft.block.IBucketPickupHandler;
import net.minecraft.block.ILiquidContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
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
public class Mizuoke_Item extends BucketItem {

	private final Fluid content;
	private final Block block;

	@SuppressWarnings("deprecation")
	public Mizuoke_Item(Fluid containedFluidIn, Block blockIn, Item.Properties properties) {
		super(containedFluidIn, properties.tab(ItemGroups_CM.TEATIME));
		this.block = blockIn;
		this.content = containedFluidIn;
	}

	/* BurnTime in a Furnace */
	@Override
	public int getBurnTime(ItemStack stackIn) {
		Item item = stackIn.getItem();

		if (item == Items_Teatime.MIZUOKE) { return 100; }
		else { return 0; }
	}

	/* 水を入れる BucketItem */
	@Override
	public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack stackIn = playerIn.getItemInHand(handIn);
		RayTraceResult raytraceresult = getPlayerPOVHitResult(worldIn, playerIn, this.content == Fluids.EMPTY ? RayTraceContext.FluidMode.SOURCE_ONLY : RayTraceContext.FluidMode.NONE);
		ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onBucketUse(playerIn, worldIn, stackIn, raytraceresult);

		boolean mode = playerIn.abilities.instabuild;

		BlockRayTraceResult blockResult = (BlockRayTraceResult)raytraceresult;
		BlockPos pos = blockResult.getBlockPos();
		Direction direction = blockResult.getDirection();
		BlockPos pos1 = pos.relative(direction);
		BlockState stateIn1 = worldIn.getBlockState(pos);
		Block block = stateIn1.getBlock();

		if (ret != null) return ret;

		if (raytraceresult.getType() == RayTraceResult.Type.MISS) { return ActionResult.pass(stackIn); }

		if (raytraceresult.getType() != RayTraceResult.Type.BLOCK) { return ActionResult.pass(stackIn); }

		else {
			if (!playerIn.isCrouching()) {
				if (worldIn.mayInteract(playerIn, pos) && playerIn.mayUseItemAt(pos1, direction, stackIn)) {

					if (this.content == Fluids.EMPTY) {
						/** 大釜からの給水 **/
						if (stateIn1.getBlock() == Blocks.CAULDRON) {
							int cauldron = stateIn1.getValue(CauldronBlock.LEVEL);

							if (cauldron >= 2) {
								playerIn.awardStat(Stats.USE_CAULDRON);
								worldIn.playSound(playerIn, pos, SoundEvents.BUCKET_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
								
								((CauldronBlock)block).setWaterLevel(worldIn, pos, stateIn1, cauldron - 2);
								if (!playerIn.inventory.add(new ItemStack(Items_Teatime.MIZUOKE_full))) {
									playerIn.drop(new ItemStack(Items_Teatime.MIZUOKE_full), false); }

								if (!mode) { stackIn.shrink(1); }
								if (mode) { }
								
								return ActionResult.success(stackIn); }

							if (cauldron == 1) {
								playerIn.awardStat(Stats.USE_CAULDRON);
								worldIn.playSound(playerIn, pos, SoundEvents.BUCKET_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
								((CauldronBlock)block).setWaterLevel(worldIn, pos, stateIn1, 0);
								
								return ActionResult.success(stackIn); }
							
							return ActionResult.pass(stackIn);
						}

						/** 溶岩と水 **/
						if (stateIn1.getBlock() instanceof IBucketPickupHandler) {

							Fluid fluid = ((IBucketPickupHandler)stateIn1.getBlock()).takeLiquid(worldIn, pos, stateIn1);
							if (fluid != Fluids.EMPTY) {

								if (fluid == Fluids.LAVA) {
									worldIn.playSound(playerIn, pos, SoundEvents.BUCKET_FILL_LAVA, SoundCategory.BLOCKS, 1.0F, 1.0F);
									worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.FIRE_EXTINGUISH, SoundCategory.PLAYERS, 0.8F, 1.0F);
									playerIn.addEffect(new EffectInstance(Effects.HARM, 1, 0));

									int i = pos.getX();
									int j = pos.getY();
									int k = pos.getZ();

									for(int l = 0; l < 8; ++l) {
										worldIn.addParticle(ParticleTypes.LARGE_SMOKE, (double)i + Math.random(), (double)j + Math.random(), (double)k + Math.random(), 0.0D, 0.0D, 0.0D); }

									if (!playerIn.inventory.add(new ItemStack(Items.AIR))) {
										playerIn.drop(new ItemStack(Items.AIR), false); }

									if (!mode) { stackIn.shrink(1); }
									if (mode) { }
								}

								else {
									playerIn.awardStat(Stats.ITEM_USED.get(this));
									worldIn.playSound(playerIn, pos, SoundEvents.BUCKET_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
									if (!playerIn.inventory.add(new ItemStack(Items_Teatime.MIZUOKE_full))) {
										playerIn.drop(new ItemStack(Items_Teatime.MIZUOKE_full), false); }

									if (!mode) { stackIn.shrink(1); }
									if (mode) { }
								}
								return ActionResult.success(stackIn);
							}
						}
					}//empty


					else {
						/** 砂を塩田に変える **/
						if (stateIn1.getBlock() == Blocks.SAND && direction == Direction.UP) {
							worldIn.playSound(playerIn, pos, SoundEvents.BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
							worldIn.setBlock(pos, Crop_Blocks.ENDEN.defaultBlockState().setValue(Enden.WET_1_9, Integer.valueOf(1)), 3);

							if (!mode) { stackIn.shrink(1);
								if (!playerIn.inventory.add(new ItemStack(Items_Teatime.MIZUOKE))) {
									playerIn.drop(new ItemStack(Items_Teatime.MIZUOKE), false); } }
							if (mode) { }
							return ActionResult.success(stackIn);
						}

						/** 大釜への注水 **/
						if (stateIn1.getBlock() == Blocks.CAULDRON) {
							int cauldron = stateIn1.getValue(CauldronBlock.LEVEL);

							if (cauldron != 3) {
								playerIn.awardStat(Stats.FILL_CAULDRON);
								worldIn.playSound(playerIn, pos, SoundEvents.BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);

								if (cauldron == 2) { ((CauldronBlock)block).setWaterLevel(worldIn, pos, stateIn1, 3); }
								else { ((CauldronBlock)block).setWaterLevel(worldIn, pos, stateIn1, cauldron + 2); }

								if (!mode) { stackIn.shrink(1);
									if (!playerIn.inventory.add(new ItemStack(Items_Teatime.MIZUOKE))) {
										playerIn.drop(new ItemStack(Items_Teatime.MIZUOKE), false); } }
								if (mode) { }
								return ActionResult.success(stackIn);
							}
							return ActionResult.pass(stackIn);
						}

						else {
							BlockState stateIn2 = worldIn.getBlockState(pos);
							BlockPos pos2 = canBlockContainFluid(worldIn, pos, stateIn2) ? pos : pos1;

							if (this.placeWater(playerIn, worldIn, pos2, blockResult)) {
								this.checkExtraContent(worldIn, stackIn, pos2);

								if (playerIn instanceof ServerPlayerEntity) { CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayerEntity)playerIn, pos2, stackIn); }
								playerIn.awardStat(Stats.ITEM_USED.get(this));

								if (!mode) { stackIn.shrink(1);
									if (!playerIn.inventory.add(new ItemStack(Items_Teatime.MIZUOKE))) {
											playerIn.drop(new ItemStack(Items_Teatime.MIZUOKE), false); } }
								if (mode) { }

								return ActionResult.success(stackIn);
							}
							else { return ActionResult.pass(stackIn); }
						}
					}//water

				}
			}//!sneaking

			return ActionResult.pass(stackIn);
		}
	}

	@Override
	public void checkExtraContent(World worldIn, ItemStack stackIn, BlockPos pos) { }

	private boolean canBlockContainFluid(World worldIn, BlockPos pos, BlockState stateIn) {
		return stateIn.getBlock() instanceof ILiquidContainer && ((ILiquidContainer)stateIn.getBlock()).canPlaceLiquid(worldIn, pos, stateIn, this.content);
	}

	public boolean placeWater(@Nullable PlayerEntity playerIn, World worldIn, BlockPos pos, @Nullable BlockRayTraceResult result) {
		if (!(this.content instanceof FlowingFluid)) {
			return false;
		}
		else {
			BlockState stateIn = worldIn.getBlockState(pos);
			Block block = stateIn.getBlock();
			Material material = stateIn.getMaterial();
			boolean flag = stateIn.canBeReplaced(this.content);
			@SuppressWarnings("deprecation")
			boolean flag1 = stateIn.isAir() || flag || block instanceof ILiquidContainer && ((ILiquidContainer)block).canPlaceLiquid(worldIn, pos, stateIn, this.content);

			if (!flag1) {
				return result != null && this.placeWater(playerIn, worldIn, result.getBlockPos().relative(result.getDirection()), (BlockRayTraceResult)null);
			}

			/** in Nether **/
			else if (worldIn.dimensionType().ultraWarm() && this.content.is(FluidTags.WATER)) {
				int i = pos.getX();
				int j = pos.getY();
				int k = pos.getZ();
				worldIn.playSound(playerIn, pos, SoundEvents.FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5F, 2.6F + (worldIn.random.nextFloat() - worldIn.random.nextFloat()) * 0.8F);

				for(int l = 0; l < 8; ++l) {
					worldIn.addParticle(ParticleTypes.LARGE_SMOKE, (double)i + Math.random(), (double)j + Math.random(), (double)k + Math.random(), 0.0D, 0.0D, 0.0D);
				}
				return true;
			}

			/** WATERLOGGED **/
			else if (block instanceof ILiquidContainer && ((ILiquidContainer)block).canPlaceLiquid(worldIn, pos, stateIn,content)) {
				((ILiquidContainer)block).placeLiquid(worldIn, pos, stateIn, ((FlowingFluid)this.content).getSource(false));
				worldIn.playSound(playerIn, pos, SoundEvents.BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
				return true;
			}

			else {
				if (!worldIn.isClientSide && flag && !material.isLiquid()) { worldIn.destroyBlock(pos, true); }

				if (!worldIn.setBlock(pos, this.content.defaultFluidState().createLegacyBlock(), 11) && !stateIn.getFluidState().isSource()) { return false; }

				else { worldIn.playSound(playerIn, pos, SoundEvents.BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
					return true; }
			}
		}
	}

	/* Get the MIZUOKE_Milk. ShearsItem, CowEntity */
	@Override
	public net.minecraft.util.ActionResultType interactLivingEntity(ItemStack stackIn, net.minecraft.entity.player.PlayerEntity playerIn, LivingEntity entity, net.minecraft.util.Hand handIn) {

		boolean mode = playerIn.abilities.instabuild;

		if (entity.level.isClientSide) return net.minecraft.util.ActionResultType.PASS;

		if (stackIn.getItem() == Items_Teatime.MIZUOKE) {

			if (entity instanceof CowEntity && !mode && !entity.isBaby()) {

				entity.playSound(SoundEvents.COW_MILK, 2.0F, 1.0F);
				if (!playerIn.inventory.add(new ItemStack(Items_Teatime.MIZUOKE_Milk))) {
					playerIn.drop(new ItemStack(Items_Teatime.MIZUOKE_Milk), false); }

				/* 消費を最後に回す */
				stackIn.shrink(1);
				return net.minecraft.util.ActionResultType.SUCCESS;
			}

			return net.minecraft.util.ActionResultType.PASS;
		}
		return net.minecraft.util.ActionResultType.PASS;
	}



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
					ItemStack stackIn = blockcontext.getItemInHand();
					BlockState stateIn1 = worldIn.getBlockState(pos1);
					Block block = stateIn1.getBlock();
					if (block == stateIn.getBlock()) {
						stateIn1 = this.updateBlockStateFromTag(pos1, worldIn, stackIn, stateIn1);
						this.updateCustomBlockEntityTag(pos1, worldIn, playerIn, stackIn, stateIn1);
						block.setPlacedBy(worldIn, pos1, stateIn1, playerIn, stackIn);
						if (playerIn instanceof ServerPlayerEntity) {
							CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayerEntity)playerIn, pos1, stackIn);
						}
					}

					SoundType soundtype = stateIn1.getSoundType(worldIn, pos1, context.getPlayer());
					worldIn.playSound(playerIn, pos1, this.getPlaceSound(stateIn1, worldIn, pos1, context.getPlayer()), SoundCategory.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);

					if (playerIn == null || !playerIn.abilities.instabuild) { stackIn.shrink(1); }

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

	public static boolean updateCustomBlockEntityTag(World worldIn, @Nullable PlayerEntity playerIn, BlockPos pos, ItemStack stackIn) {
		MinecraftServer minecraftserver = worldIn.getServer();
		if (minecraftserver == null) {
			return false;
		}

		else {
			CompoundNBT compoundnbt = stackIn.getTagElement("BlockEntityTag");
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
		tooltip.add(new TranslationTextComponent("tips.block_mizuoke").withStyle(TextFormatting.GRAY));
		tooltip.add(new TranslationTextComponent("tips.block_simpledish").withStyle(TextFormatting.GRAY));
	}
}
