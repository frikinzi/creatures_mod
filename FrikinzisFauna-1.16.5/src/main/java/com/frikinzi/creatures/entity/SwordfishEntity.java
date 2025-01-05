package com.frikinzi.creatures.entity;

import com.frikinzi.creatures.config.CreaturesConfig;
import com.frikinzi.creatures.entity.base.FishBase;
import com.frikinzi.creatures.registry.CreaturesItems;
import com.frikinzi.creatures.util.CreaturesLootTables;
import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.entity.passive.fish.CodEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.server.SAnimateHandPacket;
import net.minecraft.util.*;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerChunkProvider;
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
import java.util.UUID;

public class SwordfishEntity extends FishBase implements IAnimatable {
    private static final DataParameter<Integer> DATA_VARIANT_ID = EntityDataManager.defineId(SwordfishEntity.class, DataSerializers.INT);
    private static final DataParameter<Integer> VARIANT_SUBID = EntityDataManager.defineId(SwordfishEntity.class, DataSerializers.INT);
    private static final UUID SPEED_BOOST_UUID = UUID.randomUUID();
    private int cooldownTimer = 0;
    private static final AttributeModifier SPEED_MODIFIER = new AttributeModifier(SPEED_BOOST_UUID, "Aggressive speed boost", 0.5D, AttributeModifier.Operation.ADDITION);
    private AnimationFactory factory = new AnimationFactory(this);
    public static Map<Integer, String[]> SWORDFISH = ImmutableMap.<Integer, String[]>builder()
            .put(1, new String[]{"a", "b", "c", "d"})
            .put(2, new String[]{"a", "b"})
            .put(3, new String[]{"a", "b", "c"})
            .put(4, new String[]{"a", "b"})
            .put(5, new String[]{"a", "b", "c", "d"})
            .put(6, new String[]{""})
            .put(7, new String[]{"a", "b"})
            .put(8, new String[]{""})
            .put(9, new String[]{""})
            .build();
    public static Map<Integer, Float> SIZES = ImmutableMap.<Integer, Float>builder()
            .put(1, 0.9f)
            .put(2, 0.9f)
            .put(3, 0.9f)
            .put(4, 1.0f)
            .put(5, 1.0f)
            .put(6, 0.7f)
            .put(7, 1.0f)
            .put(8, 0.9f)
            .put(9, 0.7f)
            .build();
    public static final Map<Integer, TranslationTextComponent> SPECIES_NAMES = ImmutableMap.<Integer, TranslationTextComponent>builder()
            .put(1, new TranslationTextComponent("message.creatures.atlanticsailfish"))
            .put(2, new TranslationTextComponent("message.creatures.indopacificsailfish"))
            .put(3, new TranslationTextComponent("message.creatures.swordfish"))
            .put(4, new TranslationTextComponent("message.creatures.blackmarlin"))
            .put(5, new TranslationTextComponent("message.creatures.bluemarlin"))
            .put(6, new TranslationTextComponent("message.creatures.whitemarlin"))
            .put(7, new TranslationTextComponent("message.creatures.stripedmarlin"))
            .put(8, new TranslationTextComponent("message.creatures.longbillspearfish"))
            .put(9, new TranslationTextComponent("message.creatures.shortbillspearfish"))
            .build();
    public static final Map<Integer, String> SCIENTIFIC_NAMES = ImmutableMap.<Integer, String>builder()
            .put(1, "Istiophorus albicans")
            .put(2, "Istiophorus platypterus")
            .put(3, "Xiphias gladius")
            .put(4, "Istiompax indica")
            .put(5, "Makaira nigricans")
            .put(6, "Tetrapterus albida")
            .put(7, "Tetrapturus audax")
            .put(8, "Tetrapturus pfluegeri")
            .put(9, "Tetrapturus angustirostris")
            .build();

    public SwordfishEntity(EntityType<? extends SwordfishEntity> p_i50246_1_, World p_i50246_2_) {
        super(p_i50246_1_, p_i50246_2_);
    }

