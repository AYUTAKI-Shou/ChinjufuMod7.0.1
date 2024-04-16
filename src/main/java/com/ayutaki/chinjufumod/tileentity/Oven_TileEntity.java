package com.ayutaki.chinjufumod.tileentity;

import com.ayutaki.chinjufumod.handler.TileEntity_CM;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.FurnaceContainer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class Oven_TileEntity extends AbstractOvenTileEntity {

	public Oven_TileEntity() {
		super(TileEntity_CM.KIT_OVEN, IRecipeType.SMELTING);
	}

	protected ITextComponent getDefaultName() {
		return new TranslationTextComponent("container.chinjufumod.kitchen_oven");
	}

	protected Container createMenu(int id, PlayerInventory playerIn) {
		return new FurnaceContainer(id, playerIn, this, this.furnaceData);
	}

}
