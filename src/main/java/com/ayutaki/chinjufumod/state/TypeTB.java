package com.ayutaki.chinjufumod.state;

import net.minecraft.util.IStringSerializable;

public enum TypeTB implements IStringSerializable {
	TOP,
	BOTTOM;

	public String toString() { return this.getName(); }
	public String getName() { return this == TOP ? "top" : "bottom"; }
}
