package com.ayutaki.chinjufumod.registry.doors;

import com.ayutaki.chinjufumod.blocks.bamboo.BambooFenceGate;
import com.ayutaki.chinjufumod.blocks.garden.Kido;
import com.ayutaki.chinjufumod.blocks.gate.Door_CM;
import com.ayutaki.chinjufumod.blocks.wood.FenceGate_CM;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public final class Door_Blocks {

	public static Door_CM DOOR_SAKURA;
	public static Door_CM DOOR_KAEDE;
	public static Door_CM DOOR_ICHOH;

	public static FenceGate_CM SAKURA_FGATE;
	public static FenceGate_CM KAEDE_FGATE;
	public static FenceGate_CM ICHOH_FGATE;

	public static BambooFenceGate TAKEFENCEGATE;
	public static BambooFenceGate TAKEFENCEGATE_Y;
	public static BambooFenceGate TAKEFENCEGATE_K;

	public static Door_CM TAKEDOOR;
	public static Door_CM TAKEDOOR_Y;
	public static Door_CM TAKEDOOR_K;

	public static Kido KIDO;
	public static Kido KIDO_spruce;
	public static Kido KIDO_birch;
	public static Kido KIDO_jungle;
	public static Kido KIDO_acacia;
	public static Kido KIDO_darkoak;
	public static Kido KIDO_sakura;
	public static Kido KIDO_kaede;
	public static Kido KIDO_ichoh;

	/* -> main preinit() クラスを走らせて登録 */
	public static void load(FMLPreInitializationEvent event) {

		DOOR_SAKURA = new Door_CM("block_door_sakura");
		DOOR_KAEDE = new Door_CM("block_door_kaede");
		DOOR_ICHOH = new Door_CM("block_door_ichoh");

		SAKURA_FGATE = new FenceGate_CM("block_fencegate_sakura");
		KAEDE_FGATE = new FenceGate_CM("block_fencegate_kaede");
		ICHOH_FGATE = new FenceGate_CM("block_fencegate_ichoh");

		TAKEFENCEGATE = new BambooFenceGate("block_bamboo_fencegate");
		TAKEFENCEGATE_Y = new BambooFenceGate("block_bamboo_y_fencegate");
		TAKEFENCEGATE_K = new BambooFenceGate("block_bamboo_k_fencegate");

		TAKEDOOR = new Door_CM("block_bamboo_door");
		TAKEDOOR_Y = new Door_CM("block_bamboo_y_door");
		TAKEDOOR_K = new Door_CM("block_bamboo_k_door");
		
		KIDO = new Kido("block_kido");
		KIDO_spruce = new Kido("block_kido_spruce");
		KIDO_birch = new Kido("block_kido_birch");
		KIDO_jungle = new Kido("block_kido_jungle");
		KIDO_acacia = new Kido("block_kido_acacia");
		KIDO_darkoak = new Kido("block_kido_darkoak");
		KIDO_sakura = new Kido("block_kido_sakura");
		KIDO_kaede = new Kido("block_kido_kaede");
		KIDO_ichoh = new Kido("block_kido_ichoh");
	}
}
