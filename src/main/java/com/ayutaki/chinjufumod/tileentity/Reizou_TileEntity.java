package com.ayutaki.chinjufumod.tileentity;

import com.ayutaki.chinjufumod.blocks.kitchen.Reizou;
import com.ayutaki.chinjufumod.gui.ReizouMenu;
import com.ayutaki.chinjufumod.handler.MenuTypes_CM;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.handler.TileEntity_CM;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.IChestLid;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.LockableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(value = Dist.CLIENT, _interface = IChestLid.class)
public class Reizou_TileEntity extends LockableLootTileEntity implements IChestLid, ITickableTileEntity {

	private NonNullList<ItemStack> items = NonNullList.withSize(45, ItemStack.EMPTY);
	protected float openness;
	protected float oOpenness;
	protected int openCount;
	private int tickInterval;
	private net.minecraftforge.common.util.LazyOptional<net.minecraftforge.items.IItemHandlerModifiable> chestHandler;

	protected Reizou_TileEntity(TileEntityType<?> typeIn) {
		super(typeIn);
	}

	public Reizou_TileEntity() {
		this(TileEntity_CM.REIZOU);
	}

	public int getContainerSize() {
		return 45;
	}

	protected ITextComponent getDefaultName() {
		return new TranslationTextComponent("container.chest");
	}

	@Override
	public void load(BlockState state, CompoundNBT compound) {
		super.load(state, compound);
		this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
		if (!this.tryLoadLootTable(compound)) {
			ItemStackHelper.loadAllItems(compound, this.items);
		}
	}

	@Override
	public CompoundNBT save(CompoundNBT compound) {
		super.save(compound);
		if (!this.trySaveLootTable(compound)) {
			ItemStackHelper.saveAllItems(compound, this.items);
		}
		return compound;
	}

	public void tick() {
		int i = this.worldPosition.getX();
		int j = this.worldPosition.getY();
		int k = this.worldPosition.getZ();
		++this.tickInterval;
		this.openCount = getOpenCount(this.level, this, this.tickInterval, i, j, k, this.openCount);
		this.oOpenness = this.openness;
		//float f = 0.1F;
		if (this.openCount > 0 && this.openness == 0.0F) {
			this.level.setBlock(this.worldPosition, this.level.getBlockState(this.worldPosition).setValue(Reizou.OPEN, Boolean.valueOf(true)), 3);
			this.playSound(SoundEvents_CM.REIZOU_OPEN);
		}

		if (this.openCount == 0 && this.openness > 0.0F || this.openCount > 0 && this.openness < 1.0F) {
			float f1 = this.openness;
			if (this.openCount > 0) {
				this.openness += 0.1F;
			}
			else {
				this.openness -= 0.1F;
			}

			if (this.openness > 1.0F) {
				this.openness = 1.0F;
			}

			float f2 = 0.5F;
			if (this.openness < f2 && f1 >= f2) {
				this.level.setBlock(this.worldPosition, this.level.getBlockState(this.worldPosition).setValue(Reizou.OPEN, Boolean.valueOf(false)), 3);
				this.playSound(SoundEvents_CM.REIZOU_CLOSE);
			}
			
			if (this.openness < 0.0F) {
				this.openness = 0.0F;
				this.level.setBlock(this.worldPosition, this.level.getBlockState(this.worldPosition).setValue(Reizou.OPEN, Boolean.valueOf(false)), 3);
			}
		}
	}

	public static int getOpenCount(World worldIn, LockableTileEntity lTileEntity, int ticksSinceSync, int x, int y, int z, int numPlayerUsing) {
		if (!worldIn.isClientSide && numPlayerUsing != 0 && (ticksSinceSync + x + y + z) % 200 == 0) {
			numPlayerUsing = getOpenCount(worldIn, lTileEntity, x, y, z);
		}
		return numPlayerUsing;
	}

	/* ChestContainer -> ReizouMenu */
	public static int getOpenCount(World worldIn, LockableTileEntity lTileEntity, int x, int y, int z) {
		int i = 0;
		float f = 5.0F;

		for(PlayerEntity playerIn : worldIn.getEntitiesOfClass(PlayerEntity.class, new AxisAlignedBB((double)((float)x - f), (double)((float)y - f), (double)((float)z - f), (double)((float)(x + 1) + f), (double)((float)(y + 1) + f), (double)((float)(z + 1) + f)))) {
			if (playerIn.containerMenu instanceof ReizouMenu) {
				IInventory iinventory = ((ReizouMenu)playerIn.containerMenu).getContainer();
				if (iinventory == lTileEntity) {
					++i;
				}
			}
		}
		return i;
	}

