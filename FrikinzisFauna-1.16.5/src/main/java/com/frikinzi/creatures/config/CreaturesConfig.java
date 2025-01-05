package com.frikinzi.creatures.config;

import com.google.common.collect.Lists;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class CreaturesConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> koi_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Boolean> koi_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> koi_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> koi_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> koi_hatch_chance;

    public static final ForgeConfigSpec.ConfigValue<Boolean> lovebird_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> lovebird_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> lovebird_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> lovebird_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> lovebird_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> lovebird_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> dottyback_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> dottyback_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> dottyback_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> dottyback_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> dottyback_hatch_chance;

    public static final ForgeConfigSpec.ConfigValue<Boolean> pike_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> pike_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> pike_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> pike_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> pike_hatch_chance;

    public static final ForgeConfigSpec.ConfigValue<Boolean> guppy_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> guppy_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> guppy_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> guppy_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> guppy_hatch_chance;

    public static final ForgeConfigSpec.ConfigValue<Boolean> shrimp_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> shrimp_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> shrimp_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> shrimp_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> shrimp_hatch_chance;

    public static final ForgeConfigSpec.ConfigValue<Boolean> gourami_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> gourami_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> gourami_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> gourami_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> gourami_hatch_chance;

    public static final ForgeConfigSpec.ConfigValue<Boolean> arowana_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> arowana_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> arowana_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> arowana_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> arowana_hatch_chance;

    public static final ForgeConfigSpec.ConfigValue<Boolean> ghost_crab_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> ghost_crab_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> ghost_crab_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> ghost_crab_max_group;

    public static final ForgeConfigSpec.ConfigValue<Boolean> lorikeet_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> lorikeet_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> lorikeet_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> lorikeet_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> lorikeet_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> lorikeet_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> conure_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> conure_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> conure_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> conure_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> conure_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> conure_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> spoonbill_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> spoonbill_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> spoonbill_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> spoonbill_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> spoonbill_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> spoonbill_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> dove_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> dove_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> dove_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> dove_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> dove_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> dove_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> mandarin_duck_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> mandarin_duck_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> mandarin_duck_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> mandarin_duck_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> mandarin_duck_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> mandarin_duck_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> kakapo_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> kakapo_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> kakapo_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> kakapo_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> kakapo_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> kakapo_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> raven_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> raven_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> raven_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> raven_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> raven_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> raven_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> fairywren_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> fairywren_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> fairywren_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> fairywren_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> fairywren_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> fairywren_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> golden_eagle_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> golden_eagle_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> golden_eagle_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> golden_eagle_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> golden_eagle_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> golden_eagle_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> gyrfalcon_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> gyrfalcon_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> gyrfalcon_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> gyrfalcon_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> gyrfalcon_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> gyrfalcon_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> red_kite_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> red_kite_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> red_kite_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> red_kite_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> red_kite_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> red_kite_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> stellers_sea_eagle_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> stellers_sea_eagle_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> stellers_sea_eagle_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> stellers_sea_eagle_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> stellers_sea_eagle_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> stellers_sea_eagle_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> pygmy_falcon_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> pygmy_falcon_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> pygmy_falcon_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> pygmy_falcon_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> pygmy_falcon_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> pygmy_falcon_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> barn_owl_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> barn_owl_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> barn_owl_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> barn_owl_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> barn_owl_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> barn_owl_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> goldfish_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> goldfish_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> goldfish_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> goldfish_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> goldfish_hatch_chance;

    public static final ForgeConfigSpec.ConfigValue<Boolean> ranchu_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> ranchu_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> ranchu_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> ranchu_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> ranchu_hatch_chance;

    public static final ForgeConfigSpec.ConfigValue<Boolean> wild_duck_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> wild_duck_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> wild_duck_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> wild_duck_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> wild_duck_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> wild_duck_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> roller_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> roller_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> roller_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> roller_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> roller_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> roller_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> chickadee_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> chickadee_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> chickadee_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> chickadee_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> chickadee_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> chickadee_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> pygmy_goose_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> pygmy_goose_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> pygmy_goose_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> pygmy_goose_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> pygmy_goose_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> pygmy_goose_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> swallow_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> swallow_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> swallow_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> swallow_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> swallow_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> swallow_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> fire_goby_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> fire_goby_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> fire_goby_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> fire_goby_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> fire_goby_hatch_chance;

    public static final ForgeConfigSpec.ConfigValue<Boolean> blue_tang_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> blue_tang_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> blue_tang_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> blue_tang_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> blue_tang_hatch_chance;

    public static final ForgeConfigSpec.ConfigValue<Boolean> flame_angelfish_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> flame_angelfish_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> flame_angelfish_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> flame_angelfish_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> flame_angelfish_hatch_chance;

    public static final ForgeConfigSpec.ConfigValue<Boolean> trout_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> trout_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> trout_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> trout_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> trout_hatch_chance;

    public static final ForgeConfigSpec.ConfigValue<Boolean> fiddler_crab_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> fiddler_crab_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> fiddler_crab_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> fiddler_crab_max_group;

    public static final ForgeConfigSpec.ConfigValue<Boolean> ibis_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> ibis_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> ibis_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> ibis_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> ibis_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> ibis_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> red_snapper_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> red_snapper_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> red_snapper_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> red_snapper_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> red_snapper_hatch_chance;

    public static final ForgeConfigSpec.ConfigValue<Boolean> wood_duck_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> wood_duck_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> wood_duck_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> wood_duck_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> wood_duck_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> wood_duck_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> peafowl_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> peafowl_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> peafowl_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> peafowl_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> peafowl_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> peafowl_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> sparrow_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> sparrow_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> sparrow_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> sparrow_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> sparrow_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> sparrow_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> bushtit_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> bushtit_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> bushtit_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> bushtit_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> bushtit_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> bushtit_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> laughingthrush_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> laughingthrush_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> laughingthrush_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> laughingthrush_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> laughingthrush_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> laughingthrush_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> eagleowl_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> eagleowl_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> eagleowl_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> eagleowl_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> eagleowl_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> eagleowl_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> robin_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> robin_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> robin_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> robin_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> robin_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> robin_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> magpie_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> magpie_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> magpie_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> magpie_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> magpie_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> magpie_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> goose_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> goose_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> goose_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> goose_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> goose_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> goose_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> osprey_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> osprey_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> osprey_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> osprey_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> osprey_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> osprey_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> kingfisher_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> kingfisher_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> kingfisher_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> kingfisher_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> kingfisher_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> kingfisher_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> pelican_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> pelican_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> pelican_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> pelican_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> pelican_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> pelican_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> lapwing_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> lapwing_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> lapwing_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> lapwing_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> lapwing_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> lapwing_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> skua_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> skua_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> skua_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> skua_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> skua_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> skua_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> bunting_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> bunting_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> bunting_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> bunting_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> bunting_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> bunting_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> monal_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> monal_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> monal_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> monal_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> monal_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> monal_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> tanager_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> tanager_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> tanager_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> tanager_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> tanager_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> tanager_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> finch_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> finch_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> finch_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> finch_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> finch_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> finch_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> tarantula_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> tarantula_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> tarantula_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> tarantula_max_group;

    public static final ForgeConfigSpec.ConfigValue<Boolean> capercaillie_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> capercaillie_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> capercaillie_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> capercaillie_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> capercaillie_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> capercaillie_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> pheasant_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> pheasant_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> pheasant_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> pheasant_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> pheasant_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> pheasant_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> vampirecrab_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> vampirecrab_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> vampirecrab_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> vampirecrab_max_group;

    public static final ForgeConfigSpec.ConfigValue<Integer> arapaima_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Boolean> arapaima_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> arapaima_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> arapaima_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> arapaima_hatch_chance;

    public static final ForgeConfigSpec.ConfigValue<Integer> tigerbarb_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Boolean> tigerbarb_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> tigerbarb_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> tigerbarb_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> tigerbarb_hatch_chance;

    public static final ForgeConfigSpec.ConfigValue<Integer> piranha_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Boolean> piranha_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> piranha_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> piranha_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> piranha_hatch_chance;

    public static final ForgeConfigSpec.ConfigValue<Boolean> stork_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> stork_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> stork_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> stork_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> stork_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> stork_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> whistlingduck_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> whistlingduck_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> whistlingduck_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> whistlingduck_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> whistlingduck_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> whistlingduck_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> groundhornbill_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> groundhornbill_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> groundhornbill_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> groundhornbill_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> groundhornbill_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> groundhornbill_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> secretarybird_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> secretarybird_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> secretarybird_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> secretarybird_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> secretarybird_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> secretarybird_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> shoebill_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> shoebill_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> shoebill_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> shoebill_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> shoebill_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> shoebill_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> starling_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> starling_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> starling_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> starling_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> starling_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> starling_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Integer> tambaqui_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Boolean> tambaqui_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> tambaqui_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> tambaqui_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> tambaqui_hatch_chance;

    public static final ForgeConfigSpec.ConfigValue<Integer> elephantnose_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Boolean> elephantnose_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> elephantnose_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> elephantnose_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> elephantnose_hatch_chance;

    public static final ForgeConfigSpec.ConfigValue<Boolean> cormorant_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> cormorant_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> cormorant_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> cormorant_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> cormorant_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> cormorant_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> puffin_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> puffin_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> puffin_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> puffin_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> puffin_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> puffin_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> seagull_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> seagull_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> seagull_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> seagull_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> seagull_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> seagull_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Integer> swordfish_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Boolean> swordfish_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> swordfish_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> swordfish_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> swordfish_hatch_chance;

    public static final ForgeConfigSpec.ConfigValue<Boolean> booby_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> booby_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> booby_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> booby_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> booby_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> booby_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Integer> lookdown_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Boolean> lookdown_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> lookdown_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> lookdown_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> lookdown_hatch_chance;

    public static final ForgeConfigSpec.ConfigValue<Integer> sawfish_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Boolean> sawfish_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> sawfish_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> sawfish_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> sawfish_hatch_chance;

    public static final ForgeConfigSpec.ConfigValue<Integer> squid_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Boolean> squid_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> squid_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> squid_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> squid_hatch_chance;

    public static final ForgeConfigSpec.ConfigValue<Integer> mantisshrimp_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Boolean> mantisshrimp_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> mantisshrimp_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> mantisshrimp_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> mantisshrimp_hatch_chance;

    public static final ForgeConfigSpec.ConfigValue<Boolean> penguin_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> penguin_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> penguin_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> penguin_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> penguin_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> penguin_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Boolean> rail_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> rail_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> rail_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> rail_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> rail_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> rail_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Integer> barracuda_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Boolean> barracuda_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> barracuda_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> barracuda_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> barracuda_hatch_chance;

    public static final ForgeConfigSpec.ConfigValue<Boolean> avocet_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> avocet_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> avocet_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> avocet_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> avocet_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> avocet_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Integer> seadragon_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Boolean> seadragon_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> seadragon_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> seadragon_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> seadragon_hatch_chance;

    public static final ForgeConfigSpec.ConfigValue<Integer> trumpetfish_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Boolean> trumpetfish_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> trumpetfish_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> trumpetfish_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> trumpetfish_hatch_chance;

    public static final ForgeConfigSpec.ConfigValue<Integer> parrotfish_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Boolean> parrotfish_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> parrotfish_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> parrotfish_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> parrotfish_hatch_chance;

    public static final ForgeConfigSpec.ConfigValue<Boolean> frigate_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> frigate_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> frigate_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> frigate_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> frigate_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> frigate_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Integer> clownfish_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Boolean> clownfish_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> clownfish_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> clownfish_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> clownfish_hatch_chance;

    public static final ForgeConfigSpec.ConfigValue<Boolean> stilt_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> stilt_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> stilt_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> stilt_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> stilt_hatch_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> stilt_clutch_size;

    public static final ForgeConfigSpec.ConfigValue<Integer> stingray_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Boolean> stingray_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> stingray_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> stingray_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> stingray_hatch_chance;

    public static final ForgeConfigSpec.ConfigValue<Integer> lungfish_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Boolean> lungfish_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> lungfish_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> lungfish_max_group;
    public static final ForgeConfigSpec.ConfigValue<Double> lungfish_hatch_chance;

    public static final ForgeConfigSpec.ConfigValue<Boolean> ediblecrab_spawns;
    public static final ForgeConfigSpec.ConfigValue<Integer> ediblecrab_spawn_weight;
    public static final ForgeConfigSpec.ConfigValue<Integer> ediblecrab_min_group;
    public static final ForgeConfigSpec.ConfigValue<Integer> ediblecrab_max_group;

    //gameplay
    public static final ForgeConfigSpec.ConfigValue<Boolean> breed_only_variants;
    public static final ForgeConfigSpec.ConfigValue<Boolean> biome_only_variants;
    public static final ForgeConfigSpec.ConfigValue<Boolean> following;
    public static final ForgeConfigSpec.ConfigValue<Boolean> teleporting;
    public static final ForgeConfigSpec.ConfigValue<Double> teleporting_distance;
    public static final ForgeConfigSpec.ConfigValue<Boolean> raptor_attacks;
    public static final ForgeConfigSpec.ConfigValue<Boolean> raptor_throws;
    public static final ForgeConfigSpec.ConfigValue<Integer> raven_albino_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> lovebird_mutation_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> lorikeet_mutation_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> puffin_mutation_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> penguin_mutation_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> peafowl_mutation_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> swordfish_mutation_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> arapaima_mutation_chance;
    public static final ForgeConfigSpec.ConfigValue<Double> height_base_multiplier;
    public static final ForgeConfigSpec.ConfigValue<Double> height_standard_deviation;
    public static final ForgeConfigSpec.ConfigValue<Boolean> height_on;
    public static final ForgeConfigSpec.ConfigValue<Boolean> drop_feather;
    public static final ForgeConfigSpec.ConfigValue<Integer> base_egg_hatch_time;

    static {
        BUILDER.push("Koi");

        koi_spawns = BUILDER.comment("Enable/disable koi spawns").define("Koi Spawns", true);
        koi_spawn_weight = BUILDER.comment("Spawn weight for koi").define("Koi Spawn Weight", 10);
        koi_min_group = BUILDER.comment("Min group for koi").define("Koi Min Group", 1);
        koi_max_group = BUILDER.comment("Max group for koi").define("Koi Max Group", 2);
        koi_hatch_chance = BUILDER.comment("Hatch chance for each koi roe").define("Koi Hatch Chance", 0.2);

        BUILDER.pop();

        BUILDER.push("Lovebird");

        lovebird_spawns = BUILDER.comment("Enable/disable lovebird spawns").define("Lovebird Spawns", true);
        lovebird_spawn_weight = BUILDER.comment("Spawn weight for lovebirds").define("Lovebird Spawn Weight", 20);
        lovebird_min_group = BUILDER.comment("Min group for lovebirds").define("Lovebird Min Group", 3);
        lovebird_max_group = BUILDER.comment("Max group for lovebirds").define("Lovebird Max Group", 6);
        lovebird_hatch_chance = BUILDER.comment("Hatch chance for each lovebird egg").define("Lovebird Hatch Chance", 0.5);
        lovebird_clutch_size = BUILDER.comment("Max egg clutch size for lovebirds").define("Lovebird Clutch Size", 4);

        BUILDER.pop();

        BUILDER.push("Dottyback");

        dottyback_spawns = BUILDER.comment("Enable/disable dottyback spawns").define("Dottyback Spawns", true);
        dottyback_spawn_weight = BUILDER.comment("Spawn weight for dottybacks").define("Dottyback Spawn Weight", 20);
        dottyback_min_group = BUILDER.comment("Min group for dottybacks").define("Dottyback Min Group", 2);
        dottyback_max_group = BUILDER.comment("Max group for dottybacks").define("Dottyback Max Group", 3);
        dottyback_hatch_chance = BUILDER.comment("Hatch chance for each dottyback roe").define("Dottyback Hatch Chance", 0.2);

        BUILDER.pop();

        BUILDER.push("Pike");

        pike_spawns = BUILDER.comment("Enable/disable pike spawns").define("Pike Spawns", true);
        pike_spawn_weight = BUILDER.comment("Spawn weight for pikes").define("Pike Spawn Weight", 8);
        pike_min_group = BUILDER.comment("Min group for pikes").define("Pike Min Group", 1);
        pike_max_group = BUILDER.comment("Max group for pikes").define("Pike Max Group", 1);
        pike_hatch_chance = BUILDER.comment("Hatch chance for each pike roe").define("Pike Hatch Chance", 0.2);

        BUILDER.pop();

        BUILDER.push("Guppy");

        guppy_spawns = BUILDER.comment("Enable/disable guppy spawns").define("Guppy Spawns", true);
        guppy_spawn_weight = BUILDER.comment("Spawn weight for guppies").define("Guppy Spawn Weight", 10);
        guppy_min_group = BUILDER.comment("Min group for guppies").define("Guppy Min Group", 3);
        guppy_max_group = BUILDER.comment("Max group for guppies").define("Guppy Max Group", 8);
        guppy_hatch_chance = BUILDER.comment("Hatch chance for each guppy roe").define("Guppy Hatch Chance", 0.2);

        BUILDER.pop();

        BUILDER.push("Shrimp");

        shrimp_spawns = BUILDER.comment("Enable/disable shrimp spawns").define("Shrimp Spawns", true);
        shrimp_spawn_weight = BUILDER.comment("Spawn weight for shrimp").define("Shrimp Spawn Weight", 10);
        shrimp_min_group = BUILDER.comment("Min group for shrimp").define("Shrimp Min Group", 4);
        shrimp_max_group = BUILDER.comment("Max group for shrimp").define("Shrimp Max Group", 10);
        shrimp_hatch_chance = BUILDER.comment("Hatch chance for each shrimp roe").define("Shrimp Hatch Chance", 0.3);

        BUILDER.pop();

        BUILDER.push("Gourami");

        gourami_spawns = BUILDER.comment("Enable/disable gourami spawns").define("Gourami Spawns", true);
        gourami_spawn_weight = BUILDER.comment("Spawn weight for gourami").define("Gourami Spawn Weight", 10);
        gourami_min_group = BUILDER.comment("Min group for gourami").define("Gourami Min Group", 1);
        gourami_max_group = BUILDER.comment("Max group for gourami").define("Gourami Max Group", 1);
        gourami_hatch_chance = BUILDER.comment("Hatch chance for each gourami roe").define("Gourami Hatch Chance", 0.2);

        BUILDER.pop();

        BUILDER.push("Arowana");

        arowana_spawns = BUILDER.comment("Enable/disable arowana spawns").define("Arowana Spawns", true);
        arowana_spawn_weight = BUILDER.comment("Spawn weight for arowana").define("Arowana Spawn Weight", 5);
        arowana_min_group = BUILDER.comment("Min group for arowana").define("Arowana Min Group", 1);
        arowana_max_group = BUILDER.comment("Max group for arowana").define("Arowana Max Group", 1);
        arowana_hatch_chance = BUILDER.comment("Hatch chance for each arowana roe").define("Arowana Hatch Chance", 0.1);

        BUILDER.pop();

        BUILDER.push("Ghost Crab");

        ghost_crab_spawns = BUILDER.comment("Enable/disable ghost crab spawns").define("Ghost Crab Spawns", true);
        ghost_crab_spawn_weight = BUILDER.comment("Spawn weight for ghost crab").define("Ghost Crab Spawn Weight", 20);
        ghost_crab_min_group = BUILDER.comment("Min group for ghost crab").define("Ghost Crab Min Group", 2);
        ghost_crab_max_group = BUILDER.comment("Max group for ghost crab").define("Ghost Crab Max Group", 5);

        BUILDER.pop();

        BUILDER.push("Lorikeet");

        lorikeet_spawns = BUILDER.comment("Enable/disable lorikeet spawns").define("Lorikeet Spawns", true);
        lorikeet_spawn_weight = BUILDER.comment("Spawn weight for lorikeet").define("Lorikeet Spawn Weight", 20);
        lorikeet_min_group = BUILDER.comment("Min group for lorikeet").define("Lorikeet Min Group", 2);
        lorikeet_max_group = BUILDER.comment("Max group for lorikeet").define("Lorikeet Max Group", 5);
        lorikeet_hatch_chance = BUILDER.comment("Hatch chance for each lorikeet egg").define("Lorikeet Hatch Chance", 0.4);
        lorikeet_clutch_size = BUILDER.comment("Max egg clutch size for lorikeets").define("Lorikeet Clutch Size", 4);

        BUILDER.pop();

        BUILDER.push("Conure");

        conure_spawns = BUILDER.comment("Enable/disable conure spawns").define("Conure Spawns", true);
        conure_spawn_weight = BUILDER.comment("Spawn weight for conure").define("Conure Spawn Weight", 20);
        conure_min_group = BUILDER.comment("Min group for conure").define("Conure Min Group", 3);
        conure_max_group = BUILDER.comment("Max group for conure").define("Conure Max Group", 5);
        conure_hatch_chance = BUILDER.comment("Hatch chance for each conure egg").define("Conure Hatch Chance", 0.5);
        conure_clutch_size = BUILDER.comment("Max egg clutch size for conures").define("Conure Clutch Size", 4);

        BUILDER.pop();

        BUILDER.push("Spoonbill");

        spoonbill_spawns = BUILDER.comment("Enable/disable spoonbill spawns").define("Spoonbill Spawns", true);
        spoonbill_spawn_weight = BUILDER.comment("Spawn weight for spoonbill").define("Spoonbill Spawn Weight", 15);
        spoonbill_min_group = BUILDER.comment("Min group for spoonbill").define("Spoonbill Min Group", 1);
        spoonbill_max_group = BUILDER.comment("Max group for spoonbill").define("Spoonbill Max Group", 2);
        spoonbill_hatch_chance = BUILDER.comment("Hatch chance for each spoonbill egg").define("Spoonbill Hatch Chance", 0.5);
        spoonbill_clutch_size = BUILDER.comment("Max egg clutch size for spoonbills").define("Spoonbill Clutch Size", 5);

        BUILDER.pop();

        BUILDER.push("Dove");

        dove_spawns = BUILDER.comment("Enable/disable dove spawns").define("Dove Spawns", true);
        dove_spawn_weight = BUILDER.comment("Spawn weight for dove").define("Dove Spawn Weight", 20);
        dove_min_group = BUILDER.comment("Min group for dove").define("Dove Min Group", 2);
        dove_max_group = BUILDER.comment("Max group for dove").define("Dove Max Group", 5);
        dove_hatch_chance = BUILDER.comment("Hatch chance for each dove egg").define("Dove Hatch Chance", 0.8);
        dove_clutch_size = BUILDER.comment("Max egg clutch size for doves").define("Dove Clutch Size", 2);

        BUILDER.pop();

        BUILDER.push("Mandarin Duck");

        mandarin_duck_spawns = BUILDER.comment("Enable/disable mandarin duck spawns").define("Mandarin Duck Spawns", true);
        mandarin_duck_spawn_weight = BUILDER.comment("Spawn weight for mandarin duck").define("Mandarin Duck Spawn Weight", 20);
        mandarin_duck_min_group = BUILDER.comment("Min group for mandarin duck").define("Mandarin Duck Min Group", 2);
        mandarin_duck_max_group = BUILDER.comment("Max group for mandarin duck").define("Mandarin Duck Max Group", 3);
        mandarin_duck_hatch_chance = BUILDER.comment("Hatch chance for each mandarin duck egg").define("Mandarin Duck Hatch Chance", 0.6);
        mandarin_duck_clutch_size = BUILDER.comment("Max egg clutch size for mandarin ducks").define("Mandarin Duck Clutch Size", 8);

        BUILDER.pop();

        BUILDER.push("Kakapo");

        kakapo_spawns = BUILDER.comment("Enable/disable kakapo spawns").define("Kakapo Spawns", true);
        kakapo_spawn_weight = BUILDER.comment("Spawn weight for kakapo").define("Kakapo Spawn Weight", 3);
        kakapo_min_group = BUILDER.comment("Min group for kakapo").define("Kakapo Min Group", 1);
        kakapo_max_group = BUILDER.comment("Max group for kakapo").define("Kakapo Max Group", 2);
        kakapo_hatch_chance = BUILDER.comment("Hatch chance for each kakapo egg").define("Kakapo Hatch Chance", 0.1);
        kakapo_clutch_size = BUILDER.comment("Max egg clutch size for kakapos").define("Kakapo Clutch Size", 4);

        BUILDER.pop();

        BUILDER.push("Raven");

        raven_spawns = BUILDER.comment("Enable/disable raven spawns").define("Raven Spawns", true);
        raven_spawn_weight = BUILDER.comment("Spawn weight for raven").define("Raven Spawn Weight", 25);
        raven_min_group = BUILDER.comment("Min group for raven").define("Raven Min Group", 1);
        raven_max_group = BUILDER.comment("Max group for raven").define("Raven Max Group", 3);
        raven_hatch_chance = BUILDER.comment("Hatch chance for each raven egg").define("Raven Hatch Chance", 0.4);
        raven_clutch_size = BUILDER.comment("Max egg clutch size for ravens").define("Raven Clutch Size", 7);

        BUILDER.pop();

        BUILDER.push("Fairywren");

        fairywren_spawns = BUILDER.comment("Enable/disable fairywren spawns").define("Fairywren Spawns", true);
        fairywren_spawn_weight = BUILDER.comment("Spawn weight for fairywren").define("Fairywren Spawn Weight", 30);
        fairywren_min_group = BUILDER.comment("Min group for fairywren").define("Fairywren Min Group", 3);
        fairywren_max_group = BUILDER.comment("Max group for fairywren").define("Fairywren Max Group", 6);
        fairywren_hatch_chance = BUILDER.comment("Hatch chance for each fairywren egg").define("Fairywren Hatch Chance", 0.4);
        fairywren_clutch_size = BUILDER.comment("Max egg clutch size for fairywrens").define("Fairywren Clutch Size", 4);

        BUILDER.pop();

        BUILDER.push("Golden Eagle");

        golden_eagle_spawns = BUILDER.comment("Enable/disable golden eagle spawns").define("Golden Eagle Spawns", true);
        golden_eagle_spawn_weight = BUILDER.comment("Spawn weight for golden eagle").define("Golden Eagle Spawn Weight", 5);
        golden_eagle_min_group = BUILDER.comment("Min group for golden eagle").define("Golden Eagle Min Group", 1);
        golden_eagle_max_group = BUILDER.comment("Max group for golden eagle").define("Golden Eagle Max Group", 2);
        golden_eagle_hatch_chance = BUILDER.comment("Hatch chance for each golden eagle egg").define("Golden Eagle Hatch Chance", 0.4);
        golden_eagle_clutch_size = BUILDER.comment("Max egg clutch size for golden eagles").define("Golden Eagle Clutch Size", 3);

        BUILDER.pop();

        BUILDER.push("Gyrfalcon");

        gyrfalcon_spawns = BUILDER.comment("Enable/disable gyrfalcon spawns").define("Gyrfalcon Spawns", true);
        gyrfalcon_spawn_weight = BUILDER.comment("Spawn weight for gyrfalcon").define("Gyrfalcon Spawn Weight", 5);
        gyrfalcon_min_group = BUILDER.comment("Min group for gyrfalcon").define("Gyrfalcon Min Group", 1);
        gyrfalcon_max_group = BUILDER.comment("Max group for gyrfalcon").define("Gyrfalcon Max Group", 2);
        gyrfalcon_hatch_chance = BUILDER.comment("Hatch chance for each gyrfalcon egg").define("Gyrfalcon Hatch Chance", 0.3);
        gyrfalcon_clutch_size = BUILDER.comment("Max egg clutch size for gyrfalcons").define("Gyrfalcon Clutch Size", 5);

        BUILDER.pop();

        BUILDER.push("Red Kite");

        red_kite_spawns = BUILDER.comment("Enable/disable red kite spawns").define("Red Kite Spawns", true);
        red_kite_spawn_weight = BUILDER.comment("Spawn weight for red kite").define("Red Kite Spawn Weight", 5);
        red_kite_min_group = BUILDER.comment("Min group for red kite").define("Red Kite Min Group", 1);
        red_kite_max_group = BUILDER.comment("Max group for red kite").define("Red Kite Max Group", 2);
        red_kite_hatch_chance = BUILDER.comment("Hatch chance for each red kite egg").define("Red Kite Hatch Chance", 0.3);
        red_kite_clutch_size = BUILDER.comment("Max egg clutch size for red kites").define("Red Kite Clutch Size", 4);

        BUILDER.pop();

        BUILDER.push("Steller's Sea Eagle");

        stellers_sea_eagle_spawns = BUILDER.comment("Enable/disable stellers sea eagle spawns").define("Stellers Sea Eagle Spawns", true);
        stellers_sea_eagle_spawn_weight = BUILDER.comment("Spawn weight for stellers sea eagle").define("Stellers Sea Eagle Spawn Weight", 3);
        stellers_sea_eagle_min_group = BUILDER.comment("Min group for stellers sea eagle").define("Stellers Sea Eagle Min Group", 1);
        stellers_sea_eagle_max_group = BUILDER.comment("Max group for stellers sea eagle").define("Stellers Sea Eagle Max Group", 2);
        stellers_sea_eagle_hatch_chance = BUILDER.comment("Hatch chance for each Steller's sea eagle egg").define("Steller's Sea Eagle Hatch Chance", 0.2);
        stellers_sea_eagle_clutch_size = BUILDER.comment("Max egg clutch size for Steller's sea eagles").define("Steller's Sea Eagle Clutch Size", 3);

        BUILDER.pop();

        BUILDER.push("Pygmy Falcon");

        pygmy_falcon_spawns = BUILDER.comment("Enable/disable pygmy falcon spawns").define("Pygmy Falcon Spawns", true);
        pygmy_falcon_spawn_weight = BUILDER.comment("Spawn weight for pygmy falcon").define("Pygmy Falcon Spawn Weight", 5);
        pygmy_falcon_min_group = BUILDER.comment("Min group for pygmy falcon").define("Pygmy Falcon Min Group", 1);
        pygmy_falcon_max_group = BUILDER.comment("Max group for pygmy falcon").define("Pygmy Falcon Max Group", 2);
        pygmy_falcon_hatch_chance = BUILDER.comment("Hatch chance for each pygmy falcon egg").define("Pygmy Falcon Hatch Chance", 0.3);
        pygmy_falcon_clutch_size = BUILDER.comment("Max egg clutch size for pygmy falcons").define("Pygmy Falcon Clutch Size", 4);

        BUILDER.pop();

        BUILDER.push("Barn Owl");

        barn_owl_spawns = BUILDER.comment("Enable/disable barn owl spawns").define("Barn Owl Spawns", true);
        barn_owl_spawn_weight = BUILDER.comment("Spawn weight for barn owl").define("Barn Owl Spawn Weight", 10);
        barn_owl_min_group = BUILDER.comment("Min group for barn owl").define("Barn Owl Min Group", 1);
        barn_owl_max_group = BUILDER.comment("Max group for barn owl").define("Barn Owl Max Group", 2);
        barn_owl_hatch_chance = BUILDER.comment("Hatch chance for each barn owl egg").define("Barn Owl Hatch Chance", 0.3);
        barn_owl_clutch_size = BUILDER.comment("Max egg clutch size for barn owls").define("Barn Owl Clutch Size", 7);

        BUILDER.pop();

        BUILDER.push("Goldfish");

        goldfish_spawns = BUILDER.comment("Enable/disable goldfish spawns").define("Goldfish Spawns", true);
        goldfish_spawn_weight = BUILDER.comment("Spawn weight for goldfish").define("Goldfish Spawn Weight", 10);
        goldfish_min_group = BUILDER.comment("Min group for goldfish").define("Goldfish Min Group", 2);
        goldfish_max_group = BUILDER.comment("Max group for goldfish").define("Goldfish Max Group", 5);
        goldfish_hatch_chance = BUILDER.comment("Hatch chance for each goldfish roe").define("Goldfish Hatch Chance", 0.2);

        BUILDER.pop();

        BUILDER.push("Ranchu");

        ranchu_spawns = BUILDER.comment("Enable/disable ranchu spawns").define("Ranchu Spawns", true);
        ranchu_spawn_weight = BUILDER.comment("Spawn weight for ranchu").define("Ranchu Spawn Weight", 10);
        ranchu_min_group = BUILDER.comment("Min group for ranchu").define("Ranchu Min Group", 1);
        ranchu_max_group = BUILDER.comment("Max group for ranchu").define("Ranchu Max Group", 2);
        ranchu_hatch_chance = BUILDER.comment("Hatch chance for each ranchu roe").define("Ranchu Hatch Chance", 0.2);

        BUILDER.pop();

        BUILDER.push("Wild Duck");

        wild_duck_spawns = BUILDER.comment("Enable/disable wild duck spawns").define("Wild Duck Spawns", true);
        wild_duck_spawn_weight = BUILDER.comment("Spawn weight for wild duck").define("Wild Duck Spawn Weight", 20);
        wild_duck_min_group = BUILDER.comment("Min group for wild duck").define("Wild Duck Min Group", 1);
        wild_duck_max_group = BUILDER.comment("Max group for wild duck").define("Wild Duck Max Group", 2);
        wild_duck_hatch_chance = BUILDER.comment("Hatch chance for each wild duck egg").define("Wild Duck Hatch Chance", 0.3);
        wild_duck_clutch_size = BUILDER.comment("Max egg clutch size for wild ducks").define("Wild Duck Clutch Size", 4);

        BUILDER.pop();

        BUILDER.push("Roller");

        roller_spawns = BUILDER.comment("Enable/disable roller spawns").define("Roller Spawns", true);
        roller_spawn_weight = BUILDER.comment("Spawn weight for roller").define("Roller Spawn Weight", 20);
        roller_min_group = BUILDER.comment("Min group for roller").define("Roller Min Group", 1);
        roller_max_group = BUILDER.comment("Max group for roller").define("Roller Max Group", 2);
        roller_hatch_chance = BUILDER.comment("Hatch chance for each roller egg").define("Roller Hatch Chance", 0.3);
        roller_clutch_size = BUILDER.comment("Max egg clutch size for rollers").define("Roller Clutch Size", 4);

        BUILDER.pop();

        BUILDER.push("Chickadee");

        chickadee_spawns = BUILDER.comment("Enable/disable chickadee spawns").define("Chickadee Spawns", true);
        chickadee_spawn_weight = BUILDER.comment("Spawn weight for chickadee").define("Chickadee Spawn Weight", 25);
        chickadee_min_group = BUILDER.comment("Min group for chickadee").define("Chickadee Min Group", 2);
        chickadee_max_group = BUILDER.comment("Max group for chickadee").define("Chickadee Max Group", 3);
        chickadee_hatch_chance = BUILDER.comment("Hatch chance for each chickadee egg").define("Chickadee Hatch Chance", 0.3);
        chickadee_clutch_size = BUILDER.comment("Max egg clutch size for chickadees").define("Chickadee Clutch Size", 6);

        BUILDER.pop();

        BUILDER.push("Pygmy Goose");

        pygmy_goose_spawns = BUILDER.comment("Enable/disable pygmy goose spawns").define("Pygmy Goose Spawns", true);
        pygmy_goose_spawn_weight = BUILDER.comment("Spawn weight for pygmy goose").define("Pygmy Goose Spawn Weight", 25);
        pygmy_goose_min_group = BUILDER.comment("Min group for pygmy goose").define("Pygmy Goose Min Group", 1);
        pygmy_goose_max_group = BUILDER.comment("Max group for pygmy goose").define("Pygmy Goose Max Group", 2);
        pygmy_goose_hatch_chance = BUILDER.comment("Hatch chance for each pygmy goose egg").define("Pygmy Goose Hatch Chance", 0.2);
        pygmy_goose_clutch_size = BUILDER.comment("Max egg clutch size for pygmy geese").define("Pygmy Goose Clutch Size", 8);

        BUILDER.pop();

        BUILDER.push("Swallow");

        swallow_spawns = BUILDER.comment("Enable/disable swallow spawns").define("Swallow Spawns", true);
        swallow_spawn_weight = BUILDER.comment("Spawn weight for swallow").define("Swallow Spawn Weight", 25);
        swallow_min_group = BUILDER.comment("Min group for swallow").define("Swallow Min Group", 3);
        swallow_max_group = BUILDER.comment("Max group for swallow").define("Swallow Max Group", 5);
        swallow_hatch_chance = BUILDER.comment("Hatch chance for each swallow egg").define("Swallow Hatch Chance", 0.6);
        swallow_clutch_size = BUILDER.comment("Max egg clutch size for swallows").define("Swallow Clutch Size", 3);

        BUILDER.pop();

        BUILDER.push("Fire Goby");

        fire_goby_spawns = BUILDER.comment("Enable/disable fire goby spawns").define("Fire Goby Spawns", true);
        fire_goby_spawn_weight = BUILDER.comment("Spawn weight for fire goby").define("Fire Goby Spawn Weight", 20);
        fire_goby_min_group = BUILDER.comment("Min group for fire goby").define("Fire Goby Min Group", 1);
        fire_goby_max_group = BUILDER.comment("Max group for fire goby").define("Fire Goby Max Group", 1);
        fire_goby_hatch_chance = BUILDER.comment("Hatch chance for each fire goby roe").define("Fire Goby Hatch Chance", 0.2);

        BUILDER.pop();

        BUILDER.push("Blue Tang");

        blue_tang_spawns = BUILDER.comment("Enable/disable blue tang spawns").define("Blue Tang Spawns", true);
        blue_tang_spawn_weight = BUILDER.comment("Spawn weight for blue tang").define("Blue Tang Spawn Weight", 20);
        blue_tang_min_group = BUILDER.comment("Min group for blue tang").define("Blue Tang Min Group", 1);
        blue_tang_max_group = BUILDER.comment("Max group for blue tang").define("Blue Tang Max Group", 1);
        blue_tang_hatch_chance = BUILDER.comment("Hatch chance for each blue tang roe").define("Blue Tang Hatch Chance", 0.2);

        BUILDER.pop();

        BUILDER.push("Flame Angelfish");

        flame_angelfish_spawns = BUILDER.comment("Enable/disable flame angelfish spawns").define("Flame Angelfish Spawns", true);
        flame_angelfish_spawn_weight = BUILDER.comment("Spawn weight for flame angelfish").define("Flame Angelfish Spawn Weight", 20);
        flame_angelfish_min_group = BUILDER.comment("Min group for flame angelfish").define("Flame Angelfish Min Group", 1);
        flame_angelfish_max_group = BUILDER.comment("Max group for flame angelfish").define("Flame Angelfish Max Group", 1);
        flame_angelfish_hatch_chance = BUILDER.comment("Hatch chance for each flame angelfish roe").define("Flame Angelfish Hatch Chance", 0.2);

        BUILDER.pop();

        BUILDER.push("Trout");

        trout_spawns = BUILDER.comment("Enable/disable trout spawns").define("Trout Spawns", true);
        trout_spawn_weight = BUILDER.comment("Spawn weight for trout").define("Trout Spawn Weight", 10);
        trout_min_group = BUILDER.comment("Min group for trout").define("Trout Min Group", 1);
        trout_max_group = BUILDER.comment("Max group for trout").define("Trout Max Group", 1);
        trout_hatch_chance = BUILDER.comment("Hatch chance for each trout roe").define("Trout Hatch Chance", 0.2);

        BUILDER.pop();

        BUILDER.push("Fiddler Crab");

        fiddler_crab_spawns = BUILDER.comment("Enable/disable fiddler crab spawns").define("Fiddler Crab Spawns", true);
        fiddler_crab_spawn_weight = BUILDER.comment("Spawn weight for fiddler crab").define("Fiddler Crab Spawn Weight", 20);
        fiddler_crab_min_group = BUILDER.comment("Min group for fiddler crab").define("Fiddler Crab Min Group", 2);
        fiddler_crab_max_group = BUILDER.comment("Max group for fiddler crab").define("Fiddler Crab Max Group", 4);

        BUILDER.pop();

        BUILDER.push("Ibis");

        ibis_spawns = BUILDER.comment("Enable/disable ibis spawns").define("Ibis Spawns", true);
        ibis_spawn_weight = BUILDER.comment("Spawn weight for ibis").define("Ibis Spawn Weight", 20);
        ibis_min_group = BUILDER.comment("Min group for ibis").define("Ibis Min Group", 2);
        ibis_max_group = BUILDER.comment("Max group for ibis").define("Ibis Max Group", 4);
        ibis_hatch_chance = BUILDER.comment("Hatch chance for each ibis egg").define("Ibis Hatch Chance", 0.3);
        ibis_clutch_size = BUILDER.comment("Max egg clutch size for ibises").define("Ibis Clutch Size", 4);

        BUILDER.pop();

        BUILDER.push("Red Snapper");

        red_snapper_spawns = BUILDER.comment("Enable/disable red snapper spawns").define("Red Snapper Spawns", true);
        red_snapper_spawn_weight = BUILDER.comment("Spawn weight for red snapper").define("Red Snapper Spawn Weight", 10);
        red_snapper_min_group = BUILDER.comment("Min group for red snapper").define("Red Snapper Min Group", 2);
        red_snapper_max_group = BUILDER.comment("Max group for red snapper").define("Red Snapper Max Group", 5);
        red_snapper_hatch_chance = BUILDER.comment("Hatch chance for each red snapper roe").define("Red Snapper Hatch Chance", 0.2);

        BUILDER.pop();

        BUILDER.push("Wood Duck");

        wood_duck_spawns = BUILDER.comment("Enable/disable wood duck spawns").define("Wood Duck Spawns", true);
        wood_duck_spawn_weight = BUILDER.comment("Spawn weight for wood duck").define("Wood Duck Spawn Weight", 20);
        wood_duck_min_group = BUILDER.comment("Min group for wood duck").define("Wood Duck Min Group", 2);
        wood_duck_max_group = BUILDER.comment("Max group for wood duck").define("Wood Duck Max Group", 3);
        wood_duck_hatch_chance = BUILDER.comment("Hatch chance for each wood duck egg").define("Wild Duck Hatch Chance", 0.3);
        wood_duck_clutch_size = BUILDER.comment("Max egg clutch size for wood ducks").define("Wild Duck Clutch Size", 8);

        BUILDER.pop();

        BUILDER.push("Peafowl");

        peafowl_spawns = BUILDER.comment("Enable/disable peafowl spawns").define("Peafowl Spawns", true);
        peafowl_spawn_weight = BUILDER.comment("Spawn weight for peafowl").define("Peafowl Spawn Weight", 20);
        peafowl_min_group = BUILDER.comment("Min group for peafowl").define("Peafowl Min Group", 1);
        peafowl_max_group = BUILDER.comment("Max group for peafowl").define("Peafowl Max Group", 2);
        peafowl_hatch_chance = BUILDER.comment("Hatch chance for each peafowl egg").define("Peafowl Hatch Chance", 0.3);
        peafowl_clutch_size = BUILDER.comment("Max egg clutch size for peafowls").define("Peafowl Clutch Size", 6);

        BUILDER.pop();

        BUILDER.push("Sparrow");

        sparrow_spawns = BUILDER.comment("Enable/disable sparrow spawns").define("Sparrow Spawns", true);
        sparrow_spawn_weight = BUILDER.comment("Spawn weight for sparrows").define("Sparrow Spawn Weight", 30);
        sparrow_min_group = BUILDER.comment("Min group for sparrows").define("Sparrow Min Group", 4);
        sparrow_max_group = BUILDER.comment("Max group for sparrows").define("Sparrow Max Group", 7);
        sparrow_hatch_chance = BUILDER.comment("Hatch chance for each sparrow egg").define("Sparrow Hatch Chance", 0.6);
        sparrow_clutch_size = BUILDER.comment("Max egg clutch size for sparrow").define("Sparrow Clutch Size", 5);

        BUILDER.pop();

        BUILDER.push("Bushtit");

        bushtit_spawns = BUILDER.comment("Enable/disable bushtit spawns").define("Bushtit Spawns", true);
        bushtit_spawn_weight = BUILDER.comment("Spawn weight for bushtits").define("Bushtit Spawn Weight", 20);
        bushtit_min_group = BUILDER.comment("Min group for bushtits").define("Bushtit Min Group", 3);
        bushtit_max_group = BUILDER.comment("Max group for bushtits").define("Bushtit Max Group", 5);
        bushtit_hatch_chance = BUILDER.comment("Hatch chance for each bushtit egg").define("Bushtit Hatch Chance", 0.17);
        bushtit_clutch_size = BUILDER.comment("Max egg clutch size for bushtits").define("Bushtit Clutch Size", 6);

        BUILDER.pop();

        BUILDER.push("Laughingthrush");

        laughingthrush_spawns = BUILDER.comment("Enable/disable laughingthrush spawns").define("Laughingthrush Spawns", true);
        laughingthrush_spawn_weight = BUILDER.comment("Spawn weight for laughingthrushes").define("Laughingthrush Spawn Weight", 20);
        laughingthrush_min_group = BUILDER.comment("Min group for laughingthrushes").define("Laughingthrush Min Group", 3);
        laughingthrush_max_group = BUILDER.comment("Max group for laughingthrushes").define("Laughingthrush Max Group", 5);
        laughingthrush_hatch_chance = BUILDER.comment("Hatch chance for each laughingthrush egg").define("Laughingthrush Hatch Chance", 0.5);
        laughingthrush_clutch_size = BUILDER.comment("Max egg clutch size for laughingthrushes").define("Laughingthrush Clutch Size", 4);

        BUILDER.pop();

        BUILDER.push("Eagle owl");

        eagleowl_spawns = BUILDER.comment("Enable/disable eagleowl spawns").define("Eagle Owl Spawns", true);
        eagleowl_spawn_weight = BUILDER.comment("Spawn weight for eagle owls").define("Eagle Owl Spawn Weight", 10);
        eagleowl_min_group = BUILDER.comment("Min group for eagle owls").define("Eagle Owl Min Group", 1);
        eagleowl_max_group = BUILDER.comment("Max group for eagle owls").define("Eagle Owl Max Group", 2);
        eagleowl_hatch_chance = BUILDER.comment("Hatch chance for each eagle owl egg").define("Eagle Owl Hatch Chance", 0.5);
        eagleowl_clutch_size = BUILDER.comment("Max egg clutch size for eagle owls").define("Eagle Owl Clutch Size", 2);

        BUILDER.pop();

        BUILDER.push("Robin");

        robin_spawns = BUILDER.comment("Enable/disable robin spawns").define("Robin Spawns", true);
        robin_spawn_weight = BUILDER.comment("Spawn weight for robins").define("Robin Spawn Weight", 20);
        robin_min_group = BUILDER.comment("Min group for robins").define("Robin Min Group", 3);
        robin_max_group = BUILDER.comment("Max group for robins").define("Robin Max Group", 4);
        robin_hatch_chance = BUILDER.comment("Hatch chance for each robin egg").define("Robin Hatch Chance", 0.4);
        robin_clutch_size = BUILDER.comment("Max egg clutch size for robins").define("Robin Clutch Size", 6);

        BUILDER.pop();

        BUILDER.push("Magpie");

        magpie_spawns = BUILDER.comment("Enable/disable magpie spawns").define("Magpie Spawns", true);
        magpie_spawn_weight = BUILDER.comment("Spawn weight for magpies").define("Magpie Spawn Weight", 20);
        magpie_min_group = BUILDER.comment("Min group for magpies").define("Magpie Min Group", 3);
        magpie_max_group = BUILDER.comment("Max group for magpies").define("Magpie Max Group", 4);
        magpie_hatch_chance = BUILDER.comment("Hatch chance for each magpie egg").define("Magpie Hatch Chance", 0.3);
        magpie_clutch_size = BUILDER.comment("Max egg clutch size for magpies").define("Magpie Clutch Size", 7);

        BUILDER.pop();

        BUILDER.push("Goose");

        goose_spawns = BUILDER.comment("Enable/disable goose spawns").define("Goose Spawns", true);
        goose_spawn_weight = BUILDER.comment("Spawn weight for goose").define("Goose Spawn Weight", 20);
        goose_min_group = BUILDER.comment("Min group for goose").define("Goose Min Group", 3);
        goose_max_group = BUILDER.comment("Max group for goose").define("Goose Max Group", 5);
        goose_hatch_chance = BUILDER.comment("Hatch chance for each goose egg").define("Goose Hatch Chance", 0.4);
        goose_clutch_size = BUILDER.comment("Max egg clutch size for geese").define("Goose Clutch Size", 7);

        BUILDER.pop();

        BUILDER.push("Osprey");

        osprey_spawns = BUILDER.comment("Enable/disable osprey spawns").define("Osprey Spawns", true);
        osprey_spawn_weight = BUILDER.comment("Spawn weight for ospreys").define("Osprey Spawn Weight", 5);
        osprey_min_group = BUILDER.comment("Min group for ospreys").define("Osprey Min Group", 1);
        osprey_max_group = BUILDER.comment("Max group for ospreys").define("Osprey Max Group", 2);
        osprey_hatch_chance = BUILDER.comment("Hatch chance for each osprey egg").define("Osprey Hatch Chance", 0.2);
        osprey_clutch_size = BUILDER.comment("Max egg clutch size for ospreys").define("Osprey Clutch Size", 4);

        BUILDER.pop();

        BUILDER.push("Kingfisher");

        kingfisher_spawns = BUILDER.comment("Enable/disable kingfisher spawns").define("Kingfisher Spawns", true);
        kingfisher_spawn_weight = BUILDER.comment("Spawn weight for kingfishers").define("Kingfisher Spawn Weight", 20);
        kingfisher_min_group = BUILDER.comment("Min group for kingfisher").define("Kingfisher Min Group", 3);
        kingfisher_max_group = BUILDER.comment("Max group for kingfisher").define("Kingfisher Max Group", 5);
        kingfisher_hatch_chance = BUILDER.comment("Hatch chance for each kingfisher egg").define("Kingfisher Hatch Chance", 0.3);
        kingfisher_clutch_size = BUILDER.comment("Max egg clutch size for kingfisher").define("Kingfisher Clutch Size", 6);

        BUILDER.pop();

        BUILDER.push("Pelican");

        pelican_spawns = BUILDER.comment("Enable/disable pelican spawns").define("Pelican Spawns", true);
        pelican_spawn_weight = BUILDER.comment("Spawn weight for pelicans").define("Pelican Spawn Weight", 20);
        pelican_min_group = BUILDER.comment("Min group for pelican").define("Pelican Min Group", 3);
        pelican_max_group = BUILDER.comment("Max group for pelican").define("Pelican Max Group", 6);
        pelican_hatch_chance = BUILDER.comment("Hatch chance for each pelican egg").define("Pelican Hatch Chance", 0.4);
        pelican_clutch_size = BUILDER.comment("Max egg clutch size for pelicans").define("Pelican Clutch Size", 3);

        BUILDER.pop();

        BUILDER.push("Lapwing");

        lapwing_spawns = BUILDER.comment("Enable/disable lapwing spawns").define("Lapwing Spawns", true);
        lapwing_spawn_weight = BUILDER.comment("Spawn weight for lapwings").define("Lapwing Spawn Weight", 20);
        lapwing_min_group = BUILDER.comment("Min group for lapwing").define("Lapwing Min Group", 3);
        lapwing_max_group = BUILDER.comment("Max group for lapwing").define("Lapwing Max Group", 6);
        lapwing_hatch_chance = BUILDER.comment("Hatch chance for each lapwing egg").define("Lapwing Hatch Chance", 0.3);
        lapwing_clutch_size = BUILDER.comment("Max egg clutch size for lapwing").define("Lapwing Clutch Size", 4);

        BUILDER.pop();

        BUILDER.push("Skua");

        skua_spawns = BUILDER.comment("Enable/disable skua spawns").define("Skua Spawns", true);
        skua_spawn_weight = BUILDER.comment("Spawn weight for skuas").define("Skua Spawn Weight", 20);
        skua_min_group = BUILDER.comment("Min group for skua").define("Skua Min Group", 1);
        skua_max_group = BUILDER.comment("Max group for skua").define("Skua Max Group", 3);
        skua_hatch_chance = BUILDER.comment("Hatch chance for each skua egg").define("Skua Hatch Chance", 0.3);
        skua_clutch_size = BUILDER.comment("Max egg clutch size for skuas").define("Skua Clutch Size", 2);

        BUILDER.pop();

        BUILDER.push("Bunting");

        bunting_spawns = BUILDER.comment("Enable/disable bunting spawns").define("Bunting Spawns", true);
        bunting_spawn_weight = BUILDER.comment("Spawn weight for buntings").define("Bunting Spawn Weight", 20);
        bunting_min_group = BUILDER.comment("Min group for bunting").define("Bunting Min Group", 1);
        bunting_max_group = BUILDER.comment("Max group for bunting").define("Bunting Max Group", 3);
        bunting_hatch_chance = BUILDER.comment("Hatch chance for each bunting egg").define("Bunting Hatch Chance", 0.4);
        bunting_clutch_size = BUILDER.comment("Max egg clutch size for bunting").define("Bunting Clutch Size", 4);

        BUILDER.pop();

        BUILDER.push("Monal");

        monal_spawns = BUILDER.comment("Enable/disable monal spawns").define("Monal Spawns", true);
        monal_spawn_weight = BUILDER.comment("Spawn weight for monals").define("Monal Spawn Weight", 15);
        monal_min_group = BUILDER.comment("Min group for monal").define("Monal Min Group", 1);
        monal_max_group = BUILDER.comment("Max group for monal").define("Monal Max Group", 2);
        monal_hatch_chance = BUILDER.comment("Hatch chance for each monal egg").define("Monal Hatch Chance", 0.3);
        monal_clutch_size = BUILDER.comment("Max egg clutch size for monal").define("Monal Clutch Size", 5);

        BUILDER.pop();

        BUILDER.push("Tanager");

        tanager_spawns = BUILDER.comment("Enable/disable tanager spawns").define("Tanager Spawns", true);
        tanager_spawn_weight = BUILDER.comment("Spawn weight for tanagers").define("Tanager Spawn Weight", 20);
        tanager_min_group = BUILDER.comment("Min group for tanager").define("Tanager Min Group", 3);
        tanager_max_group = BUILDER.comment("Max group for tanager").define("Tanager Max Group", 5);
        tanager_hatch_chance = BUILDER.comment("Hatch chance for each tanager egg").define("Tanager Hatch Chance", 0.4);
        tanager_clutch_size = BUILDER.comment("Max egg clutch size for tanager").define("Tanager Clutch Size", 5);

        BUILDER.pop();

        BUILDER.push("Finch");

        finch_spawns = BUILDER.comment("Enable/disable finch spawns").define("Finch Spawns", true);
        finch_spawn_weight = BUILDER.comment("Spawn weight for finches").define("Finch Spawn Weight", 20);
        finch_min_group = BUILDER.comment("Min group for finch").define("Finch Min Group", 3);
        finch_max_group = BUILDER.comment("Max group for finch").define("Finch Max Group", 5);
        finch_hatch_chance = BUILDER.comment("Hatch chance for each finch egg").define("Finch Hatch Chance", 0.4);
        finch_clutch_size = BUILDER.comment("Max egg clutch size for finch").define("Finch Clutch Size", 4);

        BUILDER.pop();

        BUILDER.push("Tarantula");

        tarantula_spawns = BUILDER.comment("Enable/disable tarantula spawns").define("Tarantula Spawns", true);
        tarantula_spawn_weight = BUILDER.comment("Spawn weight for tarantulas").define("Tarantula Spawn Weight", 20);
        tarantula_min_group = BUILDER.comment("Min group for tarantula").define("Tarantula Min Group", 1);
        tarantula_max_group = BUILDER.comment("Max group for tarantula").define("Tarantula Max Group", 1);

        BUILDER.pop();

        BUILDER.push("Capercaillie");

        capercaillie_spawns = BUILDER.comment("Enable/disable capercaillie spawns").define("Capercaillie Spawns", true);
        capercaillie_spawn_weight = BUILDER.comment("Spawn weight for capercaillies").define("Capercaillie Spawn Weight", 5);
        capercaillie_min_group = BUILDER.comment("Min group for capercaillie").define("Capercaillie Min Group", 1);
        capercaillie_max_group = BUILDER.comment("Max group for capercaillie").define("Capercaillie Max Group", 2);
        capercaillie_hatch_chance = BUILDER.comment("Hatch chance for each capercaillie egg").define("Capercaillie Hatch Chance", 0.6);
        capercaillie_clutch_size = BUILDER.comment("Max egg clutch size for capercaillie").define("Capercaillie Clutch Size", 7);

        BUILDER.pop();

        BUILDER.push("Pheasant");

        pheasant_spawns = BUILDER.comment("Enable/disable pheasant spawns").define("Pheasant Spawns", true);
        pheasant_spawn_weight = BUILDER.comment("Spawn weight for pheasants").define("Pheasant Spawn Weight", 10);
        pheasant_min_group = BUILDER.comment("Min group for pheasant").define("Pheasant Min Group", 2);
        pheasant_max_group = BUILDER.comment("Max group for pheasant").define("Pheasant Max Group", 3);
        pheasant_hatch_chance = BUILDER.comment("Hatch chance for each pheasant egg").define("Pheasant Hatch Chance", 0.5);
        pheasant_clutch_size = BUILDER.comment("Max egg clutch size for pheasant").define("Pheasant Clutch Size", 8);

        BUILDER.pop();

        BUILDER.push("Vampire Crab");

        vampirecrab_spawns = BUILDER.comment("Enable/disable vampire crab spawns").define("Vampire Crab Spawns", true);
        vampirecrab_spawn_weight = BUILDER.comment("Spawn weight for vampire crab").define("Vampire Crab Spawn Weight", 25);
        vampirecrab_min_group = BUILDER.comment("Min group for vampire crab").define("Vampire Crab Min Group", 3);
        vampirecrab_max_group = BUILDER.comment("Max group for vampire crab").define("Vampire Crab Max Group", 5);

        BUILDER.pop();

        BUILDER.push("Arapaima");

        arapaima_spawns = BUILDER.comment("Enable/disable arapaima spawns").define("Arapaima Spawns", true);
        arapaima_spawn_weight = BUILDER.comment("Spawn weight for arapaima").define("Arapaima Spawn Weight", 5);
        arapaima_min_group = BUILDER.comment("Min group for arapaima").define("Arapaima Min Group", 1);
        arapaima_max_group = BUILDER.comment("Max group for arapaima").define("Arapaima Max Group", 1);
        arapaima_hatch_chance = BUILDER.comment("Hatch chance for each arapaima roe").define("Arapaima Hatch Chance", 0.1);

        BUILDER.pop();

        BUILDER.push("Tiger Barb");

        tigerbarb_spawns = BUILDER.comment("Enable/disable tiger barb spawns").define("Tiger Barb Spawns", true);
        tigerbarb_spawn_weight = BUILDER.comment("Spawn weight for tiger barb").define("Tiger Barb Spawn Weight", 25);
        tigerbarb_min_group = BUILDER.comment("Min group for tiger barb").define("Tiger Barb Min Group", 1);
        tigerbarb_max_group = BUILDER.comment("Max group for tiger barb").define("Tiger Barb Max Group", 1);
        tigerbarb_hatch_chance = BUILDER.comment("Hatch chance for each tiger barb roe").define("Tiger Barb Hatch Chance", 0.2);

        BUILDER.pop();

        BUILDER.push("Piranha");

        piranha_spawns = BUILDER.comment("Enable/disable piranha spawns").define("Piranha Spawns", true);
        piranha_spawn_weight = BUILDER.comment("Spawn weight for piranha").define("Piranha Spawn Weight", 10);
        piranha_min_group = BUILDER.comment("Min group for piranha").define("Piranha Min Group", 3);
        piranha_max_group = BUILDER.comment("Max group for piranha").define("Piranha Max Group", 6);
        piranha_hatch_chance = BUILDER.comment("Hatch chance for each piranha roe").define("Piranha Hatch Chance", 0.4);

        BUILDER.pop();

        BUILDER.push("Stork");

        stork_spawns = BUILDER.comment("Enable/disable stork spawns").define("Stork Spawns", true);
        stork_spawn_weight = BUILDER.comment("Spawn weight for stork").define("Stork Spawn Weight", 10);
        stork_min_group = BUILDER.comment("Min group for stork").define("Stork Min Group", 3);
        stork_max_group = BUILDER.comment("Max group for stork").define("Stork Max Group", 6);
        stork_hatch_chance = BUILDER.comment("Hatch chance for each stork egg").define("Stork Hatch Chance", 0.5);
        stork_clutch_size = BUILDER.comment("Max egg clutch size for stork").define("Stork Clutch Size", 3);

        BUILDER.pop();

        BUILDER.push("Whistling Duck");

        whistlingduck_spawns = BUILDER.comment("Enable/disable whistling duck spawns").define("Whistling Duck Spawns", true);
        whistlingduck_spawn_weight = BUILDER.comment("Spawn weight for whistling duck").define("Whistling Duck Spawn Weight", 10);
        whistlingduck_min_group = BUILDER.comment("Min group for whistling duck").define("Whistling Duck Min Group", 3);
        whistlingduck_max_group = BUILDER.comment("Max group for whistling duck").define("Whistling Duck Max Group", 6);
        whistlingduck_hatch_chance = BUILDER.comment("Hatch chance for each whistling duck egg").define("Whistling Duck Hatch Chance", 0.2);
        whistlingduck_clutch_size = BUILDER.comment("Max egg clutch size for whistling duck").define("Whistling Duck Clutch Size", 9);

        BUILDER.pop();

        BUILDER.push("Ground Hornbill");

        groundhornbill_spawns = BUILDER.comment("Enable/disable ground hornbill spawns").define("Ground Hornbill Spawns", true);
        groundhornbill_spawn_weight = BUILDER.comment("Spawn weight for ground hornbill").define("Ground Hornbill Spawn Weight", 8);
        groundhornbill_min_group = BUILDER.comment("Min group for ground hornbill").define("Ground Hornbill Min Group", 2);
        groundhornbill_max_group = BUILDER.comment("Max group for ground hornbill").define("Ground Hornbill Max Group", 6);
        groundhornbill_hatch_chance = BUILDER.comment("Hatch chance for each ground hornbill egg").define("Ground Hornbill Hatch Chance", 0.5);
        groundhornbill_clutch_size = BUILDER.comment("Max egg clutch size for ground hornbill").define("Ground Hornbill Clutch Size", 2);

        BUILDER.pop();

        BUILDER.push("Secretarybird");

        secretarybird_spawns = BUILDER.comment("Enable/disable secretarybird spawns").define("Secretarybird Spawns", true);
        secretarybird_spawn_weight = BUILDER.comment("Spawn weight for secretarybirds").define("Secretarybird Spawn Weight", 20);
        secretarybird_min_group = BUILDER.comment("Min group for secretarybird").define("Secretarybird Min Group", 1);
        secretarybird_max_group = BUILDER.comment("Max group for secretarybird").define("Secretarybird Max Group", 2);
        secretarybird_hatch_chance = BUILDER.comment("Hatch chance for each secretarybird egg").define("Secretarybird Hatch Chance", 0.2);
        secretarybird_clutch_size = BUILDER.comment("Max egg clutch size for secretarybirds").define("Secretarybird Clutch Size", 3);

        BUILDER.pop();

        BUILDER.push("Shoebill");

        shoebill_spawns = BUILDER.comment("Enable/disable shoebill spawns").define("Shoebill Spawns", true);
        shoebill_spawn_weight = BUILDER.comment("Spawn weight for shoebills").define("Shoebill Spawn Weight", 10);
        shoebill_min_group = BUILDER.comment("Min group for shoebills").define("Shoebill Min Group", 1);
        shoebill_max_group = BUILDER.comment("Max group for shoebills").define("Shoebill Max Group", 2);
        shoebill_hatch_chance = BUILDER.comment("Hatch chance for each shoebill egg").define("Shoebill Hatch Chance", 0.3);
        shoebill_clutch_size = BUILDER.comment("Max egg clutch size for shoebill").define("Shoebill Clutch Size", 3);

        BUILDER.pop();

        BUILDER.push("Starling");

        starling_spawns = BUILDER.comment("Enable/disable starling spawns").define("Starling Spawns", true);
        starling_spawn_weight = BUILDER.comment("Spawn weight for starlings").define("Starling Spawn Weight", 10);
        starling_min_group = BUILDER.comment("Min group for starlings").define("Starling Min Group", 3);
        starling_max_group = BUILDER.comment("Max group for starlings").define("Starling Max Group", 5);
        starling_hatch_chance = BUILDER.comment("Hatch chance for each starling egg").define("Starling Hatch Chance", 0.7);
        starling_clutch_size = BUILDER.comment("Max egg clutch size for starling").define("Starling Clutch Size", 6);

        BUILDER.pop();

        BUILDER.push("Tambaqui");

        tambaqui_spawns = BUILDER.comment("Enable/disable tambaqui spawns").define("Tambaqui Spawns", true);
        tambaqui_spawn_weight = BUILDER.comment("Spawn weight for tambaqui").define("Tambaqui Spawn Weight", 10);
        tambaqui_min_group = BUILDER.comment("Min group for tambaqui").define("Tambaqui Min Group", 1);
        tambaqui_max_group = BUILDER.comment("Max group for tambaqui").define("Tambaqui Max Group", 1);
        tambaqui_hatch_chance = BUILDER.comment("Hatch chance for each tambaqui egg").define("Tambaqui Hatch Chance", 0.3);

        BUILDER.pop();

        BUILDER.push("Elephantnose");

        elephantnose_spawns = BUILDER.comment("Enable/disable elephantnose fish spawns").define("Elephantnose Spawns", true);
        elephantnose_spawn_weight = BUILDER.comment("Spawn weight for elephantnose fish").define("Elephantnose Spawn Weight", 10);
        elephantnose_min_group = BUILDER.comment("Min group for elephantnose fish").define("Elephantnose Min Group", 3);
        elephantnose_max_group = BUILDER.comment("Max group for elephantnose fish").define("Elephantnose Max Group", 5);
        elephantnose_hatch_chance = BUILDER.comment("Hatch chance for each elephantnose fish egg").define("Elephantnose Hatch Chance", 0.3);

        BUILDER.pop();

        BUILDER.push("Cormorant");

        cormorant_spawns = BUILDER.comment("Enable/disable cormorant spawns").define("Cormorant Spawns", true);
        cormorant_spawn_weight = BUILDER.comment("Spawn weight for cormorants").define("Cormorant Spawn Weight", 10);
        cormorant_min_group = BUILDER.comment("Min group for cormorant").define("Cormorant Min Group", 3);
        cormorant_max_group = BUILDER.comment("Max group for cormorant").define("Cormorant Max Group", 5);
        cormorant_hatch_chance = BUILDER.comment("Hatch chance for each cormorant egg").define("Cormorant Hatch Chance", 0.7);
        cormorant_clutch_size = BUILDER.comment("Max egg clutch size for cormorant").define("Cormorant Clutch Size", 6);

        BUILDER.pop();

        BUILDER.push("Cormorant");

        puffin_spawns = BUILDER.comment("Enable/disable puffin spawns").define("Puffin Spawns", true);
        puffin_spawn_weight = BUILDER.comment("Spawn weight for puffins").define("Puffin Spawn Weight", 10);
        puffin_min_group = BUILDER.comment("Min group for puffin").define("Puffin Min Group", 4);
        puffin_max_group = BUILDER.comment("Max group for puffin").define("Puffin Max Group", 10);
        puffin_hatch_chance = BUILDER.comment("Hatch chance for each puffin egg").define("Puffin Hatch Chance", 0.7);
        puffin_clutch_size = BUILDER.comment("Max egg clutch size for puffin").define("Puffin Clutch Size", 2);

        BUILDER.pop();

        BUILDER.push("Seagull");

        seagull_spawns = BUILDER.comment("Enable/disable seagull spawns").define("Seagull Spawns", true);
        seagull_spawn_weight = BUILDER.comment("Spawn weight for seagulls").define("Seagull Spawn Weight", 10);
        seagull_min_group = BUILDER.comment("Min group for seagull").define("Seagull Min Group", 3);
        seagull_max_group = BUILDER.comment("Max group for seagull").define("Seagull Max Group", 5);
        seagull_hatch_chance = BUILDER.comment("Hatch chance for each seagull egg").define("Seagull Hatch Chance", 0.7);
        seagull_clutch_size = BUILDER.comment("Max egg clutch size for seagull").define("Seagull Clutch Size", 4);

        BUILDER.pop();

        BUILDER.push("Swordfish");

        swordfish_spawns = BUILDER.comment("Enable/disable swordfish spawns").define("Swordfish Spawns", true);
        swordfish_spawn_weight = BUILDER.comment("Spawn weight for swordfish").define("Swordfish Spawn Weight", 10);
        swordfish_min_group = BUILDER.comment("Min group for swordfish").define("Swordfish Min Group", 1);
        swordfish_max_group = BUILDER.comment("Max group for swordfish").define("Swordfish Max Group", 1);
        swordfish_hatch_chance = BUILDER.comment("Hatch chance for each swordfish egg").define("Swordfish Hatch Chance", 0.3);

        BUILDER.pop();

        BUILDER.push("Booby");

        booby_spawns = BUILDER.comment("Enable/disable booby spawns").define("Booby Spawns", true);
        booby_spawn_weight = BUILDER.comment("Spawn weight for booby").define("Booby Spawn Weight", 10);
        booby_min_group = BUILDER.comment("Min group for booby").define("Booby Min Group", 3);
        booby_max_group = BUILDER.comment("Max group for booby").define("Booby Max Group", 5);
        booby_hatch_chance = BUILDER.comment("Hatch chance for each booby egg").define("Booby Hatch Chance", 0.7);
        booby_clutch_size = BUILDER.comment("Max egg clutch size for booby").define("Booby Clutch Size", 4);

        BUILDER.pop();

        BUILDER.push("Lookdown");

        lookdown_spawns = BUILDER.comment("Enable/disable lookdown spawns").define("Lookdown Spawns", true);
        lookdown_spawn_weight = BUILDER.comment("Spawn weight for lookdown").define("Lookdown Spawn Weight", 10);
        lookdown_min_group = BUILDER.comment("Min group for lookdown").define("Lookdown Min Group", 4);
        lookdown_max_group = BUILDER.comment("Max group for lookdown").define("Lookdown Max Group", 6);
        lookdown_hatch_chance = BUILDER.comment("Hatch chance for each lookdown egg").define("Lookdown Hatch Chance", 0.3);

        BUILDER.pop();

        BUILDER.push("Sawfish");

        sawfish_spawns = BUILDER.comment("Enable/disable sawfish").define("Sawfish Spawns", true);
        sawfish_spawn_weight = BUILDER.comment("Spawn weight for sawfish").define("Sawfish Spawn Weight", 5);
        sawfish_min_group = BUILDER.comment("Min group for sawfish").define("Sawfish Min Group", 1);
        sawfish_max_group = BUILDER.comment("Max group for sawfish").define("Sawfish Max Group", 1);
        sawfish_hatch_chance = BUILDER.comment("Hatch chance for each sawfish egg").define("Sawfish Hatch Chance", 0.2);

        BUILDER.pop();

        BUILDER.push("Squid");

        squid_spawns = BUILDER.comment("Enable/disable squid").define("Squid Spawns", true);
        squid_spawn_weight = BUILDER.comment("Spawn weight for squid").define("Squid Spawn Weight", 15);
        squid_min_group = BUILDER.comment("Min group for squid").define("Squid Min Group", 5);
        squid_max_group = BUILDER.comment("Max group for squid").define("Squid Max Group", 6);
        squid_hatch_chance = BUILDER.comment("Hatch chance for each squid egg").define("Squid Hatch Chance", 0.4);

        BUILDER.pop();

        BUILDER.push("Mantis Shrimp");

        mantisshrimp_spawns = BUILDER.comment("Enable/disable mantis shrimp").define("Mantis Shrimp Spawns", true);
        mantisshrimp_spawn_weight = BUILDER.comment("Spawn weight for mantis shrimp").define("Mantis Shrimp Spawn Weight", 15);
        mantisshrimp_min_group = BUILDER.comment("Min group for mantis shrimp").define("Mantis Shrimp Min Group", 1);
        mantisshrimp_max_group = BUILDER.comment("Max group for mantis shrimp").define("Mantis Shrimp Max Group", 1);
        mantisshrimp_hatch_chance = BUILDER.comment("Hatch chance for each mantis shrimp egg").define("Mantis Shrimp Hatch Chance", 0.4);

        BUILDER.pop();

        BUILDER.push("Penguin");

        penguin_spawns = BUILDER.comment("Enable/disable penguin spawns").define("Penguin Spawns", true);
        penguin_spawn_weight = BUILDER.comment("Spawn weight for penguin").define("Penguin Spawn Weight", 10);
        penguin_min_group = BUILDER.comment("Min group for penguin").define("Penguin Min Group", 3);
        penguin_max_group = BUILDER.comment("Max group for penguin").define("Penguin Max Group", 5);
        penguin_hatch_chance = BUILDER.comment("Hatch chance for each penguin egg").define("Penguin Hatch Chance", 0.7);
        penguin_clutch_size = BUILDER.comment("Max egg clutch size for penguin").define("Penguin Clutch Size", 2);

        BUILDER.pop();

        BUILDER.push("Rail");

        rail_spawns = BUILDER.comment("Enable/disable rail spawns").define("Rail Spawns", true);
        rail_spawn_weight = BUILDER.comment("Spawn weight for rail").define("Rail Spawn Weight", 10);
        rail_min_group = BUILDER.comment("Min group for rail").define("Rail Min Group", 1);
        rail_max_group = BUILDER.comment("Max group for rail").define("Rail Max Group", 2);
        rail_hatch_chance = BUILDER.comment("Hatch chance for each rail egg").define("Rail Hatch Chance", 0.6);
        rail_clutch_size = BUILDER.comment("Max egg clutch size for rails").define("Rail Clutch Size", 3);

        BUILDER.pop();

        BUILDER.push("Barracuda");

        barracuda_spawns = BUILDER.comment("Enable/disable barracuda").define("Barracuda Spawns", true);
        barracuda_spawn_weight = BUILDER.comment("Spawn weight for barracuda").define("Barracuda Spawn Weight", 10);
        barracuda_min_group = BUILDER.comment("Min group for barracuda").define("Barracuda Min Group", 1);
        barracuda_max_group = BUILDER.comment("Max group for barracuda").define("Barracuda Max Group", 1);
        barracuda_hatch_chance = BUILDER.comment("Hatch chance for each barracuda egg").define("Barracuda Hatch Chance", 0.4);

        BUILDER.pop();

        BUILDER.push("Avocet");

        avocet_spawns = BUILDER.comment("Enable/disable avocet spawns").define("Avocet Spawns", true);
        avocet_spawn_weight = BUILDER.comment("Spawn weight for avocet").define("Avocet Spawn Weight", 10);
        avocet_min_group = BUILDER.comment("Min group for avocet").define("Avocet Min Group", 3);
        avocet_max_group = BUILDER.comment("Max group for avocet").define("Avocet Max Group", 5);
        avocet_hatch_chance = BUILDER.comment("Hatch chance for each avocet egg").define("Avocet Hatch Chance", 0.5);
        avocet_clutch_size = BUILDER.comment("Max egg clutch size for avocet").define("Avocet Clutch Size", 4);

        BUILDER.pop();

        BUILDER.push("Seadragon");

        seadragon_spawns = BUILDER.comment("Enable/disable Seadragon").define("Seadragon Spawns", true);
        seadragon_spawn_weight = BUILDER.comment("Spawn weight for Seadragon").define("Seadragon Spawn Weight", 10);
        seadragon_min_group = BUILDER.comment("Min group for Seadragon").define("Seadragon Min Group", 1);
        seadragon_max_group = BUILDER.comment("Max group for Seadragon").define("Seadragon Max Group", 1);
        seadragon_hatch_chance = BUILDER.comment("Hatch chance for each Seadragon egg").define("Seadragon Hatch Chance", 0.4);

        BUILDER.pop();

        BUILDER.push("Trumpetfish");

        trumpetfish_spawns = BUILDER.comment("Enable/disable trumpetfish").define("Trumpetfish Spawns", true);
        trumpetfish_spawn_weight = BUILDER.comment("Spawn weight for trumpetfish").define("Trumpetfish Spawn Weight", 10);
        trumpetfish_min_group = BUILDER.comment("Min group for trumpetfish").define("Trumpetfish Min Group", 1);
        trumpetfish_max_group = BUILDER.comment("Max group for trumpetfish").define("Trumpetfish Max Group", 4);
        trumpetfish_hatch_chance = BUILDER.comment("Hatch chance for each trumpetfish egg").define("Trumpetfish Hatch Chance", 0.4);

        BUILDER.pop();

        BUILDER.push("Parrotfish");

        parrotfish_spawns = BUILDER.comment("Enable/disable parrotfish").define("Parrotfish Spawns", true);
        parrotfish_spawn_weight = BUILDER.comment("Spawn weight for parrotfish").define("Parrotfish Spawn Weight", 10);
        parrotfish_min_group = BUILDER.comment("Min group for parrotfish").define("Parrotfish Min Group", 3);
        parrotfish_max_group = BUILDER.comment("Max group for parrotfish").define("Parrotfish Max Group", 5);
        parrotfish_hatch_chance = BUILDER.comment("Hatch chance for each parrotfish egg").define("Parrotfish Hatch Chance", 0.4);

        BUILDER.pop();

        BUILDER.push("Frigate");

        frigate_spawns = BUILDER.comment("Enable/disable frigate spawns").define("Frigate Spawns", true);
        frigate_spawn_weight = BUILDER.comment("Spawn weight for frigate").define("Frigate Spawn Weight", 10);
        frigate_min_group = BUILDER.comment("Min group for frigate").define("Frigate Min Group", 3);
        frigate_max_group = BUILDER.comment("Max group for frigate").define("Frigate Max Group", 5);
        frigate_hatch_chance = BUILDER.comment("Hatch chance for each frigate egg").define("Frigate Hatch Chance", 0.5);
        frigate_clutch_size = BUILDER.comment("Max egg clutch size for frigate").define("Frigate Clutch Size", 4);

        BUILDER.pop();

        BUILDER.push("Clownfish");

        clownfish_spawns = BUILDER.comment("Enable/disable clownfish").define("Clownfish Spawns", true);
        clownfish_spawn_weight = BUILDER.comment("Spawn weight for clownfish").define("Clownfish Spawn Weight", 10);
        clownfish_min_group = BUILDER.comment("Min group for clownfish").define("Clownfish Min Group", 3);
        clownfish_max_group = BUILDER.comment("Max group for clownfish").define("Clownfish Max Group", 5);
        clownfish_hatch_chance = BUILDER.comment("Hatch chance for each clownfish egg").define("Clownfish Hatch Chance", 0.4);

        BUILDER.pop();

        BUILDER.push("Stilt");

        stilt_spawns = BUILDER.comment("Enable/disable stilt spawns").define("Stilt Spawns", true);
        stilt_spawn_weight = BUILDER.comment("Spawn weight for stilt").define("Stilt Spawn Weight", 10);
        stilt_min_group = BUILDER.comment("Min group for stilt").define("Stilt Min Group", 3);
        stilt_max_group = BUILDER.comment("Max group for stilt").define("Stilt Max Group", 5);
        stilt_hatch_chance = BUILDER.comment("Hatch chance for each stilt egg").define("Stilt Hatch Chance", 0.5);
        stilt_clutch_size = BUILDER.comment("Max egg clutch size for stilt").define("Stilt Clutch Size", 4);

        BUILDER.pop();

        BUILDER.push("Stingray");

        stingray_spawns = BUILDER.comment("Enable/disable stingray").define("Stingray Spawns", true);
        stingray_spawn_weight = BUILDER.comment("Spawn weight for stingray").define("Stingray Spawn Weight", 10);
        stingray_min_group = BUILDER.comment("Min group for stingray").define("Stingray Min Group", 1);
        stingray_max_group = BUILDER.comment("Max group for stingray").define("Stingray Max Group", 2);
        stingray_hatch_chance = BUILDER.comment("Hatch chance for each stingray egg").define("Stingray Hatch Chance", 0.4);

        BUILDER.pop();

        BUILDER.push("Lungfish");

        lungfish_spawns = BUILDER.comment("Enable/disable lungfish").define("Lungfish Spawns", true);
        lungfish_spawn_weight = BUILDER.comment("Spawn weight for lungfish").define("Lungfish Spawn Weight", 10);
        lungfish_min_group = BUILDER.comment("Min group for lungfish").define("Lungfish Min Group", 1);
        lungfish_max_group = BUILDER.comment("Max group for lungfish").define("Lungfish Max Group", 2);
        lungfish_hatch_chance = BUILDER.comment("Hatch chance for each lungfish egg").define("Lungfish Hatch Chance", 0.4);

        BUILDER.pop();

        BUILDER.push("Edible Crab");

        ediblecrab_spawns = BUILDER.comment("Enable/disable edible crab spawns").define("Edible Crab Spawns", true);
        ediblecrab_spawn_weight = BUILDER.comment("Spawn weight for edible crab").define("Edible Crab Spawn Weight", 25);
        ediblecrab_min_group = BUILDER.comment("Min group for edible crab").define("Edible Crab Min Group", 3);
        ediblecrab_max_group = BUILDER.comment("Max group for edible crab").define("Edible Crab Max Group", 5);

        BUILDER.pop();

        BUILDER.push("Gameplay");

        breed_only_variants = BUILDER.comment("Gameplay: Enable/disable breed-only variants").define("Breed-Only Variants", true);
        biome_only_variants = BUILDER.comment("Gameplay: Enable/disable biome-specific variants").define("Biome-Specific Variants", true);
        following = BUILDER.comment("Gameplay: Enable/disable tamed birds following the player").define("Following", true);
        teleporting = BUILDER.comment("Gameplay: Enable/disable tamed birds teleporting to the player while following").define("Teleportation", true);
        teleporting_distance = BUILDER.comment("Gameplay: Distance at which a following bird will teleport to you (higher value = greater distance)").define("Teleporting distance", 3.0D);
        raptor_attacks = BUILDER.comment("Gameplay: Enable/disable raptors attacking prey").define("Raptor Attacks", true);
        raptor_throws = BUILDER.comment("Gameplay: Enable/disable raptors throwing targets into air").define("Raptors Throw", true);
        raven_albino_chance = BUILDER.comment("Rarity of albino ravens (higher number = rarer)").define("Albino Raven Rarity", 500);
        lovebird_mutation_chance = BUILDER.comment("Rarity of mutation lovebirds from breeding").define("Lovebird Mutation Rarity", 10);
        peafowl_mutation_chance = BUILDER.comment("Rarity of mutation peafowls from breeding").define("Peafowl Mutation Rarity", 10);
        penguin_mutation_chance = BUILDER.comment("Rarity of mutation penguins from breeding").define("Penguin Mutation Rarity", 10);
        lorikeet_mutation_chance = BUILDER.comment("Rarity of mutation lorikeets from breeding").define("Lorikeet Mutation Rarity", 10);
        puffin_mutation_chance = BUILDER.comment("Rarity of mutation puffins from breeding").define("Puffin Mutation Rarity", 50);
        swordfish_mutation_chance = BUILDER.comment("Rarity of mutation swordfish from breeding/spawning").define("Swordfish Mutation Rarity", 50);
        arapaima_mutation_chance = BUILDER.comment("Rarity of arapaima albino mutation from breeding/spawning").define("Arapaim Mutation Rarity", 50);
        height_base_multiplier = BUILDER.comment("Base multiplier of height (note: it's recommended to not change this unless you want all entities to be larger/smaller").define("Height Base Multiplier", 1.0);
        height_standard_deviation = BUILDER.comment("Standard deviation of height of entities (higher value = more variation, 0 = turning off basically)").define("Height Standard Deviation", 0.10);
        height_on = BUILDER.comment("Gameplay: Enable/disable height variation").define("Height Variation", true);
        drop_feather = BUILDER.comment("Gameplay: Enable/disable ducks dropping feathers").define("Ducks Drop Feathers", true);
        base_egg_hatch_time = BUILDER.comment("Base time for egg to hatch, in ticks").define("Base Egg Hatch Time", 6000);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }

}
