package com.ayutaki.chinjufumod.state;

import net.minecraft.util.StringRepresentable;

public enum TatamiType implements StringRepresentable {
	
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

	private final String name;

	private TatamiType(String name) { this.name = name; }

	public String toString() { return this.name; }

	public String getSerializedName() { return this.name; }
}
