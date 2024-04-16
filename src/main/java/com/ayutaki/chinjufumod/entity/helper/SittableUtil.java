package com.ayutaki.chinjufumod.entity.helper;

import java.util.List;

import com.ayutaki.chinjufumod.entity.SitableEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class SittableUtil {

	/*spawnEntityInWorld を spawnEntity*/
	public static boolean sitOnBlock(World par1World, double x, double y, double z, EntityPlayer par5EntityPlayer, double par6) {

		if (!checkForExistingEntity(par1World, x, y, z, par5EntityPlayer)) {
			SitableEntity nemb = new SitableEntity(par1World, x, y, z, par6);
			par1World.spawnEntity(nemb);
			par5EntityPlayer.startRiding(nemb);
		}
		return true;
	}

	public static boolean sitOnBlock2(World par1World, double x, double y, double z, EntityPlayer par5EntityPlayer, double par6) {

		if (!checkForExistingEntity(par1World, x, y, z, par5EntityPlayer)) {
			SitableEntity nemb = new SitableEntity(par1World, x, y, z, par6 - 0.5);
			par1World.spawnEntity(nemb);
			par5EntityPlayer.startRiding(nemb);
		}
		return true;
	}
	
	public static boolean sitOnBlockWithRotationOffset(World par1World, double x, double y, double z,
			EntityPlayer par5EntityPlayer, double par6, int metadata, double offset) {

		if (!checkForExistingEntity(par1World, x, y, z, par5EntityPlayer)) {
			SitableEntity nemb = new SitableEntity(par1World, x, y, z, par6, metadata, offset);
			par1World.spawnEntity(nemb);
			par5EntityPlayer.startRiding(nemb);
		}
		return true;
	}

	public static boolean checkForExistingEntity(World par1World, double x, double y, double z, EntityPlayer par5EntityPlayer) {

		List<SitableEntity> listEMB = par1World.getEntitiesWithinAABB(SitableEntity.class,
				new AxisAlignedBB(x, y, z, x + 1.0D, y + 1.0D, z + 1.0D).expand(1D, 1D, 1D));
		for (SitableEntity mount : listEMB)
		{
			if (mount.blockPosX == x && mount.blockPosY == y && mount.blockPosZ == z)
			{
				if (!mount.isBeingRidden())
				{
					par5EntityPlayer.startRiding(mount);
				}
				return true;
			}
		}
		return false;
	}

	public static boolean isSomeoneSitting(World worldIn, double x, double y, double z) {

		List<SitableEntity> listEMB = worldIn.getEntitiesWithinAABB(SitableEntity.class,
				new AxisAlignedBB(x, y, z, x + 1.0D, y + 1.0D, z + 1.0D).expand(1D, 1D, 1D));
		for (SitableEntity mount : listEMB)
		{
			if (mount.blockPosX == x && mount.blockPosY == y && mount.blockPosZ == z)
			{
				return mount.isBeingRidden();
			}
		}
		return false;
	}

}
