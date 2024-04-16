package com.ayutaki.chinjufumod.world.biome;

import java.util.List;
import java.util.function.Consumer;

import com.mojang.datafixers.util.Pair;

import net.minecraft.SharedConstants;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.registries.VanillaRegistries;
import net.minecraft.data.worldgen.TerrainProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.CubicSpline;
import net.minecraft.util.ToFloatFunction;
import net.minecraft.util.VisibleForDebug;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.DensityFunctions;
import net.minecraft.world.level.levelgen.NoiseRouterData;

// net.minecraft.world.level.biome.OverworldBiome_Builder
public class BiomeBuilder_unUsed {
	@SuppressWarnings("unused")
	private static final float VALLEY_SIZE = 0.05F;
	@SuppressWarnings("unused")
	private static final float LOW_START = 0.26666668F;
	public static final float HIGH_START = 0.4F;
	@SuppressWarnings("unused")
	private static final float HIGH_END = 0.93333334F;
	@SuppressWarnings("unused")
	private static final float PEAK_SIZE = 0.1F;
	public static final float PEAK_START = 0.56666666F;
	@SuppressWarnings("unused")
	private static final float PEAK_END = 0.7666667F;
	public static final float NEAR_INLAND_START = -0.11F;
	public static final float MID_INLAND_START = 0.03F;
	public static final float FAR_INLAND_START = 0.3F;
	public static final float EROSION_INDEX_1_START = -0.78F;
	public static final float EROSION_INDEX_2_START = -0.375F;
	@SuppressWarnings("unused")
	private static final float EROSION_DEEP_DARK_DRYNESS_THRESHOLD = -0.225F;
	@SuppressWarnings("unused")
	private static final float DEPTH_DEEP_DARK_DRYNESS_THRESHOLD = 0.9F;
	private final Climate.Parameter FULL_RANGE = Climate.Parameter.span(-1.0F, 1.0F);
	private final Climate.Parameter[] temperatures = new Climate.Parameter[]{Climate.Parameter.span(-1.0F, -0.45F), Climate.Parameter.span(-0.45F, -0.15F), Climate.Parameter.span(-0.15F, 0.2F), Climate.Parameter.span(0.2F, 0.55F), Climate.Parameter.span(0.55F, 1.0F)};
	private final Climate.Parameter[] humidities = new Climate.Parameter[]{Climate.Parameter.span(-1.0F, -0.35F), Climate.Parameter.span(-0.35F, -0.1F), Climate.Parameter.span(-0.1F, 0.1F), Climate.Parameter.span(0.1F, 0.3F), Climate.Parameter.span(0.3F, 1.0F)};
	private final Climate.Parameter[] erosions = new Climate.Parameter[]{Climate.Parameter.span(-1.0F, -0.78F), Climate.Parameter.span(-0.78F, -0.375F), Climate.Parameter.span(-0.375F, -0.2225F), Climate.Parameter.span(-0.2225F, 0.05F), Climate.Parameter.span(0.05F, 0.45F), Climate.Parameter.span(0.45F, 0.55F), Climate.Parameter.span(0.55F, 1.0F)};
	private final Climate.Parameter FROZEN_RANGE = this.temperatures[0];
	private final Climate.Parameter UNFROZEN_RANGE = Climate.Parameter.span(this.temperatures[1], this.temperatures[4]);
	private final Climate.Parameter mushroomFieldsContinentalness = Climate.Parameter.span(-1.2F, -1.05F);
	private final Climate.Parameter deepOceanContinentalness = Climate.Parameter.span(-1.05F, -0.455F);
	private final Climate.Parameter oceanContinentalness = Climate.Parameter.span(-0.455F, -0.19F);
	private final Climate.Parameter coastContinentalness = Climate.Parameter.span(-0.19F, -0.11F);
	private final Climate.Parameter inlandContinentalness = Climate.Parameter.span(-0.11F, 0.55F);
	private final Climate.Parameter nearInlandContinentalness = Climate.Parameter.span(-0.11F, 0.03F);
	private final Climate.Parameter midInlandContinentalness = Climate.Parameter.span(0.03F, 0.3F);
	private final Climate.Parameter farInlandContinentalness = Climate.Parameter.span(0.3F, 1.0F);
	
	/* private final ResourceKey<Biome>[][] OCEANS = new ResourceKey[][]{
		{Biomes.DEEP_FROZEN_OCEAN, Biomes.DEEP_COLD_OCEAN, Biomes.DEEP_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.WARM_OCEAN}, 
		{Biomes.FROZEN_OCEAN, Biomes.COLD_OCEAN, Biomes.OCEAN, Biomes.LUKEWARM_OCEAN, Biomes.WARM_OCEAN} }; */

