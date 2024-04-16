package com.ayutaki.chinjufumod.registry;

import java.util.function.Supplier;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.season.Hinadan;
import com.ayutaki.chinjufumod.blocks.season.Hinakazari;
import com.ayutaki.chinjufumod.blocks.season.Kadomatsu;
import com.ayutaki.chinjufumod.blocks.season.Kagamimochi;
import com.ayutaki.chinjufumod.blocks.season.Kakigouri;
import com.ayutaki.chinjufumod.blocks.season.Kouri_Hata;
import com.ayutaki.chinjufumod.blocks.season.KusaRoof;
import com.ayutaki.chinjufumod.blocks.season.KusaTaba;
import com.ayutaki.chinjufumod.blocks.season.PresentBox;
import com.ayutaki.chinjufumod.blocks.season.Shimenawa;
import com.ayutaki.chinjufumod.blocks.season.SnowCore;
import com.ayutaki.chinjufumod.blocks.season.SnowMan;
import com.ayutaki.chinjufumod.blocks.season.SnowMan_Color;
import com.ayutaki.chinjufumod.blocks.season.Uchiwa;
import com.ayutaki.chinjufumod.blocks.season.Wataame;
import com.ayutaki.chinjufumod.blocks.season.XmasTree;
import com.ayutaki.chinjufumod.blocks.wood.WoodStairs_CM;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Seasonal_Blocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);
	
	public static final RegistryObject<Block> KUSATABA = register("block_tabakusa", () -> kusaTaba());
	public static final RegistryObject<Block> WARATABA = register("block_tabawara", () -> kusaTaba());
	public static final RegistryObject<Block> KAYATABA = register("block_tabakaya", () -> kusaTaba());
	public static final RegistryObject<Block> KUSATABADUMMY = register("block_tabakusadummy", () -> new Block(kusaState()));

	public static final RegistryObject<Block> KUSATABA_RF = register("block_tabakusa_roof", () -> kusaRoof());
	public static final RegistryObject<Block> WARATABA_RF = register("block_tabawara_roof", () -> kusaRoof());
	public static final RegistryObject<Block> KAYATABA_RF = register("block_tabakaya_roof", () -> kusaRoof());

	public static final RegistryObject<Block> KUSATABA_STAIRS = register("block_tabakusa_stairs", () -> kusaStairs());
	public static final RegistryObject<Block> WARATABA_STAIRS = register("block_tabawara_stairs", () -> kusaStairs());
	public static final RegistryObject<Block> KAYATABA_STAIRS = register("block_tabakaya_stairs", () -> kusaStairs());

	public static final RegistryObject<Block> KADOMATSU = register("block_kadomatsu", () -> new Kadomatsu(baseState().sound(SoundType.WOOD)));
	public static final RegistryObject<Block> SHIMENAWA = register("block_shimenawa", () -> new Shimenawa(baseState().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> KAGAMIMOCHI = register("block_kagamimochi", () -> new Kagamimochi(baseState().sound(SoundType.WOOD)));

	public static final RegistryObject<Block> HINAKAZARI = register("block_hinakazari", () -> new Hinakazari(baseState().sound(SoundType.WOOD)));
	public static final RegistryObject<Block> HINADAN = register("block_hinadan", () -> new Hinadan(baseState().sound(SoundType.WOOD)));

	public static final RegistryObject<Block> XMASTREE = register("block_xmastree", () -> new XmasTree(baseState().sound(SoundType.WOOD)));
	public static final RegistryObject<Block> XMASTREE_W = register("block_xmastree_w", () -> new XmasTree(baseState().sound(SoundType.WOOD)));

	public static final RegistryObject<Block> PRESENT_app = register("block_present_app", () -> present());
	public static final RegistryObject<Block> PRESENT_bok = register("block_present_bok", () -> present());
	public static final RegistryObject<Block> PRESENT_dia = register("block_present_dia", () -> present());
	public static final RegistryObject<Block> PRESENT_lap = register("block_present_lap", () -> present());
	public static final RegistryObject<Block> PRESENT_bla = register("block_present_bla", () -> present());
	public static final RegistryObject<Block> PRESENT_chc = register("block_present_chc", () -> present());
	public static final RegistryObject<Block> PRESENT_chh = register("block_present_chh", () -> present());
	
	public static final RegistryObject<Block> SNOWCORE = register("block_snowcore", () -> new SnowCore(15792895, snowState()));
	public static final RegistryObject<Block> SNOWMAN = register("block_snowman", () -> new SnowMan(snowState()));
	public static final RegistryObject<Block> SNOWMAN_COLOR = register("block_snowman_color", () -> new SnowMan_Color(snowState()));

	public static final RegistryObject<Block> UCHIWA_white = register("block_uchiwa_white", () -> uchiwa());
	public static final RegistryObject<Block> UCHIWA_orange = register("block_uchiwa_orange", () -> uchiwa());
	public static final RegistryObject<Block> UCHIWA_magenta = register("block_uchiwa_magenta", () -> uchiwa());
	public static final RegistryObject<Block> UCHIWA_lightb = register("block_uchiwa_lightb", () -> uchiwa());
	public static final RegistryObject<Block> UCHIWA_yellow = register("block_uchiwa_yellow", () -> uchiwa());
	public static final RegistryObject<Block> UCHIWA_lime = register("block_uchiwa_lime", () -> uchiwa());
	public static final RegistryObject<Block> UCHIWA_pink = register("block_uchiwa_pink", () -> uchiwa());
	public static final RegistryObject<Block> UCHIWA_gray = register("block_uchiwa_gray", () -> uchiwa());
	public static final RegistryObject<Block> UCHIWA_lightg = register("block_uchiwa_lightg", () -> uchiwa());
	public static final RegistryObject<Block> UCHIWA_cyan = register("block_uchiwa_cyan", () -> uchiwa());
	public static final RegistryObject<Block> UCHIWA_purple = register("block_uchiwa_purple", () -> uchiwa());
	public static final RegistryObject<Block> UCHIWA_blue = register("block_uchiwa_blue", () -> uchiwa());
	public static final RegistryObject<Block> UCHIWA_brown = register("block_uchiwa_brown", () -> uchiwa());
	public static final RegistryObject<Block> UCHIWA_green = register("block_uchiwa_green", () -> uchiwa());
	public static final RegistryObject<Block> UCHIWA_red = register("block_uchiwa_red", () -> uchiwa());
	public static final RegistryObject<Block> UCHIWA_black = register("block_uchiwa_black", () -> uchiwa());

	public static final RegistryObject<Block> WATAGASHI_block = register("block_watagashi", () -> wataame());
	public static final RegistryObject<Block> WATAGASHI_pink = register("block_watagashi_pink", () -> wataame());
	public static final RegistryObject<Block> WATAGASHI_red = register("block_watagashi_red", () -> wataame());
	public static final RegistryObject<Block> WATAGASHI_yellow = register("block_watagashi_yellow", () -> wataame());
	public static final RegistryObject<Block> WATAGASHI_green = register("block_watagashi_green", () -> wataame());

	public static final RegistryObject<Block> KAKIGOURI_hata = register("block_kakigouri_hata",
			() -> new Kouri_Hata(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).strength(1.0F, 1.0F).sound(SoundType.WOOL).noOcclusion().isValidSpawn(Seasonal_Blocks::neverEntity).isSuffocating(Seasonal_Blocks::never)));
	public static final RegistryObject<Block> KAKIGOURI_block = register("block_kakigouri_block1", () -> kakigouri());
	public static final RegistryObject<Block> KAKIGOURI_pink = register("block_kakigouri_pink1", () -> kakigouri());
	public static final RegistryObject<Block> KAKIGOURI_red = register("block_kakigouri_red1", () -> kakigouri());
	public static final RegistryObject<Block> KAKIGOURI_yellow = register("block_kakigouri_yellow1", () -> kakigouri());
	public static final RegistryObject<Block> KAKIGOURI_green = register("block_kakigouri_green1", () -> kakigouri());
	
	
	/* Share variables */
	private static boolean never(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return false;
	}

	private static Boolean neverEntity(BlockState state, BlockGetter worldIn, BlockPos pos, EntityType<?> entity) {
		return (boolean)false;
	}

	private static boolean neverSlab(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return (state.getValue(KusaRoof.TYPE) == SlabType.DOUBLE)? true : false;
	}

	private static Boolean neverEntitySlab(BlockState state, BlockGetter worldIn, BlockPos pos, EntityType<?> entity) {
		return (state.getValue(KusaRoof.TYPE) == SlabType.BOTTOM)? (boolean)false : (boolean)true;
	}

	private static Boolean neverEntityStairs(BlockState state, BlockGetter worldIn, BlockPos pos, EntityType<?> entity) {
		return (state.getValue(WoodStairs_CM.HALF) == Half.BOTTOM)? (boolean)false : (boolean)true;
	}
	
	private static Properties baseState() {
		return BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(1.0F, 3.0F).noOcclusion()
				.isValidSpawn(Seasonal_Blocks::neverEntity).isSuffocating(Seasonal_Blocks::never);
	}
	
	private static Properties kusaState() {
		return BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).strength(1.0F, 3.0F).sound(SoundType.GRASS);
	}
	
	private static Properties snowState() {
		return BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).strength(1.0F, 1.0F).sound(SoundType.SNOW).noOcclusion()
				.isValidSpawn(Seasonal_Blocks::neverEntity).isSuffocating(Seasonal_Blocks::never);
	}
		
	private static KusaTaba kusaTaba() {
		return new KusaTaba(kusaState());
	}
	
	private static KusaRoof kusaRoof() {
		return new KusaRoof(kusaState().noOcclusion().isValidSpawn(Seasonal_Blocks::neverEntitySlab).isSuffocating(Seasonal_Blocks::neverSlab));
	}

	private static WoodStairs_CM kusaStairs() {
		return new WoodStairs_CM(KUSATABADUMMY.get().defaultBlockState(), kusaState().noOcclusion().isValidSpawn(Seasonal_Blocks::neverEntityStairs).isSuffocating(Seasonal_Blocks::never));
	}
	
	private static PresentBox present() {
		return new PresentBox(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(1.0F, 1.0F).sound(SoundType.WOOD)
				.noOcclusion().isValidSpawn(Seasonal_Blocks::neverEntity).isSuffocating(Seasonal_Blocks::never));
	}
	
	private static Uchiwa uchiwa() {
		return new Uchiwa(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).strength(1.0F, 1.0F).sound(SoundType.WOOL)
				.noOcclusion().isValidSpawn(Seasonal_Blocks::neverEntity).isSuffocating(Seasonal_Blocks::never));
	}
	
	private static Wataame wataame() {
		return new Wataame(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(1.0F, 1.0F).sound(SoundType.WOOD)
				.noOcclusion().isValidSpawn(Seasonal_Blocks::neverEntity).isSuffocating(Seasonal_Blocks::never));
	}

	private static Kakigouri kakigouri() {
		return new Kakigouri(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).noCollission().strength(1.0F, 1.0F).sound(SoundType.STONE)
				.noOcclusion().isValidSpawn(Seasonal_Blocks::neverEntity).isSuffocating(Seasonal_Blocks::never));
	}
	
	
	///* Register *///
	private static RegistryObject<Block> register(String name, Supplier<Block> block) {
		return BLOCKS.register(name, block);
	}
}
