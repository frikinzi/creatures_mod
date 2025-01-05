package com.frikinzi.creatures.entity;

import com.frikinzi.creatures.config.CreaturesConfig;
import com.frikinzi.creatures.entity.base.CreaturesBirdEntity;
import com.frikinzi.creatures.entity.base.GroupFishBase;
import com.frikinzi.creatures.registry.CreaturesItems;
import com.frikinzi.creatures.util.CreaturesLootTables;
import com.google.common.collect.ImmutableMap;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.entity.passive.fish.AbstractGroupFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import javax.annotation.Nullable;
import java.util.Map;

public class ParrotfishEntity extends GroupFishBase implements IAnimatable {
    private static final DataParameter<Integer> DATA_VARIANT_ID = EntityDataManager.defineId(ParrotfishEntity.class, DataSerializers.INT);
    private static final DataParameter<Boolean> EATING = EntityDataManager.defineId(ParrotfishEntity.class, DataSerializers.BOOLEAN);

    private boolean isCrunching = false;
    private int eatTimer = 0;
    private AnimationFactory factory = new AnimationFactory(this);
    public static final Map<Integer, TranslationTextComponent> SPECIES_NAMES = ImmutableMap.<Integer, TranslationTextComponent>builder()
            .put(1, new TranslationTextComponent("message.creatures.bumpheadparrotfish"))
            .put(2, new TranslationTextComponent("message.creatures.cetoscarusparrotfish"))
            .put(3, new TranslationTextComponent("message.creatures.cetoscarusparrotfish"))
            .put(4, new TranslationTextComponent("message.creatures.heavybeakparrotfish"))
            .put(5, new TranslationTextComponent("message.creatures.bluntheadparrotfish"))
            .put(6, new TranslationTextComponent("message.creatures.blueparrotfish"))
            .put(7, new TranslationTextComponent("message.creatures.knobsnoutparrotfish"))
            .put(8, new TranslationTextComponent("message.creatures.midnightparrotfish2"))
            .put(9, new TranslationTextComponent("message.creatures.bumpheadparrotfish2"))
            .put(10, new TranslationTextComponent("message.creatures.midnightparrotfish3"))
            .put(11, new TranslationTextComponent("message.creatures.rainbowparrotfish"))
            .put(12, new TranslationTextComponent("message.creatures.singaporeparrotfish"))
            .build();

    public static final Map<Integer, String> SCIENTIFIC_NAMES = ImmutableMap.<Integer, String>builder()
            .put(1, "Bolbometopon muricatum")
            .put(2, "Cetoscarus bicolor")
            .put(3, "Cetoscarus bicolor")
            .put(4, "Chlorurus gibbus")
            .put(5, "Chlorurus microrhinos")
            .put(6, "Scarus coeruleus")
            .put(7, "Scarus ovifrons")
            .put(8, "Scarus coelestinus")
            .put(9, "Bolbometopon muricatum")
            .put(10, "Scarus coelestinus")
            .put(11, "Scarus guacamaia")
            .put(12, "Scarus prasiognathos")
            .build();

    public ParrotfishEntity(EntityType<? extends ParrotfishEntity> p_i50246_1_, World p_i50246_2_) {
        super(p_i50246_1_, p_i50246_2_);
    }

