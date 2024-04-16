package com.ayutaki.chinjufumod.gui;

import com.ayutaki.chinjufumod.tileentity.Reizou_TileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ReizouMenu extends Container {

	private final Reizou_TileEntity chestInventory;
	
	public ReizouMenu(InventoryPlayer playerInventory, Reizou_TileEntity tileEntity, EntityPlayer player) {
		this.chestInventory = tileEntity;
		int containerRows = 5;
		tileEntity.openInventory(player);
		int i = (containerRows - 4) * 18;
		
		for(int j = 0; j < containerRows; ++j) {
			for(int k = 0; k < 9; ++k) {
				this.addSlotToContainer(new Slot(chestInventory, k + j * 9, 8 + k * 18, 18 + j * 18));
			}
		}

		for(int l = 0; l < 3; ++l) {
			 for(int j1 = 0; j1 < 9; ++j1) {
				 this.addSlotToContainer(new Slot(playerInventory, j1 + l * 9 + 9, 8 + j1 * 18, 104 + l * 18 + i));
			 }
		 }

		 for(int i1 = 0; i1 < 9; ++i1) {
			 this.addSlotToContainer(new Slot(playerInventory, i1, 8 + i1 * 18, 162 + i));
		 }
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
		ItemStack stack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		int containerRows = 5;
		
		if (slot != null && slot.getHasStack()) {
			ItemStack stack1 = slot.getStack();
			stack = stack1.copy();
			if (index < containerRows * 9) {
				if (!this.mergeItemStack(stack1, containerRows * 9, this.inventorySlots.size(), true)) {
					return ItemStack.EMPTY; }
			} 
			
			else if (!this.mergeItemStack(stack1, 0, containerRows * 9, false)) {
				return ItemStack.EMPTY;
			}

			if (stack1.isEmpty()) { slot.putStack(ItemStack.EMPTY); }
			
			else { slot.onSlotChanged(); }
		}

		return stack;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return this.chestInventory.isUsableByPlayer(playerIn);
	}

	@Override
	public void onContainerClosed(EntityPlayer playerIn) {
		super.onContainerClosed(playerIn);
		this.chestInventory.closeInventory(playerIn);
	}
	
	public IInventory getLowerChestInventory() {
		return this.chestInventory;
	}
}
