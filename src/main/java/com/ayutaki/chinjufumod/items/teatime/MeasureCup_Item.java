package com.ayutaki.chinjufumod.items.teatime;

import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;

public class MeasureCup_Item extends BucketItem {

	private final Fluid content;
	private final Block block;
	
	@SuppressWarnings("deprecation")
	public MeasureCup_Item(Fluid containedFluidIn, Block blockIn, Item.Properties properties) {
		super(containedFluidIn, properties);
		this.block = blockIn;
		this.content = containedFluidIn;
	}
	
	/* BucketItem ...Changed the method of collecting LAVA and WATER. */
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

							if (cauldron > 1) {
								playerIn.awardStat(Stats.USE_CAULDRON);
								worldIn.playSound(playerIn, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
								if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.KEIRYO_CUP_full.get()))) {
									playerIn.drop(new ItemStack(Items_Teatime.KEIRYO_CUP_full.get()), false); }

								if (!mode) { stack.shrink(1); }
								if (mode) { }
								
								worldIn.setBlock(pos, Blocks.WATER_CAULDRON.defaultBlockState()
										.setValue(LayeredCauldronBlock.LEVEL, Integer.valueOf(cauldron - 1)), 3);
								return InteractionResultHolder.success(stack);
							}

							if (cauldron == 1) {
								playerIn.awardStat(Stats.USE_CAULDRON);
								worldIn.playSound(playerIn, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
								if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.KEIRYO_CUP_full.get()))) {
									playerIn.drop(new ItemStack(Items_Teatime.KEIRYO_CUP_full.get()), false); }

								if (!mode) { stack.shrink(1); }
								if (mode) { }
								
								worldIn.setBlock(pos, Blocks.CAULDRON.defaultBlockState(), 3);
								return InteractionResultHolder.success(stack);
							}
							return InteractionResultHolder.pass(stack);
						}

						/** WATER **/
						if (worldIn.getFluidState(pos).is(FluidTags.WATER)) {
							worldIn.playSound(playerIn, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
							if (!playerIn.getInventory().add(new ItemStack(Items_Teatime.KEIRYO_CUP_full.get()))) {
								playerIn.drop(new ItemStack(Items_Teatime.KEIRYO_CUP_full.get()), false); }

							if (!mode) { stack.shrink(1); }
							if (mode) { }
							
							return InteractionResultHolder.success(stack);
						}
						
						return InteractionResultHolder.pass(stack);
					}// MIZUOKE is empty.

				}
			}//!sneaking

			return InteractionResultHolder.pass(stack);
		}
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
		tooltip.add(Component.translatable("tips.block_measurecup").withStyle(ChatFormatting.GRAY));
		tooltip.add(Component.translatable("tips.block_simpledish").withStyle(ChatFormatting.GRAY));
	}
}
