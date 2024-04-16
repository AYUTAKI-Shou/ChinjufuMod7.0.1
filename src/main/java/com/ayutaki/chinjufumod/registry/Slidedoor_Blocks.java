package com.ayutaki.chinjufumod.registry;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.amado.Amado;
import com.ayutaki.chinjufumod.blocks.amado.AmadoWindow;
import com.ayutaki.chinjufumod.blocks.amado.Tobukuro;
import com.ayutaki.chinjufumod.blocks.amado.TobukuroWindow;
import com.ayutaki.chinjufumod.blocks.amado.Tobukuro_L;
import com.ayutaki.chinjufumod.blocks.slidedoor.Fusuma;
import com.ayutaki.chinjufumod.blocks.slidedoor.Fusuma_B;
import com.ayutaki.chinjufumod.blocks.slidedoor.GlassDoor;
import com.ayutaki.chinjufumod.blocks.slidedoor.GlassDoorHalf;
import com.ayutaki.chinjufumod.blocks.slidedoor.Shouji;
import com.ayutaki.chinjufumod.blocks.slidedoor.ShoujiHalf;
import com.ayutaki.chinjufumod.blocks.slidedoor.ShoujiWindow;

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

public class Slidedoor_Blocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);
	
	public static final RegistryObject<Block> FUSUMA_white = register("block_fusuma", () -> fusuma());
	public static final RegistryObject<Block> FUSUMA_orange = register("block_fusuma_orange", () -> fusuma());
	public static final RegistryObject<Block> FUSUMA_magenta = register("block_fusuma_magenta", () -> fusuma());
	public static final RegistryObject<Block> FUSUMA_lightb = register("block_fusuma_lightb", () -> fusuma());
	public static final RegistryObject<Block> FUSUMA_yellow = register("block_fusuma_yellow", () -> fusuma());
	public static final RegistryObject<Block> FUSUMA_lime = register("block_fusuma_lime", () -> fusuma());
	public static final RegistryObject<Block> FUSUMA_pink = register("block_fusuma_pink", () -> fusuma());
	public static final RegistryObject<Block> FUSUMA_gray = register("block_fusuma_gray", () -> fusuma());
	public static final RegistryObject<Block> FUSUMA_lightg = register("block_fusuma_lightg", () -> fusuma());
	public static final RegistryObject<Block> FUSUMA_cyan = register("block_fusuma_cyan", () -> fusuma());
	public static final RegistryObject<Block> FUSUMA_purple = register("block_fusuma_purple", () -> fusuma());
	public static final RegistryObject<Block> FUSUMA_blue = register("block_fusuma_blue", () -> fusuma());
	public static final RegistryObject<Block> FUSUMA_brown = register("block_fusuma_brown", () -> fusuma());
	public static final RegistryObject<Block> FUSUMA_green = register("block_fusuma_green", () -> fusuma());
	public static final RegistryObject<Block> FUSUMA_red = register("block_fusuma_red", () -> fusuma());
	public static final RegistryObject<Block> FUSUMA_black = register("block_fusuma_black", () -> fusuma());

	public static final RegistryObject<Block> FUSUMAB_white = register("block_fusumab", () -> fusumaBtype());
	public static final RegistryObject<Block> FUSUMAB_orange = register("block_fusumab_orange", () -> fusumaBtype());
	public static final RegistryObject<Block> FUSUMAB_magenta = register("block_fusumab_magenta", () -> fusumaBtype());
	public static final RegistryObject<Block> FUSUMAB_lightb = register("block_fusumab_lightb", () -> fusumaBtype());
	public static final RegistryObject<Block> FUSUMAB_yellow = register("block_fusumab_yellow", () -> fusumaBtype());
	public static final RegistryObject<Block> FUSUMAB_lime = register("block_fusumab_lime", () -> fusumaBtype());
	public static final RegistryObject<Block> FUSUMAB_pink = register("block_fusumab_pink", () -> fusumaBtype());
	public static final RegistryObject<Block> FUSUMAB_gray = register("block_fusumab_gray", () -> fusumaBtype());
	public static final RegistryObject<Block> FUSUMAB_lightg = register("block_fusumab_lightg", () -> fusumaBtype());
	public static final RegistryObject<Block> FUSUMAB_cyan = register("block_fusumab_cyan", () -> fusumaBtype());
	public static final RegistryObject<Block> FUSUMAB_purple = register("block_fusumab_purple", () -> fusumaBtype());
	public static final RegistryObject<Block> FUSUMAB_blue = register("block_fusumab_blue", () -> fusumaBtype());
	public static final RegistryObject<Block> FUSUMAB_brown = register("block_fusumab_brown", () -> fusumaBtype());
	public static final RegistryObject<Block> FUSUMAB_green = register("block_fusumab_green", () -> fusumaBtype());
	public static final RegistryObject<Block> FUSUMAB_red = register("block_fusumab_red", () -> fusumaBtype());
	public static final RegistryObject<Block> FUSUMAB_black = register("block_fusumab_black", () -> fusumaBtype());

	public static final RegistryObject<Block> GARASUDO = register("block_garasudo", () -> glassdoor());
	public static final RegistryObject<Block> GARASUDO_SPRU = register("block_garasudo_spruce", () -> glassdoor());
	public static final RegistryObject<Block> GARASUDO_BIR = register("block_garasudo_birch", () -> glassdoor());
	public static final RegistryObject<Block> GARASUDO_JUN = register("block_garasudo_jungle", () -> glassdoor());
	public static final RegistryObject<Block> GARASUDO_ACA = register("block_garasudo_acacia", () -> glassdoor());
	public static final RegistryObject<Block> GARASUDO_DOAK = register("block_garasudo_darkoak", () -> glassdoor());
	public static final RegistryObject<Block> GARASUDO_SAKU = register("block_garasudo_sakura", () -> glassdoor());
	public static final RegistryObject<Block> GARASUDO_KAE = register("block_garasudo_kaede", () -> glassdoor());
	public static final RegistryObject<Block> GARASUDO_ICH = register("block_garasudo_ichoh", () -> glassdoor());

	public static final RegistryObject<Block> GARASUDOB = register("block_garasudob", () -> glassdoor());
	public static final RegistryObject<Block> GARASUDOB_SPRU = register("block_garasudob_spruce", () -> glassdoor());
	public static final RegistryObject<Block> GARASUDOB_BIR = register("block_garasudob_birch", () -> glassdoor());
	public static final RegistryObject<Block> GARASUDOB_JUN = register("block_garasudob_jungle", () -> glassdoor());
	public static final RegistryObject<Block> GARASUDOB_ACA = register("block_garasudob_acacia", () -> glassdoor());
	public static final RegistryObject<Block> GARASUDOB_DOAK = register("block_garasudob_darkoak", () -> glassdoor());
	public static final RegistryObject<Block> GARASUDOB_SAKU = register("block_garasudob_sakura", () -> glassdoor());
	public static final RegistryObject<Block> GARASUDOB_KAE = register("block_garasudob_kaede", () -> glassdoor());
	public static final RegistryObject<Block> GARASUDOB_ICH = register("block_garasudob_ichoh", () -> glassdoor());

	public static final RegistryObject<Block> GARASUDOH = register("block_garasudohalf", () -> glassdoorHalf());
	public static final RegistryObject<Block> GARASUDOH_SPRU = register("block_garasudohalf_spruce", () -> glassdoorHalf());
	public static final RegistryObject<Block> GARASUDOH_BIR = register("block_garasudohalf_birch", () -> glassdoorHalf());
	public static final RegistryObject<Block> GARASUDOH_JUN = register("block_garasudohalf_jungle", () -> glassdoorHalf());
	public static final RegistryObject<Block> GARASUDOH_ACA = register("block_garasudohalf_acacia", () -> glassdoorHalf());
	public static final RegistryObject<Block> GARASUDOH_DOAK = register("block_garasudohalf_darkoak", () -> glassdoorHalf());
	public static final RegistryObject<Block> GARASUDOH_SAKU = register("block_garasudohalf_sakura", () -> glassdoorHalf());
	public static final RegistryObject<Block> GARASUDOH_KAE = register("block_garasudohalf_kaede", () -> glassdoorHalf());
	public static final RegistryObject<Block> GARASUDOH_ICH = register("block_garasudohalf_ichoh", () -> glassdoorHalf());

	public static final RegistryObject<Block> SHOUJI = register("block_shouji", () -> shouji());
	public static final RegistryObject<Block> SHOUJI_SPRU = register("block_shouji_spruce", () -> shouji());
	public static final RegistryObject<Block> SHOUJI_BIR = register("block_shouji_birch", () -> shouji());
	public static final RegistryObject<Block> SHOUJI_JUN = register("block_shouji_jungle", () -> shouji());
	public static final RegistryObject<Block> SHOUJI_ACA = register("block_shouji_acacia", () -> shouji());
	public static final RegistryObject<Block> SHOUJI_DOAK = register("block_shouji_darkoak", () -> shouji());
	public static final RegistryObject<Block> SHOUJI_SAKU = register("block_shouji_sakura", () -> shouji());
	public static final RegistryObject<Block> SHOUJI_KAE = register("block_shouji_kaede", () -> shouji());
	public static final RegistryObject<Block> SHOUJI_ICH = register("block_shouji_ichoh", () -> shouji());

	public static final RegistryObject<Block> SHOUJIB = register("block_shoujib", () -> shouji());
	public static final RegistryObject<Block> SHOUJIB_SPRU = register("block_shoujib_spruce", () -> shouji());
	public static final RegistryObject<Block> SHOUJIB_BIR = register("block_shoujib_birch", () -> shouji());
	public static final RegistryObject<Block> SHOUJIB_JUN = register("block_shoujib_jungle", () -> shouji());
	public static final RegistryObject<Block> SHOUJIB_ACA = register("block_shoujib_acacia", () -> shouji());
	public static final RegistryObject<Block> SHOUJIB_DOAK = register("block_shoujib_darkoak", () -> shouji());
	public static final RegistryObject<Block> SHOUJIB_SAKU = register("block_shoujib_sakura", () -> shouji());
	public static final RegistryObject<Block> SHOUJIB_KAE = register("block_shoujib_kaede", () -> shouji());
	public static final RegistryObject<Block> SHOUJIB_ICH = register("block_shoujib_ichoh", () -> shouji());

	public static final RegistryObject<Block> SHOUJIH = register("block_shoujihalf", () -> shoujiHalf());
	public static final RegistryObject<Block> SHOUJIH_SPRU = register("block_shoujihalf_spruce", () -> shoujiHalf());
	public static final RegistryObject<Block> SHOUJIH_BIR = register("block_shoujihalf_birch", () -> shoujiHalf());
	public static final RegistryObject<Block> SHOUJIH_JUN = register("block_shoujihalf_jungle", () -> shoujiHalf());
	public static final RegistryObject<Block> SHOUJIH_ACA = register("block_shoujihalf_acacia", () -> shoujiHalf());
	public static final RegistryObject<Block> SHOUJIH_DOAK = register("block_shoujihalf_darkoak", () -> shoujiHalf());
	public static final RegistryObject<Block> SHOUJIH_SAKU = register("block_shoujihalf_sakura", () -> shoujiHalf());
	public static final RegistryObject<Block> SHOUJIH_KAE = register("block_shoujihalf_kaede", () -> shoujiHalf());
	public static final RegistryObject<Block> SHOUJIH_ICH = register("block_shoujihalf_ichoh", () -> shoujiHalf());

	public static final RegistryObject<Block> SHOUJI_WIN = register("block_shoujih", () -> shoujiWin());
	public static final RegistryObject<Block> SHOUJI_WIN_SPRU = register("block_shoujih_spruce", () -> shoujiWin());
	public static final RegistryObject<Block> SHOUJI_WIN_BIR = register("block_shoujih_birch", () -> shoujiWin());
	public static final RegistryObject<Block> SHOUJI_WIN_JUN = register("block_shoujih_jungle", () -> shoujiWin());
	public static final RegistryObject<Block> SHOUJI_WIN_ACA = register("block_shoujih_acacia", () -> shoujiWin());
	public static final RegistryObject<Block> SHOUJI_WIN_DOAK = register("block_shoujih_darkoak", () -> shoujiWin());
	public static final RegistryObject<Block> SHOUJI_WIN_SAKU = register("block_shoujih_sakura", () -> shoujiWin());
	public static final RegistryObject<Block> SHOUJI_WIN_KAE = register("block_shoujih_kaede", () -> shoujiWin());
	public static final RegistryObject<Block> SHOUJI_WIN_ICH = register("block_shoujih_ichoh", () -> shoujiWin());

	public static final RegistryObject<Block> SHOUJI_WINR = register("block_shoujihr", () -> shoujiWin());
	public static final RegistryObject<Block> SHOUJI_WINR_SPRU = register("block_shoujihr_spruce", () -> shoujiWin());
	public static final RegistryObject<Block> SHOUJI_WINR_BIR = register("block_shoujihr_birch", () -> shoujiWin());
	public static final RegistryObject<Block> SHOUJI_WINR_JUN = register("block_shoujihr_jungle", () -> shoujiWin());
	public static final RegistryObject<Block> SHOUJI_WINR_ACA = register("block_shoujihr_acacia", () -> shoujiWin());
	public static final RegistryObject<Block> SHOUJI_WINR_DOAK = register("block_shoujihr_darkoak", () -> shoujiWin());
	public static final RegistryObject<Block> SHOUJI_WINR_SAKU = register("block_shoujihr_sakura", () -> shoujiWin());
	public static final RegistryObject<Block> SHOUJI_WINR_KAE = register("block_shoujihr_kaede", () -> shoujiWin());
	public static final RegistryObject<Block> SHOUJI_WINR_ICH = register("block_shoujihr_ichoh", () -> shoujiWin());

	public static final RegistryObject<Block> AMADO_S = register("block_amado_spruce", () -> new Amado(amadoState()));
	public static final RegistryObject<Block> TOBUKURO_S = register("block_tobukuro_spruce", () -> new Tobukuro(amadoState()));
	public static final RegistryObject<Block> TOBUKURO_SL = register("block_tobukuro_sprucel", () -> new Tobukuro_L(amadoState()));

	public static final RegistryObject<Block> AMADOWIN_S = register("block_amadowin_spruce", () -> new AmadoWindow(amadoState()));
	public static final RegistryObject<Block> TOBUKUROWIN_S = register("block_tobukurowin_spruce", () -> new TobukuroWindow(amadoState()));

	public static final RegistryObject<Block> AMADO = register("block_amado", () -> new Amado(amadoState()));
	public static final RegistryObject<Block> TOBUKURO = register("block_tobukuro", () -> new Tobukuro(amadoState()));
	public static final RegistryObject<Block> TOBUKURO_L = register("block_tobukuro_l", () -> new Tobukuro_L(amadoState()));

	public static final RegistryObject<Block> AMADOWIN = register("block_amadowin", () -> new AmadoWindow(amadoState()));
	public static final RegistryObject<Block> TOBUKUROWIN = register("block_tobukurowin", () -> new TobukuroWindow(amadoState()));

	
	/* Share variables */
	private static boolean never(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return false;
	}

	private static Boolean neverEntity(BlockState state, BlockGetter worldIn, BlockPos pos, EntityType<?> entity) {
		return (boolean)false;
	}
	
	/* 要検証 Config_CM.INSTANCE.antiShadow.get() == true && */
	private static ToIntFunction<BlockState> litBlockEmission(int value) {
		return (state) -> { return value; };
	}
	
	private static Properties woodSlidedoor() {
		return BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(1.0F, 3.0F).sound(SoundType.WOOD)
				.noOcclusion().isValidSpawn(Slidedoor_Blocks::neverEntity).isSuffocating(Slidedoor_Blocks::never).lightLevel(litBlockEmission(1));
	}
	
	private static Properties amadoState() {
		return BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(2.0F, 5.0F).sound(SoundType.WOOD).noOcclusion()
				.isValidSpawn(Slidedoor_Blocks::neverEntity).isSuffocating(Slidedoor_Blocks::never); 
	}
	
	private static Fusuma fusuma() {
		return new Fusuma(woodSlidedoor());
	}

	private static Fusuma_B fusumaBtype() {
		return new Fusuma_B(woodSlidedoor());
	}

	private static GlassDoor glassdoor() {
		return new GlassDoor(woodSlidedoor());
	}

	private static GlassDoorHalf glassdoorHalf() {
		return new GlassDoorHalf(woodSlidedoor());
	}

	private static Shouji shouji() {
		return new Shouji(woodSlidedoor());
	}

	private static ShoujiHalf shoujiHalf() {
		return new ShoujiHalf(woodSlidedoor());
	}

	private static ShoujiWindow shoujiWin() {
		return new ShoujiWindow(woodSlidedoor());
	}
	
	
	///* Register *///
	private static RegistryObject<Block> register(String name, Supplier<Block> block) {
		return BLOCKS.register(name, block);
	}
}
