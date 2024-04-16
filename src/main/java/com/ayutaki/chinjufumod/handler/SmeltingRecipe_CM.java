package com.ayutaki.chinjufumod.handler;

import com.ayutaki.chinjufumod.registry.Items_Chinjufu;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Items_Wablock;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.Items_WallPane;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SmeltingRecipe_CM {

	/* かまどレシピの登録 Register smelting recipe.*/
	public static void registerSmeltingRecipes() {
		register();
	}

	public static void register() {
		/*ひび入り花崗岩レンガ*/
		GameRegistry.addSmelting(new ItemStack(Items_WallPane.BRICK_C, 1, 1), new ItemStack(Items_WallPane.BRICK_C, 1, 7), 0.5F);

		/*ひび入り閃緑岩レンガ*/
		GameRegistry.addSmelting(new ItemStack(Items_WallPane.BRICK_C, 1, 2), new ItemStack(Items_WallPane.BRICK_C, 1, 8), 0.5F);

		/*ひび入り安山岩レンガ*/
		GameRegistry.addSmelting(new ItemStack(Items_WallPane.BRICK_C, 1, 3), new ItemStack(Items_WallPane.BRICK_C, 1, 9), 0.5F);

		/*瓦(黒)*/
		GameRegistry.addSmelting(Items_Wablock.CLAYKAWARA, new ItemStack(Items_Wablock.KAWARA, 1, 15), 0.5F);

		/*アルミニウム精錬 素材 -> 精錬結果*/
		GameRegistry.addSmelting(Items_Chinjufu.BAUXITE, new ItemStack(Items_Chinjufu.ALUMINUM, 1), 1.0F);

		/*マッチ*/
		GameRegistry.addSmelting(Items_Teatime.Item_MATCH, new ItemStack(Items.DYE, 1, 15), 0.5F);

		/*生酒の火入れ*/
		GameRegistry.addSmelting(Items_Teatime.NAMASAKEBOT, new ItemStack(Items_Teatime.SAKEBOT, 1), 0.5F);

		/*皿*/
		GameRegistry.addSmelting(new ItemStack(Items_Teatime.CLAY_DISH, 1, 1), new ItemStack(Items_Teatime.Item_SARA, 1), 0.5F);

		/*湯呑み*/
		GameRegistry.addSmelting(new ItemStack(Items_Teatime.CLAY_DISH, 1, 2), new ItemStack(Items_Teatime.Item_DISH, 1, 1), 0.5F);

		/*急須*/
		GameRegistry.addSmelting(new ItemStack(Items_Teatime.CLAY_DISH, 1, 3), new ItemStack(Items_Teatime.KYUSU_kara, 1), 0.5F);

		/*ティーカップ*/
		GameRegistry.addSmelting(new ItemStack(Items_Teatime.CLAY_DISH, 1, 4), new ItemStack(Items_Teatime.Item_DISH, 1, 2), 0.5F);

		/*ティーポット*/
		GameRegistry.addSmelting(new ItemStack(Items_Teatime.CLAY_DISH, 1, 5), new ItemStack(Items_Teatime.TEAPOT_kara, 1), 0.5F);

		/*茶碗*/
		GameRegistry.addSmelting(new ItemStack(Items_Teatime.CLAY_DISH, 1, 6), new ItemStack(Items_Teatime.Item_DISH, 1, 3), 0.5F);

		/*鍋*/
		GameRegistry.addSmelting(new ItemStack(Items_Teatime.CLAY_DISH, 1, 7), new ItemStack(Items_Teatime.NABE_kara, 1), 0.5F);

		/*呑水*/
		GameRegistry.addSmelting(new ItemStack(Items_Teatime.CLAY_DISH, 1, 8), new ItemStack(Items_Teatime.Item_DISH, 1, 5), 0.5F);

		/*どんぶり*/
		GameRegistry.addSmelting(new ItemStack(Items_Teatime.CLAY_DISH, 1, 9), new ItemStack(Items_Teatime.Item_DISH, 1, 6), 0.5F);

		/*テーブルロール*/
		GameRegistry.addSmelting(new ItemStack(Items_Teatime.KOMUGI, 1, 3), new ItemStack(Items_Teatime.BUN, 1), 0.5F);

		/*スコーン*/
		GameRegistry.addSmelting(new ItemStack(Items_Teatime.KOMUGI, 1, 5), new ItemStack(Items_Teatime.SCONE, 1), 0.5F);

		/*せんべい*/
		GameRegistry.addSmelting(new ItemStack(Items_Teatime.KOMUGI, 1, 6), new ItemStack(Items_Teatime.SENBEI, 1), 0.5F);

		/*焼きとうもろこし*/
		GameRegistry.addSmelting(Items_Teatime.FOOD_CORN, new ItemStack(Items_Teatime.FOOD_CORN_B, 1), 0.5F);

		/* 新原木から木炭 */
		GameRegistry.addSmelting(Items_Seasonal.SAKURA_log, new ItemStack(Items.COAL, 1, 1), 0.5F);
		GameRegistry.addSmelting(Items_Seasonal.KAEDE_log, new ItemStack(Items.COAL, 1, 1), 0.5F);
		GameRegistry.addSmelting(Items_Seasonal.ICHOH_log, new ItemStack(Items.COAL, 1, 1), 0.5F);

		/* 藁灰 */
		GameRegistry.addSmelting(Items_Seasonal.WARATABA, new ItemStack(Items_Seasonal.WARAHAI), 0.1F);
		GameRegistry.addSmelting(Blocks.HAY_BLOCK, new ItemStack(Items_Seasonal.WARAHAI), 0.1F);

		/* ピザ */
		GameRegistry.addSmelting(new ItemStack(Items_Teatime.KOMUGI, 1, 8), new ItemStack(Items_Teatime.PIZZA, 1, 0), 0.1F);
		GameRegistry.addSmelting(new ItemStack(Items_Teatime.KOMUGI, 1, 9), new ItemStack(Items_Teatime.PIZZA, 1, 1), 0.1F);
		GameRegistry.addSmelting(new ItemStack(Items_Teatime.KOMUGI, 1, 10), new ItemStack(Items_Teatime.PIZZA, 1, 2), 0.1F);
		GameRegistry.addSmelting(new ItemStack(Items_Teatime.KOMUGI, 1, 11), new ItemStack(Items_Teatime.PIZZA, 1, 3), 0.1F);
		
		/* チョコレート焙煎 */
		GameRegistry.addSmelting(Items_Seasonal.COCOA_F, new ItemStack(Items_Seasonal.COCOA_R), 0.1F);

		/*竹ブロック(焦げ)*/
		GameRegistry.addSmelting(Items_Wadeco.TAKECUBE, new ItemStack(Items_Wadeco.TAKECUBE_K, 1, 0), 0.5F);
		
		/*焼きイカ*/
		GameRegistry.addSmelting(Items_Teatime.CUT_IKA, new ItemStack(Items_Teatime.COOKED_IKA, 1, 0), 0.5F);
		
		/*焼きハマグリ*/
		GameRegistry.addSmelting(Items_Teatime.HAMAGURI, new ItemStack(Items_Teatime.HAMAGURI_COOK, 1, 0), 0.1F);
		
		/*焼きクリ*/
		GameRegistry.addSmelting(Items_Seasonal.KURI, new ItemStack(Items_Seasonal.KURI_ROAST, 1, 0), 0.1F);
		
		/*焼きタケノコ*/
		GameRegistry.addSmelting(Items_Seasonal.TAKENOKO, new ItemStack(Items_Seasonal.TAKENOKO_ROAST, 1, 0), 0.5F);
	}

}
