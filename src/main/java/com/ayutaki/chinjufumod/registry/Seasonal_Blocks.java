package com.ayutaki.chinjufumod.registry;

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

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.EntityType;
import net.minecraft.state.properties.Half;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Seasonal_Blocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);

	public static Block KUSATABA = register("block_tabakusa", kusaTaba());
	public static Block WARATABA = register("block_tabawara", kusaTaba());
	public static Block KAYATABA = register("block_tabakaya", kusaTaba());
	public static Block KUSATABADUMMY = register("block_tabakusadummy", new Block(kusaState()));

	public static Block KUSATABA_RF = register("block_tabakusa_roof", kusaRoof());
	public static Block WARATABA_RF = register("block_tabawara_roof", kusaRoof());
	public static Block KAYATABA_RF = register("block_tabakaya_roof", kusaRoof());

	public static Block KUSATABA_STAIRS = register("block_tabakusa_stairs", kusaStairs());
	public static Block WARATABA_STAIRS = register("block_tabawara_stairs", kusaStairs());
	public static Block KAYATABA_STAIRS = register("block_tabakaya_stairs", kusaStairs());

	public static Block KADOMATSU = register("block_kadomatsu", new Kadomatsu(baseState().sound(SoundType.WOOD)));
	public static Block SHIMENAWA = register("block_shimenawa", new Shimenawa(baseState().sound(SoundType.GRASS)));
	public static Block KAGAMIMOCHI = register("block_kagamimochi", new Kagamimochi(baseState().sound(SoundType.WOOD)));

	public static Block HINAKAZARI = register("block_hinakazari", new Hinakazari(baseState().sound(SoundType.WOOD)));
	public static Block HINADAN = register("block_hinadan", new Hinadan(baseState().sound(SoundType.WOOD)));

	public static Block XMASTREE = register("block_xmastree", new XmasTree(baseState().sound(SoundType.WOOD)));
	public static Block XMASTREE_W = register("block_xmastree_w", new XmasTree(baseState().sound(SoundType.WOOD)));

	public static Block PRESENT_app = register("block_present_app", present());
	public static Block PRESENT_bok = register("block_present_bok", present());
	public static Block PRESENT_dia = register("block_present_dia", present());
	public static Block PRESENT_lap = register("block_present_lap", present());
	public static Block PRESENT_bla = register("block_present_bla", present());
	public static Block PRESENT_chc = register("block_present_chc", present());
	public static Block PRESENT_chh = register("block_present_chh", present());

	public static Block UCHIWA_white = register("block_uchiwa_white", uchiwa());
	public static Block UCHIWA_orange = register("block_uchiwa_orange", uchiwa());
	public static Block UCHIWA_magenta = register("block_uchiwa_magenta", uchiwa());
	public static Block UCHIWA_lightb = register("block_uchiwa_lightb", uchiwa());
	public static Block UCHIWA_yellow = register("block_uchiwa_yellow", uchiwa());
	public static Block UCHIWA_lime = register("block_uchiwa_lime", uchiwa());
	public static Block UCHIWA_pink = register("block_uchiwa_pink", uchiwa());
	public static Block UCHIWA_gray = register("block_uchiwa_gray", uchiwa());
	public static Block UCHIWA_lightg = register("block_uchiwa_lightg", uchiwa());
	public static Block UCHIWA_cyan = register("block_uchiwa_cyan", uchiwa());
	public static Block UCHIWA_purple = register("block_uchiwa_purple", uchiwa());
	public static Block UCHIWA_blue = register("block_uchiwa_blue", uchiwa());
	public static Block UCHIWA_brown = register("block_uchiwa_brown", uchiwa());
	public static Block UCHIWA_green = register("block_uchiwa_green", uchiwa());
	public static Block UCHIWA_red = register("block_uchiwa_red", uchiwa());
	public static Block UCHIWA_black = register("block_uchiwa_black", uchiwa());

	public static Block WATAGASHI_block = register("block_watagashi", wataame());
	public static Block WATAGASHI_pink = register("block_watagashi_pink", wataame());
	public static Block WATAGASHI_red = register("block_watagashi_red", wataame());
	public static Block WATAGASHI_yellow = register("block_watagashi_yellow", wataame());
	public static Block WATAGASHI_green = register("block_watagashi_green", wataame());

	public static Block KAKIGOURI_hata = register("block_kakigouri_hata", new Kouri_Hata(AbstractBlock.Properties.of(Material.WOOL).strength(1.0F, 1.0F).sound(SoundType.WOOL)
			.noOcclusion().isValidSpawn(Seasonal_Blocks::neverEntity).isSuffocating(Seasonal_Blocks::never)));
	public static Block KAKIGOURI_block = register("block_kakigouri_block1", kakigouri());
	public static Block KAKIGOURI_pink = register("block_kakigouri_pink1", kakigouri());
	public static Block KAKIGOURI_red = register("block_kakigouri_red1", kakigouri());
	public static Block KAKIGOURI_yellow = register("block_kakigouri_yellow1", kakigouri());
	public static Block KAKIGOURI_green = register("block_kakigouri_green1", kakigouri());
	
	public static Block SNOWCORE = register("block_snowcore", new SnowCore(15792895, snowState()));
	public static Block SNOWMAN = register("block_snowman", new SnowMan(snowState()));
	public static Block SNOWMAN_COLOR = register("block_snowman_color", new SnowMan_Color(snowState()));
	
	
	/* Share variables */
	private static boolean never(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	private static Boolean neverEntity(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> entity) {
		return (boolean)false;
	}

	private static boolean neverSlab(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return (state.getValue(KusaRoof.TYPE) == SlabType.DOUBLE)? true : false;
	}

	private static Boolean neverEntitySlab(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> entity) {
		return (state.getValue(KusaRoof.TYPE) == SlabType.BOTTOM)? (boolean)false : (boolean)true;
	}

	private static Boolean neverEntityStairs(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> entity) {
		return (state.getValue(WoodStairs_CM.HALF) == Half.BOTTOM)? (boolean)false : (boolean)true;
	}

	private static Properties baseState() {
		return AbstractBlock.Properties.of(Material.WOOD).strength(1.0F, 3.0F).noOcclusion()
				.isValidSpawn(Seasonal_Blocks::neverEntity).isSuffocating(Seasonal_Blocks::never);
	}
	
	private static Properties kusaState() {
		return AbstractBlock.Properties.of(Material.WOOD, MaterialColor.PLANT).strength(1.0F, 3.0F).sound(SoundType.GRASS);
	}
	
	private static Properties snowState() {
		return AbstractBlock.Properties.of(Material.WOOD, MaterialColor.SNOW).strength(1.0F, 1.0F).sound(SoundType.SNOW)
				.noOcclusion().isValidSpawn(Seasonal_Blocks::neverEntity).isSuffocating(Seasonal_Blocks::never);
	}
	
	private static KusaTaba kusaTaba() {
		return new KusaTaba(kusaState());
	}
	
	private static KusaRoof kusaRoof() {
		return new KusaRoof(kusaState().isValidSpawn(Seasonal_Blocks::neverEntitySlab).isSuffocating(Seasonal_Blocks::neverSlab));
	}

	private static WoodStairs_CM kusaStairs() {
		return new WoodStairs_CM(KUSATABADUMMY.defaultBlockState(), kusaState().isValidSpawn(Seasonal_Blocks::neverEntityStairs).isSuffocating(Seasonal_Blocks::never));
	}

	private static PresentBox present() {
		return new PresentBox(AbstractBlock.Properties.of(Material.WOOD).strength(1.0F, 1.0F).sound(SoundType.WOOD)
				.noOcclusion().isValidSpawn(Seasonal_Blocks::neverEntity).isSuffocating(Seasonal_Blocks::never));
	}

	private static Uchiwa uchiwa() {
		return new Uchiwa(AbstractBlock.Properties.of(Material.WOOL).strength(1.0F, 1.0F).sound(SoundType.WOOL)
				.noOcclusion().isValidSpawn(Seasonal_Blocks::neverEntity).isSuffocating(Seasonal_Blocks::never));
	}

	private static Wataame wataame() {
		return new Wataame(AbstractBlock.Properties.of(Material.WOOD).strength(1.0F, 1.0F).sound(SoundType.WOOD)
				.noOcclusion().isValidSpawn(Seasonal_Blocks::neverEntity).isSuffocating(Seasonal_Blocks::never));
	}

	private static Kakigouri kakigouri() {
		return new Kakigouri(AbstractBlock.Properties.of(Material.STONE).noCollission().strength(1.0F, 1.0F).sound(SoundType.STONE)
				.noOcclusion().isValidSpawn(Seasonal_Blocks::neverEntity).isSuffocating(Seasonal_Blocks::never));
	}


	///* Register *///
	private static Block register(String name, Block block) {
		BLOCKS.register(name, () -> block);
		return block;
	}
}
