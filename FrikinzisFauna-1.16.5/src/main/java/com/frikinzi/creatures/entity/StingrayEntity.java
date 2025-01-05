package com.frikinzi.creatures.entity;

import com.frikinzi.creatures.config.CreaturesConfig;
import com.frikinzi.creatures.entity.base.GroupFishBase;
import com.frikinzi.creatures.registry.CreaturesItems;
import com.frikinzi.creatures.util.CreaturesLootTables;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.LookController;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.Difficulty;
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
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

public class StingrayEntity extends GroupFishBase implements IAnimatable {
    private static final DataParameter<Integer> DATA_VARIANT_ID = EntityDataManager.defineId(StingrayEntity.class, DataSerializers.INT);
    private static final Set<Block> DIGGABLES = Sets.newHashSet(Blocks.CLAY, Blocks.DIRT, Blocks.COARSE_DIRT, Blocks.PODZOL, Blocks.FARMLAND, Blocks.GRASS_BLOCK, Blocks.GRAVEL, Blocks.MYCELIUM, Blocks.SAND, Blocks.RED_SAND, Blocks.SNOW_BLOCK, Blocks.SNOW, Blocks.SOUL_SAND, Blocks.GRASS_PATH, Blocks.WHITE_CONCRETE_POWDER, Blocks.ORANGE_CONCRETE_POWDER, Blocks.MAGENTA_CONCRETE_POWDER, Blocks.LIGHT_BLUE_CONCRETE_POWDER, Blocks.YELLOW_CONCRETE_POWDER, Blocks.LIME_CONCRETE_POWDER, Blocks.PINK_CONCRETE_POWDER, Blocks.GRAY_CONCRETE_POWDER, Blocks.LIGHT_GRAY_CONCRETE_POWDER, Blocks.CYAN_CONCRETE_POWDER, Blocks.PURPLE_CONCRETE_POWDER, Blocks.BLUE_CONCRETE_POWDER, Blocks.BROWN_CONCRETE_POWDER, Blocks.GREEN_CONCRETE_POWDER, Blocks.RED_CONCRETE_POWDER, Blocks.BLACK_CONCRETE_POWDER, Blocks.SOUL_SOIL);
    private static final DataParameter<Integer> GENDER = EntityDataManager.defineId(StingrayEntity.class, DataSerializers.INT);
    private boolean isHiding = false;
    private AnimationFactory factory = new AnimationFactory(this);
    public StingrayEntity(EntityType<? extends StingrayEntity> p_i50246_1_, World p_i50246_2_) {
        super(p_i50246_1_, p_i50246_2_);
        this.moveControl = new StingrayEntity.StingrayMoveHelperController(this);
    }
    private boolean didAttack;
    public static final Map<Integer, TranslationTextComponent> SPECIES_NAMES = ImmutableMap.<Integer, TranslationTextComponent>builder()
            .put(1, new TranslationTextComponent("message.creatures.commonstingray"))
            .put(2, new TranslationTextComponent("message.creatures.atlanticstingray"))
            .put(3, new TranslationTextComponent("message.creatures.bluespotted"))
            .put(4, new TranslationTextComponent("message.creatures.roundribbontail"))
            .put(5, new TranslationTextComponent("message.creatures.bullseye"))
            .put(6, new TranslationTextComponent("message.creatures.yellowstingray"))
            .put(7, new TranslationTextComponent("message.creatures.cowtailstingray"))
            .put(8, new TranslationTextComponent("message.creatures.commonstingaree"))
            .put(9, new TranslationTextComponent("message.creatures.maskedstingaree"))
            .put(10, new TranslationTextComponent("message.creatures.bandedstingaree"))
            .put(11, new TranslationTextComponent("message.creatures.spottedstingaree"))
            .put(12, new TranslationTextComponent("message.creatures.southernstingray"))
            .put(13, new TranslationTextComponent("message.creatures.pelagicstingray"))
            .put(14, new TranslationTextComponent("message.creatures.porcupinestingray"))
            .put(15, new TranslationTextComponent("message.creatures.leopardwhipray"))
            .build();
    public static final Map<Integer, String> SCIENTIFIC_NAMES = ImmutableMap.<Integer, String>builder()
            .put(1, "Dasyatis pastinaca")
            .put(2, "Dasyatis sabinus")
            .put(3, "Taeniura lymma")
            .put(4, "Taeniura meyeni")
            .put(5, "Diplobatis ommata")
            .put(6, "Urobatis jamaicensis")
            .put(7, "Pastinachus sephen")
            .put(8, "Trygonoptera testacea")
            .put(9, "Trygonoptera personata")
            .put(10, "Urolophus cruciatus")
            .put(11, "Urolophus gigas")
            .put(12, "Hypanus americanus")
            .put(13, "Pteroplatytrygon violacea")
            .put(14, "Urogymnus asperrimus")
            .put(15, "Himantura leoparda")
            .build();

