package com.ayutaki.chinjufumod.gui;

import java.util.Objects;

import com.ayutaki.chinjufumod.handler.MenuTypes_CM;
import com.ayutaki.chinjufumod.tileentity.Reizou_TileEntity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;

public class ReizouMenu extends Container {

	private final IInventory container;
	
	public ReizouMenu(int windowId, PlayerInventory inventory, PacketBuffer data) {
		this(MenuTypes_CM.TANSU_MENU.get(), windowId, inventory, getContainer(inventory, data));
	}
	
	public ReizouMenu(ContainerType<?> type, int windowId, final PlayerInventory inventory, final IInventory container) {
		super(type, windowId);
		this.container = container;
		int containerRows = 5;
		this.container.startOpen(inventory.player);
		int i = (containerRows - 4) * 18;

		for(int j = 0; j < containerRows; ++j) {
			for(int k = 0; k < 9; ++k) {
				this.addSlot(new Slot(container, k + j * 9, 8 + k * 18, 18 + j * 18));
			}
		}

		for(int l = 0; l < 3; ++l) {
			 for(int j1 = 0; j1 < 9; ++j1) {
				 this.addSlot(new Slot(inventory, j1 + l * 9 + 9, 8 + j1 * 18, 104 + l * 18 + i));
			 }
		 }

		 for(int i1 = 0; i1 < 9; ++i1) {
			 this.addSlot(new Slot(inventory, i1, 8 + i1 * 18, 162 + i));
		 }
	}

	private static Reizou_TileEntity getContainer(final PlayerInventory inventory, final PacketBuffer data) {
		Objects.requireNonNull(inventory, "inventory cannot be null");
		Objects.requireNonNull(data, "data cannot be null");
		final TileEntity tileAtPos = inventory.player.level.getBlockEntity(data.readBlockPos());
		if(tileAtPos instanceof Reizou_TileEntity) {
			return (Reizou_TileEntity) tileAtPos;
		}
		throw new IllegalStateException("Tile entity is not correct! " + tileAtPos);
	}
	
	@Override
	public ItemStack quickMoveStack(PlayerEntity playerIn, int index) {
		ItemStack stack = ItemStack.EMPTY;
		Slot slot = this.slots.get(index);
		int containerRows = 5;
		
		if (slot != null && slot.hasItem()) {
			ItemStack stack1 = slot.getItem();
			stack = stack1.copy();
			if (index < containerRows * 9) {
				if (!this.moveItemStackTo(stack1, containerRows * 9, this.slots.size(), true)) {
					return ItemStack.EMPTY; }
			} 
			
			else if (!this.moveItemStackTo(stack1, 0, containerRows * 9, false)) {
				return ItemStack.EMPTY;
			}

			if (stack1.isEmpty()) { slot.set(ItemStack.EMPTY); }
			
			else { slot.setChanged(); }
		}

		return stack;
	}
	
	@Override
	public boolean stillValid(PlayerEntity playerIn) {
		return this.container.stillValid(playerIn);
	}

	@Override
	public void removed(PlayerEntity playerIn) {
		super.removed(playerIn);
		this.container.stopOpen(playerIn);
	}
	
	public IInventory getContainer() {
		return this.container;
	}
}
