package com.ayutaki.chinjufumod.state;

import net.minecraft.util.IStringSerializable;

public enum TypeLR implements IStringSerializable {
	DEFAULT("default"),
	LEFT("left"),
	RIGHT("right"),
	BOTH("both");

	private final String id;

	TypeLR(String id) { this.id = id; }

	@Override
	public String getName() { return id; }

	@Override
	public String toString() { return id; }
}
