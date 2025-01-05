package com.frikinzi.creatures.entity;

import com.frikinzi.creatures.config.CreaturesConfig;
import com.frikinzi.creatures.entity.ai.FollowFlockLeaderGoal;
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
import net.minecraft.block.Blocks;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.fish.CodEntity;
import net.minecraft.entity.passive.fish.SalmonEntity;
import net.minecraft.entity.passive.fish.TropicalFishEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeMod;
import org.codehaus.plexus.util.StringUtils;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class SeagullEntity extends NonTameableFlyingBirdBase implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);
    private static final Ingredient FOOD_ITEMS = Ingredient.of(Items.COD, Items.SALMON, Items.TROPICAL_FISH, CreaturesItems.CRAB_PINCERS, CreaturesItems.RAW_TROUT, Items.TROPICAL_FISH, Items.BREAD);
    public static final Map<Integer, TranslationTextComponent> SPECIES_NAMES = ImmutableMap.<Integer, TranslationTextComponent>builder()
            .put(1, new TranslationTextComponent("message.creatures.herringgull"))
            .put(2, new TranslationTextComponent("message.creatures.sabinesgull"))
            .put(3, new TranslationTextComponent("message.creatures.rossgull"))
            .put(4, new TranslationTextComponent("message.creatures.laughinggull"))
            .put(5, new TranslationTextComponent("message.creatures.heermannsgull"))
            .put(6, new TranslationTextComponent("message.creatures.ivorygull"))
            .put(7, new TranslationTextComponent("message.creatures.blackbilledgull"))
            .put(8, new TranslationTextComponent("message.creatures.andeangull"))
            .build();
    public static Map<Integer, TranslationTextComponent> DESCRIPTIONS = new HashMap<Integer, TranslationTextComponent>() {{
        put(1, new TranslationTextComponent("description.creatures.herringgull"));
        put(2, new TranslationTextComponent("description.creatures.sabinesgull"));
        put(3, new TranslationTextComponent("description.creatures.rossgull"));
        put(4, new TranslationTextComponent("description.creatures.laughinggull"));
        put(5, new TranslationTextComponent("description.creatures.heermannsgull"));
        put(6, new TranslationTextComponent("description.creatures.ivorygull"));
        put(7, new TranslationTextComponent("description.creatures.blackbilledgull"));
        put(8, new TranslationTextComponent("description.creatures.andeangull"));
    }};
    public static Map<Integer, String> SCIENTIFIC_NAMES = new HashMap<Integer, String>() {{
        put(1, "Larus argentatus");
        put(2, "Xema sabini");
        put(3, "Rhodostethia rosea");
        put(4, "Leucophaeus atricilla");
        put(5, "Larus heermanni");
        put(6, "Pagophila eburnea");
        put(7, "Chroicocephalus bulleri");
        put(8, "Chroicocephalus serranus");
    }};

    public SeagullEntity(EntityType<? extends SeagullEntity> p_i50251_1_, World p_i50251_2_) {
        super(p_i50251_1_, p_i50251_2_);
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.0D, false, FOOD_ITEMS));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, CodEntity.class, false));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, SalmonEntity.class, false));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, TropicalFishEntity.class, false));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, RedSnapperEntity.class, false));
        this.goalSelector.addGoal(6, new FollowFlockLeaderGoal(this));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event)
    {
        if (event.isMoving() && this.onGround || this.isInWater()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("walk", true));
            return PlayState.CONTINUE;
        } if (!this.onGround || this.isFlying()) {
        event.getController().setAnimation(new AnimationBuilder().addAnimation("fly", true));
        return PlayState.CONTINUE;
    } if (this.isSleeping()) {
        event.getController().setAnimation(new AnimationBuilder().addAnimation("sleep", true));
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
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 6.0D).add(Attributes.FLYING_SPEED, (double)0.8F).add(Attributes.MOVEMENT_SPEED, (double)0.4F).add(ForgeMod.SWIM_SPEED.get(), 3.0).add(Attributes.ATTACK_DAMAGE, 1.0D);
    }

    public int determineVariant() {
        return 9;
    }

    @Override
    public AgeableEntity getBreedOffspring(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        SeagullEntity seagullentity = (SeagullEntity) getType().create(p_241840_1_);
        seagullentity.setVariant(this.getVariant());
        seagullentity.setGender(this.random.nextInt(2));
        seagullentity.setHeightMultiplier(getSpawnEggOffspringHeight());
        return seagullentity;
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
            return TAME_FOOD = Sets.newHashSet(Items.COD, Items.SALMON, Items.BREAD, CreaturesItems.CRAB_PINCERS, CreaturesItems.RAW_TROUT, Items.TROPICAL_FISH);
    }

    protected SoundEvent getAmbientSound() {
        if (!this.isSleeping()) {
        return CreaturesSound.SEAGULL; } else {
            return null;
        }
    }


    public ResourceLocation getDefaultLootTable() {
        return CreaturesLootTables.SMALL_BIRD_GENERIC;
    }

    public String getSpeciesName() {
        TranslationTextComponent translatable = SPECIES_NAMES.get(this.getVariant());
        if (translatable != null) {
            return translatable.getString();
        } return "Unknown";
    }

    public ItemStack getFoodItem() {
        return new ItemStack(Items.COD, 1);
    }

    public String getFoodName() {
        return StringUtils.capitalizeFirstLetter(Items.COD.toString());
    }

    public float getHatchChance() {
        return CreaturesConfig.seagull_hatch_chance.get().floatValue();
    }

    public int getClutchSize() {
        return this.random.nextInt(CreaturesConfig.seagull_clutch_size.get());
    }

    public static boolean checkSeagullSpawnRules(EntityType<? extends AnimalEntity> p_223316_0_, IWorld p_223316_1_, SpawnReason p_223316_2_, BlockPos p_223316_3_, Random p_223316_4_) {
        return p_223316_1_.getBlockState(p_223316_3_.below()).is(Blocks.SAND) || p_223316_1_.getBlockState(p_223316_3_.below()).is(Blocks.GRASS_BLOCK) && p_223316_1_.getRawBrightness(p_223316_3_, 0) > 8;
    }

    public int getMaxFlockSize() {
        return 5;
    }

    public int getIUCNStatus() {
        if (this.getVariant() == 1) {
            return 2; //atlantic is vulnerable
        } return super.getIUCNStatus();
    }
    public String getScientificName() {
        return SCIENTIFIC_NAMES.get(this.getVariant());
    }

    public ITextComponent getFunFact() {
        return new TranslationTextComponent("description.creatures.gull");
    }


}
