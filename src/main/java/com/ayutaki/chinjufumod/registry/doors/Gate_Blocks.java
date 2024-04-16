package com.ayutaki.chinjufumod.registry.doors;

import com.ayutaki.chinjufumod.blocks.gate.IronGate_1;
import com.ayutaki.chinjufumod.blocks.gate.IronGate_2;
import com.ayutaki.chinjufumod.blocks.gate.GrillGate_1;
import com.ayutaki.chinjufumod.blocks.gate.GrillGate_2;
import com.ayutaki.chinjufumod.blocks.gate.WoodenGate_1;
import com.ayutaki.chinjufumod.blocks.gate.WoodenGate_2;

import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public final class Gate_Blocks {

	public static WoodenGate_1 GATE_SPRUCE;
	public static WoodenGate_2 GATE_SPRUCE2;
	public static WoodenGate_1 GATE_SPRUCE_B;
	public static WoodenGate_2 GATE_SPRUCE_B2;
	
	public static IronGate_1 GATE_IRON;
	public static IronGate_2 GATE_IRON2;
	public static GrillGate_1 GATE_IRONGRILL;
	public static GrillGate_2 GATE_IRONGRILL2;

	/* -> main preinit() クラスを走らせて登録 */
	public static void load(FMLPreInitializationEvent event) {
		GATE_SPRUCE = new WoodenGate_1(Material.WOOD, "block_gate_spruce");
		GATE_SPRUCE2 = new WoodenGate_2(Material.WOOD, "block_gate_spruce2");
		GATE_SPRUCE_B = new WoodenGate_1(Material.WOOD, "block_gate_spruce_b");
		GATE_SPRUCE_B2 = new WoodenGate_2(Material.WOOD, "block_gate_spruce_b2");
		
		GATE_IRON = new IronGate_1(Material.WOOD, "block_gate_iron");
		GATE_IRON2 = new IronGate_2(Material.WOOD, "block_gate_iron2");
		GATE_IRONGRILL = new GrillGate_1(Material.WOOD, "block_gate_irongrill");
		GATE_IRONGRILL2 = new GrillGate_2(Material.WOOD, "block_gate_irongrill2");
	}
}