	@SuppressWarnings("unchecked")
	private final ResourceKey<Biome>[][] MIDDLE_BIOMES = new ResourceKey[][]{
		{null, null, null, null, null}, 
		{null, null, BiomeKey_CM.KAEDE_HILLS_KEY, BiomeKey_CM.ICHOH_HILLS_KEY, null}, 
		{BiomeKey_CM.SAKURA_FOREST_KEY, BiomeKey_CM.SAKURA_HILLS_KEY, BiomeKey_CM.KAEDE_FOREST_KEY, BiomeKey_CM.ICHOH_FOREST_KEY, null}, 
		{null, null, null, null, null}, 
		{null, null, null, null, null} };

	@SuppressWarnings("unchecked")
	private final ResourceKey<Biome>[][] MIDDLE_BIOMES_VARIANT = new ResourceKey[][]{
		{null, null, null, null, null}, 
		{null, null, null, null, null}, 
		{BiomeKey_CM.SAKURA_FOREST_KEY, null, BiomeKey_CM.KAEDE_FOREST_KEY, BiomeKey_CM.ICHOH_FOREST_KEY, null}, 
		{null, null, null, null, null}, 
		{null, null, null, null, null} };
		
	@SuppressWarnings("unchecked")
	private final ResourceKey<Biome>[][] PLATEAU_BIOMES = new ResourceKey[][]{
		{null, null, null, null, null}, 
		{null, null, BiomeKey_CM.KAEDE_FOREST_KEY, BiomeKey_CM.ICHOH_FOREST_KEY, null},
		{BiomeKey_CM.SAKURA_FOREST_KEY, null, BiomeKey_CM.KAEDE_FOREST_KEY, BiomeKey_CM.ICHOH_FOREST_KEY, null}, 
		{null, null, null, BiomeKey_CM.SAKURA_FOREST_KEY, null}, 
		{null, null, null, null, null} };
		
	@SuppressWarnings("unchecked")
	private final ResourceKey<Biome>[][] PLATEAU_BIOMES_VARIANT = new ResourceKey[][]{
		{null, null, null, null, null}, 
		{null, null, null, null, null}, 
		{BiomeKey_CM.SAKURA_FOREST_KEY, null, BiomeKey_CM.KAEDE_FOREST_KEY, BiomeKey_CM.ICHOH_FOREST_KEY, null}, 
		{null, null, null, null, null}, 
		{null, null, null, null, null} };
		
		/* private final ResourceKey<Biome>[][] SHATTERED_BIOMES = new ResourceKey[][]{
		{Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST}, 
		{Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST}, 
		{Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST}, 
		{null, null, null, null, null}, 
		{null, null, null, null, null} }; */

