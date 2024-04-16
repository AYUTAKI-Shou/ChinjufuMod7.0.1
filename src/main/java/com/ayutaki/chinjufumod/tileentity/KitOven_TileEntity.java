package com.ayutaki.chinjufumod.tileentity;

import com.ayutaki.chinjufumod.blocks.furnace.Kitchen_Oven;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBoat;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.datafix.FixTypes;
import net.minecraft.util.datafix.walkers.ItemStackDataLists;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class KitOven_TileEntity extends TileEntityLockable implements ITickable, ISidedInventory {

	private static final int[] SLOTS_TOP = new int[] {0};
	private static final int[] SLOTS_BOTTOM = new int[] {2, 1};
	private static final int[] SLOTS_SIDES = new int[] {1};
	/** The ItemStacks that hold the items currently being used in the furnace */
	private NonNullList<ItemStack> furnaceItemStacks = NonNullList.<ItemStack>withSize(3, ItemStack.EMPTY);
	/** The number of ticks that the furnace will keep burning */
	private int furnaceBurnTime;
	/** The number of ticks that a fresh copy of the currently-burning item would keep the furnace burning for */
	private int currentItemBurnTime;
	private int cookTime;
	private int totalCookTime;
	private String furnaceCustomName;

	/**
	 * Returns the number of slots in the inventory.
	 */
	public int getSizeInventory() {
		return this.furnaceItemStacks.size();
	}

	public boolean isEmpty() {

		for (ItemStack stack : this.furnaceItemStacks) {

			if (!stack.isEmpty()) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Returns the stack in the given slot.
	 */
	public ItemStack getStackInSlot(int index) {
		return this.furnaceItemStacks.get(index);
	}

	/**
	 * Removes up to a specified number of items from an inventory slot and returns them in a new stack.
	 */
	public ItemStack decrStackSize(int index, int count) {
		return ItemStackHelper.getAndSplit(this.furnaceItemStacks, index, count);
	}

	/**
	 * Removes a stack from the given slot and returns it.
	 */
	public ItemStack removeStackFromSlot(int index) {
		return ItemStackHelper.getAndRemove(this.furnaceItemStacks, index);
	}

	/**
	 * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
	 */
	public void setInventorySlotContents(int index, ItemStack stack) {

		ItemStack countStack = this.furnaceItemStacks.get(index);
		boolean flag = !stack.isEmpty() && stack.isItemEqual(countStack) && ItemStack.areItemStackTagsEqual(stack, countStack);
		this.furnaceItemStacks.set(index, stack);

		if (stack.getCount() > this.getInventoryStackLimit()) {
			stack.setCount(this.getInventoryStackLimit());
		}

		if (index == 0 && !flag) {
			this.totalCookTime = this.getCookTime(stack);
			this.cookTime = 0;
			this.markDirty();
		}
	}

	/**
	 * Get the name of this object. For players this returns their username
	 */
	public String getName() {
		return this.hasCustomName() ? this.furnaceCustomName : "container.kitchen_oven";
	}

	/**
	 * Returns true if this thing is named
	 */
	public boolean hasCustomName() {
		return this.furnaceCustomName != null && !this.furnaceCustomName.isEmpty();
	}

	public void setCustomInventoryName(String p_145951_1_) {
		this.furnaceCustomName = p_145951_1_;
	}

	public static void registerFixesFurnace(DataFixer fixer) {
		fixer.registerWalker(FixTypes.BLOCK_ENTITY, new ItemStackDataLists(TileEntityFurnace.class, new String[] {"Items"}));
	}

	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);

		this.furnaceItemStacks = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
		ItemStackHelper.loadAllItems(compound, this.furnaceItemStacks);
		this.furnaceBurnTime = compound.getInteger("BurnTime");
		this.cookTime = compound.getInteger("CookTime");
		this.totalCookTime = compound.getInteger("CookTimeTotal");
		this.currentItemBurnTime = getItemBurnTime(this.furnaceItemStacks.get(1));

		if (compound.hasKey("CustomName", 8)) {
			this.furnaceCustomName = compound.getString("CustomName");
		}
	}

	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);

		compound.setInteger("BurnTime", (short)this.furnaceBurnTime);
		compound.setInteger("CookTime", (short)this.cookTime);
		compound.setInteger("CookTimeTotal", (short)this.totalCookTime);
		ItemStackHelper.saveAllItems(compound, this.furnaceItemStacks);

		if (this.hasCustomName()) {
			compound.setString("CustomName", this.furnaceCustomName);
		}

		return compound;
	}

	/**
	 * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended.
	 */
	public int getInventoryStackLimit() {
		return 64;
	}

	/**
	 * Furnace isBurning
	 */
	public boolean isBurning() {
		return this.furnaceBurnTime > 0;
	}

	@SideOnly(Side.CLIENT)
	public static boolean isBurning(IInventory inventory) {
		return inventory.getField(0) > 0;
	}

	/**
	 * Like the old updateEntity(), except more generic.
	 */
	public void update() {

		boolean flag = this.isBurning();
		boolean flag1 = false;

		if (this.isBurning()) {
			--this.furnaceBurnTime;
		}

		if (!this.world.isRemote) {

			ItemStack stack = this.furnaceItemStacks.get(1);

			if (this.isBurning() || !stack.isEmpty() && !((ItemStack)this.furnaceItemStacks.get(0)).isEmpty()) {

				if (!this.isBurning() && this.canSmelt()) {
					this.furnaceBurnTime = getItemBurnTime(stack);
					this.currentItemBurnTime = this.furnaceBurnTime;

					if (this.isBurning()) {
						flag1 = true;

						if (!stack.isEmpty()) {

							Item item = stack.getItem();
							stack.shrink(1);

							if (stack.isEmpty()) {

								ItemStack item1 = item.getContainerItem(stack);
								this.furnaceItemStacks.set(1, item1);
							}
						}
					}
				}

				if (this.isBurning() && this.canSmelt()) {
					++this.cookTime;

					if (this.cookTime == this.totalCookTime) {
						this.cookTime = 0;
						this.totalCookTime = this.getCookTime(this.furnaceItemStacks.get(0));
						this.smeltItem();
						flag1 = true;
					}
				}

				else {
					this.cookTime = 0;
				}
			}

			else if (!this.isBurning() && this.cookTime > 0) {
				this.cookTime = MathHelper.clamp(this.cookTime - 2, 0, this.totalCookTime);
			}

			if (flag != this.isBurning()) {
				flag1 = true;
				Kitchen_Oven.setState(this.isBurning(), this.world, this.pos);
			}
		}

		if (flag1) {
			this.markDirty();
		}

	}

	/* 間接的な熱を使うため, 200 -> 250 */
	public int getCookTime(ItemStack stack) {
		return 250;
	}

	/**
	 * Returns true if the furnace can smelt an item, i.e. has a source item, destination stack isn't full, etc.
	 */
	private boolean canSmelt() {

		if (((ItemStack)this.furnaceItemStacks.get(0)).isEmpty()) {
			return false;
		}

		else {
			ItemStack stack = FurnaceRecipes.instance().getSmeltingResult(this.furnaceItemStacks.get(0));

			if (stack.isEmpty()) {
				return false;
			}

			else {
				ItemStack stack1 = this.furnaceItemStacks.get(2);

				if (stack1.isEmpty()) {
					return true;
				}

				else if (!stack1.isItemEqual(stack)) {
					return false;
				}

				// Forge fix: make furnace respect stack sizes in furnace recipes
				else if (stack1.getCount() + stack.getCount() <= this.getInventoryStackLimit() && stack1
						.getCount() + stack.getCount() <= stack1.getMaxStackSize()) {
					return true;
				}

				else {
					return stack1.getCount() + stack.getCount() <= stack.getMaxStackSize(); // Forge fix: make furnace respect stack sizes in furnace recipes
				}
			}
		}
	}

	/**
	 * Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack
	 */
	public void smeltItem() {

		if (this.canSmelt()) {

			ItemStack stack = this.furnaceItemStacks.get(0);
			ItemStack stack1 = FurnaceRecipes.instance().getSmeltingResult(stack);
			ItemStack stack2 = this.furnaceItemStacks.get(2);

			if (stack2.isEmpty()) {
				this.furnaceItemStacks.set(2, stack1.copy());
			}

			else if (stack2.getItem() == stack1.getItem()) {
				stack2.grow(stack1.getCount());
			}

			if (stack.getItem() == Item.getItemFromBlock(Blocks.SPONGE) && stack
					.getMetadata() == 1 && !((ItemStack)this.furnaceItemStacks.get(1)).isEmpty() && ((ItemStack)this.furnaceItemStacks.get(1)).getItem() == Items.BUCKET) {
				this.furnaceItemStacks.set(1, new ItemStack(Items.WATER_BUCKET));
			}

			stack.shrink(1);
		}
	}

	/* 燃料の燃焼時間 Cstoveは1.5倍, KitOvenは3倍にする
	 * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't fuel */
	public static int getItemBurnTime(ItemStack stack) {

		if (stack.isEmpty()) {
			return 0;
		}

		else {

			int burnTime = net.minecraftforge.event.ForgeEventFactory.getItemBurnTime(stack);
			if (burnTime >= 0) return burnTime;
			Item item = stack.getItem();

			if (item == Item.getItemFromBlock(Blocks.WOODEN_SLAB)) {
				return 450;
			}

			else if (item == Item.getItemFromBlock(Blocks.WOOL)) {
				return 300;
			}

			else if (item == Item.getItemFromBlock(Blocks.CARPET)) {
				return 201;
			}

			else if (item == Item.getItemFromBlock(Blocks.LADDER)) {
				return 900;
			}

			else if (item == Item.getItemFromBlock(Blocks.WOODEN_BUTTON)) {
				return 300;
			}

			else if (Block.getBlockFromItem(item).getDefaultState().getMaterial() == Material.WOOD) {
				return 900;
			}

			else if (item == Item.getItemFromBlock(Blocks.COAL_BLOCK)) {
				return 48000;
			}

			else if (item instanceof ItemTool && "WOOD".equals(((ItemTool)item).getToolMaterialName())) {
				return 600;
			}

			else if (item instanceof ItemSword && "WOOD".equals(((ItemSword)item).getToolMaterialName())) {
				return 600;
			}

			else if (item instanceof ItemHoe && "WOOD".equals(((ItemHoe)item).getMaterialName())) {
				return 600;
			}

			else if (item == Items.STICK) {
				return 300;
			}

			else if (item != Items.BOW && item != Items.FISHING_ROD) {

				if (item == Items.SIGN) {
					return 600;
				}

				else if (item == Items.COAL) {
					return 4800;
				}

				else if (item == Items.LAVA_BUCKET) {
					return 60000;
				}

				else if (item != Item.getItemFromBlock(Blocks.SAPLING) && item != Items.BOWL) {

					if (item == Items.BLAZE_ROD) {
						return 7200;
					}

					else if (item instanceof ItemDoor && item != Items.IRON_DOOR) {
						return 600;
					}

					else {
						return item instanceof ItemBoat ? 1200 : 0;
					}
				}

				else {
					return 300;
				}
			}

			else {
				return 900;
			}

		}
	}

	public static boolean isItemFuel(ItemStack stack) {
		return getItemBurnTime(stack) > 0;
	}

	/**
	 * Don't rename this method to canInteractWith due to conflicts with Container
	 */
	public boolean isUsableByPlayer(EntityPlayer playerIn) {

		if (this.world.getTileEntity(this.pos) != this) {
			return false;
		}

		else {
			return playerIn.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
		}
	}

	public void openInventory(EntityPlayer playerIn) { }

	public void closeInventory(EntityPlayer playerIn) { }

	/**
	 * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot. For
	 * guis use Slot.isItemValid
	 */
	public boolean isItemValidForSlot(int index, ItemStack stack) {

		if (index == 2) {
			return false;
		}

		else if (index != 1) {
			return true;
		}

		else {
			ItemStack countStack = this.furnaceItemStacks.get(1);
			return isItemFuel(stack) || SlotFurnaceFuel.isBucket(stack) && countStack.getItem() != Items.BUCKET;
		}
	}

	public int[] getSlotsForFace(EnumFacing side) {

		if (side == EnumFacing.DOWN) {
			return SLOTS_BOTTOM;
		}

		else {
			return side == EnumFacing.UP ? SLOTS_TOP : SLOTS_SIDES;
		}
	}

	/**
	 * Returns true if automation can insert the given item in the given slot from the given side.
	 */
	public boolean canInsertItem(int index, ItemStack stack, EnumFacing direction) {
		return this.isItemValidForSlot(index, stack);
	}

	/**
	 * Returns true if automation can extract the given item in the given slot from the given side.
	 */
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {

		if (direction == EnumFacing.DOWN && index == 1) {
			Item item = stack.getItem();

			if (item != Items.WATER_BUCKET && item != Items.BUCKET) {
				return false;
			}
		}

		return true;
	}

	public String getGuiID() {
		return "minecraft:furnace";
	}

	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		return new ContainerFurnace(playerInventory, this);
	}

	public int getField(int id) {
		switch (id) {
			case 0:
				return this.furnaceBurnTime;
			case 1:
				return this.currentItemBurnTime;
			case 2:
				return this.cookTime;
			case 3:
				return this.totalCookTime;
			default:
				return 0;
		}
	}

	public void setField(int id, int value) {
		switch (id) {
			case 0:
				this.furnaceBurnTime = value;
				break;
			case 1:
				this.currentItemBurnTime = value;
				break;
			case 2:
				this.cookTime = value;
				break;
			case 3:
				this.totalCookTime = value;
		}
	}

	public int getFieldCount() {
		return 4;
	}

	public void clear() {
		this.furnaceItemStacks.clear();
	}

	net.minecraftforge.items.IItemHandler handlerTop = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.UP);
	net.minecraftforge.items.IItemHandler handlerBottom = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.DOWN);
	net.minecraftforge.items.IItemHandler handlerSide = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.WEST);

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getCapability(net.minecraftforge.common.capabilities.Capability<T> capability,
			@javax.annotation.Nullable net.minecraft.util.EnumFacing facing) {
		if (facing != null && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			if (facing == EnumFacing.DOWN)
				return (T) handlerBottom;
			else if (facing == EnumFacing.UP)
				return (T) handlerTop;
			else
				return (T) handlerSide;
		return super.getCapability(capability, facing);
	}
}
