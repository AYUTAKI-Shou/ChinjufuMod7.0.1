package com.ayutaki.chinjufumod.items.hakkou;

import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.crop.Enden;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BucketPickup;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;

public class Mizuoke_Item extends BucketItem {

	private final Fluid content;
	private final Block block;
	
	@SuppressWarnings("deprecation")
	public Mizuoke_Item(Fluid containedFluidIn, Block blockIn, Item.Properties properties) {
		super(containedFluidIn, properties);
		this.block = blockIn;
		this.content = containedFluidIn;
	}
	
	/* BurnTime in a Furnace */
	@Override
	public int getBurnTime(ItemStack stack, @Nullable RecipeType<?> recipeType) {
		Item item = stack.getItem();

		if (item == Items_Teatime.MIZUOKE.get()) { return 100; }
		else { return 0; }
	}
	
	/* BucketItem ...Changed the method of collecting LAVA and WATER. */
	@SuppressWarnings("deprecation")
	@Override
	public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand hand) {
		ItemStack stack = playerIn.getItemInHand(hand);
		BlockHitResult blockResult = getPlayerPOVHitResult(worldIn, playerIn, this.content == Fluids.EMPTY ? ClipContext.Fluid.SOURCE_ONLY : ClipContext.Fluid.NONE);
		InteractionResultHolder<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onBucketUse(playerIn, worldIn, stack, blockResult);

		boolean mode = playerIn.getAbilities().instabuild;

		BlockPos pos = blockResult.getBlockPos();
		Direction direction = blockResult.getDirection();
		BlockPos posDirect = pos.relative(direction);
		BlockState state = worldIn.getBlockState(pos);
		Block block = state.getBlock();

		if (ret != null) return ret;

		if (blockResult.getType() == HitResult.Type.MISS) { return InteractionResultHolder.pass(stack); }

		if (blockResult.getType() != HitResult.Type.BLOCK) { return InteractionResultHolder.pass(stack); }

		else {
			if (!playerIn.isCrouching()) {
				if (worldIn.mayInteract(playerIn, pos) && playerIn.mayUseItemAt(posDirect, direction, stack)) {

					if (this.content == Fluids.EMPTY) {
						
						/** From CAULDRON. **/
						if (block == Blocks.WATER_CAULDRON) {
							int cauldron = state.getValue(LayeredCauldronBlock.LEVEL);

							if (cauldron > 2) {
								playerIn.awardStat(Stats.USE_CAULDRON);
								worldIn.playSound(playerIn, pos, SoundEvents.BUCKET_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
								if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.MIZUOKE_full.get()))) {
									playerIn.drop(new ItemStack(Items_Teatime.MIZUOKE_full.get()), false); }

								if (!mode) { stack.shrink(1); }
								if (mode) { }
								
								worldIn.setBlock(pos, Blocks.WATER_CAULDRON.defaultBlockState()
										.setValue(LayeredCauldronBlock.LEVEL, Integer.valueOf(cauldron - 2)), 3);
								
								return InteractionResultHolder.success(stack);
							}

							if (cauldron == 2) {
								playerIn.awardStat(Stats.USE_CAULDRON);
								worldIn.playSound(playerIn, pos, SoundEvents.BUCKET_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
								if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.MIZUOKE_full.get()))) {
									playerIn.drop(new ItemStack(Items_Teatime.MIZUOKE_full.get()), false); }

								if (!mode) { stack.shrink(1); }
								if (mode) { }
								
								worldIn.setBlock(pos, Blocks.CAULDRON.defaultBlockState(), 3);
								return InteractionResultHolder.success(stack);
							}
							
							if (cauldron == 1) {
								playerIn.awardStat(Stats.USE_CAULDRON);
								worldIn.playSound(playerIn, pos, SoundEvents.BUCKET_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
								worldIn.setBlock(pos, Blocks.CAULDRON.defaultBlockState(), 3);
								return InteractionResultHolder.success(stack);
							}
							return InteractionResultHolder.pass(stack);
						}

						/** LAVA and WATER **/
						if (block instanceof BucketPickup) {
							
							if (block != Blocks.LAVA && block != Blocks.WATER) {
								if (state.getValue(BlockStateProperties.WATERLOGGED)) {
									playerIn.awardStat(Stats.ITEM_USED.get(this));
									worldIn.setBlock(pos, state.setValue(BlockStateProperties.WATERLOGGED, Boolean.valueOf(false)), 3);
									worldIn.playSound(playerIn, pos, SoundEvents.BUCKET_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
									
									if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.MIZUOKE_full.get()))) {
										playerIn.drop(new ItemStack(Items_Teatime.MIZUOKE_full.get()), false); }

									if (!mode) { stack.shrink(1); }
									if (mode) { } }
							}
							
							if (block == Blocks.LAVA || block == Blocks.WATER) {
								int liquid = state.getValue(LiquidBlock.LEVEL);
								
								if (block == Blocks.LAVA && liquid == 0) {
									worldIn.playSound(playerIn, pos, SoundEvents.BUCKET_FILL_LAVA, SoundSource.BLOCKS, 1.0F, 1.0F);
									worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.FIRE_EXTINGUISH, SoundSource.PLAYERS, 0.8F, 1.0F);
									playerIn.addEffect(new MobEffectInstance(MobEffects.HARM, 1, 0));

									int i = pos.getX();
									int j = pos.getY();
									int k = pos.getZ();

									for(int l = 0; l < 8; ++l) {
										worldIn.addParticle(ParticleTypes.LARGE_SMOKE, (double)i + Math.random(), (double)j + Math.random(), (double)k + Math.random(), 0.0D, 0.0D, 0.0D); }

									if (!playerIn.getInventory().add(new ItemStack(Items.AIR))) {
										playerIn.drop(new ItemStack(Items.AIR), false); }

									if (!mode) { stack.shrink(1); }
									if (mode) { } }

								if (block == Blocks.WATER && liquid == 0) {
									playerIn.awardStat(Stats.ITEM_USED.get(this));
									worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
									worldIn.playSound(playerIn, pos, SoundEvents.BUCKET_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
									
									if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.MIZUOKE_full.get()))) {
										playerIn.drop(new ItemStack(Items_Teatime.MIZUOKE_full.get()), false); }

									if (!mode) { stack.shrink(1); }
									if (mode) { } }
							}
							return InteractionResultHolder.success(stack);
						}
			
					}// MIZUOKE is empty.


					else {
						/** Turn SAND into ENDEN. **/
						if (block == Blocks.SAND && direction == Direction.UP) {
							worldIn.playSound(playerIn, pos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
							worldIn.setBlock(pos, Crop_Blocks.ENDEN.get().defaultBlockState().setValue(Enden.WET_1_9, Integer.valueOf(1)), 3);

							if (!mode) { stack.shrink(1);
								if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.MIZUOKE.get()))) {
									playerIn.drop(new ItemStack(Items_Teatime.MIZUOKE.get()), false); } }
							if (mode) { }
							return InteractionResultHolder.success(stack);
						}

						/** To CAULDRON. **/
						if (block == Blocks.CAULDRON) {
							playerIn.awardStat(Stats.FILL_CAULDRON);
							worldIn.playSound(playerIn, pos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);

							if (!mode) { stack.shrink(1);
							if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.MIZUOKE.get()))) {
								playerIn.drop(new ItemStack(Items_Teatime.MIZUOKE.get()), false); } }

							worldIn.setBlock(pos, Blocks.WATER_CAULDRON.defaultBlockState()
									.setValue(LayeredCauldronBlock.LEVEL, Integer.valueOf(2)), 3);
							
							return InteractionResultHolder.success(stack);
						}

						if (block == Blocks.WATER_CAULDRON) {
							int cauldron = state.getValue(LayeredCauldronBlock.LEVEL);

							if (cauldron != 3) {
								playerIn.awardStat(Stats.FILL_CAULDRON);
								worldIn.playSound(playerIn, pos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);

								if (cauldron == 2) { 
									worldIn.setBlock(pos, Blocks.WATER_CAULDRON.defaultBlockState()
										.setValue(LayeredCauldronBlock.LEVEL, Integer.valueOf(3)), 3); }
								else { 
									worldIn.setBlock(pos, Blocks.WATER_CAULDRON.defaultBlockState()
										.setValue(LayeredCauldronBlock.LEVEL, Integer.valueOf(cauldron + 2)), 3); }

								if (!mode) { stack.shrink(1);
									if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.MIZUOKE.get()))) {
										playerIn.drop(new ItemStack(Items_Teatime.MIZUOKE.get()), false); } }
								if (mode) { }
								
								return InteractionResultHolder.success(stack);
							}
							return InteractionResultHolder.pass(stack);
						}
						
						else {
							BlockState stateFluid = worldIn.getBlockState(pos);
							BlockPos posFluid = canBlockContainFluid(worldIn, pos, stateFluid) ? pos : posDirect;

							if (this.emptyContents(playerIn, worldIn, posFluid, blockResult)) {
								this.checkExtraContent(playerIn, worldIn, stack, posFluid);

								if (playerIn instanceof ServerPlayer) { CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer)playerIn, posFluid, stack); }
								playerIn.awardStat(Stats.ITEM_USED.get(this));

								if (!mode) { stack.shrink(1);
									if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.MIZUOKE.get()))) {
											playerIn.drop(new ItemStack(Items_Teatime.MIZUOKE.get()), false); } }
								if (mode) { }

								return InteractionResultHolder.success(stack);
							}
							else { return InteractionResultHolder.pass(stack); }
						}
					}//water

				}
			}//!sneaking

			return InteractionResultHolder.pass(stack);
		}
	}

	protected boolean canBlockContainFluid(Level worldIn, BlockPos pos, BlockState state) {
		return state.getBlock() instanceof LiquidBlockContainer liquid && liquid.canPlaceLiquid(null, worldIn, pos, state, this.content);
	} // fix 20.2
	
	@SuppressWarnings("deprecation")
	public boolean emptyContents(@Nullable Player playerIn, Level worldIn, BlockPos pos, @Nullable BlockHitResult blockResult, @Nullable ItemStack container) {
		if (!(this.content instanceof FlowingFluid)) { return false; }

		else {
			BlockState state = worldIn.getBlockState(pos);
			Block block = state.getBlock();
			boolean flag = state.canBeReplaced(this.content);
			boolean flag1 = state.isAir() || flag || block instanceof LiquidBlockContainer liquid && liquid.canPlaceLiquid(playerIn, worldIn, pos, state, this.content);
			java.util.Optional<net.minecraftforge.fluids.FluidStack> fluidStack = java.util.Optional.ofNullable(container).flatMap(net.minecraftforge.fluids.FluidUtil::getFluidContained);
			
			if (!flag1) {
				return blockResult != null && this.emptyContents(playerIn, worldIn, blockResult.getBlockPos().relative(blockResult.getDirection()), (BlockHitResult)null, container); } 
			
			else if (fluidStack.isPresent() && this.content.getFluidType().isVaporizedOnPlacement(worldIn, pos, fluidStack.get())) {
				this.content.getFluidType().onVaporize(playerIn, worldIn, pos, fluidStack.get());
				return true;
			}
			
			/** in Nether **/
			else if (worldIn.dimensionType().ultraWarm() && this.content.is(FluidTags.WATER)) {
				int i = pos.getX();
				int j = pos.getY();
				int k = pos.getZ();
				worldIn.playSound(playerIn, pos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 0.5F, 2.6F + (worldIn.random.nextFloat() - worldIn.random.nextFloat()) * 0.8F);

				for(int l = 0; l < 8; ++l) {
					worldIn.addParticle(ParticleTypes.LARGE_SMOKE, (double)i + Math.random(), (double)j + Math.random(), (double)k + Math.random(), 0.0D, 0.0D, 0.0D); }

				return true; } 
			
			/** WATERLOGGED **/
			else if (block instanceof LiquidBlockContainer liquid && liquid.canPlaceLiquid(playerIn, worldIn, pos, state, content)) {
				((LiquidBlockContainer)block).placeLiquid(worldIn, pos, state, ((FlowingFluid)this.content).getSource(false));
				this.playEmptySound(playerIn, worldIn, pos);
				return true; } 
			
			else {
				if (!worldIn.isClientSide && flag && !state.liquid()) { worldIn.destroyBlock(pos, true); }

				if (!worldIn.setBlock(pos, this.content.defaultFluidState().createLegacyBlock(), 11) && !state.getFluidState().isSource()) { return false; } 
				
				else { this.playEmptySound(playerIn, worldIn, pos);
					return true; }
			}
		}
	} // fix 20.2
	
	/* Get the MIZUOKE_Milk. ShearsItem, CowEntity */
	@SuppressWarnings("resource")
	@Override
	public net.minecraft.world.InteractionResult interactLivingEntity(ItemStack stack, net.minecraft.world.entity.player.Player playerIn, LivingEntity entity, net.minecraft.world.InteractionHand hand) {
		boolean mode = playerIn.getAbilities().instabuild;

		if (entity.level().isClientSide) return InteractionResult.PASS;

		if (stack.getItem() == Items_Teatime.MIZUOKE.get()) {

			if (entity instanceof Cow && !mode && !entity.isBaby()) {

				entity.playSound(SoundEvents.COW_MILK, 2.0F, 1.0F);
				if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.MIZUOKE_Milk.get()))) {
					playerIn.drop(new ItemStack(Items_Teatime.MIZUOKE_Milk.get()), false); }

				/* 消費を最後に回す */
				stack.shrink(1);
				return InteractionResult.SUCCESS; }

			if (entity instanceof Goat && !mode && !entity.isBaby()) {

				entity.playSound(SoundEvents.GOAT_MILK, 2.0F, 1.0F);
				if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.MIZUOKE_Milk.get()))) {
					playerIn.drop(new ItemStack(Items_Teatime.MIZUOKE_Milk.get()), false); }

				stack.shrink(1);
				return InteractionResult.SUCCESS; }
			
			return InteractionResult.PASS;
		}
		return InteractionResult.PASS;
	}
	
	
	//////* BlockItem *///////////////////////////////////////////////
	/* Branch the process. */
	@Override
	 public InteractionResult useOn(UseOnContext context) {
		Player playerIn = context.getPlayer();

		if (context.getClickedFace() == Direction.UP && (playerIn.isCrouching() || playerIn.isPassenger())) {
			return this.place(new BlockPlaceContext(context)); }

		else {
			return this.use(context.getLevel(), context.getPlayer(), context.getHand()).getResult(); }
	 }
	 
	public InteractionResult place(BlockPlaceContext context) {
		if (!context.canPlace()) { return InteractionResult.FAIL; } 
		
		else {
			BlockPlaceContext blockplacecontext = this.updatePlacementContext(context);
			if (blockplacecontext == null) { return InteractionResult.FAIL; } 
			
			else {
				BlockState state = this.getPlacementState(blockplacecontext);
				if (state == null) { return InteractionResult.FAIL; } 
				
				else if (!this.placeBlock(blockplacecontext, state)) { return InteractionResult.FAIL; } 
				
				else {
					BlockPos pos = blockplacecontext.getClickedPos();
					Level worldIn = blockplacecontext.getLevel();
					Player playerIn = blockplacecontext.getPlayer();
					ItemStack stack = blockplacecontext.getItemInHand();
					BlockState state1 = worldIn.getBlockState(pos);
					if (state1.is(state.getBlock())) {
						state1 = this.updateBlockStateFromTag(pos, worldIn, stack, state1);
						this.updateCustomBlockEntityTag(pos, worldIn, playerIn, stack, state1);
						state1.getBlock().setPlacedBy(worldIn, pos, state1, playerIn, stack);
						if (playerIn instanceof ServerPlayer) {
							CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer)playerIn, pos, stack);
						}
					}

					worldIn.gameEvent(playerIn, GameEvent.BLOCK_PLACE, pos);
					SoundType soundtype = state1.getSoundType(worldIn, pos, context.getPlayer());
					worldIn.playSound(playerIn, pos, this.getPlaceSound(state1, worldIn, pos, context.getPlayer()), SoundSource.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
					if (playerIn == null || !playerIn.getAbilities().instabuild) {
						stack.shrink(1);
					}

					return InteractionResult.sidedSuccess(worldIn.isClientSide);
				}
			}
		}
	}
	
	protected SoundEvent getPlaceSound(BlockState state, Level world, BlockPos pos, Player entity) {
		return state.getSoundType(world, pos, entity).getPlaceSound();
	}

	@Nullable
	public BlockPlaceContext updatePlacementContext(BlockPlaceContext context) {
		return context;
	}

	protected boolean updateCustomBlockEntityTag(BlockPos pos, Level worldIn, @Nullable Player playerIn, ItemStack stack, BlockState state) {
		return updateCustomBlockEntityTag(worldIn, playerIn, pos, stack);
	}

	@Nullable
	protected BlockState getPlacementState(BlockPlaceContext context) {
		BlockState state = this.getBlock().getStateForPlacement(context);
		return state != null && this.canPlace(context, state) ? state : null;
	}

	private BlockState updateBlockStateFromTag(BlockPos pos, Level worldIn, ItemStack stack, BlockState state) {
		BlockState state1 = state;
		CompoundTag compoundtag = stack.getTag();
		if (compoundtag != null) {
			CompoundTag compoundtag1 = compoundtag.getCompound("BlockStateTag");
			StateDefinition<Block, BlockState> statedefinition = state.getBlock().getStateDefinition();

			for(String s : compoundtag1.getAllKeys()) {
				Property<?> property = statedefinition.getProperty(s);
				if (property != null) {
					String s1 = compoundtag1.get(s).getAsString();
					state1 = updateState(state1, property, s1);
				}
			}
		}

		if (state1 != state) { worldIn.setBlock(pos, state1, 2); }

		return state1;
	}

	private static <T extends Comparable<T>> BlockState updateState(BlockState state, Property<T> propertyIn, String string) {
		return propertyIn.getValue(string).map((p_40592_) -> {
			return state.setValue(propertyIn, p_40592_); } ).orElse(state);
	}

	protected boolean canPlace(BlockPlaceContext context, BlockState state) {
		Player playerIn = context.getPlayer();
		CollisionContext collisioncontext = playerIn == null ? CollisionContext.empty() : CollisionContext.of(playerIn);
		return (!this.mustSurvive() || state.canSurvive(context.getLevel(), context.getClickedPos())) && context.getLevel().isUnobstructed(state, context.getClickedPos(), collisioncontext);
	}

	protected boolean mustSurvive() {
		return true;
	}

	protected boolean placeBlock(BlockPlaceContext context, BlockState state) {
		return context.getLevel().setBlock(context.getClickedPos(), state, 11);
	}

	public static boolean updateCustomBlockEntityTag(Level worldIn, @Nullable Player playerIn, BlockPos pos, ItemStack stack) {
		MinecraftServer minecraftserver = worldIn.getServer();
		if (minecraftserver == null) { return false; } 
		
		else {
			CompoundTag compoundtag = getBlockEntityData(stack);
			if (compoundtag != null) {
				BlockEntity blockentity = worldIn.getBlockEntity(pos);
				if (blockentity != null) {
					if (!worldIn.isClientSide && blockentity.onlyOpCanSetNbt() && (playerIn == null || !playerIn.canUseGameMasterBlocks())) {
						return false; }

					CompoundTag compoundtag1 = blockentity.saveWithoutMetadata();
					CompoundTag compoundtag2 = compoundtag1.copy();
					compoundtag1.merge(compoundtag);
					if (!compoundtag1.equals(compoundtag2)) {
						blockentity.load(compoundtag1);
						blockentity.setChanged();
						return true;
					}
				}
			}
			return false;
		}
	}

	/* getNameTextComponent に影響するためコメントアウト
	public String getDescriptionId() {
		return this.getBlock().getDescriptionId();
	}

	ItemGroup に影響するためコメントアウト
	public void fillItemCategory(CreativeModeTab tab, NonNullList<ItemStack> stack) {
		if (this.allowdedIn(tab)) {
			this.getBlock().fillItemCategory(tab, stack);
		}
	}*/

	public Block getBlock() {
		return this.getBlockRaw() == null ? null : net.minecraftforge.registries.ForgeRegistries.BLOCKS.getDelegateOrThrow(this.getBlockRaw()).get();
	}

	private Block getBlockRaw() {
		return this.block;
	}

	public void registerBlocks(Map<Block, Item> blockItem, Item itemIn) {
		blockItem.put(this.getBlock(), itemIn);
	}

	public void removeFromBlockToItemMap(Map<Block, Item> blockToItemMap, Item itemIn) {
		blockToItemMap.remove(this.getBlock());
	}

	 @Nullable
	 public static CompoundTag getBlockEntityData(ItemStack stack) {
			return stack.getTagElement("BlockEntityTag");
	 }

	/* ToolTip */
	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag tipFlag) {
		tooltip.add(Component.translatable("tips.block_mizuoke").withStyle(ChatFormatting.GRAY));
		tooltip.add(Component.translatable("tips.block_simpledish").withStyle(ChatFormatting.GRAY));
	}
}
