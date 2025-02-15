package com.frikinzi.creatures.entity;

import com.frikinzi.creatures.config.CreaturesConfig;
import com.frikinzi.creatures.entity.ai.FollowFlockLeaderGoal;
import com.frikinzi.creatures.entity.ai.LandOnOwnersShoulderGoal;
import com.frikinzi.creatures.entity.base.CreaturesBirdEntity;
import com.frikinzi.creatures.entity.base.TameableBirdBase;
import com.frikinzi.creatures.entity.egg.CreaturesEggEntity;
import com.frikinzi.creatures.registry.CreaturesItems;
import com.frikinzi.creatures.registry.CreaturesSound;
import com.frikinzi.creatures.registry.ModEntityTypes;
import com.frikinzi.creatures.util.EntityAttributes;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.OwnerHurtByTargetGoal;
import net.minecraft.entity.ai.goal.OwnerHurtTargetGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
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

import javax.annotation.Nullable;
import java.util.Map;
import java.util.Set;

public class LorikeetEntity extends TameableBirdBase implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);
    private static final Ingredient FOOD_ITEMS = Ingredient.of(CreaturesItems.NECTAR);
    private boolean isGumi;
    public static final Map<Integer, TranslationTextComponent> SPECIES_NAMES = ImmutableMap.<Integer, TranslationTextComponent>builder()
            .put(1, new TranslationTextComponent("message.creatures.lorikeet.rainbow"))
            .put(2, new TranslationTextComponent("message.creatures.lorikeet.black"))
            .put(3, new TranslationTextComponent("message.creatures.lorikeet.blue"))
            .put(4, new TranslationTextComponent("message.creatures.lorikeet.olive"))
            .put(5, new TranslationTextComponent("message.creatures.lorikeet.chattering"))
            .put(6, new TranslationTextComponent("message.creatures.lorikeet.duskylory"))
            .build();
    public static final Map<Integer, String> SCIENTIFIC_NAMES = ImmutableMap.<Integer, String>builder()
            .put(1, "Trichoglossus moluccanus")
            .put(2, "Eos cyanogenia")
            .put(3, "Trichoglossus moluccanus")
            .put(4, "Trichoglossus euteles")
            .put(5, "Lorius garrulus")
            .put(6, "Pseudeos fuscata")
            .build();

    public LorikeetEntity(EntityType<? extends LorikeetEntity> p_i50251_1_, World p_i50251_2_) {
        super(p_i50251_1_, p_i50251_2_);
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(6, new FollowFlockLeaderGoal(this));
        this.goalSelector.addGoal(3, new LandOnOwnersShoulderGoal(this));

    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event)
    {
        if (event.isMoving() && this.onGround) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("walk", true));
            return PlayState.CONTINUE;
        } if (!this.onGround || this.isFlying()) {
        event.getController().setAnimation(new AnimationBuilder().addAnimation("fly", true));
        return PlayState.CONTINUE;
    } if (this.isSleeping()) {
        event.getController().setAnimation(new AnimationBuilder().addAnimation("sleep", true));
        return PlayState.CONTINUE;
    } if (this.isInSittingPose()) {
        event.getController().setAnimation(new AnimationBuilder().addAnimation("sit", true));
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
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 6.0D).add(Attributes.FLYING_SPEED, (double)0.8F).add(Attributes.MOVEMENT_SPEED, (double)0.4F);
    }

    public int determineVariant() {
        return 7;
    }

    @Override
    public AgeableEntity getBreedOffspring(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        LorikeetEntity lorikeetentity = (LorikeetEntity) getType().create(p_241840_1_);
        lorikeetentity.setGender(this.random.nextInt(2));
        if (this.getVariant() == 1) {
            if (this.random.nextInt(CreaturesConfig.lorikeet_mutation_chance.get()) == 1) {
            lorikeetentity.setVariant(3); }
            else {
                lorikeetentity.setVariant(this.getVariant());
            }
        } else {
            lorikeetentity.setVariant(this.getVariant());
        }
        lorikeetentity.setHeightMultiplier(getSpawnEggOffspringHeight());
        return lorikeetentity;
    }


    public CreaturesEggEntity layEgg(CreaturesBirdEntity animal) {
        CreaturesEggEntity egg = new CreaturesEggEntity(ModEntityTypes.EGG.get(), this.level);
        egg.setSpecies(EntityAttributes.getBirdEntityMap().inverse().get(animal.getType()));
        egg.setGender(this.random.nextInt(2));
        if (this.getVariant() == 1) {
            if (this.random.nextInt(CreaturesConfig.lorikeet_mutation_chance.get()) == 1) {
                egg.setVariant(3); }
            else {
                egg.setVariant(this.getVariant());
            }
        } else {
            egg.setVariant(this.getVariant());
        }
        return egg;
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

    public Set<Item> getTamedFood() {
            return TAME_FOOD = Sets.newHashSet(CreaturesItems.NECTAR);
    }

    protected SoundEvent getAmbientSound() {
        if (this.getVariant() == 5 && this.isGumi == true && !this.isSleeping()) {
            return CreaturesSound.LORIKEET_AMBIENT2;
        }
        else if (!this.isSleeping()) {
        return CreaturesSound.LORIKEET_AMBIENT; } else {
            return null;
        }
    }

    public void setCustomName(@Nullable ITextComponent p_200203_1_) {
        super.setCustomName(p_200203_1_);
        if (!this.isGumi && p_200203_1_ != null && p_200203_1_.getString().equals("Gumi")) {
            this.isGumi = true;
        }

    }

    public void addAdditionalSaveData(CompoundNBT p_213281_1_) {
        super.addAdditionalSaveData(p_213281_1_);
        if (this.isGumi) {
            p_213281_1_.putBoolean("Gumi", true);
        }

    }

    public void readAdditionalSaveData(CompoundNBT p_70037_1_) {
        super.readAdditionalSaveData(p_70037_1_);
        if (p_70037_1_.contains("Gumi", 99)) {
            this.isGumi = p_70037_1_.getBoolean("Gumi");
        }

    }

    @Override
    public int methodofDeterminingVariant(IWorld p_213610_1_) {
        if (CreaturesConfig.breed_only_variants.get() == true) {
            int i = this.random.nextInt(determineVariant());
            while (i == 3) {
                i = this.random.nextInt(determineVariant());
            }
            return i; }

        else {
            return this.random.nextInt(determineVariant());
        }

    }

    public String getSpeciesName() {
        TranslationTextComponent translatable = SPECIES_NAMES.get(this.getVariant());
        if (translatable != null) {
            return translatable.getString();
        } return "Unknown";
    }

    public ItemStack getFoodItem() {
        return new ItemStack(CreaturesItems.NECTAR, 1);
    }

    public float getHatchChance() {
        return Double.valueOf(CreaturesConfig.lorikeet_hatch_chance.get()).floatValue();
    }

    public int getClutchSize() {
        return this.random.nextInt(CreaturesConfig.lorikeet_clutch_size.get());
    }

    public int getMaxFlockSize() {
        return 10;
    }

    public int getIUCNStatus() {
        if (this.getVariant()== 2) {
            return 1;
        } if (this.getVariant() == 4) {
            return 2;
        }
        return super.getIUCNStatus();
    }

    public String getScientificName() {
        return SCIENTIFIC_NAMES.get(this.getVariant());
    }

    public ITextComponent getFunFact() {
        return new TranslationTextComponent("description.creatures.lorikeet");
    }

}
