package com.ayutaki.chinjufumod.state;

import net.minecraft.util.StringRepresentable;

public enum TypeLR implements StringRepresentable {
	
	DEFAULT("default"),
	LEFT("left"),
	RIGHT("right"),
	BOTH("both");

	private final String id;

	TypeLR(String id) { this.id = id; }

	@Override
	public String getSerializedName() { return id; }

	@Override
	public String toString() { return id; }
}
