package com.frikinzi.creatures.entity;

import com.frikinzi.creatures.config.CreaturesConfig;
import com.frikinzi.creatures.entity.base.FishBase;
import com.frikinzi.creatures.registry.CreaturesItems;
import com.frikinzi.creatures.util.CreaturesLootTables;
import com.google.common.collect.ImmutableMap;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import javax.annotation.Nullable;
import java.util.Map;

public class GouramiEntity extends FishBase implements IAnimatable {
    private static final DataParameter<Integer> DATA_VARIANT_ID = EntityDataManager.defineId(GouramiEntity.class, DataSerializers.INT);
    private AnimationFactory factory = new AnimationFactory(this);
    public static Map<Integer, TranslationTextComponent> SPECIES_NAMES = ImmutableMap.of(
            1, new TranslationTextComponent("message.creatures.threespot"),
            2, new TranslationTextComponent("message.creatures.roundtailed"),
            3, new TranslationTextComponent("message.creatures.goldgourami"),
            4, new TranslationTextComponent("message.creatures.dwarf"),
            5, new TranslationTextComponent("message.creatures.pearl")
    );
    public static final Map<Integer, String> SCIENTIFIC_NAMES = ImmutableMap.<Integer, String>builder()
            .put(1, "Trichopodus trichopterus")
            .put(2, "Macropodus ocellatus")
            .put(3, "Trichopodus trichopterus")
            .put(4, "Trichogaster lalius")
            .put(5, "Trichopodus leerii")
            .build();
    public static Map<Integer, TranslationTextComponent> DESCRIPTIONS = ImmutableMap.of(
            1, new TranslationTextComponent("description.creatures.threespot"),
            2, new TranslationTextComponent("description.creatures.roundtailed"),
            3, new TranslationTextComponent("description.creatures.goldgourami"),
            4, new TranslationTextComponent("description.creatures.dwarf"),
            5, new TranslationTextComponent("description.creatures.pearl")
    );

    public GouramiEntity(EntityType<? extends GouramiEntity> p_i50246_1_, World p_i50246_2_) {
        super(p_i50246_1_, p_i50246_2_);
    }

    @Nullable
    public ILivingEntityData finalizeSpawn(IServerWorld p_213386_1_, DifficultyInstance p_213386_2_, SpawnReason p_213386_3_, @Nullable ILivingEntityData p_213386_4_, @Nullable CompoundNBT p_213386_5_) {
        if (p_213386_3_ != SpawnReason.BUCKET) {
            this.setVariant(this.random.nextInt(5)+1);
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
        if (!this.isInWater()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("flop", true));
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


    protected ItemStack getBucketItemStack() {
        return new ItemStack(CreaturesItems.GOURAMI_BUCKET);
    }

    protected void saveToBucketTag(ItemStack p_204211_1_) {
        super.saveToBucketTag(p_204211_1_);
        CompoundNBT compoundnbt = p_204211_1_.getOrCreateTag();
        compoundnbt.putInt("BucketVariantTag", this.getVariant());
        compoundnbt.putFloat("BucketHeightMultiplier", this.getHeightMultiplier());
        compoundnbt.putInt("Age", this.getAge());
    }

    protected SoundEvent getAmbientSound() {
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
        return MathHelper.clamp(this.entityData.get(DATA_VARIANT_ID), 1, 6);
    }

    public void setVariant(int p_191997_1_) {
        this.entityData.set(DATA_VARIANT_ID, p_191997_1_);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_VARIANT_ID, 0);
        this.entityData.define(DATA_ID_MOVING, false);
    }

    public void addAdditionalSaveData(CompoundNBT p_213281_1_) {
        super.addAdditionalSaveData(p_213281_1_);
        p_213281_1_.putInt("Variant", this.getVariant());
    }

    public void readAdditionalSaveData(CompoundNBT p_70037_1_) {
        super.readAdditionalSaveData(p_70037_1_);
        this.setVariant(p_70037_1_.getInt("Variant"));
    }

    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 6.0D).add(Attributes.MOVEMENT_SPEED, 0.1D);
    }

    public ResourceLocation getDefaultLootTable() {
        return CreaturesLootTables.GOURAMI;
    }

    public String getSpeciesName() {
        TranslationTextComponent translatable = SPECIES_NAMES.get(this.getVariant());
        if (translatable != null) {
            return translatable.getString();
        } return "Unknown";
    }

    public float getHatchChance() {
        return Double.valueOf(CreaturesConfig.gourami_hatch_chance.get()).floatValue();
    }

    public Item getFoodItem() {
        return CreaturesItems.FISH_FOOD;
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, PlayerEntity.class, 8.0F, 2.2D, 2.0D));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, PiranhaEntity.class, 8.0F, 2.2D, 2.2D));
    }

    protected float getStandingEyeHeight(Pose p_213348_1_, EntitySize p_213348_2_) {
        return 0.2F;
    }

    public int determineVariant()
    {
        return 5;
    }

    public int getIUCNStatus() {
        if (this.getVariant()== 5) {
            return 1;
        }
        return super.getIUCNStatus();
    }

    public String getScientificName() {
        return SCIENTIFIC_NAMES.get(this.getVariant());
    }

    public ITextComponent getFunFact() {
        TranslationTextComponent translatable = DESCRIPTIONS.get(this.getVariant());
        if (translatable != null) {
            return translatable;
        } return new TranslationTextComponent("creatures.unknown");
    }

}
