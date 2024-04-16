package com.ayutaki.chinjufumod.entity.helper;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Objects;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.Vector4f;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Vector3 {

	public static final Vector3 ZERO = new Vector3(0, 0, 0);
	public static final Vector3 ONE = new Vector3(1, 1, 1);
	public static final Vector3 CENTER = new Vector3(0.5, 0.5, 0.5);

	public final double x;
	public final double y;
	public final double z;

	public Vector3(double d, double d1, double d2) {
		x = d;
		y = d1;
		z = d2;
	}

	public Vector3(Vec3d vec) {
		this(vec.x, vec.y, vec.z);
	}

	public static Vector3 fromBlockPos(BlockPos pos) {
		return new Vector3(pos.getX(), pos.getY(), pos.getZ());
	}

	public static Vector3 fromEntity(Entity entity) {
		return new Vector3(entity.getPosX(), entity.getPosY(), entity.getPosZ());
	}

	public static Vector3 fromEntityCenter(Entity entity) {
		return new Vector3(entity.getPosX(), entity.getPosY() - entity.getYOffset() + entity.getHeight() / 2, entity.getPosZ());
	}

	public static Vector3 fromTileEntity(TileEntity entity) {
		return fromBlockPos(entity.getPos());
	}

	public static Vector3 fromTileEntityCenter(TileEntity entity) {
		return fromTileEntity(entity).add(0.5);
	}

	public double dotProduct(Vector3 vec) {
		double d = vec.x * x + vec.y * y + vec.z * z;

		if (d > 1 && d < 1.00001) {
			d = 1;
		} else if (d < -1 && d > -1.00001) {
			d = -1;
		}
		return d;
	}

	public double dotProduct(double d, double d1, double d2) {
		return d * x + d1 * y + d2 * z;
	}

	public Vector3 crossProduct(Vector3 vec) {
		double d = y * vec.z - z * vec.y;
		double d1 = z * vec.x - x * vec.z;
		double d2 = x * vec.y - y * vec.x;
		return new Vector3(d, d1, d2);
	}

	public Vector3 add(double d, double d1, double d2) {
		return new Vector3(x + d, y + d1, z + d2);
	}

	public Vector3 add(Vector3 vec) {
		return add(vec.x, vec.y, vec.z);
	}

	public Vector3 add(double d) {
		return add(d, d, d);
	}

	public Vector3 subtract(Vector3 vec) {
		return new Vector3(x - vec.x, y - vec.y, z - vec.z);
	}

	public Vector3 multiply(double d) {
		return multiply(d, d, d);
	}

	public Vector3 multiply(Vector3 f) {
		return multiply(f.x, f.y, f.z);
	}

	public Vector3 multiply(double fx, double fy, double fz) {
		return new Vector3(x * fx, y * fy, z * fz);
	}

	public double mag() {
		return Math.sqrt(x * x + y * y + z * z);
	}

	public double magSquared() {
		return x * x + y * y + z * z;
	}

	public Vector3 normalize() {
		double d = mag();
		if (d != 0) {
			return multiply(1 / d);
		}
		return this;
	}

	@Override
	public String toString() {
		MathContext cont = new MathContext(4, RoundingMode.HALF_UP);
		return "Vector3(" + new BigDecimal(x, cont) + ", " + new BigDecimal(y, cont) + ", " + new BigDecimal(z, cont) + ")";
	}

	public Vector3 perpendicular() {
		if (z == 0) {
			return zCrossProduct();
		}
		return xCrossProduct();
	}

	public Vector3 xCrossProduct() {
		double d = z;
		double d1 = -y;
		return new Vector3(0, d, d1);
	}

	public Vector3 zCrossProduct() {
		double d = y;
		double d1 = -x;
		return new Vector3(d, d1, 0);
	}

	public Vector3 yCrossProduct() {
		double d = -z;
		double d1 = x;
		return new Vector3(d, 0, d1);
	}

	public Vec3d toVec3D() {
		return new Vec3d(x, y, z);
	}

	public double angle(Vector3 vec) {
		return Math.acos(normalize().dotProduct(vec.normalize()));
	}

	public boolean isInside(AxisAlignedBB aabb) {
		return x >= aabb.minX && y >= aabb.maxY && z >= aabb.minZ && x < aabb.maxX && y < aabb.maxY && z < aabb.maxZ;
	}

	public boolean isZero() {
		return x == 0 && y == 0 && z == 0;
	}

	public boolean isAxial() {
		return x == 0 ? y == 0 || z == 0 : y == 0 && z == 0;
	}

	@OnlyIn(Dist.CLIENT)
	public Vector3f vector3f() {
		return new Vector3f((float) x, (float) y, (float) z);
	}

	@OnlyIn(Dist.CLIENT)
	public Vector4f vector4f() {
		return new Vector4f((float) x, (float) y, (float) z, 1);
	}

	@OnlyIn(Dist.CLIENT)
	public void glVertex() {
		GL11.glVertex3d(x, y, z);
	}

	public Vector3 negate() {
		return new Vector3(-x, -y, -z);
	}

	public double scalarProject(Vector3 vec) {
		double l = vec.mag();
		return l == 0 ? 0 : dotProduct(vec) / l;
	}

	public Vector3 project(Vector3 vec) {
		double l = vec.magSquared();
		if (l == 0) {
			return ZERO;
		}

		double m = dotProduct(vec) / l;
		return vec.multiply(m);
	}

	public Vector3 rotate(double angle, Vector3 axis) {
		return Quat.aroundAxis(axis.normalize(), angle).rotate(this);
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Vector3)) {
			return false;
		}

		Vector3 vec = (Vector3) object;
		return x == vec.x && y == vec.y && z == vec.z;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y, z);
	}

}
