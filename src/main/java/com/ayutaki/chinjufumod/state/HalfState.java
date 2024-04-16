package com.ayutaki.chinjufumod.state;

import net.minecraft.util.IStringSerializable;

public enum HalfState implements IStringSerializable {

	UPPER,
	LOWER;

	public String toString() {
		return this.getName();
	}

	public String getName() {
		return this == UPPER ? "upper" : "lower";
	}
}