	private void playSound(SoundEvent sound) {
		double d0 = (double)this.worldPosition.getX() + 0.5D;
		double d1 = (double)this.worldPosition.getY() + 0.5D;
		double d2 = (double)this.worldPosition.getZ() + 0.5D;

		this.level.playSound((PlayerEntity)null, d0, d1, d2, sound, SoundCategory.BLOCKS, 0.5F, this.level.random.nextFloat() * 0.1F + 0.9F);
	}

	@Override
	public boolean triggerEvent(int id, int type) {
		if (id == 1) {
			this.openCount = type;
			return true;
		} 
		else {
			return super.triggerEvent(id, type);
		}
	}

	@Override
	public void startOpen(PlayerEntity playerIn) {
		if (!playerIn.isSpectator()) {
			if (this.openCount < 0) {
				this.openCount = 0;
			}
			++this.openCount;
			this.signalOpenCount();
		}
	}

	public void stopOpen(PlayerEntity playerIn) {
		if (!playerIn.isSpectator()) {
			--this.openCount;
			this.signalOpenCount();
		}
	}

	protected void signalOpenCount() {
		Block block = this.getBlockState().getBlock();
		if (block instanceof Reizou) {
			this.level.blockEvent(this.worldPosition, block, 1, this.openCount);
			this.level.updateNeighborsAt(this.worldPosition, block);
		}
	}

	protected NonNullList<ItemStack> getItems() {
		return this.items;
	}

	protected void setItems(NonNullList<ItemStack> stack) {
		this.items = stack;
	}

	@OnlyIn(Dist.CLIENT)
	public float getOpenNess(float count) {
		return MathHelper.lerp(count, this.oOpenness, this.openness);
	}

	public static int getOpenCount(IBlockReader worldIn, BlockPos pos) {
		BlockState state = worldIn.getBlockState(pos);
		if (state.hasTileEntity()) {
			TileEntity tileentity = worldIn.getBlockEntity(pos);
			if (tileentity instanceof Reizou_TileEntity) {
				return ((Reizou_TileEntity)tileentity).openCount;
			}
		}
		return 0;
	}

	public static void swapContents(Reizou_TileEntity tileEntity, Reizou_TileEntity otherTileEntity) {
		NonNullList<ItemStack> nonnulllist = tileEntity.getItems();
		tileEntity.setItems(otherTileEntity.getItems());
		otherTileEntity.setItems(nonnulllist);
	}

	protected Container createMenu(int id, PlayerInventory inventory) {
		return new ReizouMenu(MenuTypes_CM.REIZOU_MENU.get(), id, inventory, this);
		//return ChestContainer.threeRows(count, inventory);
	}

	@Override
	public void clearCache() {
		super.clearCache();
		if (this.chestHandler != null) {
			net.minecraftforge.common.util.LazyOptional<?> oldHandler = this.chestHandler;
			this.chestHandler = null;
			oldHandler.invalidate();
		}
	}

	@Override
	public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(net.minecraftforge.common.capabilities.Capability<T> cap, Direction side) {
		 if (!this.remove && cap == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			 if (this.chestHandler == null)
				 this.chestHandler = net.minecraftforge.common.util.LazyOptional.of(this::createHandler);
			 return this.chestHandler.cast();
		 }
		 return super.getCapability(cap, side);
	}

	////////////////////////
	private net.minecraftforge.items.IItemHandlerModifiable createHandler() {
		BlockState state = this.getBlockState();
		if (!(state.getBlock() instanceof Reizou)) {
			return new net.minecraftforge.items.wrapper.InvWrapper(this);
		}
		IInventory inv = Reizou.getContainer((Reizou) state.getBlock(), state, getLevel(), getBlockPos(), true);
		return new net.minecraftforge.items.wrapper.InvWrapper(inv == null ? this : inv);
	}

	@Override
	protected void invalidateCaps() {
		super.invalidateCaps();
		if (chestHandler != null)
		 chestHandler.invalidate();
	}

}
