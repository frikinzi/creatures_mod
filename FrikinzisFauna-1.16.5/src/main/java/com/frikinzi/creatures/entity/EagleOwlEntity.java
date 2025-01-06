package com.frikinzi.creatures.entity;

import com.frikinzi.creatures.config.CreaturesConfig;
import com.frikinzi.creatures.entity.base.RaptorBase;
import com.frikinzi.creatures.registry.CreaturesItems;
import com.frikinzi.creatures.registry.CreaturesSound;
import com.frikinzi.creatures.util.CreaturesLootTables;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
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

import java.util.Map;
import java.util.Set;

public class EagleOwlEntity extends RaptorBase implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);
    private static final Ingredient FOOD_ITEMS = Ingredient.of(Items.CHICKEN, Items.ROTTEN_FLESH, CreaturesItems.SMALL_BIRD_MEAT, CreaturesItems.LARGE_BIRD_MEAT, Items.PORKCHOP, Items.BEEF, Items.RABBIT);
    public static Map<Integer, TranslationTextComponent> SPECIES_NAMES = ImmutableMap.of(
            1, new TranslationTextComponent("message.creatures.eurasianeagleowl"),
            2, new TranslationTextComponent("message.creatures.duskyeagleowl")
    );
    public static final Map<Integer, String> SCIENTIFIC_NAMES = ImmutableMap.<Integer, String>builder()
            .put(1, "Bubo bubo")
            .put(2, "Ketupa coromanda")
            .build();

    public EagleOwlEntity(EntityType<? extends EagleOwlEntity> p_i50251_1_, World p_i50251_2_) {
        super(p_i50251_1_, p_i50251_2_);
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event)
    {

        if (event.isMoving() && this.onGround) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("walk", true));
            return PlayState.CONTINUE;
        }
        if (!this.onGround || this.isFlying()) {
            if (this.isBaby()) {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("baby_fly", true));
                return PlayState.CONTINUE;
            }
            event.getController().setAnimation(new AnimationBuilder().addAnimation("fly", true));
            return PlayState.CONTINUE;
        }
        if (this.isSleeping()) {
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
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 16.0D).add(Attributes.FLYING_SPEED, (double)0.8F).add(Attributes.MOVEMENT_SPEED, (double)0.4F).add(Attributes.ATTACK_DAMAGE, 2.0D);
    }

    public int determineVariant() {
        return 3;
    }

    @Override
    public AgeableEntity getBreedOffspring(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        EagleOwlEntity barnowlentity = (EagleOwlEntity) getType().create(p_241840_1_);
        barnowlentity.setGender(this.random.nextInt(2));
        barnowlentity.setVariant(this.getVariant());
        barnowlentity.setHeightMultiplier(getSpawnEggOffspringHeight());
        return barnowlentity;
    }

    @Override
    public boolean canMate(AnimalEntity p_70878_1_) {
        if (p_70878_1_ == this) {
            return false;
        } else if (p_70878_1_.getClass() != this.getClass()) {
            return false;
        } else {
            EagleOwlEntity eagleowlentity = (EagleOwlEntity) p_70878_1_;
            if (!eagleowlentity.isTame()) {
                return false;
            }
            else if (eagleowlentity.isInSittingPose()) {
                return false;
            }
            return this.isInLove() && p_70878_1_.isInLove();
        }
    }

    public boolean isFood(ItemStack p_70877_1_) {
        return FOOD_ITEMS.test(p_70877_1_);
    }

    protected SoundEvent getAmbientSound() {
        if (!this.isSleeping()) {
        return CreaturesSound.EAGLEOWL_AMBIENT; }
        return null;
    }

    @Override
    public Set<Item> getTamedFood() {
        TAME_FOOD = Sets.newHashSet(Items.CHICKEN, Items.ROTTEN_FLESH, CreaturesItems.SMALL_BIRD_MEAT);
        return TAME_FOOD;
    }

    @Override
    public boolean getTime() {
        return EagleOwlEntity.this.level.isDay();
    }

    public ResourceLocation getDefaultLootTable() {
        return CreaturesLootTables.SMALL_BIRD_OF_PREY;
    }

    public String getSpeciesName() {
        TranslationTextComponent translatable = SPECIES_NAMES.get(this.getVariant());
        if (translatable != null) {
            return translatable.getString();
        } return "Unknown";
    }

    public ItemStack getFoodItem() {
        return new ItemStack(Items.CHICKEN, 1);
    }

    public float getHatchChance() {
        return Double.valueOf(CreaturesConfig.eagleowl_hatch_chance.get()).floatValue();
    }

    public int getClutchSize() {
        return this.random.nextInt(CreaturesConfig.eagleowl_clutch_size.get());
    }

    public String getScientificName() {
        return SCIENTIFIC_NAMES.get(this.getVariant());
    }

    public ITextComponent getFunFact() {
        return new TranslationTextComponent("description.creatures.eagleowl");
    }

}