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
 
	/* アイテムは @Nullable World worldIn、ブロックは @Nullable IBlockReader worldIn*/
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {

		if (this == Items_NoTab.ROTTEN_FOOD) {
			tooltip.add(new TranslationTextComponent("tips.item_rotten_food").applyTextStyle(TextFormatting.GRAY)); }
		
		if (this == Items_Chinjufu.SHOUHOU_empty) {
			tooltip.add(new TranslationTextComponent("tips.item_shouhou_empty").applyTextStyle(TextFormatting.GRAY)); }
		if (this == Items_Chinjufu.SUMI) {
			tooltip.add(new TranslationTextComponent("tips.item_sumi").applyTextStyle(TextFormatting.GRAY)); }

		if (this == Items_Teatime.NIGARI) {
			tooltip.add(new TranslationTextComponent("tips.item_nigari").applyTextStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.SAKEKASU) {
			tooltip.add(new TranslationTextComponent("tips.item_sakekasu").applyTextStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.KOMEKOUJI) {
			tooltip.add(new TranslationTextComponent("tips.item_komekouji").applyTextStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.SHUBO) {
			tooltip.add(new TranslationTextComponent("tips.item_shubo").applyTextStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.MOROMI) {
			tooltip.add(new TranslationTextComponent("tips.item_moromi").applyTextStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.KIJI_BUN) {
			tooltip.add(new TranslationTextComponent("tips.item_kiji_bun").applyTextStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.KIJI_BURG) {
			tooltip.add(new TranslationTextComponent("tips.item_kiji_burg").applyTextStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.KIJI_SCONE) {
			tooltip.add(new TranslationTextComponent("tips.item_kiji_scone").applyTextStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.KIJI_SENBEI) {
			tooltip.add(new TranslationTextComponent("tips.item_kiji_senbei").applyTextStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.MATCH) {
			tooltip.add(new TranslationTextComponent("tips.item_match_cm").applyTextStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.CHAWAN) {
			tooltip.add(new TranslationTextComponent("tips.item_food_chawan").applyTextStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.SHIKKI) {
			tooltip.add(new TranslationTextComponent("tips.item_food_shikki").applyTextStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.TONSUI) {
			tooltip.add(new TranslationTextComponent("tips.item_food_tonsui").applyTextStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.YUNOMI) {
			tooltip.add(new TranslationTextComponent("tips.item_food_yunomi").applyTextStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.CLAY_YUNOMI) {
			tooltip.add(new TranslationTextComponent("tips.item_clay_yunomi").applyTextStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.CLAY_KYUSU) {
			tooltip.add(new TranslationTextComponent("tips.item_clay_kyusu").applyTextStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.CLAY_TCUP) {
			tooltip.add(new TranslationTextComponent("tips.item_clay_teacup").applyTextStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.CLAY_TPOT) {
			tooltip.add(new TranslationTextComponent("tips.item_clay_teapot").applyTextStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.CLAY_SARA) {
			tooltip.add(new TranslationTextComponent("tips.item_clay_sara").applyTextStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.CLAY_CHAWAN) {
			tooltip.add(new TranslationTextComponent("tips.item_clay_chawan").applyTextStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.CLAY_NABE) {
			tooltip.add(new TranslationTextComponent("tips.item_clay_nabe").applyTextStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.CLAY_TONSUI) {
			tooltip.add(new TranslationTextComponent("tips.item_clay_tonsui").applyTextStyle(TextFormatting.GRAY)); }

		if (this == Items_Teatime.SENBEI) {
			tooltip.add(new TranslationTextComponent("tips.item_food_senbei").applyTextStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.MOCHI_NORI) {
			tooltip.add(new TranslationTextComponent("tips.item_food_mochinori").applyTextStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.MOCHI_KINAKO) {
			tooltip.add(new TranslationTextComponent("tips.item_food_mochikinako").applyTextStyle(TextFormatting.GRAY)); }

		if (this == Items_Teatime.FPKINOKOAK) {
			tooltip.add(new TranslationTextComponent("tips.item_frypan_kinokoak").applyTextStyle(TextFormatting.GRAY)); }

		if (this == Items_Teatime.KOUBO) {
			tooltip.add(new TranslationTextComponent("tips.item_koubo").applyTextStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.NYUSAN) {
			tooltip.add(new TranslationTextComponent("tips.item_nyusan").applyTextStyle(TextFormatting.GRAY)); }

		if (this == Items_Teatime.RENNET) {
			tooltip.add(new TranslationTextComponent("tips.item_rennet").applyTextStyle(TextFormatting.GRAY)); }

		if (this == Items_Teatime.KIRIMI_S || this == Items_Teatime.KIRIMI_F || this == Items_Teatime.KIRIMI_B || this == Items_Teatime.KIRIMI_T) {
			tooltip.add(new TranslationTextComponent("tips.item_food_kirimi").applyTextStyle(TextFormatting.GRAY)); }

		if (this == Items_Teatime.KUSHI_SAKANA) {
			tooltip.add(new TranslationTextComponent("tips.item_kushi_sakana").applyTextStyle(TextFormatting.GRAY)); }

		if (this == Items_Teatime.CLAY_DONBURI) {
			tooltip.add(new TranslationTextComponent("tips.item_clay_donburi").applyTextStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.DONBURI) {
			tooltip.add(new TranslationTextComponent("tips.item_food_donburi").applyTextStyle(TextFormatting.GRAY)); }

		if (this == Items_Teatime.KEIRYO_CUP_full) {
			tooltip.add(new TranslationTextComponent("tips.item_measurecup_full").applyTextStyle(TextFormatting.GRAY)); }
		
		if (this == Items_Teatime.IKA) {
			tooltip.add(new TranslationTextComponent("tips.item_squid_raw").applyTextStyle(TextFormatting.GRAY)); }

		if (this == Items_Teatime.PEPPER_RAW) {
			tooltip.add(new TranslationTextComponent("tips.item_crop_pepper").applyTextStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.PEPPER_DRY || this == Items_Teatime.CHILIPEPPER) {
			tooltip.add(new TranslationTextComponent("tips.item_crop_pepperdry").applyTextStyle(TextFormatting.GRAY)); }
		
		if (this == Items_Teatime.SHOUYU_donburi) {
			tooltip.add(new TranslationTextComponent("tips.item_food_shouyu_don").applyTextStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.TSUYU_donburi) {
			tooltip.add(new TranslationTextComponent("tips.item_food_tsuyu_don").applyTextStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.KANSUI) {
			tooltip.add(new TranslationTextComponent("tips.item_kansui").applyTextStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.SHOUYU_TARE || this == Items_Teatime.MISO_TARE || this == Items_Teatime.SHIO_TARE) {
			tooltip.add(new TranslationTextComponent("tips.item_food_tare").applyTextStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.SHOUYU_Rsoup || this == Items_Teatime.MISO_Rsoup || this == Items_Teatime.SHIO_Rsoup) {
			tooltip.add(new TranslationTextComponent("tips.item_food_rsoup").applyTextStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.SOBA_PLATE) {
			tooltip.add(new TranslationTextComponent("tips.item_food_sobaplate").applyTextStyle(TextFormatting.GRAY)); }
		
		if (this == Items_Seasonal.KURI) {
			tooltip.add(new TranslationTextComponent("tips.item_chestnut").applyTextStyle(TextFormatting.GRAY)); }
		
		if (this == Items_Seasonal.KURI_SWEET || this == Items_Seasonal.KURI_CHOCO) {
			tooltip.add(new TranslationTextComponent("tips.item_chestnutsweet").applyTextStyle(TextFormatting.GRAY)); }

		if (this == Items_Seasonal.COCOA_F) {
			tooltip.add(new TranslationTextComponent("tips.item_cocoa_ferm").applyTextStyle(TextFormatting.GRAY)); }
		if (this == Items_Seasonal.COCOA_R) {
			tooltip.add(new TranslationTextComponent("tips.item_cocoa_roast").applyTextStyle(TextFormatting.GRAY)); }
		if (this == Items_Seasonal.COCOA_M) {
			tooltip.add(new TranslationTextComponent("tips.item_cocoa_mass").applyTextStyle(TextFormatting.GRAY)); }
		if (this == Items_Seasonal.CHOCO_raw) {
			tooltip.add(new TranslationTextComponent("tips.item_choco_raw").applyTextStyle(TextFormatting.GRAY)); }
		
		if (this == Items_Wablock.SHOUSEKKAI) {
			tooltip.add(new TranslationTextComponent("tips.item_shousekkai_c").applyTextStyle(TextFormatting.GRAY)); }
		if (this == Items_Wablock.CLAYKAWARA) {
			tooltip.add(new TranslationTextComponent("tips.item_claykawara").applyTextStyle(TextFormatting.GRAY)); }
	}
}
