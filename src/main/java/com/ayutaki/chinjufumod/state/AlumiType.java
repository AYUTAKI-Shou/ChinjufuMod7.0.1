package com.ayutaki.chinjufumod.state;

import net.minecraft.util.IStringSerializable;

public enum AlumiType implements IStringSerializable {
	BOTTOM("bottom"),
	DOUBLE("double");

	private final String name;

	private AlumiType(String name) { this.name = name; }

	public String toString() { return this.name; }

	public String getSerializedName() { return this.name; }
}
