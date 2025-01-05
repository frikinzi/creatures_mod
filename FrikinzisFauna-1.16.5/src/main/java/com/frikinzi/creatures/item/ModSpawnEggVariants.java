package com.frikinzi.creatures.item;

import com.frikinzi.creatures.Creatures;
import com.frikinzi.creatures.entity.*;
import com.frikinzi.creatures.entity.base.AbstractCrabBase;
import com.frikinzi.creatures.entity.base.CreaturesBirdEntity;
import com.frikinzi.creatures.entity.base.FishBase;
import com.frikinzi.creatures.entity.base.GroupFishBase;
import com.frikinzi.creatures.registry.ModEntityTypes;
import com.google.common.collect.ImmutableMap;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.MobSpawnerTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.spawner.AbstractSpawner;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.common.util.NonNullSupplier;
import net.minecraftforge.fml.RegistryObject;
import org.apache.logging.log4j.core.jmx.Server;

import javax.annotation.Nullable;
import javax.swing.*;
import java.util.*;

public class ModSpawnEggVariants extends ModSpawnEgg {
    private int currentSpecies;
    private int currentSubSpecies;
    protected static final List<ModSpawnEgg> UNADDED_EGGS = new ArrayList<>();
    private final Lazy<? extends EntityType<?>> entityTypeSupplier;

    public ModSpawnEggVariants(final NonNullSupplier<? extends EntityType<?>> entityTypeSupplier, final int p_i48465_2_,
                       final int p_i48465_3_, final Properties p_i48465_4_) {
        super(entityTypeSupplier, p_i48465_2_, p_i48465_3_, p_i48465_4_);
        this.currentSpecies = 0;
        this.currentSubSpecies = 0;
        this.entityTypeSupplier = Lazy.of(entityTypeSupplier::get);
        UNADDED_EGGS.add(this);
    }

