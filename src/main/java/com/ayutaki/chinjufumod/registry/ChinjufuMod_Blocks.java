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

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ChinjufuMod_Blocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);

	public static Block BAUXITE_ORE = register("block_bauxite_ore", new BauxiteOre(AbstractBlock.Properties.of(Material.STONE).sound(SoundType.STONE)
			.requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).harvestLevel(2).strength(3.0F, 3.0F)));

	public static Block OIL_DRUM = register("block_fuel_can", new Oil_Drum(metalState()));

	public static Block EMPTY_BOX = register("block_empty_box", new EmptyBox(boxState().isSuffocating(ChinjufuMod_Blocks::never)));
	public static Block AMMOBOX = register("block_ammunition_box", new AmmoBauxiteBox(boxState()));
	public static Block BAUXITE_BOX = register("block_bauxite_box", new AmmoBauxiteBox(boxState()));

	public static Block ALUMI_BLOCK = register("block_alumi_block", new AlumiBlock(metalState()));
	public static Block STEEL_BLOCK = register("block_steel_block", new AlumiBlock(metalState()));
	public static Block GOLD_BLOCK = register("block_gold_block", new AlumiBlock(metalState()));
	public static Block NETHERITE_BLOCK = register("block_netherite_block", new AlumiBlock(metalState()));
	
	public static Block B_ADMIRAL_STAMP = register("block_stamp_block", new AdmiralStampBlock(stampState()));
	public static Block I_ADMIRAL_STAMP = register("item_admiralstamp_b", new AdmiralStampItem(stampState()));
	public static Block REPORT_BOX = register("block_report_box", new Report_Box(metalState()));
	
	public static Block WAKE_WATER1 = register("block_wake_water1", new WakeWater1(wakeState()));
	public static Block WAKE_WATER2 = register("block_wake_water2", new WakeWater2(wakeState()));
	public static Block WAKE_WATER3 = register("block_wake_water3", new WakeWater3(wakeState()));
	

	/* Share variables */
	private static boolean never(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	private static Boolean neverEntity(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> entity) {
		return (boolean)false;
	}
	
	private static Properties metalState() {
		return AbstractBlock.Properties.of(Material.METAL).sound(SoundType.METAL).strength(1.0F, 3.0F).noOcclusion().isValidSpawn(ChinjufuMod_Blocks::neverEntity);
	}
	
	private static Properties boxState() {
		return AbstractBlock.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(1.0F, 3.0F).isValidSpawn(ChinjufuMod_Blocks::neverEntity);
	}
	
	private static Properties stampState() {
		return AbstractBlock.Properties.of(Material.WOOD).noCollission().sound(SoundType.WOOD).strength(0.5F).noOcclusion()
				.isValidSpawn(ChinjufuMod_Blocks::neverEntity).isSuffocating(ChinjufuMod_Blocks::never);
	}
	
	private static Properties wakeState() {
		return AbstractBlock.Properties.of(Material.GLASS).sound(SoundType.SNOW).strength(0.1F, 3.0F).noOcclusion()
				.isValidSpawn(ChinjufuMod_Blocks::neverEntity).isSuffocating(ChinjufuMod_Blocks::never);
	}
	
	
	///* Register *///
	private static Block register(String name, Block block) {
		BLOCKS.register(name, () -> block);
		return block;
	}
}
/**
 * Utility class to help with managing registry entries.
 * Maintains a list of all suppliers for entries and registers them during the proper Register event.
 * Suppliers should return NEW instances every time.
 *
 *Example Usage:
 *<pre>
 * private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
 * private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
 *
 * public static final RegistryObject<Block> ROCK_BLOCK = BLOCKS.register("rock", () -> new Block(Block.Properties.create(Material.ROCK)));
 * public static final RegistryObject<Item> ROCK_ITEM = ITEMS.register("rock", () -> new BlockItem(ROCK_BLOCK.get(), new Item.Properties().group(ItemGroup.MISC)));
 *
 * public ExampleMod() {
 * ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
 * BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
 * }
 *</pre>
 *
 * @param <T> The base registry type, must be a concrete base class, do not use subclasses or wild cards.
 */
