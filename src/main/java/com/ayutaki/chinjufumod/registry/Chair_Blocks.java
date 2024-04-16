package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.chair.AdmiralChair;
import com.ayutaki.chinjufumod.blocks.chair.Bench;
import com.ayutaki.chinjufumod.blocks.chair.CafeChair;
import com.ayutaki.chinjufumod.blocks.chair.DiningChair;
import com.ayutaki.chinjufumod.blocks.chair.LogChair;
import com.ayutaki.chinjufumod.blocks.chair.Sofa;
import com.ayutaki.chinjufumod.blocks.chair.Sofa_leather;

import net.minecraft.block.Block;
import net.minecraft.block.Block.Properties;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Chair_Blocks {

	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);

	public static Block ADMIRALCHAIR = register("block_admiralchair", new AdmiralChair(woodState()));
	public static Block ADMIRALCHAIR_red = register("block_admiralchair_red", new AdmiralChair(woodState()));

	public static Block DININGCHAIR = register("block_diningchair", diningChair());
	public static Block DININGCHAIR_spruce = register("block_diningchair_s", diningChair());
	public static Block DININGCHAIR_birch = register("block_diningchair_b", diningChair());
	public static Block DININGCHAIR_jungle = register("block_diningchair_j", diningChair());
	public static Block DININGCHAIR_acacia = register("block_diningchair_a", diningChair());
	public static Block DININGCHAIR_darkoak = register("block_diningchair_d", diningChair());
	public static Block DININGCHAIR_sakura = register("block_diningchair_saku", diningChair());
	public static Block DININGCHAIR_kaede = register("block_diningchair_kae", diningChair());
	public static Block DININGCHAIR_ichoh = register("block_diningchair_ich", diningChair());

	public static Block LOGCHAIR = register("block_logchair", logChair());
	public static Block LOGCHAIR_spruce = register("block_logchair_spruce", logChair());
	public static Block LOGCHAIR_birch = register("block_logchair_birch", logChair());
	public static Block LOGCHAIR_jungle = register("block_logchair_jungle", logChair());
	public static Block LOGCHAIR_acacia = register("block_logchair_acacia", logChair());
	public static Block LOGCHAIR_darkoak = register("block_logchair_darkoak", logChair());
	public static Block LOGCHAIR_sakura = register("block_logchair_sakura", logChair());
	public static Block LOGCHAIR_kaede = register("block_logchair_kaede", logChair());
	public static Block LOGCHAIR_ichoh = register("block_logchair_ichoh", logChair());

	public static Block CAFECHAIR_white = register("block_cafechair_white", cafeChair());
	public static Block CAFECHAIR_orange = register("block_cafechair_orange", cafeChair());
	public static Block CAFECHAIR_magenta = register("block_cafechair_magenta", cafeChair());
	public static Block CAFECHAIR_lightb = register("block_cafechair_lightb", cafeChair());
	public static Block CAFECHAIR_yellow = register("block_cafechair_yellow", cafeChair());
	public static Block CAFECHAIR_lime = register("block_cafechair_lime", cafeChair());
	public static Block CAFECHAIR_pink = register("block_cafechair_pink", cafeChair());
	public static Block CAFECHAIR_gray = register("block_cafechair_gray", cafeChair());
	public static Block CAFECHAIR_lightg = register("block_cafechair_lightg", cafeChair());
	public static Block CAFECHAIR_cyan = register("block_cafechair_cyan", cafeChair());
	public static Block CAFECHAIR_purple = register("block_cafechair_purple", cafeChair());
	public static Block CAFECHAIR_blue = register("block_cafechair_blue", cafeChair());
	public static Block CAFECHAIR_brown = register("block_cafechair_brown", cafeChair());
	public static Block CAFECHAIR_green = register("block_cafechair_green", cafeChair());
	public static Block CAFECHAIR_red = register("block_cafechair_red", cafeChair());
	public static Block CAFECHAIR_black = register("block_cafechair_black", cafeChair());

	public static Block SOFA_leather = register("block_sofa_leather", new Sofa_leather(woodState()));
	public static Block SOFA_white = register("block_sofa_white", sofa());
	public static Block SOFA_orange = register("block_sofa_orange", sofa());
	public static Block SOFA_magenta = register("block_sofa_magenta", sofa());
	public static Block SOFA_lightb = register("block_sofa_lightblue", sofa());
	public static Block SOFA_yellow = register("block_sofa_yellow", sofa());
	public static Block SOFA_lime = register("block_sofa_lime", sofa());
	public static Block SOFA_pink = register("block_sofa_pink", sofa());
	public static Block SOFA_gray = register("block_sofa_gray", sofa());
	public static Block SOFA_lightg = register("block_sofa_lightgray", sofa());
	public static Block SOFA_cyan = register("block_sofa_cyan", sofa());
	public static Block SOFA_purple = register("block_sofa_purple", sofa());
	public static Block SOFA_blue = register("block_sofa_blue", sofa());
	public static Block SOFA_brown = register("block_sofa_brown", sofa());
	public static Block SOFA_green = register("block_sofa_green", sofa());
	public static Block SOFA_red = register("block_sofa_red", sofa());
	public static Block SOFA_black = register("block_sofa_black", sofa());

	public static Block BENCH = register("block_bench", bench());
	public static Block BENCH_spruce = register("block_bench_spru", bench());
	public static Block BENCH_birch = register("block_bench_bir", bench());
	public static Block BENCH_jungle = register("block_bench_jun", bench());
	public static Block BENCH_acacia = register("block_bench_aca", bench());
	public static Block BENCH_darkoak = register("block_bench_doak", bench());
	public static Block BENCH_sakura = register("block_bench_saku", bench());
	public static Block BENCH_kaede = register("block_bench_kae", bench());
	public static Block BENCH_ichoh = register("block_bench_ich", bench());

	/* Share variables */
	private static DiningChair diningChair() {
		return new DiningChair(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid());
	}

	private static LogChair logChair() {
		return new LogChair(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid());
	}

	private static CafeChair cafeChair() {
		return new CafeChair(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid());
	}

	private static Sofa sofa() {
		return new Sofa(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid());
	}

	private static Bench bench() {
		return new Bench(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid());
	}

	private static Properties woodState() {
		return Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid();
	}
	
	///* Register *///
	private static Block register(String name, Block block) {
		BLOCKS.register(name, () -> block);
		return block;
	}
}
/**
* Utility class to help with managing registry entries.
* Maintains a list of all suppliers for entries and registers them during the proper Register event.
* Suppliers should return NEW instances every time.
*
*Example Usage:
*<pre>
* private static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, MODID);
* private static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, MODID);
*
* public static final RegistryObject<Block> ROCK_BLOCK = BLOCKS.register("rock", () -> new Block(Block.Properties.create(Material.ROCK)));
* public static final RegistryObject<Item> ROCK_ITEM = ITEMS.register("rock", () -> new BlockItem(ROCK_BLOCK.get(), new Item.Properties().group(ItemGroup.MISC)));
*
* public ExampleMod() {
* ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
* BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
* }
*</pre>
*
* @param <T> The base registry type, must be a concrete base class, do not use subclasses or wild cards.
*/