    public ModSpawnEggVariants(final RegistryObject<? extends EntityType<?>> entityTypeSupplier, final int p_i48465_2_,
                       final int p_i48465_3_, final Properties p_i48465_4_) {
        super(entityTypeSupplier, p_i48465_2_, p_i48465_3_, p_i48465_4_);
        this.entityTypeSupplier = Lazy.of(entityTypeSupplier);
        UNADDED_EGGS.add(this);
    }


    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("item.creatures.spawn_egg_current", this.getCurrentSpeciesName(stack)).withStyle(TextFormatting.ITALIC, TextFormatting.GRAY));
    }



    public String getCurrentSpeciesName(ItemStack stack) {
        if (stack.hasTag()) {
            if (stack.getTag().contains("EntityTag")) {
                this.currentSpecies = stack.getTag().getCompound("EntityTag").getInt("Variant");
            }
        }
        if (this.currentSpecies == 0) {
            TranslationTextComponent c = new TranslationTextComponent("creatures.random");
            return c.getString();
        }
        EntityType<?> entitytype = this.getType(stack.getTag());
        if (entitytype == ModEntityTypes.LOVEBIRD.get()) {
            if (this.currentSpecies > 0) {
                if (LovebirdEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return LovebirdEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        }if (entitytype == ModEntityTypes.SPOONBILL.get()) {
            if (this.currentSpecies > 0) {
                if (SpoonbillEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return SpoonbillEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.DOTTYBACK.get()) {
            if (this.currentSpecies > 0) {
                if (DottybackEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return DottybackEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        }
        if (entitytype == ModEntityTypes.BUNTING.get()) {
            if (this.currentSpecies > 0) {
                if (BuntingEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return BuntingEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        }
        if (entitytype == ModEntityTypes.BUSHTIT.get()) {
            if (this.currentSpecies > 0) {
                if (BushtitEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return BushtitEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        }
        if (entitytype == ModEntityTypes.CHICKADEE.get()) {
            if (this.currentSpecies > 0) {
                if (ChickadeeEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return ChickadeeEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        }
        if (entitytype == ModEntityTypes.CONURE.get()) {
            if (this.currentSpecies > 0) {
                if (ConureEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return ConureEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        }
        if (entitytype == ModEntityTypes.DOVE.get()) {
            if (this.currentSpecies > 0) {
                if (DoveEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return DoveEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        }
        if (entitytype == ModEntityTypes.EAGLEOWL.get()) {
            if (this.currentSpecies > 0) {
                if (EagleOwlEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return EagleOwlEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        }
        if (entitytype == ModEntityTypes.FAIRYWREN.get()) {
            if (this.currentSpecies > 0) {
                if (FairywrenEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return FairywrenEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        }if (entitytype == ModEntityTypes.MONAL.get()) {
            if (this.currentSpecies > 0) {
                if (MonalEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return MonalEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        }
        if (entitytype == ModEntityTypes.TANAGER.get()) {
            if (this.currentSpecies > 0) {
                if (TanagerEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return TanagerEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        }
        if (entitytype == ModEntityTypes.FINCH.get()) {
            if (this.currentSpecies > 0) {
                if (FinchEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return FinchEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        }
        if (entitytype == ModEntityTypes.PHEASANT.get()) {
            if (this.currentSpecies > 0) {
                if (PheasantEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return PheasantEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.LORIKEET.get()) {
            if (this.currentSpecies > 0) {
                if (LorikeetEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return LorikeetEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.FINCH.get()) {
            if (this.currentSpecies > 0) {
                if (FinchEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return FinchEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.GOOSE.get()) {
            if (this.currentSpecies > 0) {
                if (GooseEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return GooseEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.IBIS.get()) {
            if (this.currentSpecies > 0) {
                if (IbisEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return IbisEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.KINGFISHER.get()) {
            if (this.currentSpecies > 0) {
                if (KingfisherEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return KingfisherEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.LAPWING.get()) {
            if (this.currentSpecies > 0) {
                if (LapwingEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return LapwingEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.LAUGHINGTHRUSH.get()) {
            if (this.currentSpecies > 0) {
                if (LaughingthrushEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return LaughingthrushEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.MAGPIE.get()) {
            if (this.currentSpecies > 0) {
                if (MagpieEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return MagpieEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.PEAFOWL.get()) {
            if (this.currentSpecies > 0) {
                if (PeafowlEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return PeafowlEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.PELICAN.get()) {
            if (this.currentSpecies > 0) {
                if (PelicanEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return PelicanEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.PYGMY_GOOSE.get()) {
            if (this.currentSpecies > 0) {
                if (PygmyGooseEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return PygmyGooseEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.ROBIN.get()) {
            if (this.currentSpecies > 0) {
                if (RobinEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return RobinEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.ROLLER.get()) {
            if (this.currentSpecies > 0) {
                if (RollerEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return RollerEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.SKUA.get()) {
            if (this.currentSpecies > 0) {
                if (SkuaEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return SkuaEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.GUPPY.get()) {
            if (this.currentSpecies > 0) {
                if (GuppyEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return GuppyEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.SPARROW.get()) {
            if (this.currentSpecies > 0) {
                if (SparrowEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return SparrowEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.SWALLOW.get()) {
            if (this.currentSpecies > 0) {
                if (SwallowEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return SwallowEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.WILD_DUCK.get()) {
            if (this.currentSpecies > 0) {
                if (WildDuckEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return WildDuckEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.STORK.get()) {
            if (this.currentSpecies > 0) {
                if (StorkEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return StorkEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.WHISTLINGDUCK.get()) {
            if (this.currentSpecies > 0) {
                if (WhistlingDuckEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return WhistlingDuckEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.GROUND_HORNBILL.get()) {
            if (this.currentSpecies > 0) {
                if (GroundHornbillEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return GroundHornbillEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.STARLING.get()) {
            if (this.currentSpecies > 0) {
                if (StarlingEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return StarlingEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.CORMORANT.get()) {
            if (this.currentSpecies > 0) {
                if (CormorantEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return CormorantEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        }
        if (entitytype == ModEntityTypes.PUFFIN.get()) {
            if (this.currentSpecies > 0) {
                if (PuffinEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return PuffinEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        }
        if (entitytype == ModEntityTypes.SEAGULL.get()) {
            if (this.currentSpecies > 0) {
                if (SeagullEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return SeagullEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        }
        if (entitytype == ModEntityTypes.RED_SNAPPER.get()) {
            if (this.currentSpecies > 0) {
                if (RedSnapperEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return RedSnapperEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.FIDDLER_CRAB.get()) {
            if (this.currentSpecies > 0) {
                if (FiddlerCrabEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return FiddlerCrabEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.TARANTULA.get()) {
            if (this.currentSpecies > 0) {
                if (TarantulaEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return TarantulaEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.RAVEN.get()) {
            if (this.currentSpecies > 0) {
                if (RavenEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return RavenEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.TROUT.get()) {
            if (this.currentSpecies > 0) {
                if (TroutEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return TroutEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.GOURAMI.get()) {
            if (this.currentSpecies > 0) {
                if (GouramiEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return GouramiEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.PIRANHA.get()) {
            if (this.currentSpecies > 0) {
                if (PiranhaEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return PiranhaEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.SHRIMP.get()) {
            if (this.currentSpecies > 0) {
                if (ShrimpEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return ShrimpEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.TIGERBARB.get()) {
            if (this.currentSpecies > 0) {
                if (TigerBarbEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return TigerBarbEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.STINGRAY.get()) {
            if (this.currentSpecies > 0) {
                if (StingrayEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return StingrayEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.SWORDFISH.get()) {
            if (this.currentSpecies > 0) {
                if (SwordfishEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return SwordfishEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.BOOBY.get()) {
            if (this.currentSpecies > 0) {
                if (BoobyEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return BoobyEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.SQUID.get()) {
            if (this.currentSpecies > 0) {
                if (SquidEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return SquidEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.BANDED_PENGUIN.get()) {
            if (this.currentSpecies > 0) {
                if (BandedPenguinEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return BandedPenguinEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.BARRACUDA.get()) {
            if (this.currentSpecies > 0) {
                if (BarracudaEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return BarracudaEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.AVOCET.get()) {
            if (this.currentSpecies > 0) {
                if (AvocetEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return AvocetEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.SEADRAGON.get()) {
            if (this.currentSpecies > 0) {
                if (SeaDragonEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return SeaDragonEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.TRUMPETFISH.get()) {
            if (this.currentSpecies > 0) {
                if (TrumpetfishEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return TrumpetfishEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.CRESTED_PENGUIN.get()) {
            if (this.currentSpecies > 0) {
                if (CrestedPenguinEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return CrestedPenguinEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.PARROTFISH.get()) {
            if (this.currentSpecies > 0) {
                if (ParrotfishEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return ParrotfishEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.BRUSH_TAILED_PENGUIN.get()) {
            if (this.currentSpecies > 0) {
                if (BrushTailedPenguinEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return BrushTailedPenguinEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.LARGE_PENGUIN.get()) {
            if (this.currentSpecies > 0) {
                if (LargePenguinEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return LargePenguinEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.FRIGATE.get()) {
            if (this.currentSpecies > 0) {
                if (FrigateBirdEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return FrigateBirdEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.CLOWNFISH.get()) {
            if (this.currentSpecies > 0) {
                if (ClownfishEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return ClownfishEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.STILT.get()) {
            if (this.currentSpecies > 0) {
                if (StiltEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return StiltEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.LUNGFISH.get()) {
            if (this.currentSpecies > 0) {
                if (LungfishEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return LungfishEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.LITTLE_PENGUIN.get()) {
            if (this.currentSpecies > 0) {
                if (LittlePenguinEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return LittlePenguinEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.BLUE_TANG.get()) {
            if (this.currentSpecies > 0) {
                if (BlueTangEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return BlueTangEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.SEA_EAGLE.get()) {
            if (this.currentSpecies > 0) {
                if (SeaEagleEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return SeaEagleEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.MANTIS_SHRIMP.get()) {
            if (this.currentSpecies > 0) {
                int no = 1;
                if (this.currentSpecies == 6) {
                    no = 2;
                }
                if (MantisShrimpEntity.SPECIES_NAMES.get(no) != null) {
                    return MantisShrimpEntity.SPECIES_NAMES.get(no).getString() + " " + this.currentSpecies;
                }
            }
        } if (entitytype == ModEntityTypes.RAIL.get()) {
            if (this.currentSpecies > 0) {
                if (RailEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return RailEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.SAWFISH.get()) {
            if (this.currentSpecies > 0) {
                if (SawfishEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return SawfishEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.GHOST_CRAB.get()) {
            if (this.currentSpecies > 0) {
                if (GhostCrabEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return GhostCrabEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        } if (entitytype == ModEntityTypes.EDIBLE_CRAB.get()) {
            if (this.currentSpecies > 0) {
                if (EdibleCrabEntity.SPECIES_NAMES.get(this.currentSpecies) != null) {
                    return EdibleCrabEntity.SPECIES_NAMES.get(this.currentSpecies).getString();
                }
            }
        }
        int i = this.currentSpecies;
        return Integer.toString(i);
    }

    public void increaseSpeciesCount(World world) {
        try{
            CreaturesBirdEntity bird = (CreaturesBirdEntity) this.entityTypeSupplier.get().create(world);
            this.currentSpecies += 1;
            if (this.currentSpecies >= bird.determineVariant()) {
                this.currentSpecies = 0;
            }
        } catch (ClassCastException e) {
            try {
                FishBase fish = (FishBase) this.entityTypeSupplier.get().create(world);
                this.currentSpecies += 1;
                if (this.currentSpecies >= fish.determineVariant()) {
                    this.currentSpecies = 0;
                }
            } catch (ClassCastException i) {
                try {
                    AbstractCrabBase crab = (AbstractCrabBase) this.entityTypeSupplier.get().create(world);
                    this.currentSpecies += 1;
                    if (this.currentSpecies >= crab.determineVariant()) {
                        this.currentSpecies = 0;
                    }
                } catch (ClassCastException j) {
                    GroupFishBase group_fish = (GroupFishBase) this.entityTypeSupplier.get().create(world);
                    this.currentSpecies += 1;
                    if (this.currentSpecies >= group_fish.determineVariant()) {
                        this.currentSpecies = 0;
                    }
                }

            }


        }

    }

    public ActionResultType useOn(ItemUseContext p_195939_1_) {
        World world = p_195939_1_.getLevel();
        if (!(world instanceof ServerWorld)) {
            return ActionResultType.SUCCESS;
        }
        else {
            ItemStack itemstack = p_195939_1_.getItemInHand();

            BlockPos blockpos = p_195939_1_.getClickedPos();
            Direction direction = p_195939_1_.getClickedFace();
            BlockState blockstate = world.getBlockState(blockpos);
            if (blockstate.is(Blocks.SPAWNER)) {
                TileEntity tileentity = world.getBlockEntity(blockpos);
                if (tileentity instanceof MobSpawnerTileEntity) {
                    AbstractSpawner abstractspawner = ((MobSpawnerTileEntity)tileentity).getSpawner();
                    EntityType<?> entitytype1 = this.getType(itemstack.getTag());
                    abstractspawner.setEntityId(entitytype1);
                    tileentity.setChanged();
                    world.sendBlockUpdated(blockpos, blockstate, blockstate, 3);
                    itemstack.shrink(1);
                    return ActionResultType.CONSUME;
                }
            }

            BlockPos blockpos1;
            if (blockstate.getCollisionShape(world, blockpos).isEmpty()) {
                blockpos1 = blockpos;
            } else {
                blockpos1 = blockpos.relative(direction);
            }
            if (itemstack.getTag() != null) {
                if (itemstack.getTag().contains("EntityTag")) {
                    LivingEntity ent = (LivingEntity)this.entityTypeSupplier.get().create(world);

                    if (ent instanceof CreaturesBirdEntity) {
                        CreaturesBirdEntity bird = (CreaturesBirdEntity) ent;
                        bird.setVariant(this.currentSpecies);
                        this.currentSubSpecies = bird.methodOfDeterminingSubVariant();
                    } if (ent instanceof FishBase) {
                        FishBase fish = (FishBase) ent;
                        fish.setVariant(this.currentSpecies);
                        this.currentSubSpecies = fish.methodOfDeterminingSubVariant();
                    } if (ent instanceof GroupFishBase) {
                        GroupFishBase fish = (GroupFishBase) ent;
                        fish.setVariant(this.currentSpecies);
                        this.currentSubSpecies = fish.methodOfDeterminingSubVariant();
                    }
                    itemstack.getTag().getCompound("EntityTag").putInt("Subvariant", this.currentSubSpecies);
                }
            }

            EntityType<?> entitytype = this.getType(itemstack.getTag());
            if (entitytype.spawn((ServerWorld)world, itemstack, p_195939_1_.getPlayer(), blockpos1, SpawnReason.SPAWN_EGG, true, !Objects.equals(blockpos, blockpos1) && direction == Direction.UP) != null) {
                itemstack.shrink(1);
            }

            return ActionResultType.CONSUME;
        }
    }


    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getItemInHand(handIn);
        if (!worldIn.isClientSide && playerIn.isSteppingCarefully()) {
            this.increaseSpeciesCount(worldIn);

            itemstack.setTag(new CompoundNBT());
            if (!(this.currentSpecies <= 0)) {
                CompoundNBT entityNBT = new CompoundNBT();
                entityNBT.putInt("Variant", this.currentSpecies);
                LivingEntity ent = (LivingEntity)this.entityTypeSupplier.get().create(worldIn);

                if (ent instanceof CreaturesBirdEntity) {
                    CreaturesBirdEntity bird = (CreaturesBirdEntity) ent;
                    bird.setVariant(this.currentSpecies);
                    this.currentSubSpecies = bird.methodOfDeterminingSubVariant();
                } if (ent instanceof FishBase) {
                    FishBase fish = (FishBase) ent;
                    fish.setVariant(this.currentSpecies);
                    this.currentSubSpecies = fish.methodOfDeterminingSubVariant();
                } if (ent instanceof GroupFishBase) {
                    GroupFishBase fish = (GroupFishBase) ent;
                    fish.setVariant(this.currentSpecies);
                    this.currentSubSpecies = fish.methodOfDeterminingSubVariant();
                }
                entityNBT.putInt("Subvariant", this.currentSubSpecies);
                itemstack.getTag().put("EntityTag", entityNBT);

            }
            playerIn.displayClientMessage(new TranslationTextComponent("item.creatures.spawn_egg_change",  this.getCurrentSpeciesName(itemstack)), true);
            return ActionResult.pass(itemstack);
        }

        BlockRayTraceResult raytraceresult = getPlayerPOVHitResult(worldIn, playerIn, RayTraceContext.FluidMode.SOURCE_ONLY);
        if (raytraceresult.getType() != RayTraceResult.Type.BLOCK) {
            return ActionResult.pass(itemstack);
        } else if (!(worldIn instanceof ServerWorld)) {
            return ActionResult.success(itemstack);
        }
         else {
            BlockPos blockpos = raytraceresult.getBlockPos();
            if (!(worldIn.getBlockState(blockpos).getBlock() instanceof FlowingFluidBlock)) {
                return ActionResult.pass(itemstack);
            } else if (worldIn.mayInteract(playerIn, blockpos) && playerIn.mayUseItemAt(blockpos, raytraceresult.getDirection(), itemstack)) {
                if (itemstack.getTag() != null) {
                    if (itemstack.getTag().contains("EntityTag")) {
                        LivingEntity ent = (LivingEntity)this.entityTypeSupplier.get().create(worldIn);

                        if (ent instanceof CreaturesBirdEntity) {
                            CreaturesBirdEntity bird = (CreaturesBirdEntity) ent;
                            bird.setVariant(this.currentSpecies);
                            this.currentSubSpecies = bird.methodOfDeterminingSubVariant();
                        } if (ent instanceof FishBase) {
                            FishBase fish = (FishBase) ent;
                            fish.setVariant(this.currentSpecies);
                            this.currentSubSpecies = fish.methodOfDeterminingSubVariant();
                        } if (ent instanceof GroupFishBase) {
                            GroupFishBase fish = (GroupFishBase) ent;
                            fish.setVariant(this.currentSpecies);
                            this.currentSubSpecies = fish.methodOfDeterminingSubVariant();
                        }
                        itemstack.getTag().getCompound("EntityTag").putInt("Subvariant", this.currentSubSpecies);
                    }
                }
                EntityType<?> entitytype = this.getType(itemstack.getTag());
                if (entitytype.spawn((ServerWorld) worldIn, itemstack, playerIn, blockpos, SpawnReason.SPAWN_EGG, false, false) == null) {
                    return ActionResult.pass(itemstack);
                }
            } else {
                return ActionResult.fail(itemstack);
            }
            return ActionResult.pass(itemstack);
        }
    }

}