	public List<Climate.ParameterPoint> spawnTarget() {
		Climate.Parameter temp = Climate.Parameter.point(0.0F);
		//float f = 0.16F;
		return List.of(new Climate.ParameterPoint(this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.FULL_RANGE), this.FULL_RANGE, temp, Climate.Parameter.span(-1.0F, -0.16F), 0L), new Climate.ParameterPoint(this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.FULL_RANGE), this.FULL_RANGE, temp, Climate.Parameter.span(0.16F, 1.0F), 0L));
	}

	protected void addBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> biomeKey) {
		if (SharedConstants.debugGenerateSquareTerrainWithoutNoise) {
			this.addDebugBiomes(biomeKey); } 
		
		else {
			// this.addOffCoastBiomes(biomeKey);
			this.addInlandBiomes(biomeKey);
			this.addUndergroundBiomes(biomeKey); }
	}

	private void addDebugBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> biomeKey) {
		HolderLookup.Provider lookUp = VanillaRegistries.createLookup();
		HolderGetter<DensityFunction> density = lookUp.lookupOrThrow(Registries.DENSITY_FUNCTION);
		DensityFunctions.Spline.Coordinate coordinate = new DensityFunctions.Spline.Coordinate(density.getOrThrow(NoiseRouterData.CONTINENTS));
		DensityFunctions.Spline.Coordinate coordinate1 = new DensityFunctions.Spline.Coordinate(density.getOrThrow(NoiseRouterData.EROSION));
		DensityFunctions.Spline.Coordinate coordinate2 = new DensityFunctions.Spline.Coordinate(density.getOrThrow(NoiseRouterData.RIDGES_FOLDED));
		biomeKey.accept(Pair.of(Climate.parameters(this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.point(0.0F), this.FULL_RANGE, 0.01F), Biomes.PLAINS));
		CubicSpline<?, ?> cubicspline = TerrainProvider.buildErosionOffsetSpline(coordinate1, coordinate2, -0.15F, 0.0F, 0.0F, 0.1F, 0.0F, -0.03F, false, false, ToFloatFunction.IDENTITY);
		if (cubicspline instanceof CubicSpline.Multipoint<?, ?> multipoint) {
			ResourceKey<Biome> resourcekey = Biomes.DESERT;

			for(float f : multipoint.locations()) {
				biomeKey.accept(Pair.of(Climate.parameters(this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.point(f), Climate.Parameter.point(0.0F), this.FULL_RANGE, 0.0F), resourcekey));
				resourcekey = resourcekey == Biomes.DESERT ? Biomes.BADLANDS : Biomes.DESERT;
			}
		}

		CubicSpline<?, ?> cubicspline1 = TerrainProvider.overworldOffset(coordinate, coordinate1, coordinate2, false);
		if (cubicspline1 instanceof CubicSpline.Multipoint<?, ?> multipoint1) {
			for(float f1 : multipoint1.locations()) {
				biomeKey.accept(Pair.of(Climate.parameters(this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.point(f1), this.FULL_RANGE, Climate.Parameter.point(0.0F), this.FULL_RANGE, 0.0F), Biomes.SNOWY_TAIGA));
			}
		}
	}

	/*private void addOffCoastBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> biomeKey) {
		this.addSurfaceBiome(biomeKey, this.FULL_RANGE, this.FULL_RANGE, this.mushroomFieldsContinentalness, this.FULL_RANGE, this.FULL_RANGE, 0.0F, Biomes.MUSHROOM_FIELDS);

		for(int i = 0; i < this.temperatures.length; ++i) {
			Climate.Parameter temp = this.temperatures[i];
			this.addSurfaceBiome(biomeKey, temp, this.FULL_RANGE, this.deepOceanContinentalness, this.FULL_RANGE, this.FULL_RANGE, 0.0F, this.OCEANS[0][i]);
			this.addSurfaceBiome(biomeKey, temp, this.FULL_RANGE, this.oceanContinentalness, this.FULL_RANGE, this.FULL_RANGE, 0.0F, this.OCEANS[1][i]);
		}
	} */

	private void addInlandBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> biomeKey) {
		this.addMidSlice(biomeKey, Climate.Parameter.span(-1.0F, -0.93333334F));
		this.addHighSlice(biomeKey, Climate.Parameter.span(-0.93333334F, -0.7666667F));
		this.addPeaks(biomeKey, Climate.Parameter.span(-0.7666667F, -0.56666666F));
		this.addHighSlice(biomeKey, Climate.Parameter.span(-0.56666666F, -0.4F));
		this.addMidSlice(biomeKey, Climate.Parameter.span(-0.4F, -0.26666668F));
		this.addLowSlice(biomeKey, Climate.Parameter.span(-0.26666668F, -0.05F));
		this.addValleys(biomeKey, Climate.Parameter.span(-0.05F, 0.05F));
		this.addLowSlice(biomeKey, Climate.Parameter.span(0.05F, 0.26666668F));
		this.addMidSlice(biomeKey, Climate.Parameter.span(0.26666668F, 0.4F));
		this.addHighSlice(biomeKey, Climate.Parameter.span(0.4F, 0.56666666F));
		this.addPeaks(biomeKey, Climate.Parameter.span(0.56666666F, 0.7666667F));
		this.addHighSlice(biomeKey, Climate.Parameter.span(0.7666667F, 0.93333334F));
		this.addMidSlice(biomeKey, Climate.Parameter.span(0.93333334F, 1.0F));
	}

	private void addPeaks(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> biomeKey, Climate.Parameter par) {
		for(int i = 0; i < this.temperatures.length; ++i) {
			Climate.Parameter temp = this.temperatures[i];

			for(int j = 0; j < this.humidities.length; ++j) {
				Climate.Parameter moisture = this.humidities[j];
				ResourceKey<Biome> resourcekey = this.pickMiddleBiome(i, j, par);
				ResourceKey<Biome> resourcekey1 = this.pickMiddleBiomeOrBadlandsIfHot(i, j, par);
				ResourceKey<Biome> resourcekey2 = this.pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(i, j, par);
				ResourceKey<Biome> resourcekey3 = this.pickPlateauBiome(i, j, par);
				// ResourceKey<Biome> resourcekey4 = this.pickShatteredBiome(i, j, par);
				// ResourceKey<Biome> resourcekey5 = this.maybePickWindsweptSavannaBiome(i, j, par, resourcekey4);
				ResourceKey<Biome> resourcekey6 = this.pickPeakBiome(i, j, par);
				this.addSurfaceBiome(biomeKey, temp, moisture, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[0], par, 0.0F, resourcekey6);
				this.addSurfaceBiome(biomeKey, temp, moisture, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[1], par, 0.0F, resourcekey2);
				this.addSurfaceBiome(biomeKey, temp, moisture, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[1], par, 0.0F, resourcekey6);
				this.addSurfaceBiome(biomeKey, temp, moisture, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[3]), par, 0.0F, resourcekey);
				this.addSurfaceBiome(biomeKey, temp, moisture, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[2], par, 0.0F, resourcekey3);
				this.addSurfaceBiome(biomeKey, temp, moisture, this.midInlandContinentalness, this.erosions[3], par, 0.0F, resourcekey1);
				this.addSurfaceBiome(biomeKey, temp, moisture, this.farInlandContinentalness, this.erosions[3], par, 0.0F, resourcekey3);
				this.addSurfaceBiome(biomeKey, temp, moisture, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[4], par, 0.0F, resourcekey);
				// this.addSurfaceBiome(biomeKey, temp, moisture, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[5], par, 0.0F, resourcekey5);
				// this.addSurfaceBiome(biomeKey, temp, moisture, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], par, 0.0F, resourcekey4);
				this.addSurfaceBiome(biomeKey, temp, moisture, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[6], par, 0.0F, resourcekey);
			}
		}
	}

	private void addHighSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> biomeKey, Climate.Parameter par) {
		for(int i = 0; i < this.temperatures.length; ++i) {
			Climate.Parameter temp = this.temperatures[i];

			for(int j = 0; j < this.humidities.length; ++j) {
				Climate.Parameter moisture = this.humidities[j];
				ResourceKey<Biome> resourcekey = this.pickMiddleBiome(i, j, par);
				ResourceKey<Biome> resourcekey1 = this.pickMiddleBiomeOrBadlandsIfHot(i, j, par);
				ResourceKey<Biome> resourcekey2 = this.pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(i, j, par);
				ResourceKey<Biome> resourcekey3 = this.pickPlateauBiome(i, j, par);
				// ResourceKey<Biome> resourcekey4 = this.pickShatteredBiome(i, j, par);
				ResourceKey<Biome> resourcekey5 = this.maybePickWindsweptSavannaBiome(i, j, par, resourcekey);
				ResourceKey<Biome> resourcekey6 = this.pickSlopeBiome(i, j, par);
				ResourceKey<Biome> resourcekey7 = this.pickPeakBiome(i, j, par);
				this.addSurfaceBiome(biomeKey, temp, moisture, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), par, 0.0F, resourcekey);
				this.addSurfaceBiome(biomeKey, temp, moisture, this.nearInlandContinentalness, this.erosions[0], par, 0.0F, resourcekey6);
				this.addSurfaceBiome(biomeKey, temp, moisture, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[0], par, 0.0F, resourcekey7);
				this.addSurfaceBiome(biomeKey, temp, moisture, this.nearInlandContinentalness, this.erosions[1], par, 0.0F, resourcekey2);
				this.addSurfaceBiome(biomeKey, temp, moisture, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[1], par, 0.0F, resourcekey6);
				this.addSurfaceBiome(biomeKey, temp, moisture, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[3]), par, 0.0F, resourcekey);
				this.addSurfaceBiome(biomeKey, temp, moisture, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[2], par, 0.0F, resourcekey3);
				this.addSurfaceBiome(biomeKey, temp, moisture, this.midInlandContinentalness, this.erosions[3], par, 0.0F, resourcekey1);
				this.addSurfaceBiome(biomeKey, temp, moisture, this.farInlandContinentalness, this.erosions[3], par, 0.0F, resourcekey3);
				this.addSurfaceBiome(biomeKey, temp, moisture, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[4], par, 0.0F, resourcekey);
				this.addSurfaceBiome(biomeKey, temp, moisture, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[5], par, 0.0F, resourcekey5);
				// this.addSurfaceBiome(biomeKey, temp, moisture, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], par, 0.0F, resourcekey4);
				this.addSurfaceBiome(biomeKey, temp, moisture, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[6], par, 0.0F, resourcekey);
			}
		}
	}

	private void addMidSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> biomeKey, Climate.Parameter par) {
		this.addSurfaceBiome(biomeKey, this.FULL_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[2]), par, 0.0F, Biomes.STONY_SHORE);
		this.addSurfaceBiome(biomeKey, Climate.Parameter.span(this.temperatures[1], this.temperatures[2]), this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], par, 0.0F, Biomes.SWAMP);
		this.addSurfaceBiome(biomeKey, Climate.Parameter.span(this.temperatures[3], this.temperatures[4]), this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], par, 0.0F, Biomes.MANGROVE_SWAMP);

		for(int i = 0; i < this.temperatures.length; ++i) {
			Climate.Parameter temp = this.temperatures[i];

			for(int j = 0; j < this.humidities.length; ++j) {
				Climate.Parameter moisture = this.humidities[j];
				ResourceKey<Biome> resourcekey = this.pickMiddleBiome(i, j, par);
				ResourceKey<Biome> resourcekey1 = this.pickMiddleBiomeOrBadlandsIfHot(i, j, par);
				ResourceKey<Biome> resourcekey2 = this.pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(i, j, par);
				// ResourceKey<Biome> resourcekey3 = this.pickShatteredBiome(i, j, par);
				ResourceKey<Biome> resourcekey4 = this.pickPlateauBiome(i, j, par);
				ResourceKey<Biome> resourcekey5 = this.pickBeachBiome(i, j);
				ResourceKey<Biome> resourcekey6 = this.maybePickWindsweptSavannaBiome(i, j, par, resourcekey);
				ResourceKey<Biome> resourcekey7 = this.pickShatteredCoastBiome(i, j, par);
				ResourceKey<Biome> resourcekey8 = this.pickSlopeBiome(i, j, par);
				this.addSurfaceBiome(biomeKey, temp, moisture, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[0], par, 0.0F, resourcekey8);
				this.addSurfaceBiome(biomeKey, temp, moisture, Climate.Parameter.span(this.nearInlandContinentalness, this.midInlandContinentalness), this.erosions[1], par, 0.0F, resourcekey2);
				this.addSurfaceBiome(biomeKey, temp, moisture, this.farInlandContinentalness, this.erosions[1], par, 0.0F, i == 0 ? resourcekey8 : resourcekey4);
				this.addSurfaceBiome(biomeKey, temp, moisture, this.nearInlandContinentalness, this.erosions[2], par, 0.0F, resourcekey);
				this.addSurfaceBiome(biomeKey, temp, moisture, this.midInlandContinentalness, this.erosions[2], par, 0.0F, resourcekey1);
				this.addSurfaceBiome(biomeKey, temp, moisture, this.farInlandContinentalness, this.erosions[2], par, 0.0F, resourcekey4);
				this.addSurfaceBiome(biomeKey, temp, moisture, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[3], par, 0.0F, resourcekey);
				this.addSurfaceBiome(biomeKey, temp, moisture, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[3], par, 0.0F, resourcekey1);
				if (par.max() < 0L) {
					this.addSurfaceBiome(biomeKey, temp, moisture, this.coastContinentalness, this.erosions[4], par, 0.0F, resourcekey5);
					this.addSurfaceBiome(biomeKey, temp, moisture, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[4], par, 0.0F, resourcekey);
				} else {
					this.addSurfaceBiome(biomeKey, temp, moisture, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[4], par, 0.0F, resourcekey);
				}

				this.addSurfaceBiome(biomeKey, temp, moisture, this.coastContinentalness, this.erosions[5], par, 0.0F, resourcekey7);
				this.addSurfaceBiome(biomeKey, temp, moisture, this.nearInlandContinentalness, this.erosions[5], par, 0.0F, resourcekey6);
				// this.addSurfaceBiome(biomeKey, temp, moisture, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], par, 0.0F, resourcekey3);
				if (par.max() < 0L) {
					this.addSurfaceBiome(biomeKey, temp, moisture, this.coastContinentalness, this.erosions[6], par, 0.0F, resourcekey5);
				} else {
					this.addSurfaceBiome(biomeKey, temp, moisture, this.coastContinentalness, this.erosions[6], par, 0.0F, resourcekey);
				}

				if (i == 0) {
					this.addSurfaceBiome(biomeKey, temp, moisture, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], par, 0.0F, resourcekey);
				}
			}
		}
	}

	private void addLowSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> biomeKey, Climate.Parameter par) {
		this.addSurfaceBiome(biomeKey, this.FULL_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[2]), par, 0.0F, Biomes.STONY_SHORE);
		this.addSurfaceBiome(biomeKey, Climate.Parameter.span(this.temperatures[1], this.temperatures[2]), this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], par, 0.0F, Biomes.SWAMP);
		this.addSurfaceBiome(biomeKey, Climate.Parameter.span(this.temperatures[3], this.temperatures[4]), this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], par, 0.0F, Biomes.MANGROVE_SWAMP);

		for(int i = 0; i < this.temperatures.length; ++i) {
			Climate.Parameter temp = this.temperatures[i];

			for(int j = 0; j < this.humidities.length; ++j) {
				Climate.Parameter moisture = this.humidities[j];
				ResourceKey<Biome> resourcekey = this.pickMiddleBiome(i, j, par);
				ResourceKey<Biome> resourcekey1 = this.pickMiddleBiomeOrBadlandsIfHot(i, j, par);
				ResourceKey<Biome> resourcekey2 = this.pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(i, j, par);
				ResourceKey<Biome> resourcekey3 = this.pickBeachBiome(i, j);
				ResourceKey<Biome> resourcekey4 = this.maybePickWindsweptSavannaBiome(i, j, par, resourcekey);
				ResourceKey<Biome> resourcekey5 = this.pickShatteredCoastBiome(i, j, par);
				this.addSurfaceBiome(biomeKey, temp, moisture, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), par, 0.0F, resourcekey1);
				this.addSurfaceBiome(biomeKey, temp, moisture, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[0], this.erosions[1]), par, 0.0F, resourcekey2);
				this.addSurfaceBiome(biomeKey, temp, moisture, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[2], this.erosions[3]), par, 0.0F, resourcekey);
				this.addSurfaceBiome(biomeKey, temp, moisture, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[3]), par, 0.0F, resourcekey1);
				this.addSurfaceBiome(biomeKey, temp, moisture, this.coastContinentalness, Climate.Parameter.span(this.erosions[3], this.erosions[4]), par, 0.0F, resourcekey3);
				this.addSurfaceBiome(biomeKey, temp, moisture, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[4], par, 0.0F, resourcekey);
				this.addSurfaceBiome(biomeKey, temp, moisture, this.coastContinentalness, this.erosions[5], par, 0.0F, resourcekey5);
				this.addSurfaceBiome(biomeKey, temp, moisture, this.nearInlandContinentalness, this.erosions[5], par, 0.0F, resourcekey4);
				this.addSurfaceBiome(biomeKey, temp, moisture, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], par, 0.0F, resourcekey);
				this.addSurfaceBiome(biomeKey, temp, moisture, this.coastContinentalness, this.erosions[6], par, 0.0F, resourcekey3);
				if (i == 0) {
					this.addSurfaceBiome(biomeKey, temp, moisture, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], par, 0.0F, resourcekey);
				}
			}
		}
	}

	private void addValleys(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> biomeKey, Climate.Parameter par) {
		this.addSurfaceBiome(biomeKey, this.FROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), par, 0.0F, par.max() < 0L ? Biomes.STONY_SHORE : Biomes.FROZEN_RIVER);
		this.addSurfaceBiome(biomeKey, this.UNFROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), par, 0.0F, par.max() < 0L ? Biomes.STONY_SHORE : Biomes.RIVER);
		this.addSurfaceBiome(biomeKey, this.FROZEN_RANGE, this.FULL_RANGE, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), par, 0.0F, Biomes.FROZEN_RIVER);
		this.addSurfaceBiome(biomeKey, this.UNFROZEN_RANGE, this.FULL_RANGE, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), par, 0.0F, Biomes.RIVER);
		this.addSurfaceBiome(biomeKey, this.FROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[5]), par, 0.0F, Biomes.FROZEN_RIVER);
		this.addSurfaceBiome(biomeKey, this.UNFROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[5]), par, 0.0F, Biomes.RIVER);
		this.addSurfaceBiome(biomeKey, this.FROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, this.erosions[6], par, 0.0F, Biomes.FROZEN_RIVER);
		this.addSurfaceBiome(biomeKey, this.UNFROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, this.erosions[6], par, 0.0F, Biomes.RIVER);
		this.addSurfaceBiome(biomeKey, Climate.Parameter.span(this.temperatures[1], this.temperatures[2]), this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), this.erosions[6], par, 0.0F, Biomes.SWAMP);
		this.addSurfaceBiome(biomeKey, Climate.Parameter.span(this.temperatures[3], this.temperatures[4]), this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), this.erosions[6], par, 0.0F, Biomes.MANGROVE_SWAMP);
		this.addSurfaceBiome(biomeKey, this.FROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), this.erosions[6], par, 0.0F, Biomes.FROZEN_RIVER);

		for(int i = 0; i < this.temperatures.length; ++i) {
			Climate.Parameter temp = this.temperatures[i];

			for(int j = 0; j < this.humidities.length; ++j) {
				Climate.Parameter moisture = this.humidities[j];
				ResourceKey<Biome> resourcekey = this.pickMiddleBiomeOrBadlandsIfHot(i, j, par);
				this.addSurfaceBiome(biomeKey, temp, moisture, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[0], this.erosions[1]), par, 0.0F, resourcekey);
			}
		}
	}

	private void addUndergroundBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> biomeKey) {
		this.addUndergroundBiome(biomeKey, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(0.8F, 1.0F), this.FULL_RANGE, this.FULL_RANGE, 0.0F, Biomes.DRIPSTONE_CAVES);
		this.addUndergroundBiome(biomeKey, this.FULL_RANGE, Climate.Parameter.span(0.7F, 1.0F), this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, 0.0F, Biomes.LUSH_CAVES);
		this.addBottomBiome(biomeKey, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.erosions[0], this.erosions[1]), this.FULL_RANGE, 0.0F, Biomes.DEEP_DARK);
	}

	private ResourceKey<Biome> pickMiddleBiome(int p_187164_, int p_187165_, Climate.Parameter par) {
		if (par.max() < 0L) {
			return this.MIDDLE_BIOMES[p_187164_][p_187165_];
		} else {
			ResourceKey<Biome> resourcekey = this.MIDDLE_BIOMES_VARIANT[p_187164_][p_187165_];
			return resourcekey == null ? this.MIDDLE_BIOMES[p_187164_][p_187165_] : resourcekey;
		}
	}

	private ResourceKey<Biome> pickMiddleBiomeOrBadlandsIfHot(int p_187192_, int p_187193_, Climate.Parameter par) {
		return p_187192_ == 4 ? this.pickBadlandsBiome(p_187193_, par) : this.pickMiddleBiome(p_187192_, p_187193_, par);
	}

	private ResourceKey<Biome> pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(int p_187212_, int p_187213_, Climate.Parameter par) {
		return p_187212_ == 0 ? this.pickSlopeBiome(p_187212_, p_187213_, par) : this.pickMiddleBiomeOrBadlandsIfHot(p_187212_, p_187213_, par);
	}

	private ResourceKey<Biome> maybePickWindsweptSavannaBiome(int p_201991_, int p_201992_, Climate.Parameter par, ResourceKey<Biome> biomeKey) {
		return p_201991_ > 1 && p_201992_ < 4 && par.max() >= 0L ? Biomes.WINDSWEPT_SAVANNA : biomeKey;
	}

	private ResourceKey<Biome> pickShatteredCoastBiome(int p_187223_, int p_187224_, Climate.Parameter par) {
		ResourceKey<Biome> resourcekey = par.max() >= 0L ? this.pickMiddleBiome(p_187223_, p_187224_, par) : this.pickBeachBiome(p_187223_, p_187224_);
		return this.maybePickWindsweptSavannaBiome(p_187223_, p_187224_, par, resourcekey);
	}

	private ResourceKey<Biome> pickBeachBiome(int p_187161_, int p_187162_) {
		if (p_187161_ == 0) {
			return Biomes.SNOWY_BEACH;
		} else {
			return p_187161_ == 4 ? Biomes.DESERT : Biomes.BEACH;
		}
	}

	private ResourceKey<Biome> pickBadlandsBiome(int p_187173_, Climate.Parameter par) {
		if (p_187173_ < 2) {
			return par.max() < 0L ? Biomes.BADLANDS : Biomes.ERODED_BADLANDS;
		} else {
			return p_187173_ < 3 ? Biomes.BADLANDS : Biomes.WOODED_BADLANDS;
		}
	}

	private ResourceKey<Biome> pickPlateauBiome(int p_187234_, int p_187235_, Climate.Parameter par) {
		if (par.max() >= 0L) {
			ResourceKey<Biome> resourcekey = this.PLATEAU_BIOMES_VARIANT[p_187234_][p_187235_];
			if (resourcekey != null) {
				return resourcekey;
			}
		}
		return this.PLATEAU_BIOMES[p_187234_][p_187235_];
	}

	private ResourceKey<Biome> pickPeakBiome(int p_187241_, int p_187242_, Climate.Parameter par) {
		if (p_187241_ <= 2) {
			return par.max() < 0L ? Biomes.JAGGED_PEAKS : Biomes.FROZEN_PEAKS;
		} else {
			return p_187241_ == 3 ? Biomes.STONY_PEAKS : this.pickBadlandsBiome(p_187242_, par);
		}
	}

	private ResourceKey<Biome> pickSlopeBiome(int p_187245_, int p_187246_, Climate.Parameter par) {
		if (p_187245_ >= 3) {
			return this.pickPlateauBiome(p_187245_, p_187246_, par);
		} else {
			return p_187246_ <= 1 ? Biomes.SNOWY_SLOPES : Biomes.GROVE;
		}
	}

	/* private ResourceKey<Biome> pickShatteredBiome(int p_202002_, int p_202003_, Climate.Parameter par) {
		ResourceKey<Biome> resourcekey = this.SHATTERED_BIOMES[p_202002_][p_202003_];
		return resourcekey == null ? this.pickMiddleBiome(p_202002_, p_202003_, par) : resourcekey;
	} */

	private void addSurfaceBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> biomeKey, Climate.Parameter par, Climate.Parameter par1, Climate.Parameter par2, Climate.Parameter par3, Climate.Parameter par4, float f, ResourceKey<Biome> biomeKey1) {
		biomeKey.accept(Pair.of(Climate.parameters(par, par1, par2, par3, Climate.Parameter.point(0.0F), par4, f), biomeKey1));
		biomeKey.accept(Pair.of(Climate.parameters(par, par1, par2, par3, Climate.Parameter.point(1.0F), par4, f), biomeKey1));
	}

	private void addUndergroundBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> biomeKey, Climate.Parameter par, Climate.Parameter par1, Climate.Parameter par2, Climate.Parameter par3, Climate.Parameter par4, float f, ResourceKey<Biome> biomeKey1) {
		biomeKey.accept(Pair.of(Climate.parameters(par, par1, par2, par3, Climate.Parameter.span(0.2F, 0.9F), par4, f), biomeKey1));
	}

	private void addBottomBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> biomeKey, Climate.Parameter par, Climate.Parameter par1, Climate.Parameter par2, Climate.Parameter par3, Climate.Parameter par4, float f, ResourceKey<Biome> biomeKey1) {
		biomeKey.accept(Pair.of(Climate.parameters(par, par1, par2, par3, Climate.Parameter.point(1.1F), par4, f), biomeKey1));
	}

	public static boolean isDeepDarkRegion(DensityFunction density, DensityFunction density1, DensityFunction.FunctionContext context) {
		return density.compute(context) < (double)-0.225F && density1.compute(context) > (double)0.9F;
	}

	public static String getDebugStringForPeaksAndValleys(double d) {
		if (d < (double)NoiseRouterData.peaksAndValleys(0.05F)) {
			return "Valley";
		} else if (d < (double)NoiseRouterData.peaksAndValleys(0.26666668F)) {
			return "Low";
		} else if (d < (double)NoiseRouterData.peaksAndValleys(0.4F)) {
			return "Mid";
		} else {
			return d < (double)NoiseRouterData.peaksAndValleys(0.56666666F) ? "High" : "Peak";
		}
	}

	public String getDebugStringForContinentalness(double d) {
		double d0 = (double)Climate.quantizeCoord((float)d);
		if (d0 < (double)this.mushroomFieldsContinentalness.max()) {
			return "Mushroom fields";
		} else if (d0 < (double)this.deepOceanContinentalness.max()) {
			return "Deep ocean";
		} else if (d0 < (double)this.oceanContinentalness.max()) {
			return "Ocean";
		} else if (d0 < (double)this.coastContinentalness.max()) {
			return "Coast";
		} else if (d0 < (double)this.nearInlandContinentalness.max()) {
			return "Near inland";
		} else {
			return d0 < (double)this.midInlandContinentalness.max() ? "Mid inland" : "Far inland";
		}
	}

	public String getDebugStringForErosion(double d) {
		return getDebugStringForNoiseValue(d, this.erosions);
	}

	public String getDebugStringForTemperature(double d) {
		return getDebugStringForNoiseValue(d, this.temperatures);
	}

	public String getDebugStringForHumidity(double d) {
		return getDebugStringForNoiseValue(d, this.humidities);
	}

	private static String getDebugStringForNoiseValue(double d, Climate.Parameter[] par) {
		double d0 = (double)Climate.quantizeCoord((float)d);

		for(int i = 0; i < par.length; ++i) {
			if (d0 < (double)par[i].max()) {
				return "" + i;
			}
		}

		return "?";
	}

	@VisibleForDebug
	public Climate.Parameter[] getTemperatureThresholds() {
		return this.temperatures;
	}

	@VisibleForDebug
	public Climate.Parameter[] getHumidityThresholds() {
		return this.humidities;
	}

	@VisibleForDebug
	public Climate.Parameter[] getErosionThresholds() {
		return this.erosions;
	}

	@VisibleForDebug
	public Climate.Parameter[] getContinentalnessThresholds() {
		return new Climate.Parameter[]{this.mushroomFieldsContinentalness, this.deepOceanContinentalness, this.oceanContinentalness, this.coastContinentalness, this.nearInlandContinentalness, this.midInlandContinentalness, this.farInlandContinentalness};
	}

	@VisibleForDebug
	public Climate.Parameter[] getPeaksAndValleysThresholds() {
		return new Climate.Parameter[]{Climate.Parameter.span(-2.0F, NoiseRouterData.peaksAndValleys(0.05F)), Climate.Parameter.span(NoiseRouterData.peaksAndValleys(0.05F), NoiseRouterData.peaksAndValleys(0.26666668F)), Climate.Parameter.span(NoiseRouterData.peaksAndValleys(0.26666668F), NoiseRouterData.peaksAndValleys(0.4F)), Climate.Parameter.span(NoiseRouterData.peaksAndValleys(0.4F), NoiseRouterData.peaksAndValleys(0.56666666F)), Climate.Parameter.span(NoiseRouterData.peaksAndValleys(0.56666666F), 2.0F)};
	}

	@VisibleForDebug
	public Climate.Parameter[] getWeirdnessThresholds() {
		return new Climate.Parameter[]{Climate.Parameter.span(-2.0F, 0.0F), Climate.Parameter.span(0.0F, 2.0F)};
	}
}
