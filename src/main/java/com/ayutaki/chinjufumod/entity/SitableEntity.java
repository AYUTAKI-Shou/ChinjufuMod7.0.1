package com.ayutaki.chinjufumod.entity;

import java.util.List;

import com.ayutaki.chinjufumod.handler.EntityTypes_CM;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SitableEntity extends Entity {
	
	/* Used in 'register'. */
	public SitableEntity(EntityType<SitableEntity> type, Level worldIn) {
		super(type, worldIn);
	}
	
	public SitableEntity(Level worldIn) {
		super(EntityTypes_CM.SITABLE.get(), worldIn);
		this.noPhysics = true;
	}

	/* Used in 'create'. */
	private SitableEntity(Level worldIn, BlockPos pos, double yOffset) {
		this(worldIn);
		this.setPos(pos.getX() + 0.5D, pos.getY() + 0.23D + yOffset, pos.getZ() + 0.5D);
	}

	@SuppressWarnings("resource")
	@Override
	public void tick() {
		super.tick();

		if (!this.level().isClientSide) {
			if (this.getPassengers().isEmpty() || this.level().isEmptyBlock(this.blockPosition())) {
				this.remove(RemovalReason.DISCARDED);
				this.level().updateNeighbourForOutputSignal(blockPosition(), this.level().getBlockState(blockPosition()).getBlock());
			}
		}
	}

	@Override
	protected void defineSynchedData() {}

	@Override
	protected void readAdditionalSaveData(CompoundTag compound) {}

	@Override
	protected void addAdditionalSaveData(CompoundTag compound) {}

	@Override
	protected float ridingOffset(Entity entity) {
		return 0.0F;
	} // fix 20.2

	@Override
	protected boolean canRide(Entity entity) {
		return true;
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return new ClientboundAddEntityPacket(this);
	} // fix 20.2

	public static InteractionResult create(Level worldIn, BlockPos pos, double yOffset, Player player) {
		if(!worldIn.isClientSide()) {
			List<SitableEntity> seats = worldIn.getEntitiesOfClass(SitableEntity.class, new AABB(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 1.0, pos.getY() + 1.0, pos.getZ() + 1.0));
			
			if(seats.isEmpty()) {
				SitableEntity seat = new SitableEntity(worldIn, pos, yOffset);
				worldIn.addFreshEntity(seat);
				player.startRiding(seat, false);
			}
		}
		return InteractionResult.SUCCESS;
	}
	
	/* Position when stopping the ride. */
	@Override
	public Vec3 getDismountLocationForPassenger(LivingEntity entity) {
		Direction original = this.getMotionDirection();
		Direction[] offsets = {original, original.getClockWise(), original.getCounterClockWise(), original.getOpposite()};
		for(Direction dir : offsets) {
			Vec3 safeVec = DismountHelper.findSafeDismountLocation(entity.getType(), this.level(), this.blockPosition().relative(dir), false);
			if(safeVec != null) {
				return safeVec.add(0.0D, 0.25D, 0.0D);
			}
		}
		return super.getDismountLocationForPassenger(entity);
	}
}
