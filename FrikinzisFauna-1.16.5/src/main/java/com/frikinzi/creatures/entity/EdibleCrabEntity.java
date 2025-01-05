package com.frikinzi.creatures.entity;

import com.frikinzi.creatures.entity.base.AbstractCrabBase;
import com.frikinzi.creatures.registry.CreaturesItems;
import com.frikinzi.creatures.util.CreaturesLootTables;
import com.google.common.collect.ImmutableMap;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import javax.annotation.Nullable;
import java.util.*;

public class EdibleCrabEntity extends AbstractCrabBase implements IAnimatable {
    private static final DataParameter<Integer> DATA_VARIANT_ID = EntityDataManager.defineId(EdibleCrabEntity.class, DataSerializers.INT);
    private static final DataParameter<Integer> GENDER = EntityDataManager.defineId(EdibleCrabEntity.class, DataSerializers.INT);
    private static final Ingredient FOOD_ITEMS = Ingredient.of(CreaturesItems.RAW_SHRIMP);
    private AnimationFactory factory = new AnimationFactory(this);
    private static final DataParameter<Boolean> THREAT = EntityDataManager.defineId(EdibleCrabEntity.class, DataSerializers.BOOLEAN);
    public static Map<Integer, TranslationTextComponent> SPECIES_NAMES;
    private boolean didAttack;
    static {
        Map<Integer, TranslationTextComponent> map = new HashMap<>();
        map.put(1, new TranslationTextComponent("message.creatures.ediblecrab"));
        map.put(2, new TranslationTextComponent("message.creatures.rockcrab"));
        map.put(3, new TranslationTextComponent("message.creatures.dungenesscrab"));
        map.put(4, new TranslationTextComponent("message.creatures.bluecrab"));
        SPECIES_NAMES = Collections.unmodifiableMap(map);
    }

    public static final Map<Integer, String> SCIENTIFIC_NAMES = ImmutableMap.<Integer, String>builder()
            .put(1, "Cancer pagurus")
            .put(2, "Cancer irroratus")
            .put(3, "Metacarcinus magister")
            .put(4, "Callinectes sapidus")
            .build();

    public static final Map<Integer, TranslationTextComponent> DESCRIPTIONS = ImmutableMap.<Integer, TranslationTextComponent>builder()
            .put(1, new TranslationTextComponent("description.creatures.ediblecrab"))
            .put(2, new TranslationTextComponent("description.creatures.rockcrab"))
            .put(3, new TranslationTextComponent("description.creatures.dungenesscrab"))
            .put(4, new TranslationTextComponent("description.creatures.bluecrab"))
            .build();

