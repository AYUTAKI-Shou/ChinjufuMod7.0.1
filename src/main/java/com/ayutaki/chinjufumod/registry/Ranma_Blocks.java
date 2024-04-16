package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.ranma.Koushi_B;
import com.ayutaki.chinjufumod.blocks.ranma.Noren;
import com.ayutaki.chinjufumod.blocks.ranma.Ranma;
import com.ayutaki.chinjufumod.blocks.ranma.Ranma_noInfo;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Ranma_Blocks {

	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);

	public static Block RANMA_oak = register("block_ranma_oak", ranma());
	public static Block RANMA_spruce = register("block_ranma_spru", ranma());
	public static Block RANMA_birch = register("block_ranma_bir", ranma());
	public static Block RANMA_jungle = register("block_ranma_jun", ranma());
	public static Block RANMA_acacia = register("block_ranma_aca", ranma());
	public static Block RANMA_darkoak = register("block_ranma_doak", ranma());
	public static Block RANMA_sakura = register("block_ranma_saku", ranma());
	public static Block RANMA_kaede = register("block_ranma_kae", ranma());
	public static Block RANMA_ichoh = register("block_ranma_ich", ranma());

	public static Block RANMAB_oak = register("block_ranmab_oak", ranma());
	public static Block RANMAB_spruce = register("block_ranmab_spru", ranma());
	public static Block RANMAB_birch = register("block_ranmab_bir", ranma());
	public static Block RANMAB_jungle = register("block_ranmab_jun", ranma());
	public static Block RANMAB_acacia = register("block_ranmab_aca", ranma());
	public static Block RANMAB_darkoak = register("block_ranmab_doak", ranma());
	public static Block RANMAB_sakura = register("block_ranmab_saku", ranma());
	public static Block RANMAB_kaede = register("block_ranmab_kae", ranma());
	public static Block RANMAB_ichoh = register("block_ranmab_ich", ranma());

	public static Block RANMAC_oak = register("block_ranmac_oak", ranma());
	public static Block RANMAC_spruce = register("block_ranmac_spru", ranma());
	public static Block RANMAC_birch = register("block_ranmac_bir", ranma());
	public static Block RANMAC_jungle = register("block_ranmac_jun", ranma());
	public static Block RANMAC_acacia = register("block_ranmac_aca", ranma());
	public static Block RANMAC_darkoak = register("block_ranmac_doak", ranma());
	public static Block RANMAC_sakura = register("block_ranmac_saku", ranma());
	public static Block RANMAC_kaede = register("block_ranmac_kae", ranma());
	public static Block RANMAC_ichoh = register("block_ranmac_ich", ranma());

	public static Block KANKI_oak = register("block_kanki_oak", ranmaNoInfo());
	public static Block KANKI_spruce = register("block_kanki_spru", ranmaNoInfo());
	public static Block KANKI_birch = register("block_kanki_bir", ranmaNoInfo());
	public static Block KANKI_jungle = register("block_kanki_jun", ranmaNoInfo());
	public static Block KANKI_acacia = register("block_kanki_aca", ranmaNoInfo());
	public static Block KANKI_darkoak = register("block_kanki_doak", ranmaNoInfo());
	public static Block KANKI_sakura = register("block_kanki_saku", ranmaNoInfo());
	public static Block KANKI_kaede = register("block_kanki_kae", ranmaNoInfo());
	public static Block KANKI_ichoh = register("block_kanki_ich", ranmaNoInfo());

	public static Block KOUSHI_oak = register("block_koushi_oak", ranmaNoInfo());
	public static Block KOUSHI_spruce = register("block_koushi_spru", ranmaNoInfo());
	public static Block KOUSHI_birch = register("block_koushi_bir", ranmaNoInfo());
	public static Block KOUSHI_jungle = register("block_koushi_jun", ranmaNoInfo());
	public static Block KOUSHI_acacia = register("block_koushi_aca", ranmaNoInfo());
	public static Block KOUSHI_darkoak = register("block_koushi_doak", ranmaNoInfo());
	public static Block KOUSHI_sakura = register("block_koushi_saku", ranmaNoInfo());
	public static Block KOUSHI_kaede = register("block_koushi_kae", ranmaNoInfo());
	public static Block KOUSHI_ichoh = register("block_koushi_ich", ranmaNoInfo());

	public static Block KOUSHIB_oak = register("block_koushib_oak", koushiBtype());
	public static Block KOUSHIB_spruce = register("block_koushib_spru", koushiBtype());
	public static Block KOUSHIB_birch = register("block_koushib_bir", koushiBtype());
	public static Block KOUSHIB_jungle = register("block_koushib_jun", koushiBtype());
	public static Block KOUSHIB_acacia = register("block_koushib_aca", koushiBtype());
	public static Block KOUSHIB_darkoak = register("block_koushib_doak", koushiBtype());
	public static Block KOUSHIB_sakura = register("block_koushib_saku", koushiBtype());
	public static Block KOUSHIB_kaede = register("block_koushib_kae", koushiBtype());
	public static Block KOUSHIB_ichoh = register("block_koushib_ich", koushiBtype());

	public static Block NOREN_white = register("block_noren_white", noren());
	public static Block NOREN_orange = register("block_noren_orange", noren());
	public static Block NOREN_magenta = register("block_noren_magenta", noren());
	public static Block NOREN_lightb = register("block_noren_lightb", noren());
	public static Block NOREN_yellow = register("block_noren_yellow", noren());
	public static Block NOREN_lime = register("block_noren_lime", noren());
	public static Block NOREN_pink = register("block_noren_pink", noren());
	public static Block NOREN_gray = register("block_noren_gray", noren());
	public static Block NOREN_lightg = register("block_noren_lightg", noren());
	public static Block NOREN_cyan = register("block_noren_cyan", noren());
	public static Block NOREN_purple = register("block_noren_purple", noren());
	public static Block NOREN_blue = register("block_noren_blue", noren());
	public static Block NOREN_brown = register("block_noren_brown", noren());
	public static Block NOREN_green = register("block_noren_green", noren());
	public static Block NOREN_red = register("block_noren_red", noren());
	public static Block NOREN_black = register("block_noren_black", noren());

	/* Share variables */
	private static Ranma ranma() {
		return new Ranma(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid());
	}

	private static Ranma_noInfo ranmaNoInfo() {
		return new Ranma_noInfo(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid());
	}

	private static Koushi_B koushiBtype() {
		return new Koushi_B(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid());
	}

	private static Noren noren() {
		return new Noren(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 1.0F).sound(SoundType.WOOD).notSolid());
	}

	///* Register *///
	private static Block register(String name, Block block) {
		BLOCKS.register(name, () -> block);
		return block;
	}
}
