package com.ayutaki.chinjufumod.tileentity;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.furnace.AbstractStoveBlock;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import net.minecraft.block.Blocks;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IRecipeHelperPopulator;
import net.minecraft.inventory.IRecipeHolder;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.RecipeItemHelper;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.LockableTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public abstract class AbstractStoveTileEntity extends LockableTileEntity implements ISidedInventory, IRecipeHolder, IRecipeHelperPopulator, ITickableTileEntity {

	private static final int[] SLOTS_UP = new int[]{0};
	private static final int[] SLOTS_DOWN = new int[]{2, 1};
	private static final int[] SLOTS_HORIZONTAL = new int[]{1};
	protected NonNullList<ItemStack> items = NonNullList.withSize(3, ItemStack.EMPTY);
	private int burnTime;
	private int recipesUsed;
	private int cookTime;
	private int cookTimeTotal;

	protected final IIntArray furnaceData = new IIntArray() {
		public int get(int index) {
			switch(index) {
			case 0:
				return AbstractStoveTileEntity.this.burnTime;
			case 1:
				return AbstractStoveTileEntity.this.recipesUsed;
			case 2:
				return AbstractStoveTileEntity.this.cookTime;
			case 3:
				return AbstractStoveTileEntity.this.cookTimeTotal;
			default:
				return 0;
			}
	}

	public void set(int index, int value) {
		switch(index) {
		case 0:
			AbstractStoveTileEntity.this.burnTime = value;
			break;
		case 1:
			AbstractStoveTileEntity.this.recipesUsed = value;
			break;
		case 2:
			AbstractStoveTileEntity.this.cookTime = value;
			break;
		case 3:
			AbstractStoveTileEntity.this.cookTimeTotal = value;
		}
	}

	public int size() {
		return 4;
		}
	};

	private final Map<ResourceLocation, Integer> map = Maps.newHashMap();
	protected final IRecipeType<? extends AbstractCookingRecipe> recipeType;

	protected AbstractStoveTileEntity(TileEntityType<?> tileTypeIn, IRecipeType<? extends AbstractCookingRecipe> recipeTypeIn) {
		super(tileTypeIn);
		this.recipeType = recipeTypeIn;
	}

	@Deprecated //Forge - get burn times by calling ForgeHooks#getBurnTime(ItemStack)
	public static Map<Item, Integer> getBurnTimes() {
		Map<Item, Integer> map = Maps.newLinkedHashMap();
		addItemBurnTime(map, Items.LAVA_BUCKET, 20000);
		addItemBurnTime(map, Blocks.COAL_BLOCK, 16000);
		addItemBurnTime(map, Items.BLAZE_ROD, 2400);
		addItemBurnTime(map, Items.COAL, 1600);
		addItemBurnTime(map, Items.CHARCOAL, 1600);
		addItemTagBurnTime(map, ItemTags.LOGS, 300);
		addItemTagBurnTime(map, ItemTags.PLANKS, 300);
		addItemTagBurnTime(map, ItemTags.WOODEN_STAIRS, 300);
		addItemTagBurnTime(map, ItemTags.WOODEN_SLABS, 150);
		addItemTagBurnTime(map, ItemTags.WOODEN_TRAPDOORS, 300);
		addItemTagBurnTime(map, ItemTags.WOODEN_PRESSURE_PLATES, 300);
		addItemTagBurnTime(map, net.minecraftforge.common.Tags.Items.FENCES_WOODEN, 300);
		addItemTagBurnTime(map, net.minecraftforge.common.Tags.Items.FENCE_GATES_WOODEN, 300);
		addItemBurnTime(map, Blocks.NOTE_BLOCK, 300);
		addItemBurnTime(map, Blocks.BOOKSHELF, 300);
		addItemBurnTime(map, Blocks.LECTERN, 300);
		addItemBurnTime(map, Blocks.JUKEBOX, 300);
		addItemBurnTime(map, Blocks.CHEST, 300);
		addItemBurnTime(map, Blocks.TRAPPED_CHEST, 300);
		addItemBurnTime(map, Blocks.CRAFTING_TABLE, 300);
		addItemBurnTime(map, Blocks.DAYLIGHT_DETECTOR, 300);
		addItemTagBurnTime(map, ItemTags.BANNERS, 300);
		addItemBurnTime(map, Items.BOW, 300);
		addItemBurnTime(map, Items.FISHING_ROD, 300);
		addItemBurnTime(map, Blocks.LADDER, 300);
		addItemTagBurnTime(map, ItemTags.SIGNS, 200);
		addItemBurnTime(map, Items.WOODEN_SHOVEL, 200);
		addItemBurnTime(map, Items.WOODEN_SWORD, 200);
		addItemBurnTime(map, Items.WOODEN_HOE, 200);
		addItemBurnTime(map, Items.WOODEN_AXE, 200);
		addItemBurnTime(map, Items.WOODEN_PICKAXE, 200);
		addItemTagBurnTime(map, ItemTags.WOODEN_DOORS, 200);
		addItemTagBurnTime(map, ItemTags.BOATS, 1200);
		addItemTagBurnTime(map, ItemTags.WOOL, 100);
		addItemTagBurnTime(map, ItemTags.WOODEN_BUTTONS, 100);
		addItemBurnTime(map, Items.STICK, 100);
		addItemTagBurnTime(map, ItemTags.SAPLINGS, 100);
		addItemBurnTime(map, Items.BOWL, 100);
		addItemTagBurnTime(map, ItemTags.CARPETS, 67);
		addItemBurnTime(map, Blocks.DRIED_KELP_BLOCK, 4001);
		addItemBurnTime(map, Items.CROSSBOW, 300);
		addItemBurnTime(map, Blocks.BAMBOO, 50);
		addItemBurnTime(map, Blocks.DEAD_BUSH, 100);
		addItemBurnTime(map, Blocks.SCAFFOLDING, 400);
		addItemBurnTime(map, Blocks.LOOM, 300);
		addItemBurnTime(map, Blocks.BARREL, 300);
		addItemBurnTime(map, Blocks.CARTOGRAPHY_TABLE, 300);
		addItemBurnTime(map, Blocks.FLETCHING_TABLE, 300);
		addItemBurnTime(map, Blocks.SMITHING_TABLE, 300);
		addItemBurnTime(map, Blocks.COMPOSTER, 300);
		return map;
	}

	private static void addItemTagBurnTime(Map<Item, Integer> map, Tag<Item> itemTag, int burnTimeIn) {
		for(Item item : itemTag.getAllElements()) {
			map.put(item, burnTimeIn);
		}
	}

	private static void addItemBurnTime(Map<Item, Integer> map, IItemProvider itemProvider, int burnTimeIn) {
		map.put(itemProvider.asItem(), burnTimeIn);
	}

	private boolean isBurning() {
		return this.burnTime > 0;
	}

	public void read(CompoundNBT compound) {
		super.read(compound);
		this.items = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
		ItemStackHelper.loadAllItems(compound, this.items);
		this.burnTime = compound.getInt("BurnTime");
		this.cookTime = compound.getInt("CookTime");
		this.cookTimeTotal = compound.getInt("CookTimeTotal");
		this.recipesUsed = this.getBurnTime(this.items.get(1));
		int i = compound.getShort("RecipesUsedSize");

		for(int j = 0; j < i; ++j) {
			ResourceLocation resourcelocation = new ResourceLocation(compound.getString("RecipeLocation" + j));
			int k = compound.getInt("RecipeAmount" + j);
			this.map.put(resourcelocation, k);
		}
	}

	public CompoundNBT write(CompoundNBT compound) {
		super.write(compound);
		compound.putInt("BurnTime", this.burnTime);
		compound.putInt("CookTime", this.cookTime);
		compound.putInt("CookTimeTotal", this.cookTimeTotal);
		ItemStackHelper.saveAllItems(compound, this.items);
		compound.putShort("RecipesUsedSize", (short)this.map.size());
		int i = 0;

		for(Entry<ResourceLocation, Integer> entry : this.map.entrySet()) {
			compound.putString("RecipeLocation" + i, entry.getKey().toString());
			compound.putInt("RecipeAmount" + i, entry.getValue());
			++i;
		}
		return compound;
	}

	@SuppressWarnings("unchecked")
	public void tick() {
		boolean flag = this.isBurning();
		boolean flag1 = false;
		if (this.isBurning()) {
			--this.burnTime;
		}

		if (!this.world.isRemote) {
			ItemStack stack = this.items.get(1);

			if (this.isBurning() || !stack.isEmpty() && !this.items.get(0).isEmpty()) {
				IRecipe<?> irecipe = this.world.getRecipeManager().getRecipe((IRecipeType<AbstractCookingRecipe>)this.recipeType, this, this.world).orElse(null);

				if (!this.isBurning() && this.canSmelt(irecipe)) {
					this.burnTime = this.getBurnTime(stack);
					this.recipesUsed = this.burnTime;

					if (this.isBurning()) {
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

				if (this.isBurning() && this.canSmelt(irecipe)) {
					++this.cookTime;
					if (this.cookTime == this.cookTimeTotal) {
						this.cookTime = 0;
						this.cookTimeTotal = this.getCookTime();
						this.smelt(irecipe);
						flag1 = true;
					}
				}
				else {
					this.cookTime = 0;
				}
			}
			else if (!this.isBurning() && this.cookTime > 0) {
				this.cookTime = MathHelper.clamp(this.cookTime - 2, 0, this.cookTimeTotal);
			}

			if (flag != this.isBurning()) {
				flag1 = true;
				this.world.setBlockState(this.pos, this.world.getBlockState(this.pos).with(AbstractStoveBlock.LIT, Boolean.valueOf(this.isBurning())), 3);
			}
		}

		if (flag1) {
			this.markDirty();
		}
	}

	protected boolean canSmelt(@Nullable IRecipe<?> recipeIn) {
		if (!this.items.get(0).isEmpty() && recipeIn != null) {
			ItemStack stack = recipeIn.getRecipeOutput();

			if (stack.isEmpty()) {
				return false;
			}
			else {
				ItemStack stack1 = this.items.get(2);
				if (stack1.isEmpty()) {
					return true;
				}
				else if (!stack1.isItemEqual(stack)) {
					return false;
				}
				else if (stack1.getCount() + stack.getCount() <= this.getInventoryStackLimit() && stack1.getCount() + stack.getCount() <= stack1.getMaxStackSize()) { // Forge fix: make furnace respect stack sizes in furnace recipes
					return true;
				}
				else {
					return stack1.getCount() + stack.getCount() <= stack.getMaxStackSize(); // Forge fix: make furnace respect stack sizes in furnace recipes
				}
			}
		}
		else {
			return false;
		}
	}

	private void smelt(@Nullable IRecipe<?> recipe) {
		if (recipe != null && this.canSmelt(recipe)) {
			ItemStack stack = this.items.get(0);
			ItemStack stack1 = recipe.getRecipeOutput();
			ItemStack stack2 = this.items.get(2);

			if (stack2.isEmpty()) {
				this.items.set(2, stack1.copy());
			}
			else if (stack2.getItem() == stack1.getItem()) {
				stack2.grow(stack1.getCount());
			}

			if (!this.world.isRemote) {
				this.setRecipeUsed(recipe);
			}

			if (stack.getItem() == Blocks.WET_SPONGE.asItem() && !this.items.get(1).isEmpty() && this.items.get(1).getItem() == Items.BUCKET) {
				this.items.set(1, new ItemStack(Items.WATER_BUCKET));
			}
		stack.shrink(1);
		}
	}

	/* 燃料の燃焼時間 学校ストーブは1.5倍にする */
	protected int getBurnTime(ItemStack fuel) {
		if (fuel.isEmpty()) {
			return 0;
		}
		else {
			//Item item = fuel.getItem();
			return net.minecraftforge.common.ForgeHooks.getBurnTime(fuel) /2 * 3;
		}
	}

	@SuppressWarnings("unchecked")
	protected int getCookTime() {
		return this.world.getRecipeManager().getRecipe((IRecipeType<AbstractCookingRecipe>)this.recipeType, this, this.world)
				.map(AbstractCookingRecipe::getCookTime).orElse(200);
	}

	public static boolean isFuel(ItemStack stack) {
		return net.minecraftforge.common.ForgeHooks.getBurnTime(stack) > 0;
	}

	public int[] getSlotsForFace(Direction side) {
		if (side == Direction.DOWN) {
			return SLOTS_DOWN;
		}
		else {
			return side == Direction.UP ? SLOTS_UP : SLOTS_HORIZONTAL;
		}
	}

	public boolean canInsertItem(int index, ItemStack stack, @Nullable Direction direction) {
		return this.isItemValidForSlot(index, stack);
	}

	public boolean canExtractItem(int index, ItemStack stack, Direction direction) {
		if (direction == Direction.DOWN && index == 1) {
			Item item = stack.getItem();
			if (item != Items.WATER_BUCKET && item != Items.BUCKET) {
				return false;
			}
		}
		return true;
	}

	public int getSizeInventory() {
		return this.items.size();
	}

	public boolean isEmpty() {
		for(ItemStack stack : this.items) {
			if (!stack.isEmpty()) {
				return false;
			}
		}
		return true;
	}

	public ItemStack getStackInSlot(int index) {
		return this.items.get(index);
	}

	public ItemStack decrStackSize(int index, int count) {
		return ItemStackHelper.getAndSplit(this.items, index, count);
	}

	public ItemStack removeStackFromSlot(int index) {
		return ItemStackHelper.getAndRemove(this.items, index);
	}

	public void setInventorySlotContents(int index, ItemStack stack) {
		ItemStack countStack = this.items.get(index);
		boolean flag = !stack.isEmpty() && stack.isItemEqual(countStack) && ItemStack.areItemStackTagsEqual(stack, countStack);
		this.items.set(index, stack);
		if (stack.getCount() > this.getInventoryStackLimit()) {
			stack.setCount(this.getInventoryStackLimit());
		}

		if (index == 0 && !flag) {
			this.cookTimeTotal = this.getCookTime();
			this.cookTime = 0;
			this.markDirty();
		}
	}

	public boolean isUsableByPlayer(PlayerEntity playerIn) {
		if (this.world.getTileEntity(this.pos) != this) {
			return false;
		}
		else {
			return playerIn.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
		}
	}

	public boolean isItemValidForSlot(int index, ItemStack stack) {
		if (index == 2) {
			return false;
		}
		else if (index != 1) {
			return true;
		}
		else {
			ItemStack countStack = this.items.get(1);
			return isFuel(stack) || stack.getItem() == Items.BUCKET && countStack.getItem() != Items.BUCKET;
		}
	}

	public void clear() {
		this.items.clear();
	}

	public void setRecipeUsed(@Nullable IRecipe<?> recipe) {
		if (recipe != null) {
			this.map.compute(recipe.getId(), (p_214004_0_, p_214004_1_) -> {
				return 1 + (p_214004_1_ == null ? 0 : p_214004_1_);
			});
		}
	}

	@Nullable
	public IRecipe<?> getRecipeUsed() {
		return null;
	}

	public void onCrafting(PlayerEntity playerIn) { }

	public void func_213995_d(PlayerEntity playerIn) {
		List<IRecipe<?>> list = Lists.newArrayList();

		for(Entry<ResourceLocation, Integer> entry : this.map.entrySet()) {
			playerIn.world.getRecipeManager().getRecipe(entry.getKey()).ifPresent((p_213993_3_) -> {
				list.add(p_213993_3_);
				spawnExpOrbs(playerIn, entry.getValue(), ((AbstractCookingRecipe)p_213993_3_).getExperience());
			});
		}
		playerIn.unlockRecipes(list);
			this.map.clear();
	}

	private static void spawnExpOrbs(PlayerEntity playerIn, int t, float experience) {
		if (experience == 0.0F) {
			t = 0;
		}

		else if (experience < 1.0F) {
			int i = MathHelper.floor((float)t * experience);
			if (i < MathHelper.ceil((float)t * experience) && Math.random() < (double)((float)t * experience - (float)i)) {
				++i;
			}
			t = i;
		}

		while(t > 0) {
			int j = ExperienceOrbEntity.getXPSplit(t);
			t -= j;
			playerIn.world.addEntity(new ExperienceOrbEntity(playerIn.world, playerIn.getPosX(), playerIn.getPosY() + 0.5D, playerIn.getPosZ() + 0.5D, j));
		}
	}

	public void fillStackedContents(RecipeItemHelper helper) {
		for(ItemStack stack : this.items) {
			helper.accountStack(stack);
		}
	}

	net.minecraftforge.common.util.LazyOptional<? extends net.minecraftforge.items.IItemHandler>[] handlers =
			net.minecraftforge.items.wrapper.SidedInvWrapper.create(this, Direction.UP, Direction.DOWN, Direction.NORTH);

	@Override
	public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, @Nullable Direction facing) {

		if (!this.removed && facing != null && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
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
		public void remove() {
			super.remove();
			for (int x = 0; x < handlers.length; x++)
				handlers[x].invalidate();
	}

}
