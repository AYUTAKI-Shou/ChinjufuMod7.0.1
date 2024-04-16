package com.ayutaki.chinjufumod.state;

import net.minecraft.util.IStringSerializable;

public enum TatamiType implements IStringSerializable {
	TOP("top"),
	BOTTOM("bottom"),
	DOUBLE("double"),
	
	OAK("oak"),
	SPRUCE("spruce"),
	BIRCH("birch"),
	JUNGLE("jungle"),
	ACACIA("acacia"),
	DARKOAK("darkoak"),
	SAKURA("sakura"),
	KAEDE("kaede"),
	ICHOH("ichoh");

	private final String id;

	TatamiType(String id) { this.id = id; }

	@Override
	public String getSerializedName() { return id; }

	@Override
	public String toString() { return id; }
}
