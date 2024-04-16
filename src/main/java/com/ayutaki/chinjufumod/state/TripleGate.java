package com.ayutaki.chinjufumod.state;

import net.minecraft.util.IStringSerializable;

public enum TripleGate implements IStringSerializable {
	TOP("top"),
	UPPER("upper"),
	LOWER("lower");

	private final String id;

	TripleGate(String id) { this.id = id; }

	@Override
	public String getSerializedName() { return id; }

	@Override
	public String toString() { return id; }
}
