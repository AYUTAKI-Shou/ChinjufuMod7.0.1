package com.ayutaki.chinjufumod.registry;

import java.util.function.Supplier;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.chair.AdmiralChair;
import com.ayutaki.chinjufumod.blocks.chair.Bench;
import com.ayutaki.chinjufumod.blocks.chair.CafeChair;
import com.ayutaki.chinjufumod.blocks.chair.DiningChair;
import com.ayutaki.chinjufumod.blocks.chair.LogChair;
import com.ayutaki.chinjufumod.blocks.chair.Sofa;
import com.ayutaki.chinjufumod.blocks.chair.Sofa_leather;

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

public class Chair_Blocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);
	
	public static final RegistryObject<Block> ADMIRALCHAIR = register("block_admiralchair", () -> new AdmiralChair(woodState()));
	public static final RegistryObject<Block> ADMIRALCHAIR_red = register("block_admiralchair_red", () -> new AdmiralChair(woodState()));
	
	public static final RegistryObject<Block> DININGCHAIR = register("block_diningchair", () -> diningChair());
	public static final RegistryObject<Block> DININGCHAIR_spruce = register("block_diningchair_s", () -> diningChair());
	public static final RegistryObject<Block> DININGCHAIR_birch = register("block_diningchair_b", () -> diningChair());
	public static final RegistryObject<Block> DININGCHAIR_jungle = register("block_diningchair_j", () -> diningChair());
	public static final RegistryObject<Block> DININGCHAIR_acacia = register("block_diningchair_a", () -> diningChair());
	public static final RegistryObject<Block> DININGCHAIR_darkoak = register("block_diningchair_d", () -> diningChair());
	public static final RegistryObject<Block> DININGCHAIR_sakura = register("block_diningchair_saku", () -> diningChair());
	public static final RegistryObject<Block> DININGCHAIR_kaede = register("block_diningchair_kae", () -> diningChair());
	public static final RegistryObject<Block> DININGCHAIR_ichoh = register("block_diningchair_ich", () -> diningChair());

	public static final RegistryObject<Block> LOGCHAIR = register("block_logchair", () -> logChair());
	public static final RegistryObject<Block> LOGCHAIR_spruce = register("block_logchair_spruce", () -> logChair());
	public static final RegistryObject<Block> LOGCHAIR_birch = register("block_logchair_birch", () -> logChair());
	public static final RegistryObject<Block> LOGCHAIR_jungle = register("block_logchair_jungle", () -> logChair());
	public static final RegistryObject<Block> LOGCHAIR_acacia = register("block_logchair_acacia", () -> logChair());
	public static final RegistryObject<Block> LOGCHAIR_darkoak = register("block_logchair_darkoak", () -> logChair());
	public static final RegistryObject<Block> LOGCHAIR_sakura = register("block_logchair_sakura", () -> logChair());
	public static final RegistryObject<Block> LOGCHAIR_kaede = register("block_logchair_kaede", () -> logChair());
	public static final RegistryObject<Block> LOGCHAIR_ichoh = register("block_logchair_ichoh", () -> logChair());

	public static final RegistryObject<Block> CAFECHAIR_white = register("block_cafechair_white", () -> cafeChair());
	public static final RegistryObject<Block> CAFECHAIR_orange = register("block_cafechair_orange", () -> cafeChair());
	public static final RegistryObject<Block> CAFECHAIR_magenta = register("block_cafechair_magenta", () -> cafeChair());
	public static final RegistryObject<Block> CAFECHAIR_lightb = register("block_cafechair_lightb", () -> cafeChair());
	public static final RegistryObject<Block> CAFECHAIR_yellow = register("block_cafechair_yellow", () -> cafeChair());
	public static final RegistryObject<Block> CAFECHAIR_lime = register("block_cafechair_lime", () -> cafeChair());
	public static final RegistryObject<Block> CAFECHAIR_pink = register("block_cafechair_pink", () -> cafeChair());
	public static final RegistryObject<Block> CAFECHAIR_gray = register("block_cafechair_gray", () -> cafeChair());
	public static final RegistryObject<Block> CAFECHAIR_lightg = register("block_cafechair_lightg", () -> cafeChair());
	public static final RegistryObject<Block> CAFECHAIR_cyan = register("block_cafechair_cyan", () -> cafeChair());
	public static final RegistryObject<Block> CAFECHAIR_purple = register("block_cafechair_purple", () -> cafeChair());
	public static final RegistryObject<Block> CAFECHAIR_blue = register("block_cafechair_blue", () -> cafeChair());
	public static final RegistryObject<Block> CAFECHAIR_brown = register("block_cafechair_brown", () -> cafeChair());
	public static final RegistryObject<Block> CAFECHAIR_green = register("block_cafechair_green", () -> cafeChair());
	public static final RegistryObject<Block> CAFECHAIR_red = register("block_cafechair_red", () -> cafeChair());
	public static final RegistryObject<Block> CAFECHAIR_black = register("block_cafechair_black", () -> cafeChair());

	public static final RegistryObject<Block> SOFA_leather = register("block_sofa_leather", () -> new Sofa_leather(woodState()));
	public static final RegistryObject<Block> SOFA_white = register("block_sofa_white", () -> sofa());
	public static final RegistryObject<Block> SOFA_orange = register("block_sofa_orange", () -> sofa());
	public static final RegistryObject<Block> SOFA_magenta = register("block_sofa_magenta", () -> sofa());
	public static final RegistryObject<Block> SOFA_lightb = register("block_sofa_lightblue", () -> sofa());
	public static final RegistryObject<Block> SOFA_yellow = register("block_sofa_yellow", () -> sofa());
	public static final RegistryObject<Block> SOFA_lime = register("block_sofa_lime", () -> sofa());
	public static final RegistryObject<Block> SOFA_pink = register("block_sofa_pink", () -> sofa());
	public static final RegistryObject<Block> SOFA_gray = register("block_sofa_gray", () -> sofa());
	public static final RegistryObject<Block> SOFA_lightg = register("block_sofa_lightgray", () -> sofa());
	public static final RegistryObject<Block> SOFA_cyan = register("block_sofa_cyan", () -> sofa());
	public static final RegistryObject<Block> SOFA_purple = register("block_sofa_purple", () -> sofa());
	public static final RegistryObject<Block> SOFA_blue = register("block_sofa_blue", () -> sofa());
	public static final RegistryObject<Block> SOFA_brown = register("block_sofa_brown", () -> sofa());
	public static final RegistryObject<Block> SOFA_green = register("block_sofa_green", () -> sofa());
	public static final RegistryObject<Block> SOFA_red = register("block_sofa_red", () -> sofa());
	public static final RegistryObject<Block> SOFA_black = register("block_sofa_black", () -> sofa());

	public static final RegistryObject<Block> BENCH = register("block_bench", () -> bench());
	public static final RegistryObject<Block> BENCH_spruce = register("block_bench_spru", () -> bench());
	public static final RegistryObject<Block> BENCH_birch = register("block_bench_bir", () -> bench());
	public static final RegistryObject<Block> BENCH_jungle = register("block_bench_jun", () -> bench());
	public static final RegistryObject<Block> BENCH_acacia = register("block_bench_aca", () -> bench());
	public static final RegistryObject<Block> BENCH_darkoak = register("block_bench_doak", () -> bench());
	public static final RegistryObject<Block> BENCH_sakura = register("block_bench_saku", () -> bench());
	public static final RegistryObject<Block> BENCH_kaede = register("block_bench_kae", () -> bench());
	public static final RegistryObject<Block> BENCH_ichoh = register("block_bench_ich", () -> bench());
	
	
	/* Share variables */
	private static boolean never(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return false;
	}

	private static Boolean neverEntity(BlockState state, BlockGetter worldIn, BlockPos pos, EntityType<?> entity) {
		return (boolean)false;
	}

	private static Properties woodState() {
		return BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(1.0F, 3.0F).sound(SoundType.WOOD).noOcclusion()
				.isValidSpawn(Chair_Blocks::neverEntity).isSuffocating(Chair_Blocks::never);
	}
	
	private static DiningChair diningChair() {
		return new DiningChair(woodState());
	}

	private static LogChair logChair() {
		return new LogChair(woodState());
	}

	private static CafeChair cafeChair() {
		return new CafeChair(woodState());
	}

	private static Sofa sofa() {
		return new Sofa(woodState());
	}

	private static Bench bench() {
		return new Bench(woodState());
	}
	
	
	///* Register *///
	private static RegistryObject<Block> register(String name, Supplier<Block> block) {
		return BLOCKS.register(name, block);
	}
}
