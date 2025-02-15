package com.frikinzi.creatures.entity;

import com.frikinzi.creatures.config.CreaturesConfig;
import com.frikinzi.creatures.entity.base.CreaturesBirdEntity;
import com.frikinzi.creatures.entity.base.TameableWalkingBirdBase;
import com.frikinzi.creatures.entity.egg.CreaturesEggEntity;
import com.frikinzi.creatures.registry.CreaturesItems;
import com.frikinzi.creatures.registry.CreaturesSound;
import com.frikinzi.creatures.registry.ModEntityTypes;
import com.frikinzi.creatures.util.CreaturesLootTables;
import com.frikinzi.creatures.util.EntityAttributes;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
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

import java.util.List;
import java.util.Map;
import java.util.Set;

public class PeafowlEntity extends TameableWalkingBirdBase implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);
    private PanicGoal PanicGoal;
    private static final DataParameter<Boolean> DISPLAYING = EntityDataManager.defineId(PeafowlEntity.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> ON_DISPLAY = EntityDataManager.defineId(PeafowlEntity.class, DataSerializers.BOOLEAN);
    private static final Ingredient FOOD_ITEMS = Ingredient.of(Items.WHEAT_SEEDS, Items.BEETROOT_SEEDS, Items.PUMPKIN_SEEDS, CreaturesItems.MEALWORMS);
    public static Map<Integer, TranslationTextComponent> SPECIES_NAMES = ImmutableMap.of(
            1, new TranslationTextComponent("message.creatures.greenpeafowl"),
            2, new TranslationTextComponent("message.creatures.indianpeafowl"),
            3, new TranslationTextComponent("message.creatures.albinopeafowl")
    );
    public static final Map<Integer, String> SCIENTIFIC_NAMES = ImmutableMap.<Integer, String>builder()
            .put(1, "Pavo muticus")
            .put(2, "Pavo cristatus")
            .put(3, "Pavo cristatus")
            .build();

    public PeafowlEntity(EntityType<? extends PeafowlEntity> p_i50251_1_, World p_i50251_2_) {
        super(p_i50251_1_, p_i50251_2_);
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event)
    {
        if (this.isInSittingPose()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("sleep", true));
            return PlayState.CONTINUE;
        }
        else if (this.isOnDisplay() && !this.isBaby() && !(this.getGender() == 0)) {
            if (event.isMoving()) {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("displaywalk", true));
                return PlayState.CONTINUE;
            }
            event.getController().setAnimation(new AnimationBuilder().addAnimation("display", false).addAnimation("displayidle", true));
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
            this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.4F));
            this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, true));
            this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)));
            this.targetSelector.removeGoal(PanicGoal);
            this.goalSelector.addGoal(1, new PeafowlEntity.DisplayGoal());
            //this.targetSelector.addGoal(2, new CreaturesBirdEntity.DefendBabyGoal());
        }

    }

    @Override
    public void registerControllers(AnimationData data)
    {
        data.addAnimationController(new AnimationController(this, "controller", 20, this::predicate));
    }

    @Override
    public AnimationFactory getFactory()
    {
        return this.factory;
    }

    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 12.0D).add(Attributes.MOVEMENT_SPEED, (double)0.2F).add(Attributes.ATTACK_DAMAGE, 2.0D);
    }

    public int determineVariant() {
        return 4;
    }

    @Override
    public AgeableEntity getBreedOffspring(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        PeafowlEntity peafowlentity = (PeafowlEntity) getType().create(p_241840_1_);
        peafowlentity.setVariant(this.getVariant());
        peafowlentity.setGender(this.random.nextInt(2));
        peafowlentity.setHeightMultiplier(getSpawnEggOffspringHeight());
        return peafowlentity;
    }

    @Override
    public boolean canMate(AnimalEntity p_70878_1_) {
        if (p_70878_1_ == this) {
            return false;
        } else if (p_70878_1_.getClass() != this.getClass()) {
            return false;
        } else {
            PeafowlEntity ospreyentity = (PeafowlEntity) p_70878_1_;
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
            return TAME_FOOD = Sets.newHashSet(Items.WHEAT_SEEDS, Items.PUMPKIN_SEEDS, Items.BEETROOT_SEEDS);
    }

    protected SoundEvent getAmbientSound() {
        if (!this.isSleeping()) {
        return CreaturesSound.PEAFOWL_AMBIENT; } else {
            return null;
        }
    }

    public ResourceLocation getDefaultLootTable() {
        return CreaturesLootTables.PEAFOWL;
    }

    @Override
    public int methodofDeterminingVariant(IWorld p_213610_1_) {
        int j = this.random.nextInt(100);
        if (j < 48) {
            return 1;
        } if (j < 98) {
            return 2;
        } else {
            return 3;
        }
    }

    public CreaturesEggEntity layEgg(CreaturesBirdEntity animal) {
        CreaturesEggEntity egg = new CreaturesEggEntity(ModEntityTypes.EGG.get(), this.level);
        egg.setSpecies(EntityAttributes.getBirdEntityMap().inverse().get(animal.getType()));
        egg.setGender(this.random.nextInt(2));
        if (this.getVariant() == 1) {
            if (this.random.nextInt(CreaturesConfig.lovebird_mutation_chance.get()) == 2) {
                egg.setVariant(3); }
            else {
                egg.setVariant(this.getVariant());
            }
        } else {
            egg.setVariant(this.getVariant());
        }
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
            return ((PeafowlEntity)p_220844_0_).getGender() == 0 && !((PeafowlEntity)p_220844_0_).isBaby();
        });

        protected DisplayGoal() {

        }

        public boolean canUse() {
            if (PeafowlEntity.this.getGender() == 0 || PeafowlEntity.this.isSleeping() || PeafowlEntity.this.isBaby()) {
                return false;
            } else {
                List<PeafowlEntity> list = PeafowlEntity.this.level.getNearbyEntities(PeafowlEntity.class, this.predicate, PeafowlEntity.this, PeafowlEntity.this.getBoundingBox().inflate(16.0D, 4.0D, 16.0D));
                if (list.isEmpty()) {
                    return false;
                } else {
                    return true;
                }
            }
        }

        public void start() {
            PeafowlEntity.this.getNavigation().stop();
            PeafowlEntity.this.setOnDisplay(true);
        }

        public void stop() {
            PeafowlEntity.this.setOnDisplay(false);
        }

        public boolean canContinueToUse() {
            List<PeafowlEntity> list = PeafowlEntity.this.level.getNearbyEntities(PeafowlEntity.class, this.predicate, PeafowlEntity.this, PeafowlEntity.this.getBoundingBox().inflate(16.0D, 4.0D, 16.0D));
            return !(list.isEmpty() || PeafowlEntity.this.isSleeping() || PeafowlEntity.this.isInSittingPose() || PeafowlEntity.this.isBaby());
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
        return Double.valueOf(CreaturesConfig.peafowl_hatch_chance.get()).floatValue();
    }

    public int getClutchSize() {
        return this.random.nextInt(CreaturesConfig.peafowl_clutch_size.get());
    }

    public int getIUCNStatus() {
        if (this.getVariant()== 1) {
            return 3;
        }
        return super.getIUCNStatus();
    }

    public String getScientificName() {
        return SCIENTIFIC_NAMES.get(this.getVariant());
    }

}
