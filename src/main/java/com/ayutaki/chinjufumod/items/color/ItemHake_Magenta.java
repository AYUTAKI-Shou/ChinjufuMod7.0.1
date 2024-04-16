package com.ayutaki.chinjufumod.items.color;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingWater;
import com.ayutaki.chinjufumod.blocks.base.BaseStage2_FaceWater;
import com.ayutaki.chinjufumod.blocks.chair.BaseSofa;
import com.ayutaki.chinjufumod.blocks.chair.CafeChair;
import com.ayutaki.chinjufumod.blocks.chair.Sofa;
import com.ayutaki.chinjufumod.blocks.chair.Zabuton;
import com.ayutaki.chinjufumod.blocks.chair.Zaisu;
import com.ayutaki.chinjufumod.blocks.furniture.Andon;
import com.ayutaki.chinjufumod.blocks.furniture.Candle;
import com.ayutaki.chinjufumod.blocks.harbor.CTruss;
import com.ayutaki.chinjufumod.blocks.jpblock.Base_Full_JP;
import com.ayutaki.chinjufumod.blocks.jpblock.Base_Slab_JP;
import com.ayutaki.chinjufumod.blocks.jpblock.Full_Kawara;
import com.ayutaki.chinjufumod.blocks.jpblock.Full_Namako;
import com.ayutaki.chinjufumod.blocks.jpblock.Full_Namako_B;
import com.ayutaki.chinjufumod.blocks.jpblock.Full_Plaster;
import com.ayutaki.chinjufumod.blocks.jpblock.Slab_Kawara;
import com.ayutaki.chinjufumod.blocks.jpblock.Slab_Namako;
import com.ayutaki.chinjufumod.blocks.jpblock.Slab_Namako_B;
import com.ayutaki.chinjufumod.blocks.jpblock.Slab_Plaster;
import com.ayutaki.chinjufumod.blocks.jpblock.Stairs_Kawara;
import com.ayutaki.chinjufumod.blocks.jpblock.Stairs_Namako;
import com.ayutaki.chinjufumod.blocks.jpblock.Stairs_Namako_B;
import com.ayutaki.chinjufumod.blocks.jpblock.Stairs_Plaster;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_Kawara;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_Namako;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_NamakoB;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_Plaster;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_Sama;
import com.ayutaki.chinjufumod.blocks.jpdeco.BaseTatami;
import com.ayutaki.chinjufumod.blocks.jpdeco.Futon;
import com.ayutaki.chinjufumod.blocks.jpdeco.Tatami;
import com.ayutaki.chinjufumod.blocks.jpdeco.Tatami_Y;
import com.ayutaki.chinjufumod.blocks.kamoislab.Base_KamoiPlaster;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Acacia;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Birch;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_DarkOak;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Ichoh;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Jungle;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Kaede;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Oak;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Sakura;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Spruce;
import com.ayutaki.chinjufumod.blocks.ranma.Noren;
import com.ayutaki.chinjufumod.blocks.slidedoor.BaseSlidedoor;
import com.ayutaki.chinjufumod.blocks.slidedoor.Fusuma;
import com.ayutaki.chinjufumod.blocks.slidedoor.Fusuma_B;
import com.ayutaki.chinjufumod.blocks.unitblock.Wagasa;
import com.ayutaki.chinjufumod.blocks.wallpane.WallPane_Clay;
import com.ayutaki.chinjufumod.blocks.wallpane.WallPane_Glass;
import com.ayutaki.chinjufumod.blocks.wallpane.WallPane_Namako;
import com.ayutaki.chinjufumod.blocks.wallpane.WallPane_Namako_B;
import com.ayutaki.chinjufumod.blocks.wallpane.WallPane_Plaster;
import com.ayutaki.chinjufumod.blocks.window.Curtain;
import com.ayutaki.chinjufumod.blocks.window.CurtainTall;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Chair_Blocks;
import com.ayutaki.chinjufumod.registry.Furniture_Blocks;
import com.ayutaki.chinjufumod.registry.Harbor_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.JPChair_Blocks;
import com.ayutaki.chinjufumod.registry.JPDeco_Blocks;
import com.ayutaki.chinjufumod.registry.JP_Blocks;
import com.ayutaki.chinjufumod.registry.KamoiPlaster_Blocks;
import com.ayutaki.chinjufumod.registry.Ranma_Blocks;
import com.ayutaki.chinjufumod.registry.Slidedoor_Blocks;
import com.ayutaki.chinjufumod.registry.Unit_Blocks;
import com.ayutaki.chinjufumod.registry.WallPanel_Blocks;
import com.ayutaki.chinjufumod.registry.Window_Blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.ConcretePowderBlock;
import net.minecraft.world.level.block.GlazedTerracottaBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraft.world.level.block.StainedGlassBlock;
import net.minecraft.world.level.block.StainedGlassPaneBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.SlabType;

public class ItemHake_Magenta extends Base_ItemHake {

	public ItemHake_Magenta(Item.Properties properties) {
		super(properties);
	}
	
	public InteractionResult useOn(UseOnContext context) {
		Player playerIn = context.getPlayer();
		Level worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		BlockState state = worldIn.getBlockState(pos);
		Block block = state.getBlock();

		ItemStack stack = context.getItemInHand();
		boolean mode = playerIn.getAbilities().instabuild;
		
		/** other Blocks **/
		if (block == Blocks.WHITE_WOOL || block == Blocks.ORANGE_WOOL || block == Blocks.MAGENTA_WOOL ||
				block == Blocks.LIGHT_BLUE_WOOL || block == Blocks.YELLOW_WOOL || block == Blocks.LIME_WOOL ||
				block == Blocks.PINK_WOOL || block == Blocks.GRAY_WOOL || block == Blocks.LIGHT_GRAY_WOOL ||
				block == Blocks.CYAN_WOOL || block == Blocks.PURPLE_WOOL || block == Blocks.BLUE_WOOL ||
				block == Blocks.BROWN_WOOL || block == Blocks.GREEN_WOOL || block == Blocks.RED_WOOL) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, Blocks.MAGENTA_WOOL.defaultBlockState(), 3);