    public EdibleCrabEntity(EntityType<? extends EdibleCrabEntity> p_i48567_1_, World p_i48567_2_) {
        super(p_i48567_1_, p_i48567_2_);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 2.0D, true));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
        this.goalSelector.addGoal(5, new EdibleCrabEntity.WanderGoal(this, 0.7D,0.0005F));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, PlayerEntity.class, 6.0F, 1.0D, 1.2D));
        this.goalSelector.addGoal(1, new EdibleCrabEntity.ThreatGoal());
        this.targetSelector.addGoal(1, new EdibleCrabEntity.HurtByTargetGoal(this));


    }

    @Nullable
    public ILivingEntityData finalizeSpawn(IServerWorld p_213386_1_, DifficultyInstance p_213386_2_, SpawnReason p_213386_3_, @Nullable ILivingEntityData p_213386_4_, @Nullable CompoundNBT p_213386_5_) {
        //this.setVariant(this.random.nextInt(5));
        this.setGender(this.random.nextInt(2));
        if (p_213386_4_ == null) {
            p_213386_4_ = new AgeableData(false);
        }

        return super.finalizeSpawn(p_213386_1_, p_213386_2_, p_213386_3_, p_213386_4_, p_213386_5_);
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event)
    {
        if (this.isThreatPose()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("defense", true));
            return PlayState.CONTINUE;
        }
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("walk", true));
            return PlayState.CONTINUE;
        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));
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

    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 4.0D).add(Attributes.MOVEMENT_SPEED, (double)0.2F).add(Attributes.ATTACK_DAMAGE, 2.0D);
    }

    public ItemStack getFoodItem() {
        return new ItemStack(CreaturesItems.RAW_SHRIMP, 1);
    }

    @Override
    public AgeableEntity getBreedOffspring(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        EdibleCrabEntity ediblecrab = (EdibleCrabEntity) getType().create(p_241840_1_);
        ediblecrab.setVariant(this.getVariant());
        return ediblecrab;
    }

    @Override
    public boolean canMate(AnimalEntity p_70878_1_) {
        if (p_70878_1_ == this) {
            return false;
        } else if (p_70878_1_.getClass() != this.getClass()) {
            return false;
        } else {
            return this.isInLove() && p_70878_1_.isInLove();
        }
    }

    public boolean isFood(ItemStack p_70877_1_) {
        return FOOD_ITEMS.test(p_70877_1_);
    }

    public int getVariant() {
        return MathHelper.clamp(this.entityData.get(DATA_VARIANT_ID), 1, 5);
    }

    public void setVariant(int p_191997_1_) {
        this.entityData.set(DATA_VARIANT_ID, p_191997_1_);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_VARIANT_ID, 0);
        this.entityData.define(GENDER, 0);
        this.entityData.define(THREAT, false);
    }

    public void setThreatPose(boolean p_70918_1_) {
        this.entityData.set(THREAT, p_70918_1_);
    }

    public boolean isThreatPose() {
        return this.entityData.get(THREAT);
    }

    public void addAdditionalSaveData(CompoundNBT p_213281_1_) {
        super.addAdditionalSaveData(p_213281_1_);
        p_213281_1_.putInt("Variant", this.getVariant());
        p_213281_1_.putInt("Gender", this.getGender());
        p_213281_1_.putBoolean("Threat", this.isThreatPose());
    }

    public void readAdditionalSaveData(CompoundNBT p_70037_1_) {
        super.readAdditionalSaveData(p_70037_1_);
        this.setVariant(p_70037_1_.getInt("Variant"));
        this.setGender(p_70037_1_.getInt("Gender"));
        this.setThreatPose(p_70037_1_.getBoolean("Threat"));
    }

    public int getGender() {
        return MathHelper.clamp(this.entityData.get(GENDER), 0, 2);
    }

    public void setGender(int p_191997_1_) {
        this.entityData.set(GENDER, p_191997_1_);
    }

    public boolean canBreatheUnderwater() {
        return true;
    }

    public ResourceLocation getDefaultLootTable() {
        if (this.getVariant() == 3) {
            return CreaturesLootTables.DUNGENESSCRAB;
        } if (this.getVariant() == 4) {
            return CreaturesLootTables.BLUE_CRAB;
        } if (this.getVariant() == 2) {
            return CreaturesLootTables.ROCKCRAB;
        }
        return CreaturesLootTables.EDIBLE_CRAB;
    }

    public static boolean checkAnimalSpawnRules(EntityType<? extends AnimalEntity> p_223316_0_, IWorld p_223316_1_, SpawnReason p_223316_2_, BlockPos p_223316_3_, Random p_223316_4_) {
        return p_223316_1_.getBlockState(p_223316_3_.below()).is(Blocks.SAND) && p_223316_1_.getRawBrightness(p_223316_3_, 0) > 8;
    }

    public void aiStep() {
        if (this.isThreatPose()) {
            this.getNavigation().stop();
        }
        super.aiStep();

    }

    public String getSpeciesName() {
        TranslationTextComponent translatable = SPECIES_NAMES.get(this.getVariant());
        if (translatable != null) {
            return translatable.getString();
        } return "Unknown";
    }

    public String getGenderString() {
        if (this.getGender() == 1) {
            ITextComponent i = new TranslationTextComponent("gui.male");
            return i.getString();
        } else {
            ITextComponent i = new TranslationTextComponent("gui.female");
            return i.getString();
        }
    }

    public int getIUCNStatus() {
        return -1;
    }

    public String getScientificName() {
        return SCIENTIFIC_NAMES.get(this.getVariant());
    }

    private void setDidAttack(boolean p_190714_1_) {
        this.didAttack = p_190714_1_;
    }

    public ITextComponent getFunFact() {
        TranslationTextComponent translatable = DESCRIPTIONS.get(this.getVariant());
        if (translatable != null) {
            return translatable;
        } return new TranslationTextComponent("creatures.unknown");
    }

    public class ThreatGoal extends Goal {
        private PlayerEntity angertarget;
        private final EntityPredicate predicate = (new EntityPredicate()).range(2.0D).allowInvulnerable().selector((p_220844_0_) -> {
            return !((PlayerEntity)p_220844_0_).isCrouching();
        });

        protected ThreatGoal() {
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
            angertarget = null;
        }

        public boolean canUse() {
            if (EdibleCrabEntity.this.isBaby() || EdibleCrabEntity.this.getTarget() != null) {
                return false;
            } else {
                List<PlayerEntity> list = EdibleCrabEntity.this.level.getNearbyEntities(PlayerEntity.class, this.predicate, EdibleCrabEntity.this, EdibleCrabEntity.this.getBoundingBox().inflate(2.0D, 2.0D, 2.0D));
                if (list.isEmpty()) {
                    return false;
                }
                angertarget = list.get(0);
                return true;

            }
        }

        public void start() {
            EdibleCrabEntity.this.getLookControl().setLookAt(this.angertarget, 10.0F, (float)EdibleCrabEntity.this.getMaxHeadXRot());
            EdibleCrabEntity.this.setDeltaMovement(0,0,0);
            EdibleCrabEntity.this.setThreatPose(true);
        }

        public void stop() {
            EdibleCrabEntity.this.setThreatPose(false);
            angertarget = null;
        }

        public boolean canContinueToUse() {
            if (EdibleCrabEntity.this.getTarget() != null) {
                return false;
            }
            List<PlayerEntity> list = EdibleCrabEntity.this.level.getNearbyEntities(PlayerEntity.class, this.predicate, EdibleCrabEntity.this, EdibleCrabEntity.this.getBoundingBox().inflate(4.0D, 4.0D, 4.0D));
            return !(list.isEmpty() || EdibleCrabEntity.this.isBaby());
        }

    }

    public String getGenderName() {
        if (this.getGender() == 1) {
            return "m";

        }        return "f";
    }

    public class WanderGoal extends WaterAvoidingRandomWalkingGoal {
        EdibleCrabEntity ediblecrab;
        public WanderGoal(CreatureEntity p_i47302_1_, double p_i47302_2_, float p_i47302_4_) {
            super(p_i47302_1_,p_i47302_2_,p_i47302_4_);
            ediblecrab = (EdibleCrabEntity) p_i47302_1_;
        }

        public boolean canUse() {
            return !ediblecrab.isThreatPose() && super.canUse();
        }

        public boolean canContinueToUse() {
            if (ediblecrab.isThreatPose()) {
                return false;
            }
            return super.canContinueToUse();
        }

    }

    static class HurtByTargetGoal extends net.minecraft.entity.ai.goal.HurtByTargetGoal {
        public HurtByTargetGoal(EdibleCrabEntity p_i47282_1_) {
            super(p_i47282_1_);
        }

        public boolean canContinueToUse() {
            if (this.mob instanceof EdibleCrabEntity) {
                EdibleCrabEntity ediblecrabentity = (EdibleCrabEntity)this.mob;
                if (ediblecrabentity.didAttack) {
                    ediblecrabentity.setDidAttack(false);
                    return false;
                }
            }

            return super.canContinueToUse();
        }
    }

    public int determineVariant() {
        return 5;
    }

    public boolean isPushedByFluid() {
        return false;
    }



}
