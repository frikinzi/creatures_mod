package com.frikinzi.creatures.util;

import com.frikinzi.creatures.Creatures;
import com.frikinzi.creatures.entity.*;
import com.frikinzi.creatures.entity.base.CreaturesBirdEntity;
import com.frikinzi.creatures.entity.base.FishBase;
import com.frikinzi.creatures.entity.base.TameableBirdBase;
import com.frikinzi.creatures.entity.egg.CreaturesEggEntity;
import com.frikinzi.creatures.entity.egg.CreaturesRoeEntity;
import com.frikinzi.creatures.registry.ModEntityTypes;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Creatures.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityAttributes {
    private static final BiMap<Integer, EntityType<? extends CreaturesBirdEntity>> birdEntityMap = HashBiMap.create();
    private static final BiMap<Integer, EntityType<? extends AbstractFishEntity>> fishEntityMap = HashBiMap.create();
    
    @SubscribeEvent
    public static void entityAttributes(EntityAttributeCreationEvent event) {
        EntitySpawnPlacementRegistry.register(ModEntityTypes.KOI.get(),
                EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                FishBase::checkFishSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.DOTTYBACK.get(),
                EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                FishBase::checkFishSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.PIKE.get(),
                EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                FishBase::checkFishSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.GOURAMI.get(),
                EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                FishBase::checkFishSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.SHRIMP.get(),
                EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                FishBase::checkFishSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.GUPPY.get(),
                EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                FishBase::checkFishSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.AROWANA.get(),
                EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                FishBase::checkFishSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.TROUT.get(),
                EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                FishBase::checkFishSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.BLUE_TANG.get(),
                EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                FishBase::checkFishSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.FIRE_GOBY.get(),
                EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                FishBase::checkFishSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.FLAME_ANGELFISH.get(),
                EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                FishBase::checkFishSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.GOLDFISH.get(),
                EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                FishBase::checkFishSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.RANCHU.get(),
                EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                FishBase::checkFishSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.RED_SNAPPER.get(),
                EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                FishBase::checkFishSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.TIGERBARB.get(),
                EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                FishBase::checkFishSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.PIRANHA.get(),
                EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                FishBase::checkFishSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.ARAPAIMA.get(),
                EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                FishBase::checkFishSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.TAMBAQUI.get(),
                EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                FishBase::checkFishSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.ELEPHANTNOSE.get(),
                EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                FishBase::checkFishSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.STINGRAY.get(),
                EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                FishBase::checkFishSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.SAWFISH.get(),
                EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                FishBase::checkFishSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.SWORDFISH.get(),
                EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                FishBase::checkFishSpawnRules);

        EntitySpawnPlacementRegistry.register(ModEntityTypes.LOVEBIRD.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                TameableBirdBase::checkBirdSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.SPOONBILL.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                AnimalEntity::checkAnimalSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.IBIS.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                AnimalEntity::checkAnimalSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.KAKAPO.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                AnimalEntity::checkAnimalSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.MANDARIN_DUCK.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                AnimalEntity::checkAnimalSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.WOOD_DUCK.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                AnimalEntity::checkAnimalSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.LORIKEET.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                TameableBirdBase::checkBirdSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.CONURE.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                TameableBirdBase::checkBirdSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.DOVE.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                DoveEntity::checkDoveSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.RAVEN.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                TameableBirdBase::checkBirdSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.GOLDEN_EAGLE.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                AnimalEntity::checkAnimalSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.SEA_EAGLE.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                SeaEagleEntity::checkSSESpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.GYRFALCON.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                AnimalEntity::checkAnimalSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.FAIRYWREN.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                TameableBirdBase::checkBirdSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.RED_KITE.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                AnimalEntity::checkAnimalSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.GHOST_CRAB.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                GhostCrabEntity::checkAnimalSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.FIDDLER_CRAB.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                GhostCrabEntity::checkAnimalSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.PYGMY_FALCON.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                PygmyFalconEntity::checkFalconSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.BARN_OWL.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                TameableBirdBase::checkBirdSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.WILD_DUCK.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                AnimalEntity::checkAnimalSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.ROLLER.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                TameableBirdBase::checkBirdSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.CHICKADEE.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                TameableBirdBase::checkBirdSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.PYGMY_GOOSE.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                AnimalEntity::checkAnimalSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.SWALLOW.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                TameableBirdBase::checkBirdSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.PEAFOWL.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                TameableBirdBase::checkBirdSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.SPARROW.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                SparrowEntity::checkSparrowSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.BUSHTIT.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                TameableBirdBase::checkBirdSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.LAUGHINGTHRUSH.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                TameableBirdBase::checkBirdSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.EAGLEOWL.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                TameableBirdBase::checkBirdSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.ROBIN.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                TameableBirdBase::checkBirdSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.MAGPIE.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                TameableBirdBase::checkBirdSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.GOOSE.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                TameableBirdBase::checkBirdSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.OSPREY.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                TameableBirdBase::checkBirdSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.KINGFISHER.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                TameableBirdBase::checkBirdSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.PELICAN.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                PelicanEntity::checkPelicanSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.LAPWING.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                TameableBirdBase::checkBirdSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.SKUA.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                LargePenguinEntity::checkPenguinSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.BUNTING.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                TameableBirdBase::checkBirdSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.MONAL.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                TameableBirdBase::checkBirdSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.TANAGER.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                TameableBirdBase::checkBirdSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.FINCH.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                TameableBirdBase::checkBirdSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.VAMPIRECRAB.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                GhostCrabEntity::checkAnimalSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.TARANTULA.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                TarantulaEntity::checkTarantulaSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.CAPERCAILLIE.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                TameableBirdBase::checkBirdSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.PHEASANT.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                TameableBirdBase::checkBirdSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.STORK.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                TameableBirdBase::checkBirdSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.WHISTLINGDUCK.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                TameableBirdBase::checkBirdSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.GROUND_HORNBILL.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                TameableBirdBase::checkBirdSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.SECRETARYBIRD.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                TameableBirdBase::checkBirdSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.SHOEBILL.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                TameableBirdBase::checkBirdSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.STARLING.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                TameableBirdBase::checkBirdSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.CORMORANT.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                TameableBirdBase::checkBirdSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.PUFFIN.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                TameableBirdBase::checkBirdSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.SEAGULL.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                PelicanEntity::checkPelicanSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.BOOBY.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                PelicanEntity::checkPelicanSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.BANDED_PENGUIN.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                PelicanEntity::checkPelicanSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.RAIL.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                TameableBirdBase::checkBirdSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.AVOCET.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                TameableBirdBase::checkBirdSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.CRESTED_PENGUIN.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                PelicanEntity::checkPelicanSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.BRUSH_TAILED_PENGUIN.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                LargePenguinEntity::checkPenguinSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.YELLOW_EYED_PENGUIN.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                PelicanEntity::checkPelicanSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.LARGE_PENGUIN.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                LargePenguinEntity::checkPenguinSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.FRIGATE.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                PelicanEntity::checkPelicanSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.STILT.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                TameableBirdBase::checkBirdSpawnRules);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.LITTLE_PENGUIN.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING,
                PelicanEntity::checkPelicanSpawnRules);

        event.put(ModEntityTypes.KOI.get(), KoiEntity.createAttributes().build());
        event.put(ModEntityTypes.LOVEBIRD.get(), LovebirdEntity.createAttributes().build());
        event.put(ModEntityTypes.DOTTYBACK.get(), DottybackEntity.createAttributes().build());
        event.put(ModEntityTypes.PIKE.get(), PikeEntity.createAttributes().build());
        event.put(ModEntityTypes.GUPPY.get(), GuppyEntity.createAttributes().build());
        event.put(ModEntityTypes.SPOONBILL.get(), SpoonbillEntity.createAttributes().build());
        event.put(ModEntityTypes.KAKAPO.get(), KakapoEntity.createAttributes().build());
        event.put(ModEntityTypes.MANDARIN_DUCK.get(), MandarinDuckEntity.createAttributes().build());
        event.put(ModEntityTypes.AROWANA.get(), ArowanaEntity.createAttributes().build());
        event.put(ModEntityTypes.RAVEN.get(), RavenEntity.createAttributes().build());
        event.put(ModEntityTypes.SHRIMP.get(), ShrimpEntity.createAttributes().build());
        event.put(ModEntityTypes.DOVE.get(), DoveEntity.createAttributes().build());
        event.put(ModEntityTypes.RED_KITE.get(), RedKiteEntity.createAttributes().build());
        event.put(ModEntityTypes.GOLDEN_EAGLE.get(), GoldenEagleEntity.createAttributes().build());
        event.put(ModEntityTypes.SEA_EAGLE.get(), SeaEagleEntity.createAttributes().build());
        event.put(ModEntityTypes.GYRFALCON.get(), GyrfalconEntity.createAttributes().build());
        event.put(ModEntityTypes.LORIKEET.get(), LorikeetEntity.createAttributes().build());
        event.put(ModEntityTypes.CONURE.get(), ConureEntity.createAttributes().build());
        event.put(ModEntityTypes.FAIRYWREN.get(), FairywrenEntity.createAttributes().build());
        event.put(ModEntityTypes.GHOST_CRAB.get(), GhostCrabEntity.createAttributes().build());
        event.put(ModEntityTypes.GOURAMI.get(), GouramiEntity.createAttributes().build());
        event.put(ModEntityTypes.PYGMY_FALCON.get(), PygmyFalconEntity.createAttributes().build());
        event.put(ModEntityTypes.BARN_OWL.get(), BarnOwlEntity.createAttributes().build());
        event.put(ModEntityTypes.WILD_DUCK.get(), WildDuckEntity.createAttributes().build());
        event.put(ModEntityTypes.ROLLER.get(), RollerEntity.createAttributes().build());
        event.put(ModEntityTypes.GOLDFISH.get(), GoldfishEntity.createAttributes().build());
        event.put(ModEntityTypes.RANCHU.get(), RanchuEntity.createAttributes().build());
        event.put(ModEntityTypes.CHICKADEE.get(), ChickadeeEntity.createAttributes().build());
        event.put(ModEntityTypes.PYGMY_GOOSE.get(), PygmyGooseEntity.createAttributes().build());
        event.put(ModEntityTypes.FIRE_GOBY.get(), FireGobyEntity.createAttributes().build());
        event.put(ModEntityTypes.BLUE_TANG.get(), BlueTangEntity.createAttributes().build());
        event.put(ModEntityTypes.TROUT.get(), TroutEntity.createAttributes().build());
        event.put(ModEntityTypes.SWALLOW.get(), SwallowEntity.createAttributes().build());
        event.put(ModEntityTypes.FIDDLER_CRAB.get(), FiddlerCrabEntity.createAttributes().build());
        event.put(ModEntityTypes.FLAME_ANGELFISH.get(), FlameAngelfishEntity.createAttributes().build());
        event.put(ModEntityTypes.IBIS.get(), IbisEntity.createAttributes().build());
        event.put(ModEntityTypes.RED_SNAPPER.get(), RedSnapperEntity.createAttributes().build());
        event.put(ModEntityTypes.WOOD_DUCK.get(), WoodDuckEntity.createAttributes().build());
        event.put(ModEntityTypes.PEAFOWL.get(), PeafowlEntity.createAttributes().build());
        event.put(ModEntityTypes.SPARROW.get(), SparrowEntity.createAttributes().build());
        event.put(ModEntityTypes.BUSHTIT.get(), BushtitEntity.createAttributes().build());
        event.put(ModEntityTypes.EAGLEOWL.get(), EagleOwlEntity.createAttributes().build());
        event.put(ModEntityTypes.ROBIN.get(), RobinEntity.createAttributes().build());
        event.put(ModEntityTypes.MAGPIE.get(), MagpieEntity.createAttributes().build());
        event.put(ModEntityTypes.LAUGHINGTHRUSH.get(), LaughingthrushEntity.createAttributes().build());
        event.put(ModEntityTypes.GOOSE.get(), GooseEntity.createAttributes().build());
        event.put(ModEntityTypes.OSPREY.get(), OspreyEntity.createAttributes().build());
        event.put(ModEntityTypes.KINGFISHER.get(), KingfisherEntity.createAttributes().build());
        event.put(ModEntityTypes.PELICAN.get(), PelicanEntity.createAttributes().build());
        event.put(ModEntityTypes.LAPWING.get(), LapwingEntity.createAttributes().build());
        event.put(ModEntityTypes.SKUA.get(), SkuaEntity.createAttributes().build());
        event.put(ModEntityTypes.BUNTING.get(), BuntingEntity.createAttributes().build());
        event.put(ModEntityTypes.MONAL.get(), MonalEntity.createAttributes().build());
        event.put(ModEntityTypes.TANAGER.get(), TanagerEntity.createAttributes().build());
        event.put(ModEntityTypes.FINCH.get(), FinchEntity.createAttributes().build());
        event.put(ModEntityTypes.VAMPIRECRAB.get(), FinchEntity.createAttributes().build());
        event.put(ModEntityTypes.TARANTULA.get(), TarantulaEntity.createAttributes().build());
        event.put(ModEntityTypes.CAPERCAILLIE.get(), CapercaillieEntity.createAttributes().build());
        event.put(ModEntityTypes.TIGERBARB.get(), TigerBarbEntity.createAttributes().build());
        event.put(ModEntityTypes.PHEASANT.get(), PheasantEntity.createAttributes().build());
        event.put(ModEntityTypes.ARAPAIMA.get(), ArapaimaEntity.createAttributes().build());
        event.put(ModEntityTypes.PIRANHA.get(), PiranhaEntity.createAttributes().build());
        event.put(ModEntityTypes.STORK.get(), StorkEntity.createAttributes().build());
        event.put(ModEntityTypes.WHISTLINGDUCK.get(), WhistlingDuckEntity.createAttributes().build());
        event.put(ModEntityTypes.GROUND_HORNBILL.get(), GroundHornbillEntity.createAttributes().build());
        event.put(ModEntityTypes.SECRETARYBIRD.get(), SecretaryBirdEntity.createAttributes().build());
        event.put(ModEntityTypes.SHOEBILL.get(), ShoebillEntity.createAttributes().build());
        event.put(ModEntityTypes.STARLING.get(), StarlingEntity.createAttributes().build());
        event.put(ModEntityTypes.TAMBAQUI.get(), TambaquiEntity.createAttributes().build());
        event.put(ModEntityTypes.ELEPHANTNOSE.get(), ElephantNoseFishEntity.createAttributes().build());
        event.put(ModEntityTypes.CORMORANT.get(), CormorantEntity.createAttributes().build());
        event.put(ModEntityTypes.STINGRAY.get(), StingrayEntity.createAttributes().build());
        event.put(ModEntityTypes.PUFFIN.get(), PuffinEntity.createAttributes().build());
        event.put(ModEntityTypes.SAWFISH.get(), SawfishEntity.createAttributes().build());
        event.put(ModEntityTypes.SEAGULL.get(), SeagullEntity.createAttributes().build());
        event.put(ModEntityTypes.SWORDFISH.get(), SwordfishEntity.createAttributes().build());
        event.put(ModEntityTypes.BOOBY.get(), BoobyEntity.createAttributes().build());
        event.put(ModEntityTypes.SQUID.get(), SquidEntity.createAttributes().build());
        event.put(ModEntityTypes.LOOKDOWN.get(), LookdownEntity.createAttributes().build());
        event.put(ModEntityTypes.BANDED_PENGUIN.get(), BandedPenguinEntity.createAttributes().build());
        event.put(ModEntityTypes.MANTIS_SHRIMP.get(), MantisShrimpEntity.createAttributes().build());
        event.put(ModEntityTypes.RAIL.get(), RailEntity.createAttributes().build());
        event.put(ModEntityTypes.BARRACUDA.get(), BarracudaEntity.createAttributes().build());
        event.put(ModEntityTypes.AVOCET.get(), AvocetEntity.createAttributes().build());
        event.put(ModEntityTypes.SEADRAGON.get(), SeaDragonEntity.createAttributes().build());
        event.put(ModEntityTypes.TRUMPETFISH.get(), TrumpetfishEntity.createAttributes().build());
        event.put(ModEntityTypes.CRESTED_PENGUIN.get(), CrestedPenguinEntity.createAttributes().build());
        event.put(ModEntityTypes.PARROTFISH.get(), ParrotfishEntity.createAttributes().build());
        event.put(ModEntityTypes.YELLOW_EYED_PENGUIN.get(), YellowEyedPenguinEntity.createAttributes().build());
        event.put(ModEntityTypes.BRUSH_TAILED_PENGUIN.get(), BrushTailedPenguinEntity.createAttributes().build());
        event.put(ModEntityTypes.LARGE_PENGUIN.get(), LargePenguinEntity.createAttributes().build());
        event.put(ModEntityTypes.FRIGATE.get(), FrigateBirdEntity.createAttributes().build());
        event.put(ModEntityTypes.CLOWNFISH.get(), ClownfishEntity.createAttributes().build());
        event.put(ModEntityTypes.STILT.get(), StiltEntity.createAttributes().build());
        event.put(ModEntityTypes.LUNGFISH.get(), LungfishEntity.createAttributes().build());
        event.put(ModEntityTypes.LITTLE_PENGUIN.get(), LittlePenguinEntity.createAttributes().build());
        event.put(ModEntityTypes.EDIBLE_CRAB.get(), EdibleCrabEntity.createAttributes().build());

        event.put(ModEntityTypes.EGG.get(), CreaturesEggEntity.createAttributes().build());
        event.put(ModEntityTypes.ROE.get(), CreaturesRoeEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void birdMap(final RegistryEvent.Register<EntityType<?>> event) {
        birdEntityMap.put(0, ModEntityTypes.LOVEBIRD.get());
        birdEntityMap.put(1, ModEntityTypes.SPOONBILL.get());
        birdEntityMap.put(2, ModEntityTypes.KAKAPO.get());
        birdEntityMap.put(3, ModEntityTypes.MANDARIN_DUCK.get());
        birdEntityMap.put(4, ModEntityTypes.RAVEN.get());
        birdEntityMap.put(5, ModEntityTypes.DOVE.get());
        birdEntityMap.put(6, ModEntityTypes.RED_KITE.get());
        birdEntityMap.put(7, ModEntityTypes.GOLDEN_EAGLE.get());
        birdEntityMap.put(8, ModEntityTypes.SEA_EAGLE.get());
        birdEntityMap.put(9, ModEntityTypes.GYRFALCON.get());
        birdEntityMap.put(10, ModEntityTypes.LORIKEET.get());
        birdEntityMap.put(11, ModEntityTypes.CONURE.get());
        birdEntityMap.put(12, ModEntityTypes.FAIRYWREN.get());
        birdEntityMap.put(13, ModEntityTypes.PYGMY_FALCON.get());
        birdEntityMap.put(14, ModEntityTypes.BARN_OWL.get());
        birdEntityMap.put(15, ModEntityTypes.WILD_DUCK.get());
        birdEntityMap.put(16, ModEntityTypes.ROLLER.get());
        birdEntityMap.put(17, ModEntityTypes.CHICKADEE.get());
        birdEntityMap.put(18, ModEntityTypes.PYGMY_GOOSE.get());
        birdEntityMap.put(19, ModEntityTypes.SWALLOW.get());
        birdEntityMap.put(20, ModEntityTypes.IBIS.get());
        birdEntityMap.put(21, ModEntityTypes.WOOD_DUCK.get());
        birdEntityMap.put(22, ModEntityTypes.PEAFOWL.get());
        birdEntityMap.put(23, ModEntityTypes.SPARROW.get());
        birdEntityMap.put(24, ModEntityTypes.BUSHTIT.get());
        birdEntityMap.put(25, ModEntityTypes.EAGLEOWL.get());
        birdEntityMap.put(26, ModEntityTypes.ROBIN.get());
        birdEntityMap.put(27, ModEntityTypes.LAUGHINGTHRUSH.get());
        birdEntityMap.put(28, ModEntityTypes.MAGPIE.get());
        birdEntityMap.put(29, ModEntityTypes.GOOSE.get());
        birdEntityMap.put(30, ModEntityTypes.OSPREY.get());
        birdEntityMap.put(31, ModEntityTypes.KINGFISHER.get());
        birdEntityMap.put(32, ModEntityTypes.PELICAN.get());
        birdEntityMap.put(33, ModEntityTypes.LAPWING.get());
        birdEntityMap.put(34, ModEntityTypes.SKUA.get());
        birdEntityMap.put(35, ModEntityTypes.BUNTING.get());
        birdEntityMap.put(36, ModEntityTypes.MONAL.get());
        birdEntityMap.put(37, ModEntityTypes.TANAGER.get());
        birdEntityMap.put(38, ModEntityTypes.FINCH.get());
        birdEntityMap.put(39, ModEntityTypes.CAPERCAILLIE.get());
        birdEntityMap.put(40, ModEntityTypes.PHEASANT.get());
        birdEntityMap.put(41, ModEntityTypes.STORK.get());
        birdEntityMap.put(42, ModEntityTypes.WHISTLINGDUCK.get());
        birdEntityMap.put(43, ModEntityTypes.GROUND_HORNBILL.get());
        birdEntityMap.put(44, ModEntityTypes.SECRETARYBIRD.get());
        birdEntityMap.put(45, ModEntityTypes.SHOEBILL.get());
        birdEntityMap.put(46, ModEntityTypes.STARLING.get());
        birdEntityMap.put(47, ModEntityTypes.CORMORANT.get());
        birdEntityMap.put(48, ModEntityTypes.PUFFIN.get());
        birdEntityMap.put(49, ModEntityTypes.SEAGULL.get());
        birdEntityMap.put(50, ModEntityTypes.BOOBY.get());
        birdEntityMap.put(51, ModEntityTypes.BANDED_PENGUIN.get());
        birdEntityMap.put(52, ModEntityTypes.RAIL.get());
        birdEntityMap.put(53, ModEntityTypes.AVOCET.get());
        birdEntityMap.put(54, ModEntityTypes.CRESTED_PENGUIN.get());
        birdEntityMap.put(55, ModEntityTypes.YELLOW_EYED_PENGUIN.get());
        birdEntityMap.put(56, ModEntityTypes.BRUSH_TAILED_PENGUIN.get());
        birdEntityMap.put(57, ModEntityTypes.LARGE_PENGUIN.get());
        birdEntityMap.put(58, ModEntityTypes.FRIGATE.get());
        birdEntityMap.put(59, ModEntityTypes.STILT.get());
        birdEntityMap.put(60, ModEntityTypes.LITTLE_PENGUIN.get());

    }

    @SubscribeEvent
    public static void fishMap(final RegistryEvent.Register<EntityType<?>> event) {
        fishEntityMap.put(1, ModEntityTypes.KOI.get());
        fishEntityMap.put(2, ModEntityTypes.DOTTYBACK.get());
        fishEntityMap.put(3, ModEntityTypes.PIKE.get());
        fishEntityMap.put(4, ModEntityTypes.GUPPY.get());
        fishEntityMap.put(5, ModEntityTypes.AROWANA.get());
        fishEntityMap.put(6, ModEntityTypes.SHRIMP.get());
        fishEntityMap.put(7, ModEntityTypes.GOURAMI.get());
        fishEntityMap.put(8, ModEntityTypes.GOLDFISH.get());
        fishEntityMap.put(9, ModEntityTypes.RANCHU.get());
        fishEntityMap.put(10, ModEntityTypes.FIRE_GOBY.get());
        fishEntityMap.put(11, ModEntityTypes.BLUE_TANG.get());
        fishEntityMap.put(12, ModEntityTypes.FLAME_ANGELFISH.get());
        fishEntityMap.put(13, ModEntityTypes.TROUT.get());
        fishEntityMap.put(14, ModEntityTypes.RED_SNAPPER.get());
        fishEntityMap.put(15, ModEntityTypes.TIGERBARB.get());
        fishEntityMap.put(16, ModEntityTypes.ARAPAIMA.get());
        fishEntityMap.put(17, ModEntityTypes.PIRANHA.get());
        fishEntityMap.put(18, ModEntityTypes.TAMBAQUI.get());
        fishEntityMap.put(19, ModEntityTypes.ELEPHANTNOSE.get());
        fishEntityMap.put(20, ModEntityTypes.STINGRAY.get());
        fishEntityMap.put(21, ModEntityTypes.SAWFISH.get());
        fishEntityMap.put(22, ModEntityTypes.SWORDFISH.get());
        fishEntityMap.put(23, ModEntityTypes.SQUID.get());
        fishEntityMap.put(24, ModEntityTypes.MANTIS_SHRIMP.get());
        fishEntityMap.put(25, ModEntityTypes.BARRACUDA.get());
        fishEntityMap.put(26, ModEntityTypes.SEADRAGON.get());
        fishEntityMap.put(27, ModEntityTypes.PARROTFISH.get());
        fishEntityMap.put(28, ModEntityTypes.CLOWNFISH.get());
        fishEntityMap.put(29, ModEntityTypes.LUNGFISH.get());

    }

    public static BiMap<Integer, EntityType<? extends CreaturesBirdEntity>> getBirdEntityMap() {
        return birdEntityMap;
    }
    public static BiMap<Integer, EntityType<? extends AbstractFishEntity>> getFishEntityMap() {
        return fishEntityMap;
    }

}
