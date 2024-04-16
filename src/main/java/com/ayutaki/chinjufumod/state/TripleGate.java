package com.ayutaki.chinjufumod.state;

import net.minecraft.util.IStringSerializable;

public enum TripleGate implements IStringSerializable {
	TOP("top"),
	UPPER("upper"),
	LOWER("lower");

	private final String name;

	private TripleGate(String name) { this.name = name; }

	public String toString() { return this.name; }

	public String getName() { return this.name; }
}
