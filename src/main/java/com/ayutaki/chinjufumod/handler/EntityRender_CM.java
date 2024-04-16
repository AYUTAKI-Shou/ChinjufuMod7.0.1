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
import net.minecraft.client.renderer.entity.EntityRenderers;

public class EntityRender_CM {

	public static void register() {
		EntityRenderers.register(EntityTypes_CM.SITABLE.get(), SitableRenderer::new); 
		EntityRenderers.register(EntityTypes_CM.AMMO_L.get(), RenderAmmo_Large::new);
		EntityRenderers.register(EntityTypes_CM.AMMO_M.get(), RenderAmmo_Medium::new);
		EntityRenderers.register(EntityTypes_CM.AMMO_S.get(), RenderAmmo_Small::new);
		EntityRenderers.register(EntityTypes_CM.AMMO_K.get(), RenderAmmo_Kijyuu::new);
		
		EntityRenderers.register(EntityTypes_CM.TYPE97.get(), renderManager -> new RenderKK_Type97(renderManager, Minecraft.getInstance().getItemRenderer()));
		EntityRenderers.register(EntityTypes_CM.TENZAN.get(), renderManager -> new RenderKK_Tenzan(renderManager, Minecraft.getInstance().getItemRenderer()));
		EntityRenderers.register(EntityTypes_CM.RYUSEI.get(), renderManager -> new RenderKK_Ryusei(renderManager, Minecraft.getInstance().getItemRenderer()));
		EntityRenderers.register(EntityTypes_CM.TBF.get(), renderManager -> new RenderKK_TBF(renderManager, Minecraft.getInstance().getItemRenderer()));
		EntityRenderers.register(EntityTypes_CM.SWORDFISH.get(), renderManager -> new RenderKK_Swordfish(renderManager, Minecraft.getInstance().getItemRenderer()));
		EntityRenderers.register(EntityTypes_CM.BARRACUDA.get(), renderManager -> new RenderKK_Barracuda(renderManager, Minecraft.getInstance().getItemRenderer()));
		EntityRenderers.register(EntityTypes_CM.MOSQUITO.get(), renderManager -> new RenderKK_Mosquito(renderManager, Minecraft.getInstance().getItemRenderer()));

		EntityRenderers.register(EntityTypes_CM.TYPE99.get(), renderManager -> new RenderKB_Type99(renderManager, Minecraft.getInstance().getItemRenderer()));
		EntityRenderers.register(EntityTypes_CM.SUISEI.get(), renderManager -> new RenderKB_Suisei(renderManager, Minecraft.getInstance().getItemRenderer()));
		EntityRenderers.register(EntityTypes_CM.TYPEZERO.get(), renderManager -> new RenderKB_TypeZero(renderManager, Minecraft.getInstance().getItemRenderer()));
		EntityRenderers.register(EntityTypes_CM.JU87.get(), renderManager -> new RenderKB_Ju87(renderManager, Minecraft.getInstance().getItemRenderer()));
		EntityRenderers.register(EntityTypes_CM.RE2001.get(), renderManager -> new RenderKB_Re2001(renderManager, Minecraft.getInstance().getItemRenderer()));
		EntityRenderers.register(EntityTypes_CM.SBD.get(), renderManager -> new RenderKB_SBD(renderManager, Minecraft.getInstance().getItemRenderer()));
		EntityRenderers.register(EntityTypes_CM.F4U.get(), renderManager -> new RenderKB_F4U(renderManager, Minecraft.getInstance().getItemRenderer()));

		EntityRenderers.register(EntityTypes_CM.GYORAI61.get(), renderManager -> new RenderGyorai61cm(renderManager, Minecraft.getInstance().getItemRenderer()));
		
		EntityRenderers.register(EntityTypes_CM.TOAMI.get(), renderManager -> new ToamiRenderer(renderManager, Minecraft.getInstance().getItemRenderer()));
	}
}