    @Nullable
    public ILivingEntityData finalizeSpawn(IServerWorld p_213386_1_, DifficultyInstance p_213386_2_, SpawnReason p_213386_3_, @Nullable ILivingEntityData p_213386_4_, @Nullable CompoundNBT p_213386_5_) {
        if (p_213386_3_ != SpawnReason.BUCKET) {
            this.setVariant(this.random.nextInt(16));
            this.setGender(this.random.nextInt(2));
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
            event.getController().setAnimation(new AnimationBuilder().addAnimation("Flop", true));
            return PlayState.CONTINUE;
        }
        if (this.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("swim", true));
            isHiding = false;
            return PlayState.CONTINUE;
        }
        if (this.canBurrow() && this.isOnGround() && !this.isMoving() && onDiggableBlock(this)) {
            if (!isHiding) {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("Hiding", false).addAnimation("HideIdle", true));
                isHiding = true;  // Set the flag to true when Hiding animation starts
            }
            return PlayState.CONTINUE;
        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation("Idle", true));
        isHiding = false;
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


    public int getMaxSchoolSize() {
        return 1;
    }

    protected ItemStack getBucketItemStack() {
        return new ItemStack(CreaturesItems.ELEPHANTNOSE_BUCKET);
    }

    protected void saveToBucketTag(ItemStack p_204211_1_) {
        super.saveToBucketTag(p_204211_1_);
        CompoundNBT compoundnbt = p_204211_1_.getOrCreateTag();
        compoundnbt.putInt("BucketVariantTag", this.getVariant());
        compoundnbt.putInt("BucketGenderTag", this.getGender());
        compoundnbt.putFloat("BucketHeightMultiplier", this.getHeightMultiplier());
        compoundnbt.putInt("Age", this.getAge());
    }

    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return SoundEvents.SALMON_HURT;
    }

    protected SoundEvent getFlopSound() {
        return SoundEvents.SALMON_FLOP;
    }

    public int getVariant() {
        return MathHelper.clamp(this.entityData.get(DATA_VARIANT_ID), 1, 16);
    }

    public void setVariant(int p_191997_1_) {
        this.entityData.set(DATA_VARIANT_ID, p_191997_1_);
    }

    public int getGender() {
        return MathHelper.clamp(this.entityData.get(GENDER), 0, 2);
    }

    public void setGender(int p_191997_1_) {
        this.entityData.set(GENDER, p_191997_1_);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_VARIANT_ID, 0);
        this.entityData.define(GENDER, 0);
        this.entityData.define(DATA_ID_MOVING, false);
    }

    public void addAdditionalSaveData(CompoundNBT p_213281_1_) {
        super.addAdditionalSaveData(p_213281_1_);
        p_213281_1_.putInt("Variant", this.getVariant());
        p_213281_1_.putInt("Gender", this.getGender());
    }

    public void readAdditionalSaveData(CompoundNBT p_70037_1_) {
        super.readAdditionalSaveData(p_70037_1_);
        this.setVariant(p_70037_1_.getInt("Variant"));
        this.setGender(p_70037_1_.getInt("Gender"));
    }

    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 6.0D).add(Attributes.MOVEMENT_SPEED, 0.1D).add(Attributes.ATTACK_DAMAGE, 2.0D);
    }

    public ResourceLocation getDefaultLootTable() {
        return CreaturesLootTables.TROPICAL_FISH;
    }

    public float getHatchChance() {
        return CreaturesConfig.stingray_hatch_chance.get().floatValue();
    }

    public Item getFoodItem() {
        return CreaturesItems.FISH_FOOD;
    }

    protected void registerGoals() {
        this.randomStrollGoal = new StingrayRandomWalkingGoal(this, 0.8D);
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 2.0D, true));
        this.goalSelector.addGoal(7, this.randomStrollGoal);
        this.randomStrollGoal.setFlags(EnumSet.of(Goal.Flag.MOVE));
        this.goalSelector.addGoal(5, new FollowSchoolLeaderGoal(this));
        this.goalSelector.addGoal(3, new GroupFishBase.EatFoodGoal());
        this.goalSelector.addGoal(4, new AvoidEntityGoal<>(this, PlayerEntity.class, 1.0F, 1.8D, 1.8D));
        this.targetSelector.addGoal(1, new StingrayEntity.HurtByTargetGoal(this));
    }

    public int determineVariant() {
        return 16;
    }

    public String getGenderName() {
        if (this.getGender() == 0) {
            return "f";
        } return "m";
    }

    public float getSize() {
        switch(this.getVariant()) {
            case 1:
                return 1;
            case 2:
                return 0.5f;
            case 3:
                return 0.5f;
            case 4:
                return 1.5f;
            case 5:
                return 0.5f;
            case 6:
                return 0.5f;
            case 7:
                return 1.5f;
            case 8:
                return 0.5f;
            case 9:
                return 0.5f;
            case 10:
                return 0.5f;
            case 11:
                return 0.5f;
            case 12:
                return 1.1f;
            case 13:
                return 0.8f;
            case 14:
                return 1.1f;
            case 15:
                return 1.2f;
            default:
                return 1;
        }
    }

    public void travel(Vector3d p_213352_1_) {
        if (this.isEffectiveAi() && this.isInWater()) {
            this.moveRelative(0.1F, p_213352_1_);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
            if (!this.isMoving() && this.getTarget() == null) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
            }
        } else {
            super.travel(p_213352_1_);
        }

    }


    static class StingrayMoveHelperController extends MoveHelperController {

        public StingrayMoveHelperController(GroupFishBase p_i45831_1_) {
            super(p_i45831_1_);
            this.fishbase = p_i45831_1_;
        }

        @Override
        public void tick() {
            if (this.operation == Action.MOVE_TO && !this.fishbase.getNavigation().isDone()) {
                if ((this.wantedY - this.fishbase.getY())> 0 && !this.mob.isAggressive()) {
                    this.wantedY -= 0.7*((this.wantedY - this.fishbase.getY()));
                }
                Vector3d vector3d = new Vector3d(this.wantedX - this.fishbase.getX(), this.wantedY - this.fishbase.getY(), this.wantedZ - this.fishbase.getZ());
                double d0 = vector3d.length();
                double d1 = vector3d.x / d0;
                double d2 = (vector3d.y / d0); // Scale down Y movement component
                double d3 = vector3d.z / d0;
                float f = (float) (MathHelper.atan2(vector3d.z, vector3d.x) * (double) (180F / (float) Math.PI)) - 90.0F;
                this.fishbase.yRot = this.rotlerp(this.fishbase.yRot, f, 90.0F);
                this.fishbase.yBodyRot = this.fishbase.yRot;
                float f1 = (float) (this.speedModifier * this.fishbase.getAttributeValue(Attributes.MOVEMENT_SPEED));
                float f2 = MathHelper.lerp(0.125F, this.fishbase.getSpeed(), f1);
                this.fishbase.setSpeed(f2);
                double d4 = Math.sin((double) (this.fishbase.tickCount + this.fishbase.getId()) * 0.5D) * 0.05D;
                double d5 = Math.cos((double) (this.fishbase.yRot * ((float) Math.PI / 180F)));
                double d6 = Math.sin((double) (this.fishbase.yRot * ((float) Math.PI / 180F)));
                double d7 = Math.sin((double) (this.fishbase.tickCount + this.fishbase.getId()) * 0.75D) * 0.05D;
                this.fishbase.setDeltaMovement(this.fishbase.getDeltaMovement().add(0, d7 * (d6 + d5) * 0.25D + (double)f2 * d2 * 0.1D, 0));
                LookController lookcontroller = this.fishbase.getLookControl();
                double d8 = this.fishbase.getX() + d1 * 2.0D;
                double d9 = this.fishbase.getEyeY() + d2 / d0;
                double d10 = this.fishbase.getZ() + d3 * 2.0D;
                double d11 = lookcontroller.getWantedX();
                double d12 = lookcontroller.getWantedY();
                double d13 = lookcontroller.getWantedZ();
                if (!lookcontroller.isHasWanted()) {
                    d11 = d8;
                    d12 = d9;
                    d13 = d10;
                }

                //this.fishbase.getLookControl().setLookAt(MathHelper.lerp(0.125D, d11, d8), MathHelper.lerp(0.125D, d12, d9), MathHelper.lerp(0.125D, d13, d10), 10.0F, 40.0F);
                this.fishbase.setMoving(true);
            } else {
                this.fishbase.setSpeed(0.0F);
                this.fishbase.setMoving(false);
            }
        }
    }

    private boolean onDiggableBlock(CreatureEntity entity) {
        BlockPos pos = entity.blockPosition().below();
        BlockState blockState = entity.level.getBlockState(pos);
        return DIGGABLES.contains(blockState.getBlock());
    }

    static class HurtByTargetGoal extends net.minecraft.entity.ai.goal.HurtByTargetGoal {
        public HurtByTargetGoal(StingrayEntity p_i47282_1_) {
            super(p_i47282_1_);
        }

        public boolean canContinueToUse() {
            if (this.mob instanceof StingrayEntity) {
                StingrayEntity stingrayentity = (StingrayEntity)this.mob;
                if (stingrayentity.didAttack) {
                    stingrayentity.setDidAttack(false);
                    return false;
                }
            }

            return super.canContinueToUse();
        }
    }

    static class StingrayRandomWalkingGoal extends net.minecraft.entity.ai.goal.RandomWalkingGoal {
        public StingrayRandomWalkingGoal(StingrayEntity p_i1648_1_, double p_i1648_2_) {
            super(p_i1648_1_, p_i1648_2_, 120);
        }

        @Override
        public void tick() {
            if (this.mob instanceof StingrayEntity) {
                this.interval = ((StingrayEntity) this.mob).getActivityLevel();
            }
            super.tick();

        }

        public boolean canUse() {
            if (this.mob.level.isNight()) {
                this.interval = ((StingrayEntity)this.mob).getActivityLevel();
            }
            return super.canUse();
        }

    }

    private void setDidAttack(boolean p_190714_1_) {
        this.didAttack = p_190714_1_;
    }

    public boolean doHurtTarget(Entity p_70652_1_) {
        if (super.doHurtTarget(p_70652_1_)) {
            if (p_70652_1_ instanceof LivingEntity) {
                if (this.getVariant() != 14) {
                    int i = 0;
                    if (this.level.getDifficulty() == Difficulty.NORMAL) {
                        i = 7;
                    } else if (this.level.getDifficulty() == Difficulty.HARD) {
                        i = 15;
                    }

                    if (i > 0) {
                        ((LivingEntity)p_70652_1_).addEffect(new EffectInstance(Effects.POISON, i * 20, 0));
                    }
                }

            }
            this.setDidAttack(true);

            return true;
        } else {
            return false;
        }
    }

    public int getActivityLevel() {
        if (this.getVariant() == 13) {
            return 20;
        }
        else if (this.level.isNight()) {
            return 20;
        } else {
            return 5000;
        }
    }

    public boolean canBurrow() {
        return (this.getVariant() != 3 && this.getVariant() !=4 && this.getVariant() != 13);
    }

    public int getIUCNStatus() {
        if (this.getVariant()== 1 || this.getVariant() == 4) {
            return 2;
        } if (this.getVariant() == 7 || this.getVariant() == 8 || this.getVariant() == 12) {
            return 1;
        } if (this.getVariant() == 14){
            return -1;
        } if (this.getVariant() == 15) {
            return 3;
        }
        return super.getIUCNStatus();
    }

    public ActionResultType mobInteract(PlayerEntity p_230254_1_, Hand p_230254_2_) {
        ItemStack itemstack = p_230254_1_.getItemInHand(p_230254_2_);
        if (itemstack.getItem() == Items.WATER_BUCKET && this.isAlive()) {
            return ActionResultType.PASS;
        } else {
            return super.mobInteract(p_230254_1_, p_230254_2_);
        }
    }

    public ITextComponent getFunFact() {
        return new TranslationTextComponent("description.creatures.stingray");
    }
    public String getScientificName() {
        return SCIENTIFIC_NAMES.get(this.getVariant());
    }

}
