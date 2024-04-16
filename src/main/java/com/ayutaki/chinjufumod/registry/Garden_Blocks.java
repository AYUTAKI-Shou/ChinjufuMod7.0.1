package com.ayutaki.chinjufumod.registry;

import java.util.function.Supplier;
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

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Garden_Blocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);
	
	public static final RegistryObject<Block> SUDARE = register("block_sudare_1", 
			() -> new Sudare(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).noCollission().strength(1.0F, 1.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(Garden_Blocks::neverEntity).isSuffocating(Garden_Blocks::never)));

	public static final RegistryObject<Block> SHISHIODOSHI = register("block_shishiodoshi", 
			() -> new ShishiOdoshi_stage1(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(1.0F, 3.0F).sound(SoundType.STONE).noOcclusion().isValidSpawn(Garden_Blocks::neverEntity).isSuffocating(Garden_Blocks::never)));
	public static final RegistryObject<Block> SHISHIODOSHI2 = register("block_shishiodoshi2", 
			() -> new ShishiOdoshi_stage2(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(1.0F, 3.0F).sound(SoundType.STONE).noOcclusion().isValidSpawn(Garden_Blocks::neverEntity).isSuffocating(Garden_Blocks::never)));

	public static final RegistryObject<Block> CHOUZUBACHI = register("block_chouzubachi_kara", () -> chouzubachi());
	public static final RegistryObject<Block> CHOUZUBACHI_gra = register("block_chouzu_gra_kara", () -> chouzubachi());
	public static final RegistryObject<Block> CHOUZUBACHI_dio = register("block_chouzu_dio_kara", () -> chouzubachi());
	public static final RegistryObject<Block> CHOUZUBACHI_and = register("block_chouzu_and_kara", () -> chouzubachi());

	public static final RegistryObject<Block> ISHITOUROU = register("block_ishitourou_stone", () -> tourou());
	public static final RegistryObject<Block> ISHITOUROU_gra = register("block_ishitourou_gra", () -> tourou());
	public static final RegistryObject<Block> ISHITOUROU_dio = register("block_ishitourou_dio", () -> tourou());
	public static final RegistryObject<Block> ISHITOUROU_and = register("block_ishitourou_and", () -> tourou());

	public static final RegistryObject<Block> LONGTOUROU = register("block_longtourou_stone", () -> tourouLong());
	public static final RegistryObject<Block> LONGTOUROU_gra = register("block_longtourou_gra", () -> tourouLong());
	public static final RegistryObject<Block> LONGTOUROU_dio = register("block_longtourou_dio", () -> tourouLong());
	public static final RegistryObject<Block> LONGTOUROU_and = register("block_longtourou_and", () -> tourouLong());

	public static final RegistryObject<Block> TAKEAKARI = register("block_takeakari", () -> takeakari());
	public static final RegistryObject<Block> TAKEAKARI_Y = register("block_takeakari_y", () -> takeakari());
	public static final RegistryObject<Block> TAKEAKARI_K = register("block_takeakari_k", () -> takeakari());
	
	public static final RegistryObject<Block> BONSAI_oak = register("block_bonsai_oak", () -> bonsai());
	public static final RegistryObject<Block> BONSAI_spru = register("block_bonsai_spruce", () -> bonsai());
	public static final RegistryObject<Block> BONSAI_bir = register("block_bonsai_birch", () -> bonsai());
	public static final RegistryObject<Block> BONSAI_jun = register("block_bonsai_jungle", () -> bonsai());
	public static final RegistryObject<Block> BONSAI_aca = register("block_bonsai_acacia", () -> bonsai());
	public static final RegistryObject<Block> BONSAI_doak = register("block_bonsai_darkoak", () -> bonsai());
	public static final RegistryObject<Block> BONSAI_sakura = register("block_bonsai_sakura", () -> bonsai());
	public static final RegistryObject<Block> BONSAI_kaede = register("block_bonsai_kaede", () -> bonsai());
	public static final RegistryObject<Block> BONSAI_ichoh = register("block_bonsai_ichoh", () -> bonsai());
	public static final RegistryObject<Block> BONSAI_kare = register("block_bonsai_oakkare", () -> bonsai());

	public static final RegistryObject<Block> KANYOU = register("block_kanyouoak_bot", () -> kanyou(MapColor.PLANT));
	public static final RegistryObject<Block> KANYOU_spruce = register("block_kanyouspruce_bot", () -> kanyou(MapColor.PLANT));
	public static final RegistryObject<Block> KANYOU_birch = register("block_kanyoubirch_bot", () -> kanyou(MapColor.PLANT));
	public static final RegistryObject<Block> KANYOU_jungle = register("block_kanyoujungle_bot", () -> kanyou(MapColor.PLANT));
	public static final RegistryObject<Block> KANYOU_acacia = register("block_kanyouacacia_bot", () -> kanyou(MapColor.PLANT));
	public static final RegistryObject<Block> KANYOU_darkoak = register("block_kanyoudarkoak_bot", () -> kanyou(MapColor.PLANT));
	public static final RegistryObject<Block> KANYOU_sakura = register("block_kanyousakura_bot", () -> kanyou(MapColor.COLOR_PINK));
	public static final RegistryObject<Block> KANYOU_kaede = register("block_kanyoukaede_bot", () -> kanyou(MapColor.COLOR_RED));
	public static final RegistryObject<Block> KANYOU_ichoh = register("block_kanyouichoh_bot", () -> kanyou(MapColor.COLOR_YELLOW));
	public static final RegistryObject<Block> KANYOU_kare = register("block_kanyouoakkare_bot", () -> kanyou(MapColor.COLOR_BROWN));;

	public static final RegistryObject<Block> IKEGAKI = register("block_low_oak", () -> ikegaki(MapColor.PLANT));
	public static final RegistryObject<Block> IKEGAKI_spruce = register("block_low_spruce", () -> ikegaki(MapColor.PLANT));
	public static final RegistryObject<Block> IKEGAKI_birch = register("block_low_birch", () -> ikegaki(MapColor.PLANT));
	public static final RegistryObject<Block> IKEGAKI_jungle = register("block_low_jungle", () -> ikegaki(MapColor.PLANT));
	public static final RegistryObject<Block> IKEGAKI_acacia = register("block_low_acacia", () -> ikegaki(MapColor.PLANT));
	public static final RegistryObject<Block> IKEGAKI_darkoak = register("block_low_darkoak", () -> ikegaki(MapColor.PLANT));
	public static final RegistryObject<Block> IKEGAKI_sakura = register("block_low_sakura", () -> ikegaki(MapColor.COLOR_PINK));
	public static final RegistryObject<Block> IKEGAKI_kaede = register("block_low_kaede", () -> ikegaki(MapColor.COLOR_RED));
	public static final RegistryObject<Block> IKEGAKI_ichoh = register("block_low_ichoh", () -> ikegaki(MapColor.COLOR_YELLOW));
	public static final RegistryObject<Block> IKEGAKI_kare = register("block_low_oakkare", () -> ikegaki(MapColor.COLOR_BROWN));

	public static final RegistryObject<Block> IKEGAKILONG = register("block_longoak_bot", () -> ikegakiLong(MapColor.PLANT));
	public static final RegistryObject<Block> IKEGAKILONG_spruce = register("block_longspruce_bot", () -> ikegakiLong(MapColor.PLANT));
	public static final RegistryObject<Block> IKEGAKILONG_birch = register("block_longbirch_bot", () -> ikegakiLong(MapColor.PLANT));
	public static final RegistryObject<Block> IKEGAKILONG_jungle = register("block_longjungle_bot", () -> ikegakiLong(MapColor.PLANT));
	public static final RegistryObject<Block> IKEGAKILONG_acacia = register("block_longacacia_bot", () -> ikegakiLong(MapColor.PLANT));
	public static final RegistryObject<Block> IKEGAKILONG_darkoak = register("block_longdarkoak_bot", () -> ikegakiLong(MapColor.PLANT));
	public static final RegistryObject<Block> IKEGAKILONG_sakura = register("block_longsakura_bot", () -> ikegakiLong(MapColor.COLOR_PINK));
	public static final RegistryObject<Block> IKEGAKILONG_kaede = register("block_longkaede_bot", () -> ikegakiLong(MapColor.COLOR_RED));
	public static final RegistryObject<Block> IKEGAKILONG_ichoh = register("block_longichoh_bot", () -> ikegakiLong(MapColor.COLOR_YELLOW));
	public static final RegistryObject<Block> IKEGAKILONG_kare = register("block_longoakkare_bot", () -> ikegakiLong(MapColor.COLOR_BROWN));

	public static final RegistryObject<Block> TETSUSAKU_BOT = register("block_ironfence_bot", 
			() -> new IronFence(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).strength(1.0F, 10.0F).sound(SoundType.METAL).noOcclusion().isValidSpawn(Garden_Blocks::neverEntity).isSuffocating(Garden_Blocks::never)));

	public static final RegistryObject<Block> ITABEI = register("block_itabei", () -> itabei());
	public static final RegistryObject<Block> ITABEI_spruce = register("block_itabei_spruce", () -> itabei());
	public static final RegistryObject<Block> ITABEI_birch = register("block_itabei_birch", () -> itabei());
	public static final RegistryObject<Block> ITABEI_jungle = register("block_itabei_jungle", () -> itabei());
	public static final RegistryObject<Block> ITABEI_acacia = register("block_itabei_acacia", () -> itabei());
	public static final RegistryObject<Block> ITABEI_darkoak = register("block_itabei_darkoak", () -> itabei());
	public static final RegistryObject<Block> ITABEI_sakura = register("block_itabei_sakura", () -> itabei());
	public static final RegistryObject<Block> ITABEI_kaede = register("block_itabei_kaede", () -> itabei());
	public static final RegistryObject<Block> ITABEI_ichoh = register("block_itabei_ichoh", () -> itabei());
	
	public static final RegistryObject<Block> KIDO = register("block_kido", () -> kido());
	public static final RegistryObject<Block> KIDO_spruce = register("block_kido_spruce", () -> kido());
	public static final RegistryObject<Block> KIDO_birch = register("block_kido_birch", () -> kido());
	public static final RegistryObject<Block> KIDO_jungle = register("block_kido_jungle", () -> kido());
	public static final RegistryObject<Block> KIDO_acacia = register("block_kido_acacia", () -> kido());
	public static final RegistryObject<Block> KIDO_darkoak = register("block_kido_darkoak", () -> kido());
	public static final RegistryObject<Block> KIDO_sakura = register("block_kido_sakura", () -> kido());
	public static final RegistryObject<Block> KIDO_kaede = register("block_kido_kaede", () -> kido());
	public static final RegistryObject<Block> KIDO_ichoh = register("block_kido_ichoh", () -> kido());
	
	public static final RegistryObject<Block> SAMON = register("block_samon", () -> samon());
	public static final RegistryObject<Block> SAMON_B = register("block_samon_black", () -> samon());
	public static final RegistryObject<Block> NIWAISHI = register("block_niwaishi", () -> niwaishi());
	public static final RegistryObject<Block> NIWAISHI_gra = register("block_niwaishi_gra", () -> niwaishi());
	public static final RegistryObject<Block> NIWAISHI_dio = register("block_niwaishi_dio", () -> niwaishi());
	public static final RegistryObject<Block> NIWAISHI_and = register("block_niwaishi_and", () -> niwaishi());
	public static final RegistryObject<Block> NIWAISHI_slab = register("block_niwaishi_slab", () -> niwaishi_slab());
	public static final RegistryObject<Block> NIWAISHI_slab_gra = register("block_niwaishi_slab_gra", () -> niwaishi_slab());
	public static final RegistryObject<Block> NIWAISHI_slab_dio = register("block_niwaishi_slab_dio", () -> niwaishi_slab());
	public static final RegistryObject<Block> NIWAISHI_slab_and = register("block_niwaishi_slab_and", () -> niwaishi_slab());
	
	public static final RegistryObject<Block> MAKIBISHI = register("block_makibishi", 
			() -> new Makibishi(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).strength(1.0F, 1.0F).sound(SoundType.METAL).noCollission().noOcclusion().isValidSpawn(Garden_Blocks::neverEntity).isSuffocating(Garden_Blocks::never)));

	
	/* Share variables */
	private static ToIntFunction<BlockState> litBlockEmission(int value) {
		return (state) -> { return state.getValue(BlockStateProperties.LIT) ? value : 0; };
	}

	private static ToIntFunction<BlockState> litTourouLong(int value) {
		return (state) -> { return (state.getValue(TourouLong.HALF) == DoubleBlockHalf.UPPER && state.getValue(TourouLong.LIT)) ? value : 0; };
	}
	
	private static boolean never(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return false;
	}

	private static Boolean neverEntity(BlockState state, BlockGetter worldIn, BlockPos pos, EntityType<?> entity) {
		return (boolean)false;
	}
	
	private static Properties woodStateNever() {
		return BlockBehaviour.Properties.of().strength(1.0F, 3.0F).sound(SoundType.WOOD)
				.noOcclusion().isValidSpawn(Garden_Blocks::neverEntity).isSuffocating(Garden_Blocks::never);
	}
	
	private static Properties stoneStateNever() {
		return BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(1.0F, 6.0F).sound(SoundType.STONE)
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
		return new Takeakari(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).noCollission().strength(1.0F, 1.0F).sound(SoundType.WOOD)
				.noOcclusion().isValidSpawn(Garden_Blocks::neverEntity).isSuffocating(Garden_Blocks::never).lightLevel(litBlockEmission(14)));
	}
	
	private static Bonsai bonsai() {
		return new Bonsai(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).noCollission().strength(1.0F, 3.0F).sound(SoundType.STONE)
				.noOcclusion().isValidSpawn(Garden_Blocks::neverEntity).isSuffocating(Garden_Blocks::never));
	}

	private static Kanyou kanyou(MapColor color) {
		return new Kanyou(woodStateNever().mapColor(color));
	}

	private static Ikegaki ikegaki(MapColor color) {
		return new Ikegaki(woodStateNever().mapColor(color));
	}

	private static IkegakiLong ikegakiLong(MapColor color) {
		return new IkegakiLong(woodStateNever().mapColor(color));
	}

	private static Samon samon() {
		return new Samon(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).strength(1.0F, 3.0F).sound(SoundType.SAND)
				.isValidSpawn(Garden_Blocks::neverEntity));
	}
	
	private static Niwaishi niwaishi() {
		return new Niwaishi(stoneStateNever());
	}

	private static Niwaishi_slab niwaishi_slab() {
		return new Niwaishi_slab(stoneStateNever());
	}

	private static Itabei itabei() {
		return new Itabei(woodStateNever().mapColor(MapColor.WOOD));
	}
	
	private static Kido kido() {
		return new Kido(woodStateNever().mapColor(MapColor.WOOD));
	}
	
	
	///* Register *///
	private static RegistryObject<Block> register(String name, Supplier<Block> block) {
		return BLOCKS.register(name, block);
	}
}
