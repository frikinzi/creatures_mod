package com.frikinzi.creatures.entity;

import com.frikinzi.creatures.config.CreaturesConfig;
import com.frikinzi.creatures.entity.base.CreaturesBirdEntity;
import com.frikinzi.creatures.entity.base.NonTameableFlyingBirdBase;
import com.frikinzi.creatures.entity.egg.CreaturesEggEntity;
import com.frikinzi.creatures.registry.CreaturesItems;
import com.frikinzi.creatures.registry.CreaturesSound;
import com.frikinzi.creatures.registry.ModEntityTypes;
import com.frikinzi.creatures.util.CreaturesLootTables;
import com.frikinzi.creatures.util.EntityAttributes;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NonTamedTargetGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public class FrigateBirdEntity extends NonTameableFlyingBirdBase implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);
    private PanicGoal PanicGoal;
    public static final Predicate<LivingEntity> PREY_SELECTOR = (p_213440_0_) -> {
        EntityType<?> entitytype = p_213440_0_.getType();
        return entitytype == ModEntityTypes.GOLDFISH.get() || entitytype == EntityType.SALMON || entitytype == ModEntityTypes.GOURAMI.get() || entitytype == ModEntityTypes.GUPPY.get() || entitytype == ModEntityTypes.SHRIMP.get();
    };
    private static final DataParameter<Boolean> DISPLAYING = EntityDataManager.defineId(FrigateBirdEntity.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> ON_DISPLAY = EntityDataManager.defineId(FrigateBirdEntity.class, DataSerializers.BOOLEAN);
    private static final Ingredient FOOD_ITEMS = Ingredient.of(Items.WHEAT_SEEDS, Items.BEETROOT_SEEDS, Items.PUMPKIN_SEEDS, CreaturesItems.MEALWORMS);
    public static final Map<Integer, TranslationTextComponent> SPECIES_NAMES = ImmutableMap.<Integer, TranslationTextComponent>builder()
            .put(1, new TranslationTextComponent("message.creatures.magnificentfrigate"))
            .put(2, new TranslationTextComponent("message.creatures.greatfrigate"))
            .put(3, new TranslationTextComponent("message.creatures.ascensionfrigate"))
            .put(4, new TranslationTextComponent("message.creatures.christmasislandfrigate"))
            .put(5, new TranslationTextComponent("message.creatures.lesserfrigate"))
            .build();
    public static final Map<Integer, TranslationTextComponent> DESCRIPTIONS = ImmutableMap.<Integer, TranslationTextComponent>builder()
            .put(1, new TranslationTextComponent("description.creatures.magnificentfrigate"))
            .put(2, new TranslationTextComponent("description.creatures.greatfrigate"))
            .put(3, new TranslationTextComponent("description.creatures.ascensionfrigate"))
            .put(4, new TranslationTextComponent("description.creatures.christmasislandfrigate"))
            .put(5, new TranslationTextComponent("description.creatures.lesserfrigate"))
            .build();
    public static final Map<Integer, String> SCIENTIFIC_NAMES = ImmutableMap.<Integer, String>builder()
            .put(1, "Fregata magnificens")
            .put(2, "Fregata minor")
            .put(3, "Fregata aquila")
            .put(4, "Fregata andrewsi")
            .put(5, "Fregata ariel")
            .build();

    public FrigateBirdEntity(EntityType<? extends FrigateBirdEntity> p_i50251_1_, World p_i50251_2_) {
        super(p_i50251_1_, p_i50251_2_);
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event)
    {
        if (this.isFlying()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("fly", true));
            return PlayState.CONTINUE;
        }
        if (this.isOnGround() && this.isOnDisplay() && !this.isBaby() && !(this.getGender() == 0)) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("inflate", false).addAnimation("inflateidle", true));
            return PlayState.CONTINUE;
        } else {
            if (event.isMoving()) {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("walk", true));
                return PlayState.CONTINUE;
            }
            if (this.isSleeping()) {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("sleep", true));
                return PlayState.CONTINUE;
            }
            event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));
            return PlayState.CONTINUE;
        }
    }

    protected void registerGoals() {
        super.registerGoals();
        if (!this.isBaby()) {
            this.goalSelector.addGoal(1, new FrigateBirdEntity.DisplayGoal());
            this.targetSelector.addGoal(5, new NonTamedTargetGoal<>(this, WaterMobEntity.class, false, PREY_SELECTOR));
            this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, true));
        }


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
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 8.0D).add(Attributes.FLYING_SPEED, (double)0.8F).add(Attributes.MOVEMENT_SPEED, (double)0.2F).add(Attributes.ATTACK_DAMAGE, 2.0D);
    }

    public int determineVariant() {
        return 6;
    }

    @Override
    public AgeableEntity getBreedOffspring(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        FrigateBirdEntity boobyentity = (FrigateBirdEntity) getType().create(p_241840_1_);
        boobyentity.setVariant(this.getVariant());
        boobyentity.setGender(this.random.nextInt(2));
        boobyentity.setHeightMultiplier(getSpawnEggOffspringHeight());
        return boobyentity;
    }

    @Override
    public boolean canMate(AnimalEntity p_70878_1_) {
        if (p_70878_1_ == this) {
            return false;
        } else if (p_70878_1_.getClass() != this.getClass()) {
            return false;
        } else {
            FrigateBirdEntity ospreyentity = (FrigateBirdEntity) p_70878_1_;
            if (!ospreyentity.isTame()) {
                return false;
            }
            else if (ospreyentity.isInSittingPose()) {
                return false;
            }
            return this.isInLove() && p_70878_1_.isInLove();
        }
    }

    public boolean isFood(ItemStack p_70877_1_) {
        return FOOD_ITEMS.test(p_70877_1_);
    }

    public Set<Item> getTamedFood() {
            return TAME_FOOD = Sets.newHashSet(Items.COD, CreaturesItems.RAW_SHRIMP);
    }

    protected SoundEvent getAmbientSound() {
        if (!this.isSleeping()) {
        return CreaturesSound.FRIGATE_AMBIENT; } else {
            return null;
        }
    }

    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return CreaturesSound.BOOBY_HURT;
    }


    public ResourceLocation getDefaultLootTable() {
        return CreaturesLootTables.SMALL_BIRD_GENERIC;
    }

    public CreaturesEggEntity layEgg(CreaturesBirdEntity animal) {
        CreaturesEggEntity egg = new CreaturesEggEntity(ModEntityTypes.EGG.get(), this.level);
        egg.setSpecies(EntityAttributes.getBirdEntityMap().inverse().get(animal.getType()));
        egg.setGender(this.random.nextInt(2));
        egg.setVariant(this.getVariant());
        return egg;
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DISPLAYING, false);
        this.entityData.define(ON_DISPLAY, false);
    }

    public void setDisplaying(boolean p_70918_1_) {
        this.entityData.set(DISPLAYING, p_70918_1_);
    }

    public boolean isDisplaying() {
        return this.entityData.get(DISPLAYING);
    }

    public void setOnDisplay(boolean p_70918_1_) {
        this.entityData.set(ON_DISPLAY, p_70918_1_);
    }

    public boolean isOnDisplay() {
        return this.entityData.get(ON_DISPLAY);
    }

    public class DisplayGoal extends Goal {
        private final EntityPredicate predicate = (new EntityPredicate()).range(16.0D).allowInvulnerable().selector((p_220844_0_) -> {
            return ((FrigateBirdEntity)p_220844_0_).getGender() == 0 && !((FrigateBirdEntity)p_220844_0_).isBaby();
        });

        protected DisplayGoal() {

        }

        public boolean canUse() {
            if (FrigateBirdEntity.this.isBaby()) {
                return false;
            }
            if (!FrigateBirdEntity.this.isOnGround()) {
                return false;
            }
            if (FrigateBirdEntity.this.getGender() == 0 || FrigateBirdEntity.this.isSleeping() || FrigateBirdEntity.this.isBaby()) {
                return false;
            } else {
                List<FrigateBirdEntity> list = FrigateBirdEntity.this.level.getNearbyEntities(FrigateBirdEntity.class, this.predicate, FrigateBirdEntity.this, FrigateBirdEntity.this.getBoundingBox().inflate(16.0D, 4.0D, 16.0D));
                if (list.isEmpty()) {
                    return false;
                } else {
                    return true;
                }
            }
        }

        public void start() {
            FrigateBirdEntity.this.getNavigation().stop();
            FrigateBirdEntity.this.setOnDisplay(true);
        }

        public void stop() {
            FrigateBirdEntity.this.setOnDisplay(false);
        }

        public boolean canContinueToUse() {
            List<FrigateBirdEntity> list = FrigateBirdEntity.this.level.getNearbyEntities(FrigateBirdEntity.class, this.predicate, FrigateBirdEntity.this, FrigateBirdEntity.this.getBoundingBox().inflate(16.0D, 4.0D, 16.0D));
            return !(list.isEmpty() || FrigateBirdEntity.this.isSleeping()  || FrigateBirdEntity.this.isBaby());
        }

    }

    public String getGenderName() {
        if (this.getGender() == 1) {
            return "m";
        } else {
            return "f";
        }
    }

    public String getSpeciesName() {
        TranslationTextComponent translatable = SPECIES_NAMES.get(this.getVariant());
        if (translatable != null) {
            return translatable.getString();
        } return "Unknown";
    }

    public float getHatchChance() {
        return Double.valueOf(CreaturesConfig.frigate_hatch_chance.get()).floatValue();
    }

    public int getClutchSize() {
        return this.random.nextInt(CreaturesConfig.frigate_clutch_size.get());
    }

    public void aiStep() {
        super.aiStep();
        Vector3d vector3d = this.getDeltaMovement();
        if (this.isAggressive() & !this.onGround && vector3d.y < 0.0D) {
            this.setDeltaMovement(vector3d.multiply(1.0D, 2.0D, 1.0D));
        }
    }

    public int getIUCNStatus() {
        if (this.getVariant() == 4) {
            return 4;
        }
        if (this.getVariant() == 3) {
            return 2;
        } return super.getIUCNStatus();
    }

    public ITextComponent getFunFact() {
        return new TranslationTextComponent("description.creatures.frigate");
    }

    public String getScientificName() {
        return SCIENTIFIC_NAMES.get(this.getVariant());
    }

}
