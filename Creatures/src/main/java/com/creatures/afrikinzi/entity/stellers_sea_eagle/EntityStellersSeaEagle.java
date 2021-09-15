package com.creatures.afrikinzi.entity.stellers_sea_eagle;

import com.creatures.afrikinzi.entity.RaptorBase;
import com.creatures.afrikinzi.entity.koi.EntityKoi;
import com.creatures.afrikinzi.entity.mandarin_duck.EntityMandarinDuck;
import com.creatures.afrikinzi.entity.raven.EntityRaven;
import com.creatures.afrikinzi.util.handlers.SoundsHandler;
import com.google.common.base.Predicate;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.Set;

public class EntityStellersSeaEagle extends RaptorBase implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);

    public EntityStellersSeaEagle(World worldIn) {
        super(worldIn);
        this.setSize(1.8F, 1.5F);
        this.moveHelper = new EntityFlyHelper(this);
        this.setPathPriority(PathNodeType.WATER, 1.0F);
        Set<Item> TAME_ITEMS = Sets.newHashSet(Items.FISH, Items.COOKED_FISH);
    }

    @Override
    protected void initEntityAI() {
        this.aiSit = new EntityAISit(this);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(7, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(5, new EntityAIAttackMelee(this, 1.2D, true));
        this.tasks.addTask(4, new EntityAILeapAtTarget(this, 0.4F));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, false, new Class[0]));
        this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(2, new EntityAIFollowOwnerFlying(this, 1.0D, 5.0F, 1.0F));
        this.tasks.addTask(2, new EntityAIWanderAvoidWaterFlying(this, 1.0D));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        //this.targetTasks.addTask(6, new EntityStellersSeaEagle.AIFishing(this));
        this.targetTasks.addTask(6, new EntityAITargetNonTamed(this, EntityRabbit.class, false, (Predicate) null));
        //this.targetTasks.addTask(6, new EntityAITargetNonTamed(this, EntityChicken.class, false, (Predicate) null));
        this.targetTasks.addTask(6, new EntityAITargetNonTamed(this, EntityKoi.class, false, (Predicate) null));
        this.targetTasks.addTask(6, new EntityAITargetNonTamed(this, EntitySquid.class, false, (Predicate) null));
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
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(35.0D);
        this.getEntityAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(3.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.40000000298023224D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(40.0D);
    }

    static class AIFishing extends EntityAIMoveToBlock {
        private final EntityStellersSeaEagle eagle;

        public AIFishing(EntityStellersSeaEagle eagleIn) {
            super(eagleIn, 0.699999988079071D, 8);
            this.eagle = eagleIn;
        }

        public boolean shouldExecute() {
            if (!this.eagle.isTamed() && this.eagle.HungerTime <= 0 && !this.eagle.hasPrey()) {
                return super.shouldExecute();
            } else {
                return false;
            }
        }

        public void startExecuting()
        {
            super.startExecuting();
        }

        protected boolean shouldMoveTo(World worldIn, BlockPos pos) {
            pos = pos.up();
            IBlockState iblockstate = worldIn.getBlockState(pos);
            Block block = iblockstate.getBlock();

            if (iblockstate.getMaterial() == Material.WATER) {
                return true;
            }
            else {
                if (block == Blocks.FLOWING_WATER) {
                    System.out.println("moving to test chest");
                    return true;
                    }
                return false;
                }
        }

        public void updateTask() {
            super.updateTask();
            if (this.getIsAboveDestination()) {
                System.out.println("eagle is fishing");

                this.eagle.motionY *= 1.2D;
                this.eagle.motionY = -1.2F;

                this.eagle.setPrey(true);
            }
        }
    }

    public SoundEvent getAmbientSound()
    {
        if (!this.isSleeping()) {

            return SoundsHandler.STELLERS_SEA_EAGLE_AMBIENT;
        } else {
            return null;
        }
    }

    @Override
    public boolean isBreedingItem(ItemStack stack)
    {
        return stack.getItem() == Items.FISH;
    }

    @Override
    public boolean canMateWith(EntityAnimal otherAnimal)
    {
        if (otherAnimal == this)
        {
            return false;
        }
        else if (!(otherAnimal instanceof EntityStellersSeaEagle))
        {
            return false;
        }
        else
        {
            EntityStellersSeaEagle entitystellersseaeagle = (EntityStellersSeaEagle)otherAnimal;
            return this.isInLove() && entitystellersseaeagle.isInLove();
        }


    }

    @Override
    public EntityStellersSeaEagle createChild(EntityAgeable ageable)
    {
        EntityStellersSeaEagle entitystellersseaeagle = new EntityStellersSeaEagle(this.world);

        return entitystellersseaeagle;
    }

    @Override
    public Set<Item> getTameItems() {
        TAME_ITEMS = Sets.newHashSet(Items.FISH);
        return TAME_ITEMS;
    }



}