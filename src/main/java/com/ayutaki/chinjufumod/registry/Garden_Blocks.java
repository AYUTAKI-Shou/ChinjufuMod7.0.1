package com.ayutaki.chinjufumod.registry;

import java.util.function.ToIntFunction;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.garden.Bonsai;
import com.ayutaki.chinjufumod.blocks.garden.Chouzubachi;
import com.ayutaki.chinjufumod.blocks.garden.Ikegaki;
import com.ayutaki.chinjufumod.blocks.garden.IkegakiLong;
import com.ayutaki.chinjufumod.blocks.garden.IronFence;
import com.ayutaki.chinjufumod.blocks.garden.Itabei;
import com.ayutaki.chinjufumod.blocks.garden.Kanyou;
import com.ayutaki.chinjufumod.blocks.garden.Kido;
import com.ayutaki.chinjufumod.blocks.garden.Makibishi;
import com.ayutaki.chinjufumod.blocks.garden.Niwaishi;
import com.ayutaki.chinjufumod.blocks.garden.Niwaishi_slab;
import com.ayutaki.chinjufumod.blocks.garden.Samon;
import com.ayutaki.chinjufumod.blocks.garden.ShishiOdoshi_stage1;
import com.ayutaki.chinjufumod.blocks.garden.ShishiOdoshi_stage2;
import com.ayutaki.chinjufumod.blocks.garden.Sudare;
import com.ayutaki.chinjufumod.blocks.garden.Takeakari;
import com.ayutaki.chinjufumod.blocks.garden.Tourou;
import com.ayutaki.chinjufumod.blocks.garden.TourouLong;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.EntityType;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Garden_Blocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);

	public static Block SUDARE = register("block_sudare_1", new Sudare(AbstractBlock.Properties.of(Material.WOOD).noCollission().strength(1.0F, 1.0F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Garden_Blocks::neverEntity).isSuffocating(Garden_Blocks::never)));

	public static Block SHISHIODOSHI = register("block_shishiodoshi", new ShishiOdoshi_stage1(AbstractBlock.Properties.of(Material.WOOD).strength(1.0F, 3.0F).sound(SoundType.STONE)
			.noOcclusion().isValidSpawn(Garden_Blocks::neverEntity).isSuffocating(Garden_Blocks::never)));
	public static Block SHISHIODOSHI2 = register("block_shishiodoshi2", new ShishiOdoshi_stage2(AbstractBlock.Properties.of(Material.WOOD).strength(1.0F, 3.0F).sound(SoundType.STONE)
			.noOcclusion().isValidSpawn(Garden_Blocks::neverEntity).isSuffocating(Garden_Blocks::never)));

	public static Block CHOUZUBACHI = register("block_chouzubachi_kara", chouzubachi());
	public static Block CHOUZUBACHI_gra = register("block_chouzu_gra_kara", chouzubachi());
	public static Block CHOUZUBACHI_dio = register("block_chouzu_dio_kara", chouzubachi());
	public static Block CHOUZUBACHI_and = register("block_chouzu_and_kara", chouzubachi());

	public static Block ISHITOUROU = register("block_ishitourou_stone", tourou());
	public static Block ISHITOUROU_gra = register("block_ishitourou_gra", tourou());
	public static Block ISHITOUROU_dio = register("block_ishitourou_dio", tourou());
	public static Block ISHITOUROU_and = register("block_ishitourou_and", tourou());

	public static Block LONGTOUROU = register("block_longtourou_stone", tourouLong());
	public static Block LONGTOUROU_gra = register("block_longtourou_gra", tourouLong());
	public static Block LONGTOUROU_dio = register("block_longtourou_dio", tourouLong());
	public static Block LONGTOUROU_and = register("block_longtourou_and", tourouLong());

	public static Block TAKEAKARI = register("block_takeakari", takeakari());
	public static Block TAKEAKARI_Y = register("block_takeakari_y", takeakari());
	public static Block TAKEAKARI_K = register("block_takeakari_k", takeakari());
	
	public static Block BONSAI_oak = register("block_bonsai_oak", bonsai());
	public static Block BONSAI_spru = register("block_bonsai_spruce", bonsai());
	public static Block BONSAI_bir = register("block_bonsai_birch", bonsai());
	public static Block BONSAI_jun = register("block_bonsai_jungle", bonsai());
	public static Block BONSAI_aca = register("block_bonsai_acacia", bonsai());
	public static Block BONSAI_doak = register("block_bonsai_darkoak", bonsai());
	public static Block BONSAI_sakura = register("block_bonsai_sakura", bonsai());
	public static Block BONSAI_kaede = register("block_bonsai_kaede", bonsai());
	public static Block BONSAI_ichoh = register("block_bonsai_ichoh", bonsai());
	public static Block BONSAI_kare = register("block_bonsai_oakkare", bonsai());

	public static Block KANYOU = register("block_kanyouoak_bot", kanyou(MaterialColor.PLANT));
	public static Block KANYOU_spruce = register("block_kanyouspruce_bot", kanyou(MaterialColor.PLANT));
	public static Block KANYOU_birch = register("block_kanyoubirch_bot", kanyou(MaterialColor.PLANT));
	public static Block KANYOU_jungle = register("block_kanyoujungle_bot", kanyou(MaterialColor.PLANT));
	public static Block KANYOU_acacia = register("block_kanyouacacia_bot", kanyou(MaterialColor.PLANT));
	public static Block KANYOU_darkoak = register("block_kanyoudarkoak_bot", kanyou(MaterialColor.PLANT));
	public static Block KANYOU_sakura = register("block_kanyousakura_bot", kanyou(MaterialColor.COLOR_PINK));
	public static Block KANYOU_kaede = register("block_kanyoukaede_bot", kanyou(MaterialColor.COLOR_RED));
	public static Block KANYOU_ichoh = register("block_kanyouichoh_bot", kanyou(MaterialColor.COLOR_YELLOW));
	public static Block KANYOU_kare = register("block_kanyouoakkare_bot", kanyou(MaterialColor.COLOR_BROWN));
	
	public static Block IKEGAKI = register("block_low_oak", ikegaki(MaterialColor.PLANT));
	public static Block IKEGAKI_spruce = register("block_low_spruce", ikegaki(MaterialColor.PLANT));
	public static Block IKEGAKI_birch = register("block_low_birch", ikegaki(MaterialColor.PLANT));
	public static Block IKEGAKI_jungle = register("block_low_jungle", ikegaki(MaterialColor.PLANT));
	public static Block IKEGAKI_acacia = register("block_low_acacia", ikegaki(MaterialColor.PLANT));
	public static Block IKEGAKI_darkoak = register("block_low_darkoak", ikegaki(MaterialColor.PLANT));
	public static Block IKEGAKI_sakura = register("block_low_sakura", ikegaki(MaterialColor.COLOR_PINK));
	public static Block IKEGAKI_kaede = register("block_low_kaede", ikegaki(MaterialColor.COLOR_RED));
	public static Block IKEGAKI_ichoh = register("block_low_ichoh", ikegaki(MaterialColor.COLOR_YELLOW));
	public static Block IKEGAKI_kare = register("block_low_oakkare", ikegaki(MaterialColor.COLOR_BROWN));

	public static Block IKEGAKILONG = register("block_longoak_bot", ikegakiLong(MaterialColor.PLANT));
	public static Block IKEGAKILONG_spruce = register("block_longspruce_bot", ikegakiLong(MaterialColor.PLANT));
	public static Block IKEGAKILONG_birch = register("block_longbirch_bot", ikegakiLong(MaterialColor.PLANT));
	public static Block IKEGAKILONG_jungle = register("block_longjungle_bot", ikegakiLong(MaterialColor.PLANT));
	public static Block IKEGAKILONG_acacia = register("block_longacacia_bot", ikegakiLong(MaterialColor.PLANT));
	public static Block IKEGAKILONG_darkoak = register("block_longdarkoak_bot", ikegakiLong(MaterialColor.PLANT));
	public static Block IKEGAKILONG_sakura = register("block_longsakura_bot", ikegakiLong(MaterialColor.COLOR_PINK));
	public static Block IKEGAKILONG_kaede = register("block_longkaede_bot", ikegakiLong(MaterialColor.COLOR_RED));
	public static Block IKEGAKILONG_ichoh = register("block_longichoh_bot", ikegakiLong(MaterialColor.COLOR_YELLOW));
	public static Block IKEGAKILONG_kare = register("block_longoakkare_bot", ikegakiLong(MaterialColor.COLOR_BROWN));

	public static Block TETSUSAKU_BOT = register("block_ironfence_bot", new IronFence(AbstractBlock.Properties.of(Material.METAL).strength(1.0F, 10.0F).sound(SoundType.METAL)
			.noOcclusion().isValidSpawn(Garden_Blocks::neverEntity).isSuffocating(Garden_Blocks::never)));

	public static Block ITABEI = register("block_itabei", itabei());
	public static Block ITABEI_spruce = register("block_itabei_spruce", itabei());
	public static Block ITABEI_birch = register("block_itabei_birch", itabei());
	public static Block ITABEI_jungle = register("block_itabei_jungle", itabei());
	public static Block ITABEI_acacia = register("block_itabei_acacia", itabei());
	public static Block ITABEI_darkoak = register("block_itabei_darkoak", itabei());
	public static Block ITABEI_sakura = register("block_itabei_sakura", itabei());
	public static Block ITABEI_kaede = register("block_itabei_kaede", itabei());
	public static Block ITABEI_ichoh = register("block_itabei_ichoh", itabei());
	
	public static Block KIDO = register("block_kido", kido());
	public static Block KIDO_spruce = register("block_kido_spruce", kido());
	public static Block KIDO_birch = register("block_kido_birch", kido());
	public static Block KIDO_jungle = register("block_kido_jungle", kido());
	public static Block KIDO_acacia = register("block_kido_acacia", kido());
	public static Block KIDO_darkoak = register("block_kido_darkoak", kido());
	public static Block KIDO_sakura = register("block_kido_sakura", kido());
	public static Block KIDO_kaede = register("block_kido_kaede", kido());
	public static Block KIDO_ichoh = register("block_kido_ichoh", kido());
	
	public static Block SAMON = register("block_samon", samon());
	public static Block SAMON_B = register("block_samon_black", samon());
	public static Block NIWAISHI = register("block_niwaishi", niwaishi());
	public static Block NIWAISHI_gra = register("block_niwaishi_gra", niwaishi());
	public static Block NIWAISHI_dio = register("block_niwaishi_dio", niwaishi());
	public static Block NIWAISHI_and = register("block_niwaishi_and", niwaishi());
	public static Block NIWAISHI_slab = register("block_niwaishi_slab", niwaishi_slab());
	public static Block NIWAISHI_slab_gra = register("block_niwaishi_slab_gra", niwaishi_slab());
	public static Block NIWAISHI_slab_dio = register("block_niwaishi_slab_dio", niwaishi_slab());
	public static Block NIWAISHI_slab_and = register("block_niwaishi_slab_and", niwaishi_slab());
	
	public static Block MAKIBISHI = register("block_makibishi", new Makibishi(AbstractBlock.Properties.of(Material.METAL).strength(1.0F, 1.0F).sound(SoundType.METAL)
			.noCollission().noOcclusion().isValidSpawn(Garden_Blocks::neverEntity).isSuffocating(Garden_Blocks::never)));

	/* Share variables */
	private static ToIntFunction<BlockState> litBlockEmission(int value) {
		return (state) -> { return state.getValue(BlockStateProperties.LIT) ? value : 0; };
	}

	private static ToIntFunction<BlockState> litTourouLong(int value) {
		return (state) -> { return (state.getValue(TourouLong.HALF) == DoubleBlockHalf.UPPER && state.getValue(TourouLong.LIT)) ? value : 0; };
	}

	private static boolean never(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	private static Boolean neverEntity(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> entity) {
		return (boolean)false;
	}

	private static Properties woodStateNever(MaterialColor color) {
		return AbstractBlock.Properties.of(Material.WOOD, color).strength(1.0F, 3.0F).sound(SoundType.WOOD)
				.noOcclusion().isValidSpawn(Garden_Blocks::neverEntity).isSuffocating(Garden_Blocks::never);
	}
	
	private static Properties stoneStateNever() {
		return AbstractBlock.Properties.of(Material.WOOD).strength(1.0F, 6.0F).sound(SoundType.STONE)
				.noOcclusion().isValidSpawn(Garden_Blocks::neverEntity).isSuffocating(Garden_Blocks::never);
	}
	
	private static Chouzubachi chouzubachi() {
		return new Chouzubachi(stoneStateNever().randomTicks());
	}

	private static Tourou tourou() {
		return new Tourou(stoneStateNever().lightLevel(litBlockEmission(15)));
	}

	private static TourouLong tourouLong() {
		return new TourouLong(stoneStateNever().lightLevel(litTourouLong(15)));
	}

	private static Takeakari takeakari() {
		return new Takeakari(AbstractBlock.Properties.of(Material.WOOD).noCollission().strength(1.0F, 1.0F).sound(SoundType.WOOD)
				.noOcclusion().isValidSpawn(Garden_Blocks::neverEntity).isSuffocating(Garden_Blocks::never).lightLevel(litBlockEmission(14)));
	}
	
	private static Bonsai bonsai() {
		return new Bonsai(AbstractBlock.Properties.of(Material.WOOD).noCollission().strength(1.0F, 3.0F).sound(SoundType.STONE)
				.noOcclusion().isValidSpawn(Garden_Blocks::neverEntity).isSuffocating(Garden_Blocks::never));
	}

	private static Kanyou kanyou(MaterialColor color) {
		return new Kanyou(woodStateNever(color));
	}

	private static Ikegaki ikegaki(MaterialColor color) {
		return new Ikegaki(woodStateNever(color));
	}

	private static IkegakiLong ikegakiLong(MaterialColor color) {
		return new IkegakiLong(woodStateNever(color));
	}

	private static Samon samon() {
		return new Samon(AbstractBlock.Properties.of(Material.SAND).strength(1.0F, 3.0F).sound(SoundType.SAND)
				.isValidSpawn(Garden_Blocks::neverEntity));
	}
	
	private static Niwaishi niwaishi() {
		return new Niwaishi(stoneStateNever());
	}

	private static Niwaishi_slab niwaishi_slab() {
		return new Niwaishi_slab(stoneStateNever());
	}

	private static Itabei itabei() {
		return new Itabei(woodStateNever(MaterialColor.WOOD));
	}
	
	private static Kido kido() {
		return new Kido(woodStateNever(MaterialColor.WOOD));
	}
	
	
	///* Register *///
	private static Block register(String name, Block block) {
		BLOCKS.register(name, () -> block);
		return block;
	}
}
