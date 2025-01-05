package com.frikinzi.creatures.entity;

import com.frikinzi.creatures.config.CreaturesConfig;
import com.frikinzi.creatures.entity.base.CreaturesBirdEntity;
import com.frikinzi.creatures.entity.base.FishBase;
import com.frikinzi.creatures.registry.CreaturesItems;
import com.frikinzi.creatures.util.CreaturesLootTables;
import com.google.common.collect.ImmutableMap;
import net.minecraft.data.loot.EntityLootTables;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.fish.AbstractGroupFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTables;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.*;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.BiomeDictionary;
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

public class SquidEntity extends FishBase implements IAnimatable {
    private static final DataParameter<Integer> DATA_VARIANT_ID = EntityDataManager.defineId(SquidEntity.class, DataSerializers.INT);
    private static final DataParameter<Integer> VARIANT_SUBID = EntityDataManager.defineId(SquidEntity.class, DataSerializers.INT);
    private AnimationFactory factory = new AnimationFactory(this);
    public float xBodyRotO  =1;
    public static final Map<Integer, TranslationTextComponent> SPECIES_NAMES = ImmutableMap.<Integer, TranslationTextComponent>builder()
            .put(1, new TranslationTextComponent("message.creatures.humboldt"))
            .put(2, new TranslationTextComponent("message.creatures.swordtipsquid"))
            .put(3, new TranslationTextComponent("message.creatures.europeansquid"))
            .put(4, new TranslationTextComponent("message.creatures.purplebackflying"))
            .put(5, new TranslationTextComponent("message.creatures.antarcticflying"))
            .put(6, new TranslationTextComponent("message.creatures.japaneseflying"))
            .put(7, new TranslationTextComponent("message.creatures.newzealandarrow"))
            .put(8, new TranslationTextComponent("message.creatures.caribbeansquid"))
            .put(9, new TranslationTextComponent("message.creatures.bigfinsquid"))
            .put(10, new TranslationTextComponent("message.creatures.southernreef"))
            .build();
    public static final Map<Integer, String> SCIENTIFIC_NAMES = ImmutableMap.<Integer, String>builder()
            .put(1, "Dosidicus gigas")
            .put(2, "Uroteuthis edulis")
            .put(3, "Loligo vulgaris")
            .put(4, "Sthenoteuthis oualaniensis")
            .put(5, "Todarodes filippovae")
            .put(6, "Todarodes pacificus")
            .put(7, "Nototodarus sloanii")
            .put(8, "Sepioteuthis sepioidea")
            .put(9,"Sepioteuthis lessoniana")
            .put(10,"Sepioteuthis australis")
            .build();

    public static Map<Integer, Integer> SQUID = ImmutableMap.<Integer, Integer>builder()
            .put(1, 3)
            .put(2, 1)
            .put(3, 2)
            .put(4, 1)
            .put(5, 1)
            .put(6, 1)
            .put(7, 1)
            .put(8, 3)
            .put(9, 3)
            .put(10, 3)
            .build();

    public static Map<Integer, Double> SIZES = ImmutableMap.<Integer, Double>builder()
            .put(1, 2.0D)
            .put(2, 1.0D)
            .put(3, 0.8D)
            .put(4, 0.8D)
            .put(5, 1.0D)
            .put(6, 0.8D)
            .put(7, 0.8D)
            .put(8, 0.8D)
            .put(9, 0.8D)
            .put(10, 0.8D)
            .build();

    public SquidEntity(EntityType<? extends SquidEntity> p_i50246_1_, World p_i50246_2_) {
        super(p_i50246_1_, p_i50246_2_);
    }

