package com.ayutaki.chinjufumod.gui;

import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.CraftingMenu;

public class KitBoardMenu extends CraftingMenu {

	private final ContainerLevelAccess access;
	@SuppressWarnings("unused")
	private final Player player;
	
	public KitBoardMenu(int id, Inventory playerInventory, ContainerLevelAccess worldPos) {
		super(id, playerInventory, worldPos);
		this.access = worldPos;
		this.player = playerInventory.player;
	}
	
	public boolean stillValid(Player playerIn) {
		return stillValid(this.access, playerIn, Kitchen_Blocks.KIT_BOARD.get());
	}
}