    @Nullable
    public ILivingEntityData finalizeSpawn(IServerWorld p_213386_1_, DifficultyInstance p_213386_2_, SpawnReason p_213386_3_, @Nullable ILivingEntityData p_213386_4_, @Nullable CompoundNBT p_213386_5_) {
        if (p_213386_3_ != SpawnReason.BUCKET) {
            this.setGender(this.random.nextInt(2));
            if (p_213386_3_ == SpawnReason.SPAWN_EGG) {
                if (p_213386_5_ != null && p_213386_5_.contains("Variant")) {
                    this.setVariant(p_213386_5_.getInt("Variant"));
                } else {
                    this.setVariant(this.random.nextInt(12) + 1);
                }
            } else {
                int color;
                if (p_213386_4_ instanceof ParrotfishEntity.ParrotfishData) {
                    color = ((ParrotfishEntity.ParrotfishData)p_213386_4_).variant;
                } else {
                    color = this.random.nextInt(12) + 1;
                    p_213386_4_ = new ParrotfishEntity.ParrotfishData(this, color);
                }
                this.setVariant(color);
            }
            //this.setVariant(this.random.nextInt(12)+1);
            float f = (float) (this.random.nextGaussian() * CreaturesConfig.height_standard_deviation.get() + CreaturesConfig.height_base_multiplier.get());
            this.setHeightMultiplier(f);
        }
        if (p_213386_5_ != null) {
            if (p_213386_5_.contains("BucketVariantTag", 3)) {
                this.setVariant(p_213386_5_.getInt("BucketVariantTag"));
                //return p_213386_4_;
            }
            if (p_213386_5_.contains("BucketHeightMultiplier")) {
                this.setHeightMultiplier(p_213386_5_.getFloat("BucketHeightMultiplier"));
            } if (p_213386_5_.contains("Age")) {
                this.setAge(p_213386_5_.getInt("Age"));
            }
            return p_213386_4_;
        }
        return super.finalizeSpawn(p_213386_1_, p_213386_2_, p_213386_3_, p_213386_4_, p_213386_5_);
    }



    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event)
    {
        if (this.isEating()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("crunch", true));
            return PlayState.CONTINUE;
        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation("swim", true));
        return PlayState.CONTINUE;
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

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, PlayerEntity.class, 8.0F, 2.2D, 2.2D));
        this.goalSelector.addGoal(2, new ParrotfishEntity.EatCoralGoal(this));
    }

    public void aiStep() {
        if (!this.level.isClientSide) {
            if (this.eatTimer > 0) {
                this.playAmbientSound();
                this.spawnParticles();
                this.eatTimer--;
            } else {
                this.setEating(false);
            }
        }
        super.aiStep();
    }

    protected void spawnParticles() {
        IParticleData iparticledata = new ItemParticleData(ParticleTypes.ITEM, new ItemStack(Items.BRAIN_CORAL.getItem()));

        for(int i = 0; i < 7; ++i) {
            double d0 = this.random.nextGaussian() * 0.02D;
            double d1 = this.random.nextGaussian() * 0.02D;
            double d2 = this.random.nextGaussian() * 0.02D;
            ((ServerWorld)this.level).addParticle(iparticledata, this.getRandomX(1.0D), this.getRandomY() + 0.5D, this.getRandomZ(1.0D), d0, d1, d2);
        }

    }


    public int getMaxSchoolSize() {
        return 10;
    }

    protected ItemStack getBucketItemStack() {
        return new ItemStack(CreaturesItems.DOTTYBACK_BUCKET);
    }

    protected void saveToBucketTag(ItemStack p_204211_1_) {
        super.saveToBucketTag(p_204211_1_);
        CompoundNBT compoundnbt = p_204211_1_.getOrCreateTag();
        compoundnbt.putInt("BucketVariantTag", this.getVariant());
        compoundnbt.putFloat("BucketHeightMultiplier", this.getHeightMultiplier());
        compoundnbt.putInt("Age", this.getAge());
    }

    protected SoundEvent getAmbientSound() {
        if (this.isCrunching) {
            return SoundEvents.GENERIC_EAT;
        }
        return SoundEvents.SALMON_AMBIENT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.SALMON_DEATH;
    }

    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return SoundEvents.SALMON_HURT;
    }

    protected SoundEvent getFlopSound() {
        return SoundEvents.SALMON_FLOP;
    }

    public int getVariant() {
        return MathHelper.clamp(this.entityData.get(DATA_VARIANT_ID), 1, 13);
    }

    public void setVariant(int p_191997_1_) {
        this.entityData.set(DATA_VARIANT_ID, p_191997_1_);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(EATING, false);
        this.entityData.define(DATA_VARIANT_ID, 0);
        this.entityData.define(DATA_ID_MOVING, false);
    }

    public void addAdditionalSaveData(CompoundNBT p_213281_1_) {
        super.addAdditionalSaveData(p_213281_1_);
        p_213281_1_.putInt("Variant", this.getVariant());
        p_213281_1_.putBoolean("Eating", this.isEating());
    }

    public void readAdditionalSaveData(CompoundNBT p_70037_1_) {
        super.readAdditionalSaveData(p_70037_1_);
        this.setVariant(p_70037_1_.getInt("Variant"));
        this.setEating(p_70037_1_.getBoolean("Eating"));
    }

    public boolean isEating() {
        return this.entityData.get(EATING);
    }

    public void setEating(boolean p_70606_1_) {
        this.entityData.set(EATING, p_70606_1_);
    }


    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 6.0D).add(Attributes.MOVEMENT_SPEED, 0.06D);
    }

    public String getSpeciesName() {
        TranslationTextComponent translatable = SPECIES_NAMES.get(this.getVariant());
        if (translatable != null) {
            return translatable.getString();
        } return "Unknown";
    }

    public float getHatchChance() {
        return Double.valueOf(CreaturesConfig.parrotfish_hatch_chance.get()).floatValue();
    }

    public Item getFoodItem() {
        return CreaturesItems.ALGAE_WAFER;
    }

    public double getMoveSpeed() {
        return 1.2D;
    }

    public ResourceLocation getDefaultLootTable() {
        return CreaturesLootTables.PARROTFISH;
    }

    public int determineVariant()
    {
        return 13;
    }


    static class EatCoralGoal extends MoveToBlockGoal {
        private final ParrotfishEntity parrotfish;
        private boolean wantsToEat;
        private int eatTimer = 0;
        private boolean canEat;

        public EatCoralGoal(ParrotfishEntity p_i45860_1_) {
            super(p_i45860_1_, (double)1.0F, 16, 16);
            this.parrotfish = p_i45860_1_;
        }

        public boolean canUse() {
            if (this.parrotfish.isBaby()) {
                return false;
            }
            return super.canUse();
        }

        public boolean canContinueToUse() {
            return super.canContinueToUse();
        }

        public void stop() {
            super.stop();
        }

        public void tick() {
            super.tick();
            this.parrotfish.getLookControl().setLookAt((double)this.blockPos.getX() + 0.5D, (double)(this.blockPos.getY() + 1), (double)this.blockPos.getZ() + 0.5D, 10.0F, (float)this.parrotfish.getMaxHeadXRot());
            if (this.isReachedTarget()) {
                this.parrotfish.eatTimer = 500;
                this.parrotfish.setEating(true);
            }

        }

        protected boolean isValidTarget(IWorldReader p_179488_1_, BlockPos p_179488_2_) {
            return p_179488_1_.isWaterAt(p_179488_2_.above()) && (p_179488_1_.getBlockState(p_179488_2_).getBlock().is(BlockTags.CORAL_BLOCKS) || p_179488_1_.getBlockState(p_179488_2_).getBlock().is(BlockTags.CORAL_PLANTS));
        }
    }

    public String getGenderName() {
        if (this.getGender() == 0) {
            return "f";
        } return "m";
    }

    public String getScientificName() {
        return SCIENTIFIC_NAMES.get(this.getVariant());
    }

    public static class ParrotfishData extends AbstractGroupFishEntity.GroupData {
        public final int variant;

        public ParrotfishData(AbstractGroupFishEntity leader, int variant) {
            super(leader);
            this.variant = variant;
        }
    }

    public ITextComponent getFunFact() {
        return new TranslationTextComponent("description.creatures.parrotfish");
    }

}
