package com.ayutaki.chinjufumod.handler;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.world.biome.BiomeMaker_CM;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Biomes_CM {

	public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, ChinjufuMod.MOD_ID);

	public static final RegistryObject<Biome> SAKURA_FOREST = BIOMES.register("biome_sakura", BiomeMaker_CM::makeSakuraBiome);
	public static final RegistryObject<Biome> SAKURA_HILLS = BIOMES.register("biome_sakurahills", BiomeMaker_CM::makeSakuraHills);
	public static final RegistryObject<Biome> ACER_FOREST = BIOMES.register("biome_kaede", BiomeMaker_CM::makeKaedeBiome);
	public static final RegistryObject<Biome> ACER_HILLS = BIOMES.register("biome_kaedehills", BiomeMaker_CM::makeKaedeHills);
	public static final RegistryObject<Biome> GINKGO_FOREST = BIOMES.register("biome_ichoh", BiomeMaker_CM::makeIchohBiome);
	public static final RegistryObject<Biome> GINKGO_HILLS = BIOMES.register("biome_ichohhills", BiomeMaker_CM::makeIchohHills);

}
