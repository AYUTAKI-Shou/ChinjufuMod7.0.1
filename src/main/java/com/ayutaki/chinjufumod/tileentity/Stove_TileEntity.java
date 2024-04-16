package com.ayutaki.chinjufumod.tileentity;

import com.ayutaki.chinjufumod.handler.BlockEntity_CM;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.FurnaceMenu;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.state.BlockState;

public class Stove_TileEntity extends AbstractStoveTileEntity {
	
	public Stove_TileEntity(BlockPos pos, BlockState state) {
		super(BlockEntity_CM.C_STOVE.get(), pos, state, RecipeType.SMELTING);
	}

	protected Component getDefaultName() {
		return Component.translatable("container.furnace");
	}

	protected AbstractContainerMenu createMenu(int id, Inventory inventory) {
		return new FurnaceMenu(id, inventory, this, this.dataAccess);
	}
}
