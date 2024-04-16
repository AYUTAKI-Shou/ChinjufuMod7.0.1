package com.ayutaki.chinjufumod.handler;

import com.ayutaki.chinjufumod.ChinjufuMod;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ArmorLayer_CM {

	/* Separate layers into Inner and Outer. */
	public static final ModelLayerLocation GISOU_INNER = register("armor_gisou", "inner");
	public static final ModelLayerLocation GISOU_OUTER = register("armor_gisou", "outer");
	public static final ModelLayerLocation AKATSUKI_INNER = register("armor_akatsuki", "inner");
	public static final ModelLayerLocation AKATSUKI_OUTER = register("armor_akatsuki", "outer");
	public static final ModelLayerLocation KASUMI_OUTER = register("armor_kasumi", "outer");
	
	public static final ModelLayerLocation SENDAI_INNER = register("armor_sendai", "inner");
	public static final ModelLayerLocation SENDAI_OUTER = register("armor_sendai", "outer");
	public static final ModelLayerLocation YURA_INNER = register("armor_yura", "inner");
	public static final ModelLayerLocation YURA_OUTER = register("armor_yura", "outer");
	public static final ModelLayerLocation TONE_INNER = register("armor_tone", "inner");
	public static final ModelLayerLocation TONE_OUTER = register("armor_tone", "outer");

	public static final ModelLayerLocation IKKOU_INNER = register("armor_ikkou", "inner");
	public static final ModelLayerLocation IKKOU_OUTER = register("armor_ikkou", "outer");
	public static final ModelLayerLocation RJ_INNER = register("armor_ryujou", "inner");
	public static final ModelLayerLocation RJ_OUTER = register("armor_ryujou", "outer");
	public static final ModelLayerLocation ZUIHOU_INNER = register("armor_zuihou", "inner");
	public static final ModelLayerLocation ZUIHOU_OUTER = register("armor_zuihou", "outer");
	
	public static final ModelLayerLocation SENKAN_INNER = register("armor_senkan", "inner");
	public static final ModelLayerLocation SENKAN_OUTER = register("armor_senkan", "outer");
	public static final ModelLayerLocation NAGATO_INNER = register("armor_nagato", "inner");
	public static final ModelLayerLocation NAGATO_OUTER = register("armor_nagato", "outer");
	
	public static final ModelLayerLocation SUBMARINE_INNER = register("armor_sabmarine", "inner");
	public static final ModelLayerLocation SUBMARINE_OUTER = register("armor_sabmarine", "outer");
	public static final ModelLayerLocation UKIWA_INNER = register("armor_ukiwa", "inner");
	public static final ModelLayerLocation RO500_OUTER = register("armor_ro500", "outer");
	public static final ModelLayerLocation RO500_OUTER_C = register("armor_ro500_c", "outer");
	
	public static final ModelLayerLocation YUKATA_INNER = register("armor_yukata", "inner");
	public static final ModelLayerLocation YUKATA_OUTER = register("armor_yukata", "outer");
	
	private static ModelLayerLocation register(String name, String layer) {
		return new ModelLayerLocation(new ResourceLocation(ChinjufuMod.MOD_ID, name), layer);
	}
}
