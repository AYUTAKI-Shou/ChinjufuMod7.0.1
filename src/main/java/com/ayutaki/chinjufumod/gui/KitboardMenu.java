package com.ayutaki.chinjufumod.gui;

import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.WorkbenchContainer;
import net.minecraft.util.IWorldPosCallable;

/* バニラの WorkbenchContainer を継承 */
public class KitboardMenu extends WorkbenchContainer {

	private final IWorldPosCallable access;
	@SuppressWarnings("unused")
	private final PlayerEntity playerIn;

	public KitboardMenu(int id, PlayerInventory inventory, IWorldPosCallable worldPos) {
		super(id, inventory, worldPos);
		this.access = worldPos;
		this.playerIn = inventory.player;
	}

	/* Determines whether supplied player can use this container */
	public boolean stillValid(PlayerEntity playerIn) {
		return stillValid(this.access, playerIn, Kitchen_Blocks.KIT_BOARD);
	}

}
