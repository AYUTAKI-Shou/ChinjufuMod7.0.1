package com.ayutaki.chinjufumod.handler;

import com.ayutaki.chinjufumod.ChinjufuMod;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundEvents_CM {

	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ChinjufuMod.MOD_ID);

	public static final RegistryObject<SoundEvent> AM_CARTRIDGE = register("am_cartridge");
	public static final RegistryObject<SoundEvent> AM_CARTRIDGE2 = register("am_cartridge2");
	public static final RegistryObject<SoundEvent> AM_CARTRIDGE3 = register("am_cartridge3");
	public static final RegistryObject<SoundEvent> AM_FIRE = register("am_fire");
	public static final RegistryObject<SoundEvent> AM_IMPACT = register("am_impact");
	public static final RegistryObject<SoundEvent> AM_HIT = register("am_hit");
	
	public static final RegistryObject<SoundEvent> KK_ATACK = register("kk_atack");
	public static final RegistryObject<SoundEvent> KK_ATACK2 = register("kk_atack2");
	public static final RegistryObject<SoundEvent> KK_START = register("kk_starting");
	public static final RegistryObject<SoundEvent> KK_BREAK = register("kk_break");
	public static final RegistryObject<SoundEvent> KK_IMPACT = register("kk_impact");
	public static final RegistryObject<SoundEvent> KK_PROPELLER = register("kk_propeller");
	public static final RegistryObject<SoundEvent> KK_PROPELLER12 = register("kk_propeller_12");
	public static final RegistryObject<SoundEvent> KK_STOP = register("kk_stop");
	public static final RegistryObject<SoundEvent> GYORAI = register("gyorai");
	public static final RegistryObject<SoundEvent> SET_GUN = register("set_gun");
	public static final RegistryObject<SoundEvent> EMPTY_AMMO = register("empty_ammo");
	
	public static final RegistryObject<SoundEvent> WATER_WAKE = register("wake_water");
	public static final RegistryObject<SoundEvent> WATER_SPLASH = register("water_splash");

	public static final RegistryObject<SoundEvent> JUU = register("juu");
	public static final RegistryObject<SoundEvent> GUTSUGUTSU = register("gutsugutsu");
	public static final RegistryObject<SoundEvent> TEA = register("tea");
	public static final RegistryObject<SoundEvent> SAKE = register("sake");
	public static final RegistryObject<SoundEvent> SHOUYU = register("shouyu");
	public static final RegistryObject<SoundEvent> PAKU = register("paku");
	public static final RegistryObject<SoundEvent> GOKU = register("goku");
	public static final RegistryObject<SoundEvent> WATER_START = register("water_start");
	public static final RegistryObject<SoundEvent> WATER_STOP = register("water_stop");
	public static final RegistryObject<SoundEvent> KITCHEN_CUT = register("kitchen_cut");

	public static final RegistryObject<SoundEvent> TANSU_OPEN = register("tansu_open");
	public static final RegistryObject<SoundEvent> TANSU_CLOSE = register("tansu_close");

	public static final RegistryObject<SoundEvent> WINDOW_OPEN = register("window_open");
	public static final RegistryObject<SoundEvent> WINDOW_CLOSE = register("window_close");
	public static final RegistryObject<SoundEvent> WINDOW_UD = register("window_updown");
	public static final RegistryObject<SoundEvent> FUSUMA = register("fusuma");
	public static final RegistryObject<SoundEvent> FUSUMA_SHORT = register("fusuma_short");
	public static final RegistryObject<SoundEvent> AMADO_CANCEL = register("amado_cancel");

	public static final RegistryObject<SoundEvent> HIKIDO = register("hikido");
	public static final RegistryObject<SoundEvent> HIKIDO_SHORT = register("hikido_short");
	public static final RegistryObject<SoundEvent> KINUZURE = register("kinuzure");
	public static final RegistryObject<SoundEvent> SIT_CHAIR = register("sit_chair");

	public static final RegistryObject<SoundEvent> SHISHIODOSHI = register("shishiodoshi");

	public static final RegistryObject<SoundEvent> GATE_WOOD = register("gate_wood");
	public static final RegistryObject<SoundEvent> GATE_IRON_OPEN = register("gate_iron_open");
	public static final RegistryObject<SoundEvent> GATE_IRON_CLOSE = register("gate_iron_close");
	public static final RegistryObject<SoundEvent> PAINT = register("paint");

	public static final RegistryObject<SoundEvent> WADAIKO_TOP = register("wadaiko_top");
	public static final RegistryObject<SoundEvent> WADAIKO_SIDE = register("wadaiko_side");
	public static final RegistryObject<SoundEvent> CURTAIN = register("curtain");
	
	public static final RegistryObject<SoundEvent> WRITE_REPORT = register("write_report");
	public static final RegistryObject<SoundEvent> OPEN = register("open");
	public static final RegistryObject<SoundEvent> OPEN_OVEN = register("open_oven");
	public static final RegistryObject<SoundEvent> REIZOU_OPEN = register("reizou_open");
	public static final RegistryObject<SoundEvent> REIZOU_CLOSE = register("reizou_close");
	public static final RegistryObject<SoundEvent> TOUCH_BLOCK = register("touch_block");
	public static final RegistryObject<SoundEvent> THROW = register("throw");
	public static final RegistryObject<SoundEvent> SWING = register("swing");
	public static final RegistryObject<SoundEvent> ERROR = register("error");
	public static final RegistryObject<SoundEvent> NOISE = register("basalt_deltas_click2");
	
	///* Register *///
	private static RegistryObject<SoundEvent> register(String name) {
		ResourceLocation location = new ResourceLocation(ChinjufuMod.MOD_ID, name);
		return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(location));
	}
}
