package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.gate.Gate_iron;
import com.ayutaki.chinjufumod.blocks.gate.Gate_irongrill;
import com.ayutaki.chinjufumod.blocks.gate.Gate_spruce;
import com.ayutaki.chinjufumod.blocks.season.Door_CM;

import net.minecraft.block.Block;
import net.minecraft.block.Block.Properties;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Gate_Blocks {

	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);

	public static Block GATE_SPRUCE = register("block_gate_spruce", gateSpruce());
	public static Block GATE_SPRUCE_B = register("block_gate_spruce_b", gateSpruce());
	public static Block GATE_IRON = register("block_gate_iron", new Gate_iron(ironState()));
	public static Block GATE_IRONGRILL = register("block_gate_irongrill", new Gate_irongrill(ironState()));

	public static Block DOOR_SAKURA = register("block_door_sakura", doorCM());
	public static Block DOOR_KAEDE = register("block_door_kaede", doorCM());
	public static Block DOOR_ICHOH = register("block_door_ichoh", doorCM());

	/* Share variables */
	private static Gate_spruce gateSpruce() {
		return new Gate_spruce(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 10.0F).sound(SoundType.WOOD).notSolid());
	}
	
	private static Properties ironState() {
		return Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 20.0F).sound(SoundType.METAL).notSolid();
	}

	private static Door_CM doorCM() {
		return new Door_CM(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 10.0F).sound(SoundType.WOOD).notSolid());
	}
	
	///* Register *///
	private static Block register(String name, Block block) {
		BLOCKS.register(name, () -> block);
		return block;
	}
}
