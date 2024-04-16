package com.ayutaki.chinjufumod.tileentity;

import com.ayutaki.chinjufumod.blocks.kitchen.Reizou;
import com.ayutaki.chinjufumod.handler.BlockEntity_CM;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestLidController;
import net.minecraft.world.level.block.entity.ContainerOpenersCounter;
import net.minecraft.world.level.block.entity.LidBlockEntity;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class Reizou_TileEntity extends RandomizableContainerBlockEntity implements LidBlockEntity {
	
	@SuppressWarnings("unused")
	private static final int EVENT_SET_OPEN_COUNT = 1;
	private NonNullList<ItemStack> items = NonNullList.withSize(45, ItemStack.EMPTY); //
	
	private final ContainerOpenersCounter openersCounter = new ContainerOpenersCounter() {
		protected void onOpen(Level worldIn, BlockPos pos, BlockState state) {
			Reizou_TileEntity.playSound(worldIn, pos, state, SoundEvents_CM.REIZOU_OPEN.get());
			worldIn.setBlock(pos, state.setValue(Reizou.OPEN, Boolean.valueOf(true)), 3);
		}

		protected void onClose(Level worldIn, BlockPos pos, BlockState state) {
			Reizou_TileEntity.playSound(worldIn, pos, state, SoundEvents_CM.REIZOU_CLOSE.get());
			worldIn.setBlock(pos, state.setValue(Reizou.OPEN, Boolean.valueOf(false)), 3);
		}

		protected void openerCountChanged(Level worldIn, BlockPos pos, BlockState state, int count, int openCount) {
			Reizou_TileEntity.this.signalOpenCount(worldIn, pos, state, count, openCount);
		}

		protected boolean isOwnContainer(Player playerIn) {
			return false;	}
	};
	
	private final ChestLidController chestLidController = new ChestLidController();

	protected Reizou_TileEntity(BlockEntityType<?> typeIn, BlockPos pos, BlockState state) {
		super(typeIn, pos, state);
	}

	public Reizou_TileEntity(BlockPos pos, BlockState state) {
		this(BlockEntity_CM.REIZOU.get(), pos, state);
	}

	public int getContainerSize() {
		return 45; //45
	}

	protected Component getDefaultName() {
		return Component.translatable("container.chest");
	}

	public void load(CompoundTag compound) {
		super.load(compound);
		this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
		if (!this.tryLoadLootTable(compound)) {
			ContainerHelper.loadAllItems(compound, this.items);
		}
	}

	protected void saveAdditional(CompoundTag compound) {
		super.saveAdditional(compound);
		if (!this.trySaveLootTable(compound)) {
			ContainerHelper.saveAllItems(compound, this.items);
		}
	}

	public static void lidAnimateTick(Level worldIn, BlockPos pos, BlockState state, Reizou_TileEntity tileEntity) {
		tileEntity.chestLidController.tickLid();
	}

	static void playSound(Level worldIn, BlockPos pos, BlockState state, SoundEvent sound) {
		double d0 = (double)pos.getX() + 0.5D;
		double d1 = (double)pos.getY() + 0.5D;
		double d2 = (double)pos.getZ() + 0.5D;

		worldIn.playSound((Player)null, d0, d1, d2, sound, SoundSource.BLOCKS, 0.5F, worldIn.random.nextFloat() * 0.1F + 0.9F);
	}

	public boolean triggerEvent(int id, int type) {
		if (id == 1) {
			this.chestLidController.shouldBeOpen(type > 0);
			return true;
		} else {
			return super.triggerEvent(id, type);
		}
	}

	public void startOpen(Player playerIn) {
		if (!this.remove && !playerIn.isSpectator()) {
			this.openersCounter.incrementOpeners(playerIn, this.getLevel(), this.getBlockPos(), this.getBlockState());
		}
	}

	public void stopOpen(Player playerIn) {
		if (!this.remove && !playerIn.isSpectator()) {
			this.openersCounter.decrementOpeners(playerIn, this.getLevel(), this.getBlockPos(), this.getBlockState());
		}
	}

	protected NonNullList<ItemStack> getItems() {
		return this.items;
	}

	protected void setItems(NonNullList<ItemStack> stack) {
		this.items = stack;
	}

	public float getOpenNess(float count) {
		return this.chestLidController.getOpenness(count);
	}

	public static int getOpenCount(BlockGetter worldIn, BlockPos pos) {
		BlockState state = worldIn.getBlockState(pos);
		if (state.hasBlockEntity()) {
			BlockEntity blockentity = worldIn.getBlockEntity(pos);
			if (blockentity instanceof Reizou_TileEntity) {
				return ((Reizou_TileEntity)blockentity).openersCounter.getOpenerCount();
			}
		}
		return 0;
	}

	public static void swapContents(Reizou_TileEntity tileEntity, Reizou_TileEntity otherTileEntity) {
		NonNullList<ItemStack> nonnulllist = tileEntity.getItems();
		tileEntity.setItems(otherTileEntity.getItems());
		otherTileEntity.setItems(nonnulllist);
	}

	protected AbstractContainerMenu createMenu(int id, Inventory inventory) {
		//return new TansuMenu(MenuTypes_CM.TANSU_MENU.get(), id, inventory, this); Stopped using it in 1.20.2. 
		return new ChestMenu(MenuType.GENERIC_9x5, id, inventory, this, 5);
	}

	private net.minecraftforge.common.util.LazyOptional<net.minecraftforge.items.IItemHandlerModifiable> chestHandler;
	
	@SuppressWarnings("deprecation")
	@Override
	public void setBlockState(BlockState state) {
		super.setBlockState(state);
		if (this.chestHandler != null) {
			net.minecraftforge.common.util.LazyOptional<?> oldHandler = this.chestHandler;
			this.chestHandler = null;
			oldHandler.invalidate();
		}
	}

	@Override
	public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(net.minecraftforge.common.capabilities.Capability<T> cap, Direction side) {
		 if (!this.remove && cap == net.minecraftforge.common.capabilities.ForgeCapabilities.ITEM_HANDLER) {
			 if (this.chestHandler == null)
				 this.chestHandler = net.minecraftforge.common.util.LazyOptional.of(this::createHandler);
			 return this.chestHandler.cast();
		 }
		 return super.getCapability(cap, side);
	}

	private net.minecraftforge.items.IItemHandlerModifiable createHandler() {
		BlockState state = this.getBlockState();
		if (!(state.getBlock() instanceof Reizou)) {
			return new net.minecraftforge.items.wrapper.InvWrapper(this);
		}
		Container inv = Reizou.getContainer((Reizou) state.getBlock(), state, getLevel(), getBlockPos(), true);
		return new net.minecraftforge.items.wrapper.InvWrapper(inv == null ? this : inv);
	}

	@Override
	public void invalidateCaps() {
		super.invalidateCaps();
		if (chestHandler != null) {
			chestHandler.invalidate();
			chestHandler = null;
		}
	}

	public void recheckOpen() {
		if (!this.remove) {
			this.openersCounter.recheckOpeners(this.getLevel(), this.getBlockPos(), this.getBlockState());
		}
	}

	protected void signalOpenCount(Level worldIn, BlockPos pos, BlockState state, int count, int openCount) {
		Block block = state.getBlock();
		worldIn.blockEvent(pos, block, 1, openCount);
	}
}
