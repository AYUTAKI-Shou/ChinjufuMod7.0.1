package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.crop.Ami_Shikake;
import com.ayutaki.chinjufumod.blocks.crop.Ami_Youshoku;
import com.ayutaki.chinjufumod.blocks.crop.Cabbage;
import com.ayutaki.chinjufumod.blocks.crop.Chanoki;
import com.ayutaki.chinjufumod.blocks.crop.Chilipepper;
import com.ayutaki.chinjufumod.blocks.crop.Corn;
import com.ayutaki.chinjufumod.blocks.crop.Cumin;
import com.ayutaki.chinjufumod.blocks.crop.Enden;
import com.ayutaki.chinjufumod.blocks.crop.Enden_kara;
import com.ayutaki.chinjufumod.blocks.crop.Grape;
import com.ayutaki.chinjufumod.blocks.crop.GreenOnion;
import com.ayutaki.chinjufumod.blocks.crop.Hakusai;
import com.ayutaki.chinjufumod.blocks.crop.Hamaguri;
import com.ayutaki.chinjufumod.blocks.crop.HodaGi_A_Bot;
import com.ayutaki.chinjufumod.blocks.crop.HodaGi_A_Top;
import com.ayutaki.chinjufumod.blocks.crop.HodaGi_B_Bot;
import com.ayutaki.chinjufumod.blocks.crop.HodaGi_B_Top;
import com.ayutaki.chinjufumod.blocks.crop.HodaGi_C_Bot;
import com.ayutaki.chinjufumod.blocks.crop.HodaGi_C_Top;
import com.ayutaki.chinjufumod.blocks.crop.Inagi;
import com.ayutaki.chinjufumod.blocks.crop.LostClam;
import com.ayutaki.chinjufumod.blocks.crop.Mikan;
import com.ayutaki.chinjufumod.blocks.crop.NoriAmi;
import com.ayutaki.chinjufumod.blocks.crop.Onion;
import com.ayutaki.chinjufumod.blocks.crop.Pepper;
import com.ayutaki.chinjufumod.blocks.crop.Rice;
import com.ayutaki.chinjufumod.blocks.crop.Rice_8;
import com.ayutaki.chinjufumod.blocks.crop.Sakura_me;
import com.ayutaki.chinjufumod.blocks.crop.SeedsBox;
import com.ayutaki.chinjufumod.blocks.crop.Soy;
import com.ayutaki.chinjufumod.blocks.crop.Spinach;
import com.ayutaki.chinjufumod.blocks.crop.Tomato;
import com.ayutaki.chinjufumod.blocks.crop.Turmeric;

import net.minecraft.block.Block;
import net.minecraft.block.Block.Properties;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Crop_Blocks {

	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);

	public static Block SEEDSBOX = register("block_seedsbox", new SeedsBox(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.CROP).notSolid()));

	public static Block CABBAGE = register("block_vege_cabbage", new Cabbage(cropRandom()));
	public static Block HAKUSAI = register("block_vege_hakusai", new Hakusai(cropRandom()));
	public static Block CORN = register("block_vege_corn", new Corn(cropRandom()));
	/** 6.4.1 **/ public static Block GREENONION = register("block_vege_greenonion", new GreenOnion(cropRandom()));
	public static Block ONION = register("block_vege_onion", new Onion(cropRandom()));
	public static Block RICE = register("block_vege_rice", new Rice(cropRandom()));
	public static Block RICE_8 = register("block_vege_rice_8", new Rice_8(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().hardnessAndResistance(0.1F).sound(SoundType.CROP).notSolid()));
	public static Block SOY = register("block_vege_soy", new Soy(cropRandom()));
	public static Block SPINACH = register("block_vege_spinach", new Spinach(cropRandom()));
	public static Block TOMATO = register("block_vege_tomato", new Tomato(cropRandom()));
	public static Block SAKURA = register("block_tree_sakura_me", new Sakura_me(cropRandom()));

	public static Block CHANOKI = register("block_wood_chanoki", new Chanoki(woodRandom()));
	public static Block BUDOUNOKI = register("block_wood_grape", new Grape(woodRandom()));
	public static Block MIKAN = register("block_wood_mikan", new Mikan(woodRandom()));

	public static Block HODAGI_A_BOT = register("block_hodagi_a_bot", new HodaGi_A_Bot(woodRandom()));
	public static Block HODAGI_A_TOP = register("block_hodagi_a_top", new HodaGi_A_Top(woodRandom()));
	public static Block HODAGI_B_BOT = register("block_hodagi_b_bot", new HodaGi_B_Bot(woodRandom()));
	public static Block HODAGI_B_TOP = register("block_hodagi_b_top", new HodaGi_B_Top(woodRandom()));
	public static Block HODAGI_C_BOT = register("block_hodagi_c_bot", new HodaGi_C_Bot(woodRandom()));
	public static Block HODAGI_C_TOP = register("block_hodagi_c_top", new HodaGi_C_Top(woodRandom()));

	public static Block PEPPER = register("block_spice_pepper", new Pepper(woodRandom()));
	public static Block CUMIN = register("block_spice_cumin", new Cumin(cropRandom()));
	public static Block TURMERIC = register("block_spice_turmeric", new Turmeric(cropRandom()));
	public static Block CHILI = register("block_spice_chilipepper", new Chilipepper(cropRandom()));
	
	public static Block NORIAMI = register("block_noriami", new NoriAmi(plantRandom()));
	public static Block INAGI = register("block_inagi", new Inagi(plantRandom()));

	public static Block ENDEN = register("block_enden", new Enden(sandRandom(MaterialColor.SNOW)));
	public static Block ENDEN_k = register("block_enden_k", new Enden_kara(sandRandom(MaterialColor.SNOW)));
	
	public static Block TOAMI = register("item_toami", new Block(Block.Properties.create(Material.WOOL)));
	public static Block SHIKAKE_AMI = register("block_ami_shikake", new Ami_Shikake(woolRandom()));
	public static Block YOUSHOKU_AMI = register("block_ami_youshoku", new Ami_Youshoku(woolRandom()));
	
	public static Block HAMAGURI = register("block_hamaguri", new Hamaguri(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.SNOW).notSolid()));
	public static Block KAINASHI = register("block_lostclam", new LostClam(14406560, sandRandom(MaterialColor.SAND)));
	
	/* Share variables */
	private static Properties cropRandom() {
		return Block.Properties.create(Material.PLANTS).doesNotBlockMovement().hardnessAndResistance(0.1F)
				.sound(SoundType.CROP).notSolid().tickRandomly();
	}
	
	private static Properties woodRandom() {
		return Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F)
				.sound(SoundType.WOOD).notSolid().tickRandomly();
	}
	
	private static Properties plantRandom() {
		return Block.Properties.create(Material.PLANTS).doesNotBlockMovement().hardnessAndResistance(1.0F)
				.sound(SoundType.WOOD).notSolid().tickRandomly();
	}

	private static Properties sandRandom(MaterialColor color) {
		return Block.Properties.create(Material.SAND, color).hardnessAndResistance(2.0F).sound(SoundType.SAND).notSolid().tickRandomly();
	}

	private static Properties woolRandom() {
		return Block.Properties.create(Material.WOOL).hardnessAndResistance(1.0F).sound(SoundType.CLOTH).notSolid().tickRandomly();
	}
	
	///* Register *///
	private static Block register(String name, Block block) {
		BLOCKS.register(name, () -> block);
		return block;
	}
}
