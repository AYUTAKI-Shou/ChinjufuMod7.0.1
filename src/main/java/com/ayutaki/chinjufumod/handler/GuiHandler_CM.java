package com.ayutaki.chinjufumod.handler;

import com.ayutaki.chinjufumod.gui.ReizouMenu;
import com.ayutaki.chinjufumod.gui.ReizouScreen;
import com.ayutaki.chinjufumod.gui.TansuMenu;
import com.ayutaki.chinjufumod.gui.TansuScreen;
import com.ayutaki.chinjufumod.tileentity.Reizou_TileEntity;
import com.ayutaki.chinjufumod.tileentity.Tansu_TileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler_CM implements IGuiHandler {

	/** Incrementable index for the gui ID */
	private static int nextGuiId = 0;
	public static final int TANSU_GUI = nextGuiId++;
	public static final int REIZOU_GUI = nextGuiId++;
	
	/* Menu */
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		
		if(id == TANSU_GUI){
			return new TansuMenu(player.inventory, (Tansu_TileEntity)world.getTileEntity(new BlockPos(x, y, z)), player); }
		
		else if(id == REIZOU_GUI){
			return new ReizouMenu(player.inventory, (Reizou_TileEntity)world.getTileEntity(new BlockPos(x, y, z)), player); }
		
		return null;
	}

	
	/* Screen */
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		
		if(id == TANSU_GUI){
			return new TansuScreen(player.inventory, (Tansu_TileEntity)world.getTileEntity(new BlockPos(x, y, z)), player); }
		
		else if(id == REIZOU_GUI){
			return new ReizouScreen(player.inventory, (Reizou_TileEntity)world.getTileEntity(new BlockPos(x, y, z)), player); }
		
		return null;
	}
}
