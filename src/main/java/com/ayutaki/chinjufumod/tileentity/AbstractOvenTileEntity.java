package com.ayutaki.chinjufumod.tileentity;

import java.util.Map;

import javax.annotation.Nullable;

import com.google.common.collect.Maps;

import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.RecipeItemHelper;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SharedConstants;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public abstract class AbstractOvenTileEntity extends AbstractFurnaceTileEntity {

	private static final int[] SLOTS_FOR_UP = new int[]{0};
	private static final int[] SLOTS_FOR_DOWN = new int[]{2, 1};
	private static final int[] SLOTS_FOR_SIDES = new int[]{1};
	protected NonNullList<ItemStack> items = NonNullList.withSize(3, ItemStack.EMPTY);
	private int litTime;
	private int litDuration;
	private int cookingProgress;
	private int cookingTotalTime;
	protected final IIntArray dataAccess = new IIntArray() {
		public int get(int index) {
			switch (index) {
			case 0:
				return AbstractOvenTileEntity.this.litTime;
			case 1:
				return AbstractOvenTileEntity.this.litDuration;
			case 2:
				return AbstractOvenTileEntity.this.cookingProgress;
			case 3:
				return AbstractOvenTileEntity.this.cookingTotalTime;
			default:
				return 0;
			}
		}

		public void set(int index, int value) {
			switch (index) {
			case 0:
				AbstractOvenTileEntity.this.litTime = value;
				break;
			case 1:
				AbstractOvenTileEntity.this.litDuration = value;
				break;
			case 2:
				AbstractOvenTileEntity.this.cookingProgress = value;
				break;
			case 3:
				AbstractOvenTileEntity.this.cookingTotalTime = value;
			}

		}

		public int getCount() {
			return 4;
		}
	};

	private final Object2IntOpenHashMap<ResourceLocation> recipesUsed = new Object2IntOpenHashMap<>();
	protected final IRecipeType<? extends AbstractCookingRecipe> recipeType;

	protected AbstractOvenTileEntity(TileEntityType<?> tileTypeIn, IRecipeType<? extends AbstractCookingRecipe> recipeTypeIn) {
		super(tileTypeIn, recipeTypeIn);
		this.recipeType = recipeTypeIn;
	}

	@Deprecated //Forge - get burn times by calling ForgeHooks#getBurnTime(ItemStack)
	public static Map<Item, Integer> getFuel() {
		Map<Item, Integer> map = Maps.newLinkedHashMap();
		add(map, Items.LAVA_BUCKET, 20000);
		add(map, Blocks.COAL_BLOCK, 16000);
		add(map, Items.BLAZE_ROD, 2400);
		add(map, Items.COAL, 1600);
		add(map, Items.CHARCOAL, 1600);
		add(map, ItemTags.LOGS, 300);
		add(map, ItemTags.PLANKS, 300);
		add(map, ItemTags.WOODEN_STAIRS, 300);
		add(map, ItemTags.WOODEN_SLABS, 150);
		add(map, ItemTags.WOODEN_TRAPDOORS, 300);
		add(map, ItemTags.WOODEN_PRESSURE_PLATES, 300);
		add(map, Blocks.OAK_FENCE, 300);
		add(map, Blocks.BIRCH_FENCE, 300);
		add(map, Blocks.SPRUCE_FENCE, 300);
		add(map, Blocks.JUNGLE_FENCE, 300);
		add(map, Blocks.DARK_OAK_FENCE, 300);
		add(map, Blocks.ACACIA_FENCE, 300);
		add(map, Blocks.OAK_FENCE_GATE, 300);
		add(map, Blocks.BIRCH_FENCE_GATE, 300);
		add(map, Blocks.SPRUCE_FENCE_GATE, 300);
		add(map, Blocks.JUNGLE_FENCE_GATE, 300);
		add(map, Blocks.DARK_OAK_FENCE_GATE, 300);
		add(map, Blocks.ACACIA_FENCE_GATE, 300);
		add(map, Blocks.NOTE_BLOCK, 300);
		add(map, Blocks.BOOKSHELF, 300);
		add(map, Blocks.LECTERN, 300);
		add(map, Blocks.JUKEBOX, 300);
		add(map, Blocks.CHEST, 300);
		add(map, Blocks.TRAPPED_CHEST, 300);
		add(map, Blocks.CRAFTING_TABLE, 300);
		add(map, Blocks.DAYLIGHT_DETECTOR, 300);
		add(map, ItemTags.BANNERS, 300);
		add(map, Items.BOW, 300);
		add(map, Items.FISHING_ROD, 300);
		add(map, Blocks.LADDER, 300);
		add(map, ItemTags.SIGNS, 200);
		add(map, Items.WOODEN_SHOVEL, 200);
		add(map, Items.WOODEN_SWORD, 200);
		add(map, Items.WOODEN_HOE, 200);
		add(map, Items.WOODEN_AXE, 200);
		add(map, Items.WOODEN_PICKAXE, 200);
		add(map, ItemTags.WOODEN_DOORS, 200);
		add(map, ItemTags.BOATS, 1200);
		add(map, ItemTags.WOOL, 100);
		add(map, ItemTags.WOODEN_BUTTONS, 100);
		add(map, Items.STICK, 100);
		add(map, ItemTags.SAPLINGS, 100);
		add(map, Items.BOWL, 100);
		add(map, ItemTags.CARPETS, 67);
		add(map, Blocks.DRIED_KELP_BLOCK, 4001);
		add(map, Items.CROSSBOW, 300);
		add(map, Blocks.BAMBOO, 50);
		add(map, Blocks.DEAD_BUSH, 100);
		add(map, Blocks.SCAFFOLDING, 400);
		add(map, Blocks.LOOM, 300);
		add(map, Blocks.BARREL, 300);
		add(map, Blocks.CARTOGRAPHY_TABLE, 300);
		add(map, Blocks.FLETCHING_TABLE, 300);
		add(map, Blocks.SMITHING_TABLE, 300);
		add(map, Blocks.COMPOSTER, 300);
		return map;
	}

	private static boolean isNeverAFurnaceFuel(Item item) {
		return ItemTags.NON_FLAMMABLE_WOOD.contains(item);
	}

	private static void add(Map<Item, Integer> map, ITag<Item> itemProvider, int burnTimeIn) {
		for(Item item : itemProvider.getValues()) {
			if (!isNeverAFurnaceFuel(item)) {
				map.put(item, burnTimeIn);
			}
		}

	}

	private static void add(Map<Item, Integer> map, IItemProvider itemProvider, int burnTimeIn) {
		Item item = itemProvider.asItem();
		if (isNeverAFurnaceFuel(item)) {
			if (SharedConstants.IS_RUNNING_IN_IDE) {
				throw (IllegalStateException)Util.pauseInIde(new IllegalStateException("A developer tried to explicitly make fire resistant item " + item.getName((ItemStack)null).getString() + " a furnace fuel. That will not work!"));
			}
		} else {
			map.put(item, burnTimeIn);
		}
	}

	private boolean isLit() {
		return this.litTime > 0;
	}

	@Override
	public void load(BlockState state, CompoundNBT compound) { //TODO: MARK
		super.load(state, compound);
		this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
		ItemStackHelper.loadAllItems(compound, this.items);
		this.litTime = compound.getInt("BurnTime");
		this.cookingProgress = compound.getInt("CookTime");
		this.cookingTotalTime = compound.getInt("CookTimeTotal");
		this.litDuration = this.getBurnDuration(this.items.get(1));
		CompoundNBT compoundnbt = compound.getCompound("RecipesUsed");

		for(String s : compoundnbt.getAllKeys()) {
			this.recipesUsed.put(new ResourceLocation(s), compoundnbt.getInt(s));
		}
	}

	@Override
	public CompoundNBT save(CompoundNBT compound) {
		super.save(compound);
		compound.putInt("BurnTime", this.litTime);
		compound.putInt("CookTime", this.cookingProgress);
		compound.putInt("CookTimeTotal", this.cookingTotalTime);
		ItemStackHelper.saveAllItems(compound, this.items);
		CompoundNBT compoundnbt = new CompoundNBT();
		this.recipesUsed.forEach((p_235643_1_, p_235643_2_) -> {
			compoundnbt.putInt(p_235643_1_.toString(), p_235643_2_);
		});
		compound.put("RecipesUsed", compoundnbt);
		return compound;
	}

	@SuppressWarnings("unchecked")
	public void tick() {
		boolean flag = this.isLit();
		boolean flag1 = false;
		if (this.isLit()) {
			--this.litTime;
		}

		if (!this.level.isClientSide) {
			ItemStack stack = this.items.get(1);
			if (this.isLit() || !stack.isEmpty() && !this.items.get(0).isEmpty()) {
				IRecipe<?> irecipe = this.level.getRecipeManager().getRecipeFor((IRecipeType<AbstractCookingRecipe>)this.recipeType, this, this.level).orElse(null);
				if (!this.isLit() && this.canBurn(irecipe)) {
					this.litTime = this.getBurnDuration(stack);
					this.litDuration = this.litTime;
					if (this.isLit()) {
						flag1 = true;
						if (stack.hasContainerItem())
							 this.items.set(1, stack.getContainerItem());
						else
						if (!stack.isEmpty()) {
							//Item item = stack.getItem();
							stack.shrink(1);
							if (stack.isEmpty()) {
								this.items.set(1, stack.getContainerItem());
							}
						}
					}
				}

				if (this.isLit() && this.canBurn(irecipe)) {
					++this.cookingProgress;
					if (this.cookingProgress == this.cookingTotalTime) {
						this.cookingProgress = 0;
						this.cookingTotalTime = this.getTotalCookTime();
						this.burn(irecipe);
						flag1 = true;
					}
				} else {
					this.cookingProgress = 0;
				}
			} else if (!this.isLit() && this.cookingProgress > 0) {
				this.cookingProgress = MathHelper.clamp(this.cookingProgress - 2, 0, this.cookingTotalTime);
			}

			if (flag != this.isLit()) {
				flag1 = true;
				this.level.setBlock(this.worldPosition, this.level.getBlockState(this.worldPosition).setValue(AbstractFurnaceBlock.LIT, Boolean.valueOf(this.isLit())), 3);
			}
		}

		if (flag1) {
			this.setChanged();
		}

	}

	@Override
	protected boolean canBurn(@Nullable IRecipe<?> recipe) {
		if (!this.items.get(0).isEmpty() && recipe != null) {
			ItemStack stack = recipe.getResultItem();
			if (stack.isEmpty()) {
				return false;
			} else {
				ItemStack stack1 = this.items.get(2);
				if (stack1.isEmpty()) {
					return true;
				} else if (!stack1.sameItem(stack)) {
					return false;
				} else if (stack1.getCount() + stack.getCount() <= this.getMaxStackSize() && stack1.getCount() + stack.getCount() <= stack1.getMaxStackSize()) { // Forge fix: make furnace respect stack sizes in furnace recipes
					return true;
				} else {
					return stack1.getCount() + stack.getCount() <= stack.getMaxStackSize(); // Forge fix: make furnace respect stack sizes in furnace recipes
				}
			}
		} else {
			return false;
		}
	}

	private void burn(@Nullable IRecipe<?> recipe) {
		if (recipe != null && this.canBurn(recipe)) {
			ItemStack stack = this.items.get(0);
			ItemStack stack1 = recipe.getResultItem();
			ItemStack stack2 = this.items.get(2);
			if (stack2.isEmpty()) {
				this.items.set(2, stack1.copy());
			} else if (stack2.getItem() == stack1.getItem()) {
				stack2.grow(stack1.getCount());
			}

			if (!this.level.isClientSide) {
				this.setRecipeUsed(recipe);
			}

			if (stack.getItem() == Blocks.WET_SPONGE.asItem() && !this.items.get(1).isEmpty() && this.items.get(1).getItem() == Items.BUCKET) {
				this.items.set(1, new ItemStack(Items.WATER_BUCKET));
			}

			stack.shrink(1);
		}
	}

	/* 燃料の燃焼時間 KitOvenは3倍にする */
	@Override
	protected int getBurnDuration(ItemStack stack) {
		if (stack.isEmpty()) {
			return 0;
		} else {
			//Item item = stack.getItem();
			return net.minecraftforge.common.ForgeHooks.getBurnTime(stack, this.recipeType) * 3;
		}
	}

	/* 間接的な熱を使うため、200 -> 250 */
	@SuppressWarnings("unchecked")
	protected int getTotalCookTime() {
		return this.level.getRecipeManager().getRecipeFor((IRecipeType<AbstractCookingRecipe>)this.recipeType, this, this.level)
				.map(AbstractCookingRecipe::getCookingTime).orElse(200) /4 * 5;
	}

	public static boolean isFuel(ItemStack stack) {
		return net.minecraftforge.common.ForgeHooks.getBurnTime(stack, null) > 0;
	}

	@Override
	public int[] getSlotsForFace(Direction direction) {
		if (direction == Direction.DOWN) {
			return SLOTS_FOR_DOWN;
		} else {
			return direction == Direction.UP ? SLOTS_FOR_UP : SLOTS_FOR_SIDES;
		}
	}

	@Override
	public boolean canPlaceItemThroughFace(int count, ItemStack stack, @Nullable Direction direction) {
		return this.canPlaceItem(count, stack);
	}

	@Override
	public boolean canTakeItemThroughFace(int count, ItemStack stack, Direction direction) {
		if (direction == Direction.DOWN && count == 1) {
			Item item = stack.getItem();
			if (item != Items.WATER_BUCKET && item != Items.BUCKET) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int getContainerSize() {
		return this.items.size();
	}

	@Override
	public boolean isEmpty() {
		for(ItemStack stack : this.items) {
			if (!stack.isEmpty()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public ItemStack getItem(int count) {
		return this.items.get(count);
	}

	@Override
	public ItemStack removeItem(int count1, int count2) {
		return ItemStackHelper.removeItem(this.items, count1, count2);
	}

	@Override
	public ItemStack removeItemNoUpdate(int count) {
		return ItemStackHelper.takeItem(this.items, count);
	}

	@Override
	public void setItem(int count, ItemStack stack) {
		ItemStack countStack = this.items.get(count);
		boolean flag = !stack.isEmpty() && stack.sameItem(countStack) && ItemStack.tagMatches(stack, countStack);
		this.items.set(count, stack);
		if (stack.getCount() > this.getMaxStackSize()) {
			stack.setCount(this.getMaxStackSize());
		}

		if (count == 0 && !flag) {
			this.cookingTotalTime = this.getTotalCookTime();
			this.cookingProgress = 0;
			this.setChanged();
		}

	}

	@Override
	public boolean stillValid(PlayerEntity playerIn) {
		if (this.level.getBlockEntity(this.worldPosition) != this) {
			return false;
		} else {
			return playerIn.distanceToSqr((double)this.worldPosition.getX() + 0.5D, (double)this.worldPosition.getY() + 0.5D, (double)this.worldPosition.getZ() + 0.5D) <= 64.0D;
		}
	}

	@Override
	public boolean canPlaceItem(int count, ItemStack stack) {
		if (count == 2) {
			return false;
		} else if (count != 1) {
			return true;
		} else {
			ItemStack countStack = this.items.get(1);
			return isFuel(stack) || stack.getItem() == Items.BUCKET && countStack.getItem() != Items.BUCKET;
		}
	}

	@Override
	public void clearContent() {
		this.items.clear();
	}

	@Override
	public void setRecipeUsed(@Nullable IRecipe<?> recipe) {
		if (recipe != null) {
			ResourceLocation resourcelocation = recipe.getId();
			this.recipesUsed.addTo(resourcelocation, 1);
		}
	}

	@Nullable
	public IRecipe<?> getRecipeUsed() {
		return null;
	}

	/*public void awardUsedRecipes(PlayerEntity playerIn) {
	}

	public void awardUsedRecipesAndPopExperience(PlayerEntity playerIn) {
		List<IRecipe<?>> list = this.getRecipesToAwardAndPopExperience(playerIn.level, playerIn.position());
		player.awardRecipes(list);
		this.recipesUsed.clear();
	}

	public List<IRecipe<?>> getRecipesToAwardAndPopExperience(World worldIn, Vector3d v3d) {
		List<IRecipe<?>> list = Lists.newArrayList();

		for(Entry<ResourceLocation> entry : this.recipesUsed.object2IntEntrySet()) {
			worldIn.getRecipeManager().byKey(entry.getKey()).ifPresent((p_235642_4_) -> {
				list.add(p_235642_4_);
				createExperience(worldIn, v3d, entry.getIntValue(), ((AbstractCookingRecipe)p_235642_4_).getExperience());
			});
		}
		return list;
	}*/

	@SuppressWarnings("unused")
	private static void createExperience(World worldIn, Vector3d v3d, int count, float count_f) {
		int i = MathHelper.floor((float)count * count_f);
		float f = MathHelper.frac((float)count * count_f);
		if (f != 0.0F && Math.random() < (double)f) {
			++i;
		}

		while(i > 0) {
			int j = ExperienceOrbEntity.getExperienceValue(i);
			i -= j;
			worldIn.addFreshEntity(new ExperienceOrbEntity(worldIn, v3d.x, v3d.y, v3d.z, j));
		}
	}

	@Override
	public void fillStackedContents(RecipeItemHelper helper) {
		for(ItemStack stack : this.items) {
			helper.accountStack(stack);
		}
	}

	net.minecraftforge.common.util.LazyOptional<? extends net.minecraftforge.items.IItemHandler>[] handlers =
			 net.minecraftforge.items.wrapper.SidedInvWrapper.create(this, Direction.UP, Direction.DOWN, Direction.NORTH);

	@Override
	public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, @Nullable Direction facing) {
		if (!this.remove && facing != null && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			if (facing == Direction.UP)
				return handlers[0].cast();
			else if (facing == Direction.DOWN)
				return handlers[1].cast();
			else
				return handlers[2].cast();
		}
		return super.getCapability(capability, facing);
	}

	@Override
	protected void invalidateCaps() {
		super.invalidateCaps();
		for (int x = 0; x < handlers.length; x++)
		 handlers[x].invalidate();
	}

}
