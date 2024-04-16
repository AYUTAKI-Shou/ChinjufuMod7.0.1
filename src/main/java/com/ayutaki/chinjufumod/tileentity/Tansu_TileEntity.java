package com.ayutaki.chinjufumod.tileentity;

import com.ayutaki.chinjufumod.blocks.furniture.Tansu;
import com.ayutaki.chinjufumod.gui.TansuMenu;
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
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.wrapper.InvWrapper;

public class Tansu_TileEntity extends LockableLootTileEntity implements ITickableTileEntity {

	private NonNullList<ItemStack> chestContents = NonNullList.withSize(45, ItemStack.EMPTY);
	protected float lidAngle;
	protected float prevLidAngle;
	private int ticksSinceSync;
	protected int numPlayersUsing;
	private net.minecraftforge.common.util.LazyOptional<net.minecraftforge.items.IItemHandlerModifiable> chestHandler;

	public Tansu_TileEntity(TileEntityType<?> typeIn) {
		super(typeIn);
	}

	public Tansu_TileEntity() {
		this(TileEntity_CM.TANSU);
	}

	/* インベントリ数 */
	@Override
	public int getSizeInventory() {
		return 45;
	}

	/* GUI */
	@Override
	protected ITextComponent getDefaultName() {
		return new TranslationTextComponent("container.chest");
	}

	protected Container createMenu(int id, PlayerInventory inventory) {
		return new TansuMenu(MenuTypes_CM.TANSU_MENU.get(), id, inventory, this);
		//return ChestContainer.createGeneric9X3(id, inventory, this);
	}

	/* 収納したアイテムの処理 */
	@Override
	public NonNullList<ItemStack> getItems() {
		return this.chestContents;
	}

	@Override
	public void setItems(NonNullList<ItemStack> itemsIn) {
		this.chestContents = itemsIn;
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		super.write(compound);
		if (!this.checkLootAndWrite(compound)) {
			ItemStackHelper.saveAllItems(compound, this.chestContents);
		}
		return compound;
	}

	@Override
	public void read(CompoundNBT compound) {
		super.read(compound);
		this.chestContents = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
		if (!this.checkLootAndRead(compound)) {
			ItemStackHelper.loadAllItems(compound, this.chestContents);
		}
	}

	/* 効果音 ITickableTileEntity */
	public void tick() {
		int i = this.pos.getX();
		int j = this.pos.getY();
		int k = this.pos.getZ();
		++this.ticksSinceSync;
		this.numPlayersUsing = calculatePlayersUsingSync(this.world, this, this.ticksSinceSync, i, j, k, this.numPlayersUsing);
		this.prevLidAngle = this.lidAngle;

		if (this.numPlayersUsing > 0 && this.lidAngle == 0.0F) {
			this.world.setBlockState(this.pos, this.world.getBlockState(this.pos).with(Tansu.OPEN, Boolean.valueOf(true)), 3);
			this.playSound(SoundEvents_CM.TANSU_OPEN);
		}

		if (this.numPlayersUsing == 0 && this.lidAngle > 0.0F || this.numPlayersUsing > 0 && this.lidAngle < 1.0F) {
			float f1 = this.lidAngle;
			if (this.numPlayersUsing > 0) {
				this.lidAngle += 0.1F;
			} else {
				this.lidAngle -= 0.1F;
			}

			if (this.lidAngle > 1.0F) {
				this.lidAngle = 1.0F;
			}

			if (this.lidAngle < 0.5F && f1 >= 0.5F) {
				this.world.setBlockState(this.pos, this.world.getBlockState(this.pos).with(Tansu.OPEN, Boolean.valueOf(false)), 3);
				this.playSound(SoundEvents_CM.TANSU_CLOSE);
			}

			if (this.lidAngle < 0.0F) {
				this.lidAngle = 0.0F;
				this.world.setBlockState(this.pos, this.world.getBlockState(this.pos).with(Tansu.OPEN, Boolean.valueOf(false)), 3);
			}
		}
	}

