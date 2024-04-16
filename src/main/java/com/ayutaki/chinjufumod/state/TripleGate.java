package com.ayutaki.chinjufumod.state;

import net.minecraft.util.StringRepresentable;

public enum TripleGate implements StringRepresentable {
	
	TOP("top"),
	UPPER("upper"),
	LOWER("lower");

	private final String name;

	private TripleGate(String name) { this.name = name; }

	public String toString() { return this.name; }

	public String getSerializedName() { return this.name; }
}
