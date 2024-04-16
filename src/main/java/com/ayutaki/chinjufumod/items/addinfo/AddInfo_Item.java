package com.ayutaki.chinjufumod.items.addinfo;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.registry.Items_Chinjufu;
import com.ayutaki.chinjufumod.registry.Items_NoTab;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Items_Wablock;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class AddInfo_Item extends Item {

	public AddInfo_Item(Properties properties) {
		super(properties);
	}

	/* ToolTip ...Item.class 222(1.16.5) */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {

		if (this == Items_NoTab.ROTTEN_FOOD) {
			tooltip.add(new TranslationTextComponent("tips.item_rotten_food").withStyle(TextFormatting.GRAY)); }
		
		if (this == Items_Chinjufu.SHOUHOU_empty) {
			tooltip.add(new TranslationTextComponent("tips.item_shouhou_empty").withStyle(TextFormatting.GRAY)); }
		if (this == Items_Chinjufu.SUMI) {
			tooltip.add(new TranslationTextComponent("tips.item_sumi").withStyle(TextFormatting.GRAY)); }

		if (this == Items_Teatime.NIGARI) {
			tooltip.add(new TranslationTextComponent("tips.item_nigari").withStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.SAKEKASU) {
			tooltip.add(new TranslationTextComponent("tips.item_sakekasu").withStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.KOMEKOUJI) {
			tooltip.add(new TranslationTextComponent("tips.item_komekouji").withStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.SHUBO) {
			tooltip.add(new TranslationTextComponent("tips.item_shubo").withStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.MOROMI) {
			tooltip.add(new TranslationTextComponent("tips.item_moromi").withStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.KIJI_BUN) {
			tooltip.add(new TranslationTextComponent("tips.item_kiji_bun").withStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.KIJI_BURG) {
			tooltip.add(new TranslationTextComponent("tips.item_kiji_burg").withStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.KIJI_SCONE) {
			tooltip.add(new TranslationTextComponent("tips.item_kiji_scone").withStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.KIJI_SENBEI) {
			tooltip.add(new TranslationTextComponent("tips.item_kiji_senbei").withStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.MATCH) {
			tooltip.add(new TranslationTextComponent("tips.item_match_cm").withStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.CHAWAN) {
			tooltip.add(new TranslationTextComponent("tips.item_food_chawan").withStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.SHIKKI) {
			tooltip.add(new TranslationTextComponent("tips.item_food_shikki").withStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.TONSUI) {
			tooltip.add(new TranslationTextComponent("tips.item_food_tonsui").withStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.YUNOMI) {
			tooltip.add(new TranslationTextComponent("tips.item_food_yunomi").withStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.CLAY_YUNOMI) {
			tooltip.add(new TranslationTextComponent("tips.item_clay_yunomi").withStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.CLAY_KYUSU) {
			tooltip.add(new TranslationTextComponent("tips.item_clay_kyusu").withStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.CLAY_TCUP) {
			tooltip.add(new TranslationTextComponent("tips.item_clay_teacup").withStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.CLAY_TPOT) {
			tooltip.add(new TranslationTextComponent("tips.item_clay_teapot").withStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.CLAY_SARA) {
			tooltip.add(new TranslationTextComponent("tips.item_clay_sara").withStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.CLAY_CHAWAN) {
			tooltip.add(new TranslationTextComponent("tips.item_clay_chawan").withStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.CLAY_NABE) {
			tooltip.add(new TranslationTextComponent("tips.item_clay_nabe").withStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.CLAY_TONSUI) {
			tooltip.add(new TranslationTextComponent("tips.item_clay_tonsui").withStyle(TextFormatting.GRAY)); }

		if (this == Items_Teatime.SENBEI) {
			tooltip.add(new TranslationTextComponent("tips.item_food_senbei").withStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.MOCHI_NORI) {
			tooltip.add(new TranslationTextComponent("tips.item_food_mochinori").withStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.MOCHI_KINAKO) {
			tooltip.add(new TranslationTextComponent("tips.item_food_mochikinako").withStyle(TextFormatting.GRAY)); }
			
		if (this == Items_Teatime.FPKINOKOAK) {
			tooltip.add(new TranslationTextComponent("tips.item_frypan_kinokoak").withStyle(TextFormatting.GRAY)); }

		if (this == Items_Teatime.KOUBO) {
			tooltip.add(new TranslationTextComponent("tips.item_koubo").withStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.NYUSAN) {
			tooltip.add(new TranslationTextComponent("tips.item_nyusan").withStyle(TextFormatting.GRAY)); }

		if (this == Items_Teatime.RENNET) {
			tooltip.add(new TranslationTextComponent("tips.item_rennet").withStyle(TextFormatting.GRAY)); }

		if (this == Items_Teatime.KIRIMI_S || this == Items_Teatime.KIRIMI_F || this == Items_Teatime.KIRIMI_B || this == Items_Teatime.KIRIMI_T) {
			tooltip.add(new TranslationTextComponent("tips.item_food_kirimi").withStyle(TextFormatting.GRAY)); }

		if (this == Items_Teatime.KUSHI_SAKANA) {
			tooltip.add(new TranslationTextComponent("tips.item_kushi_sakana").withStyle(TextFormatting.GRAY)); }

		if (this == Items_Teatime.CLAY_DONBURI) {
			tooltip.add(new TranslationTextComponent("tips.item_clay_donburi").withStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.DONBURI) {
			tooltip.add(new TranslationTextComponent("tips.item_food_donburi").withStyle(TextFormatting.GRAY)); }

		if (this == Items_Teatime.KEIRYO_CUP_full) {
			tooltip.add(new TranslationTextComponent("tips.item_measurecup_full").withStyle(TextFormatting.GRAY)); }
		
		if (this == Items_Teatime.IKA) {
			tooltip.add(new TranslationTextComponent("tips.item_squid_raw").withStyle(TextFormatting.GRAY)); }

		if (this == Items_Teatime.PEPPER_RAW) {
			tooltip.add(new TranslationTextComponent("tips.item_crop_pepper").withStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.PEPPER_DRY || this == Items_Teatime.CHILIPEPPER) {
			tooltip.add(new TranslationTextComponent("tips.item_crop_pepperdry").withStyle(TextFormatting.GRAY)); }
		
		if (this == Items_Teatime.SHOUYU_donburi) {
			tooltip.add(new TranslationTextComponent("tips.item_food_shouyu_don").withStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.TSUYU_donburi) {
			tooltip.add(new TranslationTextComponent("tips.item_food_tsuyu_don").withStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.KANSUI) {
			tooltip.add(new TranslationTextComponent("tips.item_kansui").withStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.SHOUYU_TARE || this == Items_Teatime.MISO_TARE || this == Items_Teatime.SHIO_TARE) {
			tooltip.add(new TranslationTextComponent("tips.item_food_tare").withStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.SHOUYU_Rsoup || this == Items_Teatime.MISO_Rsoup || this == Items_Teatime.SHIO_Rsoup) {
			tooltip.add(new TranslationTextComponent("tips.item_food_rsoup").withStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.SOBA_PLATE) {
			tooltip.add(new TranslationTextComponent("tips.item_food_sobaplate").withStyle(TextFormatting.GRAY)); }
		
		if (this == Items_Seasonal.KURI) {
			tooltip.add(new TranslationTextComponent("tips.item_chestnut").withStyle(TextFormatting.GRAY)); }
		
		if (this == Items_Seasonal.KURI_SWEET || this == Items_Seasonal.KURI_CHOCO) {
			tooltip.add(new TranslationTextComponent("tips.item_chestnutsweet").withStyle(TextFormatting.GRAY)); }

		if (this == Items_Seasonal.COCOA_F) {
			tooltip.add(new TranslationTextComponent("tips.item_cocoa_ferm").withStyle(TextFormatting.GRAY)); }
		if (this == Items_Seasonal.COCOA_R) {
			tooltip.add(new TranslationTextComponent("tips.item_cocoa_roast").withStyle(TextFormatting.GRAY)); }
		if (this == Items_Seasonal.COCOA_M) {
			tooltip.add(new TranslationTextComponent("tips.item_cocoa_mass").withStyle(TextFormatting.GRAY)); }
		if (this == Items_Seasonal.CHOCO_raw) {
			tooltip.add(new TranslationTextComponent("tips.item_choco_raw").withStyle(TextFormatting.GRAY)); }
		
		if (this == Items_Wablock.SHOUSEKKAI) {
			tooltip.add(new TranslationTextComponent("tips.item_shousekkai_c").withStyle(TextFormatting.GRAY)); }
		if (this == Items_Wablock.CLAYKAWARA) {
			tooltip.add(new TranslationTextComponent("tips.item_claykawara").withStyle(TextFormatting.GRAY)); }
	}
}
