package com.frikinzi.creatures.entity.egg;

import com.frikinzi.creatures.Creatures;
import com.frikinzi.creatures.config.CreaturesConfig;
import com.frikinzi.creatures.entity.base.CreaturesBirdEntity;
import com.frikinzi.creatures.registry.CreaturesItems;
import com.frikinzi.creatures.registry.CreaturesSound;
import com.frikinzi.creatures.util.EntityAttributes;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.core.jmx.Server;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.UUID;

public class CreaturesEggEntity extends AgeableEntity implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);
    private static final DataParameter<Integer> SPECIES_ID = EntityDataManager.defineId(CreaturesEggEntity.class, DataSerializers.INT);
    private static final DataParameter<Integer> DATA_VARIANT_ID = EntityDataManager.defineId(CreaturesEggEntity.class, DataSerializers.INT);
    private static final DataParameter<Integer> DATA_SUBVARIANT_ID = EntityDataManager.defineId(CreaturesEggEntity.class, DataSerializers.INT);
    private static final DataParameter<Integer> GENDER = EntityDataManager.defineId(CreaturesEggEntity.class, DataSerializers.INT);
    private static final DataParameter<Boolean> HATCHING = EntityDataManager.defineId(CreaturesEggEntity.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Float> HEIGHT_MULTIPLIER = EntityDataManager.defineId(CreaturesEggEntity.class, DataSerializers.FLOAT);
    protected static final DataParameter<Optional<UUID>> DATA_PARENTUUID_ID = EntityDataManager.defineId(CreaturesEggEntity.class, DataSerializers.OPTIONAL_UUID);
    public int hatchTime = this.random.nextInt(CreaturesConfig.base_egg_hatch_time.get()) + CreaturesConfig.base_egg_hatch_time.get();
    private CreaturesBirdEntity parent;

    public CreaturesEggEntity(EntityType<? extends CreaturesEggEntity> p_i50251_1_, World p_i50251_2_) {
        super(p_i50251_1_, p_i50251_2_);
        parent = null;
    }

    @Nullable
    public ILivingEntityData finalizeSpawn(IServerWorld p_213386_1_, DifficultyInstance p_213386_2_, SpawnReason p_213386_3_, @Nullable ILivingEntityData p_213386_4_, @Nullable CompoundNBT p_213386_5_) {
        if (p_213386_5_ != null) {
            //System.out.print(p_213386_5_);
            if (p_213386_5_.contains("EggVariant", 3)) {
            this.setVariant(p_213386_5_.getInt("EggVariant"));
            this.setGender(this.random.nextInt(2)); }
            if (p_213386_5_.contains("EggHeightMultiplier", 4)) {
                this.setHeightMultiplier(p_213386_5_.getFloat("EggHeightMultiplier"));
            }
        }
        return p_213386_4_;
    }

    public void setParent(CreaturesBirdEntity parent) {
        this.parent = parent;
    }

    public CreaturesBirdEntity getParent() {
        return this.parent;
    }

    protected void registerGoals() {
    }


    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event)
    {
        if (this.isHatching()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("hatch", true));
            return PlayState.CONTINUE;
        }
        return null;
    }

    @Override
    public void registerControllers(AnimationData data)
    {
        data.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory()
    {
        return this.factory;
    }

    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 1.0D);
    }

    @Override
    public void tick() {
        super.tick();
        hatchEgg(this);
    }

    public int getVariant() {
        return MathHelper.clamp(this.entityData.get(DATA_VARIANT_ID), 1, 30);
    }
    public void setVariant(int p_191997_1_) {
        this.entityData.set(DATA_VARIANT_ID, p_191997_1_);
    }

    public int getSubVariant() {
        return MathHelper.clamp(this.entityData.get(DATA_SUBVARIANT_ID), 1, 30);
    }
    public void setSubVariant(int p_191997_1_) {
        this.entityData.set(DATA_SUBVARIANT_ID, p_191997_1_);
    }

    public int getGender() {
        return MathHelper.clamp(this.entityData.get(GENDER), 0, 2);
    }

    public void setGender(int p_191997_1_) {
        this.entityData.set(GENDER, p_191997_1_);
    }

    public int getSpecies() {
        return MathHelper.clamp(this.entityData.get(SPECIES_ID), 0, 1000);
    }

    public void setSpecies(int p_191997_1_) {
        this.entityData.set(SPECIES_ID, p_191997_1_);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_VARIANT_ID, 0);
        this.entityData.define(DATA_SUBVARIANT_ID, 0);
        this.entityData.define(GENDER, 0);
        this.entityData.define(SPECIES_ID, 0);
        this.entityData.define(HATCHING, false);
        this.entityData.define(HEIGHT_MULTIPLIER, 1.0F);
        this.entityData.define(DATA_PARENTUUID_ID, Optional.empty());
    }


    public void addAdditionalSaveData(CompoundNBT p_213281_1_) {
        super.addAdditionalSaveData(p_213281_1_);
        p_213281_1_.putBoolean("Hatching", this.isHatching());
        p_213281_1_.putInt("Variant", this.getVariant());
        p_213281_1_.putInt("Subvariant", this.getSubVariant());
        p_213281_1_.putInt("Species", this.getSpecies());
        p_213281_1_.putInt("Gender", this.getGender());
        p_213281_1_.putFloat("HeightMultiplier", this.getHeightMultiplier());
        if (this.getParentUUID() != null) {
            p_213281_1_.putUUID("Parent", this.getParentUUID());
        }
    }

    public void readAdditionalSaveData(CompoundNBT p_70037_1_) {
        super.readAdditionalSaveData(p_70037_1_);
        this.setHatching(p_70037_1_.getBoolean("Hatching"));
        this.setSubVariant(p_70037_1_.getInt("Subvariant"));
        this.setVariant(p_70037_1_.getInt("Variant"));
        this.setSpecies(p_70037_1_.getInt("Species"));
        this.setGender(p_70037_1_.getInt("Gender"));
        this.setHeightMultiplier(p_70037_1_.getFloat("HeightMultiplier"));
        UUID uuid;
        if (p_70037_1_.hasUUID("Parent")) {
            uuid = p_70037_1_.getUUID("Parent");
            this.setParentUUID(uuid);
        }

    }

    public float getHeightMultiplier() {
        return this.entityData.get(HEIGHT_MULTIPLIER);
    }

    public void setHeightMultiplier(float p_70606_1_) {
        this.entityData.set(HEIGHT_MULTIPLIER, MathHelper.clamp(p_70606_1_, 0.5F, 2F));
    }

    public boolean isHatching() {
        return this.entityData.get(HATCHING);
    }

    private void setHatching(boolean p_213485_1_) {
        this.entityData.set(HATCHING, p_213485_1_);
    }

    @Override
    protected void doPush(Entity entity) {
    }

    @Nullable
    public UUID getParentUUID() {
        return this.entityData.get(DATA_PARENTUUID_ID).orElse((UUID)null);
    }

    public void setParentUUID(@Nullable UUID p_184754_1_) {
        this.entityData.set(DATA_PARENTUUID_ID, Optional.ofNullable(p_184754_1_));
    }

    public void hatchEgg(CreaturesEggEntity egg) {
        if (egg.hatchTime <= 500) {
            egg.setHatching(true);
        } else {
            egg.setHatching(false);
        }
        if (--egg.hatchTime <= 0) {
            if (!this.level.isClientSide) {
                int species = egg.getSpecies();
                EntityType<? extends CreaturesBirdEntity> type = EntityAttributes.getBirdEntityMap().get(species);
                if (type != null) {
                    CreaturesBirdEntity bird = createBirdEntity(type, egg);

                    if (this.random.nextFloat() < bird.getHatchChance()) {
                        this.spawnParticles(true);
                        this.level.addFreshEntity(bird);
                    } else {
                        this.spawnParticles(false);
                    }
                }

                egg.remove();
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void handleEntityEvent(byte p_70103_1_) {
        if (p_70103_1_ == 3) {
            double d0 = 0.08D;

            for(int i = 0; i < 8; ++i) {
                this.level.addParticle(new ItemParticleData(ParticleTypes.ITEM, this.getEggItem()), this.getX(), this.getY(), this.getZ(), ((double)this.random.nextFloat() - 0.5D) * 0.08D, ((double)this.random.nextFloat() - 0.5D) * 0.08D, ((double)this.random.nextFloat() - 0.5D) * 0.08D);
            }
        }

    }

    protected void spawnParticles(boolean p_70908_1_) {
        IParticleData iparticledata = new ItemParticleData(ParticleTypes.ITEM, this.getEggItem());
        if (!p_70908_1_) {
            iparticledata = ParticleTypes.SMOKE;
        }
        for(int i = 0; i < 7; ++i) {
            double d0 = this.random.nextGaussian() * 0.02D;
            double d1 = this.random.nextGaussian() * 0.02D;
            double d2 = this.random.nextGaussian() * 0.02D;
            ((ServerWorld)this.level).sendParticles(iparticledata, this.getX(), this.getY(), this.getZ(), 0, d0, d1, d2, (double)0.1F);
        }

    }

    @Override
    public AgeableEntity getBreedOffspring(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        return null;
    }

    public ActionResultType mobInteract(PlayerEntity p_230254_1_, Hand p_230254_2_) {
        ItemStack itemstack = p_230254_1_.getItemInHand(p_230254_2_);
        if (itemstack == ItemStack.EMPTY && this.isAlive()) {
            ItemStack itemstack1 = this.getEggItem();
            this.saveToEggTag(itemstack1);
            if (itemstack.isEmpty()) {
                p_230254_1_.setItemInHand(p_230254_2_, itemstack1);
            } else if (!p_230254_1_.inventory.add(itemstack1)) {
                p_230254_1_.drop(itemstack1, false);
            }
            this.remove();
            return ActionResultType.sidedSuccess(this.level.isClientSide);
        }
        if (itemstack.getItem() == CreaturesItems.FF_GUIDE) {
            //System.out.println(this.getParentUUID());
            Creatures.PROXY.setReferencedMob(this);
            if (this.level.isClientSide) {
                Creatures.PROXY.openCreaturesGUI(itemstack);
                return ActionResultType.SUCCESS;
            }
        }
            return super.mobInteract(p_230254_1_, p_230254_2_);
    }

    protected void saveToEggTag(ItemStack p_204211_1_) {
        if (this.hasCustomName()) {
            p_204211_1_.setHoverName(this.getCustomName());
        }
        CompoundNBT compoundnbt = p_204211_1_.getOrCreateTag();
        compoundnbt.putInt("EggVariant", this.getVariant());
        compoundnbt.putFloat("EggHeightMultiplier", this.getHeightMultiplier());
        System.out.println(compoundnbt);

    }

    public ItemStack getEggItem() {
        if (this.getSpecies() == 0) {
            return new ItemStack(CreaturesItems.LOVEBIRD_EGG);
        }
        else if (this.getSpecies() == 1) {
        return new ItemStack(CreaturesItems.SPOONBILL_EGG); }
        else if (this.getSpecies() == 2) {
            return new ItemStack(CreaturesItems.KAKAPO_EGG);
        } else if (this.getSpecies() == 3) {
            return new ItemStack(CreaturesItems.MANDARIN_DUCK_EGG);
        } else if (this.getSpecies() == 4) {
            return new ItemStack(CreaturesItems.RAVEN_EGG);
        } else if (this.getSpecies() == 5) {
            return new ItemStack(CreaturesItems.DOVE_EGG);
        } else if (this.getSpecies() == 6) {
            return new ItemStack(CreaturesItems.RED_KITE_EGG);
        } else if (this.getSpecies() == 7) {
            return new ItemStack(CreaturesItems.GOLDEN_EAGLE_EGG);
        } else if (this.getSpecies() == 8) {
            return new ItemStack(CreaturesItems.STELLERS_SEA_EAGLE_EGG);
        } else if (this.getSpecies() == 9) {
            return new ItemStack(CreaturesItems.GYRFALCON_EGG);
        } else if (this.getSpecies() == 10) {
            return new ItemStack(CreaturesItems.LORIKEET_EGG);
        } else if (this.getSpecies() == 11) {
            return new ItemStack(CreaturesItems.CONURE_EGG);
        } else if (this.getSpecies() == 12) {
            return new ItemStack(CreaturesItems.FAIRYWREN_EGG);
        } else if (this.getSpecies() == 13) {
            return new ItemStack(CreaturesItems.PYGMY_FALCON_EGG);
        } else if (this.getSpecies() == 14) {
            return new ItemStack(CreaturesItems.BARN_OWL_EGG);
        } else if (this.getSpecies() == 15) {
            return new ItemStack(CreaturesItems.WILD_DUCK_EGG);
        } else if (this.getSpecies() == 16) {
            return new ItemStack(CreaturesItems.ROLLER_EGG);
        } else if (this.getSpecies() == 17) {
            return new ItemStack(CreaturesItems.CHICKADEE_EGG);
        } else if (this.getSpecies() == 18) {
            return new ItemStack(CreaturesItems.PYGMY_GOOSE_EGG);
        } else if (this.getSpecies() == 19) {
            return new ItemStack(CreaturesItems.SWALLOW_EGG);
        } else if (this.getSpecies() == 20) {
            return new ItemStack(CreaturesItems.IBIS_EGG);
        } else if (this.getSpecies() == 21) {
            return new ItemStack(CreaturesItems.WOOD_DUCK_EGG);
        } else if (this.getSpecies() == 22) {
            return new ItemStack(CreaturesItems.PEAFOWL_EGG);
        } else if (this.getSpecies() == 23) {
            return new ItemStack(CreaturesItems.SPARROW_EGG);
        } else if (this.getSpecies() == 24) {
            return new ItemStack(CreaturesItems.BUSHTIT_EGG);
        } else if (this.getSpecies() == 25) {
            return new ItemStack(CreaturesItems.EAGLEOWL_EGG);
        } else if (this.getSpecies() == 26) {
            return new ItemStack(CreaturesItems.ROBIN_EGG);
        } else if (this.getSpecies() == 27) {
            return new ItemStack(CreaturesItems.LAUGHINGTHRUSH_EGG);
        } else if (this.getSpecies() == 28) {
            return new ItemStack(CreaturesItems.MAGPIE_EGG);
        } else if (this.getSpecies() == 29) {
            return new ItemStack(CreaturesItems.GOOSE_EGG);
        } else if (this.getSpecies() == 30) {
            return new ItemStack(CreaturesItems.OSPREY_EGG);
        } else if (this.getSpecies() == 31) {
            return new ItemStack(CreaturesItems.KINGFISHER_EGG);
        } else if (this.getSpecies() == 32) {
            return new ItemStack(CreaturesItems.PELICAN_EGG);
        } else if (this.getSpecies() == 33) {
            return new ItemStack(CreaturesItems.LAPWING_EGG);
        } else if (this.getSpecies() == 34) {
            return new ItemStack(CreaturesItems.SKUA_EGG);
        }  else if (this.getSpecies() == 35) {
            return new ItemStack(CreaturesItems.BUNTING_EGG);
        }  else if (this.getSpecies() == 36) {
            return new ItemStack(CreaturesItems.MONAL_EGG);
        }  else if (this.getSpecies() == 37) {
            return new ItemStack(CreaturesItems.TANAGER_EGG);
        }  else if (this.getSpecies() == 38) {
            return new ItemStack(CreaturesItems.FINCH_EGG);
        }   else if (this.getSpecies() == 39) {
            return new ItemStack(CreaturesItems.CAPERCAILLIE_EGG);
        }    else if (this.getSpecies() == 40) {
            return new ItemStack(CreaturesItems.PHEASANT_EGG);
        }    else if (this.getSpecies() == 41) {
            return new ItemStack(CreaturesItems.STORK_EGG);
        }     else if (this.getSpecies() == 42) {
            return new ItemStack(CreaturesItems.WHISTLINGDUCK_EGG);
        }     else if (this.getSpecies() == 43) {
            return new ItemStack(CreaturesItems.GROUND_HORNBILL_EGG);
        }      else if (this.getSpecies() == 44) {
            return new ItemStack(CreaturesItems.SECRETARYBIRD_EGG);
        }     else if (this.getSpecies() == 45) {
            return new ItemStack(CreaturesItems.SHOEBILL_EGG);
        }     else if (this.getSpecies() == 46) {
            return new ItemStack(CreaturesItems.STARLING_EGG);
        }     else if (this.getSpecies() == 47) {
            return new ItemStack(CreaturesItems.CORMORANT_EGG);
        }     else if (this.getSpecies() == 48) {
            return new ItemStack(CreaturesItems.PUFFIN_EGG);
        }     else if (this.getSpecies() == 49) {
            return new ItemStack(CreaturesItems.SEAGULL_EGG);
        }     else if (this.getSpecies() == 50) {
            return new ItemStack(CreaturesItems.BOOBY_EGG);
        }     else if (this.getSpecies() == 51) {
            return new ItemStack(CreaturesItems.PENGUIN_EGG);
        }     else if (this.getSpecies() == 52) {
            return new ItemStack(CreaturesItems.RAIL_EGG);
        }else if (this.getSpecies() == 53) {
            return new ItemStack(CreaturesItems.AVOCET_EGG);
        }else if (this.getSpecies() == 54) {
            return new ItemStack(CreaturesItems.CRESTED_PENGUIN_EGG);
        }else if (this.getSpecies() == 55) {
            return new ItemStack(CreaturesItems.YELLOWEYED_PENGUIN_EGG);
        }else if (this.getSpecies() == 56) {
            return new ItemStack(CreaturesItems.BRUSHTAILED_PENGUIN_EGG);
        }else if (this.getSpecies() == 57) {
            return new ItemStack(CreaturesItems.LARGE_PENGUIN_EGG);
        }else if (this.getSpecies() == 58) {
            return new ItemStack(CreaturesItems.FRIGATE_EGG);
        }else if (this.getSpecies() == 59) {
            return new ItemStack(CreaturesItems.STILT_EGG);
        }else if (this.getSpecies() == 60) {
            return new ItemStack(CreaturesItems.LITTLEPENGUIN_EGG);
        }       else {
            return new ItemStack(CreaturesItems.LOVEBIRD_EGG);
        }
    }

    public boolean isPushable() {
        return false;
    }

    public int getHatchTime() {
        return (this.hatchTime / 1200);
    }

    protected SoundEvent getAmbientSound() {
        if (this.isHatching()) {
            return CreaturesSound.EGG_HATCH; } else {
            return null;
        }
    }

    protected void tickDeath() {
        ++this.deathTime;
        if (this.deathTime == 20) {
            this.remove(); //Forge keep data until we revive player
        }

    }

    public void die(DamageSource p_70645_1_) {
        if (net.minecraftforge.common.ForgeHooks.onLivingDeath(this, p_70645_1_)) return;
        if (!this.removed && !this.dead) {
            Entity entity = p_70645_1_.getEntity();
            LivingEntity livingentity = this.getKillCredit();
            if (this.deathScore >= 0 && livingentity != null) {
                livingentity.awardKillScore(this, this.deathScore, p_70645_1_);
            }

            if (this.isSleeping()) {
                this.stopSleeping();
            }

            this.dead = true;
            this.getCombatTracker().recheckStatus();
            if (this.level instanceof ServerWorld) {
                if (entity != null) {
                    entity.killed((ServerWorld)this.level, this);
                }

                this.dropAllDeathLoot(p_70645_1_);
                this.createWitherRose(livingentity);
            }

            this.level.broadcastEntityEvent(this, (byte)3);}
    }

    public String getHeightString() {
        if (this.getHeightMultiplier() >= 1.5) {
            ITextComponent i = new TranslationTextComponent("gui.giant");
            return i.getString();
        }
        if (this.getHeightMultiplier() >= 1.4) {
            ITextComponent i = new TranslationTextComponent("gui.huge");
            return i.getString();
        }
        if (this.getHeightMultiplier() >= 1.21) {
            ITextComponent i = new TranslationTextComponent("gui.large");
            return i.getString();
        } if (this.getHeightMultiplier() < 1.21 && this.getHeightMultiplier() > 1.11) {
            ITextComponent i = new TranslationTextComponent("gui.above_average");
            return i.getString();
        }
        if (this.getHeightMultiplier() <= 1.11 && this.getHeightMultiplier() >= 0.89) {
            ITextComponent i = new TranslationTextComponent("gui.average");
            return i.getString();
        }
        if (this.getHeightMultiplier() < 0.89 && this.getHeightMultiplier() >= 0.79) {
            ITextComponent i = new TranslationTextComponent("gui.below_average");
            return i.getString();
        }
        else {
            ITextComponent i = new TranslationTextComponent("gui.small");
            return i.getString();
        }
    }

    private CreaturesBirdEntity createBirdEntity(EntityType<? extends CreaturesBirdEntity> entityType, CreaturesEggEntity egg) {
        CreaturesBirdEntity bird = entityType.create(egg.level);
        if (egg.hasCustomName()) {
            bird.setCustomName(egg.getCustomName());
        }
        if (this.getVariant() == -1) {
            bird.setVariant(bird.determineVariant());
        } else {
            bird.setVariant(egg.getVariant());
        }
        bird.setHeightMultiplier(this.getHeightMultiplier());
        bird.setGender(egg.getGender());
        bird.setBaby(true);
        bird.setPos(egg.getX(), egg.getY(), egg.getZ());
        bird.setParentUUID(this.getParentUUID());
        return bird;
    }



}
