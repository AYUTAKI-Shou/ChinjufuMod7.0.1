package com.ayutaki.chinjufumod.registry;

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

import net.minecraft.block.Block;
import net.minecraft.block.Block.Properties;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Slidedoor_Blocks {

	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);

	public static Block FUSUMA_white = register("block_fusuma", fusuma());
	public static Block FUSUMA_orange = register("block_fusuma_orange", fusuma());
	public static Block FUSUMA_magenta = register("block_fusuma_magenta", fusuma());
	public static Block FUSUMA_lightb = register("block_fusuma_lightb", fusuma());
	public static Block FUSUMA_yellow = register("block_fusuma_yellow", fusuma());
	public static Block FUSUMA_lime = register("block_fusuma_lime", fusuma());
	public static Block FUSUMA_pink = register("block_fusuma_pink", fusuma());
	public static Block FUSUMA_gray = register("block_fusuma_gray", fusuma());
	public static Block FUSUMA_lightg = register("block_fusuma_lightg", fusuma());
	public static Block FUSUMA_cyan = register("block_fusuma_cyan", fusuma());
	public static Block FUSUMA_purple = register("block_fusuma_purple", fusuma());
	public static Block FUSUMA_blue = register("block_fusuma_blue", fusuma());
	public static Block FUSUMA_brown = register("block_fusuma_brown", fusuma());
	public static Block FUSUMA_green = register("block_fusuma_green", fusuma());
	public static Block FUSUMA_red = register("block_fusuma_red", fusuma());
	public static Block FUSUMA_black = register("block_fusuma_black", fusuma());

	public static Block FUSUMAB_white = register("block_fusumab", fusumaBtype());
	public static Block FUSUMAB_orange = register("block_fusumab_orange", fusumaBtype());
	public static Block FUSUMAB_magenta = register("block_fusumab_magenta", fusumaBtype());
	public static Block FUSUMAB_lightb = register("block_fusumab_lightb", fusumaBtype());
	public static Block FUSUMAB_yellow = register("block_fusumab_yellow", fusumaBtype());
	public static Block FUSUMAB_lime = register("block_fusumab_lime", fusumaBtype());
	public static Block FUSUMAB_pink = register("block_fusumab_pink", fusumaBtype());
	public static Block FUSUMAB_gray = register("block_fusumab_gray", fusumaBtype());
	public static Block FUSUMAB_lightg = register("block_fusumab_lightg", fusumaBtype());
	public static Block FUSUMAB_cyan = register("block_fusumab_cyan", fusumaBtype());
	public static Block FUSUMAB_purple = register("block_fusumab_purple", fusumaBtype());
	public static Block FUSUMAB_blue = register("block_fusumab_blue", fusumaBtype());
	public static Block FUSUMAB_brown = register("block_fusumab_brown", fusumaBtype());
	public static Block FUSUMAB_green = register("block_fusumab_green", fusumaBtype());
	public static Block FUSUMAB_red = register("block_fusumab_red", fusumaBtype());
	public static Block FUSUMAB_black = register("block_fusumab_black", fusumaBtype());

	public static Block GARASUDO = register("block_garasudo", glassdoor());
	public static Block GARASUDO_SPRU = register("block_garasudo_spruce", glassdoor());
	public static Block GARASUDO_BIR = register("block_garasudo_birch", glassdoor());
	public static Block GARASUDO_JUN = register("block_garasudo_jungle", glassdoor());
	public static Block GARASUDO_ACA = register("block_garasudo_acacia", glassdoor());
	public static Block GARASUDO_DOAK = register("block_garasudo_darkoak", glassdoor());
	public static Block GARASUDO_SAKU = register("block_garasudo_sakura", glassdoor());
	public static Block GARASUDO_KAE = register("block_garasudo_kaede", glassdoor());
	public static Block GARASUDO_ICH = register("block_garasudo_ichoh", glassdoor());

	public static Block GARASUDOB = register("block_garasudob", glassdoor());
	public static Block GARASUDOB_SPRU = register("block_garasudob_spruce", glassdoor());
	public static Block GARASUDOB_BIR = register("block_garasudob_birch", glassdoor());
	public static Block GARASUDOB_JUN = register("block_garasudob_jungle", glassdoor());
	public static Block GARASUDOB_ACA = register("block_garasudob_acacia", glassdoor());
	public static Block GARASUDOB_DOAK = register("block_garasudob_darkoak", glassdoor());
	public static Block GARASUDOB_SAKU = register("block_garasudob_sakura", glassdoor());
	public static Block GARASUDOB_KAE = register("block_garasudob_kaede", glassdoor());
	public static Block GARASUDOB_ICH = register("block_garasudob_ichoh", glassdoor());

	public static Block GARASUDOH = register("block_garasudohalf", glassdoorHalf());
	public static Block GARASUDOH_SPRU = register("block_garasudohalf_spruce", glassdoorHalf());
	public static Block GARASUDOH_BIR = register("block_garasudohalf_birch", glassdoorHalf());
	public static Block GARASUDOH_JUN = register("block_garasudohalf_jungle", glassdoorHalf());
	public static Block GARASUDOH_ACA = register("block_garasudohalf_acacia", glassdoorHalf());
	public static Block GARASUDOH_DOAK = register("block_garasudohalf_darkoak", glassdoorHalf());
	public static Block GARASUDOH_SAKU = register("block_garasudohalf_sakura", glassdoorHalf());
	public static Block GARASUDOH_KAE = register("block_garasudohalf_kaede", glassdoorHalf());
	public static Block GARASUDOH_ICH = register("block_garasudohalf_ichoh", glassdoorHalf());

	public static Block SHOUJI = register("block_shouji", shouji());
	public static Block SHOUJI_SPRU = register("block_shouji_spruce", shouji());
	public static Block SHOUJI_BIR = register("block_shouji_birch", shouji());
	public static Block SHOUJI_JUN = register("block_shouji_jungle", shouji());
	public static Block SHOUJI_ACA = register("block_shouji_acacia", shouji());
	public static Block SHOUJI_DOAK = register("block_shouji_darkoak", shouji());
	public static Block SHOUJI_SAKU = register("block_shouji_sakura", shouji());
	public static Block SHOUJI_KAE = register("block_shouji_kaede", shouji());
	public static Block SHOUJI_ICH = register("block_shouji_ichoh", shouji());

	public static Block SHOUJIB = register("block_shoujib", shouji());
	public static Block SHOUJIB_SPRU = register("block_shoujib_spruce", shouji());
	public static Block SHOUJIB_BIR = register("block_shoujib_birch", shouji());
	public static Block SHOUJIB_JUN = register("block_shoujib_jungle", shouji());
	public static Block SHOUJIB_ACA = register("block_shoujib_acacia", shouji());
	public static Block SHOUJIB_DOAK = register("block_shoujib_darkoak", shouji());
	public static Block SHOUJIB_SAKU = register("block_shoujib_sakura", shouji());
	public static Block SHOUJIB_KAE = register("block_shoujib_kaede", shouji());
	public static Block SHOUJIB_ICH = register("block_shoujib_ichoh", shouji());

	public static Block SHOUJIH = register("block_shoujihalf", shoujiHalf());
	public static Block SHOUJIH_SPRU = register("block_shoujihalf_spruce", shoujiHalf());
	public static Block SHOUJIH_BIR = register("block_shoujihalf_birch", shoujiHalf());
	public static Block SHOUJIH_JUN = register("block_shoujihalf_jungle", shoujiHalf());
	public static Block SHOUJIH_ACA = register("block_shoujihalf_acacia", shoujiHalf());
	public static Block SHOUJIH_DOAK = register("block_shoujihalf_darkoak", shoujiHalf());
	public static Block SHOUJIH_SAKU = register("block_shoujihalf_sakura", shoujiHalf());
	public static Block SHOUJIH_KAE = register("block_shoujihalf_kaede", shoujiHalf());
	public static Block SHOUJIH_ICH = register("block_shoujihalf_ichoh", shoujiHalf());

	public static Block SHOUJI_WIN = register("block_shoujih", shoujiWin());
	public static Block SHOUJI_WIN_SPRU = register("block_shoujih_spruce", shoujiWin());
	public static Block SHOUJI_WIN_BIR = register("block_shoujih_birch", shoujiWin());
	public static Block SHOUJI_WIN_JUN = register("block_shoujih_jungle", shoujiWin());
	public static Block SHOUJI_WIN_ACA = register("block_shoujih_acacia", shoujiWin());
	public static Block SHOUJI_WIN_DOAK = register("block_shoujih_darkoak", shoujiWin());
	public static Block SHOUJI_WIN_SAKU = register("block_shoujih_sakura", shoujiWin());
	public static Block SHOUJI_WIN_KAE = register("block_shoujih_kaede", shoujiWin());
	public static Block SHOUJI_WIN_ICH = register("block_shoujih_ichoh", shoujiWin());

	public static Block SHOUJI_WINR = register("block_shoujihr", shoujiWin());
	public static Block SHOUJI_WINR_SPRU = register("block_shoujihr_spruce", shoujiWin());
	public static Block SHOUJI_WINR_BIR = register("block_shoujihr_birch", shoujiWin());
	public static Block SHOUJI_WINR_JUN = register("block_shoujihr_jungle", shoujiWin());
	public static Block SHOUJI_WINR_ACA = register("block_shoujihr_acacia", shoujiWin());
	public static Block SHOUJI_WINR_DOAK = register("block_shoujihr_darkoak", shoujiWin());
	public static Block SHOUJI_WINR_SAKU = register("block_shoujihr_sakura", shoujiWin());
	public static Block SHOUJI_WINR_KAE = register("block_shoujihr_kaede", shoujiWin());
	public static Block SHOUJI_WINR_ICH = register("block_shoujihr_ichoh", shoujiWin());

	public static Block AMADO_S = register("block_amado_spruce", new Amado(amadoState()));
	public static Block TOBUKURO_S = register("block_tobukuro_spruce", new Tobukuro(amadoState()));
	public static Block TOBUKURO_SL = register("block_tobukuro_sprucel", new Tobukuro_L(amadoState()));

	public static Block AMADOWIN_S = register("block_amadowin_spruce", new AmadoWindow(amadoState()));
	public static Block TOBUKUROWIN_S = register("block_tobukurowin_spruce", new TobukuroWindow(amadoState()));

	public static Block AMADO = register("block_amado", new Amado(amadoState()));
	public static Block TOBUKURO = register("block_tobukuro", new Tobukuro(amadoState()));
	public static Block TOBUKURO_L = register("block_tobukuro_l", new Tobukuro_L(amadoState()));

	public static Block AMADOWIN = register("block_amadowin", new AmadoWindow(amadoState()));
	public static Block TOBUKUROWIN = register("block_tobukurowin", new TobukuroWindow(amadoState()));

	/* Share variables */
	private static Fusuma fusuma() {
		return new Fusuma(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid());
	}

	private static Fusuma_B fusumaBtype() {
		return new Fusuma_B(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid());
	}

	private static GlassDoor glassdoor() {
		return new GlassDoor(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid());
	}

	private static GlassDoorHalf glassdoorHalf() {
		return new GlassDoorHalf(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid());
	}

	private static Shouji shouji() {
		return new Shouji(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid());
	}

	private static ShoujiHalf shoujiHalf() {
		return new ShoujiHalf(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid());
	}

	private static ShoujiWindow shoujiWin() {
		return new ShoujiWindow(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid());
	}

	private static Properties amadoState() {
		return Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 5.0F).sound(SoundType.WOOD).notSolid();
	}
	
	///* Register *///
	private static Block register(String name, Block block) {
		BLOCKS.register(name, () -> block);
		return block;
	}
}
