package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.kamoi.Kamoi_Ichoh;
import com.ayutaki.chinjufumod.blocks.kamoi.Kamoi_Kaede;
import com.ayutaki.chinjufumod.blocks.kamoi.Kamoi_Sakura;
import com.ayutaki.chinjufumod.blocks.season.PressurePlate_CM;
import com.ayutaki.chinjufumod.blocks.season.TrapDoor_CM;
import com.ayutaki.chinjufumod.blocks.season.WoodButton_CM;
import com.ayutaki.chinjufumod.blocks.wallpane.WallPane_Stage3;
import com.ayutaki.chinjufumod.blocks.wallpane.WallPane_Stage4;
import com.ayutaki.chinjufumod.blocks.wood.CM_SaplingBlock;
import com.ayutaki.chinjufumod.blocks.wood.Carpet_CM;
import com.ayutaki.chinjufumod.blocks.wood.FallLeaf;
import com.ayutaki.chinjufumod.blocks.wood.KuriIga_Bush;
import com.ayutaki.chinjufumod.blocks.wood.KuriIga_Fall;
import com.ayutaki.chinjufumod.blocks.wood.Suiden;
import com.ayutaki.chinjufumod.blocks.wood.Take_CM;
import com.ayutaki.chinjufumod.blocks.wood.Takenoko;
import com.ayutaki.chinjufumod.blocks.wood.Tree_AutumnOak;
import com.ayutaki.chinjufumod.blocks.wood.Tree_Ichoh;
import com.ayutaki.chinjufumod.blocks.wood.Tree_Kaede;
import com.ayutaki.chinjufumod.blocks.wood.Tree_Sakura;
import com.ayutaki.chinjufumod.blocks.wood.WoodFenceGate_CM;
import com.ayutaki.chinjufumod.blocks.wood.WoodFence_CM;
import com.ayutaki.chinjufumod.blocks.wood.WoodLeaf_CM;
import com.ayutaki.chinjufumod.blocks.wood.WoodLeaf_Kuri;
import com.ayutaki.chinjufumod.blocks.wood.WoodPillar_CM;
import com.ayutaki.chinjufumod.blocks.wood.WoodPlanks_CM;
import com.ayutaki.chinjufumod.blocks.wood.WoodSlab_CM;
import com.ayutaki.chinjufumod.blocks.wood.WoodStairs_CM;