			stack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } ); //BreakAnimation 無しで筆を返すことも可能

			return InteractionResult.SUCCESS;
		}

		if (block == Blocks.WHITE_CONCRETE || block == Blocks.ORANGE_CONCRETE || block == Blocks.MAGENTA_CONCRETE ||
				block == Blocks.LIGHT_BLUE_CONCRETE || block == Blocks.YELLOW_CONCRETE || block == Blocks.LIME_CONCRETE ||
				block == Blocks.PINK_CONCRETE || block == Blocks.GRAY_CONCRETE || block == Blocks.LIGHT_GRAY_CONCRETE ||
				block == Blocks.CYAN_CONCRETE || block == Blocks.PURPLE_CONCRETE || block == Blocks.BLUE_CONCRETE ||
				block == Blocks.BROWN_CONCRETE || block == Blocks.GREEN_CONCRETE || block == Blocks.RED_CONCRETE) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, Blocks.MAGENTA_CONCRETE.defaultBlockState(), 3);

			stack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}

		if (block == Blocks.WHITE_TERRACOTTA || block == Blocks.ORANGE_TERRACOTTA || block == Blocks.MAGENTA_TERRACOTTA ||
				block == Blocks.LIGHT_BLUE_TERRACOTTA || block == Blocks.YELLOW_TERRACOTTA || block == Blocks.LIME_TERRACOTTA ||
				block == Blocks.PINK_TERRACOTTA || block == Blocks.GRAY_TERRACOTTA || block == Blocks.LIGHT_GRAY_TERRACOTTA ||
				block == Blocks.CYAN_TERRACOTTA || block == Blocks.PURPLE_TERRACOTTA || block == Blocks.BLUE_TERRACOTTA ||
				block == Blocks.BROWN_TERRACOTTA || block == Blocks.GREEN_TERRACOTTA || block == Blocks.RED_TERRACOTTA ||
				block == Blocks.TERRACOTTA) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, Blocks.MAGENTA_TERRACOTTA.defaultBlockState(), 3);

			stack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}

		if (block instanceof ConcretePowderBlock && block != Blocks.MAGENTA_CONCRETE_POWDER) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, Blocks.MAGENTA_CONCRETE_POWDER.defaultBlockState(), 3);

			stack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}

		if ((block instanceof StainedGlassBlock && block != Blocks.MAGENTA_STAINED_GLASS) || block == Blocks.GLASS) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, Blocks.MAGENTA_STAINED_GLASS.defaultBlockState(), 3);

			stack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}

		/** テラコッタ **/
		if (block instanceof GlazedTerracottaBlock && block != Blocks.MAGENTA_GLAZED_TERRACOTTA) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, Blocks.MAGENTA_GLAZED_TERRACOTTA.defaultBlockState()
					.setValue(GlazedTerracottaBlock.FACING, state.getValue(GlazedTerracottaBlock.FACING)), 3);

			stack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}

		/** 板ガラス **/
		if ((block instanceof StainedGlassPaneBlock && block != Blocks.MAGENTA_STAINED_GLASS_PANE) || block == Blocks.GLASS_PANE) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, Blocks.MAGENTA_STAINED_GLASS_PANE.defaultBlockState()
					.setValue(IronBarsBlock.NORTH, state.getValue(IronBarsBlock.NORTH))
					.setValue(IronBarsBlock.EAST, state.getValue(IronBarsBlock.EAST))
					.setValue(IronBarsBlock.SOUTH, state.getValue(IronBarsBlock.SOUTH))
					.setValue(IronBarsBlock.WEST, state.getValue(IronBarsBlock.WEST))
					.setValue(IronBarsBlock.WATERLOGGED, state.getValue(IronBarsBlock.WATERLOGGED)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}

		/**カーペット **/
		if (block instanceof CarpetBlock && block != Blocks.MAGENTA_CARPET) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, Blocks.MAGENTA_CARPET.defaultBlockState(), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}


		/** 瓦・漆喰・なまこ壁 **/
		if (block instanceof Full_Kawara && block != JP_Blocks.KAWARA_magenta.get()) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, JP_Blocks.KAWARA_magenta.get().defaultBlockState()
					.setValue(Base_Full_JP.CRACK, state.getValue(Base_Full_JP.CRACK)), 3);

			stack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}

		if (block instanceof Full_Plaster && block != JP_Blocks.SHIKKUI_magenta.get() && block != JP_Blocks.DIRTWALL.get()) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, JP_Blocks.SHIKKUI_magenta.get().defaultBlockState()
					.setValue(Base_Full_JP.CRACK, state.getValue(Base_Full_JP.CRACK)), 3);

			stack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}

		if (block instanceof Full_Namako && block != JP_Blocks.NAMAKO_magenta.get()) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, JP_Blocks.NAMAKO_magenta.get().defaultBlockState()
					.setValue(Base_Full_JP.CRACK, state.getValue(Base_Full_JP.CRACK)), 3);

			stack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}

		if (block instanceof Full_Namako_B && block != JP_Blocks.NAMAKOB_magenta.get()) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, JP_Blocks.NAMAKOB_magenta.get().defaultBlockState()
					.setValue(Base_Full_JP.CRACK, state.getValue(Base_Full_JP.CRACK)), 3);

			stack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}

		/** 階段 **/
		if (block instanceof Stairs_Kawara && block != JP_Blocks.KAWARA_ST_magenta.get()) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, JP_Blocks.KAWARA_ST_magenta.get().defaultBlockState()
					.setValue(StairBlock.FACING, state.getValue(StairBlock.FACING))
					.setValue(StairBlock.HALF, state.getValue(StairBlock.HALF))
					.setValue(StairBlock.SHAPE, state.getValue(StairBlock.SHAPE))
					.setValue(StairBlock.WATERLOGGED, state.getValue(StairBlock.WATERLOGGED)), 3);

			stack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}

		if (block instanceof Stairs_Plaster && block != JP_Blocks.SHIKKUI_ST_magenta.get() && block != JP_Blocks.DIRTWALL_stairs.get()) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, JP_Blocks.SHIKKUI_ST_magenta.get().defaultBlockState()
					.setValue(StairBlock.FACING, state.getValue(StairBlock.FACING))
					.setValue(StairBlock.HALF, state.getValue(StairBlock.HALF))
					.setValue(StairBlock.SHAPE, state.getValue(StairBlock.SHAPE))
					.setValue(StairBlock.WATERLOGGED, state.getValue(StairBlock.WATERLOGGED)), 3);

			stack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}

		if (block instanceof Stairs_Namako && block != JP_Blocks.NAMAKO_ST_magenta.get()) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, JP_Blocks.NAMAKO_ST_magenta.get().defaultBlockState()
					.setValue(StairBlock.FACING, state.getValue(StairBlock.FACING))
					.setValue(StairBlock.HALF, state.getValue(StairBlock.HALF))
					.setValue(StairBlock.SHAPE, state.getValue(StairBlock.SHAPE))
					.setValue(StairBlock.WATERLOGGED, state.getValue(StairBlock.WATERLOGGED)), 3);

			stack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}

		if (block instanceof Stairs_Namako_B && block != JP_Blocks.NAMAKOB_ST_magenta.get()) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, JP_Blocks.NAMAKOB_ST_magenta.get().defaultBlockState()
					.setValue(StairBlock.FACING, state.getValue(StairBlock.FACING))
					.setValue(StairBlock.HALF, state.getValue(StairBlock.HALF))
					.setValue(StairBlock.SHAPE, state.getValue(StairBlock.SHAPE))
					.setValue(StairBlock.WATERLOGGED, state.getValue(StairBlock.WATERLOGGED)), 3);

			stack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}

		/** ハーフブロック **/
		if (block instanceof Slab_Kawara && block != JP_Blocks.KAWARA_SH_magenta.get()) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, JP_Blocks.KAWARA_SH_magenta.get().defaultBlockState()
					.setValue(Base_Slab_JP.TYPE, state.getValue(Base_Slab_JP.TYPE))
					.setValue(Base_Slab_JP.CRACK, state.getValue(Base_Slab_JP.CRACK))
					.setValue(Base_Slab_JP.WATERLOGGED, state.getValue(Base_Slab_JP.WATERLOGGED)), 3);

			if (state.getValue(Base_Slab_JP.TYPE) == SlabType.DOUBLE) {
				stack.hurtAndBreak(2, playerIn, user -> {
					if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
						playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
					user.broadcastBreakEvent(context.getHand()); } );
			}

			if (state.getValue(Base_Slab_JP.TYPE) != SlabType.DOUBLE) {
				stack.hurtAndBreak(1, playerIn, user -> {
					if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
						playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
					user.broadcastBreakEvent(context.getHand()); } );
			}
			return InteractionResult.SUCCESS;
		}

		if (block instanceof Slab_Plaster && block != JP_Blocks.SHIKKUI_SH_magenta.get() && block != JP_Blocks.DIRTWALL_SH.get()) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, JP_Blocks.SHIKKUI_SH_magenta.get().defaultBlockState()
					.setValue(Base_Slab_JP.TYPE, state.getValue(Base_Slab_JP.TYPE))
					.setValue(Base_Slab_JP.CRACK, state.getValue(Base_Slab_JP.CRACK))
					.setValue(Base_Slab_JP.WATERLOGGED, state.getValue(Base_Slab_JP.WATERLOGGED)), 3);

			if (state.getValue(Base_Slab_JP.TYPE) == SlabType.DOUBLE) {
				stack.hurtAndBreak(2, playerIn, user -> {
					if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
						playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
					user.broadcastBreakEvent(context.getHand()); } );
			}

			if (state.getValue(Base_Slab_JP.TYPE) != SlabType.DOUBLE) {
				stack.hurtAndBreak(1, playerIn, user -> {
					if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
						playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
					user.broadcastBreakEvent(context.getHand()); } );
			}
			return InteractionResult.SUCCESS;
		}

		if (block instanceof Slab_Namako && block != JP_Blocks.NAMAKO_SH_magenta.get()) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, JP_Blocks.NAMAKO_SH_magenta.get().defaultBlockState()
					.setValue(Base_Slab_JP.TYPE, state.getValue(Base_Slab_JP.TYPE))
					.setValue(Base_Slab_JP.CRACK, state.getValue(Base_Slab_JP.CRACK))
					.setValue(Base_Slab_JP.WATERLOGGED, state.getValue(Base_Slab_JP.WATERLOGGED)), 3);

			if (state.getValue(Base_Slab_JP.TYPE) == SlabType.DOUBLE) {
				stack.hurtAndBreak(2, playerIn, user -> {
					if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
						playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
					user.broadcastBreakEvent(context.getHand()); } );
			}

			if (state.getValue(Base_Slab_JP.TYPE) != SlabType.DOUBLE) {
				stack.hurtAndBreak(1, playerIn, user -> {
					if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
						playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
					user.broadcastBreakEvent(context.getHand()); } );
			}
			return InteractionResult.SUCCESS;
		}

		if (block instanceof Slab_Namako_B && block != JP_Blocks.NAMAKOB_SH_magenta.get()) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, JP_Blocks.NAMAKOB_SH_magenta.get().defaultBlockState()
					.setValue(Base_Slab_JP.TYPE, state.getValue(Base_Slab_JP.TYPE))
					.setValue(Base_Slab_JP.CRACK, state.getValue(Base_Slab_JP.CRACK))
					.setValue(Base_Slab_JP.WATERLOGGED, state.getValue(Base_Slab_JP.WATERLOGGED)), 3);

			if (state.getValue(Base_Slab_JP.TYPE) == SlabType.DOUBLE) {
				stack.hurtAndBreak(2, playerIn, user -> {
					if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
						playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
					user.broadcastBreakEvent(context.getHand()); } );
			}

			if (state.getValue(Base_Slab_JP.TYPE) != SlabType.DOUBLE) {
				stack.hurtAndBreak(1, playerIn, user -> {
					if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
						playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
					user.broadcastBreakEvent(context.getHand()); } );
			}
			return InteractionResult.SUCCESS;
		}

		///////////////////////
		/** トラス **/
		if (block instanceof CTruss && block != Harbor_Blocks.TRUSS_magenta.get()) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, Harbor_Blocks.TRUSS_magenta.get().defaultBlockState()
					.setValue(BaseFacingWater.H_FACING, state.getValue(BaseFacingWater.H_FACING))
					.setValue(BaseFacingWater.WATERLOGGED, state.getValue(BaseFacingWater.WATERLOGGED)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}

		/** 椅子・座布団・キャンドル **/
		if (block instanceof CafeChair && block != Chair_Blocks.CAFECHAIR_magenta.get()) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, Chair_Blocks.CAFECHAIR_magenta.get().defaultBlockState(), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}

		if (block instanceof Zabuton && block != JPChair_Blocks.ZABUTON_magenta.get() && block != JPChair_Blocks.WARAZABUTON.get()) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, JPChair_Blocks.ZABUTON_magenta.get().defaultBlockState()
					.setValue(Zabuton.DOWN, state.getValue(Zabuton.DOWN))
					.setValue(Zabuton.WATERLOGGED, state.getValue(Zabuton.WATERLOGGED)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}

		if (block instanceof Candle && block != Furniture_Blocks.CANDLE_magenta.get()) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, Furniture_Blocks.CANDLE_magenta.get().defaultBlockState()
					.setValue(Candle.LIT, state.getValue(Candle.LIT))
					.setValue(Candle.DOWN, state.getValue(Candle.DOWN))
					.setValue(Candle.WATERLOGGED, state.getValue(Candle.WATERLOGGED)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}

		/** 行灯 **/
		if (block instanceof Andon && block != JPDeco_Blocks.ANDON_magenta.get()) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, JPDeco_Blocks.ANDON_magenta.get().defaultBlockState()
					.setValue(Andon.LIT, state.getValue(Andon.LIT))
					.setValue(Andon.H_FACING, state.getValue(Andon.H_FACING))
					.setValue(Andon.WATERLOGGED, state.getValue(Andon.WATERLOGGED)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}

		/** ソファ **/
		if (block instanceof Sofa && block != Chair_Blocks.SOFA_magenta.get()) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, Chair_Blocks.SOFA_magenta.get().defaultBlockState()
					.setValue(BaseSofa.TYPE, state.getValue(BaseSofa.TYPE))
					.setValue(BaseSofa.H_FACING, state.getValue(BaseSofa.H_FACING))
					.setValue(BaseSofa.WATERLOGGED, state.getValue(BaseSofa.WATERLOGGED)), 3);

			stack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}

		/** 座椅子 **/
		if (block instanceof Zaisu && block != JPChair_Blocks.ZAISU_magenta.get()) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, JPChair_Blocks.ZAISU_magenta.get().defaultBlockState()
					.setValue(BaseFacingWater.H_FACING, state.getValue(BaseFacingWater.H_FACING))
					.setValue(BaseFacingWater.WATERLOGGED, state.getValue(BaseFacingWater.WATERLOGGED)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}

		/** のれん **/
		if (block instanceof Noren && block != Ranma_Blocks.NOREN_magenta.get()) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, Ranma_Blocks.NOREN_magenta.get().defaultBlockState()
					.setValue(Noren.TYPE, state.getValue(Noren.TYPE))
					.setValue(Noren.H_FACING, state.getValue(Noren.H_FACING))
					.setValue(Noren.WATERLOGGED, state.getValue(Noren.WATERLOGGED)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}

		/** 布団 **/
		if (block instanceof Futon && block != JPDeco_Blocks.FUTON_magenta.get()) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, JPDeco_Blocks.FUTON_magenta.get().defaultBlockState()
					.setValue(BaseStage2_FaceWater.STAGE_1_2, state.getValue(BaseStage2_FaceWater.STAGE_1_2))
					.setValue(BaseStage2_FaceWater.H_FACING, state.getValue(BaseStage2_FaceWater.H_FACING))
					.setValue(BaseStage2_FaceWater.WATERLOGGED, state.getValue(BaseStage2_FaceWater.WATERLOGGED)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}

		/** 畳 **/
		if (block instanceof Tatami && block != JPDeco_Blocks.TATAMI_H_magenta.get() && block != JPDeco_Blocks.TATAMI_H.get()) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, JPDeco_Blocks.TATAMI_H_magenta.get().defaultBlockState()
					.setValue(BaseTatami.TYPE, state.getValue(BaseTatami.TYPE))
					.setValue(BaseTatami.H_FACING, state.getValue(BaseTatami.H_FACING))
					.setValue(BaseTatami.WATERLOGGED, state.getValue(BaseTatami.WATERLOGGED)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}

		if (block instanceof Tatami_Y && block != JPDeco_Blocks.TATAMI_HY_magenta.get() && block != JPDeco_Blocks.TATAMI_HY.get()) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, JPDeco_Blocks.TATAMI_HY_magenta.get().defaultBlockState()
					.setValue(BaseTatami.TYPE, state.getValue(BaseTatami.TYPE))
					.setValue(BaseTatami.H_FACING, state.getValue(BaseTatami.H_FACING))
					.setValue(BaseTatami.WATERLOGGED, state.getValue(BaseTatami.WATERLOGGED)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}

		/** 傘 **/
		if (block instanceof Wagasa && block != Unit_Blocks.KASA_magenta.get()) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, Unit_Blocks.KASA_magenta.get().defaultBlockState()
					.setValue(Wagasa.NORTH, state.getValue(Wagasa.NORTH))
					.setValue(Wagasa.EAST, state.getValue(Wagasa.EAST))
					.setValue(Wagasa.SOUTH, state.getValue(Wagasa.SOUTH))
					.setValue(Wagasa.WEST, state.getValue(Wagasa.WEST))
					.setValue(Wagasa.WHICH, Boolean.valueOf(false))
					.setValue(Wagasa.WATERLOGGED, state.getValue(Wagasa.WATERLOGGED)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}


		///////////////////////
		/** ふすま **/
		if (block instanceof Fusuma && block != Slidedoor_Blocks.FUSUMA_magenta.get()) {

			CMEvents.soundPaint(worldIn, playerIn, pos);

			if (state.getValue(BaseSlidedoor.HALF) == DoubleBlockHalf.LOWER) {
				worldIn.setBlock(pos, Slidedoor_Blocks.FUSUMA_magenta.get().defaultBlockState()
						.setValue(BaseSlidedoor.H_FACING, state.getValue(BaseSlidedoor.H_FACING))
						.setValue(BaseSlidedoor.OPEN, state.getValue(BaseSlidedoor.OPEN))
						.setValue(BaseSlidedoor.HINGE, state.getValue(BaseSlidedoor.HINGE))
						.setValue(BaseSlidedoor.POWERED, state.getValue(BaseSlidedoor.POWERED))
						.setValue(BaseSlidedoor.HALF, DoubleBlockHalf.LOWER)
						.setValue(BaseSlidedoor.WATERLOGGED, state.getValue(BaseSlidedoor.WATERLOGGED)), 3);
				worldIn.setBlock(pos.above(), Slidedoor_Blocks.FUSUMA_magenta.get().defaultBlockState()
						.setValue(BaseSlidedoor.H_FACING, state.getValue(BaseSlidedoor.H_FACING))
						.setValue(BaseSlidedoor.OPEN, state.getValue(BaseSlidedoor.OPEN))
						.setValue(BaseSlidedoor.HINGE, state.getValue(BaseSlidedoor.HINGE))
						.setValue(BaseSlidedoor.POWERED, state.getValue(BaseSlidedoor.POWERED))
						.setValue(BaseSlidedoor.HALF, DoubleBlockHalf.UPPER)
						.setValue(BaseSlidedoor.WATERLOGGED, state.getValue(BaseSlidedoor.WATERLOGGED)), 3); }

			if (state.getValue(BaseSlidedoor.HALF) == DoubleBlockHalf.UPPER) {
				worldIn.setBlock(pos, Slidedoor_Blocks.FUSUMA_magenta.get().defaultBlockState()
						.setValue(BaseSlidedoor.H_FACING, state.getValue(BaseSlidedoor.H_FACING))
						.setValue(BaseSlidedoor.OPEN, state.getValue(BaseSlidedoor.OPEN))
						.setValue(BaseSlidedoor.HINGE, state.getValue(BaseSlidedoor.HINGE))
						.setValue(BaseSlidedoor.POWERED, state.getValue(BaseSlidedoor.POWERED))
						.setValue(BaseSlidedoor.HALF, DoubleBlockHalf.UPPER)
						.setValue(BaseSlidedoor.WATERLOGGED, state.getValue(BaseSlidedoor.WATERLOGGED)), 3);
				worldIn.setBlock(pos.below(), Slidedoor_Blocks.FUSUMA_magenta.get().defaultBlockState()
						.setValue(BaseSlidedoor.H_FACING, state.getValue(BaseSlidedoor.H_FACING))
						.setValue(BaseSlidedoor.OPEN, state.getValue(BaseSlidedoor.OPEN))
						.setValue(BaseSlidedoor.HINGE, state.getValue(BaseSlidedoor.HINGE))
						.setValue(BaseSlidedoor.POWERED, state.getValue(BaseSlidedoor.POWERED))
						.setValue(BaseSlidedoor.HALF, DoubleBlockHalf.LOWER)
						.setValue(BaseSlidedoor.WATERLOGGED, state.getValue(BaseSlidedoor.WATERLOGGED)), 3); }

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}

		if (block instanceof Fusuma_B && block != Slidedoor_Blocks.FUSUMAB_magenta.get()) {

			CMEvents.soundPaint(worldIn, playerIn, pos);

			if (state.getValue(BaseSlidedoor.HALF) == DoubleBlockHalf.LOWER) {
				worldIn.setBlock(pos, Slidedoor_Blocks.FUSUMAB_magenta.get().defaultBlockState()
						.setValue(BaseSlidedoor.H_FACING, state.getValue(BaseSlidedoor.H_FACING))
						.setValue(BaseSlidedoor.OPEN, state.getValue(BaseSlidedoor.OPEN))
						.setValue(BaseSlidedoor.HINGE, state.getValue(BaseSlidedoor.HINGE))
						.setValue(BaseSlidedoor.POWERED, state.getValue(BaseSlidedoor.POWERED))
						.setValue(BaseSlidedoor.HALF, DoubleBlockHalf.LOWER)
						.setValue(BaseSlidedoor.WATERLOGGED, state.getValue(BaseSlidedoor.WATERLOGGED)), 3);
				worldIn.setBlock(pos.above(), Slidedoor_Blocks.FUSUMAB_magenta.get().defaultBlockState()
						.setValue(BaseSlidedoor.H_FACING, state.getValue(BaseSlidedoor.H_FACING))
						.setValue(BaseSlidedoor.OPEN, state.getValue(BaseSlidedoor.OPEN))
						.setValue(BaseSlidedoor.HINGE, state.getValue(BaseSlidedoor.HINGE))
						.setValue(BaseSlidedoor.POWERED, state.getValue(BaseSlidedoor.POWERED))
						.setValue(BaseSlidedoor.HALF, DoubleBlockHalf.UPPER)
						.setValue(BaseSlidedoor.WATERLOGGED, state.getValue(BaseSlidedoor.WATERLOGGED)), 3); }

			if (state.getValue(BaseSlidedoor.HALF) == DoubleBlockHalf.UPPER) {
				worldIn.setBlock(pos, Slidedoor_Blocks.FUSUMAB_magenta.get().defaultBlockState()
						.setValue(BaseSlidedoor.H_FACING, state.getValue(BaseSlidedoor.H_FACING))
						.setValue(BaseSlidedoor.OPEN, state.getValue(BaseSlidedoor.OPEN))
						.setValue(BaseSlidedoor.HINGE, state.getValue(BaseSlidedoor.HINGE))
						.setValue(BaseSlidedoor.POWERED, state.getValue(BaseSlidedoor.POWERED))
						.setValue(BaseSlidedoor.HALF, DoubleBlockHalf.UPPER)
						.setValue(BaseSlidedoor.WATERLOGGED, state.getValue(BaseSlidedoor.WATERLOGGED)), 3);
				worldIn.setBlock(pos.below(), Slidedoor_Blocks.FUSUMAB_magenta.get().defaultBlockState()
						.setValue(BaseSlidedoor.H_FACING, state.getValue(BaseSlidedoor.H_FACING))
						.setValue(BaseSlidedoor.OPEN, state.getValue(BaseSlidedoor.OPEN))
						.setValue(BaseSlidedoor.HINGE, state.getValue(BaseSlidedoor.HINGE))
						.setValue(BaseSlidedoor.POWERED, state.getValue(BaseSlidedoor.POWERED))
						.setValue(BaseSlidedoor.HALF, DoubleBlockHalf.LOWER)
						.setValue(BaseSlidedoor.WATERLOGGED, state.getValue(BaseSlidedoor.WATERLOGGED)), 3); }

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}

		///////////////////////
		/** 鴨居 **/
		if (block instanceof KamoiPlaster_Oak && block != KamoiPlaster_Blocks.KAMOI_magenta_oak.get()) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_magenta_oak.get().defaultBlockState()
					.setValue(Base_KamoiPlaster.H_FACING, state.getValue(Base_KamoiPlaster.H_FACING))
					.setValue(Base_KamoiPlaster.STAGE_1_4, state.getValue(Base_KamoiPlaster.STAGE_1_4)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}

		if (block instanceof KamoiPlaster_Spruce && block != KamoiPlaster_Blocks.KAMOI_magenta_spru.get()) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_magenta_spru.get().defaultBlockState()
					.setValue(Base_KamoiPlaster.H_FACING, state.getValue(Base_KamoiPlaster.H_FACING))
					.setValue(Base_KamoiPlaster.STAGE_1_4, state.getValue(Base_KamoiPlaster.STAGE_1_4)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}

		if (block instanceof KamoiPlaster_Birch && block != KamoiPlaster_Blocks.KAMOI_magenta_bir.get()) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_magenta_bir.get().defaultBlockState()
					.setValue(Base_KamoiPlaster.H_FACING, state.getValue(Base_KamoiPlaster.H_FACING))
					.setValue(Base_KamoiPlaster.STAGE_1_4, state.getValue(Base_KamoiPlaster.STAGE_1_4)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}

		if (block instanceof KamoiPlaster_Jungle && block != KamoiPlaster_Blocks.KAMOI_magenta_jun.get()) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_magenta_jun.get().defaultBlockState()
					.setValue(Base_KamoiPlaster.H_FACING, state.getValue(Base_KamoiPlaster.H_FACING))
					.setValue(Base_KamoiPlaster.STAGE_1_4, state.getValue(Base_KamoiPlaster.STAGE_1_4)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}

		if (block instanceof KamoiPlaster_Acacia && block != KamoiPlaster_Blocks.KAMOI_magenta_aca.get()) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_magenta_aca.get().defaultBlockState()
					.setValue(Base_KamoiPlaster.H_FACING, state.getValue(Base_KamoiPlaster.H_FACING))
					.setValue(Base_KamoiPlaster.STAGE_1_4, state.getValue(Base_KamoiPlaster.STAGE_1_4)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}

		if (block instanceof KamoiPlaster_DarkOak && block != KamoiPlaster_Blocks.KAMOI_magenta_doak.get()) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_magenta_doak.get().defaultBlockState()
					.setValue(Base_KamoiPlaster.H_FACING, state.getValue(Base_KamoiPlaster.H_FACING))
					.setValue(Base_KamoiPlaster.STAGE_1_4, state.getValue(Base_KamoiPlaster.STAGE_1_4)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}

		if (block instanceof KamoiPlaster_Sakura && block != KamoiPlaster_Blocks.KAMOI_magenta_sakura.get()) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_magenta_sakura.get().defaultBlockState()
					.setValue(Base_KamoiPlaster.H_FACING, state.getValue(Base_KamoiPlaster.H_FACING))
					.setValue(Base_KamoiPlaster.STAGE_1_4, state.getValue(Base_KamoiPlaster.STAGE_1_4)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}

		if (block instanceof KamoiPlaster_Kaede && block != KamoiPlaster_Blocks.KAMOI_magenta_kaede.get()) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_magenta_kaede.get().defaultBlockState()
					.setValue(Base_KamoiPlaster.H_FACING, state.getValue(Base_KamoiPlaster.H_FACING))
					.setValue(Base_KamoiPlaster.STAGE_1_4, state.getValue(Base_KamoiPlaster.STAGE_1_4)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}

		if (block instanceof KamoiPlaster_Ichoh && block != KamoiPlaster_Blocks.KAMOI_magenta_ichoh.get()) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, KamoiPlaster_Blocks.KAMOI_magenta_ichoh.get().defaultBlockState()
					.setValue(Base_KamoiPlaster.H_FACING, state.getValue(Base_KamoiPlaster.H_FACING))
					.setValue(Base_KamoiPlaster.STAGE_1_4, state.getValue(Base_KamoiPlaster.STAGE_1_4)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}


		///////////////////////
		/** 粘土 **/
		if (block instanceof WallPane_Clay && block != WallPanel_Blocks.WP_CLAY_magenta.get()) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, WallPanel_Blocks.WP_CLAY_magenta.get().defaultBlockState()
					.setValue(BaseFacingWater.H_FACING, state.getValue(BaseFacingWater.H_FACING))
					.setValue(BaseFacingWater.WATERLOGGED, state.getValue(BaseFacingWater.WATERLOGGED)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}

		/** ガラス **/
		if (block instanceof WallPane_Glass && block != WallPanel_Blocks.WP_GLASS_magenta.get()) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, WallPanel_Blocks.WP_GLASS_magenta.get().defaultBlockState()
					.setValue(BaseFacingWater.H_FACING, state.getValue(BaseFacingWater.H_FACING))
					.setValue(BaseFacingWater.WATERLOGGED, state.getValue(BaseFacingWater.WATERLOGGED)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}

		/** しっくい **/
		if (block instanceof WallPane_Plaster && block != WallPanel_Blocks.WP_PLASTER_magenta.get()) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, WallPanel_Blocks.WP_PLASTER_magenta.get().defaultBlockState()
					.setValue(BaseStage2_FaceWater.H_FACING, state.getValue(BaseStage2_FaceWater.H_FACING))
					.setValue(BaseStage2_FaceWater.STAGE_1_2, state.getValue(BaseStage2_FaceWater.STAGE_1_2))
					.setValue(BaseStage2_FaceWater.WATERLOGGED, state.getValue(BaseStage2_FaceWater.WATERLOGGED)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}

		/** なまこ **/
		if (block instanceof WallPane_Namako && block != WallPanel_Blocks.WP_NAMAKO_magenta.get()) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, WallPanel_Blocks.WP_NAMAKO_magenta.get().defaultBlockState()
					.setValue(BaseStage2_FaceWater.H_FACING, state.getValue(BaseStage2_FaceWater.H_FACING))
					.setValue(BaseStage2_FaceWater.STAGE_1_2, state.getValue(BaseStage2_FaceWater.STAGE_1_2))
					.setValue(BaseStage2_FaceWater.WATERLOGGED, state.getValue(BaseStage2_FaceWater.WATERLOGGED)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}

		if (block instanceof WallPane_Namako_B && block != WallPanel_Blocks.WP_NAMAKOB_magenta.get()) {

			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, WallPanel_Blocks.WP_NAMAKOB_magenta.get().defaultBlockState()
					.setValue(BaseStage2_FaceWater.H_FACING, state.getValue(BaseStage2_FaceWater.H_FACING))
					.setValue(BaseStage2_FaceWater.STAGE_1_2, state.getValue(BaseStage2_FaceWater.STAGE_1_2))
					.setValue(BaseStage2_FaceWater.WATERLOGGED, state.getValue(BaseStage2_FaceWater.WATERLOGGED)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}

		///6.1.2////////////////////
		if (block instanceof Wall_Plaster && block != JP_Blocks.SHIKKUI_WALL_magenta.get() && block != JP_Blocks.DIRTWALL_WALL.get()) {
			
			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, JP_Blocks.SHIKKUI_WALL_magenta.get().defaultBlockState()
					.setValue(Wall_Plaster.NORTH, state.getValue(Wall_Plaster.NORTH))
					.setValue(Wall_Plaster.SOUTH, state.getValue(Wall_Plaster.SOUTH))
					.setValue(Wall_Plaster.EAST, state.getValue(Wall_Plaster.EAST))
					.setValue(Wall_Plaster.WEST, state.getValue(Wall_Plaster.WEST))
					.setValue(Wall_Plaster.CRACK, state.getValue(Wall_Plaster.CRACK))
					.setValue(Wall_Plaster.WATERLOGGED, state.getValue(Wall_Plaster.WATERLOGGED)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}
		
		if (block instanceof Wall_Sama && block != JP_Blocks.SHIKKUI_SAMA_magenta.get() && block != JP_Blocks.DIRTWALL_SAMA.get()) {
			
			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, JP_Blocks.SHIKKUI_SAMA_magenta.get().defaultBlockState()
					.setValue(Wall_Sama.H_FACING, state.getValue(Wall_Sama.H_FACING))
					.setValue(Wall_Sama.STAGE_1_4, state.getValue(Wall_Sama.STAGE_1_4))
					.setValue(Wall_Sama.WATERLOGGED, state.getValue(Wall_Sama.WATERLOGGED)), 3);
			
			if (state.getValue(Wall_Sama.STAGE_1_4) <= 2) {
				stack.hurtAndBreak(1, playerIn, user -> {
					if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
						playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
					user.broadcastBreakEvent(context.getHand()); } );
			}
			
			if (state.getValue(Wall_Sama.STAGE_1_4) >= 3) {
				stack.hurtAndBreak(2, playerIn, user -> {
					if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
						playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
					user.broadcastBreakEvent(context.getHand()); } );
			}

			return InteractionResult.SUCCESS;
		}

		if (block instanceof Wall_Kawara && block != JP_Blocks.KAWARA_WALL_magenta.get()) {
			
			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, JP_Blocks.KAWARA_WALL_magenta.get().defaultBlockState()
					.setValue(Wall_Kawara.NORTH, state.getValue(Wall_Kawara.NORTH))
					.setValue(Wall_Kawara.SOUTH, state.getValue(Wall_Kawara.SOUTH))
					.setValue(Wall_Kawara.EAST, state.getValue(Wall_Kawara.EAST))
					.setValue(Wall_Kawara.WEST, state.getValue(Wall_Kawara.WEST))
					.setValue(Wall_Kawara.WATERLOGGED, state.getValue(Wall_Kawara.WATERLOGGED)), 3);
			
			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}
		
		if (block instanceof Wall_Namako && block != JP_Blocks.NAMAKO_WALL_magenta.get()) {
			
			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, JP_Blocks.NAMAKO_WALL_magenta.get().defaultBlockState()
					.setValue(Wall_Namako.NORTH, state.getValue(Wall_Namako.NORTH))
					.setValue(Wall_Namako.SOUTH, state.getValue(Wall_Namako.SOUTH))
					.setValue(Wall_Namako.EAST, state.getValue(Wall_Namako.EAST))
					.setValue(Wall_Namako.WEST, state.getValue(Wall_Namako.WEST))
					.setValue(Wall_Namako.CRACK, state.getValue(Wall_Namako.CRACK))
					.setValue(Wall_Namako.WATERLOGGED, state.getValue(Wall_Namako.WATERLOGGED)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}
		
		if (block instanceof Wall_NamakoB && block != JP_Blocks.NAMAKOB_WALL_magenta.get()) {
			
			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, JP_Blocks.NAMAKOB_WALL_magenta.get().defaultBlockState()
					.setValue(Wall_NamakoB.NORTH, state.getValue(Wall_NamakoB.NORTH))
					.setValue(Wall_NamakoB.SOUTH, state.getValue(Wall_NamakoB.SOUTH))
					.setValue(Wall_NamakoB.EAST, state.getValue(Wall_NamakoB.EAST))
					.setValue(Wall_NamakoB.WEST, state.getValue(Wall_NamakoB.WEST))
					.setValue(Wall_NamakoB.CRACK, state.getValue(Wall_NamakoB.CRACK))
					.setValue(Wall_NamakoB.WATERLOGGED, state.getValue(Wall_NamakoB.WATERLOGGED)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}
		
		///6.2.4////////////////////
		if (block instanceof Curtain && block != Window_Blocks.CURTAIN_magenta.get()) {
			
			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlock(pos, Window_Blocks.CURTAIN_magenta.get().defaultBlockState()
					.setValue(Curtain.H_FACING, state.getValue(Wall_Sama.H_FACING))
					.setValue(Curtain.STAGE_1_4, state.getValue(Wall_Sama.STAGE_1_4))
					.setValue(Curtain.WATERLOGGED, state.getValue(Wall_Sama.WATERLOGGED)), 3);

			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}
		
		if (block instanceof CurtainTall && block != Window_Blocks.CURTAINTALL_magenta.get()) {
			
			CMEvents.soundPaint(worldIn, playerIn, pos);
			
			if (state.getValue(CurtainTall.HALF) == DoubleBlockHalf.LOWER) {
				worldIn.setBlock(pos, Window_Blocks.CURTAINTALL_magenta.get().defaultBlockState()
						.setValue(CurtainTall.H_FACING, state.getValue(CurtainTall.H_FACING))
						.setValue(CurtainTall.OPEN, state.getValue(CurtainTall.OPEN))
						.setValue(CurtainTall.HINGE, state.getValue(CurtainTall.HINGE))
						.setValue(CurtainTall.HALF, DoubleBlockHalf.LOWER)
						.setValue(CurtainTall.WATERLOGGED, state.getValue(CurtainTall.WATERLOGGED)), 3);
				worldIn.setBlock(pos.above(), Window_Blocks.CURTAINTALL_magenta.get().defaultBlockState()
						.setValue(CurtainTall.H_FACING, state.getValue(CurtainTall.H_FACING))
						.setValue(CurtainTall.OPEN, state.getValue(CurtainTall.OPEN))
						.setValue(CurtainTall.HINGE, state.getValue(CurtainTall.HINGE))
						.setValue(CurtainTall.HALF, DoubleBlockHalf.UPPER)
						.setValue(CurtainTall.WATERLOGGED, state.getValue(CurtainTall.WATERLOGGED)), 3); }
			
			if (state.getValue(CurtainTall.HALF) == DoubleBlockHalf.UPPER) {
				worldIn.setBlock(pos, Window_Blocks.CURTAINTALL_magenta.get().defaultBlockState()
						.setValue(CurtainTall.H_FACING, state.getValue(CurtainTall.H_FACING))
						.setValue(CurtainTall.OPEN, state.getValue(CurtainTall.OPEN))
						.setValue(CurtainTall.HINGE, state.getValue(CurtainTall.HINGE))
						.setValue(CurtainTall.HALF, DoubleBlockHalf.UPPER)
						.setValue(CurtainTall.WATERLOGGED, state.getValue(CurtainTall.WATERLOGGED)), 3);
				worldIn.setBlock(pos.below(), Window_Blocks.CURTAINTALL_magenta.get().defaultBlockState()
						.setValue(CurtainTall.H_FACING, state.getValue(CurtainTall.H_FACING))
						.setValue(CurtainTall.OPEN, state.getValue(CurtainTall.OPEN))
						.setValue(CurtainTall.HINGE, state.getValue(CurtainTall.HINGE))
						.setValue(CurtainTall.HALF, DoubleBlockHalf.LOWER)
						.setValue(CurtainTall.WATERLOGGED, state.getValue(CurtainTall.WATERLOGGED)), 3); }
			
			stack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return InteractionResult.SUCCESS;
		}
		
		/* Wash the brush. MIZUOKE work is in the block. */
		if (block == Blocks.WATER_CAULDRON) {
			int cauldron = state.getValue(LayeredCauldronBlock.LEVEL);
			CMEvents.soundWash(worldIn, playerIn, pos);
			
			if (cauldron != 1) {
				worldIn.setBlock(pos, state.setValue(LayeredCauldronBlock.LEVEL, Integer.valueOf(cauldron - 1)), 3); }

			if (cauldron == 1) {
				worldIn.setBlock(pos, Blocks.CAULDRON.defaultBlockState(), 3); }
			
			/** Return the Item. **/
			if (!playerIn.getInventory().add(new ItemStack(Items_Wadeco.HAKE.get()))) {
				playerIn.drop(new ItemStack(Items_Wadeco.HAKE.get()), false); }

			if (!mode) { stack.shrink(1); }
			return InteractionResult.SUCCESS;
		}

		return InteractionResult.FAIL;
	}
}
