package com.frikinzi.creatures.entity;

import com.frikinzi.creatures.config.CreaturesConfig;
import com.frikinzi.creatures.entity.ai.CreaturesFollowGoal;
import com.frikinzi.creatures.entity.ai.MateGoal;
import com.frikinzi.creatures.entity.ai.StayCloseToChildGoal;
import com.frikinzi.creatures.entity.ai.StayCloseToEggGoal;
import com.frikinzi.creatures.entity.base.CreaturesBirdEntity;
import com.frikinzi.creatures.entity.base.NonTameableBirdBase;
import com.frikinzi.creatures.entity.base.TameableWalkingBirdBase;
import com.frikinzi.creatures.entity.egg.CreaturesEggEntity;
import com.frikinzi.creatures.registry.CreaturesSound;
import com.frikinzi.creatures.registry.ModEntityTypes;
import com.frikinzi.creatures.util.CreaturesLootTables;
import com.frikinzi.creatures.util.EntityAttributes;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.fish.CodEntity;
import net.minecraft.entity.passive.fish.SalmonEntity;
import net.minecraft.entity.passive.fish.TropicalFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.*;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.*;
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

public class CrestedPenguinEntity extends NonTameableBirdBase implements IAnimatable {
    private final GroundPathNavigator groundNavigation;
    protected final SwimmerPathNavigator waterNavigation;
    private boolean searchingForLand;
    private static final DataParameter<Integer> VARIANT_SUBID = EntityDataManager.defineId(CrestedPenguinEntity.class, DataSerializers.INT);
    private AnimationFactory factory = new AnimationFactory(this);
    private static final DataParameter<BlockPos> TRAVEL_POS = EntityDataManager.defineId(CrestedPenguinEntity.class, DataSerializers.BLOCK_POS);
    private static final DataParameter<Boolean> TRAVELLING = EntityDataManager.defineId(CrestedPenguinEntity.class, DataSerializers.BOOLEAN);
    private static final Ingredient FOOD_ITEMS = Ingredient.of(Items.COD);
    public static final Map<Integer, TranslationTextComponent> SPECIES_NAMES;

    static {
        Map<Integer, TranslationTextComponent> messageMap = new HashMap<>();
        messageMap.put(1, new TranslationTextComponent("message.creatures.fiordland"));
        messageMap.put(2, new TranslationTextComponent("message.creatures.snarescrested"));
        messageMap.put(3, new TranslationTextComponent("message.creatures.erectcrested"));
        messageMap.put(4, new TranslationTextComponent("message.creatures.southernrockhopper"));
        messageMap.put(5, new TranslationTextComponent("message.creatures.easternrockhopper"));
        messageMap.put(6, new TranslationTextComponent("message.creatures.northernrockhopper"));
        messageMap.put(7, new TranslationTextComponent("message.creatures.macaroni"));
        messageMap.put(8, new TranslationTextComponent("message.creatures.royalpenguin"));
        SPECIES_NAMES = Collections.unmodifiableMap(messageMap);
    }
    public static final Map<Integer, TranslationTextComponent> DESCRIPTION;

    static {
        Map<Integer, TranslationTextComponent> messageMap = new HashMap<>();
        messageMap.put(1, new TranslationTextComponent("description.creatures.fiordland"));
        messageMap.put(2, new TranslationTextComponent("description.creatures.snarescrested"));
        messageMap.put(3, new TranslationTextComponent("description.creatures.erectcrested"));
        messageMap.put(4, new TranslationTextComponent("description.creatures.southernrockhopper"));
        messageMap.put(5, new TranslationTextComponent("description.creatures.easternrockhopper"));
        messageMap.put(6, new TranslationTextComponent("description.creatures.northernrockhopper"));
        messageMap.put(7, new TranslationTextComponent("description.creatures.macaroni"));
        messageMap.put(8, new TranslationTextComponent("description.creatures.royalpenguin"));
        DESCRIPTION = Collections.unmodifiableMap(messageMap);
    }

    public static final Map<Integer, String> SCIENTIFIC_NAMES = ImmutableMap.<Integer, String>builder()
            .put(1, "Eudyptes pachyrhynchus")
            .put(2, "Eudyptes robustus")
            .put(3, "Eudyptes sclateri")
            .put(4, "Eudyptes chrysocome")
            .put(5, "Eudyptes filholi")
            .put(6, "Eudyptes moseleyi")
            .put(7, "Eudyptes chrysolophus")
            .put(8, "Eudyptes schlegeli")
            .build();