import net.minecraft.block.Block;
import net.minecraft.block.Block.Properties;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Wood_Blocks {

	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);

	public static Block SUIDEN = register("block_suiden", new Suiden(Block.Properties.create(Material.EARTH).tickRandomly()
			.hardnessAndResistance(1.0F, 5.0F).sound(SoundType.PLANT)));
	/**バイオームの土壌として使う際は Material.EARTH **/
	public static Block FALL_LEAF = register("block_fall_leaf", new FallLeaf(Block.Properties.create(Material.EARTH).tickRandomly()
			.hardnessAndResistance(0.75F, 5.0F).sound(SoundType.PLANT)));

	public static Block SAKURA_log = register("block_tree_sakura_log", logPillar());
	public static Block KAEDE_log = register("block_tree_kaede_log", logPillar());
	public static Block ICHOH_log = register("block_tree_ichoh_log", logPillar());
	public static Block OAKKARE_log = register("block_tree_oakkare_log", logPillar());
	
	public static Block SAKURA_flow = register("block_tree_sakura_flow", new WoodLeaf_CM(leavesRandom(MaterialColor.PINK)));
	public static Block KAEDE_leaf = register("block_tree_kaede_leaf", new WoodLeaf_CM(leavesRandom(MaterialColor.RED)));
	public static Block ICHOH_leaf = register("block_tree_ichoh_leaf", new WoodLeaf_CM(leavesRandom(MaterialColor.YELLOW)));
	public static Block OAKKARE_leaf = register("block_tree_oakkare_leaf", new WoodLeaf_Kuri(leavesRandom(MaterialColor.BROWN)));
	
	public static Block SAKURA_nae = register("block_tree_sakura_nae", new CM_SaplingBlock(new Tree_Sakura(), naeRandom()));
	public static Block KAEDE_nae = register("block_tree_kaede_nae", new CM_SaplingBlock(new Tree_Kaede(), naeRandom()));
	public static Block ICHOH_nae = register("block_tree_ichoh_nae", new CM_SaplingBlock(new Tree_Ichoh(), naeRandom()));
	public static Block OAKKARE_nae = register("block_tree_oakkare_nae", new CM_SaplingBlock(new Tree_AutumnOak(), naeRandom()));

	public static Block KURIIGA_FALL = register("block_chestnuts", new KuriIga_Fall(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(0.1F).sound(SoundType.SNOW).notSolid()));
	public static Block KURIIGA_BUSH = register("block_chestnuts_bush", new KuriIga_Bush(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(0.1F).sound(SoundType.SNOW).notSolid()));
	
	public static Block TAKE = register("block_take", new Take_CM(Block.Properties.create(Material.BAMBOO, MaterialColor.FOLIAGE)
			.tickRandomly().hardnessAndResistance(1.0F).sound(SoundType.BAMBOO).notSolid()));
	public static Block TAKENOKO = register("block_takenoko", new Takenoko(Block.Properties.create(Material.WOOD)
			.doesNotBlockMovement().tickRandomly().hardnessAndResistance(1.0F).sound(SoundType.BAMBOO_SAPLING).notSolid()));
	
	public static Block SAKURA_planks = register("block_planks_sakura", planks());
	public static Block KAEDE_planks = register("block_planks_kaede", planks());
	public static Block ICHOH_planks = register("block_planks_ichoh", planks());

	public static Block SAKURA_slabhalf = register("block_slabhalf_sakura", woodenSlab());
	public static Block KAEDE_slabhalf = register("block_slabhalf_kaede", woodenSlab());
	public static Block ICHOH_slabhalf = register("block_slabhalf_ichoh", woodenSlab());

	public static Block SAKURA_stairs = register("block_stairs_sakura", woodenStairs());
	public static Block KAEDE_stairs = register("block_stairs_kaede", woodenStairs());
	public static Block ICHOH_stairs = register("block_stairs_ichoh", woodenStairs());

	public static Block PILLAR_saku = register("block_pillar_sakura", logPillar());
	public static Block PILLAR_kae = register("block_pillar_kaede", logPillar());
	public static Block PILLAR_ich = register("block_pillar_ichoh", logPillar());

	public static Block PILLARSLAB_saku = register("block_kamoi_sakura", new Kamoi_Sakura(woodState()));
	public static Block PILLARSLAB_kae = register("block_kamoi_kaede", new Kamoi_Kaede(woodState()));
	public static Block PILLARSLAB_ich = register("block_kamoi_ichoh", new Kamoi_Ichoh(woodState()));

	public static Block SAKURA_FENCE = register("block_fence_sakura", woodenFence());
	public static Block KAEDE_FENCE = register("block_fence_kaede", woodenFence());
	public static Block ICHOH_FENCE = register("block_fence_ichoh", woodenFence());
	public static Block SAKURA_FGATE = register("block_fencegate_sakura", woodenFenceGate());
	public static Block KAEDE_FGATE = register("block_fencegate_kaede", woodenFenceGate());
	public static Block ICHOH_FGATE = register("block_fencegate_ichoh", woodenFenceGate());

	public static Block SAKURA_TRAPDOOR = register("block_trapdoor_sakura", trapDoor());
	public static Block KAEDE_TRAPDOOR = register("block_trapdoor_kaede", trapDoor());
	public static Block ICHOH_TRAPDOOR = register("block_trapdoor_ichoh", trapDoor());
	public static Block SAKURA_PLATE = register("block_plate_sakura", pressurePlate());
	public static Block KAEDE_PLATE = register("block_plate_kaede", pressurePlate());
	public static Block ICHOH_PLATE = register("block_plate_ichoh", pressurePlate());
	public static Block SAKURA_BUTTON = register("block_button_sakura", woodenButton());
	public static Block KAEDE_BUTTON = register("block_button_kaede", woodenButton());
	public static Block ICHOH_BUTTON = register("block_button_ichoh", woodenButton());

	public static Block SAKURA_carpet = register("block_carpet_sakura", carpetLeaf());
	public static Block KAEDE_carpet = register("block_carpet_kaede", carpetLeaf());
	public static Block ICHOH_carpet = register("block_carpet_ichoh", carpetLeaf());
	public static Block OCHIBA_carpet = register("block_carpet_ochiba", carpetLeaf());

	public static Block WP_LOG_sakura = register("block_wp_log_sakura", wallPaneStage3());
	public static Block WP_LOG_kaede = register("block_wp_log_kaede", wallPaneStage3());
	public static Block WP_LOG_ichoh = register("block_wp_log_ichoh", wallPaneStage3());

	public static Block WP_PLANK_sakura = register("block_wp_plank_sakura", wallPaneStage4());
	public static Block WP_PLANK_kaede = register("block_wp_plank_kaede", wallPaneStage4());
	public static Block WP_PLANK_ichoh = register("block_wp_plank_ichoh", wallPaneStage4());

	/* Share variables */
	private static WoodPillar_CM logPillar() {
		return new WoodPillar_CM(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD));
	}

	private static Block planks() {
		return new WoodPlanks_CM(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD));
	}

	private static WoodSlab_CM woodenSlab() {
		return new WoodSlab_CM(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid());
	}

	private static WoodStairs_CM woodenStairs() {
		return new WoodStairs_CM(SAKURA_planks.getDefaultState(), Block.Properties.create(Material.WOOD)
				.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid());
	}

	private static WoodFence_CM woodenFence() {
		return new WoodFence_CM(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid());
	}

	private static WoodFenceGate_CM woodenFenceGate() {
		return new WoodFenceGate_CM(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid());
	}

	private static TrapDoor_CM trapDoor() {
		return new TrapDoor_CM(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid());
	}

	private static PressurePlate_CM pressurePlate() {
		return new PressurePlate_CM(PressurePlate_CM.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD)
				.hardnessAndResistance(0.5F).sound(SoundType.WOOD).notSolid());
	}

	private static WoodButton_CM woodenButton() {
		return new WoodButton_CM(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD).notSolid());
	}

	private static Carpet_CM carpetLeaf() {
		return new Carpet_CM(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 1.0F).sound(SoundType.PLANT).notSolid());
	}

	private static WallPane_Stage3 wallPaneStage3() {
		return new WallPane_Stage3(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid());
	}

	private static WallPane_Stage4 wallPaneStage4() {
		return new WallPane_Stage4(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid());
	}

	private static Properties leavesRandom(MaterialColor color) {
		return Block.Properties.create(Material.LEAVES, color).hardnessAndResistance(0.2F).sound(SoundType.PLANT).notSolid().tickRandomly();
	}
	
	private static Properties naeRandom() {
		return Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F, 1.0F).sound(SoundType.WOOD).notSolid().tickRandomly();
	}

	private static Properties woodState() {
		return Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid();
	}
	
	///* Register *///
	private static Block register(String name, Block block) {
		BLOCKS.register(name, () -> block);
		return block;
	}
}