    @Nullable
    public ILivingEntityData finalizeSpawn(IServerWorld p_213386_1_, DifficultyInstance p_213386_2_, SpawnReason p_213386_3_, @Nullable ILivingEntityData p_213386_4_, @Nullable CompoundNBT p_213386_5_) {
        if (p_213386_3_ != SpawnReason.BUCKET) {
            this.setGender(this.random.nextInt(2));
            //this.setVariant(this.random.nextInt(10));
            int num = SWORDFISH.get(this.getVariant()).length;
            this.setSubVariant(this.random.nextInt(num));
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
        if (this.swinging && !this.isBaby()){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("attack", false));
            return PlayState.CONTINUE;
        }
        if (!this.isInWater() && !this.isBaby()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("flop", true));
            return PlayState.CONTINUE;
        }
        if (this.isAggressive()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("fast", true));
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


    public int getMaxSchoolSize() {
        return 1;
    }

    protected ItemStack getBucketItemStack() {
        return new ItemStack(CreaturesItems.TAMBAQUI_BUCKET);
    }

    protected void saveToBucketTag(ItemStack p_204211_1_) {
        super.saveToBucketTag(p_204211_1_);
        CompoundNBT compoundnbt = p_204211_1_.getOrCreateTag();
        compoundnbt.putInt("BucketVariantTag", this.getVariant());
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
        return MathHelper.clamp(this.entityData.get(DATA_VARIANT_ID), 1, 10);
    }

    public int getSubVariant() {
        return MathHelper.clamp(this.entityData.get(VARIANT_SUBID), 0, SWORDFISH.get(this.getVariant()).length-1);
    }

    public void setVariant(int p_191997_1_) {
        this.entityData.set(DATA_VARIANT_ID, p_191997_1_);
    }