    public CrestedPenguinEntity(EntityType<? extends CrestedPenguinEntity> p_i50251_1_, World p_i50251_2_) {
        super(p_i50251_1_, p_i50251_2_);
        this.setPathfindingMalus(PathNodeType.WATER, 0.0F);
        this.moveControl = new CrestedPenguinEntity.MoveHelperController(this);
        this.maxUpStep = 1.0F;
        this.groundNavigation = new GroundPathNavigator(this, p_i50251_2_);
        this.waterNavigation = new SwimmerPathNavigator(this, p_i50251_2_);

    }

    @Nullable
    public ILivingEntityData finalizeSpawn(IServerWorld p_213386_1_, DifficultyInstance p_213386_2_, SpawnReason p_213386_3_, @Nullable ILivingEntityData p_213386_4_, @Nullable CompoundNBT p_213386_5_) {
        this.setTravelPos(BlockPos.ZERO);

        return super.finalizeSpawn(p_213386_1_, p_213386_2_, p_213386_3_, p_213386_4_, p_213386_5_);
    }

   protected PathNavigator createNavigation(World p_175447_1_) {
       return new CrestedPenguinEntity.Navigator(this, p_175447_1_);
   }

    protected float nextStep() {
        return this.moveDist + 0.15F;
    }

    public float getWalkTargetValue(BlockPos p_205022_1_, IWorldReader p_205022_2_) {
        if (p_205022_2_.getFluidState(p_205022_1_).is(FluidTags.WATER)) {
            return 10.0F;
        } else {
            return p_205022_2_.getBrightness(p_205022_1_) - 0.5F;
        }
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event)
    {
        if (this.isInWater()) {
            if (this.isBaby()) {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("swim", true));
                return PlayState.CONTINUE;
            }
            if (!event.isMoving()) {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("swim", true));
                return PlayState.CONTINUE;
            }
            event.getController().setAnimation(new AnimationBuilder().addAnimation("dive", true));
            return PlayState.CONTINUE;
        }
        else {
            if (event.isMoving()) {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("walk", true));
                return PlayState.CONTINUE;
            }

            if (this.isSleeping()) {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("sleep", true));
                return PlayState.CONTINUE;
            }
            if (this.isGrooming()) {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("grooming", true));
                return PlayState.CONTINUE;

            }
            event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));
            return PlayState.CONTINUE;
        }
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(7, new CrestedPenguinEntity.TravelGoal(this, 1.0D));
        this.goalSelector.addGoal(9, new CrestedPenguinEntity.WanderGoal(this, 1.0D, 100));
        this.goalSelector.addGoal(1, new StayCloseToEggGoal(this, 1.0D));
        this.goalSelector.addGoal(10, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(6, new CreaturesFollowGoal(this,1.0D, 5.0F, 1.0F, true));
        this.goalSelector.addGoal(0, new SleepGoal());
        this.goalSelector.addGoal(2, new StayCloseToChildGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(1, new MateGoal(this, 1.0D));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, CodEntity.class, false));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, SalmonEntity.class, false));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, TropicalFishEntity.class, false));

    }

    @Override
    public void registerControllers(AnimationData data)
    {
        data.addAnimationController(new AnimationController(this, "controller", 10, this::predicate));
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
        return 9;
    }

    @Override
    public AgeableEntity getBreedOffspring(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        CrestedPenguinEntity crestedpenguin = (CrestedPenguinEntity) getType().create(p_241840_1_);
        crestedpenguin.setVariant(this.getVariant());
        crestedpenguin.setGender(this.random.nextInt(2));
        crestedpenguin.setHeightMultiplier(getSpawnEggOffspringHeight());
        return crestedpenguin;
    }

    protected void playSwimSound(float p_203006_1_) {
        super.playSwimSound(p_203006_1_ * 1.5F);
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

    public int methodofDeterminingVariant(IWorld p_213610_1_) {
        if (this.random.nextInt(10) == 1) {
            this.setSubVariant(2);
        } return super.methodofDeterminingVariant(p_213610_1_);
    }

    public boolean isFood(ItemStack p_70877_1_) {
        return FOOD_ITEMS.test(p_70877_1_);
    }

    protected SoundEvent getAmbientSound() {
        if (!this.isSleeping()) {
        return CreaturesSound.CRESTED_PENGUIN; } else {
            return null;
        }
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

    public void updateSwimming() {
        if (!this.level.isClientSide) {
            if (this.isEffectiveAi() && this.isInWater() && this.wantsToSwim()) {
                this.navigation = this.waterNavigation;
                this.setSwimming(true);
            } else {
                this.navigation = this.groundNavigation;
                this.setSwimming(false);
            }
        }

    }

    private boolean wantsToSwim() {
        if (this.searchingForLand) {
            return true;
        } else {
            LivingEntity livingentity = this.getTarget();
            return livingentity != null && livingentity.isInWater();
        }
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(TRAVELLING, false);
        this.entityData.define(TRAVEL_POS, BlockPos.ZERO);
        this.entityData.define(VARIANT_SUBID, 0);
    }

    private void setTravelPos(BlockPos p_203019_1_) {
        this.entityData.set(TRAVEL_POS, p_203019_1_);
    }

    private BlockPos getTravelPos() {
        return this.entityData.get(TRAVEL_POS);
    }

    public void setSubVariant(int p_191997_1_) {
        this.entityData.set(VARIANT_SUBID, p_191997_1_);
    }

    public int getSubVariant() {
        return MathHelper.clamp(this.entityData.get(VARIANT_SUBID), 1, 3);
    }

    public void readAdditionalSaveData(CompoundNBT p_70037_1_) {
        super.readAdditionalSaveData(p_70037_1_);
        int l = p_70037_1_.getInt("TravelPosX");
        int i1 = p_70037_1_.getInt("TravelPosY");
        int j1 = p_70037_1_.getInt("TravelPosZ");
        this.setTravelPos(new BlockPos(l, i1, j1));
        this.setSubVariant(p_70037_1_.getInt("Subvariant"));
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

    public void addAdditionalSaveData(CompoundNBT p_213281_1_) {
        super.addAdditionalSaveData(p_213281_1_);
        p_213281_1_.putInt("TravelPosX", this.getTravelPos().getX());
        p_213281_1_.putInt("TravelPosY", this.getTravelPos().getY());
        p_213281_1_.putInt("TravelPosZ", this.getTravelPos().getZ());
        p_213281_1_.putInt("Subvariant", this.getSubVariant());
    }

    public float getHatchChance() {
        return Double.valueOf(CreaturesConfig.peafowl_hatch_chance.get()).floatValue();
    }

    public int getClutchSize() {
        return this.random.nextInt(CreaturesConfig.peafowl_clutch_size.get());
    }

    private boolean isTravelling() {
        return this.entityData.get(TRAVELLING);
    }

    private void setTravelling(boolean p_203021_1_) {
        this.entityData.set(TRAVELLING, p_203021_1_);
    }

    public void travel(Vector3d p_213352_1_) {
        if (this.isEffectiveAi() && this.isInWater()) {
            this.moveRelative(0.1F, p_213352_1_);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
//            if (this.getTarget() == null) {
//                this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
//            }
        } else {
            super.travel(p_213352_1_);
        }

    }

    public void aiStep() {
        if (!this.level.isClientSide) {
            if (this.isBaby()) {
                this.getNavigation().stop();
            }
            int i = this.random.nextInt(3000);
            if (i == 0 && !this.isInWater() && !this.isSleeping() && !this.isBaby()) {
                this.getNavigation().stop();
                this.setGrooming(true);
            }
            if ((i == 1 || this.isInWater()) && this.isGrooming()) {
                this.setGrooming(false);
            }
        }
        super.aiStep();
    }

    static class MoveHelperController extends MovementController {
        private final CrestedPenguinEntity penguin;

        MoveHelperController(CrestedPenguinEntity p_i48817_1_) {
            super(p_i48817_1_);
            this.penguin = p_i48817_1_;
        }

        private void updateSpeed() {
 //           if (this.cormorant.isInWater()) {
 //               this.cormorant.setDeltaMovement(this.cormorant.getDeltaMovement().add(0.0D, 0.005D, 0.0D));
//
 //           }

        }

        public void tick() {
            if (this.penguin.wantsToSwim() && this.penguin.isInWater()) {
                if (this.penguin.searchingForLand) {
                    this.penguin.setDeltaMovement(this.penguin.getDeltaMovement().add(0.0D, 0.003D, 0.0D));
                }
            }

            this.updateSpeed();
            if (this.operation == Action.MOVE_TO && !this.penguin.getNavigation().isDone()) {
                double d0 = this.wantedX - this.penguin.getX();
                double d1 = this.wantedY - this.penguin.getY();
                double d2 = this.wantedZ - this.penguin.getZ();
                double d3 = (double) MathHelper.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
                d1 = d1 / d3;
                float f = (float)(MathHelper.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
                this.penguin.yRot = this.rotlerp(this.penguin.yRot, f, 90.0F);
                this.penguin.yBodyRot = this.penguin.yRot;
                float f1 = (float)(this.speedModifier * this.penguin.getAttributeValue(Attributes.MOVEMENT_SPEED));
                this.penguin.setSpeed(MathHelper.lerp(0.125F, this.penguin.getSpeed(), f1));
                this.penguin.setDeltaMovement(this.penguin.getDeltaMovement().add(0.0D, (double)this.penguin.getSpeed() * d1 * 0.1D, 0.0D));
            }
            else {
                this.penguin.setSpeed(0.0F);
            }
        }
    }


    static class Navigator extends SwimmerPathNavigator {
        Navigator(CrestedPenguinEntity p_i48815_1_, World p_i48815_2_) {
            super(p_i48815_1_, p_i48815_2_);
        }

        protected boolean canUpdatePath() {
            return true;
        }

        protected PathFinder createPathFinder(int p_179679_1_) {
            this.nodeEvaluator = new WalkAndSwimNodeProcessor();
            return new PathFinder(this.nodeEvaluator, p_179679_1_);
        }

        public boolean isStableDestination(BlockPos p_188555_1_) {
            if (this.mob instanceof CrestedPenguinEntity) {
                CrestedPenguinEntity cormorant = (CrestedPenguinEntity)this.mob;
                if (cormorant.isTravelling()) {
                    //return this.level.getBlockState(p_188555_1_).is(Blocks.WATER);
                }
            }

            return !this.level.getBlockState(p_188555_1_.below()).isAir();
        }
    }

    static class TravelGoal extends Goal {
        private final CrestedPenguinEntity cormorant;
        private final double speedModifier;
        private boolean stuck;

        TravelGoal(CrestedPenguinEntity p_i48811_1_, double p_i48811_2_) {
            this.cormorant = p_i48811_1_;
            this.speedModifier = p_i48811_2_;
        }

        public boolean canUse() {
            return this.cormorant.isInWater();
        }

        public void start() {
            int i = 512;
            int j = 4;
            Random random = this.cormorant.random;
            int k = random.nextInt(1025) - 512;
            int l = random.nextInt(9) - 4;
            int i1 = random.nextInt(1025) - 512;
            //if ((double)l + this.cormorant.getY() > (double)(this.cormorant.level.getSeaLevel() - 1)) {
            //    l = 0;
            //}

            BlockPos blockpos = new BlockPos((double)k + this.cormorant.getX(), (double)l + this.cormorant.getY(), (double)i1 + this.cormorant.getZ());
            this.cormorant.setTravelPos(blockpos);
            this.cormorant.setTravelling(true);
            this.stuck = false;
        }

        public void tick() {
            if (this.cormorant.getNavigation().isDone()) {
                Vector3d vector3d = Vector3d.atBottomCenterOf(this.cormorant.getTravelPos());
                Vector3d vector3d1 = RandomPositionGenerator.getPosTowards(this.cormorant, 16, 3, vector3d, (double)((float)Math.PI / 10F));
                if (vector3d1 == null) {
                    vector3d1 = RandomPositionGenerator.getPosTowards(this.cormorant, 8, 7, vector3d);
                }

                if (vector3d1 != null) {
                    int i = MathHelper.floor(vector3d1.x);
                    int j = MathHelper.floor(vector3d1.z);
                    int k = 34;
                    if (!this.cormorant.level.hasChunksAt(i - 34, 0, j - 34, i + 34, 0, j + 34)) {
                        vector3d1 = null;
                    }
                }

                if (vector3d1 == null) {
                    this.stuck = true;
                    return;
                }

                this.cormorant.getNavigation().moveTo(vector3d1.x, vector3d1.y, vector3d1.z, this.speedModifier);
            }

        }

        public boolean canContinueToUse() {
            return !this.cormorant.getNavigation().isDone() && !this.stuck && !this.cormorant.isInLove();
        }

        public void stop() {
            this.cormorant.setTravelling(false);
            super.stop();
        }
    }

    static class WanderGoal extends RandomWalkingGoal {
        private final CrestedPenguinEntity cormorant;

        private WanderGoal(CrestedPenguinEntity p_i48813_1_, double p_i48813_2_, int p_i48813_4_) {
            super(p_i48813_1_, p_i48813_2_, p_i48813_4_);
            this.cormorant = p_i48813_1_;
        }

        public boolean canUse() {
            return !this.mob.isInWater() && super.canUse();
        }
    }

    public boolean canBreatheUnderwater() {
        return true;
    }

    static class GoToBeachGoal extends MoveToBlockGoal {
        private final CrestedPenguinEntity drowned;

        public GoToBeachGoal(CrestedPenguinEntity p_i48911_1_, double p_i48911_2_) {
            super(p_i48911_1_, p_i48911_2_, 8, 2);
            this.drowned = p_i48911_1_;
        }

        public boolean canUse() {
            return super.canUse() && !this.drowned.level.isDay() && this.drowned.isInWater() && this.drowned.getY() >= (double)(this.drowned.level.getSeaLevel() - 3);
        }

        public boolean canContinueToUse() {
            return super.canContinueToUse();
        }

        protected boolean isValidTarget(IWorldReader p_179488_1_, BlockPos p_179488_2_) {
            BlockPos blockpos = p_179488_2_.above();
            return p_179488_1_.isEmptyBlock(blockpos) && p_179488_1_.isEmptyBlock(blockpos.above()) ? p_179488_1_.getBlockState(p_179488_2_).entityCanStandOn(p_179488_1_, p_179488_2_, this.drowned) : false;
        }

        public void start() {
            this.drowned.setSearchingForLand(false);
            this.drowned.navigation = this.drowned.groundNavigation;
            super.start();
        }

        public void stop() {
            super.stop();
        }
    }

    public void setSearchingForLand(boolean p_204713_1_) {
        this.searchingForLand = p_204713_1_;
    }

    static class SwimUpGoal extends Goal {
        private final CrestedPenguinEntity cormorant;
        private final double speedModifier;
        private final int seaLevel;
        private boolean stuck;

        public SwimUpGoal(CrestedPenguinEntity p_i48908_1_, double p_i48908_2_, int p_i48908_4_) {
            this.cormorant = p_i48908_1_;
            this.speedModifier = p_i48908_2_;
            this.seaLevel = p_i48908_4_;
        }

        public boolean canUse() {
            return this.cormorant.isInWater() && this.cormorant.getY() < (double)(this.seaLevel)-2;
        }

        public boolean canContinueToUse() {
            return this.canUse() && !this.stuck;
        }

        public void tick() {
            if (this.cormorant.getY() < (double)(this.seaLevel - 1) && (this.cormorant.getNavigation().isDone() || this.cormorant.closeToNextPos())) {
                Vector3d vector3d = RandomPositionGenerator.getPosTowards(this.cormorant, 4, 8, new Vector3d(this.cormorant.getX(), (double)(this.seaLevel - 1), this.cormorant.getZ()));
                if (vector3d == null) {
                    this.stuck = true;
                    return;
                }

                this.cormorant.getNavigation().moveTo(vector3d.x, vector3d.y, vector3d.z, this.speedModifier);
            }

        }

        public void start() {
            this.cormorant.setSearchingForLand(true);
            this.stuck = false;
        }

        public void stop() {
            this.cormorant.setSearchingForLand(false);
        }
    }

    protected boolean closeToNextPos() {
        Path path = this.getNavigation().getPath();
        if (path != null) {
            BlockPos blockpos = path.getTarget();
            if (blockpos != null) {
                double d0 = this.distanceToSqr((double)blockpos.getX(), (double)blockpos.getY(), (double)blockpos.getZ());
                if (d0 < 4.0D) {
                    return true;
                }
            }
        }

        return false;
    }

    public ItemStack getFoodItem() {
        return new ItemStack(Items.COD, 1);
    }

    public int getIUCNStatus() {
        if (this.getVariant() == 1) {
            return 1;
        } if (this.getVariant() == 2 || this.getVariant() == 4 || this.getVariant() == 5 || this.getVariant() == 7) {
            return 2;
        } if (this.getVariant() == 3 || this.getVariant() == 6) {
            return 3;
        }
        return super.getIUCNStatus();
    }

    public ITextComponent getFunFact() {
        TranslationTextComponent translatable = DESCRIPTION.get(this.getVariant());
        if (translatable != null) {
            return translatable;
        } return new TranslationTextComponent("creatures.unknown");
    }

    public String getScientificName() {
        return SCIENTIFIC_NAMES.get(this.getVariant());
    }


}
