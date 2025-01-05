package com.frikinzi.creatures.entity.base;

import com.frikinzi.creatures.config.CreaturesConfig;
import com.frikinzi.creatures.entity.ai.StayCloseToEggGoal;
import com.frikinzi.creatures.entity.egg.CreaturesEggEntity;
import com.frikinzi.creatures.registry.CreaturesItems;
import com.frikinzi.creatures.registry.ModEntityTypes;
import com.frikinzi.creatures.util.EntityAttributes;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.passive.horse.CoatColors;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.*;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Stream;

abstract public class CreaturesBirdEntity extends TameableEntity {
    World world;
    CreaturesBirdEntity mate;
    private CreaturesBirdEntity leader;
    public int sitProgress;
    public int ticksToSit;
    private int schoolSize = 1;
    private int moreCarrotTicks;
    private static final DataParameter<Integer> GENDER = EntityDataManager.defineId(CreaturesBirdEntity.class, DataSerializers.INT);
    private static final DataParameter<Boolean> GROOMING = EntityDataManager.defineId(CreaturesBirdEntity.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Float> HEIGHT_MULTIPLIER = EntityDataManager.defineId(CreaturesBirdEntity.class, DataSerializers.FLOAT);
    protected static final DataParameter<Optional<UUID>> DATA_MATEUUID_ID = EntityDataManager.defineId(CreaturesBirdEntity.class, DataSerializers.OPTIONAL_UUID);
    protected static final DataParameter<Optional<UUID>> DATA_PARENTUUID_ID = EntityDataManager.defineId(CreaturesBirdEntity.class, DataSerializers.OPTIONAL_UUID);


    public CreaturesBirdEntity(EntityType<? extends CreaturesBirdEntity> p_i50251_1_, World p_i50251_2_) {
        super(p_i50251_1_, p_i50251_2_);
        mate = null;
        this.ticksToSit = 40;
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(2, new StayCloseToEggGoal(this, 1.0D));
    }

    @Nullable
    public ILivingEntityData finalizeSpawn(IServerWorld p_213386_1_, DifficultyInstance p_213386_2_, SpawnReason p_213386_3_, @Nullable ILivingEntityData p_213386_4_, @Nullable CompoundNBT p_213386_5_) {
        if (p_213386_4_ == null) {
            p_213386_4_ = new AgeableData(false);
        }

        if (this.random.nextFloat() <= 0.05) {
            this.setBaby(true);
        }

        float f = (float)(this.random.nextGaussian() * CreaturesConfig.height_standard_deviation.get() + CreaturesConfig.height_base_multiplier.get());
        this.setHeightMultiplier(f);

        return super.finalizeSpawn(p_213386_1_, p_213386_2_, p_213386_3_, p_213386_4_, p_213386_5_);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(HEIGHT_MULTIPLIER, 1.0F);
        this.entityData.define(DATA_MATEUUID_ID, Optional.empty());
        this.entityData.define(DATA_PARENTUUID_ID, Optional.empty());
        this.entityData.define(GROOMING, false);
    }

    public CreaturesBirdEntity getMate() {
        return this.mate;
    }

    public void setMate(CreaturesBirdEntity bird) {
        this.mate = bird;
    }

    public float getHeightMultiplier() {
        return this.entityData.get(HEIGHT_MULTIPLIER);
    }

    public boolean isGrooming() {
        return this.entityData.get(GROOMING);
    }

    public void setGrooming(boolean p_70606_1_) {
        this.entityData.set(GROOMING, p_70606_1_);
    }

    public void setHeightMultiplier(float p_70606_1_) {
        if (this.getHeightMultiplier() < 0.7F) {
            this.entityData.set(HEIGHT_MULTIPLIER, 1.0F);
        } else {
        this.entityData.set(HEIGHT_MULTIPLIER, MathHelper.clamp(p_70606_1_, 0.7F, 1.5F)); }
    }

    public boolean isMonogamous() {
        return false;
    }

    public String getHeightString() {
        if (this.getHeightMultiplier() >= 1.5) {
            ITextComponent i = new TranslationTextComponent("gui.giant");
            return i.getString();
        }
        if (this.getHeightMultiplier() >= 1.4) {
            ITextComponent i = new TranslationTextComponent("gui.huge");
            return i.getString();
        }
        if (this.getHeightMultiplier() >= 1.21) {
            ITextComponent i = new TranslationTextComponent("gui.large");
            return i.getString();
        } if (this.getHeightMultiplier() < 1.21 && this.getHeightMultiplier() > 1.11) {
            ITextComponent i = new TranslationTextComponent("gui.above_average");
            return i.getString();
        }
        if (this.getHeightMultiplier() <= 1.11 && this.getHeightMultiplier() >= 0.89) {
            ITextComponent i = new TranslationTextComponent("gui.average");
            return i.getString();
        }
        if (this.getHeightMultiplier() < 0.89 && this.getHeightMultiplier() >= 0.79) {
            ITextComponent i = new TranslationTextComponent("gui.below_average");
            return i.getString();
        }
        else {
            ITextComponent i = new TranslationTextComponent("gui.small");
            return i.getString();
        }
    }


    public void addAdditionalSaveData(CompoundNBT p_213281_1_) {
        p_213281_1_.putBoolean("Grooming", this.isGrooming());
        p_213281_1_.putFloat("HeightMultiplier", this.getHeightMultiplier());
        if (this.getMateUUID() != null) {
            p_213281_1_.putUUID("Mate", this.getMateUUID());
        }
        if (this.getParentUUID() != null) {
            p_213281_1_.putUUID("Parent", this.getParentUUID());
        }
        p_213281_1_.putInt("MoreCarrotTicks", this.moreCarrotTicks);
        super.addAdditionalSaveData(p_213281_1_);
    }

    private boolean wantsMoreFood() {
        return this.moreCarrotTicks == 0;
    }

    public void readAdditionalSaveData(CompoundNBT p_70037_1_) {
        super.readAdditionalSaveData(p_70037_1_);
        this.moreCarrotTicks = p_70037_1_.getInt("MoreCarrotTicks");
        if (!p_70037_1_.contains("HeightMultiplier") || this.getHeightMultiplier() < 0.7F || this.getHeightMultiplier() > 1.5F) {
            this.setHeightMultiplier((float)(this.random.nextGaussian() * CreaturesConfig.height_standard_deviation.get() + CreaturesConfig.height_base_multiplier.get()));
        } else {
        this.setHeightMultiplier(p_70037_1_.getFloat("HeightMultiplier")); }
        if (p_70037_1_.hasUUID("Mate")) {
            uuid = p_70037_1_.getUUID("Mate");
            if (uuid != null) {
                try {
                    this.setMateUUID(uuid);
                } catch (Throwable throwable) {
                }
            }
        }
        if (p_70037_1_.hasUUID("Parent")) {
            uuid = p_70037_1_.getUUID("Parent");
            if (uuid != null) {
                try {
                    this.setParentUUID(uuid);
                } catch (Throwable throwable) {
                }
            }
        }
    }

    public void aiStep() {
        if (this.isGrooming()) {
            this.getNavigation().stop();
        }
        if (!this.level.isClientSide) {
            if (!this.getNavigation().isDone() && (this.isGrooming() || this.isSleeping())) {
                this.setGrooming(false);
            }
        }
        if (this.isGrooming() && this.sitProgress < this.ticksToSit) {
            this.sitProgress++;
        } else if (!this.isGrooming() && this.sitProgress > 0) {
            this.sitProgress--;
        }
        super.aiStep();
    }

    @Nullable
    public UUID getMateUUID() {
        return this.entityData.get(DATA_MATEUUID_ID).orElse((UUID)null);
    }

    public UUID getParentUUID() {
        return this.entityData.get(DATA_PARENTUUID_ID).orElse((UUID)null);
    }


    public void setMateUUID(@Nullable UUID p_184754_1_) {
        this.entityData.set(DATA_MATEUUID_ID, Optional.ofNullable(p_184754_1_));
    }

    public void setParentUUID(@Nullable UUID p_184754_1_) {
        this.entityData.set(DATA_PARENTUUID_ID, Optional.ofNullable(p_184754_1_));
    }

    public CreaturesEggEntity layEgg(CreaturesBirdEntity animal) {
        CreaturesEggEntity egg = new CreaturesEggEntity(ModEntityTypes.EGG.get(), this.level);
        egg.setSpecies(EntityAttributes.getBirdEntityMap().inverse().get(animal.getType()));
        egg.setGender(this.random.nextInt(2));
        int[] variants = {this.getVariant(), animal.getVariant()};
        int rand = this.random.nextInt(2);
        egg.setVariant(variants[rand]);
        egg.setPos(MathHelper.floor(this.getX()) + 0.5, MathHelper.floor(this.getY()) + 0.5, MathHelper.floor(this.getZ()) + 0.5);
        return egg;
    }

    public int getVariant() {
        return 0;
    }
    
    abstract public void setVariant(int i);

    public void setSubVariant(int i) {

    }

    public int getSubVariant() {
        return 0;
    }

    public float getHatchChance() {
        return 1;
    }

    public int getClutchSize() {
        return 1;
    }

    public int methodofDeterminingVariant(IWorld p_213610_1_) {
        return 1;
    }

    public int getGender() {
        return MathHelper.clamp(this.entityData.get(GENDER), 0, 2);
    }

    public ActionResultType mobInteract(PlayerEntity p_230254_1_, Hand p_230254_2_) {
        ItemStack itemstack = p_230254_1_.getItemInHand(p_230254_2_);
        if (itemstack.getItem() == CreaturesItems.FF_GUIDE) {
            //System.out.println(this.getUUID());
            if (this.level.isClientSide) {
                if (itemstack.getTag() == null) {
                    itemstack.getOrCreateTag();
                }
                String s = String.valueOf(EntityAttributes.getBirdEntityMap().inverse().get(this.getType()));
                if (!itemstack.getTag().contains(s)) {
                    if (this.determineVariant() == 1) {
                        itemstack.getTag().putIntArray(s, new int[1]);
                    } else {
                        itemstack.getTag().putIntArray(s, new int[this.determineVariant()-1]);
                    }
                }
                try {
                    itemstack.getTag().getIntArray(s)[this.getVariant()-1] = this.getVariant();
                } catch (Exception e) {
                    itemstack.getTag().getIntArray(s)[0] = 1;
                }

                System.out.println(Arrays.toString(itemstack.getTag().getIntArray(s)));

                return ActionResultType.SUCCESS;
            }
        } return super.mobInteract(p_230254_1_, p_230254_2_);
    }

    public boolean hurt(DamageSource p_29378_, float p_29379_) {
        if (this.isGrooming()) {
            this.setGrooming(false);
        }
        if (this.isInvulnerableTo(p_29378_)) {
            return false;
        } else {
            if (!this.level.isClientSide) {
                this.setOrderedToSit(false);
            }

            return super.hurt(p_29378_, p_29379_);
        }
    }

    public float getSpawnEggOffspringHeight() {
        return (float)(this.getRandom().nextGaussian() * 0.05 + this.getHeightMultiplier());
    }

    public abstract void setGender(int gender);

    public class DefendBabyGoal extends NearestAttackableTargetGoal<LivingEntity> {
        public DefendBabyGoal() {
            super(CreaturesBirdEntity.this, LivingEntity.class, 5, true, true, (Predicate<LivingEntity>)LivingEntity::attackable);
        }

        public boolean canUse() {
            if (!CreaturesBirdEntity.this.isBaby() && !CreaturesBirdEntity.this.isTame()) {
                if (super.canUse()) {
                    for (CreaturesBirdEntity birdEntity : CreaturesBirdEntity.this.level.getEntitiesOfClass(CreaturesBirdEntity.class, CreaturesBirdEntity.this.getBoundingBox().inflate(4.0D, 4.0D, 4.0D))) {
                        if (birdEntity.isBaby() && birdEntity.getClass() == CreaturesBirdEntity.this.getClass()) {

                            if (this.target.getClass() == CreaturesBirdEntity.this.getClass() || this.target.getClass() == CreaturesEggEntity.class || this.target.isBaby()) {
                                return false;
                            }
                            return true;
                        }
                    }
                    for (CreaturesEggEntity eggEntity : CreaturesBirdEntity.this.level.getEntitiesOfClass(CreaturesEggEntity.class, CreaturesBirdEntity.this.getBoundingBox().inflate(3.0D, 2.0D, 3.0D))) {
                        if (eggEntity.getSpecies() == EntityAttributes.getBirdEntityMap().inverse().get(CreaturesBirdEntity.this.getType())) {
                            if (this.target.getClass() == CreaturesBirdEntity.this.getClass() || this.target.isBaby() || this.target.getClass() == CreaturesEggEntity.class) {
                                return false;
                            }
                            //System.out.println("defend egg");
                            return true;
                        }
                    }
                }

            }
            return false;
        }

        protected double getFollowDistance() {
            return super.getFollowDistance() * 0.1D;
        }
    }

    public String getGenderName() {
        if (this.getGender() == 1) {
            return "m";
        } else {
            return "f";
        }
    }

    class HurtByTargetGoal extends net.minecraft.entity.ai.goal.HurtByTargetGoal {
        public HurtByTargetGoal() {
            super(CreaturesBirdEntity.this);
        }

        public void start() {
            super.start();
            if (CreaturesBirdEntity.this.isBaby()) {
                this.alertOthers();
                this.stop();
            }

        }

        protected void alertOther(MobEntity p_220793_1_, LivingEntity p_220793_2_) {
            if (p_220793_1_.getClass() == CreaturesBirdEntity.this.getClass() && !p_220793_1_.isBaby()) {
                super.alertOther(p_220793_1_, p_220793_2_);
            }

        }


    }


    public int getMaxFlockSize() {
        return super.getMaxSpawnClusterSize();
    }

    public boolean isFollower() {
        return this.leader != null && this.leader.isAlive();
    }

    public CreaturesBirdEntity startFollowing(CreaturesBirdEntity p_212803_1_) {
        this.leader = p_212803_1_;
        p_212803_1_.addFollower();
        return p_212803_1_;
    }

    public void stopFollowing() {
        this.leader.removeFollower();
        this.leader = null;
    }

    private void addFollower() {
        ++this.schoolSize;
    }

    private void removeFollower() {
        --this.schoolSize;
    }

    public boolean canBeFollowed() {
        return this.hasFollowers() && this.schoolSize < this.getMaxFlockSize();
    }


    public int determineVariant() {
        return 1;
    }

    public void tick() {
        super.tick();
        if (this.hasFollowers() && this.level.random.nextInt(200) == 1) {
            List<CreaturesBirdEntity> list = this.level.getEntitiesOfClass(this.getClass(), this.getBoundingBox().inflate(8.0D, 8.0D, 8.0D));
            if (list.size() <= 1) {
                this.schoolSize = 1;
            }
        }

    }

    public boolean hasFollowers() {
        return this.schoolSize > 1;
    }

    public boolean inRangeOfLeader() {
        return this.distanceToSqr(this.leader) <= 121.0D;
    }

    public void pathToLeader() {
        if (this.isFollower()) {
            this.getNavigation().moveTo(this.leader, 1.0D);
        }

    }

    public int getAmbientSoundInterval() {
        return 160;
    }

    public String getSpeciesName() {
        return "Unknown";
    }

    public void addFollowers(Stream<CreaturesBirdEntity> p_212810_1_) {
        p_212810_1_.limit((long)(this.getMaxFlockSize() - this.schoolSize)).filter((p_212801_1_) -> {
            return p_212801_1_ != this;
        }).filter((p_212801_1_) -> {
            return p_212801_1_.getVariant() == this.getVariant();
        }).forEach((p_212804_1_) -> {
            p_212804_1_.startFollowing(this);
        });
    }

    public static class GroupData implements ILivingEntityData {
        public final CreaturesBirdEntity leader;

        public GroupData(CreaturesBirdEntity p_i49858_1_) {
            this.leader = p_i49858_1_;
        }
    }

    static class RaidFarmGoal extends MoveToBlockGoal {
        private final CreaturesBirdEntity bird;
        private boolean wantsToRaid;
        private boolean canRaid;

        public RaidFarmGoal(CreaturesBirdEntity p_i45860_1_) {
            super(p_i45860_1_, (double)0.7F, 16);
            this.bird = p_i45860_1_;
        }

        public boolean canUse() {
            if (this.nextStartTick <= 0) {
                if (!net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.bird.level, this.bird)) {
                    return false;
                }

                this.canRaid = false;
                this.wantsToRaid = this.bird.wantsMoreFood();
                this.wantsToRaid = true;
            }

            return super.canUse();
        }

        public boolean canContinueToUse() {
            return this.canRaid && super.canContinueToUse();
        }

        public void tick() {
            super.tick();
            this.bird.getLookControl().setLookAt((double)this.blockPos.getX() + 0.5D, (double)(this.blockPos.getY() + 1), (double)this.blockPos.getZ() + 0.5D, 10.0F, (float)this.bird.getMaxHeadXRot());
            if (this.isReachedTarget()) {
                World world = this.bird.level;
                BlockPos blockpos = this.blockPos.above();
                BlockState blockstate = world.getBlockState(blockpos);
                Block block = blockstate.getBlock();
                if (this.canRaid && block == Blocks.WHEAT) {
                    Integer integer = blockstate.getValue(CropsBlock.AGE);
                    if (integer == 0) {
                        world.setBlock(blockpos, Blocks.AIR.defaultBlockState(), 2);
                        world.destroyBlock(blockpos, true, this.bird);
                    } else {
                        world.setBlock(blockpos, blockstate.setValue(CropsBlock.AGE, Integer.valueOf(integer - 1)), 2);
                        world.levelEvent(2001, blockpos, Block.getId(blockstate));
                    }

                    this.bird.moreCarrotTicks = 40;
                }

                this.canRaid = false;
                this.nextStartTick = 10;
            }

        }

        protected boolean isValidTarget(IWorldReader p_179488_1_, BlockPos p_179488_2_) {
            Block block = p_179488_1_.getBlockState(p_179488_2_).getBlock();
            if (block == Blocks.FARMLAND && this.wantsToRaid && !this.canRaid) {
                p_179488_2_ = p_179488_2_.above();
                BlockState blockstate = p_179488_1_.getBlockState(p_179488_2_);
                block = blockstate.getBlock();
                if (block instanceof CropsBlock && ((CropsBlock)block).isMaxAge(blockstate)) {
                    this.canRaid = true;
                    return true;
                }
            }

            return false;
        }


    }

