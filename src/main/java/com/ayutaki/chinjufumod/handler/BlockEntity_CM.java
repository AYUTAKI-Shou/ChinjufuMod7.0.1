package com.ayutaki.chinjufumod.handler;

import java.util.function.Supplier;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.registry.Furniture_Blocks;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;
import com.ayutaki.chinjufumod.registry.School_Blocks;
import com.ayutaki.chinjufumod.tileentity.Oven_TileEntity;
import com.ayutaki.chinjufumod.tileentity.ReizouTop_TileEntity;
import com.ayutaki.chinjufumod.tileentity.Reizou_TileEntity;
import com.ayutaki.chinjufumod.tileentity.Stove_TileEntity;
import com.ayutaki.chinjufumod.tileentity.Tansu_TileEntity;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntity_CM {

	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ChinjufuMod.MOD_ID);

	public static final RegistryObject<BlockEntityType<Stove_TileEntity>> C_STOVE = register("cstove",Stove_TileEntity::new,
			() -> new Block[]{ School_Blocks.CSTOVE_top.get() });
	
	public static final RegistryObject<BlockEntityType<Tansu_TileEntity>> TANSU = register("tansu", Tansu_TileEntity::new,
			() -> new Block[]{ Furniture_Blocks.TANSU_OAK.get(), Furniture_Blocks.TANSU_SPRUCE.get(), Furniture_Blocks.TANSU_BIRCH.get(),
					Furniture_Blocks.TANSU_JUNGLE.get(), Furniture_Blocks.TANSU_ACACIA.get(), Furniture_Blocks.TANSU_DOAK.get(),
					Furniture_Blocks.TANSU_SAKURA.get(), Furniture_Blocks.TANSU_KAEDE.get(), Furniture_Blocks.TANSU_ICHOH.get() });

	public static final RegistryObject<BlockEntityType<Oven_TileEntity>> KIT_OVEN = register("kitoven", Oven_TileEntity::new,
			() -> new Block[]{ Kitchen_Blocks.KIT_OVEN.get(), Kitchen_Blocks.KIT_OVEN_B.get() });

	public static final RegistryObject<BlockEntityType<Reizou_TileEntity>> REIZOU = register("reizou", Reizou_TileEntity::new,
			() -> new Block[]{ Kitchen_Blocks.KIT_REIZOU.get() });
	
	public static final RegistryObject<BlockEntityType<ReizouTop_TileEntity>> REIZOU_TOP = register("reizou_top", ReizouTop_TileEntity::new,
			() -> new Block[]{ Kitchen_Blocks.KIT_REIZOU_TOP.get() });
	
	///* Register *///
	private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> register(String name, BlockEntityType.BlockEntitySupplier<T> supplier, Supplier<Block[]> blocks) {
		return BLOCK_ENTITIES.register(name, () -> BlockEntityType.Builder.of(supplier, blocks.get()).build(null));
	}
}