	public static int calculatePlayersUsingSync(World worldIn, LockableTileEntity lTileEntity, int ticksSinceSync, int x, int y, int z, int numPlayerUsing) {
		if (!worldIn.isRemote && numPlayerUsing != 0 && (ticksSinceSync + x + y + z) % 200 == 0) {
			numPlayerUsing = calculatePlayersUsing(worldIn, lTileEntity, x, y, z);
		}
		return numPlayerUsing;
	}

	public static int calculatePlayersUsing(World worldIn, LockableTileEntity lTileEntity, int x, int y, int z) {
		int i = 0;

		for(PlayerEntity playerIn : worldIn.getEntitiesWithinAABB(PlayerEntity.class, new AxisAlignedBB((double)((float)x - 5.0F), (double)((float)y - 5.0F), (double)((float)z - 5.0F), (double)((float)(x + 1) + 5.0F), (double)((float)(y + 1) + 5.0F), (double)((float)(z + 1) + 5.0F)))) {
			if (playerIn.openContainer instanceof TansuMenu) {
				IInventory iinventory = ((TansuMenu)playerIn.openContainer).getLowerChestInventory();
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
		this.world.playSound((PlayerEntity) null, dx, dy, dz, sound, SoundCategory.BLOCKS, 1.0F, 1.0F);
	}

	@Override
	public boolean receiveClientEvent(int id, int type) {
		if (id == 1) {
			this.numPlayersUsing = type;
			return true;
		} else {
			return super.receiveClientEvent(id, type);
		}
	}

	@Override
	public void openInventory(PlayerEntity playerIn) {
		if (!playerIn.isSpectator()) {
			if (this.numPlayersUsing < 0) {
				this.numPlayersUsing = 0;
			}

			++this.numPlayersUsing;
			this.onOpenOrClose();
		}
	}

	@Override
	public void closeInventory(PlayerEntity playerIn) {
		if (!playerIn.isSpectator()) {
			--this.numPlayersUsing;
			this.onOpenOrClose();
		}
	}

	protected void onOpenOrClose() {
		Block block = this.getBlockState().getBlock();
		if (block instanceof Tansu) {
			this.world.addBlockEvent(this.pos, block, 1, this.numPlayersUsing);
			this.world.notifyNeighborsOfStateChange(this.pos, block);
		}
	}

	@OnlyIn(Dist.CLIENT)
	public float getLidAngle(float partialTicks) {
		return MathHelper.lerp(partialTicks, this.prevLidAngle, this.lidAngle);
	}

	public static int getPlayersUsing(IBlockReader reader, BlockPos pos) {
		BlockState state = reader.getBlockState(pos);
		if (state.hasTileEntity()) {
			TileEntity tileentity = reader.getTileEntity(pos);
			if (tileentity instanceof Tansu_TileEntity) {
				return ((Tansu_TileEntity) tileentity).numPlayersUsing;
			}
		}
		return 0;
	}

	public static void swapContents(Tansu_TileEntity te, Tansu_TileEntity otherTe) {
		NonNullList<ItemStack> list = te.getItems();
		te.setItems(otherTe.getItems());
		otherTe.setItems(list);
	}

	@Override
	public void updateContainingBlockInfo() {
		super.updateContainingBlockInfo();
		if (this.chestHandler != null) {
			this.chestHandler.invalidate();
			this.chestHandler = null;
		}
	}

	@Override
	public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(net.minecraftforge.common.capabilities.Capability<T> cap, Direction side) {
		if (!this.removed && cap == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			if (this.chestHandler == null)
				this.chestHandler = net.minecraftforge.common.util.LazyOptional.of(this::createHandler);
			return this.chestHandler.cast();
		}
		return super.getCapability(cap, side);
	}

	private IItemHandlerModifiable createHandler() {
		return new InvWrapper(this);
	}

	@Override
	public void remove() {
		super.remove();
		if (chestHandler != null)
			chestHandler.invalidate();
	}

}
