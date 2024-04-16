package com.ayutaki.chinjufumod.state;

import net.minecraft.util.IStringSerializable;

public enum SlabHalf implements IStringSerializable {
	TOP("top"),
	BOTTOM("bottom");

	private final String name;
	private SlabHalf(String name) { this.name = name; }
	public String toString() { return this.name; }
	public String getName() { return this.name; }
}
