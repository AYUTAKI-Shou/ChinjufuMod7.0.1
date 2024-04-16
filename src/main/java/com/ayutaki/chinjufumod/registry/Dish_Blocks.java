package com.ayutaki.chinjufumod.registry;

import java.util.function.ToIntFunction;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.dish.Chauke_Mikan;
import com.ayutaki.chinjufumod.blocks.dish.Chauke_Scone;
import com.ayutaki.chinjufumod.blocks.dish.Chauke_Senbei;
import com.ayutaki.chinjufumod.blocks.dish.Chicken_Roast;
import com.ayutaki.chinjufumod.blocks.dish.Chicken_small;
import com.ayutaki.chinjufumod.blocks.dish.Corn_Soup;
import com.ayutaki.chinjufumod.blocks.dish.Curry;
import com.ayutaki.chinjufumod.blocks.dish.Curry_set;
import com.ayutaki.chinjufumod.blocks.dish.Donburi;
import com.ayutaki.chinjufumod.blocks.dish.EggBurg;
import com.ayutaki.chinjufumod.blocks.dish.EggBurg_set;
import com.ayutaki.chinjufumod.blocks.dish.Frypan_Curry;
import com.ayutaki.chinjufumod.blocks.dish.Frypan_DonNama;
import com.ayutaki.chinjufumod.blocks.dish.Frypan_Katsu;
import com.ayutaki.chinjufumod.blocks.dish.Frypan_KinokoAK;
import com.ayutaki.chinjufumod.blocks.dish.Frypan_OSauce;
import com.ayutaki.chinjufumod.blocks.dish.Frypan_PastaNama;
import com.ayutaki.chinjufumod.blocks.dish.Frypan_TakePlate;
import com.ayutaki.chinjufumod.blocks.dish.Frypan_kara;
import com.ayutaki.chinjufumod.blocks.dish.Gohan;
import com.ayutaki.chinjufumod.blocks.dish.Hakusai_Duke;
import com.ayutaki.chinjufumod.blocks.dish.IceCream;
import com.ayutaki.chinjufumod.blocks.dish.Irori_Sakana_C;
import com.ayutaki.chinjufumod.blocks.dish.Irori_Sakana_E1;
import com.ayutaki.chinjufumod.blocks.dish.Irori_Sakana_E2;
import com.ayutaki.chinjufumod.blocks.dish.Irori_Sakana_R1;
import com.ayutaki.chinjufumod.blocks.dish.Irori_Sakana_R2;
import com.ayutaki.chinjufumod.blocks.dish.JPTeaCup;
import com.ayutaki.chinjufumod.blocks.dish.JPTeaKyusu;
import com.ayutaki.chinjufumod.blocks.dish.JPTea_Set;
import com.ayutaki.chinjufumod.blocks.dish.Kettle_full;
import com.ayutaki.chinjufumod.blocks.dish.Kettle_kara;
import com.ayutaki.chinjufumod.blocks.dish.MeasureCup;
import com.ayutaki.chinjufumod.blocks.dish.Miso_Soup;
import com.ayutaki.chinjufumod.blocks.dish.Nabe2_Shio;
import com.ayutaki.chinjufumod.blocks.dish.Nabe2_TakeBowl;
import com.ayutaki.chinjufumod.blocks.dish.Nabe2_Toufu;
import com.ayutaki.chinjufumod.blocks.dish.NabeCorn;
import com.ayutaki.chinjufumod.blocks.dish.NabeGohan;
import com.ayutaki.chinjufumod.blocks.dish.NabeGohan_TakeKuri;
import com.ayutaki.chinjufumod.blocks.dish.NabeMiso;
import com.ayutaki.chinjufumod.blocks.dish.NabeTori;
import com.ayutaki.chinjufumod.blocks.dish.Nabe_GohanNama;
import com.ayutaki.chinjufumod.blocks.dish.Nabe_SoupNama;
import com.ayutaki.chinjufumod.blocks.dish.Nabe_kara;
import com.ayutaki.chinjufumod.blocks.dish.Niboshi;
import com.ayutaki.chinjufumod.blocks.dish.Okonomiyaki;
import com.ayutaki.chinjufumod.blocks.dish.Pasta;
import com.ayutaki.chinjufumod.blocks.dish.PastaSeafood;
import com.ayutaki.chinjufumod.blocks.dish.Pizza_5;
import com.ayutaki.chinjufumod.blocks.dish.Ramen;
import com.ayutaki.chinjufumod.blocks.dish.RiceDish;
import com.ayutaki.chinjufumod.blocks.dish.SconeSet_1;
import com.ayutaki.chinjufumod.blocks.dish.SconeSet_kara;
import com.ayutaki.chinjufumod.blocks.dish.ShouyuSara_1;
import com.ayutaki.chinjufumod.blocks.dish.Stew;
import com.ayutaki.chinjufumod.blocks.dish.SushiGeta_full;
import com.ayutaki.chinjufumod.blocks.dish.SushiGeta_kara1_5;
import com.ayutaki.chinjufumod.blocks.dish.SushiMeshi;
import com.ayutaki.chinjufumod.blocks.dish.SushiOke;
import com.ayutaki.chinjufumod.blocks.dish.SushiOkeFull_1;
import com.ayutaki.chinjufumod.blocks.dish.SushiOkeFull_9;
import com.ayutaki.chinjufumod.blocks.dish.SushiSet;
import com.ayutaki.chinjufumod.blocks.dish.Tamagoyaki;
import com.ayutaki.chinjufumod.blocks.dish.Tamagoyaki_set;
import com.ayutaki.chinjufumod.blocks.dish.TeaCup;
import com.ayutaki.chinjufumod.blocks.dish.TeaPot;
import com.ayutaki.chinjufumod.blocks.dish.Tea_Set;
import com.ayutaki.chinjufumod.blocks.dish.Teppan_4empty;
import com.ayutaki.chinjufumod.blocks.dish.Teppan_4emptyC;
import com.ayutaki.chinjufumod.blocks.dish.Teppan_5th;
import com.ayutaki.chinjufumod.blocks.dish.Teppan_Stage4;
import com.ayutaki.chinjufumod.blocks.dish.Teppan_Stage4C;
import com.ayutaki.chinjufumod.blocks.dish.Tonsui;
import com.ayutaki.chinjufumod.blocks.dish.Udon;
import com.ayutaki.chinjufumod.blocks.dish.YakiJyake_set;
import com.ayutaki.chinjufumod.blocks.dish.YakiZakana_set;
import com.ayutaki.chinjufumod.blocks.dish.Zundou;
import com.ayutaki.chinjufumod.blocks.dish.Zundou4_Curry;
import com.ayutaki.chinjufumod.blocks.dish.Zundou4_Dashi;
import com.ayutaki.chinjufumod.blocks.dish.Zundou4_Fish;
import com.ayutaki.chinjufumod.blocks.dish.Zundou4_Oriito;
import com.ayutaki.chinjufumod.blocks.dish.Zundou4_Pasta;
import com.ayutaki.chinjufumod.blocks.dish.Zundou4_RSoup;
import com.ayutaki.chinjufumod.blocks.dish.Zundou4_RSoup_nama;
import com.ayutaki.chinjufumod.blocks.dish.Zundou4_Ramen;
import com.ayutaki.chinjufumod.blocks.dish.Zundou4_Stew;
import com.ayutaki.chinjufumod.blocks.dish.Zundou4_Udon;
import com.ayutaki.chinjufumod.blocks.dish.Zundou_Aku;
import com.ayutaki.chinjufumod.blocks.dish.Zundou_Milk;
import com.ayutaki.chinjufumod.blocks.dish.Zundou_Mizu;
import com.ayutaki.chinjufumod.blocks.dish.Zundou_NamaCurry;
import com.ayutaki.chinjufumod.blocks.dish.Zundou_NamaStew;
import com.ayutaki.chinjufumod.blocks.dish.Zundou_Shio;
import com.ayutaki.chinjufumod.blocks.hakkou.Bot_Dashi;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Dish_Blocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);

	public static Block ZUNDOU = register("block_food_zundou", new Zundou(metalDish()));
	public static Block ZUNDOU_MIZU = register("block_zundou_mizu", new Zundou_Mizu(metalDish()));
	public static Block ZUNDOU_SHIO = register("block_zundou_shiomizu", new Zundou_Shio(metalDish()));
	public static Block ZUNDOU_MILK = register("block_zundou_milk", new Zundou_Milk(metalDish()));

	public static Block ZUNDOU_NCURRY = register("block_food_cunabe_n", new Zundou_NamaCurry(metalDish()));
	public static Block ZUNDOU_CURRY = register("block_food_cunabe_1", new Zundou4_Curry(metalDish()));
	public static Block ZUNDOU_NCURRY_C = register("block_food_cunabe_cn", new Zundou_NamaCurry(metalDish()));
	public static Block ZUNDOU_CURRY_C = register("block_food_cunabe_c1", new Zundou4_Curry(metalDish()));
	public static Block ZUNDOU_NCURRY_T = register("block_food_cunabe_tn", new Zundou_NamaCurry(metalDish()));
	public static Block ZUNDOU_CURRY_T = register("block_food_cunabe_t1", new Zundou4_Curry(metalDish()));
	public static Block ZUNDOU_NSTEW = register("block_food_stewnabe_n", new Zundou_NamaStew(metalDish()));
	public static Block ZUNDOU_STEW = register("block_food_stewnabe_1", new Zundou4_Stew(metalDish()));

	public static Block ZUNDOU_FISH = register("block_zundou_fish", new Zundou4_Fish(metalDish()));
	public static Block ZUNDOU_DASHI = register("block_food_dashinabe_1", new Zundou4_Dashi(metalDish()));
	public static Block ZUNDOU_UDON = register("block_zundou_udon", new Zundou4_Udon(metalDish()));
	public static Block ZUNDOU_PASTA = register("block_zundou_pasta", new Zundou4_Pasta(metalDish()));
	/** 6.4.1 **/ 
	public static Block ZUNDOU_RSOUP_nama = register("block_food_rsoup_n", new Zundou4_RSoup_nama(metalDish()));
	public static Block ZUNDOU_RSOUP = register("block_food_rsoup_1", new Zundou4_RSoup(metalDish()));
	public static Block ZUNDOU_RAMEN = register("block_zundou_ramen", new Zundou4_Ramen(metalDish()));

	public static Block ZUNDOU_AKU = register("block_zundou_aku", new Zundou_Aku(metalDish()));
	public static Block ZUNDOU_ORIITO = register("block_zundou_oriito", new Zundou4_Oriito(metalDish()));

	public static Block NABE_kara = register("block_food_karanabe", new Nabe_kara(stoneDish()));
	public static Block NABETORI_nama = register("block_food_nabe_n", new Nabe_SoupNama(stoneDish()));
	public static Block NABEMISO_nama = register("block_food_nabemiso_n", new Nabe_SoupNama(stoneDish()));
	public static Block NABEGOHAN_nama = register("block_food_nabegohan_n", new Nabe_GohanNama(stoneDish()));
	public static Block NABEGOHANTAKE_nama = register("block_food_nabegohantake_n", new Nabe_GohanNama(stoneDish()));
	public static Block NABEGOHANKURI_nama = register("block_food_nabegohankuri_n", new Nabe_GohanNama(stoneDish()));
	public static Block NABECORN_nama = register("block_food_nabecorns_n", new Nabe_SoupNama(stoneDish()));
	public static Block NABESHIO_nama = register("block_food_nabeshio_n", new Nabe2_Shio(stoneDish()));
	public static Block NABENIMAME_nama = register("block_food_nabenimame_n", new Nabe2_TakeBowl(stoneDish()));
	public static Block NABETOUFU_nama = register("block_food_nabetoufu_n", new Nabe2_Toufu(stoneDish()));
	public static Block KURI_NABE_nama = register("block_food_nabekuri_n", new Nabe2_TakeBowl(stoneDish()));
	
	public static Block NABETORI = register("block_food_nabe_1", new NabeTori(stoneDish()));
	public static Block NABEMISO = register("block_food_nabemiso_1", new NabeMiso(stoneDish()));
	public static Block NABEGOHAN = register("block_food_nabegohan_1", new NabeGohan(stoneDish()));
	public static Block NABEGOHAN_TAKE = register("block_food_nabegohantake_1", new NabeGohan_TakeKuri(stoneDish()));
	public static Block NABEGOHAN_KURI = register("block_food_nabegohankuri_1", new NabeGohan_TakeKuri(stoneDish()));
	public static Block NABECORN = register("block_food_nabecorns_1", new NabeCorn(stoneDish()));

	public static Block OSAUCE_bot_1 = register("block_osauce_bot", new Bot_Dashi(stoneState()));
	public static Block OSAUCE_bot_2 = register("block_osauce_bot_2", new Bot_Dashi(stoneState()));
	public static Block OSAUCE_bot_3 = register("block_osauce_bot_3", new Bot_Dashi(stoneState()));
	public static Block OSAUCE_bot_4 = register("block_osauce_bot_4", new Bot_Dashi(stoneState()));
	public static Block MAYO_bot_1 = register("block_mayo_bot", new Bot_Dashi(stoneState()));
	public static Block MAYO_bot_2 = register("block_mayo_bot_2", new Bot_Dashi(stoneState()));
	public static Block MAYO_bot_3 = register("block_mayo_bot_3", new Bot_Dashi(stoneState()));
	public static Block MAYO_bot_4 = register("block_mayo_bot_4", new Bot_Dashi(stoneState()));
	
	public static Block KEIRYO_CUP = register("block_measurecup", new MeasureCup(stoneDish()));

	public static Block FRYPAN_kara = register("block_food_frypan", new Frypan_kara(metalDish().lightLevel(litAntiShadow(1))));
	public static Block FPTAMAGO_nama = register("block_food_frypan_n_tamago", new Frypan_TakePlate(metalDish().lightLevel(litAntiShadow(1))));
	public static Block FPGYUDON_nama = register("block_food_frypan_n_gyudon", new Frypan_DonNama(metalDish().lightLevel(litAntiShadow(1))));
	public static Block FPOYAKODON_nama = register("block_food_frypan_n_oyakodon", new Frypan_DonNama(metalDish().lightLevel(litAntiShadow(1))));
	public static Block FPKATSU_nama = register("block_food_frypan_n_katsu", new Frypan_Katsu(metalDish().lightLevel(litAntiShadow(1))));
	public static Block FPKATSUDON_nama = register("block_food_frypan_n_katsudon", new Frypan_DonNama(metalDish().lightLevel(litAntiShadow(1))));
	public static Block FPEGGBURG_nama = register("block_food_frypan_n_eggb", new Frypan_TakePlate(metalDish().lightLevel(litAntiShadow(1))));
	public static Block FPTOMATO_nama = register("block_food_frypan_n_tomatos", new Frypan_PastaNama(metalDish().lightLevel(litAntiShadow(1))));
	public static Block FPKINOKO_nama = register("block_food_frypan_n_kinokos", new Frypan_PastaNama(metalDish().lightLevel(litAntiShadow(1))));
	public static Block FPSEAFOOD_nama = register("block_food_frypan_n_seafood", new Frypan_PastaNama(metalDish().lightLevel(litAntiShadow(1))));
	public static Block FPKINOKOAK_nama = register("block_food_frypan_n_kinokoak", new Frypan_KinokoAK(metalDish().lightLevel(litAntiShadow(1))));
	public static Block FPCURRY_nama = register("block_food_frypan_n_roux", new Frypan_Curry(metalDish().lightLevel(litAntiShadow(1))));

	public static Block FPOSAUCE_nama = register("block_food_frypan_n_osauce", new Frypan_OSauce(metalDish().lightLevel(litAntiShadow(1))));
	public static Block OKONOMIYAKI_nama = register("block_food_teppan_n_okonomiyaki", new Teppan_4empty(snowDish()));
	public static Block OKONOMIS_nama = register("block_food_teppan_n_okonomis", new Teppan_4empty(snowDish()));
	public static Block OKONOMIC_nama = register("block_food_teppan_n_okonomic", new Teppan_4empty(snowDish()));
	public static Block OKONOMISOBA_nama = register("block_food_teppan_n_okonomisoba", new Teppan_Stage4(snowDish()));
	public static Block OKONOMISOBAS_nama = register("block_food_teppan_n_okonomisobas", new Teppan_Stage4(snowDish()));
	public static Block OKONOMISOBAC_nama = register("block_food_teppan_n_okonomisobac", new Teppan_Stage4(snowDish()));
	public static Block YAKISOBA_nama = register("block_food_teppan_n_yakisoba", new Teppan_Stage4(snowDish()));
	public static Block YAKISOBASHIO_nama = register("block_food_teppan_n_yakisobashio", new Teppan_Stage4(snowDish()));
	
	public static Block OKONOMIYAKI_click = register("block_food_teppan_c_okonomiyaki", new Teppan_4emptyC(snowDish()));
	public static Block OKONOMIS_click = register("block_food_teppan_c_okonomis", new Teppan_4emptyC(snowDish()));
	public static Block OKONOMIC_click = register("block_food_teppan_c_okonomic", new Teppan_4emptyC(snowDish()));
	public static Block OKONOMISOBA_click = register("block_food_teppan_c_okonomisoba", new Teppan_Stage4C(snowDish()));
	public static Block OKONOMISOBAS_click = register("block_food_teppan_c_okonomisobas", new Teppan_Stage4C(snowDish()));
	public static Block OKONOMISOBAC_click = register("block_food_teppan_c_okonomisobac", new Teppan_Stage4C(snowDish()));
	public static Block YAKISOBA_click = register("block_food_teppan_c_yakisoba", new Teppan_Stage4C(snowDish()));
	public static Block YAKISOBASHIO_click = register("block_food_teppan_c_yakisobashio", new Teppan_Stage4C(snowDish()));

	public static Block OKONOMISOBA_5 = register("block_food_teppan_5_okonomisoba", new Teppan_5th(snowDish()));
	public static Block OKONOMISOBAS_5 = register("block_food_teppan_5_okonomisobas", new Teppan_5th(snowDish()));
	public static Block OKONOMISOBAC_5 = register("block_food_teppan_5_okonomisobac", new Teppan_5th(snowDish()));
	
	public static Block NIBOSHI = register("block_niboshi", new Niboshi(snowDish().randomTicks()));

	public static Block CURRY = register("block_food_curry_1", new Curry(stoneDish()));
	public static Block CURRYSET = register("block_food_curryset_1", new Curry_set(stoneDish()));
	public static Block CURRY_C = register("block_food_curry_c1", new Curry(stoneDish()));
	public static Block CURRYSET_C = register("block_food_curryset_c1", new Curry_set(stoneDish()));
	public static Block CURRY_T = register("block_food_curry_t1", new Curry(stoneDish()));
	public static Block CURRYSET_T = register("block_food_curryset_t1", new Curry_set(stoneDish()));
	public static Block STEW = register("block_food_stew_1", new Stew(stoneDish()));

	public static Block UDON_SU = register("block_food_udonsu_1", new Udon(stoneDish()));
	public static Block UDON_NIKU = register("block_food_udonniku_1", new Udon(stoneDish()));
	public static Block UDON_TSUKIMI = register("block_food_udontsukimi_1", new Udon(stoneDish()));
	/** 6.4.1 **/ 
	public static Block RAMEN_SHOUYU = register("block_food_ramenshouyu_1", new Ramen(stoneDish()));
	public static Block RAMEN_MISO = register("block_food_ramenmiso_1", new Ramen(stoneDish()));
	public static Block RAMEN_SHIO = register("block_food_ramenshio_1", new Ramen(stoneDish()));

	public static Block TONSUITORI = register("block_food_tonsui_1", new Tonsui(stoneDish()));
	public static Block MISOSOUP = register("block_food_misosp_1", new Miso_Soup(woodDish()));
	public static Block GOHAN = register("block_food_gohan_1", new Gohan(stoneDish()));
	public static Block GOHAN_TAKE = register("block_food_gohantake_1", new Gohan(stoneDish()));
	public static Block GOHAN_KURI = register("block_food_gohankuri_1", new Gohan(stoneDish()));
	public static Block RICE = register("block_food_rice_1", new RiceDish(stoneDish()));
	public static Block DONBURI_MESHI = register("block_food_donmeshi_1", new Donburi(stoneDish()));

	public static Block DONBURI_GYU = register("block_food_dongyu_1", new Donburi(stoneDish()));
	public static Block DONBURI_OYAKO = register("block_food_donoyako_1", new Donburi(stoneDish()));
	public static Block DONBURI_KATSU = register("block_food_donkatsu_1", new Donburi(stoneDish()));
	public static Block DONBURI_KAISEN = register("block_food_donkaisen_1", new Donburi(stoneDish()));
	
	public static Block HAKUSAIDUKE = register("block_food_hsd_1", new Hakusai_Duke(stoneDish()));
	public static Block TAMAGOYAKI = register("block_food_tgy_1", new Tamagoyaki(stoneDish()));

	public static Block TAMAGOYAKITEI = register("block_food_tgytei_1", new Tamagoyaki_set(stoneDish()));
	public static Block YAKIZAKANATEI = register("block_food_yakizakanatei_1", new YakiZakana_set(stoneDish()));
	public static Block YAKIJYAKETEI = register("block_food_yakijyaketei_1", new YakiJyake_set(stoneDish()));
	public static Block TAMAGOYAKITEI_TAKE = register("block_food_tgyteitake_1", new Tamagoyaki_set(stoneDish()));
	public static Block YAKIZAKANATEI_TAKE = register("block_food_yakizakanateitake_1", new YakiZakana_set(stoneDish()));
	public static Block YAKIJYAKETEI_TAKE = register("block_food_yakijyaketeitake_1", new YakiJyake_set(stoneDish()));
	public static Block TAMAGOYAKITEI_KURI = register("block_food_tgyteikuri_1", new Tamagoyaki_set(stoneDish()));
	public static Block YAKIZAKANATEI_KURI = register("block_food_yakizakanateikuri_1", new YakiZakana_set(stoneDish()));
	public static Block YAKIJYAKETEI_KURI = register("block_food_yakijyaketeikuri_1", new YakiJyake_set(stoneDish()));
	
	public static Block CORNSOUP = register("block_food_cornsp_1", new Corn_Soup(stoneDish()));
	public static Block EGGBURG = register("block_food_egb_1", new EggBurg(stoneDish()));
	public static Block EGGBURGSET = register("block_food_egbset_1", new EggBurg_set(stoneDish()));

	public static Block PASTATOMATO = register("block_food_pastatoma_1", new Pasta(stoneDish()));
	public static Block PASTACHEESE = register("block_food_pastacheese_1", new Pasta(stoneDish()));
	public static Block PASTAKINOKO = register("block_food_pastakinoko_1", new Pasta(stoneDish()));
	public static Block PASTASEAFOOD = register("block_food_pastaseafood_1", new PastaSeafood(stoneDish()));
	public static Block PIZZA = register("block_food_pizza_1", new Pizza_5(woodDish()));
	public static Block PIZZA_C = register("block_food_pizza_c1", new Pizza_5(woodDish()));
	public static Block PIZZA_T = register("block_food_pizza_t1", new Pizza_5(woodDish()));
	public static Block PIZZA_S = register("block_food_pizza_s1", new Pizza_5(woodDish()));
	public static Block OKONOMIYAKI = register("block_food_okonomiyaki_1", new Okonomiyaki(stoneDish()));
	public static Block OKONOMIS = register("block_food_okonomis_1", new Okonomiyaki(stoneDish()));
	public static Block OKONOMIC = register("block_food_okonomic_1", new Okonomiyaki(stoneDish()));
	public static Block OKONOMISOBA = register("block_food_okonomisoba_1", new Okonomiyaki(stoneDish()));
	public static Block OKONOMISOBAS = register("block_food_okonomisobas_1", new Okonomiyaki(stoneDish()));
	public static Block OKONOMISOBAC = register("block_food_okonomisobac_1", new Okonomiyaki(stoneDish()));
	public static Block YAKISOBA = register("block_food_yakisoba_1", new Pasta(stoneDish()));
	public static Block YAKISOBASHIO = register("block_food_yakisobashio_1", new Pasta(stoneDish()));
	
	public static Block CHICKEN = register("block_food_roastchicken_1", new Chicken_Roast(stoneDish()));
	public static Block CHICKEN_small = register("block_food_chickenb_1", new Chicken_small(stoneDish()));

	public static Block SUSHIMESHI = register("block_food_sushimeshi", new SushiMeshi(woodDish()));
	public static Block SUSHIGETA_kara = register("block_food_sushigeta_kara", new SushiGeta_kara1_5(woodDish()));
	public static Block SUSHIGETA_salmon = register("block_food_sushigeta_salmon", new SushiGeta_full(woodDish()));
	public static Block SUSHIGETA_fish = register("block_food_sushigeta_fish", new SushiGeta_full(woodDish()));
	public static Block SUSHIGETA_beef = register("block_food_sushigeta_beef", new SushiGeta_full(woodDish()));
	public static Block SUSHIGETA_tamago = register("block_food_sushigeta_tamago", new SushiGeta_full(woodDish()));

	public static Block SUSHISET_salmon = register("block_food_sushiset_salmon", new SushiSet(woodDish()));
	public static Block SUSHISET_fish = register("block_food_sushiset_fish", new SushiSet(woodDish()));
	public static Block SUSHISET_beef = register("block_food_sushiset_beef", new SushiSet(woodDish()));
	public static Block SUSHISET_tamago = register("block_food_sushiset_tamago", new SushiSet(woodDish()));
	public static Block SUSHISET_4shoku = register("block_food_sushiset_4shoku", new SushiSet(woodDish()));

	public static Block SUSHIOKE = register("block_food_sushioke_kara", new SushiOke(woodDish()));
	public static Block SUSHIOKE_FULL_1 = register("block_food_sushiokefull_1", new SushiOkeFull_1(woodDish()));
	public static Block SUSHIOKE_FULL_9 = register("block_food_sushiokefull_9", new SushiOkeFull_9(woodDish()));
	public static Block SHOUYUSARA_1 = register("block_food_shouyusara_1", new ShouyuSara_1(stoneDish()));

	public static Block KETTLE_kara = register("item_kettle_kara", new Kettle_kara(metalDish()));
	public static Block KETTLE_full = register("block_kettle_full", new Kettle_full(metalDish()));

	public static Block KYUSU = register("block_food_kyusu_1", new JPTeaKyusu(stoneDish()));
	public static Block JPTEACUP = register("block_food_jpteacup_1", new JPTeaCup(stoneDish()));
	public static Block JPTEASET = register("block_food_jpteaset_1", new JPTea_Set(stoneDish()));
	public static Block CHAUKE_SENBEI = register("block_food_senbei", new Chauke_Senbei(woodDish()));
	public static Block CHAUKE_MIKAN = register("block_food_mikan", new Chauke_Mikan(woodDish()));

	public static Block TEAPOT = register("block_food_teapot_1", new TeaPot(stoneDish()));
	public static Block TEACUP = register("block_food_teacup_1", new TeaCup(stoneDish()));
	public static Block TEASET = register("block_food_teaset_1", new Tea_Set(stoneDish()));
	public static Block CHAUKE_SCONE = register("block_food_scone", new Chauke_Scone(stoneDish()));

	public static Block SCONESET_kara = register("block_food_teastand", new SconeSet_kara(metalDish()));
	public static Block SCONESET_1 = register("block_food_sconeset_1", new SconeSet_1(metalDish()));
	public static Block ICECREAM = register("block_food_icecream_1", new IceCream(stoneDish()));

	public static Block IRORISAKANA_E1 = register("block_irori_sakana_e1", new Irori_Sakana_E1(snowDish()));
	public static Block IRORISAKANA_E2 = register("block_irori_sakana_e2", new Irori_Sakana_E2(snowDish()));
	public static Block IRORISAKANA_R1 = register("block_irori_sakana_r1", new Irori_Sakana_R1(snowDish()));
	public static Block IRORISAKANA_R2 = register("block_irori_sakana_r2", new Irori_Sakana_R2(snowDish()));
	public static Block IRORISAKANA_C = register("block_irori_sakana_c", new Irori_Sakana_C(snowDish()));

	/* Share variables */
	public static ToIntFunction<BlockState> litAntiShadow(int value) {
		return (state) -> { return value; };
	}

	private static boolean never(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	private static Boolean neverEntity(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> entity) {
		return (boolean)false;
	}

	private static Properties metalDish() {
		return AbstractBlock.Properties.of(Material.METAL).noCollission().strength(1.0F, 3.0F).sound(SoundType.METAL).noOcclusion()
				.isValidSpawn(Dish_Blocks::neverEntity).isSuffocating(Dish_Blocks::never);
	}
	
	private static Properties stoneDish() {
		return AbstractBlock.Properties.of(Material.STONE).noCollission().strength(1.0F, 3.0F).sound(SoundType.STONE).noOcclusion()
				.isValidSpawn(Dish_Blocks::neverEntity).isSuffocating(Dish_Blocks::never);
	}
	
	private static Properties woodDish() {
		return AbstractBlock.Properties.of(Material.WOOD).noCollission().strength(1.0F, 3.0F).sound(SoundType.WOOD).noOcclusion()
				.isValidSpawn(Dish_Blocks::neverEntity).isSuffocating(Dish_Blocks::never);
	}
	
	private static Properties snowDish() {
		return AbstractBlock.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.SNOW).noOcclusion()
				.isValidSpawn(Dish_Blocks::neverEntity).isSuffocating(Dish_Blocks::never);
	}
	
	private static Properties stoneState() {
		return AbstractBlock.Properties.of(Material.STONE).noCollission().strength(1.0F, 1.0F).sound(SoundType.STONE).noOcclusion()
				.isValidSpawn(Dish_Blocks::neverEntity).isSuffocating(Dish_Blocks::never);
	}
	
	///* Register *///
	private static Block register(String name, Block block) {
		BLOCKS.register(name, () -> block);
		return block;
	}
}
