package com.ayutaki.chinjufumod.handler;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.world.biome.IchohBiome;
import com.ayutaki.chinjufumod.world.biome.IchohHillsBiome;
import com.ayutaki.chinjufumod.world.biome.KaedeBiome;
import com.ayutaki.chinjufumod.world.biome.KaedeHillsBiome;
import com.ayutaki.chinjufumod.world.biome.SakuraBiome;
import com.ayutaki.chinjufumod.world.biome.SakuraHillsBiome;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Biomes_CM {

	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, ChinjufuMod.MOD_ID);

	public static final RegistryObject<Biome> SAKURA_FOREST = BIOMES.register("biome_sakura", () -> new SakuraBiome());
	public static final RegistryObject<Biome> SAKURA_HILLS = BIOMES.register("biome_sakurahills", () -> new SakuraHillsBiome());
	public static final RegistryObject<Biome> ACER_FOREST = BIOMES.register("biome_kaede", () -> new KaedeBiome());
	public static final RegistryObject<Biome> ACER_HILLS = BIOMES.register("biome_kaedehills", () -> new KaedeHillsBiome());
	public static final RegistryObject<Biome> GINKGO_FOREST = BIOMES.register("biome_ichoh", () -> new IchohBiome());
	public static final RegistryObject<Biome> GINKGO_HILLS = BIOMES.register("biome_ichohhills", () -> new IchohHillsBiome());

}
