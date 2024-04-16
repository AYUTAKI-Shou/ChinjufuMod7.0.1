package com.ayutaki.chinjufumod.gui;

import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.WorkbenchContainer;
import net.minecraft.util.IWorldPosCallable;

/* バニラの WorkbenchContainer を継承 */
public class KitboardContainer extends WorkbenchContainer {

	private final IWorldPosCallable worldPos;

	public KitboardContainer(int id, PlayerInventory inventory, IWorldPosCallable worldPos, Block workbench) {
		super(id, inventory, worldPos);
		this.worldPos = worldPos;
	}

	/* Determines whether supplied player can use this container */
	public boolean canInteractWith(PlayerEntity playerIn) {
		return isWithinUsableDistance(this.worldPos, playerIn, Kitchen_Blocks.KIT_BOARD);
	}

}
