package com.ayutaki.chinjufumod.handler;

import com.ayutaki.chinjufumod.ChinjufuMod;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundEvents_CM {

	public static SoundEvent AM_CARTRIDGE, AM_CARTRIDGE2, AM_CARTRIDGE3, AM_FIRE, AM_IMPACT, AM_HIT, SET_GUN, EMPTY_AMMO;
	public static SoundEvent KK_ATACK, KK_ATACK2, KK_START, KK_BREAK, KK_IMPACT, KK_PROPELLER, KK_PROPELLER12, KK_STOP, GYORAI;
	public static SoundEvent WATER_WAKE, WATER_SPLASH;

	public static SoundEvent JUU, GUTSUGUTSU, TEA, SAKE, SHOUYU, PAKU, GOKU,
										WATER_START, WATER_STOP, KITCHEN_CUT;

	public static SoundEvent TANSU_OPEN, TANSU_CLOSE, WINDOW_OPEN, WINDOW_CLOSE, WINDOW_UD,
										FUSUMA, FUSUMA_SHORT, AMADO_CANCEL, HIKIDO, HIKIDO_SHORT,
										KINUZURE, SIT_CHAIR, SHISHIODOSHI,
										GATE_WOOD, GATE_IRON_OPEN, GATE_IRON_CLOSE, PAINT;

	public static SoundEvent WADAIKO_TOP, WADAIKO_SIDE, CURTAIN;

	public static SoundEvent WRITE_REPORT, OPEN, OPEN_OVEN, REIZOU_OPEN, REIZOU_CLOSE;
	public static SoundEvent TOUCH_BLOCK, THROW, SWING, ERROR, NOISE;
	
	public static void registerSounds() {

		AM_CARTRIDGE = registerSound("am_cartridge");
		AM_CARTRIDGE2 = registerSound("am_cartridge2");
		AM_CARTRIDGE3 = registerSound("am_cartridge3");
		AM_FIRE = registerSound("am_fire");
		AM_IMPACT = registerSound("am_impact");
		AM_HIT = registerSound("am_hit");
		
		KK_ATACK = registerSound("kk_atack");
		KK_ATACK2 = registerSound("kk_atack2");
		KK_START = registerSound("kk_starting");
		KK_BREAK = registerSound("kk_break");
		KK_IMPACT = registerSound("kk_impact");
		KK_PROPELLER = registerSound("kk_propeller");
		KK_PROPELLER12 = registerSound("kk_propeller_12");
		KK_STOP = registerSound("kk_stop");
		GYORAI = registerSound("gyorai");
		SET_GUN = registerSound("set_gun");
		EMPTY_AMMO = registerSound("empty_ammo");
		
		WATER_WAKE = registerSound("wake_water");
		WATER_SPLASH = registerSound("water_splash");

		JUU = registerSound("juu");
		GUTSUGUTSU = registerSound("gutsugutsu");
		TEA = registerSound("tea");
		SAKE = registerSound("sake");
		SHOUYU = registerSound("shouyu");
		PAKU = registerSound("paku");
		GOKU = registerSound("goku");
		WATER_START = registerSound("water_start");
		WATER_STOP = registerSound("water_stop");
		KITCHEN_CUT = registerSound("kitchen_cut");

		TANSU_OPEN = registerSound("tansu_open");
		TANSU_CLOSE = registerSound("tansu_close");

		WINDOW_OPEN = registerSound("window_open");
		WINDOW_CLOSE = registerSound("window_close");
		WINDOW_UD = registerSound("window_updown");
		FUSUMA = registerSound("fusuma");
		FUSUMA_SHORT = registerSound("fusuma_short");
		AMADO_CANCEL = registerSound("amado_cancel");

		HIKIDO = registerSound("hikido");
		HIKIDO_SHORT = registerSound("hikido_short");
		KINUZURE = registerSound("kinuzure");
		SIT_CHAIR = registerSound("sit_chair");

		SHISHIODOSHI = registerSound("shishiodoshi");

		GATE_WOOD = registerSound("gate_wood");
		GATE_IRON_OPEN = registerSound("gate_iron_open");
		GATE_IRON_CLOSE = registerSound("gate_iron_close");

		PAINT = registerSound("paint");

		WADAIKO_TOP = registerSound("wadaiko_top");
		WADAIKO_SIDE = registerSound("wadaiko_side");
		CURTAIN = registerSound("curtain");
		
		WRITE_REPORT = registerSound("write_report");
		OPEN = registerSound("open");
		OPEN_OVEN = registerSound("open_oven");
		REIZOU_OPEN = registerSound("reizou_open");
		REIZOU_CLOSE = registerSound("reizou_close");
		TOUCH_BLOCK = registerSound("touch_block");
		THROW = registerSound("throw");
		SWING = registerSound("swing");
		ERROR = registerSound("error");
		NOISE = registerSound("basalt_deltas_click2");
	}

	private static SoundEvent registerSound(String name) {
		ResourceLocation location = new ResourceLocation(ChinjufuMod.MOD_ID, name);
		SoundEvent event = new SoundEvent(location);
		event.setRegistryName(name);
		ForgeRegistries.SOUND_EVENTS.register(event);
		return event;
	}
}
