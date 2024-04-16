package com.ayutaki.chinjufumod.tileentity;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.kitchen.Reizou;
import com.ayutaki.chinjufumod.gui.ReizouMenu;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.datafix.FixTypes;
import net.minecraft.util.datafix.walkers.ItemStackDataLists;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Reizou_TileEntity extends TileEntityLockableLoot implements ITickable {

	private NonNullList<ItemStack> chestContents = NonNullList.<ItemStack>withSize(45, ItemStack.EMPTY);

	public int numPlayersUsing;
	public float lidAngle;
	public float prevLidAngle;
	private int ticksSinceSync;
	
	public Reizou_TileEntity() { }

	/*	 インベントリーの数 */
	public int getSizeInventory() {
		return 45;
	}

	public boolean isEmpty() {
		for (ItemStack stack : this.chestContents) {

			if (!stack.isEmpty()) {
				return false;
			}
		}
		return true;
	}

	/* Get the name of this object. For players this returns their username */
	public String getName() {
		return this.hasCustomName() ? this.customName : "container.chest";
	}

	/* 収納したアイテムの処理 */
	public static void registerFixesChest(DataFixer fixer) {
		fixer.registerWalker(FixTypes.BLOCK_ENTITY, new ItemStackDataLists(Reizou_TileEntity.class, new String[] {"Items"}));
	}

	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.chestContents = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);

		if (!this.checkLootAndRead(compound)) {
			ItemStackHelper.loadAllItems(compound, this.chestContents);
		}

		if (compound.hasKey("CustomName", 8)) {
			this.customName = compound.getString("CustomName");
		}
	}

	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);

		if (!this.checkLootAndWrite(compound)) {
			ItemStackHelper.saveAllItems(compound, this.chestContents);
		}

		if (this.hasCustomName()) {
			compound.setString("CustomName", this.customName);
		}
		return compound;
	}

	/* インベントリにおけるスタックの最大値 */
	public int getInventoryStackLimit() {
		return 64;
	}

	public void updateContainingBlockInfo() {
		super.updateContainingBlockInfo();
	}

	@Nullable
	protected Reizou_TileEntity getAdjacentChest(EnumFacing side) {
		BlockPos pos = this.pos.offset(side);

		if (this.isChestAt(pos)) {
			TileEntity tileentity = this.world.getTileEntity(pos);

			if (tileentity instanceof Reizou_TileEntity) {
				Reizou_TileEntity tileentitychest = (Reizou_TileEntity)tileentity;
				return tileentitychest;
			}
		}
		return null;
	}

	private boolean isChestAt(BlockPos posIn) {
		if (this.world == null) {
			return false;
		}
		else {
			Block block = this.world.getBlockState(posIn).getBlock();
			return block instanceof Reizou;
		}
	}

	/*	 クライアントイベントの受信 */
	public boolean receiveClientEvent(int id, int type) {

		if (id == 1) {
			this.numPlayersUsing = type;
			return true;
		}
		else {
			return super.receiveClientEvent(id, type);
		}
	}

	/*	 チェストの開閉処理 */
	public void openInventory(EntityPlayer playerIn) {
		if (!playerIn.isSpectator()) {
			if (this.numPlayersUsing < 0) {
				this.numPlayersUsing = 0; }

			++this.numPlayersUsing;
			this.world.addBlockEvent(this.pos, getBlockType(), 1, this.numPlayersUsing);
			this.world.notifyNeighborsOfStateChange(this.pos, this.getBlockType(), false);
		}
	}

	public void closeInventory(EntityPlayer playerIn) {
		if (!playerIn.isSpectator() && this.getBlockType() instanceof Reizou) {
			--this.numPlayersUsing;
			this.world.addBlockEvent(this.pos, getBlockType(), 1, this.numPlayersUsing);
			this.world.notifyNeighborsOfStateChange(this.pos, this.getBlockType(), false);
		}
	}

	public static int calculatePlayersUsingSync(World worldIn, TileEntityLockable lTileEntity, int ticksSinceSync, int x, int y, int z, int numPlayerUsing) {
		if (!worldIn.isRemote && numPlayerUsing != 0 && (ticksSinceSync + x + y + z) % 200 == 0) {
			numPlayerUsing = calculatePlayersUsing(worldIn, lTileEntity, x, y, z);
		}
		return numPlayerUsing;
	}
	
	public static int calculatePlayersUsing(World worldIn, TileEntityLockable lTileEntity, int x, int y, int z) {
		int i = 0;

		for(EntityPlayer playerIn : worldIn.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB((double)((float)x - 5.0F), (double)((float)y - 5.0F), (double)((float)z - 5.0F), (double)((float)(x + 1) + 5.0F), (double)((float)(y + 1) + 5.0F), (double)((float)(z + 1) + 5.0F)))) {
			if (playerIn.openContainer instanceof ReizouMenu) {
				IInventory iinventory = ((ReizouMenu)playerIn.openContainer).getLowerChestInventory();
				if (iinventory == lTileEntity) {
					++i;
				}
			}
		}
		return i;
	}
	
	private void playSound(SoundEvent sound) {
		double dx = (double) this.pos.getX() + 0.5D;
		double dy = (double) this.pos.getY() + 0.5D;
		double dz = (double) this.pos.getZ() + 0.5D;
		this.world.playSound((EntityPlayer) null, dx, dy, dz, sound, SoundCategory.BLOCKS, 1.0F, 1.0F);
	}
	
	/*	 チェストの開閉時の効果音 */
	public void update() {
		
		int i = this.pos.getX();
		int j = this.pos.getY();
		int k = this.pos.getZ();
		++this.ticksSinceSync;
		this.numPlayersUsing = calculatePlayersUsingSync(this.world, this, this.ticksSinceSync, i, j, k, this.numPlayersUsing);
		this.prevLidAngle = this.lidAngle;
		
		if (this.numPlayersUsing > 0 && this.lidAngle == 0.0F) {
			this.playSound(SoundEvents_CM.REIZOU_OPEN);
		}

		if (this.numPlayersUsing == 0 && this.lidAngle > 0.0F || this.numPlayersUsing > 0 && this.lidAngle < 1.0F) {
			float f2 = this.lidAngle;

			if (this.numPlayersUsing > 0) {
				this.lidAngle += 0.1F;
			}
			else {
				this.lidAngle -= 0.1F;
			}

			if (this.lidAngle > 1.0F) {
				this.lidAngle = 1.0F;
			}

			if (this.lidAngle < 0.5F && f2 >= 0.5F) {
				this.playSound(SoundEvents_CM.REIZOU_CLOSE);
			}

			if (this.lidAngle < 0.0F) {
				this.lidAngle = 0.0F;
			}
		}
	}

	public boolean isOpen() {
		return this.lidAngle != 0.0F;
	}
	
	/* タイルエンティを無効化 */
	public void invalidate() {
		super.invalidate();
		this.updateContainingBlockInfo();
	}

	/* GUIのID */
	public String getGuiID() {
		return ChinjufuMod.MOD_ID + ":reizou_45";
	}

	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		this.fillWithLoot(playerIn);
		return new ReizouMenu(playerInventory, this, playerIn);
	}

	protected NonNullList<ItemStack> getItems() {
		return this.chestContents;
	}
	
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate) {
		return oldState.getBlock() != newSate.getBlock();
	}
}