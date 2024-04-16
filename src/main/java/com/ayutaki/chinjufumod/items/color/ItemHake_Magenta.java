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
import com.ayutaki.chinjufumod.registry.JP_Blocks;
import com.ayutaki.chinjufumod.registry.JPdeco_Blocks;
import com.ayutaki.chinjufumod.registry.KamoiPlaster_Blocks;
import com.ayutaki.chinjufumod.registry.Ranma_Blocks;
import com.ayutaki.chinjufumod.registry.Slidedoor_Blocks;
import com.ayutaki.chinjufumod.registry.Unit_Blocks;
import com.ayutaki.chinjufumod.registry.WallPanel_Blocks;
import com.ayutaki.chinjufumod.registry.Window_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CarpetBlock;
import net.minecraft.block.CauldronBlock;
import net.minecraft.block.ConcretePowderBlock;
import net.minecraft.block.GlazedTerracottaBlock;
import net.minecraft.block.PaneBlock;
import net.minecraft.block.StainedGlassBlock;
import net.minecraft.block.StainedGlassPaneBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class ItemHake_Magenta extends Base_ItemHake {

	public ItemHake_Magenta(Properties properties) {
		super(properties);
	}

	/* FlintAndSteel */
	public ActionResultType onItemUse(ItemUseContext context) {
		PlayerEntity playerIn = context.getPlayer();
		IWorld iworld = context.getWorld();
		BlockPos pos = context.getPos();
		BlockState state = iworld.getBlockState(pos);
		Block block = state.getBlock();

		ItemStack stack = context.getItem();
		boolean mode = playerIn.abilities.isCreativeMode;

		/** 木材 採用見送り **/

		/** 羊毛・コンクリート **/
		if (block == Blocks.WHITE_WOOL || block == Blocks.ORANGE_WOOL || block == Blocks.LIGHT_BLUE_WOOL ||
				block == Blocks.YELLOW_WOOL || block == Blocks.LIME_WOOL || block == Blocks.PINK_WOOL ||
				block == Blocks.GRAY_WOOL || block == Blocks.LIGHT_GRAY_WOOL || block == Blocks.CYAN_WOOL ||
				block == Blocks.PURPLE_WOOL || block == Blocks.BLUE_WOOL || block == Blocks.BROWN_WOOL ||
				block == Blocks.GREEN_WOOL || block == Blocks.RED_WOOL || block == Blocks.BLACK_WOOL) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, Blocks.MAGENTA_WOOL.getDefaultState(), 3);

			stack.damageItem(2, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } ); //BreakAnimation 無しで筆を返すことも可能

			return ActionResultType.SUCCESS;
		}

		if (block == Blocks.WHITE_CONCRETE || block == Blocks.ORANGE_CONCRETE || block == Blocks.LIGHT_BLUE_CONCRETE ||
				block == Blocks.YELLOW_CONCRETE || block == Blocks.LIME_CONCRETE || block == Blocks.PINK_CONCRETE ||
				block == Blocks.GRAY_CONCRETE || block == Blocks.LIGHT_GRAY_CONCRETE || block == Blocks.CYAN_CONCRETE ||
				block == Blocks.PURPLE_CONCRETE || block == Blocks.BLUE_CONCRETE || block == Blocks.BROWN_CONCRETE ||
				block == Blocks.GREEN_CONCRETE || block == Blocks.RED_CONCRETE || block == Blocks.BLACK_CONCRETE) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, Blocks.MAGENTA_CONCRETE.getDefaultState(), 3);

			stack.damageItem(2, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block == Blocks.WHITE_TERRACOTTA || block == Blocks.ORANGE_TERRACOTTA || block == Blocks.LIGHT_BLUE_TERRACOTTA ||
				block == Blocks.YELLOW_TERRACOTTA || block == Blocks.LIME_TERRACOTTA || block == Blocks.PINK_TERRACOTTA ||
				block == Blocks.GRAY_TERRACOTTA || block == Blocks.LIGHT_GRAY_TERRACOTTA || block == Blocks.CYAN_TERRACOTTA ||
				block == Blocks.PURPLE_TERRACOTTA || block == Blocks.BLUE_TERRACOTTA || block == Blocks.BROWN_TERRACOTTA ||
				block == Blocks.GREEN_TERRACOTTA || block == Blocks.RED_TERRACOTTA || block == Blocks.BLACK_TERRACOTTA ||
				block == Blocks.TERRACOTTA) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, Blocks.MAGENTA_TERRACOTTA.getDefaultState(), 3);

			stack.damageItem(2, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof ConcretePowderBlock && block != Blocks.MAGENTA_CONCRETE_POWDER) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, Blocks.MAGENTA_CONCRETE_POWDER.getDefaultState(), 3);

			stack.damageItem(2, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if ((block instanceof StainedGlassBlock && block != Blocks.MAGENTA_STAINED_GLASS) || block == Blocks.GLASS) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, Blocks.MAGENTA_STAINED_GLASS.getDefaultState(), 3);

			stack.damageItem(2, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** テラコッタ **/
		if (block instanceof GlazedTerracottaBlock && block != Blocks.MAGENTA_GLAZED_TERRACOTTA) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, Blocks.MAGENTA_GLAZED_TERRACOTTA.getDefaultState()
					.with(GlazedTerracottaBlock.HORIZONTAL_FACING, state.get(GlazedTerracottaBlock.HORIZONTAL_FACING)), 3);

			stack.damageItem(2, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** 板ガラス **/
		if ((block instanceof StainedGlassPaneBlock && block != Blocks.MAGENTA_STAINED_GLASS_PANE) || block == Blocks.GLASS_PANE) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, Blocks.MAGENTA_STAINED_GLASS_PANE.getDefaultState()
					.with(PaneBlock.NORTH, state.get(PaneBlock.NORTH))
					.with(PaneBlock.EAST, state.get(PaneBlock.EAST))
					.with(PaneBlock.SOUTH, state.get(PaneBlock.SOUTH))
					.with(PaneBlock.WEST, state.get(PaneBlock.WEST))
					.with(PaneBlock.WATERLOGGED, state.get(PaneBlock.WATERLOGGED)), 3);

			stack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/**カーペット **/
		if (block instanceof CarpetBlock && block != Blocks.MAGENTA_CARPET) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, Blocks.MAGENTA_CARPET.getDefaultState(), 3);

			stack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}


		/** 瓦・漆喰・なまこ壁 **/
		if (block instanceof Full_Kawara && block != JP_Blocks.KAWARA_magenta) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, JP_Blocks.KAWARA_magenta.getDefaultState()
					.with(Base_Full_JP.CRACK, state.get(Base_Full_JP.CRACK)), 3);

			stack.damageItem(2, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Full_Plaster && block != JP_Blocks.SHIKKUI_magenta && block != JP_Blocks.DIRTWALL) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, JP_Blocks.SHIKKUI_magenta.getDefaultState()
					.with(Base_Full_JP.CRACK, state.get(Base_Full_JP.CRACK)), 3);

			stack.damageItem(2, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Full_Namako && block != JP_Blocks.NAMAKO_magenta) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, JP_Blocks.NAMAKO_magenta.getDefaultState()
					.with(Base_Full_JP.CRACK, state.get(Base_Full_JP.CRACK)), 3);

			stack.damageItem(2, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Full_Namako_B && block != JP_Blocks.NAMAKOB_magenta) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, JP_Blocks.NAMAKOB_magenta.getDefaultState()
					.with(Base_Full_JP.CRACK, state.get(Base_Full_JP.CRACK)), 3);

			stack.damageItem(2, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** 階段 **/
		if (block instanceof Stairs_Kawara && block != JP_Blocks.KAWARA_ST_magenta) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, JP_Blocks.KAWARA_ST_magenta.getDefaultState()
					.with(StairsBlock.FACING, state.get(StairsBlock.FACING))
					.with(StairsBlock.HALF, state.get(StairsBlock.HALF))
					.with(StairsBlock.SHAPE, state.get(StairsBlock.SHAPE))
					.with(StairsBlock.WATERLOGGED, state.get(StairsBlock.WATERLOGGED)), 3);

			stack.damageItem(2, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Stairs_Plaster && block != JP_Blocks.SHIKKUI_ST_magenta && block != JP_Blocks.DIRTWALL_stairs) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, JP_Blocks.SHIKKUI_ST_magenta.getDefaultState()
					.with(StairsBlock.FACING, state.get(StairsBlock.FACING))
					.with(StairsBlock.HALF, state.get(StairsBlock.HALF))
					.with(StairsBlock.SHAPE, state.get(StairsBlock.SHAPE))
					.with(StairsBlock.WATERLOGGED, state.get(StairsBlock.WATERLOGGED)), 3);

			stack.damageItem(2, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Stairs_Namako && block != JP_Blocks.NAMAKO_ST_magenta) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, JP_Blocks.NAMAKO_ST_magenta.getDefaultState()
					.with(StairsBlock.FACING, state.get(StairsBlock.FACING))
					.with(StairsBlock.HALF, state.get(StairsBlock.HALF))
					.with(StairsBlock.SHAPE, state.get(StairsBlock.SHAPE))
					.with(StairsBlock.WATERLOGGED, state.get(StairsBlock.WATERLOGGED)), 3);

			stack.damageItem(2, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Stairs_Namako_B && block != JP_Blocks.NAMAKOB_ST_magenta) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, JP_Blocks.NAMAKOB_ST_magenta.getDefaultState()
					.with(StairsBlock.FACING, state.get(StairsBlock.FACING))
					.with(StairsBlock.HALF, state.get(StairsBlock.HALF))
					.with(StairsBlock.SHAPE, state.get(StairsBlock.SHAPE))
					.with(StairsBlock.WATERLOGGED, state.get(StairsBlock.WATERLOGGED)), 3);

			stack.damageItem(2, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** ハーフブロック **/
		if (block instanceof Slab_Kawara && block != JP_Blocks.KAWARA_SH_magenta) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, JP_Blocks.KAWARA_SH_magenta.getDefaultState()
					.with(Base_Slab_JP.TYPE, state.get(Base_Slab_JP.TYPE))
					.with(Base_Slab_JP.CRACK, state.get(Base_Slab_JP.CRACK))
					.with(Base_Slab_JP.WATERLOGGED, state.get(Base_Slab_JP.WATERLOGGED)), 3);

			if (state.get(Base_Slab_JP.TYPE) == SlabType.DOUBLE) {
				stack.damageItem(2, playerIn, user -> {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
					user.sendBreakAnimation(context.getHand()); } );
			}

			if (state.get(Base_Slab_JP.TYPE) != SlabType.DOUBLE) {
				stack.damageItem(1, playerIn, user -> {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
					user.sendBreakAnimation(context.getHand()); } );
			}
			return ActionResultType.SUCCESS;
		}

		if (block instanceof Slab_Plaster && block != JP_Blocks.SHIKKUI_SH_magenta && block != JP_Blocks.DIRTWALL_SH) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, JP_Blocks.SHIKKUI_SH_magenta.getDefaultState()
					.with(Base_Slab_JP.TYPE, state.get(Base_Slab_JP.TYPE))
					.with(Base_Slab_JP.CRACK, state.get(Base_Slab_JP.CRACK))
					.with(Base_Slab_JP.WATERLOGGED, state.get(Base_Slab_JP.WATERLOGGED)), 3);

			if (state.get(Base_Slab_JP.TYPE) == SlabType.DOUBLE) {
				stack.damageItem(2, playerIn, user -> {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
					user.sendBreakAnimation(context.getHand()); } );
			}

			if (state.get(Base_Slab_JP.TYPE) != SlabType.DOUBLE) {
				stack.damageItem(1, playerIn, user -> {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
					user.sendBreakAnimation(context.getHand()); } );
			}
			return ActionResultType.SUCCESS;
		}

		if (block instanceof Slab_Namako && block != JP_Blocks.NAMAKO_SH_magenta) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, JP_Blocks.NAMAKO_SH_magenta.getDefaultState()
					.with(Base_Slab_JP.TYPE, state.get(Base_Slab_JP.TYPE))
					.with(Base_Slab_JP.CRACK, state.get(Base_Slab_JP.CRACK))
					.with(Base_Slab_JP.WATERLOGGED, state.get(Base_Slab_JP.WATERLOGGED)), 3);

			if (state.get(Base_Slab_JP.TYPE) == SlabType.DOUBLE) {
				stack.damageItem(2, playerIn, user -> {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
					user.sendBreakAnimation(context.getHand()); } );
			}

			if (state.get(Base_Slab_JP.TYPE) != SlabType.DOUBLE) {
				stack.damageItem(1, playerIn, user -> {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
					user.sendBreakAnimation(context.getHand()); } );
			}
			return ActionResultType.SUCCESS;
		}

		if (block instanceof Slab_Namako_B && block != JP_Blocks.NAMAKOB_SH_magenta) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, JP_Blocks.NAMAKOB_SH_magenta.getDefaultState()
					.with(Base_Slab_JP.TYPE, state.get(Base_Slab_JP.TYPE))
					.with(Base_Slab_JP.CRACK, state.get(Base_Slab_JP.CRACK))
					.with(Base_Slab_JP.WATERLOGGED, state.get(Base_Slab_JP.WATERLOGGED)), 3);

			if (state.get(Base_Slab_JP.TYPE) == SlabType.DOUBLE) {
				stack.damageItem(2, playerIn, user -> {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
					user.sendBreakAnimation(context.getHand()); } );
			}

			if (state.get(Base_Slab_JP.TYPE) != SlabType.DOUBLE) {
				stack.damageItem(1, playerIn, user -> {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
					user.sendBreakAnimation(context.getHand()); } );
			}
			return ActionResultType.SUCCESS;
		}

		///////////////////////
		/** トラス **/
		if (block instanceof CTruss && block != Harbor_Blocks.TRUSS_magenta) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, Harbor_Blocks.TRUSS_magenta.getDefaultState()
					.with(BaseFacingWater.H_FACING, state.get(BaseFacingWater.H_FACING))
					.with(BaseFacingWater.WATERLOGGED, state.get(BaseFacingWater.WATERLOGGED)), 3);

			stack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** 椅子・座布団・キャンドル **/
		if (block instanceof CafeChair && block != Chair_Blocks.CAFECHAIR_magenta) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, Chair_Blocks.CAFECHAIR_magenta.getDefaultState(), 3);

			stack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Zabuton && block != JPChair_Blocks.ZABUTON_magenta && block != JPChair_Blocks.WARAZABUTON) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, JPChair_Blocks.ZABUTON_magenta.getDefaultState()
					.with(Zabuton.DOWN, state.get(Zabuton.DOWN))
					.with(Zabuton.WATERLOGGED, state.get(Zabuton.WATERLOGGED)), 3);

			stack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Candle && block != Furniture_Blocks.CANDLE_magenta) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, Furniture_Blocks.CANDLE_magenta.getDefaultState()
					.with(Candle.LIT, state.get(Candle.LIT))
					.with(Candle.DOWN, state.get(Candle.DOWN))
					.with(Candle.WATERLOGGED, state.get(Candle.WATERLOGGED)), 3);

			stack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** 行灯 **/
		if (block instanceof Andon && block != JPdeco_Blocks.ANDON_magenta) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, JPdeco_Blocks.ANDON_magenta.getDefaultState()
					.with(Andon.LIT, state.get(Andon.LIT))
					.with(Andon.H_FACING, state.get(Andon.H_FACING))
					.with(Andon.WATERLOGGED, state.get(Andon.WATERLOGGED)), 3);

			stack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** ソファ **/
		if (block instanceof Sofa && block != Chair_Blocks.SOFA_magenta) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, Chair_Blocks.SOFA_magenta.getDefaultState()
					.with(BaseSofa.TYPE, state.get(BaseSofa.TYPE))
					.with(BaseSofa.H_FACING, state.get(BaseSofa.H_FACING))
					.with(BaseSofa.WATERLOGGED, state.get(BaseSofa.WATERLOGGED)), 3);

			stack.damageItem(2, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** 座椅子 **/
		if (block instanceof Zaisu && block != JPChair_Blocks.ZAISU_magenta) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, JPChair_Blocks.ZAISU_magenta.getDefaultState()
					.with(BaseFacingWater.H_FACING, state.get(BaseFacingWater.H_FACING))
					.with(BaseFacingWater.WATERLOGGED, state.get(BaseFacingWater.WATERLOGGED)), 3);

			stack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** のれん **/
		if (block instanceof Noren && block != Ranma_Blocks.NOREN_magenta) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, Ranma_Blocks.NOREN_magenta.getDefaultState()
					.with(Noren.TYPE, state.get(Noren.TYPE))
					.with(Noren.H_FACING, state.get(Noren.H_FACING))
					.with(Noren.WATERLOGGED, state.get(Noren.WATERLOGGED)), 3);

			stack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** 布団 **/
		if (block instanceof Futon && block != JPdeco_Blocks.FUTON_magenta) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, JPdeco_Blocks.FUTON_magenta.getDefaultState()
					.with(BaseStage2_FaceWater.STAGE_1_2, state.get(BaseStage2_FaceWater.STAGE_1_2))
					.with(BaseStage2_FaceWater.H_FACING, state.get(BaseStage2_FaceWater.H_FACING))
					.with(BaseStage2_FaceWater.WATERLOGGED, state.get(BaseStage2_FaceWater.WATERLOGGED)), 3);

			stack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** 畳 **/
		if (block instanceof Tatami && block != JPdeco_Blocks.TATAMI_H_magenta && block != JPdeco_Blocks.TATAMI_H) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, JPdeco_Blocks.TATAMI_H_magenta.getDefaultState()
					.with(BaseTatami.TYPE, state.get(BaseTatami.TYPE))
					.with(BaseTatami.H_FACING, state.get(BaseTatami.H_FACING))
					.with(BaseTatami.WATERLOGGED, state.get(BaseTatami.WATERLOGGED)), 3);

			stack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Tatami_Y && block != JPdeco_Blocks.TATAMI_HY_magenta && block != JPdeco_Blocks.TATAMI_HY) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, JPdeco_Blocks.TATAMI_HY_magenta.getDefaultState()
					.with(BaseTatami.TYPE, state.get(BaseTatami.TYPE))
					.with(BaseTatami.H_FACING, state.get(BaseTatami.H_FACING))
					.with(BaseTatami.WATERLOGGED, state.get(BaseTatami.WATERLOGGED)), 3);

			stack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** 傘 **/
		if (block instanceof Wagasa && block != Unit_Blocks.KASA_magenta) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, Unit_Blocks.KASA_magenta.getDefaultState()
					.with(Wagasa.NORTH, state.get(Wagasa.NORTH))
					.with(Wagasa.EAST, state.get(Wagasa.EAST))
					.with(Wagasa.SOUTH, state.get(Wagasa.SOUTH))
					.with(Wagasa.WEST, state.get(Wagasa.WEST))
					.with(Wagasa.WHICH, Boolean.valueOf(false))
					.with(Wagasa.WATERLOGGED, state.get(Wagasa.WATERLOGGED)), 3);

			stack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}


		///////////////////////
		/** ふすま **/
		if (block instanceof Fusuma && block != Slidedoor_Blocks.FUSUMA_magenta) {

			CMEvents.soundPaint(iworld, playerIn, pos);

			if (state.get(BaseSlidedoor.HALF) == DoubleBlockHalf.LOWER) {
				iworld.setBlockState(pos, Slidedoor_Blocks.FUSUMA_magenta.getDefaultState()
						.with(BaseSlidedoor.H_FACING, state.get(BaseSlidedoor.H_FACING))
						.with(BaseSlidedoor.OPEN, state.get(BaseSlidedoor.OPEN))
						.with(BaseSlidedoor.HINGE, state.get(BaseSlidedoor.HINGE))
						.with(BaseSlidedoor.POWERED, state.get(BaseSlidedoor.POWERED))
						.with(BaseSlidedoor.HALF, DoubleBlockHalf.LOWER)
						.with(BaseSlidedoor.WATERLOGGED, state.get(BaseSlidedoor.WATERLOGGED)), 3);
				iworld.setBlockState(pos.up(), Slidedoor_Blocks.FUSUMA_magenta.getDefaultState()
						.with(BaseSlidedoor.H_FACING, state.get(BaseSlidedoor.H_FACING))
						.with(BaseSlidedoor.OPEN, state.get(BaseSlidedoor.OPEN))
						.with(BaseSlidedoor.HINGE, state.get(BaseSlidedoor.HINGE))
						.with(BaseSlidedoor.POWERED, state.get(BaseSlidedoor.POWERED))
						.with(BaseSlidedoor.HALF, DoubleBlockHalf.UPPER)
						.with(BaseSlidedoor.WATERLOGGED, state.get(BaseSlidedoor.WATERLOGGED)), 3); }

			if (state.get(BaseSlidedoor.HALF) == DoubleBlockHalf.UPPER) {
				iworld.setBlockState(pos, Slidedoor_Blocks.FUSUMA_magenta.getDefaultState()
						.with(BaseSlidedoor.H_FACING, state.get(BaseSlidedoor.H_FACING))
						.with(BaseSlidedoor.OPEN, state.get(BaseSlidedoor.OPEN))
						.with(BaseSlidedoor.HINGE, state.get(BaseSlidedoor.HINGE))
						.with(BaseSlidedoor.POWERED, state.get(BaseSlidedoor.POWERED))
						.with(BaseSlidedoor.HALF, DoubleBlockHalf.UPPER)
						.with(BaseSlidedoor.WATERLOGGED, state.get(BaseSlidedoor.WATERLOGGED)), 3);
				iworld.setBlockState(pos.down(), Slidedoor_Blocks.FUSUMA_magenta.getDefaultState()
						.with(BaseSlidedoor.H_FACING, state.get(BaseSlidedoor.H_FACING))
						.with(BaseSlidedoor.OPEN, state.get(BaseSlidedoor.OPEN))
						.with(BaseSlidedoor.HINGE, state.get(BaseSlidedoor.HINGE))
						.with(BaseSlidedoor.POWERED, state.get(BaseSlidedoor.POWERED))
						.with(BaseSlidedoor.HALF, DoubleBlockHalf.LOWER)
						.with(BaseSlidedoor.WATERLOGGED, state.get(BaseSlidedoor.WATERLOGGED)), 3); }

			stack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Fusuma_B && block != Slidedoor_Blocks.FUSUMAB_magenta) {

			CMEvents.soundPaint(iworld, playerIn, pos);

			if (state.get(BaseSlidedoor.HALF) == DoubleBlockHalf.LOWER) {
				iworld.setBlockState(pos, Slidedoor_Blocks.FUSUMAB_magenta.getDefaultState()
						.with(BaseSlidedoor.H_FACING, state.get(BaseSlidedoor.H_FACING))
						.with(BaseSlidedoor.OPEN, state.get(BaseSlidedoor.OPEN))
						.with(BaseSlidedoor.HINGE, state.get(BaseSlidedoor.HINGE))
						.with(BaseSlidedoor.POWERED, state.get(BaseSlidedoor.POWERED))
						.with(BaseSlidedoor.HALF, DoubleBlockHalf.LOWER)
						.with(BaseSlidedoor.WATERLOGGED, state.get(BaseSlidedoor.WATERLOGGED)), 3);
				iworld.setBlockState(pos.up(), Slidedoor_Blocks.FUSUMAB_magenta.getDefaultState()
						.with(BaseSlidedoor.H_FACING, state.get(BaseSlidedoor.H_FACING))
						.with(BaseSlidedoor.OPEN, state.get(BaseSlidedoor.OPEN))
						.with(BaseSlidedoor.HINGE, state.get(BaseSlidedoor.HINGE))
						.with(BaseSlidedoor.POWERED, state.get(BaseSlidedoor.POWERED))
						.with(BaseSlidedoor.HALF, DoubleBlockHalf.UPPER)
						.with(BaseSlidedoor.WATERLOGGED, state.get(BaseSlidedoor.WATERLOGGED)), 3); }

			if (state.get(BaseSlidedoor.HALF) == DoubleBlockHalf.UPPER) {
				iworld.setBlockState(pos, Slidedoor_Blocks.FUSUMAB_magenta.getDefaultState()
						.with(BaseSlidedoor.H_FACING, state.get(BaseSlidedoor.H_FACING))
						.with(BaseSlidedoor.OPEN, state.get(BaseSlidedoor.OPEN))
						.with(BaseSlidedoor.HINGE, state.get(BaseSlidedoor.HINGE))
						.with(BaseSlidedoor.POWERED, state.get(BaseSlidedoor.POWERED))
						.with(BaseSlidedoor.HALF, DoubleBlockHalf.UPPER)
						.with(BaseSlidedoor.WATERLOGGED, state.get(BaseSlidedoor.WATERLOGGED)), 3);
				iworld.setBlockState(pos.down(), Slidedoor_Blocks.FUSUMAB_magenta.getDefaultState()
						.with(BaseSlidedoor.H_FACING, state.get(BaseSlidedoor.H_FACING))
						.with(BaseSlidedoor.OPEN, state.get(BaseSlidedoor.OPEN))
						.with(BaseSlidedoor.HINGE, state.get(BaseSlidedoor.HINGE))
						.with(BaseSlidedoor.POWERED, state.get(BaseSlidedoor.POWERED))
						.with(BaseSlidedoor.HALF, DoubleBlockHalf.LOWER)
						.with(BaseSlidedoor.WATERLOGGED, state.get(BaseSlidedoor.WATERLOGGED)), 3); }

			stack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		///////////////////////
		/** 鴨居 **/
		if (block instanceof KamoiPlaster_Oak && block != KamoiPlaster_Blocks.KAMOI_magenta_oak) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, KamoiPlaster_Blocks.KAMOI_magenta_oak.getDefaultState()
					.with(Base_KamoiPlaster.H_FACING, state.get(Base_KamoiPlaster.H_FACING))
					.with(Base_KamoiPlaster.STAGE_1_4, state.get(Base_KamoiPlaster.STAGE_1_4)), 3);

			stack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof KamoiPlaster_Spruce && block != KamoiPlaster_Blocks.KAMOI_magenta_spru) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, KamoiPlaster_Blocks.KAMOI_magenta_spru.getDefaultState()
					.with(Base_KamoiPlaster.H_FACING, state.get(Base_KamoiPlaster.H_FACING))
					.with(Base_KamoiPlaster.STAGE_1_4, state.get(Base_KamoiPlaster.STAGE_1_4)), 3);

			stack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof KamoiPlaster_Birch && block != KamoiPlaster_Blocks.KAMOI_magenta_bir) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, KamoiPlaster_Blocks.KAMOI_magenta_bir.getDefaultState()
					.with(Base_KamoiPlaster.H_FACING, state.get(Base_KamoiPlaster.H_FACING))
					.with(Base_KamoiPlaster.STAGE_1_4, state.get(Base_KamoiPlaster.STAGE_1_4)), 3);

			stack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof KamoiPlaster_Jungle && block != KamoiPlaster_Blocks.KAMOI_magenta_jun) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, KamoiPlaster_Blocks.KAMOI_magenta_jun.getDefaultState()
					.with(Base_KamoiPlaster.H_FACING, state.get(Base_KamoiPlaster.H_FACING))
					.with(Base_KamoiPlaster.STAGE_1_4, state.get(Base_KamoiPlaster.STAGE_1_4)), 3);

			stack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof KamoiPlaster_Acacia && block != KamoiPlaster_Blocks.KAMOI_magenta_aca) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, KamoiPlaster_Blocks.KAMOI_magenta_aca.getDefaultState()
					.with(Base_KamoiPlaster.H_FACING, state.get(Base_KamoiPlaster.H_FACING))
					.with(Base_KamoiPlaster.STAGE_1_4, state.get(Base_KamoiPlaster.STAGE_1_4)), 3);

			stack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof KamoiPlaster_DarkOak && block != KamoiPlaster_Blocks.KAMOI_magenta_doak) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, KamoiPlaster_Blocks.KAMOI_magenta_doak.getDefaultState()
					.with(Base_KamoiPlaster.H_FACING, state.get(Base_KamoiPlaster.H_FACING))
					.with(Base_KamoiPlaster.STAGE_1_4, state.get(Base_KamoiPlaster.STAGE_1_4)), 3);

			stack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof KamoiPlaster_Sakura && block != KamoiPlaster_Blocks.KAMOI_magenta_sakura) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, KamoiPlaster_Blocks.KAMOI_magenta_sakura.getDefaultState()
					.with(Base_KamoiPlaster.H_FACING, state.get(Base_KamoiPlaster.H_FACING))
					.with(Base_KamoiPlaster.STAGE_1_4, state.get(Base_KamoiPlaster.STAGE_1_4)), 3);

			stack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof KamoiPlaster_Kaede && block != KamoiPlaster_Blocks.KAMOI_magenta_kaede) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, KamoiPlaster_Blocks.KAMOI_magenta_kaede.getDefaultState()
					.with(Base_KamoiPlaster.H_FACING, state.get(Base_KamoiPlaster.H_FACING))
					.with(Base_KamoiPlaster.STAGE_1_4, state.get(Base_KamoiPlaster.STAGE_1_4)), 3);

			stack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof KamoiPlaster_Ichoh && block != KamoiPlaster_Blocks.KAMOI_magenta_ichoh) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, KamoiPlaster_Blocks.KAMOI_magenta_ichoh.getDefaultState()
					.with(Base_KamoiPlaster.H_FACING, state.get(Base_KamoiPlaster.H_FACING))
					.with(Base_KamoiPlaster.STAGE_1_4, state.get(Base_KamoiPlaster.STAGE_1_4)), 3);

			stack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}


		///////////////////////
		/** 粘土 **/
		if (block instanceof WallPane_Clay && block != WallPanel_Blocks.WP_CLAY_magenta) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, WallPanel_Blocks.WP_CLAY_magenta.getDefaultState()
					.with(BaseFacingWater.H_FACING, state.get(BaseFacingWater.H_FACING))
					.with(BaseFacingWater.WATERLOGGED, state.get(BaseFacingWater.WATERLOGGED)), 3);

			stack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** ガラス **/
		if (block instanceof WallPane_Glass && block != WallPanel_Blocks.WP_GLASS_magenta) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, WallPanel_Blocks.WP_GLASS_magenta.getDefaultState()
					.with(BaseFacingWater.H_FACING, state.get(BaseFacingWater.H_FACING))
					.with(BaseFacingWater.WATERLOGGED, state.get(BaseFacingWater.WATERLOGGED)), 3);

			stack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** しっくい **/
		if (block instanceof WallPane_Plaster && block != WallPanel_Blocks.WP_PLASTER_magenta) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, WallPanel_Blocks.WP_PLASTER_magenta.getDefaultState()
					.with(BaseStage2_FaceWater.H_FACING, state.get(BaseStage2_FaceWater.H_FACING))
					.with(BaseStage2_FaceWater.STAGE_1_2, state.get(BaseStage2_FaceWater.STAGE_1_2))
					.with(BaseStage2_FaceWater.WATERLOGGED, state.get(BaseStage2_FaceWater.WATERLOGGED)), 3);

			stack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** なまこ **/
		if (block instanceof WallPane_Namako && block != WallPanel_Blocks.WP_NAMAKO_magenta) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, WallPanel_Blocks.WP_NAMAKO_magenta.getDefaultState()
					.with(BaseStage2_FaceWater.H_FACING, state.get(BaseStage2_FaceWater.H_FACING))
					.with(BaseStage2_FaceWater.STAGE_1_2, state.get(BaseStage2_FaceWater.STAGE_1_2))
					.with(BaseStage2_FaceWater.WATERLOGGED, state.get(BaseStage2_FaceWater.WATERLOGGED)), 3);

			stack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof WallPane_Namako_B && block != WallPanel_Blocks.WP_NAMAKOB_magenta) {

			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, WallPanel_Blocks.WP_NAMAKOB_magenta.getDefaultState()
					.with(BaseStage2_FaceWater.H_FACING, state.get(BaseStage2_FaceWater.H_FACING))
					.with(BaseStage2_FaceWater.STAGE_1_2, state.get(BaseStage2_FaceWater.STAGE_1_2))
					.with(BaseStage2_FaceWater.WATERLOGGED, state.get(BaseStage2_FaceWater.WATERLOGGED)), 3);

			stack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		///6.1.2////////////////////
		if (block instanceof Wall_Plaster && block != JP_Blocks.SHIKKUI_WALL_magenta && block != JP_Blocks.DIRTWALL_WALL) {
			
			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, JP_Blocks.SHIKKUI_WALL_magenta.getDefaultState()
					.with(Wall_Plaster.NORTH, state.get(Wall_Plaster.NORTH))
					.with(Wall_Plaster.SOUTH, state.get(Wall_Plaster.SOUTH))
					.with(Wall_Plaster.EAST, state.get(Wall_Plaster.EAST))
					.with(Wall_Plaster.WEST, state.get(Wall_Plaster.WEST))
					.with(Wall_Plaster.CRACK, state.get(Wall_Plaster.CRACK))
					.with(Wall_Plaster.WATERLOGGED, state.get(Wall_Plaster.WATERLOGGED)), 3);

			stack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}
		
		if (block instanceof Wall_Sama && block != JP_Blocks.SHIKKUI_SAMA_magenta && block != JP_Blocks.DIRTWALL_SAMA) {
			
			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, JP_Blocks.SHIKKUI_SAMA_magenta.getDefaultState()
					.with(Wall_Sama.H_FACING, state.get(Wall_Sama.H_FACING))
					.with(Wall_Sama.STAGE_1_4, state.get(Wall_Sama.STAGE_1_4))
					.with(Wall_Sama.WATERLOGGED, state.get(Wall_Sama.WATERLOGGED)), 3);
			
			if (state.get(Wall_Sama.STAGE_1_4) <= 2) {
				stack.damageItem(1, playerIn, user -> {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
					user.sendBreakAnimation(context.getHand()); } );
			}
			
			if (state.get(Wall_Sama.STAGE_1_4) >= 3) {
				stack.damageItem(2, playerIn, user -> {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
					user.sendBreakAnimation(context.getHand()); } );
			}

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Wall_Kawara && block != JP_Blocks.KAWARA_WALL_magenta) {
			
			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, JP_Blocks.KAWARA_WALL_magenta.getDefaultState()
					.with(Wall_Kawara.NORTH, state.get(Wall_Kawara.NORTH))
					.with(Wall_Kawara.SOUTH, state.get(Wall_Kawara.SOUTH))
					.with(Wall_Kawara.EAST, state.get(Wall_Kawara.EAST))
					.with(Wall_Kawara.WEST, state.get(Wall_Kawara.WEST))
					.with(Wall_Kawara.WATERLOGGED, state.get(Wall_Kawara.WATERLOGGED)), 3);
			
			stack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}
		
		if (block instanceof Wall_Namako && block != JP_Blocks.NAMAKO_WALL_magenta) {
			
			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, JP_Blocks.NAMAKO_WALL_magenta.getDefaultState()
					.with(Wall_Namako.NORTH, state.get(Wall_Namako.NORTH))
					.with(Wall_Namako.SOUTH, state.get(Wall_Namako.SOUTH))
					.with(Wall_Namako.EAST, state.get(Wall_Namako.EAST))
					.with(Wall_Namako.WEST, state.get(Wall_Namako.WEST))
					.with(Wall_Namako.CRACK, state.get(Wall_Namako.CRACK))
					.with(Wall_Namako.WATERLOGGED, state.get(Wall_Namako.WATERLOGGED)), 3);

			stack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}
		
		if (block instanceof Wall_NamakoB && block != JP_Blocks.NAMAKOB_WALL_magenta) {
			
			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, JP_Blocks.NAMAKOB_WALL_magenta.getDefaultState()
					.with(Wall_NamakoB.NORTH, state.get(Wall_NamakoB.NORTH))
					.with(Wall_NamakoB.SOUTH, state.get(Wall_NamakoB.SOUTH))
					.with(Wall_NamakoB.EAST, state.get(Wall_NamakoB.EAST))
					.with(Wall_NamakoB.WEST, state.get(Wall_NamakoB.WEST))
					.with(Wall_NamakoB.CRACK, state.get(Wall_NamakoB.CRACK))
					.with(Wall_NamakoB.WATERLOGGED, state.get(Wall_NamakoB.WATERLOGGED)), 3);

			stack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}
		
		///6.2.4////////////////////
		if (block instanceof Curtain && block != Window_Blocks.CURTAIN_magenta) {
			
			CMEvents.soundPaint(iworld, playerIn, pos);
			iworld.setBlockState(pos, Window_Blocks.CURTAIN_magenta.getDefaultState()
					.with(Curtain.H_FACING, state.get(Wall_Sama.H_FACING))
					.with(Curtain.STAGE_1_4, state.get(Wall_Sama.STAGE_1_4))
					.with(Curtain.WATERLOGGED, state.get(Wall_Sama.WATERLOGGED)), 3);

			stack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}
		
		if (block instanceof CurtainTall && block != Window_Blocks.CURTAINTALL_magenta) {
			
			CMEvents.soundPaint(iworld, playerIn, pos);
			
			if (state.get(CurtainTall.HALF) == DoubleBlockHalf.LOWER) {
				iworld.setBlockState(pos, Window_Blocks.CURTAINTALL_magenta.getDefaultState()
						.with(CurtainTall.H_FACING, state.get(CurtainTall.H_FACING))
						.with(CurtainTall.OPEN, state.get(CurtainTall.OPEN))
						.with(CurtainTall.HINGE, state.get(CurtainTall.HINGE))
						.with(CurtainTall.HALF, DoubleBlockHalf.LOWER)
						.with(CurtainTall.WATERLOGGED, state.get(CurtainTall.WATERLOGGED)), 3);
				iworld.setBlockState(pos.up(), Window_Blocks.CURTAINTALL_magenta.getDefaultState()
						.with(CurtainTall.H_FACING, state.get(CurtainTall.H_FACING))
						.with(CurtainTall.OPEN, state.get(CurtainTall.OPEN))
						.with(CurtainTall.HINGE, state.get(CurtainTall.HINGE))
						.with(CurtainTall.HALF, DoubleBlockHalf.UPPER)
						.with(CurtainTall.WATERLOGGED, state.get(CurtainTall.WATERLOGGED)), 3); }
			
			if (state.get(CurtainTall.HALF) == DoubleBlockHalf.UPPER) {
				iworld.setBlockState(pos, Window_Blocks.CURTAINTALL_magenta.getDefaultState()
						.with(CurtainTall.H_FACING, state.get(CurtainTall.H_FACING))
						.with(CurtainTall.OPEN, state.get(CurtainTall.OPEN))
						.with(CurtainTall.HINGE, state.get(CurtainTall.HINGE))
						.with(CurtainTall.HALF, DoubleBlockHalf.UPPER)
						.with(CurtainTall.WATERLOGGED, state.get(CurtainTall.WATERLOGGED)), 3);
				iworld.setBlockState(pos.down(), Window_Blocks.CURTAINTALL_magenta.getDefaultState()
						.with(CurtainTall.H_FACING, state.get(CurtainTall.H_FACING))
						.with(CurtainTall.OPEN, state.get(CurtainTall.OPEN))
						.with(CurtainTall.HINGE, state.get(CurtainTall.HINGE))
						.with(CurtainTall.HALF, DoubleBlockHalf.LOWER)
						.with(CurtainTall.WATERLOGGED, state.get(CurtainTall.WATERLOGGED)), 3); }
			
			stack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}
		
		/* Wash the brush. MIZUOKE work is in the block. */
		if (block == Blocks.CAULDRON) {
			int level = state.get(CauldronBlock.LEVEL);
			if (level != 0) {
				CMEvents.soundWash(iworld, playerIn, pos);
				iworld.setBlockState(pos, state.with(CauldronBlock.LEVEL, Integer.valueOf(level - 1)), 3);

				/** アイテムを返す **/
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }

				if (!mode) { stack.shrink(1); }
				return ActionResultType.SUCCESS;
			}
		}

		return ActionResultType.FAIL;
	}

}
