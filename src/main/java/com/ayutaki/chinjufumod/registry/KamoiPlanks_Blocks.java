package com.ayutaki.chinjufumod.registry;

import java.util.function.Supplier;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlanks_Acacia;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlanks_Birch;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlanks_DarkOak;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlanks_Ichoh;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlanks_Jungle;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlanks_Kaede;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlanks_Oak;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlanks_Sakura;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlanks_Spruce;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class KamoiPlanks_Blocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);

	public static final RegistryObject<Block> KAMOI_oak_oak = register("block_ka_oak_oak", () -> kamoiOak());
	public static final RegistryObject<Block> KAMOI_spru_oak = register("block_ka_spru_oak", () -> kamoiOak());
	public static final RegistryObject<Block> KAMOI_bir_oak = register("block_ka_bir_oak", () -> kamoiOak());
	public static final RegistryObject<Block> KAMOI_jun_oak = register("block_ka_jun_oak", () -> kamoiOak());
	public static final RegistryObject<Block> KAMOI_aca_oak = register("block_ka_aca_oak", () -> kamoiOak());
	public static final RegistryObject<Block> KAMOI_doak_oak = register("block_ka_doak_oak", () -> kamoiOak());
	public static final RegistryObject<Block> KAMOI_saku_oak = register("block_ka_saku_oak", () -> kamoiOak());
	public static final RegistryObject<Block> KAMOI_kae_oak = register("block_ka_kae_oak", () -> kamoiOak());
	public static final RegistryObject<Block> KAMOI_ich_oak = register("block_ka_ich_oak", () -> kamoiOak());

	public static final RegistryObject<Block> KAMOI_oak_spru = register("block_ka_oak_spru", () -> kamoiSpruce());
	public static final RegistryObject<Block> KAMOI_spru_spru = register("block_ka_spru_spru", () -> kamoiSpruce());
	public static final RegistryObject<Block> KAMOI_bir_spru = register("block_ka_bir_spru", () -> kamoiSpruce());
	public static final RegistryObject<Block> KAMOI_jun_spru = register("block_ka_jun_spru", () -> kamoiSpruce());
	public static final RegistryObject<Block> KAMOI_aca_spru = register("block_ka_aca_spru", () -> kamoiSpruce());
	public static final RegistryObject<Block> KAMOI_doak_spru = register("block_ka_doak_spru", () -> kamoiSpruce());
	public static final RegistryObject<Block> KAMOI_saku_spru = register("block_ka_saku_spru", () -> kamoiSpruce());
	public static final RegistryObject<Block> KAMOI_kae_spru = register("block_ka_kae_spru", () -> kamoiSpruce());
	public static final RegistryObject<Block> KAMOI_ich_spru = register("block_ka_ich_spru", () -> kamoiSpruce());

	public static final RegistryObject<Block> KAMOI_oak_bir = register("block_ka_oak_bir", () -> kamoiBirch());
	public static final RegistryObject<Block> KAMOI_spru_bir = register("block_ka_spru_bir", () -> kamoiBirch());
	public static final RegistryObject<Block> KAMOI_bir_bir = register("block_ka_bir_bir", () -> kamoiBirch());
	public static final RegistryObject<Block> KAMOI_jun_bir = register("block_ka_jun_bir", () -> kamoiBirch());
	public static final RegistryObject<Block> KAMOI_aca_bir = register("block_ka_aca_bir", () -> kamoiBirch());
	public static final RegistryObject<Block> KAMOI_doak_bir = register("block_ka_doak_bir", () -> kamoiBirch());
	public static final RegistryObject<Block> KAMOI_saku_bir = register("block_ka_saku_bir", () -> kamoiBirch());
	public static final RegistryObject<Block> KAMOI_kae_bir = register("block_ka_kae_bir", () -> kamoiBirch());
	public static final RegistryObject<Block> KAMOI_ich_bir = register("block_ka_ich_bir", () -> kamoiBirch());

	public static final RegistryObject<Block> KAMOI_oak_jun = register("block_ka_oak_jun", () -> kamoiJungle());
	public static final RegistryObject<Block> KAMOI_spru_jun = register("block_ka_spru_jun", () -> kamoiJungle());
	public static final RegistryObject<Block> KAMOI_bir_jun = register("block_ka_bir_jun", () -> kamoiJungle());
	public static final RegistryObject<Block> KAMOI_jun_jun = register("block_ka_jun_jun", () -> kamoiJungle());
	public static final RegistryObject<Block> KAMOI_aca_jun = register("block_ka_aca_jun", () -> kamoiJungle());
	public static final RegistryObject<Block> KAMOI_doak_jun = register("block_ka_doak_jun", () -> kamoiJungle());
	public static final RegistryObject<Block> KAMOI_saku_jun = register("block_ka_saku_jun", () -> kamoiJungle());
	public static final RegistryObject<Block> KAMOI_kae_jun = register("block_ka_kae_jun", () -> kamoiJungle());
	public static final RegistryObject<Block> KAMOI_ich_jun = register("block_ka_ich_jun", () -> kamoiJungle());

	public static final RegistryObject<Block> KAMOI_oak_aca = register("block_ka_oak_aca", () -> kamoiAcacia());
	public static final RegistryObject<Block> KAMOI_spru_aca = register("block_ka_spru_aca", () -> kamoiAcacia());
	public static final RegistryObject<Block> KAMOI_bir_aca = register("block_ka_bir_aca", () -> kamoiAcacia());
	public static final RegistryObject<Block> KAMOI_jun_aca = register("block_ka_jun_aca", () -> kamoiAcacia());
	public static final RegistryObject<Block> KAMOI_aca_aca = register("block_ka_aca_aca", () -> kamoiAcacia());
	public static final RegistryObject<Block> KAMOI_doak_aca = register("block_ka_doak_aca", () -> kamoiAcacia());
	public static final RegistryObject<Block> KAMOI_saku_aca = register("block_ka_saku_aca", () -> kamoiAcacia());
	public static final RegistryObject<Block> KAMOI_kae_aca = register("block_ka_kae_aca", () -> kamoiAcacia());
	public static final RegistryObject<Block> KAMOI_ich_aca = register("block_ka_ich_aca", () -> kamoiAcacia());

	public static final RegistryObject<Block> KAMOI_oak_doak = register("block_ka_oak_doak", () -> kamoiDarkOak());
	public static final RegistryObject<Block> KAMOI_spru_doak = register("block_ka_spru_doak", () -> kamoiDarkOak());
	public static final RegistryObject<Block> KAMOI_bir_doak = register("block_ka_bir_doak", () -> kamoiDarkOak());
	public static final RegistryObject<Block> KAMOI_jun_doak = register("block_ka_jun_doak", () -> kamoiDarkOak());
	public static final RegistryObject<Block> KAMOI_aca_doak = register("block_ka_aca_doak", () -> kamoiDarkOak());
	public static final RegistryObject<Block> KAMOI_doak_doak = register("block_ka_doak_doak", () -> kamoiDarkOak());
	public static final RegistryObject<Block> KAMOI_saku_doak = register("block_ka_saku_doak", () -> kamoiDarkOak());
	public static final RegistryObject<Block> KAMOI_kae_doak = register("block_ka_kae_doak", () -> kamoiDarkOak());
	public static final RegistryObject<Block> KAMOI_ich_doak = register("block_ka_ich_doak", () -> kamoiDarkOak());

	public static final RegistryObject<Block> KAMOI_oak_sakura = register("block_ka_oak_saku", () -> kamoiSakura());
	public static final RegistryObject<Block> KAMOI_spru_sakura = register("block_ka_spru_saku", () -> kamoiSakura());
	public static final RegistryObject<Block> KAMOI_bir_sakura = register("block_ka_bir_saku", () -> kamoiSakura());
	public static final RegistryObject<Block> KAMOI_jun_sakura = register("block_ka_jun_saku", () -> kamoiSakura());
	public static final RegistryObject<Block> KAMOI_aca_sakura = register("block_ka_aca_saku", () -> kamoiSakura());
	public static final RegistryObject<Block> KAMOI_doak_sakura = register("block_ka_doak_saku", () -> kamoiSakura());
	public static final RegistryObject<Block> KAMOI_saku_sakura = register("block_ka_saku_saku", () -> kamoiSakura());
	public static final RegistryObject<Block> KAMOI_kae_sakura = register("block_ka_kae_saku", () -> kamoiSakura());
	public static final RegistryObject<Block> KAMOI_ich_sakura = register("block_ka_ich_saku", () -> kamoiSakura());

	public static final RegistryObject<Block> KAMOI_oak_kaede = register("block_ka_oak_kae", () -> kamoiKaede());
	public static final RegistryObject<Block> KAMOI_spru_kaede = register("block_ka_spru_kae", () -> kamoiKaede());
	public static final RegistryObject<Block> KAMOI_bir_kaede = register("block_ka_bir_kae", () -> kamoiKaede());
	public static final RegistryObject<Block> KAMOI_jun_kaede = register("block_ka_jun_kae", () -> kamoiKaede());
	public static final RegistryObject<Block> KAMOI_aca_kaede = register("block_ka_aca_kae", () -> kamoiKaede());
	public static final RegistryObject<Block> KAMOI_doak_kaede = register("block_ka_doak_kae", () -> kamoiKaede());
	public static final RegistryObject<Block> KAMOI_saku_kaede = register("block_ka_saku_kae", () -> kamoiKaede());
	public static final RegistryObject<Block> KAMOI_kae_kaede = register("block_ka_kae_kae", () -> kamoiKaede());
	public static final RegistryObject<Block> KAMOI_ich_kaede = register("block_ka_ich_kae", () -> kamoiKaede());

	public static final RegistryObject<Block> KAMOI_oak_ichoh = register("block_ka_oak_ich", () -> kamoiIchoh());
	public static final RegistryObject<Block> KAMOI_spru_ichoh = register("block_ka_spru_ich", () -> kamoiIchoh());
	public static final RegistryObject<Block> KAMOI_bir_ichoh = register("block_ka_bir_ich", () -> kamoiIchoh());
	public static final RegistryObject<Block> KAMOI_jun_ichoh = register("block_ka_jun_ich", () -> kamoiIchoh());
	public static final RegistryObject<Block> KAMOI_aca_ichoh = register("block_ka_aca_ich", () -> kamoiIchoh());
	public static final RegistryObject<Block> KAMOI_doak_ichoh = register("block_ka_doak_ich", () -> kamoiIchoh());
	public static final RegistryObject<Block> KAMOI_saku_ichoh = register("block_ka_saku_ich", () -> kamoiIchoh());
	public static final RegistryObject<Block> KAMOI_kae_ichoh = register("block_ka_kae_ich", () -> kamoiIchoh());
	public static final RegistryObject<Block> KAMOI_ich_ichoh = register("block_ka_ich_ich", () -> kamoiIchoh());

	/* Share variables */
	private static Properties woodState() {
		return BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(1.0F, 3.0F).sound(SoundType.WOOD);
	}
	
	private static KamoiPlanks_Oak kamoiOak() {
		return new KamoiPlanks_Oak(woodState());
	}

	private static KamoiPlanks_Spruce kamoiSpruce() {
		return new KamoiPlanks_Spruce(woodState());
	}

	private static KamoiPlanks_Birch kamoiBirch() {
		return new KamoiPlanks_Birch(woodState());
	}

	private static KamoiPlanks_Jungle kamoiJungle() {
		return new KamoiPlanks_Jungle(woodState());
	}

	private static KamoiPlanks_Acacia kamoiAcacia() {
		return new KamoiPlanks_Acacia(woodState());
	}

	private static KamoiPlanks_DarkOak kamoiDarkOak() {
		return new KamoiPlanks_DarkOak(woodState());
	}

	private static KamoiPlanks_Sakura kamoiSakura() {
		return new KamoiPlanks_Sakura(woodState());
	}

	private static KamoiPlanks_Kaede kamoiKaede() {
		return new KamoiPlanks_Kaede(woodState());
	}

	private static KamoiPlanks_Ichoh kamoiIchoh() {
		return new KamoiPlanks_Ichoh(woodState());
	}
	
	
	///* Register *///
	private static RegistryObject<Block> register(String name, Supplier<Block> block) {
		return BLOCKS.register(name, block);
	}
}
