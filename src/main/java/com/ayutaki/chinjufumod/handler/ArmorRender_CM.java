package com.ayutaki.chinjufumod.handler;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.items.armor.model.AkatsukiModel;
import com.ayutaki.chinjufumod.items.armor.model.BattleshipModel;
import com.ayutaki.chinjufumod.items.armor.model.GisouModel;
import com.ayutaki.chinjufumod.items.armor.model.IkkousenModel;
import com.ayutaki.chinjufumod.items.armor.model.KasumiOuter;
import com.ayutaki.chinjufumod.items.armor.model.NagatoModel;
import com.ayutaki.chinjufumod.items.armor.model.RJModel;
import com.ayutaki.chinjufumod.items.armor.model.Ro500_Outer;
import com.ayutaki.chinjufumod.items.armor.model.SendaiModel;
import com.ayutaki.chinjufumod.items.armor.model.SubmarineModel;
import com.ayutaki.chinjufumod.items.armor.model.ToneModel;
import com.ayutaki.chinjufumod.items.armor.model.UKIWA_Model;
import com.ayutaki.chinjufumod.items.armor.model.YUKATA_Model;
import com.ayutaki.chinjufumod.items.armor.model.YuraModel;
import com.ayutaki.chinjufumod.items.armor.model.ZuihouModel;

import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ArmorRender_CM {

	@SubscribeEvent
	public static void registerEntityRenderingHandler(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ArmorLayer_CM.GISOU_INNER, () -> LayerDefinition.create(GisouModel.createInner(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.GISOU_OUTER, () -> LayerDefinition.create(GisouModel.createOuter(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.AKATSUKI_INNER, () -> LayerDefinition.create(AkatsukiModel.createInner(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.AKATSUKI_OUTER, () -> LayerDefinition.create(AkatsukiModel.createOuter(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.KASUMI_OUTER, () -> LayerDefinition.create(KasumiOuter.createOuter(), 64, 120));
		
		event.registerLayerDefinition(ArmorLayer_CM.SENDAI_INNER, () -> LayerDefinition.create(SendaiModel.createInner(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.SENDAI_OUTER, () -> LayerDefinition.create(SendaiModel.createOuter(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.YURA_INNER, () -> LayerDefinition.create(YuraModel.createInner(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.YURA_OUTER, () -> LayerDefinition.create(YuraModel.createOuter(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.TONE_INNER, () -> LayerDefinition.create(ToneModel.createInner(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.TONE_OUTER, () -> LayerDefinition.create(ToneModel.createOuter(), 64, 120));

		event.registerLayerDefinition(ArmorLayer_CM.RJ_INNER, () -> LayerDefinition.create(RJModel.createInner(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.RJ_OUTER, () -> LayerDefinition.create(RJModel.createOuter(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.ZUIHOU_INNER, () -> LayerDefinition.create(ZuihouModel.createInner(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.ZUIHOU_OUTER, () -> LayerDefinition.create(ZuihouModel.createOuter(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.IKKOU_INNER, () -> LayerDefinition.create(IkkousenModel.createInner(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.IKKOU_OUTER, () -> LayerDefinition.create(IkkousenModel.createOuter(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.RJ_INNER, () -> LayerDefinition.create(RJModel.createInner(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.RJ_OUTER, () -> LayerDefinition.create(RJModel.createOuter(), 64, 120));
		
		event.registerLayerDefinition(ArmorLayer_CM.SENKAN_INNER, () -> LayerDefinition.create(BattleshipModel.createInner(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.SENKAN_OUTER, () -> LayerDefinition.create(BattleshipModel.createOuter(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.NAGATO_INNER, () -> LayerDefinition.create(NagatoModel.createInner(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.NAGATO_OUTER, () -> LayerDefinition.create(NagatoModel.createOuter(), 64, 120));

		event.registerLayerDefinition(ArmorLayer_CM.SUBMARINE_INNER, () -> LayerDefinition.create(SubmarineModel.createInner(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.SUBMARINE_OUTER, () -> LayerDefinition.create(SubmarineModel.createOuter(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.UKIWA_INNER, () -> LayerDefinition.create(UKIWA_Model.createInner(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.RO500_OUTER, () -> LayerDefinition.create(Ro500_Outer.createOuter(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.RO500_OUTER_C, () -> LayerDefinition.create(UKIWA_Model.ro500_OuterC(), 64, 120));

		
		event.registerLayerDefinition(ArmorLayer_CM.YUKATA_INNER, () -> LayerDefinition.create(YUKATA_Model.createInner(), 64, 120));
		event.registerLayerDefinition(ArmorLayer_CM.YUKATA_OUTER, () -> LayerDefinition.create(YUKATA_Model.createOuter(), 64, 120));
	}
}
