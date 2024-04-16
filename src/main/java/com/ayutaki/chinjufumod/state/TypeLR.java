package com.ayutaki.chinjufumod.state;

import net.minecraft.util.IStringSerializable;

public enum TypeLR implements IStringSerializable {
	DEFAULT("default"),
	LEFT("left"),
	RIGHT("right"),
	BOTH("both");

	private final String name;
	TypeLR(String id) { this.name = id; }
	public String getName() { return this.name; }
}
