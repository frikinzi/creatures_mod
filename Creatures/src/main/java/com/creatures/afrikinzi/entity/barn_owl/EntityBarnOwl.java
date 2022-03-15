package com.creatures.afrikinzi.entity.barn_owl;

import com.creatures.afrikinzi.config.CreaturesConfig;
import com.creatures.afrikinzi.entity.ICreaturesEntity;
import com.creatures.afrikinzi.entity.RaptorBase;
import com.creatures.afrikinzi.entity.ai.EntityAIFollowOwnerCreatures;
import com.creatures.afrikinzi.entity.arowana.EntityArowana;
import com.creatures.afrikinzi.entity.chickadee.EntityChickadee;
import com.creatures.afrikinzi.entity.fairy_wren.EntityFairyWren;
import com.creatures.afrikinzi.entity.swallow.EntitySwallow;
import com.creatures.afrikinzi.init.ItemInit;
import com.creatures.afrikinzi.util.handlers.SoundsHandler;
import com.google.common.base.Predicate;
import com.google.common.collect.Sets;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.Set;

public class EntityBarnOwl extends RaptorBase implements IAnimatable, ICreaturesEntity {
    private AnimationFactory factory = new AnimationFactory(this);
    private static final Set<Item> TEMPTATION_ITEMS = Sets.newHashSet(ItemInit.RAW_SMALL_WILD_BIRD_MEAT, Items.CHICKEN, ItemInit.RAW_LARGE_WILD_BIRD_MEAT);

    public EntityBarnOwl(World worldIn) {
        super(worldIn);
        this.setSize(1F, 1F);
        this.moveHelper = new EntityFlyHelper(this);
    }

    @Override
    protected void initEntityAI() {
        this.aiSit = new EntityAISit(this);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(5, new EntityAIAttackMelee(this, 1.4D, true));
        this.tasks.addTask(4, new EntityAILeapAtTarget(this, 0.4F));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, false, new Class[0]));
        this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAIFollowOwnerCreatures(this, 1.0D, 5.0F, 1.0F));
        this.tasks.addTask(7, new EntityAIWanderAvoidWaterFlying(this, 1.0D));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        if (CreaturesConfig.eagleAttacks == true) {
            this.targetTasks.addTask(8, new EntityAITargetNonTamed(this, EntityFairyWren.class, false, (Predicate) null));
            this.targetTasks.addTask(8, new EntityAITargetNonTamed(this, EntityChicken.class, false, (Predicate) null));
            this.targetTasks.addTask(8, new EntityAITargetNonTamed(this, EntityChickadee.class, false, (Predicate) null));
            this.targetTasks.addTask(8, new EntityAITargetNonTamed(this, EntitySwallow.class, false, (Predicate) null));
        }
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving() && this.onGround) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("walk", true));
            return PlayState.CONTINUE;
        }
        if (!this.onGround || this.isFlying()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("fly", true));
            return PlayState.CONTINUE;
        }
        if (this.isSleeping() && !this.isDead) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("sleep", true));
            return PlayState.CONTINUE;
        } if (this.isSitting()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("sit", true));
            return PlayState.CONTINUE;
        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(3.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.40000000298023224D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(40.0D);
    }

    @Override
    public boolean isBreedingItem(ItemStack stack)
    {
        return TEMPTATION_ITEMS.contains(stack.getItem());
    }

    @Override
    public boolean canMateWith(EntityAnimal otherAnimal)
    {
        if (otherAnimal == this)
        {
            return false;
        }
        else if (!this.isTamed())
        {
            return false;
        }
        else if (!(otherAnimal instanceof EntityBarnOwl))
        {
            return false;
        }
        else
        {
            EntityBarnOwl entitybarnowl = (EntityBarnOwl)otherAnimal;
            return this.isInLove() && entitybarnowl.isInLove();
        }


    }

    @Override
    public EntityBarnOwl createChild(EntityAgeable ageable)
    {
        EntityBarnOwl entitybarnowl = new EntityBarnOwl(this.world);
        entitybarnowl.setGender(this.rand.nextInt(2));

        return entitybarnowl;
    }

    public SoundEvent getAmbientSound()
    {
        if (!this.isSleeping()) {

            return SoundsHandler.BARN_OWL_AMBIENT;
        } else {
            return null;
        }
    }

    @Override
    public void getsleep() {
        setSleeping(world.getWorldTime() > 1000 && world.getWorldTime() <= 12000);
    }

    public String getSpeciesName() {
        String s1 = I18n.format("entity.barn_owl.name");
        return s1;
    }

    public String getFoodName() {
        return net.minecraft.util.text.translation.I18n.translateToLocal(Items.CHICKEN.getUnlocalizedName() + ".name").trim();
    }

}
