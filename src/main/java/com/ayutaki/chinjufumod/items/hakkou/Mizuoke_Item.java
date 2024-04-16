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
public class Mizuoke_Item extends BucketItem {

	private final Fluid containedBlock;
	private final Block block;

	@SuppressWarnings("deprecation")
	public Mizuoke_Item(Fluid containedFluidIn, Block blockIn, Item.Properties properties) {
		super(containedFluidIn, properties.group(ItemGroups_CM.TEATIME));
		this.block = blockIn;
		this.containedBlock = containedFluidIn;
	}

	/* Used in Furnace. */
	@Override
	public int getBurnTime(ItemStack stack) {
		Item item = stack.getItem();

		if (item == Items_Teatime.MIZUOKE) { return 100; }
		else { return 0; }
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

							if (cauldron >= 2) {
								playerIn.addStat(Stats.USE_CAULDRON);
								worldIn.playSound(playerIn, pos, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
								
								((CauldronBlock)block).setWaterLevel(worldIn, pos, stateIn1, cauldron - 2);
								if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MIZUOKE_full))) {
									playerIn.dropItem(new ItemStack(Items_Teatime.MIZUOKE_full), false); }

								if (!mode) { stack.shrink(1); }
								if (mode) { }
								
								return ActionResult.resultSuccess(stack); }

							if (cauldron == 1) {
								playerIn.addStat(Stats.USE_CAULDRON);
								worldIn.playSound(playerIn, pos, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
								((CauldronBlock)block).setWaterLevel(worldIn, pos, stateIn1, 0);
								
								return ActionResult.resultSuccess(stack); }
							
							return ActionResult.resultPass(stack);
						}

						/** 溶岩と水 **/
						if (stateIn1.getBlock() instanceof IBucketPickupHandler) {

							Fluid fluid = ((IBucketPickupHandler)stateIn1.getBlock()).pickupFluid(worldIn, pos, stateIn1);
							if (fluid != Fluids.EMPTY) {

								if (fluid == Fluids.LAVA) {
									worldIn.playSound(playerIn, pos, SoundEvents.ITEM_BUCKET_FILL_LAVA, SoundCategory.BLOCKS, 1.0F, 1.0F);
									worldIn.playSound(null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ENTITY_GENERIC_BURN, SoundCategory.PLAYERS, 1.0F, 1.0F);
									playerIn.addPotionEffect(new EffectInstance(Effects.INSTANT_DAMAGE, 1, 0));

									int i = pos.getX();
									int j = pos.getY();
									int k = pos.getZ();

									for(int l = 0; l < 8; ++l) {
										worldIn.addParticle(ParticleTypes.LARGE_SMOKE, (double)i + Math.random(), (double)j + Math.random(), (double)k + Math.random(), 0.0D, 0.0D, 0.0D); }

									if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.AIR))) {
										playerIn.dropItem(new ItemStack(Items.AIR), false); }

									if (!mode) { stack.shrink(1); }
									if (mode) { }
								}

								else {
									playerIn.addStat(Stats.ITEM_USED.get(this));
										worldIn.playSound(playerIn, pos, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
									if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MIZUOKE_full))) {
										playerIn.dropItem(new ItemStack(Items_Teatime.MIZUOKE_full), false); }

									if (!mode) { stack.shrink(1); }
									if (mode) { }
								}
								return ActionResult.resultSuccess(stack);
							}
						}
					}//empty


					else {
						/** 砂を塩田に変える **/
						if (stateIn1.getBlock() == Blocks.SAND && direction == Direction.UP) {
							worldIn.playSound(playerIn, pos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
							worldIn.setBlockState(pos, Crop_Blocks.ENDEN.getDefaultState().with(Enden.WET_1_9, Integer.valueOf(1)), 3);

							if (!mode) { stack.shrink(1);
								if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MIZUOKE))) {
									playerIn.dropItem(new ItemStack(Items_Teatime.MIZUOKE), false); } }
							if (mode) { }
							return ActionResult.resultSuccess(stack);
						}

						/** 大釜への注水 **/
						if (stateIn1.getBlock() == Blocks.CAULDRON) {
							int cauldron = stateIn1.get(CauldronBlock.LEVEL);

							if (cauldron != 3) {
								playerIn.addStat(Stats.FILL_CAULDRON);
								worldIn.playSound(playerIn, pos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);

								if (cauldron == 2) { ((CauldronBlock)block).setWaterLevel(worldIn, pos, stateIn1, 3); }
								else { ((CauldronBlock)block).setWaterLevel(worldIn, pos, stateIn1, cauldron + 2); }

								if (!mode) { stack.shrink(1);
									if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MIZUOKE))) {
										playerIn.dropItem(new ItemStack(Items_Teatime.MIZUOKE), false); } }
								if (mode) { }
								return ActionResult.resultSuccess(stack);
							}
							return ActionResult.resultPass(stack);
						}

						else {
							BlockState stateIn2 = worldIn.getBlockState(pos);
							BlockPos pos2 = canBlockContainFluid(worldIn, pos, stateIn2) ? pos : pos1;

							if (this.emptyBucket(playerIn, worldIn, pos2, blockResult)) {
								this.checkExtraContent(worldIn, stack, pos2);

								if (playerIn instanceof ServerPlayerEntity) {
									CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayerEntity)playerIn, pos2, stack); }

								playerIn.addStat(Stats.ITEM_USED.get(this));
								if (!mode) { stack.shrink(1);
									if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MIZUOKE))) {
										playerIn.dropItem(new ItemStack(Items_Teatime.MIZUOKE), false); } }
								if (mode) { }

								return ActionResult.resultSuccess(stack); }

							else { return ActionResult.resultPass(stack); }
						}
					}//water

				}
			}//!sneaking

			return ActionResult.resultPass(stack);
		}
	}

	public void checkExtraContent(World worldIn, ItemStack stack, BlockPos pos) { }

	private boolean canBlockContainFluid(World worldIn, BlockPos pos, BlockState stateIn) {
		return stateIn.getBlock() instanceof ILiquidContainer && ((ILiquidContainer)stateIn.getBlock()).canContainFluid(worldIn, pos, stateIn, this.containedBlock);
	}

	@SuppressWarnings("deprecation")
	public boolean emptyBucket(@Nullable PlayerEntity playerIn, World worldIn, BlockPos pos, @Nullable BlockRayTraceResult result) {
		if (!(this.containedBlock instanceof FlowingFluid)) {
			return false;
		}

		else {
			BlockState stateIn = worldIn.getBlockState(pos);
			Material material = stateIn.getMaterial();
			boolean flag = stateIn.isReplaceable(this.containedBlock);
			boolean canContainFluid = canBlockContainFluid(worldIn, pos, stateIn);

			if (stateIn.isAir() || flag || canContainFluid) {

				/** in Nether **/
				if (worldIn.dimension.doesWaterVaporize() && this.containedBlock.isIn(FluidTags.WATER)) {
					int i = pos.getX();
					int j = pos.getY();
					int k = pos.getZ();
					worldIn.playSound(playerIn, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5F, 2.6F + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.8F);

					for(int l = 0; l < 8; ++l) {
						worldIn.addParticle(ParticleTypes.LARGE_SMOKE, (double)i + Math.random(), (double)j + Math.random(), (double)k + Math.random(), 0.0D, 0.0D, 0.0D);
					}
				}

				/** WATERLOGGED **/
				else if (canContainFluid) {
					if (((ILiquidContainer)stateIn.getBlock()).receiveFluid(worldIn, pos, stateIn, ((FlowingFluid)this.containedBlock).getStillFluidState(false))) {
						worldIn.playSound(playerIn, pos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
					}
				}

				else {
					if (!worldIn.isRemote && flag && !material.isLiquid()) { worldIn.destroyBlock(pos, true); }

					worldIn.playSound(playerIn, pos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
					worldIn.setBlockState(pos, this.containedBlock.getDefaultState().getBlockState(), 11);
				}
				return true;
			}

			else {
				return result == null ? false : this.tryPlaceContainedLiquid(playerIn, worldIn, result.getPos().offset(result.getFace()), (BlockRayTraceResult)null);
			}
		}
	}

	/* 牛乳を汲む ShearsItem, CowEntity */
	@Override
	public boolean itemInteractionForEntity(ItemStack stack, net.minecraft.entity.player.PlayerEntity playerIn, LivingEntity entity, net.minecraft.util.Hand handIn) {

		boolean mode = playerIn.abilities.isCreativeMode;

		if (entity.world.isRemote) return false;

		if (stack.getItem() == Items_Teatime.MIZUOKE) {

			if (entity instanceof CowEntity && !mode && !entity.isChild()) {

				entity.playSound(SoundEvents.ENTITY_COW_MILK, 2.0F, 1.0F);

				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MIZUOKE_Milk))) {
					playerIn.dropItem(new ItemStack(Items_Teatime.MIZUOKE_Milk), false); }

				/* 消費を最後に回す */
				stack.shrink(1);
				return true;
			}
			return false;
		}
		return false;
	}


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
		tooltip.add(new TranslationTextComponent("tips.block_mizuoke").applyTextStyle(TextFormatting.GRAY));
		tooltip.add(new TranslationTextComponent("tips.block_simpledish").applyTextStyle(TextFormatting.GRAY));
	}
}
