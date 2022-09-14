
package net.mcreator.combatcraftmodv.world.biome;

import net.minecraft.world.level.levelgen.placement.SurfaceWaterDepthFilter;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraft.world.level.levelgen.placement.NoiseThresholdCountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.feature.trunkplacers.MegaJungleTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaJungleFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.AmbientParticleSettings;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.AmbientAdditionsSettings;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.Music;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.AquaticFeatures;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.combatcraftmodv.world.features.treedecorators.AlternateForestTrunkDecorator;
import net.mcreator.combatcraftmodv.world.features.treedecorators.AlternateForestLeaveDecorator;
import net.mcreator.combatcraftmodv.world.features.treedecorators.AlternateForestFruitDecorator;

import java.util.List;

import com.google.common.collect.ImmutableList;

public class AlternateForestBiome {
	public static final Climate.ParameterPoint PARAMETER_POINT = new Climate.ParameterPoint(Climate.Parameter.span(-0.214285714286f, 0.214285714286f),
			Climate.Parameter.span(0.185714285714f, 0.614285714286f), Climate.Parameter.span(0.295714285714f, 0.724285714286f),
			Climate.Parameter.span(0.585714285714f, 1.014285714286f), Climate.Parameter.point(0),
			Climate.Parameter.span(-0.294074674083f, 0.134496754489f), 0);

	public static Biome createBiome() {
		BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(-10092442).waterColor(-6723841).waterFogColor(-12707949)
				.skyColor(-10092442).foliageColorOverride(-13434829).grassColorOverride(-10092544)
				.ambientLoopSound(new SoundEvent(new ResourceLocation("ambient.warped_forest.mood")))
				.ambientMoodSound(new AmbientMoodSettings(new SoundEvent(new ResourceLocation("entity.husk.converted_to_zombie")), 6000, 8, 2))
				.ambientAdditionsSound(new AmbientAdditionsSettings(new SoundEvent(new ResourceLocation("entity.ghast.scream")), 0.0111D))
				.backgroundMusic(new Music(new SoundEvent(new ResourceLocation("ambient.cave")), 12000, 24000, true))
				.ambientParticle(new AmbientParticleSettings(ParticleTypes.EXPLOSION, 0.005f)).build();
		BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacementUtils.register(
				"combatcraftmodv:tree_alternate_forest",
				FeatureUtils.register("combatcraftmodv:tree_alternate_forest", Feature.TREE,
						new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.WEEPING_VINES_PLANT.defaultBlockState()),
								new MegaJungleTrunkPlacer(7, 2, 19), BlockStateProvider.simple(Blocks.CRIMSON_STEM.defaultBlockState()),
								new MegaJungleFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 2), new TwoLayersFeatureSize(1, 1, 2))
								.decorators(ImmutableList.of(AlternateForestLeaveDecorator.INSTANCE, AlternateForestTrunkDecorator.INSTANCE,
										AlternateForestFruitDecorator.INSTANCE))
								.build()),
				List.of(CountPlacement.of(2), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0),
						PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome())));
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
				PlacementUtils.register("combatcraftmodv:grass_alternate_forest", VegetationFeatures.PATCH_GRASS,
						List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
								BiomeFilter.biome())));
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacementUtils
				.register("combatcraftmodv:seagrass_alternate_forest", AquaticFeatures.SEAGRASS_SHORT, AquaticPlacements.seagrassPlacement(1)));
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
				PlacementUtils.register("combatcraftmodv:flower_alternate_forest", VegetationFeatures.FLOWER_DEFAULT, List.of(CountPlacement.of(4),
						RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
				PlacementUtils.register("combatcraftmodv:brown_mushroom_alternate_forest", VegetationFeatures.PATCH_BROWN_MUSHROOM,
						List.of(CountPlacement.of(5), RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP,
								BiomeFilter.biome())));
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
				PlacementUtils.register("combatcraftmodv:red_mushroom_alternate_forest", VegetationFeatures.PATCH_RED_MUSHROOM,
						List.of(CountPlacement.of(5), RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP,
								BiomeFilter.biome())));
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
				PlacementUtils.register("combatcraftmodv:mushrooms_huge_alternate_forest", VegetationFeatures.MUSHROOM_ISLAND_VEGETATION,
						List.of(CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
				PlacementUtils.register("combatcraftmodv:disk_sand_alternate_forest",
						FeatureUtils.register("combatcraftmodv:disk_sand_alternate_forest", Feature.DISK,
								new DiskConfiguration(Blocks.SAND.defaultBlockState(), UniformInt.of(2, 6), 2,
										List.of(Blocks.MAGENTA_TERRACOTTA.defaultBlockState(), Blocks.DEEPSLATE.defaultBlockState()))),
						List.of(CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome())));
		BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeGenerationSettings);
		BiomeDefaultFeatures.addSwampVegetation(biomeGenerationSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
		BiomeDefaultFeatures.addSurfaceFreezing(biomeGenerationSettings);
		MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
		mobSpawnInfo.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FALLING_BLOCK, 20, 4, 10));
		return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.NONE).temperature(0.5f)
				.downfall(0.7f).specialEffects(effects).mobSpawnSettings(mobSpawnInfo.build()).generationSettings(biomeGenerationSettings.build())
				.build();
	}

	public static void init() {
	}
}
