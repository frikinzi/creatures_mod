package com.frikinzi.creatures.entity.ai;

import com.frikinzi.creatures.entity.base.TameableBirdBase;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.passive.ShoulderRidingEntity;
import net.minecraft.entity.player.ServerPlayerEntity;

public class LandOnOwnersShoulderGoal extends Goal {
    private final TameableBirdBase entity;
    private ServerPlayerEntity owner;
    private boolean isSittingOnShoulder;

    public LandOnOwnersShoulderGoal(TameableBirdBase p_i47415_1_) {
        this.entity = p_i47415_1_;
    }

    public boolean canUse() {
        ServerPlayerEntity serverplayerentity = (ServerPlayerEntity)this.entity.getOwner();
        if(serverplayerentity != null) {
            if (!serverplayerentity.getShoulderEntityLeft().isEmpty()) {
                return false; //can only land on left shoulder
            }
        }

        boolean flag = serverplayerentity != null && !serverplayerentity.isSpectator() && !serverplayerentity.abilities.flying && !serverplayerentity.isInWater();
        return !this.entity.isOrderedToSit() && flag && this.entity.canSitOnShoulder();
    }

    public boolean isInterruptable() {
        return !this.isSittingOnShoulder;
    }

    public void start() {
        this.owner = (ServerPlayerEntity)this.entity.getOwner();
        this.isSittingOnShoulder = false;
    }

    public void tick() {
        if (!this.isSittingOnShoulder && !this.entity.isInSittingPose() && !this.entity.isLeashed()) {
            if (this.entity.getBoundingBox().intersects(this.owner.getBoundingBox())) {
                this.isSittingOnShoulder = this.entity.setEntityOnShoulder(this.owner);
            }

        }
    }
}