    public ITextComponent getFunFact() {
        return new TranslationTextComponent("creatures.unknown");
    }

    public int getIUCNStatus() {
        return 0;
    }

    public TextFormatting getIUCNColor() {
        if (this.getIUCNStatus() == 0) {
            return TextFormatting.DARK_GREEN; // least concern
        } if (this.getIUCNStatus() == 1) {
            return TextFormatting.GOLD; // near threatened
        } if (this.getIUCNStatus() == 2) {
            return TextFormatting.GOLD;  // vulnerable
        } if (this.getIUCNStatus() == 3) {
            return TextFormatting.RED; // endangered
        } if (this.getIUCNStatus() == 4) {
            return TextFormatting.DARK_RED; // critically endangered
        } if (this.getIUCNStatus() == 5) {
            return TextFormatting.DARK_PURPLE; // extinct in the wild
        } if (this.getIUCNStatus() == 6) {
            return TextFormatting.BLACK; // extinct
        } return TextFormatting.GRAY; // unknown
    }
    public ITextComponent getIUCNText() {
        if (this.getIUCNStatus() == 0) {
            return new TranslationTextComponent("creatures.leastconcern"); // least concern
        } if (this.getIUCNStatus() == 1) {
            return new TranslationTextComponent("creatures.nearthreatened"); // near threatened
        } if (this.getIUCNStatus() == 2) {
            return new TranslationTextComponent("creatures.vulnerable");  // vulnerable
        } if (this.getIUCNStatus() == 3) {
            return new TranslationTextComponent("creatures.endangered"); // endangered
        } if (this.getIUCNStatus() == 4) {
            return new TranslationTextComponent("creatures.criticallyendangered"); // critically endangered
        } if (this.getIUCNStatus() == 5) {
            return new TranslationTextComponent("creatures.extinctinwild"); // extinct in the wild
        } if (this.getIUCNStatus() == 6) {
            return new TranslationTextComponent("creatures.extinct"); // extinct
        } return new TranslationTextComponent("creatures.datadeficient"); // unknown
    }

    public String getScientificName() {
        return "";
    }

    public static class BirdData extends AgeableEntity.AgeableData {
        public final int variant;

        public BirdData(int p_i231557_1_) {
            super(true);
            this.variant = p_i231557_1_;
        }
    }

    public int methodOfDeterminingSubVariant() {
        return 1;
    }
}