    public void setSubVariant(int p_191997_1_) {
        this.entityData.set(VARIANT_SUBID, p_191997_1_);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_VARIANT_ID, 0);
        this.entityData.define(VARIANT_SUBID, 0);
        this.entityData.define(DATA_ID_MOVING, false);
    }

    public void addAdditionalSaveData(CompoundNBT p_213281_1_) {
        super.addAdditionalSaveData(p_213281_1_);
        p_213281_1_.putInt("Variant", this.getVariant());
        p_213281_1_.putInt("Subvariant", this.getSubVariant());

    }

    public void readAdditionalSaveData(CompoundNBT p_70037_1_) {
        super.readAdditionalSaveData(p_70037_1_);
        this.setVariant(p_70037_1_.getInt("Variant"));
        this.setSubVariant(p_70037_1_.getInt("Subvariant"));
    }

    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 4.0).add(Attributes.ATTACK_SPEED, 2);
    }

    public ResourceLocation getDefaultLootTable() {
        return CreaturesLootTables.SWORDFISH;
    }

    public float getHatchChance() {
        return CreaturesConfig.swordfish_hatch_chance.get().floatValue();
    }

    public Item getFoodItem() {
        return CreaturesItems.FISH_FOOD;
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 2.0D, true));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoalCooldown<>(this, RedSnapperEntity.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoalCooldown<>(this, CodEntity.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoalCooldown<>(this, SquidEntity.class, false));

    }

    public ActionResultType mobInteract(PlayerEntity p_230254_1_, Hand p_230254_2_) {
        ItemStack itemstack = p_230254_1_.getItemInHand(p_230254_2_);
        if (itemstack.getItem() == Items.WATER_BUCKET && this.isAlive()) {
            return ActionResultType.PASS;
        } else {
            return super.mobInteract(p_230254_1_, p_230254_2_);
        }
    }

    public String getTextureString() {
        if (this.isSexuallyDimorphic()) {
            return this.getVariant() + SWORDFISH.get(this.getVariant())[this.getSubVariant()] + this.getGenderString();
        }
        return this.getVariant() + SWORDFISH.get(this.getVariant())[this.getSubVariant()];
    }

    public boolean isSexuallyDimorphic() {
        if (this.getVariant() == 4 || this.getVariant() == 5) {
            return true;
        }
        return false;
    }

    public void tick() {
        if (this.isAggressive() && !this.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(SPEED_MODIFIER)) {
            this.getAttribute(Attributes.MOVEMENT_SPEED).addTransientModifier(SPEED_MODIFIER);
        } else {
            if (this.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(SPEED_MODIFIER)) {
                this.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(SPEED_MODIFIER);
            }
        }

        super.tick();
    }

    public float getSizeMultiplier() {
        float multiplier = 1.0f;
        if (this.getGender() == 0 && (this.getVariant() == 4 || this.getVariant() == 5 || this.getVariant() == 6)) {
            multiplier = multiplier * 1.5f;
        } multiplier = multiplier * (float) SIZES.get(this.getVariant());
        return multiplier;
    }

    public void aiStep() {
        this.updateSwingTime();
        if (cooldownTimer > 0) {
            cooldownTimer--;
        }
        super.aiStep();
    }

    private int getCurrentSwingDuration() {
        return 20;
    }

    public void swing(Hand p_226292_1_, boolean p_226292_2_) {
        ItemStack stack = this.getItemInHand(p_226292_1_);
        if (!stack.isEmpty() && stack.onEntitySwing(this)) return;
        if (!this.swinging || this.swingTime >= this.getCurrentSwingDuration() / 2 || this.swingTime < 0) {
            this.swingTime = -1;
            this.swinging = true;
            this.swingingArm = p_226292_1_;
            if (this.level instanceof ServerWorld) {
                SAnimateHandPacket sanimatehandpacket = new SAnimateHandPacket(this, p_226292_1_ == Hand.MAIN_HAND ? 0 : 3);
                ServerChunkProvider serverchunkprovider = ((ServerWorld)this.level).getChunkSource();
                if (p_226292_2_) {
                    serverchunkprovider.broadcastAndSend(this, sanimatehandpacket);
                } else {
                    serverchunkprovider.broadcast(this, sanimatehandpacket);
                }
            }
        }

    }

    protected void updateSwingTime() {
        int i = this.getCurrentSwingDuration();
        if (this.swinging) {
            ++this.swingTime;
            if (this.swingTime >= i) {
                this.swingTime = 0;
                this.swinging = false;
            }
        } else {
            this.swingTime = 0;
        }

        this.attackAnim = (float)this.swingTime / (float)i;
    }

    public boolean canAttackTarget(LivingEntity target) {
        if (this.cooldownTimer > 0) {
            return false;
        }
        this.cooldownTimer = 1000;
        return true;
    }



    public class NearestAttackableTargetGoalCooldown<T extends LivingEntity> extends NearestAttackableTargetGoal<T> {

        public NearestAttackableTargetGoalCooldown(SwordfishEntity swordfish, Class<T> targetClass, boolean checkSight) {
            super(SwordfishEntity.this, targetClass, checkSight);
        }

        @Override
        public boolean canUse() {
            if (SwordfishEntity.this.cooldownTimer > 0) {
                return false;
            }
            if (SwordfishEntity.this.getTarget() != null && !SwordfishEntity.this.canAttackTarget(SwordfishEntity.this.getTarget())) {
                return false;
            }
            return super.canUse();
        }

        public void start() {
            SwordfishEntity.this.cooldownTimer = 1000;
            super.start();
        }
    }

    public int getIUCNStatus() {
        if (this.getVariant() == 1 || this.getVariant() == 2 || this.getVariant() == 5) {
            return 2;
        } if (this.getVariant() == 3) {
            return 1;
        } if (this.getVariant() == 4 || this.getVariant() == 9) {
            return -1;
        }
        return super.getIUCNStatus();
    }
    public String getSpeciesName() {
        TranslationTextComponent translatable = SPECIES_NAMES.get(this.getVariant());
        if (translatable != null) {
            return translatable.getString();
        } return "Unknown";
    }

    public int getBabyVariant() {
        if (this.getVariant() == 1 || this.getVariant() == 2) {
            return 1;
        } if (this.getVariant() == 3) {
            return 3;
        } return 2;
    }

    public int determineVariant() {
        return 10;
    }

    public String getScientificName() {
        return SCIENTIFIC_NAMES.get(this.getVariant());
    }

    public int methodOfDeterminingSubVariant() {
        int tmp = this.random.nextInt(SWORDFISH.get(this.getVariant()).length);
        if (this.getVariant() == 1 || this.getVariant() == 5) {
                if (this.random.nextInt(CreaturesConfig.swordfish_mutation_chance.get()) == 1) {
                    tmp = this.random.nextInt(SWORDFISH.get(this.getVariant()).length);
                } else {
                    tmp = this.random.nextInt(SWORDFISH.get(this.getVariant()).length-1);
                }

        }
        return tmp;
    }

    public ITextComponent getFunFact() {
        if (this.getVariant() == 2) {
            return new TranslationTextComponent("description.creatures.indopacificsailfish");
        }
        return new TranslationTextComponent("description.creatures.billfish");
    }

}
