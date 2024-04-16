package com.ayutaki.chinjufumod.registry;

import java.util.function.Supplier;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.kamoi.Base_Kamoi;
import com.ayutaki.chinjufumod.blocks.kamoi.Kamoi_Ichoh;
import com.ayutaki.chinjufumod.blocks.kamoi.Kamoi_Kaede;
import com.ayutaki.chinjufumod.blocks.kamoi.Kamoi_Sakura;
import com.ayutaki.chinjufumod.blocks.season.Carpet_CM;
import com.ayutaki.chinjufumod.blocks.season.Door_CM;
import com.ayutaki.chinjufumod.blocks.season.PressurePlate_CM;
import com.ayutaki.chinjufumod.blocks.season.TrapDoor_CM;
import com.ayutaki.chinjufumod.blocks.season.WoodButton_CM;
import com.ayutaki.chinjufumod.blocks.season.WoodFenceGate_CM;
import com.ayutaki.chinjufumod.blocks.season.WoodFence_CM;
import com.ayutaki.chinjufumod.blocks.wallpane.WallPane_Stage3;
import com.ayutaki.chinjufumod.blocks.wallpane.WallPane_Stage4;
import com.ayutaki.chinjufumod.blocks.wood.CM_SaplingBlock;
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
import com.ayutaki.chinjufumod.blocks.wood.WoodLeaf_CM;
import com.ayutaki.chinjufumod.blocks.wood.WoodLeaf_Kuri;
import com.ayutaki.chinjufumod.blocks.wood.WoodPillar_CM;
import com.ayutaki.chinjufumod.blocks.wood.WoodPlanks_CM;
import com.ayutaki.chinjufumod.blocks.wood.WoodSlab_CM;
import com.ayutaki.chinjufumod.blocks.wood.WoodStairs_CM;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Wood_Blocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);

	public static final RegistryObject<Block> SUIDEN = register("block_suiden",
			() -> new Suiden(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).randomTicks().strength(1.0F, 5.0F).sound(SoundType.GRASS).isValidSpawn(Wood_Blocks::neverEntity)));

	public static final RegistryObject<Block> TAKE = register("block_take",
			() -> new Take_CM(Block.Properties.of().mapColor(MapColor.PLANT).randomTicks().strength(1.0F).sound(SoundType.BAMBOO).isSuffocating(Wood_Blocks::never).isViewBlocking(Wood_Blocks::never).dynamicShape()));
	public static final RegistryObject<Block> TAKENOKO = register("block_takenoko",
			() -> new Takenoko(Block.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().strength(1.0F).sound(SoundType.BAMBOO_SAPLING).isSuffocating(Wood_Blocks::never).isViewBlocking(Wood_Blocks::never).dynamicShape()));
	public static final RegistryObject<Block> KURIIGA_FALL = register("block_chestnuts",
			() -> new KuriIga_Fall(Block.Properties.of().mapColor(MapColor.WOOD).noCollission().strength(0.3F).sound(SoundType.SNOW).isSuffocating(Wood_Blocks::never).isViewBlocking(Wood_Blocks::never).dynamicShape()));
	public static final RegistryObject<Block> KURIIGA_BUSH = register("block_chestnuts_bush",
			() -> new KuriIga_Bush(Block.Properties.of().mapColor(MapColor.PLANT).noCollission().strength(0.3F).sound(SoundType.SNOW).isSuffocating(Wood_Blocks::never).isViewBlocking(Wood_Blocks::never).dynamicShape()));

	public static final RegistryObject<Block> FALL_LEAF = register("block_fall_leaf",
			() -> new FallLeaf(Block.Properties.of().mapColor(MapColor.DIRT).randomTicks().strength(0.75F, 5.0F).sound(SoundType.GRASS)));

	public static final RegistryObject<Block> SAKURA_log = register("block_tree_sakura_log", () -> logPillar());
	public static final RegistryObject<Block> KAEDE_log = register("block_tree_kaede_log", () -> logPillar());
	public static final RegistryObject<Block> ICHOH_log = register("block_tree_ichoh_log", () -> logPillar());
	public static final RegistryObject<Block> OAKKARE_log = register("block_tree_oakkare_log", () -> logPillar());
	
	public static final RegistryObject<Block> SAKURA_flow = register("block_tree_sakura_flow", () -> new WoodLeaf_CM(leavesRandom().mapColor(MapColor.COLOR_PINK)));
	public static final RegistryObject<Block> KAEDE_leaf = register("block_tree_kaede_leaf", () -> new WoodLeaf_CM(leavesRandom().mapColor(MapColor.COLOR_RED)));
	public static final RegistryObject<Block> ICHOH_leaf = register("block_tree_ichoh_leaf", () -> new WoodLeaf_CM(leavesRandom().mapColor(MapColor.COLOR_YELLOW)));
	public static final RegistryObject<Block> OAKKARE_leaf = register("block_tree_oakkare_leaf", () -> new WoodLeaf_Kuri(leavesRandom().mapColor(MapColor.COLOR_BROWN)));
	
	public static final RegistryObject<Block> SAKURA_nae = register("block_tree_sakura_nae", () -> new CM_SaplingBlock(new Tree_Sakura(), naeRandom()));
	public static final RegistryObject<Block> KAEDE_nae = register("block_tree_kaede_nae", () -> new CM_SaplingBlock(new Tree_Kaede(), naeRandom()));
	public static final RegistryObject<Block> ICHOH_nae = register("block_tree_ichoh_nae", () -> new CM_SaplingBlock(new Tree_Ichoh(), naeRandom()));
	public static final RegistryObject<Block> OAKKARE_nae = register("block_tree_oakkare_nae", () -> new CM_SaplingBlock(new Tree_AutumnOak(), naeRandom()));

	public static final RegistryObject<Block> SAKURA_planks = register("block_planks_sakura", () -> planks());
	public static final RegistryObject<Block> KAEDE_planks = register("block_planks_kaede", () -> planks());
	public static final RegistryObject<Block> ICHOH_planks = register("block_planks_ichoh", () -> planks());

	public static final RegistryObject<Block> SAKURA_slabhalf = register("block_slabhalf_sakura", () -> woodenSlab());
	public static final RegistryObject<Block> KAEDE_slabhalf = register("block_slabhalf_kaede", () -> woodenSlab());
	public static final RegistryObject<Block> ICHOH_slabhalf = register("block_slabhalf_ichoh", () -> woodenSlab());

	public static final RegistryObject<Block> SAKURA_stairs = register("block_stairs_sakura", () -> woodenStairs());
	public static final RegistryObject<Block> KAEDE_stairs = register("block_stairs_kaede", () -> woodenStairs());
	public static final RegistryObject<Block> ICHOH_stairs = register("block_stairs_ichoh", () -> woodenStairs());

	public static final RegistryObject<Block> PILLAR_saku = register("block_pillar_sakura", () -> logPillar());
	public static final RegistryObject<Block> PILLAR_kae = register("block_pillar_kaede", () -> logPillar());
	public static final RegistryObject<Block> PILLAR_ich = register("block_pillar_ichoh", () -> logPillar());

	public static final RegistryObject<Block> PILLARSLAB_saku = register("block_kamoi_sakura", () -> new Kamoi_Sakura(kamoiState()));
	public static final RegistryObject<Block> PILLARSLAB_kae = register("block_kamoi_kaede", () -> new Kamoi_Kaede(kamoiState()));
	public static final RegistryObject<Block> PILLARSLAB_ich = register("block_kamoi_ichoh", () -> new Kamoi_Ichoh(kamoiState()));
	
	public static final RegistryObject<Block> SAKURA_FENCE = register("block_fence_sakura", () -> woodenFence());
	public static final RegistryObject<Block> KAEDE_FENCE = register("block_fence_kaede", () -> woodenFence());
	public static final RegistryObject<Block> ICHOH_FENCE = register("block_fence_ichoh", () -> woodenFence());
	public static final RegistryObject<Block> SAKURA_FGATE = register("block_fencegate_sakura", () -> woodenFenceGate(WoodType.OAK));
	public static final RegistryObject<Block> KAEDE_FGATE = register("block_fencegate_kaede", () -> woodenFenceGate(WoodType.OAK));
	public static final RegistryObject<Block> ICHOH_FGATE = register("block_fencegate_ichoh", () -> woodenFenceGate(WoodType.OAK));

	public static final RegistryObject<Block> DOOR_SAKURA = register("block_door_sakura", () -> doorCM(BlockSetType.OAK));
	public static final RegistryObject<Block> DOOR_KAEDE = register("block_door_kaede", () -> doorCM(BlockSetType.OAK));
	public static final RegistryObject<Block> DOOR_ICHOH = register("block_door_ichoh", () -> doorCM(BlockSetType.OAK));
	
	public static final RegistryObject<Block> SAKURA_TRAPDOOR = register("block_trapdoor_sakura", () -> trapDoor(BlockSetType.OAK));
	public static final RegistryObject<Block> KAEDE_TRAPDOOR = register("block_trapdoor_kaede", () -> trapDoor(BlockSetType.OAK));
	public static final RegistryObject<Block> ICHOH_TRAPDOOR = register("block_trapdoor_ichoh", () -> trapDoor(BlockSetType.OAK));
	public static final RegistryObject<Block> SAKURA_PLATE = register("block_plate_sakura", () -> pressurePlate(BlockSetType.OAK));
	public static final RegistryObject<Block> KAEDE_PLATE = register("block_plate_kaede", () -> pressurePlate(BlockSetType.OAK));
	public static final RegistryObject<Block> ICHOH_PLATE = register("block_plate_ichoh", () -> pressurePlate(BlockSetType.OAK));
	public static final RegistryObject<Block> SAKURA_BUTTON = register("block_button_sakura", () -> woodenButton(BlockSetType.OAK));
	public static final RegistryObject<Block> KAEDE_BUTTON = register("block_button_kaede", () -> woodenButton(BlockSetType.OAK));
	public static final RegistryObject<Block> ICHOH_BUTTON = register("block_button_ichoh", () -> woodenButton(BlockSetType.OAK));

	public static final RegistryObject<Block> SAKURA_carpet = register("block_carpet_sakura", () -> carpetLeaf());
	public static final RegistryObject<Block> KAEDE_carpet = register("block_carpet_kaede", () -> carpetLeaf());
	public static final RegistryObject<Block> ICHOH_carpet = register("block_carpet_ichoh", () -> carpetLeaf());
	public static final RegistryObject<Block> OCHIBA_carpet = register("block_carpet_ochiba", () -> carpetLeaf());
	
	public static final RegistryObject<Block> WP_LOG_sakura = register("block_wp_log_sakura", () -> wallPaneStage3());
	public static final RegistryObject<Block> WP_LOG_kaede = register("block_wp_log_kaede", () -> wallPaneStage3());
	public static final RegistryObject<Block> WP_LOG_ichoh = register("block_wp_log_ichoh", () -> wallPaneStage3());

	public static final RegistryObject<Block> WP_PLANK_sakura = register("block_wp_plank_sakura", () -> wallPaneStage4());
	public static final RegistryObject<Block> WP_PLANK_kaede = register("block_wp_plank_kaede", () -> wallPaneStage4());
	public static final RegistryObject<Block> WP_PLANK_ichoh = register("block_wp_plank_ichoh", () -> wallPaneStage4());
	
	
	/* Share variables */
	private static boolean never(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return false;
	}

	private static Boolean neverEntity(BlockState state, BlockGetter worldIn, BlockPos pos, EntityType<?> entity) {
		return (boolean)false;
	}
	
	private static boolean neverSlab(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return (state.getValue(WoodSlab_CM.TYPE) == SlabType.DOUBLE)? true : false;
	}

	private static Boolean neverEntitySlab(BlockState state, BlockGetter worldIn, BlockPos pos, EntityType<?> entity) {
		return (state.getValue(WoodSlab_CM.TYPE) == SlabType.BOTTOM)? (boolean)false : (boolean)true;
	}

	private static Boolean neverEntityStairs(BlockState state, BlockGetter worldIn, BlockPos pos, EntityType<?> entity) {
		return (state.getValue(WoodStairs_CM.HALF) == Half.BOTTOM)? (boolean)false : (boolean)true;
	}

	private static Boolean neverEntityKamoi(BlockState state, BlockGetter worldIn, BlockPos pos, EntityType<?> entity) {
		return (state.getValue(Base_Kamoi.STAGE_1_4) != 4)? (boolean)false : (boolean)true;
	}
	
	private static boolean ocelotOrParrot(BlockState state, BlockGetter worldIn, BlockPos pos, EntityType<?> entity) {
		return entity == EntityType.OCELOT || entity == EntityType.PARROT;
	}
	
	private static Properties leavesRandom() {
		return Block.Properties.of().strength(0.2F).sound(SoundType.GRASS).noOcclusion()
				.isValidSpawn(Wood_Blocks::ocelotOrParrot).isSuffocating(Wood_Blocks::never).isViewBlocking(Wood_Blocks::never).randomTicks();
	}
	
	private static Properties naeRandom() {
		return Block.Properties.of().noCollission().strength(1.0F, 1.0F).sound(SoundType.WOOD).noOcclusion()
				.isValidSpawn(Wood_Blocks::neverEntity).isSuffocating(Wood_Blocks::never).randomTicks();
	}
	
	private static Properties woodState() {
		return BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(1.0F, 3.0F).sound(SoundType.WOOD);
	}
	
	private static Properties kamoiState() {
		return woodState().noOcclusion().isValidSpawn(Wood_Blocks::neverEntityKamoi).isSuffocating(Wood_Blocks::never);
	}
	
	private static Properties woodStateNever() {
		return woodState().noOcclusion().isValidSpawn(Wood_Blocks::neverEntity).isSuffocating(Wood_Blocks::never);
	}
	
	private static WoodPillar_CM logPillar() {
		return new WoodPillar_CM(woodState());
	}
	
	private static Block planks() {
		return new WoodPlanks_CM(woodState());
	}

	private static WoodSlab_CM woodenSlab() {
		return new WoodSlab_CM(woodState().noOcclusion().isValidSpawn(Wood_Blocks::neverEntitySlab).isSuffocating(Wood_Blocks::neverSlab));
	}

	private static WoodStairs_CM woodenStairs() {
		return new WoodStairs_CM(SAKURA_planks.get().defaultBlockState(), woodState().noOcclusion().isValidSpawn(Wood_Blocks::neverEntityStairs).isSuffocating(Wood_Blocks::never));
	}
	
	private static WoodFence_CM woodenFence() {
		return new WoodFence_CM(woodStateNever());
	}

	private static WoodFenceGate_CM woodenFenceGate(WoodType type) {
		return new WoodFenceGate_CM(woodStateNever(), type);
	}

	private static Door_CM doorCM(BlockSetType type) {
		return new Door_CM(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(1.0F, 10.0F).sound(SoundType.WOOD)
				.noOcclusion().isValidSpawn(Wood_Blocks::neverEntity).isSuffocating(Wood_Blocks::never), type);
	}
	
	private static TrapDoor_CM trapDoor(BlockSetType type) {
		return new TrapDoor_CM(woodStateNever(), type);
	}

	private static PressurePlate_CM pressurePlate(BlockSetType type) {
		return new PressurePlate_CM(PressurePlate_CM.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD)
				.strength(0.5F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(Wood_Blocks::neverEntity).isSuffocating(Wood_Blocks::never), type);
	}

	private static WoodButton_CM woodenButton(BlockSetType type) {
		return new WoodButton_CM(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(0.5F).sound(SoundType.WOOD)
				.noCollission().noOcclusion().isValidSpawn(Wood_Blocks::neverEntity).isSuffocating(Wood_Blocks::never), type, 30, true);
	}

	private static Carpet_CM carpetLeaf() {
		return new Carpet_CM(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(1.0F, 1.0F).sound(SoundType.GRASS)
				.noOcclusion().isValidSpawn(Wood_Blocks::neverEntity).isSuffocating(Wood_Blocks::never));
	}
	
	private static WallPane_Stage3 wallPaneStage3() {
		return new WallPane_Stage3(woodStateNever());
	}

	private static WallPane_Stage4 wallPaneStage4() {
		return new WallPane_Stage4(woodStateNever());
	}
	
	
	///* Register *///
	private static RegistryObject<Block> register(String name, Supplier<Block> block) {
		return BLOCKS.register(name, block);
	}
}
