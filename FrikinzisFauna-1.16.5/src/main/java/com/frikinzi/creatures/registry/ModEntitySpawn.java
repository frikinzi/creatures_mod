package com.frikinzi.creatures.registry;

import com.frikinzi.creatures.Creatures;
import com.frikinzi.creatures.config.CreaturesConfig;
import net.minecraft.entity.EntityClassification;
import net.minecraft.util.RegistryKey;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.world.MobSpawnInfoBuilder;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Set;

@Mod.EventBusSubscriber(modid = Creatures.MODID)
public class ModEntitySpawn {
    @SubscribeEvent
    public static void onBiomesLoad(final BiomeLoadingEvent event) {
        if (event.getName() == null)
            return;
        RegistryKey<Biome> biomeKey = RegistryKey.create(Registry.BIOME_REGISTRY, event.getName());
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(biomeKey);
        MobSpawnInfoBuilder spawns = event.getSpawns();
        if (CreaturesConfig.koi_spawns.get() && (types.contains(BiomeDictionary.Type.RIVER) || types.contains(BiomeDictionary.Type.SWAMP))) {
            spawns.addSpawn(EntityClassification.WATER_AMBIENT,
                    new MobSpawnInfo.Spawners(ModEntityTypes.KOI.get(), CreaturesConfig.koi_spawn_weight.get(), CreaturesConfig.koi_min_group.get(), CreaturesConfig.koi_max_group.get()));
        }
        if (CreaturesConfig.dottyback_spawns.get() && types.contains(BiomeDictionary.Type.OCEAN) && types.contains(BiomeDictionary.Type.HOT)) {
            spawns.addSpawn(EntityClassification.WATER_AMBIENT,
                    new MobSpawnInfo.Spawners(ModEntityTypes.DOTTYBACK.get(), CreaturesConfig.dottyback_spawn_weight.get(), CreaturesConfig.dottyback_min_group.get(), CreaturesConfig.dottyback_max_group.get()));
        }
        if (CreaturesConfig.red_snapper_spawns.get() && types.contains(BiomeDictionary.Type.OCEAN) && (!types.contains(BiomeDictionary.Type.COLD))) {
            spawns.addSpawn(EntityClassification.WATER_AMBIENT,
                    new MobSpawnInfo.Spawners(ModEntityTypes.RED_SNAPPER.get(), CreaturesConfig.red_snapper_spawn_weight.get(), CreaturesConfig.red_snapper_min_group.get(), CreaturesConfig.red_snapper_max_group.get()));
        }
        if (CreaturesConfig.pike_spawns.get() && types.contains(BiomeDictionary.Type.RIVER)) {
            spawns.addSpawn(EntityClassification.WATER_AMBIENT,
                    new MobSpawnInfo.Spawners(ModEntityTypes.PIKE.get(), CreaturesConfig.pike_spawn_weight.get(), CreaturesConfig.pike_min_group.get(), CreaturesConfig.pike_max_group.get()));
        }

        if (CreaturesConfig.guppy_spawns.get() && types.contains(BiomeDictionary.Type.RIVER)) {
            spawns.addSpawn(EntityClassification.WATER_AMBIENT,
                    new MobSpawnInfo.Spawners(ModEntityTypes.GUPPY.get(), CreaturesConfig.guppy_spawn_weight.get(), CreaturesConfig.guppy_min_group.get(), CreaturesConfig.guppy_max_group.get()));
        }

        if (CreaturesConfig.lovebird_spawns.get() && types.contains(BiomeDictionary.Type.SAVANNA)) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.LOVEBIRD.get(), CreaturesConfig.lovebird_spawn_weight.get(), CreaturesConfig.lovebird_min_group.get(), CreaturesConfig.lovebird_max_group.get()));
        }
        if (CreaturesConfig.roller_spawns.get() && types.contains(BiomeDictionary.Type.SAVANNA)) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.ROLLER.get(), CreaturesConfig.roller_spawn_weight.get(), CreaturesConfig.roller_min_group.get(), CreaturesConfig.roller_max_group.get()));
        }
        if (CreaturesConfig.shrimp_spawns.get() && (types.contains(BiomeDictionary.Type.RIVER) || types.contains(BiomeDictionary.Type.SWAMP))) {
            spawns.addSpawn(EntityClassification.WATER_AMBIENT,
                    new MobSpawnInfo.Spawners(ModEntityTypes.SHRIMP.get(), CreaturesConfig.shrimp_spawn_weight.get(), CreaturesConfig.shrimp_min_group.get(), CreaturesConfig.shrimp_max_group.get()));
        }
        if (CreaturesConfig.gourami_spawns.get() && (types.contains(BiomeDictionary.Type.RIVER) || types.contains(BiomeDictionary.Type.SWAMP))) {
            spawns.addSpawn(EntityClassification.WATER_AMBIENT,
                    new MobSpawnInfo.Spawners(ModEntityTypes.GOURAMI.get(), CreaturesConfig.gourami_spawn_weight.get(), CreaturesConfig.gourami_min_group.get(), CreaturesConfig.gourami_max_group.get()));
        }
        if (CreaturesConfig.arowana_spawns.get() && (types.contains(BiomeDictionary.Type.RIVER) || types.contains(BiomeDictionary.Type.SWAMP))) {
            spawns.addSpawn(EntityClassification.WATER_AMBIENT,
                    new MobSpawnInfo.Spawners(ModEntityTypes.AROWANA.get(), CreaturesConfig.arowana_spawn_weight.get(), CreaturesConfig.arowana_min_group.get(), CreaturesConfig.arowana_max_group.get()));
        }
        if (CreaturesConfig.ghost_crab_spawns.get() && types.contains(BiomeDictionary.Type.BEACH) && !types.contains(BiomeDictionary.Type.COLD)) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.GHOST_CRAB.get(), CreaturesConfig.ghost_crab_spawn_weight.get(), CreaturesConfig.ghost_crab_min_group.get(), CreaturesConfig.ghost_crab_max_group.get()));
        }
        if (CreaturesConfig.lorikeet_spawns.get() && !types.contains(BiomeDictionary.Type.NETHER) && (types.contains(BiomeDictionary.Type.FOREST) || types.contains(BiomeDictionary.Type.JUNGLE))) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.LORIKEET.get(), CreaturesConfig.lorikeet_spawn_weight.get(), CreaturesConfig.lorikeet_min_group.get(), CreaturesConfig.lorikeet_max_group.get()));
        }
        if (CreaturesConfig.conure_spawns.get()  && !types.contains(BiomeDictionary.Type.NETHER) && (types.contains(BiomeDictionary.Type.FOREST) || types.contains(BiomeDictionary.Type.JUNGLE))) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.CONURE.get(), CreaturesConfig.conure_spawn_weight.get(), CreaturesConfig.conure_min_group.get(), CreaturesConfig.conure_max_group.get()));
        }
        if (CreaturesConfig.spoonbill_spawns.get() && types.contains(BiomeDictionary.Type.SWAMP)) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.SPOONBILL.get(), CreaturesConfig.spoonbill_spawn_weight.get(), CreaturesConfig.spoonbill_min_group.get(), CreaturesConfig.spoonbill_max_group.get()));
        }
        if (CreaturesConfig.dove_spawns.get() && !types.contains(BiomeDictionary.Type.NETHER) && ((types.contains(BiomeDictionary.Type.MOUNTAIN) || ((types.contains(BiomeDictionary.Type.JUNGLE) || types.contains(BiomeDictionary.Type.FOREST) || types.contains(BiomeDictionary.Type.PLAINS) || types.contains(BiomeDictionary.Type.SWAMP) || types.contains(BiomeDictionary.Type.MESA)))))) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.DOVE.get(), CreaturesConfig.dove_spawn_weight.get(), CreaturesConfig.dove_min_group.get(), CreaturesConfig.dove_max_group.get()));
        }
        if (CreaturesConfig.mandarin_duck_spawns.get() && !types.contains(BiomeDictionary.Type.NETHER) && (types.contains(BiomeDictionary.Type.RIVER))) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.MANDARIN_DUCK.get(), CreaturesConfig.mandarin_duck_spawn_weight.get(), CreaturesConfig.mandarin_duck_min_group.get(), CreaturesConfig.mandarin_duck_max_group.get()));
        }
        if (CreaturesConfig.kakapo_spawns.get() && types.contains(BiomeDictionary.Type.FOREST) && !types.contains(BiomeDictionary.Type.NETHER)  && !types.contains(BiomeDictionary.Type.COLD)) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.KAKAPO.get(), CreaturesConfig.kakapo_spawn_weight.get(), CreaturesConfig.kakapo_min_group.get(), CreaturesConfig.kakapo_max_group.get()));
        }
        if (CreaturesConfig.raven_spawns.get() && types.contains(BiomeDictionary.Type.FOREST) && !types.contains(BiomeDictionary.Type.NETHER)) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.RAVEN.get(), CreaturesConfig.raven_spawn_weight.get(), CreaturesConfig.raven_min_group.get(), CreaturesConfig.raven_max_group.get()));
        }
        if (CreaturesConfig.fairywren_spawns.get() && types.contains(BiomeDictionary.Type.FOREST) && !types.contains(BiomeDictionary.Type.NETHER) && !types.contains(BiomeDictionary.Type.COLD)) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.FAIRYWREN.get(), CreaturesConfig.fairywren_spawn_weight.get(), CreaturesConfig.fairywren_min_group.get(), CreaturesConfig.fairywren_max_group.get()));
        }
        if (CreaturesConfig.golden_eagle_spawns.get() && (types.contains(BiomeDictionary.Type.FOREST) || types.contains(BiomeDictionary.Type.DRY) || types.contains(BiomeDictionary.Type.PLAINS) || types.contains(BiomeDictionary.Type.MESA) || types.contains(BiomeDictionary.Type.MOUNTAIN)) && !types.contains(BiomeDictionary.Type.NETHER)) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.GOLDEN_EAGLE.get(), CreaturesConfig.golden_eagle_spawn_weight.get(), CreaturesConfig.golden_eagle_min_group.get(), CreaturesConfig.golden_eagle_max_group.get()));
        }
        if (CreaturesConfig.gyrfalcon_spawns.get() && types.contains(BiomeDictionary.Type.SNOWY) && types.contains(BiomeDictionary.Type.MOUNTAIN)) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.GYRFALCON.get(), CreaturesConfig.gyrfalcon_spawn_weight.get(), CreaturesConfig.gyrfalcon_min_group.get(), CreaturesConfig.gyrfalcon_max_group.get()));
        }
        if (CreaturesConfig.red_kite_spawns.get() && types.contains(BiomeDictionary.Type.FOREST) && !types.contains(BiomeDictionary.Type.NETHER)) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.RED_KITE.get(), CreaturesConfig.red_kite_spawn_weight.get(), CreaturesConfig.red_kite_min_group.get(), CreaturesConfig.red_kite_max_group.get()));
        }
        if (CreaturesConfig.stellers_sea_eagle_spawns.get() && types.contains(BiomeDictionary.Type.SNOWY)) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.SEA_EAGLE.get(), CreaturesConfig.stellers_sea_eagle_spawn_weight.get(), CreaturesConfig.stellers_sea_eagle_min_group.get(), CreaturesConfig.stellers_sea_eagle_max_group.get()));
        }
        if (CreaturesConfig.pygmy_falcon_spawns.get() && types.contains(BiomeDictionary.Type.DRY) && !types.contains(BiomeDictionary.Type.NETHER)) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.PYGMY_FALCON.get(), CreaturesConfig.pygmy_falcon_spawn_weight.get(), CreaturesConfig.pygmy_falcon_min_group.get(), CreaturesConfig.pygmy_falcon_max_group.get()));
        }
        if (CreaturesConfig.barn_owl_spawns.get() && (types.contains(BiomeDictionary.Type.FOREST) && !types.contains(BiomeDictionary.Type.NETHER))) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.BARN_OWL.get(), CreaturesConfig.barn_owl_spawn_weight.get(), CreaturesConfig.barn_owl_min_group.get(), CreaturesConfig.barn_owl_max_group.get()));
        }
        if (CreaturesConfig.goldfish_spawns.get() && (types.contains(BiomeDictionary.Type.RIVER) || types.contains(BiomeDictionary.Type.SWAMP))) {
            spawns.addSpawn(EntityClassification.WATER_AMBIENT,
                    new MobSpawnInfo.Spawners(ModEntityTypes.GOLDFISH.get(), CreaturesConfig.goldfish_spawn_weight.get(), CreaturesConfig.goldfish_min_group.get(), CreaturesConfig.goldfish_max_group.get()));
        }
        if (CreaturesConfig.ranchu_spawns.get() && (types.contains(BiomeDictionary.Type.RIVER) || types.contains(BiomeDictionary.Type.SWAMP))) {
            spawns.addSpawn(EntityClassification.WATER_AMBIENT,
                    new MobSpawnInfo.Spawners(ModEntityTypes.RANCHU.get(), CreaturesConfig.ranchu_spawn_weight.get(), CreaturesConfig.ranchu_min_group.get(), CreaturesConfig.ranchu_max_group.get()));
        }
        if (CreaturesConfig.wild_duck_spawns.get() && types.contains(BiomeDictionary.Type.RIVER)) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.WILD_DUCK.get(), CreaturesConfig.wild_duck_spawn_weight.get(), CreaturesConfig.wild_duck_min_group.get(), CreaturesConfig.wild_duck_max_group.get()));
        }
        if (CreaturesConfig.chickadee_spawns.get() && types.contains(BiomeDictionary.Type.FOREST) && !types.contains(BiomeDictionary.Type.NETHER)) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.CHICKADEE.get(), CreaturesConfig.chickadee_spawn_weight.get(), CreaturesConfig.chickadee_min_group.get(), CreaturesConfig.chickadee_max_group.get()));
        }
        if (CreaturesConfig.pygmy_goose_spawns.get() && types.contains(BiomeDictionary.Type.SWAMP)) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.PYGMY_GOOSE.get(), CreaturesConfig.pygmy_goose_spawn_weight.get(), CreaturesConfig.pygmy_goose_min_group.get(), CreaturesConfig.pygmy_goose_max_group.get()));
        }
        if (CreaturesConfig.swallow_spawns.get() && !types.contains(BiomeDictionary.Type.NETHER) && (types.contains(BiomeDictionary.Type.FOREST) || types.contains(BiomeDictionary.Type.PLAINS))) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.SWALLOW.get(), CreaturesConfig.swallow_spawn_weight.get(), CreaturesConfig.swallow_min_group.get(), CreaturesConfig.swallow_max_group.get()));
        }
        if (CreaturesConfig.fire_goby_spawns.get() && types.contains(BiomeDictionary.Type.OCEAN) && types.contains(BiomeDictionary.Type.HOT)) {
            spawns.addSpawn(EntityClassification.WATER_AMBIENT,
                    new MobSpawnInfo.Spawners(ModEntityTypes.FIRE_GOBY.get(), CreaturesConfig.fire_goby_spawn_weight.get(), CreaturesConfig.fire_goby_min_group.get(), CreaturesConfig.fire_goby_max_group.get()));
        }
        if (CreaturesConfig.blue_tang_spawns.get() && types.contains(BiomeDictionary.Type.OCEAN) && types.contains(BiomeDictionary.Type.HOT)) {
            spawns.addSpawn(EntityClassification.WATER_AMBIENT,
                    new MobSpawnInfo.Spawners(ModEntityTypes.BLUE_TANG.get(), CreaturesConfig.blue_tang_spawn_weight.get(), CreaturesConfig.blue_tang_min_group.get(), CreaturesConfig.blue_tang_max_group.get()));
        }
        if (CreaturesConfig.flame_angelfish_spawns.get() && (types.contains(BiomeDictionary.Type.OCEAN) && types.contains(BiomeDictionary.Type.HOT))) {
            spawns.addSpawn(EntityClassification.WATER_AMBIENT,
                    new MobSpawnInfo.Spawners(ModEntityTypes.FLAME_ANGELFISH.get(), CreaturesConfig.flame_angelfish_spawn_weight.get(), CreaturesConfig.flame_angelfish_min_group.get(), CreaturesConfig.flame_angelfish_max_group.get()));
        }
        if (CreaturesConfig.trout_spawns.get() && types.contains(BiomeDictionary.Type.RIVER)) {
            spawns.addSpawn(EntityClassification.WATER_AMBIENT,
                    new MobSpawnInfo.Spawners(ModEntityTypes.TROUT.get(), CreaturesConfig.trout_spawn_weight.get(), CreaturesConfig.trout_min_group.get(), CreaturesConfig.trout_max_group.get()));
        }
        if (CreaturesConfig.fiddler_crab_spawns.get() && (types.contains(BiomeDictionary.Type.BEACH) && !types.contains(BiomeDictionary.Type.COLD))) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.FIDDLER_CRAB.get(), CreaturesConfig.fiddler_crab_spawn_weight.get(), CreaturesConfig.fiddler_crab_min_group.get(), CreaturesConfig.fiddler_crab_max_group.get()));
        }
        if (CreaturesConfig.ibis_spawns.get() && (types.contains(BiomeDictionary.Type.SWAMP) || types.contains(BiomeDictionary.Type.RIVER))) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.IBIS.get(), CreaturesConfig.ibis_spawn_weight.get(), CreaturesConfig.ibis_min_group.get(), CreaturesConfig.ibis_max_group.get()));
        }
        if (CreaturesConfig.wood_duck_spawns.get() && (types.contains(BiomeDictionary.Type.SWAMP) || types.contains(BiomeDictionary.Type.RIVER))) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.WOOD_DUCK.get(), CreaturesConfig.wood_duck_spawn_weight.get(), CreaturesConfig.wood_duck_min_group.get(), CreaturesConfig.wood_duck_max_group.get()));
        }
        if (CreaturesConfig.peafowl_spawns.get() && types.contains(BiomeDictionary.Type.FOREST)) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.PEAFOWL.get(), CreaturesConfig.peafowl_spawn_weight.get(), CreaturesConfig.peafowl_min_group.get(), CreaturesConfig.peafowl_max_group.get()));
        }
        if (CreaturesConfig.sparrow_spawns.get() && types.contains(BiomeDictionary.Type.FOREST) || types.contains(BiomeDictionary.Type.JUNGLE) || types.contains(BiomeDictionary.Type.DRY)) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.SPARROW.get(), CreaturesConfig.sparrow_spawn_weight.get(), CreaturesConfig.sparrow_min_group.get(), CreaturesConfig.sparrow_max_group.get()));
        }
        if (CreaturesConfig.bushtit_spawns.get() && types.contains(BiomeDictionary.Type.FOREST)) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.BUSHTIT.get(), CreaturesConfig.bushtit_spawn_weight.get(), CreaturesConfig.bushtit_min_group.get(), CreaturesConfig.bushtit_max_group.get()));
        }
        if (CreaturesConfig.laughingthrush_spawns.get() && !(types.contains(BiomeDictionary.Type.NETHER)) && (types.contains(BiomeDictionary.Type.FOREST) || types.contains(BiomeDictionary.Type.MOUNTAIN))) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.LAUGHINGTHRUSH.get(), CreaturesConfig.laughingthrush_spawn_weight.get(), CreaturesConfig.laughingthrush_min_group.get(), CreaturesConfig.laughingthrush_max_group.get()));
        }
        if (CreaturesConfig.eagleowl_spawns.get() && types.contains(BiomeDictionary.Type.FOREST)) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.EAGLEOWL.get(), CreaturesConfig.eagleowl_spawn_weight.get(), CreaturesConfig.eagleowl_min_group.get(), CreaturesConfig.eagleowl_max_group.get()));
        }
        if (CreaturesConfig.robin_spawns.get() && types.contains(BiomeDictionary.Type.FOREST)) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.ROBIN.get(), CreaturesConfig.robin_spawn_weight.get(), CreaturesConfig.robin_min_group.get(), CreaturesConfig.robin_max_group.get()));
        }
        if (CreaturesConfig.magpie_spawns.get() && types.contains(BiomeDictionary.Type.FOREST)) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.MAGPIE.get(), CreaturesConfig.magpie_spawn_weight.get(), CreaturesConfig.magpie_min_group.get(), CreaturesConfig.magpie_max_group.get()));
        }
        if (CreaturesConfig.goose_spawns.get() && (types.contains(BiomeDictionary.Type.FOREST) || types.contains(BiomeDictionary.Type.RIVER) || types.contains(BiomeDictionary.Type.SWAMP))) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.GOOSE.get(), CreaturesConfig.goose_spawn_weight.get(), CreaturesConfig.goose_min_group.get(), CreaturesConfig.goose_max_group.get()));
        }
        if (CreaturesConfig.osprey_spawns.get() && (types.contains(BiomeDictionary.Type.BEACH) || types.contains(BiomeDictionary.Type.RIVER) || types.contains(BiomeDictionary.Type.SWAMP))) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.OSPREY.get(), CreaturesConfig.osprey_spawn_weight.get(), CreaturesConfig.osprey_min_group.get(), CreaturesConfig.osprey_max_group.get()));
        }
        if (CreaturesConfig.kingfisher_spawns.get() && (types.contains(BiomeDictionary.Type.BEACH) || types.contains(BiomeDictionary.Type.RIVER) || types.contains(BiomeDictionary.Type.SWAMP))) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.KINGFISHER.get(), CreaturesConfig.kingfisher_spawn_weight.get(), CreaturesConfig.kingfisher_min_group.get(), CreaturesConfig.kingfisher_max_group.get()));
        }
        if (CreaturesConfig.pelican_spawns.get() && types.contains(BiomeDictionary.Type.BEACH)) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.PELICAN.get(), CreaturesConfig.pelican_spawn_weight.get(), CreaturesConfig.pelican_min_group.get(), CreaturesConfig.pelican_max_group.get()));
        }
        if (CreaturesConfig.lapwing_spawns.get() && (types.contains(BiomeDictionary.Type.SWAMP) || types.contains(BiomeDictionary.Type.PLAINS))) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.LAPWING.get(), CreaturesConfig.lapwing_spawn_weight.get(), CreaturesConfig.lapwing_min_group.get(), CreaturesConfig.lapwing_max_group.get()));
        }
        if (CreaturesConfig.skua_spawns.get() && (types.contains(BiomeDictionary.Type.BEACH) || types.contains(BiomeDictionary.Type.SNOWY))) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.SKUA.get(), CreaturesConfig.skua_spawn_weight.get(), CreaturesConfig.skua_min_group.get(), CreaturesConfig.skua_max_group.get()));
        }  if (CreaturesConfig.bunting_spawns.get() && !types.contains(BiomeDictionary.Type.NETHER) && types.contains(BiomeDictionary.Type.FOREST)) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.BUNTING.get(), CreaturesConfig.bunting_spawn_weight.get(), CreaturesConfig.bunting_min_group.get(), CreaturesConfig.bunting_max_group.get()));
        }  if (CreaturesConfig.monal_spawns.get() && types.contains(BiomeDictionary.Type.MOUNTAIN)) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.MONAL.get(), CreaturesConfig.monal_spawn_weight.get(), CreaturesConfig.monal_min_group.get(), CreaturesConfig.monal_max_group.get()));
        }  if (CreaturesConfig.tanager_spawns.get() && types.contains(BiomeDictionary.Type.JUNGLE)) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.TANAGER.get(), CreaturesConfig.tanager_spawn_weight.get(), CreaturesConfig.tanager_min_group.get(), CreaturesConfig.tanager_max_group.get()));
        }  if (CreaturesConfig.finch_spawns.get() && (types.contains(BiomeDictionary.Type.SAVANNA))) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.FINCH.get(), CreaturesConfig.finch_spawn_weight.get(), CreaturesConfig.finch_min_group.get(), CreaturesConfig.finch_max_group.get()));
        }  if (CreaturesConfig.capercaillie_spawns.get() && (!types.contains(BiomeDictionary.Type.NETHER) && types.contains(BiomeDictionary.Type.FOREST))) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.CAPERCAILLIE.get(), CreaturesConfig.capercaillie_spawn_weight.get(), CreaturesConfig.capercaillie_min_group.get(), CreaturesConfig.capercaillie_max_group.get()));
        }   if (CreaturesConfig.pheasant_spawns.get() && (!types.contains(BiomeDictionary.Type.NETHER) && (types.contains(BiomeDictionary.Type.FOREST) || types.contains(BiomeDictionary.Type.MOUNTAIN)))) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.PHEASANT.get(), CreaturesConfig.pheasant_spawn_weight.get(), CreaturesConfig.pheasant_min_group.get(), CreaturesConfig.pheasant_max_group.get()));
        }  if (CreaturesConfig.tarantula_spawns.get() && !types.contains(BiomeDictionary.Type.NETHER) && (types.contains(BiomeDictionary.Type.DRY) || types.contains(BiomeDictionary.Type.JUNGLE))) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.TARANTULA.get(), CreaturesConfig.tarantula_spawn_weight.get(), CreaturesConfig.tarantula_min_group.get(), CreaturesConfig.tarantula_max_group.get()));
        }  if (CreaturesConfig.vampirecrab_spawns.get() && types.contains(BiomeDictionary.Type.RIVER)) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.VAMPIRECRAB.get(), CreaturesConfig.vampirecrab_spawn_weight.get(), CreaturesConfig.vampirecrab_min_group.get(), CreaturesConfig.vampirecrab_max_group.get()));
        }
        if (CreaturesConfig.arapaima_spawns.get() && types.contains(BiomeDictionary.Type.RIVER)) {
            spawns.addSpawn(EntityClassification.WATER_AMBIENT,
                    new MobSpawnInfo.Spawners(ModEntityTypes.ARAPAIMA.get(), CreaturesConfig.arapaima_spawn_weight.get(), CreaturesConfig.arapaima_min_group.get(), CreaturesConfig.arapaima_max_group.get()));
        }
        if (CreaturesConfig.tigerbarb_spawns.get() && types.contains(BiomeDictionary.Type.RIVER)) {
            spawns.addSpawn(EntityClassification.WATER_AMBIENT,
                    new MobSpawnInfo.Spawners(ModEntityTypes.TIGERBARB.get(), CreaturesConfig.tigerbarb_spawn_weight.get(), CreaturesConfig.tigerbarb_min_group.get(), CreaturesConfig.tigerbarb_max_group.get()));
        }
        if (CreaturesConfig.piranha_spawns.get() && types.contains(BiomeDictionary.Type.RIVER) && !types.contains(BiomeDictionary.Type.COLD)) {
            spawns.addSpawn(EntityClassification.WATER_AMBIENT,
                    new MobSpawnInfo.Spawners(ModEntityTypes.PIRANHA.get(), CreaturesConfig.piranha_spawn_weight.get(), CreaturesConfig.piranha_min_group.get(), CreaturesConfig.piranha_max_group.get()));
        }

        if (CreaturesConfig.tambaqui_spawns.get() && types.contains(BiomeDictionary.Type.RIVER) && !types.contains(BiomeDictionary.Type.COLD)) {
            spawns.addSpawn(EntityClassification.WATER_AMBIENT,
                    new MobSpawnInfo.Spawners(ModEntityTypes.TAMBAQUI.get(), CreaturesConfig.tambaqui_spawn_weight.get(), CreaturesConfig.tambaqui_min_group.get(), CreaturesConfig.tambaqui_max_group.get()));
        }
        if (CreaturesConfig.elephantnose_spawns.get() && types.contains(BiomeDictionary.Type.RIVER) && !types.contains(BiomeDictionary.Type.COLD)) {
            spawns.addSpawn(EntityClassification.WATER_AMBIENT,
                    new MobSpawnInfo.Spawners(ModEntityTypes.ELEPHANTNOSE.get(), CreaturesConfig.elephantnose_spawn_weight.get(), CreaturesConfig.elephantnose_min_group.get(), CreaturesConfig.elephantnose_max_group.get()));
        }
        if (CreaturesConfig.stork_spawns.get() && (!types.contains(BiomeDictionary.Type.NETHER) && (types.contains(BiomeDictionary.Type.SWAMP)))) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.PHEASANT.get(), CreaturesConfig.stork_spawn_weight.get(), CreaturesConfig.stork_min_group.get(), CreaturesConfig.stork_max_group.get()));
        }   if (CreaturesConfig.whistlingduck_spawns.get() && (!types.contains(BiomeDictionary.Type.NETHER) && (types.contains(BiomeDictionary.Type.SWAMP)))) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.WHISTLINGDUCK.get(), CreaturesConfig.whistlingduck_spawn_weight.get(), CreaturesConfig.whistlingduck_min_group.get(), CreaturesConfig.whistlingduck_max_group.get()));
        }   if (CreaturesConfig.groundhornbill_spawns.get() && (!types.contains(BiomeDictionary.Type.NETHER) && (types.contains(BiomeDictionary.Type.SAVANNA)))) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.GROUND_HORNBILL.get(), CreaturesConfig.groundhornbill_spawn_weight.get(), CreaturesConfig.groundhornbill_min_group.get(), CreaturesConfig.groundhornbill_max_group.get()));
        }   if (CreaturesConfig.secretarybird_spawns.get() && (!types.contains(BiomeDictionary.Type.NETHER) && (types.contains(BiomeDictionary.Type.SAVANNA)))) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.SECRETARYBIRD.get(), CreaturesConfig.secretarybird_spawn_weight.get(), CreaturesConfig.secretarybird_min_group.get(), CreaturesConfig.secretarybird_max_group.get()));
        }   if (CreaturesConfig.shoebill_spawns.get() && (!types.contains(BiomeDictionary.Type.NETHER) && (types.contains(BiomeDictionary.Type.SWAMP)))) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.SHOEBILL.get(), CreaturesConfig.shoebill_spawn_weight.get(), CreaturesConfig.shoebill_min_group.get(), CreaturesConfig.shoebill_max_group.get()));
        }   if (CreaturesConfig.cormorant_spawns.get() && (!types.contains(BiomeDictionary.Type.NETHER) && (types.contains(BiomeDictionary.Type.BEACH)))) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.CORMORANT.get(), CreaturesConfig.cormorant_spawn_weight.get(), CreaturesConfig.cormorant_min_group.get(), CreaturesConfig.cormorant_max_group.get()));
        }   if (CreaturesConfig.starling_spawns.get() && (!types.contains(BiomeDictionary.Type.NETHER) && (types.contains(BiomeDictionary.Type.SAVANNA)))) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.STARLING.get(), CreaturesConfig.starling_spawn_weight.get(), CreaturesConfig.starling_min_group.get(), CreaturesConfig.starling_max_group.get()));
        }   if (CreaturesConfig.stingray_spawns.get() && (!types.contains(BiomeDictionary.Type.NETHER) && (types.contains(BiomeDictionary.Type.OCEAN)) && types.contains(BiomeDictionary.Type.HOT))) {
            spawns.addSpawn(EntityClassification.WATER_AMBIENT,
                    new MobSpawnInfo.Spawners(ModEntityTypes.STINGRAY.get(), CreaturesConfig.stingray_spawn_weight.get(), CreaturesConfig.stingray_min_group.get(), CreaturesConfig.stingray_max_group.get()));
        }   if (CreaturesConfig.puffin_spawns.get() && (!types.contains(BiomeDictionary.Type.NETHER) && (types.contains(BiomeDictionary.Type.BEACH)) && (types.contains(BiomeDictionary.Type.COLD)) )) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.PUFFIN.get(), CreaturesConfig.puffin_spawn_weight.get(), CreaturesConfig.puffin_min_group.get(), CreaturesConfig.puffin_max_group.get()));
        }   if (CreaturesConfig.sawfish_spawns.get() && (!types.contains(BiomeDictionary.Type.NETHER) && (types.contains(BiomeDictionary.Type.OCEAN)) && !(types.contains(BiomeDictionary.Type.COLD)) )) {
            spawns.addSpawn(EntityClassification.WATER_AMBIENT,
                    new MobSpawnInfo.Spawners(ModEntityTypes.SAWFISH.get(), CreaturesConfig.sawfish_spawn_weight.get(), CreaturesConfig.sawfish_min_group.get(), CreaturesConfig.sawfish_max_group.get()));
        }   if (CreaturesConfig.seagull_spawns.get() && (!types.contains(BiomeDictionary.Type.NETHER) && (types.contains(BiomeDictionary.Type.BEACH)) )) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.SEAGULL.get(), CreaturesConfig.seagull_spawn_weight.get(), CreaturesConfig.seagull_min_group.get(), CreaturesConfig.seagull_max_group.get()));
        }   if (CreaturesConfig.swordfish_spawns.get() && (!types.contains(BiomeDictionary.Type.NETHER) && (types.contains(BiomeDictionary.Type.OCEAN)) )) {
            spawns.addSpawn(EntityClassification.WATER_AMBIENT,
                    new MobSpawnInfo.Spawners(ModEntityTypes.SWORDFISH.get(), CreaturesConfig.swordfish_spawn_weight.get(), CreaturesConfig.swordfish_min_group.get(), CreaturesConfig.swordfish_max_group.get()));
        }   if (CreaturesConfig.booby_spawns.get() && (!types.contains(BiomeDictionary.Type.NETHER) && (types.contains(BiomeDictionary.Type.BEACH))&& !(types.contains(BiomeDictionary.Type.COLD)) )) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.BOOBY.get(), CreaturesConfig.booby_spawn_weight.get(), CreaturesConfig.booby_min_group.get(), CreaturesConfig.booby_max_group.get()));
        }   if (CreaturesConfig.squid_spawns.get() && (!types.contains(BiomeDictionary.Type.NETHER) && (types.contains(BiomeDictionary.Type.OCEAN)) )) {
            spawns.addSpawn(EntityClassification.WATER_AMBIENT,
                    new MobSpawnInfo.Spawners(ModEntityTypes.SQUID.get(), CreaturesConfig.squid_spawn_weight.get(), CreaturesConfig.squid_min_group.get(), CreaturesConfig.squid_max_group.get()));
        }   if (CreaturesConfig.lookdown_spawns.get() && (!types.contains(BiomeDictionary.Type.NETHER) && (types.contains(BiomeDictionary.Type.OCEAN))&& !(types.contains(BiomeDictionary.Type.COLD)) )) {
            spawns.addSpawn(EntityClassification.WATER_AMBIENT,
                    new MobSpawnInfo.Spawners(ModEntityTypes.LOOKDOWN.get(), CreaturesConfig.lookdown_spawn_weight.get(), CreaturesConfig.lookdown_min_group.get(), CreaturesConfig.lookdown_max_group.get()));
        }   if (CreaturesConfig.penguin_spawns.get()) {
            if (types.contains(BiomeDictionary.Type.COLD) && types.contains(BiomeDictionary.Type.SNOWY) && !types.contains(BiomeDictionary.Type.FOREST) && !types.contains(BiomeDictionary.Type.MOUNTAIN)) {
                spawns.addSpawn(EntityClassification.CREATURE,
                        new MobSpawnInfo.Spawners(ModEntityTypes.LARGE_PENGUIN.get(), CreaturesConfig.penguin_spawn_weight.get(), CreaturesConfig.penguin_min_group.get(), CreaturesConfig.penguin_max_group.get()));
                spawns.addSpawn(EntityClassification.CREATURE,
                        new MobSpawnInfo.Spawners(ModEntityTypes.BRUSH_TAILED_PENGUIN.get(), CreaturesConfig.penguin_spawn_weight.get(), CreaturesConfig.penguin_min_group.get(), CreaturesConfig.penguin_max_group.get()));
            }
            if (types.contains(BiomeDictionary.Type.BEACH)) {
                if (!(types.contains(BiomeDictionary.Type.COLD))) {
                    spawns.addSpawn(EntityClassification.CREATURE,
                            new MobSpawnInfo.Spawners(ModEntityTypes.BANDED_PENGUIN.get(), CreaturesConfig.penguin_spawn_weight.get(), CreaturesConfig.penguin_min_group.get(), CreaturesConfig.penguin_max_group.get()));
                    spawns.addSpawn(EntityClassification.CREATURE,
                            new MobSpawnInfo.Spawners(ModEntityTypes.YELLOW_EYED_PENGUIN.get(), CreaturesConfig.penguin_spawn_weight.get(), CreaturesConfig.penguin_min_group.get(), CreaturesConfig.penguin_max_group.get()));
                    spawns.addSpawn(EntityClassification.CREATURE,
                            new MobSpawnInfo.Spawners(ModEntityTypes.CRESTED_PENGUIN.get(), CreaturesConfig.penguin_spawn_weight.get(), CreaturesConfig.penguin_min_group.get(), CreaturesConfig.penguin_max_group.get()));
                    spawns.addSpawn(EntityClassification.CREATURE,
                            new MobSpawnInfo.Spawners(ModEntityTypes.LITTLE_PENGUIN.get(), CreaturesConfig.penguin_spawn_weight.get(), CreaturesConfig.penguin_min_group.get(), CreaturesConfig.penguin_max_group.get()));
                }


            }

        }   if (CreaturesConfig.mantisshrimp_spawns.get() && (!types.contains(BiomeDictionary.Type.NETHER) && (types.contains(BiomeDictionary.Type.OCEAN))&& (types.contains(BiomeDictionary.Type.HOT)) )) {
            spawns.addSpawn(EntityClassification.WATER_AMBIENT,
                    new MobSpawnInfo.Spawners(ModEntityTypes.MANTIS_SHRIMP.get(), CreaturesConfig.mantisshrimp_spawn_weight.get(), CreaturesConfig.mantisshrimp_min_group.get(), CreaturesConfig.mantisshrimp_max_group.get()));
        }   if (CreaturesConfig.rail_spawns.get() && (!types.contains(BiomeDictionary.Type.NETHER) && (types.contains(BiomeDictionary.Type.FOREST))&& !(types.contains(BiomeDictionary.Type.COLD)) )) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.RAIL.get(), CreaturesConfig.rail_spawn_weight.get(), CreaturesConfig.rail_min_group.get(), CreaturesConfig.rail_max_group.get()));
        }   if (CreaturesConfig.barracuda_spawns.get() && (!types.contains(BiomeDictionary.Type.NETHER) && (types.contains(BiomeDictionary.Type.OCEAN))&& (types.contains(BiomeDictionary.Type.HOT)) )) {
            spawns.addSpawn(EntityClassification.WATER_AMBIENT,
                    new MobSpawnInfo.Spawners(ModEntityTypes.BARRACUDA.get(), CreaturesConfig.barracuda_spawn_weight.get(), CreaturesConfig.barracuda_min_group.get(), CreaturesConfig.barracuda_max_group.get()));
        }   if (CreaturesConfig.avocet_spawns.get() && (!types.contains(BiomeDictionary.Type.NETHER) && (types.contains(BiomeDictionary.Type.SWAMP)) )) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.AVOCET.get(), CreaturesConfig.avocet_spawn_weight.get(), CreaturesConfig.avocet_min_group.get(), CreaturesConfig.avocet_max_group.get()));
        }   if (CreaturesConfig.seadragon_spawns.get() && (!types.contains(BiomeDictionary.Type.NETHER) && (types.contains(BiomeDictionary.Type.OCEAN))&& (types.contains(BiomeDictionary.Type.HOT)) )) {
            spawns.addSpawn(EntityClassification.WATER_AMBIENT,
                    new MobSpawnInfo.Spawners(ModEntityTypes.SEADRAGON.get(), CreaturesConfig.seadragon_spawn_weight.get(), CreaturesConfig.seadragon_min_group.get(), CreaturesConfig.seadragon_max_group.get()));
        }   if (CreaturesConfig.trumpetfish_spawns.get() && (!types.contains(BiomeDictionary.Type.NETHER) && (types.contains(BiomeDictionary.Type.OCEAN))&& (types.contains(BiomeDictionary.Type.HOT)) )) {
            spawns.addSpawn(EntityClassification.WATER_AMBIENT,
                    new MobSpawnInfo.Spawners(ModEntityTypes.TRUMPETFISH.get(), CreaturesConfig.trumpetfish_spawn_weight.get(), CreaturesConfig.trumpetfish_min_group.get(), CreaturesConfig.trumpetfish_max_group.get()));
        }   if (CreaturesConfig.parrotfish_spawns.get() && (!types.contains(BiomeDictionary.Type.NETHER) && (types.contains(BiomeDictionary.Type.OCEAN))&& (types.contains(BiomeDictionary.Type.HOT)) )) {
            spawns.addSpawn(EntityClassification.WATER_AMBIENT,
                    new MobSpawnInfo.Spawners(ModEntityTypes.PARROTFISH.get(), CreaturesConfig.parrotfish_spawn_weight.get(), CreaturesConfig.parrotfish_min_group.get(), CreaturesConfig.parrotfish_max_group.get()));
        }   if (CreaturesConfig.frigate_spawns.get() && (!types.contains(BiomeDictionary.Type.NETHER) && (types.contains(BiomeDictionary.Type.BEACH))&& !(types.contains(BiomeDictionary.Type.COLD)) )) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.FRIGATE.get(), CreaturesConfig.frigate_spawn_weight.get(), CreaturesConfig.frigate_min_group.get(), CreaturesConfig.frigate_max_group.get()));
        }   if (CreaturesConfig.clownfish_spawns.get() && (!types.contains(BiomeDictionary.Type.NETHER) && (types.contains(BiomeDictionary.Type.OCEAN))&& (types.contains(BiomeDictionary.Type.HOT)) )) {
            spawns.addSpawn(EntityClassification.WATER_AMBIENT,
                    new MobSpawnInfo.Spawners(ModEntityTypes.CLOWNFISH.get(), CreaturesConfig.clownfish_spawn_weight.get(), CreaturesConfig.clownfish_min_group.get(), CreaturesConfig.clownfish_max_group.get()));
        }   if (CreaturesConfig.stilt_spawns.get() && (!types.contains(BiomeDictionary.Type.NETHER) && (types.contains(BiomeDictionary.Type.SWAMP)) )) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.STILT.get(), CreaturesConfig.stilt_spawn_weight.get(), CreaturesConfig.stilt_min_group.get(), CreaturesConfig.stilt_max_group.get()));
        }   if (CreaturesConfig.lungfish_spawns.get() && (types.contains(BiomeDictionary.Type.OVERWORLD) && (types.contains(BiomeDictionary.Type.SWAMP)) )) {
            spawns.addSpawn(EntityClassification.WATER_AMBIENT,
                    new MobSpawnInfo.Spawners(ModEntityTypes.LUNGFISH.get(), CreaturesConfig.lungfish_spawn_weight.get(), CreaturesConfig.lungfish_min_group.get(), CreaturesConfig.lungfish_max_group.get()));
        }  if (CreaturesConfig.ediblecrab_spawns.get() && types.contains(BiomeDictionary.Type.OCEAN)) {
            spawns.addSpawn(EntityClassification.CREATURE,
                    new MobSpawnInfo.Spawners(ModEntityTypes.EDIBLE_CRAB.get(), CreaturesConfig.ediblecrab_spawn_weight.get(), CreaturesConfig.ediblecrab_min_group.get(), CreaturesConfig.ediblecrab_max_group.get()));
        }


    }


}
