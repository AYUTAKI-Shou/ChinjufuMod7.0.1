package com.ayutaki.chinjufumod.handler;

import com.ayutaki.chinjufumod.entity.render.RenderAmmo_Kijyuu;
import com.ayutaki.chinjufumod.entity.render.RenderAmmo_Large;
import com.ayutaki.chinjufumod.entity.render.RenderAmmo_Medium;
import com.ayutaki.chinjufumod.entity.render.RenderAmmo_Small;
import com.ayutaki.chinjufumod.entity.render.RenderGyorai61cm;
import com.ayutaki.chinjufumod.entity.render.RenderKB_F4U;
import com.ayutaki.chinjufumod.entity.render.RenderKB_Ju87;
import com.ayutaki.chinjufumod.entity.render.RenderKB_Re2001;
import com.ayutaki.chinjufumod.entity.render.RenderKB_SBD;
import com.ayutaki.chinjufumod.entity.render.RenderKB_Suisei;
import com.ayutaki.chinjufumod.entity.render.RenderKB_Type99;
import com.ayutaki.chinjufumod.entity.render.RenderKB_TypeZero;
import com.ayutaki.chinjufumod.entity.render.RenderKK_Barracuda;
import com.ayutaki.chinjufumod.entity.render.RenderKK_Mosquito;
import com.ayutaki.chinjufumod.entity.render.RenderKK_Ryusei;
import com.ayutaki.chinjufumod.entity.render.RenderKK_Swordfish;
import com.ayutaki.chinjufumod.entity.render.RenderKK_TBF;
import com.ayutaki.chinjufumod.entity.render.RenderKK_Tenzan;
import com.ayutaki.chinjufumod.entity.render.RenderKK_Type97;
import com.ayutaki.chinjufumod.entity.render.SitableRenderer;
import com.ayutaki.chinjufumod.entity.render.ToamiRenderer;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class EntityRender_CM {

	public static void register() {

		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.SITABLE, SitableRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.AMMO_L, RenderAmmo_Large::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.AMMO_M, RenderAmmo_Medium::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.AMMO_S, RenderAmmo_Small::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.AMMO_K, RenderAmmo_Kijyuu::new);

		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.TYPE97, renderManager -> new RenderKK_Type97(renderManager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.TENZAN, renderManager -> new RenderKK_Tenzan(renderManager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.RYUSEI, renderManager -> new RenderKK_Ryusei(renderManager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.TBF, renderManager -> new RenderKK_TBF(renderManager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.SWORDFISH, renderManager -> new RenderKK_Swordfish(renderManager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.BARRACUDA, renderManager -> new RenderKK_Barracuda(renderManager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.MOSQUITO, renderManager -> new RenderKK_Mosquito(renderManager, Minecraft.getInstance().getItemRenderer()));

		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.TYPE99, renderManager -> new RenderKB_Type99(renderManager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.SUISEI, renderManager -> new RenderKB_Suisei(renderManager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.TYPEZERO, renderManager -> new RenderKB_TypeZero(renderManager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.JU87, renderManager -> new RenderKB_Ju87(renderManager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.RE2001, renderManager -> new RenderKB_Re2001(renderManager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.SBD, renderManager -> new RenderKB_SBD(renderManager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.F4U, renderManager -> new RenderKB_F4U(renderManager, Minecraft.getInstance().getItemRenderer()));

		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.GYORAI61, renderManager -> new RenderGyorai61cm(renderManager, Minecraft.getInstance().getItemRenderer()));

		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.TOAMI, renderManager -> new ToamiRenderer(renderManager, Minecraft.getInstance().getItemRenderer()));
	}

}
