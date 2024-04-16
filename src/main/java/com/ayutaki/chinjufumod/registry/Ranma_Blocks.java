package com.ayutaki.chinjufumod.registry;

import java.util.function.Supplier;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.ranma.Koushi_B;
import com.ayutaki.chinjufumod.blocks.ranma.Noren;
import com.ayutaki.chinjufumod.blocks.ranma.Ranma;
import com.ayutaki.chinjufumod.blocks.ranma.Ranma_noInfo;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Ranma_Blocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);

	public static final RegistryObject<Block> RANMA_oak = register("block_ranma_oak", () -> ranma());
	public static final RegistryObject<Block> RANMA_spruce = register("block_ranma_spru", () -> ranma());
	public static final RegistryObject<Block> RANMA_birch = register("block_ranma_bir", () -> ranma());
	public static final RegistryObject<Block> RANMA_jungle = register("block_ranma_jun", () -> ranma());
	public static final RegistryObject<Block> RANMA_acacia = register("block_ranma_aca", () -> ranma());
	public static final RegistryObject<Block> RANMA_darkoak = register("block_ranma_doak", () -> ranma());
	public static final RegistryObject<Block> RANMA_sakura = register("block_ranma_saku", () -> ranma());
	public static final RegistryObject<Block> RANMA_kaede = register("block_ranma_kae", () -> ranma());
	public static final RegistryObject<Block> RANMA_ichoh = register("block_ranma_ich", () -> ranma());

	public static final RegistryObject<Block> RANMAB_oak = register("block_ranmab_oak", () -> ranma());
	public static final RegistryObject<Block> RANMAB_spruce = register("block_ranmab_spru", () -> ranma());
	public static final RegistryObject<Block> RANMAB_birch = register("block_ranmab_bir", () -> ranma());
	public static final RegistryObject<Block> RANMAB_jungle = register("block_ranmab_jun", () -> ranma());
	public static final RegistryObject<Block> RANMAB_acacia = register("block_ranmab_aca", () -> ranma());
	public static final RegistryObject<Block> RANMAB_darkoak = register("block_ranmab_doak", () -> ranma());
	public static final RegistryObject<Block> RANMAB_sakura = register("block_ranmab_saku", () -> ranma());
	public static final RegistryObject<Block> RANMAB_kaede = register("block_ranmab_kae", () -> ranma());
	public static final RegistryObject<Block> RANMAB_ichoh = register("block_ranmab_ich", () -> ranma());

	public static final RegistryObject<Block> RANMAC_oak = register("block_ranmac_oak", () -> ranma());
	public static final RegistryObject<Block> RANMAC_spruce = register("block_ranmac_spru", () -> ranma());
	public static final RegistryObject<Block> RANMAC_birch = register("block_ranmac_bir", () -> ranma());
	public static final RegistryObject<Block> RANMAC_jungle = register("block_ranmac_jun", () -> ranma());
	public static final RegistryObject<Block> RANMAC_acacia = register("block_ranmac_aca", () -> ranma());
	public static final RegistryObject<Block> RANMAC_darkoak = register("block_ranmac_doak", () -> ranma());
	public static final RegistryObject<Block> RANMAC_sakura = register("block_ranmac_saku", () -> ranma());
	public static final RegistryObject<Block> RANMAC_kaede = register("block_ranmac_kae", () -> ranma());
	public static final RegistryObject<Block> RANMAC_ichoh = register("block_ranmac_ich", () -> ranma());

	public static final RegistryObject<Block> KANKI_oak = register("block_kanki_oak", () -> ranmaNoInfo());
	public static final RegistryObject<Block> KANKI_spruce = register("block_kanki_spru", () -> ranmaNoInfo());
	public static final RegistryObject<Block> KANKI_birch = register("block_kanki_bir", () -> ranmaNoInfo());
	public static final RegistryObject<Block> KANKI_jungle = register("block_kanki_jun", () -> ranmaNoInfo());
	public static final RegistryObject<Block> KANKI_acacia = register("block_kanki_aca", () -> ranmaNoInfo());
	public static final RegistryObject<Block> KANKI_darkoak = register("block_kanki_doak", () -> ranmaNoInfo());
	public static final RegistryObject<Block> KANKI_sakura = register("block_kanki_saku", () -> ranmaNoInfo());
	public static final RegistryObject<Block> KANKI_kaede = register("block_kanki_kae", () -> ranmaNoInfo());
	public static final RegistryObject<Block> KANKI_ichoh = register("block_kanki_ich", () -> ranmaNoInfo());

	public static final RegistryObject<Block> KOUSHI_oak = register("block_koushi_oak", () -> ranmaNoInfo());
	public static final RegistryObject<Block> KOUSHI_spruce = register("block_koushi_spru", () -> ranmaNoInfo());
	public static final RegistryObject<Block> KOUSHI_birch = register("block_koushi_bir", () -> ranmaNoInfo());
	public static final RegistryObject<Block> KOUSHI_jungle = register("block_koushi_jun", () -> ranmaNoInfo());
	public static final RegistryObject<Block> KOUSHI_acacia = register("block_koushi_aca", () -> ranmaNoInfo());
	public static final RegistryObject<Block> KOUSHI_darkoak = register("block_koushi_doak", () -> ranmaNoInfo());
	public static final RegistryObject<Block> KOUSHI_sakura = register("block_koushi_saku", () -> ranmaNoInfo());
	public static final RegistryObject<Block> KOUSHI_kaede = register("block_koushi_kae", () -> ranmaNoInfo());
	public static final RegistryObject<Block> KOUSHI_ichoh = register("block_koushi_ich", () -> ranmaNoInfo());

	public static final RegistryObject<Block> KOUSHIB_oak = register("block_koushib_oak", () -> koushiBtype());
	public static final RegistryObject<Block> KOUSHIB_spruce = register("block_koushib_spru", () -> koushiBtype());
	public static final RegistryObject<Block> KOUSHIB_birch = register("block_koushib_bir", () -> koushiBtype());
	public static final RegistryObject<Block> KOUSHIB_jungle = register("block_koushib_jun", () -> koushiBtype());
	public static final RegistryObject<Block> KOUSHIB_acacia = register("block_koushib_aca", () -> koushiBtype());
	public static final RegistryObject<Block> KOUSHIB_darkoak = register("block_koushib_doak", () -> koushiBtype());
	public static final RegistryObject<Block> KOUSHIB_sakura = register("block_koushib_saku", () -> koushiBtype());
	public static final RegistryObject<Block> KOUSHIB_kaede = register("block_koushib_kae", () -> koushiBtype());
	public static final RegistryObject<Block> KOUSHIB_ichoh = register("block_koushib_ich", () -> koushiBtype());

	public static final RegistryObject<Block> NOREN_white = register("block_noren_white", () -> noren());
	public static final RegistryObject<Block> NOREN_orange = register("block_noren_orange", () -> noren());
	public static final RegistryObject<Block> NOREN_magenta = register("block_noren_magenta", () -> noren());
	public static final RegistryObject<Block> NOREN_lightb = register("block_noren_lightb", () -> noren());
	public static final RegistryObject<Block> NOREN_yellow = register("block_noren_yellow", () -> noren());
	public static final RegistryObject<Block> NOREN_lime = register("block_noren_lime", () -> noren());
	public static final RegistryObject<Block> NOREN_pink = register("block_noren_pink", () -> noren());
	public static final RegistryObject<Block> NOREN_gray = register("block_noren_gray", () -> noren());
	public static final RegistryObject<Block> NOREN_lightg = register("block_noren_lightg", () -> noren());
	public static final RegistryObject<Block> NOREN_cyan = register("block_noren_cyan", () -> noren());
	public static final RegistryObject<Block> NOREN_purple = register("block_noren_purple", () -> noren());
	public static final RegistryObject<Block> NOREN_blue = register("block_noren_blue", () -> noren());
	public static final RegistryObject<Block> NOREN_brown = register("block_noren_brown", () -> noren());
	public static final RegistryObject<Block> NOREN_green = register("block_noren_green", () -> noren());
	public static final RegistryObject<Block> NOREN_red = register("block_noren_red", () -> noren());
	public static final RegistryObject<Block> NOREN_black = register("block_noren_black", () -> noren());
	
	
	/* Share variables */
	private static boolean never(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return false;
	}

	private static Boolean neverEntity(BlockState state, BlockGetter worldIn, BlockPos pos, EntityType<?> entity) {
		return (boolean)false;
	}
	
	private static Properties woodStateNever() {
		return BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(1.0F, 3.0F).sound(SoundType.WOOD)
				.noOcclusion().isValidSpawn(Ranma_Blocks::neverEntity).isSuffocating(Ranma_Blocks::never);
	}
	
	private static Ranma ranma() {
		return new Ranma(woodStateNever());
	}

	private static Ranma_noInfo ranmaNoInfo() {
		return new Ranma_noInfo(woodStateNever());
	}

	private static Koushi_B koushiBtype() {
		return new Koushi_B(woodStateNever());
	}

	private static Noren noren() {
		return new Noren(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(1.0F, 1.0F).sound(SoundType.WOOD)
				.noOcclusion().isValidSpawn(Ranma_Blocks::neverEntity).isSuffocating(Ranma_Blocks::never));
	}
	
	
	///* Register *///
	private static RegistryObject<Block> register(String name, Supplier<Block> block) {
		return BLOCKS.register(name, block);
	}
}
