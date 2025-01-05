package com.frikinzi.creatures.entity.base;

import com.frikinzi.creatures.Creatures;
import com.frikinzi.creatures.config.CreaturesConfig;
import com.frikinzi.creatures.entity.GhostCrabEntity;
import com.frikinzi.creatures.registry.CreaturesItems;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

abstract public class AbstractCrabBase extends AnimalEntity {
    private static final DataParameter<Float> HEIGHT_MULTIPLIER = EntityDataManager.defineId(AbstractCrabBase.class, DataSerializers.FLOAT);
    private static final DataParameter<Integer> DATA_VARIANT_ID = EntityDataManager.defineId(AbstractCrabBase.class, DataSerializers.INT);
    private static final DataParameter<Integer> GENDER = EntityDataManager.defineId(AbstractCrabBase.class, DataSerializers.INT);


    public AbstractCrabBase(EntityType<? extends AbstractCrabBase> p_i48567_1_, World p_i48567_2_) {
        super(p_i48567_1_, p_i48567_2_);

    }

    @Nullable
    public ILivingEntityData finalizeSpawn(IServerWorld p_213386_1_, DifficultyInstance p_213386_2_, SpawnReason p_213386_3_, @Nullable ILivingEntityData p_213386_4_, @Nullable CompoundNBT p_213386_5_) {
        if (p_213386_4_ == null) {
            p_213386_4_ = new AgeableData(false);
        }
        int color;
        if (p_213386_4_ instanceof AbstractCrabBase.CrabData) {
            color = ((AbstractCrabBase.CrabData)p_213386_4_).variant;
            this.setVariant(color);
        } else {
            int variant = Math.max(determineVariant(), 2);
            this.setVariant(this.random.nextInt(variant-1)+1);
        }

        float f = (float)(this.random.nextGaussian() * CreaturesConfig.height_standard_deviation.get() + CreaturesConfig.height_base_multiplier.get());
        this.setHeightMultiplier(f);

        return super.finalizeSpawn(p_213386_1_, p_213386_2_, p_213386_3_, p_213386_4_, p_213386_5_);
    }

    public String getSpeciesName() {
        return this.getType().getDescription().getString();
    }

    public ActionResultType mobInteract(PlayerEntity p_230254_1_, Hand p_230254_2_) {
        ItemStack itemstack = p_230254_1_.getItemInHand(p_230254_2_);
        if (itemstack.getItem() == CreaturesItems.FF_GUIDE) {
            if (this.level.isClientSide) {
                Creatures.PROXY.setReferencedMob(this);
                Creatures.PROXY.openCreaturesGUI(itemstack);
                return ActionResultType.sidedSuccess(this.level.isClientSide);
            }
        }
        return super.mobInteract(p_230254_1_, p_230254_2_);
    }

    public String getFoodName() {
        return "";
    }

    public ItemStack getFoodItem() {
        return new ItemStack(Items.DEAD_BUSH, 1);
    }

    public String getGenderString() {
        return "Null";
    }


    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(HEIGHT_MULTIPLIER, 1.0F);
        this.entityData.define(GENDER, 0);

    }

    public float getHeightMultiplier() {
        return this.entityData.get(HEIGHT_MULTIPLIER);
    }

    public void setHeightMultiplier(float p_70606_1_) {
        if (this.getHeightMultiplier() < 0.7F) {
            this.entityData.set(HEIGHT_MULTIPLIER, 1.0F);
        } else {
            this.entityData.set(HEIGHT_MULTIPLIER, MathHelper.clamp(p_70606_1_, 0.7F, 1.5F)); }
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
        p_213281_1_.putFloat("HeightMultiplier", this.getHeightMultiplier());
        p_213281_1_.putFloat("Gender", this.getGender());
        super.addAdditionalSaveData(p_213281_1_);
    }

    public int getGender() {
        return MathHelper.clamp(this.entityData.get(GENDER), 0, 2);
    }

    public void setGender(int p_191997_1_) {
        this.entityData.set(GENDER, p_191997_1_);
    }

    public void readAdditionalSaveData(CompoundNBT p_70037_1_) {
        super.readAdditionalSaveData(p_70037_1_);
        if (!p_70037_1_.contains("HeightMultiplier") || this.getHeightMultiplier() < 0.7F || this.getHeightMultiplier() > 1.5F) {
            this.setHeightMultiplier((float)(this.random.nextGaussian() * CreaturesConfig.height_standard_deviation.get() + CreaturesConfig.height_base_multiplier.get()));
        } else {
            this.setHeightMultiplier(p_70037_1_.getFloat("HeightMultiplier")); }
    }

    public void setVariant(int p_191997_1_) {
        this.entityData.set(DATA_VARIANT_ID, p_191997_1_);
    }

    public int determineVariant() {
        return 1;
    }

    public int getVariant() {
        return 1;
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

    public String getGenderText() {
        if (this.getGender() == 1) {
            ITextComponent i = new TranslationTextComponent("gui.male");
            return i.getString();
        } else {
            ITextComponent i = new TranslationTextComponent("gui.female");
            return i.getString();
        }
    }

    public static class CrabData extends AgeableEntity.AgeableData {
        public final int variant;

        public CrabData(int p_i231557_1_) {
            super(true);
            this.variant = p_i231557_1_;
        }
    }


}
