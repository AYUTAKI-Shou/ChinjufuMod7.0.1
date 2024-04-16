package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.cmblock.AdmiralStampBlock;
import com.ayutaki.chinjufumod.blocks.cmblock.AdmiralStampItem;
import com.ayutaki.chinjufumod.blocks.cmblock.AlumiBlock;
import com.ayutaki.chinjufumod.blocks.cmblock.AmmoBauxiteBox;
import com.ayutaki.chinjufumod.blocks.cmblock.BauxiteOre;
import com.ayutaki.chinjufumod.blocks.cmblock.EmptyBox;
import com.ayutaki.chinjufumod.blocks.cmblock.Oil_Drum;
import com.ayutaki.chinjufumod.blocks.cmblock.Report_Box;
import com.ayutaki.chinjufumod.blocks.cmblock.WakeWater1;
import com.ayutaki.chinjufumod.blocks.cmblock.WakeWater2;
import com.ayutaki.chinjufumod.blocks.cmblock.WakeWater3;

import net.minecraft.block.Block;
import net.minecraft.block.Block.Properties;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ChinjufuMod_Blocks {

	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);

	public static Block BAUXITE_ORE = register("block_bauxite_ore", new BauxiteOre(Block.Properties.create(Material.ROCK).sound(SoundType.STONE)
			.harvestTool(ToolType.PICKAXE).harvestLevel(2).hardnessAndResistance(3.0F, 3.0F)));

	public static Block OIL_DRUM = register("block_fuel_can", new Oil_Drum(metalState()));

	public static Block EMPTY_BOX = register("block_empty_box", new EmptyBox(boxState()));
	public static Block AMMOBOX = register("block_ammunition_box", new AmmoBauxiteBox(boxState()));
	public static Block BAUXITE_BOX = register("block_bauxite_box", new AmmoBauxiteBox(boxState()));

	public static Block ALUMI_BLOCK = register("block_alumi_block", new AlumiBlock(metalState()));
	public static Block STEEL_BLOCK = register("block_steel_block", new AlumiBlock(metalState()));
	public static Block GOLD_BLOCK = register("block_gold_block", new AlumiBlock(metalState()));

	public static Block B_ADMIRAL_STAMP = register("block_stamp_block", new AdmiralStampBlock(stampState()));
	public static Block I_ADMIRAL_STAMP = register("item_admiralstamp_b", new AdmiralStampItem(stampState()));
	public static Block REPORT_BOX = register("block_report_box", new Report_Box(metalState()));
	
	public static Block WAKE_WATER1 = register("block_wake_water1", new WakeWater1(wakeState()));
	public static Block WAKE_WATER2 = register("block_wake_water2", new WakeWater2(wakeState()));
	public static Block WAKE_WATER3 = register("block_wake_water3", new WakeWater3(wakeState()));

	
	/* Share variables */
	private static Properties metalState() {
		return Block.Properties.create(Material.WOOD).sound(SoundType.METAL).hardnessAndResistance(1.0F, 3.0F).notSolid();
	}
	
	private static Properties boxState() {
		return Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.0F, 3.0F).notSolid();
	}
	
	private static Properties stampState() {
		return Block.Properties.create(Material.WOOD).doesNotBlockMovement().sound(SoundType.WOOD).hardnessAndResistance(0.5F).notSolid();
	}
	
	private static Properties wakeState() {
		return Block.Properties.create(Material.GLASS).sound(SoundType.SNOW).hardnessAndResistance(0.1F, 3.0F).notSolid();
	}
	
	///* Register *///
	private static Block register(String name, Block block) {
		BLOCKS.register(name, () -> block);
		return block;
	}
}
