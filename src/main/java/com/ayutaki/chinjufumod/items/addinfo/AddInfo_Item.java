package com.ayutaki.chinjufumod.items.addinfo;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.registry.Items_Chinjufu;
import com.ayutaki.chinjufumod.registry.Items_NoTab;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Items_Wablock;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class AddInfo_Item extends Item {

	public AddInfo_Item(Item.Properties properties) {
		super(properties);
	}
	
	/* ToolTip */
	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag tipFlag) {

		if (this ==  Items_NoTab.ROTTEN_FOOD.get()) {
			tooltip.add(Component.translatable("tips.item_rotten_food").withStyle(ChatFormatting.GRAY)); }
		
		if (this == Items_Chinjufu.SHOUHOU_empty.get()) {
			tooltip.add(Component.translatable("tips.item_shouhou_empty").withStyle(ChatFormatting.GRAY)); }
		if (this == Items_Chinjufu.SUMI.get()) {
			tooltip.add(Component.translatable("tips.item_sumi").withStyle(ChatFormatting.GRAY)); }

		if (this == Items_Teatime.NIGARI.get()) {
			tooltip.add(Component.translatable("tips.item_nigari").withStyle(ChatFormatting.GRAY)); }
		if (this == Items_Teatime.SAKEKASU.get()) {
			tooltip.add(Component.translatable("tips.item_sakekasu").withStyle(ChatFormatting.GRAY)); }
		if (this == Items_Teatime.KOMEKOUJI.get()) {
			tooltip.add(Component.translatable("tips.item_komekouji").withStyle(ChatFormatting.GRAY)); }
		if (this == Items_Teatime.SHUBO.get()) {
			tooltip.add(Component.translatable("tips.item_shubo").withStyle(ChatFormatting.GRAY)); }
		if (this == Items_Teatime.MOROMI.get()) {
			tooltip.add(Component.translatable("tips.item_moromi").withStyle(ChatFormatting.GRAY)); }
		if (this == Items_Teatime.KIJI_BUN.get()) {
			tooltip.add(Component.translatable("tips.item_kiji_bun").withStyle(ChatFormatting.GRAY)); }
		if (this == Items_Teatime.KIJI_BURG.get()) {
			tooltip.add(Component.translatable("tips.item_kiji_burg").withStyle(ChatFormatting.GRAY)); }
		if (this == Items_Teatime.KIJI_SCONE.get()) {
			tooltip.add(Component.translatable("tips.item_kiji_scone").withStyle(ChatFormatting.GRAY)); }
		if (this == Items_Teatime.KIJI_SENBEI.get()) {
			tooltip.add(Component.translatable("tips.item_kiji_senbei").withStyle(ChatFormatting.GRAY)); }
		if (this == Items_Teatime.MATCH.get()) {
			tooltip.add(Component.translatable("tips.item_match_cm").withStyle(ChatFormatting.GRAY)); }
		if (this == Items_Teatime.CHAWAN.get()) {
			tooltip.add(Component.translatable("tips.item_food_chawan").withStyle(ChatFormatting.GRAY)); }
		if (this == Items_Teatime.SHIKKI.get()) {
			tooltip.add(Component.translatable("tips.item_food_shikki").withStyle(ChatFormatting.GRAY)); }
		if (this == Items_Teatime.TONSUI.get()) {
			tooltip.add(Component.translatable("tips.item_food_tonsui").withStyle(ChatFormatting.GRAY)); }
		if (this == Items_Teatime.YUNOMI.get()) {
			tooltip.add(Component.translatable("tips.item_food_yunomi").withStyle(ChatFormatting.GRAY)); }
		if (this == Items_Teatime.CLAY_YUNOMI.get()) {
			tooltip.add(Component.translatable("tips.item_clay_yunomi").withStyle(ChatFormatting.GRAY)); }
		if (this == Items_Teatime.CLAY_KYUSU.get()) {
			tooltip.add(Component.translatable("tips.item_clay_kyusu").withStyle(ChatFormatting.GRAY)); }
		if (this == Items_Teatime.CLAY_TCUP.get()) {
			tooltip.add(Component.translatable("tips.item_clay_teacup").withStyle(ChatFormatting.GRAY)); }
		if (this == Items_Teatime.CLAY_TPOT.get()) {
			tooltip.add(Component.translatable("tips.item_clay_teapot").withStyle(ChatFormatting.GRAY)); }
		if (this == Items_Teatime.CLAY_SARA.get()) {
			tooltip.add(Component.translatable("tips.item_clay_sara").withStyle(ChatFormatting.GRAY)); }
		if (this == Items_Teatime.CLAY_CHAWAN.get()) {
			tooltip.add(Component.translatable("tips.item_clay_chawan").withStyle(ChatFormatting.GRAY)); }
		if (this == Items_Teatime.CLAY_NABE.get()) {
			tooltip.add(Component.translatable("tips.item_clay_nabe").withStyle(ChatFormatting.GRAY)); }
		if (this == Items_Teatime.CLAY_TONSUI.get()) {
			tooltip.add(Component.translatable("tips.item_clay_tonsui").withStyle(ChatFormatting.GRAY)); }

		if (this == Items_Teatime.SENBEI.get()) {
			tooltip.add(Component.translatable("tips.item_food_senbei").withStyle(ChatFormatting.GRAY)); }
		if (this == Items_Teatime.MOCHI_NORI.get()) {
			tooltip.add(Component.translatable("tips.item_food_mochinori").withStyle(ChatFormatting.GRAY)); }
		if (this == Items_Teatime.MOCHI_KINAKO.get()) {
			tooltip.add(Component.translatable("tips.item_food_mochikinako").withStyle(ChatFormatting.GRAY)); }
		
		if (this == Items_Teatime.FPKINOKOAK.get()) {
			tooltip.add(Component.translatable("tips.item_frypan_kinokoak").withStyle(ChatFormatting.GRAY)); }

		if (this == Items_Teatime.KOUBO.get()) {
			tooltip.add(Component.translatable("tips.item_koubo").withStyle(ChatFormatting.GRAY)); }
		if (this == Items_Teatime.NYUSAN.get()) {
			tooltip.add(Component.translatable("tips.item_nyusan").withStyle(ChatFormatting.GRAY)); }

		if (this == Items_Teatime.RENNET.get()) {
			tooltip.add(Component.translatable("tips.item_rennet").withStyle(ChatFormatting.GRAY)); }

		if (this == Items_Teatime.KIRIMI_S.get() || this == Items_Teatime.KIRIMI_F.get() || this == Items_Teatime.KIRIMI_B.get() || this == Items_Teatime.KIRIMI_T.get()) {
			tooltip.add(Component.translatable("tips.item_food_kirimi").withStyle(ChatFormatting.GRAY)); }

		if (this == Items_Teatime.KUSHI_SAKANA.get()) {
			tooltip.add(Component.translatable("tips.item_kushi_sakana").withStyle(ChatFormatting.GRAY)); }

		if (this == Items_Teatime.CLAY_DONBURI.get()) {
			tooltip.add(Component.translatable("tips.item_clay_donburi").withStyle(ChatFormatting.GRAY)); }
		if (this == Items_Teatime.DONBURI.get()) {
			tooltip.add(Component.translatable("tips.item_food_donburi").withStyle(ChatFormatting.GRAY)); }

		if (this == Items_Teatime.KEIRYO_CUP_full.get()) {
			tooltip.add(Component.translatable("tips.item_measurecup_full").withStyle(ChatFormatting.GRAY)); }
		
		if (this == Items_Teatime.IKA.get()) {
			tooltip.add(Component.translatable("tips.item_squid_raw").withStyle(ChatFormatting.GRAY)); }

		if (this == Items_Teatime.PEPPER_RAW.get()) {
			tooltip.add(Component.translatable("tips.item_crop_pepper").withStyle(ChatFormatting.GRAY)); }
		if (this == Items_Teatime.PEPPER_DRY.get() || this == Items_Teatime.CHILIPEPPER.get()) {
			tooltip.add(Component.translatable("tips.item_crop_pepperdry").withStyle(ChatFormatting.GRAY)); }
		
		if (this == Items_Teatime.SHOUYU_donburi.get()) {
			tooltip.add(Component.translatable("tips.item_food_shouyu_don").withStyle(ChatFormatting.GRAY)); }
		if (this == Items_Teatime.TSUYU_donburi.get()) {
			tooltip.add(Component.translatable("tips.item_food_tsuyu_don").withStyle(ChatFormatting.GRAY)); }
		if (this == Items_Teatime.KANSUI.get()) {
			tooltip.add(Component.translatable("tips.item_kansui").withStyle(ChatFormatting.GRAY)); }
		if (this == Items_Teatime.SHOUYU_TARE.get() || this == Items_Teatime.MISO_TARE.get() || this == Items_Teatime.SHIO_TARE.get()) {
			tooltip.add(Component.translatable("tips.item_food_tare").withStyle(ChatFormatting.GRAY)); }
		if (this == Items_Teatime.SHOUYU_Rsoup.get() || this == Items_Teatime.MISO_Rsoup.get() || this == Items_Teatime.SHIO_Rsoup.get()) {
			tooltip.add(Component.translatable("tips.item_food_rsoup").withStyle(ChatFormatting.GRAY)); }
		if (this == Items_Teatime.SOBA_PLATE.get()) {
			tooltip.add(Component.translatable("tips.item_food_sobaplate").withStyle(ChatFormatting.GRAY)); }
		
		if (this == Items_Seasonal.KURI.get()) {
			tooltip.add(Component.translatable("tips.item_chestnut").withStyle(ChatFormatting.GRAY)); }
		
		if (this == Items_Seasonal.KURI_SWEET.get() || this == Items_Seasonal.KURI_CHOCO.get()) {
			tooltip.add(Component.translatable("tips.item_chestnutsweet").withStyle(ChatFormatting.GRAY)); }

		if (this == Items_Seasonal.COCOA_F.get()) {
			tooltip.add(Component.translatable("tips.item_cocoa_ferm").withStyle(ChatFormatting.GRAY)); }
		if (this == Items_Seasonal.COCOA_R.get()) {
			tooltip.add(Component.translatable("tips.item_cocoa_roast").withStyle(ChatFormatting.GRAY)); }
		if (this == Items_Seasonal.COCOA_M.get()) {
			tooltip.add(Component.translatable("tips.item_cocoa_mass").withStyle(ChatFormatting.GRAY)); }
		if (this == Items_Seasonal.CHOCO_raw.get()) {
			tooltip.add(Component.translatable("tips.item_choco_raw").withStyle(ChatFormatting.GRAY)); }
		
		if (this == Items_Wablock.SHOUSEKKAI.get()) {
			tooltip.add(Component.translatable("tips.item_shousekkai_c").withStyle(ChatFormatting.GRAY)); }
		if (this == Items_Wablock.CLAYKAWARA.get()) {
			tooltip.add(Component.translatable("tips.item_claykawara").withStyle(ChatFormatting.GRAY)); }
	}
}