    @Nullable
    public ILivingEntityData finalizeSpawn(IServerWorld p_213386_1_, DifficultyInstance p_213386_2_, SpawnReason p_213386_3_, @Nullable ILivingEntityData p_213386_4_, @Nullable CompoundNBT p_213386_5_) {
        if (p_213386_3_ != SpawnReason.BUCKET) {
            int color;
            if (p_213386_4_ instanceof SquidEntity.SquidData) {
                color = ((SquidEntity.SquidData)p_213386_4_).variant;
            } else {
                color = methodofDeterminingVariant(p_213386_1_);
                p_213386_4_ = new SquidEntity.SquidData(color);
            }
            this.setVariant(color);
            this.setSubVariant(this.random.nextInt(SQUID.get(this.getVariant()))+1);
            float f = (float) (this.random.nextGaussian() * CreaturesConfig.height_standard_deviation.get() + CreaturesConfig.height_base_multiplier.get());
            this.setHeightMultiplier(f);
        }
        if (p_213386_5_ != null) {
            if (p_213386_5_.contains("BucketVariantTag", 3)) {
                this.setVariant(p_213386_5_.getInt("BucketVariantTag"));
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
        if (this.isReef() || this.isBaby()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("swim_reef", true));
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

    protected ItemStack getBucketItemStack() {
        return new ItemStack(CreaturesItems.TROUT_BUCKET);
    }

    protected void saveToBucketTag(ItemStack p_204211_1_) {
        super.saveToBucketTag(p_204211_1_);
        CompoundNBT compoundnbt = p_204211_1_.getOrCreateTag();
        compoundnbt.putInt("BucketVariantTag", this.getVariant());
        compoundnbt.putFloat("BucketHeightMultiplier", this.getHeightMultiplier());
        compoundnbt.putInt("Age", this.getAge());
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.SQUID_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return SoundEvents.SQUID_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.SQUID_DEATH;
    }

    protected SoundEvent getFlopSound() {
        return SoundEvents.SALMON_FLOP;
    }

    public int getVariant() {
        return MathHelper.clamp(this.entityData.get(DATA_VARIANT_ID), 1, 11);
    }

    public void setVariant(int p_191997_1_) {
        this.entityData.set(DATA_VARIANT_ID, p_191997_1_);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_VARIANT_ID, 0);
        this.entityData.define(DATA_ID_MOVING, false);
        this.entityData.define(VARIANT_SUBID, 0);
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
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.MOVEMENT_SPEED, 0.1D);
    }

    public ResourceLocation getDefaultLootTable() {
        return CreaturesLootTables.SQUID;
    }

    public float getHatchChance() {
        return Double.valueOf(CreaturesConfig.squid_hatch_chance.get()).floatValue();
    }

    public Item getFoodItem() {
        return CreaturesItems.FISH_FOOD;
    }

    public String getSpeciesName() {
        TranslationTextComponent translatable = SPECIES_NAMES.get(this.getVariant());
        if (translatable != null) {
            return translatable.getString();
        } return "Unknown";
    }

    public int determineVariant() {
        return 11;
    }


    public int getSubVariant() {
        return MathHelper.clamp(this.entityData.get(VARIANT_SUBID), 1, SQUID.get(this.getVariant()));
    }

    public void setSubVariant(int p_191997_1_) {
        this.entityData.set(VARIANT_SUBID, p_191997_1_);
    }

    private Vector3d rotateVector(Vector3d p_207400_1_) {
        Vector3d vector3d = p_207400_1_.xRot(this.xBodyRotO * ((float)Math.PI / 180F));
        return vector3d.yRot(-this.yBodyRotO * ((float)Math.PI / 180F));
    }

    private void spawnInk() {
        this.playSound(SoundEvents.SQUID_SQUIRT, this.getSoundVolume(), this.getVoicePitch());
        Vector3d vector3d = this.rotateVector(new Vector3d(0.0D, -1.0D, 0.0D)).add(this.getX(), this.getY(), this.getZ());

        for(int i = 0; i < 30; ++i) {
            Vector3d vector3d1 = this.rotateVector(new Vector3d((double)this.random.nextFloat() * 0.6D - 0.3D, -1.0D, (double)this.random.nextFloat() * 0.6D - 0.3D));
            Vector3d vector3d2 = vector3d1.scale(0.3D + (double)(this.random.nextFloat() * 2.0F));
            ((ServerWorld)this.level).sendParticles(ParticleTypes.SQUID_INK, vector3d.x, vector3d.y + 0.5D, vector3d.z, 0, vector3d2.x, vector3d2.y, vector3d2.z, (double)0.1F);
        }

    }

    public boolean hurt(DamageSource p_70097_1_, float p_70097_2_) {
        if (super.hurt(p_70097_1_, p_70097_2_) && this.getLastHurtByMob() != null) {
            this.spawnInk();
            return true;
        } else {
            return false;
        }
    }

    public boolean isReef() {
        return this.getVariant() == 8 || this.getVariant() == 9 || this.getVariant() == 10;
    }

    public double getSizeMultiplier() {
        return SIZES.get(this.getVariant());
    }

    public int getIUCNStatus() {
        if (this.getVariant()== 1 || this.getVariant() == 2 || this.getVariant() == 3 || this.getVariant() == 9) {
            return -1;
        }
        return super.getIUCNStatus();
    }

    public int methodofDeterminingVariant(IWorld p_213610_1_) {
        if (CreaturesConfig.biome_only_variants.get()) {
            Biome biome = p_213610_1_.getBiome(this.blockPosition());
            RegistryKey<Biome> biomeKey = RegistryKey.create(Registry.BIOME_REGISTRY, biome.getRegistryName());
            Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(biomeKey);

            if (types.contains(BiomeDictionary.Type.HOT) && types.contains(BiomeDictionary.Type.OCEAN)) {
                return this.random.nextInt(3) + 8;
            }
            return this.random.nextInt(7)+1;
        } return this.random.nextInt(10)+1;
    }

    public ActionResultType mobInteract(PlayerEntity p_230254_1_, Hand p_230254_2_) {
        ItemStack itemstack = p_230254_1_.getItemInHand(p_230254_2_);
        if (itemstack.getItem() == Items.WATER_BUCKET && this.isAlive()) {
            return ActionResultType.PASS;
        } else {
            return super.mobInteract(p_230254_1_, p_230254_2_);
        }
    }

    public static class SquidData implements ILivingEntityData {
        public final int variant;

        public SquidData(int p_i231557_1_) {
            this.variant = p_i231557_1_;
        }
    }

    public String getScientificName() {
        return SCIENTIFIC_NAMES.get(this.getVariant());
    }

    public int methodOfDeterminingSubVariant() {
        return this.random.nextInt(SQUID.get(this.getVariant()))+1;
    }

    public ITextComponent getFunFact() {
        return new TranslationTextComponent("description.creatures.squid");
    }

}
