package com.ayutaki.chinjufumod.handler;

import com.ayutaki.chinjufumod.ChinjufuMod;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SoundEvents_CM {

	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ChinjufuMod.MOD_ID);

	public static SoundEvent AM_CARTRIDGE = register("am_cartridge");
	public static SoundEvent AM_CARTRIDGE2 = register("am_cartridge2");
	public static SoundEvent AM_CARTRIDGE3 = register("am_cartridge3");
	public static SoundEvent AM_FIRE = register("am_fire");
	public static SoundEvent AM_IMPACT = register("am_impact");
	public static SoundEvent AM_HIT = register("am_hit");
	
	public static SoundEvent KK_ATACK = register("kk_atack");
	public static SoundEvent KK_ATACK2 = register("kk_atack2");
	public static SoundEvent KK_START = register("kk_starting");
	public static SoundEvent KK_BREAK = register("kk_break");
	public static SoundEvent KK_IMPACT = register("kk_impact");
	public static SoundEvent KK_PROPELLER = register("kk_propeller");
	public static SoundEvent KK_PROPELLER_12 = register("kk_propeller_12");
	public static SoundEvent KK_STOP = register("kk_stop");
	public static SoundEvent GYORAI = register("gyorai");
	public static SoundEvent SET_GUN = register("set_gun");
	public static SoundEvent EMPTY_AMMO = register("empty_ammo");
	
	public static SoundEvent WATER_WAKE = register("wake_water");
	public static SoundEvent WATER_SPLASH = register("water_splash");

	public static SoundEvent JUU = register("juu");
	public static SoundEvent GUTSUGUTSU = register("gutsugutsu");
	public static SoundEvent TEA = register("tea");
	public static SoundEvent SAKE = register("sake");
	public static SoundEvent SHOUYU = register("shouyu");
	public static SoundEvent PAKU = register("paku");
	public static SoundEvent GOKU = register("goku");
	public static SoundEvent WATER_START = register("water_start");
	public static SoundEvent WATER_STOP = register("water_stop");
	public static SoundEvent KITCHEN_CUT = register("kitchen_cut");

	public static SoundEvent TANSU_OPEN = register("tansu_open");
	public static SoundEvent TANSU_CLOSE = register("tansu_close");

	public static SoundEvent WINDOW_OPEN = register("window_open");
	public static SoundEvent WINDOW_CLOSE = register("window_close");
	public static SoundEvent WINDOW_UD = register("window_updown");
	public static SoundEvent FUSUMA = register("fusuma");
	public static SoundEvent FUSUMA_SHORT = register("fusuma_short");
	public static SoundEvent AMADO_CANCEL = register("amado_cancel");

	public static SoundEvent HIKIDO = register("hikido");
	public static SoundEvent HIKIDO_SHORT = register("hikido_short");
	public static SoundEvent KINUZURE = register("kinuzure");
	public static SoundEvent SIT_CHAIR = register("sit_chair");

	public static SoundEvent SHISHIODOSHI = register("shishiodoshi");

	public static SoundEvent GATE_WOOD = register("gate_wood");
	public static SoundEvent GATE_IRON_OPEN = register("gate_iron_open");
	public static SoundEvent GATE_IRON_CLOSE = register("gate_iron_close");
	public static SoundEvent PAINT = register("paint");

	public static SoundEvent WADAIKO_TOP = register("wadaiko_top");
	public static SoundEvent WADAIKO_SIDE = register("wadaiko_side");
	public static SoundEvent CURTAIN = register("curtain");
	
	public static SoundEvent WRITE_REPORT = register("write_report");
	public static SoundEvent OPEN = register("open");
	public static SoundEvent OPEN_OVEN = register("open_oven");
	public static SoundEvent REIZOU_OPEN = register("reizou_open");
	public static SoundEvent REIZOU_CLOSE = register("reizou_close");
	public static SoundEvent TOUCH_BLOCK = register("touch_block");
	public static SoundEvent THROW = register("throw");
	public static SoundEvent SWING = register("swing");
	public static SoundEvent ERROR = register("error");
	public static SoundEvent NOISE = register("basalt_deltas_click2");
	
	///* Register *///
	private static SoundEvent register(String name) {
		ResourceLocation location = new ResourceLocation(ChinjufuMod.MOD_ID, name);
		SoundEvent event = new SoundEvent(location);
		SOUNDS.register(name, () -> event);
		return event;
	}
}
