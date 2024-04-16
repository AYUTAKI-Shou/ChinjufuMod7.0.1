package com.ayutaki.chinjufumod;

import java.util.LinkedList;
import java.util.List;

import com.ayutaki.chinjufumod.handler.Biomes_CM;
import com.ayutaki.chinjufumod.registry.Chinjufu_Blocks;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Furniture_Blocks;
import com.ayutaki.chinjufumod.registry.Garden_Blocks;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
import com.ayutaki.chinjufumod.registry.Harbor_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Armor;
import com.ayutaki.chinjufumod.registry.Items_Chinjufu;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Items_Wablock;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.Items_WallPane;
import com.ayutaki.chinjufumod.registry.Items_Weapon;
import com.ayutaki.chinjufumod.registry.JPBlock_Blocks;
import com.ayutaki.chinjufumod.registry.JPDeco_Blocks;
import com.ayutaki.chinjufumod.registry.KamoiPlanks_Blocks;
import com.ayutaki.chinjufumod.registry.KamoiShikkui_Blocks;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;
import com.ayutaki.chinjufumod.registry.Lamp_Blocks;
import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;
import com.ayutaki.chinjufumod.registry.Slidedoor_Blocks;
import com.ayutaki.chinjufumod.registry.Unit_Blocks;
import com.ayutaki.chinjufumod.registry.WallBrick_Blocks;
import com.ayutaki.chinjufumod.registry.WallPaneJP_Blocks;
import com.ayutaki.chinjufumod.registry.WallPane_Blocks;
import com.ayutaki.chinjufumod.registry.Window_Blocks;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

public class RegisterHandler_CM {

	/* ブロックを登録する【内部クラス】 Register Blocks. 【Inner Classs】 */
	@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID)
	public static class Blocks {

		public static final List<Block> BLOCKS = new LinkedList<>();

		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) {

			Chinjufu_Blocks.init();
			Chinjufu_Blocks.register();
			Unit_Blocks.init();
			Unit_Blocks.register();
			Furniture_Blocks.init();
			Furniture_Blocks.register();
			Lamp_Blocks.init();
			Lamp_Blocks.register();
			Harbor_Blocks.init();
			Harbor_Blocks.register();
			Window_Blocks.init();
			Window_Blocks.register();
			
			Crop_Blocks.init();
			Crop_Blocks.register();
			Hakkou_Blocks.init();
			Hakkou_Blocks.register();
			Dish_Blocks.init();
			Dish_Blocks.register();
			Kitchen_Blocks.init();
			Kitchen_Blocks.register();
			
			Seasonal_Blocks.init();
			Seasonal_Blocks.register();
			
			JPDeco_Blocks.init();
			JPDeco_Blocks.register();
			Garden_Blocks.init();
			Garden_Blocks.register();
			Slidedoor_Blocks.init();
			Slidedoor_Blocks.register();
			JPBlock_Blocks.init();
			JPBlock_Blocks.register();

			KamoiShikkui_Blocks.init();
			KamoiShikkui_Blocks.register();
			KamoiPlanks_Blocks.init();
			KamoiPlanks_Blocks.register();
			WallBrick_Blocks.init();
			WallBrick_Blocks.register();
			WallPane_Blocks.init();
			WallPane_Blocks.register();
			WallPaneJP_Blocks.init();
			WallPaneJP_Blocks.register();

			BLOCKS.stream().forEach(block -> event.getRegistry().register(block));
		}
	}


	/* アイテムを登録する【内部クラス】 Register Items. 【Inner Classs】 */
	@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID)
	public static class Items {
		public static final List<Item> ITEMS = new LinkedList<>();

		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {

			Items_Chinjufu.init();
			Items_Chinjufu.register();
			Items_Teatime.init();
			Items_Teatime.register();

			Items_Seasonal.init();
			Items_Seasonal.register();

			Items_Armor.init();
			Items_Armor.register();
			Items_Weapon.init();
			Items_Weapon.register();

			Items_Wadeco.init();
			Items_Wadeco.register();

			Items_Wablock.init();
			Items_Wablock.register();

			Items_WallPane.init();
			Items_WallPane.register();

			ITEMS.stream().forEach(item -> event.getRegistry().register(item));
		}
	}


 /* ドロップ時やインベントリにおける, アイテムやアイテムブロックの描画を登録する【内部クラス】
	 * Register rendering of Items and ItemBlocks in drop and inventory. 【Inner Classs】 */
	@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, value = Side.CLIENT)
	public static class ItemModels {

		@SubscribeEvent
		public static void registerModels(ModelRegistryEvent event) {
			/** 鎮守府MOD 金剛 **/
			Items_Chinjufu.registerRenders();

			/** 鎮守府MOD 金剛 ティータイム **/
			Items_Teatime.registerRenders();

			/** 鎮守府MOD 金剛 季節物 **/
			Items_Seasonal.registerRenders();

			/** 鎮守府MOD 金剛 艤装 **/
			Items_Weapon.registerRenders();
			Items_Armor.registerRenders();

			/** 鎮守府MOD 扶桑 和装飾 **/
			Items_Wadeco.registerRenders();

			/** 鎮守府MOD 扶桑 和ブロック **/
			Items_Wablock.registerRenders();

			/** 鎮守府MOD 扶桑 外壁パネル **/
			WallPane_Blocks.registerRenders();
			WallPaneJP_Blocks.registerRenders();
			Items_WallPane.registerRenders();
		}
	}

	@Mod.EventBusSubscriber
	private static class Biomes {
		@SubscribeEvent
		public static void registerBiomes(RegistryEvent.Register<Biome> event) {
			Biomes_CM.registerBiomes(event);
		}
	}
}
